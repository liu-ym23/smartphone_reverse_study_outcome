package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class G3413CTRBlockCipher extends StreamBlockCipher {
    private byte[] CTR;
    private byte[] IV;
    private final int blockSize;
    private byte[] buf;
    private int byteCount;
    private final BlockCipher cipher;
    private boolean initialized;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f525270s;

    public G3413CTRBlockCipher(BlockCipher r100) {
        this(r100, r100.getBlockSize() * 8);
    }

    public G3413CTRBlockCipher(BlockCipher r100, int r101) {
        super(r100);
        this.byteCount = 0;
        if (r101 < 0) goto L9;
        if (r101 > (r100.getBlockSize() * 8)) goto L9;
        this.cipher = r100;
        int r102 = r100.getBlockSize();
        this.blockSize = r102;
        this.f525270s = r101 / 8;
        this.CTR = new byte[r102];
        return;
    L9:
        throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (r100.getBlockSize() * 8));
    }

    private byte[] generateBuf() {
        byte[] r100 = this.CTR;
        byte[] r101 = new byte[r100.length];
        this.cipher.processBlock(r100, 0, r101, 0);
        return GOST3413CipherUtil.MSB(r101, this.f525270s);
    }

    private void generateCRT() {
        byte[] r100 = this.CTR;
        int r101 = r100.length - 1;
        r100[r101] = (byte) (r100[r101] + 1);
    }

    private void initArrays() {
        int r100 = this.blockSize;
        this.IV = new byte[r100 / 2];
        this.CTR = new byte[r100];
        this.buf = new byte[this.f525270s];
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) {
        if (this.byteCount != 0) goto L5;
        this.buf = generateBuf();
    L5:
        byte[] r101 = this.buf;
        int r102 = this.byteCount;
        byte r103 = (byte) (r100 ^ r101[r102]);
        int r104 = r102 + 1;
        this.byteCount = r104;
        if (r104 != this.f525270s) goto L8;
        this.byteCount = 0;
        generateCRT();
    L8:
        return r103;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCTR";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.f525270s;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof ParametersWithIV) == false) goto L15;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        initArrays();
        byte[] r103 = Arrays.clone(r102.getIV());
        this.IV = r103;
        if (r103.length != (this.blockSize / 2)) goto L14;
        System.arraycopy(r103, 0, this.CTR, 0, r103.length);
        int r104 = this.IV.length;
    L8:
        if (r104 >= this.blockSize) goto L11;
        this.CTR[r104] = 0;
        r104 = r104 + 1;
        goto L8
    L11:
        if (r102.getParameters() == null) goto L19;
        BlockCipher r105 = this.cipher;
        r101 = r102.getParameters();
    L18:
        r105.init(true, r101);
    L19:
        this.initialized = true;
        return;
    L14:
        throw new IllegalArgumentException("Parameter IV length must be == blockSize/2");
    L15:
        initArrays();
        if (r101 == null) goto L19;
        r105 = this.cipher;
        goto L18
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        processBytes(r100, r101, this.f525270s, r102, r110);
        return this.f525270s;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        if (this.initialized == false) goto L11;
        byte[] r100 = this.IV;
        System.arraycopy(r100, 0, this.CTR, 0, r100.length);
        int r101 = this.IV.length;
    L6:
        if (r101 >= this.blockSize) goto L8;
        this.CTR[r101] = 0;
        r101 = r101 + 1;
        goto L6
    L8:
        this.byteCount = 0;
        this.cipher.reset();
        return;
    }
}
