package com.lynx.tasm;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile i8a.d f383563a;

    public q0() {
        this.f383563a = null;
    }

    public final void a(String r100, String r101) {
        if (r101 == null) goto L28;
    L22:
        e = move-exception;
        LLog.w("LynxInfoReportHelper", "Report Lynx Crash Context tag failed for LynxServiceCenter " + e.getMessage());
        return;
    L4:
        if (this.f383563a != null) goto L15;
        monitor-enter(this);     // Catch: NullPointerException -> L20 Throwable -> L22
    L11:
        th = move-exception;
        throw th;     // Catch: NullPointerException -> L20 Throwable -> L22
    L7:
        if (this.f383563a != null) goto L9;
        this.f383563a = (i8a.d) i8a.n.c().a(i8a.d.class);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
    L15:
        if (this.f383563a != null) goto L18;
        LLog.e("LynxInfoReportHelper", "LynxMonitorService is null");     // Catch: NullPointerException -> L20 Throwable -> L22
        return;
    L18:
        this.f383563a.reportCrashGlobalContextTag(r100, r101);     // Catch: NullPointerException -> L20 Throwable -> L22
        return;
    }
}
