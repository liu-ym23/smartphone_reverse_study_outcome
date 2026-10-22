package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes42.dex */
public class BasicEntropySourceProvider implements EntropySourceProvider {
    private final boolean _predictionResistant;
    private final SecureRandom _sr;

    public BasicEntropySourceProvider(SecureRandom r100, boolean r101) {
        this._sr = r100;
        this._predictionResistant = r101;
    }

    public static /* synthetic */ boolean access$000(BasicEntropySourceProvider r100) {
        return r100._predictionResistant;
    }

    public static /* synthetic */ SecureRandom access$100(BasicEntropySourceProvider r100) {
        return r100._sr;
    }

    @Override // org.bouncycastle.crypto.prng.EntropySourceProvider
    public EntropySource get(final int r100) {
        return new AnonymousClass1(this, r100);
    }
}
