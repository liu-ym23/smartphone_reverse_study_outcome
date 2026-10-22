package org.bouncycastle.crypto;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

/* JADX INFO: loaded from: classes42.dex */
public class AsymmetricCipherKeyPair {
    private AsymmetricKeyParameter privateParam;
    private AsymmetricKeyParameter publicParam;

    public AsymmetricCipherKeyPair(CipherParameters r100, CipherParameters r101) {
        this.publicParam = (AsymmetricKeyParameter) r100;
        this.privateParam = (AsymmetricKeyParameter) r101;
    }

    public AsymmetricCipherKeyPair(AsymmetricKeyParameter r100, AsymmetricKeyParameter r101) {
        this.publicParam = r100;
        this.privateParam = r101;
    }

    public AsymmetricKeyParameter getPrivate() {
        return this.privateParam;
    }

    public AsymmetricKeyParameter getPublic() {
        return this.publicParam;
    }
}
