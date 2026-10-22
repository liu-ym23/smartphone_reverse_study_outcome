package com.bytedance.android.shopping.orderlist.common.utils;

import com.bytedance.android.ec.base.api.ai.IECAIHostService;
import com.bytedance.android.ec.host.api.service.IECHostService;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public static final b a(IECHostService r5, OrderAppletPageScene r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        Boolean r0 = null;
        if (r5 == null) goto L5;
        IECAIHostService r7 = r5.getECHostAIService();
    L7:
        if (r7 == null) goto L9;
        r0 = Boolean.valueOf(r7.isInApplet());
    L9:
        int r8 = d.a[r6.ordinal()];
        boolean r2 = false;
        if (r8 != 1) goto L12;
        if (r7 != null) goto L21;
    L24:
        return new b(r0, r2);
    L21:
        if (r7.isLandingPage() != true) goto L24;
    L22:
        r2 = true;
        goto L24
    L12:
        if (r8 != 2) goto L18;
        if (r7 == null) goto L24;
        if (r7.isGoToLandingPage() != true) goto L24;
    L18:
        throw new NoWhenBranchMatchedException();
    L5:
        r7 = null;
        goto L7
    }
}
