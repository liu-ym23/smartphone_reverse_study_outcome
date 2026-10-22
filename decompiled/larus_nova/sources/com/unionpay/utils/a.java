package com.unionpay.utils;

import kotlin.UByte;

/* JADX INFO: loaded from: classes41.dex */
public final class a {
    public static String a(byte[] r100) {
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        int r104 = r100[r103] & UByte.MAX_VALUE;
        r101.append("0123456789abcdef".charAt(r104 >> 4));
        r101.append("0123456789abcdef".charAt(r104 & 15));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static byte[] b(String r100) {
        char[] r101 = r100.toCharArray();
        int r102 = r101.length / 2;
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L8;
        int r105 = r104 * 2;
        int r106 = Character.digit(r101[r105 + 1], 16) | (Character.digit(r101[r105], 16) << 4);
        if (r106 <= 127) goto L7;
        r106 = r106 - 256;
    L7:
        r103[r104] = (byte) r106;
        r104 = r104 + 1;
        goto L3
    L8:
        return r103;
    }
}
