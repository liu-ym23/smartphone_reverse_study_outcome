package org.bouncycastle.x509;

import java.util.Collection;
import org.bouncycastle.util.Selector;

/* JADX INFO: loaded from: classes42.dex */
public abstract class X509StoreSpi {
    public X509StoreSpi() {
    }

    public abstract Collection engineGetMatches(Selector r100);

    public abstract void engineInit(X509StoreParameters r100);
}
