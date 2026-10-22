package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class SkipjackEngine implements BlockCipher {
    static final int BLOCK_SIZE = 8;
    static short[] ftable;
    private boolean encrypting;
    private int[] key0;
    private int[] key1;
    private int[] key2;
    private int[] key3;

    static {
        ftable = new short[]{163, 215, 9, 131, 248, 72, 246, 244, 179, 33, 21, 120, 153, 177, 175, 249, 231, 45, 77, 138, 206, 76, 202, 46, 82, 149, 217, 30, 78, 56, 68, 40, 10, 223, 2, 160, 23, 241, 96, 104, 18, 183, 122, 195, 233, 250, 61, 83, 150, 132, 107, 186, 242, 99, 154, 25, 124, 174, 229, 245, 247, 22, 106, 162, 57, 182, 123, 15, 193, 147, 129, 27, 238, 180, 26, 234, 208, 145, 47, 184, 85, 185, 218, 133, 63, 65, 191, 224, 90, 88, 128, 95, 102, 11, 216, 144, 53, 213, 192, 167, 51, 6, 101, 105, 69, 0, 148, 86, 109, 152, 155, 118, 151, 252, 178, 194, 176, 254, 219, 32, 225, 235, 214, 228, 221, 71, 74, 29, 66, 237, 158, 110, 73, 60, 205, 67, 39, 210, 7, 212, 222, 199, 103, 24, 137, 203, 48, 31, 141, 198, 143, 170, 200, 116, 220, 201, 93, 92, 49, 164, 112, 136, 97, 44, 159, 13, 43, 135, 80, 130, 84, 100, 38, 125, 3, 64, 52, 75, 28, 115, 209, 196, 253, 59, 204, 251, 127, 171, 230, 62, 91, 165, 173, 4, 35, 156, 20, 81, 34, 240, 41, 121, 113, 126, 255, 140, 14, 226, 12, 239, 188, 114, 117, 111, 55, 161, 236, 211, 142, 98, 139, 134, 16, 232, 8, 119, 17, 190, 146, 79, 36, 197, 50, 54, 157, 207, 243, 166, 187, 172, 94, 108, 169, 19, 87, 37, 181, 227, 189, 168, 58, 1, 5, 89, 42, 70};
    }

    public SkipjackEngine() {
    }

    private int g(int r100, int r101) {
        int r102 = (r101 >> 8) & 255;
        int r103 = r101 & 255;
        short[] r104 = ftable;
        int r105 = r102 ^ r104[this.key0[r100] ^ r103];
        int r106 = r103 ^ r104[this.key1[r100] ^ r105];
        int r107 = r105 ^ r104[this.key2[r100] ^ r106];
        int r108 = r104[this.key3[r100] ^ r107] ^ r106;
        return (r107 << 8) + r108;
    }

    private int h(int r100, int r101) {
        int r102 = r101 & 255;
        int r103 = (r101 >> 8) & 255;
        short[] r104 = ftable;
        int r105 = r102 ^ r104[this.key3[r100] ^ r103];
        int r106 = r103 ^ r104[this.key2[r100] ^ r105];
        int r107 = r105 ^ r104[this.key1[r100] ^ r106];
        return ((r104[this.key0[r100] ^ r107] ^ r106) << 8) + r107;
    }

    public int decryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = (r110[r111 + 0] << 8) + (r110[r111 + 1] & UByte.MAX_VALUE);
        int r101 = (r110[r111 + 2] << 8) + (r110[r111 + 3] & UByte.MAX_VALUE);
        int r102 = (r110[r111 + 4] << 8) + (r110[r111 + 5] & UByte.MAX_VALUE);
        int r103 = (r110[r111 + 6] << 8) + (r110[r111 + 7] & UByte.MAX_VALUE);
        int r114 = 31;
        int r104 = 0;
    L4:
        if (r104 >= 2) goto L12;
        int r105 = 0;
    L6:
        if (r105 >= 8) goto L8;
        int r106 = h(r114, r101);
        int r107 = (r102 ^ r106) ^ (r114 + 1);
        r114 = r114 - 1;
        r105 = r105 + 1;
        int r108 = r103;
        r103 = r100;
        r100 = r106;
        r101 = r107;
        r102 = r108;
        goto L6
    L8:
        int r109 = 0;
    L9:
        if (r109 >= 8) goto L11;
        int r115 = (r100 ^ r101) ^ (r114 + 1);
        int r116 = h(r114, r101);
        r114 = r114 - 1;
        r109 = r109 + 1;
        int r117 = r103;
        r103 = r115;
        r100 = r116;
        r101 = r102;
        r102 = r117;
        goto L9
    L11:
        r104 = r104 + 1;
        goto L4
    L12:
        r112[r113 + 0] = (byte) (r100 >> 8);
        r112[r113 + 1] = (byte) r100;
        r112[r113 + 2] = (byte) (r101 >> 8);
        r112[r113 + 3] = (byte) r101;
        r112[r113 + 4] = (byte) (r102 >> 8);
        r112[r113 + 5] = (byte) r102;
        r112[r113 + 6] = (byte) (r103 >> 8);
        r112[r113 + 7] = (byte) r103;
        return 8;
    }

    public int encryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = (r110[r111 + 0] << 8) + (r110[r111 + 1] & UByte.MAX_VALUE);
        int r101 = (r110[r111 + 2] << 8) + (r110[r111 + 3] & UByte.MAX_VALUE);
        int r102 = (r110[r111 + 4] << 8) + (r110[r111 + 5] & UByte.MAX_VALUE);
        int r103 = (r110[r111 + 6] << 8) + (r110[r111 + 7] & UByte.MAX_VALUE);
        int r114 = 0;
        int r104 = 0;
    L4:
        if (r114 >= 2) goto L12;
        int r105 = 0;
    L6:
        if (r105 >= 8) goto L8;
        int r106 = g(r104, r100);
        r104 = r104 + 1;
        r105 = r105 + 1;
        int r107 = r101;
        r101 = r106;
        r100 = (r103 ^ r106) ^ r104;
        r103 = r102;
        r102 = r107;
        goto L6
    L8:
        int r108 = 0;
    L9:
        if (r108 >= 8) goto L11;
        int r109 = r104 + 1;
        int r115 = (r101 ^ r100) ^ r109;
        int r116 = g(r104, r100);
        r108 = r108 + 1;
        r104 = r109;
        r101 = r116;
        r100 = r103;
        r103 = r102;
        r102 = r115;
        goto L9
    L11:
        r114 = r114 + 1;
        goto L4
    L12:
        r112[r113 + 0] = (byte) (r100 >> 8);
        r112[r113 + 1] = (byte) r100;
        r112[r113 + 2] = (byte) (r101 >> 8);
        r112[r113 + 3] = (byte) r101;
        r112[r113 + 4] = (byte) (r102 >> 8);
        r112[r113 + 5] = (byte) r102;
        r112[r113 + 6] = (byte) (r103 >> 8);
        r112[r113 + 7] = (byte) r103;
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "SKIPJACK";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L9;
        byte[] r102 = ((KeyParameter) r101).getKey();
        this.encrypting = r100;
        this.key0 = new int[32];
        this.key1 = new int[32];
        this.key2 = new int[32];
        this.key3 = new int[32];
        int r103 = 0;
    L5:
        if (r103 >= 32) goto L7;
        int r104 = r103 * 4;
        this.key0[r103] = r102[r104 % 10] & UByte.MAX_VALUE;
        this.key1[r103] = r102[(r104 + 1) % 10] & UByte.MAX_VALUE;
        this.key2[r103] = r102[(r104 + 2) % 10] & UByte.MAX_VALUE;
        this.key3[r103] = r102[(r104 + 3) % 10] & UByte.MAX_VALUE;
        r103 = r103 + 1;
        goto L5
    L7:
        return;
    L9:
        throw new IllegalArgumentException("invalid parameter passed to SKIPJACK init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this.key1 == null) goto L19;
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
        throw new IllegalStateException("SKIPJACK engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
