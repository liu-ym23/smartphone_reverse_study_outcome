package com.bytedance.ee.bear.bitable.statistic.common;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointType;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a implements j {
    public final HashMap<String, Serializable> a;
    public final HashMap<String, Serializable> b;
    public final HashMap<String, Serializable> c;
    public List<String> d;
    public boolean e;

    public List<String> e() {
        return null;
    }

    public abstract String i();

    public String j() {
        return BatterySceneData.OPT_START;
    }

    public abstract boolean k(i r1, com.bytedance.ee.bear.bitable.statistic.e r2, BitableStatisticEventModel$NormalPointModel r3, List<BitableStatisticEventModel$NormalPointModel> r4);

    public void p() {
        this.a.clear();
        List<String> r0 = e();
        if (r0 == null) goto L5;
        List<String> r1 = CollectionsKt.toMutableList(r0);
    L6:
        this.d = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public a() {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public final Long f(BitableStatisticEventModel$NormalPointModel r6) {
        Intrinsics.checkNotNullParameter(r6, "currPoint");
        Serializable r0 = this.a.get(j());
        if ((r0 instanceof Long) == true) goto L7;
        int r7 = e.a;
        e.c(getTag(), "calPointCostTime startTime invalid " + r0);
        return null;
    L7:
        return Long.valueOf(r6.getTimestamp() - ((Number) r0).longValue());
    }

    public Pair<String, Serializable> g(BitableStatisticEventModel$NormalPointModel r3) {
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Long r4 = f(r3);
        if (r4 != null) goto L7;
        return null;
    L7:
        return TuplesKt.to("cost_time", Long.valueOf(r4.longValue()));
    }

    public Map<String, Serializable> h(BitableStatisticConstant$Result r5) {
        Intrinsics.checkNotNullParameter(r5, TipCallBackData.RESULT);
        int r6 = e.a;
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("stage", BatterySceneData.OPT_END), TuplesKt.to(TipCallBackData.RESULT, r5.getValue()), TuplesKt.to("main_stage_timestamp_list", this.a), TuplesKt.to("main_stage_duration_list", e.b(this.a, j()))});
    }

    public final void a(String r2, Serializable r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (r3 != null) goto L5;
        this.c.remove(r2);
        return;
    L5:
        this.c.put(r2, r3);
    }

    public final void d(BitableStatisticEventModel$NormalPointModel r4, String r5, Serializable r6) {
        Intrinsics.checkNotNullParameter(r4, "currPoint");
        HashMap<String, Serializable> r0 = this.a;
        if (r5 != null) goto L5;
        r5 = r4.getName();
    L5:
        if (r6 != null) goto L7;
        r6 = Long.valueOf(r4.getTimestamp());
    L7:
        r0.put(r5, r6);
    }

    public static void o(a r4, i r5, com.bytedance.ee.bear.bitable.statistic.e r6, BitableStatisticEventModel$NormalPointModel r7) {
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "logger");
        Intrinsics.checkNotNullParameter(r6, "trace");
        Intrinsics.checkNotNullParameter(r7, "currPoint");
        String r0 = r4.i();
        Map<String, ? extends Serializable> r1 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("stage", BatterySceneData.OPT_START), TuplesKt.to("time", Long.valueOf(r7.getTimestamp()))});
        r1.putAll(r4.b);
        Map<? extends String, ? extends Object> r8 = r7.getExtras();
        if (r8 != null) goto L6;
        r8 = MapsKt.emptyMap();
    L6:
        r1.putAll(r8);
        Unit r9 = Unit.INSTANCE;
        r5.d(r6, r0, r1);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> b(i r9, com.bytedance.ee.bear.bitable.statistic.e r10, BitableStatisticEventModel$NormalPointModel r11, List<BitableStatisticEventModel$NormalPointModel> r12) {
        Intrinsics.checkNotNullParameter(r9, "logger");
        Intrinsics.checkNotNullParameter(r10, "trace");
        Intrinsics.checkNotNullParameter(r11, "currPoint");
        Intrinsics.checkNotNullParameter(r12, "allPoints");
        if (this.e == false) goto L6;
        int r0 = e.a;
        tt5.a.h("BitableStatistic", getTag() + ' ' + ("consume end. " + r11.getName()));
        return null;
    L6:
        List<String> r1 = this.d;
        if (r1 == null) goto L10;
        r1.remove(r11.getName());
    L10:
        if (r11.getType() != BitableStatisticEventModel$NormalPointType.INIT_POINT) goto L12;
        p();
    L12:
        boolean r2 = k(r9, r10, r11, r12);
        if (r11.getType() != BitableStatisticEventModel$NormalPointType.END_POINT) goto L15;
        r10.b(Boolean.FALSE);
    L15:
        List<String> r5 = this.d;
        if (r5 == null) goto L20;
        boolean r6 = true;
        if (r5.isEmpty() != true) goto L20;
    L21:
        if (r6 == false) goto L24;
        m(this, r9, r10, r11, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        return r12;
    L24:
        if (r2 == false) goto L26;
        return r12;
    L26:
        return null;
    L20:
        r6 = false;
        goto L21
    }

    public static void n(a r4, i r5, com.bytedance.ee.bear.bitable.statistic.e r6, BitableStatisticEventModel$NormalPointModel r7, boolean r8, int r9) {
        if ((r9 & 16) == 0) goto L5;
        r8 = false;
    L5:
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "logger");
        Intrinsics.checkNotNullParameter(r6, "trace");
        Intrinsics.checkNotNullParameter(r7, "currPoint");
        String r10 = r4.i();
        HashMap r0 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("stage", r7.getName()), TuplesKt.to("time", Long.valueOf(r7.getTimestamp()))});
        Long r1 = r4.f(r7);
        if (r1 == null) goto L8;
        r0.put("cost_time", r1);
    L8:
        r0.putAll(r4.b);
        if (r8 == true) goto L15;
        Map r11 = r7.getExtras();
        if (r11 != null) goto L14;
        r11 = MapsKt.emptyMap();
    L14:
        r0.putAll(r11);
    L15:
        Unit r12 = Unit.INSTANCE;
        r5.d(r6, r10, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(i r4, com.bytedance.ee.bear.bitable.statistic.e r5, BitableStatisticEventModel$NormalPointModel r6, BitableStatisticConstant$Result r7, String r8, Map<String, ? extends Serializable> r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r4, "logger");
        Intrinsics.checkNotNullParameter(r5, "trace");
        Intrinsics.checkNotNullParameter(r6, "currPoint");
        Intrinsics.checkNotNullParameter(r7, TipCallBackData.RESULT);
        this.e = true;
        String r0 = i();
        Map<String, Serializable> r11 = h(r7);
        Pair<String, Serializable> r1 = g(r6);
        if (r1 == null) goto L5;
        r11.put(r1.getFirst(), r1.getSecond());
    L5:
        if (r8 == null) goto L7;
        r11.put("reason", r8);
    L7:
        r11.putAll(this.b);
        r11.putAll(this.c);
        if (r10 == true) goto L14;
        Map r12 = r6.getExtras();
        if (r12 != null) goto L13;
        r12 = MapsKt.emptyMap();
    L13:
        r11.putAll(r12);
    L14:
        if (r9 == null) goto L16;
        r11.putAll(r9);
    L16:
        Unit r13 = Unit.INSTANCE;
        r4.d(r5, r0, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(a r10, i r11, com.bytedance.ee.bear.bitable.statistic.e r12, BitableStatisticEventModel$NormalPointModel r13, BitableStatisticConstant$Result r14, String r16, Map r17, int r18) {
        if ((r18 & 16) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r18 & 32) == 0) goto L9;
        Map r8 = null;
    L10:
        r10.l(r11, r12, r13, r14, r7, r8, false);
        return;
    L9:
        r8 = r17;
        goto L10
    L5:
        r7 = r16;
        goto L7
    }
}
