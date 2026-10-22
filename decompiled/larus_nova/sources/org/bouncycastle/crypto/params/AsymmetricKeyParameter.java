package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class AsymmetricKeyParameter implements CipherParameters {
    boolean privateKey;

    public AsymmetricKeyParameter(boolean r100) {
        this.privateKey = r100;
    }

    public boolean isPrivate() {
        return this.privateKey;
    }
}
