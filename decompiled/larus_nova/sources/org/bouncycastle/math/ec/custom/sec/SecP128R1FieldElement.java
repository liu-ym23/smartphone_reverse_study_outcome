package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP128R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525448x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));
    }

    public SecP128R1FieldElement() {
        this.f525448x = Nat128.create();
    }

    public SecP128R1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525448x = SecP128R1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
    }

    public SecP128R1FieldElement(int[] r100) {
        this.f525448x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat128.create();
        SecP128R1Field.add(this.f525448x, ((SecP128R1FieldElement) r100).f525448x, r101);
        return new SecP128R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat128.create();
        SecP128R1Field.addOne(this.f525448x, r100);
        return new SecP128R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat128.create();
        SecP128R1Field.inv(((SecP128R1FieldElement) r100).f525448x, r101);
        SecP128R1Field.multiply(r101, this.f525448x, r101);
        return new SecP128R1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP128R1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat128.eq(this.f525448x, ((SecP128R1FieldElement) r100).f525448x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP128R1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525448x, 0, 4);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat128.create();
        SecP128R1Field.inv(this.f525448x, r100);
        return new SecP128R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat128.isOne(this.f525448x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat128.isZero(this.f525448x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat128.create();
        SecP128R1Field.multiply(this.f525448x, ((SecP128R1FieldElement) r100).f525448x, r101);
        return new SecP128R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat128.create();
        SecP128R1Field.negate(this.f525448x, r100);
        return new SecP128R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525448x;
        if (Nat128.isZero(r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat128.isOne(r100) == true) goto L12;
        int[] r101 = Nat128.create();
        SecP128R1Field.square(r100, r101);
        SecP128R1Field.multiply(r101, r100, r101);
        int[] r102 = Nat128.create();
        SecP128R1Field.squareN(r101, 2, r102);
        SecP128R1Field.multiply(r102, r101, r102);
        int[] r103 = Nat128.create();
        SecP128R1Field.squareN(r102, 4, r103);
        SecP128R1Field.multiply(r103, r102, r103);
        SecP128R1Field.squareN(r103, 2, r102);
        SecP128R1Field.multiply(r102, r101, r102);
        SecP128R1Field.squareN(r102, 10, r101);
        SecP128R1Field.multiply(r101, r102, r101);
        SecP128R1Field.squareN(r101, 10, r103);
        SecP128R1Field.multiply(r103, r102, r103);
        SecP128R1Field.square(r103, r102);
        SecP128R1Field.multiply(r102, r100, r102);
        SecP128R1Field.squareN(r102, 95, r102);
        SecP128R1Field.square(r102, r103);
        if (Nat128.eq(r100, r103) == true) goto L13;
        return null;
    L13:
        return new SecP128R1FieldElement(r102);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat128.create();
        SecP128R1Field.square(this.f525448x, r100);
        return new SecP128R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat128.create();
        SecP128R1Field.subtract(this.f525448x, ((SecP128R1FieldElement) r100).f525448x, r101);
        return new SecP128R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat128.getBit(this.f525448x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat128.toBigInteger(this.f525448x);
    }
}
