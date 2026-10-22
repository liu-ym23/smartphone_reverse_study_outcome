package org.bouncycastle.crypto.prng.drbg;

/* JADX INFO: loaded from: classes42.dex */
public interface SP80090DRBG {
    int generate(byte[] r100, byte[] r101, boolean r102);

    int getBlockSize();

    void reseed(byte[] r100);
}
