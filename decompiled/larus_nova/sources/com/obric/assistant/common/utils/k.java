package com.obric.assistant.common.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class k {
    public static final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "str");
        boolean r101 = true;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        return "#";
    L9:
        char r103 = r100.charAt(0);
        if (19968 <= r103) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L26;
        String r105 = ru7.c.c(r103);     // Catch: Exception -> L30
        Intrinsics.checkNotNull(r105);     // Catch: Exception -> L30
        if (r105.length() > 0) goto L20;
        r101 = false;
    L20:
        if (r101 == true) goto L22;
        return "#";
    L22:
        if (Character.isLetter(r105.charAt(0)) == false) goto L34;
        return String.valueOf(Character.toUpperCase(r105.charAt(0)));
    L34:
        return "#";
    L37:
        return "#";
    L26:
        if (Character.isLetter(r103) == true) goto L35;
        Character.isDigit(r103);
        return "#";
    L35:
        return String.valueOf(Character.toUpperCase(r103));
    L12:
        if (r103 >= 40870) goto L14;
        r104 = true;
        goto L15
    L5:
        r102 = false;
        goto L7
    }

    public static final boolean b(String r100) {
        if (r100.length() != 1) goto L13;
        char r101 = r100.charAt(0);
        if ('A' <= r101) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r101 >= '[') goto L9;
        r102 = true;
        goto L10
    L13:
        return false;
    }
}
