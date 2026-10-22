package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.jce.MultiCertStoreParameters;

/* JADX INFO: loaded from: classes42.dex */
public class MultiCertStoreSpi extends CertStoreSpi {
    private MultiCertStoreParameters params;

    public MultiCertStoreSpi(CertStoreParameters r100) throws InvalidAlgorithmParameterException {
        super(r100);
        if ((r100 instanceof MultiCertStoreParameters) == false) goto L7;
        this.params = (MultiCertStoreParameters) r100;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("org.bouncycastle.jce.provider.MultiCertStoreSpi: parameter must be a MultiCertStoreParameters object\n" + r100.toString());
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector r100) throws CertStoreException {
        boolean r101 = this.params.getSearchAllStores();
        Iterator r102 = this.params.getCertStores().iterator();
        if (r101 == false) goto L5;
        List r103 = new ArrayList();
    L7:
        if (r102.hasNext() == false) goto L14;
        Collection<? extends CRL> r104 = ((CertStore) r102.next()).getCRLs(r100);
        if (r101 == true) goto L10;
        if (r104.isEmpty() == true) goto L7;
        return r104;
    L10:
        r103.addAll(r104);
        goto L7
    L14:
        return r103;
    L5:
        r103 = Collections.EMPTY_LIST;
        goto L7
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector r100) throws CertStoreException {
        boolean r101 = this.params.getSearchAllStores();
        Iterator r102 = this.params.getCertStores().iterator();
        if (r101 == false) goto L5;
        List r103 = new ArrayList();
    L7:
        if (r102.hasNext() == false) goto L14;
        Collection<? extends Certificate> r104 = ((CertStore) r102.next()).getCertificates(r100);
        if (r101 == true) goto L10;
        if (r104.isEmpty() == true) goto L7;
        return r104;
    L10:
        r103.addAll(r104);
        goto L7
    L14:
        return r103;
    L5:
        r103 = Collections.EMPTY_LIST;
        goto L7
    }
}
