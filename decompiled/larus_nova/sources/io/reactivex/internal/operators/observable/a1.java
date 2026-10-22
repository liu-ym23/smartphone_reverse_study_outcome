package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class a1<T> implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<T> f494257a;

    public a1(Observer<T> r100) {
        this.f494257a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        Observer<T> r101 = this.f494257a;
        r101.onError(r100);
    }
}
