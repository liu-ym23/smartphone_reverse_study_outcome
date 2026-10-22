package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface Signer {
    byte[] generateSignature() throws CryptoException, DataLengthException;

    void init(boolean r100, CipherParameters r101);

    void reset();

    void update(byte r100);

    void update(byte[] r100, int r101, int r102);

    boolean verifySignature(byte[] r100);
}
