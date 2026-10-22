package io.reactivex.internal.subscribers;

import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class InnerQueuedSubscriber<T> extends AtomicReference<wwc.c> implements io.reactivex.g<T>, wwc.c {
    private static final long serialVersionUID = 22876611072430776L;
    volatile boolean done;
    int fusionMode;
    final int limit;
    final g<T> parent;
    final int prefetch;
    long produced;
    volatile vtc.j<T> queue;

    public void setDone() {
        this.done = true;
    }

    @Override // wwc.b
    public void onComplete() {
        this.parent.innerComplete(this);
    }

    public void requestOne() {
        if (this.fusionMode == 1) goto L9;
        long r100 = this.produced + 1;
        if (r100 != this.limit) goto L7;
        this.produced = 0;
        get().request(r100);
        return;
    L7:
        this.produced = r100;
        return;
    }

    @Override // wwc.c
    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDone() {
        return this.done;
    }

    public vtc.j<T> queue() {
        return this.queue;
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        this.parent.innerError(this, r100);
    }

    @Override // wwc.b
    public void onNext(T r100) {
        if (this.fusionMode != 0) goto L5;
        this.parent.innerNext(this, r100);
        return;
    L5:
        this.parent.drain();
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.setOnce(this, r100) == true) goto L5;
        return;
    L5:
        if ((r100 instanceof vtc.g) == false) goto L14;
        vtc.g r101 = (vtc.g) r100;
        int r102 = r101.requestFusion(3);
        if (r102 != 1) goto L11;
        this.fusionMode = r102;
        this.queue = r101;
        this.done = true;
        this.parent.innerComplete(this);
        return;
    L11:
        if (r102 != 2) goto L14;
        this.fusionMode = r102;
        this.queue = r101;
        io.reactivex.internal.util.j.e(r100, this.prefetch);
        return;
    L14:
        int r103 = this.prefetch;
        if (r103 >= 0) goto L17;
        vtc.j<T> r104 = new io.reactivex.internal.queue.a(-r103);
    L18:
        this.queue = r104;
        io.reactivex.internal.util.j.e(r100, this.prefetch);
        return;
    L17:
        r104 = new SpscArrayQueue(r103);
        goto L18
    }

    @Override // wwc.c
    public void request(long r100) {
        if (this.fusionMode == 1) goto L9;
        long r101 = this.produced + r100;
        if (r101 < this.limit) goto L7;
        this.produced = 0;
        get().request(r101);
        return;
    L7:
        this.produced = r101;
        return;
    }

    public InnerQueuedSubscriber(g<T> r100, int r101) {
        this.parent = r100;
        this.prefetch = r101;
        this.limit = r101 - (r101 >> 2);
    }
}
