package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DHKeyGenerationParameters extends KeyGenerationParameters {
    private DHParameters params;

    public DHKeyGenerationParameters(SecureRandom r100, DHParameters r101) {
        super(r100, getStrength(r101));
        this.params = r101;
    }

    public static int getStrength(DHParameters r100) {
        if (r100.getL() == 0) goto L6;
        return r100.getL();
    L6:
        return r100.getP().bitLength();
    }

    public DHParameters getParameters() {
        return this.params;
    }
}
