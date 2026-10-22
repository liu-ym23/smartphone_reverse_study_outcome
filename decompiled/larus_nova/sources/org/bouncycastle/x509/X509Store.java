package org.bouncycastle.x509;

import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Collection;
import org.bouncycastle.util.Selector;
import org.bouncycastle.util.Store;

/* JADX INFO: loaded from: classes42.dex */
public class X509Store implements Store {
    private Provider _provider;
    private X509StoreSpi _spi;

    private X509Store(Provider r100, X509StoreSpi r101) {
        this._provider = r100;
        this._spi = r101;
    }

    private static X509Store createStore(X509Util.Implementation r100, X509StoreParameters r101) {
        X509StoreSpi r102 = (X509StoreSpi) r100.getEngine();
        r102.engineInit(r101);
        return new X509Store(r100.getProvider(), r102);
    }

    public static X509Store getInstance(String r100, X509StoreParameters r101) throws NoSuchStoreException {
        return createStore(X509Util.getImplementation("X509Store", r100), r101);
    L4:
        e = move-exception;
        throw new NoSuchStoreException(e.getMessage());
    }

    public static X509Store getInstance(String r100, X509StoreParameters r101, String r102) throws NoSuchStoreException, NoSuchProviderException {
        return getInstance(r100, r101, X509Util.getProvider(r102));
    }

    public static X509Store getInstance(String r100, X509StoreParameters r101, Provider r102) throws NoSuchStoreException {
        return createStore(X509Util.getImplementation("X509Store", r100, r102), r101);
    L4:
        e = move-exception;
        throw new NoSuchStoreException(e.getMessage());
    }

    @Override // org.bouncycastle.util.Store
    public Collection getMatches(Selector r100) {
        return this._spi.engineGetMatches(r100);
    }

    public Provider getProvider() {
        return this._provider;
    }
}
