package org.bouncycastle.pqc.crypto.rainbow;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowKeyGenerationParameters extends KeyGenerationParameters {
    private RainbowParameters params;

    public RainbowKeyGenerationParameters(SecureRandom r100, RainbowParameters r101) {
        super(r100, r101.getVi()[r101.getVi().length - 1] - r101.getVi()[0]);
        this.params = r101;
    }

    public RainbowParameters getParameters() {
        return this.params;
    }
}
