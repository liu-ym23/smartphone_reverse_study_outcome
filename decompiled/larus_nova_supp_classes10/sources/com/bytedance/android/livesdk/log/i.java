package com.bytedance.android.livesdk.log;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class i implements qm0.b {
    public i() {
    }

    public final void sendLog(String r4, Map<String, String> r5, Object... r6) {
        Intrinsics.checkNotNullParameter(r6, "args");
        u.l().sendLog(r4, r5, new Object[]{r6});
    }
}
