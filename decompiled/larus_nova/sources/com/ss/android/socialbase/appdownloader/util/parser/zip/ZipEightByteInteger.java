package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes38.dex */
public final class ZipEightByteInteger {
    private static final int BYTE_1 = 1;
    private static final int BYTE_1_MASK = 65280;
    private static final int BYTE_1_SHIFT = 8;
    private static final int BYTE_2 = 2;
    private static final int BYTE_2_MASK = 16711680;
    private static final int BYTE_2_SHIFT = 16;
    private static final int BYTE_3 = 3;
    private static final long BYTE_3_MASK = 4278190080L;
    private static final int BYTE_3_SHIFT = 24;
    private static final int BYTE_4 = 4;
    private static final long BYTE_4_MASK = 1095216660480L;
    private static final int BYTE_4_SHIFT = 32;
    private static final int BYTE_5 = 5;
    private static final long BYTE_5_MASK = 280375465082880L;
    private static final int BYTE_5_SHIFT = 40;
    private static final int BYTE_6 = 6;
    private static final long BYTE_6_MASK = 71776119061217280L;
    private static final int BYTE_6_SHIFT = 48;
    private static final int BYTE_7 = 7;
    private static final long BYTE_7_MASK = 9151314442816847872L;
    private static final int BYTE_7_SHIFT = 56;
    private static final byte LEFTMOST_BIT = -128;
    private static final int LEFTMOST_BIT_SHIFT = 63;
    public static final ZipEightByteInteger ZERO = null;
    private final BigInteger value;

    static {
        ZERO = new ZipEightByteInteger(0);
    }

    public byte[] getBytes() {
        return getBytes(this.value);
    }

    public long getLongValue() {
        return this.value.longValue();
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "ZipEightByteInteger value: " + this.value;
    }

    public BigInteger getValue() {
        return this.value;
    }

    public ZipEightByteInteger(long r100) {
        this(BigInteger.valueOf(r100));
    }

    public static byte[] getBytes(BigInteger r100) {
        long r101 = r100.longValue();
        byte[] r102 = {(byte) (255 & r101), (byte) ((65280 & r101) >> 8), (byte) ((16711680 & r101) >> 16), (byte) ((BYTE_3_MASK & r101) >> 24), (byte) ((BYTE_4_MASK & r101) >> 32), (byte) ((BYTE_5_MASK & r101) >> 40), (byte) ((BYTE_6_MASK & r101) >> 48), (byte) ((r101 & BYTE_7_MASK) >> 56)};
        if (r100.testBit(63) == false) goto L5;
        r102[7] = (byte) (r102[7] | (-128));
    L5:
        return r102;
    }

    public static long getLongValue(byte[] r100) {
        return getLongValue(r100, 0);
    }

    public static BigInteger getValue(byte[] r100) {
        return getValue(r100, 0);
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof ZipEightByteInteger) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.value.equals(((ZipEightByteInteger) r100).getValue()) == false) goto L7;
        return true;
    }

    public ZipEightByteInteger(BigInteger r100) {
        this.value = r100;
    }

    public static byte[] getBytes(long r100) {
        return getBytes(BigInteger.valueOf(r100));
    }

    public ZipEightByteInteger(byte[] r100) {
        this(r100, 0);
    }

    public ZipEightByteInteger(byte[] r100, int r101) {
        this.value = getValue(r100, r101);
    }

    public static long getLongValue(byte[] r100, int r101) {
        return getValue(r100, r101).longValue();
    }

    public static BigInteger getValue(byte[] r100, int r101) {
        int r102 = r101 + 7;
        BigInteger r103 = BigInteger.valueOf(((((((((((long) r100[r102]) << 56) & BYTE_7_MASK) + ((((long) r100[r101 + 6]) << 48) & BYTE_6_MASK)) + ((((long) r100[r101 + 5]) << 40) & BYTE_5_MASK)) + ((((long) r100[r101 + 4]) << 32) & BYTE_4_MASK)) + ((((long) r100[r101 + 3]) << 24) & BYTE_3_MASK)) + ((((long) r100[r101 + 2]) << 16) & 16711680)) + ((((long) r100[r101 + 1]) << 8) & 65280)) + (((long) r100[r101]) & 255));
        if ((r100[r102] & (-128)) == (-128)) goto L5;
        return r103;
    L5:
        return r103.setBit(63);
    }
}
