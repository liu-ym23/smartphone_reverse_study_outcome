package org.bouncycastle.math.ec.rfc8032;

import java.security.SecureRandom;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.math.ec.rfc7748.X25519;
import org.bouncycastle.math.ec.rfc7748.X25519Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public abstract class Ed25519 {
    private static final int[] B_x = null;
    private static final int[] B_y = null;
    private static final int[] C_d = null;
    private static final int[] C_d2 = null;
    private static final int[] C_d4 = null;
    private static final byte[] DOM2_PREFIX = null;
    private static final int[] L = null;
    private static final int L0 = -50998291;
    private static final int L1 = 19280294;
    private static final int L2 = 127719000;
    private static final int L3 = -6428113;
    private static final int L4 = 5343;
    private static final long M08L = 255;
    private static final long M28L = 268435455;
    private static final long M32L = 4294967295L;
    private static final int[] P = null;
    private static final int POINT_BYTES = 32;
    private static final int PRECOMP_BLOCKS = 8;
    private static final int PRECOMP_MASK = 7;
    private static final int PRECOMP_POINTS = 8;
    private static final int PRECOMP_SPACING = 8;
    private static final int PRECOMP_TEETH = 4;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 32;
    private static final int SCALAR_BYTES = 32;
    private static final int SCALAR_INTS = 8;
    public static final int SECRET_KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private static final int WNAF_WIDTH_BASE = 7;
    private static int[] precompBase;
    private static PointExt[] precompBaseTable;
    private static final Object precompLock = null;

    /* JADX INFO: renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Algorithm {
        public static final int Ed25519 = 0;
        public static final int Ed25519ctx = 1;
        public static final int Ed25519ph = 2;

        public Algorithm() {
        }
    }

    public static class F extends X25519Field {
        private F() {
        }
    }

    public static class PointAccum {

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        int[] f525482u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        int[] f525483v;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int[] f525484x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int[] f525485y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int[] f525486z;

        private PointAccum() {
            this.f525484x = X25519Field.create();
            this.f525485y = X25519Field.create();
            this.f525486z = X25519Field.create();
            this.f525482u = X25519Field.create();
            this.f525483v = X25519Field.create();
        }

        public /* synthetic */ PointAccum(AnonymousClass1 r100) {
            this();
        }
    }

    public static class PointAffine {

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int[] f525487x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int[] f525488y;

        private PointAffine() {
            this.f525487x = X25519Field.create();
            this.f525488y = X25519Field.create();
        }

        public /* synthetic */ PointAffine(AnonymousClass1 r100) {
            this();
        }
    }

    public static class PointExt {

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        int[] f525489t;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        int[] f525490x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        int[] f525491y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        int[] f525492z;

        private PointExt() {
            this.f525490x = X25519Field.create();
            this.f525491y = X25519Field.create();
            this.f525492z = X25519Field.create();
            this.f525489t = X25519Field.create();
        }

        public /* synthetic */ PointExt(AnonymousClass1 r100) {
            this();
        }
    }

    public static class PointPrecomp {
        int[] xyd;
        int[] ymx_h;
        int[] ypx_h;

        private PointPrecomp() {
            this.ypx_h = X25519Field.create();
            this.ymx_h = X25519Field.create();
            this.xyd = X25519Field.create();
        }

        public /* synthetic */ PointPrecomp(AnonymousClass1 r100) {
            this();
        }
    }

    static {
        DOM2_PREFIX = new byte[]{83, 105, 103, 69, 100, 50, 53, 53, 49, 57, 32, 110, 111, 32, 69, 100, 50, 53, 53, 49, 57, 32, 99, 111, 108, 108, 105, 115, 105, 111, 110, 115};
        P = new int[]{-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
        L = new int[]{1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};
        B_x = new int[]{52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};
        B_y = new int[]{40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};
        C_d = new int[]{56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};
        C_d2 = new int[]{45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};
        C_d4 = new int[]{23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
        precompLock = new Object();
        precompBaseTable = null;
        precompBase = null;
    }

    public Ed25519() {
    }

    private static byte[] calculateS(byte[] r100, byte[] r101, byte[] r102) {
        int[] r103 = new int[16];
        int r104 = 0;
        decodeScalar(r100, 0, r103);
        int[] r105 = new int[8];
        decodeScalar(r101, 0, r105);
        int[] r106 = new int[8];
        decodeScalar(r102, 0, r106);
        Nat256.mulAddTo(r105, r106, r103);
        byte[] r107 = new byte[64];
    L3:
        if (r104 >= 16) goto L6;
        encode32(r103[r104], r107, r104 * 4);
        r104 = r104 + 1;
        goto L3
    L6:
        return reduceScalar(r107);
    }

    private static boolean checkContextVar(byte[] r100, byte r101) {
        if (r100 != null) goto L4;
        if (r101 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.length >= 256) goto L8;
        goto L7
    }

    private static int checkPoint(int[] r100, int[] r101) {
        int[] r102 = X25519Field.create();
        int[] r103 = X25519Field.create();
        int[] r104 = X25519Field.create();
        X25519Field.sqr(r100, r103);
        X25519Field.sqr(r101, r104);
        X25519Field.mul(r103, r104, r102);
        X25519Field.sub(r104, r103, r104);
        X25519Field.mul(r102, C_d, r102);
        X25519Field.addOne(r102);
        X25519Field.sub(r102, r104, r102);
        X25519Field.normalize(r102);
        return X25519Field.isZero(r102);
    }

    private static int checkPoint(int[] r100, int[] r101, int[] r102) {
        int[] r103 = X25519Field.create();
        int[] r104 = X25519Field.create();
        int[] r105 = X25519Field.create();
        int[] r106 = X25519Field.create();
        X25519Field.sqr(r100, r104);
        X25519Field.sqr(r101, r105);
        X25519Field.sqr(r102, r106);
        X25519Field.mul(r104, r105, r103);
        X25519Field.sub(r105, r104, r105);
        X25519Field.mul(r105, r106, r105);
        X25519Field.sqr(r106, r106);
        X25519Field.mul(r103, C_d, r103);
        X25519Field.add(r103, r106, r103);
        X25519Field.sub(r103, r105, r103);
        X25519Field.normalize(r103);
        return X25519Field.isZero(r103);
    }

    private static boolean checkPointVar(byte[] r100) {
        int[] r101 = new int[8];
        decode32(r100, 0, r101, 0, 8);
        r101[7] = r101[7] & Integer.MAX_VALUE;
        return !Nat256.gte(r101, P);
    }

    private static boolean checkScalarVar(byte[] r100) {
        int[] r101 = new int[8];
        decodeScalar(r100, 0, r101);
        return !Nat256.gte(r101, L);
    }

    private static Digest createDigest() {
        return new SHA512Digest();
    }

    public static Digest createPrehash() {
        return createDigest();
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

    private static boolean decodePointVar(byte[] r100, int r101, boolean r102, PointAffine r103) {
        byte[] r104 = Arrays.copyOfRange(r100, r101, r101 + 32);
        boolean r105 = false;
        if (checkPointVar(r104) == true) goto L5;
        return false;
    L5:
        byte r106 = r104[31];
        int r107 = (r106 & ByteCompanionObject.MIN_VALUE) >>> 7;
        r104[31] = (byte) (r106 & ByteCompanionObject.MAX_VALUE);
        X25519Field.decode(r104, 0, r103.f525488y);
        int[] r108 = X25519Field.create();
        int[] r109 = X25519Field.create();
        X25519Field.sqr(r103.f525488y, r108);
        X25519Field.mul(C_d, r108, r109);
        X25519Field.subOne(r108);
        X25519Field.addOne(r109);
        if (X25519Field.sqrtRatioVar(r108, r109, r103.f525487x) == true) goto L8;
        return false;
    L8:
        X25519Field.normalize(r103.f525487x);
        if (r107 == 1) goto L11;
    L13:
        int[] r110 = r103.f525487x;
        if (r107 == (r110[0] & 1)) goto L17;
        r105 = true;
    L17:
        if ((r102 ^ r105) == false) goto L19;
        X25519Field.negate(r110, r110);
    L19:
        return true;
    L11:
        if (X25519Field.isZeroVar(r103.f525487x) == false) goto L13;
        return false;
    }

    private static void decodeScalar(byte[] r100, int r101, int[] r102) {
        decode32(r100, r101, r102, 0, 8);
    }

    private static void dom2(Digest r100, byte r101, byte[] r102) {
        if (r102 == null) goto L5;
        byte[] r103 = DOM2_PREFIX;
        int r104 = r103.length;
        int r105 = r104 + 2;
        int r106 = r102.length + r105;
        byte[] r107 = new byte[r106];
        System.arraycopy(r103, 0, r107, 0, r104);
        r107[r104] = r101;
        r107[r104 + 1] = (byte) r102.length;
        System.arraycopy(r102, 0, r107, r105, r102.length);
        r100.update(r107, 0, r106);
        return;
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

    private static int encodePoint(PointAccum r100, byte[] r101, int r102) {
        int[] r103 = X25519Field.create();
        int[] r104 = X25519Field.create();
        X25519Field.inv(r100.f525486z, r104);
        X25519Field.mul(r100.f525484x, r104, r103);
        X25519Field.mul(r100.f525485y, r104, r104);
        X25519Field.normalize(r103);
        X25519Field.normalize(r104);
        int r105 = checkPoint(r103, r104);
        X25519Field.encode(r104, r101, r102);
        int r106 = (r102 + 32) - 1;
        r101[r106] = (byte) (((r103[0] & 1) << 7) | r101[r106]);
        return r105;
    }

    public static void generatePrivateKey(SecureRandom r100, byte[] r101) {
        r100.nextBytes(r101);
    }

    public static void generatePublicKey(byte[] r100, int r101, byte[] r102, int r103) {
        Digest r104 = createDigest();
        byte[] r105 = new byte[r104.getDigestSize()];
        r104.update(r100, r101, 32);
        r104.doFinal(r105, 0);
        byte[] r106 = new byte[32];
        pruneScalar(r105, 0, r106);
        scalarMultBaseEncoded(r106, r102, r103);
    }

    private static int getWindow4(int[] r100, int r101) {
        int r102 = r101 >>> 3;
        int r103 = r100[r102];
        return (r103 >>> ((r101 & 7) << 2)) & 15;
    }

    private static byte[] getWnafVar(int[] r110, int r111) {
        int[] r100 = new int[16];
        int r101 = 0;
        int r102 = 8;
        int r103 = 16;
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
        byte[] r112 = new byte[253];
        int r107 = 1 << r111;
        int r108 = r107 - 1;
        int r109 = r107 >>> 1;
        int r113 = 0;
        int r114 = 0;
    L7:
        if (r101 >= 16) goto L15;
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

    private static void implSign(Digest r100, byte[] r101, byte[] r102, byte[] r103, int r104, byte[] r105, byte r110, byte[] r111, int r112, int r113, byte[] r114, int r115) {
        dom2(r100, r110, r105);
        r100.update(r101, 32, 32);
        r100.update(r111, r112, r113);
        r100.doFinal(r101, 0);
        byte[] r106 = reduceScalar(r101);
        byte[] r107 = new byte[32];
        scalarMultBaseEncoded(r106, r107, 0);
        dom2(r100, r110, r105);
        r100.update(r107, 0, 32);
        r100.update(r103, r104, 32);
        r100.update(r111, r112, r113);
        r100.doFinal(r101, 0);
        byte[] r108 = calculateS(r106, reduceScalar(r101), r102);
        System.arraycopy(r107, 0, r114, r115, 32);
        System.arraycopy(r108, 0, r114, r115 + 32, 32);
    }

    private static void implSign(byte[] r110, int r111, byte[] r112, byte r113, byte[] r114, int r115, int r116, byte[] r210, int r211) {
        if (checkContextVar(r112, r113) == false) goto L7;
        Digest r100 = createDigest();
        byte[] r101 = new byte[r100.getDigestSize()];
        r100.update(r110, r111, 32);
        r100.doFinal(r101, 0);
        byte[] r102 = new byte[32];
        pruneScalar(r101, 0, r102);
        byte[] r103 = new byte[32];
        scalarMultBaseEncoded(r102, r103, 0);
        implSign(r100, r101, r102, r103, 0, r112, r113, r114, r115, r116, r210, r211);
        return;
    L7:
        throw new IllegalArgumentException("ctx");
    }

    private static void implSign(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, byte r115, byte[] r116, int r210, int r211, byte[] r212, int r213) {
        if (checkContextVar(r114, r115) == false) goto L7;
        Digest r100 = createDigest();
        byte[] r101 = new byte[r100.getDigestSize()];
        r100.update(r110, r111, 32);
        r100.doFinal(r101, 0);
        byte[] r102 = new byte[32];
        pruneScalar(r101, 0, r102);
        implSign(r100, r101, r102, r112, r113, r114, r115, r116, r210, r211, r212, r213);
        return;
    L7:
        throw new IllegalArgumentException("ctx");
    }

    private static boolean implVerify(byte[] r100, int r101, byte[] r102, int r103, byte[] r110, byte r111, byte[] r112, int r113, int r114) {
        if (checkContextVar(r110, r111) == false) goto L20;
        int r104 = r101 + 32;
        byte[] r105 = Arrays.copyOfRange(r100, r101, r104);
        byte[] r106 = Arrays.copyOfRange(r100, r104, r101 + 64);
        if (checkPointVar(r105) == true) goto L8;
        return false;
    L8:
        if (checkScalarVar(r106) == true) goto L10;
        return false;
    L10:
        AnonymousClass1 r107 = null;
        PointAffine r108 = new PointAffine(r107);
        if (decodePointVar(r102, r103, true, r108) == true) goto L13;
        return false;
    L13:
        Digest r109 = createDigest();
        byte[] r115 = new byte[r109.getDigestSize()];
        dom2(r109, r111, r110);
        r109.update(r105, 0, 32);
        r109.update(r102, r103, 32);
        r109.update(r112, r113, r114);
        r109.doFinal(r115, 0);
        byte[] r116 = reduceScalar(r115);
        int[] r117 = new int[8];
        decodeScalar(r106, 0, r117);
        int[] r118 = new int[8];
        decodeScalar(r116, 0, r118);
        PointAccum r119 = new PointAccum(r107);
        scalarMultStrausVar(r117, r118, r108, r119);
        byte[] r120 = new byte[32];
        if (encodePoint(r119, r120, 0) != 0) goto L16;
        return false;
    L16:
        if (Arrays.areEqual(r120, r105) == false) goto L22;
        return true;
    L22:
        return false;
    L20:
        throw new IllegalArgumentException("ctx");
    }

    private static void pointAdd(PointExt r110, PointAccum r111) {
        int[] r100 = X25519Field.create();
        int[] r101 = X25519Field.create();
        int[] r102 = X25519Field.create();
        int[] r103 = X25519Field.create();
        int[] r104 = r111.f525482u;
        int[] r105 = X25519Field.create();
        int[] r106 = X25519Field.create();
        int[] r107 = r111.f525483v;
        X25519Field.apm(r111.f525485y, r111.f525484x, r101, r100);
        X25519Field.apm(r110.f525491y, r110.f525490x, r103, r102);
        X25519Field.mul(r100, r102, r100);
        X25519Field.mul(r101, r103, r101);
        X25519Field.mul(r111.f525482u, r111.f525483v, r102);
        X25519Field.mul(r102, r110.f525489t, r102);
        X25519Field.mul(r102, C_d2, r102);
        X25519Field.mul(r111.f525486z, r110.f525492z, r103);
        X25519Field.add(r103, r103, r103);
        X25519Field.apm(r101, r100, r107, r104);
        X25519Field.apm(r103, r102, r106, r105);
        X25519Field.carry(r106);
        X25519Field.mul(r104, r105, r111.f525484x);
        X25519Field.mul(r106, r107, r111.f525485y);
        X25519Field.mul(r105, r106, r111.f525486z);
    }

    private static void pointAdd(PointExt r110, PointExt r111) {
        int[] r100 = X25519Field.create();
        int[] r101 = X25519Field.create();
        int[] r102 = X25519Field.create();
        int[] r103 = X25519Field.create();
        int[] r104 = X25519Field.create();
        int[] r105 = X25519Field.create();
        int[] r106 = X25519Field.create();
        int[] r107 = X25519Field.create();
        X25519Field.apm(r110.f525491y, r110.f525490x, r101, r100);
        X25519Field.apm(r111.f525491y, r111.f525490x, r103, r102);
        X25519Field.mul(r100, r102, r100);
        X25519Field.mul(r101, r103, r101);
        X25519Field.mul(r110.f525489t, r111.f525489t, r102);
        X25519Field.mul(r102, C_d2, r102);
        X25519Field.mul(r110.f525492z, r111.f525492z, r103);
        X25519Field.add(r103, r103, r103);
        X25519Field.apm(r101, r100, r107, r104);
        X25519Field.apm(r103, r102, r106, r105);
        X25519Field.carry(r106);
        X25519Field.mul(r104, r105, r111.f525490x);
        X25519Field.mul(r106, r107, r111.f525491y);
        X25519Field.mul(r105, r106, r111.f525492z);
        X25519Field.mul(r104, r107, r111.f525489t);
    }

    private static void pointAddPrecomp(PointPrecomp r100, PointAccum r110) {
        int[] r101 = X25519Field.create();
        int[] r102 = X25519Field.create();
        int[] r103 = X25519Field.create();
        int[] r104 = r110.f525482u;
        int[] r105 = X25519Field.create();
        int[] r106 = X25519Field.create();
        int[] r107 = r110.f525483v;
        X25519Field.apm(r110.f525485y, r110.f525484x, r102, r101);
        X25519Field.mul(r101, r100.ymx_h, r101);
        X25519Field.mul(r102, r100.ypx_h, r102);
        X25519Field.mul(r110.f525482u, r110.f525483v, r103);
        X25519Field.mul(r103, r100.xyd, r103);
        X25519Field.apm(r102, r101, r107, r104);
        X25519Field.apm(r110.f525486z, r103, r106, r105);
        X25519Field.carry(r106);
        X25519Field.mul(r104, r105, r110.f525484x);
        X25519Field.mul(r106, r107, r110.f525485y);
        X25519Field.mul(r105, r106, r110.f525486z);
    }

    private static void pointAddVar(boolean r110, PointExt r111, PointAccum r112) {
        int[] r100 = X25519Field.create();
        int[] r101 = X25519Field.create();
        int[] r102 = X25519Field.create();
        int[] r103 = X25519Field.create();
        int[] r104 = r112.f525482u;
        int[] r105 = X25519Field.create();
        int[] r106 = X25519Field.create();
        int[] r107 = r112.f525483v;
        if (r110 == false) goto L5;
        int[] r113 = r102;
        int[] r108 = r103;
        int[] r109 = r105;
        int[] r114 = r106;
    L6:
        X25519Field.apm(r112.f525485y, r112.f525484x, r101, r100);
        X25519Field.apm(r111.f525491y, r111.f525490x, r113, r108);
        X25519Field.mul(r100, r102, r100);
        X25519Field.mul(r101, r103, r101);
        X25519Field.mul(r112.f525482u, r112.f525483v, r102);
        X25519Field.mul(r102, r111.f525489t, r102);
        X25519Field.mul(r102, C_d2, r102);
        X25519Field.mul(r112.f525486z, r111.f525492z, r103);
        X25519Field.add(r103, r103, r103);
        X25519Field.apm(r101, r100, r107, r104);
        X25519Field.apm(r103, r102, r109, r114);
        X25519Field.carry(r109);
        X25519Field.mul(r104, r105, r112.f525484x);
        X25519Field.mul(r106, r107, r112.f525485y);
        X25519Field.mul(r105, r106, r112.f525486z);
        return;
    L5:
        r108 = r102;
        r113 = r103;
        r114 = r105;
        r109 = r106;
        goto L6
    }

    private static void pointAddVar(boolean r110, PointExt r111, PointExt r112, PointExt r210) {
        int[] r100 = X25519Field.create();
        int[] r101 = X25519Field.create();
        int[] r102 = X25519Field.create();
        int[] r103 = X25519Field.create();
        int[] r104 = X25519Field.create();
        int[] r105 = X25519Field.create();
        int[] r106 = X25519Field.create();
        int[] r113 = X25519Field.create();
        if (r110 == false) goto L5;
        int[] r114 = r102;
        int[] r115 = r103;
        int[] r116 = r105;
        int[] r117 = r106;
    L6:
        X25519Field.apm(r111.f525491y, r111.f525490x, r101, r100);
        X25519Field.apm(r112.f525491y, r112.f525490x, r114, r115);
        X25519Field.mul(r100, r102, r100);
        X25519Field.mul(r101, r103, r101);
        X25519Field.mul(r111.f525489t, r112.f525489t, r102);
        X25519Field.mul(r102, C_d2, r102);
        X25519Field.mul(r111.f525492z, r112.f525492z, r103);
        X25519Field.add(r103, r103, r103);
        X25519Field.apm(r101, r100, r113, r104);
        X25519Field.apm(r103, r102, r116, r117);
        X25519Field.carry(r116);
        X25519Field.mul(r104, r105, r210.f525490x);
        X25519Field.mul(r106, r113, r210.f525491y);
        X25519Field.mul(r105, r106, r210.f525492z);
        X25519Field.mul(r104, r113, r210.f525489t);
        return;
    L5:
        r115 = r102;
        r114 = r103;
        r117 = r105;
        r116 = r106;
        goto L6
    }

    private static PointExt pointCopy(PointAccum r100) {
        PointExt r101 = new PointExt(null);
        X25519Field.copy(r100.f525484x, 0, r101.f525490x, 0);
        X25519Field.copy(r100.f525485y, 0, r101.f525491y, 0);
        X25519Field.copy(r100.f525486z, 0, r101.f525492z, 0);
        X25519Field.mul(r100.f525482u, r100.f525483v, r101.f525489t);
        return r101;
    }

    private static PointExt pointCopy(PointAffine r100) {
        PointExt r101 = new PointExt(null);
        X25519Field.copy(r100.f525487x, 0, r101.f525490x, 0);
        X25519Field.copy(r100.f525488y, 0, r101.f525491y, 0);
        pointExtendXY(r101);
        return r101;
    }

    private static PointExt pointCopy(PointExt r100) {
        PointExt r101 = new PointExt(null);
        pointCopy(r100, r101);
        return r101;
    }

    private static void pointCopy(PointAffine r100, PointAccum r101) {
        X25519Field.copy(r100.f525487x, 0, r101.f525484x, 0);
        X25519Field.copy(r100.f525488y, 0, r101.f525485y, 0);
        pointExtendXY(r101);
    }

    private static void pointCopy(PointExt r100, PointExt r101) {
        X25519Field.copy(r100.f525490x, 0, r101.f525490x, 0);
        X25519Field.copy(r100.f525491y, 0, r101.f525491y, 0);
        X25519Field.copy(r100.f525492z, 0, r101.f525492z, 0);
        X25519Field.copy(r100.f525489t, 0, r101.f525489t, 0);
    }

    private static void pointDouble(PointAccum r100) {
        int[] r101 = X25519Field.create();
        int[] r102 = X25519Field.create();
        int[] r103 = X25519Field.create();
        int[] r104 = r100.f525482u;
        int[] r105 = X25519Field.create();
        int[] r106 = X25519Field.create();
        int[] r107 = r100.f525483v;
        X25519Field.sqr(r100.f525484x, r101);
        X25519Field.sqr(r100.f525485y, r102);
        X25519Field.sqr(r100.f525486z, r103);
        X25519Field.add(r103, r103, r103);
        X25519Field.apm(r101, r102, r107, r106);
        X25519Field.add(r100.f525484x, r100.f525485y, r104);
        X25519Field.sqr(r104, r104);
        X25519Field.sub(r107, r104, r104);
        X25519Field.add(r103, r106, r105);
        X25519Field.carry(r105);
        X25519Field.mul(r104, r105, r100.f525484x);
        X25519Field.mul(r106, r107, r100.f525485y);
        X25519Field.mul(r105, r106, r100.f525486z);
    }

    private static void pointExtendXY(PointAccum r100) {
        X25519Field.one(r100.f525486z);
        X25519Field.copy(r100.f525484x, 0, r100.f525482u, 0);
        X25519Field.copy(r100.f525485y, 0, r100.f525483v, 0);
    }

    private static void pointExtendXY(PointExt r100) {
        X25519Field.one(r100.f525492z);
        X25519Field.mul(r100.f525490x, r100.f525491y, r100.f525489t);
    }

    private static void pointLookup(int r100, int r101, PointPrecomp r102) {
        int r103 = ((r100 * 8) * 3) * 10;
        int r104 = 0;
    L3:
        if (r104 >= 8) goto L5;
        int r105 = ((r104 ^ r101) - 1) >> 31;
        X25519Field.cmov(r105, precompBase, r103, r102.ypx_h, 0);
        int r106 = r103 + 10;
        X25519Field.cmov(r105, precompBase, r106, r102.ymx_h, 0);
        int r107 = r106 + 10;
        X25519Field.cmov(r105, precompBase, r107, r102.xyd, 0);
        r103 = r107 + 10;
        r104 = r104 + 1;
        goto L3
    }

    private static void pointLookup(int[] r100, int r101, PointExt r102) {
        int r103 = r101 * 40;
        X25519Field.copy(r100, r103, r102.f525490x, 0);
        int r104 = r103 + 10;
        X25519Field.copy(r100, r104, r102.f525491y, 0);
        int r105 = r104 + 10;
        X25519Field.copy(r100, r105, r102.f525492z, 0);
        X25519Field.copy(r100, r105 + 10, r102.f525489t, 0);
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
        X25519Field.cmov(r109, r102, r108, r103.f525490x, 0);
        int r110 = r108 + 10;
        X25519Field.cmov(r109, r102, r110, r103.f525491y, 0);
        int r111 = r110 + 10;
        X25519Field.cmov(r109, r102, r111, r103.f525492z, 0);
        int r112 = r111 + 10;
        X25519Field.cmov(r109, r102, r112, r103.f525489t, 0);
        r108 = r112 + 10;
        r107 = r107 + 1;
        goto L4
    L6:
        X25519Field.cnegate(r105, r103.f525490x);
        X25519Field.cnegate(r105, r103.f525489t);
    }

    private static int[] pointPrecompute(PointAffine r100, int r101) {
        PointExt r102 = pointCopy(r100);
        PointExt r103 = pointCopy(r102);
        pointAdd(r102, r103);
        int[] r104 = X25519Field.createTable(r101 * 4);
        int r105 = 0;
        int r106 = 0;
    L3:
        X25519Field.copy(r102.f525490x, 0, r104, r105);
        int r107 = r105 + 10;
        X25519Field.copy(r102.f525491y, 0, r104, r107);
        int r108 = r107 + 10;
        X25519Field.copy(r102.f525492z, 0, r104, r108);
        int r109 = r108 + 10;
        X25519Field.copy(r102.f525489t, 0, r104, r109);
        r105 = r109 + 10;
        r106 = r106 + 1;
        if (r106 == r101) goto L5;
        pointAdd(r103, r102);
        goto L3
    L5:
        return r104;
    }

    private static PointExt[] pointPrecomputeVar(PointExt r100, int r101) {
        AnonymousClass1 r102 = null;
        PointExt r103 = new PointExt(r102);
        pointAddVar(false, r100, r100, r103);
        PointExt[] r104 = new PointExt[r101];
        r104[0] = pointCopy(r100);
        int r105 = 1;
    L3:
        if (r105 >= r101) goto L5;
        PointExt r106 = r104[r105 - 1];
        PointExt r107 = new PointExt(r102);
        r104[r105] = r107;
        pointAddVar(false, r106, r103, r107);
        r105 = r105 + 1;
        goto L3
    L5:
        return r104;
    }

    private static void pointSetNeutral(PointAccum r100) {
        X25519Field.zero(r100.f525484x);
        X25519Field.one(r100.f525485y);
        X25519Field.one(r100.f525486z);
        X25519Field.zero(r100.f525482u);
        X25519Field.one(r100.f525483v);
    }

    private static void pointSetNeutral(PointExt r100) {
        X25519Field.zero(r100.f525490x);
        X25519Field.one(r100.f525491y);
        X25519Field.one(r100.f525492z);
        X25519Field.zero(r100.f525489t);
    }

    public static void precompute() {
        Object r100 = precompLock;
        monitor-enter(r100);
    L39:
        th = move-exception;
        throw th;
    L5:
        if (precompBase == null) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L39
        return;
    L8:
        AnonymousClass1 r101 = null;
        PointExt r102 = new PointExt(r101);     // Catch: Throwable -> L39
        int[] r103 = B_x;     // Catch: Throwable -> L39
        X25519Field.copy(r103, 0, r102.f525490x, 0);     // Catch: Throwable -> L39
        int[] r104 = B_y;     // Catch: Throwable -> L39
        X25519Field.copy(r104, 0, r102.f525491y, 0);     // Catch: Throwable -> L39
        pointExtendXY(r102);     // Catch: Throwable -> L39
        precompBaseTable = pointPrecomputeVar(r102, 32);     // Catch: Throwable -> L39
        PointAccum r105 = new PointAccum(r101);     // Catch: Throwable -> L39
        X25519Field.copy(r103, 0, r105.f525484x, 0);     // Catch: Throwable -> L39
        X25519Field.copy(r104, 0, r105.f525485y, 0);     // Catch: Throwable -> L39
        pointExtendXY(r105);     // Catch: Throwable -> L39
        precompBase = X25519Field.createTable(192);     // Catch: Throwable -> L39
        int r106 = 0;
        int r107 = 0;
    L10:
        if (r106 >= 8) goto L37;
        PointExt[] r108 = new PointExt[4];     // Catch: Throwable -> L39
        PointExt r109 = new PointExt(r101);     // Catch: Throwable -> L39
        pointSetNeutral(r109);     // Catch: Throwable -> L39
        int r110 = 0;
    L12:
        int r111 = 1;
        if (r110 >= 4) goto L19;
        pointAddVar(true, r109, pointCopy(r105), r109);     // Catch: Throwable -> L39
        pointDouble(r105);     // Catch: Throwable -> L39
        r108[r110] = pointCopy(r105);     // Catch: Throwable -> L39
        if ((r106 + r110) == 10) goto L18;
    L16:
        if (r111 >= 8) goto L18;
        pointDouble(r105);     // Catch: Throwable -> L39
        r111 = r111 + 1;     // Catch: Throwable -> L39
    L18:
        r110 = r110 + 1;     // Catch: Throwable -> L39
        goto L12
    L19:
        PointExt[] r112 = new PointExt[8];     // Catch: Throwable -> L39
        r112[0] = r109;     // Catch: Throwable -> L39
        int r113 = 0;
        int r114 = 1;
    L21:
        if (r113 >= 3) goto L26;
        int r115 = r111 << r113;     // Catch: Throwable -> L39
        int r116 = 0;
    L23:
        if (r116 >= r115) goto L25;
        PointExt r117 = r112[r114 - r115];     // Catch: Throwable -> L39
        PointExt r118 = r108[r113];     // Catch: Throwable -> L39
        PointExt r119 = new PointExt(r101);     // Catch: Throwable -> L39
        r112[r114] = r119;     // Catch: Throwable -> L39
        pointAddVar(false, r117, r118, r119);     // Catch: Throwable -> L39
        r116 = r116 + 1;     // Catch: Throwable -> L39
        r114 = r114 + 1;     // Catch: Throwable -> L39
        goto L23
    L25:
        r113 = r113 + 1;     // Catch: Throwable -> L39
        r111 = 1;
        goto L21
    L26:
        int[] r120 = X25519Field.createTable(8);     // Catch: Throwable -> L39
        int[] r121 = X25519Field.create();     // Catch: Throwable -> L39
        X25519Field.copy(r112[0].f525492z, 0, r121, 0);     // Catch: Throwable -> L39
        X25519Field.copy(r121, 0, r120, 0);     // Catch: Throwable -> L39
        int r122 = 0;
    L27:
        r122 = r122 + 1;     // Catch: Throwable -> L39
        if (r122 >= 8) goto L30;
        X25519Field.mul(r121, r112[r122].f525492z, r121);     // Catch: Throwable -> L39
        X25519Field.copy(r121, 0, r120, r122 * 10);     // Catch: Throwable -> L39
        goto L27
    L30:
        X25519Field.add(r121, r121, r121);     // Catch: Throwable -> L39
        X25519Field.invVar(r121, r121);     // Catch: Throwable -> L39
        int r123 = r122 - 1;     // Catch: Throwable -> L39
        int[] r124 = X25519Field.create();     // Catch: Throwable -> L39
    L31:
        if (r123 <= 0) goto L33;
        int r125 = r123 - 1;     // Catch: Throwable -> L39
        X25519Field.copy(r120, r125 * 10, r124, 0);     // Catch: Throwable -> L39
        X25519Field.mul(r124, r121, r124);     // Catch: Throwable -> L39
        X25519Field.copy(r124, 0, r120, r123 * 10);     // Catch: Throwable -> L39
        X25519Field.mul(r121, r112[r123].f525492z, r121);     // Catch: Throwable -> L39
        r123 = r125;
        goto L31
    L33:
        X25519Field.copy(r121, 0, r120, 0);     // Catch: Throwable -> L39
        int r126 = 0;
    L34:
        if (r126 >= 8) goto L36;
        PointExt r127 = r112[r126];     // Catch: Throwable -> L39
        int[] r128 = X25519Field.create();     // Catch: Throwable -> L39
        int[] r129 = X25519Field.create();     // Catch: Throwable -> L39
        X25519Field.copy(r120, r126 * 10, r129, 0);     // Catch: Throwable -> L39
        X25519Field.mul(r127.f525490x, r129, r128);     // Catch: Throwable -> L39
        X25519Field.mul(r127.f525491y, r129, r129);     // Catch: Throwable -> L39
        PointPrecomp r130 = new PointPrecomp(r101);     // Catch: Throwable -> L39
        X25519Field.apm(r129, r128, r130.ypx_h, r130.ymx_h);     // Catch: Throwable -> L39
        X25519Field.mul(r128, r129, r130.xyd);     // Catch: Throwable -> L39
        int[] r131 = r130.xyd;     // Catch: Throwable -> L39
        X25519Field.mul(r131, C_d4, r131);     // Catch: Throwable -> L39
        X25519Field.normalize(r130.ypx_h);     // Catch: Throwable -> L39
        X25519Field.normalize(r130.ymx_h);     // Catch: Throwable -> L39
        X25519Field.copy(r130.ypx_h, 0, precompBase, r107);     // Catch: Throwable -> L39
        int r132 = r107 + 10;     // Catch: Throwable -> L39
        X25519Field.copy(r130.ymx_h, 0, precompBase, r132);     // Catch: Throwable -> L39
        int r133 = r132 + 10;     // Catch: Throwable -> L39
        X25519Field.copy(r130.xyd, 0, precompBase, r133);     // Catch: Throwable -> L39
        r107 = r133 + 10;     // Catch: Throwable -> L39
        r126 = r126 + 1;     // Catch: Throwable -> L39
        goto L34
    L36:
        r106 = r106 + 1;     // Catch: Throwable -> L39
        goto L10
    L37:
        monitor-exit(r100);     // Catch: Throwable -> L39
    }

    private static void pruneScalar(byte[] r100, int r101, byte[] r102) {
        System.arraycopy(r100, r101, r102, 0, 32);
        r102[0] = (byte) (r102[0] & 248);
        byte r103 = (byte) (r102[31] & ByteCompanionObject.MAX_VALUE);
        r102[31] = r103;
        r102[31] = (byte) (r103 | 64);
    }

    private static byte[] reduceScalar(byte[] r510) {
        long r100 = ((long) decode32(r510, 0)) & 4294967295L;
        long r101 = ((long) (decode24(r510, 4) << 4)) & 4294967295L;
        long r110 = ((long) decode32(r510, 7)) & 4294967295L;
        long r111 = ((long) (decode24(r510, 11) << 4)) & 4294967295L;
        long r112 = ((long) decode32(r510, 14)) & 4294967295L;
        long r102 = ((long) (decode24(r510, 18) << 4)) & 4294967295L;
        long r103 = ((long) decode32(r510, 21)) & 4294967295L;
        long r104 = ((long) (decode24(r510, 25) << 4)) & 4294967295L;
        long r113 = ((long) decode32(r510, 28)) & 4294967295L;
        long r114 = ((long) (decode24(r510, 32) << 4)) & 4294967295L;
        long r115 = ((long) decode32(r510, 35)) & 4294967295L;
        long r105 = ((long) (decode24(r510, 39) << 4)) & 4294967295L;
        long r106 = ((long) decode32(r510, 42)) & 4294967295L;
        long r107 = ((long) (decode24(r510, 46) << 4)) & 4294967295L;
        long r116 = ((long) decode32(r510, 49)) & 4294967295L;
        long r117 = ((long) (decode24(r510, 53) << 4)) & 4294967295L;
        long r118 = ((long) decode32(r510, 56)) & 4294967295L;
        long r108 = ((long) (decode24(r510, 60) << 4)) & 4294967295L;
        long r119 = ((long) r510[63]) & 255;
        long r120 = r114 - (r119 * (-50998291));
        long r121 = r115 - (r119 * 19280294);
        long r109 = r105 - (r119 * 127719000);
        long r122 = r106 - (r119 * (-6428113));
        long r123 = r107 - (r119 * 5343);
        long r124 = r108 + (r118 >> 28);
        long r410 = r118 & M28L;
        long r310 = r113 - (r124 * (-50998291));
        long r125 = r120 - (r124 * 19280294);
        long r126 = r121 - (r124 * 127719000);
        long r127 = r109 - (r124 * (-6428113));
        long r128 = r122 - (r124 * 5343);
        long r129 = r104 - (r410 * (-50998291));
        long r311 = r310 - (r410 * 19280294);
        long r130 = r125 - (r410 * 127719000);
        long r131 = r126 - (r410 * (-6428113));
        long r132 = r127 - (r410 * 5343);
        long r312 = r117 + (r116 >> 28);
        long r313 = r116 & M28L;
        long r314 = r103 - (r312 * (-50998291));
        long r133 = r129 - (r312 * 19280294);
        long r315 = r311 - (r312 * 127719000);
        long r134 = r130 - (r312 * (-6428113));
        long r135 = r131 - (r312 * 5343);
        long r210 = r102 - (r313 * (-50998291));
        long r316 = r314 - (r313 * 19280294);
        long r136 = r133 - (r313 * 127719000);
        long r317 = r315 - (r313 * (-6428113));
        long r137 = r134 - (r313 * 5343);
        long r138 = r123 + (r128 >> 28);
        long r211 = r112 - (r138 * (-50998291));
        long r212 = r210 - (r138 * 19280294);
        long r318 = r316 - (r138 * 127719000);
        long r139 = r136 - (r138 * (-6428113));
        long r140 = (r128 & M28L) + (r132 >> 28);
        long r141 = r111 - (r140 * (-50998291));
        long r213 = r211 - (r140 * 19280294);
        long r214 = r212 - (r140 * 127719000);
        long r319 = r318 - (r140 * (-6428113));
        long r142 = r139 - (r140 * 5343);
        long r143 = (r132 & M28L) + (r135 >> 28);
        long r144 = r135 & M28L;
        long r145 = r110 - (r143 * (-50998291));
        long r146 = r141 - (r143 * 19280294);
        long r215 = r213 - (r143 * 127719000);
        long r216 = r214 - (r143 * (-6428113));
        long r320 = r319 - (r143 * 5343);
        long r147 = r144 + (r137 >> 28);
        long r148 = r137 & M28L;
        long r149 = r101 - (r147 * (-50998291));
        long r150 = r145 - (r147 * 19280294);
        long r151 = r146 - (r147 * 127719000);
        long r217 = r215 - (r147 * (-6428113));
        long r218 = r216 - (r147 * 5343);
        long r321 = (r317 - (r138 * 5343)) + (r142 >> 28);
        long r152 = r142 & M28L;
        long r153 = r148 + (r321 >> 28);
        long r154 = r321 & M28L;
        long r155 = r154 >>> 27;
        long r156 = r153 + r155;
        long r157 = r100 - (r156 * (-50998291));
        long r158 = r149 - (r156 * 19280294);
        long r159 = r150 - (r156 * 127719000);
        long r160 = r151 - (r156 * (-6428113));
        long r161 = r158 + (r157 >> 28);
        long r162 = r157 & M28L;
        long r163 = r159 + (r161 >> 28);
        long r164 = r161 & M28L;
        long r165 = r160 + (r163 >> 28);
        long r166 = r163 & M28L;
        long r219 = (r217 - (r156 * 5343)) + (r165 >> 28);
        long r167 = r165 & M28L;
        long r220 = r218 + (r219 >> 28);
        long r168 = r219 & M28L;
        long r322 = r320 + (r220 >> 28);
        long r221 = r220 & M28L;
        long r169 = r152 + (r322 >> 28);
        long r222 = r322 & M28L;
        long r170 = r154 + (r169 >> 28);
        long r171 = r169 & M28L;
        long r223 = r170 >> 28;
        long r172 = r170 & M28L;
        long r224 = r223 - r155;
        long r173 = r162 + (r224 & (-50998291));
        long r174 = r164 + (r224 & 19280294);
        long r175 = r166 + (r224 & 127719000);
        long r176 = r167 + (r224 & (-6428113));
        long r177 = r168 + (r224 & 5343);
        long r178 = r174 + (r173 >> 28);
        long r179 = r173 & M28L;
        long r180 = r175 + (r178 >> 28);
        long r181 = r178 & M28L;
        long r182 = r176 + (r180 >> 28);
        long r183 = r180 & M28L;
        long r184 = r177 + (r182 >> 28);
        long r185 = r182 & M28L;
        long r225 = r221 + (r184 >> 28);
        long r186 = r184 & M28L;
        long r226 = r222 + (r225 >> 28);
        long r187 = r225 & M28L;
        long r188 = r171 + (r226 >> 28);
        long r227 = r226 & M28L;
        long r189 = r172 + (r188 >> 28);
        long r190 = r188 & M28L;
        byte[] r191 = new byte[32];
        encode56(r179 | (r181 << 28), r191, 0);
        encode56((r185 << 28) | r183, r191, 7);
        encode56(r186 | (r187 << 28), r191, 14);
        encode56(r227 | (r190 << 28), r191, 21);
        encode32((int) r189, r191, 28);
        return r191;
    }

    private static void scalarMult(byte[] r100, PointAffine r101, PointAccum r102) {
        int[] r103 = new int[8];
        decodeScalar(r100, 0, r103);
        Nat.shiftDownBits(8, r103, 3, 1);
        Nat.cadd(8, (~r103[0]) & 1, r103, L, r103);
        Nat.shiftDownBit(8, r103, 0);
        int[] r104 = pointPrecompute(r101, 8);
        PointExt r105 = new PointExt(null);
        pointCopy(r101, r102);
        pointLookup(r104, 7, r105);
        pointAdd(r105, r102);
        int r106 = 62;
    L3:
        pointLookup(r103, r106, r104, r105);
        pointAdd(r105, r102);
        pointDouble(r102);
        pointDouble(r102);
        pointDouble(r102);
        r106 = r106 - 1;
        if (r106 < 0) goto L5;
        pointDouble(r102);
        goto L3
    }

    private static void scalarMultBase(byte[] r100, PointAccum r110) {
        precompute();
        int[] r101 = new int[8];
        decodeScalar(r100, 0, r101);
        Nat.cadd(8, (~r101[0]) & 1, r101, L, r101);
        Nat.shiftDownBit(8, r101, 1);
        int r102 = 0;
    L3:
        if (r102 >= 8) goto L5;
        r101[r102] = Interleave.shuffle2(r101[r102]);
        r102 = r102 + 1;
        goto L3
    L5:
        PointPrecomp r103 = new PointPrecomp(null);
        pointSetNeutral(r110);
        int r104 = 28;
    L6:
        int r105 = 0;
    L7:
        if (r105 >= 8) goto L9;
        int r106 = r101[r105] >>> r104;
        int r107 = (r106 >>> 3) & 1;
        pointLookup(r105, (r106 ^ (-r107)) & 7, r103);
        X25519Field.cswap(r107, r103.ypx_h, r103.ymx_h);
        X25519Field.cnegate(r107, r103.xyd);
        pointAddPrecomp(r103, r110);
        r105 = r105 + 1;
        goto L7
    L9:
        r104 = r104 - 4;
        if (r104 < 0) goto L11;
        pointDouble(r110);
        goto L6
    }

    private static void scalarMultBaseEncoded(byte[] r100, byte[] r101, int r102) {
        PointAccum r103 = new PointAccum(null);
        scalarMultBase(r100, r103);
        if (encodePoint(r103, r101, r102) == 0) goto L6;
        return;
    L6:
        throw new IllegalStateException();
    }

    public static void scalarMultBaseYZ(X25519.Friend r100, byte[] r101, int r102, int[] r103, int[] r104) {
        if (r100 == null) goto L10;
        byte[] r105 = new byte[32];
        pruneScalar(r101, r102, r105);
        PointAccum r106 = new PointAccum(null);
        scalarMultBase(r105, r106);
        if (checkPoint(r106.f525484x, r106.f525485y, r106.f525486z) == 0) goto L8;
        X25519Field.copy(r106.f525485y, 0, r103, 0);
        X25519Field.copy(r106.f525486z, 0, r104, 0);
        return;
    L8:
        throw new IllegalStateException();
    L10:
        throw new NullPointerException("This method is only for use by X25519");
    }

    private static void scalarMultStrausVar(int[] r100, int[] r101, PointAffine r102, PointAccum r103) {
        precompute();
        byte[] r104 = getWnafVar(r100, 7);
        byte[] r105 = getWnafVar(r101, 5);
        PointExt[] r106 = pointPrecomputeVar(pointCopy(r102), 8);
        pointSetNeutral(r103);
        int r107 = 252;
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

    public static void sign(byte[] r100, int r110, byte[] r111, int r112, int r113, byte[] r114, int r115) {
        implSign(r100, r110, null, (byte) 0, r111, r112, r113, r114, r115);
    }

    public static void sign(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, int r115, int r116, byte[] r117, int r118) {
        implSign(r110, r111, r112, r113, null, (byte) 0, r114, r115, r116, r117, r118);
    }

    public static void sign(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, byte[] r115, int r116, int r117, byte[] r118, int r210) {
        implSign(r110, r111, r112, r113, r114, (byte) 0, r115, r116, r117, r118, r210);
    }

    public static void sign(byte[] r100, int r110, byte[] r111, byte[] r112, int r113, int r114, byte[] r115, int r116) {
        implSign(r100, r110, r111, (byte) 0, r112, r113, r114, r115, r116);
    }

    public static void signPrehash(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, Digest r115, byte[] r116, int r117) {
        byte[] r100 = new byte[64];
        if (64 != r115.doFinal(r100, 0)) goto L7;
        implSign(r110, r111, r112, r113, r114, (byte) 1, r100, 0, 64, r116, r117);
        return;
    L7:
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, byte[] r115, int r116, byte[] r117, int r118) {
        implSign(r110, r111, r112, r113, r114, (byte) 1, r115, r116, 64, r117, r118);
    }

    public static void signPrehash(byte[] r110, int r111, byte[] r112, Digest r113, byte[] r114, int r115) {
        byte[] r100 = new byte[64];
        if (64 != r113.doFinal(r100, 0)) goto L7;
        implSign(r110, r111, r112, (byte) 1, r100, 0, 64, r114, r115);
        return;
    L7:
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] r100, int r110, byte[] r111, byte[] r112, int r113, byte[] r114, int r115) {
        implSign(r100, r110, r111, (byte) 1, r112, r113, 64, r114, r115);
    }

    public static boolean verify(byte[] r100, int r110, byte[] r111, int r112, byte[] r113, int r114, int r115) {
        return implVerify(r100, r110, r111, r112, null, (byte) 0, r113, r114, r115);
    }

    public static boolean verify(byte[] r100, int r110, byte[] r111, int r112, byte[] r113, byte[] r114, int r115, int r116) {
        return implVerify(r100, r110, r111, r112, r113, (byte) 0, r114, r115, r116);
    }

    public static boolean verifyPrehash(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, Digest r115) {
        byte[] r100 = new byte[64];
        if (64 != r115.doFinal(r100, 0)) goto L7;
        return implVerify(r110, r111, r112, r113, r114, (byte) 1, r100, 0, 64);
    L7:
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] r100, int r110, byte[] r111, int r112, byte[] r113, byte[] r114, int r115) {
        return implVerify(r100, r110, r111, r112, r113, (byte) 1, r114, r115, 64);
    }
}
