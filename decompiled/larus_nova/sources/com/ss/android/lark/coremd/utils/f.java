package com.ss.android.lark.coremd.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f {
    static {
    }

    public static int a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "str");
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r102 >= r100.length()) goto L7;
        if (r103 >= r101) goto L7;
        r102 = r102 + Character.charCount(r100.codePointAt(r102));
        r103 = r103 + 1;
    L7:
        if (r103 == r101) goto L13;
        return -1;
    L13:
        return r102;
    }
}
