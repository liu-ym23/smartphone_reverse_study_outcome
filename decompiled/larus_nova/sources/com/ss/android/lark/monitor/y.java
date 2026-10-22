package com.ss.android.lark.monitor;

import androidx.core.util.Pair;
import com.facebook.battery.reporter.cpu.CpuMetricsReporter;
import com.facebook.battery.reporter.network.NetworkMetricsReporter;
import com.facebook.battery.reporter.time.TimeMetricsReporter;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public final class y implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f432538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.a f432539b;

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter.Event
    public final boolean isSampled() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter.Event
    public final void logAndRelease() {
        this.f432539b.f432357j = System.currentTimeMillis();
        b.a r100 = this.f432539b;
        r100.getClass();
        b r101 = new b(r100);
        Log.i("LarkMetrics", "process:" + r101.f432343g + ", activityName:" + r101.f432337a);
        if (((CopyOnWriteArrayList) r101.f432347k).isEmpty() == true) goto L11;
        Iterator r102 = ((CopyOnWriteArrayList) r101.f432347k).iterator();
    L6:
        if (r102.hasNext() == false) goto L17;
        Pair r103 = (Pair) r102.next();
        if (r103 == null) goto L6;
        Log.i("LarkMetrics", "thread name:" + ((String) r103.first) + " usage:" + r103.second);
        goto L6
    L17:
        return;
    }

    public y(i r100) {
        this.f432538a = r100.f432398b;
    }

    @Override // com.ss.android.lark.monitor.z
    public final void a(String r100, double r101) {
        List<Pair<String, Double>> r102 = this.f432539b.f432358k;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) r102;
        r103.add(new Pair(r100, Double.valueOf(r101)));
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter.Event
    public final void acquireEvent(String r100, String r101) {
        b.a r102 = new b.a();
        r102.f432348a = r101;
        this.f432539b = r102;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter.Event
    public final void add(String r100, long r101) {
        if (NetworkMetricsReporter.MOBILE_BYTES_RX.equals(r100) == false) goto L6;
        this.f432539b.f432352e = (r101 * 1.0f) / 1024.0f;
        return;
    L6:
        if (NetworkMetricsReporter.MOBILE_BYTES_TX.equals(r100) == false) goto L9;
        this.f432539b.f432351d = (r101 * 1.0f) / 1024.0f;
        return;
    L9:
        if (NetworkMetricsReporter.WIFI_BYTES_RX.equals(r100) == false) goto L12;
        this.f432539b.f432350c = (r101 * 1.0f) / 1024.0f;
        return;
    L12:
        if (NetworkMetricsReporter.WIFI_BYTES_TX.equals(r100) == false) goto L15;
        this.f432539b.f432349b = (r101 * 1.0f) / 1024.0f;
        return;
    L15:
        if (TimeMetricsReporter.REALTIME_MS.equals(r100) == false) goto L22;
        this.f432539b.f432356i = (r101 * 1.0f) / 1000.0f;
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter.Event
    public final void add(String r100, int r101) {
        if ("max_mem".equals(r100) == false) goto L6;
        this.f432539b.getClass();
        return;
    L6:
        if ("total_mem".equals(r100) == false) goto L9;
        this.f432539b.getClass();
        return;
    L9:
        if ("native_heap".equals(r100) == false) goto L12;
        this.f432539b.getClass();
        return;
    L12:
        if ("java_heap".equals(r100) == false) goto L18;
        this.f432539b.getClass();
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter.Event
    public final void add(String r100, double r101) {
        if (CpuMetricsReporter.CPU_SYSTEM_TIME_S.equals(r100) == false) goto L6;
        this.f432539b.f432353f = r101;
        return;
    L6:
        if (CpuMetricsReporter.CPU_USER_TIME_S.equals(r100) == false) goto L9;
        this.f432539b.f432354g = r101;
        return;
    L9:
        if ("cpu_overload_multiple".equals(r100) == false) goto L14;
        this.f432539b.getClass();
        return;
    }

    @Override // com.facebook.battery.reporter.core.SystemMetricsReporter.Event
    public final void add(String r100, String r101) {
        if ("process_name".equals(r100) == false) goto L6;
        this.f432539b.f432355h = r101;
        return;
    }
}
