package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class CramerShoupKeyGenerationParameters extends KeyGenerationParameters {
    private CramerShoupParameters params;

    public CramerShoupKeyGenerationParameters(SecureRandom r100, CramerShoupParameters r101) {
        super(r100, getStrength(r101));
        this.params = r101;
    }

    public static int getStrength(CramerShoupParameters r100) {
        return r100.getP().bitLength();
    }

    public CramerShoupParameters getParameters() {
        return this.params;
    }
}
