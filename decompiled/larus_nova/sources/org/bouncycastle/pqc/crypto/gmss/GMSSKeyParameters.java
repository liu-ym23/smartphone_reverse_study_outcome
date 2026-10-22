package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSKeyParameters extends AsymmetricKeyParameter {
    private GMSSParameters params;

    public GMSSKeyParameters(boolean r100, GMSSParameters r101) {
        super(r100);
        this.params = r101;
    }

    public GMSSParameters getParameters() {
        return this.params;
    }
}
