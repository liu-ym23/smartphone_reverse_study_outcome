package com.ss.bytertc.engine.utils;

import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes40.dex */
public class LogRecover {
    private static LogRecover instance;
    private static boolean isRunning;
    private static Timer timer;

    public LogRecover() {
    }

    public static native void nativeSendLogRecoverRequest();

    public synchronized void startTimer() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (isRunning == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        TimerTask r100 = new AnonymousClass1(this);     // Catch: Throwable -> L10
        timer.schedule(r100, 1000, 600000);     // Catch: Throwable -> L10
        isRunning = true;     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public static LogRecover getInstance() {
        if (instance != null) goto L20;
        monitor-enter(LogRecover.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L14;
        instance = new LogRecover();     // Catch: Throwable -> L16
        timer = new PthreadTimer("ls/LogRecover");     // Catch: OutOfMemoryError -> L12 Throwable -> L16
        goto L13
    L11:
        isRunning = false;     // Catch: Throwable -> L16
    L13:
        throw new IllegalStateException("LogRecover timer create failed as out of memory");     // Catch: Throwable -> L16
    L14:
        monitor-exit(LogRecover.class);     // Catch: Throwable -> L16
    L20:
        return instance;
    }

    private void runOnUIThread(Runnable r100) {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        r100.run();
        return;
    L5:
        new Handler(Looper.getMainLooper()).post(r100);
    }

    public static /* synthetic */ void access$000(LogRecover r100, Runnable r101) {
        r100.runOnUIThread(r101);
    }
}
