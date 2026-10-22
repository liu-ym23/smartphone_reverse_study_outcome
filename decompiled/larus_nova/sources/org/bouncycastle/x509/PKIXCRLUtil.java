package org.bouncycastle.x509;

import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.PKIXParameters;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes42.dex */
abstract class PKIXCRLUtil {
    public PKIXCRLUtil() {
    }

    public static Set findCRLs(X509CRLStoreSelector r100, PKIXParameters r101) throws AnnotatedException {
        HashSet r102 = new HashSet();
        findCRLs(r102, r100, r101.getCertStores());     // Catch: AnnotatedException -> L5
        return r102;
    L5:
        e = move-exception;
        throw new AnnotatedException("Exception obtaining complete CRLs.", e);
    }

    private static void findCRLs(HashSet r100, X509CRLStoreSelector r101, List r102) throws AnnotatedException {
        Iterator r103 = r102.iterator();
        AnnotatedException r104 = null;
        boolean r105 = false;
    L4:
        if (r103.hasNext() == false) goto L18;
        Object r106 = r103.next();
        if ((r106 instanceof X509Store) == false) goto L23;
        r100.addAll(((X509Store) r106).getMatches(r101));     // Catch: StoreException -> L10
    L9:
        r105 = true;
    L10:
        e = move-exception;
        AnnotatedException r107 = new AnnotatedException("Exception searching in X.509 CRL store.", e);
    L12:
        r104 = r107;
        goto L4
    L23:
        r100.addAll(((CertStore) r106).getCRLs(r101));     // Catch: CertStoreException -> L16
    L16:
        e = move-exception;
        r107 = new AnnotatedException("Exception searching in X.509 CRL store.", e);
        goto L12
    L18:
        if (r105 == true) goto L22;
        if (r104 == null) goto L33;
        throw r104;
    L33:
        return;
    }
}
