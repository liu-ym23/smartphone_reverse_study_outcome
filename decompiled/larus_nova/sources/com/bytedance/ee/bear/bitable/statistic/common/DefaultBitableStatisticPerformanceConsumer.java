package com.bytedance.ee.bear.bitable.statistic.common;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticConstant$Result;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DefaultBitableStatisticPerformanceConsumer extends com.bytedance.ee.bear.bitable.statistic.common.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f215607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f215608g;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(com.bytedance.ee.bear.bitable.statistic.e r100, BitableStatisticEventModel$NormalPointModel r101, List<BitableStatisticEventModel$NormalPointModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "currPoint");
        Intrinsics.checkNotNullParameter(r102, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return (String) this.f215608g.getValue();
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return this.f215607f;
    }

    public DefaultBitableStatisticPerformanceConsumer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f215607f = r100;
        this.f215608g = LazyKt.lazy(new DefaultBitableStatisticPerformanceConsumer$tag$2(this));
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r110, com.bytedance.ee.bear.bitable.statistic.e r111, BitableStatisticEventModel$NormalPointModel r112, List<BitableStatisticEventModel$NormalPointModel> r113) {
        Intrinsics.checkNotNullParameter(r110, "logger");
        Intrinsics.checkNotNullParameter(r111, "trace");
        Intrinsics.checkNotNullParameter(r112, "currPoint");
        Intrinsics.checkNotNullParameter(r113, "allPoints");
        String r114 = r112.getName();
        if (Intrinsics.areEqual(r114, "start") == false) goto L7;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.o(this, r110, r111, r112);
        return false;
    L7:
        if (Intrinsics.areEqual(r114, "end") == false) goto L10;
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.m(this, r110, r111, r112, BitableStatisticConstant$Result.SUCCESS, null, null, 112);
        return true;
    L10:
        d(r112, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r110, r111, r112, false, 24);
        return false;
    }
}
