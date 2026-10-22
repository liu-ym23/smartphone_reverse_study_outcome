package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes23.dex */
public class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f278192b = "X509CertificateUtil";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f278193c = "hmsrootcas.bks";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f278194d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f278195e = "bks";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f278196f = "052root";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f278197g = "hmsincas.bks";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f278198h = "huawei cbg application integration ca";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f278199a;

    public X509Certificate a() {
        return a(f278197g, f278198h);
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f278196f);
    }

    public h(Context r100) {
        this.f278199a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate a(String r100, String r101) {
        ?? r102 = 0;
        X509Certificate r103 = null;
        KeyStore r104 = KeyStore.getInstance(f278195e);     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 CertificateException -> L20 KeyStoreException -> L22
        InputStream r105 = this.f278199a.getAssets().open(r100);     // Catch: Throwable -> L14 NoSuchAlgorithmException -> L16 IOException -> L18 CertificateException -> L20 KeyStoreException -> L22
        r105.reset();     // Catch: NoSuchAlgorithmException -> L6 IOException -> L8 CertificateException -> L10 KeyStoreException -> L12 Throwable -> L28
        r104.load(r105, "".toCharArray());     // Catch: NoSuchAlgorithmException -> L6 IOException -> L8 CertificateException -> L10 KeyStoreException -> L12 Throwable -> L28
        r103 = (X509Certificate) r104.getCertificate(r101);     // Catch: NoSuchAlgorithmException -> L6 IOException -> L8 CertificateException -> L10 KeyStoreException -> L12 Throwable -> L28
        r100 = r105;
    L26:
        d.a(r100);
        return r103;
    L8:
        e = e;
    L25:
        e.b(f278192b, "loadBksCA: exception : " + e.getMessage());     // Catch: Throwable -> L28
        r100 = r105;
    L12:
        e = e;
    L6:
        e = e;
    L10:
        e = e;
        goto L25
    L28:
        th = th;
        r102 = r100;
    L30:
        d.a(r102);
        throw th;
    L18:
        e = e;
    L17:
        r105 = null;
    L22:
        e = e;
    L16:
        e = e;
    L20:
        e = e;
    L14:
        th = th;
        goto L30
    }
}
