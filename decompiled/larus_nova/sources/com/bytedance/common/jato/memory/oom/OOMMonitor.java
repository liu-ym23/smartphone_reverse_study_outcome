package com.bytedance.common.jato.memory.oom;

import com.bytedance.common.jato.JatoNativeLoader;
import com.bytedance.common.jato.gc.GCListener;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes15.dex */
public class OOMMonitor {
    private volatile boolean inited;
    private final AtomicInteger listenerCount;
    private volatile GCListener[] listeners;

    private void dispatchOOM() {
    }

    private native void init();

    private synchronized void tryInit() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L6;
    L9:
        monitor-exit(this);
        return;
    L6:
        if (JatoNativeLoader.loadLibrary() == false) goto L8;
        init();     // Catch: Throwable -> L11
    L8:
        this.inited = true;     // Catch: Throwable -> L11
        goto L9
    }

    public OOMMonitor() {
        this.inited = false;
        this.listeners = new GCListener[1];
        this.listenerCount = new AtomicInteger(0);
        tryInit();
    }
}
