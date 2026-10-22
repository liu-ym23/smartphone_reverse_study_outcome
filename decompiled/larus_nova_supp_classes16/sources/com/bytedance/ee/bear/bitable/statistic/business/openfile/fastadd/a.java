package com.bytedance.ee.bear.bitable.statistic.business.openfile.fastadd;

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
        switch(r0.hashCode()) {
            case -1474256725: goto L18;
            case -399085738: goto L15;
            case 225577840: goto L12;
            case 436549234: goto L9;
            case 525808394: goto L6;
            default: goto L23;
        };
    L6:
        if (r0.equals("BASE_ADD_RECORD_META_START") == false) goto L23;
    L20:
        d(r9, null, null);
        com.bytedance.ee.bear.bitable.statistic.common.a.n(this, r7, r8, r9, false, 24);
        return false;
    L9:
        if (r0.equals("BASE_ADD_RECORD_RETURN_META") == true) goto L20;
    L12:
        if (r0.equals("BASE_ADD_RECORD_GET_META") == true) goto L20;
    L15:
        if (r0.equals("BASE_ADD_RECORD_META_FAIL") == true) goto L20;
    L18:
        if (r0.equals("BASE_ADD_RECORD_META_SUCCESS") == true) goto L20;
    L23:
        return super.k(r7, r8, r9, r10);
    }
}
