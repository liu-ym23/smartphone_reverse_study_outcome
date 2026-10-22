package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class l {
    public static final y6 a(com.bytedance.android.livesdk.link.model.bridge.f r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$rtcLiveCoreDataEx");
        com.bytedance.android.livesdk.link.model.bridge.q1 r2 = r1.getRtcLiveCoreData();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (y6) r2.castTo(y6.class);
    }
}
