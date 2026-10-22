package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP384R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525467x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));
    }

    public SecP384R1FieldElement() {
        this.f525467x = Nat.create(12);
    }

    public SecP384R1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525467x = SecP384R1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
    }

    public SecP384R1FieldElement(int[] r100) {
        this.f525467x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat.create(12);
        SecP384R1Field.add(this.f525467x, ((SecP384R1FieldElement) r100).f525467x, r101);
        return new SecP384R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat.create(12);
        SecP384R1Field.addOne(this.f525467x, r100);
        return new SecP384R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat.create(12);
        SecP384R1Field.inv(((SecP384R1FieldElement) r100).f525467x, r101);
        SecP384R1Field.multiply(r101, this.f525467x, r101);
        return new SecP384R1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP384R1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat.eq(12, this.f525467x, ((SecP384R1FieldElement) r100).f525467x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP384R1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525467x, 0, 12);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat.create(12);
        SecP384R1Field.inv(this.f525467x, r100);
        return new SecP384R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(12, this.f525467x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(12, this.f525467x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat.create(12);
        SecP384R1Field.multiply(this.f525467x, ((SecP384R1FieldElement) r100).f525467x, r101);
        return new SecP384R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat.create(12);
        SecP384R1Field.negate(this.f525467x, r100);
        return new SecP384R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525467x;
        if (Nat.isZero(12, r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat.isOne(12, r100) == true) goto L12;
        int[] r101 = Nat.create(12);
        int[] r102 = Nat.create(12);
        int[] r103 = Nat.create(12);
        int[] r104 = Nat.create(12);
        SecP384R1Field.square(r100, r101);
        SecP384R1Field.multiply(r101, r100, r101);
        SecP384R1Field.squareN(r101, 2, r102);
        SecP384R1Field.multiply(r102, r101, r102);
        SecP384R1Field.square(r102, r102);
        SecP384R1Field.multiply(r102, r100, r102);
        SecP384R1Field.squareN(r102, 5, r103);
        SecP384R1Field.multiply(r103, r102, r103);
        SecP384R1Field.squareN(r103, 5, r104);
        SecP384R1Field.multiply(r104, r102, r104);
        SecP384R1Field.squareN(r104, 15, r102);
        SecP384R1Field.multiply(r102, r104, r102);
        SecP384R1Field.squareN(r102, 2, r103);
        SecP384R1Field.multiply(r101, r103, r101);
        SecP384R1Field.squareN(r103, 28, r103);
        SecP384R1Field.multiply(r102, r103, r102);
        SecP384R1Field.squareN(r102, 60, r103);
        SecP384R1Field.multiply(r103, r102, r103);
        SecP384R1Field.squareN(r103, 120, r102);
        SecP384R1Field.multiply(r102, r103, r102);
        SecP384R1Field.squareN(r102, 15, r102);
        SecP384R1Field.multiply(r102, r104, r102);
        SecP384R1Field.squareN(r102, 33, r102);
        SecP384R1Field.multiply(r102, r101, r102);
        SecP384R1Field.squareN(r102, 64, r102);
        SecP384R1Field.multiply(r102, r100, r102);
        SecP384R1Field.squareN(r102, 30, r101);
        SecP384R1Field.square(r101, r102);
        if (Nat.eq(12, r100, r102) == true) goto L13;
        return null;
    L13:
        return new SecP384R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat.create(12);
        SecP384R1Field.square(this.f525467x, r100);
        return new SecP384R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat.create(12);
        SecP384R1Field.subtract(this.f525467x, ((SecP384R1FieldElement) r100).f525467x, r101);
        return new SecP384R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat.getBit(this.f525467x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat.toBigInteger(12, this.f525467x);
    }
}
