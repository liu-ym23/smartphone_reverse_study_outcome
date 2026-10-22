package org.bouncycastle.jcajce.spec;

import java.math.BigInteger;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class DHExtendedPublicKeySpec extends DHPublicKeySpec {
    private final DHParameterSpec params;

    public DHExtendedPublicKeySpec(BigInteger r100, DHParameterSpec r101) {
        super(r100, r101.getP(), r101.getG());
        this.params = r101;
    }

    public DHParameterSpec getParams() {
        return this.params;
    }
}
