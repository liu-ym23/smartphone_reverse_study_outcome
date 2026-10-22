package org.bouncycastle.crypto.modes;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes42.dex */
public class PaddedBlockCipher extends BufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher r100) {
        this.cipher = r100;
        this.buf = new byte[r100.getBlockSize()];
        this.bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] r100, int r101) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int r102 = this.cipher.getBlockSize();
        if (this.forEncryption == false) goto L18;
        if (this.bufOff == r102) goto L7;
        int r103 = 0;
    L12:
        byte r104 = (byte) (r102 - this.bufOff);
    L13:
        int r105 = this.bufOff;
        if (r105 >= r102) goto L16;
        this.buf[r105] = r104;
        this.bufOff = r105 + 1;
        goto L13
    L16:
        int r106 = r103 + this.cipher.processBlock(this.buf, 0, r100, r101 + r103);
    L22:
        reset();
        return r106;
    L7:
        if (((r102 * 2) + r101) > r100.length) goto L10;
        r103 = this.cipher.processBlock(this.buf, 0, r100, r101);
        this.bufOff = 0;
        goto L12
    L10:
        throw new OutputLengthException("output buffer too short");
    L18:
        if (this.bufOff != r102) goto L27;
        BlockCipher r107 = this.cipher;
        byte[] r108 = this.buf;
        int r109 = r107.processBlock(r108, 0, r108, 0);
        this.bufOff = 0;
        byte[] r110 = this.buf;
        int r111 = r110[r102 - 1] & UByte.MAX_VALUE;
        if (r111 > r102) goto L25;
        r106 = r109 - r111;
        System.arraycopy(r110, 0, r100, r101, r106);
        goto L22
    L25:
        throw new InvalidCipherTextException("pad block corrupted");
    L27:
        throw new DataLengthException("last block incomplete in decryption");
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int r100) {
        int r101 = r100 + this.bufOff;
        byte[] r102 = this.buf;
        int r103 = r101 % r102.length;
        if (r103 == 0) goto L5;
        r101 = r101 - r103;
    L7:
        return r101 + r102.length;
    L5:
        if (this.forEncryption == true) goto L7;
        return r101;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int r100) {
        int r101 = r100 + this.bufOff;
        byte[] r102 = this.buf;
        int r103 = r101 % r102.length;
        if (r103 != 0) goto L7;
        return r101 - r102.length;
    L7:
        return r101 - r103;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException, IllegalStateException {
        int r103 = this.bufOff;
        byte[] r104 = this.buf;
        int r105 = 0;
        if (r103 != r104.length) goto L5;
        int r106 = this.cipher.processBlock(r104, 0, r101, r102);
        this.bufOff = 0;
        r105 = r106;
    L5:
        byte[] r107 = this.buf;
        int r108 = this.bufOff;
        this.bufOff = r108 + 1;
        r107[r108] = r100;
        return r105;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r110) throws DataLengthException, IllegalStateException {
        if (r102 < 0) goto L19;
        int r104 = getBlockSize();
        int r105 = getUpdateOutputSize(r102);
        if (r105 > 0) goto L6;
    L10:
        byte[] r106 = this.buf;
        int r107 = r106.length;
        int r108 = this.bufOff;
        int r109 = r107 - r108;
        int r111 = 0;
        if (r102 <= r109) goto L16;
        System.arraycopy(r100, r101, r106, r108, r109);
        int r112 = this.cipher.processBlock(this.buf, 0, r103, r110) + 0;
        this.bufOff = 0;
        r102 = r102 - r109;
        r101 = r101 + r109;
        r111 = r112;
    L14:
        if (r102 <= this.buf.length) goto L16;
        r111 = r111 + this.cipher.processBlock(r100, r101, r103, r110 + r111);
        r102 = r102 - r104;
        r101 = r101 + r104;
    L16:
        System.arraycopy(r100, r101, this.buf, this.bufOff, r102);
        this.bufOff += r102;
        return r111;
    L6:
        if ((r105 + r110) <= r103.length) goto L10;
        throw new OutputLengthException("output buffer too short");
    L19:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
