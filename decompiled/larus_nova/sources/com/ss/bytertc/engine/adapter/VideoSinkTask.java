package com.ss.bytertc.engine.adapter;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes40.dex */
public class VideoSinkTask extends PthreadHandlerThreadV2 {
    private Handler mHandler;
    private Object mLock;

    public VideoSinkTask() {
        super("VideoSinkTaskManager", 0);
        this.mLock = new Object();
    }

    public void exit() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        quitSafely();     // Catch: Throwable -> L9
        this.mHandler = null;     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void init() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        ThreadMethodProxy.start(this);     // Catch: Throwable -> L8 OutOfMemoryError -> L10
        this.mHandler = new Handler(getLooper());     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L11:
        throw new IllegalStateException("videosink task create thread failed as out of memory");     // Catch: Throwable -> L8
    }

    public void post(Runnable r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        Handler r102 = this.mHandler;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.post(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void postDelayed(Runnable r100, long r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        Handler r103 = this.mHandler;     // Catch: Throwable -> L9
        if (r103 == null) goto L7;
        r103.postDelayed(r100, r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
