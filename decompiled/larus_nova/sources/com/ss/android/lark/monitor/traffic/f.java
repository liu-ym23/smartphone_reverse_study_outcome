package com.ss.android.lark.monitor.traffic;

import android.content.Context;
import com.facebook.battery.metrics.core.StatefulSystemMetricsCollector;
import com.facebook.battery.metrics.network.NetworkMetrics;
import com.facebook.battery.metrics.network.NetworkMetricsCollector;

/* JADX INFO: loaded from: classes36.dex */
public final class f extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StatefulSystemMetricsCollector<NetworkMetrics, NetworkMetricsCollector> f432479b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f432480c;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r100 = new TrafficMetrics();
        if (this.f432480c == false) goto L8;
        NetworkMetrics r101 = (NetworkMetrics) this.f432479b.getLatestDiffAndReset();
        if (r101 == null) goto L7;
        r100.mobileBytesRx = r101.mobileBytesRx;
        r100.mobileBytesTx = r101.mobileBytesTx;
        r100.wifiBytesRx = r101.wifiBytesRx;
        r100.wifiBytesTx = r101.wifiBytesTx;
    L7:
        r100.from = "total";
        this.f432473a = r100;
    L8:
        return r100;
    }

    public f(com.ss.android.lark.monitor.i r100) {
        super(0);
        Context r101 = r100.f432397a;
        boolean r102 = r100.f432400d;
        this.f432479b = new StatefulSystemMetricsCollector(new NetworkMetricsCollector(r101));
        this.f432480c = r102;
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r100) {
        TrafficMetrics r101 = this.f432473a;
        if (r101 == null) goto L6;
        r100.f432497a = r101.totalKBytes();
        r100.f432498b = this.f432473a.totalMobileKBytes();
        r100.f432499c = this.f432473a.totalWifiKBytes();
        r100.f432500d = this.f432473a.totalRxKBytes();
        r100.f432501e = this.f432473a.totalTxKBytes();
        return;
    }
}
