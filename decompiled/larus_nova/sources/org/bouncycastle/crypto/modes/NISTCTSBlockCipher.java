package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes42.dex */
public class NISTCTSBlockCipher extends BufferedBlockCipher {
    public static final int CS1 = 1;
    public static final int CS2 = 2;
    public static final int CS3 = 3;
    private final int blockSize;
    private final int type;

    public NISTCTSBlockCipher(int r100, BlockCipher r101) {
        this.type = r100;
        this.cipher = new CBCBlockCipher(r101);
        int r102 = r101.getBlockSize();
        this.blockSize = r102;
        this.buf = new byte[r102 * 2];
        this.bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] r110, int r111) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        if ((this.bufOff + r111) > r110.length) goto L53;
        int r100 = this.cipher.getBlockSize();
        int r101 = this.bufOff;
        int r102 = r101 - r100;
        byte[] r103 = new byte[r100];
        if (this.forEncryption == false) goto L21;
        if (r101 < r100) goto L20;
        if (r101 <= r100) goto L18;
        byte[] r104 = new byte[r100];
        int r105 = this.type;
        if (r105 == 2) goto L13;
        if (r105 == 3) goto L13;
        System.arraycopy(this.buf, 0, r103, 0, r100);
        this.cipher.processBlock(r103, 0, r103, 0);
        System.arraycopy(r103, 0, r110, r111, r102);
        System.arraycopy(this.buf, this.bufOff - r102, r104, 0, r102);
        this.cipher.processBlock(r104, 0, r104, 0);
        System.arraycopy(r104, 0, r110, r111 + r102, r100);
    L48:
        int r112 = this.bufOff;
        reset();
        return r112;
    L13:
        this.cipher.processBlock(this.buf, 0, r103, 0);
        System.arraycopy(this.buf, r100, r104, 0, r102);
        this.cipher.processBlock(r104, 0, r104, 0);
        if (this.type != 2) goto L17;
        if (r102 != r100) goto L17;
        System.arraycopy(r103, 0, r110, r111, r100);
        System.arraycopy(r104, 0, r110, r111 + r100, r102);
    L17:
        System.arraycopy(r104, 0, r110, r111, r100);
        System.arraycopy(r103, 0, r110, r111 + r100, r102);
        goto L48
    L18:
        this.cipher.processBlock(this.buf, 0, r103, 0);
    L47:
        System.arraycopy(r103, 0, r110, r111, r100);
        goto L48
    L20:
        throw new DataLengthException("need at least one block of input for NISTCTS");
    L21:
        if (r101 < r100) goto L51;
        byte[] r106 = new byte[r100];
        if (r101 <= r100) goto L46;
        int r107 = this.type;
        if (r107 == 3) goto L36;
        if (r107 == 2) goto L28;
    L30:
        ((CBCBlockCipher) this.cipher).getUnderlyingCipher().processBlock(this.buf, this.bufOff - r100, r106, 0);
        System.arraycopy(this.buf, 0, r103, 0, r100);
        if (r102 == r100) goto L33;
        System.arraycopy(r106, r102, r103, r102, r100 - r102);
    L33:
        this.cipher.processBlock(r103, 0, r103, 0);
        System.arraycopy(r103, 0, r110, r111, r100);
        int r108 = 0;
    L34:
        if (r108 == r102) goto L45;
        r106[r108] = (byte) (r106[r108] ^ this.buf[r108]);
        r108 = r108 + 1;
    L45:
        System.arraycopy(r106, 0, r110, r111 + r100, r102);
        goto L48
    L28:
        if (((this.buf.length - r101) % r100) == 0) goto L30;
    L36:
        BlockCipher r109 = this.cipher;
        if ((r109 instanceof CBCBlockCipher) == false) goto L39;
        ((CBCBlockCipher) r109).getUnderlyingCipher().processBlock(this.buf, 0, r103, 0);
    L40:
        int r113 = r100;
    L42:
        if (r113 == this.bufOff) goto L44;
        int r114 = r113 - r100;
        r106[r114] = (byte) (r103[r114] ^ this.buf[r113]);
        r113 = r113 + 1;
        goto L42
    L44:
        System.arraycopy(this.buf, r100, r103, 0, r102);
        this.cipher.processBlock(r103, 0, r110, r111);
        goto L45
    L39:
        r109.processBlock(this.buf, 0, r103, 0);
        goto L40
    L46:
        this.cipher.processBlock(this.buf, 0, r103, 0);
        goto L47
    L51:
        throw new DataLengthException("need at least one block of input for CTS");
    L53:
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
