package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ECKeyGenerationParameters extends KeyGenerationParameters {
    private ECDomainParameters domainParams;

    public ECKeyGenerationParameters(ECDomainParameters r100, SecureRandom r101) {
        super(r101, r100.getN().bitLength());
        this.domainParams = r100;
    }

    public ECDomainParameters getDomainParameters() {
        return this.domainParams;
    }
}
