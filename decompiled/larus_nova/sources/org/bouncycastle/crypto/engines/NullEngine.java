package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes42.dex */
public class NullEngine implements BlockCipher {
    protected static final int DEFAULT_BLOCK_SIZE = 1;
    private final int blockSize;
    private boolean initialised;

    public NullEngine() {
        this(1);
    }

    public NullEngine(int r100) {
        this.blockSize = r100;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Null";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) throws IllegalArgumentException {
        this.initialised = true;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException {
        if (this.initialised == false) goto L18;
        int r104 = this.blockSize;
        if ((r101 + r104) > r100.length) goto L16;
        if ((r104 + r103) > r102.length) goto L14;
        int r105 = 0;
    L9:
        int r106 = this.blockSize;
        if (r105 >= r106) goto L12;
        r102[r103 + r105] = r100[r101 + r105];
        r105 = r105 + 1;
        goto L9
    L12:
        return r106;
    L14:
        throw new OutputLengthException("output buffer too short");
    L16:
        throw new DataLengthException("input buffer too short");
    L18:
        throw new IllegalStateException("Null engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
