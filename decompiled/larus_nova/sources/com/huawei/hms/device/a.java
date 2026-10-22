package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IOUtils;
import com.huawei.secure.android.common.ssl.util.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes23.dex */
public class a {
    public static X509Certificate a(byte[] r100) {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r100));
    L4:
        e = move-exception;
        HMSLog.e("X509CertUtil", "Failed to get cert: " + e.getMessage());
        return null;
    }

    public static List<X509Certificate> b(List<String> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<String> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(a(r102.next()));
        goto L4
    L6:
        return r101;
    }

    private static List<String> c(String r100) {
        JSONArray r101 = new JSONArray(r100);     // Catch: JSONException -> L12
        if (r101.length() <= 1) goto L5;
        ArrayList r102 = new ArrayList(r101.length());     // Catch: JSONException -> L12
        int r103 = 0;
    L8:
        if (r103 >= r101.length()) goto L11;
        r102.add(JSONArrayProtectorUtils.getString(r101, r103));     // Catch: JSONException -> L12
        r103 = r103 + 1;
        goto L8
    L11:
        return r102;
    L5:
        return Collections.emptyList();
    L12:
        e = move-exception;
        HMSLog.e("X509CertUtil", "Failed to getCertChain: " + e.getMessage());
        return Collections.emptyList();
    }

    public static X509Certificate a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        return a(Base64.decode(r100));
    L7:
        e = move-exception;
        HMSLog.e("X509CertUtil", "getCert failed : " + e.getMessage());
        return null;
    }

    public static List<X509Certificate> b(String r100) {
        return b(c(r100));
    }

    public static boolean a(List<X509Certificate> r100) {
        int r101 = 0;
    L4:
        if (r101 >= (r100.size() - 1)) goto L9;
        if (a((X509Certificate) ListProtector.get(r100, r101)) == false) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public static boolean a(X509Certificate r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.getBasicConstraints() != (-1)) goto L8;
        return false;
    L8:
        boolean[] r101 = r100.getKeyUsage();
        if (5 < r101.length) goto L11;
        return false;
    L11:
        return r101[5];
    }

    public static X509Certificate a(Context r100) {
        return a(r100, h.f278196f);
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x008b: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:33554571), block:B:41:0x008b */
    public static X509Certificate a(Context r100, String r101) {
        InputStream r102 = null;
        if (r100 != null) goto L46;
    L44:
        HMSLog.e("X509CertUtil", "args are error");
        return null;
    L46:
        if (TextUtils.isEmpty(r101) == true) goto L44;
        KeyStore r103 = KeyStore.getInstance(h.f278195e);     // Catch: Throwable -> L27 NoSuchAlgorithmException -> L29 CertificateException -> L31 IOException -> L33 KeyStoreException -> L35
        InputStream r104 = r100.getAssets().open("hmsrootcas.bks");     // Catch: Throwable -> L27 NoSuchAlgorithmException -> L29 CertificateException -> L31 IOException -> L33 KeyStoreException -> L35
        r103.load(r104, "".toCharArray());     // Catch: NoSuchAlgorithmException -> L19 CertificateException -> L21 IOException -> L23 KeyStoreException -> L25 Throwable -> L40
        if (r103.containsAlias(r101) == true) goto L13;
        HMSLog.e("X509CertUtil", "Not include alias " + r101);     // Catch: NoSuchAlgorithmException -> L19 CertificateException -> L21 IOException -> L23 KeyStoreException -> L25 Throwable -> L40
        HMSPackageManager.getInstance(r100).setUseOldCertificate(true);     // Catch: NoSuchAlgorithmException -> L19 CertificateException -> L21 IOException -> L23 KeyStoreException -> L25 Throwable -> L40
        IOUtils.closeQuietly(r104);
        return null;
    L13:
        Certificate r105 = r103.getCertificate(r101);     // Catch: NoSuchAlgorithmException -> L19 CertificateException -> L21 IOException -> L23 KeyStoreException -> L25 Throwable -> L40
        if ((r105 instanceof X509Certificate) == false) goto L18;
        X509Certificate r106 = (X509Certificate) r105;     // Catch: NoSuchAlgorithmException -> L19 CertificateException -> L21 IOException -> L23 KeyStoreException -> L25 Throwable -> L40
        r106.checkValidity();     // Catch: NoSuchAlgorithmException -> L19 CertificateException -> L21 IOException -> L23 KeyStoreException -> L25 Throwable -> L40
        IOUtils.closeQuietly(r104);
        return r106;
    L18:
        IOUtils.closeQuietly(r104);
    L39:
        return null;
    L23:
        e = e;
    L37:
        HMSLog.e("X509CertUtil", "exception:" + e.getMessage());     // Catch: Throwable -> L40
        IOUtils.closeQuietly(r104);
    L25:
        e = e;
    L19:
        e = e;
    L21:
        e = e;
        goto L37
    L33:
        e = e;
    L30:
        r104 = null;
    L35:
        e = e;
    L29:
        e = e;
    L31:
        e = e;
    L27:
        th = th;
    L42:
        IOUtils.closeQuietly(r102);
        throw th;
    L40:
        th = th;
        r102 = r5;
        goto L42
    }

    public static boolean b(X509Certificate r100, String r101) {
        return b(r100, "OU", r101);
    }

    public static boolean a(X509Certificate r100, List<X509Certificate> r101) {
        if (r101 != null) goto L5;
    L31:
        return false;
    L5:
        if (r101.size() == 0) goto L31;
        if (r100 != null) goto L11;
        HMSLog.e("X509CertUtil", "rootCert is null,verify failed ");
        return false;
    L11:
        PublicKey r102 = r100.getPublicKey();
        Iterator<X509Certificate> r103 = r101.iterator();
    L13:
        if (r103.hasNext() == false) goto L30;
        X509Certificate r104 = r103.next();
        if (r104 == null) goto L28;
        r104.checkValidity();     // Catch: SignatureException -> L18 NoSuchProviderException -> L20 InvalidKeyException -> L22 NoSuchAlgorithmException -> L24 Throwable -> L26
        r104.verify(r102);     // Catch: SignatureException -> L18 NoSuchProviderException -> L20 InvalidKeyException -> L22 NoSuchAlgorithmException -> L24 Throwable -> L26
        r102 = r104.getPublicKey();     // Catch: SignatureException -> L18 NoSuchProviderException -> L20 InvalidKeyException -> L22 NoSuchAlgorithmException -> L24 Throwable -> L26
    L26:
        e = move-exception;
        HMSLog.e("X509CertUtil", "verify failed " + e.getMessage());
    L28:
        return false;
    L30:
        return a(r101);
    }

    private static String a(String r100, String r101) {
        int r102 = r100.toUpperCase(Locale.getDefault()).indexOf(r101 + ContainerUtils.KEY_VALUE_DELIMITER);
        if (r102 != (-1)) goto L6;
        return null;
    L6:
        int r103 = r100.indexOf(",", r102);
        if (r103 == (-1)) goto L11;
        return r100.substring((r102 + r101.length()) + 1, r103);
    L11:
        return r100.substring((r102 + r101.length()) + 1);
    }

    public static boolean a(X509Certificate r100, String r101) {
        return b(r100, "CN", r101);
    }

    public static boolean a(X509Certificate r100, byte[] r101, byte[] r102) {
        Signature r103 = Signature.getInstance(r100.getSigAlgName());     // Catch: InvalidKeyException -> L4 SignatureException -> L6 Throwable -> L8
        r103.initVerify(r100.getPublicKey());     // Catch: InvalidKeyException -> L4 SignatureException -> L6 Throwable -> L8
        r103.update(r101);     // Catch: InvalidKeyException -> L4 SignatureException -> L6 Throwable -> L8
        return r103.verify(r102);
    L8:
        e = move-exception;
        HMSLog.e("X509CertUtil", "failed checkSignature : " + e.getMessage());
        return false;
    }

    public static boolean b(X509Certificate r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return false;
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L9;
        return false;
    L9:
        return r102.equals(a(r100.getSubjectDN().getName(), r101));
    }

    public static boolean a(X509Certificate r100, String r101, String r102) {
        return a(r100, r101.getBytes("UTF-8"), Base64.decode(r102));
    L6:
        e = move-exception;
        HMSLog.e("X509CertUtil", " plainText exception: " + e.getMessage());
        return false;
    }
}
