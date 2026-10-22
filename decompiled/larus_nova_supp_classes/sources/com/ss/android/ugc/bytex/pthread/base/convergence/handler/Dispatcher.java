package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class Dispatcher {
    private static final Object dispatcherLock = null;
    private static volatile Looper dispatcherLooper;
    private static final Runnable emptyRunnable = null;
    private static final ConcurrentHashMap<Integer, Boolean> quitedThreads = null;
    private static final AtomicInteger sIdentify = null;
    private static final ConcurrentHashMap<Integer, Executor> threadExecutors = null;

    static {
        dispatcherLock = new Object();
        sIdentify = new AtomicInteger(0);
        quitedThreads = new ConcurrentHashMap();
        threadExecutors = new ConcurrentHashMap();
        emptyRunnable = new AnonymousClass1();
    }

    public Dispatcher() {
    }

    public static /* synthetic */ ConcurrentHashMap access$000() {
        return quitedThreads;
    }

    public static int attachHandlerThreadIdentify() {
        return sIdentify.incrementAndGet();
    }

    public static void dispatchMessage(ReuseableHandlerThread r3, Message r4) {
        int r0 = r3.getIdentify();
        if (quitedThreads.get(Integer.valueOf(r0)) != Boolean.TRUE) goto L5;
        return;
    L5:
        r3.execute(new 2(r0, r4));
    }

    public static Looper getDispatcherLooper() {
        Looper r0 = dispatcherLooper;
        if (r0 != null) goto L14;
        Object r1 = dispatcherLock;
        monitor-enter(r1);
        r0 = dispatcherLooper;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        DispatchHandlerThread r2 = new DispatchHandlerThread("Dispatcher");     // Catch: Throwable -> L11
        r2.start();     // Catch: Throwable -> L11
        r0 = r2.getLooper();     // Catch: Throwable -> L11
        dispatcherLooper = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    }

    public static void onLooperQuit(Looper r3) {
        Object r4 = r3.getThread();
        if ((r4 instanceof ReuseableHandlerThread) == false) goto L6;
        ReuseableHandlerThread r5 = (ReuseableHandlerThread) r4;
        quitedThreads.put(Integer.valueOf(r5.getIdentify()), Boolean.TRUE);
        r5.onQuit();
        r5.execute(emptyRunnable);
        return;
    }
}
