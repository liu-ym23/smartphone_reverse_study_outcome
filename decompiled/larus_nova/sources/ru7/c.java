package ru7;

import com.ss.texturerender.effect.AbsEffect;
import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class c {
    public static int b(char r100) {
        int r101 = r100 - 19968;
        if (r101 < 0) goto L8;
        if (r101 >= 7000) goto L8;
        return a(d.f539275a, d.f539276b, r101);
    L8:
        if (7000 > r101) goto L13;
        if (r101 >= 14000) goto L13;
        return a(e.f539277a, e.f539278b, r101 - 7000);
    L13:
        return a(f.f539279a, f.f539280b, r101 - AbsEffect.OPTION_EFFECT_FLOAT_SRCROPSIZEU);
    }

    public static String c(char r100) {
        if (19968 <= r100) goto L5;
    L8:
        if (12295 != r100) goto L10;
    L9:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L18;
        if (r100 != 12295) goto L16;
        return "LING";
    L16:
        return g.f539282b[b(r100)];
    L18:
        return String.valueOf(r100);
    L10:
        r101 = false;
        goto L11
    L5:
        if (r100 > 40869) goto L8;
        if (b(r100) > 0) goto L9;
        goto L8
    }

    public static String d(String r100) {
        int r101 = a.f539274a;
        if (r100 != null) goto L5;
        return r100;
    L5:
        if (r100.length() == 0) goto L20;
        StringBuffer r102 = new StringBuffer();
        int r103 = 0;
    L9:
        if (r103 >= r100.length()) goto L15;
        r102.append(c(r100.charAt(r103)));
        if (r103 == (r100.length() - 1)) goto L13;
        r102.append("");
    L13:
        r103 = r103 + 1;
        goto L9
    L15:
        return r102.toString();
    L20:
        return r100;
    }

    public static short a(byte[] r100, byte[] r101, int r102) {
        int r103 = r102 % 8;
        short r104 = (short) (r101[r102] & UByte.MAX_VALUE);
        if ((r100[r102 / 8] & g.f539281a[r103]) != 0) goto L5;
        return r104;
    L5:
        return (short) (r104 | 256);
    }
}
