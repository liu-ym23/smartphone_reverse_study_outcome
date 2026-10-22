package org.bouncycastle.math.ec.rfc7748;

import com.ss.bduploader.BDVideoUploaderBase;
import java.security.SecureRandom;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public abstract class X448 {
    private static final int C_A = 156326;
    private static final int C_A24 = 39082;
    public static final int POINT_SIZE = 56;
    public static final int SCALAR_SIZE = 56;

    public static class F extends X448Field {
        private F() {
        }
    }

    public static class Friend {
        private static final Friend INSTANCE = null;

        static {
            INSTANCE = new Friend();
        }

        private Friend() {
        }

        public static /* synthetic */ Friend access$000() {
            return INSTANCE;
        }
    }

    public X448() {
    }

    public static boolean calculateAgreement(byte[] r100, int r101, byte[] r102, int r103, byte[] r104, int r105) {
        scalarMult(r100, r101, r102, r103, r104, r105);
        return !Arrays.areAllZeroes(r104, r105, 56);
    }

    private static int decode32(byte[] r100, int r101) {
        int r102 = r100[r101] & UByte.MAX_VALUE;
        int r103 = r101 + 1;
        int r104 = r102 | ((r100[r103] & UByte.MAX_VALUE) << 8);
        int r105 = r103 + 1;
        int r106 = r104 | ((r100[r105] & UByte.MAX_VALUE) << 16);
        return (r100[r105 + 1] << 24) | r106;
    }

    private static void decodeScalar(byte[] r100, int r101, int[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= 14) goto L6;
        r102[r103] = decode32(r100, (r103 * 4) + r101);
        r103 = r103 + 1;
        goto L4
    L6:
        r102[0] = r102[0] & (-4);
        r102[13] = r102[13] | Integer.MIN_VALUE;
    }

    public static void generatePrivateKey(SecureRandom r100, byte[] r101) {
        r100.nextBytes(r101);
        r101[0] = (byte) (r101[0] & 252);
        r101[55] = (byte) (r101[55] | ByteCompanionObject.MIN_VALUE);
    }

    public static void generatePublicKey(byte[] r100, int r101, byte[] r102, int r103) {
        scalarMultBase(r100, r101, r102, r103);
    }

    private static void pointDouble(int[] r100, int[] r101) {
        int[] r102 = X448Field.create();
        int[] r103 = X448Field.create();
        X448Field.add(r100, r101, r102);
        X448Field.sub(r100, r101, r103);
        X448Field.sqr(r102, r102);
        X448Field.sqr(r103, r103);
        X448Field.mul(r102, r103, r100);
        X448Field.sub(r102, r103, r102);
        X448Field.mul(r102, C_A24, r101);
        X448Field.add(r101, r103, r101);
        X448Field.mul(r101, r102, r101);
    }

    public static void precompute() {
        Ed448.precompute();
    }

    public static void scalarMult(byte[] r110, int r111, byte[] r112, int r113, byte[] r114, int r115) {
        int[] r100 = new int[14];
        decodeScalar(r110, r111, r100);
        int[] r116 = X448Field.create();
        X448Field.decode(r112, r113, r116);
        int[] r117 = X448Field.create();
        int r118 = 0;
        X448Field.copy(r116, 0, r117, 0);
        int[] r119 = X448Field.create();
        r119[0] = 1;
        int[] r101 = X448Field.create();
        r101[0] = 1;
        int[] r102 = X448Field.create();
        int[] r103 = X448Field.create();
        int[] r104 = X448Field.create();
        int r105 = BDVideoUploaderBase.KeyIsDynamicSliceForceConfig;
        int r106 = 1;
    L3:
        X448Field.add(r101, r102, r103);
        X448Field.sub(r101, r102, r101);
        X448Field.add(r117, r119, r102);
        X448Field.sub(r117, r119, r117);
        X448Field.mul(r103, r117, r103);
        X448Field.mul(r101, r102, r101);
        X448Field.sqr(r102, r102);
        X448Field.sqr(r117, r117);
        X448Field.sub(r102, r117, r104);
        X448Field.mul(r104, C_A24, r119);
        X448Field.add(r119, r117, r119);
        X448Field.mul(r119, r104, r119);
        X448Field.mul(r117, r102, r117);
        X448Field.sub(r103, r101, r102);
        X448Field.add(r103, r101, r101);
        X448Field.sqr(r101, r101);
        X448Field.sqr(r102, r102);
        X448Field.mul(r102, r116, r102);
        r105 = r105 - 1;
        int r107 = (r100[r105 >>> 5] >>> (r105 & 31)) & 1;
        int r108 = r106 ^ r107;
        X448Field.cswap(r108, r117, r101);
        X448Field.cswap(r108, r119, r102);
        if (r105 < 2) goto L5;
        r106 = r107;
    L5:
        if (r118 >= 2) goto L7;
        pointDouble(r117, r119);
        r118 = r118 + 1;
        goto L5
    L7:
        X448Field.inv(r119, r119);
        X448Field.mul(r117, r119, r117);
        X448Field.normalize(r117);
        X448Field.encode(r117, r114, r115);
    }

    public static void scalarMultBase(byte[] r100, int r101, byte[] r102, int r103) {
        int[] r104 = X448Field.create();
        int[] r105 = X448Field.create();
        Ed448.scalarMultBaseXY(Friend.access$000(), r100, r101, r104, r105);
        X448Field.inv(r104, r104);
        X448Field.mul(r104, r105, r104);
        X448Field.sqr(r104, r104);
        X448Field.normalize(r104);
        X448Field.encode(r104, r102, r103);
    }
}
