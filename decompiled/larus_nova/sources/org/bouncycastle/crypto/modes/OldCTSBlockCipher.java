package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes42.dex */
public class OldCTSBlockCipher extends BufferedBlockCipher {
    private int blockSize;

    public OldCTSBlockCipher(BlockCipher r100) {
        if ((r100 instanceof OFBBlockCipher) == true) goto L9;
        if ((r100 instanceof CFBBlockCipher) == true) goto L9;
        this.cipher = r100;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        this.buf = new byte[r101 * 2];
        this.bufOff = 0;
        return;
    L9:
        throw new IllegalArgumentException("CTSBlockCipher can only accept ECB, or CBC ciphers");
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] r110, int r111) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        if ((this.bufOff + r111) > r110.length) goto L34;
        int r100 = this.cipher.getBlockSize();
        int r101 = this.bufOff - r100;
        byte[] r102 = new byte[r100];
        if (this.forEncryption == false) goto L22;
        this.cipher.processBlock(this.buf, 0, r102, 0);
        int r103 = this.bufOff;
        if (r103 < r100) goto L21;
    L8:
        byte[] r104 = this.buf;
        if (r103 == r104.length) goto L11;
        r104[r103] = r102[r103 - r100];
        r103 = r103 + 1;
        goto L8
    L11:
        int r105 = r100;
    L13:
        if (r105 == this.bufOff) goto L15;
        byte[] r106 = this.buf;
        r106[r105] = (byte) (r106[r105] ^ r102[r105 - r100]);
        r105 = r105 + 1;
        goto L13
    L15:
        BlockCipher r107 = this.cipher;
        if ((r107 instanceof CBCBlockCipher) == false) goto L18;
        ((CBCBlockCipher) r107).getUnderlyingCipher().processBlock(this.buf, r100, r110, r111);
    L19:
        System.arraycopy(r102, 0, r110, r111 + r100, r101);
    L31:
        int r112 = this.bufOff;
        reset();
        return r112;
    L18:
        r107.processBlock(this.buf, r100, r110, r111);
        goto L19
    L21:
        throw new DataLengthException("need at least one block of input for CTS");
    L22:
        byte[] r108 = new byte[r100];
        BlockCipher r109 = this.cipher;
        if ((r109 instanceof CBCBlockCipher) == false) goto L25;
        ((CBCBlockCipher) r109).getUnderlyingCipher().processBlock(this.buf, 0, r102, 0);
    L26:
        int r113 = r100;
    L28:
        if (r113 == this.bufOff) goto L30;
        int r114 = r113 - r100;
        r108[r114] = (byte) (r102[r114] ^ this.buf[r113]);
        r113 = r113 + 1;
        goto L28
    L30:
        System.arraycopy(this.buf, r100, r102, 0, r101);
        this.cipher.processBlock(r102, 0, r110, r111);
        System.arraycopy(r108, 0, r110, r111 + r100, r101);
        goto L31
    L25:
        r109.processBlock(this.buf, 0, r102, 0);
        goto L26
    L34:
        throw new OutputLengthException("output buffer to small in doFinal");
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int r100) {
        return r100 + this.bufOff;
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
        byte[] r107 = this.buf;
        int r108 = this.blockSize;
        System.arraycopy(r107, r108, r107, 0, r108);
        this.bufOff = this.blockSize;
        r105 = r106;
    L5:
        byte[] r109 = this.buf;
        int r110 = this.bufOff;
        this.bufOff = r110 + 1;
        r109[r110] = r100;
        return r105;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r110, int r111) throws DataLengthException, IllegalStateException {
        if (r102 < 0) goto L19;
        int r103 = getBlockSize();
        int r104 = getUpdateOutputSize(r102);
        if (r104 > 0) goto L6;
    L10:
        byte[] r105 = this.buf;
        int r106 = r105.length;
        int r107 = this.bufOff;
        int r108 = r106 - r107;
        int r109 = 0;
        if (r102 <= r108) goto L16;
        System.arraycopy(r100, r101, r105, r107, r108);
        int r112 = this.cipher.processBlock(this.buf, 0, r110, r111) + 0;
        byte[] r113 = this.buf;
        System.arraycopy(r113, r103, r113, 0, r103);
        this.bufOff = r103;
        r102 = r102 - r108;
        r101 = r101 + r108;
    L13:
        if (r102 <= r103) goto L15;
        System.arraycopy(r100, r101, this.buf, this.bufOff, r103);
        r112 = r112 + this.cipher.processBlock(this.buf, 0, r110, r111 + r112);
        byte[] r114 = this.buf;
        System.arraycopy(r114, r103, r114, 0, r103);
        r102 = r102 - r103;
        r101 = r101 + r103;
        goto L13
    L15:
        r109 = r112;
    L16:
        System.arraycopy(r100, r101, this.buf, this.bufOff, r102);
        this.bufOff += r102;
        return r109;
    L6:
        if ((r104 + r111) <= r110.length) goto L10;
        throw new OutputLengthException("output buffer too short");
    L19:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }
}
