package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class g {
    public static final char[] a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length();
        char[] r102 = new char[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = r100.charAt(r103);
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }
}
