package com.bytedance.android.livesdk.livecommerce.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e extends u0 {
    public e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "dialogName");
        super("livesdk_" + r3 + "_dialog_show");
    }
}
