package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public final class XMSSKeyGenerationParameters extends KeyGenerationParameters {
    private final XMSSParameters xmssParameters;

    public XMSSKeyGenerationParameters(XMSSParameters r100, SecureRandom r101) {
        super(r101, -1);
        this.xmssParameters = r100;
    }

    public XMSSParameters getParameters() {
        return this.xmssParameters;
    }
}
