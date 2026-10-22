package com.jakewharton.rxrelay2;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes23.dex */
public abstract class b<T> extends Observable<T> implements Consumer<T> {
    public abstract void accept(T r100);

    public b() {
    }
}
