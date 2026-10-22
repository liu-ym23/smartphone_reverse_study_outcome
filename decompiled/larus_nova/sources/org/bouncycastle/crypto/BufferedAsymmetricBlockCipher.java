package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public class BufferedAsymmetricBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    private final AsymmetricBlockCipher cipher;

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher r100) {
        this.cipher = r100;
    }

    public byte[] doFinal() throws InvalidCipherTextException {
        byte[] r100 = this.cipher.processBlock(this.buf, 0, this.bufOff);
        reset();
        return r100;
    }

    public int getBufferPosition() {
        return this.bufOff;
    }

    public int getInputBlockSize() {
        return this.cipher.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.cipher.getOutputBlockSize();
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public void init(boolean r100, CipherParameters r101) {
        reset();
        this.cipher.init(r100, r101);
        this.buf = new byte[this.cipher.getInputBlockSize() + (r100 ? 1 : 0)];
        this.bufOff = 0;
    }

    public void processByte(byte r100) {
        int r101 = this.bufOff;
        byte[] r102 = this.buf;
        if (r101 >= r102.length) goto L7;
        this.bufOff = r101 + 1;
        r102[r101] = r100;
        return;
    L7:
        throw new DataLengthException("attempt to process message too long for cipher");
    }

    public void processBytes(byte[] r100, int r101, int r102) {
        if (r102 != 0) goto L4;
        return;
    L4:
        if (r102 < 0) goto L12;
        int r103 = this.bufOff;
        int r104 = r103 + r102;
        byte[] r105 = this.buf;
        if (r104 > r105.length) goto L10;
        System.arraycopy(r100, r101, r105, r103, r102);
        this.bufOff += r102;
        return;
    L10:
        throw new DataLengthException("attempt to process message too long for cipher");
    L12:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public void reset() {
        if (this.buf == null) goto L8;
        int r100 = 0;
    L5:
        byte[] r101 = this.buf;
        if (r100 >= r101.length) goto L8;
        r101[r100] = 0;
        r100 = r100 + 1;
    L8:
        this.bufOff = 0;
    }
}
