package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes41.dex */
public abstract class c<T> extends CountDownLatch implements io.reactivex.g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f495023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Throwable f495024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wwc.c f495025c;

    public c() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) goto L18;
    L12:
        Throwable r100 = this.f495024b;
        if (r100 != null) goto L17;
        return this.f495023a;
    L17:
        throw ExceptionHelper.d(r100);
    L18:
        io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L6
        await();     // Catch: InterruptedException -> L6
    L6:
        e = move-exception;
        wwc.c r101 = this.f495025c;
        this.f495025c = SubscriptionHelper.CANCELLED;
        if (r101 == null) goto L11;
        r101.cancel();
    L11:
        throw ExceptionHelper.d(e);
    }

    @Override // wwc.b
    public final void onComplete() {
        countDown();
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.validate(this.f495025c, r100) == false) goto L6;
        this.f495025c = r100;
        r100.request(Long.MAX_VALUE);
        return;
    }
}
