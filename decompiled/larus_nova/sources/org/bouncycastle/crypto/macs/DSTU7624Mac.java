package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.DSTU7624Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU7624Mac implements Mac {
    private static final int BITS_IN_BYTE = 8;
    private int blockSize;
    private byte[] buf;
    private int bufOff;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f525228c;
    private byte[] cTemp;
    private DSTU7624Engine engine;
    private boolean initCalled;
    private byte[] kDelta;
    private int macSize;

    public DSTU7624Mac(int r100, int r101) {
        this.initCalled = false;
        this.engine = new DSTU7624Engine(r100);
        int r102 = r100 / 8;
        this.blockSize = r102;
        this.macSize = r101 / 8;
        this.f525228c = new byte[r102];
        this.kDelta = new byte[r102];
        this.cTemp = new byte[r102];
        this.buf = new byte[r102];
    }

    private void processBlock(byte[] r100, int r101) {
        xor(this.f525228c, 0, r100, r101, this.cTemp);
        this.engine.processBlock(this.cTemp, 0, this.f525228c, 0);
    }

    private void xor(byte[] r100, int r101, byte[] r102, int r103, byte[] r104) {
        int r105 = r100.length - r101;
        int r106 = this.blockSize;
        if (r105 < r106) goto L14;
        if ((r102.length - r103) < r106) goto L14;
        if (r104.length < r106) goto L14;
        int r107 = 0;
    L10:
        if (r107 >= this.blockSize) goto L12;
        r104[r107] = (byte) (r100[r107 + r101] ^ r102[r107 + r103]);
        r107 = r107 + 1;
        goto L10
    L12:
        return;
    L14:
        throw new IllegalArgumentException("some of input buffers too short");
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] r110, int r111) throws DataLengthException, IllegalStateException {
        int r100 = this.bufOff;
        byte[] r101 = this.buf;
        if ((r100 % r101.length) != 0) goto L11;
        xor(this.f525228c, 0, r101, 0, this.cTemp);
        xor(this.cTemp, 0, this.kDelta, 0, this.f525228c);
        DSTU7624Engine r102 = this.engine;
        byte[] r103 = this.f525228c;
        r102.processBlock(r103, 0, r103, 0);
        int r104 = this.macSize;
        if ((r104 + r111) > r110.length) goto L9;
        System.arraycopy(this.f525228c, 0, r110, r111, r104);
        reset();
        return this.macSize;
    L9:
        throw new OutputLengthException("output buffer too short");
    L11:
        throw new DataLengthException("input must be a multiple of blocksize");
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "DSTU7624Mac";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters r100) throws IllegalArgumentException {
        if ((r100 instanceof KeyParameter) == false) goto L7;
        this.engine.init(true, r100);
        this.initCalled = true;
        reset();
        return;
    L7:
        throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        Arrays.fill(this.f525228c, (byte) 0);
        Arrays.fill(this.cTemp, (byte) 0);
        Arrays.fill(this.kDelta, (byte) 0);
        Arrays.fill(this.buf, (byte) 0);
        this.engine.reset();
        if (this.initCalled == false) goto L5;
        DSTU7624Engine r100 = this.engine;
        byte[] r101 = this.kDelta;
        r100.processBlock(r101, 0, r101, 0);
    L5:
        this.bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte r100) {
        int r101 = this.bufOff;
        byte[] r102 = this.buf;
        if (r101 != r102.length) goto L5;
        processBlock(r102, 0);
        this.bufOff = 0;
    L5:
        byte[] r103 = this.buf;
        int r104 = this.bufOff;
        this.bufOff = r104 + 1;
        r103[r104] = r100;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] r100, int r101, int r102) {
        if (r102 < 0) goto L11;
        int r103 = this.engine.getBlockSize();
        int r104 = this.bufOff;
        int r105 = r103 - r104;
        if (r102 <= r105) goto L8;
        System.arraycopy(r100, r101, this.buf, r104, r105);
        processBlock(this.buf, 0);
        this.bufOff = 0;
        r102 = r102 - r105;
        r101 = r101 + r105;
    L6:
        if (r102 <= r103) goto L8;
        processBlock(r100, r101);
        r102 = r102 - r103;
        r101 = r101 + r103;
    L8:
        System.arraycopy(r100, r101, this.buf, this.bufOff, r102);
        this.bufOff += r102;
        return;
    L11:
        throw new IllegalArgumentException("can't have a negative input length!");
    }
}
