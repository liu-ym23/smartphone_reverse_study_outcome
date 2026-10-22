package com.lynx.tasm.utils;

import android.os.Handler;
import android.os.Looper;
import com.lynx.tasm.base.LLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes32.dex */
public class UIThreadUtils {
    private static final String TAG = "UIThreadUtils";
    private static volatile Handler sMainHandler;

    public UIThreadUtils() {
    }

    private static Handler getUiThreadHandler() {
        if (sMainHandler != null) goto L15;
        monitor-enter(UIThreadUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sMainHandler != null) goto L9;
        sMainHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(UIThreadUtils.class);     // Catch: Throwable -> L11
    L15:
        return sMainHandler;
    }

    public static void assertNotOnUiThread() {
        if ((!isOnUiThread()) == false) goto L6;
        return;
    L6:
        throw new AssertionError("Expected not to run on UI thread!");
    }

    public static void assertOnUiThread() {
        if (isOnUiThread() == false) goto L6;
        return;
    L6:
        throw new AssertionError("Expected to run on UI thread!");
    }

    public static boolean isOnUiThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    public static void postAtFrontOfQueueOnUiThread(Runnable r100) {
        getUiThreadHandler().postAtFrontOfQueue(r100);
    }

    public static void runOnUiThread(Runnable r100) {
        getUiThreadHandler().post(r100);
    }

    public static void runOnUiThreadImmediately(Runnable r100) {
        if (isOnUiThread() == false) goto L5;
        r100.run();
        return;
    L5:
        runOnUiThread(r100);
    }

    public static void runOnUiThreadImmediatelyWithPostAtFront(Runnable r100) {
        if (isOnUiThread() == false) goto L5;
        r100.run();
        return;
    L5:
        postAtFrontOfQueueOnUiThread(r100);
    }

    public static boolean runOnUiThreadSync(Runnable r100) {
        if (isOnUiThread() == false) goto L6;
        r100.run();
        return true;
    L6:
        FutureTask r101 = new FutureTask(r100, null);
        runOnUiThread(r101);
        r101.get();     // Catch: ExecutionException -> L9 InterruptedException -> L12
        return true;
    L12:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        LLog.e(TAG, "Interrupted while waiting for UI thread task: " + e);
        return false;
    L9:
        e = move-exception;
        LLog.e(TAG, "Exception while running UI thread task: " + e.getCause());
        return false;
    }

    public static void removeCallbacks(Runnable r100, Object r101) {
        getUiThreadHandler().removeCallbacks(r100, r101);
    }

    public static void runOnUiThread(Runnable r100, long r101) {
        getUiThreadHandler().postDelayed(r100, r101);
    }

    public static void runOnUiThreadAtTime(Runnable r100, Object r101, long r102) {
        getUiThreadHandler().postAtTime(r100, r101, r102);
    }
}
