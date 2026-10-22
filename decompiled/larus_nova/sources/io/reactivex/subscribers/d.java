package io.reactivex.subscribers;

import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class d<T> implements g<T>, wwc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wwc.b<? super T> f495153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public wwc.c f495154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.reactivex.internal.util.a<Object> f495156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f495157e;

    public final void a() {
    L2:
        monitor-enter(this);
        io.reactivex.internal.util.a<Object> r100 = this.f495156d;     // Catch: Throwable -> L13
        if (r100 == null) goto L5;
        this.f495156d = null;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r100.a(this.f495153a) == false) goto L2;
        return;
    L5:
        this.f495155c = false;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // wwc.c
    public final void cancel() {
        this.f495154b.cancel();
    }

    @Override // wwc.b
    public final void onComplete() {
        if (this.f495157e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.f495157e == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.f495155c == false) goto L18;
        io.reactivex.internal.util.a<Object> r100 = this.f495156d;     // Catch: Throwable -> L22
        if (r100 != null) goto L15;
        r100 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L22
        this.f495156d = r100;     // Catch: Throwable -> L22
    L15:
        r100.b(NotificationLite.complete());     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.f495157e = true;     // Catch: Throwable -> L22
        this.f495155c = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.f495153a.onComplete();
    }

    public d(wwc.b<? super T> r100) {
        this.f495153a = r100;
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        if (this.f495157e == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        monitor-enter(this);
        boolean r101 = true;
        if (this.f495157e == false) goto L11;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L18
        if (r101 == false) goto L25;
        RxJavaPlugins.onError(r100);
        return;
    L25:
        this.f495153a.onError(r100);
        return;
    L11:
        if (this.f495155c == false) goto L20;
        this.f495157e = true;     // Catch: Throwable -> L18
        io.reactivex.internal.util.a<Object> r102 = this.f495156d;     // Catch: Throwable -> L18
        if (r102 != null) goto L15;
        r102 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L18
        this.f495156d = r102;     // Catch: Throwable -> L18
    L15:
        Object r103 = NotificationLite.error(r100);     // Catch: Throwable -> L18
        r102.f495046a[0] = r103;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L20:
        this.f495157e = true;     // Catch: Throwable -> L18
        this.f495155c = true;     // Catch: Throwable -> L18
        r101 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        if (this.f495157e == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        this.f495154b.cancel();
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L8:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L10:
        if (this.f495157e == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L14:
        if (this.f495155c == false) goto L21;
        io.reactivex.internal.util.a<Object> r101 = this.f495156d;     // Catch: Throwable -> L25
        if (r101 != null) goto L18;
        r101 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L25
        this.f495156d = r101;     // Catch: Throwable -> L25
    L18:
        r101.b(NotificationLite.next(r100));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L21:
        this.f495155c = true;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        this.f495153a.onNext(r100);
        a();
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.validate(this.f495154b, r100) == false) goto L6;
        this.f495154b = r100;
        this.f495153a.onSubscribe(this);
        return;
    }

    @Override // wwc.c
    public final void request(long r100) {
        this.f495154b.request(r100);
    }
}
