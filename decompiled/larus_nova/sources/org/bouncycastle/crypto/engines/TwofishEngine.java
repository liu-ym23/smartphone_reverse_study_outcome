package org.bouncycastle.crypto.engines;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes42.dex */
public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;
    private static final byte[][] P = null;
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private boolean encrypting;
    private int[] gMDS0;
    private int[] gMDS1;
    private int[] gMDS2;
    private int[] gMDS3;
    private int[] gSBox;
    private int[] gSubKeys;
    private int k64Cnt;
    private byte[] workingKey;

    static {
        P = new byte[][]{new byte[]{-87, 103, -77, -24, 4, -3, -93, 118, -102, -110, ByteCompanionObject.MIN_VALUE, 120, -28, -35, -47, 56, HTTP.CR, -58, 53, -104, 24, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, -48, -117, 48, -124, 84, -33, 35, 25, 91, Base64.padSymbol, 89, -13, -82, -94, -126, 99, 1, -125, 46, -39, 81, -101, 124, -90, -21, -91, -66, 22, 12, -29, 97, -64, -116, 58, -11, 115, 44, 37, 11, -69, 78, -119, 107, 83, 106, -76, -15, -31, -26, -67, 69, -30, -12, -74, 102, -52, -107, 3, 86, -44, 28, 30, -41, -5, -61, -114, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, 98, 113, -127, 121, 9, -83, 36, -51, -7, -40, -27, -59, -71, 77, 68, 8, -122, -25, -95, 29, -86, -19, 6, 112, -78, -46, 65, 123, -96, 17, 49, -62, 39, -112, 32, -10, 96, -1, -106, 92, -79, -85, -98, -100, 82, 27, 95, -109, 10, -17, -111, -123, 73, -18, 45, 79, -113, 59, 71, -121, 109, 70, -42, 62, 105, 100, 42, -50, -53, 47, -4, -105, 5, 122, -84, ByteCompanionObject.MAX_VALUE, -43, 26, 75, 14, -89, 90, 40, 20, 63, 41, -120, 60, 76, 2, -72, -38, -80, 23, 85, 31, -118, 125, 87, -57, -115, 116, -73, -60, -97, 114, 126, 21, 34, 18, 88, 7, -103, 52, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, 64, -36, -2, 50, -92, -54, 16, 33, -16, -45, 93, 15, 0, 111, -99, 54, 66, 74, 94, -63, -32}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, -42, 50, -40, -3, 55, 113, -15, -31, 48, 15, -8, 27, -121, -6, 6, 63, 94, -70, -82, 91, -118, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, -79, 14, ByteCompanionObject.MIN_VALUE, 93, -46, -43, -96, -124, 7, 20, -75, -112, 44, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, -80, -67, 90, -4, 96, 98, -106, 108, 66, -9, 16, 124, 40, 39, -116, 19, -107, -100, -57, 36, 70, 59, 112, -54, -29, -123, -53, 17, -48, -109, -72, -90, -125, 32, -1, -97, 119, -61, -52, 3, 111, 8, -65, 64, -25, 43, -30, 121, 12, -86, -126, 65, 58, -22, -71, -28, -102, -92, -105, 126, -38, 122, 23, 102, -108, -95, 29, Base64.padSymbol, -16, -34, -77, 11, 114, -89, 28, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, 42, 73, -127, -120, -18, 33, -60, 26, -21, -39, -59, 57, -103, -51, -83, 49, -117, 1, 24, 35, -35, 31, 78, 45, -7, 72, 79, -14, 101, -114, 120, 92, 88, 25, -115, -27, -104, 87, 103, ByteCompanionObject.MAX_VALUE, 5, 100, -81, 99, -74, -2, -11, -73, 60, -91, -50, -23, 104, 68, -32, 77, 67, 105, 41, 46, -84, 21, 89, -88, 10, -98, 110, 71, -33, 52, 53, 106, -49, -36, 34, -55, -64, -101, -119, -44, -19, -85, 18, -94, HTTP.CR, 82, -69, 2, 47, -87, -41, 97, 30, -76, 80, 4, -10, -62, 22, 37, -122, 86, 85, 9, -66, -111}};
    }

    public TwofishEngine() {
        this.encrypting = false;
        this.gMDS0 = new int[256];
        this.gMDS1 = new int[256];
        this.gMDS2 = new int[256];
        this.gMDS3 = new int[256];
        this.k64Cnt = 0;
        this.workingKey = null;
        int[] r100 = new int[2];
        int[] r101 = new int[2];
        int[] r102 = new int[2];
        int r103 = 0;
    L3:
        if (r103 >= 256) goto L5;
        byte[][] r104 = P;
        int r105 = r104[0][r103] & UByte.MAX_VALUE;
        r100[0] = r105;
        r101[0] = Mx_X(r105) & 255;
        r102[0] = Mx_Y(r105) & 255;
        int r106 = r104[1][r103] & UByte.MAX_VALUE;
        r100[1] = r106;
        r101[1] = Mx_X(r106) & 255;
        int r107 = Mx_Y(r106) & 255;
        r102[1] = r107;
        int[] r108 = this.gMDS0;
        int r109 = (r100[1] | (r101[1] << 8)) | (r107 << 16);
        r108[r103] = (r107 << 24) | r109;
        int[] r110 = this.gMDS1;
        int r111 = r102[0];
        r110[r103] = ((r111 | (r111 << 8)) | (r101[0] << 16)) | (r100[0] << 24);
        int[] r112 = this.gMDS2;
        int r113 = r101[1];
        int r114 = r102[1];
        int r115 = r100[1] << 16;
        r112[r103] = (r115 | (r113 | (r114 << 8))) | (r114 << 24);
        int[] r116 = this.gMDS3;
        int r117 = r101[0];
        int r118 = ((r100[0] << 8) | r117) | (r102[0] << 16);
        r116[r103] = (r117 << 24) | r118;
        r103 = r103 + 1;
        goto L3
    }

    private void Bits32ToBytes(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        r101[r102 + 1] = (byte) (r100 >> 8);
        r101[r102 + 2] = (byte) (r100 >> 16);
        r101[r102 + 3] = (byte) (r100 >> 24);
    }

    private int BytesTo32Bits(byte[] r100, int r101) {
        int r102 = ((r100[r101] & UByte.MAX_VALUE) | ((r100[r101 + 1] & UByte.MAX_VALUE) << 8)) | ((r100[r101 + 2] & UByte.MAX_VALUE) << 16);
        return ((r100[r101 + 3] & UByte.MAX_VALUE) << 24) | r102;
    }

    private int F32(int r110, int[] r111) {
        int r100 = b0(r110);
        int r101 = b1(r110);
        int r102 = b2(r110);
        int r112 = b3(r110);
        int r103 = r111[0];
        int r104 = r111[1];
        int r105 = r111[2];
        int r113 = r111[3];
        int r114 = this.k64Cnt & 3;
        if (r114 == 0) goto L9;
        if (r114 == 1) goto L8;
        if (r114 == 2) goto L11;
        if (r114 != 3) goto L14;
    L10:
        byte[][] r115 = P;
        r100 = (r115[1][r100] & UByte.MAX_VALUE) ^ b0(r105);
        r101 = (r115[1][r101] & UByte.MAX_VALUE) ^ b1(r105);
        r102 = (r115[0][r102] & UByte.MAX_VALUE) ^ b2(r105);
        r112 = (r115[0][r112] & UByte.MAX_VALUE) ^ b3(r105);
        goto L11
    L14:
        return 0;
    L11:
        int[] r116 = this.gMDS0;
        byte[][] r106 = P;
        byte[] r107 = r106[0];
        int r117 = (r116[(r107[(r107[r100] & UByte.MAX_VALUE) ^ b0(r104)] & UByte.MAX_VALUE) ^ b0(r103)] ^ this.gMDS1[(r106[0][(r106[1][r101] & UByte.MAX_VALUE) ^ b1(r104)] & UByte.MAX_VALUE) ^ b1(r103)]) ^ this.gMDS2[(r106[1][(r106[0][r102] & UByte.MAX_VALUE) ^ b2(r104)] & UByte.MAX_VALUE) ^ b2(r103)];
        int[] r108 = this.gMDS3;
        byte[] r109 = r106[1];
        int r118 = r108[(r109[(r109[r112] & UByte.MAX_VALUE) ^ b3(r104)] & UByte.MAX_VALUE) ^ b3(r103)];
    L13:
        return r117 ^ r118;
    L8:
        int[] r119 = this.gMDS0;
        byte[][] r120 = P;
        r117 = (r119[(r120[0][r100] & UByte.MAX_VALUE) ^ b0(r103)] ^ this.gMDS1[(r120[0][r101] & UByte.MAX_VALUE) ^ b1(r103)]) ^ this.gMDS2[(r120[1][r102] & UByte.MAX_VALUE) ^ b2(r103)];
        r118 = this.gMDS3[(r120[1][r112] & UByte.MAX_VALUE) ^ b3(r103)];
        goto L13
    L9:
        byte[][] r121 = P;
        r100 = (r121[1][r100] & UByte.MAX_VALUE) ^ b0(r113);
        r101 = (r121[0][r101] & UByte.MAX_VALUE) ^ b1(r113);
        r102 = (r121[0][r102] & UByte.MAX_VALUE) ^ b2(r113);
        r112 = (r121[1][r112] & UByte.MAX_VALUE) ^ b3(r113);
        goto L10
    }

    private int Fe32_0(int r100) {
        int[] r101 = this.gSBox;
        int r102 = (r101[((r100 & 255) * 2) + 0] ^ r101[(((r100 >>> 8) & 255) * 2) + 1]) ^ r101[(((r100 >>> 16) & 255) * 2) + 512];
        return r101[(((r100 >>> 24) & 255) * 2) + 513] ^ r102;
    }

    private int Fe32_3(int r100) {
        int[] r101 = this.gSBox;
        int r102 = (r101[(((r100 >>> 24) & 255) * 2) + 0] ^ r101[((r100 & 255) * 2) + 1]) ^ r101[(((r100 >>> 8) & 255) * 2) + 512];
        return r101[(((r100 >>> 16) & 255) * 2) + 513] ^ r102;
    }

    private int LFSR1(int r100) {
        int r101 = r100 >> 1;
        if ((r100 & 1) == 0) goto L5;
        int r102 = 180;
    L7:
        return r102 ^ r101;
    L5:
        r102 = 0;
        goto L7
    }

    private int LFSR2(int r100) {
        int r101 = r100 >> 2;
        int r102 = 0;
        if ((r100 & 2) == 0) goto L5;
        int r103 = 180;
    L6:
        int r104 = r101 ^ r103;
        if ((r100 & 1) == 0) goto L10;
        r102 = 90;
    L10:
        return r104 ^ r102;
    L5:
        r103 = 0;
        goto L6
    }

    private int Mx_X(int r100) {
        return r100 ^ LFSR2(r100);
    }

    private int Mx_Y(int r100) {
        int r101 = LFSR1(r100) ^ r100;
        return LFSR2(r100) ^ r101;
    }

    private int RS_MDS_Encode(int r100, int r101) {
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= 4) goto L6;
        r101 = RS_rem(r101);
        r103 = r103 + 1;
        goto L4
    L6:
        int r104 = r100 ^ r101;
    L7:
        if (r102 >= 4) goto L9;
        r104 = RS_rem(r104);
        r102 = r102 + 1;
        goto L7
    L9:
        return r104;
    }

    private int RS_rem(int r100) {
        int r101 = (r100 >>> 24) & 255;
        int r102 = r101 << 1;
        int r103 = 0;
        if ((r101 & 128) == 0) goto L5;
        int r104 = 333;
    L6:
        int r105 = (r102 ^ r104) & 255;
        int r106 = r101 >>> 1;
        if ((r101 & 1) == 0) goto L9;
        r103 = 166;
    L9:
        int r107 = (r106 ^ r103) ^ r105;
        return ((((r100 << 8) ^ (r107 << 24)) ^ (r105 << 16)) ^ (r107 << 8)) ^ r101;
    L5:
        r104 = 0;
        goto L6
    }

    private int b0(int r100) {
        return r100 & 255;
    }

    private int b1(int r100) {
        return (r100 >>> 8) & 255;
    }

    private int b2(int r100) {
        return (r100 >>> 16) & 255;
    }

    private int b3(int r100) {
        return (r100 >>> 24) & 255;
    }

    private void decryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = BytesTo32Bits(r110, r111) ^ this.gSubKeys[4];
        int r101 = BytesTo32Bits(r110, r111 + 4) ^ this.gSubKeys[5];
        int r102 = BytesTo32Bits(r110, r111 + 8) ^ this.gSubKeys[6];
        int r114 = BytesTo32Bits(r110, r111 + 12) ^ this.gSubKeys[7];
        int r115 = 39;
        int r103 = 0;
    L4:
        if (r103 >= 16) goto L6;
        int r104 = Fe32_0(r100);
        int r105 = Fe32_3(r101);
        int[] r106 = this.gSubKeys;
        int r107 = r115 - 1;
        int r116 = r114 ^ (((r105 * 2) + r104) + r106[r115]);
        int r117 = (r102 << 1) | (r102 >>> 31);
        int r108 = r107 - 1;
        int r118 = r117 ^ ((r104 + r105) + r106[r107]);
        r114 = (r116 << 31) | (r116 >>> 1);
        int r109 = Fe32_0(r118);
        int r119 = Fe32_3(r114);
        int[] r120 = this.gSubKeys;
        int r121 = r108 - 1;
        int r122 = r101 ^ (((r119 * 2) + r109) + r120[r108]);
        r100 = ((r100 >>> 31) | (r100 << 1)) ^ ((r109 + r119) + r120[r121]);
        r101 = (r122 << 31) | (r122 >>> 1);
        r103 = r103 + 2;
        r102 = r118;
        r115 = r121 - 1;
        goto L4
    L6:
        Bits32ToBytes(this.gSubKeys[0] ^ r102, r112, r113);
        Bits32ToBytes(r114 ^ this.gSubKeys[1], r112, r113 + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ r100, r112, r113 + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ r101, r112, r113 + 12);
    }

    private void encryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = 0;
        int r101 = BytesTo32Bits(r110, r111) ^ this.gSubKeys[0];
        int r102 = BytesTo32Bits(r110, r111 + 4) ^ this.gSubKeys[1];
        int r103 = BytesTo32Bits(r110, r111 + 8) ^ this.gSubKeys[2];
        int r114 = BytesTo32Bits(r110, r111 + 12) ^ this.gSubKeys[3];
        int r115 = 8;
    L4:
        if (r100 >= 16) goto L6;
        int r104 = Fe32_0(r101);
        int r105 = Fe32_3(r102);
        int[] r106 = this.gSubKeys;
        int r107 = r115 + 1;
        int r116 = r103 ^ ((r104 + r105) + r106[r115]);
        r103 = (r116 >>> 1) | (r116 << 31);
        int r117 = r114 << 1;
        int r118 = (r114 >>> 31) | r117;
        int r119 = r107 + 1;
        r114 = r118 ^ ((r104 + (r105 * 2)) + r106[r107]);
        int r108 = Fe32_0(r103);
        int r109 = Fe32_3(r114);
        int[] r120 = this.gSubKeys;
        int r121 = r119 + 1;
        int r122 = r101 ^ ((r108 + r109) + r120[r119]);
        r101 = (r122 >>> 1) | (r122 << 31);
        int r123 = (r102 << 1) | (r102 >>> 31);
        r100 = r100 + 2;
        r102 = r123 ^ ((r108 + (r109 * 2)) + r120[r121]);
        r115 = r121 + 1;
        goto L4
    L6:
        Bits32ToBytes(this.gSubKeys[4] ^ r103, r112, r113);
        Bits32ToBytes(r114 ^ this.gSubKeys[5], r112, r113 + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ r101, r112, r113 + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ r102, r112, r113 + 12);
    }

    private void setKey(byte[] r210) {
        int[] r100 = new int[4];
        int[] r101 = new int[4];
        int[] r102 = new int[4];
        this.gSubKeys = new int[40];
        int r103 = this.k64Cnt;
        if (r103 < 1) goto L33;
        if (r103 > 4) goto L31;
        int r104 = 0;
    L7:
        if (r104 >= this.k64Cnt) goto L9;
        int r105 = r104 * 8;
        r100[r104] = BytesTo32Bits(r210, r105);
        int r106 = BytesTo32Bits(r210, r105 + 4);
        r101[r104] = r106;
        r102[(this.k64Cnt - 1) - r104] = RS_MDS_Encode(r100[r104], r106);
        r104 = r104 + 1;
        goto L7
    L9:
        int r107 = 0;
    L11:
        if (r107 >= 20) goto L13;
        int r108 = SK_STEP * r107;
        int r109 = F32(r108, r100);
        int r110 = F32(r108 + 16843009, r101);
        int r111 = r110 << 8;
        int r112 = (r110 >>> 24) | r111;
        int r113 = r109 + r112;
        int[] r114 = this.gSubKeys;
        int r115 = r107 * 2;
        r114[r115] = r113;
        int r116 = r113 + r112;
        r114[r115 + 1] = (r116 << 9) | (r116 >>> 23);
        r107 = r107 + 1;
        goto L11
    L13:
        int r117 = r102[0];
        int r118 = r102[1];
        int r119 = 2;
        int r120 = r102[2];
        int r121 = r102[3];
        this.gSBox = new int[1024];
        int r122 = 0;
    L15:
        if (r122 >= 256) goto L29;
        int r123 = this.k64Cnt & 3;
        if (r123 == 0) goto L25;
        if (r123 == 1) goto L24;
        if (r123 == r119) goto L23;
        if (r123 != 3) goto L28;
        int r124 = r122;
        int r125 = r124;
        int r126 = r125;
        int r127 = r126;
    L26:
        byte[][] r128 = P;
        int r129 = (r128[1][r125] & UByte.MAX_VALUE) ^ b0(r120);
        int r130 = (r128[1][r126] & UByte.MAX_VALUE) ^ b1(r120);
        int r131 = (r128[0][r127] & UByte.MAX_VALUE) ^ b2(r120);
        int r132 = (r128[0][r124] & UByte.MAX_VALUE) ^ b3(r120);
    L27:
        int[] r133 = this.gSBox;
        int r134 = r122 * 2;
        int[] r135 = this.gMDS0;
        byte[][] r136 = P;
        byte[] r137 = r136[0];
        r133[r134] = r135[(r137[(r137[r129] & UByte.MAX_VALUE) ^ b0(r118)] & UByte.MAX_VALUE) ^ b0(r117)];
        this.gSBox[r134 + 1] = this.gMDS1[(r136[0][(r136[1][r130] & UByte.MAX_VALUE) ^ b1(r118)] & UByte.MAX_VALUE) ^ b1(r117)];
        this.gSBox[r134 + 512] = this.gMDS2[(r136[1][(r136[0][r131] & UByte.MAX_VALUE) ^ b2(r118)] & UByte.MAX_VALUE) ^ b2(r117)];
        int[] r138 = this.gMDS3;
        byte[] r139 = r136[1];
        this.gSBox[r134 + 513] = r138[(r139[(r139[r132] & UByte.MAX_VALUE) ^ b3(r118)] & UByte.MAX_VALUE) ^ b3(r117)];
    L28:
        r122 = r122 + 1;
        r119 = 2;
        goto L15
    L23:
        r132 = r122;
        r129 = r132;
        r130 = r129;
        r131 = r130;
        goto L27
    L24:
        int[] r140 = this.gSBox;
        int r141 = r122 * 2;
        int[] r142 = this.gMDS0;
        byte[][] r143 = P;
        r140[r141] = r142[(r143[0][r122] & UByte.MAX_VALUE) ^ b0(r117)];
        this.gSBox[r141 + 1] = this.gMDS1[(r143[0][r122] & UByte.MAX_VALUE) ^ b1(r117)];
        this.gSBox[r141 + 512] = this.gMDS2[(r143[1][r122] & UByte.MAX_VALUE) ^ b2(r117)];
        this.gSBox[r141 + 513] = this.gMDS3[(r143[1][r122] & UByte.MAX_VALUE) ^ b3(r117)];
        goto L28
    L25:
        byte[][] r144 = P;
        r125 = (r144[1][r122] & UByte.MAX_VALUE) ^ b0(r121);
        r126 = (r144[0][r122] & UByte.MAX_VALUE) ^ b1(r121);
        r127 = (r144[0][r122] & UByte.MAX_VALUE) ^ b2(r121);
        r124 = (r144[1][r122] & UByte.MAX_VALUE) ^ b3(r121);
        goto L26
    L29:
        return;
    L31:
        throw new IllegalArgumentException("Key size larger than 256 bits");
    L33:
        throw new IllegalArgumentException("Key size less than 64 bits");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Twofish";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.encrypting = r100;
        byte[] r102 = ((KeyParameter) r101).getKey();
        this.workingKey = r102;
        this.k64Cnt = r102.length / 8;
        setKey(r102);
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this.workingKey == null) goto L19;
        if ((r101 + 16) > r100.length) goto L17;
        if ((r103 + 16) > r102.length) goto L15;
        if (this.encrypting == false) goto L11;
        encryptBlock(r100, r101, r102, r103);
        return 16;
    L11:
        decryptBlock(r100, r101, r102, r103);
        return 16;
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException("Twofish not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] r100 = this.workingKey;
        if (r100 == null) goto L6;
        setKey(r100);
        return;
    }
}
