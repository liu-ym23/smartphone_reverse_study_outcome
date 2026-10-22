package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CRLException;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes42.dex */
class X509CRLInternal extends X509CRLImpl {
    private final byte[] encoding;

    public X509CRLInternal(JcaJceHelper r100, CertificateList r101, String r102, byte[] r103, boolean r104, byte[] r105) {
        super(r100, r101, r102, r103, r104);
        this.encoding = r105;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl, java.security.cert.X509CRL
    public byte[] getEncoded() throws CRLException {
        byte[] r100 = this.encoding;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new CRLException();
    }
}
