package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

/* JADX INFO: loaded from: classes42.dex */
public class SecT571R1Point extends ECPoint.AbstractF2m {
    public SecT571R1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        super(r100, r101, r102);
    }

    public SecT571R1Point(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
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
        SecT571FieldElement r101 = (SecT571FieldElement) this.f525438x;
        SecT571FieldElement r102 = (SecT571FieldElement) r110.getRawXCoord();
        if (r101.isZero() == true) goto L11;
        SecT571FieldElement r103 = (SecT571FieldElement) this.f525439y;
        SecT571FieldElement r104 = (SecT571FieldElement) this.f525440zs[0];
        SecT571FieldElement r105 = (SecT571FieldElement) r110.getRawYCoord();
        SecT571FieldElement r106 = (SecT571FieldElement) r110.getZCoord(0);
        long[] r107 = Nat576.create64();
        long[] r111 = Nat576.create64();
        long[] r112 = Nat576.create64();
        long[] r113 = Nat576.create64();
        if (r104.isOne() == false) goto L19;
        long[] r114 = null;
    L20:
        if (r114 != null) goto L22;
        long[] r115 = r102.f525478x;
        long[] r116 = r105.f525478x;
    L24:
        if (r106.isOne() == false) goto L26;
        long[] r108 = null;
    L27:
        long[] r109 = r101.f525478x;
        if (r108 != null) goto L30;
        long[] r117 = r103.f525478x;
    L31:
        SecT571Field.add(r117, r116, r112);
        SecT571Field.add(r109, r115, r113);
        if (Nat576.isZero64(r113) == false) goto L40;
        if (Nat576.isZero64(r112) == false) goto L38;
        return twice();
    L38:
        return r100.getInfinity();
    L40:
        if (r102.isZero() == false) goto L46;
        ECPoint r118 = normalize();
        SecT571FieldElement r119 = (SecT571FieldElement) r118.getXCoord();
        ECFieldElement r120 = r118.getYCoord();
        ECFieldElement r121 = r120.add(r105).divide(r119);
        SecT571FieldElement r122 = (SecT571FieldElement) r121.square().add(r121).add(r119).addOne();
        if (r122.isZero() == true) goto L44;
        SecT571FieldElement r123 = (SecT571FieldElement) r121.multiply(r119.add(r122)).add(r122).add(r120).divide(r122).add(r122);
        SecT571FieldElement r124 = (SecT571FieldElement) r100.fromBigInteger(ECConstants.ONE);
    L58:
        return new SecT571R1Point(r100, r122, r123, new ECFieldElement[]{r124});
    L44:
        return new SecT571R1Point(r100, r122, SecT571R1Curve.SecT571R1_B_SQRT);
    L46:
        SecT571Field.square(r113, r113);
        long[] r125 = SecT571Field.precompMultiplicand(r112);
        SecT571Field.multiplyPrecomp(r109, r125, r107);
        SecT571Field.multiplyPrecomp(r115, r125, r111);
        SecT571FieldElement r126 = new SecT571FieldElement(r107);
        SecT571Field.multiply(r107, r111, r126.f525478x);
        if (r126.isZero() == true) goto L49;
        SecT571FieldElement r127 = new SecT571FieldElement(r112);
        SecT571Field.multiplyPrecomp(r113, r125, r127.f525478x);
        if (r108 == null) goto L53;
        long[] r128 = r127.f525478x;
        SecT571Field.multiplyPrecomp(r128, r108, r128);
    L53:
        long[] r129 = Nat576.createExt64();
        SecT571Field.add(r111, r113, r113);
        SecT571Field.squareAddToExt(r113, r129);
        SecT571Field.add(r103.f525478x, r104.f525478x, r113);
        SecT571Field.multiplyAddToExt(r113, r127.f525478x, r129);
        SecT571FieldElement r130 = new SecT571FieldElement(r113);
        SecT571Field.reduce(r129, r130.f525478x);
        if (r114 == null) goto L56;
        long[] r131 = r127.f525478x;
        SecT571Field.multiplyPrecomp(r131, r114, r131);
    L56:
        r122 = r126;
        r123 = r130;
        r124 = r127;
        goto L58
    L49:
        return new SecT571R1Point(r100, r126, SecT571R1Curve.SecT571R1_B_SQRT);
    L30:
        SecT571Field.multiplyPrecomp(r109, r108, r107);
        SecT571Field.multiplyPrecomp(r103.f525478x, r108, r112);
        r109 = r107;
        r117 = r112;
        goto L31
    L26:
        r108 = SecT571Field.precompMultiplicand(r106.f525478x);
        goto L27
    L22:
        SecT571Field.multiplyPrecomp(r102.f525478x, r114, r111);
        SecT571Field.multiplyPrecomp(r105.f525478x, r114, r113);
        r115 = r111;
        r116 = r113;
        goto L24
    L19:
        r114 = SecT571Field.precompMultiplicand(r104.f525478x);
        goto L20
    L11:
        if (r102.isZero() == false) goto L15;
        return r100.getInfinity();
    L15:
        return r110.add(this);
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint detach() {
        return new SecT571R1Point(null, getAffineXCoord(), getAffineYCoord());
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
        return new SecT571R1Point(this.curve, r100, r101.add(r102), new ECFieldElement[]{r102});
    }

    @Override // org.bouncycastle.math.ec.ECPoint
    public ECPoint twice() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        ECCurve r100 = getCurve();
        SecT571FieldElement r101 = (SecT571FieldElement) this.f525438x;
        if (r101.isZero() == true) goto L8;
        SecT571FieldElement r102 = (SecT571FieldElement) this.f525439y;
        SecT571FieldElement r103 = (SecT571FieldElement) this.f525440zs[0];
        long[] r104 = Nat576.create64();
        long[] r105 = Nat576.create64();
        if (r103.isOne() == false) goto L12;
        long[] r106 = null;
    L13:
        long[] r107 = r102.f525478x;
        if (r106 != null) goto L16;
        long[] r108 = r103.f525478x;
    L17:
        long[] r109 = Nat576.create64();
        SecT571Field.square(r102.f525478x, r109);
        SecT571Field.addBothTo(r107, r108, r109);
        if (Nat576.isZero64(r109) == true) goto L20;
        long[] r110 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(r109, r107, r110);
        SecT571FieldElement r111 = new SecT571FieldElement(r104);
        SecT571Field.square(r109, r111.f525478x);
        SecT571FieldElement r112 = new SecT571FieldElement(r109);
        if (r106 == null) goto L24;
        long[] r113 = r112.f525478x;
        SecT571Field.multiply(r113, r108, r113);
    L24:
        long[] r114 = r101.f525478x;
        if (r106 == null) goto L28;
        SecT571Field.multiplyPrecomp(r114, r106, r105);
        r114 = r105;
    L28:
        SecT571Field.squareAddToExt(r114, r110);
        SecT571Field.reduce(r110, r105);
        SecT571Field.addBothTo(r111.f525478x, r112.f525478x, r105);
        return new SecT571R1Point(r100, r111, new SecT571FieldElement(r105), new ECFieldElement[]{r112});
    L20:
        return new SecT571R1Point(r100, new SecT571FieldElement(r109), SecT571R1Curve.SecT571R1_B_SQRT);
    L16:
        SecT571Field.multiplyPrecomp(r107, r106, r104);
        SecT571Field.square(r103.f525478x, r105);
        r107 = r104;
        r108 = r105;
        goto L17
    L12:
        r106 = SecT571Field.precompMultiplicand(r103.f525478x);
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
        SecT571FieldElement r101 = (SecT571FieldElement) this.f525438x;
        if (r101.isZero() == false) goto L12;
        return r110;
    L12:
        SecT571FieldElement r102 = (SecT571FieldElement) r110.getRawXCoord();
        SecT571FieldElement r103 = (SecT571FieldElement) r110.getZCoord(0);
        if (r102.isZero() == true) goto L32;
        if (r103.isOne() == false) goto L32;
        SecT571FieldElement r104 = (SecT571FieldElement) this.f525439y;
        SecT571FieldElement r105 = (SecT571FieldElement) this.f525440zs[0];
        SecT571FieldElement r106 = (SecT571FieldElement) r110.getRawYCoord();
        long[] r107 = Nat576.create64();
        long[] r108 = Nat576.create64();
        long[] r109 = Nat576.create64();
        long[] r111 = Nat576.create64();
        SecT571Field.square(r101.f525478x, r107);
        SecT571Field.square(r104.f525478x, r108);
        SecT571Field.square(r105.f525478x, r109);
        SecT571Field.multiply(r104.f525478x, r105.f525478x, r111);
        SecT571Field.addBothTo(r109, r108, r111);
        long[] r112 = SecT571Field.precompMultiplicand(r109);
        SecT571Field.multiplyPrecomp(r106.f525478x, r112, r109);
        SecT571Field.add(r109, r108, r109);
        long[] r113 = Nat576.createExt64();
        SecT571Field.multiplyAddToExt(r109, r111, r113);
        SecT571Field.multiplyPrecompAddToExt(r107, r112, r113);
        SecT571Field.reduce(r113, r109);
        SecT571Field.multiplyPrecomp(r102.f525478x, r112, r107);
        SecT571Field.add(r107, r111, r108);
        SecT571Field.square(r108, r108);
        if (Nat576.isZero64(r108) == false) goto L26;
        if (Nat576.isZero64(r109) == false) goto L24;
        return r110.twice();
    L24:
        return r100.getInfinity();
    L26:
        if (Nat576.isZero64(r109) == true) goto L28;
        SecT571FieldElement r114 = new SecT571FieldElement();
        SecT571Field.square(r109, r114.f525478x);
        long[] r115 = r114.f525478x;
        SecT571Field.multiply(r115, r107, r115);
        SecT571FieldElement r116 = new SecT571FieldElement(r107);
        SecT571Field.multiply(r109, r108, r116.f525478x);
        long[] r117 = r116.f525478x;
        SecT571Field.multiplyPrecomp(r117, r112, r117);
        SecT571FieldElement r118 = new SecT571FieldElement(r108);
        SecT571Field.add(r109, r108, r118.f525478x);
        long[] r119 = r118.f525478x;
        SecT571Field.square(r119, r119);
        Nat.zero64(18, r113);
        SecT571Field.multiplyAddToExt(r118.f525478x, r111, r113);
        SecT571Field.addOne(r106.f525478x, r111);
        SecT571Field.multiplyAddToExt(r111, r116.f525478x, r113);
        SecT571Field.reduce(r113, r118.f525478x);
        return new SecT571R1Point(r100, r114, r118, new ECFieldElement[]{r116});
    L28:
        return new SecT571R1Point(r100, new SecT571FieldElement(r109), SecT571R1Curve.SecT571R1_B_SQRT);
    L32:
        return twice().add(r110);
    L8:
        return twice();
    }
}
