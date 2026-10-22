package org.bouncycastle.pqc.crypto.qtesla;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class QTESLAKeyGenerationParameters extends KeyGenerationParameters {
    private final int securityCategory;

    public QTESLAKeyGenerationParameters(int r100, SecureRandom r101) {
        super(r101, -1);
        QTESLASecurityCategory.getPrivateSize(r100);
        this.securityCategory = r100;
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
