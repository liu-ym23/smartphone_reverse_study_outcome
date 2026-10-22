package com.huawei.secure.android.common.ssl.util;

import android.net.http.SslCertificate;
import java.io.ByteArrayInputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278180a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f278181b = 5;

    public b() {
    }

    public static X509Certificate a(String r100) {
        return (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(r100.getBytes()));
    L4:
        e = move-exception;
        e.b(f278180a, "generateX509FromStr: CertificateException" + e.getMessage());
        return null;
    }

    public static boolean b(X509Certificate[] r100) {
        Date r101 = new Date();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L15;
        r100[r103].checkValidity(r101);     // Catch: Exception -> L7 CertificateNotYetValidException -> L10 CertificateExpiredException -> L12
        r103 = r103 + 1;
        goto L3
    L12:
        e = e;
    L13:
        e.b(f278180a, "verifyCertificateDate: exception : " + e.getMessage());
        return false;
    L10:
        e = e;
    L7:
        e = move-exception;
        e.b(f278180a, "verifyCertificateDate : exception : " + e.getMessage());
        return false;
    L15:
        return true;
    }

    public static X509Certificate a(SslCertificate r100) {
        byte[] r101 = SslCertificate.saveState(r100).getByteArray("x509-certificate");
        if (r101 != null) goto L10;
    L8:
        return null;
    L10:
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r101));
    L6:
        e = move-exception;
        e.a(f278180a, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, e);
        goto L8
    }

    public static boolean a(X509Certificate r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getBasicConstraints() != (-1)) goto L9;
        return false;
    L9:
        return r100.getKeyUsage()[5];
    }

    public static boolean a(X509Certificate[] r100) {
        int r101 = 0;
    L4:
        if (r101 >= (r100.length - 1)) goto L9;
        if (a(r100[r101]) == false) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static boolean a(X509Certificate r100, X509Certificate r101) {
        r101.verify(r100.getPublicKey());     // Catch: Exception -> L9 SignatureException -> L12 NoSuchProviderException -> L15 NoSuchAlgorithmException -> L18 InvalidKeyException -> L21 CertificateException -> L24
    L5:
        if (b(new X509Certificate[]{r100, r101}) == true) goto L8;
        e.b(f278180a, "verify: date not right");
        return false;
    L8:
        return true;
    L21:
        e = move-exception;
        e.b(f278180a, "verify: publickey InvalidKeyException " + e.getMessage());
        return false;
    L18:
        e = move-exception;
        e.b(f278180a, "verify: publickey NoSuchAlgorithmException " + e.getMessage());
        return false;
    L15:
        e = move-exception;
        e.b(f278180a, "verify: publickey NoSuchProviderException " + e.getMessage());
        return false;
    L12:
        e = move-exception;
        e.b(f278180a, "verify: publickey SignatureException " + e.getMessage());
        return false;
    L24:
        e = move-exception;
        e.b(f278180a, "verify: publickey CertificateException " + e.getMessage());
        return false;
    L9:
        e = move-exception;
        e.b(f278180a, "verify: Exception " + e.getMessage());
        return false;
    }

    public static boolean a(X509Certificate[] r100, X509CRL r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L6;
        r102.add(r100[r104].getSerialNumber());
        r104 = r104 + 1;
        goto L3
    L6:
        if (r101 != null) goto L23;
        return true;
    L23:
        Set<? extends X509CRLEntry> r105 = r101.getRevokedCertificates();     // Catch: Exception -> L20
        if (r105 != null) goto L11;
    L19:
        return true;
    L11:
        if (r105.isEmpty() == true) goto L19;
        Iterator<? extends X509CRLEntry> r106 = r105.iterator();     // Catch: Exception -> L20
    L14:
        if (r106.hasNext() == false) goto L19;
        if (r102.contains(r106.next().getSerialNumber()) == false) goto L14;
        e.b(f278180a, "verify: certificate revoked");     // Catch: Exception -> L20
        return false;
    L20:
        e = move-exception;
        e.b(f278180a, "verify: revoked verify exception : " + e.getMessage());
        return false;
    }

    public static boolean a(X509Certificate r100, X509Certificate[] r101) throws NoSuchProviderException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Principal r102 = null;
        int r103 = 0;
    L4:
        if (r103 >= r101.length) goto L14;
        X509Certificate r104 = r101[r103];
        Principal r105 = r104.getIssuerDN();
        Principal r106 = r104.getSubjectDN();
        if (r102 == null) goto L12;
        if (r105.equals(r102) == false) goto L10;
        r101[r103].verify(r101[r103 - 1].getPublicKey());
        goto L12
    L10:
        e.b(f278180a, "verify: principalIssuer not match");
        return false;
    L12:
        r103 = r103 + 1;
        r102 = r106;
        goto L4
    L14:
        if (a(r100, r101[0]) == true) goto L17;
        return false;
    L17:
        if (b(r101) == true) goto L20;
        return false;
    L20:
        if (a(r100) == true) goto L23;
        return false;
    L23:
        if (a(r101) == true) goto L25;
        return false;
    L25:
        return true;
    }

    public static boolean a(X509Certificate r100, String r101) {
        if (r101.equals(r100.getSubjectDN().getName()) == true) goto L6;
        e.b(f278180a, "verify: subject name is error");
        return false;
    L6:
        return true;
    }

    public static boolean a(X509Certificate r100, X509Certificate[] r101, X509CRL r102, String r103) throws NoSuchAlgorithmException, CertificateException, NoSuchProviderException, InvalidKeyException, SignatureException {
        if (a(r100, r101) == false) goto L6;
        return false;
    L6:
        if (a(r101, r102) == false) goto L9;
        return false;
    L9:
        if (a(r101[r101.length - 1], r103) == true) goto L12;
        return false;
    L12:
        if (b(r101) == true) goto L14;
        return false;
    L14:
        return true;
    }
}
