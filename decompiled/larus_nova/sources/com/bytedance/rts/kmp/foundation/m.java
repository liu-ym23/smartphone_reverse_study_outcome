package com.bytedance.rts.kmp.foundation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class m {
    public static final int a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.length();
    }

    @RTSHiddenFromObjC
    public static final String b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = false;
        if (r101 >= 0) goto L5;
    L7:
        if (r102 == true) goto L11;
        return "";
    L11:
        return String.valueOf(r100.charAt(r101));
    L5:
        if (r101 >= r100.length()) goto L7;
        r102 = true;
        goto L7
    }
}
