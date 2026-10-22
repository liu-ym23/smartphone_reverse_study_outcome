package com.bytedance.dora.link.monitor;

import pk4.j;

/* JADX INFO: loaded from: classes15.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DoraBytelinkPairTraceMonitor f204438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f204439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DoraBytelinkPairTraceMonitor.c f204440c;

    public /* synthetic */ b(DoraBytelinkPairTraceMonitor r100, int r101, DoraBytelinkPairTraceMonitor.c r102) {
        this.f204438a = r100;
        this.f204439b = r101;
        this.f204440c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DoraBytelinkPairTraceMonitor r100 = this.f204438a;
        int r101 = this.f204439b;
        DoraBytelinkPairTraceMonitor.c r102 = this.f204440c;
        r100.getClass();
        r100.b(r101, r102);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        j.c("DoraBytelinkPairTraceMonitor", "onSessionClosed: async close processing failed", th);
    }
}
