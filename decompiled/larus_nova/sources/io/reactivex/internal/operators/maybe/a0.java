package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;

/* JADX INFO: loaded from: classes41.dex */
public final class a0<T, R> extends a<T, R> {
    public a0(MaybeSource r100) {
        super(r100);
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super R> r100) {
        throw null;     // Catch: Throwable -> L4
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
    }
}
