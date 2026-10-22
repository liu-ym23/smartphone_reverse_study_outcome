package org.bouncycastle.crypto.digests;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes42.dex */
public abstract class HarakaBase implements Digest {
    protected static final int DIGEST_SIZE = 32;
    private static final byte[][] S = null;

    static {
        S = new byte[][]{new byte[]{99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118}, new byte[]{-54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64}, new byte[]{-73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21}, new byte[]{4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117}, new byte[]{9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124}, new byte[]{83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49}, new byte[]{-48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, 60, -97, -88}, new byte[]{81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46}, new byte[]{-51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, Base64.padSymbol, 100, 93, 25, 115}, new byte[]{96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37}, new byte[]{-32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121}, new byte[]{-25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8}, new byte[]{-70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118}, new byte[]{112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98}, new byte[]{-31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33}, new byte[]{-116, -95, -119, HTTP.CR, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22}};
    }

    public HarakaBase() {
    }

    public static byte[] aesEnc(byte[] r100, byte[] r101) {
        byte[] r102 = mixColumns(shiftRows(subBytes(r100)));
        xorReverse(r102, r101);
        return r102;
    }

    private static byte[] mixColumns(byte[] r110) {
        byte[] r100 = new byte[r110.length];
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r101 >= 4) goto L6;
        int r103 = r102 + 1;
        int r104 = r101 * 4;
        int r105 = r104 + 1;
        int r106 = (xTime(r110[r104]) ^ xTime(r110[r105])) ^ r110[r105];
        int r107 = r104 + 2;
        int r108 = r106 ^ r110[r107];
        int r109 = r104 + 3;
        r100[r102] = (byte) (r108 ^ r110[r109]);
        int r111 = r103 + 1;
        r100[r103] = (byte) ((((r110[r104] ^ xTime(r110[r105])) ^ xTime(r110[r107])) ^ r110[r107]) ^ r110[r109]);
        int r112 = r111 + 1;
        r100[r111] = (byte) ((((r110[r104] ^ r110[r105]) ^ xTime(r110[r107])) ^ xTime(r110[r109])) ^ r110[r109]);
        r102 = r112 + 1;
        byte r113 = xTime(r110[r104]);
        r100[r112] = (byte) ((((r110[r104] ^ r113) ^ r110[r105]) ^ r110[r107]) ^ xTime(r110[r109]));
        r101 = r101 + 1;
        goto L4
    L6:
        return r100;
    }

    public static byte sBox(byte r100) {
        return S[(r100 & UByte.MAX_VALUE) >>> 4][r100 & 15];
    }

    public static byte[] shiftRows(byte[] r110) {
        return new byte[]{r110[0], r110[5], r110[10], r110[15], r110[4], r110[9], r110[14], r110[3], r110[8], r110[13], r110[2], r110[7], r110[12], r110[1], r110[6], r110[11]};
    }

    public static byte[] subBytes(byte[] r100) {
        byte[] r101 = new byte[r100.length];
        r101[0] = sBox(r100[0]);
        r101[1] = sBox(r100[1]);
        r101[2] = sBox(r100[2]);
        r101[3] = sBox(r100[3]);
        r101[4] = sBox(r100[4]);
        r101[5] = sBox(r100[5]);
        r101[6] = sBox(r100[6]);
        r101[7] = sBox(r100[7]);
        r101[8] = sBox(r100[8]);
        r101[9] = sBox(r100[9]);
        r101[10] = sBox(r100[10]);
        r101[11] = sBox(r100[11]);
        r101[12] = sBox(r100[12]);
        r101[13] = sBox(r100[13]);
        r101[14] = sBox(r100[14]);
        r101[15] = sBox(r100[15]);
        return r101;
    }

    public static byte xTime(byte r100) {
        int r101 = r100 >>> 7;
        int r102 = r100 << 1;
        if (r101 <= 0) goto L6;
        r102 = r102 ^ 27;
    L6:
        return (byte) (r102 & 255);
    }

    public static byte[] xor(byte[] r100, byte[] r101, int r102) {
        byte[] r103 = new byte[16];
        int r104 = 0;
    L3:
        if (r104 >= 16) goto L5;
        byte r105 = r100[r104];
        int r106 = r102 + 1;
        r103[r104] = (byte) (r101[r102] ^ r105);
        r104 = r104 + 1;
        r102 = r106;
        goto L3
    L5:
        return r103;
    }

    public static void xorReverse(byte[] r110, byte[] r111) {
        r110[0] = (byte) (r110[0] ^ r111[15]);
        r110[1] = (byte) (r110[1] ^ r111[14]);
        r110[2] = (byte) (r110[2] ^ r111[13]);
        r110[3] = (byte) (r110[3] ^ r111[12]);
        r110[4] = (byte) (r110[4] ^ r111[11]);
        r110[5] = (byte) (r110[5] ^ r111[10]);
        r110[6] = (byte) (r110[6] ^ r111[9]);
        r110[7] = (byte) (r110[7] ^ r111[8]);
        byte r112 = r110[8];
        r110[8] = (byte) (r111[7] ^ r112);
        byte r113 = r110[9];
        r110[9] = (byte) (r111[6] ^ r113);
        byte r114 = r110[10];
        r110[10] = (byte) (r111[5] ^ r114);
        byte r100 = r110[11];
        r110[11] = (byte) (r111[4] ^ r100);
        byte r101 = r110[12];
        r110[12] = (byte) (r111[3] ^ r101);
        byte r102 = r110[13];
        r110[13] = (byte) (r111[2] ^ r102);
        byte r103 = r110[14];
        r110[14] = (byte) (r111[1] ^ r103);
        byte r104 = r110[15];
        r110[15] = (byte) (r111[0] ^ r104);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }
}
