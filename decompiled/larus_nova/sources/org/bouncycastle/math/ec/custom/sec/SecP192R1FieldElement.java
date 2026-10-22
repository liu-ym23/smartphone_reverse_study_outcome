package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP192R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525457x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));
    }

    public SecP192R1FieldElement() {
        this.f525457x = Nat192.create();
    }

    public SecP192R1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525457x = SecP192R1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
    }

    public SecP192R1FieldElement(int[] r100) {
        this.f525457x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192R1Field.add(this.f525457x, ((SecP192R1FieldElement) r100).f525457x, r101);
        return new SecP192R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat192.create();
        SecP192R1Field.addOne(this.f525457x, r100);
        return new SecP192R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192R1Field.inv(((SecP192R1FieldElement) r100).f525457x, r101);
        SecP192R1Field.multiply(r101, this.f525457x, r101);
        return new SecP192R1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP192R1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat192.eq(this.f525457x, ((SecP192R1FieldElement) r100).f525457x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP192R1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525457x, 0, 6);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat192.create();
        SecP192R1Field.inv(this.f525457x, r100);
        return new SecP192R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne(this.f525457x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero(this.f525457x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192R1Field.multiply(this.f525457x, ((SecP192R1FieldElement) r100).f525457x, r101);
        return new SecP192R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat192.create();
        SecP192R1Field.negate(this.f525457x, r100);
        return new SecP192R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525457x;
        if (Nat192.isZero(r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat192.isOne(r100) == true) goto L12;
        int[] r101 = Nat192.create();
        int[] r102 = Nat192.create();
        SecP192R1Field.square(r100, r101);
        SecP192R1Field.multiply(r101, r100, r101);
        SecP192R1Field.squareN(r101, 2, r102);
        SecP192R1Field.multiply(r102, r101, r102);
        SecP192R1Field.squareN(r102, 4, r101);
        SecP192R1Field.multiply(r101, r102, r101);
        SecP192R1Field.squareN(r101, 8, r102);
        SecP192R1Field.multiply(r102, r101, r102);
        SecP192R1Field.squareN(r102, 16, r101);
        SecP192R1Field.multiply(r101, r102, r101);
        SecP192R1Field.squareN(r101, 32, r102);
        SecP192R1Field.multiply(r102, r101, r102);
        SecP192R1Field.squareN(r102, 64, r101);
        SecP192R1Field.multiply(r101, r102, r101);
        SecP192R1Field.squareN(r101, 62, r101);
        SecP192R1Field.square(r101, r102);
        if (Nat192.eq(r100, r102) == true) goto L13;
        return null;
    L13:
        return new SecP192R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat192.create();
        SecP192R1Field.square(this.f525457x, r100);
        return new SecP192R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat192.create();
        SecP192R1Field.subtract(this.f525457x, ((SecP192R1FieldElement) r100).f525457x, r101);
        return new SecP192R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat192.getBit(this.f525457x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat192.toBigInteger(this.f525457x);
    }
}
