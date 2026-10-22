package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ECPoint {
    protected static final ECFieldElement[] EMPTY_ZS = null;
    protected ECCurve curve;
    protected Hashtable preCompTable;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected ECFieldElement f525438x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected ECFieldElement f525439y;

    /* JADX INFO: renamed from: zs, reason: collision with root package name */
    protected ECFieldElement[] f525440zs;

    public static abstract class AbstractF2m extends ECPoint {
        public AbstractF2m(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
            super(r100, r101, r102);
        }

        public AbstractF2m(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
            super(r100, r101, r102, r103);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean satisfiesCurveEquation() {
            ECCurve r100 = getCurve();
            ECFieldElement r101 = this.f525438x;
            ECFieldElement r102 = r100.getA();
            ECFieldElement r103 = r100.getB();
            int r104 = r100.getCoordinateSystem();
            if (r104 != 6) goto L17;
            ECFieldElement r105 = this.f525440zs[0];
            boolean r106 = r105.isOne();
            if (r101.isZero() == false) goto L11;
            ECFieldElement r107 = this.f525439y.square();
            if (r106 == true) goto L10;
            r103 = r103.multiply(r105.square());
        L10:
            return r107.equals(r103);
        L11:
            ECFieldElement r108 = this.f525439y;
            ECFieldElement r109 = r101.square();
            if (r106 == false) goto L14;
            ECFieldElement r110 = r108.square().add(r108).add(r102);
            ECFieldElement r111 = r109.square().add(r103);
        L16:
            return r110.multiply(r109).equals(r111);
        L14:
            ECFieldElement r112 = r105.square();
            ECFieldElement r113 = r112.square();
            r110 = r108.add(r105).multiplyPlusProduct(r108, r102, r112);
            r111 = r109.squarePlusProduct(r103, r113);
            goto L16
        L17:
            ECFieldElement r114 = this.f525439y;
            ECFieldElement r115 = r114.add(r101).multiply(r114);
            if (r104 == 0) goto L27;
            if (r104 != 1) goto L25;
            ECFieldElement r116 = this.f525440zs[0];
            if (r116.isOne() == true) goto L27;
            ECFieldElement r117 = r116.multiply(r116.square());
            r115 = r115.multiply(r116);
            r102 = r102.multiply(r116);
            r103 = r103.multiply(r117);
            goto L27
        L25:
            throw new IllegalStateException("unsupported coordinate system");
        L27:
            return r115.equals(r101.add(r102).multiply(r101.square()).add(r103));
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean satisfiesOrder() {
            BigInteger r100 = this.curve.getCofactor();
            if (ECConstants.TWO.equals(r100) == false) goto L10;
            if (((ECFieldElement.AbstractF2m) normalize().getAffineXCoord()).trace() != 0) goto L21;
            return false;
        L21:
            return true;
        L10:
            if (ECConstants.FOUR.equals(r100) == false) goto L20;
            ECPoint r101 = normalize();
            ECFieldElement r102 = r101.getAffineXCoord();
            ECCurve r103 = this.curve;
            ECFieldElement r104 = ((ECCurve.AbstractF2m) r103).solveQuadraticEquation(r102.add(r103.getA()));
            if (r104 != null) goto L14;
            return false;
        L14:
            ECFieldElement r105 = r101.getAffineYCoord();
            if (((ECFieldElement.AbstractF2m) r102.multiply(r104).add(r105)).trace() == 0) goto L22;
            return false;
        L22:
            return true;
        L20:
            return super.satisfiesOrder();
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleX(ECFieldElement r100) {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            int r101 = getCurveCoordinateSystem();
            if (r101 != 5) goto L8;
            ECFieldElement r102 = getRawXCoord();
            ECFieldElement r103 = getRawYCoord();
            return getCurve().createRawPoint(r102, r103.add(r102).divide(r100).add(r102.multiply(r100)), getRawZCoords());
        L8:
            if (r101 != 6) goto L10;
            ECFieldElement r104 = getRawXCoord();
            ECFieldElement r105 = getRawYCoord();
            ECFieldElement r106 = getRawZCoords()[0];
            ECFieldElement r107 = r104.multiply(r100.square());
            ECFieldElement r108 = r105.add(r104).add(r107);
            ECFieldElement r109 = r106.multiply(r100);
            return getCurve().createRawPoint(r107, r108, new ECFieldElement[]{r109});
        L10:
            return super.scaleX(r100);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleXNegateY(ECFieldElement r100) {
            return scaleX(r100);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleY(ECFieldElement r100) {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            int r101 = getCurveCoordinateSystem();
            if (r101 != 5) goto L8;
        L11:
            ECFieldElement r102 = getRawXCoord();
            ECFieldElement r103 = getRawYCoord().add(r102).multiply(r100).add(r102);
            return getCurve().createRawPoint(r102, r103, getRawZCoords());
        L8:
            if (r101 == 6) goto L11;
            return super.scaleY(r100);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint scaleYNegateX(ECFieldElement r100) {
            return scaleY(r100);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint r100) {
            if (r100.isInfinity() == false) goto L6;
            return this;
        L6:
            return add(r100.negate());
        }

        public AbstractF2m tau() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r100 = getCurve();
            int r101 = r100.getCoordinateSystem();
            ECFieldElement r102 = this.f525438x;
            if (r101 != 0) goto L8;
        L19:
            ECPoint r103 = r100.createRawPoint(r102.square(), this.f525439y.square());
        L18:
            return (AbstractF2m) r103;
        L8:
            if (r101 != 1) goto L10;
        L16:
            ECFieldElement r104 = this.f525439y;
            ECFieldElement r105 = this.f525440zs[0];
            r103 = r100.createRawPoint(r102.square(), r104.square(), new ECFieldElement[]{r105.square()});
            goto L18
        L10:
            if (r101 == 5) goto L19;
            if (r101 == 6) goto L16;
            throw new IllegalStateException("unsupported coordinate system");
        }

        public AbstractF2m tauPow(int r100) {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r101 = getCurve();
            int r102 = r101.getCoordinateSystem();
            ECFieldElement r103 = this.f525438x;
            if (r102 != 0) goto L8;
        L19:
            ECPoint r104 = r101.createRawPoint(r103.squarePow(r100), this.f525439y.squarePow(r100));
        L18:
            return (AbstractF2m) r104;
        L8:
            if (r102 != 1) goto L10;
        L16:
            ECFieldElement r105 = this.f525439y;
            ECFieldElement r106 = this.f525440zs[0];
            r104 = r101.createRawPoint(r103.squarePow(r100), r105.squarePow(r100), new ECFieldElement[]{r106.squarePow(r100)});
            goto L18
        L10:
            if (r102 == 5) goto L19;
            if (r102 == 6) goto L16;
            throw new IllegalStateException("unsupported coordinate system");
        }
    }

    public static abstract class AbstractFp extends ECPoint {
        public AbstractFp(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
            super(r100, r101, r102);
        }

        public AbstractFp(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
            super(r100, r101, r102, r103);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean getCompressionYTilde() {
            return getAffineYCoord().testBitZero();
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean satisfiesCurveEquation() {
            ECFieldElement r100 = this.f525438x;
            ECFieldElement r101 = this.f525439y;
            ECFieldElement r102 = this.curve.getA();
            ECFieldElement r103 = this.curve.getB();
            ECFieldElement r104 = r101.square();
            int r105 = getCurveCoordinateSystem();
            if (r105 == 0) goto L22;
            if (r105 != 1) goto L7;
            ECFieldElement r106 = this.f525440zs[0];
            if (r106.isOne() == true) goto L22;
            ECFieldElement r107 = r106.square();
            ECFieldElement r108 = r106.multiply(r107);
            r104 = r104.multiply(r106);
            r102 = r102.multiply(r107);
            r103 = r103.multiply(r108);
            goto L22
        L7:
            if (r105 != 2) goto L9;
        L15:
            ECFieldElement r109 = this.f525440zs[0];
            if (r109.isOne() == true) goto L22;
            ECFieldElement r110 = r109.square();
            ECFieldElement r111 = r110.square();
            ECFieldElement r112 = r110.multiply(r111);
            r102 = r102.multiply(r111);
            r103 = r103.multiply(r112);
            goto L22
        L9:
            if (r105 == 3) goto L15;
            if (r105 == 4) goto L15;
            throw new IllegalStateException("unsupported coordinate system");
        L22:
            return r104.equals(r100.square().add(r102).multiply(r100).add(r103));
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint subtract(ECPoint r100) {
            if (r100.isInfinity() == false) goto L6;
            return this;
        L6:
            return add(r100.negate());
        }
    }

    public static class F2m extends AbstractF2m {
        public F2m(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
            super(r100, r101, r102);
        }

        public F2m(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
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
            int r101 = r100.getCoordinateSystem();
            ECFieldElement r102 = this.f525438x;
            ECFieldElement r103 = r110.f525438x;
            if (r101 != 0) goto L11;
            ECFieldElement r104 = this.f525439y;
            ECFieldElement r105 = r110.f525439y;
            ECFieldElement r106 = r102.add(r103);
            ECFieldElement r107 = r104.add(r105);
            if (r106.isZero() == true) goto L90;
            ECFieldElement r108 = r107.divide(r106);
            ECFieldElement r109 = r108.square().add(r108).add(r106).add(r100.getA());
            return new F2m(r100, r109, r108.multiply(r102.add(r109)).add(r109).add(r104));
        L90:
            if (r107.isZero() == false) goto L94;
            return twice();
        L94:
            return r100.getInfinity();
        L11:
            if (r101 != 1) goto L13;
            ECFieldElement r111 = this.f525439y;
            ECFieldElement r112 = this.f525440zs[0];
            ECFieldElement r113 = r110.f525439y;
            ECFieldElement r114 = r110.f525440zs[0];
            boolean r115 = r114.isOne();
            ECFieldElement r116 = r112.multiply(r113);
            if (r115 == false) goto L64;
            ECFieldElement r117 = r111;
        L65:
            ECFieldElement r118 = r116.add(r117);
            ECFieldElement r119 = r112.multiply(r103);
            if (r115 == false) goto L68;
            ECFieldElement r120 = r102;
        L69:
            ECFieldElement r121 = r119.add(r120);
            if (r121.isZero() == true) goto L72;
            ECFieldElement r122 = r121.square();
            ECFieldElement r123 = r122.multiply(r121);
            if (r115 == true) goto L81;
            r112 = r112.multiply(r114);
        L81:
            ECFieldElement r124 = r118.add(r121);
            ECFieldElement r125 = r124.multiplyPlusProduct(r118, r122, r100.getA()).multiply(r112).add(r123);
            ECFieldElement r126 = r121.multiply(r125);
            if (r115 == true) goto L86;
            r122 = r122.multiply(r114);
        L86:
            return new F2m(r100, r126, r118.multiplyPlusProduct(r102, r121, r111).multiplyPlusProduct(r122, r124, r125), new ECFieldElement[]{r123.multiply(r112)});
        L72:
            if (r118.isZero() == false) goto L76;
            return twice();
        L76:
            return r100.getInfinity();
        L68:
            r120 = r102.multiply(r114);
            goto L69
        L64:
            r117 = r111.multiply(r114);
            goto L65
        L13:
            if (r101 != 6) goto L60;
            if (r102.isZero() == true) goto L17;
            ECFieldElement r127 = this.f525439y;
            ECFieldElement r128 = this.f525440zs[0];
            ECFieldElement r129 = r110.f525439y;
            ECFieldElement r130 = r110.f525440zs[0];
            boolean r131 = r128.isOne();
            if (r131 == true) goto L25;
            ECFieldElement r132 = r103.multiply(r128);
            ECFieldElement r133 = r129.multiply(r128);
        L26:
            boolean r134 = r130.isOne();
            if (r134 == true) goto L29;
            r102 = r102.multiply(r130);
            ECFieldElement r135 = r127.multiply(r130);
        L30:
            ECFieldElement r136 = r135.add(r133);
            ECFieldElement r137 = r102.add(r132);
            if (r137.isZero() == false) goto L39;
            if (r136.isZero() == false) goto L37;
            return twice();
        L37:
            return r100.getInfinity();
        L39:
            if (r103.isZero() == false) goto L45;
            ECPoint r138 = normalize();
            ECFieldElement r139 = r138.getXCoord();
            ECFieldElement r140 = r138.getYCoord();
            ECFieldElement r141 = r140.add(r129).divide(r139);
            ECFieldElement r142 = r141.square().add(r141).add(r139).add(r100.getA());
            if (r142.isZero() == true) goto L43;
            ECFieldElement r143 = r141.multiply(r139.add(r142)).add(r142).add(r140).divide(r142).add(r142);
            ECFieldElement r144 = r100.fromBigInteger(ECConstants.ONE);
        L58:
            return new F2m(r100, r142, r143, new ECFieldElement[]{r144});
        L43:
            return new F2m(r100, r142, r100.getB().sqrt());
        L45:
            ECFieldElement r145 = r137.square();
            ECFieldElement r146 = r136.multiply(r102);
            ECFieldElement r147 = r136.multiply(r132);
            ECFieldElement r148 = r146.multiply(r147);
            if (r148.isZero() == true) goto L48;
            ECFieldElement r149 = r136.multiply(r145);
            if (r134 == true) goto L52;
            ECFieldElement r150 = r149.multiply(r130);
        L53:
            ECFieldElement r151 = r147.add(r145).squarePlusProduct(r150, r127.add(r128));
            if (r131 == true) goto L56;
            r150 = r150.multiply(r128);
        L56:
            r142 = r148;
            r144 = r150;
            r143 = r151;
            goto L58
        L52:
            r150 = r149;
            goto L53
        L48:
            return new F2m(r100, r148, r100.getB().sqrt());
        L29:
            r135 = r127;
            goto L30
        L25:
            r132 = r103;
            r133 = r129;
            goto L26
        L17:
            if (r103.isZero() == false) goto L21;
            return r100.getInfinity();
        L21:
            return r110.add(this);
        L60:
            throw new IllegalStateException("unsupported coordinate system");
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint detach() {
            return new F2m(null, getAffineXCoord(), getAffineYCoord());
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public boolean getCompressionYTilde() {
            ECFieldElement r100 = getRawXCoord();
            if (r100.isZero() == false) goto L5;
            return false;
        L5:
            ECFieldElement r101 = getRawYCoord();
            int r102 = getCurveCoordinateSystem();
            if (r102 == 5) goto L12;
            if (r102 == 6) goto L12;
            return r101.divide(r100).testBitZero();
        L12:
            if (r101.testBitZero() == r100.testBitZero()) goto L15;
            return true;
        L15:
            return false;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getYCoord() {
            int r100 = getCurveCoordinateSystem();
            if (r100 == 5) goto L7;
            if (r100 == 6) goto L7;
            return this.f525439y;
        L7:
            ECFieldElement r101 = this.f525438x;
            ECFieldElement r102 = this.f525439y;
            if (isInfinity() == false) goto L10;
        L18:
            return r102;
        L10:
            if (r101.isZero() == true) goto L18;
            ECFieldElement r103 = r102.add(r101).multiply(r101);
            if (6 != r100) goto L19;
            ECFieldElement r104 = this.f525440zs[0];
            if (r104.isOne() == false) goto L17;
            return r103;
        L17:
            return r103.divide(r104);
        L19:
            return r103;
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
            int r101 = getCurveCoordinateSystem();
            if (r101 == 0) goto L25;
            if (r101 != 1) goto L13;
            ECFieldElement r102 = this.f525439y;
            ECFieldElement r103 = this.f525440zs[0];
            return new F2m(this.curve, r100, r102.add(r100), new ECFieldElement[]{r103});
        L13:
            if (r101 == 5) goto L21;
            if (r101 != 6) goto L19;
            ECFieldElement r104 = this.f525439y;
            ECFieldElement r105 = this.f525440zs[0];
            return new F2m(this.curve, r100, r104.add(r105), new ECFieldElement[]{r105});
        L19:
            throw new IllegalStateException("unsupported coordinate system");
        L21:
            return new F2m(this.curve, r100, this.f525439y.addOne());
        L25:
            return new F2m(this.curve, r100, this.f525439y.add(r100));
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r100 = getCurve();
            ECFieldElement r101 = this.f525438x;
            if (r101.isZero() == true) goto L8;
            int r102 = r100.getCoordinateSystem();
            if (r102 != 0) goto L12;
            ECFieldElement r103 = this.f525439y.divide(r101).add(r101);
            ECFieldElement r104 = r103.square().add(r103).add(r100.getA());
            return new F2m(r100, r104, r101.squarePlusProduct(r104, r103.addOne()));
        L12:
            if (r102 != 1) goto L14;
            ECFieldElement r105 = this.f525439y;
            ECFieldElement r106 = this.f525440zs[0];
            boolean r107 = r106.isOne();
            if (r107 == false) goto L58;
            ECFieldElement r108 = r101;
        L59:
            if (r107 == true) goto L62;
            r105 = r105.multiply(r106);
        L62:
            ECFieldElement r109 = r101.square();
            ECFieldElement r110 = r109.add(r105);
            ECFieldElement r111 = r108.square();
            ECFieldElement r112 = r110.add(r108);
            ECFieldElement r113 = r112.multiplyPlusProduct(r110, r111, r100.getA());
            return new F2m(r100, r108.multiply(r113), r109.square().multiplyPlusProduct(r108, r113, r112), new ECFieldElement[]{r108.multiply(r111)});
        L58:
            r108 = r101.multiply(r106);
            goto L59
        L14:
            if (r102 != 6) goto L54;
            ECFieldElement r114 = this.f525439y;
            ECFieldElement r115 = this.f525440zs[0];
            boolean r116 = r115.isOne();
            if (r116 == false) goto L18;
            ECFieldElement r117 = r114;
        L19:
            if (r116 == false) goto L21;
            ECFieldElement r118 = r115;
        L22:
            ECFieldElement r119 = r100.getA();
            if (r116 == false) goto L25;
            ECFieldElement r120 = r119;
        L26:
            ECFieldElement r121 = r114.square().add(r117).add(r120);
            if (r121.isZero() == true) goto L29;
            ECFieldElement r122 = r121.square();
            if (r116 == false) goto L33;
            ECFieldElement r123 = r121;
        L34:
            ECFieldElement r124 = r100.getB();
            if (r124.bitLength() >= (r100.getFieldSize() >> 1)) goto L46;
            ECFieldElement r125 = r114.add(r101).square();
            if (r124.isOne() == false) goto L39;
            ECFieldElement r126 = r120.add(r118).square();
        L40:
            ECFieldElement r127 = r125.add(r121).add(r118).multiply(r125).add(r126).add(r122);
            if (r119.isZero() == false) goto L44;
        L50:
            r127 = r127.add(r123);
        L52:
            return new F2m(r100, r122, r127, new ECFieldElement[]{r123});
        L44:
            if (r119.isOne() == true) goto L52;
            r127 = r127.add(r119.addOne().multiply(r123));
            goto L52
        L39:
            r126 = r120.squarePlusProduct(r124, r118.square());
            goto L40
        L46:
            if (r116 == true) goto L49;
            r101 = r101.multiply(r115);
        L49:
            r127 = r101.squarePlusProduct(r121, r117).add(r122);
            goto L50
        L33:
            r123 = r121.multiply(r118);
            goto L34
        L29:
            return new F2m(r100, r121, r100.getB().sqrt());
        L25:
            r120 = r119.multiply(r118);
            goto L26
        L21:
            r118 = r115.square();
            goto L22
        L18:
            r117 = r114.multiply(r115);
            goto L19
        L54:
            throw new IllegalStateException("unsupported coordinate system");
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
            if (r101.isZero() == false) goto L13;
            return r110;
        L13:
            if (r100.getCoordinateSystem() != 6) goto L15;
            ECFieldElement r102 = r110.f525438x;
            ECFieldElement r103 = r110.f525440zs[0];
            if (r102.isZero() == true) goto L36;
            if (r103.isOne() == false) goto L36;
            ECFieldElement r104 = this.f525439y;
            ECFieldElement r105 = this.f525440zs[0];
            ECFieldElement r106 = r110.f525439y;
            ECFieldElement r107 = r101.square();
            ECFieldElement r108 = r104.square();
            ECFieldElement r109 = r105.square();
            ECFieldElement r111 = r100.getA().multiply(r109).add(r108).add(r104.multiply(r105));
            ECFieldElement r112 = r106.addOne();
            ECFieldElement r113 = r100.getA().add(r112).multiply(r109).add(r108).multiplyPlusProduct(r111, r107, r109);
            ECFieldElement r114 = r102.multiply(r109);
            ECFieldElement r115 = r114.add(r111).square();
            if (r115.isZero() == false) goto L30;
            if (r113.isZero() == false) goto L28;
            return r110.twice();
        L28:
            return r100.getInfinity();
        L30:
            if (r113.isZero() == true) goto L32;
            ECFieldElement r116 = r113.square().multiply(r114);
            ECFieldElement r117 = r113.multiply(r115).multiply(r109);
            return new F2m(r100, r116, r113.add(r115).square().multiplyPlusProduct(r111, r112, r117), new ECFieldElement[]{r117});
        L32:
            return new F2m(r100, r113, r100.getB().sqrt());
        L36:
            return twice().add(r110);
        L15:
            return twice().add(r110);
        L8:
            return twice();
        }
    }

    public static class Fp extends AbstractFp {
        public Fp(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
            super(r100, r101, r102);
        }

        public Fp(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
            super(r100, r101, r102, r103);
        }

        /*  JADX ERROR: Type inference failed
            jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 5321. Try increasing type updates limit count.
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
            */
        @Override // org.bouncycastle.math.ec.ECPoint
        public org.bouncycastle.math.ec.ECPoint add(org.bouncycastle.math.ec.ECPoint r17) {
            /*  JADX ERROR: Simple mode code generation failed
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: INVOKE (r2v0 ?? I:boolean) = (r16v0 'this' ?? I:org.bouncycastle.math.ec.ECPoint A[IMMUTABLE_TYPE, THIS]) VIRTUAL call: org.bouncycastle.math.ec.ECPoint.isInfinity():boolean A[DECLARE_VAR, MD:():boolean (m)] in method: org.bouncycastle.math.ec.ECPoint.Fp.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint, file: classes42.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
                	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
                	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
                	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
                	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
                	... 48 more
                */
            /*
                Method dump skipped, instruction units count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.math.ec.ECPoint.Fp.add(org.bouncycastle.math.ec.ECPoint):org.bouncycastle.math.ec.ECPoint");
        }

        public ECFieldElement calculateJacobianModifiedW(ECFieldElement r100, ECFieldElement r101) {
            ECFieldElement r102 = getCurve().getA();
            if (r102.isZero() == false) goto L5;
        L14:
            return r102;
        L5:
            if (r100.isOne() == true) goto L14;
            if (r101 != null) goto L9;
            r101 = r100.square();
        L9:
            ECFieldElement r103 = r101.square();
            ECFieldElement r104 = r102.negate();
            if (r104.bitLength() >= r102.bitLength()) goto L13;
            return r103.multiply(r104).negate();
        L13:
            return r103.multiply(r102);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint detach() {
            return new Fp(null, getAffineXCoord(), getAffineYCoord());
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

        public ECFieldElement getJacobianModifiedW() {
            ECFieldElement[] r100 = this.f525440zs;
            ECFieldElement r101 = r100[1];
            if (r101 != null) goto L6;
            ECFieldElement r102 = calculateJacobianModifiedW(r100[0], null);
            r100[1] = r102;
            return r102;
        L6:
            return r101;
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECFieldElement getZCoord(int r100) {
            if (r100 != 1) goto L9;
            if (4 != getCurveCoordinateSystem()) goto L9;
            return getJacobianModifiedW();
        L9:
            return super.getZCoord(r100);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint negate() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r100 = getCurve();
            if (r100.getCoordinateSystem() == 0) goto L10;
            return new Fp(r100, this.f525438x, this.f525439y.negate(), this.f525440zs);
        L10:
            return new Fp(r100, this.f525438x, this.f525439y.negate());
        }

        public ECFieldElement three(ECFieldElement r100) {
            return two(r100).add(r100);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint threeTimes() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECFieldElement r100 = this.f525439y;
            if (r100.isZero() == false) goto L8;
            return this;
        L8:
            ECCurve r101 = getCurve();
            int r102 = r101.getCoordinateSystem();
            if (r102 != 0) goto L11;
            ECFieldElement r103 = this.f525438x;
            ECFieldElement r104 = two(r100);
            ECFieldElement r105 = r104.square();
            ECFieldElement r106 = three(r103.square()).add(getCurve().getA());
            ECFieldElement r107 = r106.square();
            ECFieldElement r108 = three(r103).multiply(r105).subtract(r107);
            if (r108.isZero() == true) goto L19;
            ECFieldElement r109 = r108.multiply(r104).invert();
            ECFieldElement r110 = r108.multiply(r109).multiply(r106);
            ECFieldElement r111 = r105.square().multiply(r109).subtract(r110);
            ECFieldElement r112 = r111.subtract(r110).multiply(r110.add(r111)).add(r103);
            return new Fp(r101, r112, r103.subtract(r112).multiply(r111).subtract(r100));
        L19:
            return getCurve().getInfinity();
        L11:
            if (r102 == 4) goto L15;
            return twice().add(this);
        L15:
            return twiceJacobianModified(false).add(this);
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint timesPow2(int r110) {
            if (r110 < 0) goto L63;
            if (r110 != 0) goto L6;
        L61:
            return this;
        L6:
            if (isInfinity() == true) goto L61;
            if (r110 == 1) goto L11;
            ECCurve r100 = getCurve();
            ECFieldElement r101 = this.f525439y;
            if (r101.isZero() == true) goto L15;
            int r102 = r100.getCoordinateSystem();
            ECFieldElement r103 = r100.getA();
            ECFieldElement r104 = this.f525438x;
            ECFieldElement[] r105 = this.f525440zs;
            if (r105.length >= 1) goto L19;
            ECFieldElement r106 = r100.fromBigInteger(ECConstants.ONE);
        L21:
            if (r106.isOne() == true) goto L32;
            if (r102 == 0) goto L32;
            if (r102 == 1) goto L30;
            if (r102 == 2) goto L29;
            if (r102 != 4) goto L28;
            r103 = getJacobianModifiedW();
            goto L32
        L28:
            throw new IllegalStateException("unsupported coordinate system");
        L29:
            ECFieldElement r107 = null;
        L31:
            r103 = calculateJacobianModifiedW(r106, r107);
            goto L32
        L30:
            r107 = r106.square();
            r104 = r104.multiply(r106);
            r101 = r101.multiply(r107);
        L32:
            int r108 = 0;
        L33:
            if (r108 >= r110) goto L46;
            if (r101.isZero() == true) goto L37;
            ECFieldElement r111 = three(r104.square());
            ECFieldElement r112 = two(r101);
            ECFieldElement r109 = r112.multiply(r101);
            ECFieldElement r113 = two(r104.multiply(r109));
            ECFieldElement r114 = two(r109.square());
            if (r103.isZero() == true) goto L41;
            r111 = r111.add(r103);
            r103 = two(r114.multiply(r103));
        L41:
            ECFieldElement r115 = r111.square().subtract(two(r113));
            r101 = r111.multiply(r113.subtract(r115)).subtract(r114);
            if (r106.isOne() == false) goto L44;
            r106 = r112;
        L45:
            r108 = r108 + 1;
            r104 = r115;
            goto L33
        L44:
            r106 = r112.multiply(r106);
            goto L45
        L37:
            return r100.getInfinity();
        L46:
            if (r102 == 0) goto L59;
            if (r102 == 1) goto L58;
            if (r102 == 2) goto L56;
            if (r102 != 4) goto L54;
            return new Fp(r100, r104, r101, new ECFieldElement[]{r106, r103});
        L54:
            throw new IllegalStateException("unsupported coordinate system");
        L56:
            return new Fp(r100, r104, r101, new ECFieldElement[]{r106});
        L58:
            return new Fp(r100, r104.multiply(r106), r101, new ECFieldElement[]{r106.multiply(r106.square())});
        L59:
            ECFieldElement r116 = r106.invert();
            ECFieldElement r117 = r116.square();
            return new Fp(r100, r104.multiply(r117), r101.multiply(r117.multiply(r116)));
        L19:
            r106 = r105[0];
            goto L21
        L15:
            return r100.getInfinity();
        L11:
            return twice();
        L63:
            throw new IllegalArgumentException("'e' cannot be negative");
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twice() {
            if (isInfinity() == false) goto L5;
            return this;
        L5:
            ECCurve r100 = getCurve();
            ECFieldElement r101 = this.f525439y;
            if (r101.isZero() == true) goto L8;
            int r102 = r100.getCoordinateSystem();
            ECFieldElement r103 = this.f525438x;
            if (r102 != 0) goto L12;
            ECFieldElement r104 = three(r103.square()).add(getCurve().getA()).divide(two(r101));
            ECFieldElement r105 = r104.square().subtract(two(r103));
            return new Fp(r100, r105, r104.multiply(r103.subtract(r105)).subtract(r101));
        L12:
            if (r102 != 1) goto L14;
            ECFieldElement r106 = this.f525440zs[0];
            boolean r107 = r106.isOne();
            ECFieldElement r108 = r100.getA();
            if (r108.isZero() == true) goto L47;
            if (r107 == true) goto L47;
            r108 = r108.multiply(r106.square());
        L47:
            ECFieldElement r109 = r108.add(three(r103.square()));
            if (r107 == false) goto L50;
            ECFieldElement r110 = r101;
        L51:
            if (r107 == false) goto L53;
            ECFieldElement r111 = r101.square();
        L54:
            ECFieldElement r112 = four(r103.multiply(r111));
            ECFieldElement r113 = r109.square().subtract(two(r112));
            ECFieldElement r114 = two(r110);
            ECFieldElement r115 = r113.multiply(r114);
            ECFieldElement r116 = two(r111);
            ECFieldElement r117 = r112.subtract(r113).multiply(r109).subtract(two(r116.square()));
            if (r107 == false) goto L57;
            ECFieldElement r118 = two(r116);
        L59:
            return new Fp(r100, r115, r117, new ECFieldElement[]{two(r118).multiply(r110)});
        L57:
            r118 = r114.square();
            goto L59
        L53:
            r111 = r110.multiply(r101);
            goto L54
        L50:
            r110 = r101.multiply(r106);
            goto L51
        L14:
            if (r102 != 2) goto L16;
            ECFieldElement r119 = this.f525440zs[0];
            boolean r120 = r119.isOne();
            ECFieldElement r121 = r101.square();
            ECFieldElement r122 = r121.square();
            ECFieldElement r123 = r100.getA();
            ECFieldElement r124 = r123.negate();
            if (r124.toBigInteger().equals(BigInteger.valueOf(3)) == false) goto L27;
            if (r120 == false) goto L25;
            ECFieldElement r125 = r119;
        L26:
            ECFieldElement r126 = three(r103.add(r125).multiply(r103.subtract(r125)));
            ECFieldElement r127 = r121.multiply(r103);
        L38:
            ECFieldElement r128 = four(r127);
            ECFieldElement r129 = r126.square().subtract(two(r128));
            ECFieldElement r130 = r128.subtract(r129).multiply(r126).subtract(eight(r122));
            ECFieldElement r131 = two(r101);
            if (r120 == true) goto L42;
            r131 = r131.multiply(r119);
        L42:
            return new Fp(r100, r129, r130, new ECFieldElement[]{r131});
        L25:
            r125 = r119.square();
            goto L26
        L27:
            ECFieldElement r132 = three(r103.square());
            if (r120 == false) goto L31;
        L29:
            r126 = r132.add(r123);
        L37:
            r127 = r103.multiply(r121);
            goto L38
        L31:
            if (r123.isZero() == true) goto L36;
            ECFieldElement r133 = r119.square().square();
            if (r124.bitLength() >= r123.bitLength()) goto L35;
            r126 = r132.subtract(r133.multiply(r124));
            goto L37
        L35:
            r123 = r133.multiply(r123);
            goto L29
        L36:
            r126 = r132;
            goto L37
        L16:
            if (r102 != 4) goto L20;
            return twiceJacobianModified(true);
        L20:
            throw new IllegalStateException("unsupported coordinate system");
        L8:
            return r100.getInfinity();
        }

        public Fp twiceJacobianModified(boolean r110) {
            ECFieldElement r100 = this.f525438x;
            ECFieldElement r101 = this.f525439y;
            ECFieldElement r102 = this.f525440zs[0];
            ECFieldElement r103 = getJacobianModifiedW();
            ECFieldElement r104 = three(r100.square()).add(r103);
            ECFieldElement r105 = two(r101);
            ECFieldElement r106 = r105.multiply(r101);
            ECFieldElement r107 = two(r100.multiply(r106));
            ECFieldElement r108 = r104.square().subtract(two(r107));
            ECFieldElement r109 = two(r106.square());
            ECFieldElement r111 = r104.multiply(r107.subtract(r108)).subtract(r109);
            if (r110 == false) goto L5;
            ECFieldElement r112 = two(r109.multiply(r103));
        L7:
            if (r102.isOne() == true) goto L11;
            r105 = r105.multiply(r102);
        L11:
            return new Fp(getCurve(), r108, r111, new ECFieldElement[]{r105, r112});
        L5:
            r112 = null;
            goto L7
        }

        @Override // org.bouncycastle.math.ec.ECPoint
        public ECPoint twicePlus(ECPoint r100) {
            if (this != r100) goto L6;
            return threeTimes();
        L6:
            if (isInfinity() == false) goto L9;
            return r100;
        L9:
            if (r100.isInfinity() == true) goto L11;
            ECFieldElement r101 = this.f525439y;
            if (r101.isZero() == false) goto L15;
            return r100;
        L15:
            ECCurve r102 = getCurve();
            int r103 = r102.getCoordinateSystem();
            if (r103 != 0) goto L18;
            ECFieldElement r104 = this.f525438x;
            ECFieldElement r105 = r100.f525438x;
            ECFieldElement r106 = r100.f525439y;
            ECFieldElement r107 = r105.subtract(r104);
            ECFieldElement r108 = r106.subtract(r101);
            if (r107.isZero() == true) goto L26;
            ECFieldElement r109 = r107.square();
            ECFieldElement r110 = r108.square();
            ECFieldElement r111 = r109.multiply(two(r104).add(r105)).subtract(r110);
            if (r111.isZero() == true) goto L33;
            ECFieldElement r112 = r111.multiply(r107).invert();
            ECFieldElement r113 = r111.multiply(r112).multiply(r108);
            ECFieldElement r114 = two(r101).multiply(r109).multiply(r107).multiply(r112).subtract(r113);
            ECFieldElement r115 = r114.subtract(r113).multiply(r113.add(r114)).add(r105);
            return new Fp(r102, r115, r104.subtract(r115).multiply(r114).subtract(r101));
        L33:
            return r102.getInfinity();
        L26:
            if (r108.isZero() == true) goto L28;
            return this;
        L28:
            return threeTimes();
        L18:
            if (r103 == 4) goto L22;
            return twice().add(r100);
        L22:
            return twiceJacobianModified(false).add(r100);
        L11:
            return twice();
        }

        public ECFieldElement two(ECFieldElement r100) {
            return r100.add(r100);
        }
    }

    static {
        EMPTY_ZS = new ECFieldElement[0];
    }

    public ECPoint(ECCurve r100, ECFieldElement r101, ECFieldElement r102) {
        this(r100, r101, r102, getInitialZCoords(r100));
    }

    public ECPoint(ECCurve r100, ECFieldElement r101, ECFieldElement r102, ECFieldElement[] r103) {
        this.preCompTable = null;
        this.curve = r100;
        this.f525438x = r101;
        this.f525439y = r102;
        this.f525440zs = r103;
    }

    public static ECFieldElement[] getInitialZCoords(ECCurve r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        if (r101 == 0) goto L29;
        if (r101 == 5) goto L29;
        ECFieldElement r102 = r100.fromBigInteger(ECConstants.ONE);
        if (r101 == 1) goto L27;
        if (r101 == 2) goto L27;
        if (r101 == 3) goto L25;
        if (r101 == 4) goto L23;
        if (r101 == 6) goto L27;
        throw new IllegalArgumentException("unknown coordinate system");
    L23:
        return new ECFieldElement[]{r102, r100.getA()};
    L25:
        return new ECFieldElement[]{r102, r102, r102};
    L27:
        return new ECFieldElement[]{r102};
    L29:
        return EMPTY_ZS;
    L5:
        r101 = r100.getCoordinateSystem();
        goto L6
    }

    public abstract ECPoint add(ECPoint r100);

    public void checkNormalized() {
        if (isNormalized() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("point not in normal form");
    }

    public ECPoint createScaledPoint(ECFieldElement r100, ECFieldElement r101) {
        return getCurve().createRawPoint(getRawXCoord().multiply(r100), getRawYCoord().multiply(r101));
    }

    public abstract ECPoint detach();

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof ECPoint) == true) goto L10;
        return false;
    L10:
        return equals((ECPoint) r100);
    }

    public boolean equals(ECPoint r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        ECCurve r101 = getCurve();
        ECCurve r102 = r100.getCurve();
        if (r101 != null) goto L8;
        boolean r103 = true;
    L9:
        if (r102 != null) goto L11;
        boolean r104 = true;
    L12:
        boolean r105 = isInfinity();
        boolean r106 = r100.isInfinity();
        if (r105 == true) goto L34;
        if (r106 == true) goto L34;
        if (r103 == false) goto L19;
        if (r104 == false) goto L19;
    L21:
        ECPoint r107 = this;
    L29:
        if (r107.getXCoord().equals(r100.getXCoord()) == true) goto L31;
        return false;
    L31:
        if (r107.getYCoord().equals(r100.getYCoord()) == false) goto L43;
        return true;
    L43:
        return false;
    L19:
        if (r103 == false) goto L22;
        r100 = r100.normalize();
        goto L21
    L22:
        if (r104 == false) goto L25;
        r107 = normalize();
        goto L29
    L25:
        if (r101.equals(r102) == true) goto L27;
        return false;
    L27:
        ECPoint[] r108 = {this, r101.importPoint(r100)};
        r101.normalizeAll(r108);
        r107 = r108[0];
        r100 = r108[1];
    L34:
        if (r105 == false) goto L44;
        if (r106 == false) goto L45;
        if (r103 == true) goto L40;
        if (r104 == true) goto L40;
        if (r101.equals(r102) == true) goto L40;
        return false;
    L40:
        return true;
    L45:
        return false;
    L44:
        return false;
    L11:
        r104 = false;
        goto L12
    L8:
        r103 = false;
        goto L9
    }

    public ECFieldElement getAffineXCoord() {
        checkNormalized();
        return getXCoord();
    }

    public ECFieldElement getAffineYCoord() {
        checkNormalized();
        return getYCoord();
    }

    public abstract boolean getCompressionYTilde();

    public ECCurve getCurve() {
        return this.curve;
    }

    public int getCurveCoordinateSystem() {
        ECCurve r100 = this.curve;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.getCoordinateSystem();
    }

    public final ECPoint getDetachedPoint() {
        return normalize().detach();
    }

    public byte[] getEncoded(boolean r100) {
        if (isInfinity() == true) goto L5;
        ECPoint r101 = normalize();
        byte[] r102 = r101.getXCoord().getEncoded();
        if (r100 == false) goto L14;
        byte[] r103 = new byte[r102.length + 1];
        if (r101.getCompressionYTilde() == false) goto L11;
        int r104 = 3;
    L12:
        r103[0] = (byte) r104;
        System.arraycopy(r102, 0, r103, 1, r102.length);
        return r103;
    L11:
        r104 = 2;
        goto L12
    L14:
        byte[] r105 = r101.getYCoord().getEncoded();
        byte[] r106 = new byte[(r102.length + r105.length) + 1];
        r106[0] = 4;
        System.arraycopy(r102, 0, r106, 1, r102.length);
        System.arraycopy(r105, 0, r106, r102.length + 1, r105.length);
        return r106;
    L5:
        return new byte[1];
    }

    public final ECFieldElement getRawXCoord() {
        return this.f525438x;
    }

    public final ECFieldElement getRawYCoord() {
        return this.f525439y;
    }

    public final ECFieldElement[] getRawZCoords() {
        return this.f525440zs;
    }

    public ECFieldElement getXCoord() {
        return this.f525438x;
    }

    public ECFieldElement getYCoord() {
        return this.f525439y;
    }

    public ECFieldElement getZCoord(int r100) {
        if (r100 < 0) goto L7;
        ECFieldElement[] r101 = this.f525440zs;
        if (r100 >= r101.length) goto L7;
        return r101[r100];
    L7:
        return null;
    }

    public ECFieldElement[] getZCoords() {
        ECFieldElement[] r100 = this.f525440zs;
        int r101 = r100.length;
        if (r101 == 0) goto L5;
        ECFieldElement[] r102 = new ECFieldElement[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    L5:
        return EMPTY_ZS;
    }

    public int hashCode() {
        ECCurve r100 = getCurve();
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        if (isInfinity() == true) goto L10;
        ECPoint r102 = normalize();
        return (r101 ^ (r102.getXCoord().hashCode() * 17)) ^ (r102.getYCoord().hashCode() * 257);
    L10:
        return r101;
    L5:
        r101 = ~r100.hashCode();
        goto L7
    }

    public boolean implIsValid(final boolean r100, final boolean r101) {
        if (isInfinity() == false) goto L6;
        return true;
    L6:
        return !((ValidityPrecompInfo) getCurve().precompute(this, "bc_validity", new AnonymousClass1(this, r100, r101))).hasFailed();
    }

    public boolean isInfinity() {
        if (this.f525438x != null) goto L5;
    L10:
        return true;
    L5:
        if (this.f525439y == null) goto L10;
        ECFieldElement[] r100 = this.f525440zs;
        if (r100.length > 0) goto L9;
        return false;
    L9:
        if (r100[0].isZero() == true) goto L10;
        return false;
    }

    public boolean isNormalized() {
        int r100 = getCurveCoordinateSystem();
        if (r100 != 0) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 5) goto L10;
        if (isInfinity() == true) goto L10;
        if (this.f525440zs[0].isOne() == true) goto L10;
        return false;
    }

    public boolean isValid() {
        return implIsValid(false, true);
    }

    public boolean isValidPartial() {
        return implIsValid(false, false);
    }

    public ECPoint multiply(BigInteger r100) {
        return getCurve().getMultiplier().multiply(this, r100);
    }

    public abstract ECPoint negate();

    public ECPoint normalize() {
        if (isInfinity() == false) goto L5;
        return this;
    L5:
        int r100 = getCurveCoordinateSystem();
        if (r100 != 0) goto L8;
    L18:
        return this;
    L8:
        if (r100 == 5) goto L18;
        ECFieldElement r101 = getZCoord(0);
        if (r101.isOne() == false) goto L13;
        return this;
    L13:
        if (this.curve == null) goto L17;
        SecureRandom r102 = CryptoServicesRegistrar.getSecureRandom();
        ECFieldElement r103 = this.curve.randomFieldElementMult(r102);
        return normalize(r101.multiply(r103).invert().multiply(r103));
    L17:
        throw new IllegalStateException("Detached points must be in affine coordinates");
    }

    public ECPoint normalize(ECFieldElement r100) {
        int r101 = getCurveCoordinateSystem();
        if (r101 == 1) goto L18;
        if (r101 != 2) goto L7;
    L15:
        ECFieldElement r102 = r100.square();
        return createScaledPoint(r102, r102.multiply(r100));
    L7:
        if (r101 == 3) goto L15;
        if (r101 == 4) goto L15;
        if (r101 == 6) goto L18;
        throw new IllegalStateException("not a projective coordinate system");
    L18:
        return createScaledPoint(r100, r100);
    }

    public abstract boolean satisfiesCurveEquation();

    public boolean satisfiesOrder() {
        if (ECConstants.ONE.equals(this.curve.getCofactor()) == false) goto L5;
        return true;
    L5:
        BigInteger r100 = this.curve.getOrder();
        if (r100 != null) goto L8;
        return true;
    L8:
        if (ECAlgorithms.referenceMultiply(this, r100).isInfinity() == true) goto L13;
        return false;
    L13:
        return true;
    }

    public ECPoint scaleX(ECFieldElement r100) {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return getCurve().createRawPoint(getRawXCoord().multiply(r100), getRawYCoord(), getRawZCoords());
    }

    public ECPoint scaleXNegateY(ECFieldElement r100) {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return getCurve().createRawPoint(getRawXCoord().multiply(r100), getRawYCoord().negate(), getRawZCoords());
    }

    public ECPoint scaleY(ECFieldElement r100) {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(r100), getRawZCoords());
    }

    public ECPoint scaleYNegateX(ECFieldElement r100) {
        if (isInfinity() == false) goto L6;
        return this;
    L6:
        return getCurve().createRawPoint(getRawXCoord().negate(), getRawYCoord().multiply(r100), getRawZCoords());
    }

    public abstract ECPoint subtract(ECPoint r100);

    public ECPoint threeTimes() {
        return twicePlus(this);
    }

    public ECPoint timesPow2(int r100) {
        if (r100 < 0) goto L9;
        ECPoint r101 = this;
    L4:
        r100 = r100 - 1;
        if (r100 < 0) goto L7;
        r101 = r101.twice();
        goto L4
    L7:
        return r101;
    L9:
        throw new IllegalArgumentException("'e' cannot be negative");
    }

    public String toString() {
        if (isInfinity() == false) goto L6;
        return "INF";
    L6:
        StringBuffer r100 = new StringBuffer("(");
        r100.append(getRawXCoord());
        r100.append(',');
        r100.append(getRawYCoord());
        int r101 = 0;
    L8:
        if (r101 >= this.f525440zs.length) goto L10;
        r100.append(',');
        r100.append(this.f525440zs[r101]);
        r101 = r101 + 1;
        goto L8
    L10:
        r100.append(')');
        return r100.toString();
    }

    public abstract ECPoint twice();

    public ECPoint twicePlus(ECPoint r100) {
        return twice().add(r100);
    }
}
