package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP160R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525451x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));
    }

    public SecP160R1FieldElement() {
        this.f525451x = Nat160.create();
    }

    public SecP160R1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525451x = SecP160R1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
    }

    public SecP160R1FieldElement(int[] r100) {
        this.f525451x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R1Field.add(this.f525451x, ((SecP160R1FieldElement) r100).f525451x, r101);
        return new SecP160R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat160.create();
        SecP160R1Field.addOne(this.f525451x, r100);
        return new SecP160R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R1Field.inv(((SecP160R1FieldElement) r100).f525451x, r101);
        SecP160R1Field.multiply(r101, this.f525451x, r101);
        return new SecP160R1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP160R1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat160.eq(this.f525451x, ((SecP160R1FieldElement) r100).f525451x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP160R1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525451x, 0, 5);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat160.create();
        SecP160R1Field.inv(this.f525451x, r100);
        return new SecP160R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat160.isOne(this.f525451x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat160.isZero(this.f525451x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R1Field.multiply(this.f525451x, ((SecP160R1FieldElement) r100).f525451x, r101);
        return new SecP160R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat160.create();
        SecP160R1Field.negate(this.f525451x, r100);
        return new SecP160R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525451x;
        if (Nat160.isZero(r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat160.isOne(r100) == true) goto L12;
        int[] r101 = Nat160.create();
        SecP160R1Field.square(r100, r101);
        SecP160R1Field.multiply(r101, r100, r101);
        int[] r102 = Nat160.create();
        SecP160R1Field.squareN(r101, 2, r102);
        SecP160R1Field.multiply(r102, r101, r102);
        SecP160R1Field.squareN(r102, 4, r101);
        SecP160R1Field.multiply(r101, r102, r101);
        SecP160R1Field.squareN(r101, 8, r102);
        SecP160R1Field.multiply(r102, r101, r102);
        SecP160R1Field.squareN(r102, 16, r101);
        SecP160R1Field.multiply(r101, r102, r101);
        SecP160R1Field.squareN(r101, 32, r102);
        SecP160R1Field.multiply(r102, r101, r102);
        SecP160R1Field.squareN(r102, 64, r101);
        SecP160R1Field.multiply(r101, r102, r101);
        SecP160R1Field.square(r101, r102);
        SecP160R1Field.multiply(r102, r100, r102);
        SecP160R1Field.squareN(r102, 29, r102);
        SecP160R1Field.square(r102, r101);
        if (Nat160.eq(r100, r101) == true) goto L13;
        return null;
    L13:
        return new SecP160R1FieldElement(r102);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat160.create();
        SecP160R1Field.square(this.f525451x, r100);
        return new SecP160R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R1Field.subtract(this.f525451x, ((SecP160R1FieldElement) r100).f525451x, r101);
        return new SecP160R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat160.getBit(this.f525451x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat160.toBigInteger(this.f525451x);
    }
}
