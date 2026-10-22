package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class RSAEngine implements AsymmetricBlockCipher {
    private RSACoreEngine core;

    public RSAEngine() {
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.core.getInputBlockSize();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        return this.core.getOutputBlockSize();
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if (this.core != null) goto L5;
        this.core = new RSACoreEngine();
    L5:
        this.core.init(r100, r101);
    }

    @Override // org.bouncycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] r100, int r101, int r102) {
        RSACoreEngine r103 = this.core;
        if (r103 == null) goto L7;
        return r103.convertOutput(r103.processBlock(r103.convertInput(r100, r101, r102)));
    L7:
        throw new IllegalStateException("RSA engine not initialised");
    }
}
