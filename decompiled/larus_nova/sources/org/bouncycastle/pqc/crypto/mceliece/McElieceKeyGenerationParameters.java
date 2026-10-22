package org.bouncycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKeyGenerationParameters extends KeyGenerationParameters {
    private McElieceParameters params;

    public McElieceKeyGenerationParameters(SecureRandom r100, McElieceParameters r101) {
        super(r100, 256);
        this.params = r101;
    }

    public McElieceParameters getParameters() {
        return this.params;
    }
}
