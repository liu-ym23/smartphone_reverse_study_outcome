package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class p9 {
    public static final x6 a(o9 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiAnchorExtraEx");
        com.bytedance.android.livesdk.link.model.bridge.n1 r2 = r1.getMultiAnchorExtra();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (x6) r2.castTo(x6.class);
    }

    public static final boolean b(o9 r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$isSwitchChannel");
        if (r4.getToLinkerId() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
