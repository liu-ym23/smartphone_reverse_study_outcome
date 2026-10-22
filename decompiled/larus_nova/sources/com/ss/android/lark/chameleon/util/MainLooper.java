package com.ss.android.lark.chameleon.util;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes35.dex */
public class MainLooper {
    private static Handler mainLooperHandler;

    public MainLooper() {
    }

    static {
        mainLooperHandler = new Handler(Looper.getMainLooper());
    }

    public static boolean isRunningInMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(mainLooperHandler.getLooper())) goto L5;
        return true;
    L5:
        return false;
    }

    public static void post(Runnable r100) {
        mainLooperHandler.post(r100);
    }

    public static void removeCallbacks(Runnable r100) {
        mainLooperHandler.removeCallbacks(r100);
    }

    public static void runOnMainThread(Runnable r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        r100.run();
        return;
    L5:
        post(r100);
    }

    public static void postDelayed(Runnable r100, long r101) {
        mainLooperHandler.postDelayed(r100, r101);
    }

    public static void runOnMainThreadDelayed(Runnable r100, long r101) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L5;
    L7:
        postDelayed(r100, r101);
        return;
    L5:
        if (r101 > 0) goto L7;
        r100.run();
    }
}
