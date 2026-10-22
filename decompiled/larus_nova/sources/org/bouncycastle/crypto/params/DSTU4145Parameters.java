package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU4145Parameters extends ECDomainParameters {
    private final byte[] dke;

    public DSTU4145Parameters(ECDomainParameters r100, byte[] r101) {
        super(r100.getCurve(), r100.getG(), r100.getN(), r100.getH(), r100.getSeed());
        this.dke = Arrays.clone(r101);
    }

    public byte[] getDKE() {
        return Arrays.clone(this.dke);
    }
}
