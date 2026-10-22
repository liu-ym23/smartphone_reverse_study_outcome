package com.unionpay.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static String a(Context r100, String r101) {
        String r102 = "";
    L50:
        e = move-exception;
        Exception e100 = e;
    L52:
        e100.printStackTrace();
        return r102;
    L4:
        X509Certificate r103 = null;
        PackageInfo r104 = r100.getPackageManager().getPackageInfo(r101, 64);     // Catch: PackageManager.NameNotFoundException -> L7 Exception -> L50
    L9:
        if (r104 == null) goto L68;
        int r105 = 0;
        ByteArrayInputStream r106 = new ByteArrayInputStream(r104.signatures[0].toByteArray());     // Catch: Exception -> L50
        CertificateFactory r107 = CertificateFactory.getInstance("X509");     // Catch: CertificateException -> L13 Exception -> L50
    L16:
        if (r107 == null) goto L63;
        Certificate r108 = r107.generateCertificate(r106);     // Catch: CertificateException -> L21 Exception -> L50
        if ((r108 instanceof X509Certificate) == false) goto L63;
        r103 = (X509Certificate) r108;     // Catch: CertificateException -> L21 Exception -> L50
        goto L63
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L50
    L63:
        MessageDigest r109 = MessageDigest.getInstance("SHA256");     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
        if (r103 == null) goto L43;
        byte[] r110 = r109.digest(r103.getEncoded());     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
        StringBuilder r111 = new StringBuilder(r110.length * 2);     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
    L27:
        if (r105 >= r110.length) goto L37;
        String r112 = Integer.toHexString(r110[r105]);     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
        int r113 = r112.length();     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
        if (r113 != 1) goto L31;
        r112 = "0".concat(r112);     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
    L31:
        if (r113 <= 2) goto L33;
        r112 = r112.substring(r113 - 2, r113);     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
    L33:
        r111.append(r112.toUpperCase());     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
        if (r105 >= (r110.length - 1)) goto L36;
        r111.append(':');     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
    L36:
        r105 = r105 + 1;     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
        goto L27
    L37:
        String r114 = r111.toString();     // Catch: CertificateEncodingException -> L39 NoSuchAlgorithmException -> L41 Exception -> L50
    L44:
        if (r114 == null) goto L69;
        return r114.replaceAll(":", "");
    L47:
        e100 = e;
        r102 = r114;
        goto L52
    L69:
        return r114;
    L43:
        r114 = "";
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L50
    L39:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L50
        goto L43
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L50
        r107 = null;
        goto L16
    L68:
        return "";
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L50
        r104 = null;
        goto L9
    }
}
