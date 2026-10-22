package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class ThreadUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object sLock = null;
    private static boolean sThreadAssertsDisabled;
    private static Handler sUiThreadHandler;
    private static boolean sWillOverride;

    /* JADX INFO: loaded from: classes5.dex */
    public static class ThreadChecker {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final long mThreadId;

        public void assertOnValidThread() {
        }

        public ThreadChecker() {
            this.mThreadId = Process.myTid();
        }

        static {
        }
    }

    public ThreadUtils() {
    }

    public static void assertOnBackgroundThread() {
    }

    public static void assertOnUiThread() {
    }

    static {
        sLock = new Object();
    }

    public static void checkUiThread() {
        if (sThreadAssertsDisabled == false) goto L5;
        return;
    L5:
        if (runningOnUiThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on the UI thread.");
    }

    public static Handler getUiThreadHandler() {
        Object r100 = sLock;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (sUiThreadHandler == null) goto L7;
        boolean r101 = false;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L17
        if (r101 == false) goto L16;
        TraceEvent.onUiThreadReady();
    L16:
        return sUiThreadHandler;
    L7:
        if (sWillOverride == true) goto L10;
        sUiThreadHandler = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L17
        r101 = true;
        goto L12
    L10:
        throw new RuntimeException("Did not yet override the UI thread");     // Catch: Throwable -> L17
    }

    public static Looper getUiThreadLooper() {
        return getUiThreadHandler().getLooper();
    }

    public static boolean runningOnUiThread() {
        if (getUiThreadHandler().getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ boolean access$000() {
        return sThreadAssertsDisabled;
    }

    private static boolean isThreadPriorityAudio(int r100) {
        if (Process.getThreadPriority(r100) != (-16)) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> FutureTask<T> postOnUiThread(FutureTask<T> r100) {
        getUiThreadHandler().post(r100);
        return r100;
    }

    public static void runOnUiThread(Runnable r100) {
        if (runningOnUiThread() == false) goto L5;
        r100.run();
        return;
    L5:
        getUiThreadHandler().post(r100);
    }

    public static void runOnUiThreadBlocking(Runnable r100) {
        if (runningOnUiThread() == false) goto L5;
        r100.run();
        return;
    L5:
        FutureTask r101 = new FutureTask(r100, null);
        postOnUiThread(r101);
        r101.get();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("Exception occurred while waiting for runnable", e);
    }

    public static <T> T runOnUiThreadBlockingNoException(Callable<T> r100) {
        return (T) runOnUiThreadBlocking(r100);
    L4:
        e = move-exception;
        throw new RuntimeException("Error occurred waiting for callable", e);
    }

    public static void setThreadAssertsDisabledForTesting(boolean r100) {
        sThreadAssertsDisabled = r100;
    }

    public static void setThreadPriorityAudio(int r100) {
        Process.setThreadPriority(r100, -16);
    }

    public static void setUiThread(Looper r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        if (r100 == null) goto L6;
        Handler r102 = sUiThreadHandler;     // Catch: Throwable -> L20
        if (r102 != null) goto L12;
    L16:
        sUiThreadHandler = new Handler(r100);     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        TraceEvent.onUiThreadReady();
        return;
    L12:
        if (r102.getLooper() == r100) goto L16;
        throw new RuntimeException("UI thread looper is already set to " + sUiThreadHandler.getLooper() + " (Main thread looper is " + Looper.getMainLooper() + "), cannot set to new looper " + r100);     // Catch: Throwable -> L20
    L6:
        sUiThreadHandler = null;     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public static void setWillOverrideUiThread(boolean r100) {
        Object r101 = sLock;
        monitor-enter(r101);
        sWillOverride = r100;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void postOnUiThread(Runnable r100) {
        getUiThreadHandler().post(r100);
    }

    public static <T> FutureTask<T> runOnUiThread(FutureTask<T> r100) {
        if (runningOnUiThread() == false) goto L5;
        r100.run();
    L6:
        return r100;
    L5:
        postOnUiThread(r100);
        goto L6
    }

    public static <T> T runOnUiThreadBlocking(Callable<T> r100) throws ExecutionException {
        FutureTask r101 = new FutureTask(r100);
        runOnUiThread(r101);
        return (T) r101.get();
    L5:
        e = move-exception;
        throw new RuntimeException("Interrupted waiting for callable", e);
    }

    public static <T> FutureTask<T> runOnUiThread(Callable<T> r100) {
        return runOnUiThread(new FutureTask(r100));
    }

    public static void postOnUiThreadDelayed(Runnable r100, long r101) {
        getUiThreadHandler().postDelayed(r100, r101);
    }
}
