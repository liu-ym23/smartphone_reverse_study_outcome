package com.ss.android.lark.monitor.traffic;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile TrafficMetrics f432481b;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r100 = new TrafficMetrics();
        this.f432473a = r100;
        r100.from = TrafficMetrics.FRPM_TTNET;
        monitor-enter(this);
        this.f432473a.set(this.f432481b);     // Catch: Throwable -> L8
        this.f432481b.reset();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return this.f432473a;
    L8:
        th = move-exception;
        throw th;
    }

    public g() {
        this.f432481b = new TrafficMetrics();
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r100) {
        TrafficMetrics r101 = this.f432473a;
        if (r101 == null) goto L6;
        r100.E = r101.totalKBytes();
        r100.F = this.f432473a.totalMobileKBytes();
        r100.G = this.f432473a.totalWifiKBytes();
        r100.H = this.f432473a.totalRxKBytes();
        r100.I = this.f432473a.totalTxKBytes();
        return;
    }
}
