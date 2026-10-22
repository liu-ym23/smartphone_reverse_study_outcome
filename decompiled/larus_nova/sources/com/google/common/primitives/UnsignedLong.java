package com.google.common.primitives;

import com.google.common.base.m;
import java.io.Serializable;
import java.math.BigInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedLong extends Number implements Comparable<UnsignedLong>, Serializable {
    public static final UnsignedLong MAX_VALUE = null;
    public static final UnsignedLong ONE = null;
    public static final UnsignedLong ZERO = null;
    private final long value;

    static {
        ZERO = new UnsignedLong(0);
        ONE = new UnsignedLong(1);
        MAX_VALUE = new UnsignedLong(-1);
    }

    public BigInteger bigIntegerValue() {
        BigInteger r100 = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        if (this.value < 0) goto L5;
        return r100;
    L5:
        return r100.setBit(63);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long r100 = this.value;
        if (r100 < 0) goto L7;
        return r100;
    L7:
        return ((r100 & 1) | (r100 >>> 1)) * 2.0d;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long r100 = this.value;
        if (r100 < 0) goto L7;
        return r100;
    L7:
        return ((r100 & 1) | (r100 >>> 1)) * 2.0f;
    }

    public int hashCode() {
        long r100 = this.value;
        return (int) (r100 ^ (r100 >>> 32));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public String toString() {
        return UnsignedLongs.d(this.value, 10);
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong(long r100) {
        this.value = r100;
    }

    public static UnsignedLong fromLongBits(long r100) {
        return new UnsignedLong(r100);
    }

    public static UnsignedLong valueOf(BigInteger r100) {
        r100.getClass();
        if (r100.signum() >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        m.h(r101, "value (%s) is outside the range for an unsigned long value", r100);
        return fromLongBits(r100.longValue());
    L5:
        if (r100.bitLength() > 64) goto L7;
        r101 = true;
        goto L8
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedLong r100) {
        r100.getClass();
        return UnsignedLongs.a(this.value, r100.value);
    }

    public UnsignedLong dividedBy(UnsignedLong r100) {
        long r101 = this.value;
        r100.getClass();
        return fromLongBits(UnsignedLongs.b(r101, r100.value));
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof UnsignedLong) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedLong) r100).value) goto L9;
        return true;
    L9:
        return false;
    }

    public UnsignedLong minus(UnsignedLong r100) {
        long r101 = this.value;
        r100.getClass();
        return fromLongBits(r101 - r100.value);
    }

    public UnsignedLong mod(UnsignedLong r100) {
        long r101 = this.value;
        r100.getClass();
        return fromLongBits(UnsignedLongs.c(r101, r100.value));
    }

    public UnsignedLong plus(UnsignedLong r100) {
        long r101 = this.value;
        r100.getClass();
        return fromLongBits(r101 + r100.value);
    }

    public UnsignedLong times(UnsignedLong r100) {
        long r101 = this.value;
        r100.getClass();
        return fromLongBits(r101 * r100.value);
    }

    public String toString(int r100) {
        return UnsignedLongs.d(this.value, r100);
    }

    public static UnsignedLong valueOf(long r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        m.f(r101, "value (%s) is outside the range for an unsigned long value", r100);
        return fromLongBits(r100);
    L5:
        r101 = false;
        goto L6
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedLong r100) {
        return compareTo2(r100);
    }

    public static UnsignedLong valueOf(String r100) {
        return valueOf(r100, 10);
    }

    public static UnsignedLong valueOf(String r110, int r111) {
        r110.getClass();
        if (r110.length() == 0) goto L38;
        if (r111 < 2) goto L36;
        if (r111 > 36) goto L36;
        int r100 = UnsignedLongs.a.f275659c[r111] - 1;
        long r101 = 0;
        int r102 = 0;
    L10:
        if (r102 >= r110.length()) goto L34;
        int r103 = Character.digit(r110.charAt(r102), r111);
        if (r103 == (-1)) goto L32;
        if (r102 <= r100) goto L30;
        if (r101 < 0) goto L25;
        long r112 = UnsignedLongs.a.f275657a[r111];
        if (r101 < r112) goto L24;
        if (r101 > r112) goto L25;
        if (r103 > UnsignedLongs.a.f275658b[r111]) goto L25;
    L24:
        boolean r104 = false;
    L26:
        if (r104 == false) goto L30;
        throw new NumberFormatException("Too large for unsigned long: ".concat(r110));
    L25:
        r104 = true;
    L30:
        r101 = (r101 * ((long) r111)) + ((long) r103);
        r102 = r102 + 1;
        goto L10
    L32:
        throw new NumberFormatException(r110);
    L34:
        return fromLongBits(r101);
    L36:
        throw new NumberFormatException("illegal radix: " + r111);
    L38:
        throw new NumberFormatException("empty string");
    }
}
