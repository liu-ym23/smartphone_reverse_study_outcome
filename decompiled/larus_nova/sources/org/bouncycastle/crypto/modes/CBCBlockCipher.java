package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class CBCBlockCipher implements BlockCipher {
    private byte[] IV;
    private int blockSize;
    private byte[] cbcNextV;
    private byte[] cbcV;
    private BlockCipher cipher;
    private boolean encrypting;

    public CBCBlockCipher(BlockCipher r100) {
        this.cipher = r100;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        this.IV = new byte[r101];
        this.cbcV = new byte[r101];
        this.cbcNextV = new byte[r101];
    }

    private int decryptBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        int r104 = this.blockSize;
        if ((r101 + r104) > r100.length) goto L11;
        int r105 = 0;
        System.arraycopy(r100, r101, this.cbcNextV, 0, r104);
        int r106 = this.cipher.processBlock(r100, r101, r102, r103);
    L6:
        if (r105 >= this.blockSize) goto L8;
        int r107 = r103 + r105;
        r102[r107] = (byte) (r102[r107] ^ this.cbcV[r105]);
        r105 = r105 + 1;
        goto L6
    L8:
        byte[] r108 = this.cbcV;
        this.cbcV = this.cbcNextV;
        this.cbcNextV = r108;
        return r106;
    L11:
        throw new DataLengthException("input buffer too short");
    }

    private int encryptBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if ((this.blockSize + r101) > r100.length) goto L11;
        int r104 = 0;
    L6:
        if (r104 >= this.blockSize) goto L8;
        byte[] r105 = this.cbcV;
        r105[r104] = (byte) (r105[r104] ^ r100[r101 + r104]);
        r104 = r104 + 1;
        goto L6
    L8:
        int r106 = this.cipher.processBlock(this.cbcV, 0, r102, r103);
        byte[] r107 = this.cbcV;
        System.arraycopy(r102, r103, r107, 0, r107.length);
        return r106;
    L11:
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CBC";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        boolean r102 = this.encrypting;
        this.encrypting = r100;
        if ((r101 instanceof ParametersWithIV) == false) goto L15;
        ParametersWithIV r103 = (ParametersWithIV) r101;
        byte[] r104 = r103.getIV();
        if (r104.length != this.blockSize) goto L14;
        System.arraycopy(r104, 0, this.IV, 0, r104.length);
        reset();
        if (r103.getParameters() == null) goto L9;
        BlockCipher r105 = this.cipher;
        r101 = r103.getParameters();
    L18:
        r105.init(r100, r101);
        return;
    L9:
        if (r102 != r100) goto L12;
        return;
    L12:
        throw new IllegalArgumentException("cannot change encrypting state without providing key.");
    L14:
        throw new IllegalArgumentException("initialisation vector must be the same length as block size");
    L15:
        reset();
        if (r101 == null) goto L19;
        r105 = this.cipher;
        goto L18
    L19:
        if (r102 != r100) goto L22;
        return;
    L22:
        throw new IllegalArgumentException("cannot change encrypting state without providing key.");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.encrypting == false) goto L6;
        return encryptBlock(r100, r101, r102, r103);
    L6:
        return decryptBlock(r100, r101, r102, r103);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        byte[] r100 = this.IV;
        System.arraycopy(r100, 0, this.cbcV, 0, r100.length);
        Arrays.fill(this.cbcNextV, (byte) 0);
        this.cipher.reset();
    }
}
