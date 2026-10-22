package org.bouncycastle.math.ec;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes42.dex */
public abstract class WNafUtil {
    private static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = null;
    private static final byte[] EMPTY_BYTES = null;
    private static final int[] EMPTY_INTS = null;
    private static final ECPoint[] EMPTY_POINTS = null;
    private static final int MAX_WIDTH = 16;
    public static final String PRECOMP_NAME = "bc_wnaf";

    static {
        DEFAULT_WINDOW_SIZE_CUTOFFS = new int[]{13, 41, 121, 337, 897, 2305};
        EMPTY_BYTES = new byte[0];
        EMPTY_INTS = new int[0];
        EMPTY_POINTS = new ECPoint[0];
    }

    public WNafUtil() {
    }

    public static /* synthetic */ ECPoint[] access$000() {
        return EMPTY_POINTS;
    }

    public static /* synthetic */ ECPoint[] access$100(ECPoint[] r100, int r101) {
        return resizeTable(r100, r101);
    }

    public static void configureBasepoint(ECPoint r100) {
        ECCurve r101 = r100.getCurve();
        if (r101 != null) goto L5;
        return;
    L5:
        BigInteger r102 = r101.getOrder();
        if (r102 != null) goto L8;
        int r103 = r101.getFieldSize() + 1;
    L9:
        final int r104 = Math.min(16, getWindowSize(r103) + 3);
        r101.precompute(r100, PRECOMP_NAME, new AnonymousClass1(r104));
        return;
    L8:
        r103 = r102.bitLength();
        goto L9
    }

    public static int[] generateCompactNaf(BigInteger r110) {
        if ((r110.bitLength() >>> 16) != 0) goto L24;
        if (r110.signum() == 0) goto L7;
        BigInteger r100 = r110.shiftLeft(1).add(r110);
        int r101 = r100.bitLength();
        int r102 = r101 >> 1;
        int[] r103 = new int[r102];
        BigInteger r104 = r100.xor(r110);
        int r105 = r101 - 1;
        int r106 = 0;
        int r107 = 0;
        int r108 = 1;
    L9:
        if (r108 >= r105) goto L19;
        if (r104.testBit(r108) == true) goto L14;
        r107 = r107 + 1;
    L18:
        r108 = r108 + 1;
        goto L9
    L14:
        if (r110.testBit(r108) == false) goto L16;
        int r109 = -1;
    L17:
        r103[r106] = r107 | (r109 << 16);
        r108 = r108 + 1;
        r106 = r106 + 1;
        r107 = 1;
        goto L18
    L16:
        r109 = 1;
        goto L17
    L19:
        int r111 = r106 + 1;
        r103[r106] = 65536 | r107;
        if (r102 > r111) goto L22;
        return r103;
    L22:
        return trim(r103, r111);
    L7:
        return EMPTY_INTS;
    L24:
        throw new IllegalArgumentException("'k' must have bitlength < 2^16");
    }

    public static int[] generateCompactWindowNaf(int r110, BigInteger r111) {
        if (r110 == 2) goto L5;
        if (r110 < 2) goto L39;
        if (r110 > 16) goto L39;
        if ((r111.bitLength() >>> 16) != 0) goto L37;
        if (r111.signum() == 0) goto L14;
        int r100 = (r111.bitLength() / r110) + 1;
        int[] r101 = new int[r100];
        int r102 = 1 << r110;
        int r103 = r102 - 1;
        int r104 = r102 >>> 1;
        int r105 = 0;
        int r106 = 0;
        boolean r112 = false;
    L17:
        if (r105 > r111.bitLength()) goto L33;
        if (r111.testBit(r105) == r112) goto L20;
        r111 = r111.shiftRight(r105);
        int r113 = r111.intValue() & r103;
        if (r112 == false) goto L25;
        r113 = r113 + 1;
    L25:
        if ((r113 & r104) == 0) goto L27;
        r112 = true;
    L28:
        if (r112 == false) goto L30;
        r113 = r113 - r102;
    L30:
        if (r106 <= 0) goto L32;
        r105 = r105 - 1;
    L32:
        r101[r106] = r105 | (r113 << 16);
        r105 = r110;
        r106 = r106 + 1;
        goto L17
    L27:
        r112 = false;
        goto L28
    L20:
        r105 = r105 + 1;
        goto L17
    L33:
        if (r100 > r106) goto L35;
        return r101;
    L35:
        return trim(r101, r106);
    L14:
        return EMPTY_INTS;
    L37:
        throw new IllegalArgumentException("'k' must have bitlength < 2^16");
    L39:
        throw new IllegalArgumentException("'width' must be in the range [2, 16]");
    L5:
        return generateCompactNaf(r111);
    }

    public static byte[] generateJSF(BigInteger r110, BigInteger r111) {
        int r100 = Math.max(r110.bitLength(), r111.bitLength()) + 1;
        byte[] r101 = new byte[r100];
        int r102 = 0;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if ((r102 | r103) == 0) goto L6;
    L13:
        int r106 = ((r110.intValue() >>> r104) + r102) & 7;
        int r107 = ((r111.intValue() >>> r104) + r103) & 7;
        int r108 = r106 & 1;
        if (r108 == 0) goto L20;
        r108 = r108 - (r106 & 2);
        if ((r106 + r108) != 4) goto L20;
        if ((r107 & 3) != 2) goto L20;
        r108 = -r108;
    L20:
        int r112 = r107 & 1;
        if (r112 == 0) goto L28;
        r112 = r112 - (r107 & 2);
        if ((r107 + r112) != 4) goto L28;
        if ((r106 & 3) != 2) goto L28;
        r112 = -r112;
    L28:
        if ((r102 << 1) != (r108 + 1)) goto L31;
        r102 = r102 ^ 1;
    L31:
        if ((r103 << 1) != (r112 + 1)) goto L33;
        r103 = r103 ^ 1;
    L33:
        r104 = r104 + 1;
        if (r104 != 30) goto L36;
        r110 = r110.shiftRight(30);
        r111 = r111.shiftRight(30);
        r104 = 0;
    L36:
        r101[r105] = (byte) ((r108 << 4) | (r112 & 15));
        r105 = r105 + 1;
        goto L4
    L6:
        if (r110.bitLength() > r104) goto L13;
        if (r111.bitLength() > r104) goto L13;
        if (r100 > r105) goto L12;
        return r101;
    L12:
        return trim(r101, r105);
    }

