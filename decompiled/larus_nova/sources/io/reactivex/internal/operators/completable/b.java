package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class b extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable<? extends CompletableSource> f492955a;

    public b(Callable<? extends CompletableSource> r100) {
        this.f492955a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        ((CompletableSource) ObjectHelper.requireNonNull(this.f492955a.call(), "The completableSupplier returned a null CompletableSource")).subscribe(r100);
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
    }
}
