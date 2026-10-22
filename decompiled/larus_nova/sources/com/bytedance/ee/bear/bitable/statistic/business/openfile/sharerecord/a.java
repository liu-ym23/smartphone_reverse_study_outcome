package com.bytedance.ee.bear.bitable.statistic.business.openfile.sharerecord;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a extends tu4.a {
    public a() {
    }

    @Override // tu4.a, com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r100, e r101, BitableStatisticEventModel$NormalPointModel r102, List<BitableStatisticEventModel$NormalPointModel> r110) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, "trace");
        Intrinsics.checkNotNullParameter(r102, "currPoint");
        Intrinsics.checkNotNullParameter(r110, "allPoints");
        String r103 = r102.getName();
        if (Intrinsics.areEqual(r103, "POINT_SHARE_RECORD_PREFETCH_BEGIN") == false) goto L5;
    L9:
        d(r102, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r100, r101, r102, false, 24);
        return false;
    L5:
        if (Intrinsics.areEqual(r103, "POINT_SHARE_RECORD_PREFETCH_END") == true) goto L9;
        return super.k(r100, r101, r102, r110);
    }
}
