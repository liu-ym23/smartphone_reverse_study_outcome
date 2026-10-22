package com.volcengine.zeus.signature;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
class VerbatimX509Certificate extends WrappedX509Certificate {
    private final byte[] mEncodedVerbatim;
    private int mHash;

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.mHash != (-1)) goto L8;
        this.mHash = Arrays.hashCode(getEncoded());     // Catch: CertificateEncodingException -> L6
    L6:
        this.mHash = 0;
    L8:
        return this.mHash;
    }

    @Override // com.volcengine.zeus.signature.WrappedX509Certificate, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.mEncodedVerbatim;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VerbatimX509Certificate) == true) goto L11;
        return false;
    L11:
        return Arrays.equals(getEncoded(), ((VerbatimX509Certificate) r100).getEncoded());
    L10:
        return false;
    }

    public VerbatimX509Certificate(X509Certificate r100, byte[] r101) {
        super(r100);
        this.mHash = -1;
        this.mEncodedVerbatim = r101;
    }
}
