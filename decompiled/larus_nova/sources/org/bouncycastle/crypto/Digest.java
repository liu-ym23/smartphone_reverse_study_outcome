package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes42.dex */
public interface Digest {
    int doFinal(byte[] r100, int r101);

    String getAlgorithmName();

    int getDigestSize();

    void reset();

    void update(byte r100);

    void update(byte[] r100, int r101, int r102);
}