    public static byte[] generateNaf(BigInteger r100) {
        if (r100.signum() == 0) goto L5;
        BigInteger r101 = r100.shiftLeft(1).add(r100);
        int r102 = r101.bitLength() - 1;
        byte[] r103 = new byte[r102];
        BigInteger r104 = r101.xor(r100);
        int r105 = 1;
    L7:
        if (r105 >= r102) goto L16;
        if (r104.testBit(r105) == false) goto L15;
        int r106 = r105 - 1;
        if (r100.testBit(r105) == false) goto L13;
        int r107 = -1;
    L14:
        r103[r106] = (byte) r107;
        r105 = r105 + 1;
        goto L15
    L13:
        r107 = 1;
    L15:
        r105 = r105 + 1;
        goto L7
    L16:
        r103[r102 - 1] = 1;
        return r103;
    L5:
        return EMPTY_BYTES;
    }

    public static byte[] generateWindowNaf(int r110, BigInteger r111) {
        if (r110 == 2) goto L5;
        if (r110 < 2) goto L35;
        if (r110 > 8) goto L35;
        if (r111.signum() == 0) goto L12;
        int r100 = r111.bitLength() + 1;
        byte[] r101 = new byte[r100];
        int r102 = 1 << r110;
        int r103 = r102 - 1;
        int r104 = r102 >>> 1;
        int r105 = 0;
        int r106 = 0;
        boolean r107 = false;
    L15:
        if (r105 > r111.bitLength()) goto L31;
        if (r111.testBit(r105) == r107) goto L18;
        r111 = r111.shiftRight(r105);
        int r112 = r111.intValue() & r103;
        if (r107 == false) goto L23;
        r112 = r112 + 1;
    L23:
        if ((r112 & r104) == 0) goto L25;
        r107 = true;
    L26:
        if (r107 == false) goto L28;
        r112 = r112 - r102;
    L28:
        if (r106 <= 0) goto L30;
        r105 = r105 - 1;
    L30:
        int r108 = r106 + r105;
        r101[r108] = (byte) r112;
        r106 = r108 + 1;
        r105 = r110;
        goto L15
    L25:
        r107 = false;
        goto L26
    L18:
        r105 = r105 + 1;
        goto L15
    L31:
        if (r100 > r106) goto L33;
        return r101;
    L33:
        return trim(r101, r106);
    L12:
        return EMPTY_BYTES;
    L35:
        throw new IllegalArgumentException("'width' must be in the range [2, 8]");
    L5:
        return generateNaf(r111);
    }

    public static int getNafWeight(BigInteger r100) {
        if (r100.signum() != 0) goto L7;
        return 0;
    L7:
        return r100.shiftLeft(1).add(r100).xor(r100).bitCount();
    }

    public static WNafPreCompInfo getWNafPreCompInfo(ECPoint r100) {
        return getWNafPreCompInfo(r100.getCurve().getPreCompInfo(r100, PRECOMP_NAME));
    }

    public static WNafPreCompInfo getWNafPreCompInfo(PreCompInfo r100) {
        if ((r100 instanceof WNafPreCompInfo) == true) goto L7;
        return null;
    L7:
        return (WNafPreCompInfo) r100;
    }

    public static int getWindowSize(int r100) {
        return getWindowSize(r100, DEFAULT_WINDOW_SIZE_CUTOFFS, 16);
    }

    public static int getWindowSize(int r100, int r101) {
        return getWindowSize(r100, DEFAULT_WINDOW_SIZE_CUTOFFS, r101);
    }

    public static int getWindowSize(int r100, int[] r101) {
        return getWindowSize(r100, r101, 16);
    }

    public static int getWindowSize(int r100, int[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L10;
        if (r100 < r101[r103]) goto L10;
        r103 = r103 + 1;
    L10:
        return Math.max(2, Math.min(r102, r103 + 2));
    }

    public static WNafPreCompInfo precompute(final ECPoint r100, final int r101, final boolean r102) {
        final ECCurve r103 = r100.getCurve();
        return (WNafPreCompInfo) r103.precompute(r100, PRECOMP_NAME, new AnonymousClass2(r101, r102, r100, r103));
    }

    public static WNafPreCompInfo precomputeWithPointMap(ECPoint r100, final ECPointMap r101, final WNafPreCompInfo r102, final boolean r103) {
        return (WNafPreCompInfo) r100.getCurve().precompute(r100, PRECOMP_NAME, new AnonymousClass3(r102, r103, r101));
    }

    private static ECPoint[] resizeTable(ECPoint[] r100, int r101) {
        ECPoint[] r102 = new ECPoint[r101];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        return r102;
    }

    private static byte[] trim(byte[] r100, int r101) {
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }

    private static int[] trim(int[] r100, int r101) {
        int[] r102 = new int[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        return r102;
    }
}
