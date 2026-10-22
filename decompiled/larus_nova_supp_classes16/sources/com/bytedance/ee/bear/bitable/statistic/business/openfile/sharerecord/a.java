package com.bytedance.ee.bear.bitable.statistic.business.openfile.sharerecord;

import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends tu4.a {
    public a() {
    }

    @Override // tu4.a, com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r7, e r8, BitableStatisticEventModel$NormalPointModel r9, List<BitableStatisticEventModel$NormalPointModel> r10) {
        Intrinsics.checkNotNullParameter(r7, "logger");
        Intrinsics.checkNotNullParameter(r8, "trace");
        Intrinsics.checkNotNullParameter(r9, "currPoint");
        Intrinsics.checkNotNullParameter(r10, "allPoints");
        String r0 = r9.getName();
        if (Intrinsics.areEqual(r0, "POINT_SHARE_RECORD_PREFETCH_BEGIN") == false) goto L5;
    L9:
        d(r9, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r7, r8, r9, false, 24);
        return false;
    L5:
        if (Intrinsics.areEqual(r0, "POINT_SHARE_RECORD_PREFETCH_END") == true) goto L9;
        return super.k(r7, r8, r9, r10);
    }
}
