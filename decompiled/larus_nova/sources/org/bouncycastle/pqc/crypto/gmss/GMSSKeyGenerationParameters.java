package org.bouncycastle.pqc.crypto.gmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSKeyGenerationParameters extends KeyGenerationParameters {
    private GMSSParameters params;

    public GMSSKeyGenerationParameters(SecureRandom r100, GMSSParameters r101) {
        super(r100, 1);
        this.params = r101;
    }

    public GMSSParameters getParameters() {
        return this.params;
    }
}
