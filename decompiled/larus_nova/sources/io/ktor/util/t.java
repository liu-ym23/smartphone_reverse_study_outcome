package io.ktor.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class t {
    public static final f a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new f(r100);
    }

    public static final char b(char r100) {
        boolean r101 = true;
        if ('A' <= r100) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L19;
        if (r100 >= 0) goto L12;
    L14:
        r101 = false;
    L15:
        if (r101 == false) goto L18;
        return r100;
    L18:
        return Character.toLowerCase(r100);
    L12:
        if (r100 >= 128) goto L14;
    L19:
        return (char) (r100 + ' ');
    L5:
        if (r100 >= '[') goto L7;
        r102 = true;
        goto L8
    }

    public static final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r101 = r100.length();
        int r102 = 0;
    L4:
        if (r102 >= r101) goto L12;
        char r103 = r100.charAt(r102);
        if (b(r103) == r103) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L13;
        r102 = r102 + 1;
    L13:
        if (r102 != (-1)) goto L15;
        return r100;
    L15:
        StringBuilder r105 = new StringBuilder(r100.length());
        r105.append(r100, 0, r102);
        int r106 = StringsKt.getLastIndex(r100);
        if (r102 > r106) goto L21;
    L17:
        r105.append(b(r100.charAt(r102)));
        if (r102 == r106) goto L21;
        r102 = r102 + 1;
    L21:
        return r105.toString();
    L8:
        r104 = false;
        goto L9
    L12:
        r102 = -1;
        goto L13
    }
}
