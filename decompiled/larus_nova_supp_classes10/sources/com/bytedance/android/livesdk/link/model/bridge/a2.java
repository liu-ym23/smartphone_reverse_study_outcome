package com.bytedance.android.livesdk.link.model.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a2 {
    public static final String a(z1 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$simpleString");
        return "PreRTCUser{" + r2.getLinkmicIdStr() + ": push=" + r2.getRtcPushStream() + ",status=" + r2.getLinkStatus() + '}';
    }
}
