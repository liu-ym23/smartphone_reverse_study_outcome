package com.bytedance.ee.bear.bitable.statistic.common;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Debug;
import com.bytedance.ee.bear.bitable.statistic.h;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.inner.BitableFpsTracer;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class b implements h {
    public long a;
    public double b;
    public final HashMap<String, Serializable> c;
    public final HashMap<String, Serializable> d;

    public abstract boolean b();

    public boolean c() {
        return this instanceof com.bytedance.ee.bear.bitable.infoarch.nativeview.performance.c;
    }

    public abstract String e();

    public abstract String f();

    public b() {
        HashMap<String, Serializable> r0 = new HashMap();
        r0.put("is_on_demand", Boolean.FALSE);
        this.c = r0;
        HashMap<String, Serializable> r1 = new HashMap();
        r1.put("attach_table_count", 0);
        r1.put("total_attach_table_count", 0);
        this.d = r1;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.h
    public final void a(i r3, BitableFpsTracer r4, double r5, long r7) {
        Intrinsics.checkNotNullParameter(r3, "agent");
        Intrinsics.checkNotNullParameter(r4, "trace");
        if (c() == false) goto L6;
        this.b += r5 * r7;
        this.a += r7;
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.h
    public final boolean d(i r16, BitableFpsTracer r17, HashMap r18, HashMap r19, HashMap r20, boolean r21, com.bytedance.ee.bear.bitable.statistic.a r22) {
        Intrinsics.checkNotNullParameter(r16, "agent");
        Intrinsics.checkNotNullParameter(r17, "trace");
        Intrinsics.checkNotNullParameter(r18, "dropFrames");
        Intrinsics.checkNotNullParameter(r19, "dropStateRatio");
        Intrinsics.checkNotNullParameter(r20, "dropDurRatio");
        Intrinsics.checkNotNullParameter(r22, "eventContext");
        if (((Boolean) BitableStatisticConstant$Debug.b.getValue()).booleanValue() == true) goto L5;
        if (r21 == true) goto L5;
    L7:
        if (r18.isEmpty() == false) goto L10;
        return false;
    L10:
        if (b() == false) goto L13;
        if (r21 == true) goto L13;
        return false;
    L13:
        Float r8 = (Float) r20.get("hitch_dur_ratio");
        if (r8 == null) goto L16;
        float r9 = r8.floatValue();
    L17:
        Map<String, ? extends Serializable> r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", e()), TuplesKt.to("drop_frame", r18), TuplesKt.to("drop_state_ratio", r19), TuplesKt.to("drop_dur_ratio", r20), TuplesKt.to("hitch_dur_ratio", Float.valueOf(r9)), TuplesKt.to("device_max_refresh_rate", Integer.valueOf(r22.a)), TuplesKt.to("refresh_rate", Integer.valueOf(r22.b))});
        r3.putAll(this.c);
        r3.put("extra", this.d);
        Unit r10 = Unit.INSTANCE;
        r16.d(r17, "base_mobile_performance_drop_frame_info", r3);
        if (c() == false) goto L22;
        double r4 = this.b;
        long r11 = this.a;
        double r5 = r4 / r11;
        this.a = 0;
        this.b = 0.0d;
        tt5.a.h(f(), "totalFPS: " + r5 + ", duration: " + r11 + ", scene: " + e());
        Map<String, ? extends Serializable> r6 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("scene", e()), TuplesKt.to("fps", Double.valueOf(r5)), TuplesKt.to("device_max_refresh_rate", Integer.valueOf(r22.a)), TuplesKt.to("refresh_rate", Integer.valueOf(r22.b))});
        r6.putAll(this.c);
        r6.put("extra", this.d);
        r16.d(r17, "base_mobile_performance_fps_info", r6);
        return true;
    L22:
        return true;
    L16:
        r9 = 0.0f;
    L5:
        int r12 = e.a;
        tt5.a.h("BitableStatistic", f() + ' ' + ("isForceStop:" + r21));
        goto L7
    }
}
