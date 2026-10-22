package lv7;

import kotlin.UByte;

/* JADX INFO: loaded from: classes23.dex */
public final class d {
    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        r101.append("0123456789abcdef".charAt(r104 / 16));
        r101.append("0123456789abcdef".charAt(r104 % 16));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }
}
