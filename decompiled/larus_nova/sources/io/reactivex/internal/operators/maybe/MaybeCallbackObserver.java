package io.reactivex.internal.operators.maybe;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
    private static final long serialVersionUID = -6076952298809384986L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onSuccess;

    public boolean hasCustomOnError() {
        if (this.onError == Functions.ON_ERROR_MISSING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.k
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.k
    public void onError(Throwable r100) {
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
    }

    @Override // io.reactivex.k
    public void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this, r100);
    }

    @Override // io.reactivex.k
    public void onSuccess(T r100) {
        lazySet(DisposableHelper.DISPOSED);
        this.onSuccess.accept(r100);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    public MaybeCallbackObserver(Consumer<? super T> r100, Consumer<? super Throwable> r101, Action r102) {
        this.onSuccess = r100;
        this.onError = r101;
        this.onComplete = r102;
    }
}
