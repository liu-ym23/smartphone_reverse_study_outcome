package com.bytedance.common.jato.view;

import android.os.Handler;
import android.os.HandlerThread;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;

/* JADX INFO: loaded from: classes15.dex */
public class ViewHandler {
    private static Handler handler;
    private static volatile boolean isInited;
    private static HandlerThread worker;

    public ViewHandler() {
    }

    public static Handler getHandler() {
        if (isInited == true) goto L15;
        monitor-enter(ViewHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (isInited == true) goto L9;
        init();     // Catch: Throwable -> L11
        isInited = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(ViewHandler.class);     // Catch: Throwable -> L11
    L15:
        return handler;
    }

    private static void init() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("ViewHandler");
        worker = r100;
        ThreadMethodProxy.start(r100);
        handler = new Handler(worker.getLooper());
    }
}
