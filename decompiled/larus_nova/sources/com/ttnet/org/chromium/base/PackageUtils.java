package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class PackageUtils {
    private static final char[] HEX_CHAR_LOOKUP = null;
    private static final String TAG = "PackageUtils";

    static {
        HEX_CHAR_LOOKUP = "0123456789ABCDEF".toCharArray();
    }

    private PackageUtils() {
    }

    public static String byteArrayToHexString(byte[] r100) {
        StringBuilder r101 = new StringBuilder((r100.length * 3) - 1);
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L10;
        char[] r103 = HEX_CHAR_LOOKUP;
        r101.append(r103[(r100[r102] & 240) >>> 4]);
        r101.append(r103[r100[r102] & 15]);
        if (r102 >= (r100.length - 1)) goto L8;
        r101.append(':');
    L8:
        r102 = r102 + 1;
        goto L4
    L10:
        return r101.toString();
    }

    public static List<String> getCertificateSHA256FingerprintForPackage(PackageManager r100, String r101) {
        PackageInfo r102 = r100.getPackageInfo(r101, 64);     // Catch: PackageManager.NameNotFoundException -> L16
        if (r102 != null) goto L6;
        return null;
    L6:
        ArrayList r103 = new ArrayList(r102.signatures.length);
        Signature[] r104 = r102.signatures;
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L15;
        String r107 = byteArrayToHexString(MessageDigest.getInstance("SHA256").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(r104[r106].toByteArray()))).getEncoded()));     // Catch: Throwable -> L11 CertificateEncodingException -> L13
    L12:
        r103.add(r107);
        r106 = r106 + 1;
    L11:
        r107 = null;
    L13:
        Log.w(TAG, "Certificate type X509 encoding failed", new Object[0]);
        return null;
    L15:
        return r103;
    L16:
        return null;
    }

    public static int getPackageVersion(Context r100, String r101) {
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r102 == null) goto L11;
        return r102.versionCode;
    L11:
        return -1;
    L12:
        return -1;
    }

    public static boolean isPackageInstalled(Context r100, String r101) {
        r100.getPackageManager().getPackageInfo(r101, 0);     // Catch: PackageManager.NameNotFoundException -> L6
        return true;
    L6:
        return false;
    }
}
