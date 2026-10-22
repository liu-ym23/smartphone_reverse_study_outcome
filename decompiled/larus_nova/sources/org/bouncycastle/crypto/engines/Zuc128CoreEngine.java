package org.bouncycastle.crypto.engines;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Memoable;

/* JADX INFO: loaded from: classes42.dex */
public class Zuc128CoreEngine implements StreamCipher, Memoable {
    private static final short[] EK_d = null;
    private static final byte[] S0 = null;
    private static final byte[] S1 = null;
    private final int[] BRC;
    private final int[] F;
    private final int[] LFSR;
    private final byte[] keyStream;
    private int theIndex;
    private int theIterations;
    private Zuc128CoreEngine theResetState;

    static {
        S0 = new byte[]{62, 114, 91, 71, -54, -32, 0, 51, 4, -47, 84, -104, 9, -71, 109, -53, 123, 27, -7, 50, -81, -99, 106, -91, -72, 45, -4, 29, 8, 83, 3, -112, 77, 78, -124, -103, -28, -50, -39, -111, -35, -74, -123, 72, -117, 41, 110, -84, -51, -63, -8, 30, 115, 67, 105, -58, -75, -67, -3, 57, 99, 32, -44, 56, 118, 125, -78, -89, -49, -19, 87, -59, -13, 44, -69, 20, 33, 6, 85, -101, -29, -17, 94, 49, 79, ByteCompanionObject.MAX_VALUE, 90, -92, HTTP.CR, -126, 81, 73, 95, -70, 88, 28, 74, 22, -43, 23, -88, -110, 36, 31, -116, -1, -40, -82, 46, 1, -45, -83, 59, 75, -38, 70, -21, -55, -34, -102, -113, -121, -41, 58, ByteCompanionObject.MIN_VALUE, 111, 47, -56, -79, -76, 55, -9, 10, 34, 19, 40, 124, -52, 60, -119, -57, -61, -106, 86, 7, -65, 126, -16, 11, 43, -105, 82, 53, 65, 121, 97, -90, 76, 16, -2, PSSSigner.TRAILER_IMPLICIT, 38, -107, -120, -118, -80, -93, -5, -64, 24, -108, -14, -31, -27, -23, 93, -48, -36, 17, 102, 100, 92, -20, 89, 66, 117, 18, -11, 116, -100, -86, 35, 14, -122, -85, -66, 42, 2, -25, 103, -26, 68, -94, 108, -62, -109, -97, -15, -10, -6, 54, -46, 80, 104, -98, 98, 113, 21, Base64.padSymbol, -42, 64, -60, -30, 15, -114, -125, 119, 107, 37, 5, 63, 12, 48, -22, 112, -73, -95, -24, -87, 101, -115, 39, 26, -37, -127, -77, -96, -12, 69, 122, 25, -33, -18, 120, 52, 96};
        S1 = new byte[]{85, -62, 99, 113, 59, -56, 71, -122, -97, 60, -38, 91, 41, -86, -3, 119, -116, -59, -108, 12, -90, 26, 19, 0, -29, -88, 22, 114, 64, -7, -8, 66, 68, 38, 104, -106, -127, -39, 69, 62, 16, 118, -58, -89, -117, 57, 67, -31, 58, -75, 86, 42, -64, 109, -77, 5, 34, 102, -65, -36, 11, -6, 98, 72, -35, 32, 17, 6, 54, -55, -63, -49, -10, 39, 82, -69, 105, -11, -44, -121, ByteCompanionObject.MAX_VALUE, -124, 76, -46, -100, 87, -92, PSSSigner.TRAILER_IMPLICIT, 79, -102, -33, -2, -42, -115, 122, -21, 43, 83, -40, 92, -95, 20, 23, -5, 35, -43, 125, 48, 103, 115, 8, 9, -18, -73, 112, 63, 97, -78, 25, -114, 78, -27, 75, -109, -113, 93, -37, -87, -83, -15, -82, 46, -53, HTTP.CR, -4, -12, 45, 70, 110, 29, -105, -24, -47, -23, 77, 55, -91, 117, 94, -125, -98, -85, -126, -99, -71, 28, -32, -51, 73, -119, 1, -74, -67, 88, 36, -94, 95, 56, 120, -103, 21, -112, 80, -72, -107, -28, -48, -111, -57, -50, -19, 15, -76, 111, -96, -52, -16, 2, 74, 121, -61, -34, -93, -17, -22, 81, -26, 107, 24, -20, 27, 44, ByteCompanionObject.MIN_VALUE, -9, 116, -25, -1, 33, 90, 106, 84, 30, 65, 49, -110, 53, -60, 51, 7, 10, -70, 126, 14, 52, -120, -79, -104, 124, -13, Base64.padSymbol, 96, 108, 123, -54, -45, 31, 50, 101, 4, 40, 100, -66, -123, -101, 47, 89, -118, -41, -80, 37, -84, -81, 18, 3, -30, -14};
        EK_d = new short[]{17623, 9916, 25195, 4958, 22409, 13794, 28981, 2479, 19832, 12051, 27588, 6897, 24102, 15437, 30874, 18348};
    }

