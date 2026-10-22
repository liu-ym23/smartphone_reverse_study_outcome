package com.bytedance.android.livesdk.link.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class r5 {
    public static final b7 a(q5 r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$multiChannelInfoEx");
        com.bytedance.android.livesdk.link.model.bridge.s1 r2 = r1.getMultiChannelInfo();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (b7) r2.castTo(b7.class);
    }
}
