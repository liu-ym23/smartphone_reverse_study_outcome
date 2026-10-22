package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.BlockCipher;

/* JADX INFO: loaded from: classes42.dex */
public class X931RNG {
    private static final int BLOCK128_MAX_BITS_REQUEST = 262144;
    private static final long BLOCK128_RESEED_MAX = 8388608;
    private static final int BLOCK64_MAX_BITS_REQUEST = 4096;
    private static final long BLOCK64_RESEED_MAX = 32768;
    private final byte[] DT;
    private final byte[] I;
    private final byte[] R;
    private byte[] V;
    private final BlockCipher engine;
    private final EntropySource entropySource;
    private long reseedCounter;

    public X931RNG(BlockCipher r100, byte[] r101, EntropySource r102) {
        this.reseedCounter = 1;
        this.engine = r100;
        this.entropySource = r102;
        byte[] r103 = new byte[r100.getBlockSize()];
        this.DT = r103;
        System.arraycopy(r101, 0, r103, 0, r103.length);
        this.I = new byte[r100.getBlockSize()];
        this.R = new byte[r100.getBlockSize()];
    }

    private void increment(byte[] r100) {
        int r101 = r100.length - 1;
    L3:
        if (r101 < 0) goto L8;
        byte r102 = (byte) (r100[r101] + 1);
        r100[r101] = r102;
        if (r102 != 0) goto L11;
        r101 = r101 - 1;
        goto L3
    L11:
        return;
    }

    private static boolean isTooLarge(byte[] r100, int r101) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length <= r101) goto L6;
        return true;
    }

    private void process(byte[] r100, byte[] r101, byte[] r102) {
        int r103 = 0;
    L4:
        if (r103 == r100.length) goto L6;
        r100[r103] = (byte) (r101[r103] ^ r102[r103]);
        r103 = r103 + 1;
        goto L4
    L6:
        this.engine.processBlock(r100, 0, r100, 0);
    }

    public int generate(byte[] r100, boolean r101) {
        if (this.R.length != 8) goto L13;
        if (this.reseedCounter <= 32768) goto L8;
        return -1;
    L8:
        if (isTooLarge(r100, 512) == true) goto L11;
    L17:
        if (r101 == false) goto L19;
    L20:
        byte[] r102 = this.entropySource.getEntropy();
        this.V = r102;
        if (r102.length != this.engine.getBlockSize()) goto L31;
    L22:
        int r103 = r100.length / this.R.length;
        int r104 = 0;
    L23:
        if (r104 >= r103) goto L25;
        this.engine.processBlock(this.DT, 0, this.I, 0);
        process(this.R, this.I, this.V);
        process(this.V, this.R, this.I);
        byte[] r105 = this.R;
        System.arraycopy(r105, 0, r100, r105.length * r104, r105.length);
        increment(this.DT);
        r104 = r104 + 1;
        goto L23
    L25:
        int r106 = r100.length - (this.R.length * r103);
        if (r106 <= 0) goto L28;
        this.engine.processBlock(this.DT, 0, this.I, 0);
        process(this.R, this.I, this.V);
        process(this.V, this.R, this.I);
        byte[] r107 = this.R;
        System.arraycopy(r107, 0, r100, r103 * r107.length, r106);
        increment(this.DT);
    L28:
        this.reseedCounter++;
        return r100.length;
    L31:
        throw new IllegalStateException("Insufficient entropy returned");
    L19:
        if (this.V != null) goto L22;
    L11:
        throw new IllegalArgumentException("Number of bits per request limited to 4096");
    L13:
        if (this.reseedCounter <= BLOCK128_RESEED_MAX) goto L16;
        return -1;
    L16:
        if (isTooLarge(r100, 32768) == false) goto L17;
        throw new IllegalArgumentException("Number of bits per request limited to 262144");
    }

    public EntropySource getEntropySource() {
        return this.entropySource;
    }

    public void reseed() {
        byte[] r100 = this.entropySource.getEntropy();
        this.V = r100;
        if (r100.length != this.engine.getBlockSize()) goto L7;
        this.reseedCounter = 1;
        return;
    L7:
        throw new IllegalStateException("Insufficient entropy returned");
    }
}
