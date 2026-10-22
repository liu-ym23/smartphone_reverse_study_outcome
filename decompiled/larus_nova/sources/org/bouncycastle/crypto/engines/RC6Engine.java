package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class RC6Engine implements BlockCipher {
    private static final int LGW = 5;
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private static final int _noRounds = 20;
    private static final int bytesPerWord = 4;
    private static final int wordSize = 32;
    private int[] _S;
    private boolean forEncryption;

    public RC6Engine() {
        this._S = null;
    }

    private int bytesToWord(byte[] r100, int r101) {
        int r102 = 0;
        int r103 = 3;
    L3:
        if (r103 < 0) goto L5;
        r102 = (r102 << 8) + (r100[r103 + r101] & UByte.MAX_VALUE);
        r103 = r103 - 1;
        goto L3
    L5:
        return r102;
    }

    private int decryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = bytesToWord(r110, r111);
        int r101 = bytesToWord(r110, r111 + 4);
        int r102 = bytesToWord(r110, r111 + 8);
        int r114 = bytesToWord(r110, r111 + 12);
        int[] r115 = this._S;
        int r103 = r102 - r115[43];
        int r104 = r100 - r115[42];
        int r116 = 20;
    L4:
        if (r116 < 1) goto L6;
        int r105 = rotateLeft(((r104 * 2) + 1) * r104, 5);
        int r106 = rotateLeft(((r103 * 2) + 1) * r103, 5);
        int r107 = r116 * 2;
        int r108 = rotateRight(r101 - this._S[r107 + 1], r105) ^ r106;
        r116 = r116 - 1;
        int r109 = r104;
        r104 = rotateRight(r114 - this._S[r107], r106) ^ r105;
        r114 = r103;
        r103 = r108;
        r101 = r109;
        goto L4
    L6:
        int[] r117 = this._S;
        int r118 = r114 - r117[1];
        int r119 = r101 - r117[0];
        wordToBytes(r104, r112, r113);
        wordToBytes(r119, r112, r113 + 4);
        wordToBytes(r103, r112, r113 + 8);
        wordToBytes(r118, r112, r113 + 12);
        return 16;
    }

    private int encryptBlock(byte[] r110, int r111, byte[] r112, int r113) {
        int r100 = bytesToWord(r110, r111);
        int r101 = bytesToWord(r110, r111 + 4);
        int r102 = bytesToWord(r110, r111 + 8);
        int r114 = bytesToWord(r110, r111 + 12);
        int[] r115 = this._S;
        int r103 = r101 + r115[0];
        int r116 = r114 + r115[1];
        int r117 = 1;
    L4:
        if (r117 > 20) goto L6;
        int r104 = rotateLeft(((r103 * 2) + 1) * r103, 5);
        int r105 = rotateLeft(((r116 * 2) + 1) * r116, 5);
        int r106 = r117 * 2;
        int r107 = rotateLeft(r100 ^ r104, r105) + this._S[r106];
        int r108 = rotateLeft(r102 ^ r105, r104) + this._S[r106 + 1];
        r117 = r117 + 1;
        r102 = r116;
        r116 = r107;
        r100 = r103;
        r103 = r108;
        goto L4
    L6:
        int[] r118 = this._S;
        int r109 = r100 + r118[42];
        int r119 = r102 + r118[43];
        wordToBytes(r109, r112, r113);
        wordToBytes(r103, r112, r113 + 4);
        wordToBytes(r119, r112, r113 + 8);
        wordToBytes(r116, r112, r113 + 12);
        return 16;
    }

    private int rotateLeft(int r100, int r101) {
        int r102 = r100 << r101;
        return (r100 >>> (-r101)) | r102;
    }

    private int rotateRight(int r100, int r101) {
        int r102 = r100 >>> r101;
        return (r100 << (-r101)) | r102;
    }

    private void setKey(byte[] r110) {
        int r100 = (r110.length + 3) / 4;
        int r101 = ((r110.length + 4) - 1) / 4;
        int[] r102 = new int[r101];
        int r103 = r110.length - 1;
    L3:
        if (r103 < 0) goto L5;
        int r104 = r103 / 4;
        r102[r104] = (r102[r104] << 8) + (r110[r103] & UByte.MAX_VALUE);
        r103 = r103 - 1;
        goto L3
    L5:
        int[] r111 = new int[44];
        this._S = r111;
        int r105 = 0;
        r111[0] = P32;
        int r112 = 1;
    L6:
        int[] r106 = this._S;
        if (r112 >= r106.length) goto L10;
        r106[r112] = r106[r112 - 1] + Q32;
        r112 = r112 + 1;
        goto L6
    L10:
        if (r101 <= r106.length) goto L12;
        int r113 = r101 * 3;
    L13:
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
        int r114 = 0;
    L14:
        if (r105 >= r113) goto L16;
        int[] r115 = this._S;
        r108 = rotateLeft((r115[r107] + r108) + r109, 3);
        r115[r107] = r108;
        r109 = rotateLeft((r102[r114] + r108) + r109, r109 + r108);
        r102[r114] = r109;
        r107 = (r107 + 1) % this._S.length;
        r114 = (r114 + 1) % r101;
        r105 = r105 + 1;
        goto L14
    L16:
        return;
    L12:
        r113 = r106.length * 3;
        goto L13
    }

    private void wordToBytes(int r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= 4) goto L6;
        r101[r103 + r102] = (byte) r100;
        r100 = r100 >>> 8;
        r103 = r103 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC6";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L7;
        this.forEncryption = r100;
        setKey(((KeyParameter) r101).getKey());
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to RC6 init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        int r104 = getBlockSize();
        if (this._S == null) goto L18;
        if ((r101 + r104) > r100.length) goto L16;
        if ((r104 + r103) > r102.length) goto L14;
        if (this.forEncryption == false) goto L12;
        return encryptBlock(r100, r101, r102, r103);
    L12:
        return decryptBlock(r100, r101, r102, r103);
    L14:
        throw new OutputLengthException("output buffer too short");
    L16:
        throw new DataLengthException("input buffer too short");
    L18:
        throw new IllegalStateException("RC6 engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
