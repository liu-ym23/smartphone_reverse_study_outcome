package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.j;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class BitableListItemDrawTimeConsumer implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f215632c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f215633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f215634b;

    public static final class a {
        public static String a() {
            Intrinsics.checkNotNullParameter("OPEN_RECORD_CELL_LIST", "pointName");
            return "OPEN_RECORD_CELL_LIST_item_draw";
        }

        public static String b() {
            Intrinsics.checkNotNullParameter("OPEN_RECORD_CELL_LIST", "pointName");
            return "OPEN_RECORD_CELL_LIST_set_data";
        }
    }

    static {
    }

    public BitableListItemDrawTimeConsumer() {
        this.f215633a = LazyKt.lazy(new BitableListItemDrawTimeConsumer$setDataPointName$2(this));
        this.f215634b = LazyKt.lazy(new BitableListItemDrawTimeConsumer$itemDrawPointName$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Serializable, java.lang.Object[]] */
    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        if (Intrinsics.areEqual(r101.getName(), "OPEN_RECORD_CELL_LIST") == false) goto L6;
        BitableStatisticEventModel$NormalPointModel r103 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_RECORD_CELL_LIST", r101.getTimestamp(), false, 8);
        r103.addExtra("points", r102.toArray(new BitableStatisticEventModel$NormalPointModel[0]));
        return CollectionsKt.listOf(r103);
    L6:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> b(i r110, com.bytedance.ee.bear.bitable.statistic.e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        if (Intrinsics.areEqual(r112.getName(), "OPEN_RECORD_CELL_LIST") == false) goto L103;
        HashMap<String, Serializable> r114 = r112.getExtras();
        if (r114 == null) goto L7;
        Object r115 = (Serializable) r114.get("points");
    L8:
        BitableStatisticEventModel$NormalPointModel[] r116 = (BitableStatisticEventModel$NormalPointModel[]) r115;
        LinkedHashMap r100 = new LinkedHashMap();
        if (r116 == null) goto L52;
        int r101 = r116.length;
        int r102 = 0;
    L11:
        if (r102 >= r101) goto L52;
        BitableStatisticEventModel$NormalPointModel r103 = r116[r102];
        String r104 = r103.getName();
        if (Intrinsics.areEqual(r104, (String) this.f215633a.getValue()) == false) goto L32;
        HashMap<String, Serializable> r105 = r103.getExtras();
        if (r105 == null) goto L17;
        Serializable r106 = r105.get(BytedCertConstant.IntentKey.VIEW_TYPE);
    L18:
        String r107 = (String) r106;
        if (r107 == null) goto L50;
        HashMap<String, Serializable> r108 = r103.getExtras();
        if (r108 == null) goto L24;
        Serializable r109 = r108.get(HiAnalyticsConstant.BI_KEY_COST_TIME);
    L25:
        Integer r117 = (Integer) r109;
        if (r117 == null) goto L50;
        int r118 = r117.intValue();
        e r119 = (e) r100.get(r107);
        if (r119 != null) goto L30;
        r119 = new e();
    L30:
        r119.a(0, r118);
        r100.put(r107, r119);
        goto L50
    L24:
        r109 = null;
    L50:
        r102 = r102 + 1;
        goto L11
    L17:
        r106 = null;
        goto L18
    L32:
        if (Intrinsics.areEqual(r104, (String) this.f215634b.getValue()) == false) goto L50;
        HashMap<String, Serializable> r120 = r103.getExtras();
        if (r120 == null) goto L36;
        Serializable r121 = r120.get(BytedCertConstant.IntentKey.VIEW_TYPE);
    L37:
        String r122 = (String) r121;
        if (r122 == null) goto L50;
        HashMap<String, Serializable> r123 = r103.getExtras();
        if (r123 == null) goto L43;
        Serializable r124 = r123.get(HiAnalyticsConstant.BI_KEY_COST_TIME);
    L44:
        Integer r125 = (Integer) r124;
        if (r125 == null) goto L50;
        int r126 = r125.intValue();
        e r127 = (e) r100.get(r122);
        if (r127 != null) goto L49;
        r127 = new e();
    L49:
        r127.a(1, r126);
        r100.put(r122, r127);
        goto L50
    L43:
        r124 = null;
        goto L44
    L36:
        r121 = null;
    L52:
        if (r100.isEmpty() == true) goto L104;
        d r128 = new d();
        Iterator r129 = r100.entrySet().iterator();
    L56:
        if (r129.hasNext() == false) goto L84;
        Map.Entry r130 = (Map.Entry) r129.next();
        if (((e) r130.getValue()).f215647b[0] == 0) goto L83;
        if (((e) r130.getValue()).f215647b[1] == 0) goto L83;
        int r131 = 0;
    L63:
        if (r131 >= 2) goto L56;
        e r132 = (e) r130.getValue();
        int r133 = r132.f215647b[r131];
        if (r133 != 0) goto L67;
        Integer r134 = null;
    L68:
        if (r134 == null) goto L70;
        r128.f215643a[r131].put(r130.getKey(), Integer.valueOf(r134.intValue()));
    L70:
        int r135 = ((e) r130.getValue()).f215648c[r131];
        if (r135 != 0) goto L73;
        Integer r136 = null;
    L74:
        if (r136 == null) goto L76;
        r128.f215644b[r131].put(r130.getKey(), Integer.valueOf(r136.intValue()));
    L76:
        e r137 = (e) r130.getValue();
        int r138 = r137.f215650e[r131];
        if (r138 != 0) goto L79;
        Integer r139 = null;
    L80:
        if (r139 == null) goto L82;
        r128.f215645c[r131].put(r130.getKey(), Integer.valueOf(r139.intValue()));
    L82:
        r131 = r131 + 1;
        goto L63
    L79:
        r139 = Integer.valueOf((int) (r137.f215649d[r131] / ((long) r138)));
        goto L80
    L73:
        r136 = Integer.valueOf(r135);
        goto L74
    L67:
        r134 = Integer.valueOf((int) (r132.f215646a[r131] / ((long) r133)));
    L83:
        boolean r140 = true;
    L85:
        if (r140 == true) goto L105;
        r110.d(r111, "base_mobile_performance_record_cell", MapsKt.mapOf(new Pair[]{TuplesKt.to("set_data_avg", r128.f215643a[0]), TuplesKt.to("draw_avg", r128.f215643a[1]), TuplesKt.to("set_data_max", r128.f215644b[0]), TuplesKt.to("draw_max", r128.f215644b[1]), TuplesKt.to("set_data_10ms_avg", r128.f215645c[0]), TuplesKt.to("draw_10ms_avg", r128.f215645c[1])}));
        return CollectionsKt.listOf(r112);
    L105:
        return null;
    L84:
        r140 = false;
        goto L85
    L104:
        return null;
    L7:
        r115 = null;
        goto L8
    L103:
        return null;
    }
}
