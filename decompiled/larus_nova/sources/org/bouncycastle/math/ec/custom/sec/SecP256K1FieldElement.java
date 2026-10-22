package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP256K1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525463x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));
    }

    public SecP256K1FieldElement() {
        this.f525463x = Nat256.create();
    }

    public SecP256K1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525463x = SecP256K1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
    }

    public SecP256K1FieldElement(int[] r100) {
        this.f525463x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SecP256K1Field.add(this.f525463x, ((SecP256K1FieldElement) r100).f525463x, r101);
        return new SecP256K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat256.create();
        SecP256K1Field.addOne(this.f525463x, r100);
        return new SecP256K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SecP256K1Field.inv(((SecP256K1FieldElement) r100).f525463x, r101);
        SecP256K1Field.multiply(r101, this.f525463x, r101);
        return new SecP256K1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP256K1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat256.eq(this.f525463x, ((SecP256K1FieldElement) r100).f525463x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP256K1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525463x, 0, 8);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat256.create();
        SecP256K1Field.inv(this.f525463x, r100);
        return new SecP256K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne(this.f525463x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero(this.f525463x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SecP256K1Field.multiply(this.f525463x, ((SecP256K1FieldElement) r100).f525463x, r101);
        return new SecP256K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat256.create();
        SecP256K1Field.negate(this.f525463x, r100);
        return new SecP256K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525463x;
        if (Nat256.isZero(r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat256.isOne(r100) == true) goto L12;
        int[] r101 = Nat256.create();
        SecP256K1Field.square(r100, r101);
        SecP256K1Field.multiply(r101, r100, r101);
        int[] r102 = Nat256.create();
        SecP256K1Field.square(r101, r102);
        SecP256K1Field.multiply(r102, r100, r102);
        int[] r103 = Nat256.create();
        SecP256K1Field.squareN(r102, 3, r103);
        SecP256K1Field.multiply(r103, r102, r103);
        SecP256K1Field.squareN(r103, 3, r103);
        SecP256K1Field.multiply(r103, r102, r103);
        SecP256K1Field.squareN(r103, 2, r103);
        SecP256K1Field.multiply(r103, r101, r103);
        int[] r104 = Nat256.create();
        SecP256K1Field.squareN(r103, 11, r104);
        SecP256K1Field.multiply(r104, r103, r104);
        SecP256K1Field.squareN(r104, 22, r103);
        SecP256K1Field.multiply(r103, r104, r103);
        int[] r105 = Nat256.create();
        SecP256K1Field.squareN(r103, 44, r105);
        SecP256K1Field.multiply(r105, r103, r105);
        int[] r106 = Nat256.create();
        SecP256K1Field.squareN(r105, 88, r106);
        SecP256K1Field.multiply(r106, r105, r106);
        SecP256K1Field.squareN(r106, 44, r105);
        SecP256K1Field.multiply(r105, r103, r105);
        SecP256K1Field.squareN(r105, 3, r103);
        SecP256K1Field.multiply(r103, r102, r103);
        SecP256K1Field.squareN(r103, 23, r103);
        SecP256K1Field.multiply(r103, r104, r103);
        SecP256K1Field.squareN(r103, 6, r103);
        SecP256K1Field.multiply(r103, r101, r103);
        SecP256K1Field.squareN(r103, 2, r103);
        SecP256K1Field.square(r103, r101);
        if (Nat256.eq(r100, r101) == true) goto L13;
        return null;
    L13:
        return new SecP256K1FieldElement(r103);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat256.create();
        SecP256K1Field.square(this.f525463x, r100);
        return new SecP256K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SecP256K1Field.subtract(this.f525463x, ((SecP256K1FieldElement) r100).f525463x, r101);
        return new SecP256K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat256.getBit(this.f525463x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.f525463x);
    }
}
