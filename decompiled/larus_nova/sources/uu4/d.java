package uu4;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends com.bytedance.ee.bear.bitable.statistic.common.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f551744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f551745g;

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
    public final Pair<String, Serializable> g(BitableStatisticEventModel$NormalPointModel r100) {
        Intrinsics.checkNotNullParameter(r100, "currPoint");
        Long r101 = f(r100);
        if (r101 == null) goto L5;
        long r102 = r101.longValue();
    L7:
        return TuplesKt.to("duration", Long.valueOf(r102));
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final Map<String, Serializable> h(BitableStatisticConstant$Result r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        return new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        String r103 = r101.getName();
        if (Intrinsics.areEqual(r103, "RECORD_TEMP_POINT") == false) goto L6;
        this.f551744f++;
        return null;
    L6:
        if (Intrinsics.areEqual(r103, "SWITCH_PAGE_TEMP_POINT") == false) goto L11;
        this.f551745g++;
        return null;
    L11:
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r110, com.bytedance.ee.bear.bitable.statistic.e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r100 = r112.getName();
        if (Intrinsics.areEqual(r100, "start") == false) goto L7;
        d(r112, null, null);
        return false;
    L7:
        if (Intrinsics.areEqual(r100, "end") == false) goto L14;
        d(r112, null, null);
        Long r101 = f(r112);
        if (r101 == null) goto L11;
        long r102 = r101.longValue();
    L12:
        l(r110, r111, r112, BitableStatisticConstant$Result.SUCCESS, null, MapsKt.mapOf(new Pair[]{TuplesKt.to("edit_count", Integer.valueOf(this.f551744f)), TuplesKt.to("switch_count", Integer.valueOf(this.f551745g)), TuplesKt.to("duration_ms", Long.valueOf(r102))}), true);
        return true;
    L11:
        r102 = 0;
        goto L12
    L14:
        return false;
    }
}
