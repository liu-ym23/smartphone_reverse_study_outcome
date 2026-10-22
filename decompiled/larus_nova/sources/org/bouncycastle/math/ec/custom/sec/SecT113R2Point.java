package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

/* JADX INFO: loaded from: classes42.dex */
public class SecT113R2Point extends ECPoint.AbstractF2m {
    public SecT113R2Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        super(r100, r101, r102);
    }

    public SecT113R2Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
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
        ECCurve r100 = getCurve();
        ECFieldElement r101 = this.f525438x;
        ECFieldElement r102 = r110.getRawXCoord();
        if (r101.isZero() == true) goto L11;
        ECFieldElement r103 = this.f525439y;
        ECFieldElement r104 = this.f525440zs[0];
        ECFieldElement r105 = r110.getRawYCoord();
        ECFieldElement r111 = r110.getZCoord(0);
        boolean r106 = r104.isOne();
        if (r106 == true) goto L19;
        ECFieldElement r107 = r102.multiply(r104);
        ECFieldElement r108 = r105.multiply(r104);
    L20:
        boolean r112 = r111.isOne();
        if (r112 == true) goto L23;
        r101 = r101.multiply(r111);
        ECFieldElement r113 = r103.multiply(r111);
    L24:
        ECFieldElement r109 = r113.add(r108);
        ECFieldElement r114 = r101.add(r107);
        if (r114.isZero() == false) goto L33;
        if (r109.isZero() == false) goto L31;
        return twice();
    L31:
        return r100.getInfinity();
    L33:
        if (r102.isZero() == false) goto L39;
        ECPoint r115 = normalize();
        ECFieldElement r116 = r115.getXCoord();
        ECFieldElement r117 = r115.getYCoord();
        ECFieldElement r118 = r117.add(r105).divide(r116);
        ECFieldElement r119 = r118.square().add(r118).add(r116).add(r100.getA());
        if (r119.isZero() == true) goto L37;
        ECFieldElement r120 = r118.multiply(r116.add(r119)).add(r119).add(r117).divide(r119).add(r119);
        ECFieldElement r121 = r100.fromBigInteger(ECConstants.ONE);
    L52:
        return new SecT113R2Point(r100, r119, r120, new ECFieldElement[]{r121});
    L37:
        return new SecT113R2Point(r100, r119, r100.getB().sqrt());
    L39:
        ECFieldElement r122 = r114.square();
        ECFieldElement r123 = r109.multiply(r101);
        ECFieldElement r124 = r109.multiply(r107);
        ECFieldElement r125 = r123.multiply(r124);
        if (r125.isZero() == true) goto L42;
        ECFieldElement r126 = r109.multiply(r122);
        if (r112 == true) goto L46;
        ECFieldElement r127 = r126.multiply(r111);
    L47:
        ECFieldElement r128 = r124.add(r122).squarePlusProduct(r127, r103.add(r104));
        if (r106 == true) goto L50;
        r127 = r127.multiply(r104);
    L50:
        r119 = r125;
        r121 = r127;
        r120 = r128;
        goto L52
    L46:
        r127 = r126;
        goto L47
    L42:
        return new SecT113R2Point(r100, r125, r100.getB().sqrt());
    L23:
        r113 = r103;
        goto L24
    L19:
        r107 = r102;
        r108 = r105;
        goto L20
    L11:
        if (r102.isZero() == false) goto L15;
        return r100.getInfinity();
    L15:
        return r110.add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecT113R2Point(null, getAffineXCoord(), getAffineYCoord());
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public boolean getCompressionYTilde() {
        ECFieldElement r100 = getRawXCoord();
        if (r100.isZero() == false) goto L6;
        return false;
    L6:
        if (getRawYCoord().testBitZero() == r100.testBitZero()) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECFieldElement getYCoord() {
        ECFieldElement r100 = this.f525438x;
        ECFieldElement r101 = this.f525439y;
        if (isInfinity() == false) goto L5;
    L11:
        return r101;
    L5:
        if (r100.isZero() == true) goto L11;
        ECFieldElement r102 = r101.add(r100).multiply(r100);
        ECFieldElement r103 = this.f525440zs[0];
        if (r103.isOne() == false) goto L10;
        return r102;
    L10:
        return r102.divide(r103);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint negate() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECFieldElement r100 = this.f525438x;
        if (r100.isZero() == false) goto L8;
        return this;
    L8:
        ECFieldElement r101 = this.f525439y;
        ECFieldElement r102 = this.f525440zs[0];
        return new SecT113R2Point(this.curve, r100, r101.add(r102), new ECFieldElement[]{r102});
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r100 = getCurve();
        ECFieldElement r101 = this.f525438x;
        if (r101.isZero() == true) goto L8;
        ECFieldElement r102 = this.f525439y;
        ECFieldElement r103 = this.f525440zs[0];
        boolean r104 = r103.isOne();
        if (r104 == false) goto L12;
        ECFieldElement r105 = r102;
    L13:
        if (r104 == false) goto L15;
        ECFieldElement r106 = r103;
    L16:
        ECFieldElement r107 = r100.getA();
        if (r104 == true) goto L20;
        r107 = r107.multiply(r106);
    L20:
        ECFieldElement r108 = r102.square().add(r105).add(r107);
        if (r108.isZero() == true) goto L23;
        ECFieldElement r109 = r108.square();
        if (r104 == false) goto L27;
        ECFieldElement r110 = r108;
    L28:
        if (r104 == true) goto L32;
        r101 = r101.multiply(r103);
    L32:
        return new SecT113R2Point(r100, r109, r101.squarePlusProduct(r108, r105).add(r109).add(r110), new ECFieldElement[]{r110});
    L27:
        r110 = r108.multiply(r106);
        goto L28
    L23:
        return new SecT113R2Point(r100, r108, r100.getB().sqrt());
    L15:
        r106 = r103.square();
        goto L16
    L12:
        r105 = r102.multiply(r103);
        goto L13
    L8:
        return r100.getInfinity();
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twicePlus(ECPoint r110) {
        if (isInfinity() == false) goto L6;
        return r110;
    L6:
        if (r110.isInfinity() == true) goto L8;
        ECCurve r100 = getCurve();
        ECFieldElement r101 = this.f525438x;
        if (r101.isZero() == false) goto L12;
        return r110;
    L12:
        ECFieldElement r102 = r110.getRawXCoord();
        ECFieldElement r103 = r110.getZCoord(0);
        if (r102.isZero() == true) goto L32;
        if (r103.isOne() == false) goto L32;
        ECFieldElement r104 = this.f525439y;
        ECFieldElement r105 = this.f525440zs[0];
        ECFieldElement r106 = r110.getRawYCoord();
        ECFieldElement r107 = r101.square();
        ECFieldElement r108 = r104.square();
        ECFieldElement r109 = r105.square();
        ECFieldElement r111 = r100.getA().multiply(r109).add(r108).add(r104.multiply(r105));
        ECFieldElement r112 = r106.addOne();
        ECFieldElement r113 = r100.getA().add(r112).multiply(r109).add(r108).multiplyPlusProduct(r111, r107, r109);
        ECFieldElement r114 = r102.multiply(r109);
        ECFieldElement r115 = r114.add(r111).square();
        if (r115.isZero() == false) goto L26;
        if (r113.isZero() == false) goto L24;
        return r110.twice();
    L24:
        return r100.getInfinity();
    L26:
        if (r113.isZero() == true) goto L28;
        ECFieldElement r116 = r113.square().multiply(r114);
        ECFieldElement r117 = r113.multiply(r115).multiply(r109);
        return new SecT113R2Point(r100, r116, r113.add(r115).square().multiplyPlusProduct(r111, r112, r117), new ECFieldElement[]{r117});
    L28:
        return new SecT113R2Point(r100, r113, r100.getB().sqrt());
    L32:
        return twice().add(r110);
    L8:
        return twice();
    }
}
