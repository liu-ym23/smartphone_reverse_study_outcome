package io.reactivex.subscribers;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.g;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.observers.BaseTestConsumer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class TestSubscriber<T> extends BaseTestConsumer<T, TestSubscriber<T>> implements g<T>, wwc.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wwc.b<? super T> f495144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f495145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicReference<wwc.c> f495146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f495147h;

    public static final enum EmptySubscriber extends Enum<EmptySubscriber> implements g<Object> {
        public static final EmptySubscriber INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EmptySubscriber[] f495148a = null;

        @Override // wwc.b
        public void onComplete() {
        }

        @Override // wwc.b
        public void onError(Throwable r100) {
        }

        @Override // wwc.b
        public void onNext(Object r100) {
        }

        @Override // io.reactivex.g, wwc.b
        public void onSubscribe(wwc.c r100) {
        }

        static {
            EmptySubscriber r100 = new EmptySubscriber();
            INSTANCE = r100;
            f495148a = new EmptySubscriber[]{r100};
        }

        public EmptySubscriber() {
            super("INSTANCE", 0);
        }

        public static EmptySubscriber[] values() {
            return (EmptySubscriber[]) f495148a.clone();
        }

        public static EmptySubscriber valueOf(String r100) {
            return (EmptySubscriber) r27.a.a(EmptySubscriber.class, r100);
        }
    }

    public TestSubscriber() {
        this(EmptySubscriber.INSTANCE, Long.MAX_VALUE);
    }

    @Override // wwc.c
    public final void cancel() {
        if (this.f495145f == true) goto L6;
        this.f495145f = true;
        SubscriptionHelper.cancel(this.f495146g);
        return;
    }

    @Override // wwc.b
    public final void onComplete() {
        if (this.f495056d == true) goto L13;
        this.f495056d = true;
        if (this.f495146g.get() != null) goto L13;
        this.f495055c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L13:
        ThreadMethodProxy.currentThread();     // Catch: Throwable -> L10
        this.f495144e.onComplete();     // Catch: Throwable -> L10
        this.f495053a.countDown();
        return;
    L10:
        th = move-exception;
        this.f495053a.countDown();
        throw th;
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        cancel();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f495145f;
    }

    public TestSubscriber(long r100) {
        this(EmptySubscriber.INSTANCE, r100);
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        if (this.f495056d == true) goto L16;
        this.f495056d = true;
        if (this.f495146g.get() != null) goto L16;
        this.f495055c.add(new NullPointerException("onSubscribe not called in proper order"));
    L16:
        ThreadMethodProxy.currentThread();     // Catch: Throwable -> L13
        this.f495055c.add(r100);     // Catch: Throwable -> L13
        if (r100 != null) goto L10;
        this.f495055c.add(new IllegalStateException("onError received a null Throwable"));     // Catch: Throwable -> L13
    L10:
        this.f495144e.onError(r100);     // Catch: Throwable -> L13
        this.f495053a.countDown();
        return;
    L13:
        th = move-exception;
        this.f495053a.countDown();
        throw th;
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        if (this.f495056d == true) goto L7;
        this.f495056d = true;
        if (this.f495146g.get() != null) goto L7;
        this.f495055c.add(new IllegalStateException("onSubscribe not called in proper order"));
    L7:
        ThreadMethodProxy.currentThread();
        this.f495054b.add(r100);
        if (r100 != null) goto L10;
        this.f495055c.add(new NullPointerException("onNext received a null value"));
    L10:
        this.f495144e.onNext(r100);
    }

    @Override // io.reactivex.g, wwc.b
    public final void onSubscribe(wwc.c r100) {
        ThreadMethodProxy.currentThread();
        if (r100 != null) goto L6;
        this.f495055c.add(new NullPointerException("onSubscribe received a null Subscription"));
        return;
    L6:
        AtomicReference<wwc.c> r101 = this.f495146g;
    L8:
        if (r101.compareAndSet(null, r100) == true) goto L9;
        if (r101.get() == null) goto L8;
        boolean r102 = false;
    L13:
        if (r102 == true) goto L18;
        r100.cancel();
        if (this.f495146g.get() == SubscriptionHelper.CANCELLED) goto L25;
        this.f495055c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + r100));
        return;
    L25:
        return;
    L18:
        this.f495144e.onSubscribe(r100);
        long r103 = this.f495147h.getAndSet(0);
        if (r103 == 0) goto L26;
        r100.request(r103);
        return;
    L26:
        return;
    L9:
        r102 = true;
        goto L13
    }

    @Override // wwc.c
    public final void request(long r100) {
        SubscriptionHelper.deferredRequest(this.f495146g, this.f495147h, r100);
    }

    public TestSubscriber(wwc.b<? super T> r100, long r101) {
        if (r101 < 0) goto L7;
        this.f495144e = r100;
        this.f495146g = new AtomicReference();
        this.f495147h = new AtomicLong(r101);
        return;
    L7:
        throw new IllegalArgumentException("Negative initial request not allowed");
    }
}
