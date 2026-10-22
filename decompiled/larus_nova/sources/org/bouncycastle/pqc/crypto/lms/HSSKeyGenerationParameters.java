package org.bouncycastle.pqc.crypto.lms;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class HSSKeyGenerationParameters extends KeyGenerationParameters {
    private final LMSParameters[] lmsParameters;

    public HSSKeyGenerationParameters(LMSParameters[] r100, SecureRandom r101) {
        super(r101, LmsUtils.calculateStrength(r100[0]));
        if (r100.length == 0) goto L9;
        if (r100.length > 8) goto L9;
        this.lmsParameters = r100;
        return;
    L9:
        throw new IllegalArgumentException("lmsParameters length should be between 1 and 8 inclusive");
    }

    public int getDepth() {
        return this.lmsParameters.length;
    }

    public LMSParameters[] getLmsParameters() {
        return this.lmsParameters;
    }
}
