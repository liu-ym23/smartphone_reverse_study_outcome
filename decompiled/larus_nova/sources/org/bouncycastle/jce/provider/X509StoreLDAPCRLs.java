package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509CRLStoreSelector;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;
import org.bouncycastle.x509.util.LDAPStoreHelper;

/* JADX INFO: loaded from: classes42.dex */
public class X509StoreLDAPCRLs extends X509StoreSpi {
    private LDAPStoreHelper helper;

    public X509StoreLDAPCRLs() {
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector r100) throws StoreException {
        if ((r100 instanceof X509CRLStoreSelector) == false) goto L5;
        X509CRLStoreSelector r101 = (X509CRLStoreSelector) r100;
        HashSet r102 = new HashSet();
        if (r101.isDeltaCRLIndicatorEnabled() == false) goto L9;
        Collection r103 = this.helper.getDeltaCertificateRevocationLists(r101);
    L10:
        r102.addAll(r103);
        return r102;
    L9:
        r102.addAll(this.helper.getDeltaCertificateRevocationLists(r101));
        r102.addAll(this.helper.getAttributeAuthorityRevocationLists(r101));
        r102.addAll(this.helper.getAttributeCertificateRevocationLists(r101));
        r102.addAll(this.helper.getAuthorityRevocationLists(r101));
        r103 = this.helper.getCertificateRevocationLists(r101);
        goto L10
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
