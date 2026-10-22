package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class G3413CFBBlockCipher extends StreamBlockCipher {
    private byte[] R;
    private byte[] R_init;
    private int blockSize;
    private int byteCount;
    private BlockCipher cipher;
    private boolean forEncryption;
    private byte[] gamma;
    private byte[] inBuf;
    private boolean initialized;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f525268m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f525269s;

    public G3413CFBBlockCipher(BlockCipher r100) {
        this(r100, r100.getBlockSize() * 8);
    }

    public G3413CFBBlockCipher(BlockCipher r100, int r101) {
        super(r100);
        this.initialized = false;
        if (r101 < 0) goto L9;
        if (r101 > (r100.getBlockSize() * 8)) goto L9;
        this.blockSize = r100.getBlockSize();
        this.cipher = r100;
        this.f525269s = r101 / 8;
        this.inBuf = new byte[getBlockSize()];
        return;
    L9:
        throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (r100.getBlockSize() * 8));
    }

    private void initArrays() {
        int r100 = this.f525268m;
        this.R = new byte[r100];
        this.R_init = new byte[r100];
    }

    private void setupDefaultParams() {
        this.f525268m = this.blockSize * 2;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) {
        if (this.byteCount != 0) goto L5;
        this.gamma = createGamma();
    L5:
        byte[] r101 = this.gamma;
        int r102 = this.byteCount;
        byte r103 = (byte) (r101[r102] ^ r100);
        byte[] r104 = this.inBuf;
        int r105 = r102 + 1;
        this.byteCount = r105;
        if (this.forEncryption == false) goto L8;
        r100 = r103;
    L8:
        r104[r102] = r100;
        if (r105 != getBlockSize()) goto L11;
        this.byteCount = 0;
        generateR(this.inBuf);
    L11:
        return r103;
    }

    public byte[] createGamma() {
        byte[] r100 = GOST3413CipherUtil.MSB(this.R, this.blockSize);
        byte[] r101 = new byte[r100.length];
        this.cipher.processBlock(r100, 0, r101, 0);
        return GOST3413CipherUtil.MSB(r101, this.f525269s);
    }

    public void generateR(byte[] r100) {
        byte[] r101 = GOST3413CipherUtil.LSB(this.R, this.f525268m - this.f525269s);
        System.arraycopy(r101, 0, this.R, 0, r101.length);
        System.arraycopy(r100, 0, this.R, r101.length, this.f525268m - r101.length);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.f525269s;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.forEncryption = r100;
        if ((r101 instanceof ParametersWithIV) == false) goto L11;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        if (r103.length < this.blockSize) goto L10;
        this.f525268m = r103.length;
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
        processBytes(r100, r101, getBlockSize(), r102, r110);
        return getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.byteCount = 0;
        Arrays.clear(this.inBuf);
        Arrays.clear(this.gamma);
        if (this.initialized == false) goto L6;
        byte[] r100 = this.R_init;
        System.arraycopy(r100, 0, this.R, 0, r100.length);
        this.cipher.reset();
        return;
    }
}
