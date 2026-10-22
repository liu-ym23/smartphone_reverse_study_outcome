package jvc;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* JADX INFO: loaded from: classes42.dex */
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f500644a;

    public final int hashCode() {
        return this.f500644a.hashCode();
    }

    public a(e r100) {
        this.f500644a = r100;
    }

    public final boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
    L10:
        return false;
    L8:
        if (((a) r100).f500644a.equals(this.f500644a) == false) goto L10;
        return true;
    }

    @Override // jvc.c
    public final List<Certificate> a(List<Certificate> r110, String r111) throws SSLPeerUnverifiedException {
        ArrayDeque r112 = new ArrayDeque(r110);
        ArrayList r113 = new ArrayList();
        r113.add(r112.removeFirst());
        int r100 = 0;
        boolean r101 = false;
    L4:
        if (r100 >= 9) goto L36;
        X509Certificate r102 = (X509Certificate) ListProtector.get(r113, r113.size() - 1);
        X509Certificate r103 = this.f500644a.a(r102);
        if (r103 != null) goto L8;
        Iterator r104 = r112.iterator();
    L22:
        if (r104.hasNext() == false) goto L31;
        X509Certificate r105 = (X509Certificate) r104.next();
        if (r102.getIssuerDN().equals(r105.getSubjectDN()) == true) goto L39;
    L25:
        boolean r106 = false;
    L28:
        if (r106 == false) goto L22;
        r104.remove();
        r113.add(r105);
    L30:
        r100 = r100 + 1;
        goto L4
    L39:
        r102.verify(r105.getPublicKey());     // Catch: GeneralSecurityException -> L38
        r106 = true;
        goto L28
    L31:
        if (r101 == false) goto L34;
        return r113;
    L34:
        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + r102);
    L8:
        if (r113.size() <= 1) goto L10;
    L11:
        r113.add(r103);
    L13:
        if (r103.getIssuerDN().equals(r103.getSubjectDN()) == true) goto L41;
    L14:
        boolean r107 = false;
    L17:
        if (r107 == true) goto L18;
        r101 = true;
        goto L30
    L18:
        return r113;
    L41:
        r103.verify(r103.getPublicKey());     // Catch: GeneralSecurityException -> L37
        r107 = true;
        goto L17
    L10:
        if (r102.equals(r103) == true) goto L13;
    L36:
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + r113);
    }
}
