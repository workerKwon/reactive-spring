package com.spring.reactive.observer.impl;

import com.spring.reactive.observer.Observer;
import com.spring.reactive.observer.Subject;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConcreteSubject implements Subject<String> {

    private final Set<Observer<String>> observers = new CopyOnWriteArraySet<>();

    @Override
    public void registerObserver(Observer<String> observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        observers.forEach(observer -> observer.observe(event));
    }
}