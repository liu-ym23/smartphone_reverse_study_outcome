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
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SM4Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int[] CK = null;
    private static final int[] FK = null;
    private static final byte[] Sbox = null;
    private final int[] X;

    /* JADX INFO: renamed from: rk, reason: collision with root package name */
    private int[] f525200rk;

    static {
        Sbox = new byte[]{-42, -112, -23, -2, -52, -31, Base64.padSymbol, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, ByteCompanionObject.MIN_VALUE, -33, -108, -6, 117, -113, 63, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, 14, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, HTTP.CR, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, PSSSigner.TRAILER_IMPLICIT, ByteCompanionObject.MAX_VALUE, 17, -39, 92, 65, 31, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};
        CK = new int[]{462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};
        FK = new int[]{-1548633402, 1453994832, 1736282519, -1301273892};
    }

    public SM4Engine() {
        this.X = new int[4];
    }

    private int F0(int[] r100, int r101) {
        int r102 = r100[0];
        int r103 = r100[1] ^ r100[2];
        return T((r100[3] ^ r103) ^ r101) ^ r102;
    }

    private int F1(int[] r100, int r101) {
        int r102 = r100[1];
        int r103 = r100[2] ^ r100[3];
        return T((r100[0] ^ r103) ^ r101) ^ r102;
    }

    private int F2(int[] r100, int r101) {
        int r102 = r100[2];
        int r103 = r100[3] ^ r100[0];
        return T((r100[1] ^ r103) ^ r101) ^ r102;
    }

    private int F3(int[] r100, int r101) {
        int r102 = r100[3];
        int r103 = r100[0] ^ r100[1];
        return T((r100[2] ^ r103) ^ r101) ^ r102;
    }

    private int L(int r100) {
        int r101 = ((rotateLeft(r100, 2) ^ r100) ^ rotateLeft(r100, 10)) ^ rotateLeft(r100, 18);
        return rotateLeft(r100, 24) ^ r101;
    }

    private int L_ap(int r100) {
        int r101 = rotateLeft(r100, 13) ^ r100;
        return rotateLeft(r100, 23) ^ r101;
    }

    private int T(int r100) {
        return L(tau(r100));
    }

    private int T_ap(int r100) {
        return L_ap(tau(r100));
    }

    private int[] expandKey(boolean r110, byte[] r111) {
        int[] r100 = new int[32];
        int r101 = 4;
        int r112 = Pack.bigEndianToInt(r111, 12);
        int[] r102 = {Pack.bigEndianToInt(r111, 0), Pack.bigEndianToInt(r111, 4), Pack.bigEndianToInt(r111, 8), r112};
        int r103 = r102[0];
        int[] r113 = FK;
        int r104 = r103 ^ r113[0];
        int r114 = r102[1] ^ r113[1];
        int r105 = r102[2] ^ r113[2];
        int r115 = r112 ^ r113[3];
        int[] r106 = {r104, r114, r105, r115};
        if (r110 == false) goto L7;
        int r116 = (r114 ^ r105) ^ r115;
        int[] r117 = CK;
        int r118 = T_ap(r116 ^ r117[0]) ^ r104;
        r100[0] = r118;
        int r119 = T_ap((r118 ^ (r106[2] ^ r106[3])) ^ r117[1]) ^ r106[1];
        r100[1] = r119;
        int r120 = T_ap((r119 ^ (r106[3] ^ r100[0])) ^ r117[2]) ^ r106[2];
        r100[2] = r120;
        r100[3] = T_ap((r120 ^ (r100[0] ^ r100[1])) ^ r117[3]) ^ r106[3];
    L5:
        if (r101 >= 32) goto L10;
        r100[r101] = r100[r101 - 4] ^ T_ap(((r100[r101 - 3] ^ r100[r101 - 2]) ^ r100[r101 - 1]) ^ CK[r101]);
        r101 = r101 + 1;
    L10:
        return r100;
    L7:
        int r121 = (r114 ^ r105) ^ r115;
        int[] r122 = CK;
        int r123 = T_ap(r121 ^ r122[0]) ^ r104;
        r100[31] = r123;
        int r124 = T_ap((r123 ^ (r106[2] ^ r106[3])) ^ r122[1]) ^ r106[1];
        r100[30] = r124;
        int r125 = T_ap((r124 ^ (r106[3] ^ r100[31])) ^ r122[2]) ^ r106[2];
        r100[29] = r125;
        r100[28] = T_ap((r125 ^ (r100[31] ^ r100[30])) ^ r122[3]) ^ r106[3];
        int r126 = 27;
    L8:
        if (r126 < 0) goto L10;
        r100[r126] = r100[r126 + 4] ^ T_ap(((r100[r126 + 3] ^ r100[r126 + 2]) ^ r100[r126 + 1]) ^ CK[31 - r126]);
        r126 = r126 - 1;
        goto L8
    }

    private int rotateLeft(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    private int tau(int r100) {
        byte[] r101 = Sbox;
        int r102 = r101[(r100 >> 24) & 255] & UByte.MAX_VALUE;
        int r103 = r101[(r100 >> 16) & 255] & UByte.MAX_VALUE;
        int r104 = r101[(r100 >> 8) & 255] & UByte.MAX_VALUE;
        return (r101[r100 & 255] & UByte.MAX_VALUE) | (((r102 << 24) | (r103 << 16)) | (r104 << 8));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "SM4";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof KeyParameter) == false) goto L11;
        byte[] r102 = ((KeyParameter) r101).getKey();
        if (r102.length != 16) goto L9;
        this.f525200rk = expandKey(r100, r102);
        return;
    L9:
        throw new IllegalArgumentException("SM4 requires a 128 bit key");
    L11:
        throw new IllegalArgumentException("invalid parameter passed to SM4 init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        if (this.f525200rk == null) goto L19;
        if ((r101 + 16) > r100.length) goto L17;
        if ((r110 + 16) > r102.length) goto L15;
        this.X[0] = Pack.bigEndianToInt(r100, r101);
        this.X[1] = Pack.bigEndianToInt(r100, r101 + 4);
        this.X[2] = Pack.bigEndianToInt(r100, r101 + 8);
        this.X[3] = Pack.bigEndianToInt(r100, r101 + 12);
        int r103 = 0;
    L10:
        if (r103 >= 32) goto L12;
        int[] r104 = this.X;
        r104[0] = F0(r104, this.f525200rk[r103]);
        int[] r105 = this.X;
        r105[1] = F1(r105, this.f525200rk[r103 + 1]);
        int[] r106 = this.X;
        r106[2] = F2(r106, this.f525200rk[r103 + 2]);
        int[] r107 = this.X;
        r107[3] = F3(r107, this.f525200rk[r103 + 3]);
        r103 = r103 + 4;
        goto L10
    L12:
        Pack.intToBigEndian(this.X[3], r102, r110);
        Pack.intToBigEndian(this.X[2], r102, r110 + 4);
        Pack.intToBigEndian(this.X[1], r102, r110 + 8);
        Pack.intToBigEndian(this.X[0], r102, r110 + 12);
        return 16;
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException("SM4 not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
