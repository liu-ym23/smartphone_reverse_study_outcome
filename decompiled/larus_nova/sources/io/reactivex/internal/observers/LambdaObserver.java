package io.reactivex.internal.observers;

import io.reactivex.Observer;
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
public final class LambdaObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -7251123623727029452L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super Disposable> onSubscribe;

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

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (isDisposed() == true) goto L12;
        lazySet(DisposableHelper.DISPOSED);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        if (isDisposed() == true) goto L9;
        lazySet(DisposableHelper.DISPOSED);
        this.onError.accept(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
        return;
    L9:
        RxJavaPlugins.onError(r100);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        if (isDisposed() == true) goto L11;
        this.onNext.accept(r100);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        get().dispose();
        onError(th);
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        if (DisposableHelper.setOnce(this, r100) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r100.dispose();
        onError(th);
        return;
    }

    public LambdaObserver(Consumer<? super T> r100, Consumer<? super Throwable> r101, Action r102, Consumer<? super Disposable> r103) {
        this.onNext = r100;
        this.onError = r101;
        this.onComplete = r102;
        this.onSubscribe = r103;
    }
}
