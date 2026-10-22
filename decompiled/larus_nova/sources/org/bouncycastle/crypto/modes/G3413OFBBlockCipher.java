package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class G3413OFBBlockCipher extends StreamBlockCipher {
    private byte[] R;
    private byte[] R_init;
    private byte[] Y;
    private int blockSize;
    private int byteCount;
    private BlockCipher cipher;
    private boolean initialized;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525271m;

    public G3413OFBBlockCipher(BlockCipher r100) {
        super(r100);
        this.initialized = false;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        this.cipher = r100;
        this.Y = new byte[r101];
    }

    private void generateR() {
        byte[] r100 = GOST3413CipherUtil.LSB(this.R, this.f525271m - this.blockSize);
        System.arraycopy(r100, 0, this.R, 0, r100.length);
        System.arraycopy(this.Y, 0, this.R, r100.length, this.f525271m - r100.length);
    }

    private void generateY() {
        byte[] r100 = GOST3413CipherUtil.MSB(this.R, this.blockSize);
        this.cipher.processBlock(r100, 0, this.Y, 0);
    }

    private void initArrays() {
        int r100 = this.f525271m;
        this.R = new byte[r100];
        this.R_init = new byte[r100];
    }

    private void setupDefaultParams() {
        this.f525271m = this.blockSize * 2;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) {
        if (this.byteCount != 0) goto L5;
        generateY();
    L5:
        byte[] r101 = this.Y;
        int r102 = this.byteCount;
        byte r103 = (byte) (r100 ^ r101[r102]);
        int r104 = r102 + 1;
        this.byteCount = r104;
        if (r104 != getBlockSize()) goto L8;
        this.byteCount = 0;
        generateR();
    L8:
        return r103;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OFB";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof ParametersWithIV) == false) goto L11;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        if (r103.length < this.blockSize) goto L10;
        this.f525271m = r103.length;
        initArrays();
        byte[] r104 = Arrays.clone(r103);
        this.R_init = r104;
        System.arraycopy(r104, 0, this.R, 0, r104.length);
        if (r102.getParameters() == null) goto L15;
        BlockCipher r105 = this.cipher;
        r101 = r102.getParameters();
    L14:
        r105.init(true, r101);
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
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        processBytes(r100, r101, this.blockSize, r102, r110);
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        if (this.initialized == false) goto L6;
        byte[] r100 = this.R_init;
        System.arraycopy(r100, 0, this.R, 0, r100.length);
        Arrays.clear(this.Y);
        this.byteCount = 0;
        this.cipher.reset();
        return;
    }
}
