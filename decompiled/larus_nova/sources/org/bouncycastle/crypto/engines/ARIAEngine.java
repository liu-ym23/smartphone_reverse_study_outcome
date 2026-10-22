package org.bouncycastle.crypto.engines;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.lang.reflect.Array;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class ARIAEngine implements BlockCipher {
    protected static final int BLOCK_SIZE = 16;
    private static final byte[][] C = null;
    private static final byte[] SB1_sbox = null;
    private static final byte[] SB2_sbox = null;
    private static final byte[] SB3_sbox = null;
    private static final byte[] SB4_sbox = null;
    private byte[][] roundKeys;

    static {
        C = new byte[][]{Hex.decodeStrict("517cc1b727220a94fe13abe8fa9a6ee0"), Hex.decodeStrict("6db14acc9e21c820ff28b1d5ef5de2b0"), Hex.decodeStrict("db92371d2126e9700324977504e8c90e")};
        SB1_sbox = new byte[]{99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, ByteCompanionObject.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, ByteCompanionObject.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, Base64.padSymbol, 100, 93, 25, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, 28, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, -95, -119, HTTP.CR, -65, -26, 66, 104, 65, -103, 45, 15, -80, 84, -69, 22};
        SB2_sbox = new byte[]{-30, 78, 84, -4, -108, -62, 74, -52, 98, HTTP.CR, 106, 70, 60, 77, -117, -47, 94, -6, 100, -53, -76, -105, -66, 43, PSSSigner.TRAILER_IMPLICIT, 119, 46, 3, -45, 25, 89, -63, 29, 6, 65, 107, 85, -16, -103, 105, -22, -100, 24, -82, 99, -33, -25, -69, 0, 115, 102, -5, -106, 76, -123, -28, 58, 9, 69, -86, 15, -18, 16, -21, 45, ByteCompanionObject.MAX_VALUE, -12, 41, -84, -49, -83, -111, -115, 120, -56, -107, -7, 47, -50, -51, 8, 122, -120, 56, 92, -125, 42, 40, 71, -37, -72, -57, -109, -92, 18, 83, -1, -121, 14, 49, 54, 33, 88, 72, 1, -114, 55, 116, 50, -54, -23, -79, -73, -85, 12, -41, -60, 86, 66, 38, 7, -104, 96, -39, -74, -71, 17, 64, -20, 32, -116, -67, -96, -55, -124, 4, 73, 35, -15, 79, 80, 31, 19, -36, -40, -64, -98, 87, -29, -61, 123, 101, 59, 2, -113, 62, -24, 37, -110, -27, 21, -35, -3, 23, -87, -65, -44, -102, 126, -59, 57, 103, -2, 118, -99, 67, -89, -31, -48, -11, 104, -14, 27, 52, 112, 5, -93, -118, -43, 121, -122, -88, 48, -58, 81, 75, 30, -90, 39, -10, 53, -46, 110, 36, 22, -126, 95, -38, -26, 117, -94, -17, 44, -78, 28, -97, 93, 111, ByteCompanionObject.MIN_VALUE, 10, 114, 68, -101, 108, -112, 11, 91, 51, 125, 90, 82, -13, 97, -95, -9, -80, -42, 63, 124, 109, -19, 20, -32, -91, Base64.padSymbol, 34, -77, -8, -119, -34, 113, 26, -81, -70, -75, -127};
        SB3_sbox = new byte[]{82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, 35, Base64.padSymbol, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, 36, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, 110, 71, -15, 26, 113, 29, 41, -59, -119, 111, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, 18, 16, 89, 39, ByteCompanionObject.MIN_VALUE, -20, 95, 96, 81, ByteCompanionObject.MAX_VALUE, -87, 25, -75, 74, HTTP.CR, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, 43, 4, 126, -70, 119, -42, 38, -31, 105, 20, 99, 85, 33, 12, 125};
        SB4_sbox = new byte[]{48, 104, -103, 27, -121, -71, 33, 120, 80, 57, -37, -31, 114, 9, 98, 60, 62, 126, 94, -114, -15, -96, -52, -93, 42, 29, -5, -74, -42, 32, -60, -115, -127, 101, -11, -119, -53, -99, 119, -58, 87, 67, 86, 23, -44, 64, 26, 77, -64, 99, 108, -29, -73, -56, 100, 106, 83, -86, 56, -104, 12, -12, -101, -19, ByteCompanionObject.MAX_VALUE, 34, 118, -81, -35, 58, 11, 88, 103, -120, 6, -61, 53, HTTP.CR, 1, -117, -116, -62, -26, 95, 2, 36, 117, -109, 102, 30, -27, -30, 84, -40, 16, -50, 122, -24, 8, 44, 18, -105, 50, -85, -76, 39, 10, 35, -33, -17, -54, -39, -72, -6, -36, 49, 107, -47, -83, 25, 73, -67, 81, -106, -18, -28, -88, 65, -38, -1, -51, 85, -122, 54, -66, 97, 82, -8, -69, 14, -126, 72, 105, -102, -32, 71, -98, 92, 4, 75, 52, 21, 121, 38, -89, -34, 41, -82, -110, -41, -124, -23, -46, -70, 93, -13, -59, -80, -65, -92, 59, 113, 68, 70, 43, -4, -21, 111, -43, -10, 20, -2, 124, 112, 90, 125, -3, 47, 24, -125, 22, -91, -111, 31, 5, -107, 116, -87, -63, 91, 74, -123, 109, 19, 7, 79, 78, 69, -78, 15, -55, 28, -90, PSSSigner.TRAILER_IMPLICIT, -20, 115, -112, 123, -49, 89, -113, -95, -7, 45, -14, -79, 0, -108, 55, -97, -48, 46, -100, 110, 40, 63, ByteCompanionObject.MIN_VALUE, -16, Base64.padSymbol, -45, 37, -118, -75, -25, 66, -77, -57, -22, -9, 76, 17, 51, 3, -94, -84, 96};
    }

    public ARIAEngine() {
    }

    public static void A(byte[] r310) {
        byte r100 = r310[0];
        byte r101 = r310[1];
        byte r102 = r310[2];
        byte r103 = r310[3];
        byte r104 = r310[4];
        byte r110 = r310[5];
        byte r111 = r310[6];
        byte r112 = r310[7];
        byte r113 = r310[8];
        byte r114 = r310[9];
        byte r210 = r310[10];
        byte r211 = r310[11];
        byte r212 = r310[12];
        byte r213 = r310[13];
        byte r214 = r310[14];
        byte r311 = r310[15];
        r310[0] = (byte) ((((((r103 ^ r104) ^ r111) ^ r113) ^ r114) ^ r213) ^ r214);
        r310[1] = (byte) ((((((r102 ^ r110) ^ r112) ^ r113) ^ r114) ^ r212) ^ r311);
        r310[2] = (byte) ((((((r101 ^ r104) ^ r111) ^ r210) ^ r211) ^ r212) ^ r311);
        r310[3] = (byte) ((((((r100 ^ r110) ^ r112) ^ r210) ^ r211) ^ r213) ^ r214);
        int r105 = r100 ^ r102;
        r310[4] = (byte) (((((r105 ^ r110) ^ r113) ^ r211) ^ r214) ^ r311);
        int r106 = r101 ^ r103;
        r310[5] = (byte) (((((r106 ^ r104) ^ r114) ^ r210) ^ r214) ^ r311);
        r310[6] = (byte) (((((r105 ^ r112) ^ r114) ^ r210) ^ r212) ^ r213);
        r310[7] = (byte) (((((r106 ^ r111) ^ r113) ^ r211) ^ r212) ^ r213);
        int r107 = r100 ^ r101;
        r310[8] = (byte) (((((r107 ^ r104) ^ r112) ^ r210) ^ r213) ^ r311);
        r310[9] = (byte) (((((r107 ^ r110) ^ r111) ^ r211) ^ r212) ^ r214);
        int r108 = r102 ^ r103;
        r310[10] = (byte) (((((r108 ^ r110) ^ r111) ^ r113) ^ r213) ^ r311);
        r310[11] = (byte) (((((r108 ^ r104) ^ r112) ^ r114) ^ r212) ^ r214);
        int r109 = r101 ^ r102;
        r310[12] = (byte) (((((r109 ^ r111) ^ r112) ^ r114) ^ r211) ^ r212);
        int r115 = r100 ^ r103;
        r310[13] = (byte) (((((r115 ^ r111) ^ r112) ^ r113) ^ r210) ^ r213);
        r310[14] = (byte) (((((r115 ^ r104) ^ r110) ^ r114) ^ r211) ^ r214);
        r310[15] = (byte) (((((r109 ^ r104) ^ r110) ^ r113) ^ r210) ^ r311);
    }

    public static void FE(byte[] r100, byte[] r101) {
        xor(r100, r101);
        SL2(r100);
        A(r100);
    }

    public static void FO(byte[] r100, byte[] r101) {
        xor(r100, r101);
        SL1(r100);
        A(r100);
    }

    public static byte SB1(byte r100) {
        return SB1_sbox[r100 & UByte.MAX_VALUE];
    }

    public static byte SB2(byte r100) {
        return SB2_sbox[r100 & UByte.MAX_VALUE];
    }

    public static byte SB3(byte r100) {
        return SB3_sbox[r100 & UByte.MAX_VALUE];
    }

    public static byte SB4(byte r100) {
        return SB4_sbox[r100 & UByte.MAX_VALUE];
    }

    public static void SL1(byte[] r100) {
        r100[0] = SB1(r100[0]);
        r100[1] = SB2(r100[1]);
        r100[2] = SB3(r100[2]);
        r100[3] = SB4(r100[3]);
        r100[4] = SB1(r100[4]);
        r100[5] = SB2(r100[5]);
        r100[6] = SB3(r100[6]);
        r100[7] = SB4(r100[7]);
        r100[8] = SB1(r100[8]);
        r100[9] = SB2(r100[9]);
        r100[10] = SB3(r100[10]);
        r100[11] = SB4(r100[11]);
        r100[12] = SB1(r100[12]);
        r100[13] = SB2(r100[13]);
        r100[14] = SB3(r100[14]);
        r100[15] = SB4(r100[15]);
    }

    public static void SL2(byte[] r100) {
        r100[0] = SB3(r100[0]);
        r100[1] = SB4(r100[1]);
        r100[2] = SB1(r100[2]);
        r100[3] = SB2(r100[3]);
        r100[4] = SB3(r100[4]);
        r100[5] = SB4(r100[5]);
        r100[6] = SB1(r100[6]);
        r100[7] = SB2(r100[7]);
        r100[8] = SB3(r100[8]);
        r100[9] = SB4(r100[9]);
        r100[10] = SB1(r100[10]);
        r100[11] = SB2(r100[11]);
        r100[12] = SB3(r100[12]);
        r100[13] = SB4(r100[13]);
        r100[14] = SB1(r100[14]);
        r100[15] = SB2(r100[15]);
    }

    public static byte[][] keySchedule(boolean r110, byte[] r111) {
        int r100 = r111.length;
        if (r100 < 16) goto L19;
        if (r100 > 32) goto L19;
        if ((r100 & 7) != 0) goto L19;
        int r101 = (r100 >>> 3) - 2;
        byte[][] r102 = C;
        byte[] r103 = r102[r101];
        byte[] r104 = r102[(r101 + 1) % 3];
        byte[] r105 = r102[(r101 + 2) % 3];
        byte[] r106 = new byte[16];
        byte[] r107 = new byte[16];
        System.arraycopy(r111, 0, r106, 0, 16);
        System.arraycopy(r111, 16, r107, 0, r100 - 16);
        byte[] r112 = new byte[16];
        byte[] r108 = new byte[16];
        byte[] r113 = new byte[16];
        byte[] r114 = new byte[16];
        System.arraycopy(r106, 0, r112, 0, 16);
        System.arraycopy(r112, 0, r108, 0, 16);
        FO(r108, r103);
        xor(r108, r107);
        System.arraycopy(r108, 0, r113, 0, 16);
        FE(r113, r104);
        xor(r113, r112);
        System.arraycopy(r113, 0, r114, 0, 16);
        FO(r114, r105);
        xor(r114, r108);
        int r109 = (r101 * 2) + 12;
        int r115 = 1;
        byte[][] r116 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r109 + 1, 16});
        keyScheduleRound(r116[0], r112, r108, 19);
        keyScheduleRound(r116[1], r108, r113, 19);
        keyScheduleRound(r116[2], r113, r114, 19);
        keyScheduleRound(r116[3], r114, r112, 19);
        keyScheduleRound(r116[4], r112, r108, 31);
        keyScheduleRound(r116[5], r108, r113, 31);
        keyScheduleRound(r116[6], r113, r114, 31);
        keyScheduleRound(r116[7], r114, r112, 31);
        keyScheduleRound(r116[8], r112, r108, 67);
        keyScheduleRound(r116[9], r108, r113, 67);
        keyScheduleRound(r116[10], r113, r114, 67);
        keyScheduleRound(r116[11], r114, r112, 67);
        keyScheduleRound(r116[12], r112, r108, 97);
        if (r109 <= 12) goto L13;
        keyScheduleRound(r116[13], r108, r113, 97);
        keyScheduleRound(r116[14], r113, r114, 97);
        if (r109 <= 14) goto L13;
        keyScheduleRound(r116[15], r114, r112, 97);
        keyScheduleRound(r116[16], r112, r108, 109);
    L13:
        if (r110 == true) goto L17;
        reverseKeys(r116);
    L15:
        if (r115 >= r109) goto L17;
        A(r116[r115]);
        r115 = r115 + 1;
    L17:
        return r116;
    L19:
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    public static void keyScheduleRound(byte[] r100, byte[] r101, byte[] r102, int r103) {
        int r104 = r103 >>> 3;
        int r105 = r103 & 7;
        int r106 = 8 - r105;
        int r107 = r102[15 - r104] & 255;
        int r108 = 0;
    L4:
        if (r108 >= 16) goto L6;
        int r109 = r102[(r108 - r104) & 15] & 255;
        r100[r108] = (byte) (((r107 << r106) | (r109 >>> r105)) ^ (r101[r108] & 255));
        r108 = r108 + 1;
        r107 = r109;
        goto L4
    }

    public static void reverseKeys(byte[][] r100) {
        int r101 = r100.length;
        int r102 = r101 / 2;
        int r103 = r101 - 1;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        byte[] r105 = r100[r104];
        int r106 = r103 - r104;
        r100[r104] = r100[r106];
        r100[r106] = r105;
        r104 = r104 + 1;
        goto L3
    }

    public static void xor(byte[] r100, byte[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= 16) goto L6;
        r100[r102] = (byte) (r100[r102] ^ r101[r102]);
        r102 = r102 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "ARIA";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.roundKeys = keySchedule(r100, ((KeyParameter) r101).getKey());
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to ARIA init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.roundKeys == null) goto L18;
        if (r101 > (r100.length - 16)) goto L16;
        if (r103 > (r102.length - 16)) goto L14;
        byte[] r104 = new byte[16];
        System.arraycopy(r100, r101, r104, 0, 16);
        int r105 = this.roundKeys.length - 3;
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L11;
        int r107 = r106 + 1;
        FO(r104, this.roundKeys[r106]);
        FE(r104, this.roundKeys[r107]);
        r106 = r107 + 1;
        goto L9
    L11:
        int r108 = r106 + 1;
        FO(r104, this.roundKeys[r106]);
        xor(r104, this.roundKeys[r108]);
        SL2(r104);
        xor(r104, this.roundKeys[r108 + 1]);
        System.arraycopy(r104, 0, r102, r103, 16);
        return 16;
    L14:
        throw new OutputLengthException("output buffer too short");
    L16:
        throw new DataLengthException("input buffer too short");
    L18:
        throw new IllegalStateException("ARIA engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
