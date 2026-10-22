package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSMTKeyParameters extends AsymmetricKeyParameter {
    private final String treeDigest;

    public XMSSMTKeyParameters(boolean r100, String r101) {
        super(r100);
        this.treeDigest = r101;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
