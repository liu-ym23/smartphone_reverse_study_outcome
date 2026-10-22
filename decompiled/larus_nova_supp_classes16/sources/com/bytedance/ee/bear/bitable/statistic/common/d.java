package com.bytedance.ee.bear.bitable.statistic.common;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.bitable.statistic.n;
import java.io.Serializable;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(n r3, i r4, BitableStatisticEventModel$NormalPointModel r5, String r6, Long r7) {
        Intrinsics.checkNotNullParameter(r3, "trace");
        Intrinsics.checkNotNullParameter(r4, "logger");
        Intrinsics.checkNotNullParameter(r5, "point");
        Intrinsics.checkNotNullParameter(r6, "reason");
        Map<String, ? extends Serializable> r8 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("reason", r6), TuplesKt.to("point_name", r5.getName()), TuplesKt.to("point_type", r5.getType().getType())});
        if (r7 == null) goto L5;
        r8.put("duration", r7);
    L5:
        Unit r9 = Unit.INSTANCE;
        r4.d(r3, "base_mobile_performance_warning_point", r8);
    }
}
