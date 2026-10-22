package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;

/* JADX INFO: loaded from: classes42.dex */
public class GCFBBlockCipher extends StreamBlockCipher {
    private static final byte[] C = null;
    private final CFBBlockCipher cfbEngine;
    private long counter;
    private boolean forEncryption;
    private KeyParameter key;

    static {
        C = new byte[]{105, 0, 114, 34, 100, -55, 4, 35, -115, 58, -37, -106, 70, -23, 42, -60, 24, -2, -84, -108, 0, -19, 7, 18, -64, -122, -36, -62, -17, 76, -87, 43};
    }

    public GCFBBlockCipher(BlockCipher r100) {
        super(r100);
        this.counter = 0;
        this.cfbEngine = new CFBBlockCipher(r100, r100.getBlockSize() * 8);
    }

    @Override // org.bouncycastle.crypto.StreamBlockCipher
    public byte calculateByte(byte r100) {
        long r101 = this.counter;
        if (r101 > 0) goto L5;
    L7:
        this.counter++;
        return this.cfbEngine.calculateByte(r100);
    L5:
        if ((r101 % 1024) != 0) goto L7;
        BlockCipher r102 = this.cfbEngine.getUnderlyingCipher();
        r102.init(false, this.key);
        byte[] r103 = new byte[32];
        byte[] r104 = C;
        r102.processBlock(r104, 0, r103, 0);
        r102.processBlock(r104, 8, r103, 8);
        r102.processBlock(r104, 16, r103, 16);
        r102.processBlock(r104, 24, r103, 24);
        KeyParameter r105 = new KeyParameter(r103);
        this.key = r105;
        r102.init(true, r105);
        byte[] r106 = this.cfbEngine.getCurrentIV();
        r102.processBlock(r106, 0, r106, 0);
        this.cfbEngine.init(this.forEncryption, new ParametersWithIV(this.key, r106));
        goto L7
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        String r100 = this.cfbEngine.getAlgorithmName();
        return r100.substring(0, r100.indexOf(47)) + "/G" + r100.substring(r100.indexOf(47) + 1);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cfbEngine.getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.counter = 0;
        this.cfbEngine.init(r100, r101);
        this.forEncryption = r100;
        if ((r101 instanceof ParametersWithIV) == false) goto L6;
        r101 = ((ParametersWithIV) r101).getParameters();
    L6:
        if ((r101 instanceof ParametersWithRandom) == false) goto L9;
        r101 = ((ParametersWithRandom) r101).getParameters();
    L9:
        if ((r101 instanceof ParametersWithSBox) == false) goto L11;
        r101 = ((ParametersWithSBox) r101).getParameters();
    L11:
        this.key = (KeyParameter) r101;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r110, int r111) throws DataLengthException, IllegalStateException {
        processBytes(r100, r101, this.cfbEngine.getBlockSize(), r110, r111);
        return this.cfbEngine.getBlockSize();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.counter = 0;
        this.cfbEngine.reset();
    }
}
