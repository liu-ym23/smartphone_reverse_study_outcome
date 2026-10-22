package io.reactivex.internal.observers;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
    private static final long serialVersionUID = -7012088219455310787L;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onSuccess;

    public boolean hasCustomOnError() {
        if (this.onError == Functions.ON_ERROR_MISSING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != DisposableHelper.DISPOSED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable r100) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this, r100);
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T r100) {
        lazySet(DisposableHelper.DISPOSED);
        this.onSuccess.accept(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    public ConsumerSingleObserver(Consumer<? super T> r100, Consumer<? super Throwable> r101) {
        this.onSuccess = r100;
        this.onError = r101;
    }
}
