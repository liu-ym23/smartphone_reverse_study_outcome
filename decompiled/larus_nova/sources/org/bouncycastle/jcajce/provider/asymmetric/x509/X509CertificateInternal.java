package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.security.cert.CertificateEncodingException;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.jcajce.util.JcaJceHelper;

/* JADX INFO: loaded from: classes42.dex */
class X509CertificateInternal extends X509CertificateImpl {
    private final byte[] encoding;

    public X509CertificateInternal(JcaJceHelper r100, Certificate r101, BasicConstraints r102, boolean[] r103, String r104, byte[] r105, byte[] r106) {
        super(r100, r101, r102, r103, r104, r105);
        this.encoding = r106;
    }

    @Override // org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] r100 = this.encoding;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new CertificateEncodingException();
    }
}
