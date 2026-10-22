package org.bouncycastle.jce.spec;

import java.security.spec.KeySpec;

/* JADX INFO: loaded from: classes42.dex */
public class ECKeySpec implements KeySpec {
    private ECParameterSpec spec;

    public ECKeySpec(ECParameterSpec r100) {
        this.spec = r100;
    }

    public ECParameterSpec getParams() {
        return this.spec;
    }
}
