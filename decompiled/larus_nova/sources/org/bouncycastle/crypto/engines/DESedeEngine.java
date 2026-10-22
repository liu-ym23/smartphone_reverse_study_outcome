package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class DESedeEngine extends DESEngine {
    protected static final int BLOCK_SIZE = 8;
    private boolean forEncryption;
    private int[] workingKey1;
    private int[] workingKey2;
    private int[] workingKey3;

    public DESedeEngine() {
        this.workingKey1 = null;
        this.workingKey2 = null;
        this.workingKey3 = null;
    }

    @Override // org.bouncycastle.crypto.engines.DESEngine, org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "DESede";
    }

    @Override // org.bouncycastle.crypto.engines.DESEngine, org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.engines.DESEngine, org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof KeyParameter) == false) goto L17;
        byte[] r102 = ((KeyParameter) r101).getKey();
        if (r102.length != 24) goto L7;
    L11:
        this.forEncryption = r100;
        byte[] r103 = new byte[8];
        System.arraycopy(r102, 0, r103, 0, 8);
        this.workingKey1 = generateWorkingKey(r100, r103);
        byte[] r104 = new byte[8];
        System.arraycopy(r102, 8, r104, 0, 8);
        this.workingKey2 = generateWorkingKey(!r100, r104);
        if (r102.length != 24) goto L14;
        byte[] r105 = new byte[8];
        System.arraycopy(r102, 16, r105, 0, 8);
        this.workingKey3 = generateWorkingKey(r100, r105);
        return;
    L14:
        this.workingKey3 = this.workingKey1;
        return;
    L7:
        if (r102.length == 16) goto L11;
        throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
    L17:
        throw new IllegalArgumentException("invalid parameter passed to DESede init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.engines.DESEngine, org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r110, byte[] r111, int r112) {
        int[] r101 = this.workingKey1;
        if (r101 == null) goto L18;
        if ((r110 + 8) > r100.length) goto L16;
        if ((r112 + 8) > r111.length) goto L14;
        byte[] r102 = new byte[8];
        if (this.forEncryption == false) goto L11;
        desFunc(r101, r100, r110, r102, 0);
        desFunc(this.workingKey2, r102, 0, r102, 0);
        desFunc(this.workingKey3, r102, 0, r111, r112);
    L12:
        return 8;
    L11:
        desFunc(this.workingKey3, r100, r110, r102, 0);
        desFunc(this.workingKey2, r102, 0, r102, 0);
        desFunc(this.workingKey1, r102, 0, r111, r112);
        goto L12
    L14:
        throw new OutputLengthException("output buffer too short");
    L16:
        throw new DataLengthException("input buffer too short");
    L18:
        throw new IllegalStateException("DESede engine not initialised");
    }

    @Override // org.bouncycastle.crypto.engines.DESEngine, org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
