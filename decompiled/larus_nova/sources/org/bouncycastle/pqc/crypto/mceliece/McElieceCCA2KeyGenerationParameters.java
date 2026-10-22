package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2KeyGenerationParameters extends KeyGenerationParameters {
    private McElieceCCA2Parameters params;

    public McElieceCCA2KeyGenerationParameters(SecureRandom r100, McElieceCCA2Parameters r101) {
        super(r100, 128);
        this.params = r101;
    }

    public McElieceCCA2Parameters getParameters() {
        return this.params;
    }
}
