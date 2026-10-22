package org.bouncycastle.pqc.crypto.gmss;

/* JADX INFO: loaded from: classes42.dex */
public class GMSSPublicKeyParameters extends GMSSKeyParameters {
    private byte[] gmssPublicKey;

    public GMSSPublicKeyParameters(byte[] r100, GMSSParameters r101) {
        super(false, r101);
        this.gmssPublicKey = r100;
    }

    public byte[] getPublicKey() {
        return this.gmssPublicKey;
    }
}
