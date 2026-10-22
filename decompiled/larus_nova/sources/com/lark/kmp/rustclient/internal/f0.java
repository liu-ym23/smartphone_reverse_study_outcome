package com.lark.kmp.rustclient.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f0 {
    public static final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L25;
        int r102 = r100.length() - 1;
        int r103 = 0;
        boolean r104 = false;
    L8:
        if (r103 > r102) goto L24;
        if (r104 == true) goto L11;
        int r105 = r103;
    L13:
        if (Intrinsics.compare(r100.charAt(r105), 32) > 0) goto L15;
        boolean r106 = true;
    L16:
        if (r104 == false) goto L17;
        if (r106 == false) goto L24;
        r102 = r102 - 1;
        goto L8
    L17:
        if (r106 == false) goto L18;
        r103 = r103 + 1;
        goto L8
    L18:
        r104 = true;
        goto L8
    L15:
        r106 = false;
        goto L16
    L11:
        r105 = r102;
    L24:
        if (Intrinsics.areEqual(r100.subSequence(r103, r102 + 1).toString(), "0") == true) goto L25;
        return false;
    L25:
        return true;
    L5:
        r101 = false;
        goto L6
    }
}
