package com.ss.android.lark.monitor.traffic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class n extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, TrafficMetrics> f432531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<TrafficMetrics> f432532c;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r100 = new TrafficMetrics();
        r100.from = "web";
        if (this.f432531b.isEmpty() == false) goto L5;
        ArrayList r101 = new ArrayList();
    L12:
        this.f432532c = r101;
        return r100;
    L5:
        monitor-enter(this);
        r101 = new ArrayList(this.f432531b.size());     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, TrafficMetrics>> r102 = this.f432531b.entrySet().iterator();     // Catch: Throwable -> L14
    L8:
        if (r102.hasNext() == false) goto L10;
        TrafficMetrics r103 = r102.next().getValue();     // Catch: Throwable -> L14
        r101.add(r103);     // Catch: Throwable -> L14
        r100.wifiBytesRx += r103.wifiBytesRx;     // Catch: Throwable -> L14
        r100.wifiBytesTx += r103.wifiBytesTx;     // Catch: Throwable -> L14
        r100.mobileBytesRx += r103.mobileBytesRx;     // Catch: Throwable -> L14
        r100.mobileBytesTx += r103.mobileBytesTx;     // Catch: Throwable -> L14
        goto L8
    L10:
        this.f432531b.clear();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public n() {
        this.f432531b = new ConcurrentHashMap(4);
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r100) {
        List<TrafficMetrics> r101 = this.f432532c;
        if (r101 == null) goto L8;
        Iterator<TrafficMetrics> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        TrafficMetrics r103 = r102.next();
        r100.f432512p += r103.totalKBytes();
        r100.f432513q += r103.totalMobileKBytes();
        r100.f432514r += r103.totalWifiKBytes();
        r100.f432515s += r103.totalRxKBytes();
        r100.f432516t += r103.totalTxKBytes();
        goto L6
    L10:
        return;
    }
}
