package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class KXTSBlockCipher extends BufferedBlockCipher {
    private static final long RED_POLY_128 = 135;
    private static final long RED_POLY_256 = 1061;
    private static final long RED_POLY_512 = 293;
    private final int blockSize;
    private int counter;
    private final long reductionPolynomial;
    private final long[] tw_current;
    private final long[] tw_init;

    public KXTSBlockCipher(BlockCipher r100) {
        this.cipher = r100;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        this.reductionPolynomial = getReductionPolynomial(r101);
        this.tw_init = new long[r101 >>> 3];
        this.tw_current = new long[r101 >>> 3];
        this.counter = -1;
    }

    private static void GF_double(long r100, long[] r110) {
        long r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r110.length) goto L6;
        long r103 = r110[r102];
        long r104 = r103 >>> 63;
        r110[r102] = r101 ^ (r103 << 1);
        r102 = r102 + 1;
        r101 = r104;
        goto L4
    L6:
        long r105 = r100 & (-r101);
        r110[0] = r105 ^ r110[0];
    }

    public static long getReductionPolynomial(int r100) {
        if (r100 != 16) goto L5;
        return RED_POLY_128;
    L5:
        if (r100 != 32) goto L7;
        return RED_POLY_256;
    L7:
        if (r100 != 64) goto L11;
        return RED_POLY_512;
    L11:
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    private void processBlock(byte[] r100, int r101, byte[] r102, int r110) {
        int r103 = this.counter;
        if (r103 == (-1)) goto L14;
        this.counter = r103 + 1;
        GF_double(this.reductionPolynomial, this.tw_current);
        byte[] r104 = new byte[this.blockSize];
        int r105 = 0;
        Pack.longToLittleEndian(this.tw_current, r104, 0);
        int r106 = this.blockSize;
        byte[] r107 = new byte[r106];
        System.arraycopy(r104, 0, r107, 0, r106);
        int r108 = 0;
    L6:
        if (r108 >= this.blockSize) goto L8;
        r107[r108] = (byte) (r107[r108] ^ r100[r101 + r108]);
        r108 = r108 + 1;
        goto L6
    L8:
        this.cipher.processBlock(r107, 0, r107, 0);
    L10:
        if (r105 >= this.blockSize) goto L12;
        r102[r110 + r105] = (byte) (r107[r105] ^ r104[r105]);
        r105 = r105 + 1;
        goto L10
    L12:
        return;
    L14:
        throw new IllegalStateException("Attempt to process too many blocks");
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int doFinal(byte[] r100, int r101) {
        reset();
        return 0;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int getOutputSize(int r100) {
        return r100;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int r100) {
        return r100;
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithIV) == false) goto L11;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        CipherParameters r103 = r102.getParameters();
        byte[] r104 = r102.getIV();
        int r105 = r104.length;
        int r106 = this.blockSize;
        if (r105 != r106) goto L9;
        byte[] r107 = new byte[r106];
        System.arraycopy(r104, 0, r107, 0, r106);
        this.cipher.init(true, r103);
        this.cipher.processBlock(r107, 0, r107, 0);
        this.cipher.init(r100, r103);
        Pack.littleEndianToLong(r107, 0, this.tw_init);
        long[] r108 = this.tw_init;
        System.arraycopy(r108, 0, this.tw_current, 0, r108.length);
        this.counter = 0;
        return;
    L9:
        throw new IllegalArgumentException("Currently only support IVs of exactly one block");
    L11:
        throw new IllegalArgumentException("Invalid parameters passed");
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int processByte(byte r100, byte[] r101, int r102) {
        throw new IllegalStateException("unsupported operation");
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        if ((r100.length - r101) < r102) goto L17;
        if ((r103.length - r101) < r102) goto L15;
        if ((r102 % this.blockSize) != 0) goto L13;
        int r105 = 0;
    L9:
        if (r105 >= r102) goto L11;
        processBlock(r100, r101 + r105, r103, r104 + r105);
        r105 = r105 + this.blockSize;
        goto L9
    L11:
        return r102;
    L13:
        throw new IllegalArgumentException("Partial blocks not supported");
    L15:
        throw new OutputLengthException("Output buffer too short");
    L17:
        throw new DataLengthException("Input buffer too short");
    }

    @Override // org.bouncycastle.crypto.BufferedBlockCipher
    public void reset() {
        this.cipher.reset();
        long[] r100 = this.tw_init;
        System.arraycopy(r100, 0, this.tw_current, 0, r100.length);
        this.counter = 0;
    }
}
