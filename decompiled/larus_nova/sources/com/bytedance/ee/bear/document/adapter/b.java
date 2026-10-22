package com.bytedance.ee.bear.document.adapter;

import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {
    public static final f a(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = a.f218708c;
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        a r102 = (a) r100.getHostAbilityOrNull(a.class);
        if (r102 != null) goto L7;
        r102 = new a(r100);
        r100.registerHostAbility(r102);
    L7:
        return new f(r102);
    }
}
