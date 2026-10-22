package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;

/* JADX INFO: loaded from: classes42.dex */
public class ParametersWithRandom implements CipherParameters {
    private CipherParameters parameters;
    private SecureRandom random;

    public ParametersWithRandom(CipherParameters r100) {
        this(r100, null);
    }

    public ParametersWithRandom(CipherParameters r100, SecureRandom r101) {
        this.random = CryptoServicesRegistrar.getSecureRandom(r101);
        this.parameters = r100;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    public SecureRandom getRandom() {
        return this.random;
    }
}
