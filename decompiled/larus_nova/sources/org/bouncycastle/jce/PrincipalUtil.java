package org.bouncycastle.jce;

import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.TBSCertificateStructure;
import org.bouncycastle.asn1.x509.X509Name;

/* JADX INFO: loaded from: classes42.dex */
public class PrincipalUtil {
    public PrincipalUtil() {
    }

    public static X509Principal getIssuerX509Principal(X509CRL r100) throws CRLException {
        return new X509Principal(X509Name.getInstance(TBSCertList.getInstance(ASN1Primitive.fromByteArray(r100.getTBSCertList())).getIssuer()));
    L4:
        e = move-exception;
        throw new CRLException(e.toString());
    }

    public static X509Principal getIssuerX509Principal(X509Certificate r100) throws CertificateEncodingException {
        return new X509Principal(X509Name.getInstance(TBSCertificateStructure.getInstance(ASN1Primitive.fromByteArray(r100.getTBSCertificate())).getIssuer()));
    L4:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    }

    public static X509Principal getSubjectX509Principal(X509Certificate r100) throws CertificateEncodingException {
        return new X509Principal(X509Name.getInstance(TBSCertificateStructure.getInstance(ASN1Primitive.fromByteArray(r100.getTBSCertificate())).getSubject()));
    L4:
        e = move-exception;
        throw new CertificateEncodingException(e.toString());
    }
}
