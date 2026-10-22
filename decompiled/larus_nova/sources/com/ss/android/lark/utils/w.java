package com.ss.android.lark.utils;

import android.text.InputFilter;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
public final class w implements InputFilter {

    public static final class a {
    }

    static {
    }

    @JvmStatic
    public static final CharSequence b(CharSequence r110) {
        if (r110 == null) goto L23;
        int r100 = Math.max(0, 0);
        String r101 = (String) r110;
        int r102 = r101.length();
        int r103 = 0;
    L4:
        if (r100 >= r102) goto L30;
        int r104 = r100 + 1;
        char r105 = r101.charAt(r100);
        int r106 = 2;
        if (Character.isHighSurrogate(r105) == false) goto L11;
        if (r104 >= r102) goto L11;
        char r107 = r101.charAt(r104);
        if (Character.isLowSurrogate(r107) == false) goto L11;
        r104 = r104 + 1;
        int r108 = Character.toCodePoint(r105, r107);
        int r109 = 2;
        int r111 = r108;
    L13:
        if (r111 >= 2048) goto L16;
        r106 = 1;
    L16:
        r103 = r103 + r106;
        if (r103 == 18) goto L28;
        if (r103 == 19) goto L29;
        r100 = r104;
        goto L4
    L29:
        return r101.subSequence(0, r104 - r109);
    L28:
        return r101.subSequence(0, r104);
    L11:
        r109 = 1;
        r111 = r105;
        goto L13
    L30:
        return r110;
    L23:
        return null;
    }

    @JvmStatic
    public static final int a(CharSequence r100, int r101) {
        int r102 = 0;
        if (r101 < 0) goto L20;
        String r103 = (String) r100;
        if (r103.length() <= 0) goto L20;
        int r104 = Math.max(0, 0);
        int r105 = Math.min(r101, r103.length());
    L8:
        if (r104 >= r105) goto L20;
        int r106 = r104 + 1;
        char r107 = r103.charAt(r104);
        boolean r108 = Character.isHighSurrogate(r107);
        int r109 = r107;
        r109 = r107;
        if (r108 == false) goto L16;
        if (r106 >= r105) goto L16;
        char r110 = r103.charAt(r106);
        r109 = r107;
        if (Character.isLowSurrogate(r110) == false) goto L16;
        r106 = r106 + 1;
        r109 = Character.toCodePoint(r107, r110);
    L16:
        if (r109 < 2048) goto L18;
        int r111 = 2;
    L19:
        r102 = r102 + r111;
        r104 = r106;
        goto L8
    L18:
        r111 = 1;
    L20:
        return r102;
    }
}
