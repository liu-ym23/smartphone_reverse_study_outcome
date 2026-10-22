package org.bouncycastle.crypto.modes;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes42.dex */
public class GOFBBlockCipher extends StreamBlockCipher {
    static final int C1 = 16843012;
    static final int C2 = 16843009;
    private byte[] IV;
    int N3;
    int N4;
    private final int blockSize;
    private int byteCount;
    private final BlockCipher cipher;
    boolean firstStep;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public GOFBBlockCipher(BlockCipher r100) {
        super(r100);
        this.firstStep = true;
        this.cipher = r100;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        if (r101 != 8) goto L7;
        this.IV = new byte[r100.getBlockSize()];
        this.ofbV = new byte[r100.getBlockSize()];
        this.ofbOutV = new byte[r100.getBlockSize()];
        return;
    L7:
        throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
    }

    private int bytesToint(byte[] r100, int r101) {
        return ((((r100[r101 + 3] << 24) & (-16777216)) + ((r100[r101 + 2] << 16) & 16711680)) + ((r100[r101 + 1] << 8) & 65280)) + (r100[r101] & UByte.MAX_VALUE);
    }

    private void intTobytes(int r100, byte[] r101, int r102) {
        r101[r102 + 3] = (byte) (r100 >>> 24);
        r101[r102 + 2] = (byte) (r100 >>> 16);
        r101[r102 + 1] = (byte) (r100 >>> 8);
        r101[r102] = (byte) r100;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) {
        if (this.byteCount == 0) goto L5;
    L12:
        byte[] r101 = this.ofbOutV;
        int r102 = this.byteCount;
        int r103 = r102 + 1;
        this.byteCount = r103;
        byte r104 = (byte) (r100 ^ r101[r102]);
        int r105 = this.blockSize;
        if (r103 != r105) goto L15;
        this.byteCount = 0;
        byte[] r106 = this.ofbV;
        System.arraycopy(r106, r105, r106, 0, r106.length - r105);
        byte[] r107 = this.ofbOutV;
        byte[] r108 = this.ofbV;
        int r109 = r108.length;
        int r110 = this.blockSize;
        System.arraycopy(r107, 0, r108, r109 - r110, r110);
    L15:
        return r104;
    L5:
        if (this.firstStep == false) goto L7;
        this.firstStep = false;
        this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
        this.N3 = bytesToint(this.ofbOutV, 0);
        this.N4 = bytesToint(this.ofbOutV, 4);
    L7:
        int r111 = this.N3 + 16843009;
        this.N3 = r111;
        int r112 = this.N4 + 16843012;
        this.N4 = r112;
        if (r112 >= 16843012) goto L11;
        if (r112 <= 0) goto L11;
        this.N4 = r112 + 1;
    L11:
        intTobytes(r111, this.ofbV, 0);
        intTobytes(this.N4, this.ofbV, 4);
        this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
        goto L12
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/GCTR";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.firstStep = true;
        this.N3 = 0;
        this.N4 = 0;
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
        this.firstStep = true;
        this.N3 = 0;
        this.N4 = 0;
        byte[] r100 = this.IV;
        System.arraycopy(r100, 0, this.ofbV, 0, r100.length);
        this.byteCount = 0;
        this.cipher.reset();
    }
}
