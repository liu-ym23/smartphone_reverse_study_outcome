package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceKeyParameters extends AsymmetricKeyParameter {
    private McElieceParameters params;

    public McElieceKeyParameters(boolean r100, McElieceParameters r101) {
        super(r100);
        this.params = r101;
    }

    public McElieceParameters getParameters() {
        return this.params;
    }
}
