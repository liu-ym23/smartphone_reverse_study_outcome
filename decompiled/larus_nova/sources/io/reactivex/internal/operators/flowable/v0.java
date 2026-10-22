package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class v0<T> implements Consumer<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwc.b<T> f493624a;

    public v0(wwc.b<T> r100) {
        this.f493624a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Throwable r100) throws Exception {
        wwc.b<T> r101 = this.f493624a;
        r101.onError(r100);
    }
}
