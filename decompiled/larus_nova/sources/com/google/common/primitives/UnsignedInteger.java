package com.google.common.primitives;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.common.base.m;
import java.math.BigInteger;
import javax.annotation.CheckForNull;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class UnsignedInteger extends Number implements Comparable<UnsignedInteger> {
    public static final UnsignedInteger MAX_VALUE = null;
    public static final UnsignedInteger ONE = null;
    public static final UnsignedInteger ZERO = null;
    private final int value;

    static {
        ZERO = fromIntBits(0);
        ONE = fromIntBits(1);
        MAX_VALUE = fromIntBits(-1);
    }

    @Override // java.lang.Number
    public long longValue() {
        return UnsignedInts.a(this.value);
    }

    public String toString() {
        return toString(10);
    }

    public BigInteger bigIntegerValue() {
        return BigInteger.valueOf(longValue());
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return longValue();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return longValue();
    }

    public int hashCode() {
        return this.value;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    public UnsignedInteger(int r100) {
        this.value = r100 & (-1);
    }

    public static UnsignedInteger fromIntBits(int r100) {
        return new UnsignedInteger(r100);
    }

    public static UnsignedInteger valueOf(BigInteger r100) {
        r100.getClass();
        if (r100.signum() >= 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        m.h(r101, "value (%s) is outside the range for an unsigned integer value", r100);
        return fromIntBits(r100.intValue());
    L5:
        if (r100.bitLength() > 32) goto L7;
        r101 = true;
        goto L8
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(UnsignedInteger r100) {
        r100.getClass();
        int r101 = this.value;
        int r102 = r101 ^ Integer.MIN_VALUE;
        int r103 = r100.value ^ Integer.MIN_VALUE;
        if (r102 >= r103) goto L5;
        return -1;
    L5:
        if (r102 <= r103) goto L7;
        return 1;
    L7:
        return 0;
    }

    public UnsignedInteger dividedBy(UnsignedInteger r100) {
        int r101 = this.value;
        r100.getClass();
        int r102 = r100.value;
        return fromIntBits((int) (UnsignedInts.a(r101) / UnsignedInts.a(r102)));
    }

    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof UnsignedInteger) == true) goto L5;
        return false;
    L5:
        if (this.value != ((UnsignedInteger) r100).value) goto L9;
        return true;
    L9:
        return false;
    }

    public UnsignedInteger minus(UnsignedInteger r100) {
        int r101 = this.value;
        r100.getClass();
        return fromIntBits(r101 - r100.value);
    }

    public UnsignedInteger mod(UnsignedInteger r100) {
        int r101 = this.value;
        r100.getClass();
        int r102 = r100.value;
        return fromIntBits((int) (UnsignedInts.a(r101) % UnsignedInts.a(r102)));
    }

    public UnsignedInteger plus(UnsignedInteger r100) {
        int r101 = this.value;
        r100.getClass();
        return fromIntBits(r101 + r100.value);
    }

    public UnsignedInteger times(UnsignedInteger r100) {
        int r101 = this.value;
        r100.getClass();
        return fromIntBits(r101 * r100.value);
    }

    public String toString(int r100) {
        return Long.toString(((long) this.value) & BodyPartID.bodyIdMax, r100);
    }

    public static UnsignedInteger valueOf(long r100) {
        if ((BodyPartID.bodyIdMax & r100) != r100) goto L5;
        boolean r101 = true;
    L6:
        m.f(r101, "value (%s) is outside the range for an unsigned integer value", r100);
        return fromIntBits((int) r100);
    L5:
        r101 = false;
        goto L6
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UnsignedInteger r100) {
        return compareTo2(r100);
    }

    public static UnsignedInteger valueOf(String r100) {
        return valueOf(r100, 10);
    }

    public static UnsignedInteger valueOf(String r100, int r101) {
        r100.getClass();
        long r102 = CastLongProtector.parseLong(r100, r101);
        if ((BodyPartID.bodyIdMax & r102) != r102) goto L7;
        return fromIntBits((int) r102);
    L7:
        throw new NumberFormatException("Input " + r100 + " in base " + r101 + " is not in the range of an unsigned integer");
    }
}
