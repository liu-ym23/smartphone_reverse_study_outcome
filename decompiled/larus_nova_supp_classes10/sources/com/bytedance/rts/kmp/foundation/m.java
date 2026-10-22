package com.bytedance.rts.kmp.foundation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    public static final int a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.length();
    }

    @RTSHiddenFromObjC
    public static final String b(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == true) goto L11;
        return "";
    L11:
        return String.valueOf(r2.charAt(r3));
    L5:
        if (r3 >= r2.length()) goto L7;
        r0 = true;
        goto L7
    }
}
