package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class SPHINCSKeyParameters extends AsymmetricKeyParameter {
    public static final String SHA3_256 = "SHA3-256";
    public static final String SHA512_256 = "SHA-512/256";
    private final String treeDigest;

    public SPHINCSKeyParameters(boolean r100, String r101) {
        super(r100);
        this.treeDigest = r101;
    }

    public String getTreeDigest() {
        return this.treeDigest;
    }
}
