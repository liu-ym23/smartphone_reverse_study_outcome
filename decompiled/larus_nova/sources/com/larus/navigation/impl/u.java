package com.larus.navigation.impl;

import com.larus.bmhome.share.panel.ShareChannel;
import com.larus.navigation.api.y;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class u {
    public static final c37.d a(y r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r100 = r110.f359722d;
        Integer r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.toLowerCase(Locale.ROOT);
    L7:
        if (Intrinsics.areEqual(r102, ShareChannel.DOUYIN) == false) goto L11;
        r101 = 3;
    L14:
        return new c37.d(r110.f359719a, r110.f359720b, r110.f359721c, r101, r110.f359723e);
    L11:
        if (Intrinsics.areEqual(r102, "baidu") == false) goto L14;
        r101 = 2;
        goto L14
    L5:
        r102 = null;
        goto L7
    }
}
