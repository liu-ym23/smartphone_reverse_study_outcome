package com.facebook.common.executors;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes22.dex */
public final class FrescoHandlerThread {
    private static final String THREAD_NAME = "FrescoAsyncController";

    public static final class HandlerHolder {
        static final Handler sMainHandler = null;
        static final Handler sWorkerHandler = null;
        static final HandlerThread sWorkerThread = null;

        private HandlerHolder() {
        }

        static {
            sWorkerThread = FrescoHandlerThread.access$000();
            sWorkerHandler = FrescoHandlerThread.access$100();
            sMainHandler = new Handler(Looper.getMainLooper());
        }
    }

    private FrescoHandlerThread() {
    }

    private static Handler createWorkerHandler() {
        return new Handler(HandlerHolder.sWorkerThread.getLooper());
    }

    private static HandlerThread createWorkerThread() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2(THREAD_NAME);
        ThreadMethodProxy.start(r100);
        return r100;
    }

    public static /* synthetic */ HandlerThread access$000() {
        return createWorkerThread();
    }

    public static /* synthetic */ Handler access$100() {
        return createWorkerHandler();
    }

    public static boolean isMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public static Handler getMainHandler() {
        return HandlerHolder.sMainHandler;
    }

    public static Handler getWorkerHandler() {
        return HandlerHolder.sWorkerHandler;
    }

    public static void removeAsync(Runnable r100) {
        getWorkerHandler().removeCallbacks(r100);
    }

    public static void runAsync(Runnable r100) {
        if (ThreadMethodProxy.currentThread() != HandlerHolder.sWorkerThread) goto L5;
        r100.run();
        return;
    L5:
        getWorkerHandler().post(r100);
    }

    public static void runInMain(Runnable r100) {
        if (isMainThread() == false) goto L5;
        r100.run();
        return;
    L5:
        getMainHandler().post(r100);
    }

    public static void runAsyncDelayed(Runnable r100, long r101) {
        getWorkerHandler().postDelayed(r100, r101);
    }
}
