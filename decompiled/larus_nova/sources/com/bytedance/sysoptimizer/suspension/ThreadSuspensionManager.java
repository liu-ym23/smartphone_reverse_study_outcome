package com.bytedance.sysoptimizer.suspension;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes22.dex */
public class ThreadSuspensionManager {
    private static final long DEFAULT_SUSPENSION_TASK_DURATION = 180000;
    private static final int MSG_STOP_TASK = 0;
    private static final String SUSPEND_TASK_THREAD_NAME = "suspend_thread_task";
    private static final String TAG = "ThreadSuspensionManager";
    private static ThreadSuspensionHandler mHanderThread;
    private static final Handler mMainHandler = null;

    public ThreadSuspensionManager() {
    }

    public static void start(SuspensionParam r100, ThreadSuspendedCallback r101, Runnable r102) {
    }

    static {
        final Looper r100 = Looper.getMainLooper();
        mMainHandler = new AnonymousClass1(r100);
    }

    public static void stop() {
        Handler r100 = mMainHandler;
        r100.removeMessages(0);
        Message r101 = Message.obtain();
        r101.what = 0;
        r100.sendMessage(r101);
    }

    private static void stopTask() {
        ThreadSuspensionHandler r100 = mHanderThread;
        if (r100 == null) goto L6;
        r100.stopTask();
        mHanderThread = null;
        return;
    }

    public static /* synthetic */ void access$000() {
        stopTask();
    }
}
