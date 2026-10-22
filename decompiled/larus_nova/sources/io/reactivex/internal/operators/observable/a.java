package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/* JADX INFO: loaded from: classes41.dex */
public abstract class a<T, U> extends Observable<U> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSource<T> f494245a;

    public a(ObservableSource<T> r100) {
        this.f494245a = r100;
    }
}
