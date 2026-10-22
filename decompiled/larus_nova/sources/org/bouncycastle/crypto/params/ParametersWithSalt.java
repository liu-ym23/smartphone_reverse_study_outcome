package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ParametersWithSalt implements CipherParameters {
    private CipherParameters parameters;
    private byte[] salt;

    public ParametersWithSalt(CipherParameters r100, byte[] r101) {
        this(r100, r101, 0, r101.length);
    }

    public ParametersWithSalt(CipherParameters r100, byte[] r101, int r102, int r103) {
        byte[] r104 = new byte[r103];
        this.salt = r104;
        this.parameters = r100;
        System.arraycopy(r101, r102, r104, 0, r103);
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    public byte[] getSalt() {
        return this.salt;
    }
}
