package org.bouncycastle.pqc.crypto.newhope;

import com.obric.sva.sdk.data.ISmModel;
import java.security.SecureRandom;
import kotlin.UByte;
import org.bouncycastle.crypto.digests.SHA3Digest;

/* JADX INFO: loaded from: classes42.dex */
class NewHope {
    public static final int AGREEMENT_SIZE = 32;
    public static final int POLY_SIZE = 1024;
    public static final int SENDA_BYTES = 1824;
    public static final int SENDB_BYTES = 2048;
    private static final boolean STATISTICAL_TEST = false;

    public NewHope() {
    }

    public static void decodeA(short[] r100, byte[] r101, byte[] r102) {
        Poly.fromBytes(r100, r102);
        System.arraycopy(r102, ISmModel.VERSION_0700, r101, 0, 32);
    }

    public static void decodeB(short[] r100, short[] r101, byte[] r102) {
        Poly.fromBytes(r100, r102);
        int r103 = 0;
    L4:
        if (r103 >= 256) goto L6;
        int r104 = r103 * 4;
        int r105 = r102[r103 + ISmModel.VERSION_0700] & UByte.MAX_VALUE;
        r101[r104 + 0] = (short) (r105 & 3);
        r101[r104 + 1] = (short) ((r105 >>> 2) & 3);
        r101[r104 + 2] = (short) ((r105 >>> 4) & 3);
        r101[r104 + 3] = (short) (r105 >>> 6);
        r103 = r103 + 1;
        goto L4
    }

    public static void encodeA(byte[] r100, short[] r101, byte[] r102) {
        Poly.toBytes(r100, r101);
        System.arraycopy(r102, 0, r100, ISmModel.VERSION_0700, 32);
    }

    public static void encodeB(byte[] r100, short[] r101, short[] r102) {
        Poly.toBytes(r100, r101);
        int r103 = 0;
    L4:
        if (r103 >= 256) goto L6;
        int r104 = r103 * 4;
        int r105 = r103 + ISmModel.VERSION_0700;
        int r106 = (r102[r104] | (r102[r104 + 1] << 2)) | (r102[r104 + 2] << 4);
        r100[r105] = (byte) ((r102[r104 + 3] << 6) | r106);
        r103 = r103 + 1;
        goto L4
    }

    public static void generateA(short[] r100, byte[] r101) {
        Poly.uniform(r100, r101);
    }

    public static void keygen(SecureRandom r100, byte[] r101, short[] r102) {
        byte[] r103 = new byte[32];
        r100.nextBytes(r103);
        sha3(r103);
        short[] r104 = new short[1024];
        generateA(r104, r103);
        byte[] r105 = new byte[32];
        r100.nextBytes(r105);
        Poly.getNoise(r102, r105, (byte) 0);
        Poly.toNTT(r102);
        short[] r106 = new short[1024];
        Poly.getNoise(r106, r105, (byte) 1);
        Poly.toNTT(r106);
        short[] r107 = new short[1024];
        Poly.pointWise(r104, r102, r107);
        short[] r108 = new short[1024];
        Poly.add(r107, r106, r108);
        encodeA(r101, r108, r103);
    }

    public static void sha3(byte[] r100) {
        SHA3Digest r101 = new SHA3Digest(256);
        r101.update(r100, 0, 32);
        r101.doFinal(r100, 0);
    }

    public static void sharedA(byte[] r100, short[] r101, byte[] r102) {
        short[] r103 = new short[1024];
        short[] r104 = new short[1024];
        decodeB(r103, r104, r102);
        short[] r105 = new short[1024];
        Poly.pointWise(r101, r103, r105);
        Poly.fromNTT(r105);
        ErrorCorrection.rec(r100, r105, r104);
        sha3(r100);
    }

    public static void sharedB(SecureRandom r100, byte[] r101, byte[] r102, byte[] r103) {
        short[] r104 = new short[1024];
        byte[] r105 = new byte[32];
        decodeA(r104, r105, r103);
        short[] r106 = new short[1024];
        generateA(r106, r105);
        byte[] r107 = new byte[32];
        r100.nextBytes(r107);
        short[] r108 = new short[1024];
        Poly.getNoise(r108, r107, (byte) 0);
        Poly.toNTT(r108);
        short[] r109 = new short[1024];
        Poly.getNoise(r109, r107, (byte) 1);
        Poly.toNTT(r109);
        short[] r110 = new short[1024];
        Poly.pointWise(r106, r108, r110);
        Poly.add(r110, r109, r110);
        short[] r111 = new short[1024];
        Poly.pointWise(r104, r108, r111);
        Poly.fromNTT(r111);
        short[] r112 = new short[1024];
        Poly.getNoise(r112, r107, (byte) 2);
        Poly.add(r111, r112, r111);
        short[] r113 = new short[1024];
        ErrorCorrection.helpRec(r113, r111, r107, (byte) 3);
        encodeB(r102, r110, r113);
        ErrorCorrection.rec(r101, r111, r113);
        sha3(r101);
    }
}
