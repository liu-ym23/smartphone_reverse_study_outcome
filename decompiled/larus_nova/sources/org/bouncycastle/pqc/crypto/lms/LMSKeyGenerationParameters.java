package org.bouncycastle.pqc.crypto.lms;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class LMSKeyGenerationParameters extends KeyGenerationParameters {
    private final LMSParameters lmsParameters;

    public LMSKeyGenerationParameters(LMSParameters r100, SecureRandom r101) {
        super(r101, LmsUtils.calculateStrength(r100));
        this.lmsParameters = r100;
    }

    public LMSParameters getParameters() {
        return this.lmsParameters;
    }
}