    public Zuc128CoreEngine() {
        this.LFSR = new int[16];
        this.F = new int[2];
        this.BRC = new int[4];
        this.keyStream = new byte[4];
    }

    public Zuc128CoreEngine(Zuc128CoreEngine r100) {
        this.LFSR = new int[16];
        this.F = new int[2];
        this.BRC = new int[4];
        this.keyStream = new byte[4];
        reset(r100);
    }

    private int AddM(int r100, int r101) {
        int r102 = r100 + r101;
        return (Integer.MAX_VALUE & r102) + (r102 >>> 31);
    }

    private void BitReorganization() {
        int[] r100 = this.BRC;
        int[] r101 = this.LFSR;
        r100[0] = ((r101[15] & 2147450880) << 1) | (r101[14] & 65535);
        r100[1] = ((r101[11] & 65535) << 16) | (r101[9] >>> 15);
        r100[2] = ((r101[7] & 65535) << 16) | (r101[5] >>> 15);
        int r102 = (r101[2] & 65535) << 16;
        r100[3] = (r101[0] >>> 15) | r102;
    }

    private static int L1(int r100) {
        int r101 = ((ROT(r100, 2) ^ r100) ^ ROT(r100, 10)) ^ ROT(r100, 18);
        return ROT(r100, 24) ^ r101;
    }

    private static int L2(int r100) {
        int r101 = ((ROT(r100, 8) ^ r100) ^ ROT(r100, 14)) ^ ROT(r100, 22);
        return ROT(r100, 30) ^ r101;
    }

    private void LFSRWithInitialisationMode(int r110) {
        int r100 = this.LFSR[0];
        int r111 = AddM(AddM(AddM(AddM(AddM(AddM(r100, MulByPow2(r100, 8)), MulByPow2(this.LFSR[4], 20)), MulByPow2(this.LFSR[10], 21)), MulByPow2(this.LFSR[13], 17)), MulByPow2(this.LFSR[15], 15)), r110);
        int[] r101 = this.LFSR;
        r101[0] = r101[1];
        r101[1] = r101[2];
        r101[2] = r101[3];
        r101[3] = r101[4];
        r101[4] = r101[5];
        r101[5] = r101[6];
        r101[6] = r101[7];
        r101[7] = r101[8];
        r101[8] = r101[9];
        r101[9] = r101[10];
        r101[10] = r101[11];
        r101[11] = r101[12];
        r101[12] = r101[13];
        r101[13] = r101[14];
        r101[14] = r101[15];
        r101[15] = r111;
    }

