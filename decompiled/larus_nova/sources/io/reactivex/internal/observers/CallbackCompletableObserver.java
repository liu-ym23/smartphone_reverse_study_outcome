package io.reactivex.internal.observers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class CallbackCompletableObserver extends AtomicReference<Disposable> implements io.reactivex.b, Disposable, Consumer<Throwable> {
    private static final long serialVersionUID = -4361286194466301354L;
    final Action onComplete;
    final Consumer<? super Throwable> onError;

    public boolean hasCustomOnError() {
        if (this.onError == this) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.b
    public void onComplete() {
        this.onComplete.run();     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        goto L6
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

    public CallbackCompletableObserver(Action r100) {
        this.onError = this;
        this.onComplete = r100;
    }

    /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
    public void accept2(Throwable r100) {
        RxJavaPlugins.onError(new OnErrorNotImplementedException(r100));
    }

    @Override // io.reactivex.b
    public void onError(Throwable r100) {
        this.onError.accept(r100);     // Catch: Throwable -> L4
    L6:
        lazySet(DisposableHelper.DISPOSED);
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        goto L6
    }

    @Override // io.reactivex.b
    public void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this, r100);
    }

    @Override // io.reactivex.functions.Consumer
    public /* bridge */ /* synthetic */ void accept(Throwable r100) throws Exception {
        accept2(r100);
    }

    public CallbackCompletableObserver(Consumer<? super Throwable> r100, Action r101) {
        this.onError = r100;
        this.onComplete = r101;
    }
}
