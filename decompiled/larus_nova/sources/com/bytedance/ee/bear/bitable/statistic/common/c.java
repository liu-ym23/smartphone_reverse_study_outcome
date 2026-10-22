package com.bytedance.ee.bear.bitable.statistic.common;

import com.bytedance.ee.bear.bitable.statistic.g;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class c implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f215618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f215619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f215620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<bv4.b> f215621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Long> f215622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f215623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g f215624g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f215625h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final HashMap<String, Serializable> f215626i;

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void e() {
        Number r100 = 0;
        this.f215620c = false;
        if (this.f215619b <= 0) goto L112;
        HashMap r101 = new HashMap();
        r101.put("scene", f());
        r101.put("record_count", Integer.valueOf(this.f215619b));
        bv4.b r102 = (bv4.b) CollectionsKt.firstOrNull(this.f215621d);
        if (r102 == null) goto L7;
        int r103 = r102.f20836d;
    L8:
        r101.put("num_of_cores", Integer.valueOf(r103));
        r101.put("monitor_total_time", Long.valueOf(((long) this.f215619b) * this.f215625h));
        List<bv4.b> r104 = this.f215621d;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L9:
        Double r107 = null;
        if (r106.hasNext() == false) goto L16;
        bv4.b r108 = (bv4.b) r106.next();
        if (r108 == null) goto L14;
        r107 = r108.f20834b;
    L14:
        if (r107 == null) goto L9;
        r105.add(r107);
        goto L9
    L16:
        Number r109 = CollectionsKt.m9876maxOrNull(r105);
        if (r109 != null) goto L19;
        r109 = r100;
    L19:
        List<bv4.b> r110 = this.f215621d;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L21:
        if (r112.hasNext() == false) goto L28;
        bv4.b r113 = (bv4.b) r112.next();
        if (r113 == null) goto L25;
        Double r114 = r113.f20834b;
    L26:
        if (r114 == null) goto L21;
        r111.add(r114);
        goto L21
    L25:
        r114 = null;
        goto L26
    L28:
        Number r115 = CollectionsKt.m9878minOrNull(r111);
        if (r115 != null) goto L31;
        r115 = r100;
    L31:
        List<bv4.b> r116 = this.f215621d;
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L33:
        if (r118.hasNext() == false) goto L40;
        bv4.b r119 = (bv4.b) r118.next();
        if (r119 == null) goto L37;
        Double r120 = r119.f20834b;
    L38:
        if (r120 == null) goto L33;
        r117.add(r120);
        goto L33
    L37:
        r120 = null;
        goto L38
    L40:
        Number r121 = (Double) CollectionsKt.firstOrNull(r117);
        if (r121 != null) goto L43;
        r121 = r100;
    L43:
        List<bv4.b> r122 = this.f215621d;
        ArrayList r123 = new ArrayList();
        Iterator<T> r124 = r122.iterator();
    L45:
        if (r124.hasNext() == false) goto L52;
        bv4.b r125 = (bv4.b) r124.next();
        if (r125 == null) goto L49;
        Double r126 = r125.f20834b;
    L50:
        if (r126 == null) goto L45;
        r123.add(r126);
        goto L45
    L49:
        r126 = null;
        goto L50
    L52:
        Double r127 = (Double) CollectionsKt.lastOrNull(r123);
        if (r127 == null) goto L56;
        r100 = r127;
    L56:
        List<bv4.b> r128 = this.f215621d;
        ArrayList r129 = new ArrayList();
        Iterator<T> r130 = r128.iterator();
    L58:
        if (r130.hasNext() == false) goto L65;
        bv4.b r131 = (bv4.b) r130.next();
        if (r131 == null) goto L62;
        Double r132 = r131.f20834b;
    L63:
        if (r132 == null) goto L58;
        r129.add(r132);
        goto L58
    L62:
        r132 = null;
        goto L63
    L65:
        r101.put("total_cpu_usage_average", Double.valueOf(CollectionsKt.averageOfDouble(r129)));
        r101.put("total_cpu_usage_max", r109);
        r101.put("total_cpu_usage_start", r121);
        r101.put("total_cpu_usage_end", r100);
        r101.put("total_cpu_usage_max_minus_min", Double.valueOf(r109.doubleValue() - r115.doubleValue()));
        r101.put("total_cpu_usage_end_minus_start", Double.valueOf(r121.doubleValue() - r100.doubleValue()));
        r101.put("total_cpu_usage_max_minus_start", Double.valueOf(r109.doubleValue() - r121.doubleValue()));
        Long r133 = (Long) CollectionsKt.maxOrNull(this.f215622e);
        long r134 = 0;
        if (r133 == null) goto L68;
        long r135 = r133.longValue();
    L69:
        Long r136 = (Long) CollectionsKt.minOrNull(this.f215622e);
        if (r136 == null) goto L72;
        long r137 = r136.longValue();
    L73:
        Long r138 = (Long) CollectionsKt.firstOrNull(this.f215622e);
        if (r138 == null) goto L76;
        long r139 = r138.longValue();
    L77:
        Long r140 = (Long) CollectionsKt.lastOrNull(this.f215622e);
        if (r140 == null) goto L80;
        r134 = r140.longValue();
    L80:
        r101.put("memory_main_average", Double.valueOf(CollectionsKt.averageOfLong(this.f215622e)));
        r101.put("memory_main_max", Long.valueOf(r135));
        r101.put("memory_main_start", Long.valueOf(r139));
        r101.put("memory_main_end", Long.valueOf(r134));
        double r141 = r135;
        r101.put("memory_main_max_minus_min", Double.valueOf(r141 - r137));
        double r142 = r139;
        r101.put("memory_main_end_minus_start", Double.valueOf(r142 - r134));
        r101.put("memory_main_max_minus_start", Double.valueOf(r141 - r142));
        r101.put("extra", this.f215626i);
        tt5.a.h(g(), "onStopMonitor: " + r101);
        g r143 = this.f215624g;
        if (r143 == null) goto L85;
        i r144 = this.f215623f;
        if (r144 == null) goto L85;
        r144.d(r143, "base_power_log_monitor_event_dev", r101);
    L85:
        tt5.a.h(g(), "cancel");
        this.f215619b = 0;
        this.f215620c = false;
        ((CopyOnWriteArrayList) this.f215621d).clear();
        ((CopyOnWriteArrayList) this.f215622e).clear();
        return;
    L76:
        r139 = 0;
        goto L77
    L72:
        r137 = 0;
        goto L73
    L68:
        r135 = 0;
        goto L69
    L7:
        r103 = 0;
        goto L8
    }

    public abstract String f();

    public abstract String g();

    public c() {
        this.f215618a = 60;
        this.f215621d = new CopyOnWriteArrayList();
        this.f215622e = new CopyOnWriteArrayList();
        HashMap<String, Serializable> r100 = new HashMap();
        r100.put("attach_table_count", 0);
        r100.put("total_attach_table_count", 0);
        this.f215626i = r100;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void d() {
        tt5.a.h(g(), "onStartMonitor timeout: 60");
        e();
        this.f215619b = 0;
        this.f215618a = 60;
        this.f215620c = true;
        ((CopyOnWriteArrayList) this.f215621d).clear();
        ((CopyOnWriteArrayList) this.f215622e).clear();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final boolean c() {
        return this.f215620c;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void a(bv4.b r100, long r101) {
        if (this.f215620c == false) goto L8;
        this.f215619b++;
        ((CopyOnWriteArrayList) this.f215621d).add(r100);
        ((CopyOnWriteArrayList) this.f215622e).add(Long.valueOf(r101));
        this.f215625h = 2;
        tt5.a.h(g(), "onProcessMonitor: " + this.f215619b + ", cpuInfo: " + r100 + ", memoryInfo: " + r101);
        if (this.f215619b < (this.f215618a / 2)) goto L9;
        e();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void b(i r100, g r101) {
        Intrinsics.checkNotNullParameter(r100, "agent");
        Intrinsics.checkNotNullParameter(r101, "trace");
        this.f215623f = r100;
        this.f215624g = r101;
    }
}
