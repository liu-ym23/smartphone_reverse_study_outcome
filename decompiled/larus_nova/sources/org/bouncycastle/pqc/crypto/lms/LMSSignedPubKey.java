package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes42.dex */
class LMSSignedPubKey implements Encodable {
    private final LMSPublicKeyParameters publicKey;
    private final LMSSignature signature;

    public LMSSignedPubKey(LMSSignature r100, LMSPublicKeyParameters r101) {
        this.signature = r100;
        this.publicKey = r101;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L25;
        LMSSignedPubKey r101 = (LMSSignedPubKey) r100;
        LMSSignature r102 = this.signature;
        if (r102 == null) goto L16;
        if (r102.equals(r101.signature) == false) goto L17;
    L18:
        LMSPublicKeyParameters r103 = this.publicKey;
        LMSPublicKeyParameters r104 = r101.publicKey;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        return false;
    L16:
        if (r101.signature == null) goto L18;
        goto L17
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() throws IOException {
        return Composer.compose().bytes(this.signature.getEncoded()).bytes(this.publicKey.getEncoded()).build();
    }

    public LMSPublicKeyParameters getPublicKey() {
        return this.publicKey;
    }

    public LMSSignature getSignature() {
        return this.signature;
    }

    public int hashCode() {
        LMSSignature r100 = this.signature;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LMSPublicKeyParameters r104 = this.publicKey;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }
}
