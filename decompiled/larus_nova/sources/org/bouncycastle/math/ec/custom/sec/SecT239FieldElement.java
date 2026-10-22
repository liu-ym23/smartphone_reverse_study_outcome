package org.bouncycastle.math.ec.custom.sec;

import com.ss.ttvideoengine.model.VideoRef;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class SecT239FieldElement extends ECFieldElement.AbstractF2m {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected long[] f525475x;

    public SecT239FieldElement() {
        this.f525475x = Nat256.create64();
    }

    public SecT239FieldElement(BigInteger r100) {
        if (r100 == null) goto L11;
        if (r100.signum() < 0) goto L11;
        if (r100.bitLength() > 239) goto L11;
        this.f525475x = SecT239Field.fromBigInteger(r100);
        return;
    L11:
        throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
    }

    public SecT239FieldElement(long[] r100) {
        this.f525475x = r100;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement add(ECFieldElement r100) {
        long[] r101 = Nat256.create64();
        SecT239Field.add(this.f525475x, ((SecT239FieldElement) r100).f525475x, r101);
        return new SecT239FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement addOne() {
        long[] r100 = Nat256.create64();
        SecT239Field.addOne(this.f525475x, r100);
        return new SecT239FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement divide(ECFieldElement r100) {
        return multiply(r100.invert());
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof SecT239FieldElement) == true) goto L10;
        return false;
    L10:
        return Nat256.eq64(this.f525475x, ((SecT239FieldElement) r100).f525475x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public String getFieldName() {
        return "SecT239Field";
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public int getFieldSize() {
        return VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X;
    }

    public int getK1() {
        return 158;
    }

    public int getK2() {
        return 0;
    }

    public int getK3() {
        return 0;
    }

    public int getM() {
        return VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X;
    }

    public int getRepresentation() {
        return 2;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public ECFieldElement halfTrace() {
        long[] r100 = Nat256.create64();
        SecT239Field.halfTrace(this.f525475x, r100);
        return new SecT239FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public boolean hasFastTrace() {
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f525475x, 0, 4) ^ 23900158;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement invert() {
        long[] r100 = Nat256.create64();
        SecT239Field.invert(this.f525475x, r100);
        return new SecT239FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isOne() {
        return Nat256.isOne64(this.f525475x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean isZero() {
        return Nat256.isZero64(this.f525475x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiply(ECFieldElement r100) {
        long[] r101 = Nat256.create64();
        SecT239Field.multiply(this.f525475x, ((SecT239FieldElement) r100).f525475x, r101);
        return new SecT239FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyMinusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        return multiplyPlusProduct(r100, r101, r102);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement multiplyPlusProduct(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102) {
        long[] r103 = this.f525475x;
        long[] r104 = ((SecT239FieldElement) r100).f525475x;
        long[] r105 = ((SecT239FieldElement) r101).f525475x;
        long[] r106 = ((SecT239FieldElement) r102).f525475x;
        long[] r107 = Nat256.createExt64();
        SecT239Field.multiplyAddToExt(r103, r104, r107);
        SecT239Field.multiplyAddToExt(r105, r106, r107);
        long[] r108 = Nat256.create64();
        SecT239Field.reduce(r107, r108);
        return new SecT239FieldElement(r108);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement negate() {
        return this;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement sqrt() {
        long[] r100 = Nat256.create64();
        SecT239Field.sqrt(this.f525475x, r100);
        return new SecT239FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement square() {
        long[] r100 = Nat256.create64();
        SecT239Field.square(this.f525475x, r100);
        return new SecT239FieldElement(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squareMinusProduct(ECFieldElement r100, ECFieldElement r101) {
        return squarePlusProduct(r100, r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePlusProduct(ECFieldElement r100, ECFieldElement r101) {
        long[] r102 = this.f525475x;
        long[] r103 = ((SecT239FieldElement) r100).f525475x;
        long[] r104 = ((SecT239FieldElement) r101).f525475x;
        long[] r105 = Nat256.createExt64();
        SecT239Field.squareAddToExt(r102, r105);
        SecT239Field.multiplyAddToExt(r103, r104, r105);
        long[] r106 = Nat256.create64();
        SecT239Field.reduce(r105, r106);
        return new SecT239FieldElement(r106);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement squarePow(int r100) {
        if (r100 >= 1) goto L5;
        return this;
    L5:
        long[] r101 = Nat256.create64();
        SecT239Field.squareN(this.f525475x, r100, r101);
        return new SecT239FieldElement(r101);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public ECFieldElement subtract(ECFieldElement r100) {
        return add(r100);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public boolean testBitZero() {
        if ((this.f525475x[0] & 1) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement
    public BigInteger toBigInteger() {
        return Nat256.toBigInteger64(this.f525475x);
    }

    @Override // org.bouncycastle.math.ec.ECFieldElement.AbstractF2m
    public int trace() {
        return SecT239Field.trace(this.f525475x);
    }
}
