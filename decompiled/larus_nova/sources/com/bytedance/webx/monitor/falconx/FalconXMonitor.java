package com.bytedance.webx.monitor.falconx;

import nv5.g;

/* JADX INFO: loaded from: classes22.dex */
public class FalconXMonitor {
    private static volatile FalconXMonitor instance;
    private boolean hasSetMonitor;

    public class a implements g.a {
        public a() {
        }
    }

    public static FalconXMonitor getInstance() {
        if (instance != null) goto L15;
        monitor-enter(FalconXMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new FalconXMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FalconXMonitor.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void beginMonitor() {
        if (this.hasSetMonitor == true) goto L6;
        this.hasSetMonitor = true;
        g.f520897a = new a();
        return;
    }

    public FalconXMonitor() {
        this.hasSetMonitor = false;
    }
}
