package com.lynx.debugrouter.base;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes32.dex */
public class UIThreadUtils {
    private static Handler sMainHandler;

    public UIThreadUtils() {
    }

    public static boolean isOnUiThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void runOnUiThread(Runnable r100) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.post(r100);
    }

    public static void runOnUiThreadImmediately(Runnable r100) {
        if (isOnUiThread() == false) goto L5;
        r100.run();
        return;
    L5:
        runOnUiThread(r100);
    }

    public static void removeCallbacks(Runnable r100, Object r101) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.removeCallbacks(r100, r101);
    }

    public static void runOnUiThread(Runnable r100, long r101) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.postDelayed(r100, r101);
    }

    public static void runOnUiThreadAtTime(Runnable r100, Object r101, long r102) {
        monitor-enter(UIThreadUtils.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMainHandler != null) goto L7;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L10
    L7:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L10
        sMainHandler.postAtTime(r100, r101, r102);
    }
}
