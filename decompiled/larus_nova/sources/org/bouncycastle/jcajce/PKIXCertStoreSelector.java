package org.bouncycastle.jcajce;

import java.io.IOException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.X509CertSelector;
import java.util.Collection;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public class PKIXCertStoreSelector<T extends Certificate> implements Selector<T> {
    private final CertSelector baseSelector;

    /* JADX INFO: renamed from: org.bouncycastle.jcajce.PKIXCertStoreSelector$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private final CertSelector baseSelector;

        public Builder(CertSelector r100) {
            this.baseSelector = (CertSelector) r100.clone();
        }

        public PKIXCertStoreSelector<? extends Certificate> build() {
            return new PKIXCertStoreSelector(this.baseSelector, null);
        }
    }

    public static class SelectorClone extends X509CertSelector {
        private final PKIXCertStoreSelector selector;

        public SelectorClone(PKIXCertStoreSelector r100) {
            this.selector = r100;
            if ((PKIXCertStoreSelector.access$100(r100) instanceof X509CertSelector) == false) goto L10;
            X509CertSelector r101 = (X509CertSelector) PKIXCertStoreSelector.access$100(r100);
            setAuthorityKeyIdentifier(r101.getAuthorityKeyIdentifier());
            setBasicConstraints(r101.getBasicConstraints());
            setCertificate(r101.getCertificate());
            setCertificateValid(r101.getCertificateValid());
            setKeyUsage(r101.getKeyUsage());
            setMatchAllSubjectAltNames(r101.getMatchAllSubjectAltNames());
            setPrivateKeyValid(r101.getPrivateKeyValid());
            setSerialNumber(r101.getSerialNumber());
            setSubjectKeyIdentifier(r101.getSubjectKeyIdentifier());
            setSubjectPublicKey(r101.getSubjectPublicKey());
            setExtendedKeyUsage(r101.getExtendedKeyUsage());     // Catch: IOException -> L7
            setIssuer(r101.getIssuerAsBytes());     // Catch: IOException -> L7
            setNameConstraints(r101.getNameConstraints());     // Catch: IOException -> L7
            setPathToNames(r101.getPathToNames());     // Catch: IOException -> L7
            setPolicy(r101.getPolicy());     // Catch: IOException -> L7
            setSubject(r101.getSubjectAsBytes());     // Catch: IOException -> L7
            setSubjectAlternativeNames(r101.getSubjectAlternativeNames());     // Catch: IOException -> L7
            setSubjectPublicKeyAlgID(r101.getSubjectPublicKeyAlgID());     // Catch: IOException -> L7
            return;
        L7:
            e = move-exception;
            throw new IllegalStateException("base selector invalid: " + e.getMessage(), e);
        }

        @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector
        public boolean match(Certificate r100) {
            PKIXCertStoreSelector r101 = this.selector;
            if (r101 != null) goto L8;
            if (r100 == null) goto L6;
            return true;
        L6:
            return false;
        L8:
            return r101.match(r100);
        }
    }

    private PKIXCertStoreSelector(CertSelector r100) {
        this.baseSelector = r100;
    }

    public /* synthetic */ PKIXCertStoreSelector(CertSelector r100, AnonymousClass1 r101) {
        this(r100);
    }

    public static /* synthetic */ CertSelector access$100(PKIXCertStoreSelector r100) {
        return r100.baseSelector;
    }

    public static Collection<? extends Certificate> getCertificates(PKIXCertStoreSelector r100, CertStore r101) throws CertStoreException {
        return r101.getCertificates(new SelectorClone(r100));
    }

    @Override // org.bouncycastle.util.Selector
    public Object clone() {
        return new PKIXCertStoreSelector(this.baseSelector);
    }

    public Certificate getCertificate() {
        CertSelector r100 = this.baseSelector;
        if ((r100 instanceof X509CertSelector) == true) goto L5;
        return null;
    L5:
        return ((X509CertSelector) r100).getCertificate();
    }

    @Override // org.bouncycastle.util.Selector
    public /* bridge */ /* synthetic */ boolean match(Object r100) {
        return match((Certificate) r100);
    }

    public boolean match(Certificate r100) {
        return this.baseSelector.match(r100);
    }
}
