package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSMTKeyGenerationParameters extends KeyGenerationParameters {
    private final XMSSMTParameters xmssmtParameters;

    public XMSSMTKeyGenerationParameters(XMSSMTParameters r100, SecureRandom r101) {
        super(r101, -1);
        this.xmssmtParameters = r100;
    }

    public XMSSMTParameters getParameters() {
        return this.xmssmtParameters;
    }
}
