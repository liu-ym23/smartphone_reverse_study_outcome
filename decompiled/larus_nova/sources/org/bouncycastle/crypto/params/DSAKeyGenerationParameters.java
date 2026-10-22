package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class DSAKeyGenerationParameters extends KeyGenerationParameters {
    private DSAParameters params;

    public DSAKeyGenerationParameters(SecureRandom r100, DSAParameters r101) {
        super(r100, r101.getP().bitLength() - 1);
        this.params = r101;
    }

    public DSAParameters getParameters() {
        return this.params;
    }
}
