package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.ec.endo.EndoUtil;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.PolynomialExtensionField;
import org.bouncycastle.math.raw.Nat;

/* JADX INFO: loaded from: classes42.dex */
public class ECAlgorithms {
    public ECAlgorithms() {
    }

    public static ECPoint cleanPoint(ECCurve r100, ECPoint r101) {
        if (r100.equals(r101.getCurve()) == false) goto L7;
        return r100.decodePoint(r101.getEncoded(false));
    L7:
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static ECPoint implCheckResult(ECPoint r100) {
        if (r100.isValidPartial() == false) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Invalid result");
    }

    private static ECPoint implShamirsTrickFixedPoint(ECPoint r110, BigInteger r111, ECPoint r210, BigInteger r211) {
        ECCurve r100 = r110.getCurve();
        int r101 = FixedPointUtil.getCombSize(r100);
        if (r111.bitLength() > r101) goto L19;
        if (r211.bitLength() > r101) goto L19;
        FixedPointPreCompInfo r102 = FixedPointUtil.precompute(r110);
        FixedPointPreCompInfo r103 = FixedPointUtil.precompute(r210);
        ECLookupTable r104 = r102.getLookupTable();
        ECLookupTable r105 = r103.getLookupTable();
        int r106 = r102.getWidth();
        if (r106 == r103.getWidth()) goto L11;
        FixedPointCombMultiplier r107 = new FixedPointCombMultiplier();
        ECPoint r108 = r107.multiply(r110, r111);
        ECPoint r109 = r107.multiply(r210, r211);
    L10:
        return r108.add(r109);
    L11:
        int r112 = ((r101 + r106) - 1) / r106;
        ECPoint r113 = r100.getInfinity();
        int r114 = r106 * r112;
        int[] r115 = Nat.fromBigInteger(r114, r111);
        int[] r116 = Nat.fromBigInteger(r114, r211);
        int r117 = r114 - 1;
        int r118 = 0;
    L12:
        if (r118 >= r112) goto L17;
        int r119 = r117 - r118;
        int r120 = 0;
        int r121 = 0;
    L14:
        if (r119 < 0) goto L16;
        int r122 = r119 >>> 5;
        int r123 = r119 & 31;
        int r124 = r115[r122] >>> r123;
        r120 = ((r120 ^ (r124 >>> 1)) << 1) ^ r124;
        int r125 = r116[r122] >>> r123;
        r121 = ((r121 ^ (r125 >>> 1)) << 1) ^ r125;
        r119 = r119 - r112;
        goto L14
    L16:
        r113 = r113.twicePlus(r104.lookupVar(r120).add(r105.lookupVar(r121)));
        r118 = r118 + 1;
        goto L12
    L17:
        r108 = r113.add(r102.getOffset());
        r109 = r103.getOffset();
    L19:
        throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
    }

    public static ECPoint implShamirsTrickJsf(ECPoint r100, BigInteger r101, ECPoint r102, BigInteger r110) {
        ECCurve r103 = r100.getCurve();
        ECPoint r104 = r103.getInfinity();
        ECPoint[] r105 = {r102, r100.subtract(r102), r100, r100.add(r102)};
        r103.normalizeAll(r105);
        ECPoint[] r106 = {r105[3].negate(), r105[2].negate(), r105[1].negate(), r105[0].negate(), r104, r105[0], r105[1], r105[2], r105[3]};
        byte[] r107 = WNafUtil.generateJSF(r101, r110);
        int r108 = r107.length;
    L3:
        r108 = r108 - 1;
        if (r108 < 0) goto L6;
        byte r111 = r107[r108];
        r104 = r104.twicePlus(r106[((((r111 << 24) >> 28) * 3) + 4) + ((r111 << 28) >> 28)]);
        goto L3
    L6:
        return r104;
    }

    public static ECPoint implShamirsTrickWNaf(ECPoint r110, BigInteger r111, ECPoint r112, BigInteger r113) {
        boolean r100 = false;
        if (r111.signum() >= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r113.signum() >= 0) goto L9;
        r100 = true;
    L9:
        BigInteger r102 = r111.abs();
        BigInteger r103 = r113.abs();
        int r104 = WNafUtil.getWindowSize(r102.bitLength(), 8);
        int r105 = WNafUtil.getWindowSize(r103.bitLength(), 8);
        WNafPreCompInfo r106 = WNafUtil.precompute(r110, r104, true);
        WNafPreCompInfo r107 = WNafUtil.precompute(r112, r105, true);
        int r108 = FixedPointUtil.getCombSize(r110.getCurve());
        if (r101 == true) goto L22;
        if (r100 == true) goto L22;
        if (r111.bitLength() > r108) goto L22;
        if (r113.bitLength() > r108) goto L22;
        if (r106.isPromoted() == false) goto L22;
        if (r107.isPromoted() == false) goto L22;
        return implShamirsTrickFixedPoint(r110, r111, r112, r113);
    L22:
        int r114 = Math.min(8, r106.getWidth());
        int r115 = Math.min(8, r107.getWidth());
        if (r101 == false) goto L25;
        ECPoint[] r116 = r106.getPreCompNeg();
    L26:
        ECPoint[] r109 = r116;
        if (r100 == false) goto L29;
        ECPoint[] r117 = r107.getPreCompNeg();
    L30:
        ECPoint[] r118 = r117;
        if (r101 == false) goto L33;
        ECPoint[] r119 = r106.getPreComp();
    L34:
        ECPoint[] r120 = r119;
        if (r100 == false) goto L37;
        ECPoint[] r121 = r107.getPreComp();
    L38:
        byte[] r122 = WNafUtil.generateWindowNaf(r114, r102);
        return implShamirsTrickWNaf(r109, r120, r122, r118, r121, WNafUtil.generateWindowNaf(r115, r103));
    L37:
        r121 = r107.getPreCompNeg();
        goto L38
    L33:
        r119 = r106.getPreCompNeg();
        goto L34
    L29:
        r117 = r107.getPreComp();
        goto L30
    L25:
        r116 = r106.getPreComp();
        goto L26
    L5:
        r101 = false;
        goto L7
    }

    public static ECPoint implShamirsTrickWNaf(ECEndomorphism r110, ECPoint r111, BigInteger r112, BigInteger r113) {
        boolean r100 = false;
        if (r112.signum() >= 0) goto L5;
        boolean r101 = true;
    L7:
        if (r113.signum() >= 0) goto L9;
        r100 = true;
    L9:
        BigInteger r114 = r112.abs();
        BigInteger r115 = r113.abs();
        WNafPreCompInfo r102 = WNafUtil.precompute(r111, WNafUtil.getWindowSize(Math.max(r114.bitLength(), r115.bitLength()), 8), true);
        WNafPreCompInfo r116 = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(r110, r111), r110.getPointMap(), r102, true);
        int r117 = Math.min(8, r102.getWidth());
        int r103 = Math.min(8, r116.getWidth());
        if (r101 == false) goto L12;
        ECPoint[] r104 = r102.getPreCompNeg();
    L13:
        ECPoint[] r105 = r104;
        if (r100 == false) goto L16;
        ECPoint[] r106 = r116.getPreCompNeg();
    L17:
        ECPoint[] r107 = r106;
        if (r101 == false) goto L20;
        ECPoint[] r108 = r102.getPreComp();
    L21:
        ECPoint[] r109 = r108;
        if (r100 == false) goto L24;
        ECPoint[] r118 = r116.getPreComp();
    L25:
        byte[] r119 = WNafUtil.generateWindowNaf(r117, r114);
        return implShamirsTrickWNaf(r105, r109, r119, r107, r118, WNafUtil.generateWindowNaf(r103, r115));
    L24:
        r118 = r116.getPreCompNeg();
        goto L25
    L20:
        r108 = r102.getPreCompNeg();
        goto L21
    L16:
        r106 = r116.getPreComp();
        goto L17
    L12:
        r104 = r102.getPreComp();
        goto L13
    L5:
        r101 = false;
        goto L7
    }

