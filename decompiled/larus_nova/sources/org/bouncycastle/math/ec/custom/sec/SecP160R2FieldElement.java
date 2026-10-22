package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP160R2FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525453x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));
    }

    public SecP160R2FieldElement() {
        this.f525453x = Nat160.create();
    }

    public SecP160R2FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525453x = SecP160R2Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
    }

    public SecP160R2FieldElement(int[] r100) {
        this.f525453x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R2Field.add(this.f525453x, ((SecP160R2FieldElement) r100).f525453x, r101);
        return new SecP160R2FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat160.create();
        SecP160R2Field.addOne(this.f525453x, r100);
        return new SecP160R2FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R2Field.inv(((SecP160R2FieldElement) r100).f525453x, r101);
        SecP160R2Field.multiply(r101, this.f525453x, r101);
        return new SecP160R2FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP160R2FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat160.eq(this.f525453x, ((SecP160R2FieldElement) r100).f525453x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP160R2Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525453x, 0, 5);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat160.create();
        SecP160R2Field.inv(this.f525453x, r100);
        return new SecP160R2FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat160.isOne(this.f525453x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat160.isZero(this.f525453x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R2Field.multiply(this.f525453x, ((SecP160R2FieldElement) r100).f525453x, r101);
        return new SecP160R2FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat160.create();
        SecP160R2Field.negate(this.f525453x, r100);
        return new SecP160R2FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525453x;
        if (Nat160.isZero(r100) == false) goto L5;
    L12:
        return this;
    L5:
        if (Nat160.isOne(r100) == true) goto L12;
        int[] r101 = Nat160.create();
        SecP160R2Field.square(r100, r101);
        SecP160R2Field.multiply(r101, r100, r101);
        int[] r102 = Nat160.create();
        SecP160R2Field.square(r101, r102);
        SecP160R2Field.multiply(r102, r100, r102);
        int[] r103 = Nat160.create();
        SecP160R2Field.square(r102, r103);
        SecP160R2Field.multiply(r103, r100, r103);
        int[] r104 = Nat160.create();
        SecP160R2Field.squareN(r103, 3, r104);
        SecP160R2Field.multiply(r104, r102, r104);
        SecP160R2Field.squareN(r104, 7, r103);
        SecP160R2Field.multiply(r103, r104, r103);
        SecP160R2Field.squareN(r103, 3, r104);
        SecP160R2Field.multiply(r104, r102, r104);
        int[] r105 = Nat160.create();
        SecP160R2Field.squareN(r104, 14, r105);
        SecP160R2Field.multiply(r105, r103, r105);
        SecP160R2Field.squareN(r105, 31, r103);
        SecP160R2Field.multiply(r103, r105, r103);
        SecP160R2Field.squareN(r103, 62, r105);
        SecP160R2Field.multiply(r105, r103, r105);
        SecP160R2Field.squareN(r105, 3, r103);
        SecP160R2Field.multiply(r103, r102, r103);
        SecP160R2Field.squareN(r103, 18, r103);
        SecP160R2Field.multiply(r103, r104, r103);
        SecP160R2Field.squareN(r103, 2, r103);
        SecP160R2Field.multiply(r103, r100, r103);
        SecP160R2Field.squareN(r103, 3, r103);
        SecP160R2Field.multiply(r103, r101, r103);
        SecP160R2Field.squareN(r103, 6, r103);
        SecP160R2Field.multiply(r103, r102, r103);
        SecP160R2Field.squareN(r103, 2, r103);
        SecP160R2Field.multiply(r103, r100, r103);
        SecP160R2Field.square(r103, r101);
        if (Nat160.eq(r100, r101) == true) goto L13;
        return null;
    L13:
        return new SecP160R2FieldElement(r103);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat160.create();
        SecP160R2Field.square(this.f525453x, r100);
        return new SecP160R2FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat160.create();
        SecP160R2Field.subtract(this.f525453x, ((SecP160R2FieldElement) r100).f525453x, r101);
        return new SecP160R2FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat160.getBit(this.f525453x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat160.toBigInteger(this.f525453x);
    }
}
