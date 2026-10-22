package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;

/* JADX INFO: loaded from: classes42.dex */
public class SecP384R1Point extends ECPoint.AbstractFp {
    public SecP384R1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        super(r100, r101, r102);
    }

    public SecP384R1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
        super(r100, r101, r102, r103);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint add(ECPoint r110) {
        if (isInfinity() == false) goto L6;
        return r110;
    L6:
        if (r110.isInfinity() == false) goto L8;
        return this;
    L8:
        if (this == r110) goto L10;
        ECCurve r100 = getCurve();
        SecP384R1FieldElement r101 = (SecP384R1FieldElement) this.f525438x;
        SecP384R1FieldElement r102 = (SecP384R1FieldElement) this.f525439y;
        SecP384R1FieldElement r103 = (SecP384R1FieldElement) r110.getXCoord();
        SecP384R1FieldElement r104 = (SecP384R1FieldElement) r110.getYCoord();
        SecP384R1FieldElement r105 = (SecP384R1FieldElement) this.f525440zs[0];
        SecP384R1FieldElement r106 = (SecP384R1FieldElement) r110.getZCoord(0);
        int[] r111 = Nat.create(24);
        int[] r107 = Nat.create(24);
        int[] r112 = Nat.create(12);
        int[] r113 = Nat.create(12);
        boolean r114 = r105.isOne();
        if (r114 == false) goto L14;
        int[] r108 = r103.f525467x;
        int[] r109 = r104.f525467x;
    L15:
        boolean r115 = r106.isOne();
        if (r115 == false) goto L18;
        int[] r116 = r101.f525467x;
        int[] r117 = r102.f525467x;
    L19:
        int[] r118 = Nat.create(12);
        SecP384R1Field.subtract(r116, r108, r118);
        int[] r119 = Nat.create(12);
        SecP384R1Field.subtract(r117, r109, r119);
        if (Nat.isZero(12, r118) == true) goto L22;
        SecP384R1Field.square(r118, r112);
        int[] r120 = Nat.create(12);
        SecP384R1Field.multiply(r112, r118, r120);
        SecP384R1Field.multiply(r112, r116, r112);
        SecP384R1Field.negate(r120, r120);
        Nat384.mul(r117, r120, r111);
        SecP384R1Field.reduce32(Nat.addBothTo(12, r112, r112, r120), r120);
        SecP384R1FieldElement r121 = new SecP384R1FieldElement(r113);
        SecP384R1Field.square(r119, r121.f525467x);
        int[] r122 = r121.f525467x;
        SecP384R1Field.subtract(r122, r120, r122);
        SecP384R1FieldElement r123 = new SecP384R1FieldElement(r120);
        SecP384R1Field.subtract(r112, r121.f525467x, r123.f525467x);
        Nat384.mul(r123.f525467x, r119, r107);
        SecP384R1Field.addExt(r111, r107, r111);
        SecP384R1Field.reduce(r111, r123.f525467x);
        SecP384R1FieldElement r124 = new SecP384R1FieldElement(r118);
        if (r114 == true) goto L30;
        int[] r125 = r124.f525467x;
        SecP384R1Field.multiply(r125, r105.f525467x, r125);
    L30:
        if (r115 == true) goto L33;
        int[] r126 = r124.f525467x;
        SecP384R1Field.multiply(r126, r106.f525467x, r126);
    L33:
        return new SecP384R1Point(r100, r121, r123, new ECFieldElement[]{r124});
    L22:
        if (Nat.isZero(12, r119) == false) goto L26;
        return twice();
    L26:
        return r100.getInfinity();
    L18:
        SecP384R1Field.square(r106.f525467x, r113);
        SecP384R1Field.multiply(r113, r101.f525467x, r111);
        SecP384R1Field.multiply(r113, r106.f525467x, r113);
        SecP384R1Field.multiply(r113, r102.f525467x, r113);
        r116 = r111;
        r117 = r113;
        goto L19
    L14:
        SecP384R1Field.square(r105.f525467x, r112);
        SecP384R1Field.multiply(r112, r103.f525467x, r107);
        SecP384R1Field.multiply(r112, r105.f525467x, r112);
        SecP384R1Field.multiply(r112, r104.f525467x, r112);
        r108 = r107;
        r109 = r112;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP384R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP384R1Point(this.curve, this.f525438x, this.f525439y.negate(), this.f525440zs);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint threeTimes() {
        if (isInfinity() == false) goto L5;
    L9:
        return this;
    L5:
        if (this.f525439y.isZero() == true) goto L9;
        return twice().add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r100 = getCurve();
        SecP384R1FieldElement r101 = (SecP384R1FieldElement) this.f525439y;
        if (r101.isZero() == true) goto L8;
        SecP384R1FieldElement r102 = (SecP384R1FieldElement) this.f525438x;
        SecP384R1FieldElement r103 = (SecP384R1FieldElement) this.f525440zs[0];
        int[] r104 = Nat.create(12);
        int[] r105 = Nat.create(12);
        int[] r106 = Nat.create(12);
        SecP384R1Field.square(r101.f525467x, r106);
        int[] r107 = Nat.create(12);
        SecP384R1Field.square(r106, r107);
        boolean r110 = r103.isOne();
        int[] r111 = r103.f525467x;
        if (r110 == true) goto L12;
        SecP384R1Field.square(r111, r105);
        r111 = r105;
    L12:
        SecP384R1Field.subtract(r102.f525467x, r111, r104);
        SecP384R1Field.add(r102.f525467x, r111, r105);
        SecP384R1Field.multiply(r105, r104, r105);
        SecP384R1Field.reduce32(Nat.addBothTo(12, r105, r105, r105), r105);
        SecP384R1Field.multiply(r106, r102.f525467x, r106);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, r106, 2, 0), r106);
        SecP384R1Field.reduce32(Nat.shiftUpBits(12, r107, 3, 0, r104), r104);
        SecP384R1FieldElement r108 = new SecP384R1FieldElement(r107);
        SecP384R1Field.square(r105, r108.f525467x);
        int[] r109 = r108.f525467x;
        SecP384R1Field.subtract(r109, r106, r109);
        int[] r112 = r108.f525467x;
        SecP384R1Field.subtract(r112, r106, r112);
        SecP384R1FieldElement r113 = new SecP384R1FieldElement(r106);
        SecP384R1Field.subtract(r106, r108.f525467x, r113.f525467x);
        int[] r114 = r113.f525467x;
        SecP384R1Field.multiply(r114, r105, r114);
        int[] r115 = r113.f525467x;
        SecP384R1Field.subtract(r115, r104, r115);
        SecP384R1FieldElement r116 = new SecP384R1FieldElement(r105);
        SecP384R1Field.twice(r101.f525467x, r116.f525467x);
        if (r110 == true) goto L16;
        int[] r117 = r116.f525467x;
        SecP384R1Field.multiply(r117, r103.f525467x, r117);
    L16:
        return new SecP384R1Point(r100, r108, r113, new ECFieldElement[]{r116});
    L8:
        return r100.getInfinity();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twicePlus(ECPoint r100) {
        if (this != r100) goto L6;
        return threeTimes();
    L6:
        if (isInfinity() == false) goto L9;
        return r100;
    L9:
        if (r100.isInfinity() == false) goto L13;
        return twice();
    L13:
        if (this.f525439y.isZero() == false) goto L16;
        return r100;
    L16:
        return twice().add(r100);
    }
}
