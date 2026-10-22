package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP192K1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525455x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));
    }

    public SecP192K1FieldElement() {
        this.f525455x = Nat192.create();
    }

    public SecP192K1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525455x = SecP192K1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
    }

    public SecP192K1FieldElement(int[] r100) {
        this.f525455x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192K1Field.add(this.f525455x, ((SecP192K1FieldElement) r100).f525455x, r101);
        return new SecP192K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat192.create();
        SecP192K1Field.addOne(this.f525455x, r100);
        return new SecP192K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192K1Field.inv(((SecP192K1FieldElement) r100).f525455x, r101);
        SecP192K1Field.multiply(r101, this.f525455x, r101);
        return new SecP192K1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP192K1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat192.eq(this.f525455x, ((SecP192K1FieldElement) r100).f525455x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP192K1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525455x, 0, 6);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat192.create();
        SecP192K1Field.inv(this.f525455x, r100);
        return new SecP192K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne(this.f525455x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero(this.f525455x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192K1Field.multiply(this.f525455x, ((SecP192K1FieldElement) r100).f525455x, r101);
        return new SecP192K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat192.create();
        SecP192K1Field.negate(this.f525455x, r100);
        return new SecP192K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525455x;
        if (Nat192.isZero(r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat192.isOne(r100) == true) goto L12;
        int[] r101 = Nat192.create();
        SecP192K1Field.square(r100, r101);
        SecP192K1Field.multiply(r101, r100, r101);
        int[] r102 = Nat192.create();
        SecP192K1Field.square(r101, r102);
        SecP192K1Field.multiply(r102, r100, r102);
        int[] r103 = Nat192.create();
        SecP192K1Field.squareN(r102, 3, r103);
        SecP192K1Field.multiply(r103, r102, r103);
        SecP192K1Field.squareN(r103, 2, r103);
        SecP192K1Field.multiply(r103, r101, r103);
        SecP192K1Field.squareN(r103, 8, r101);
        SecP192K1Field.multiply(r101, r103, r101);
        SecP192K1Field.squareN(r101, 3, r103);
        SecP192K1Field.multiply(r103, r102, r103);
        int[] r104 = Nat192.create();
        SecP192K1Field.squareN(r103, 16, r104);
        SecP192K1Field.multiply(r104, r101, r104);
        SecP192K1Field.squareN(r104, 35, r101);
        SecP192K1Field.multiply(r101, r104, r101);
        SecP192K1Field.squareN(r101, 70, r104);
        SecP192K1Field.multiply(r104, r101, r104);
        SecP192K1Field.squareN(r104, 19, r101);
        SecP192K1Field.multiply(r101, r103, r101);
        SecP192K1Field.squareN(r101, 20, r101);
        SecP192K1Field.multiply(r101, r103, r101);
        SecP192K1Field.squareN(r101, 4, r101);
        SecP192K1Field.multiply(r101, r102, r101);
        SecP192K1Field.squareN(r101, 6, r101);
        SecP192K1Field.multiply(r101, r102, r101);
        SecP192K1Field.square(r101, r101);
        SecP192K1Field.square(r101, r102);
        if (Nat192.eq(r100, r102) == true) goto L13;
        return null;
    L13:
        return new SecP192K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat192.create();
        SecP192K1Field.square(this.f525455x, r100);
        return new SecP192K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192K1Field.subtract(this.f525455x, ((SecP192K1FieldElement) r100).f525455x, r101);
        return new SecP192K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat192.getBit(this.f525455x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat192.toBigInteger(this.f525455x);
    }
}
