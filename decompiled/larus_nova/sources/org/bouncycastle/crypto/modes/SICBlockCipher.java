package org.bouncycastle.crypto.modes;

import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes42.dex */
public class SICBlockCipher extends StreamBlockCipher implements SkippingStreamCipher {
    private byte[] IV;
    private final int blockSize;
    private int byteCount;
    private final BlockCipher cipher;
    private byte[] counter;
    private byte[] counterOut;

    public SICBlockCipher(BlockCipher r100) {
        super(r100);
        this.cipher = r100;
        int r101 = r100.getBlockSize();
        this.blockSize = r101;
        this.IV = new byte[r101];
        this.counter = new byte[r101];
        this.counterOut = new byte[r101];
        this.byteCount = 0;
    }

    private void adjustCounter(long r110) {
        int r100 = 5;
        long r101 = 0;
        if (r110 < 0) goto L14;
        long r102 = (((long) this.byteCount) + r110) / ((long) this.blockSize);
        long r103 = r102;
        if (r102 <= 255) goto L12;
    L6:
        if (r100 < 1) goto L12;
        long r104 = 1 << (r100 * 8);
    L9:
        if (r103 < r104) goto L11;
        incrementCounterAt(r100);
        r103 = r103 - r104;
        goto L9
    L11:
        r100 = r100 - 1;
    L12:
        incrementCounter((int) r103);
        int r111 = (int) ((r110 + ((long) this.byteCount)) - (((long) this.blockSize) * r102));
    L13:
        this.byteCount = r111;
        return;
    L14:
        long r105 = ((-r110) - ((long) this.byteCount)) / ((long) this.blockSize);
        long r106 = r105;
        if (r105 <= 255) goto L23;
    L16:
        if (r100 < 1) goto L23;
        long r112 = 1 << (r100 * 8);
    L19:
        if (r106 <= r112) goto L21;
        decrementCounterAt(r100);
        r106 = r106 - r112;
        goto L19
    L21:
        r100 = r100 - 1;
    L23:
        if (r101 == r106) goto L25;
        decrementCounterAt(0);
        r101 = r101 + 1;
        goto L23
    L25:
        int r113 = (int) ((((long) this.byteCount) + r110) + (((long) this.blockSize) * r105));
        if (r113 < 0) goto L28;
        this.byteCount = 0;
        return;
    L28:
        decrementCounterAt(0);
        r111 = this.blockSize + r113;
        goto L13
    }

    private void checkCounter() {
        if (this.IV.length >= this.blockSize) goto L12;
        int r100 = 0;
    L5:
        byte[] r101 = this.IV;
        if (r100 == r101.length) goto L15;
        if (this.counter[r100] != r101[r100]) goto L11;
        r100 = r100 + 1;
        goto L5
    L11:
        throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
    L15:
        return;
    }

    private void decrementCounterAt(int r100) {
        int r101 = this.counter.length - r100;
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L7;
        byte[] r102 = this.counter;
        byte r103 = (byte) (r102[r101] - 1);
        r102[r101] = r103;
        if (r103 == (-1)) goto L3;
        return;
    }

    private void incrementCounter(int r100) {
        byte[] r101 = this.counter;
        byte r102 = r101[r101.length - 1];
        int r103 = r101.length - 1;
        r101[r103] = (byte) (r101[r103] + r100);
        if (r102 != 0) goto L5;
        return;
    L5:
        if (r101[r101.length - 1] >= r102) goto L9;
        incrementCounterAt(1);
        return;
    }

    private void incrementCounterAt(int r100) {
        int r101 = this.counter.length - r100;
    L3:
        r101 = r101 - 1;
        if (r101 < 0) goto L7;
        byte[] r102 = this.counter;
        byte r103 = (byte) (r102[r101] + 1);
        r102[r101] = r103;
        if (r103 == 0) goto L3;
        return;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) throws DataLengthException, IllegalStateException {
        int r101 = this.byteCount;
        if (r101 != 0) goto L6;
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        byte[] r102 = this.counterOut;
        int r103 = this.byteCount;
        this.byteCount = r103 + 1;
        return (byte) (r100 ^ r102[r103]);
    L6:
        byte[] r104 = this.counterOut;
        int r105 = r101 + 1;
        this.byteCount = r105;
        byte r106 = (byte) (r100 ^ r104[r101]);
        if (r105 != this.counter.length) goto L9;
        this.byteCount = 0;
        incrementCounterAt(0);
        checkCounter();
    L9:
        return r106;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/SIC";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long getPosition() {
        byte[] r100 = this.counter;
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        System.arraycopy(r100, 0, r102, 0, r101);
        int r103 = r101 - 1;
    L4:
        if (r103 < 1) goto L13;
        byte[] r104 = this.IV;
        if (r103 >= r104.length) goto L8;
        int r105 = (r102[r103] & UByte.MAX_VALUE) - (r104[r103] & UByte.MAX_VALUE);
    L9:
        if (r105 >= 0) goto L11;
        int r106 = r103 - 1;
        r102[r106] = (byte) (r102[r106] - 1);
        r105 = r105 + 256;
    L11:
        r102[r103] = (byte) r105;
        r103 = r103 - 1;
        goto L4
    L8:
        r105 = r102[r103] & UByte.MAX_VALUE;
        goto L9
    L13:
        return (Pack.bigEndianToLong(r102, r101 - 8) * ((long) this.blockSize)) + ((long) this.byteCount);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        if ((r101 instanceof ParametersWithIV) == false) goto L21;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = Arrays.clone(r102.getIV());
        this.IV = r103;
        int r104 = this.blockSize;
        if (r104 < r103.length) goto L19;
        int r105 = 8;
        if (8 <= (r104 / 2)) goto L10;
        r105 = r104 / 2;
    L10:
        if ((r104 - r103.length) > r105) goto L17;
        if (r102.getParameters() == null) goto L14;
        this.cipher.init(true, r102.getParameters());
    L14:
        reset();
        return;
    L17:
        throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.blockSize - r105) + " bytes.");
    L19:
        throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.blockSize + " bytes.");
    L21:
        throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) throws DataLengthException, IllegalStateException {
        processBytes(r100, r101, this.blockSize, r102, r110);
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        Arrays.fill(this.counter, (byte) 0);
        byte[] r100 = this.IV;
        System.arraycopy(r100, 0, this.counter, 0, r100.length);
        this.cipher.reset();
        this.byteCount = 0;
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long seekTo(long r100) {
        reset();
        return skip(r100);
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long skip(long r100) {
        adjustCounter(r100);
        checkCounter();
        this.cipher.processBlock(this.counter, 0, this.counterOut, 0);
        return r100;
    }
}
