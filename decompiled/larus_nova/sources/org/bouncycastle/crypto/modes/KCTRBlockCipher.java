package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class KCTRBlockCipher extends StreamBlockCipher {
    private int byteCount;
    private BlockCipher engine;
    private boolean initialised;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525274iv;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public KCTRBlockCipher(BlockCipher r100) {
        super(r100);
        this.engine = r100;
        this.f525274iv = new byte[r100.getBlockSize()];
        this.ofbV = new byte[r100.getBlockSize()];
        this.ofbOutV = new byte[r100.getBlockSize()];
    }

    private void checkCounter() {
    }

    private void incrementCounterAt(int r100) {
    L2:
        byte[] r101 = this.ofbV;
        if (r100 >= r101.length) goto L8;
        int r102 = r100 + 1;
        byte r103 = (byte) (r101[r100] + 1);
        r101[r100] = r103;
        if (r103 != 0) goto L11;
        r100 = r102;
        goto L2
    L11:
        return;
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) {
        int r101 = this.byteCount;
        if (r101 != 0) goto L6;
        incrementCounterAt(0);
        checkCounter();
        this.engine.processBlock(this.ofbV, 0, this.ofbOutV, 0);
        byte[] r102 = this.ofbOutV;
        int r103 = this.byteCount;
        this.byteCount = r103 + 1;
        return (byte) (r100 ^ r102[r103]);
    L6:
        byte[] r104 = this.ofbOutV;
        int r105 = r101 + 1;
        this.byteCount = r105;
        byte r106 = (byte) (r100 ^ r104[r101]);
        if (r105 != this.ofbV.length) goto L9;
        this.byteCount = 0;
    L9:
        return r106;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KCTR";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.engine.getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.initialised = true;
        if ((r101 instanceof ParametersWithIV) == false) goto L10;
        ParametersWithIV r102 = (ParametersWithIV) r101;
        byte[] r103 = r102.getIV();
        byte[] r104 = this.f525274iv;
        int r105 = r104.length - r103.length;
        Arrays.fill(r104, (byte) 0);
        System.arraycopy(r103, 0, this.f525274iv, r105, r103.length);
        CipherParameters r106 = r102.getParameters();
        if (r106 == null) goto L7;
        this.engine.init(true, r106);
    L7:
        reset();
        return;
    L10:
        throw new IllegalArgumentException("invalid parameter passed");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r110, byte[] r111, int r112) throws DataLengthException, IllegalStateException {
        if ((r100.length - r110) < getBlockSize()) goto L11;
        if ((r111.length - r112) < getBlockSize()) goto L9;
        processBytes(r100, r110, getBlockSize(), r111, r112);
        return getBlockSize();
    L9:
        throw new OutputLengthException("output buffer too short");
    L11:
        throw new DataLengthException("input buffer too short");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        if (this.initialised == false) goto L5;
        this.engine.processBlock(this.f525274iv, 0, this.ofbV, 0);
    L5:
        this.engine.reset();
        this.byteCount = 0;
    }
}
