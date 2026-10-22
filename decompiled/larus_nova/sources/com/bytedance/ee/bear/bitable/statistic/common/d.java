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

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f215627a = 0;

    static {
    }

    public static void a(n r100, i r101, BitableStatisticEventModel$NormalPointModel r102, String r103, Long r104) {
        Intrinsics.checkNotNullParameter(r100, "trace");
        Intrinsics.checkNotNullParameter(r101, "logger");
        Intrinsics.checkNotNullParameter(r102, "point");
        Intrinsics.checkNotNullParameter(r103, "reason");
        Map<String, ? extends Serializable> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("reason", r103), TuplesKt.to("point_name", r102.getName()), TuplesKt.to("point_type", r102.getType().getType())});
        if (r104 == null) goto L5;
        r105.put("duration", r104);
    L5:
        Unit r106 = Unit.INSTANCE;
        r101.d(r100, "base_mobile_performance_warning_point", r105);
    }
}