    private static ECPoint implShamirsTrickWNaf(ECPoint[] r100, ECPoint[] r101, byte[] r110, ECPoint[] r111, ECPoint[] r112, byte[] r113) {
        int r102 = Math.max(r110.length, r113.length);
        ECPoint r103 = r100[0].getCurve().getInfinity();
        int r104 = r102 - 1;
        ECPoint r105 = r103;
        int r106 = 0;
    L3:
        if (r104 < 0) goto L32;
        if (r104 >= r110.length) goto L7;
        byte r107 = r110[r104];
    L9:
        if (r104 >= r113.length) goto L11;
        byte r108 = r113[r104];
    L13:
        if ((r107 | r108) != 0) goto L15;
        r106 = r106 + 1;
    L31:
        r104 = r104 - 1;
        goto L3
    L15:
        if (r107 == 0) goto L21;
        int r109 = Math.abs(r107);
        if (r107 >= 0) goto L19;
        ECPoint[] r114 = r101;
    L20:
        ECPoint r115 = r103.add(r114[r109 >>> 1]);
    L22:
        if (r108 == 0) goto L28;
        int r116 = Math.abs(r108);
        if (r108 >= 0) goto L26;
        ECPoint[] r117 = r112;
    L27:
        r115 = r115.add(r117[r116 >>> 1]);
        goto L28
    L26:
        r117 = r111;
    L28:
        if (r106 <= 0) goto L30;
        r105 = r105.timesPow2(r106);
        r106 = 0;
    L30:
        r105 = r105.twicePlus(r115);
        goto L31
    L19:
        r114 = r100;
        goto L20
    L21:
        r115 = r103;
        goto L22
    L11:
        r108 = 0;
        goto L13
    L7:
        r107 = 0;
        goto L9
    L32:
        if (r106 > 0) goto L34;
        return r105;
    L34:
        return r105.timesPow2(r106);
    }

