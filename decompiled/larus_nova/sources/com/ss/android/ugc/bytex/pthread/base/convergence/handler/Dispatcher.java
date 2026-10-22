package com.ss.android.ugc.bytex.pthread.base.convergence.handler;

import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
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

    public static void dispatchMessage(ReuseableHandlerThread r100, final Message r101) {
        final int r102 = r100.getIdentify();
        if (quitedThreads.get(Integer.valueOf(r102)) != Boolean.TRUE) goto L5;
        return;
    L5:
        r100.execute(new AnonymousClass2(r102, r101));
    }

    public static Looper getDispatcherLooper() {
        Looper r100 = dispatcherLooper;
        if (r100 != null) goto L14;
        Object r101 = dispatcherLock;
        monitor-enter(r101);
        r100 = dispatcherLooper;     // Catch: Throwable -> L11
        if (r100 != null) goto L9;
        DispatchHandlerThread r102 = new DispatchHandlerThread("Dispatcher");     // Catch: Throwable -> L11
        r102.start();     // Catch: Throwable -> L11
        r100 = r102.getLooper();     // Catch: Throwable -> L11
        dispatcherLooper = r100;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r100;
    }

    public static void onLooperQuit(Looper r100) {
        Object r101 = r100.getThread();
        if ((r101 instanceof ReuseableHandlerThread) == false) goto L6;
        ReuseableHandlerThread r102 = (ReuseableHandlerThread) r101;
        quitedThreads.put(Integer.valueOf(r102.getIdentify()), Boolean.TRUE);
        r102.onQuit();
        r102.execute(emptyRunnable);
        return;
    }
}
