package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ForEachWhileObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    private static final long serialVersionUID = -4403180040475402120L;
    boolean done;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Predicate<? super T> onNext;

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        this.onComplete.run();     // Catch: Throwable -> L8
        return;
    L8:
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

    @Override // io.reactivex.Observer
    public void onError(Throwable r100) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.done = true;
        this.onError.accept(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
    }

    @Override // io.reactivex.Observer
    public void onNext(T r100) {
        if (this.done == false) goto L12;
        return;
    L12:
        if (this.onNext.test(r100) == true) goto L14;
        dispose();
        onComplete();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        dispose();
        onError(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r100) {
        DisposableHelper.setOnce(this, r100);
    }

    public ForEachWhileObserver(Predicate<? super T> r100, Consumer<? super Throwable> r101, Action r102) {
        this.onNext = r100;
        this.onError = r101;
        this.onComplete = r102;
    }
}
