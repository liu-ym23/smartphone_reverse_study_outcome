package com.bytedance.sdk.open.aweme.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadUtils {
    private static ExecutorService executorService;
    private static Handler mainHandler;

    public ThreadUtils() {
    }

    private static ExecutorService getExecutorService() {
        if (executorService != null) goto L15;
        monitor-enter(ThreadUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (executorService != null) goto L9;
        executorService = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("s/ThreadUtils"));     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadUtils.class);     // Catch: Throwable -> L11
    L15:
        return executorService;
    }

    public static Handler getMainHandler() {
        if (mainHandler != null) goto L15;
        monitor-enter(ThreadUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mainHandler != null) goto L9;
        mainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(ThreadUtils.class);     // Catch: Throwable -> L11
    L15:
        return mainHandler;
    }

    public static boolean isUIThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void postInMain(Runnable r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (isUIThread() == false) goto L7;
        r100.run();
        return;
    L7:
        getMainHandler().post(r100);
    }

    public static void summit(Runnable r100) {
        ExecutorService r101 = getExecutorService();
        if (r101 == null) goto L6;
        r101.submit(r100);
        return;
    }
}
