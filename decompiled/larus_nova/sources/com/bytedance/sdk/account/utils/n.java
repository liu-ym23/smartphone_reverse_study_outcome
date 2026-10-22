package com.bytedance.sdk.account.utils;

import kotlin.UByte;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final boolean a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L10
    }

    public static /* synthetic */ String c(Object r100) {
        return b(r100, 4);
    }

    public static final String b(Object r100, int r101) {
        if (r100 == null) goto L32;
        if (Intrinsics.areEqual(r100, "") == true) goto L32;
        if ((r100 instanceof k) == true) goto L9;
        int r102 = 0;
        if ((r100 instanceof byte[]) == false) goto L17;
        byte[] r103 = (byte[]) r100;
        char[] r104 = e.f269542a;
        char[] r105 = new char[r103.length * 2];
        int r106 = r103.length;
        int r107 = 0;
    L13:
        if (r102 >= r106) goto L16;
        int r108 = r103[r102] & UByte.MAX_VALUE;
        int r109 = r107 + 1;
        char[] r110 = e.f269542a;
        r105[r107] = r110[r108 >> 4];
        r107 = r109 + 1;
        r105[r109] = r110[r108 & 15];
        r102 = r102 + 1;
        goto L13
    L16:
        return c(new String(r105));
    L17:
        String r111 = r100.toString();
        int r112 = r111.length();
        if (r112 <= r101) goto L20;
        int r113 = Math.min(r101, r112 / 3);
        int r114 = Math.max(r112 - r101, (r112 * 2) / 3);
        StringBuilder r115 = new StringBuilder(r112);
        int r116 = r111.length();
    L22:
        if (r102 >= r116) goto L30;
        if (r102 >= r113) goto L25;
        r115.append(r111.charAt(r102));
    L28:
        r102 = r102 + 1;
        goto L22
    L25:
        if (r102 >= r114) goto L27;
        r115.append('*');
        goto L28
    L27:
        r115.append(r111.charAt(r102));
        goto L28
    L30:
        return r115.toString();
    L20:
        return StringsKt.repeat("*", r112);
    L9:
        return b(((k) r100).f269548a, r101);
    L32:
        return String.valueOf(r100);
    }
}
