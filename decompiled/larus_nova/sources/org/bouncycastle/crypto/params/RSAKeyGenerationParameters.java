package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.KeyGenerationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class RSAKeyGenerationParameters extends KeyGenerationParameters {
    private int certainty;
    private BigInteger publicExponent;

    public RSAKeyGenerationParameters(BigInteger r100, SecureRandom r101, int r102, int r103) {
        super(r101, r102);
        if (r102 < 12) goto L11;
        if (r100.testBit(0) == false) goto L9;
        this.publicExponent = r100;
        this.certainty = r103;
        return;
    L9:
        throw new IllegalArgumentException("public exponent cannot be even");
    L11:
        throw new IllegalArgumentException("key strength too small");
    }

    public int getCertainty() {
        return this.certainty;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }
}