    public static ECPoint implSumOfMultiplies(ECEndomorphism r110, ECPoint[] r111, BigInteger[] r112) {
        ECPoint[] r100 = r111;
        int r101 = r100.length;
        int r102 = r101 << 1;
        boolean[] r103 = new boolean[r102];
        WNafPreCompInfo[] r104 = new WNafPreCompInfo[r102];
        byte[][] r105 = new byte[r102][];
        ECPointMap r106 = r110.getPointMap();
        int r107 = 0;
    L3:
        if (r107 >= r101) goto L14;
        int r108 = r107 << 1;
        int r109 = r108 + 1;
        BigInteger r113 = r112[r108];
        if (r113.signum() >= 0) goto L7;
        boolean r114 = true;
    L8:
        r103[r108] = r114;
        BigInteger r115 = r113.abs();
        BigInteger r116 = r112[r109];
        if (r116.signum() >= 0) goto L11;
        boolean r117 = true;
    L12:
        r103[r109] = r117;
        BigInteger r118 = r116.abs();
        int r119 = WNafUtil.getWindowSize(Math.max(r115.bitLength(), r118.bitLength()), 8);
        ECPoint r120 = r100[r107];
        WNafPreCompInfo r121 = WNafUtil.precompute(r120, r119, true);
        WNafPreCompInfo r122 = WNafUtil.precomputeWithPointMap(EndoUtil.mapPoint(r110, r120), r106, r121, true);
        int r123 = Math.min(8, r121.getWidth());
        int r124 = Math.min(8, r122.getWidth());
        r104[r108] = r121;
        r104[r109] = r122;
        r105[r108] = WNafUtil.generateWindowNaf(r123, r115);
        r105[r109] = WNafUtil.generateWindowNaf(r124, r118);
        r107 = r107 + 1;
        r100 = r111;
        goto L3
    L11:
        r117 = false;
        goto L12
    L7:
        r114 = false;
        goto L8
    L14:
        return implSumOfMultiplies(r103, r104, r105);
    }

    public static ECPoint implSumOfMultiplies(ECPoint[] r110, BigInteger[] r111) {
        int r100 = r110.length;
        boolean[] r101 = new boolean[r100];
        WNafPreCompInfo[] r102 = new WNafPreCompInfo[r100];
        byte[][] r103 = new byte[r100][];
        int r104 = 0;
    L3:
        if (r104 >= r100) goto L10;
        BigInteger r105 = r111[r104];
        if (r105.signum() >= 0) goto L7;
        boolean r106 = true;
    L8:
        r101[r104] = r106;
        BigInteger r107 = r105.abs();
        int r108 = WNafUtil.getWindowSize(r107.bitLength(), 8);
        WNafPreCompInfo r109 = WNafUtil.precompute(r110[r104], r108, true);
        int r112 = Math.min(8, r109.getWidth());
        r102[r104] = r109;
        r103[r104] = WNafUtil.generateWindowNaf(r112, r107);
        r104 = r104 + 1;
        goto L3
    L7:
        r106 = false;
        goto L8
    L10:
        return implSumOfMultiplies(r101, r102, r103);
    }

