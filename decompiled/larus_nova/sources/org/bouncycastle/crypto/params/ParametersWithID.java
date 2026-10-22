package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

/* JADX INFO: loaded from: classes42.dex */
public class ParametersWithID implements CipherParameters {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private byte[] f525331id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters r100, byte[] r101) {
        this.parameters = r100;
        this.f525331id = r101;
    }

    public byte[] getID() {
        return this.f525331id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
