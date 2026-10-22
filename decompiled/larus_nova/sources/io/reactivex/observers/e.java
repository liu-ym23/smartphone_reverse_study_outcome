package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class e<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<? super T> f495065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f495066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495067c;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f495066b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f495066b.isDisposed();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.f495067c == false) goto L5;
        return;
    L5:
        this.f495067c = true;
        if (this.f495066b != null) goto L25;
        NullPointerException r100 = new NullPointerException("Subscription not set!");
        this.f495065a.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L13
        this.f495065a.onError(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
        return;
    L13:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
        return;
    L25:
        this.f495065a.onComplete();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    public e(Observer<? super T> r100) {
        this.f495065a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        if (this.f495067c == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.f495067c = true;
        if (this.f495066b != null) goto L18;
        NullPointerException r101 = new NullPointerException("Subscription not set!");
        this.f495065a.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L15
        this.f495065a.onError(new CompositeException(new Throwable[]{r100, r101}));     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, r101, th}));
        return;
    L15:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, r101, th}));
        return;
    L18:
        if (r100 != null) goto L29;
        r100 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
    L29:
        this.f495065a.onError(r100);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        if (this.f495067c == false) goto L6;
        return;
    L6:
        if (this.f495066b != null) goto L16;
        this.f495067c = true;
        NullPointerException r101 = new NullPointerException("Subscription not set!");
        this.f495065a.onSubscribe(EmptyDisposable.INSTANCE);     // Catch: Throwable -> L13
        this.f495065a.onError(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r101, th}));
        return;
    L13:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r101, th}));
        return;
    L16:
        if (r100 != null) goto L38;
        NullPointerException r102 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f495066b.dispose();     // Catch: Throwable -> L21
        onError(r102);
        return;
    L21:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{r102, th}));
        return;
    L38:
        this.f495065a.onNext(r100);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.f495066b.dispose();     // Catch: Throwable -> L31
        onError(th);
        return;
    L31:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{th, th}));
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        if (DisposableHelper.validate(this.f495066b, r100) == false) goto L18;
        this.f495066b = r100;
        this.f495065a.onSubscribe(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.f495067c = true;
        r100.dispose();     // Catch: Throwable -> L11
        RxJavaPlugins.onError(th);
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th}));
        return;
    }
}
