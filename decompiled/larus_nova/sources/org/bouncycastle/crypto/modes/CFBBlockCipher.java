package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CFBBlockCipher extends StreamBlockCipher {
    private byte[] IV;
    private int blockSize;
    private int byteCount;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher;
    private boolean encrypting;
    private byte[] inBuf;

    public CFBBlockCipher(BlockCipher r100, int r101) {
        super(r100);
        this.cipher = null;
        if (r101 > (r100.getBlockSize() * 8)) goto L10;
        if (r101 < 8) goto L10;
        if ((r101 % 8) != 0) goto L10;
        this.cipher = r100;
        this.blockSize = r101 / 8;
        this.IV = new byte[r100.getBlockSize()];
        this.cfbV = new byte[r100.getBlockSize()];
        this.cfbOutV = new byte[r100.getBlockSize()];
        this.inBuf = new byte[this.blockSize];
        return;
    L10:
        throw new IllegalArgumentException("CFB" + r101 + " not supported");
    }

    private byte decryptByte(byte r100) {
        if (this.byteCount != 0) goto L5;
        this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
    L5:
        byte[] r101 = this.inBuf;
        int r102 = this.byteCount;
        r101[r102] = r100;
        byte[] r103 = this.cfbOutV;
        int r104 = r102 + 1;
        this.byteCount = r104;
        byte r105 = (byte) (r100 ^ r103[r102]);
        int r106 = this.blockSize;
        if (r104 != r106) goto L8;
        this.byteCount = 0;
        byte[] r107 = this.cfbV;
        System.arraycopy(r107, r106, r107, 0, r107.length - r106);
        byte[] r108 = this.inBuf;
        byte[] r109 = this.cfbV;
        int r110 = r109.length;
        int r111 = this.blockSize;
        System.arraycopy(r108, 0, r109, r110 - r111, r111);
    L8:
        return r105;
    }

    private byte encryptByte(byte r100) {
        if (this.byteCount != 0) goto L5;
        this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
    L5:
        byte[] r101 = this.cfbOutV;
        int r102 = this.byteCount;
        byte r103 = (byte) (r100 ^ r101[r102]);
        byte[] r104 = this.inBuf;
        int r105 = r102 + 1;
        this.byteCount = r105;
        r104[r102] = r103;
        int r106 = this.blockSize;
        if (r105 != r106) goto L8;
        this.byteCount = 0;
        byte[] r107 = this.cfbV;
        System.arraycopy(r107, r106, r107, 0, r107.length - r106);
        byte[] r108 = this.inBuf;
        byte[] r109 = this.cfbV;
        int r110 = r109.length;
        int r111 = this.blockSize;
        System.arraycopy(r108, 0, r109, r110 - r111, r111);
    L8:
        return r103;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) throws DataLengthException, IllegalStateException {
        if (this.encrypting == false) goto L6;
        return encryptByte(r100);
    L6:
        return decryptByte(r100);
    }

    public int decryptBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        processBytes(r100, r101, this.blockSize, r102, r110);
        return this.blockSize;
    }

    public int encryptBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        processBytes(r100, r101, this.blockSize, r102, r110);
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    public byte[] getCurrentIV() {
        return Arrays.clone(this.cfbV);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.encrypting = r100;
        if ((r101 instanceof ParametersWithIV) == false) goto L14;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        int r104 = r103.length;
        byte[] r105 = this.IV;
        if (r104 >= r105.length) goto L10;
        System.arraycopy(r103, 0, r105, r105.length - r103.length, r103.length);
        int r106 = 0;
    L7:
        byte[] r107 = this.IV;
        if (r106 >= (r107.length - r103.length)) goto L11;
        r107[r106] = 0;
        r106 = r106 + 1;
    L11:
        reset();
        if (r102.getParameters() == null) goto L20;
        BlockCipher r108 = this.cipher;
        r101 = r102.getParameters();
    L17:
        r108.init(true, r101);
        return;
    L20:
        return;
    L10:
        System.arraycopy(r103, 0, r105, 0, r105.length);
        goto L11
    L14:
        reset();
        if (r101 == null) goto L21;
        r108 = this.cipher;
        goto L17
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        processBytes(r100, r101, this.blockSize, r102, r110);
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] r100 = this.IV;
        System.arraycopy(r100, 0, this.cfbV, 0, r100.length);
        Arrays.fill(this.inBuf, (byte) 0);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
