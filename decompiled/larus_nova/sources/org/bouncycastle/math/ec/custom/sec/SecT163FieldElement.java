package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SecT163FieldElement extends ECFieldElement.AbstractF2m {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected long[] f525472x;

    public SecT163FieldElement() {
        this.f525472x = Nat192.create64();
    }

    public SecT163FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.bitLength() > 163) goto L11;
        this.f525472x = SecT163Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
    }

    public SecT163FieldElement(long[] r100) {
        this.f525472x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        long[] r101 = Nat192.create64();
        SecT163Field.add(this.f525472x, ((SecT163FieldElement) r100).f525472x, r101);
        return new SecT163FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        long[] r100 = Nat192.create64();
        SecT163Field.addOne(this.f525472x, r100);
        return new SecT163FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        return multiply(r100.invert());
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecT163FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat192.eq64(this.f525472x, ((SecT163FieldElement) r100).f525472x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecT163Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return 163;
    }

    public int getK1() {
        return 3;
    }

    public int getK2() {
        return 6;
    }

    public int getK3() {
        return 7;
    }

    public int getM() {
        return 163;
    }

    public int getRepresentation() {
        return 3;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] r100 = Nat192.create64();
        SecT163Field.halfTrace(this.f525472x, r100);
        return new SecT163FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f525472x, 0, 3) ^ 163763;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        long[] r100 = Nat192.create64();
        SecT163Field.invert(this.f525472x, r100);
        return new SecT163FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat192.isOne64(this.f525472x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat192.isZero64(this.f525472x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        long[] r101 = Nat192.create64();
        SecT163Field.multiply(this.f525472x, ((SecT163FieldElement) r100).f525472x, r101);
        return new SecT163FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        return multiplyPlusProduct(r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        long[] r103 = this.f525472x;
        long[] r104 = ((SecT163FieldElement) r100).f525472x;
        long[] r105 = ((SecT163FieldElement) r101).f525472x;
        long[] r106 = ((SecT163FieldElement) r102).f525472x;
        long[] r107 = Nat192.createExt64();
        SecT163Field.multiplyAddToExt(r103, r104, r107);
        SecT163Field.multiplyAddToExt(r105, r106, r107);
        long[] r108 = Nat192.create64();
        SecT163Field.reduce(r107, r108);
        return new SecT163FieldElement(r108);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        long[] r100 = Nat192.create64();
        SecT163Field.sqrt(this.f525472x, r100);
        return new SecT163FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        long[] r100 = Nat192.create64();
        SecT163Field.square(this.f525472x, r100);
        return new SecT163FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement r100, ECFieldElement r101) {
        return squarePlusProduct(r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement r100, ECFieldElement r101) {
        long[] r102 = this.f525472x;
        long[] r103 = ((SecT163FieldElement) r100).f525472x;
        long[] r104 = ((SecT163FieldElement) r101).f525472x;
        long[] r105 = Nat192.createExt64();
        SecT163Field.squareAddToExt(r102, r105);
        SecT163Field.multiplyAddToExt(r103, r104, r105);
        long[] r106 = Nat192.create64();
        SecT163Field.reduce(r105, r106);
        return new SecT163FieldElement(r106);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePow(int r100) {
        if (r100 >= 1) goto L5;
        return this;
    L5:
        long[] r101 = Nat192.create64();
        SecT163Field.squareN(this.f525472x, r100, r101);
        return new SecT163FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        return add(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if ((this.f525472x[0] & 1) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat192.toBigInteger64(this.f525472x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public int trace() {
        return SecT163Field.trace(this.f525472x);
    }
}
