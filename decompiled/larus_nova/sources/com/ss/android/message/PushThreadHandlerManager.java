package com.ss.android.message;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class PushThreadHandlerManager implements WeakHandler.IHandler {
    private static HandlerThread sHandlerThread;
    private static volatile PushThreadHandlerManager sInstance;
    private static boolean sIsHandlerThreadInited;
    private final Set<Handler.Callback> mCallbacks;
    private final WeakHandler mHandler;

    public static PushThreadHandlerManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(PushThreadHandlerManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PushThreadHandlerManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PushThreadHandlerManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public Looper getLooper() {
        return sHandlerThread.getLooper();
    }

    private PushThreadHandlerManager() {
        this.mCallbacks = new HashSet();
        if (sHandlerThread != null) goto L5;
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("PushThreadHandler");
        sHandlerThread = r100;
        ThreadMethodProxy.start(r100);
        sIsHandlerThreadInited = true;
    L5:
        this.mHandler = new WeakHandler(sHandlerThread.getLooper(), this);
    }

    public WeakHandler getHandler() {
        return this.mHandler;
    }

    public static void setStartedHandlerThread(HandlerThread r100) {
        if (sIsHandlerThreadInited == true) goto L7;
        if (r100 == null) goto L8;
        sHandlerThread = r100;
        return;
    L8:
        return;
    }

    public void addHandlerCallback(Handler.Callback r100) {
        Set<Handler.Callback> r101 = this.mCallbacks;
        monitor-enter(r101);
        this.mCallbacks.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public WeakHandler getHandler(Handler.Callback r100) {
        addHandlerCallback(r100);
        return getHandler();
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
        Set<Handler.Callback> r101 = this.mCallbacks;
        monitor-enter(r101);
        Iterator<Handler.Callback> r102 = this.mCallbacks.iterator();     // Catch: Throwable -> L13
    L6:
        if (r102.hasNext() == false) goto L11;
        if (r102.next().handleMessage(r100) == false) goto L6;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void postRunnable(Runnable r100) {
        postRunnable(r100, 0);
    }

    public void removeHandlerCallback(Handler.Callback r100) {
        Set<Handler.Callback> r101 = this.mCallbacks;
        monitor-enter(r101);
        this.mCallbacks.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void postRunnable(Runnable r100, long r101) {
        if (r101 <= 0) goto L5;
        this.mHandler.postDelayed(r100, r101);
        return;
    L5:
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L9;
        if (r100 == null) goto L12;
        r100.run();
        return;
    L12:
        return;
    L9:
        this.mHandler.post(r100);
    }
}
