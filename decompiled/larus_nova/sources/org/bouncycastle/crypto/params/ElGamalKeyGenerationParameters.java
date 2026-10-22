package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalKeyGenerationParameters extends KeyGenerationParameters {
    private ElGamalParameters params;

    public ElGamalKeyGenerationParameters(SecureRandom r100, ElGamalParameters r101) {
        super(r100, getStrength(r101));
        this.params = r101;
    }

    public static int getStrength(ElGamalParameters r100) {
        if (r100.getL() == 0) goto L6;
        return r100.getL();
    L6:
        return r100.getP().bitLength();
    }

    public ElGamalParameters getParameters() {
        return this.params;
    }
}
