package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface StreamCipher {
    String getAlgorithmName();

    void init(boolean r100, CipherParameters r101) throws IllegalArgumentException;

    int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException;

    void reset();

    byte returnByte(byte r100);
}
