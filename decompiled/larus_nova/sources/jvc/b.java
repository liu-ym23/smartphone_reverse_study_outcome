package jvc;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes42.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<X500Principal, Set<X509Certificate>> f500645a;

    public final int hashCode() {
        return this.f500645a.hashCode();
    }

    public b(X509Certificate... r100) {
        this.f500645a = new LinkedHashMap();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        X509Certificate r103 = r100[r102];
        X500Principal r104 = r103.getSubjectX500Principal();
        Set<X509Certificate> r105 = this.f500645a.get(r104);
        if (r105 != null) goto L7;
        r105 = new LinkedHashSet(1);
        this.f500645a.put(r104, r105);
    L7:
        r105.add(r103);
        r102 = r102 + 1;
        goto L3
    }

    @Override // jvc.e
    public final X509Certificate a(X509Certificate r100) {
        X500Principal r101 = r100.getIssuerX500Principal();
        Set r102 = (Set) ((LinkedHashMap) this.f500645a).get(r101);
        if (r102 != null) goto L5;
        return null;
    L5:
        Iterator r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        X509Certificate r104 = (X509Certificate) r103.next();
        r100.verify(r104.getPublicKey());     // Catch: Exception -> L11
        return r104;
    L12:
        return null;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
    L10:
        return false;
    L8:
        if (((b) r100).f500645a.equals(this.f500645a) == false) goto L10;
        return true;
    }
}
