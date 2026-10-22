package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public class StrictSubscriber<T> extends AtomicInteger implements io.reactivex.g<T>, wwc.c {
    private static final long serialVersionUID = -4945028590049415624L;
    volatile boolean done;
    final wwc.b<? super T> downstream;
    final AtomicThrowable error;
    final AtomicBoolean once;
    final AtomicLong requested;
    final AtomicReference<wwc.c> upstream;

    @Override // wwc.b
    public void onComplete() {
        this.done = true;
        io.reactivex.internal.util.g.b(this.downstream, this, this.error);
    }

    @Override // wwc.c
    public void cancel() {
        if (this.done == true) goto L6;
        SubscriptionHelper.cancel(this.upstream);
        return;
    }

    public StrictSubscriber(wwc.b<? super T> r100) {
        this.downstream = r100;
        this.error = new AtomicThrowable();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference();
        this.once = new AtomicBoolean();
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        this.done = true;
        io.reactivex.internal.util.g.d(this.downstream, r100, this, this.error);
    }

    @Override // wwc.b
    public void onNext(T r100) {
        io.reactivex.internal.util.g.f(this.downstream, r100, this, this.error);
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(wwc.c r100) {
        if (this.once.compareAndSet(false, true) == false) goto L5;
        this.downstream.onSubscribe(this);
        SubscriptionHelper.deferredSetOnce(this.upstream, this.requested, r100);
        return;
    L5:
        r100.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    @Override // wwc.c
    public void request(long r100) {
        if (r100 > 0) goto L5;
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + r100));
        return;
    L5:
        SubscriptionHelper.deferredRequest(this.upstream, this.requested, r100);
    }
}
