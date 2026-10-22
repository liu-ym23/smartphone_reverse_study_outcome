package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;
import java.math.BigInteger;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes42.dex */
public final class ZipEightByteInteger implements Serializable {
    public static final ZipEightByteInteger ZERO = null;
    private static final long serialVersionUID = 1;
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
        byte[] r102 = {(byte) (255 & r101), (byte) ((65280 & r101) >> 8), (byte) ((16711680 & r101) >> 16), (byte) ((4278190080L & r101) >> 24), (byte) ((1095216660480L & r101) >> 32), (byte) ((280375465082880L & r101) >> 40), (byte) ((71776119061217280L & r101) >> 48), (byte) ((r101 & 9151314442816847872L) >> 56)};
        if (r100.testBit(63) == false) goto L5;
        r102[7] = (byte) (r102[7] | ByteCompanionObject.MIN_VALUE);
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
        if (r100 != null) goto L4;
        return false;
    L4:
        if ((r100 instanceof ZipEightByteInteger) == true) goto L7;
        return false;
    L7:
        return this.value.equals(((ZipEightByteInteger) r100).getValue());
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
        BigInteger r103 = BigInteger.valueOf(((((((((((long) r100[r102]) << 56) & 9151314442816847872L) + ((((long) r100[r101 + 6]) << 48) & 71776119061217280L)) + ((((long) r100[r101 + 5]) << 40) & 280375465082880L)) + ((((long) r100[r101 + 4]) << 32) & 1095216660480L)) + ((((long) r100[r101 + 3]) << 24) & 4278190080L)) + ((((long) r100[r101 + 2]) << 16) & 16711680)) + ((((long) r100[r101 + 1]) << 8) & 65280)) + (((long) r100[r101]) & 255));
        if ((r100[r102] & ByteCompanionObject.MIN_VALUE) == (-128)) goto L5;
        return r103;
    L5:
        return r103.setBit(63);
    }
}
