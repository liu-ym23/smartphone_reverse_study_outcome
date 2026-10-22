package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.crypto.DerivationParameters;

/* JADX INFO: loaded from: classes42.dex */
public class GSKKDFParameters implements DerivationParameters {
    private final byte[] nonce;
    private final int startCounter;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final byte[] f525121z;

    public GSKKDFParameters(byte[] r100, int r101) {
        this(r100, r101, null);
    }

    public GSKKDFParameters(byte[] r100, int r101, byte[] r102) {
        this.f525121z = r100;
        this.startCounter = r101;
        this.nonce = r102;
    }

    public byte[] getNonce() {
        return this.nonce;
    }

    public int getStartCounter() {
        return this.startCounter;
    }

    public byte[] getZ() {
        return this.f525121z;
    }
}
