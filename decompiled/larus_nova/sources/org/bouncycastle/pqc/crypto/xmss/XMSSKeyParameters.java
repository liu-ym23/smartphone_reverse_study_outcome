package org.bouncycastle.pqc.crypto.xmss;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSKeyParameters extends AsymmetricKeyParameter {
    public static final String SHAKE128 = "SHAKE128";
    public static final String SHAKE256 = "SHAKE256";
    public static final String SHA_256 = "SHA-256";
    public static final String SHA_512 = "SHA-512";
    private final String treeDigest;

    public XMSSKeyParameters(boolean r100, String r101) {
        super(r100);
        this.treeDigest = r101;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
