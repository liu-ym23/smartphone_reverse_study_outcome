package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class OFBBlockCipher extends StreamBlockCipher {
    private byte[] IV;
    private final int blockSize;
    private int byteCount;
    private final BlockCipher cipher;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public OFBBlockCipher(BlockCipher r100, int r101) {
        super(r100);
        if (r101 > (r100.getBlockSize() * 8)) goto L10;
        if (r101 < 8) goto L10;
        if ((r101 % 8) != 0) goto L10;
        this.cipher = r100;
        this.blockSize = r101 / 8;
        this.IV = new byte[r100.getBlockSize()];
        this.ofbV = new byte[r100.getBlockSize()];
        this.ofbOutV = new byte[r100.getBlockSize()];
        return;
    L10:
        throw new IllegalArgumentException("0FB" + r101 + " not supported");
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) throws DataLengthException, IllegalStateException {
        if (this.byteCount != 0) goto L5;
        this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
    L5:
        byte[] r101 = this.ofbOutV;
        int r102 = this.byteCount;
        int r103 = r102 + 1;
        this.byteCount = r103;
        byte r104 = (byte) (r100 ^ r101[r102]);
        int r105 = this.blockSize;
        if (r103 != r105) goto L8;
        this.byteCount = 0;
        byte[] r106 = this.ofbV;
        System.arraycopy(r106, r105, r106, 0, r106.length - r105);
        byte[] r107 = this.ofbOutV;
        byte[] r108 = this.ofbV;
        int r109 = r108.length;
        int r110 = this.blockSize;
        System.arraycopy(r107, 0, r108, r109 - r110, r110);
    L8:
        return r104;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
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
        System.arraycopy(r100, 0, this.ofbV, 0, r100.length);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
