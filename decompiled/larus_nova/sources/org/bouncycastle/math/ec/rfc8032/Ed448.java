package org.bouncycastle.math.ec.rfc8032;

import com.ss.bduploader.BDVideoUploaderBase;
import java.security.SecureRandom;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Ed448 {
    private static final int[] B_x = null;
    private static final int[] B_y = null;
    private static final int C_d = -39081;
    private static final byte[] DOM4_PREFIX = null;
    private static final int[] L = null;
    private static final int L4_0 = 43969588;
    private static final int L4_1 = 30366549;
    private static final int L4_2 = 163752818;
    private static final int L4_3 = 258169998;
    private static final int L4_4 = 96434764;
    private static final int L4_5 = 227822194;
    private static final int L4_6 = 149865618;
    private static final int L4_7 = 550336261;
    private static final int L_0 = 78101261;
    private static final int L_1 = 141809365;
    private static final int L_2 = 175155932;
    private static final int L_3 = 64542499;
    private static final int L_4 = 158326419;
    private static final int L_5 = 191173276;
    private static final int L_6 = 104575268;
    private static final int L_7 = 137584065;
    private static final long M26L = 67108863;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = null;
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase;
    private static PointExt[] precompBaseTable;
    private static final Object precompLock = null;

    /* JADX INFO: renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;

        public Algorithm() {
        }
    }

    public static class F extends X448Field {
        private F() {
        }
    }

    public static class PointExt {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int[] f525493x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int[] f525494y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int[] f525495z;

        private PointExt() {
            this.f525493x = X448Field.create();
            this.f525494y = X448Field.create();
            this.f525495z = X448Field.create();
        }

        public /* synthetic */ PointExt(AnonymousClass1 r100) {
            this();
        }
    }

    public static class PointPrecomp {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int[] f525496x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int[] f525497y;

        private PointPrecomp() {
            this.f525496x = X448Field.create();
            this.f525497y = X448Field.create();
        }

        public /* synthetic */ PointPrecomp(AnonymousClass1 r100) {
            this();
        }
    }

    static {
        DOM4_PREFIX = new byte[]{83, 105, 103, 69, 100, 52, 52, 56};
        P = new int[]{-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
        L = new int[]{-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, 1073741823};
        B_x = new int[]{118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
        B_y = new int[]{36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
        precompLock = new Object();
        precompBaseTable = null;
        precompBase = null;
    }

    public Ed448() {
    }

    private static byte[] calculateS(byte[] r100, byte[] r101, byte[] r102) {
        int[] r103 = new int[28];
        int r104 = 0;
        decodeScalar(r100, 0, r103);
        int[] r105 = new int[14];
        decodeScalar(r101, 0, r105);
        int[] r106 = new int[14];
        decodeScalar(r102, 0, r106);
        Nat.mulAddTo(14, r105, r106, r103);
        byte[] r107 = new byte[114];
    L3:
        if (r104 >= 28) goto L6;
        encode32(r103[r104], r107, r104 * 4);
        r104 = r104 + 1;
        goto L3
    L6:
        return reduceScalar(r107);
    }

    private static boolean checkContextVar(byte[] r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length >= 256) goto L6;
        return true;
    }

    private static int checkPoint(int[] r100, int[] r101) {
        int[] r102 = X448Field.create();
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        X448Field.sqr(r100, r103);
        X448Field.sqr(r101, r104);
        X448Field.mul(r103, r104, r102);
        X448Field.add(r103, r104, r103);
        X448Field.mul(r102, 39081, r102);
        X448Field.subOne(r102);
        X448Field.add(r102, r103, r102);
        X448Field.normalize(r102);
        return X448Field.isZero(r102);
    }

    private static int checkPoint(int[] r100, int[] r101, int[] r102) {
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        int[] r105 = X448Field.create();
        int[] r106 = X448Field.create();
        X448Field.sqr(r100, r104);
        X448Field.sqr(r101, r105);
        X448Field.sqr(r102, r106);
        X448Field.mul(r104, r105, r103);
        X448Field.add(r104, r105, r104);
        X448Field.mul(r104, r106, r104);
        X448Field.sqr(r106, r106);
        X448Field.mul(r103, 39081, r103);
        X448Field.sub(r103, r106, r103);
        X448Field.add(r103, r104, r103);
        X448Field.normalize(r103);
        return X448Field.isZero(r103);
    }

    private static boolean checkPointVar(byte[] r100) {
        if ((r100[56] & ByteCompanionObject.MAX_VALUE) == 0) goto L5;
        return false;
    L5:
        int[] r101 = new int[14];
        decode32(r100, 0, r101, 0, 14);
        return !Nat.gte(14, r101, P);
    }

    private static boolean checkScalarVar(byte[] r100) {
        if (r100[56] == 0) goto L5;
        return false;
    L5:
        int[] r101 = new int[14];
        decodeScalar(r100, 0, r101);
        return !Nat.gte(14, r101, L);
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        return ((r100[r101 + 1] & UByte.MAX_VALUE) << 8) | r102;
    }

    private static int decode24(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        return ((r100[r103 + 1] & UByte.MAX_VALUE) << 16) | r104;
    }

    private static int decode32(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 16);
        return (r100[r105 + 1] << 24) | r106;
    }

    private static void decode32(byte[] r100, int r101, int[] r102, int r103, int r104) {
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r102[r103 + r105] = decode32(r100, (r105 * 4) + r101);
        r105 = r105 + 1;
        goto L3
    }

    private static boolean decodePointVar(byte[] r100, int r101, boolean r102, PointExt r103) {
        byte[] r104 = Arrays.copyOfRange(r100, r101, r101 + 57);
        boolean r105 = false;
        if (checkPointVar(r104) == true) goto L5;
        return false;
    L5:
        byte r106 = r104[56];
        int r107 = (r106 & ByteCompanionObject.MIN_VALUE) >>> 7;
        r104[56] = (byte) (r106 & ByteCompanionObject.MAX_VALUE);
        X448Field.decode(r104, 0, r103.f525494y);
        int[] r108 = X448Field.create();
        int[] r109 = X448Field.create();
        X448Field.sqr(r103.f525494y, r108);
        X448Field.mul(r108, 39081, r109);
        X448Field.negate(r108, r108);
        X448Field.addOne(r108);
        X448Field.addOne(r109);
        if (X448Field.sqrtRatioVar(r108, r109, r103.f525493x) == true) goto L8;
        return false;
    L8:
        X448Field.normalize(r103.f525493x);
        if (r107 == 1) goto L11;
    L13:
        int[] r110 = r103.f525493x;
        if (r107 == (r110[0] & 1)) goto L17;
        r105 = true;
    L17:
        if ((r102 ^ r105) == false) goto L19;
        X448Field.negate(r110, r110);
    L19:
        pointExtendXY(r103);
        return true;
    L11:
        if (X448Field.isZeroVar(r103.f525493x) == false) goto L13;
        return false;
    }

    private static void decodeScalar(byte[] r100, int r101, int[] r102) {
        decode32(r100, r101, r102, 0, 14);
    }

    private static void dom4(Xof r100, byte r101, byte[] r102) {
        byte[] r103 = DOM4_PREFIX;
        int r104 = r103.length;
        int r105 = r104 + 2;
        int r106 = r102.length + r105;
        byte[] r107 = new byte[r106];
        System.arraycopy(r103, 0, r107, 0, r104);
        r107[r104] = r101;
        r107[r104 + 1] = (byte) r102.length;
        System.arraycopy(r102, 0, r107, r105, r102.length);
        r100.update(r107, 0, r106);
    }

    private static void encode24(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        int r103 = r102 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        r101[r103 + 1] = (byte) (r100 >>> 16);
    }

    private static void encode32(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        int r103 = r102 + 1;
        r101[r103] = (byte) (r100 >>> 8);
        int r104 = r103 + 1;
        r101[r104] = (byte) (r100 >>> 16);
        r101[r104 + 1] = (byte) (r100 >>> 24);
    }

    private static void encode56(long r100, byte[] r101, int r102) {
        encode32((int) r100, r101, r102);
        encode24((int) (r100 >>> 32), r101, r102 + 4);
    }

    private static int encodePoint(PointExt r100, byte[] r101, int r102) {
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        X448Field.inv(r100.f525495z, r104);
        X448Field.mul(r100.f525493x, r104, r103);
        X448Field.mul(r100.f525494y, r104, r104);
        X448Field.normalize(r103);
        X448Field.normalize(r104);
        int r105 = checkPoint(r103, r104);
        X448Field.encode(r104, r101, r102);
        r101[(r102 + 57) - 1] = (byte) ((r103[0] & 1) << 7);
        return r105;
    }

    public static void generatePrivateKey(SecureRandom r100, byte[] r101) {
        r100.nextBytes(r101);
    }

    public static void generatePublicKey(byte[] r100, int r101, byte[] r102, int r103) {
        Xof r104 = createXof();
        byte[] r105 = new byte[114];
        r104.update(r100, r101, 57);
        r104.doFinal(r105, 0, 114);
        byte[] r106 = new byte[57];
        pruneScalar(r105, 0, r106);
        scalarMultBaseEncoded(r106, r102, r103);
    }

    private static int getWindow4(int[] r100, int r101) {
        int r102 = r101 >>> 3;
        int r103 = r100[r102];
        return (r103 >>> ((r101 & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] r110, int r111) {
        int[] r100 = new int[28];
        int r101 = 0;
        int r102 = 14;
        int r103 = 28;
        int r104 = 0;
    L3:
        r102 = r102 - 1;
        if (r102 < 0) goto L6;
        int r105 = r110[r102];
        int r106 = r103 - 1;
        r100[r106] = (r104 << 16) | (r105 >>> 16);
        r103 = r106 - 1;
        r100[r103] = r105;
        r104 = r105;
        goto L3
    L6:
        byte[] r112 = new byte[BDVideoUploaderBase.KeyIsDynamicSliceForceConfig];
        int r107 = 1 << r111;
        int r108 = r107 - 1;
        int r109 = r107 >>> 1;
        int r113 = 0;
        int r114 = 0;
    L7:
        if (r101 >= 28) goto L15;
        int r115 = r100[r101];
    L9:
        if (r113 >= 16) goto L14;
        int r116 = r115 >>> r113;
        if ((r116 & 1) == r114) goto L12;
        int r117 = (r116 & r108) + r114;
        int r118 = r117 & r109;
        int r119 = r117 - (r118 << 1);
        r114 = r118 >>> (r111 - 1);
        r112[(r101 << 4) + r113] = (byte) r119;
        r113 = r113 + r111;
        goto L9
    L12:
        r113 = r113 + 1;
        goto L9
    L14:
        r101 = r101 + 1;
        r113 = r113 - 16;
        goto L7
    L15:
        return r112;
    }

    private static void implSign(Xof r100, byte[] r101, byte[] r102, byte[] r103, int r104, byte[] r105, byte r110, byte[] r111, int r112, int r113, byte[] r114, int r115) {
        dom4(r100, r110, r105);
        r100.update(r101, 57, 57);
        r100.update(r111, r112, r113);
        r100.doFinal(r101, 0, r101.length);
        byte[] r106 = reduceScalar(r101);
        byte[] r107 = new byte[57];
        scalarMultBaseEncoded(r106, r107, 0);
        dom4(r100, r110, r105);
        r100.update(r107, 0, 57);
        r100.update(r103, r104, 57);
        r100.update(r111, r112, r113);
        r100.doFinal(r101, 0, r101.length);
        byte[] r108 = calculateS(r106, reduceScalar(r101), r102);
        System.arraycopy(r107, 0, r114, r115, 57);
        System.arraycopy(r108, 0, r114, r115 + 57, 57);
    }

    private static void implSign(byte[] r110, int r111, byte[] r112, byte r113, byte[] r114, int r115, int r116, byte[] r210, int r211) {
        if (checkContextVar(r112) == false) goto L7;
        Xof r100 = createXof();
        byte[] r101 = new byte[114];
        r100.update(r110, r111, 57);
        r100.doFinal(r101, 0, 114);
        byte[] r102 = new byte[57];
        pruneScalar(r101, 0, r102);
        byte[] r103 = new byte[57];
        scalarMultBaseEncoded(r102, r103, 0);
        implSign(r100, r101, r102, r103, 0, r112, r113, r114, r115, r116, r210, r211);
        return;
    L7:
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, byte r115, byte[] r116, int r210, int r211, byte[] r212, int r213) {
        if (checkContextVar(r114) == false) goto L7;
        Xof r100 = createXof();
        byte[] r101 = new byte[114];
        r100.update(r110, r111, 57);
        r100.doFinal(r101, 0, 114);
        byte[] r102 = new byte[57];
        pruneScalar(r101, 0, r102);
        implSign(r100, r101, r102, r112, r113, r114, r115, r116, r210, r211, r212, r213);
        return;
    L7:
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] r100, int r101, byte[] r102, int r110, byte[] r111, byte r112, byte[] r113, int r114, int r115) {
        if (checkContextVar(r111) == false) goto L20;
        int r103 = r101 + 57;
        byte[] r104 = Arrays.copyOfRange(r100, r101, r103);
        byte[] r105 = Arrays.copyOfRange(r100, r103, r101 + 114);
        if (checkPointVar(r104) == true) goto L8;
        return false;
    L8:
        if (checkScalarVar(r105) == true) goto L10;
        return false;
    L10:
        AnonymousClass1 r106 = null;
        PointExt r107 = new PointExt(r106);
        if (decodePointVar(r102, r110, true, r107) == true) goto L13;
        return false;
    L13:
        Xof r108 = createXof();
        byte[] r109 = new byte[114];
        dom4(r108, r112, r111);
        r108.update(r104, 0, 57);
        r108.update(r102, r110, 57);
        r108.update(r113, r114, r115);
        r108.doFinal(r109, 0, 114);
        byte[] r116 = reduceScalar(r109);
        int[] r117 = new int[14];
        decodeScalar(r105, 0, r117);
        int[] r118 = new int[14];
        decodeScalar(r116, 0, r118);
        PointExt r119 = new PointExt(r106);
        scalarMultStrausVar(r117, r118, r107, r119);
        byte[] r120 = new byte[57];
        if (encodePoint(r119, r120, 0) != 0) goto L16;
        return false;
    L16:
        if (Arrays.areEqual(r120, r104) == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        throw new IllegalArgumentException("ctx");
    }

    private static void pointAdd(PointExt r110, PointExt r111) {
        int[] r100 = X448Field.create();
        int[] r101 = X448Field.create();
        int[] r102 = X448Field.create();
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        int[] r105 = X448Field.create();
        int[] r106 = X448Field.create();
        int[] r107 = X448Field.create();
        X448Field.mul(r110.f525495z, r111.f525495z, r100);
        X448Field.sqr(r100, r101);
        X448Field.mul(r110.f525493x, r111.f525493x, r102);
        X448Field.mul(r110.f525494y, r111.f525494y, r103);
        X448Field.mul(r102, r103, r104);
        X448Field.mul(r104, 39081, r104);
        X448Field.add(r101, r104, r105);
        X448Field.sub(r101, r104, r106);
        X448Field.add(r110.f525493x, r110.f525494y, r101);
        X448Field.add(r111.f525493x, r111.f525494y, r104);
        X448Field.mul(r101, r104, r107);
        X448Field.add(r103, r102, r101);
        X448Field.sub(r103, r102, r104);
        X448Field.carry(r101);
        X448Field.sub(r107, r101, r107);
        X448Field.mul(r107, r100, r107);
        X448Field.mul(r104, r100, r104);
        X448Field.mul(r105, r107, r111.f525493x);
        X448Field.mul(r104, r106, r111.f525494y);
        X448Field.mul(r105, r106, r111.f525495z);
    }

    private static void pointAddPrecomp(PointPrecomp r100, PointExt r110) {
        int[] r101 = X448Field.create();
        int[] r102 = X448Field.create();
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        int[] r105 = X448Field.create();
        int[] r106 = X448Field.create();
        int[] r107 = X448Field.create();
        X448Field.sqr(r110.f525495z, r101);
        X448Field.mul(r100.f525496x, r110.f525493x, r102);
        X448Field.mul(r100.f525497y, r110.f525494y, r103);
        X448Field.mul(r102, r103, r104);
        X448Field.mul(r104, 39081, r104);
        X448Field.add(r101, r104, r105);
        X448Field.sub(r101, r104, r106);
        X448Field.add(r100.f525496x, r100.f525497y, r101);
        X448Field.add(r110.f525493x, r110.f525494y, r104);
        X448Field.mul(r101, r104, r107);
        X448Field.add(r103, r102, r101);
        X448Field.sub(r103, r102, r104);
        X448Field.carry(r101);
        X448Field.sub(r107, r101, r107);
        X448Field.mul(r107, r110.f525495z, r107);
        X448Field.mul(r104, r110.f525495z, r104);
        X448Field.mul(r105, r107, r110.f525493x);
        X448Field.mul(r104, r106, r110.f525494y);
        X448Field.mul(r105, r106, r110.f525495z);
    }

    private static void pointAddVar(boolean r110, PointExt r111, PointExt r112) {
        int[] r100 = X448Field.create();
        int[] r101 = X448Field.create();
        int[] r102 = X448Field.create();
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        int[] r105 = X448Field.create();
        int[] r106 = X448Field.create();
        int[] r107 = X448Field.create();
        if (r110 == false) goto L5;
        X448Field.sub(r111.f525494y, r111.f525493x, r107);
        int[] r113 = r101;
        int[] r108 = r104;
        int[] r109 = r105;
        int[] r114 = r106;
    L6:
        X448Field.mul(r111.f525495z, r112.f525495z, r100);
        X448Field.sqr(r100, r101);
        X448Field.mul(r111.f525493x, r112.f525493x, r102);
        X448Field.mul(r111.f525494y, r112.f525494y, r103);
        X448Field.mul(r102, r103, r104);
        X448Field.mul(r104, 39081, r104);
        X448Field.add(r101, r104, r114);
        X448Field.sub(r101, r104, r109);
        X448Field.add(r112.f525493x, r112.f525494y, r104);
        X448Field.mul(r107, r104, r107);
        X448Field.add(r103, r102, r108);
        X448Field.sub(r103, r102, r113);
        X448Field.carry(r108);
        X448Field.sub(r107, r101, r107);
        X448Field.mul(r107, r100, r107);
        X448Field.mul(r104, r100, r104);
        X448Field.mul(r105, r107, r112.f525493x);
        X448Field.mul(r104, r106, r112.f525494y);
        X448Field.mul(r105, r106, r112.f525495z);
        return;
    L5:
        X448Field.add(r111.f525494y, r111.f525493x, r107);
        r108 = r101;
        r113 = r104;
        r114 = r105;
        r109 = r106;
        goto L6
    }

    private static PointExt pointCopy(PointExt r100) {
        PointExt r101 = new PointExt(null);
        pointCopy(r100, r101);
        return r101;
    }

    private static void pointCopy(PointExt r100, PointExt r101) {
        X448Field.copy(r100.f525493x, 0, r101.f525493x, 0);
        X448Field.copy(r100.f525494y, 0, r101.f525494y, 0);
        X448Field.copy(r100.f525495z, 0, r101.f525495z, 0);
    }

    private static void pointDouble(PointExt r100) {
        int[] r101 = X448Field.create();
        int[] r102 = X448Field.create();
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        int[] r105 = X448Field.create();
        int[] r106 = X448Field.create();
        X448Field.add(r100.f525493x, r100.f525494y, r101);
        X448Field.sqr(r101, r101);
        X448Field.sqr(r100.f525493x, r102);
        X448Field.sqr(r100.f525494y, r103);
        X448Field.add(r102, r103, r104);
        X448Field.carry(r104);
        X448Field.sqr(r100.f525495z, r105);
        X448Field.add(r105, r105, r105);
        X448Field.carry(r105);
        X448Field.sub(r104, r105, r106);
        X448Field.sub(r101, r104, r101);
        X448Field.sub(r102, r103, r102);
        X448Field.mul(r101, r106, r100.f525493x);
        X448Field.mul(r104, r102, r100.f525494y);
        X448Field.mul(r104, r106, r100.f525495z);
    }

    private static void pointExtendXY(PointExt r100) {
        X448Field.one(r100.f525495z);
    }

    private static void pointLookup(int r100, int r101, PointPrecomp r102) {
        int r103 = ((r100 * 16) * 2) * 16;
        int r104 = 0;
    L3:
        if (r104 >= 16) goto L5;
        int r105 = ((r104 ^ r101) - 1) >> 31;
        X448Field.cmov(r105, precompBase, r103, r102.f525496x, 0);
        int r106 = r103 + 16;
        X448Field.cmov(r105, precompBase, r106, r102.f525497y, 0);
        r103 = r106 + 16;
        r104 = r104 + 1;
        goto L3
    }

    private static void pointLookup(int[] r100, int r101, int[] r102, PointExt r103) {
        int r104 = getWindow4(r100, r101);
        int r105 = (r104 >>> 3) ^ 1;
        int r106 = (r104 ^ (-r105)) & 7;
        int r107 = 0;
        int r108 = 0;
    L4:
        if (r107 >= 8) goto L6;
        int r109 = ((r107 ^ r106) - 1) >> 31;
        X448Field.cmov(r109, r102, r108, r103.f525493x, 0);
        int r110 = r108 + 16;
        X448Field.cmov(r109, r102, r110, r103.f525494y, 0);
        int r111 = r110 + 16;
        X448Field.cmov(r109, r102, r111, r103.f525495z, 0);
        r108 = r111 + 16;
        r107 = r107 + 1;
        goto L4
    L6:
        X448Field.cnegate(r105, r103.f525493x);
    }

    private static int[] pointPrecompute(PointExt r100, int r101) {
        PointExt r102 = pointCopy(r100);
        PointExt r103 = pointCopy(r102);
        pointDouble(r103);
        int[] r104 = X448Field.createTable(r101 * 3);
        int r105 = 0;
        int r106 = 0;
    L3:
        X448Field.copy(r102.f525493x, 0, r104, r105);
        int r107 = r105 + 16;
        X448Field.copy(r102.f525494y, 0, r104, r107);
        int r108 = r107 + 16;
        X448Field.copy(r102.f525495z, 0, r104, r108);
        r105 = r108 + 16;
        r106 = r106 + 1;
        if (r106 == r101) goto L5;
        pointAdd(r103, r102);
        goto L3
    L5:
        return r104;
    }

    private static PointExt[] pointPrecomputeVar(PointExt r100, int r101) {
        PointExt r102 = pointCopy(r100);
        pointDouble(r102);
        PointExt[] r103 = new PointExt[r101];
        r103[0] = pointCopy(r100);
        int r104 = 1;
    L3:
        if (r104 >= r101) goto L5;
        PointExt r105 = pointCopy(r103[r104 - 1]);
        r103[r104] = r105;
        pointAddVar(false, r102, r105);
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    private static void pointSetNeutral(PointExt r100) {
        X448Field.zero(r100.f525493x);
        X448Field.one(r100.f525494y);
        X448Field.one(r100.f525495z);
    }

    public static void precompute() {
        Object r100 = precompLock;
        monitor-enter(r100);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (precompBase == null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L40
        return;
    L8:
        AnonymousClass1 r101 = null;
        PointExt r102 = new PointExt(r101);     // Catch: Throwable -> L40
        X448Field.copy(B_x, 0, r102.f525493x, 0);     // Catch: Throwable -> L40
        X448Field.copy(B_y, 0, r102.f525494y, 0);     // Catch: Throwable -> L40
        pointExtendXY(r102);     // Catch: Throwable -> L40
        precompBaseTable = pointPrecomputeVar(r102, 32);     // Catch: Throwable -> L40
        precompBase = X448Field.createTable(160);     // Catch: Throwable -> L40
        int r103 = 0;
        int r104 = 0;
    L10:
        if (r103 >= 5) goto L38;
        PointExt[] r105 = new PointExt[5];     // Catch: Throwable -> L40
        PointExt r106 = new PointExt(r101);     // Catch: Throwable -> L40
        pointSetNeutral(r106);     // Catch: Throwable -> L40
        int r107 = 0;
    L12:
        int r110 = 1;
        if (r107 >= 5) goto L20;
        pointAddVar(true, r102, r106);     // Catch: Throwable -> L40
        pointDouble(r102);     // Catch: Throwable -> L40
        r105[r107] = pointCopy(r102);     // Catch: Throwable -> L40
        if ((r103 + r107) == 8) goto L19;
    L17:
        if (r110 >= 18) goto L19;
        pointDouble(r102);     // Catch: Throwable -> L40
        r110 = r110 + 1;     // Catch: Throwable -> L40
    L19:
        r107 = r107 + 1;     // Catch: Throwable -> L40
        goto L12
    L20:
        PointExt[] r108 = new PointExt[16];     // Catch: Throwable -> L40
        r108[0] = r106;     // Catch: Throwable -> L40
        int r109 = 0;
        int r111 = 1;
    L22:
        if (r109 >= 4) goto L27;
        int r112 = 1 << r109;     // Catch: Throwable -> L40
        int r113 = 0;
    L24:
        if (r113 >= r112) goto L26;
        PointExt r114 = pointCopy(r108[r111 - r112]);     // Catch: Throwable -> L40
        r108[r111] = r114;     // Catch: Throwable -> L40
        pointAddVar(false, r105[r109], r114);     // Catch: Throwable -> L40
        r113 = r113 + 1;     // Catch: Throwable -> L40
        r111 = r111 + 1;     // Catch: Throwable -> L40
        goto L24
    L26:
        r109 = r109 + 1;     // Catch: Throwable -> L40
        goto L22
    L27:
        int[] r115 = X448Field.createTable(16);     // Catch: Throwable -> L40
        int[] r116 = X448Field.create();     // Catch: Throwable -> L40
        X448Field.copy(r108[0].f525495z, 0, r116, 0);     // Catch: Throwable -> L40
        X448Field.copy(r116, 0, r115, 0);     // Catch: Throwable -> L40
        int r117 = 0;
    L28:
        r117 = r117 + 1;     // Catch: Throwable -> L40
        if (r117 >= 16) goto L31;
        X448Field.mul(r116, r108[r117].f525495z, r116);     // Catch: Throwable -> L40
        X448Field.copy(r116, 0, r115, r117 * 16);     // Catch: Throwable -> L40
        goto L28
    L31:
        X448Field.invVar(r116, r116);     // Catch: Throwable -> L40
        int r118 = r117 - 1;     // Catch: Throwable -> L40
        int[] r119 = X448Field.create();     // Catch: Throwable -> L40
    L32:
        if (r118 <= 0) goto L34;
        int r120 = r118 - 1;     // Catch: Throwable -> L40
        X448Field.copy(r115, r120 * 16, r119, 0);     // Catch: Throwable -> L40
        X448Field.mul(r119, r116, r119);     // Catch: Throwable -> L40
        X448Field.copy(r119, 0, r115, r118 * 16);     // Catch: Throwable -> L40
        X448Field.mul(r116, r108[r118].f525495z, r116);     // Catch: Throwable -> L40
        r118 = r120;
        goto L32
    L34:
        X448Field.copy(r116, 0, r115, 0);     // Catch: Throwable -> L40
        int r121 = 0;
    L35:
        if (r121 >= 16) goto L37;
        PointExt r122 = r108[r121];     // Catch: Throwable -> L40
        X448Field.copy(r115, r121 * 16, r122.f525495z, 0);     // Catch: Throwable -> L40
        int[] r123 = r122.f525493x;     // Catch: Throwable -> L40
        X448Field.mul(r123, r122.f525495z, r123);     // Catch: Throwable -> L40
        int[] r124 = r122.f525494y;     // Catch: Throwable -> L40
        X448Field.mul(r124, r122.f525495z, r124);     // Catch: Throwable -> L40
        X448Field.copy(r122.f525493x, 0, precompBase, r104);     // Catch: Throwable -> L40
        int r125 = r104 + 16;     // Catch: Throwable -> L40
        X448Field.copy(r122.f525494y, 0, precompBase, r125);     // Catch: Throwable -> L40
        r104 = r125 + 16;     // Catch: Throwable -> L40
        r121 = r121 + 1;     // Catch: Throwable -> L40
        goto L35
    L37:
        r103 = r103 + 1;     // Catch: Throwable -> L40
        goto L10
    L38:
        monitor-exit(r100);     // Catch: Throwable -> L40
    }

    private static void pruneScalar(byte[] r100, int r101, byte[] r102) {
        System.arraycopy(r100, r101, r102, 0, 56);
        r102[0] = (byte) (r102[0] & 252);
        r102[55] = (byte) (r102[55] | ByteCompanionObject.MIN_VALUE);
        r102[56] = 0;
    }

    private static byte[] reduceScalar(byte[] r810) {
        long r100 = ((long) decode32(r810, 0)) & 4294967295L;
        long r101 = ((long) (decode24(r810, 4) << 4)) & 4294967295L;
        long r110 = ((long) decode32(r810, 7)) & 4294967295L;
        long r111 = ((long) (decode24(r810, 11) << 4)) & 4294967295L;
        long r112 = ((long) decode32(r810, 14)) & 4294967295L;
        long r102 = ((long) (decode24(r810, 18) << 4)) & 4294967295L;
        long r103 = ((long) decode32(r810, 21)) & 4294967295L;
        long r104 = ((long) (decode24(r810, 25) << 4)) & 4294967295L;
        long r113 = ((long) decode32(r810, 28)) & 4294967295L;
        long r114 = ((long) (decode24(r810, 32) << 4)) & 4294967295L;
        long r115 = ((long) decode32(r810, 35)) & 4294967295L;
        long r105 = ((long) (decode24(r810, 39) << 4)) & 4294967295L;
        long r106 = ((long) decode32(r810, 42)) & 4294967295L;
        long r107 = ((long) (decode24(r810, 46) << 4)) & 4294967295L;
        long r116 = ((long) decode32(r810, 49)) & 4294967295L;
        long r117 = ((long) (decode24(r810, 53) << 4)) & 4294967295L;
        long r118 = ((long) decode32(r810, 56)) & 4294967295L;
        long r108 = ((long) (decode24(r810, 60) << 4)) & 4294967295L;
        long r109 = ((long) decode32(r810, 63)) & 4294967295L;
        long r119 = ((long) (decode24(r810, 67) << 4)) & 4294967295L;
        long r120 = ((long) decode32(r810, 70)) & 4294967295L;
        long r121 = ((long) (decode24(r810, 74) << 4)) & 4294967295L;
        long r122 = ((long) decode32(r810, 77)) & 4294967295L;
        long r123 = ((long) (decode24(r810, 81) << 4)) & 4294967295L;
        long r124 = ((long) decode32(r810, 84)) & 4294967295L;
        long r125 = ((long) (decode24(r810, 88) << 4)) & 4294967295L;
        long r126 = ((long) decode32(r810, 91)) & 4294967295L;
        long r127 = ((long) (decode24(r810, 95) << 4)) & 4294967295L;
        long r128 = ((long) decode32(r810, 98)) & 4294967295L;
        long r129 = ((long) (decode24(r810, 102) << 4)) & 4294967295L;
        long r130 = ((long) decode32(r810, 105)) & 4294967295L;
        long r131 = ((long) (decode24(r810, 109) << 4)) & 4294967295L;
        long r132 = ((long) decode16(r810, 112)) & 4294967295L;
        long r133 = r118 + (r132 * 43969588);
        long r134 = r108 + (r132 * 30366549);
        long r135 = r109 + (r132 * 163752818);
        long r136 = r119 + (r132 * 258169998);
        long r137 = r120 + (r132 * 96434764);
        long r510 = r121 + (r132 * 227822194);
        long r511 = r122 + (r132 * 149865618);
        long r512 = r131 + (r130 >>> 28);
        long r610 = r130 & M28L;
        long r410 = r117 + (r512 * 43969588);
        long r138 = r133 + (r512 * 30366549);
        long r139 = r134 + (r512 * 163752818);
        long r140 = r135 + (r512 * 258169998);
        long r141 = r136 + (r512 * 96434764);
        long r142 = r137 + (r512 * 227822194);
        long r513 = r510 + (r512 * 149865618);
        long r514 = r511 + (r512 * 550336261);
        long r411 = r116 + (r610 * 43969588);
        long r412 = r410 + (r610 * 30366549);
        long r143 = r138 + (r610 * 163752818);
        long r144 = r139 + (r610 * 258169998);
        long r145 = r140 + (r610 * 96434764);
        long r146 = r141 + (r610 * 227822194);
        long r147 = r142 + (r610 * 149865618);
        long r515 = r129 + (r128 >>> 28);
        long r611 = r128 & M28L;
        long r413 = r107 + (r515 * 43969588);
        long r414 = r411 + (r515 * 30366549);
        long r415 = r412 + (r515 * 163752818);
        long r148 = r143 + (r515 * 258169998);
        long r149 = r144 + (r515 * 96434764);
        long r150 = r145 + (r515 * 227822194);
        long r151 = r146 + (r515 * 149865618);
        long r152 = r147 + (r515 * 550336261);
        long r416 = r106 + (r611 * 43969588);
        long r417 = r413 + (r611 * 30366549);
        long r418 = r414 + (r611 * 163752818);
        long r419 = r415 + (r611 * 258169998);
        long r153 = r148 + (r611 * 96434764);
        long r154 = r149 + (r611 * 227822194);
        long r155 = r150 + (r611 * 149865618);
        long r516 = r127 + (r126 >>> 28);
        long r612 = r126 & M28L;
        long r420 = r105 + (r516 * 43969588);
        long r421 = r416 + (r516 * 30366549);
        long r422 = r417 + (r516 * 163752818);
        long r423 = r418 + (r516 * 258169998);
        long r424 = r419 + (r516 * 96434764);
        long r156 = r153 + (r516 * 227822194);
        long r157 = r154 + (r516 * 149865618);
        long r158 = r155 + (r516 * 550336261);
        long r310 = r115 + (r612 * 43969588);
        long r425 = r420 + (r612 * 30366549);
        long r426 = r421 + (r612 * 163752818);
        long r427 = r422 + (r612 * 258169998);
        long r428 = r423 + (r612 * 96434764);
        long r429 = r424 + (r612 * 227822194);
        long r159 = r156 + (r612 * 149865618);
        long r160 = r157 + (r612 * 550336261);
        long r517 = r125 + (r124 >>> 28);
        long r518 = r124 & M28L;
        long r311 = r114 + (r517 * 43969588);
        long r312 = r310 + (r517 * 30366549);
        long r430 = r425 + (r517 * 163752818);
        long r431 = r426 + (r517 * 258169998);
        long r432 = r427 + (r517 * 96434764);
        long r433 = r428 + (r517 * 227822194);
        long r434 = r429 + (r517 * 149865618);
        long r161 = r159 + (r517 * 550336261);
        long r519 = (r513 + (r610 * 550336261)) + (r152 >>> 28);
        long r162 = r152 & M28L;
        long r520 = r514 + (r519 >>> 28);
        long r521 = r519 & M28L;
        long r163 = (r123 + (r132 * 550336261)) + (r520 >>> 28);
        long r522 = r520 & M28L;
        long r523 = r518 + (r163 >>> 28);
        long r164 = r163 & M28L;
        long r313 = r113 + (r523 * 43969588);
        long r314 = r311 + (r523 * 30366549);
        long r315 = r312 + (r523 * 163752818);
        long r435 = r430 + (r523 * 258169998);
        long r436 = r431 + (r523 * 96434764);
        long r437 = r432 + (r523 * 227822194);
        long r438 = r433 + (r523 * 149865618);
        long r316 = r104 + (r164 * 43969588);
        long r317 = r313 + (r164 * 30366549);
        long r318 = r314 + (r164 * 163752818);
        long r319 = r315 + (r164 * 258169998);
        long r439 = r435 + (r164 * 96434764);
        long r440 = r436 + (r164 * 227822194);
        long r441 = r437 + (r164 * 149865618);
        long r442 = r438 + (r164 * 550336261);
        long r165 = r103 + (r522 * 43969588);
        long r320 = r316 + (r522 * 30366549);
        long r321 = r317 + (r522 * 163752818);
        long r322 = r318 + (r522 * 258169998);
        long r323 = r319 + (r522 * 96434764);
        long r443 = r439 + (r522 * 227822194);
        long r444 = r440 + (r522 * 149865618);
        long r166 = r158 + (r160 >>> 28);
        long r167 = r160 & M28L;
        long r168 = (r151 + (r611 * 550336261)) + (r166 >>> 28);
        long r169 = r166 & M28L;
        long r170 = r162 + (r168 >>> 28);
        long r171 = r168 & M28L;
        long r524 = r521 + (r170 >>> 28);
        long r172 = r170 & M28L;
        long r210 = r102 + (r524 * 43969588);
        long r173 = r165 + (r524 * 30366549);
        long r324 = r320 + (r524 * 163752818);
        long r325 = r321 + (r524 * 258169998);
        long r326 = r322 + (r524 * 96434764);
        long r327 = r323 + (r524 * 227822194);
        long r445 = r443 + (r524 * 149865618);
        long r211 = r112 + (r172 * 43969588);
        long r212 = r210 + (r172 * 30366549);
        long r174 = r173 + (r172 * 163752818);
        long r328 = r324 + (r172 * 258169998);
        long r329 = r325 + (r172 * 96434764);
        long r330 = r326 + (r172 * 227822194);
        long r331 = r327 + (r172 * 149865618);
        long r446 = r445 + (r172 * 550336261);
        long r175 = r111 + (r171 * 43969588);
        long r213 = r211 + (r171 * 30366549);
        long r214 = r212 + (r171 * 163752818);
        long r176 = r174 + (r171 * 258169998);
        long r332 = r328 + (r171 * 96434764);
        long r333 = r329 + (r171 * 227822194);
        long r334 = r330 + (r171 * 149865618);
        long r335 = r331 + (r171 * 550336261);
        long r447 = (r434 + (r523 * 550336261)) + (r442 >>> 28);
        long r177 = r442 & M28L;
        long r178 = r161 + (r447 >>> 28);
        long r215 = r447 & M28L;
        long r179 = r167 + (r178 >>> 28);
        long r180 = r178 & M28L;
        long r181 = r169 + (r179 >>> 28);
        long r182 = r179 & M28L;
        long r216 = r110 + (r181 * 43969588);
        long r183 = r175 + (r181 * 30366549);
        long r217 = r213 + (r181 * 163752818);
        long r218 = r214 + (r181 * 258169998);
        long r184 = r176 + (r181 * 96434764);
        long r336 = r332 + (r181 * 227822194);
        long r337 = r333 + (r181 * 149865618);
        long r338 = r334 + (r181 * 550336261);
        long r185 = r101 + (43969588 * r182);
        long r219 = r216 + (30366549 * r182);
        long r186 = r183 + (163752818 * r182);
        long r220 = r217 + (258169998 * r182);
        long r221 = r218 + (96434764 * r182);
        long r187 = r184 + (227822194 * r182);
        long r339 = r336 + (149865618 * r182);
        long r188 = r215 & M26L;
        long r189 = ((r180 * 4) + (r215 >>> 26)) + 1;
        long r190 = r100 + (78101261 * r189);
        long r191 = r185 + (141809365 * r189);
        long r222 = r219 + (175155932 * r189);
        long r192 = r186 + (64542499 * r189);
        long r223 = r220 + (158326419 * r189);
        long r224 = r221 + (191173276 * r189);
        long r193 = r187 + (104575268 * r189);
        long r340 = r339 + (r189 * 137584065);
        long r194 = r191 + (r190 >>> 28);
        long r195 = r190 & M28L;
        long r225 = r222 + (r194 >>> 28);
        long r196 = r194 & M28L;
        long r197 = r192 + (r225 >>> 28);
        long r198 = r225 & M28L;
        long r226 = r223 + (r197 >>> 28);
        long r199 = r197 & M28L;
        long r227 = r224 + (r226 >>> 28);
        long r228 = r226 & M28L;
        long r200 = r193 + (r227 >>> 28);
        long r229 = r227 & M28L;
        long r341 = r340 + (r200 >>> 28);
        long r201 = r200 & M28L;
        long r342 = (r337 + (r182 * 550336261)) + (r341 >>> 28);
        long r230 = r341 & M28L;
        long r343 = r338 + (r342 >>> 28);
        long r231 = r342 & M28L;
        long r344 = r335 + (r343 >>> 28);
        long r345 = r343 & M28L;
        long r448 = r446 + (r344 >>> 28);
        long r346 = r344 & M28L;
        long r449 = (r444 + (r524 * 550336261)) + (r448 >>> 28);
        long r347 = r448 & M28L;
        long r450 = (r441 + (r522 * 550336261)) + (r449 >>> 28);
        long r348 = r449 & M28L;
        long r202 = r177 + (r450 >>> 28);
        long r349 = r450 & M28L;
        long r1100 = r188 + (r202 >>> 28);
        long r203 = r202 & M28L;
        long r204 = r1100 & M26L;
        long r451 = (r1100 >>> 26) - 1;
        long r1101 = r195 - (r451 & 78101261);
        long r205 = r196 - (r451 & 141809365);
        long r1102 = r198 - (r451 & 175155932);
        long r206 = r199 - (r451 & 64542499);
        long r232 = r228 - (r451 & 158326419);
        long r233 = r229 - (r451 & 191173276);
        long r207 = r201 - (r451 & 104575268);
        long r234 = r230 - (r451 & 137584065);
        long r208 = r205 + (r1101 >> 28);
        long r1103 = r1101 & M28L;
        long r1104 = r1102 + (r208 >> 28);
        long r209 = r208 & M28L;
        long r235 = r206 + (r1104 >> 28);
        long r1105 = r1104 & M28L;
        long r236 = r232 + (r235 >> 28);
        long r237 = r235 & M28L;
        long r238 = r233 + (r236 >> 28);
        long r1106 = r236 & M28L;
        long r239 = r207 + (r238 >> 28);
        long r1107 = r238 & M28L;
        long r240 = r234 + (r239 >> 28);
        long r241 = r239 & M28L;
        long r242 = r231 + (r240 >> 28);
        long r243 = r240 & M28L;
        long r350 = r345 + (r242 >> 28);
        long r244 = r242 & M28L;
        long r351 = r346 + (r350 >> 28);
        long r245 = r350 & M28L;
        long r352 = r347 + (r351 >> 28);
        long r246 = r351 & M28L;
        long r353 = r348 + (r352 >> 28);
        long r247 = r352 & M28L;
        long r354 = r349 + (r353 >> 28);
        long r355 = r353 & M28L;
        long r248 = r203 + (r354 >> 28);
        long r356 = r354 & M28L;
        long r249 = r204 + (r248 >> 28);
        long r250 = r248 & M28L;
        byte[] r1108 = new byte[57];
        encode56((r209 << 28) | r1103, r1108, 0);
        encode56((r237 << 28) | r1105, r1108, 7);
        encode56(r1106 | (r1107 << 28), r1108, 14);
        encode56(r241 | (r243 << 28), r1108, 21);
        encode56(r244 | (r245 << 28), r1108, 28);
        encode56(r246 | (r247 << 28), r1108, 35);
        encode56(r355 | (r356 << 28), r1108, 42);
        encode56((r249 << 28) | r250, r1108, 49);
        return r1108;
    }

    private static void scalarMult(byte[] r100, PointExt r101, PointExt r102) {
        int[] r103 = new int[14];
        int r104 = 0;
        decodeScalar(r100, 0, r103);
        Nat.shiftDownBits(14, r103, 2, 0);
        Nat.cadd(14, (~r103[0]) & 1, r103, L, r103);
        Nat.shiftDownBit(14, r103, 1);
        int[] r105 = pointPrecompute(r101, 8);
        PointExt r106 = new PointExt(null);
        pointLookup(r103, 111, r105, r102);
        int r107 = 110;
    L3:
        if (r107 < 0) goto L9;
        int r108 = 0;
    L6:
        if (r108 >= 4) goto L8;
        pointDouble(r102);
        r108 = r108 + 1;
        goto L6
    L8:
        pointLookup(r103, r107, r105, r106);
        pointAdd(r106, r102);
        r107 = r107 - 1;
    L9:
        if (r104 >= 2) goto L11;
        pointDouble(r102);
        r104 = r104 + 1;
        goto L9
    }

    private static void scalarMultBase(byte[] r110, PointExt r111) {
        precompute();
        int[] r100 = new int[15];
        decodeScalar(r110, 0, r100);
        r100[14] = Nat.cadd(14, (~r100[0]) & 1, r100, L, r100) + 4;
        Nat.shiftDownBit(15, r100, 0);
        PointPrecomp r112 = new PointPrecomp(null);
        pointSetNeutral(r111);
        int r101 = 17;
    L3:
        int r102 = r101;
        int r103 = 0;
    L5:
        if (r103 >= 5) goto L10;
        int r104 = 0;
        int r105 = 0;
    L7:
        if (r104 >= 5) goto L9;
        r105 = (r105 & (~(1 << r104))) ^ ((r100[r102 >>> 5] >>> (r102 & 31)) << r104);
        r102 = r102 + 18;
        r104 = r104 + 1;
        goto L7
    L9:
        int r106 = (r105 >>> 4) & 1;
        pointLookup(r103, ((-r106) ^ r105) & 15, r112);
        X448Field.cnegate(r106, r112.f525496x);
        pointAddPrecomp(r112, r111);
        r103 = r103 + 1;
        goto L5
    L10:
        r101 = r101 - 1;
        if (r101 < 0) goto L12;
        pointDouble(r111);
        goto L3
    }

    private static void scalarMultBaseEncoded(byte[] r100, byte[] r101, int r102) {
        PointExt r103 = new PointExt(null);
        scalarMultBase(r100, r103);
        if (encodePoint(r103, r101, r102) == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    public static void scalarMultBaseXY(X448.Friend r100, byte[] r101, int r102, int[] r103, int[] r104) {
        if (r100 == null) goto L10;
        byte[] r105 = new byte[57];
        pruneScalar(r101, r102, r105);
        PointExt r106 = new PointExt(null);
        scalarMultBase(r105, r106);
        if (checkPoint(r106.f525493x, r106.f525494y, r106.f525495z) == 0) goto L8;
        X448Field.copy(r106.f525493x, 0, r103, 0);
        X448Field.copy(r106.f525494y, 0, r104, 0);
        return;
    L8:
        throw new IllegalStateException();
    L10:
        throw new NullPointerException("This method is only for use by X448");
    }

    private static void scalarMultStrausVar(int[] r100, int[] r101, PointExt r102, PointExt r103) {
        precompute();
        byte[] r104 = getWnafVar(r100, 7);
        byte[] r105 = getWnafVar(r101, 5);
        PointExt[] r106 = pointPrecomputeVar(r102, 8);
        pointSetNeutral(r103);
        int r107 = BDVideoUploaderBase.KeyIsSkipCode2ndFileSize;
    L3:
        byte r108 = r104[r107];
        boolean r109 = false;
        if (r108 == 0) goto L10;
        int r110 = r108 >> 31;
        int r111 = (r108 ^ r110) >>> 1;
        if (r110 == 0) goto L8;
        boolean r112 = true;
    L9:
        pointAddVar(r112, precompBaseTable[r111], r103);
        goto L10
    L8:
        r112 = false;
    L10:
        byte r113 = r105[r107];
        if (r113 == 0) goto L16;
        int r114 = r113 >> 31;
        int r115 = (r113 ^ r114) >>> 1;
        if (r114 == 0) goto L15;
        r109 = true;
    L15:
        pointAddVar(r109, r106[r115], r103);
    L16:
        r107 = r107 - 1;
        if (r107 < 0) goto L18;
        pointDouble(r103);
        goto L3
    }

    public static void sign(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, byte[] r115, int r116, int r117, byte[] r118, int r210) {
        implSign(r110, r111, r112, r113, r114, (byte) 0, r115, r116, r117, r118, r210);
    }

    public static void sign(byte[] r100, int r110, byte[] r111, byte[] r112, int r113, int r114, byte[] r115, int r116) {
        implSign(r100, r110, r111, (byte) 0, r112, r113, r114, r115, r116);
    }

    public static void signPrehash(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, Xof r115, byte[] r116, int r117) {
        byte[] r100 = new byte[64];
        if (64 != r115.doFinal(r100, 0, 64)) goto L7;
        implSign(r110, r111, r112, r113, r114, (byte) 1, r100, 0, 64, r116, r117);
        return;
    L7:
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, byte[] r115, int r116, byte[] r117, int r118) {
        implSign(r110, r111, r112, r113, r114, (byte) 1, r115, r116, 64, r117, r118);
    }

    public static void signPrehash(byte[] r110, int r111, byte[] r112, Xof r113, byte[] r114, int r115) {
        byte[] r100 = new byte[64];
        if (64 != r113.doFinal(r100, 0, 64)) goto L7;
        implSign(r110, r111, r112, (byte) 1, r100, 0, 64, r114, r115);
        return;
    L7:
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] r100, int r110, byte[] r111, byte[] r112, int r113, byte[] r114, int r115) {
        implSign(r100, r110, r111, (byte) 1, r112, r113, 64, r114, r115);
    }

    public static boolean verify(byte[] r100, int r110, byte[] r111, int r112, byte[] r113, byte[] r114, int r115, int r116) {
        return implVerify(r100, r110, r111, r112, r113, (byte) 0, r114, r115, r116);
    }

    public static boolean verifyPrehash(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, Xof r115) {
        byte[] r100 = new byte[64];
        if (64 != r115.doFinal(r100, 0, 64)) goto L7;
        return implVerify(r110, r111, r112, r113, r114, (byte) 1, r100, 0, 64);
    L7:
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] r100, int r110, byte[] r111, int r112, byte[] r113, byte[] r114, int r115) {
        return implVerify(r100, r110, r111, r112, r113, (byte) 1, r114, r115, 64);
    }
}
