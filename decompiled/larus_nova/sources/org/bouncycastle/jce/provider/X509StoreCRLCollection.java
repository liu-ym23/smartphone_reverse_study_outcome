package org.bouncycastle.jce.provider;

import java.util.Collection;
import org.bouncycastle.util.CollectionStore;
import org.bouncycastle.util.Selector;
import org.bouncycastle.x509.X509CollectionStoreParameters;
import org.bouncycastle.x509.X509StoreParameters;
import org.bouncycastle.x509.X509StoreSpi;

/* JADX INFO: loaded from: classes42.dex */
public class X509StoreCRLCollection extends X509StoreSpi {
    private CollectionStore _store;

    public X509StoreCRLCollection() {
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public Collection engineGetMatches(Selector r100) {
        return this._store.getMatches(r100);
    }

    @Override // org.bouncycastle.x509.X509StoreSpi
    public void engineInit(X509StoreParameters r100) {
        if ((r100 instanceof X509CollectionStoreParameters) == false) goto L7;
        this._store = new CollectionStore(((X509CollectionStoreParameters) r100).getCollection());
        return;
    L7:
        throw new IllegalArgumentException(r100.toString());
    }
}
