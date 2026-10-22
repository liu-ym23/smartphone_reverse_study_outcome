package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;

/* JADX INFO: loaded from: classes41.dex */
public final class i0<T> extends a<T, T> {
    public i0(MaybeSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(r100);
    }
}
