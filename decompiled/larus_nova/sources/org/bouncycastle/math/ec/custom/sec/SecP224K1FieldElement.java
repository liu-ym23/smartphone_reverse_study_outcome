package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP224K1FieldElement extends ECFieldElement.AbstractFp {
    private static final int[] PRECOMP_POW2 = null;
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525459x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));
        PRECOMP_POW2 = new int[]{868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};
    }

    public SecP224K1FieldElement() {
        this.f525459x = Nat224.create();
    }

    public SecP224K1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525459x = SecP224K1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
    }

    public SecP224K1FieldElement(int[] r100) {
        this.f525459x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224K1Field.add(this.f525459x, ((SecP224K1FieldElement) r100).f525459x, r101);
        return new SecP224K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat224.create();
        SecP224K1Field.addOne(this.f525459x, r100);
        return new SecP224K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224K1Field.inv(((SecP224K1FieldElement) r100).f525459x, r101);
        SecP224K1Field.multiply(r101, this.f525459x, r101);
        return new SecP224K1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP224K1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat224.eq(this.f525459x, ((SecP224K1FieldElement) r100).f525459x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP224K1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525459x, 0, 7);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat224.create();
        SecP224K1Field.inv(this.f525459x, r100);
        return new SecP224K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat224.isOne(this.f525459x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat224.isZero(this.f525459x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224K1Field.multiply(this.f525459x, ((SecP224K1FieldElement) r100).f525459x, r101);
        return new SecP224K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat224.create();
        SecP224K1Field.negate(this.f525459x, r100);
        return new SecP224K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525459x;
        if (Nat224.isZero(r100) == false) goto L5;
    L17:
        return this;
    L5:
        if (Nat224.isOne(r100) == true) goto L17;
        int[] r101 = Nat224.create();
        SecP224K1Field.square(r100, r101);
        SecP224K1Field.multiply(r101, r100, r101);
        SecP224K1Field.square(r101, r101);
        SecP224K1Field.multiply(r101, r100, r101);
        int[] r102 = Nat224.create();
        SecP224K1Field.square(r101, r102);
        SecP224K1Field.multiply(r102, r100, r102);
        int[] r103 = Nat224.create();
        SecP224K1Field.squareN(r102, 4, r103);
        SecP224K1Field.multiply(r103, r102, r103);
        int[] r104 = Nat224.create();
        SecP224K1Field.squareN(r103, 3, r104);
        SecP224K1Field.multiply(r104, r101, r104);
        SecP224K1Field.squareN(r104, 8, r104);
        SecP224K1Field.multiply(r104, r103, r104);
        SecP224K1Field.squareN(r104, 4, r103);
        SecP224K1Field.multiply(r103, r102, r103);
        SecP224K1Field.squareN(r103, 19, r102);
        SecP224K1Field.multiply(r102, r104, r102);
        int[] r105 = Nat224.create();
        SecP224K1Field.squareN(r102, 42, r105);
        SecP224K1Field.multiply(r105, r102, r105);
        SecP224K1Field.squareN(r105, 23, r102);
        SecP224K1Field.multiply(r102, r103, r102);
        SecP224K1Field.squareN(r102, 84, r103);
        SecP224K1Field.multiply(r103, r105, r103);
        SecP224K1Field.squareN(r103, 20, r103);
        SecP224K1Field.multiply(r103, r104, r103);
        SecP224K1Field.squareN(r103, 3, r103);
        SecP224K1Field.multiply(r103, r100, r103);
        SecP224K1Field.squareN(r103, 2, r103);
        SecP224K1Field.multiply(r103, r100, r103);
        SecP224K1Field.squareN(r103, 4, r103);
        SecP224K1Field.multiply(r103, r101, r103);
        SecP224K1Field.square(r103, r103);
        SecP224K1Field.square(r103, r105);
        if (Nat224.eq(r100, r105) == true) goto L10;
        SecP224K1Field.multiply(r103, PRECOMP_POW2, r103);
        SecP224K1Field.square(r103, r105);
        if (Nat224.eq(r100, r105) == true) goto L14;
        return null;
    L14:
        return new SecP224K1FieldElement(r103);
    L10:
        return new SecP224K1FieldElement(r103);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat224.create();
        SecP224K1Field.square(this.f525459x, r100);
        return new SecP224K1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224K1Field.subtract(this.f525459x, ((SecP224K1FieldElement) r100).f525459x, r101);
        return new SecP224K1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat224.getBit(this.f525459x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.f525459x);
    }
}
