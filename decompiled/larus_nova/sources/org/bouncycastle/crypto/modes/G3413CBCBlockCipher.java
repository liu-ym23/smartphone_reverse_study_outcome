package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class G3413CBCBlockCipher implements BlockCipher {
    private byte[] R;
    private byte[] R_init;
    private int blockSize;
    private BlockCipher cipher;
    private boolean forEncryption;
    private boolean initialized;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525267m;

    public G3413CBCBlockCipher(BlockCipher r100) {
        this.initialized = false;
        this.blockSize = r100.getBlockSize();
        this.cipher = r100;
    }

    private int decrypt(byte[] r100, int r101, byte[] r102, int r103) {
        byte[] r104 = GOST3413CipherUtil.MSB(this.R, this.blockSize);
        byte[] r105 = GOST3413CipherUtil.copyFromInput(r100, this.blockSize, r101);
        byte[] r106 = new byte[r105.length];
        this.cipher.processBlock(r105, 0, r106, 0);
        byte[] r107 = GOST3413CipherUtil.sum(r106, r104);
        System.arraycopy(r107, 0, r102, r103, r107.length);
        if (r102.length <= (r103 + r107.length)) goto L6;
        generateR(r105);
    L6:
        return r107.length;
    }

    private int encrypt(byte[] r100, int r101, byte[] r102, int r103) {
        byte[] r104 = GOST3413CipherUtil.MSB(this.R, this.blockSize);
        byte[] r105 = GOST3413CipherUtil.sum(GOST3413CipherUtil.copyFromInput(r100, this.blockSize, r101), r104);
        int r106 = r105.length;
        byte[] r107 = new byte[r106];
        this.cipher.processBlock(r105, 0, r107, 0);
        System.arraycopy(r107, 0, r102, r103, r106);
        if (r102.length <= (r103 + r105.length)) goto L5;
        generateR(r107);
    L5:
        return r106;
    }

    private void generateR(byte[] r100) {
        byte[] r101 = GOST3413CipherUtil.LSB(this.R, this.f525267m - this.blockSize);
        System.arraycopy(r101, 0, this.R, 0, r101.length);
        System.arraycopy(r100, 0, this.R, r101.length, this.f525267m - r101.length);
    }

    private void initArrays() {
        int r100 = this.f525267m;
        this.R = new byte[r100];
        this.R_init = new byte[r100];
    }

    private void setupDefaultParams() {
        this.f525267m = this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CBC";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        if ((r101 instanceof ParametersWithIV) == false) goto L11;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        if (r103.length < this.blockSize) goto L10;
        this.f525267m = r103.length;
        initArrays();
        byte[] r104 = Arrays.clone(r103);
        this.R_init = r104;
        System.arraycopy(r104, 0, this.R, 0, r104.length);
        if (r102.getParameters() == null) goto L15;
        BlockCipher r105 = this.cipher;
        r101 = r102.getParameters();
    L14:
        r105.init(r100, r101);
    L15:
        this.initialized = true;
        return;
    L10:
        throw new IllegalArgumentException("Parameter m must blockSize <= m");
    L11:
        setupDefaultParams();
        initArrays();
        byte[] r106 = this.R_init;
        System.arraycopy(r106, 0, this.R, 0, r106.length);
        if (r101 == null) goto L15;
        r105 = this.cipher;
        goto L14
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.forEncryption == false) goto L6;
        return encrypt(r100, r101, r102, r103);
    L6:
        return decrypt(r100, r101, r102, r103);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        if (this.initialized == false) goto L6;
        byte[] r100 = this.R_init;
        System.arraycopy(r100, 0, this.R, 0, r100.length);
        this.cipher.reset();
        return;
    }
}
