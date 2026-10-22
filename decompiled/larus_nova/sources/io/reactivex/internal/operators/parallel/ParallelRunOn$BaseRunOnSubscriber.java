package io.reactivex.internal.operators.parallel;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.b;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements g<T>, c, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    volatile boolean cancelled;
    int consumed;
    volatile boolean done;
    Throwable error;
    final int limit;
    final int prefetch;
    final SpscArrayQueue<T> queue;
    final AtomicLong requested;
    c upstream;
    final Scheduler.Worker worker;

    @Override // io.reactivex.g, wwc.b
    public abstract /* synthetic */ void onSubscribe(c r100);

    @Override // wwc.c
    public final void cancel() {
        if (this.cancelled == true) goto L8;
        this.cancelled = true;
        this.upstream.cancel();
        this.worker.dispose();
        if (getAndIncrement() != 0) goto L9;
        this.queue.clear();
        return;
    L9:
        return;
    }

    @Override // wwc.b
    public final void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        this.done = true;
        schedule();
    }

    public final void schedule() {
        if (getAndIncrement() != 0) goto L6;
        this.worker.schedule(this);
        return;
    }

    @Override // wwc.b
    public final void onError(Throwable r100) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r100);
        return;
    L6:
        this.error = r100;
        this.done = true;
        schedule();
    }

    @Override // wwc.b
    public final void onNext(T r100) {
        if (this.done == false) goto L6;
        return;
    L6:
        if (this.queue.offer(r100) == true) goto L9;
        this.upstream.cancel();
        onError(new MissingBackpressureException("Queue is full?!"));
        return;
    L9:
        schedule();
    }

    @Override // wwc.c
    public final void request(long r100) {
        if (SubscriptionHelper.validate(r100) == false) goto L6;
        b.a(this.requested, r100);
        schedule();
        return;
    }

    public ParallelRunOn$BaseRunOnSubscriber(int r100, SpscArrayQueue<T> r101, Scheduler.Worker r102) {
        this.requested = new AtomicLong();
        this.prefetch = r100;
        this.queue = r101;
        this.limit = r100 - (r100 >> 2);
        this.worker = r102;
    }
}
