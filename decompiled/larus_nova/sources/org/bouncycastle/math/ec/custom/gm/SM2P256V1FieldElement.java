package org.bouncycastle.math.ec.custom.gm;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SM2P256V1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525446x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));
    }

    public SM2P256V1FieldElement() {
        this.f525446x = Nat256.create();
    }

    public SM2P256V1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525446x = SM2P256V1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
    }

    public SM2P256V1FieldElement(int[] r100) {
        this.f525446x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SM2P256V1Field.add(this.f525446x, ((SM2P256V1FieldElement) r100).f525446x, r101);
        return new SM2P256V1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat256.create();
        SM2P256V1Field.addOne(this.f525446x, r100);
        return new SM2P256V1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SM2P256V1Field.inv(((SM2P256V1FieldElement) r100).f525446x, r101);
        SM2P256V1Field.multiply(r101, this.f525446x, r101);
        return new SM2P256V1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SM2P256V1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat256.eq(this.f525446x, ((SM2P256V1FieldElement) r100).f525446x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SM2P256V1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525446x, 0, 8);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat256.create();
        SM2P256V1Field.inv(this.f525446x, r100);
        return new SM2P256V1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne(this.f525446x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero(this.f525446x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SM2P256V1Field.multiply(this.f525446x, ((SM2P256V1FieldElement) r100).f525446x, r101);
        return new SM2P256V1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat256.create();
        SM2P256V1Field.negate(this.f525446x, r100);
        return new SM2P256V1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525446x;
        if (Nat256.isZero(r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat256.isOne(r100) == true) goto L12;
        int[] r101 = Nat256.create();
        SM2P256V1Field.square(r100, r101);
        SM2P256V1Field.multiply(r101, r100, r101);
        int[] r102 = Nat256.create();
        SM2P256V1Field.squareN(r101, 2, r102);
        SM2P256V1Field.multiply(r102, r101, r102);
        int[] r103 = Nat256.create();
        SM2P256V1Field.squareN(r102, 2, r103);
        SM2P256V1Field.multiply(r103, r101, r103);
        SM2P256V1Field.squareN(r103, 6, r101);
        SM2P256V1Field.multiply(r101, r103, r101);
        int[] r104 = Nat256.create();
        SM2P256V1Field.squareN(r101, 12, r104);
        SM2P256V1Field.multiply(r104, r101, r104);
        SM2P256V1Field.squareN(r104, 6, r101);
        SM2P256V1Field.multiply(r101, r103, r101);
        SM2P256V1Field.square(r101, r103);
        SM2P256V1Field.multiply(r103, r100, r103);
        SM2P256V1Field.squareN(r103, 31, r104);
        SM2P256V1Field.multiply(r104, r103, r101);
        SM2P256V1Field.squareN(r104, 32, r104);
        SM2P256V1Field.multiply(r104, r101, r104);
        SM2P256V1Field.squareN(r104, 62, r104);
        SM2P256V1Field.multiply(r104, r101, r104);
        SM2P256V1Field.squareN(r104, 4, r104);
        SM2P256V1Field.multiply(r104, r102, r104);
        SM2P256V1Field.squareN(r104, 32, r104);
        SM2P256V1Field.multiply(r104, r100, r104);
        SM2P256V1Field.squareN(r104, 62, r104);
        SM2P256V1Field.square(r104, r102);
        if (Nat256.eq(r100, r102) == true) goto L13;
        return null;
    L13:
        return new SM2P256V1FieldElement(r104);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat256.create();
        SM2P256V1Field.square(this.f525446x, r100);
        return new SM2P256V1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        SM2P256V1Field.subtract(this.f525446x, ((SM2P256V1FieldElement) r100).f525446x, r101);
        return new SM2P256V1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat256.getBit(this.f525446x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.f525446x);
    }
}
