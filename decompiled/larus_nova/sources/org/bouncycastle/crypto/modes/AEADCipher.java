package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes42.dex */
public interface AEADCipher {
    int doFinal(byte[] r100, int r101) throws IllegalStateException, InvalidCipherTextException;

    String getAlgorithmName();

    byte[] getMac();

    int getOutputSize(int r100);

    int getUpdateOutputSize(int r100);

    void init(boolean r100, CipherParameters r101) throws IllegalArgumentException;

    void processAADByte(byte r100);

    void processAADBytes(byte[] r100, int r101, int r102);

    int processByte(byte r100, byte[] r101, int r102) throws DataLengthException;

    int processBytes(byte[] r100, int r101, int r102, byte[] r103, int r104) throws DataLengthException;

    void reset();
}
