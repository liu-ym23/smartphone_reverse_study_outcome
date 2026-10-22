package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public class BufferedBlockCipher {
    protected byte[] buf;
    protected int bufOff;
    protected BlockCipher cipher;
    protected boolean forEncryption;
    protected boolean partialBlockOkay;
    protected boolean pgpCFB;

    public BufferedBlockCipher() {
    }

    public BufferedBlockCipher(BlockCipher r100) {
        this.cipher = r100;
        this.buf = new byte[r100.getBlockSize()];
        boolean r101 = false;
        this.bufOff = 0;
        String r102 = r100.getAlgorithmName();
        int r103 = r102.indexOf(47) + 1;
        if (r103 > 0) goto L5;
    L7:
        boolean r104 = false;
    L8:
        this.pgpCFB = r104;
        if (r104 == false) goto L11;
    L18:
        this.partialBlockOkay = true;
        return;
    L11:
        if ((r100 instanceof StreamCipher) == true) goto L18;
        if (r103 > 0) goto L15;
    L17:
        this.partialBlockOkay = r101;
        return;
    L15:
        if (r102.startsWith("OpenPGP", r103) == false) goto L17;
        r101 = true;
        goto L17
    L5:
        if (r102.startsWith("PGP", r103) == false) goto L7;
        r104 = true;
        goto L8
    }

    public int doFinal(byte[] r100, int r101) throws DataLengthException, IllegalStateException, InvalidCipherTextException {
        int r102 = this.bufOff;     // Catch: Throwable -> L15
        if ((r101 + r102) > r100.length) goto L14;
        int r103 = 0;
        if (r102 != 0) goto L7;
    L11:
        reset();
        return r103;
    L7:
        if (this.partialBlockOkay == false) goto L10;
        BlockCipher r104 = this.cipher;     // Catch: Throwable -> L15
        byte[] r105 = this.buf;     // Catch: Throwable -> L15
        r104.processBlock(r105, 0, r105, 0);     // Catch: Throwable -> L15
        int r106 = this.bufOff;     // Catch: Throwable -> L15
        this.bufOff = 0;     // Catch: Throwable -> L15
        System.arraycopy(this.buf, 0, r100, r101, r106);     // Catch: Throwable -> L15
        r103 = r106;
        goto L11
    L10:
        throw new DataLengthException("data not block size aligned");     // Catch: Throwable -> L15
    L14:
        throw new OutputLengthException("output buffer too short for doFinal()");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        reset();
        throw th;
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public int getOutputSize(int r100) {
        return r100 + this.bufOff;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int getUpdateOutputSize(int r100) {
        int r101 = r100 + this.bufOff;
        if (this.pgpCFB == true) goto L5;
        int r102 = this.buf.length;
    L9:
        int r103 = r101 % r102;
    L11:
        return r101 - r103;
    L5:
        if (this.forEncryption == false) goto L7;
        r103 = (r101 % this.buf.length) - (this.cipher.getBlockSize() + 2);
        goto L11
    L7:
        r102 = this.buf.length;
        goto L9
    }

    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        reset();
        this.cipher.init(r100, r101);
    }

    public int processByte(byte r100, byte[] r101, int r102) throws DataLengthException, IllegalStateException {
        byte[] r103 = this.buf;
        int r104 = this.bufOff;
        int r105 = r104 + 1;
        this.bufOff = r105;
        r103[r104] = r100;
        if (r105 != r103.length) goto L6;
        int r106 = this.cipher.processBlock(r103, 0, r101, r102);
        this.bufOff = 0;
        return r106;
    L6:
        return 0;
    }

    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r110) throws DataLengthException, IllegalStateException {
        if (r102 < 0) goto L22;
        int r104 = getBlockSize();
        int r105 = getUpdateOutputSize(r102);
        if (r105 > 0) goto L6;
    L10:
        byte[] r106 = this.buf;
        int r107 = r106.length;
        int r108 = this.bufOff;
        int r109 = r107 - r108;
        if (r102 <= r109) goto L16;
        System.arraycopy(r100, r101, r106, r108, r109);
        int r111 = this.cipher.processBlock(this.buf, 0, r103, r110) + 0;
        this.bufOff = 0;
        r102 = r102 - r109;
        r101 = r101 + r109;
    L14:
        if (r102 <= this.buf.length) goto L17;
        r111 = r111 + this.cipher.processBlock(r100, r101, r103, r110 + r111);
        r102 = r102 - r104;
        r101 = r101 + r104;
    L17:
        System.arraycopy(r100, r101, this.buf, this.bufOff, r102);
        int r112 = this.bufOff + r102;
        this.bufOff = r112;
        byte[] r113 = this.buf;
        if (r112 != r113.length) goto L24;
        int r114 = r111 + this.cipher.processBlock(r113, 0, r103, r110 + r111);
        this.bufOff = 0;
        return r114;
    L24:
        return r111;
    L16:
        r111 = 0;
        goto L17
    L6:
        if ((r105 + r110) <= r103.length) goto L10;
        throw new OutputLengthException("output buffer too short");
    L22:
        throw new IllegalArgumentException("Can't have a negative input length!");
    }

    public void reset() {
        int r100 = 0;
    L3:
        byte[] r101 = this.buf;
        if (r100 >= r101.length) goto L6;
        r101[r100] = 0;
        r100 = r100 + 1;
        goto L3
    L6:
        this.bufOff = 0;
        this.cipher.reset();
    }
}
