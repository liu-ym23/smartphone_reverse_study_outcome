package org.bouncycastle.crypto.params;

/* JADX INFO: loaded from: classes42.dex */
public class ECKeyParameters extends AsymmetricKeyParameter {
    private final ECDomainParameters parameters;

    public ECKeyParameters(boolean r100, ECDomainParameters r101) {
        super(r100);
        if (r101 == null) goto L7;
        this.parameters = r101;
        return;
    L7:
        throw new NullPointerException("'parameters' cannot be null");
    }

    public ECDomainParameters getParameters() {
        return this.parameters;
    }
}
