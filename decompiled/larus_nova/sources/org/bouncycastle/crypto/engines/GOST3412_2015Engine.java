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
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3412_2015Engine implements BlockCipher {
    protected static final int BLOCK_SIZE = 16;
    private static final byte[] PI = null;
    private static final byte[] inversePI = null;
    private int KEY_LENGTH;
    private int SUB_LENGTH;
    private byte[][] _gf_mul;
    private boolean forEncryption;
    private final byte[] lFactors;
    private byte[][] subKeys;

    static {
        PI = new byte[]{-4, -18, -35, 17, -49, 110, 49, 22, -5, -60, -6, -38, 35, -59, 4, 77, -23, 119, -16, -37, -109, 46, -103, -70, 23, 54, -15, -69, 20, -51, 95, -63, -7, 24, 101, 90, -30, 92, -17, 33, -127, 28, 60, 66, -117, 1, -114, 79, 5, -124, 2, -82, -29, 106, -113, -96, 6, 11, -19, -104, ByteCompanionObject.MAX_VALUE, -44, -45, 31, -21, 52, 44, 81, -22, -56, 72, -85, -14, 42, 104, -94, -3, 58, -50, -52, -75, 112, 14, 86, 8, 12, 118, 18, -65, 114, 19, 71, -100, -73, 93, -121, 21, -95, -106, 41, 16, 123, -102, -57, -13, -111, 120, 111, -99, -98, -78, -79, 50, 117, 25, Base64.padSymbol, -1, 53, -118, 126, 109, 84, -58, ByteCompanionObject.MIN_VALUE, -61, -67, HTTP.CR, 87, -33, -11, 36, -87, 62, -88, 67, -55, -41, 121, -42, -10, 124, 34, -71, 3, -32, 15, -20, -34, 122, -108, -80, PSSSigner.TRAILER_IMPLICIT, -36, -24, 40, 80, 78, 51, 10, 74, -89, -105, 96, 115, 30, 0, 98, 68, 26, -72, 56, -126, 100, -97, 38, 65, -83, 69, 70, -110, 39, 94, 85, 47, -116, -93, -91, 125, 105, -43, -107, 59, 7, 88, -77, 64, -122, -84, 29, -9, 48, 55, 107, -28, -120, -39, -25, -119, -31, 27, -125, 73, 76, 63, -8, -2, -115, 83, -86, -112, -54, -40, -123, 97, 32, 113, 103, -92, 45, 43, 9, 91, -53, -101, 37, -48, -66, -27, 108, 82, 89, -90, 116, -46, -26, -12, -76, -64, -47, 102, -81, -62, 57, 75, 99, -74};
        inversePI = new byte[]{-91, 45, 50, -113, 14, 48, 56, -64, 84, -26, -98, 57, 85, 126, 82, -111, 100, 3, 87, 90, 28, 96, 7, 24, 33, 114, -88, -47, 41, -58, -92, 63, -32, 39, -115, 12, -126, -22, -82, -76, -102, 99, 73, -27, 66, -28, 21, -73, -56, 6, 112, -99, 65, 117, 25, -55, -86, -4, 77, -65, 42, 115, -124, -43, -61, -81, 43, -122, -89, -79, -78, 91, 70, -45, -97, -3, -44, 15, -100, 47, -101, 67, -17, -39, 121, -74, 83, ByteCompanionObject.MAX_VALUE, -63, -16, 35, -25, 37, 94, -75, 30, -94, -33, -90, -2, -84, 34, -7, -30, 74, PSSSigner.TRAILER_IMPLICIT, 53, -54, -18, 120, 5, 107, 81, -31, 89, -93, -14, 113, 86, 17, 106, -119, -108, 101, -116, -69, 119, 60, 123, 40, -85, -46, 49, -34, -60, 95, -52, -49, 118, 44, -72, -40, 46, 54, -37, 105, -77, 20, -107, -66, 98, -95, 59, 22, 102, -23, 92, 108, 109, -83, 55, 97, 75, -71, -29, -70, -15, -96, -123, -125, -38, 71, -59, -80, 51, -6, -106, 111, 110, -62, -10, 80, -1, 93, -87, -114, 23, 27, -105, 125, -20, 88, -9, 31, -5, 124, 9, HTTP.CR, 122, 103, 69, -121, -36, -24, 79, 29, 78, 4, -21, -8, -13, 62, Base64.padSymbol, -67, -118, -120, -35, -51, 11, 19, -104, 2, -109, ByteCompanionObject.MIN_VALUE, -112, -48, 36, 52, -53, -19, -12, -50, -103, 16, 68, 64, -110, 58, 1, 38, 18, 26, 72, 104, -11, -127, -117, -57, -42, 32, 10, 8, 0, 76, -41, 116};
    }

    public GOST3412_2015Engine() {
        this.lFactors = new byte[]{-108, 32, -123, 16, -62, -64, 1, -5, 1, -64, -62, 16, -123, 32, -108, 1};
        this.KEY_LENGTH = 32;
        this.SUB_LENGTH = 32 / 2;
        this.subKeys = null;
        this._gf_mul = init_gf256_mul_table();
    }

    private void C(byte[] r100, int r101) {
        Arrays.clear(r100);
        r100[15] = (byte) r101;
        L(r100);
    }

    private void F(byte[] r100, byte[] r101, byte[] r102) {
        byte[] r103 = LSX(r100, r101);
        X(r103, r102);
        System.arraycopy(r101, 0, r102, 0, this.SUB_LENGTH);
        System.arraycopy(r103, 0, r101, 0, this.SUB_LENGTH);
    }

    private void GOST3412_2015Func(byte[] r100, int r101, byte[] r102, int r103) {
        byte[] r104 = new byte[16];
        System.arraycopy(r100, r101, r104, 0, 16);
        int r105 = 9;
        if (this.forEncryption == false) goto L8;
        int r106 = 0;
    L5:
        if (r106 >= 9) goto L7;
        r104 = Arrays.copyOf(LSX(this.subKeys[r106], r104), 16);
        r106 = r106 + 1;
        goto L5
    L7:
        X(r104, this.subKeys[9]);
    L12:
        System.arraycopy(r104, 0, r102, r103, 16);
        return;
    L8:
        byte[][] r107 = this.subKeys;
        if (r105 <= 0) goto L11;
        r104 = Arrays.copyOf(XSL(r107[r105], r104), 16);
        r105 = r105 - 1;
        goto L8
    L11:
        X(r104, r107[0]);
        goto L12
    }

    private void L(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 16) goto L6;
        R(r100);
        r101 = r101 + 1;
        goto L4
    }

    private byte[] LSX(byte[] r100, byte[] r101) {
        byte[] r102 = Arrays.copyOf(r100, r100.length);
        X(r102, r101);
        S(r102);
        L(r102);
        return r102;
    }

    private void R(byte[] r100) {
        byte r101 = l(r100);
        System.arraycopy(r100, 0, r100, 1, 15);
        r100[0] = r101;
    }

    private void S(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r100[r101] = PI[unsignedByte(r100[r101])];
        r101 = r101 + 1;
        goto L4
    }

    private void X(byte[] r100, byte[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r100[r102] = (byte) (r100[r102] ^ r101[r102]);
        r102 = r102 + 1;
        goto L4
    }

    private byte[] XSL(byte[] r100, byte[] r101) {
        byte[] r102 = Arrays.copyOf(r100, r100.length);
        X(r102, r101);
        inverseL(r102);
        inverseS(r102);
        return r102;
    }

    private void generateSubKeys(byte[] r110) {
        if (r110.length != this.KEY_LENGTH) goto L21;
        this.subKeys = new byte[10][];
        int r100 = 0;
    L5:
        if (r100 >= 10) goto L7;
        this.subKeys[r100] = new byte[this.SUB_LENGTH];
        r100 = r100 + 1;
        goto L5
    L7:
        int r101 = this.SUB_LENGTH;
        byte[] r102 = new byte[r101];
        byte[] r103 = new byte[r101];
        int r104 = 0;
    L8:
        int r105 = this.SUB_LENGTH;
        if (r104 >= r105) goto L11;
        byte[][] r106 = this.subKeys;
        byte[] r107 = r106[0];
        byte r108 = r110[r104];
        r102[r104] = r108;
        r107[r104] = r108;
        byte[] r109 = r106[1];
        byte r111 = r110[r105 + r104];
        r103[r104] = r111;
        r109[r104] = r111;
        r104 = r104 + 1;
        goto L8
    L11:
        byte[] r112 = new byte[r105];
        int r113 = 1;
    L13:
        if (r113 >= 5) goto L19;
        int r114 = 1;
    L16:
        if (r114 > 8) goto L18;
        C(r112, ((r113 - 1) * 8) + r114);
        F(r112, r102, r103);
        r114 = r114 + 1;
        goto L16
    L18:
        int r115 = r113 * 2;
        System.arraycopy(r102, 0, this.subKeys[r115], 0, this.SUB_LENGTH);
        System.arraycopy(r103, 0, this.subKeys[r115 + 1], 0, this.SUB_LENGTH);
        r113 = r113 + 1;
        goto L13
    L19:
        return;
    L21:
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    private static byte[][] init_gf256_mul_table() {
        byte[][] r100 = new byte[256][];
        int r101 = 0;
    L3:
        if (r101 >= 256) goto L8;
        r100[r101] = new byte[256];
        int r102 = 0;
    L5:
        if (r102 >= 256) goto L7;
        r100[r101][r102] = kuz_mul_gf256_slow((byte) r101, (byte) r102);
        r102 = r102 + 1;
        goto L5
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        return r100;
    }

    private void inverseL(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= 16) goto L6;
        inverseR(r100);
        r101 = r101 + 1;
        goto L4
    }

    private void inverseR(byte[] r100) {
        byte[] r101 = new byte[16];
        System.arraycopy(r100, 1, r101, 0, 15);
        r101[15] = r100[0];
        byte r102 = l(r101);
        System.arraycopy(r100, 1, r100, 0, 15);
        r100[15] = r102;
    }

    private void inverseS(byte[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= r100.length) goto L6;
        r100[r101] = inversePI[unsignedByte(r100[r101])];
        r101 = r101 + 1;
        goto L4
    }

    private static byte kuz_mul_gf256_slow(byte r100, byte r101) {
        byte r102 = 0;
        byte r103 = 0;
    L4:
        if (r102 >= 8) goto L14;
        if (r100 == 0) goto L14;
        if (r101 == 0) goto L14;
        if ((r101 & 1) == 0) goto L10;
        r103 = (byte) (r103 ^ r100);
    L10:
        byte r104 = (byte) (r100 & ByteCompanionObject.MIN_VALUE);
        r100 = (byte) (r100 << 1);
        if (r104 == 0) goto L13;
        r100 = (byte) (r100 ^ 195);
    L13:
        r101 = (byte) (r101 >> 1);
        r102 = (byte) (r102 + 1);
    L14:
        return r103;
    }

    private byte l(byte[] r100) {
        byte r101 = r100[15];
        int r102 = 14;
    L3:
        if (r102 < 0) goto L5;
        r101 = (byte) (r101 ^ this._gf_mul[unsignedByte(r100[r102])][unsignedByte(this.lFactors[r102])]);
        r102 = r102 - 1;
        goto L3
    L5:
        return r101;
    }

    private int unsignedByte(byte r100) {
        return r100 & UByte.MAX_VALUE;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "GOST3412_2015";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof KeyParameter) == false) goto L5;
        this.forEncryption = r100;
        generateSubKeys(((KeyParameter) r101).getKey());
        return;
    L5:
        if (r101 != null) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("invalid parameter passed to GOST3412_2015 init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.subKeys == null) goto L15;
        if ((r101 + 16) > r100.length) goto L13;
        if ((r103 + 16) > r102.length) goto L11;
        GOST3412_2015Func(r100, r101, r102, r103);
        return 16;
    L11:
        throw new OutputLengthException("output buffer too short");
    L13:
        throw new DataLengthException("input buffer too short");
    L15:
        throw new IllegalStateException("GOST3412_2015 engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
