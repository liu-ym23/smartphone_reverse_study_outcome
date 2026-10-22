package io.reactivex.internal.subscribers;

import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class BoundedSubscriber<T> extends AtomicReference<wwc.c> implements io.reactivex.g<T>, wwc.c, Disposable {
    private static final long serialVersionUID = -7251123623727029452L;
    final int bufferSize;
    int consumed;
    final int limit;
    final Action onComplete;
    final Consumer<? super Throwable> onError;
    final Consumer<? super T> onNext;
    final Consumer<? super wwc.c> onSubscribe;

    public boolean hasCustomOnError() {
        if (this.onError == Functions.ON_ERROR_MISSING) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // wwc.b
    public void onComplete() {
        wwc.c r100 = get();
        SubscriptionHelper r101 = SubscriptionHelper.CANCELLED;
        if (r100 == r101) goto L12;
        lazySet(r101);
        this.onComplete.run();     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
        return;
    }

    @Override // wwc.c
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        cancel();
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        wwc.c r101 = get();
        SubscriptionHelper r102 = SubscriptionHelper.CANCELLED;
        if (r101 == r102) goto L9;
        lazySet(r102);
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

    @Override // wwc.b
    public void onNext(T r100) {
        if (isDisposed() == true) goto L16;
        this.onNext.accept(r100);     // Catch: Throwable -> L9
        int r101 = this.consumed + 1;     // Catch: Throwable -> L9
        if (r101 != this.limit) goto L7;
        this.consumed = 0;     // Catch: Throwable -> L9
        get().request(this.limit);     // Catch: Throwable -> L9
    L12:
        return;
    L7:
        this.consumed = r101;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        get().cancel();
        onError(th);
        return;
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.setOnce(this, r100) == false) goto L11;
        this.onSubscribe.accept(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        r100.cancel();
        onError(th);
        return;
    }

    @Override // wwc.c
    public void request(long r100) {
        get().request(r100);
    }

    public BoundedSubscriber(Consumer<? super T> r100, Consumer<? super Throwable> r101, Action r102, Consumer<? super wwc.c> r103, int r104) {
        this.onNext = r100;
        this.onError = r101;
        this.onComplete = r102;
        this.onSubscribe = r103;
        this.bufferSize = r104;
        this.limit = r104 - (r104 >> 2);
    }
}
