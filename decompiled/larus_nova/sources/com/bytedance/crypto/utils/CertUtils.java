package com.bytedance.crypto.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.cert.CertPathValidator;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class CertUtils {
    private static final String TAG = "CertUtils";

    public CertUtils() {
    }

    public static String certsToPemString(List<Certificate> r100, int r101) {
        if (r100 == null) goto L25;
        if (r100.isEmpty() == true) goto L25;
        if (r101 <= 0) goto L25;
        if (r101 > r100.size()) goto L25;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();
        Iterator<Certificate> r103 = r100.iterator();
        int r104 = 0;
    L10:
        if (r103.hasNext() == false) goto L23;
        Certificate r105 = r103.next();
        if (r104 >= r101) goto L23;
        if (r105 == null) goto L21;
        r102.write("-----BEGIN CERTIFICATE-----\\n".getBytes());
        String r106 = Base64.getEncoder().encodeToString(r105.getEncoded());
        int r107 = 0;
    L17:
        if (r107 >= r106.length()) goto L19;
        int r108 = r107 + 64;
        r102.write(r106.substring(r107, Math.min(r108, r106.length())).getBytes());
        r107 = r108;
        goto L17
    L19:
        r102.write("\\n".getBytes());
        r102.write("-----END CERTIFICATE-----\\n".getBytes());
        r104 = r104 + 1;
        goto L10
    L21:
        throw new IllegalArgumentException("Certificate is null at index " + r104);
    L23:
        return r102.toString();
    L25:
        throw new IllegalArgumentException("Certificate list is null, empty, or certNum is invalid");
    }

    public static List<X509Certificate> convertToX509Certificates(byte[] r100) {
        ArrayList r101 = new ArrayList();
        Iterator<? extends Certificate> r102 = CertificateFactory.getInstance("X.509").generateCertificates(new ByteArrayInputStream(r100)).iterator();     // Catch: CertificateException -> L10
    L5:
        if (r102.hasNext() == false) goto L12;
        Certificate r103 = r102.next();     // Catch: CertificateException -> L10
        if ((r103 instanceof X509Certificate) == false) goto L5;
        r101.add((X509Certificate) r103);     // Catch: CertificateException -> L10
    L12:
        return r101;
    L10:
        e = move-exception;
        LogUtils.e(TAG, "convertToX509Certificates failed, exception: " + e.getMessage());
        goto L12
    }

    public static X509Certificate pemStringToX509(String r100) {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(Base64.getDecoder().decode(r100.replace("-----BEGIN CERTIFICATE-----", "").replace("-----END CERTIFICATE-----", "").replace("\n", ""))));
    L5:
        e = move-exception;
        LogUtils.e(TAG, "pemStringToX509 failed, exception: " + e.getMessage());
        return null;
    }

    public static boolean validateCertChain(X509Certificate r100, List<X509Certificate> r101) {
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        if (r101.isEmpty() == true) goto L15;
        HashSet r102 = new HashSet();
        r102.add(new TrustAnchor(r100, null));
        PKIXParameters r103 = new PKIXParameters(r102);     // Catch: Exception -> L12
        r103.setRevocationEnabled(false);     // Catch: Exception -> L12
        CertPathValidator.getInstance("PKIX").validate(CertificateFactory.getInstance("X.509").generateCertPath(r101), r103);     // Catch: Exception -> L12
        return true;
    L12:
        e = move-exception;
        LogUtils.e(TAG, "validateCertChain failed, exception: " + e.getMessage());
        return false;
    L15:
        LogUtils.e(TAG, "Invalid params.");
        return false;
    }
}
