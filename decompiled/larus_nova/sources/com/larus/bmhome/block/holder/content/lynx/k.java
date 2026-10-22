package com.larus.bmhome.block.holder.content.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k {
    public static final boolean a(String r100, String r101, String r102, String r103) {
        if (r100 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == true) goto L20;
        if (r102 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == true) goto L20;
        if (Intrinsics.areEqual(r100, r102) == false) goto L20;
        boolean r106 = true;
    L21:
        if (r101 != null) goto L23;
    L26:
        boolean r107 = true;
    L27:
        if (r107 == true) goto L38;
        if (r103 != null) goto L30;
    L33:
        boolean r108 = true;
    L34:
        if (r108 == true) goto L38;
        if (Intrinsics.areEqual(r101, r103) == false) goto L38;
        boolean r109 = true;
    L39:
        if (r106 == true) goto L41;
        if (r109 == true) goto L41;
        return false;
    L41:
        return true;
    L30:
        if (r103.length() == 0) goto L33;
        r108 = false;
    L38:
        r109 = false;
        goto L39
    L23:
        if (r101.length() == 0) goto L26;
        r107 = false;
        goto L27
    L12:
        if (r102.length() == 0) goto L15;
        r105 = false;
    L20:
        r106 = false;
        goto L21
    L5:
        if (r100.length() == 0) goto L8;
        r104 = false;
        goto L9
    }
}
