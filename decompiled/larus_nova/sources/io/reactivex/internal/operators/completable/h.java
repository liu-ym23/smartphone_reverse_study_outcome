package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class h extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends Throwable> f492971a;

    public h(Callable<? extends Throwable> r100) {
        this.f492971a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        th = (Throwable) ObjectHelper.requireNonNull(this.f492971a.call(), "The error returned is null");     // Catch: Throwable -> L4
    L6:
        EmptyDisposable.error(th, r100);
        return;
    L4:
        th = th;
        Exceptions.throwIfFatal(th);
        goto L6
    }
}
