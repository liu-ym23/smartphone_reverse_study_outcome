package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

/* JADX INFO: loaded from: classes42.dex */
public class SecP192K1Point extends ECPoint.AbstractFp {
    public SecP192K1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        super(r100, r101, r102);
    }

    public SecP192K1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
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
        SecP192K1FieldElement r101 = (SecP192K1FieldElement) this.f525438x;
        SecP192K1FieldElement r102 = (SecP192K1FieldElement) this.f525439y;
        SecP192K1FieldElement r103 = (SecP192K1FieldElement) r110.getXCoord();
        SecP192K1FieldElement r104 = (SecP192K1FieldElement) r110.getYCoord();
        SecP192K1FieldElement r105 = (SecP192K1FieldElement) this.f525440zs[0];
        SecP192K1FieldElement r111 = (SecP192K1FieldElement) r110.getZCoord(0);
        int[] r106 = Nat192.createExt();
        int[] r107 = Nat192.create();
        int[] r108 = Nat192.create();
        int[] r112 = Nat192.create();
        boolean r113 = r105.isOne();
        if (r113 == false) goto L14;
        int[] r109 = r103.f525455x;
        int[] r114 = r104.f525455x;
    L15:
        boolean r115 = r111.isOne();
        if (r115 == false) goto L18;
        int[] r116 = r101.f525455x;
        int[] r117 = r102.f525455x;
    L19:
        int[] r118 = Nat192.create();
        SecP192K1Field.subtract(r116, r109, r118);
        SecP192K1Field.subtract(r117, r114, r107);
        if (Nat192.isZero(r118) == true) goto L22;
        SecP192K1Field.square(r118, r108);
        int[] r119 = Nat192.create();
        SecP192K1Field.multiply(r108, r118, r119);
        SecP192K1Field.multiply(r108, r116, r108);
        SecP192K1Field.negate(r119, r119);
        Nat192.mul(r117, r119, r106);
        SecP192K1Field.reduce32(Nat192.addBothTo(r108, r108, r119), r119);
        SecP192K1FieldElement r120 = new SecP192K1FieldElement(r112);
        SecP192K1Field.square(r107, r120.f525455x);
        int[] r121 = r120.f525455x;
        SecP192K1Field.subtract(r121, r119, r121);
        SecP192K1FieldElement r122 = new SecP192K1FieldElement(r119);
        SecP192K1Field.subtract(r108, r120.f525455x, r122.f525455x);
        SecP192K1Field.multiplyAddToExt(r122.f525455x, r107, r106);
        SecP192K1Field.reduce(r106, r122.f525455x);
        SecP192K1FieldElement r123 = new SecP192K1FieldElement(r118);
        if (r113 == true) goto L30;
        int[] r124 = r123.f525455x;
        SecP192K1Field.multiply(r124, r105.f525455x, r124);
    L30:
        if (r115 == true) goto L33;
        int[] r125 = r123.f525455x;
        SecP192K1Field.multiply(r125, r111.f525455x, r125);
    L33:
        return new SecP192K1Point(r100, r120, r122, new ECFieldElement[]{r123});
    L22:
        if (Nat192.isZero(r107) == false) goto L26;
        return twice();
    L26:
        return r100.getInfinity();
    L18:
        SecP192K1Field.square(r111.f525455x, r112);
        SecP192K1Field.multiply(r112, r101.f525455x, r106);
        SecP192K1Field.multiply(r112, r111.f525455x, r112);
        SecP192K1Field.multiply(r112, r102.f525455x, r112);
        r116 = r106;
        r117 = r112;
        goto L19
    L14:
        SecP192K1Field.square(r105.f525455x, r108);
        SecP192K1Field.multiply(r108, r103.f525455x, r107);
        SecP192K1Field.multiply(r108, r105.f525455x, r108);
        SecP192K1Field.multiply(r108, r104.f525455x, r108);
        r109 = r107;
        r114 = r108;
        goto L15
    L10:
        return twice();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecP192K1Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new SecP192K1Point(this.curve, this.f525438x, this.f525439y.negate(), this.f525440zs);
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
        SecP192K1FieldElement r101 = (SecP192K1FieldElement) this.f525439y;
        if (r101.isZero() == true) goto L8;
        SecP192K1FieldElement r102 = (SecP192K1FieldElement) this.f525438x;
        SecP192K1FieldElement r103 = (SecP192K1FieldElement) this.f525440zs[0];
        int[] r104 = Nat192.create();
        SecP192K1Field.square(r101.f525455x, r104);
        int[] r105 = Nat192.create();
        SecP192K1Field.square(r104, r105);
        int[] r106 = Nat192.create();
        SecP192K1Field.square(r102.f525455x, r106);
        SecP192K1Field.reduce32(Nat192.addBothTo(r106, r106, r106), r106);
        SecP192K1Field.multiply(r104, r102.f525455x, r104);
        SecP192K1Field.reduce32(Nat.shiftUpBits(6, r104, 2, 0), r104);
        int[] r107 = Nat192.create();
        SecP192K1Field.reduce32(Nat.shiftUpBits(6, r105, 3, 0, r107), r107);
        SecP192K1FieldElement r108 = new SecP192K1FieldElement(r105);
        SecP192K1Field.square(r106, r108.f525455x);
        int[] r109 = r108.f525455x;
        SecP192K1Field.subtract(r109, r104, r109);
        int[] r110 = r108.f525455x;
        SecP192K1Field.subtract(r110, r104, r110);
        SecP192K1FieldElement r111 = new SecP192K1FieldElement(r104);
        SecP192K1Field.subtract(r104, r108.f525455x, r111.f525455x);
        int[] r112 = r111.f525455x;
        SecP192K1Field.multiply(r112, r106, r112);
        int[] r113 = r111.f525455x;
        SecP192K1Field.subtract(r113, r107, r113);
        SecP192K1FieldElement r114 = new SecP192K1FieldElement(r106);
        SecP192K1Field.twice(r101.f525455x, r114.f525455x);
        if (r103.isOne() == true) goto L13;
        int[] r115 = r114.f525455x;
        SecP192K1Field.multiply(r115, r103.f525455x, r115);
    L13:
        return new SecP192K1Point(r100, r108, r111, new ECFieldElement[]{r114});
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
