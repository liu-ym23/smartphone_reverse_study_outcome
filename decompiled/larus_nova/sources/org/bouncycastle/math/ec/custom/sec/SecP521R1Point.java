package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes42.dex */
public class SecP521R1Point extends ECPoint.AbstractFp {
    public SecP521R1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        super(r100, r101, r102);
    }

    public SecP521R1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
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
        SecP521R1FieldElement r101 = (SecP521R1FieldElement) this.f525438x;
        SecP521R1FieldElement r102 = (SecP521R1FieldElement) this.f525439y;
        SecP521R1FieldElement r103 = (SecP521R1FieldElement) r110.getXCoord();
        SecP521R1FieldElement r104 = (SecP521R1FieldElement) r110.getYCoord();
        SecP521R1FieldElement r105 = (SecP521R1FieldElement) this.f525440zs[0];
        SecP521R1FieldElement r106 = (SecP521R1FieldElement) r110.getZCoord(0);
        int[] r111 = Nat.create(17);
        int[] r112 = Nat.create(17);
        int[] r113 = Nat.create(17);
        int[] r114 = Nat.create(17);
        boolean r115 = r105.isOne();
        if (r115 == false) goto L14;
        int[] r107 = r103.f525469x;
        int[] r108 = r104.f525469x;
    L15:
        boolean r116 = r106.isOne();
        if (r116 == false) goto L18;
        int[] r109 = r101.f525469x;
        int[] r117 = r102.f525469x;
    L19:
        int[] r118 = Nat.create(17);
        SecP521R1Field.subtract(r109, r107, r118);
        SecP521R1Field.subtract(r117, r108, r112);
        if (Nat.isZero(17, r118) == true) goto L22;
        SecP521R1Field.square(r118, r113);
        int[] r119 = Nat.create(17);
        SecP521R1Field.multiply(r113, r118, r119);
        SecP521R1Field.multiply(r113, r109, r113);
        SecP521R1Field.multiply(r117, r119, r111);
        SecP521R1FieldElement r120 = new SecP521R1FieldElement(r114);
        SecP521R1Field.square(r112, r120.f525469x);
        int[] r121 = r120.f525469x;
        SecP521R1Field.add(r121, r119, r121);
        int[] r122 = r120.f525469x;
        SecP521R1Field.subtract(r122, r113, r122);
        int[] r123 = r120.f525469x;
        SecP521R1Field.subtract(r123, r113, r123);
        SecP521R1FieldElement r124 = new SecP521R1FieldElement(r119);
        SecP521R1Field.subtract(r113, r120.f525469x, r124.f525469x);
        SecP521R1Field.multiply(r124.f525469x, r112, r112);
        SecP521R1Field.subtract(r112, r111, r124.f525469x);
        SecP521R1FieldElement r125 = new SecP521R1FieldElement(r118);
        if (r115 == true) goto L30;
        int[] r126 = r125.f525469x;
        SecP521R1Field.multiply(r126, r105.f525469x, r126);
    L30:
        if (r116 == true) goto L33;
        int[] r127 = r125.f525469x;
        SecP521R1Field.multiply(r127, r106.f525469x, r127);
    L33:
        return new SecP521R1Point(r100, r120, r124, new ECFieldElement[]{r125});
    L22:
        if (Nat.isZero(17, r112) == false) goto L26;
        return twice();
    L26:
        return r100.getInfinity();
    L18:
        SecP521R1Field.square(r106.f525469x, r114);
        SecP521R1Field.multiply(r114, r101.f525469x, r111);
        SecP521R1Field.multiply(r114, r106.f525469x, r114);
        SecP521R1Field.multiply(r114, r102.f525469x, r114);
        r109 = r111;
        r117 = r114;
        goto L19
    L14:
        SecP521R1Field.square(r105.f525469x, r113);
        SecP521R1Field.multiply(r113, r103.f525469x, r112);
        SecP521R1Field.multiply(r113, r105.f525469x, r113);
        SecP521R1Field.multiply(r113, r104.f525469x, r113);
        r107 = r112;
        r108 = r113;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP521R1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    public ECFieldElement doubleProductFromSquares(ECFieldElement r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement r103) {
        return r100.add(r101).square().subtract(r102).subtract(r103);
    }

    public ECFieldElement eight(ECFieldElement r100) {
        return four(two(r100));
    }

    public ECFieldElement four(ECFieldElement r100) {
        return two(two(r100));
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP521R1Point(this.curve, this.f525438x, this.f525439y.negate(), this.f525440zs);
    }

    public ECFieldElement three(ECFieldElement r100) {
        return two(r100).add(r100);
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
        SecP521R1FieldElement r101 = (SecP521R1FieldElement) this.f525439y;
        if (r101.isZero() == true) goto L8;
        SecP521R1FieldElement r102 = (SecP521R1FieldElement) this.f525438x;
        SecP521R1FieldElement r103 = (SecP521R1FieldElement) this.f525440zs[0];
        int[] r104 = Nat.create(17);
        int[] r105 = Nat.create(17);
        int[] r106 = Nat.create(17);
        SecP521R1Field.square(r101.f525469x, r106);
        int[] r107 = Nat.create(17);
        SecP521R1Field.square(r106, r107);
        boolean r110 = r103.isOne();
        int[] r111 = r103.f525469x;
        if (r110 == true) goto L12;
        SecP521R1Field.square(r111, r105);
        r111 = r105;
    L12:
        SecP521R1Field.subtract(r102.f525469x, r111, r104);
        SecP521R1Field.add(r102.f525469x, r111, r105);
        SecP521R1Field.multiply(r105, r104, r105);
        Nat.addBothTo(17, r105, r105, r105);
        SecP521R1Field.reduce23(r105);
        SecP521R1Field.multiply(r106, r102.f525469x, r106);
        Nat.shiftUpBits(17, r106, 2, 0);
        SecP521R1Field.reduce23(r106);
        Nat.shiftUpBits(17, r107, 3, 0, r104);
        SecP521R1Field.reduce23(r104);
        SecP521R1FieldElement r108 = new SecP521R1FieldElement(r107);
        SecP521R1Field.square(r105, r108.f525469x);
        int[] r109 = r108.f525469x;
        SecP521R1Field.subtract(r109, r106, r109);
        int[] r112 = r108.f525469x;
        SecP521R1Field.subtract(r112, r106, r112);
        SecP521R1FieldElement r113 = new SecP521R1FieldElement(r106);
        SecP521R1Field.subtract(r106, r108.f525469x, r113.f525469x);
        int[] r114 = r113.f525469x;
        SecP521R1Field.multiply(r114, r105, r114);
        int[] r115 = r113.f525469x;
        SecP521R1Field.subtract(r115, r104, r115);
        SecP521R1FieldElement r116 = new SecP521R1FieldElement(r105);
        SecP521R1Field.twice(r101.f525469x, r116.f525469x);
        if (r110 == true) goto L16;
        int[] r117 = r116.f525469x;
        SecP521R1Field.multiply(r117, r103.f525469x, r117);
    L16:
        return new SecP521R1Point(r100, r108, r113, new ECFieldElement[]{r116});
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

    public ECFieldElement two(ECFieldElement r100) {
        return r100.add(r100);
    }
}
