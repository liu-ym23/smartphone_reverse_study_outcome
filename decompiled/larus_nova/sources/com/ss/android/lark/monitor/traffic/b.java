package com.ss.android.lark.monitor.traffic;

import android.util.ArrayMap;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes36.dex */
public final class b extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, TrafficMetrics> f432474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<TrafficMetrics> f432475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayMap<String, Float> f432476d;

    @Override // com.ss.android.lark.monitor.traffic.c
    public final TrafficMetrics b() {
        TrafficMetrics r100 = new TrafficMetrics();
        r100.from = "http";
        if (this.f432474b.isEmpty() == false) goto L5;
        ArrayList r101 = new ArrayList();
    L12:
        this.f432475c = r101;
        return r100;
    L5:
        monitor-enter(this);
        r101 = new ArrayList(this.f432474b.size());     // Catch: Throwable -> L14
        Iterator<Map.Entry<String, TrafficMetrics>> r102 = this.f432474b.entrySet().iterator();     // Catch: Throwable -> L14
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
        this.f432474b.clear();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void c() {
        ArrayMap<String, Float> r100 = this.f432476d;
        monitor-enter(r100);
        Iterator<String> r101 = this.f432476d.keySet().iterator();     // Catch: Throwable -> L14 Exception -> L16
    L6:
        if (r101.hasNext() == false) goto L12;
        String r102 = r101.next();     // Catch: Throwable -> L14 Exception -> L16
        if (this.f432476d.get(r102) == null) goto L6;
        if (this.f432476d.get(r102).floatValue() < 1000.0f) goto L6;
        Log.i("TrafficMonitorHttpTraffic", "http_url: " + r102 + "url_cost(KB): " + this.f432476d.get(r102));     // Catch: Throwable -> L14 Exception -> L16
        goto L6
    L12:
        this.f432476d.clear();     // Catch: Throwable -> L14 Exception -> L16
    L18:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public b() {
        this.f432474b = new ConcurrentHashMap();
        this.f432476d = new ArrayMap();
    }

    @Override // com.ss.android.lark.monitor.traffic.c
    public final void a(k r100) {
        List<TrafficMetrics> r101 = this.f432475c;
        if (r101 == null) goto L19;
        Iterator<TrafficMetrics> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L23;
        TrafficMetrics r103 = r102.next();
        Log.i("HttpTraffic", "http_url:" + r103.from + ", url_cost(kb):" + r103.totalKBytes());
        ArrayMap<String, Float> r104 = this.f432476d;
        monitor-enter(r104);
        if (this.f432476d.get(r103.from) != null) goto L12;
        float r105 = 0.0f;
    L13:
        this.f432476d.put(r103.from, Float.valueOf(r105 + r103.totalKBytes()));     // Catch: Throwable -> L16
        monitor-exit(r104);     // Catch: Throwable -> L16
        r100.f432507k += r103.totalKBytes();
        r100.f432508l += r103.totalMobileKBytes();
        r100.f432509m += r103.totalWifiKBytes();
        r100.f432510n += r103.totalRxKBytes();
        r100.f432511o += r103.totalTxKBytes();
        goto L6
    L12:
        r105 = this.f432476d.get(r103.from).floatValue();     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    L23:
        return;
    }
}
