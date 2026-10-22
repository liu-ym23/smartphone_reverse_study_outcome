package com.bytedance.common.wschannel;

import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes15.dex */
public class SocketHandler implements WeakHandler.IHandler {
    private static WeakHandler mHandler;
    private static volatile SocketHandler sInstance;

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
    }

    public static SocketHandler inst() {
        if (sInstance != null) goto L15;
        monitor-enter(SocketHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SocketHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SocketHandler.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private SocketHandler() {
        if (mHandler != null) goto L10;
        mHandler = PushThreadHandlerManager.inst().getHandler();     // Catch: Throwable -> L6
        return;
    L6:
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("WsHT");
        ThreadMethodProxy.start(r100);
        mHandler = new WeakHandler(r100.getLooper(), this);
        return;
    }

    public WeakHandler getHandler() {
        return mHandler;
    }

    public void postRunnable(Runnable r100) {
        postRunnable(r100, 0);
    }

    public void postRunnable(Runnable r100, long r101) {
        if (r101 > 0) goto L5;
        mHandler.post(r100);
        return;
    L5:
        mHandler.postDelayed(r100, r101);
    }
}
