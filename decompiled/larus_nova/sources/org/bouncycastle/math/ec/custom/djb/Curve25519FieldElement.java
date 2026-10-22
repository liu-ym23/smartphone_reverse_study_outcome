package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class Curve25519FieldElement extends ECFieldElement.AbstractFp {
    private static final int[] PRECOMP_POW2 = null;
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525444x;

    static {
        Q = Nat256.toBigInteger(Curve25519Field.P);
        PRECOMP_POW2 = new int[]{1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};
    }

    public Curve25519FieldElement() {
        this.f525444x = Nat256.create();
    }

    public Curve25519FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525444x = Curve25519Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
    }

    public Curve25519FieldElement(int[] r100) {
        this.f525444x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        Curve25519Field.add(this.f525444x, ((Curve25519FieldElement) r100).f525444x, r101);
        return new Curve25519FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat256.create();
        Curve25519Field.addOne(this.f525444x, r100);
        return new Curve25519FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        Curve25519Field.inv(((Curve25519FieldElement) r100).f525444x, r101);
        Curve25519Field.multiply(r101, this.f525444x, r101);
        return new Curve25519FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Curve25519FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat256.eq(this.f525444x, ((Curve25519FieldElement) r100).f525444x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "Curve25519Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525444x, 0, 8);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat256.create();
        Curve25519Field.inv(this.f525444x, r100);
        return new Curve25519FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne(this.f525444x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero(this.f525444x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        Curve25519Field.multiply(this.f525444x, ((Curve25519FieldElement) r100).f525444x, r101);
        return new Curve25519FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat256.create();
        Curve25519Field.negate(this.f525444x, r100);
        return new Curve25519FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525444x;
        if (Nat256.isZero(r100) == false) goto L5;
    L17:
        return this;
    L5:
        if (Nat256.isOne(r100) == true) goto L17;
        int[] r101 = Nat256.create();
        Curve25519Field.square(r100, r101);
        Curve25519Field.multiply(r101, r100, r101);
        Curve25519Field.square(r101, r101);
        Curve25519Field.multiply(r101, r100, r101);
        int[] r102 = Nat256.create();
        Curve25519Field.square(r101, r102);
        Curve25519Field.multiply(r102, r100, r102);
        int[] r103 = Nat256.create();
        Curve25519Field.squareN(r102, 3, r103);
        Curve25519Field.multiply(r103, r101, r103);
        Curve25519Field.squareN(r103, 4, r101);
        Curve25519Field.multiply(r101, r102, r101);
        Curve25519Field.squareN(r101, 4, r103);
        Curve25519Field.multiply(r103, r102, r103);
        Curve25519Field.squareN(r103, 15, r102);
        Curve25519Field.multiply(r102, r103, r102);
        Curve25519Field.squareN(r102, 30, r103);
        Curve25519Field.multiply(r103, r102, r103);
        Curve25519Field.squareN(r103, 60, r102);
        Curve25519Field.multiply(r102, r103, r102);
        Curve25519Field.squareN(r102, 11, r103);
        Curve25519Field.multiply(r103, r101, r103);
        Curve25519Field.squareN(r103, 120, r101);
        Curve25519Field.multiply(r101, r102, r101);
        Curve25519Field.square(r101, r101);
        Curve25519Field.square(r101, r102);
        if (Nat256.eq(r100, r102) == true) goto L10;
        Curve25519Field.multiply(r101, PRECOMP_POW2, r101);
        Curve25519Field.square(r101, r102);
        if (Nat256.eq(r100, r102) == true) goto L14;
        return null;
    L14:
        return new Curve25519FieldElement(r101);
    L10:
        return new Curve25519FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat256.create();
        Curve25519Field.square(this.f525444x, r100);
        return new Curve25519FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat256.create();
        Curve25519Field.subtract(this.f525444x, ((Curve25519FieldElement) r100).f525444x, r101);
        return new Curve25519FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat256.getBit(this.f525444x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger(this.f525444x);
    }
}
