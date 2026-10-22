package org.bouncycastle.math.ec.custom.djb;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat256;

/* JADX INFO: loaded from: classes42.dex */
public class Curve25519Point extends ECPoint.AbstractFp {
    public Curve25519Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        super(r100, r101, r102);
    }

    public Curve25519Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
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
        Curve25519FieldElement r101 = (Curve25519FieldElement) this.f525438x;
        Curve25519FieldElement r102 = (Curve25519FieldElement) this.f525439y;
        Curve25519FieldElement r103 = (Curve25519FieldElement) this.f525440zs[0];
        Curve25519FieldElement r104 = (Curve25519FieldElement) r110.getXCoord();
        Curve25519FieldElement r105 = (Curve25519FieldElement) r110.getYCoord();
        Curve25519FieldElement r111 = (Curve25519FieldElement) r110.getZCoord(0);
        int[] r106 = Nat256.createExt();
        int[] r107 = Nat256.create();
        int[] r108 = Nat256.create();
        int[] r112 = Nat256.create();
        boolean r113 = r103.isOne();
        if (r113 == false) goto L14;
        int[] r109 = r104.f525444x;
        int[] r114 = r105.f525444x;
    L15:
        boolean r115 = r111.isOne();
        if (r115 == false) goto L18;
        int[] r116 = r101.f525444x;
        int[] r117 = r102.f525444x;
    L19:
        int[] r118 = Nat256.create();
        Curve25519Field.subtract(r116, r109, r118);
        Curve25519Field.subtract(r117, r114, r107);
        if (Nat256.isZero(r118) == true) goto L22;
        int[] r119 = Nat256.create();
        Curve25519Field.square(r118, r119);
        int[] r120 = Nat256.create();
        Curve25519Field.multiply(r119, r118, r120);
        Curve25519Field.multiply(r119, r116, r108);
        Curve25519Field.negate(r120, r120);
        Nat256.mul(r117, r120, r106);
        Curve25519Field.reduce27(Nat256.addBothTo(r108, r108, r120), r120);
        Curve25519FieldElement r121 = new Curve25519FieldElement(r112);
        Curve25519Field.square(r107, r121.f525444x);
        int[] r122 = r121.f525444x;
        Curve25519Field.subtract(r122, r120, r122);
        Curve25519FieldElement r123 = new Curve25519FieldElement(r120);
        Curve25519Field.subtract(r108, r121.f525444x, r123.f525444x);
        Curve25519Field.multiplyAddToExt(r123.f525444x, r107, r106);
        Curve25519Field.reduce(r106, r123.f525444x);
        Curve25519FieldElement r124 = new Curve25519FieldElement(r118);
        if (r113 == true) goto L30;
        int[] r125 = r124.f525444x;
        Curve25519Field.multiply(r125, r103.f525444x, r125);
    L30:
        if (r115 == true) goto L32;
        int[] r126 = r124.f525444x;
        Curve25519Field.multiply(r126, r111.f525444x, r126);
    L32:
        if (r113 == false) goto L35;
        if (r115 == false) goto L35;
    L37:
        return new Curve25519Point(r100, r121, r123, new ECFieldElement[]{r124, calculateJacobianModifiedW(r124, r119)});
    L35:
        r119 = null;
        goto L37
    L22:
        if (Nat256.isZero(r107) == false) goto L26;
        return twice();
    L26:
        return r100.getInfinity();
    L18:
        Curve25519Field.square(r111.f525444x, r112);
        Curve25519Field.multiply(r112, r101.f525444x, r106);
        Curve25519Field.multiply(r112, r111.f525444x, r112);
        Curve25519Field.multiply(r112, r102.f525444x, r112);
        r116 = r106;
        r117 = r112;
        goto L19
    L14:
        Curve25519Field.square(r103.f525444x, r108);
        Curve25519Field.multiply(r108, r104.f525444x, r107);
        Curve25519Field.multiply(r108, r103.f525444x, r108);
        Curve25519Field.multiply(r108, r105.f525444x, r108);
        r109 = r107;
        r114 = r108;
        goto L15
    L10:
        return twice();
    }

    public Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement r100, int[] r101) {
        Curve25519FieldElement r102 = (Curve25519FieldElement) getCurve().getA();
        if (r100.isOne() == false) goto L5;
        return r102;
    L5:
        Curve25519FieldElement r103 = new Curve25519FieldElement();
        if (r101 != null) goto L8;
        r101 = r103.f525444x;
        Curve25519Field.square(r100.f525444x, r101);
    L8:
        Curve25519Field.square(r101, r103.f525444x);
        int[] r104 = r103.f525444x;
        Curve25519Field.multiply(r104, r102.f525444x, r104);
        return r103;
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new Curve25519Point(null, getAffineXCoord(), getAffineYCoord());
    }

    public Curve25519FieldElement getJacobianModifiedW() {
        ECFieldElement[] r100 = this.f525440zs;
        Curve25519FieldElement r101 = (Curve25519FieldElement) r100[1];
        if (r101 != null) goto L6;
        Curve25519FieldElement r102 = calculateJacobianModifiedW((Curve25519FieldElement) r100[0], null);
        r100[1] = r102;
        return r102;
    L6:
        return r101;
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECFieldElement getZCoord(int r100) {
        if (r100 != 1) goto L7;
        return getJacobianModifiedW();
    L7:
        return super.getZCoord(r100);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return new Curve25519Point(getCurve(), this.f525438x, this.f525439y.negate(), this.f525440zs);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint threeTimes() {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        if (this.f525439y.isZero() == false) goto L9;
        return this;
    L9:
        return twiceJacobianModified(false).add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r100 = getCurve();
        if (this.f525439y.isZero() == false) goto L10;
        return r100.getInfinity();
    L10:
        return twiceJacobianModified(true);
    }

    public Curve25519Point twiceJacobianModified(boolean r110) {
        Curve25519FieldElement r100 = (Curve25519FieldElement) this.f525438x;
        Curve25519FieldElement r101 = (Curve25519FieldElement) this.f525439y;
        Curve25519FieldElement r102 = (Curve25519FieldElement) this.f525440zs[0];
        Curve25519FieldElement r103 = getJacobianModifiedW();
        int[] r104 = Nat256.create();
        Curve25519Field.square(r100.f525444x, r104);
        Curve25519Field.reduce27(Nat256.addBothTo(r104, r104, r104) + Nat256.addTo(r103.f525444x, r104), r104);
        int[] r105 = Nat256.create();
        Curve25519Field.twice(r101.f525444x, r105);
        int[] r106 = Nat256.create();
        Curve25519Field.multiply(r105, r101.f525444x, r106);
        int[] r107 = Nat256.create();
        Curve25519Field.multiply(r106, r100.f525444x, r107);
        Curve25519Field.twice(r107, r107);
        int[] r108 = Nat256.create();
        Curve25519Field.square(r106, r108);
        Curve25519Field.twice(r108, r108);
        Curve25519FieldElement r109 = new Curve25519FieldElement(r106);
        Curve25519Field.square(r104, r109.f525444x);
        int[] r111 = r109.f525444x;
        Curve25519Field.subtract(r111, r107, r111);
        int[] r112 = r109.f525444x;
        Curve25519Field.subtract(r112, r107, r112);
        Curve25519FieldElement r113 = new Curve25519FieldElement(r107);
        Curve25519Field.subtract(r107, r109.f525444x, r113.f525444x);
        int[] r114 = r113.f525444x;
        Curve25519Field.multiply(r114, r104, r114);
        int[] r115 = r113.f525444x;
        Curve25519Field.subtract(r115, r108, r115);
        Curve25519FieldElement r116 = new Curve25519FieldElement(r105);
        if (Nat256.isOne(r102.f525444x) == true) goto L5;
        int[] r117 = r116.f525444x;
        Curve25519Field.multiply(r117, r102.f525444x, r117);
    L5:
        if (r110 == false) goto L7;
        Curve25519FieldElement r118 = new Curve25519FieldElement(r108);
        int[] r119 = r118.f525444x;
        Curve25519Field.multiply(r119, r103.f525444x, r119);
        int[] r120 = r118.f525444x;
        Curve25519Field.twice(r120, r120);
    L9:
        return new Curve25519Point(getCurve(), r109, r113, new ECFieldElement[]{r116, r118});
    L7:
        r118 = null;
        goto L9
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
        return twiceJacobianModified(false).add(r100);
    }
}