    private static ECPoint implSumOfMultiplies(boolean[] r110, WNafPreCompInfo[] r111, byte[][] r112) {
        int r100 = r112.length;
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L5;
        r102 = Math.max(r102, r112[r101].length);
        r101 = r101 + 1;
        goto L3
    L5:
        ECPoint r103 = r111[0].getPreComp()[0].getCurve().getInfinity();
        int r104 = r102 - 1;
        ECPoint r105 = r103;
        int r106 = 0;
    L6:
        if (r104 < 0) goto L30;
        ECPoint r107 = r103;
        int r108 = 0;
    L8:
        if (r108 >= r100) goto L24;
        byte[] r109 = r112[r108];
        if (r104 >= r109.length) goto L12;
        byte r113 = r109[r104];
    L13:
        if (r113 == 0) goto L23;
        int r114 = Math.abs(r113);
        WNafPreCompInfo r115 = r111[r108];
        if (r113 >= 0) goto L17;
        boolean r116 = true;
    L19:
        if (r116 != r110[r108]) goto L21;
        ECPoint[] r117 = r115.getPreComp();
    L22:
        r107 = r107.add(r117[r114 >>> 1]);
        goto L23
    L21:
        r117 = r115.getPreCompNeg();
        goto L22
    L17:
        r116 = false;
    L23:
        r108 = r108 + 1;
        goto L8
    L12:
        r113 = 0;
        goto L13
    L24:
        if (r107 != r103) goto L26;
        r106 = r106 + 1;
    L29:
        r104 = r104 - 1;
        goto L6
    L26:
        if (r106 <= 0) goto L28;
        r105 = r105.timesPow2(r106);
        r106 = 0;
    L28:
        r105 = r105.twicePlus(r107);
        goto L29
    L30:
        if (r106 > 0) goto L32;
        return r105;
    L32:
        return r105.timesPow2(r106);
    }

