package com.bytedance.ee.bear.bitable.statistic.common;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointType;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
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

/* JADX INFO: loaded from: classes16.dex */
public abstract class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Serializable> f215609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, Serializable> f215610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, Serializable> f215611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f215612d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f215613e;

    public List<String> e() {
        return null;
    }

    public abstract String i();

    public String j() {
        return "start";
    }

    public abstract boolean k(i r100, com.bytedance.ee.bear.bitable.statistic.e r101, BitableStatisticEventModel$NormalPointModel r102, List<BitableStatisticEventModel$NormalPointModel> r103);

    public void p() {
        this.f215609a.clear();
        List<String> r100 = e();
        if (r100 == null) goto L5;
        List<String> r101 = CollectionsKt.toMutableList(r100);
    L6:
        this.f215612d = r101;
        return;
    L5:
        r101 = null;
        goto L6
    }

    public a() {
        this.f215609a = new HashMap();
        this.f215610b = new HashMap();
        this.f215611c = new HashMap();
    }

    public final Long f(BitableStatisticEventModel$NormalPointModel r100) {
        Intrinsics.checkNotNullParameter(r100, "currPoint");
        Serializable r101 = this.f215609a.get(j());
        if ((r101 instanceof Long) == true) goto L7;
        int r102 = e.f215628a;
        e.c(getTag(), "calPointCostTime startTime invalid " + r101);
        return null;
    L7:
        return Long.valueOf(r100.getTimestamp() - ((Number) r101).longValue());
    }

    public Pair<String, Serializable> g(BitableStatisticEventModel$NormalPointModel r100) {
        Intrinsics.checkNotNullParameter(r100, "currPoint");
        Long r101 = f(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return TuplesKt.to(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r101.longValue()));
    }

    public Map<String, Serializable> h(BitableStatisticConstant$Result r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        int r101 = e.f215628a;
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("stage", "end"), TuplesKt.to("result", r100.getValue()), TuplesKt.to("main_stage_timestamp_list", this.f215609a), TuplesKt.to("main_stage_duration_list", e.b(this.f215609a, j()))});
    }

    public final void a(String r100, Serializable r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
        this.f215611c.remove(r100);
        return;
    L5:
        this.f215611c.put(r100, r101);
    }

    public final void d(BitableStatisticEventModel$NormalPointModel r100, String r101, Serializable r102) {
        Intrinsics.checkNotNullParameter(r100, "currPoint");
        HashMap<String, Serializable> r103 = this.f215609a;
        if (r101 != null) goto L5;
        r101 = r100.getName();
    L5:
        if (r102 != null) goto L7;
        r102 = Long.valueOf(r100.getTimestamp());
    L7:
        r103.put(r101, r102);
    }

    public static void o(a r100, i r101, com.bytedance.ee.bear.bitable.statistic.e r102, BitableStatisticEventModel$NormalPointModel r103) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "trace");
        Intrinsics.checkNotNullParameter(r103, "currPoint");
        String r104 = r100.i();
        Map<String, ? extends Serializable> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("stage", "start"), TuplesKt.to("time", Long.valueOf(r103.getTimestamp()))});
        r105.putAll(r100.f215610b);
        Map<? extends String, ? extends Object> r106 = r103.getExtras();
        if (r106 != null) goto L6;
        r106 = MapsKt.emptyMap();
    L6:
        r105.putAll(r106);
        Unit r107 = Unit.INSTANCE;
        r101.d(r102, r104, r105);
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> b(i r100, com.bytedance.ee.bear.bitable.statistic.e r110, BitableStatisticEventModel$NormalPointModel r111, List<BitableStatisticEventModel$NormalPointModel> r112) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r110, "trace");
        Intrinsics.checkNotNullParameter(r111, "currPoint");
        Intrinsics.checkNotNullParameter(r112, "allPoints");
        if (this.f215613e == false) goto L6;
        int r101 = e.f215628a;
        tt5.a.h("BitableStatistic", getTag() + ' ' + ("consume end. " + r111.getName()));
        return null;
    L6:
        List<String> r102 = this.f215612d;
        if (r102 == null) goto L10;
        r102.remove(r111.getName());
    L10:
        if (r111.getType() != BitableStatisticEventModel$NormalPointType.INIT_POINT) goto L12;
        p();
    L12:
        boolean r103 = k(r100, r110, r111, r112);
        if (r111.getType() != BitableStatisticEventModel$NormalPointType.END_POINT) goto L15;
        r110.b(Boolean.FALSE);
    L15:
        List<String> r104 = this.f215612d;
        if (r104 == null) goto L20;
        boolean r105 = true;
        if (r104.isEmpty() != true) goto L20;
    L21:
        if (r105 == false) goto L24;
        m(this, r100, r110, r111, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        return r112;
    L24:
        if (r103 == false) goto L26;
        return r112;
    L26:
        return null;
    L20:
        r105 = false;
        goto L21
    }

    public static void n(a r100, i r101, com.bytedance.ee.bear.bitable.statistic.e r102, BitableStatisticEventModel$NormalPointModel r103, boolean r104, int r105) {
        if ((r105 & 16) == 0) goto L5;
        r104 = false;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "trace");
        Intrinsics.checkNotNullParameter(r103, "currPoint");
        String r106 = r100.i();
        HashMap r107 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("stage", r103.getName()), TuplesKt.to("time", Long.valueOf(r103.getTimestamp()))});
        Long r108 = r100.f(r103);
        if (r108 == null) goto L8;
        r107.put(HiAnalyticsConstant.BI_KEY_COST_TIME, r108);
    L8:
        r107.putAll(r100.f215610b);
        if (r104 == true) goto L15;
        Map r109 = r103.getExtras();
        if (r109 != null) goto L14;
        r109 = MapsKt.emptyMap();
    L14:
        r107.putAll(r109);
    L15:
        Unit r110 = Unit.INSTANCE;
        r101.d(r102, r106, r107);
    }

    public final void l(i r100, com.bytedance.ee.bear.bitable.statistic.e r101, BitableStatisticEventModel$NormalPointModel r102, BitableStatisticConstant$Result r103, String r104, Map<String, ? extends Serializable> r105, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, "trace");
        Intrinsics.checkNotNullParameter(r102, "currPoint");
        Intrinsics.checkNotNullParameter(r103, "result");
        this.f215613e = true;
        String r106 = i();
        Map<String, Serializable> r107 = h(r103);
        Pair<String, Serializable> r108 = g(r102);
        if (r108 == null) goto L5;
        r107.put(r108.getFirst(), r108.getSecond());
    L5:
        if (r104 == null) goto L7;
        r107.put("reason", r104);
    L7:
        r107.putAll(this.f215610b);
        r107.putAll(this.f215611c);
        if (r110 == true) goto L14;
        Map<? extends String, ? extends Serializable> r109 = r102.getExtras();
        if (r109 != null) goto L13;
        r109 = MapsKt.emptyMap();
    L13:
        r107.putAll(r109);
    L14:
        if (r105 == null) goto L16;
        r107.putAll(r105);
    L16:
        Unit r111 = Unit.INSTANCE;
        r100.d(r101, r106, r107);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void m(a r110, i r111, com.bytedance.ee.bear.bitable.statistic.e r112, BitableStatisticEventModel$NormalPointModel r113, BitableStatisticConstant$Result r114, String r115, Map r116, int r117) {
        if ((r117 & 16) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r117 & 32) == 0) goto L9;
        Map r101 = null;
    L10:
        r110.l(r111, r112, r113, r114, r100, r101, false);
        return;
    L9:
        r101 = r116;
        goto L10
    L5:
        r100 = r115;
        goto L7
    }
}
