package com.ss.android.lark.utils.rxjava;

import com.larksuite.framework.thread.CoreThreadPool;
import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;

/* JADX INFO: loaded from: classes38.dex */
public class LarkRxSchedulers {
    private static volatile ExecutorScheduler mComputeScheduler;
    private static volatile ExecutorScheduler mIOScheduler;
    private static volatile ExecutorScheduler mUIScheduler;

    public LarkRxSchedulers() {
    }

    public static Scheduler computation() {
        if (mComputeScheduler != null) goto L15;
        ExecutorScheduler r100 = new ExecutorScheduler(CoreThreadPool.getDefault().getFixedThreadPool(), false);
        monitor-enter(LarkRxSchedulers.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mComputeScheduler != null) goto L9;
        mComputeScheduler = r100;     // Catch: Throwable -> L11
    L9:
        monitor-exit(LarkRxSchedulers.class);     // Catch: Throwable -> L11
    L15:
        return mComputeScheduler;
    }

    public static Scheduler io() {
        if (mIOScheduler != null) goto L15;
        ExecutorScheduler r100 = new ExecutorScheduler(CoreThreadPool.getDefault().getCachedThreadPool(), false);
        monitor-enter(LarkRxSchedulers.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mIOScheduler != null) goto L9;
        mIOScheduler = r100;     // Catch: Throwable -> L11
    L9:
        monitor-exit(LarkRxSchedulers.class);     // Catch: Throwable -> L11
    L15:
        return mIOScheduler;
    }

    public static Scheduler mainThread() {
        if (mUIScheduler != null) goto L15;
        ExecutorScheduler r100 = new ExecutorScheduler(CoreThreadPool.getDefault().getUIExecutor(), false);
        monitor-enter(LarkRxSchedulers.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mUIScheduler != null) goto L9;
        mUIScheduler = r100;     // Catch: Throwable -> L11
    L9:
        monitor-exit(LarkRxSchedulers.class);     // Catch: Throwable -> L11
    L15:
        return mUIScheduler;
    }
}
