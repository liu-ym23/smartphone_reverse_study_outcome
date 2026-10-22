package com.ss.android.lark.monitor.traffic;

/* JADX INFO: loaded from: classes36.dex */
public final class m extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile TrafficMetrics f432530b;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r100 = new TrafficMetrics();
        this.f432473a = r100;
        r100.from = "video_play";
        monitor-enter(this);
        this.f432473a.set(this.f432530b);     // Catch: Throwable -> L8
        this.f432530b.reset();     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        return this.f432473a;
    L8:
        th = move-exception;
        throw th;
    }

    public m() {
        this.f432530b = new TrafficMetrics();
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r100) {
        TrafficMetrics r101 = this.f432473a;
        if (r101 == null) goto L6;
        r100.f432522z = r101.totalKBytes();
        r100.A = this.f432473a.totalMobileKBytes();
        r100.B = this.f432473a.totalWifiKBytes();
        r100.C = this.f432473a.totalRxKBytes();
        r100.D = this.f432473a.totalTxKBytes();
        return;
    }
}
