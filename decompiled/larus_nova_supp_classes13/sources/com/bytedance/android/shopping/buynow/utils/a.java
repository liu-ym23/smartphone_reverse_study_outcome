package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.android.ec.core.monitor.param.ECParamTrackerCenter;
import com.bytedance.android.ec.model.order.IOrderSchema;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final void a(String r1, final IOrderSchema r2) {
        Intrinsics.checkNotNullParameter(r1, "sessionId");
        com.bytedance.android.ec.core.monitor.param.a r3 = ECParamTrackerCenter.c(r1);
        if (r3 == null) goto L6;
        r3.b(new APTReportHelper$onBuyNowEnterPage$1(r2));
        return;
    }
}
