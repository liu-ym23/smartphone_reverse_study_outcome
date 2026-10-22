package org.bouncycastle.jce;

import java.security.cert.CertStoreParameters;
import java.util.Collection;

/* JADX INFO: loaded from: classes42.dex */
public class MultiCertStoreParameters implements CertStoreParameters {
    private Collection certStores;
    private boolean searchAllStores;

    public MultiCertStoreParameters(Collection r100) {
        this(r100, true);
    }

    public MultiCertStoreParameters(Collection r100, boolean r101) {
        this.certStores = r100;
        this.searchAllStores = r101;
    }

    @Override // java.security.cert.CertStoreParameters
    public Object clone() {
        return this;
    }

    public Collection getCertStores() {
        return this.certStores;
    }

    public boolean getSearchAllStores() {
        return this.searchAllStores;
    }
}
