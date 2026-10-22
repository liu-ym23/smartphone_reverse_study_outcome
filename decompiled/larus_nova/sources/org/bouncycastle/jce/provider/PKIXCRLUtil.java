package org.bouncycastle.jce.provider;

import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.jcajce.PKIXCRLStoreSelector;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;

/* JADX INFO: loaded from: classes42.dex */
abstract class PKIXCRLUtil {
    public PKIXCRLUtil() {
    }

    public static Set findCRLs(PKIXCRLStoreSelector r100, Date r101, List r102, List r103) throws AnnotatedException {
        HashSet r104 = new HashSet();
        findCRLs(r104, r100, r103);     // Catch: AnnotatedException -> L15
        findCRLs(r104, r100, r102);     // Catch: AnnotatedException -> L15
        HashSet r105 = new HashSet();
        Iterator r106 = r104.iterator();
    L6:
        if (r106.hasNext() == false) goto L14;
        X509CRL r107 = (X509CRL) r106.next();
        if (r107.getNextUpdate().after(r101) == false) goto L6;
        X509Certificate r108 = r100.getCertificateChecking();
        if (r108 == null) goto L13;
        if (r107.getThisUpdate().before(r108.getNotAfter()) == false) goto L6;
    L13:
        r105.add(r107);
        goto L6
    L14:
        return r105;
    L15:
        e = move-exception;
        throw new AnnotatedException("Exception obtaining complete CRLs.", e);
    }

    private static void findCRLs(HashSet r100, PKIXCRLStoreSelector r101, List r102) throws AnnotatedException {
        Iterator r103 = r102.iterator();
        AnnotatedException r104 = null;
        boolean r105 = false;
    L4:
        if (r103.hasNext() == false) goto L18;
        Object r106 = r103.next();
        if ((r106 instanceof Store) == false) goto L23;
        r100.addAll(((Store) r106).getMatches(r101));     // Catch: StoreException -> L10
    L9:
        r105 = true;
    L10:
        e = move-exception;
        AnnotatedException r107 = new AnnotatedException("Exception searching in X.509 CRL store.", e);
    L12:
        r104 = r107;
        goto L4
    L23:
        r100.addAll(PKIXCRLStoreSelector.getCRLs(r101, (CertStore) r106));     // Catch: CertStoreException -> L16
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
