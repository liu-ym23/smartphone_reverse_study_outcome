package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class f<T> implements Observer<T>, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Observer<? super T> f495068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f495069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f495070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public io.reactivex.internal.util.a<Object> f495071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f495072e;

    public final void b() {
    L2:
        monitor-enter(this);
        io.reactivex.internal.util.a<Object> r100 = this.f495071d;     // Catch: Throwable -> L25
        boolean r101 = false;
        if (r100 == null) goto L5;
        this.f495071d = null;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        Observer<? super T> r102 = this.f495068a;
        Object[] r103 = r100.f495046a;
    L11:
        if (r103 == null) goto L23;
        int r104 = 0;
    L14:
        if (r104 >= 4) goto L22;
        Object[] r105 = r103[r104];
        if (r105 == null) goto L22;
        if (NotificationLite.acceptFull(r105, r102) == true) goto L20;
        r104 = r104 + 1;
        goto L14
    L20:
        r101 = true;
    L22:
        r103 = r103[4];
    L23:
        if (r101 == false) goto L2;
        return;
    L5:
        this.f495070c = false;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        this.f495069b.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f495069b.isDisposed();
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        if (this.f495072e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.f495072e == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.f495070c == false) goto L18;
        io.reactivex.internal.util.a<Object> r100 = this.f495071d;     // Catch: Throwable -> L22
        if (r100 != null) goto L15;
        r100 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L22
        this.f495071d = r100;     // Catch: Throwable -> L22
    L15:
        r100.b(NotificationLite.complete());     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.f495072e = true;     // Catch: Throwable -> L22
        this.f495070c = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.f495068a.onComplete();
    }

    public f(Observer<? super T> r100) {
        this.f495068a = r100;
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable r100) {
        if (this.f495072e == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        monitor-enter(this);
        boolean r101 = true;
        if (this.f495072e == false) goto L11;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L18
        if (r101 == false) goto L25;
        RxJavaPlugins.onError(r100);
        return;
    L25:
        this.f495068a.onError(r100);
        return;
    L11:
        if (this.f495070c == false) goto L20;
        this.f495072e = true;     // Catch: Throwable -> L18
        io.reactivex.internal.util.a<Object> r102 = this.f495071d;     // Catch: Throwable -> L18
        if (r102 != null) goto L15;
        r102 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L18
        this.f495071d = r102;     // Catch: Throwable -> L18
    L15:
        Object r103 = NotificationLite.error(r100);     // Catch: Throwable -> L18
        r102.f495046a[0] = r103;     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L20:
        this.f495072e = true;     // Catch: Throwable -> L18
        this.f495070c = true;     // Catch: Throwable -> L18
        r101 = false;
    L18:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r100) {
        if (this.f495072e == false) goto L5;
        return;
    L5:
        if (r100 != null) goto L8;
        this.f495069b.dispose();
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L8:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L10:
        if (this.f495072e == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L14:
        if (this.f495070c == false) goto L21;
        io.reactivex.internal.util.a<Object> r101 = this.f495071d;     // Catch: Throwable -> L25
        if (r101 != null) goto L18;
        r101 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L25
        this.f495071d = r101;     // Catch: Throwable -> L25
    L18:
        r101.b(NotificationLite.next(r100));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L21:
        this.f495070c = true;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        this.f495068a.onNext(r100);
        b();
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable r100) {
        if (DisposableHelper.validate(this.f495069b, r100) == false) goto L6;
        this.f495069b = r100;
        this.f495068a.onSubscribe(this);
        return;
    }
}
