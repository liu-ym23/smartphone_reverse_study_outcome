package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.RC5Parameters;

/* JADX INFO: loaded from: classes42.dex */
public class RC532Engine implements BlockCipher {
    private static final int P32 = -1209970333;
    private static final int Q32 = -1640531527;
    private int[] _S;
    private int _noRounds;
    private boolean forEncryption;

    public RC532Engine() {
        this._noRounds = 12;
        this._S = null;
    }

    private int bytesToWord(byte[] r100, int r101) {
        int r102 = ((r100[r101] & UByte.MAX_VALUE) | ((r100[r101 + 1] & UByte.MAX_VALUE) << 8)) | ((r100[r101 + 2] & UByte.MAX_VALUE) << 16);
        return ((r100[r101 + 3] & UByte.MAX_VALUE) << 24) | r102;
    }

    private int decryptBlock(byte[] r100, int r101, byte[] r102, int r103) {
        int r104 = bytesToWord(r100, r101);
        int r105 = bytesToWord(r100, r101 + 4);
        int r106 = this._noRounds;
    L4:
        if (r106 < 1) goto L6;
        int r107 = r106 * 2;
        r105 = rotateRight(r105 - this._S[r107 + 1], r104) ^ r104;
        r104 = rotateRight(r104 - this._S[r107], r105) ^ r105;
        r106 = r106 - 1;
        goto L4
    L6:
        wordToBytes(r104 - this._S[0], r102, r103);
        wordToBytes(r105 - this._S[1], r102, r103 + 4);
        return 8;
    }

    private int encryptBlock(byte[] r100, int r101, byte[] r102, int r103) {
        int r104 = bytesToWord(r100, r101) + this._S[0];
        int r105 = bytesToWord(r100, r101 + 4) + this._S[1];
        int r106 = 1;
    L4:
        if (r106 > this._noRounds) goto L6;
        int r107 = r106 * 2;
        r104 = rotateLeft(r104 ^ r105, r105) + this._S[r107];
        r105 = rotateLeft(r105 ^ r104, r104) + this._S[r107 + 1];
        r106 = r106 + 1;
        goto L4
    L6:
        wordToBytes(r104, r102, r103);
        wordToBytes(r105, r102, r103 + 4);
        return 8;
    }

    private int rotateLeft(int r100, int r101) {
        int r102 = r101 & 31;
        int r103 = r100 << r102;
        return (r100 >>> (32 - r102)) | r103;
    }

    private int rotateRight(int r100, int r101) {
        int r102 = r101 & 31;
        int r103 = r100 >>> r102;
        return (r100 << (32 - r102)) | r103;
    }

    private void setKey(byte[] r110) {
        int r100 = (r110.length + 3) / 4;
        int[] r101 = new int[r100];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 == r110.length) goto L6;
        int r104 = r103 / 4;
        r101[r104] = r101[r104] + ((r110[r103] & UByte.MAX_VALUE) << ((r103 % 4) * 8));
        r103 = r103 + 1;
        goto L4
    L6:
        int[] r111 = new int[(this._noRounds + 1) * 2];
        this._S = r111;
        r111[0] = P32;
        int r112 = 1;
    L7:
        int[] r105 = this._S;
        if (r112 >= r105.length) goto L11;
        r105[r112] = r105[r112 - 1] + Q32;
        r112 = r112 + 1;
        goto L7
    L11:
        if (r100 <= r105.length) goto L13;
        int r113 = r100 * 3;
    L14:
        int r106 = 0;
        int r107 = 0;
        int r108 = 0;
        int r109 = 0;
    L15:
        if (r102 >= r113) goto L17;
        int[] r114 = this._S;
        r107 = rotateLeft((r114[r106] + r107) + r108, 3);
        r114[r106] = r107;
        r108 = rotateLeft((r101[r109] + r107) + r108, r108 + r107);
        r101[r109] = r108;
        r106 = (r106 + 1) % this._S.length;
        r109 = (r109 + 1) % r100;
        r102 = r102 + 1;
        goto L15
    L17:
        return;
    L13:
        r113 = r105.length * 3;
        goto L14
    }

    private void wordToBytes(int r100, byte[] r101, int r102) {
        r101[r102] = (byte) r100;
        r101[r102 + 1] = (byte) (r100 >> 8);
        r101[r102 + 2] = (byte) (r100 >> 16);
        r101[r102 + 3] = (byte) (r100 >> 24);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC5-32";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof RC5Parameters) == false) goto L6;
        RC5Parameters r102 = (RC5Parameters) r101;
        this._noRounds = r102.getRounds();
        setKey(r102.getKey());
    L8:
        this.forEncryption = r100;
        return;
    L6:
        if ((r101 instanceof KeyParameter) == false) goto L11;
        setKey(((KeyParameter) r101).getKey());
        goto L8
    L11:
        throw new IllegalArgumentException("invalid parameter passed to RC532 init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) {
        if (this.forEncryption == false) goto L6;
        return encryptBlock(r100, r101, r102, r103);
    L6:
        return decryptBlock(r100, r101, r102, r103);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
