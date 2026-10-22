package uu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends com.bytedance.ee.bear.bitable.statistic.common.a {
    public int f;
    public int g;

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "BitableRecordViewConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_business_item_view_event";
    }

    public d() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final Pair<String, Serializable> g(BitableStatisticEventModel$NormalPointModel r3) {
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Long r4 = f(r3);
        if (r4 == null) goto L5;
        long r0 = r4.longValue();
    L7:
        return TuplesKt.to("duration", Long.valueOf(r0));
    L5:
        r0 = 0;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final Map<String, Serializable> h(BitableStatisticConstant$Result r2) {
        Intrinsics.checkNotNullParameter(r2, TipCallBackData.RESULT);
        return new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r2, BitableStatisticEventModel$NormalPointModel r3, List<BitableStatisticEventModel$NormalPointModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Intrinsics.checkNotNullParameter(r4, "allPoints");
        String r5 = r3.getName();
        if (Intrinsics.areEqual(r5, "RECORD_TEMP_POINT") == false) goto L6;
        this.f++;
        return null;
    L6:
        if (Intrinsics.areEqual(r5, "SWITCH_PAGE_TEMP_POINT") == false) goto L11;
        this.g++;
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r13, com.bytedance.ee.bear.bitable.statistic.e r14, BitableStatisticEventModel$NormalPointModel r16, List<BitableStatisticEventModel$NormalPointModel> r17) {
        Intrinsics.checkNotNullParameter(r13, "logger");
        Intrinsics.checkNotNullParameter(r14, "trace");
        Intrinsics.checkNotNullParameter(r16, "currPoint");
        Intrinsics.checkNotNullParameter(r17, "allPoints");
        String r0 = r16.getName();
        if (Intrinsics.areEqual(r0, BatterySceneData.OPT_START) == false) goto L7;
        d(r16, null, null);
        return false;
    L7:
        if (Intrinsics.areEqual(r0, BatterySceneData.OPT_END) == false) goto L14;
        d(r16, null, null);
        Long r1 = f(r16);
        if (r1 == null) goto L11;
        long r4 = r1.longValue();
    L12:
        l(r13, r14, r16, BitableStatisticConstant$Result.SUCCESS, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("edit_count", Integer.valueOf(this.f)), TuplesKt.to("switch_count", Integer.valueOf(this.g)), TuplesKt.to("duration_ms", Long.valueOf(r4))}), true);
        return true;
    L11:
        r4 = 0;
        goto L12
    L14:
        return false;
    }
}
