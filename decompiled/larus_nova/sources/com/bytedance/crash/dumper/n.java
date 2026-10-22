package com.bytedance.crash.dumper;

import com.bytedance.crash.npth_repair.monitor.SignalMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public final class n {
    public static void a(File r100) {
        String r101 = new PolarisFileWrapper(r100, "signal_monitor.txt").getAbsolutePath();     // Catch: Throwable -> L17
        boolean r102 = nh4.a.f519163g;     // Catch: Throwable -> L17
        monitor-enter(nh4.a.class);     // Catch: Throwable -> L17
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L5:
        if ((nh4.a.e.f519176a.f519172d & 4) == 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == false) goto L11;
        SignalMonitor.b().a(r101);     // Catch: Throwable -> L13
    L11:
        monitor-exit(nh4.a.class);     // Catch: Throwable -> L17
        return;
    L7:
        r103 = false;
    }
}
