package com.bytedance.ee.bear.bitable.infoarch.nativeview.performance;

import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.h;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.inner.BitableFpsTracer;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements j, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f213682a;

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "ViewLifecycleConsumer";
    }

    public e() {
        this.f213682a = new b();
    }

    public final void e(d r100) {
        Intrinsics.checkNotNullParameter(r100, "renderPoint");
        d r101 = this.f213682a.f213671u;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "point");
        r101.f213674a += r100.f213674a;
        r101.f213675b += r100.f213675b;
        r101.f213676c += r100.f213676c;
        r101.f213677d += r100.f213677d;
        r101.f213678e += r100.f213678e;
        r101.f213679f += r100.f213679f;
        r101.f213680g += r100.f213680g;
        r101.f213681h += r100.f213681h;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.h
    public final void a(i r100, BitableFpsTracer r101, double r102, long r103) {
        Intrinsics.checkNotNullParameter(r100, "agent");
        Intrinsics.checkNotNullParameter(r101, "trace");
        b r104 = this.f213682a;
        r104.f213668r += r102 * r103;
        r104.f213667q += r103;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> b(i r110, com.bytedance.ee.bear.bitable.statistic.e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        HashMap<String, Serializable> r100 = r112.getExtras();
        if (r100 == null) goto L38;
        r100.put("clickGroup", Integer.valueOf(this.f213682a.f213654d));
        r100.put("clickHierarchyRecord", Integer.valueOf(this.f213682a.f213655e));
        r100.put("visitRow", Integer.valueOf(this.f213682a.f213656f));
        r100.put("visitCol", Integer.valueOf(this.f213682a.f213657g));
        r100.put("recordLoadingTimes", Integer.valueOf(this.f213682a.f213659i));
        r100.put(GestureAction.longPress, Integer.valueOf(this.f213682a.f213658h));
        r100.put("bridge", this.f213682a.f213663m);
        HashMap r101 = new HashMap();
        b r102 = this.f213682a;
        r101.put("averageFPS", Double.valueOf(r102.f213668r / r102.f213667q));
        r101.put("duration", Double.valueOf(this.f213682a.f213667q));
        r100.put("fps", r101);
        r100.put("dropFrameMap", this.f213682a.f213664n);
        r100.put("dropFrameState", this.f213682a.f213665o);
        r100.put("dropDurRatio", this.f213682a.f213666p);
        HashMap<String, Float> r103 = this.f213682a.f213666p;
        boolean r104 = false;
        if (r103 == null) goto L8;
        Float r105 = r103.get("hitch_dur_ratio");
        if (r105 == null) goto L8;
    L9:
        r100.put("hitch_dur_ratio", r105);
        d r106 = this.f213682a.f213671u;
        r106.getClass();
        HashMap r107 = new HashMap();
        long r108 = r106.f213674a;
        int r109 = r106.f213675b;
        String r114 = null;
        if (r109 != 0) goto L12;
        Integer r115 = null;
    L13:
        r107.put("measure_avg", r115);
        long r116 = r106.f213676c;
        int r117 = r106.f213677d;
        if (r117 != 0) goto L16;
        Integer r118 = null;
    L17:
        r107.put("layout_avg", r118);
        long r119 = r106.f213678e;
        int r120 = r106.f213679f;
        if (r120 != 0) goto L20;
        Integer r121 = null;
    L21:
        r107.put("draw_avg", r121);
        long r122 = r106.f213680g;
        int r123 = r106.f213681h;
        if (r123 != 0) goto L24;
        Integer r124 = null;
    L25:
        r107.put("set_data_avg", r124);
        r107.put("set_data_times", Integer.valueOf(r106.f213681h));
        r107.put("render_times", Integer.valueOf(r106.f213679f));
        r100.put("recordRender", r107);
        r100.put("is_on_demand", Boolean.valueOf(this.f213682a.f213662l));
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("ccm.bitable.native_view_trace_grid_horizontal_scroll") == false) goto L38;
        b r125 = this.f213682a;
        r101.put("horizontalAverageFPS", Double.valueOf(r125.f213670t / r125.f213669s));
        r101.put("horizontalDuration", Double.valueOf(this.f213682a.f213669s));
        b r126 = this.f213682a;
        double r127 = r126.f213668r + r126.f213670t;
        double r128 = r126.f213667q + r126.f213669s;
        r101.put("gridAverageFPS", Double.valueOf(r127 / r128));
        r101.put("gridDuration", Double.valueOf(r128));
        Serializable r129 = r100.get("reportScene");
        if ((r129 instanceof String) == false) goto L30;
        r114 = (String) r129;
    L30:
        if (r114 != null) goto L32;
    L34:
        if (r104 == false) goto L36;
        r100.put("stayTime", Long.valueOf(System.currentTimeMillis() - this.f213682a.f213651a));
    L36:
        r100.put("isFirstView", String.valueOf(this.f213682a.f213660j));
        r100.put("isFirstSubView", String.valueOf(this.f213682a.f213661k));
        HashMap r130 = new HashMap();
        r130.put("firstShow", Double.valueOf(this.f213682a.f213651a));
        r130.put("firstMove", Double.valueOf(this.f213682a.f213652b));
        r130.put("firstRebuild", Double.valueOf(this.f213682a.f213653c));
        r100.put("focusStage", r130);
        goto L38
    L32:
        if (r114.contentEquals("nativeDestroy") != true) goto L34;
        r104 = true;
        goto L34
    L24:
        r124 = Integer.valueOf((int) (r122 / ((long) r123)));
        goto L25
    L20:
        r121 = Integer.valueOf((int) (r119 / ((long) r120)));
        goto L21
    L16:
        r118 = Integer.valueOf((int) (r116 / ((long) r117)));
        goto L17
    L12:
        r115 = Integer.valueOf((int) (r108 / ((long) r109)));
    L8:
        r105 = 0;
    L38:
        if (this.f213682a.f213672v <= 0) goto L47;
        HashMap r131 = new HashMap();
        HashMap<String, Serializable> r132 = r112.getExtras();
        if (r132 == null) goto L44;
        Serializable r133 = r132.get("schemaVersion");
        if (r133 == null) goto L44;
        r131.put("schema_version", r133);
    L44:
        r131.put(BytedCertConstant.IntentKey.VIEW_TYPE, GXViewKey.VIEW_TYPE_CONTAINER_GRID);
        r110.d(r111, "ccm_bitable_row_expand_mobile_record_limit_view", r131);
        HashMap<String, Serializable> r134 = r112.getExtras();
        if (r134 == null) goto L47;
        Serializable r135 = r134.put("showLimitRecordFooter", Integer.valueOf(this.f213682a.f213672v));
    L47:
        String r136 = r112.getName();
        Map<String, ? extends Serializable> r137 = r112.getExtras();
        Intrinsics.checkNotNull(r137, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, java.io.Serializable>");
        r110.d(r111, r136, r137);
        return r113;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.h
    public final boolean d(i r100, BitableFpsTracer r101, HashMap r102, HashMap r103, HashMap r104, boolean r105, com.bytedance.ee.bear.bitable.statistic.a r106) {
        Intrinsics.checkNotNullParameter(r100, "agent");
        Intrinsics.checkNotNullParameter(r101, "trace");
        Intrinsics.checkNotNullParameter(r102, "dropFrames");
        Intrinsics.checkNotNullParameter(r103, "dropStateRatio");
        Intrinsics.checkNotNullParameter(r104, "dropDurRatio");
        Intrinsics.checkNotNullParameter(r106, "eventContext");
        b r107 = this.f213682a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r107.f213664n = r102;
        b r108 = this.f213682a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r108.f213665o = r103;
        b r109 = this.f213682a;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r109.f213666p = r104;
        return false;
    }
}
