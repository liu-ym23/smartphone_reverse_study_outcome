package com.larus.im.internal;

import com.larus.im.internal.protocol.bean.MixedTokens;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class v {
    public static final boolean a(TokenHolder r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        String r101 = r100.getTokenV1();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L26;
        MixedTokens r103 = r100.getTokenV2();
        IntRange r104 = com.larus.im.internal.database.utils.j.f348165a;
        if (r103 == null) goto L24;
        String r105 = r103.sseToken;
        if (r105 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == true) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == true) goto L26;
        return false;
    L18:
        if (StringsKt.isBlank(r105) == true) goto L21;
        r106 = false;
    L24:
        r107 = false;
    L26:
        return true;
    L8:
        if (StringsKt.isBlank(r101) == true) goto L11;
        r102 = false;
        goto L12
    }
}
