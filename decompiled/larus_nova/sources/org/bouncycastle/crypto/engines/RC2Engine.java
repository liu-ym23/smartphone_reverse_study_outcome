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
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.signers.PSSSigner;

/* JADX INFO: loaded from: classes42.dex */
public class RC2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 8;
    private static byte[] piTable;
    private boolean encrypting;
    private int[] workingKey;

    static {
        piTable = new byte[]{-39, 120, -7, -60, 25, -35, -75, -19, 40, -23, -3, 121, 74, -96, -40, -99, -58, 126, 55, -125, 43, 118, 83, -114, 98, 76, 100, -120, 68, -117, -5, -94, 23, -102, 89, -11, -121, -77, 79, 19, 97, 69, 109, -115, 9, -127, 125, 50, -67, -113, 64, -21, -122, -73, 123, 11, -16, -107, 33, 34, 92, 107, 78, -126, 84, -42, 101, -109, -50, 96, -78, 28, 115, 86, -64, 20, -89, -116, -15, -36, 18, 117, -54, 31, 59, -66, -28, -47, 66, Base64.padSymbol, -44, 48, -93, 60, -74, 38, 111, -65, 14, -38, 70, 105, 7, 87, 39, -14, 29, -101, PSSSigner.TRAILER_IMPLICIT, -108, 67, 3, -8, 17, -57, -10, -112, -17, 62, -25, 6, -61, -43, 47, -56, 102, 30, -41, 8, -24, -22, -34, ByteCompanionObject.MIN_VALUE, 82, -18, -9, -124, -86, 114, -84, 53, 77, 106, 42, -106, 26, -46, 113, 90, 21, 73, 116, 75, -97, -48, 94, 4, 24, -92, -20, -62, -32, 65, 110, 15, 81, -53, -52, 36, -111, -81, 80, -95, -12, 112, 57, -103, 124, 58, -123, 35, -72, -76, 122, -4, 2, 54, 91, 37, 85, -105, 49, 45, 93, -6, -104, -29, -118, -110, -82, 5, -33, 41, 16, 103, 108, -70, -55, -45, 0, -26, -49, -31, -98, -88, 44, 99, 22, 1, 63, 88, -30, -119, -87, HTTP.CR, 56, 52, 27, -85, 51, -1, -80, -69, 72, 12, 95, -71, -79, -51, 46, -59, -13, -37, 71, -27, -91, -100, 119, 10, -90, 32, 104, -2, ByteCompanionObject.MAX_VALUE, -63, -83};
    }

    public RC2Engine() {
    }

    private void decryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = ((r110[r111 + 7] & UByte.MAX_VALUE) << 8) + (r110[r111 + 6] & UByte.MAX_VALUE);
        int r101 = ((r110[r111 + 5] & UByte.MAX_VALUE) << 8) + (r110[r111 + 4] & UByte.MAX_VALUE);
        int r102 = ((r110[r111 + 3] & UByte.MAX_VALUE) << 8) + (r110[r111 + 2] & UByte.MAX_VALUE);
        int r103 = ((r110[r111 + 1] & UByte.MAX_VALUE) << 8) + (r110[r111 + 0] & UByte.MAX_VALUE);
        int r114 = 60;
    L4:
        if (r114 < 44) goto L6;
        r100 = rotateWordLeft(r100, 11) - ((((~r101) & r103) + (r102 & r101)) + this.workingKey[r114 + 3]);
        r101 = rotateWordLeft(r101, 13) - ((((~r102) & r100) + (r103 & r102)) + this.workingKey[r114 + 2]);
        r102 = rotateWordLeft(r102, 14) - ((((~r103) & r101) + (r100 & r103)) + this.workingKey[r114 + 1]);
        r103 = rotateWordLeft(r103, 15) - ((((~r100) & r102) + (r101 & r100)) + this.workingKey[r114]);
        r114 = r114 - 4;
        goto L4
    L6:
        int[] r115 = this.workingKey;
        int r104 = r100 - r115[r101 & 63];
        int r105 = r101 - r115[r102 & 63];
        int r106 = r102 - r115[r103 & 63];
        int r107 = r103 - r115[r104 & 63];
        int r116 = 40;
    L8:
        if (r116 < 20) goto L10;
        r104 = rotateWordLeft(r104, 11) - ((((~r105) & r107) + (r106 & r105)) + this.workingKey[r116 + 3]);
        r105 = rotateWordLeft(r105, 13) - ((((~r106) & r104) + (r107 & r106)) + this.workingKey[r116 + 2]);
        r106 = rotateWordLeft(r106, 14) - ((((~r107) & r105) + (r104 & r107)) + this.workingKey[r116 + 1]);
        r107 = rotateWordLeft(r107, 15) - ((((~r104) & r106) + (r105 & r104)) + this.workingKey[r116]);
        r116 = r116 - 4;
        goto L8
    L10:
        int[] r117 = this.workingKey;
        int r108 = r104 - r117[r105 & 63];
        int r109 = r105 - r117[r106 & 63];
        int r118 = r106 - r117[r107 & 63];
        int r119 = r107 - r117[r108 & 63];
        int r120 = 16;
    L11:
        if (r120 < 0) goto L13;
        r108 = rotateWordLeft(r108, 11) - ((((~r109) & r119) + (r118 & r109)) + this.workingKey[r120 + 3]);
        r109 = rotateWordLeft(r109, 13) - ((((~r118) & r108) + (r119 & r118)) + this.workingKey[r120 + 2]);
        r118 = rotateWordLeft(r118, 14) - ((((~r119) & r109) + (r108 & r119)) + this.workingKey[r120 + 1]);
        r119 = rotateWordLeft(r119, 15) - ((((~r108) & r118) + (r109 & r108)) + this.workingKey[r120]);
        r120 = r120 - 4;
        goto L11
    L13:
        r112[r113 + 0] = (byte) r119;
        r112[r113 + 1] = (byte) (r119 >> 8);
        r112[r113 + 2] = (byte) r118;
        r112[r113 + 3] = (byte) (r118 >> 8);
        r112[r113 + 4] = (byte) r109;
        r112[r113 + 5] = (byte) (r109 >> 8);
        r112[r113 + 6] = (byte) r108;
        r112[r113 + 7] = (byte) (r108 >> 8);
    }

    private void encryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = ((r110[r111 + 7] & UByte.MAX_VALUE) << 8) + (r110[r111 + 6] & UByte.MAX_VALUE);
        int r101 = ((r110[r111 + 5] & UByte.MAX_VALUE) << 8) + (r110[r111 + 4] & UByte.MAX_VALUE);
        int r102 = ((r110[r111 + 3] & UByte.MAX_VALUE) << 8) + (r110[r111 + 2] & UByte.MAX_VALUE);
        int r103 = 0;
        int r104 = ((r110[r111 + 1] & UByte.MAX_VALUE) << 8) + (r110[r111 + 0] & UByte.MAX_VALUE);
    L4:
        if (r103 > 16) goto L6;
        r104 = rotateWordLeft(((r104 + ((~r100) & r102)) + (r101 & r100)) + this.workingKey[r103], 1);
        r102 = rotateWordLeft(((r102 + ((~r104) & r101)) + (r100 & r104)) + this.workingKey[r103 + 1], 2);
        r101 = rotateWordLeft(((r101 + ((~r102) & r100)) + (r104 & r102)) + this.workingKey[r103 + 2], 3);
        r100 = rotateWordLeft(((r100 + ((~r101) & r104)) + (r102 & r101)) + this.workingKey[r103 + 3], 5);
        r103 = r103 + 4;
        goto L4
    L6:
        int[] r114 = this.workingKey;
        int r105 = r104 + r114[r100 & 63];
        int r106 = r102 + r114[r105 & 63];
        int r107 = r101 + r114[r106 & 63];
        int r108 = r100 + r114[r107 & 63];
        int r115 = 20;
    L8:
        if (r115 > 40) goto L10;
        r105 = rotateWordLeft(((r105 + ((~r108) & r106)) + (r107 & r108)) + this.workingKey[r115], 1);
        r106 = rotateWordLeft(((r106 + ((~r105) & r107)) + (r108 & r105)) + this.workingKey[r115 + 1], 2);
        r107 = rotateWordLeft(((r107 + ((~r106) & r108)) + (r105 & r106)) + this.workingKey[r115 + 2], 3);
        r108 = rotateWordLeft(((r108 + ((~r107) & r105)) + (r106 & r107)) + this.workingKey[r115 + 3], 5);
        r115 = r115 + 4;
        goto L8
    L10:
        int[] r116 = this.workingKey;
        int r109 = r105 + r116[r108 & 63];
        int r117 = r106 + r116[r109 & 63];
        int r118 = r107 + r116[r117 & 63];
        int r119 = r108 + r116[r118 & 63];
        int r120 = 44;
    L12:
        if (r120 >= 64) goto L14;
        r109 = rotateWordLeft(((r109 + ((~r119) & r117)) + (r118 & r119)) + this.workingKey[r120], 1);
        r117 = rotateWordLeft(((r117 + ((~r109) & r118)) + (r119 & r109)) + this.workingKey[r120 + 1], 2);
        r118 = rotateWordLeft(((r118 + ((~r117) & r119)) + (r109 & r117)) + this.workingKey[r120 + 2], 3);
        r119 = rotateWordLeft(((r119 + ((~r118) & r109)) + (r117 & r118)) + this.workingKey[r120 + 3], 5);
        r120 = r120 + 4;
        goto L12
    L14:
        r112[r113 + 0] = (byte) r109;
        r112[r113 + 1] = (byte) (r109 >> 8);
        r112[r113 + 2] = (byte) r117;
        r112[r113 + 3] = (byte) (r117 >> 8);
        r112[r113 + 4] = (byte) r118;
        r112[r113 + 5] = (byte) (r118 >> 8);
        r112[r113 + 6] = (byte) r119;
        r112[r113 + 7] = (byte) (r119 >> 8);
    }

    private int[] generateWorkingKey(byte[] r100, int r110) {
        int[] r101 = new int[128];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 == r100.length) goto L6;
        r101[r103] = r100[r103] & 255;
        r103 = r103 + 1;
        goto L4
    L6:
        int r104 = r100.length;
        if (r104 >= 128) goto L13;
        int r105 = r101[r104 - 1];
        int r106 = 0;
    L9:
        int r107 = r106 + 1;
        r105 = piTable[(r105 + r101[r106]) & 255] & UByte.MAX_VALUE;
        int r108 = r104 + 1;
        r101[r104] = r105;
        if (r108 >= 128) goto L13;
        r104 = r108;
        r106 = r107;
    L13:
        int r109 = (r110 + 7) >> 3;
        int r111 = 128 - r109;
        int r112 = piTable[(255 >> ((-r110) & 7)) & r101[r111]] & UByte.MAX_VALUE;
        r101[r111] = r112;
        int r113 = r111 - 1;
    L14:
        if (r113 < 0) goto L16;
        r112 = piTable[r112 ^ r101[r113 + r109]] & UByte.MAX_VALUE;
        r101[r113] = r112;
        r113 = r113 - 1;
        goto L14
    L16:
        int[] r114 = new int[64];
    L17:
        if (r102 == 64) goto L19;
        int r115 = r102 * 2;
        r114[r102] = r101[r115] + (r101[r115 + 1] << 8);
        r102 = r102 + 1;
        goto L17
    L19:
        return r114;
    }

    private int rotateWordLeft(int r100, int r101) {
        int r102 = r100 & 65535;
        int r103 = r102 << r101;
        return (r102 >> (16 - r101)) | r103;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC2";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        this.encrypting = r100;
        if ((r101 instanceof RC2Parameters) == false) goto L6;
        RC2Parameters r102 = (RC2Parameters) r101;
        this.workingKey = generateWorkingKey(r102.getKey(), r102.getEffectiveKeyBits());
        return;
    L6:
        if ((r101 instanceof KeyParameter) == false) goto L10;
        byte[] r103 = ((KeyParameter) r101).getKey();
        this.workingKey = generateWorkingKey(r103, r103.length * 8);
        return;
    L10:
        throw new IllegalArgumentException("invalid parameter passed to RC2 init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public final int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this.workingKey == null) goto L19;
        if ((r101 + 8) > r100.length) goto L17;
        if ((r103 + 8) > r102.length) goto L15;
        if (this.encrypting == false) goto L11;
        encryptBlock(r100, r101, r102, r103);
        return 8;
    L11:
        decryptBlock(r100, r101, r102, r103);
        return 8;
    L15:
        throw new OutputLengthException("output buffer too short");
    L17:
        throw new DataLengthException("input buffer too short");
    L19:
        throw new IllegalStateException("RC2 engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
