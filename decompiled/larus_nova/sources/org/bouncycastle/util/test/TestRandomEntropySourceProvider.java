package org.bouncycastle.util.test;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.crypto.prng.EntropySourceProvider;

/* JADX INFO: loaded from: classes42.dex */
public class TestRandomEntropySourceProvider implements EntropySourceProvider {
    private final boolean _predictionResistant;
    private final SecureRandom _sr;

    public TestRandomEntropySourceProvider(boolean r100) {
        this._sr = new SecureRandom();
        this._predictionResistant = r100;
    }

    public static /* synthetic */ boolean access$000(TestRandomEntropySourceProvider r100) {
        return r100._predictionResistant;
    }

    public static /* synthetic */ SecureRandom access$100(TestRandomEntropySourceProvider r100) {
        return r100._sr;
    }

    @Override // org.bouncycastle.crypto.prng.EntropySourceProvider
    public EntropySource get(final int r100) {
        return new AnonymousClass1(this, r100);
    }
}
