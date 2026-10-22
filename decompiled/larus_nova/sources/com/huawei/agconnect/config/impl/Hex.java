package com.huawei.agconnect.config.impl;

/* JADX INFO: loaded from: classes23.dex */
public class Hex {
    private static final char[] HEX_CODE = null;

    static {
        HEX_CODE = "0123456789ABCDEF".toCharArray();
    }

    public Hex() {
    }

    private static byte[] decodeHex(char[] r100) {
        if ((r100.length & 1) != 0) goto L18;
        byte[] r101 = new byte[r100.length >> 1];
        int r102 = 0;
        int r103 = 0;
    L6:
        if (r102 >= r100.length) goto L16;
        int r104 = Character.digit(r100[r102], 16);
        if (r104 == (-1)) goto L15;
        int r105 = r102 + 1;
        int r106 = Character.digit(r100[r105], 16);
        if (r106 == (-1)) goto L13;
        r102 = r105 + 1;
        r101[r103] = (byte) (((r104 << 4) | r106) & 255);
        r103 = r103 + 1;
        goto L6
    L13:
        throw new IllegalArgumentException("Illegal hexadecimal character at index " + r105);
    L15:
        throw new IllegalArgumentException("Illegal hexadecimal character at index " + r102);
    L16:
        return r101;
    L18:
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static byte[] decodeHexString(String r100) {
        return decodeHex(r100.toCharArray());
    }

    public static String encodeHexString(byte[] r100) {
        StringBuilder r101 = new StringBuilder(r100.length * 2);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        byte r104 = r100[r103];
        char[] r105 = HEX_CODE;
        r101.append(r105[(r104 >> 4) & 15]);
        r101.append(r105[r104 & 15]);
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }
}
