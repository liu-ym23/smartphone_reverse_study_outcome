package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface BlockCipher {
    String getAlgorithmName();

    int getBlockSize();

    void init(boolean r100, CipherParameters r101) throws IllegalArgumentException;

    int processBlock(byte[] r100, int r101, byte[] r102, int r103) throws DataLengthException, IllegalStateException;

    void reset();
}
