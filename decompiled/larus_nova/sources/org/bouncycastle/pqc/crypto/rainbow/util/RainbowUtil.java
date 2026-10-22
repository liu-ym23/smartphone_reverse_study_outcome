package org.bouncycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;
import kotlin.UByte;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowUtil {
    public RainbowUtil() {
    }

    public static byte[] convertArray(short[] r100) {
        byte[] r101 = new byte[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = (byte) r100[r102];
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static short[] convertArray(byte[] r100) {
        short[] r101 = new short[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = (short) (r100[r102] & UByte.MAX_VALUE);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static byte[][] convertArray(short[][] r100) {
        byte[][] r101 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r100.length, r100[0].length});
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        int r103 = 0;
    L7:
        if (r103 >= r100[0].length) goto L9;
        r101[r102][r103] = (byte) r100[r102][r103];
        r103 = r103 + 1;
        goto L7
    L9:
        r102 = r102 + 1;
        goto L4
    L10:
        return r101;
    }

    public static short[][] convertArray(byte[][] r100) {
        short[][] r101 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100.length, r100[0].length});
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        int r103 = 0;
    L7:
        if (r103 >= r100[0].length) goto L9;
        r101[r102][r103] = (short) (r100[r102][r103] & UByte.MAX_VALUE);
        r103 = r103 + 1;
        goto L7
    L9:
        r102 = r102 + 1;
        goto L4
    L10:
        return r101;
    }

    public static byte[][][] convertArray(short[][][] r100) {
        int r101 = r100.length;
        short[][] r102 = r100[0];
        byte[][][] r103 = (byte[][][]) Array.newInstance(Byte.TYPE, new int[]{r101, r102.length, r102[0].length});
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L14;
        int r105 = 0;
    L7:
        if (r105 >= r100[0].length) goto L13;
        int r106 = 0;
    L10:
        if (r106 >= r100[0][0].length) goto L12;
        r103[r104][r105][r106] = (byte) r100[r104][r105][r106];
        r106 = r106 + 1;
        goto L10
    L12:
        r105 = r105 + 1;
        goto L7
    L13:
        r104 = r104 + 1;
        goto L4
    L14:
        return r103;
    }

    public static short[][][] convertArray(byte[][][] r100) {
        int r101 = r100.length;
        byte[][] r102 = r100[0];
        short[][][] r103 = (short[][][]) Array.newInstance(Short.TYPE, new int[]{r101, r102.length, r102[0].length});
        int r104 = 0;
    L4:
        if (r104 >= r100.length) goto L14;
        int r105 = 0;
    L7:
        if (r105 >= r100[0].length) goto L13;
        int r106 = 0;
    L10:
        if (r106 >= r100[0][0].length) goto L12;
        r103[r104][r105][r106] = (short) (r100[r104][r105][r106] & UByte.MAX_VALUE);
        r106 = r106 + 1;
        goto L10
    L12:
        r105 = r105 + 1;
        goto L7
    L13:
        r104 = r104 + 1;
        goto L4
    L14:
        return r103;
    }

    public static int[] convertArraytoInt(byte[] r100) {
        int[] r101 = new int[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = r100[r102] & UByte.MAX_VALUE;
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static byte[] convertIntArray(int[] r100) {
        byte[] r101 = new byte[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = (byte) r100[r102];
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public static boolean equals(short[] r100, short[] r101) {
        if (r100.length == r101.length) goto L5;
        return false;
    L5:
        int r102 = r100.length - 1;
        boolean r103 = true;
    L6:
        if (r102 < 0) goto L12;
        if (r100[r102] != r101[r102]) goto L10;
        boolean r104 = true;
    L11:
        r103 = r103 & r104;
        r102 = r102 - 1;
        goto L6
    L10:
        r104 = false;
        goto L11
    L12:
        return r103;
    }

    public static boolean equals(short[][] r100, short[][] r101) {
        if (r100.length == r101.length) goto L6;
        return false;
    L6:
        boolean r102 = true;
        int r103 = r100.length - 1;
    L7:
        if (r103 < 0) goto L9;
        r102 = r102 & equals(r100[r103], r101[r103]);
        r103 = r103 - 1;
        goto L7
    L9:
        return r102;
    }

    public static boolean equals(short[][][] r100, short[][][] r101) {
        if (r100.length == r101.length) goto L6;
        return false;
    L6:
        boolean r102 = true;
        int r103 = r100.length - 1;
    L7:
        if (r103 < 0) goto L9;
        r102 = r102 & equals(r100[r103], r101[r103]);
        r103 = r103 - 1;
        goto L7
    L9:
        return r102;
    }
}
