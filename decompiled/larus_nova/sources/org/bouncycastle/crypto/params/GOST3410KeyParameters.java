package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410KeyParameters extends AsymmetricKeyParameter {
    private GOST3410Parameters params;

    public GOST3410KeyParameters(boolean r100, GOST3410Parameters r101) {
        super(r100);
        this.params = r101;
    }

    public GOST3410Parameters getParameters() {
        return this.params;
    }
}
