package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

/* JADX INFO: loaded from: classes42.dex */
interface DRBGProvider {
    SP80090DRBG get(EntropySource r100);

    String getAlgorithm();
}
