package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class KDFParameters implements DerivationParameters {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    byte[] f525328iv;
    byte[] shared;

    public KDFParameters(byte[] r100, byte[] r101) {
        this.shared = r100;
        this.f525328iv = r101;
    }

    public byte[] getIV() {
        return this.f525328iv;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }
}
