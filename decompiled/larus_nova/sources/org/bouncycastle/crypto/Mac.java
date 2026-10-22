package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface Mac {
    int doFinal(byte[] r100, int r101) throws DataLengthException, IllegalStateException;

    String getAlgorithmName();

    int getMacSize();

    void init(CipherParameters r100) throws IllegalArgumentException;

    void reset();

    void update(byte r100) throws IllegalStateException;

    void update(byte[] r100, int r101, int r102) throws DataLengthException, IllegalStateException;
}
