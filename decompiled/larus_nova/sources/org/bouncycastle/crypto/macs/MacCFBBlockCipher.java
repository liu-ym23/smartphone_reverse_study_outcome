package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
class MacCFBBlockCipher {
    private byte[] IV;
    private int blockSize;
    private byte[] cfbOutV;
    private byte[] cfbV;
    private BlockCipher cipher;

    public MacCFBBlockCipher(BlockCipher r100, int r101) {
        this.cipher = r100;
        this.blockSize = r101 / 8;
        this.IV = new byte[r100.getBlockSize()];
        this.cfbV = new byte[r100.getBlockSize()];
        this.cfbOutV = new byte[r100.getBlockSize()];
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void getMacBlock(byte[] r100) {
        this.cipher.processBlock(this.cfbV, 0, r100, 0);
    }

    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof ParametersWithIV) == false) goto L9;
        ParametersWithIV r101 = (ParametersWithIV) r100;
        byte[] r102 = r101.getIV();
        int r103 = r102.length;
        byte[] r104 = this.IV;
        if (r103 >= r104.length) goto L7;
        System.arraycopy(r102, 0, r104, r104.length - r102.length, r102.length);
    L8:
        reset();
        BlockCipher r105 = this.cipher;
        r100 = r101.getParameters();
    L10:
        r105.init(true, r100);
        return;
    L7:
        System.arraycopy(r102, 0, r104, 0, r104.length);
        goto L8
    L9:
        reset();
        r105 = this.cipher;
        goto L10
    }

    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        int r104 = this.blockSize;
        if ((r101 + r104) > r100.length) goto L15;
        if ((r104 + r103) > r102.length) goto L13;
        this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        int r105 = 0;
    L7:
        int r106 = this.blockSize;
        if (r105 >= r106) goto L10;
        r102[r103 + r105] = (byte) (this.cfbOutV[r105] ^ r100[r101 + r105]);
        r105 = r105 + 1;
        goto L7
    L10:
        byte[] r107 = this.cfbV;
        System.arraycopy(r107, r106, r107, 0, r107.length - r106);
        byte[] r108 = this.cfbV;
        int r109 = r108.length;
        int r110 = this.blockSize;
        System.arraycopy(r102, r103, r108, r109 - r110, r110);
        return this.blockSize;
    L13:
        throw new OutputLengthException("output buffer too short");
    L15:
        throw new DataLengthException("input buffer too short");
    }

    public void reset() {
        byte[] r100 = this.IV;
        System.arraycopy(r100, 0, this.cfbV, 0, r100.length);
        this.cipher.reset();
    }
}
