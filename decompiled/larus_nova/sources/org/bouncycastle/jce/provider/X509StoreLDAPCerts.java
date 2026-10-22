package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509CertPairStoreSelector;
import org.bouncycastle.x509.X509CertStoreSelector;
import org.bouncycastle.x509.X509CertificatePair;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;
import org.bouncycastle.x509.util.LDAPStoreHelper;

/* JADX INFO: loaded from: classes42.dex */
public class X509StoreLDAPCerts extends X509StoreSpi {
    private LDAPStoreHelper helper;

    public X509StoreLDAPCerts() {
    }

    private Collection getCertificatesFromCrossCertificatePairs(X509CertStoreSelector r100) throws StoreException {
        HashSet r101 = new HashSet();
        X509CertPairStoreSelector r102 = new X509CertPairStoreSelector();
        r102.setForwardSelector(r100);
        r102.setReverseSelector(new X509CertStoreSelector());
        HashSet r103 = new HashSet(this.helper.getCrossCertificatePairs(r102));
        HashSet r104 = new HashSet();
        HashSet r105 = new HashSet();
        Iterator r106 = r103.iterator();
    L4:
        if (r106.hasNext() == false) goto L11;
        X509CertificatePair r107 = (X509CertificatePair) r106.next();
        if (r107.getForward() == null) goto L9;
        r104.add(r107.getForward());
    L9:
        if (r107.getReverse() == null) goto L4;
        r105.add(r107.getReverse());
        goto L4
    L11:
        r101.addAll(r104);
        r101.addAll(r105);
        return r101;
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector r100) throws StoreException {
        if ((r100 instanceof X509CertStoreSelector) == false) goto L5;
        X509CertStoreSelector r101 = (X509CertStoreSelector) r100;
        HashSet r102 = new HashSet();
        if (r101.getBasicConstraints() <= 0) goto L11;
    L8:
        r102.addAll(this.helper.getCACertificates(r101));
        Collection r103 = getCertificatesFromCrossCertificatePairs(r101);
    L9:
        r102.addAll(r103);
        return r102;
    L11:
        if (r101.getBasicConstraints() != (-2)) goto L13;
        r103 = this.helper.getUserCertificates(r101);
        goto L9
    L13:
        r102.addAll(this.helper.getUserCertificates(r101));
        goto L8
    L5:
        return Collections.EMPTY_SET;
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public void engineInit(X509StoreParameters r100) {
        if ((r100 instanceof X509LDAPCertStoreParameters) == false) goto L7;
        this.helper = new LDAPStoreHelper((X509LDAPCertStoreParameters) r100);
        return;
    L7:
        throw new IllegalArgumentException("Initialization parameters must be an instance of " + X509LDAPCertStoreParameters.class.getName() + ".");
    }
}