    private void LFSRWithWorkMode() {
        int r100 = this.LFSR[0];
        int r101 = AddM(AddM(AddM(AddM(AddM(r100, MulByPow2(r100, 8)), MulByPow2(this.LFSR[4], 20)), MulByPow2(this.LFSR[10], 21)), MulByPow2(this.LFSR[13], 17)), MulByPow2(this.LFSR[15], 15));
        int[] r102 = this.LFSR;
        r102[0] = r102[1];
        r102[1] = r102[2];
        r102[2] = r102[3];
        r102[3] = r102[4];
        r102[4] = r102[5];
        r102[5] = r102[6];
        r102[6] = r102[7];
        r102[7] = r102[8];
        r102[8] = r102[9];
        r102[9] = r102[10];
        r102[10] = r102[11];
        r102[11] = r102[12];
        r102[12] = r102[13];
        r102[13] = r102[14];
        r102[14] = r102[15];
        r102[15] = r101;
    }

    private static int MAKEU31(byte r100, short r101, byte r102) {
        return (((r100 & UByte.MAX_VALUE) << 23) | ((r101 & 65535) << 8)) | (r102 & UByte.MAX_VALUE);
    }

    private static int MAKEU32(byte r100, byte r101, byte r102, byte r103) {
        return ((((r100 & UByte.MAX_VALUE) << 24) | ((r101 & UByte.MAX_VALUE) << 16)) | ((r102 & UByte.MAX_VALUE) << 8)) | (r103 & UByte.MAX_VALUE);
    }

    private static int MulByPow2(int r100, int r101) {
        int r102 = r100 << r101;
        return ((r100 >>> (31 - r101)) | r102) & Integer.MAX_VALUE;
    }

