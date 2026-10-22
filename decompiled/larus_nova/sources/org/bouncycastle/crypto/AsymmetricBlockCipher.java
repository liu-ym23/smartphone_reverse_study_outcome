package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface AsymmetricBlockCipher {
    int getInputBlockSize();

    int getOutputBlockSize();

    void init(boolean r100, CipherParameters r101);

    byte[] processBlock(byte[] r100, int r101, int r102) throws InvalidCipherTextException;
}
