package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class DSAKeyParameters extends AsymmetricKeyParameter {
    private DSAParameters params;

    public DSAKeyParameters(boolean r100, DSAParameters r101) {
        super(r100);
        this.params = r101;
    }

    public DSAParameters getParameters() {
        return this.params;
    }
}
