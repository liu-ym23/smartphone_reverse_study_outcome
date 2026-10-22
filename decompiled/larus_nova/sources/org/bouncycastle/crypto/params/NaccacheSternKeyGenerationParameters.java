package org.bouncycastle.crypto.params;

import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class NaccacheSternKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private int cntSmallPrimes;
    private boolean debug;

    public NaccacheSternKeyGenerationParameters(SecureRandom r100, int r101, int r102, int r110) {
        this(r100, r101, r102, r110, false);
    }

    public NaccacheSternKeyGenerationParameters(SecureRandom r100, int r101, int r102, int r103, boolean r104) {
        super(r100, r101);
        this.debug = false;
        this.certainty = r102;
        if ((r103 % 2) == 1) goto L11;
        if (r103 < 30) goto L9;
        this.cntSmallPrimes = r103;
        this.debug = r104;
        return;
    L9:
        throw new IllegalArgumentException("cntSmallPrimes must be >= 30 for security reasons");
    L11:
        throw new IllegalArgumentException("cntSmallPrimes must be a multiple of 2");
    }

    public int getCertainty() {
        return this.certainty;
    }

    public int getCntSmallPrimes() {
        return this.cntSmallPrimes;
    }

    public boolean isDebug() {
        return this.debug;
    }
}
