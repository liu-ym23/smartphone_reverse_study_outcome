package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface DerivationFunction {
    int generateBytes(byte[] r100, int r101, int r102) throws DataLengthException, IllegalArgumentException;

    void init(DerivationParameters r100);
}
