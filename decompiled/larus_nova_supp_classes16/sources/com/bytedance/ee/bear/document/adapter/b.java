package com.bytedance.ee.bear.document.adapter;

import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static final f a(ChameleonPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r1 = a.c;
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        a r3 = (a) r2.getHostAbilityOrNull(a.class);
        if (r3 != null) goto L7;
        r3 = new a(r2);
        r2.registerHostAbility(r3);
    L7:
        return new f(r3);
    }
}
