package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat160;

/* JADX INFO: loaded from: classes42.dex */
public class SecP160R2Point extends ECPoint.AbstractFp {
    public SecP160R2Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        super(r100, r101, r102);
    }

    public SecP160R2Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
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
        SecP160R2FieldElement r101 = (SecP160R2FieldElement) this.f525438x;
        SecP160R2FieldElement r102 = (SecP160R2FieldElement) this.f525439y;
        SecP160R2FieldElement r103 = (SecP160R2FieldElement) r110.getXCoord();
        SecP160R2FieldElement r104 = (SecP160R2FieldElement) r110.getYCoord();
        SecP160R2FieldElement r105 = (SecP160R2FieldElement) this.f525440zs[0];
        SecP160R2FieldElement r111 = (SecP160R2FieldElement) r110.getZCoord(0);
        int[] r106 = Nat160.createExt();
        int[] r107 = Nat160.create();
        int[] r108 = Nat160.create();
        int[] r112 = Nat160.create();
        boolean r113 = r105.isOne();
        if (r113 == false) goto L14;
        int[] r109 = r103.f525453x;
        int[] r114 = r104.f525453x;
    L15:
        boolean r115 = r111.isOne();
        if (r115 == false) goto L18;
        int[] r116 = r101.f525453x;
        int[] r117 = r102.f525453x;
    L19:
        int[] r118 = Nat160.create();
        SecP160R2Field.subtract(r116, r109, r118);
        SecP160R2Field.subtract(r117, r114, r107);
        if (Nat160.isZero(r118) == true) goto L22;
        SecP160R2Field.square(r118, r108);
        int[] r119 = Nat160.create();
        SecP160R2Field.multiply(r108, r118, r119);
        SecP160R2Field.multiply(r108, r116, r108);
        SecP160R2Field.negate(r119, r119);
        Nat160.mul(r117, r119, r106);
        SecP160R2Field.reduce32(Nat160.addBothTo(r108, r108, r119), r119);
        SecP160R2FieldElement r120 = new SecP160R2FieldElement(r112);
        SecP160R2Field.square(r107, r120.f525453x);
        int[] r121 = r120.f525453x;
        SecP160R2Field.subtract(r121, r119, r121);
        SecP160R2FieldElement r122 = new SecP160R2FieldElement(r119);
        SecP160R2Field.subtract(r108, r120.f525453x, r122.f525453x);
        SecP160R2Field.multiplyAddToExt(r122.f525453x, r107, r106);
        SecP160R2Field.reduce(r106, r122.f525453x);
        SecP160R2FieldElement r123 = new SecP160R2FieldElement(r118);
        if (r113 == true) goto L30;
        int[] r124 = r123.f525453x;
        SecP160R2Field.multiply(r124, r105.f525453x, r124);
    L30:
        if (r115 == true) goto L33;
        int[] r125 = r123.f525453x;
        SecP160R2Field.multiply(r125, r111.f525453x, r125);
    L33:
        return new SecP160R2Point(r100, r120, r122, new ECFieldElement[]{r123});
    L22:
        if (Nat160.isZero(r107) == false) goto L26;
        return twice();
    L26:
        return r100.getInfinity();
    L18:
        SecP160R2Field.square(r111.f525453x, r112);
        SecP160R2Field.multiply(r112, r101.f525453x, r106);
        SecP160R2Field.multiply(r112, r111.f525453x, r112);
        SecP160R2Field.multiply(r112, r102.f525453x, r112);
        r116 = r106;
        r117 = r112;
        goto L19
    L14:
        SecP160R2Field.square(r105.f525453x, r108);
        SecP160R2Field.multiply(r108, r103.f525453x, r107);
        SecP160R2Field.multiply(r108, r105.f525453x, r108);
        SecP160R2Field.multiply(r108, r104.f525453x, r108);
        r109 = r107;
        r114 = r108;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP160R2Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP160R2Point(this.curve, this.f525438x, this.f525439y.negate(), this.f525440zs);
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
        SecP160R2FieldElement r101 = (SecP160R2FieldElement) this.f525439y;
        if (r101.isZero() == true) goto L8;
        SecP160R2FieldElement r102 = (SecP160R2FieldElement) this.f525438x;
        SecP160R2FieldElement r103 = (SecP160R2FieldElement) this.f525440zs[0];
        int[] r104 = Nat160.create();
        int[] r105 = Nat160.create();
        int[] r106 = Nat160.create();
        SecP160R2Field.square(r101.f525453x, r106);
        int[] r107 = Nat160.create();
        SecP160R2Field.square(r106, r107);
        boolean r108 = r103.isOne();
        int[] r110 = r103.f525453x;
        if (r108 == true) goto L12;
        SecP160R2Field.square(r110, r105);
        r110 = r105;
    L12:
        SecP160R2Field.subtract(r102.f525453x, r110, r104);
        SecP160R2Field.add(r102.f525453x, r110, r105);
        SecP160R2Field.multiply(r105, r104, r105);
        SecP160R2Field.reduce32(Nat160.addBothTo(r105, r105, r105), r105);
        SecP160R2Field.multiply(r106, r102.f525453x, r106);
        SecP160R2Field.reduce32(Nat.shiftUpBits(5, r106, 2, 0), r106);
        SecP160R2Field.reduce32(Nat.shiftUpBits(5, r107, 3, 0, r104), r104);
        SecP160R2FieldElement r109 = new SecP160R2FieldElement(r107);
        SecP160R2Field.square(r105, r109.f525453x);
        int[] r111 = r109.f525453x;
        SecP160R2Field.subtract(r111, r106, r111);
        int[] r112 = r109.f525453x;
        SecP160R2Field.subtract(r112, r106, r112);
        SecP160R2FieldElement r113 = new SecP160R2FieldElement(r106);
        SecP160R2Field.subtract(r106, r109.f525453x, r113.f525453x);
        int[] r114 = r113.f525453x;
        SecP160R2Field.multiply(r114, r105, r114);
        int[] r115 = r113.f525453x;
        SecP160R2Field.subtract(r115, r104, r115);
        SecP160R2FieldElement r116 = new SecP160R2FieldElement(r105);
        SecP160R2Field.twice(r101.f525453x, r116.f525453x);
        if (r108 == true) goto L16;
        int[] r117 = r116.f525453x;
        SecP160R2Field.multiply(r117, r103.f525453x, r117);
    L16:
        return new SecP160R2Point(r100, r109, r113, new ECFieldElement[]{r116});
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