    public static int ROT(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (32 - r101)) | r102;
    }

    public static void encode32be(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) (r100 >> 24);
        r101[r102 + 1] = (byte) (r100 >> 16);
        r101[r102 + 2] = (byte) (r100 >> 8);
        r101[r102 + 3] = (byte) r100;
    }

    private void makeKeyStream() {
        encode32be(makeKeyStreamWord(), this.keyStream, 0);
    }

    private void setKeyAndIV(byte[] r100, byte[] r101) {
        setKeyAndIV(this.LFSR, r100, r101);
        int[] r102 = this.F;
        r102[0] = 0;
        r102[1] = 0;
        int r103 = 32;
    L3:
        BitReorganization();
        if (r103 <= 0) goto L6;
        LFSRWithInitialisationMode(F() >>> 1);
        r103 = r103 - 1;
        goto L3
    L6:
        F();
        LFSRWithWorkMode();
    }

    public int F() {
        int[] r100 = this.BRC;
        int r101 = r100[0];
        int[] r102 = this.F;
        int r103 = r102[0];
        int r104 = r102[1];
        int r105 = (r101 ^ r103) + r104;
        int r106 = r103 + r100[1];
        int r107 = r100[2] ^ r104;
        int r108 = L1((r106 << 16) | (r107 >>> 16));
        int r109 = L2((r107 << 16) | (r106 >>> 16));
        int[] r110 = this.F;
        byte[] r111 = S0;
        byte r112 = r111[r108 >>> 24];
        byte[] r113 = S1;
        r110[0] = MAKEU32(r112, r113[(r108 >>> 16) & 255], r111[(r108 >>> 8) & 255], r113[r108 & 255]);
        this.F[1] = MAKEU32(r111[r109 >>> 24], r113[(r109 >>> 16) & 255], r111[(r109 >>> 8) & 255], r113[r109 & 255]);
        return r105;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new Zuc128CoreEngine(this);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "Zuc-128";
    }

    public int getMaxIterations() {
        return 2047;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean r100, CipherParameters r101) {
        byte[] r102 = null;
        if ((r101 instanceof ParametersWithIV) == false) goto L5;
        ParametersWithIV r103 = (ParametersWithIV) r101;
        byte[] r104 = r103.getIV();
        r101 = r103.getParameters();
    L7:
        if ((r101 instanceof KeyParameter) == false) goto L9;
        r102 = ((KeyParameter) r101).getKey();
    L9:
        this.theIndex = 0;
        this.theIterations = 0;
        setKeyAndIV(r102, r104);
        this.theResetState = (Zuc128CoreEngine) copy();
        return;
    L5:
        r104 = null;
        goto L7
    }

    public int makeKeyStreamWord() {
        int r100 = this.theIterations;
        this.theIterations = r100 + 1;
        if (r100 >= getMaxIterations()) goto L7;
        BitReorganization();
        int r101 = F() ^ this.BRC[3];
        LFSRWithWorkMode();
        return r101;
    L7:
        throw new IllegalStateException("Too much data processed by singleKey/IV");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        if (this.theResetState == null) goto L17;
        if ((r101 + r102) > r100.length) goto L15;
        if ((r104 + r102) > r103.length) goto L13;
        int r105 = 0;
    L9:
        if (r105 >= r102) goto L11;
        r103[r105 + r104] = returnByte(r100[r105 + r101]);
        r105 = r105 + 1;
        goto L9
    L11:
        return r102;
    L13:
        throw new OutputLengthException("output buffer too short");
    L15:
        throw new DataLengthException("input buffer too short");
    L17:
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        Zuc128CoreEngine r100 = this.theResetState;
        if (r100 == null) goto L6;
        reset(r100);
        return;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable r100) {
        Zuc128CoreEngine r101 = (Zuc128CoreEngine) r100;
        int[] r102 = r101.LFSR;
        int[] r103 = this.LFSR;
        System.arraycopy(r102, 0, r103, 0, r103.length);
        int[] r104 = r101.F;
        int[] r105 = this.F;
        System.arraycopy(r104, 0, r105, 0, r105.length);
        int[] r106 = r101.BRC;
        int[] r107 = this.BRC;
        System.arraycopy(r106, 0, r107, 0, r107.length);
        byte[] r108 = r101.keyStream;
        byte[] r109 = this.keyStream;
        System.arraycopy(r108, 0, r109, 0, r109.length);
        this.theIndex = r101.theIndex;
        this.theIterations = r101.theIterations;
        this.theResetState = r101;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte r100) {
        if (this.theIndex != 0) goto L5;
        makeKeyStream();
    L5:
        byte[] r101 = this.keyStream;
        int r102 = this.theIndex;
        byte r103 = (byte) (r100 ^ r101[r102]);
        this.theIndex = (r102 + 1) % 4;
        return r103;
    }

    public void setKeyAndIV(int[] r100, byte[] r101, byte[] r102) {
        if (r101 == null) goto L13;
        if (r101.length != 16) goto L13;
        if (r102 == null) goto L11;
        if (r102.length != 16) goto L11;
        int[] r103 = this.LFSR;
        byte r104 = r101[0];
        short[] r105 = EK_d;
        r103[0] = MAKEU31(r104, r105[0], r102[0]);
        this.LFSR[1] = MAKEU31(r101[1], r105[1], r102[1]);
        this.LFSR[2] = MAKEU31(r101[2], r105[2], r102[2]);
        this.LFSR[3] = MAKEU31(r101[3], r105[3], r102[3]);
        this.LFSR[4] = MAKEU31(r101[4], r105[4], r102[4]);
        this.LFSR[5] = MAKEU31(r101[5], r105[5], r102[5]);
        this.LFSR[6] = MAKEU31(r101[6], r105[6], r102[6]);
        this.LFSR[7] = MAKEU31(r101[7], r105[7], r102[7]);
        this.LFSR[8] = MAKEU31(r101[8], r105[8], r102[8]);
        this.LFSR[9] = MAKEU31(r101[9], r105[9], r102[9]);
        this.LFSR[10] = MAKEU31(r101[10], r105[10], r102[10]);
        this.LFSR[11] = MAKEU31(r101[11], r105[11], r102[11]);
        this.LFSR[12] = MAKEU31(r101[12], r105[12], r102[12]);
        this.LFSR[13] = MAKEU31(r101[13], r105[13], r102[13]);
        this.LFSR[14] = MAKEU31(r101[14], r105[14], r102[14]);
        this.LFSR[15] = MAKEU31(r101[15], r105[15], r102[15]);
        return;
    L11:
        throw new IllegalArgumentException("An IV of 16 bytes is needed");
    L13:
        throw new IllegalArgumentException("A key of 16 bytes is needed");
    }
}
