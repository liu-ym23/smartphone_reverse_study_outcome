package com.facebook.common.util;

import kotlin.UByte;

/* JADX INFO: loaded from: classes22.dex */
public class Hex {
    private static final byte[] DIGITS = null;
    private static final char[] FIRST_CHAR = null;
    private static final char[] HEX_DIGITS = null;
    private static final char[] SECOND_CHAR = null;

    public Hex() {
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        FIRST_CHAR = new char[256];
        SECOND_CHAR = new char[256];
        byte r100 = 0;
        int r101 = 0;
    L3:
        if (r101 >= 256) goto L5;
        char[] r102 = FIRST_CHAR;
        char[] r103 = HEX_DIGITS;
        r102[r101] = r103[(r101 >> 4) & 15];
        SECOND_CHAR[r101] = r103[r101 & 15];
        r101 = r101 + 1;
        goto L3
    L5:
        DIGITS = new byte[103];
        int r104 = 0;
    L7:
        if (r104 > 70) goto L9;
        DIGITS[r104] = -1;
        r104 = r104 + 1;
        goto L7
    L9:
        byte r105 = 0;
    L11:
        if (r105 >= 10) goto L14;
        DIGITS[r105 + 48] = r105;
        r105 = (byte) (r105 + 1);
    L14:
        if (r100 >= 6) goto L16;
        byte[] r106 = DIGITS;
        byte r107 = (byte) (r100 + 10);
        r106[r100 + 65] = r107;
        r106[r100 + 97] = r107;
        r100 = (byte) (r100 + 1);
        goto L14
    }

    public static String byte2Hex(int r100) {
        if (r100 > 255) goto L8;
        if (r100 < 0) goto L8;
        return String.valueOf(FIRST_CHAR[r100]) + String.valueOf(SECOND_CHAR[r100]);
    L8:
        throw new IllegalArgumentException("The int converting to hex should be in range 0~255");
    }

    public static byte[] decodeHex(String r110) {
        int r100 = r110.length();
        if ((r100 & 1) != 0) goto L24;
        byte[] r101 = new byte[r100 >> 1];
        boolean r102 = false;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r100) goto L19;
        int r105 = r103 + 1;
        char r106 = r110.charAt(r103);
        if (r106 > 'f') goto L8;
        byte[] r107 = DIGITS;
        byte r108 = r107[r106];
        if (r108 == (-1)) goto L8;
        int r111 = r105 + 1;
        char r109 = r110.charAt(r105);
        if (r109 > 'f') goto L8;
        byte r112 = r107[r109];
        if (r112 == (-1)) goto L8;
        r101[r104] = (byte) ((r108 << 4) | r112);
        r104 = r104 + 1;
        r103 = r111;
    L8:
        r102 = true;
    L19:
        if (r102 == true) goto L22;
        return r101;
    L22:
        throw new IllegalArgumentException("Invalid hexadecimal digit: ".concat(r110));
    L24:
        throw new IllegalArgumentException("Odd number of characters.");
    }

    public static byte[] hexStringToByteArray(String r100) {
        return decodeHex(r100.replaceAll(" ", ""));
    }

    public static String encodeHex(byte[] r100, boolean r101) {
        char[] r102 = new char[r100.length * 2];
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= r100.length) goto L11;
        int r105 = r100[r103] & UByte.MAX_VALUE;
        if (r105 != 0) goto L9;
        if (r101 == true) goto L11;
    L9:
        int r106 = r104 + 1;
        r102[r104] = FIRST_CHAR[r105];
        r104 = r106 + 1;
        r102[r106] = SECOND_CHAR[r105];
        r103 = r103 + 1;
    L11:
        return new String(r102, 0, r104);
    }
}
