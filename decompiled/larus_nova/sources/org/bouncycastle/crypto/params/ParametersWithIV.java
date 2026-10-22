package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ParametersWithIV implements CipherParameters {

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    private byte[] f525332iv;
    private CipherParameters parameters;

    public ParametersWithIV(CipherParameters r100, byte[] r101) {
        this(r100, r101, 0, r101.length);
    }

    public ParametersWithIV(CipherParameters r100, byte[] r101, int r102, int r103) {
        byte[] r104 = new byte[r103];
        this.f525332iv = r104;
        this.parameters = r100;
        System.arraycopy(r101, r102, r104, 0, r103);
    }

    public byte[] getIV() {
        return this.f525332iv;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
