package org.bouncycastle.crypto.prng;

/* JADX INFO: loaded from: classes42.dex */
public interface EntropySource {
    int entropySize();

    byte[] getEntropy();

    boolean isPredictionResistant();
}
