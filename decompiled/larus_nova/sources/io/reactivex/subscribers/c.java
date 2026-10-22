package io.reactivex.subscribers;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class c<T> implements g<T>, wwc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwc.b<? super T> f495150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wwc.c f495151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495152c;

    @Override // wwc.c
    public final void cancel() {
        this.f495151b.cancel();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    @Override // wwc.b
    public final void onComplete() {
        if (this.f495152c == false) goto L5;
        return;
    L5:
        this.f495152c = true;
        if (this.f495151b != null) goto L25;
        NullPointerException r100 = new NullPointerException("Subscription not set!");
        this.f495150a.onSubscribe(EmptySubscription.INSTANCE);     // Catch: Throwable -> L13
        this.f495150a.onError(r100);     // Catch: Throwable -> L11
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
        this.f495150a.onComplete();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(th);
    }

    public c(wwc.b<? super T> r100) {
        this.f495150a = r100;
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        if (this.f495152c == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.f495152c = true;
        if (this.f495151b != null) goto L18;
        NullPointerException r101 = new NullPointerException("Subscription not set!");
        this.f495150a.onSubscribe(EmptySubscription.INSTANCE);     // Catch: Throwable -> L15
        this.f495150a.onError(new CompositeException(new Throwable[]{r100, r101}));     // Catch: Throwable -> L12
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
        this.f495150a.onError(r100);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{r100, th}));
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        if (this.f495152c == false) goto L6;
        return;
    L6:
        if (this.f495151b != null) goto L16;
        this.f495152c = true;
        NullPointerException r101 = new NullPointerException("Subscription not set!");
        this.f495150a.onSubscribe(EmptySubscription.INSTANCE);     // Catch: Throwable -> L13
        this.f495150a.onError(r101);     // Catch: Throwable -> L11
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
        this.f495151b.cancel();     // Catch: Throwable -> L21
        onError(r102);
        return;
    L21:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{r102, th}));
        return;
    L38:
        this.f495150a.onNext(r100);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.f495151b.cancel();     // Catch: Throwable -> L31
        onError(th);
        return;
    L31:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        onError(new CompositeException(new Throwable[]{th, th}));
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.validate(this.f495151b, r100) == false) goto L18;
        this.f495151b = r100;
        this.f495150a.onSubscribe(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.f495152c = true;
        r100.cancel();     // Catch: Throwable -> L11
        RxJavaPlugins.onError(th);
        return;
    L11:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th}));
        return;
    }

    @Override // wwc.c
    public final void request(long r100) {
        this.f495151b.request(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        this.f495151b.cancel();     // Catch: Throwable -> L9
        RxJavaPlugins.onError(th);
        return;
    L9:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        RxJavaPlugins.onError(new CompositeException(new Throwable[]{th, th}));
    }
}
