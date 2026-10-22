package io.reactivex.observables;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes41.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    public K getKey() {
        return this.key;
    }

    public GroupedObservable(K r100) {
        this.key = r100;
    }
}
