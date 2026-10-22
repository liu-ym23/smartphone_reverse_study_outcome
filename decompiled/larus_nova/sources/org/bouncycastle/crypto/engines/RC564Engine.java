package org.bouncycastle.crypto.engines;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.params.RC5Parameters;

/* JADX INFO: loaded from: classes42.dex */
public class RC564Engine implements BlockCipher {
    private static final long P64 = -5196783011329398165L;
    private static final long Q64 = -7046029254386353131L;
    private static final int bytesPerWord = 8;
    private static final int wordSize = 64;
    private long[] _S;
    private int _noRounds;
    private boolean forEncryption;

    public RC564Engine() {
        this._noRounds = 12;
        this._S = null;
    }

    private long bytesToWord(byte[] r100, int r101) {
        long r102 = 0;
        int r103 = 7;
    L3:
        if (r103 < 0) goto L5;
        r102 = (r102 << 8) + ((long) (r100[r103 + r101] & UByte.MAX_VALUE));
        r103 = r103 - 1;
        goto L3
    L5:
        return r102;
    }

    private int decryptBlock(byte[] r100, int r101, byte[] r110, int r111) {
        long r102 = bytesToWord(r100, r101);
        long r103 = bytesToWord(r100, r101 + 8);
        int r104 = this._noRounds;
    L4:
        if (r104 < 1) goto L6;
        int r105 = r104 * 2;
        r103 = rotateRight(r103 - this._S[r105 + 1], r102) ^ r102;
        r102 = rotateRight(r102 - this._S[r105], r103) ^ r103;
        r104 = r104 - 1;
        goto L4
    L6:
        wordToBytes(r102 - this._S[0], r110, r111);
        wordToBytes(r103 - this._S[1], r110, r111 + 8);
        return 16;
    }

    private int encryptBlock(byte[] r100, int r110, byte[] r111, int r112) {
        long r101 = bytesToWord(r100, r110) + this._S[0];
        long r102 = bytesToWord(r100, r110 + 8) + this._S[1];
        int r103 = 1;
    L4:
        if (r103 > this._noRounds) goto L6;
        int r104 = r103 * 2;
        r101 = rotateLeft(r101 ^ r102, r102) + this._S[r104];
        r102 = rotateLeft(r102 ^ r101, r101) + this._S[r104 + 1];
        r103 = r103 + 1;
        goto L4
    L6:
        wordToBytes(r101, r111, r112);
        wordToBytes(r102, r111, r112 + 8);
        return 16;
    }

    private long rotateLeft(long r100, long r101) {
        long r102 = r101 & 63;
        long r103 = r100 << ((int) r102);
        return (r100 >>> ((int) (64 - r102))) | r103;
    }

    private long rotateRight(long r100, long r101) {
        long r102 = r101 & 63;
        long r103 = r100 >>> ((int) r102);
        return (r100 << ((int) (64 - r102))) | r103;
    }

    private void setKey(byte[] r110) {
        int r100 = (r110.length + 7) / 8;
        long[] r101 = new long[r100];
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 == r110.length) goto L6;
        int r104 = r103 / 8;
        r101[r104] = r101[r104] + (((long) (r110[r103] & UByte.MAX_VALUE)) << ((r103 % 8) * 8));
        r103 = r103 + 1;
        goto L4
    L6:
        long[] r111 = new long[(this._noRounds + 1) * 2];
        this._S = r111;
        r111[0] = -5196783011329398165L;
        int r112 = 1;
    L7:
        long[] r105 = this._S;
        if (r112 >= r105.length) goto L11;
        r105[r112] = r105[r112 - 1] + Q64;
        r112 = r112 + 1;
        goto L7
    L11:
        if (r100 <= r105.length) goto L13;
        int r113 = r100 * 3;
    L14:
        long r106 = 0;
        long r107 = 0;
        int r108 = 0;
        int r109 = 0;
    L15:
        if (r102 >= r113) goto L17;
        long[] r114 = this._S;
        r106 = rotateLeft((r114[r108] + r106) + r107, 3);
        r114[r108] = r106;
        r107 = rotateLeft((r101[r109] + r106) + r107, r107 + r106);
        r101[r109] = r107;
        r108 = (r108 + 1) % this._S.length;
        r109 = (r109 + 1) % r100;
        r102 = r102 + 1;
        goto L15
    L17:
        return;
    L13:
        r113 = r105.length * 3;
        goto L14
    }

    private void wordToBytes(long r100, byte[] r101, int r102) {
        int r103 = 0;
    L4:
        if (r103 >= 8) goto L6;
        r101[r103 + r102] = (byte) r100;
        r100 = r100 >>> 8;
        r103 = r103 + 1;
        goto L4
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "RC5-64";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof RC5Parameters) == false) goto L7;
        RC5Parameters r102 = (RC5Parameters) r101;
        this.forEncryption = r100;
        this._noRounds = r102.getRounds();
        setKey(r102.getKey());
        return;
    L7:
        throw new IllegalArgumentException("invalid parameter passed to RC564 init - ".concat(r101.getClass().getName()));
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
