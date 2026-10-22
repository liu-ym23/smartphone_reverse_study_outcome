package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class b1<T> implements Consumer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<T> f494268a;

    public b1(Observer<T> r100) {
        this.f494268a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) throws Exception {
        this.f494268a.onNext(r100);
    }
}
