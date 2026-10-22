package com.larus.bmhome.taskskill.service;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j implements InputFilter {

    public static final class a {
    }

    static {
    }

    public j() {
    }

    public static int a(CharSequence r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r101 >= r102) goto L20;
        char r104 = r100.charAt(r101);
        int r105 = 1;
        if (Character.isHighSurrogate(r104) == false) goto L11;
        int r106 = r101 + 1;
        if (r106 >= r102) goto L11;
        if (Character.isLowSurrogate(r100.charAt(r106)) == false) goto L11;
        boolean r107 = true;
    L13:
        if (r104 > 127) goto L15;
        int r108 = 1;
    L16:
        r103 = r103 + r108;
        if (r107 == false) goto L19;
        r105 = 2;
    L19:
        r101 = r101 + r105;
        goto L3
    L15:
        r108 = 2;
    L11:
        r107 = false;
        goto L13
    L20:
        return r103;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r110) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r103, "dest");
        int r105 = (40 - a(r103, 0, r104)) - a(r103, r110, r103.length());
        if (r105 > 0) goto L6;
        return "";
    L6:
        int r106 = r101;
    L7:
        if (r106 >= r102) goto L21;
        char r111 = r100.charAt(r106);
        int r107 = 2;
        if (Character.isHighSurrogate(r111) == false) goto L15;
        int r108 = r106 + 1;
        if (r108 >= r102) goto L15;
        if (Character.isLowSurrogate(r100.charAt(r108)) == false) goto L15;
        int r109 = 2;
    L17:
        if (r111 > 127) goto L19;
        r107 = 1;
    L19:
        if (r107 > r105) goto L21;
        r105 = r105 - r107;
        r106 = r106 + r109;
    L15:
        r109 = 1;
    L21:
        if (r106 != r102) goto L24;
        return null;
    L24:
        return r100.subSequence(r101, r106);
    }
}
