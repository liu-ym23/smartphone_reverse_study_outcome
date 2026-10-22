package org.bouncycastle.jce.provider;

import java.security.InvalidAlgorithmParameterException;
import java.security.cert.CRL;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStoreException;
import java.security.cert.CertStoreParameters;
import java.security.cert.CertStoreSpi;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes42.dex */
public class CertStoreCollectionSpi extends CertStoreSpi {
    private CollectionCertStoreParameters params;

    public CertStoreCollectionSpi(CertStoreParameters r100) throws InvalidAlgorithmParameterException {
        super(r100);
        if ((r100 instanceof CollectionCertStoreParameters) == false) goto L7;
        this.params = (CollectionCertStoreParameters) r100;
        return;
    L7:
        throw new InvalidAlgorithmParameterException("org.bouncycastle.jce.provider.CertStoreCollectionSpi: parameter must be a CollectionCertStoreParameters object\n" + r100.toString());
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCRLs(CRLSelector r100) throws CertStoreException {
        ArrayList r101 = new ArrayList();
        Iterator<?> r102 = this.params.getCollection().iterator();
        if (r100 != null) goto L10;
    L5:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        if ((r103 instanceof CRL) == false) goto L5;
        r101.add(r103);
    L16:
        return r101;
    L10:
        if (r102.hasNext() == false) goto L16;
        Object r104 = r102.next();
        if ((r104 instanceof CRL) == false) goto L10;
        if (r100.match((CRL) r104) == false) goto L10;
        r101.add(r104);
        goto L10
    }

    @Override // java.security.cert.CertStoreSpi
    public Collection engineGetCertificates(CertSelector r100) throws CertStoreException {
        ArrayList r101 = new ArrayList();
        Iterator<?> r102 = this.params.getCollection().iterator();
        if (r100 != null) goto L10;
    L5:
        if (r102.hasNext() == false) goto L16;
        Object r103 = r102.next();
        if ((r103 instanceof Certificate) == false) goto L5;
        r101.add(r103);
    L16:
        return r101;
    L10:
        if (r102.hasNext() == false) goto L16;
        Object r104 = r102.next();
        if ((r104 instanceof Certificate) == false) goto L10;
        if (r100.match((Certificate) r104) == false) goto L10;
        r101.add(r104);
        goto L10
    }
}
