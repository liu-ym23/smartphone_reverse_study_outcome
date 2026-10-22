package com.bytedance.ee.bear.bitable.statistic.common;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.document.analytic.BatterySceneData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DefaultBitableStatisticPerformanceConsumer extends com.bytedance.ee.bear.bitable.statistic.common.a {
    public final String f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r2, BitableStatisticEventModel$NormalPointModel r3, List<BitableStatisticEventModel$NormalPointModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Intrinsics.checkNotNullParameter(r4, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return (String) this.g.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return this.f;
    }

    public DefaultBitableStatisticPerformanceConsumer(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        this.f = r2;
        this.g = LazyKt.lazy(new DefaultBitableStatisticPerformanceConsumer$tag$2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r12, com.bytedance.ee.bear.bitable.statistic.e r13, BitableStatisticEventModel$NormalPointModel r14, List<BitableStatisticEventModel$NormalPointModel> r16) {
        Intrinsics.checkNotNullParameter(r12, "logger");
        Intrinsics.checkNotNullParameter(r13, "trace");
        Intrinsics.checkNotNullParameter(r14, "currPoint");
        Intrinsics.checkNotNullParameter(r16, "allPoints");
        String r17 = r14.getName();
        if (Intrinsics.areEqual(r17, BatterySceneData.OPT_START) == false) goto L7;
        d(r14, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r12, r13, r14);
        return false;
    L7:
        if (Intrinsics.areEqual(r17, BatterySceneData.OPT_END) == false) goto L10;
        d(r14, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r12, r13, r14, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        return true;
    L10:
        d(r14, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r12, r13, r14, false, 24);
        return false;
    }
}
