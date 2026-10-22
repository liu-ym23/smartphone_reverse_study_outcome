package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class SecP224R1FieldElement extends ECFieldElement.AbstractFp {
    public static final BigInteger Q = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int[] f525461x;

    static {
        Q = new BigInteger(1, Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));
    }

    public SecP224R1FieldElement() {
        this.f525461x = Nat224.create();
    }

    public SecP224R1FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.compareTo(Q) >= 0) goto L11;
        this.f525461x = SecP224R1Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
    }

    public SecP224R1FieldElement(int[] r100) {
        this.f525461x = r100;
    }

    private static void RM(int[] r100, int[] r101, int[] r102, int[] r103, int[] r104, int[] r105, int[] r106) {
        SecP224R1Field.multiply(r104, r102, r106);
        SecP224R1Field.multiply(r106, r100, r106);
        SecP224R1Field.multiply(r103, r101, r105);
        SecP224R1Field.add(r105, r106, r105);
        SecP224R1Field.multiply(r103, r102, r106);
        Nat224.copy(r105, r103);
        SecP224R1Field.multiply(r104, r101, r104);
        SecP224R1Field.add(r104, r106, r104);
        SecP224R1Field.square(r104, r105);
        SecP224R1Field.multiply(r105, r100, r105);
    }

    private static void RP(int[] r110, int[] r111, int[] r112, int[] r113, int[] r114) {
        Nat224.copy(r110, r113);
        int[] r100 = Nat224.create();
        int[] r101 = Nat224.create();
        int r102 = 0;
    L4:
        if (r102 >= 7) goto L10;
        Nat224.copy(r111, r100);
        Nat224.copy(r112, r101);
        int r103 = 1 << r102;
    L6:
        r103 = r103 - 1;
        if (r103 < 0) goto L9;
        RS(r111, r112, r113, r114);
        goto L6
    L9:
        RM(r110, r100, r101, r111, r112, r113, r114);
        r102 = r102 + 1;
        goto L4
    }

    private static void RS(int[] r100, int[] r101, int[] r102, int[] r103) {
        SecP224R1Field.multiply(r101, r100, r101);
        SecP224R1Field.twice(r101, r101);
        SecP224R1Field.square(r100, r103);
        SecP224R1Field.add(r102, r103, r100);
        SecP224R1Field.multiply(r102, r103, r102);
        SecP224R1Field.reduce32(Nat.shiftUpBits(7, r102, 2, 0), r102);
    }

    private static boolean isSquare(int[] r100) {
        int[] r101 = Nat224.create();
        int[] r102 = Nat224.create();
        Nat224.copy(r100, r101);
        int r103 = 0;
    L4:
        if (r103 >= 7) goto L6;
        Nat224.copy(r101, r102);
        SecP224R1Field.squareN(r101, 1 << r103, r101);
        SecP224R1Field.multiply(r101, r102, r101);
        r103 = r103 + 1;
        goto L4
    L6:
        SecP224R1Field.squareN(r101, 95, r101);
        return Nat224.isOne(r101);
    }

    private static boolean trySqrt(int[] r100, int[] r101, int[] r102) {
        int[] r103 = Nat224.create();
        Nat224.copy(r101, r103);
        int[] r104 = Nat224.create();
        r104[0] = 1;
        int[] r105 = Nat224.create();
        RP(r100, r103, r104, r105, r102);
        int[] r106 = Nat224.create();
        int[] r107 = Nat224.create();
        int r108 = 1;
    L4:
        if (r108 >= 96) goto L10;
        Nat224.copy(r103, r106);
        Nat224.copy(r104, r107);
        RS(r103, r104, r105, r102);
        if (Nat224.isZero(r103) == true) goto L7;
        r108 = r108 + 1;
        goto L4
    L7:
        SecP224R1Field.inv(r107, r102);
        SecP224R1Field.multiply(r102, r106, r102);
        return true;
    L10:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224R1Field.add(this.f525461x, ((SecP224R1FieldElement) r100).f525461x, r101);
        return new SecP224R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        int[] r100 = Nat224.create();
        SecP224R1Field.addOne(this.f525461x, r100);
        return new SecP224R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224R1Field.inv(((SecP224R1FieldElement) r100).f525461x, r101);
        SecP224R1Field.multiply(r101, this.f525461x, r101);
        return new SecP224R1FieldElement(r101);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecP224R1FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat224.eq(this.f525461x, ((SecP224R1FieldElement) r100).f525461x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecP224R1Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return Q.bitLength();
    }

    public int hashCode() {
        return Q.hashCode() ^ Arrays.hashCode(this.f525461x, 0, 7);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        int[] r100 = Nat224.create();
        SecP224R1Field.inv(this.f525461x, r100);
        return new SecP224R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat224.isOne(this.f525461x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat224.isZero(this.f525461x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224R1Field.multiply(this.f525461x, ((SecP224R1FieldElement) r100).f525461x, r101);
        return new SecP224R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        int[] r100 = Nat224.create();
        SecP224R1Field.negate(this.f525461x, r100);
        return new SecP224R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        int[] r100 = this.f525461x;
        if (Nat224.isZero(r100) == false) goto L5;
    L17:
        return this;
    L5:
        if (Nat224.isOne(r100) == true) goto L17;
        int[] r101 = Nat224.create();
        SecP224R1Field.negate(r100, r101);
        int[] r102 = Mod.random(SecP224R1Field.P);
        int[] r103 = Nat224.create();
        if (isSquare(r100) == true) goto L11;
        return null;
    L11:
        if (trySqrt(r101, r102, r103) == true) goto L13;
        SecP224R1Field.addOne(r102, r102);
        goto L11
    L13:
        SecP224R1Field.square(r103, r102);
        if (Nat224.eq(r100, r102) == true) goto L16;
        return null;
    L16:
        return new SecP224R1FieldElement(r103);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        int[] r100 = Nat224.create();
        SecP224R1Field.square(this.f525461x, r100);
        return new SecP224R1FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        int[] r101 = Nat224.create();
        SecP224R1Field.subtract(this.f525461x, ((SecP224R1FieldElement) r100).f525461x, r101);
        return new SecP224R1FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if (Nat224.getBit(this.f525461x, 0) != 1) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat224.toBigInteger(this.f525461x);
    }
}
