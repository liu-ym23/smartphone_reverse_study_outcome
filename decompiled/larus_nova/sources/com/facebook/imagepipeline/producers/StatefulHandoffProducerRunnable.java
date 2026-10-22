package com.facebook.imagepipeline.producers;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes23.dex */
public abstract class StatefulHandoffProducerRunnable<T> extends StatefulProducerRunnable<T> {
    private long enqueueTime;
    private long pendingTime;

    public void dequeue() {
        if (this.enqueueTime <= 0) goto L6;
        this.pendingTime = SystemClock.elapsedRealtime() - this.enqueueTime;
        return;
    }

    public long getPendingTime() {
        long r100 = this.pendingTime;
        if (r100 <= 0) goto L5;
        return r100;
    L5:
        return 0;
    }

    public void enqueue() {
        this.enqueueTime = SystemClock.elapsedRealtime();
    }

    public StatefulHandoffProducerRunnable(Consumer<T> r100, ProducerListener r101, String r102, String r103) {
        super(r100, r101, r102, r103);
    }
}