    public static ECPoint implSumOfMultipliesGLV(ECPoint[] r110, BigInteger[] r111, GLVEndomorphism r112) {
        int r100 = 0;
        BigInteger r101 = r110[0].getCurve().getOrder();
        int r102 = r110.length;
        int r103 = r102 << 1;
        BigInteger[] r104 = new BigInteger[r103];
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r105 >= r102) goto L6;
        BigInteger[] r107 = r112.decomposeScalar(r111[r105].mod(r101));
        int r108 = r106 + 1;
        r104[r106] = r107[0];
        r106 = r108 + 1;
        r104[r108] = r107[1];
        r105 = r105 + 1;
        goto L3
    L6:
        if (r112.hasEfficientPointMap() == true) goto L8;
        ECPoint[] r113 = new ECPoint[r103];
        int r109 = 0;
    L10:
        if (r100 >= r102) goto L13;
        ECPoint r114 = r110[r100];
        ECPoint r115 = EndoUtil.mapPoint(r112, r114);
        int r116 = r109 + 1;
        r113[r109] = r114;
        r109 = r116 + 1;
        r113[r116] = r115;
        r100 = r100 + 1;
        goto L10
    L13:
        return implSumOfMultiplies(r113, r104);
    L8:
        return implSumOfMultiplies(r112, r110, r104);
    }

    public static ECPoint importPoint(ECCurve r100, ECPoint r101) {
        if (r100.equals(r101.getCurve()) == false) goto L7;
        return r100.importPoint(r101);
    L7:
        throw new IllegalArgumentException("Point must be on the same curve");
    }

    public static boolean isF2mCurve(ECCurve r100) {
        return isF2mField(r100.getField());
    }

    public static boolean isF2mField(FiniteField r100) {
        if (r100.getDimension() > 1) goto L5;
    L9:
        return false;
    L5:
        if (r100.getCharacteristic().equals(ECConstants.TWO) == false) goto L9;
        if ((r100 instanceof PolynomialExtensionField) == false) goto L9;
        return true;
    }

    public static boolean isFpCurve(ECCurve r100) {
        return isFpField(r100.getField());
    }

    public static boolean isFpField(FiniteField r100) {
        if (r100.getDimension() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static void montgomeryTrick(ECFieldElement[] r100, int r101, int r102) {
        montgomeryTrick(r100, r101, r102, null);
    }

    public static void montgomeryTrick(ECFieldElement[] r100, int r101, int r102, ECFieldElement r103) {
        ECFieldElement[] r104 = new ECFieldElement[r102];
        int r105 = 0;
        r104[0] = r100[r101];
    L3:
        r105 = r105 + 1;
        if (r105 >= r102) goto L6;
        r104[r105] = r104[r105 - 1].multiply(r100[r101 + r105]);
        goto L3
    L6:
        int r106 = r105 - 1;
        if (r103 == null) goto L9;
        r104[r106] = r104[r106].multiply(r103);
    L9:
        ECFieldElement r107 = r104[r106].invert();
    L10:
        if (r106 <= 0) goto L12;
        int r108 = r106 - 1;
        int r109 = r106 + r101;
        ECFieldElement r110 = r100[r109];
        r100[r109] = r104[r108].multiply(r107);
        r107 = r107.multiply(r110);
        r106 = r108;
        goto L10
    L12:
        r100[r101] = r107;
    }

    public static ECPoint referenceMultiply(ECPoint r100, BigInteger r101) {
        BigInteger r102 = r101.abs();
        ECPoint r103 = r100.getCurve().getInfinity();
        int r104 = r102.bitLength();
        if (r104 <= 0) goto L14;
        if (r102.testBit(0) == false) goto L7;
        r103 = r100;
    L7:
        int r105 = 1;
    L8:
        if (r105 >= r104) goto L14;
        r100 = r100.twice();
        if (r102.testBit(r105) == false) goto L12;
        r103 = r103.add(r100);
    L12:
        r105 = r105 + 1;
    L14:
        if (r101.signum() < 0) goto L16;
        return r103;
    L16:
        return r103.negate();
    }

    public static ECPoint shamirsTrick(ECPoint r100, BigInteger r101, ECPoint r102, BigInteger r103) {
        return implCheckResult(implShamirsTrickJsf(r100, r101, importPoint(r100.getCurve(), r102), r103));
    }

    public static ECPoint sumOfMultiplies(ECPoint[] r100, BigInteger[] r101) {
        if (r100 == null) goto L26;
        if (r101 == null) goto L26;
        if (r100.length != r101.length) goto L26;
        int r102 = 1;
        if (r100.length < 1) goto L26;
        int r103 = r100.length;
        if (r103 == 1) goto L24;
        if (r103 == 2) goto L22;
        ECPoint r104 = r100[0];
        ECCurve r105 = r104.getCurve();
        ECPoint[] r106 = new ECPoint[r103];
        r106[0] = r104;
    L13:
        if (r102 >= r103) goto L15;
        r106[r102] = importPoint(r105, r100[r102]);
        r102 = r102 + 1;
        goto L13
    L15:
        ECEndomorphism r107 = r105.getEndomorphism();
        if ((r107 instanceof GLVEndomorphism) == false) goto L20;
        return implCheckResult(implSumOfMultipliesGLV(r106, r101, (GLVEndomorphism) r107));
    L20:
        return implCheckResult(implSumOfMultiplies(r106, r101));
    L22:
        return sumOfTwoMultiplies(r100[0], r101[0], r100[1], r101[1]);
    L24:
        return r100[0].multiply(r101[0]);
    L26:
        throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
    }

    public static ECPoint sumOfTwoMultiplies(ECPoint r100, BigInteger r101, ECPoint r102, BigInteger r103) {
        ECCurve r104 = r100.getCurve();
        ECPoint r105 = importPoint(r104, r102);
        if ((r104 instanceof ECCurve.AbstractF2m) == true) goto L5;
    L9:
        ECEndomorphism r106 = r104.getEndomorphism();
        if ((r106 instanceof GLVEndomorphism) == false) goto L12;
        ECPoint r107 = implSumOfMultipliesGLV(new ECPoint[]{r100, r105}, new BigInteger[]{r101, r103}, (GLVEndomorphism) r106);
    L8:
        return implCheckResult(r107);
    L12:
        r107 = implShamirsTrickWNaf(r100, r101, r105, r103);
        goto L8
    L5:
        if (((ECCurve.AbstractF2m) r104).isKoblitz() == false) goto L9;
        r107 = r100.multiply(r101).add(r105.multiply(r103));
        goto L8
    }

    public static ECPoint validatePoint(ECPoint r100) {
        if (r100.isValid() == false) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Invalid point");
    }
}
