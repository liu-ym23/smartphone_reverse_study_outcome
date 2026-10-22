package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.Deque;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class ThreadHandoffProducerQueue {
    private final Executor mExecutor;
    private boolean mQueueing;
    private final Deque<Runnable> mRunnableList;

    public synchronized boolean isQueueing() {
        monitor-enter(this);
        boolean r100 = this.mQueueing;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void startQueueing() {
        monitor-enter(this);
        this.mQueueing = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void stopQueuing() {
        monitor-enter(this);
        this.mQueueing = false;     // Catch: Throwable -> L7
        execInQueue();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void execInQueue() {
    L3:
        if (this.mRunnableList.isEmpty() == true) goto L5;
        this.mExecutor.execute(this.mRunnableList.pop());
        goto L3
    L5:
        this.mRunnableList.clear();
    }

    public ThreadHandoffProducerQueue(Executor r100) {
        this.mQueueing = false;
        this.mExecutor = (Executor) Preconditions.checkNotNull(r100);
        this.mRunnableList = new AnonymousClass1(this);
    }

    public synchronized void addToQueueOrExecute(Runnable r100) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mQueueing == false) goto L6;
        this.mRunnableList.add(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        this.mExecutor.execute(r100);     // Catch: Throwable -> L9
        goto L7
    }

    public synchronized void remove(Runnable r100) {
        monitor-enter(this);
        this.mRunnableList.remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
