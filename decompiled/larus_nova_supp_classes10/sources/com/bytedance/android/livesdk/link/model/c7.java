package com.bytedance.android.livesdk.link.model;

import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c7 {
    public static final String a(b7 r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$toSimpleString");
        StringBuilder r0 = new StringBuilder("MultiChannelInfo{");
        if (r2.getUseMultiChannel() == false) goto L5;
        String r1 = "";
    L6:
        r0.append(r1);
        r0.append("channels=");
        Map<Long, String> r3 = r2.getChannelMap();
        if (r3 == null) goto L9;
        Set<Long> r4 = r3.keySet();
    L10:
        r0.append(r4);
        r0.append('}');
        return r0.toString();
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = "useMultiChannel=false,";
        goto L6
    }
}
