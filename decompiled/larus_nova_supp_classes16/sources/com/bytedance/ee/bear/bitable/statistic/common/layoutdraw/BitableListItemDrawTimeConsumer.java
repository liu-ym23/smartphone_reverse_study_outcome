package com.bytedance.ee.bear.bitable.statistic.common.layoutdraw;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.j;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class BitableListItemDrawTimeConsumer implements j {
    public static final /* synthetic */ int c = 0;
    public final Lazy a;
    public final Lazy b;

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
        this.a = LazyKt.lazy(new BitableListItemDrawTimeConsumer$setDataPointName$2(this));
        this.b = LazyKt.lazy(new BitableListItemDrawTimeConsumer$itemDrawPointName$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.Serializable, java.lang.Object[]] */
    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r7, BitableStatisticEventModel$NormalPointModel r8, List<BitableStatisticEventModel$NormalPointModel> r9) {
        Intrinsics.checkNotNullParameter(r7, "trace");
        Intrinsics.checkNotNullParameter(r8, "currPoint");
        Intrinsics.checkNotNullParameter(r9, "allPoints");
        if (Intrinsics.areEqual(r8.getName(), "OPEN_RECORD_CELL_LIST") == false) goto L6;
        BitableStatisticEventModel$NormalPointModel r10 = BitableStatisticEventModel$NormalPointModel.a.c(BitableStatisticEventModel$NormalPointModel.Companion, "OPEN_RECORD_CELL_LIST", r8.getTimestamp(), false, 8);
        r10.addExtra("points", r9.toArray(new BitableStatisticEventModel$NormalPointModel[0]));
        return CollectionsKt.listOf(r10);
    L6:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> b(i r12, com.bytedance.ee.bear.bitable.statistic.e r13, BitableStatisticEventModel$NormalPointModel r14, List<BitableStatisticEventModel$NormalPointModel> r16) {
        Intrinsics.checkNotNullParameter(r12, "logger");
        Intrinsics.checkNotNullParameter(r13, "trace");
        Intrinsics.checkNotNullParameter(r14, "currPoint");
        Intrinsics.checkNotNullParameter(r16, "allPoints");
        if (Intrinsics.areEqual(r14.getName(), "OPEN_RECORD_CELL_LIST") == false) goto L103;
        HashMap<String, Serializable> r17 = r14.getExtras();
        if (r17 == null) goto L7;
        Object r18 = (Serializable) r17.get("points");
    L8:
        BitableStatisticEventModel$NormalPointModel[] r19 = (BitableStatisticEventModel$NormalPointModel[]) r18;
        LinkedHashMap r1 = new LinkedHashMap();
        if (r19 == null) goto L52;
        int r4 = r19.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L52;
        BitableStatisticEventModel$NormalPointModel r6 = r19[r5];
        String r7 = r6.getName();
        if (Intrinsics.areEqual(r7, (String) this.a.getValue()) == false) goto L32;
        HashMap<String, Serializable> r8 = r6.getExtras();
        if (r8 == null) goto L17;
        Serializable r9 = r8.get("view_type");
    L18:
        String r10 = (String) r9;
        if (r10 == null) goto L50;
        HashMap<String, Serializable> r11 = r6.getExtras();
        if (r11 == null) goto L24;
        Serializable r20 = r11.get("cost_time");
    L25:
        Integer r21 = (Integer) r20;
        if (r21 == null) goto L50;
        int r22 = r21.intValue();
        e r23 = (e) r1.get(r10);
        if (r23 != null) goto L30;
        r23 = new e();
    L30:
        r23.a(0, r22);
        r1.put(r10, r23);
        goto L50
    L24:
        r20 = null;
    L50:
        r5 = r5 + 1;
        goto L11
    L17:
        r9 = null;
        goto L18
    L32:
        if (Intrinsics.areEqual(r7, (String) this.b.getValue()) == false) goto L50;
        HashMap<String, Serializable> r24 = r6.getExtras();
        if (r24 == null) goto L36;
        Serializable r26 = r24.get("view_type");
    L37:
        String r27 = (String) r26;
        if (r27 == null) goto L50;
        HashMap<String, Serializable> r28 = r6.getExtras();
        if (r28 == null) goto L43;
        Serializable r29 = r28.get("cost_time");
    L44:
        Integer r30 = (Integer) r29;
        if (r30 == null) goto L50;
        int r31 = r30.intValue();
        e r32 = (e) r1.get(r27);
        if (r32 != null) goto L49;
        r32 = new e();
    L49:
        r32.a(1, r31);
        r1.put(r27, r32);
        goto L50
    L43:
        r29 = null;
        goto L44
    L36:
        r26 = null;
    L52:
        if (r1.isEmpty() == true) goto L104;
        d r110 = new d();
        Iterator r2 = r1.entrySet().iterator();
    L56:
        if (r2.hasNext() == false) goto L84;
        Map.Entry r33 = (Map.Entry) r2.next();
        if (((e) r33.getValue()).b[0] == 0) goto L83;
        if (((e) r33.getValue()).b[1] == 0) goto L83;
        int r34 = 0;
    L63:
        if (r34 >= 2) goto L56;
        e r36 = (e) r33.getValue();
        int r37 = r36.b[r34];
        if (r37 != 0) goto L67;
        Integer r38 = null;
    L68:
        if (r38 == null) goto L70;
        r110.a[r34].put(r33.getKey(), Integer.valueOf(r38.intValue()));
    L70:
        int r39 = ((e) r33.getValue()).c[r34];
        if (r39 != 0) goto L73;
        Integer r40 = null;
    L74:
        if (r40 == null) goto L76;
        r110.b[r34].put(r33.getKey(), Integer.valueOf(r40.intValue()));
    L76:
        e r41 = (e) r33.getValue();
        int r42 = r41.e[r34];
        if (r42 != 0) goto L79;
        Integer r43 = null;
    L80:
        if (r43 == null) goto L82;
        r110.c[r34].put(r33.getKey(), Integer.valueOf(r43.intValue()));
    L82:
        r34 = r34 + 1;
        goto L63
    L79:
        r43 = Integer.valueOf((int) (r41.d[r34] / ((long) r42)));
        goto L80
    L73:
        r40 = Integer.valueOf(r39);
        goto L74
    L67:
        r38 = Integer.valueOf((int) (r36.a[r34] / ((long) r37)));
    L83:
        boolean r3 = true;
    L85:
        if (r3 == true) goto L105;
        r12.d(r13, "base_mobile_performance_record_cell", MapsKt.mapOf(new Pair[]{TuplesKt.to("set_data_avg", r110.a[0]), TuplesKt.to("draw_avg", r110.a[1]), TuplesKt.to("set_data_max", r110.b[0]), TuplesKt.to("draw_max", r110.b[1]), TuplesKt.to("set_data_10ms_avg", r110.c[0]), TuplesKt.to("draw_10ms_avg", r110.c[1])}));
        return CollectionsKt.listOf(r14);
    L105:
        return null;
    L84:
        r3 = false;
        goto L85
    L104:
        return null;
    L7:
        r18 = null;
        goto L8
    L103:
        return null;
    }
}
