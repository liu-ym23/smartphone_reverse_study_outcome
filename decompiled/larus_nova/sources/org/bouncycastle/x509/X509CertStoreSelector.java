package org.bouncycastle.x509;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public class X509CertStoreSelector extends X509CertSelector implements Selector {
    public X509CertStoreSelector() {
    }

    public static X509CertStoreSelector getInstance(X509CertSelector r100) {
        if (r100 == null) goto L11;
        X509CertStoreSelector r101 = new X509CertStoreSelector();
        r101.setAuthorityKeyIdentifier(r100.getAuthorityKeyIdentifier());
        r101.setBasicConstraints(r100.getBasicConstraints());
        r101.setCertificate(r100.getCertificate());
        r101.setCertificateValid(r100.getCertificateValid());
        r101.setMatchAllSubjectAltNames(r100.getMatchAllSubjectAltNames());
        r101.setPathToNames(r100.getPathToNames());     // Catch: IOException -> L7
        r101.setExtendedKeyUsage(r100.getExtendedKeyUsage());     // Catch: IOException -> L7
        r101.setNameConstraints(r100.getNameConstraints());     // Catch: IOException -> L7
        r101.setPolicy(r100.getPolicy());     // Catch: IOException -> L7
        r101.setSubjectPublicKeyAlgID(r100.getSubjectPublicKeyAlgID());     // Catch: IOException -> L7
        r101.setSubjectAlternativeNames(r100.getSubjectAlternativeNames());     // Catch: IOException -> L7
        r101.setIssuer(r100.getIssuer());
        r101.setKeyUsage(r100.getKeyUsage());
        r101.setPrivateKeyValid(r100.getPrivateKeyValid());
        r101.setSerialNumber(r100.getSerialNumber());
        r101.setSubject(r100.getSubject());
        r101.setSubjectKeyIdentifier(r100.getSubjectKeyIdentifier());
        r101.setSubjectPublicKey(r100.getSubjectPublicKey());
        return r101;
    L7:
        e = move-exception;
        throw new IllegalArgumentException("error in passed in selector: " + e);
    L11:
        throw new IllegalArgumentException("cannot create from null selector");
    }

    @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector, org.bouncycastle.util.Selector
    public Object clone() {
        return (X509CertStoreSelector) super.clone();
    }

    @Override // org.bouncycastle.util.Selector
    public boolean match(Object r100) {
        if ((r100 instanceof X509Certificate) == true) goto L7;
        return false;
    L7:
        return super.match((X509Certificate) r100);
    }

    @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector
    public boolean match(Certificate r100) {
        return match(r100);
    }
}
