package org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class DHExtendedPrivateKeySpec extends DHPrivateKeySpec {
    private final DHParameterSpec params;

    public DHExtendedPrivateKeySpec(BigInteger r100, DHParameterSpec r101) {
        super(r100, r101.getP(), r101.getG());
        this.params = r101;
    }

    public DHParameterSpec getParams() {
        return this.params;
    }
}
