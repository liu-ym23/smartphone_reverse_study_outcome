package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.exceptions.Exceptions;

/* JADX INFO: loaded from: classes41.dex */
public final class m extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f492979a;

    public m(Runnable r100) {
        this.f492979a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        Disposable r101 = Disposables.empty();
        r100.onSubscribe(r101);
        this.f492979a.run();     // Catch: Throwable -> L8
        if (r101.isDisposed() == true) goto L15;
        r100.onComplete();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        if (r101.isDisposed() == true) goto L16;
        r100.onError(th);
        return;
    }
}
