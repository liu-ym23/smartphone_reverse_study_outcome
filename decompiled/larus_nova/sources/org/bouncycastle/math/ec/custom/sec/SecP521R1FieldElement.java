package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP521R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525469x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));
    }

    public SecP521R1FieldElement() {
        this.f525469x = Nat.create(17);
    }

    public SecP521R1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525469x = SecP521R1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
    }

    public SecP521R1FieldElement(int[] r100) {
        this.f525469x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat.create(17);
        SecP521R1Field.add(this.f525469x, ((SecP521R1FieldElement) r100).f525469x, r101);
        return new SecP521R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat.create(17);
        SecP521R1Field.addOne(this.f525469x, r100);
        return new SecP521R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat.create(17);
        SecP521R1Field.inv(((SecP521R1FieldElement) r100).f525469x, r101);
        SecP521R1Field.multiply(r101, this.f525469x, r101);
        return new SecP521R1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP521R1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat.eq(17, this.f525469x, ((SecP521R1FieldElement) r100).f525469x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP521R1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525469x, 0, 17);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat.create(17);
        SecP521R1Field.inv(this.f525469x, r100);
        return new SecP521R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat.isOne(17, this.f525469x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat.isZero(17, this.f525469x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat.create(17);
        SecP521R1Field.multiply(this.f525469x, ((SecP521R1FieldElement) r100).f525469x, r101);
        return new SecP521R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat.create(17);
        SecP521R1Field.negate(this.f525469x, r100);
        return new SecP521R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525469x;
        if (Nat.isZero(17, r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat.isOne(17, r100) == true) goto L12;
        int[] r101 = Nat.create(17);
        int[] r102 = Nat.create(17);
        SecP521R1Field.squareN(r100, 519, r101);
        SecP521R1Field.square(r101, r102);
        if (Nat.eq(17, r100, r102) == true) goto L13;
        return null;
    L13:
        return new SecP521R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat.create(17);
        SecP521R1Field.square(this.f525469x, r100);
        return new SecP521R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat.create(17);
        SecP521R1Field.subtract(this.f525469x, ((SecP521R1FieldElement) r100).f525469x, r101);
        return new SecP521R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat.getBit(this.f525469x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat.toBigInteger(17, this.f525469x);
    }
}
