package org.bouncycastle.crypto.prng;

/* JADX INFO: loaded from: classes42.dex */
public interface RandomGenerator {
    void addSeedMaterial(long r100);

    void addSeedMaterial(byte[] r100);

    void nextBytes(byte[] r100);

    void nextBytes(byte[] r100, int r101, int r102);
}
