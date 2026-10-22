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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class c implements k {
    public long a;
    public int b;
    public boolean c;
    public final List<bv4.b> d;
    public final List<Long> e;
    public i f;
    public g g;
    public long h;
    public final HashMap<String, Serializable> i;

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void e() {
        Number r1 = 0;
        this.c = false;
        if (this.b <= 0) goto L112;
        HashMap r2 = new HashMap();
        r2.put("scene", f());
        r2.put("record_count", Integer.valueOf(this.b));
        bv4.b r3 = (bv4.b) CollectionsKt.firstOrNull(this.d);
        if (r3 == null) goto L7;
        int r4 = r3.d;
    L8:
        r2.put("num_of_cores", Integer.valueOf(r4));
        r2.put("monitor_total_time", Long.valueOf(((long) this.b) * this.h));
        List<bv4.b> r5 = this.d;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r5.iterator();
    L9:
        Double r8 = null;
        if (r7.hasNext() == false) goto L16;
        bv4.b r9 = (bv4.b) r7.next();
        if (r9 == null) goto L14;
        r8 = r9.b;
    L14:
        if (r8 == null) goto L9;
        r6.add(r8);
        goto L9
    L16:
        Number r10 = CollectionsKt.maxOrNull(r6);
        if (r10 != null) goto L19;
        r10 = r1;
    L19:
        List<bv4.b> r11 = this.d;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L21:
        if (r13.hasNext() == false) goto L28;
        bv4.b r14 = (bv4.b) r13.next();
        if (r14 == null) goto L25;
        Double r16 = r14.b;
    L26:
        if (r16 == null) goto L21;
        r12.add(r16);
        goto L21
    L25:
        r16 = null;
        goto L26
    L28:
        Number r17 = CollectionsKt.minOrNull(r12);
        if (r17 != null) goto L31;
        r17 = r1;
    L31:
        List<bv4.b> r18 = this.d;
        ArrayList r19 = new ArrayList();
        Iterator<T> r20 = r18.iterator();
    L33:
        if (r20.hasNext() == false) goto L40;
        bv4.b r21 = (bv4.b) r20.next();
        if (r21 == null) goto L37;
        Double r22 = r21.b;
    L38:
        if (r22 == null) goto L33;
        r19.add(r22);
        goto L33
    L37:
        r22 = null;
        goto L38
    L40:
        Number r23 = (Double) CollectionsKt.firstOrNull(r19);
        if (r23 != null) goto L43;
        r23 = r1;
    L43:
        List<bv4.b> r24 = this.d;
        ArrayList r26 = new ArrayList();
        Iterator<T> r27 = r24.iterator();
    L45:
        if (r27.hasNext() == false) goto L52;
        bv4.b r28 = (bv4.b) r27.next();
        if (r28 == null) goto L49;
        Double r29 = r28.b;
    L50:
        if (r29 == null) goto L45;
        r26.add(r29);
        goto L45
    L49:
        r29 = null;
        goto L50
    L52:
        Double r30 = (Double) CollectionsKt.lastOrNull(r26);
        if (r30 == null) goto L56;
        r1 = r30;
    L56:
        List<bv4.b> r31 = this.d;
        ArrayList r32 = new ArrayList();
        Iterator<T> r33 = r31.iterator();
    L58:
        if (r33.hasNext() == false) goto L65;
        bv4.b r34 = (bv4.b) r33.next();
        if (r34 == null) goto L62;
        Double r36 = r34.b;
    L63:
        if (r36 == null) goto L58;
        r32.add(r36);
        goto L58
    L62:
        r36 = null;
        goto L63
    L65:
        r2.put("total_cpu_usage_average", Double.valueOf(CollectionsKt.averageOfDouble(r32)));
        r2.put("total_cpu_usage_max", r10);
        r2.put("total_cpu_usage_start", r23);
        r2.put("total_cpu_usage_end", r1);
        r2.put("total_cpu_usage_max_minus_min", Double.valueOf(r10.doubleValue() - r17.doubleValue()));
        r2.put("total_cpu_usage_end_minus_start", Double.valueOf(r23.doubleValue() - r1.doubleValue()));
        r2.put("total_cpu_usage_max_minus_start", Double.valueOf(r10.doubleValue() - r23.doubleValue()));
        Long r37 = (Long) CollectionsKt.maxOrNull(this.e);
        long r38 = 0;
        if (r37 == null) goto L68;
        long r39 = r37.longValue();
    L69:
        Long r40 = (Long) CollectionsKt.minOrNull(this.e);
        if (r40 == null) goto L72;
        long r41 = r40.longValue();
    L73:
        Long r42 = (Long) CollectionsKt.firstOrNull(this.e);
        if (r42 == null) goto L76;
        long r43 = r42.longValue();
    L77:
        Long r44 = (Long) CollectionsKt.lastOrNull(this.e);
        if (r44 == null) goto L80;
        r38 = r44.longValue();
    L80:
        r2.put("memory_main_average", Double.valueOf(CollectionsKt.averageOfLong(this.e)));
        r2.put("memory_main_max", Long.valueOf(r39));
        r2.put("memory_main_start", Long.valueOf(r43));
        r2.put("memory_main_end", Long.valueOf(r38));
        double r46 = r39;
        r2.put("memory_main_max_minus_min", Double.valueOf(r46 - r41));
        double r47 = r43;
        r2.put("memory_main_end_minus_start", Double.valueOf(r47 - r38));
        r2.put("memory_main_max_minus_start", Double.valueOf(r46 - r47));
        r2.put("extra", this.i);
        tt5.a.h(g(), "onStopMonitor: " + r2);
        g r48 = this.g;
        if (r48 == null) goto L85;
        i r49 = this.f;
        if (r49 == null) goto L85;
        r49.d(r48, "base_power_log_monitor_event_dev", r2);
    L85:
        tt5.a.h(g(), "cancel");
        this.b = 0;
        this.c = false;
        ((CopyOnWriteArrayList) this.d).clear();
        ((CopyOnWriteArrayList) this.e).clear();
        return;
    L76:
        r43 = 0;
        goto L77
    L72:
        r41 = 0;
        goto L73
    L68:
        r39 = 0;
        goto L69
    L7:
        r4 = 0;
        goto L8
    }

    public abstract String f();

    public abstract String g();

    public c() {
        this.a = 60;
        this.d = new CopyOnWriteArrayList();
        this.e = new CopyOnWriteArrayList();
        HashMap<String, Serializable> r0 = new HashMap();
        r0.put("attach_table_count", 0);
        r0.put("total_attach_table_count", 0);
        this.i = r0;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void d() {
        tt5.a.h(g(), "onStartMonitor timeout: 60");
        e();
        this.b = 0;
        this.a = 60;
        this.c = true;
        ((CopyOnWriteArrayList) this.d).clear();
        ((CopyOnWriteArrayList) this.e).clear();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final boolean c() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void a(bv4.b r6, long r7) {
        if (this.c == false) goto L8;
        this.b++;
        ((CopyOnWriteArrayList) this.d).add(r6);
        ((CopyOnWriteArrayList) this.e).add(Long.valueOf(r7));
        this.h = 2;
        tt5.a.h(g(), "onProcessMonitor: " + this.b + ", cpuInfo: " + r6 + ", memoryInfo: " + r7);
        if (this.b < (this.a / 2)) goto L9;
        e();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.k
    public final void b(i r2, g r3) {
        Intrinsics.checkNotNullParameter(r2, "agent");
        Intrinsics.checkNotNullParameter(r3, "trace");
        this.f = r2;
        this.g = r3;
    }
}
