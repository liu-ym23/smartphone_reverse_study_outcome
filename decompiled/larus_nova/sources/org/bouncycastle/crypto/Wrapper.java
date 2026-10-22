package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface Wrapper {
    String getAlgorithmName();

    void init(boolean r100, CipherParameters r101);

    byte[] unwrap(byte[] r100, int r101, int r102) throws InvalidCipherTextException;

    byte[] wrap(byte[] r100, int r101, int r102);
}
