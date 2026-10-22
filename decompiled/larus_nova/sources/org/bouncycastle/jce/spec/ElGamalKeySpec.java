package org.bouncycastle.jce.spec;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class ElGamalKeySpec implements KeySpec {
    private ElGamalParameterSpec spec;

    public ElGamalKeySpec(ElGamalParameterSpec r100) {
        this.spec = r100;
    }

    public ElGamalParameterSpec getParams() {
        return this.spec;
    }
}
