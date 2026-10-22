package com.bytedance.common.wschannel.utils;

/* JADX INFO: loaded from: classes15.dex */
public abstract class WsAsyncTask implements Runnable {
    private final long mInitialDelay;
    private boolean mIsLoop;
    private long mLoopInterval;

    public WsAsyncTask() {
        this(0);
    }

    public final long getInitialDelay() {
        return this.mInitialDelay;
    }

    public final long getLoopInterval() {
        return this.mLoopInterval;
    }

    public final boolean isLoop() {
        return this.mIsLoop;
    }

    public WsAsyncTask(long r100) {
        this(r100, 0);
    }

    public WsAsyncTask(long r100, long r101) {
        this.mInitialDelay = r100;
        this.mLoopInterval = r101;
        if (r101 <= 0) goto L6;
        this.mIsLoop = true;
        return;
    }
}
