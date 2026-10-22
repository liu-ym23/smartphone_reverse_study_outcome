package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class w0<T> implements Consumer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwc.b<T> f493638a;

    public w0(wwc.b<T> r100) {
        this.f493638a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) throws Exception {
        this.f493638a.onNext(r100);
    }
}
