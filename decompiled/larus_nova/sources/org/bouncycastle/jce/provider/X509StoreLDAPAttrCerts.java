package org.bouncycastle.jce.provider;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import org.bouncycastle.jce.X509LDAPCertStoreParameters;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.StoreException;
import org.bouncycastle.x509.X509AttributeCertStoreSelector;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;
import org.bouncycastle.x509.util.LDAPStoreHelper;

/* JADX INFO: loaded from: classes42.dex */
public class X509StoreLDAPAttrCerts extends X509StoreSpi {
    private LDAPStoreHelper helper;

    public X509StoreLDAPAttrCerts() {
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector r100) throws StoreException {
        if ((r100 instanceof X509AttributeCertStoreSelector) == false) goto L5;
        X509AttributeCertStoreSelector r101 = (X509AttributeCertStoreSelector) r100;
        HashSet r102 = new HashSet();
        r102.addAll(this.helper.getAACertificates(r101));
        r102.addAll(this.helper.getAttributeCertificateAttributes(r101));
        r102.addAll(this.helper.getAttributeDescriptorCertificates(r101));
        return r102;
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
