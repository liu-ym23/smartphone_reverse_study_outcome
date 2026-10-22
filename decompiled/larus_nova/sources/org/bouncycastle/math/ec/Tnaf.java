package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
class Tnaf {
    private static final BigInteger MINUS_ONE = null;
    private static final BigInteger MINUS_THREE = null;
    private static final BigInteger MINUS_TWO = null;
    public static final byte POW_2_WIDTH = 16;
    public static final byte WIDTH = 4;
    public static final ZTauElement[] alpha0 = null;
    public static final byte[][] alpha0Tnaf = null;
    public static final ZTauElement[] alpha1 = null;
    public static final byte[][] alpha1Tnaf = null;

    static {
        BigInteger r100 = ECConstants.ONE;
        BigInteger r101 = r100.negate();
        MINUS_ONE = r101;
        MINUS_TWO = ECConstants.TWO.negate();
        BigInteger r102 = ECConstants.THREE.negate();
        MINUS_THREE = r102;
        BigInteger r103 = ECConstants.ZERO;
        alpha0 = new ZTauElement[]{null, new ZTauElement(r100, r103), null, new ZTauElement(r102, r101), null, new ZTauElement(r101, r101), null, new ZTauElement(r100, r101), null};
        alpha0Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        alpha1 = new ZTauElement[]{null, new ZTauElement(r100, r103), null, new ZTauElement(r102, r100), null, new ZTauElement(r101, r100), null, new ZTauElement(r100, r100), null};
        alpha1Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public Tnaf() {
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger r100, BigInteger r101, BigInteger r102, byte r103, int r104, int r105) {
        int r106 = ((r104 + 5) / 2) + r105;
        BigInteger r107 = r101.multiply(r100.shiftRight(((r104 - r106) - 2) + r103));
        BigInteger r108 = r107.add(r102.multiply(r107.shiftRight(r104)));
        int r109 = r106 - r105;
        BigInteger r110 = r108.shiftRight(r109);
        if (r108.testBit(r109 - 1) == false) goto L6;
        r110 = r110.add(ECConstants.ONE);
    L6:
        return new SimpleBigDecimal(r110, r105);
    }

    public static BigInteger[] getLucas(byte r100, int r101, boolean r102) {
        if (r100 != 1) goto L5;
    L9:
        if (r102 == false) goto L11;
        BigInteger r103 = ECConstants.TWO;
        BigInteger r104 = BigInteger.valueOf(r100);
    L12:
        int r105 = 1;
    L13:
        if (r105 >= r101) goto L19;
        if (r100 != 1) goto L16;
        BigInteger r106 = r104;
    L17:
        r105 = r105 + 1;
        BigInteger r107 = r104;
        r104 = r106.subtract(r103.shiftLeft(1));
        r103 = r107;
        goto L13
    L16:
        r106 = r104.negate();
        goto L17
    L19:
        return new BigInteger[]{r103, r104};
    L11:
        r103 = ECConstants.ZERO;
        r104 = ECConstants.ONE;
        goto L12
    L5:
        if (r100 == (-1)) goto L9;
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static byte getMu(int r100) {
        if (r100 != 0) goto L4;
        int r101 = -1;
    L6:
        return (byte) r101;
    L4:
        r101 = 1;
        goto L6
    }

    public static byte getMu(ECCurve.AbstractF2m r100) {
        if (r100.isKoblitz() == false) goto L11;
        if (r100.getA().isZero() == false) goto L8;
        return -1;
    L8:
        return 1;
    L11:
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    public static byte getMu(ECFieldElement r100) {
        if (r100.isZero() == false) goto L5;
        int r101 = -1;
    L7:
        return (byte) r101;
    L5:
        r101 = 1;
        goto L7
    }

    public static ECPoint.AbstractF2m[] getPreComp(ECPoint.AbstractF2m r100, byte r101) {
        if (r101 != 0) goto L4;
        byte[][] r102 = alpha0Tnaf;
    L5:
        ECPoint.AbstractF2m[] r103 = new ECPoint.AbstractF2m[(r102.length + 1) >>> 1];
        r103[0] = r100;
        int r104 = r102.length;
        int r105 = 3;
    L6:
        if (r105 >= r104) goto L8;
        r103[r105 >>> 1] = multiplyFromTnaf(r100, r102[r105]);
        r105 = r105 + 2;
        goto L6
    L8:
        r100.getCurve().normalizeAll(r103);
        return r103;
    L4:
        r102 = alpha1Tnaf;
        goto L5
    }

    public static int getShiftsForCofactor(BigInteger r100) {
        if (r100 == null) goto L12;
        if (r100.equals(ECConstants.TWO) == false) goto L8;
        return 1;
    L8:
        if (r100.equals(ECConstants.FOUR) == false) goto L12;
        return 2;
    L12:
        throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
    }

    public static BigInteger[] getSi(int r100, int r101, BigInteger r102) {
        byte r103 = getMu(r101);
        int r104 = getShiftsForCofactor(r102);
        BigInteger[] r105 = getLucas(r103, (r100 + 3) - r101, false);
        if (r103 != 1) goto L5;
        r105[0] = r105[0].negate();
        r105[1] = r105[1].negate();
    L5:
        BigInteger r106 = ECConstants.ONE;
        return new BigInteger[]{r106.add(r105[1]).shiftRight(r104), r106.add(r105[0]).shiftRight(r104).negate()};
    }

    public static BigInteger[] getSi(ECCurve.AbstractF2m r100) {
        if (r100.isKoblitz() == false) goto L10;
        int r101 = r100.getFieldSize();
        int r102 = r100.getA().toBigInteger().intValue();
        byte r103 = getMu(r102);
        int r104 = getShiftsForCofactor(r100.getCofactor());
        BigInteger[] r105 = getLucas(r103, (r101 + 3) - r102, false);
        if (r103 != 1) goto L7;
        r105[0] = r105[0].negate();
        r105[1] = r105[1].negate();
    L7:
        BigInteger r106 = ECConstants.ONE;
        return new BigInteger[]{r106.add(r105[1]).shiftRight(r104), r106.add(r105[0]).shiftRight(r104).negate()};
    L10:
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    public static BigInteger getTw(byte r100, int r101) {
        if (r101 != 4) goto L9;
        if (r100 != 1) goto L8;
        return BigInteger.valueOf(6);
    L8:
        return BigInteger.valueOf(10);
    L9:
        BigInteger[] r102 = getLucas(r100, r101, false);
        BigInteger r103 = ECConstants.ZERO.setBit(r101);
        BigInteger r104 = r102[1].modInverse(r103);
        return ECConstants.TWO.multiply(r102[0]).multiply(r104).mod(r103);
    }

    public static ECPoint.AbstractF2m multiplyFromTnaf(ECPoint.AbstractF2m r100, byte[] r101) {
        ECPoint.AbstractF2m r102 = (ECPoint.AbstractF2m) r100.getCurve().getInfinity();
        ECPoint.AbstractF2m r103 = (ECPoint.AbstractF2m) r100.negate();
        int r104 = r101.length - 1;
        int r105 = 0;
    L3:
        if (r104 < 0) goto L12;
        r105 = r105 + 1;
        byte r106 = r101[r104];
        if (r106 == 0) goto L11;
        ECPoint.AbstractF2m r107 = r102.tauPow(r105);
        if (r106 <= 0) goto L9;
        ECPoint.AbstractF2m r108 = r100;
    L10:
        r102 = (ECPoint.AbstractF2m) r107.add(r108);
        r105 = 0;
        goto L11
    L9:
        r108 = r103;
    L11:
        r104 = r104 - 1;
        goto L3
    L12:
        if (r105 > 0) goto L14;
        return r102;
    L14:
        return r102.tauPow(r105);
    }

    public static ECPoint.AbstractF2m multiplyRTnaf(ECPoint.AbstractF2m r100, BigInteger r101) {
        ECCurve.AbstractF2m r102 = (ECCurve.AbstractF2m) r100.getCurve();
        int r103 = r102.getFieldSize();
        int r104 = r102.getA().toBigInteger().intValue();
        byte r105 = getMu(r104);
        byte r106 = (byte) r104;
        return multiplyTnaf(r100, partModReduction(r101, r103, r106, r102.getSi(), r105, (byte) 10));
    }

    public static ECPoint.AbstractF2m multiplyTnaf(ECPoint.AbstractF2m r100, ZTauElement r101) {
        return multiplyFromTnaf(r100, tauAdicNaf(getMu(((ECCurve.AbstractF2m) r100.getCurve()).getA()), r101));
    }

    public static BigInteger norm(byte r100, ZTauElement r101) {
        BigInteger r102 = r101.f525441u;
        BigInteger r103 = r102.multiply(r102);
        BigInteger r104 = r101.f525441u.multiply(r101.f525442v);
        BigInteger r105 = r101.f525442v;
        BigInteger r106 = r105.multiply(r105).shiftLeft(1);
        if (r100 != 1) goto L7;
        BigInteger r107 = r103.add(r104);
    L9:
        return r107.add(r106);
    L7:
        if (r100 != (-1)) goto L11;
        r107 = r103.subtract(r104);
        goto L9
    L11:
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static SimpleBigDecimal norm(byte r100, SimpleBigDecimal r101, SimpleBigDecimal r102) {
        SimpleBigDecimal r103 = r101.multiply(r101);
        SimpleBigDecimal r104 = r101.multiply(r102);
        SimpleBigDecimal r105 = r102.multiply(r102).shiftLeft(1);
        if (r100 != 1) goto L7;
        SimpleBigDecimal r106 = r103.add(r104);
    L9:
        return r106.add(r105);
    L7:
        if (r100 != (-1)) goto L11;
        r106 = r103.subtract(r104);
        goto L9
    L11:
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static ZTauElement partModReduction(BigInteger r110, int r111, byte r112, BigInteger[] r113, byte r114, byte r115) {
        if (r114 != 1) goto L5;
        BigInteger r100 = r113[0].add(r113[1]);
    L6:
        BigInteger r116 = getLucas(r114, r111, true)[1];
        ZTauElement r101 = round(approximateDivisionByN(r110, r113[0], r116, r112, r111, r115), approximateDivisionByN(r110, r113[1], r116, r112, r111, r115), r114);
        return new ZTauElement(r110.subtract(r100.multiply(r101.f525441u)).subtract(BigInteger.valueOf(2).multiply(r113[1]).multiply(r101.f525442v)), r113[1].multiply(r101.f525441u).subtract(r113[0].multiply(r101.f525442v)));
    L5:
        r100 = r113[0].subtract(r113[1]);
        goto L6
    }

    public static ZTauElement round(SimpleBigDecimal r100, SimpleBigDecimal r101, byte r110) {
        if (r101.getScale() != r100.getScale()) goto L39;
        int r102 = -1;
        int r103 = 1;
        if (r110 == 1) goto L10;
        if (r110 == (-1)) goto L10;
        throw new IllegalArgumentException("mu must be 1 or -1");
    L10:
        BigInteger r104 = r100.round();
        BigInteger r105 = r101.round();
        SimpleBigDecimal r106 = r100.subtract(r104);
        SimpleBigDecimal r107 = r101.subtract(r105);
        SimpleBigDecimal r108 = r106.add(r106);
        if (r110 != 1) goto L13;
        SimpleBigDecimal r109 = r108.add(r107);
    L14:
        SimpleBigDecimal r111 = r107.add(r107).add(r107);
        SimpleBigDecimal r112 = r111.add(r107);
        if (r110 != 1) goto L17;
        SimpleBigDecimal r113 = r106.subtract(r111);
        SimpleBigDecimal r114 = r106.add(r112);
    L18:
        BigInteger r115 = ECConstants.ONE;
        byte r116 = 0;
        if (r109.compareTo(r115) < 0) goto L24;
        if (r113.compareTo(MINUS_ONE) >= 0) goto L28;
    L25:
        r116 = r110;
    L26:
        r103 = 0;
    L28:
        if (r109.compareTo(MINUS_ONE) >= 0) goto L33;
        if (r113.compareTo(r115) < 0) goto L37;
    L34:
        r116 = (byte) (-r110);
    L35:
        r102 = r103;
    L37:
        return new ZTauElement(r104.add(BigInteger.valueOf(r102)), r105.add(BigInteger.valueOf(r116)));
    L33:
        if (r114.compareTo(MINUS_TWO) >= 0) goto L35;
    L24:
        if (r114.compareTo(ECConstants.TWO) < 0) goto L26;
    L17:
        r113 = r106.add(r111);
        r114 = r106.subtract(r112);
        goto L18
    L13:
        r109 = r108.subtract(r107);
        goto L14
    L39:
        throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
    }

    public static ECPoint.AbstractF2m tau(ECPoint.AbstractF2m r100) {
        return r100.tau();
    }

    public static byte[] tauAdicNaf(byte r100, ZTauElement r110) {
        if (r100 != 1) goto L5;
    L9:
        int r101 = norm(r100, r110).bitLength();
        if (r101 <= 30) goto L12;
        int r102 = r101 + 4;
    L13:
        byte[] r103 = new byte[r102];
        BigInteger r104 = r110.f525441u;
        BigInteger r111 = r110.f525442v;
        int r105 = 0;
        int r106 = 0;
    L14:
        BigInteger r107 = ECConstants.ZERO;
        if (r104.equals(r107) == false) goto L22;
        if (r111.equals(r107) == false) goto L22;
        int r108 = r105 + 1;
        byte[] r109 = new byte[r108];
        System.arraycopy(r103, 0, r109, 0, r108);
        return r109;
    L22:
        if (r104.testBit(0) == false) goto L28;
        byte r112 = (byte) ECConstants.TWO.subtract(r104.subtract(r111.shiftLeft(1)).mod(ECConstants.FOUR)).intValue();
        r103[r106] = r112;
        if (r112 != 1) goto L26;
        r104 = r104.clearBit(0);
    L27:
        r105 = r106;
    L29:
        BigInteger r113 = r104.shiftRight(1);
        if (r100 != 1) goto L32;
        BigInteger r114 = r111.add(r113);
    L33:
        BigInteger r115 = r104.shiftRight(1).negate();
        r106 = r106 + 1;
        r104 = r114;
        r111 = r115;
        goto L14
    L32:
        r114 = r111.subtract(r113);
        goto L33
    L26:
        r104 = r104.add(ECConstants.ONE);
        goto L27
    L28:
        r103[r106] = 0;
        goto L29
    L12:
        r102 = 34;
        goto L13
    L5:
        if (r100 == (-1)) goto L9;
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static byte[] tauAdicWNaf(byte r100, ZTauElement r101, byte r110, BigInteger r111, BigInteger r112, ZTauElement[] r113) {
        if (r100 != 1) goto L5;
    L9:
        int r102 = norm(r100, r101).bitLength();
        if (r102 <= 30) goto L12;
        int r103 = (r102 + 4) + r110;
    L13:
        byte[] r114 = new byte[r103];
        BigInteger r104 = r111.shiftRight(1);
        BigInteger r105 = r101.f525441u;
        BigInteger r106 = r101.f525442v;
        int r107 = 0;
    L14:
        BigInteger r108 = ECConstants.ZERO;
        if (r105.equals(r108) == false) goto L21;
        if (r106.equals(r108) == false) goto L21;
        return r114;
    L21:
        if (r105.testBit(0) == false) goto L32;
        BigInteger r109 = r105.add(r106.multiply(r112)).mod(r111);
        if (r109.compareTo(r104) < 0) goto L25;
        r109 = r109.subtract(r111);
    L25:
        byte r115 = (byte) r109.intValue();
        r114[r107] = r115;
        if (r115 >= 0) goto L28;
        r115 = (byte) (-r115);
        boolean r116 = false;
    L29:
        if (r116 == false) goto L31;
        r105 = r105.subtract(r113[r115].f525441u);
        r106 = r106.subtract(r113[r115].f525442v);
    L33:
        BigInteger r117 = r105.shiftRight(1);
        if (r100 != 1) goto L36;
        BigInteger r118 = r106.add(r117);
    L37:
        BigInteger r119 = r105.shiftRight(1).negate();
        r107 = r107 + 1;
        r105 = r118;
        r106 = r119;
        goto L14
    L36:
        r118 = r106.subtract(r117);
        goto L37
    L31:
        r105 = r105.add(r113[r115].f525441u);
        r106 = r106.add(r113[r115].f525442v);
        goto L33
    L28:
        r116 = true;
        goto L29
    L32:
        r114[r107] = 0;
        goto L33
    L12:
        r103 = r110 + 34;
        goto L13
    L5:
        if (r100 == (-1)) goto L9;
        throw new IllegalArgumentException("mu must be 1 or -1");
    }
}
