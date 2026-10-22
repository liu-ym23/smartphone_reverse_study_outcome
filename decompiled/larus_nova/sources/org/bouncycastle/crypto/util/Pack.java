package org.bouncycastle.crypto.util;

import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Pack {
    public Pack() {
    }

    public static int bigEndianToInt(byte[] r100, int r101) {
        int r102 = r100[r101] << 24;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 16);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 8);
        return (r100[r105 + 1] & UByte.MAX_VALUE) | r106;
    }

    public static void bigEndianToInt(byte[] r100, int r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L6;
        r102[r103] = bigEndianToInt(r100, r101);
        r101 = r101 + 4;
        r103 = r103 + 1;
        goto L4
    }

    public static long bigEndianToLong(byte[] r100, int r101) {
        int r102 = bigEndianToInt(r100, r101);
        int r103 = bigEndianToInt(r100, r101 + 4);
        long r104 = (((long) r102) & BodyPartID.bodyIdMax) << 32;
        return (((long) r103) & BodyPartID.bodyIdMax) | r104;
    }

    public static void bigEndianToLong(byte[] r100, int r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L6;
        r102[r103] = bigEndianToLong(r100, r101);
        r101 = r101 + 8;
        r103 = r103 + 1;
        goto L4
    }

    public static void intToBigEndian(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) (r100 >>> 24);
        int r103 = r102 + 1;
        r101[r103] = (byte) (r100 >>> 16);
        int r104 = r103 + 1;
        r101[r104] = (byte) (r100 >>> 8);
        r101[r104 + 1] = (byte) r100;
    }

    public static void intToBigEndian(int[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        intToBigEndian(r100[r103], r101, r102);
        r102 = r102 + 4;
        r103 = r103 + 1;
        goto L4
    }

    public static byte[] intToBigEndian(int r100) {
        byte[] r101 = new byte[4];
        intToBigEndian(r100, r101, 0);
        return r101;
    }

    public static byte[] intToBigEndian(int[] r100) {
        byte[] r101 = new byte[r100.length * 4];
        intToBigEndian(r100, r101, 0);
        return r101;
    }

    public static void intToLittleEndian(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        int r103 = r102 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        int r104 = r103 + 1;
        r101[r104] = (byte) (r100 >>> 16);
        r101[r104 + 1] = (byte) (r100 >>> 24);
    }

    public static void intToLittleEndian(int[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        intToLittleEndian(r100[r103], r101, r102);
        r102 = r102 + 4;
        r103 = r103 + 1;
        goto L4
    }

    public static byte[] intToLittleEndian(int r100) {
        byte[] r101 = new byte[4];
        intToLittleEndian(r100, r101, 0);
        return r101;
    }

    public static byte[] intToLittleEndian(int[] r100) {
        byte[] r101 = new byte[r100.length * 4];
        intToLittleEndian(r100, r101, 0);
        return r101;
    }

    public static int littleEndianToInt(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 16);
        return (r100[r105 + 1] << 24) | r106;
    }

    public static void littleEndianToInt(byte[] r100, int r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L6;
        r102[r103] = littleEndianToInt(r100, r101);
        r101 = r101 + 4;
        r103 = r103 + 1;
        goto L4
    }

    public static void littleEndianToInt(byte[] r100, int r101, int[] r102, int r103, int r104) {
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r102[r103 + r105] = littleEndianToInt(r100, r101);
        r101 = r101 + 4;
        r105 = r105 + 1;
        goto L3
    }

    public static long littleEndianToLong(byte[] r100, int r101) {
        int r102 = littleEndianToInt(r100, r101);
        return ((((long) littleEndianToInt(r100, r101 + 4)) & BodyPartID.bodyIdMax) << 32) | (((long) r102) & BodyPartID.bodyIdMax);
    }

    public static void littleEndianToLong(byte[] r100, int r101, long[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L6;
        r102[r103] = littleEndianToLong(r100, r101);
        r101 = r101 + 8;
        r103 = r103 + 1;
        goto L4
    }

    public static void longToBigEndian(long r100, byte[] r101, int r102) {
        intToBigEndian((int) (r100 >>> 32), r101, r102);
        intToBigEndian((int) (r100 & BodyPartID.bodyIdMax), r101, r102 + 4);
    }

    public static void longToBigEndian(long[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        longToBigEndian(r100[r103], r101, r102);
        r102 = r102 + 8;
        r103 = r103 + 1;
        goto L4
    }

    public static byte[] longToBigEndian(long r100) {
        byte[] r101 = new byte[8];
        longToBigEndian(r100, r101, 0);
        return r101;
    }

    public static byte[] longToBigEndian(long[] r100) {
        byte[] r101 = new byte[r100.length * 8];
        longToBigEndian(r100, r101, 0);
        return r101;
    }

    public static void longToLittleEndian(long r100, byte[] r101, int r102) {
        intToLittleEndian((int) (BodyPartID.bodyIdMax & r100), r101, r102);
        intToLittleEndian((int) (r100 >>> 32), r101, r102 + 4);
    }

    public static void longToLittleEndian(long[] r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        longToLittleEndian(r100[r103], r101, r102);
        r102 = r102 + 8;
        r103 = r103 + 1;
        goto L4
    }

    public static byte[] longToLittleEndian(long r100) {
        byte[] r101 = new byte[8];
        longToLittleEndian(r100, r101, 0);
        return r101;
    }

    public static byte[] longToLittleEndian(long[] r100) {
        byte[] r101 = new byte[r100.length * 8];
        longToLittleEndian(r100, r101, 0);
        return r101;
    }
}
