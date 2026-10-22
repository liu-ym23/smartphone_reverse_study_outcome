package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410KeyGenerationParameters extends KeyGenerationParameters {
    private GOST3410Parameters params;

    public GOST3410KeyGenerationParameters(SecureRandom r100, GOST3410Parameters r101) {
        super(r100, r101.getP().bitLength() - 1);
        this.params = r101;
    }

    public GOST3410Parameters getParameters() {
        return this.params;
    }
}
