package org.bouncycastle.jce.provider;

import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameStyle;
import org.bouncycastle.jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.x509.X509AttributeCertificate;

/* JADX INFO: loaded from: classes42.dex */
class PrincipalUtils {
    public PrincipalUtils() {
    }

    public static X500Name getCA(TrustAnchor r100) {
        return getX500Name(notNull(r100).getCA());
    }

    private static byte[] getEncoded(X500Principal r100) {
        return notNull(notNull(r100).getEncoded());
    }

    public static X500Name getEncodedIssuerPrincipal(Object r100) {
        if ((r100 instanceof X509Certificate) == false) goto L7;
        return getIssuerPrincipal((X509Certificate) r100);
    L7:
        return getX500Name((X500Principal) ((X509AttributeCertificate) r100).getIssuer().getPrincipals()[0]);
    }

    public static X500Name getIssuerPrincipal(X509CRL r100) {
        return getX500Name(notNull(r100).getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getIssuerPrincipal(X509Certificate r100) {
        if ((r100 instanceof BCX509Certificate) == false) goto L7;
        return notNull(((BCX509Certificate) r100).getIssuerX500Name());
    L7:
        return getX500Name(notNull(r100).getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getSubjectPrincipal(X509Certificate r100) {
        if ((r100 instanceof BCX509Certificate) == false) goto L7;
        return notNull(((BCX509Certificate) r100).getSubjectX500Name());
    L7:
        return getX500Name(notNull(r100).getSubjectX500Principal());
    }

    public static X500Name getX500Name(X500Principal r100) {
        return notNull(X500Name.getInstance(getEncoded(r100)));
    }

    public static X500Name getX500Name(X500NameStyle r100, X500Principal r101) {
        return notNull(X500Name.getInstance(r100, getEncoded(r101)));
    }

    private static TrustAnchor notNull(TrustAnchor r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalStateException();
    }

    private static X509CRL notNull(X509CRL r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalStateException();
    }

    private static X509Certificate notNull(X509Certificate r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalStateException();
    }

    private static X500Principal notNull(X500Principal r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalStateException();
    }

    private static X500Name notNull(X500Name r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalStateException();
    }

    private static byte[] notNull(byte[] r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new IllegalStateException();
    }
}
