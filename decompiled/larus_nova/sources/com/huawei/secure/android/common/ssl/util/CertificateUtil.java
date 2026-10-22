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
public final class CertificateUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278178a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public static X509Certificate getHwCbgRootCA(Context r100) {
        ?? r101 = 0;
        X509Certificate r102 = null;
        KeyStore r103 = KeyStore.getInstance(h.f278195e);     // Catch: Throwable -> L16 RuntimeException -> L18 NoSuchAlgorithmException -> L20 IOException -> L22 CertificateException -> L24 KeyStoreException -> L26
        InputStream r104 = r100.getAssets().open("hmsrootcas.bks");     // Catch: Throwable -> L16 RuntimeException -> L18 NoSuchAlgorithmException -> L20 IOException -> L22 CertificateException -> L24 KeyStoreException -> L26
    L39:
        r104.reset();     // Catch: RuntimeException -> L6 NoSuchAlgorithmException -> L8 IOException -> L10 CertificateException -> L12 KeyStoreException -> L14 Throwable -> L32
        r103.load(r104, "".toCharArray());     // Catch: RuntimeException -> L6 NoSuchAlgorithmException -> L8 IOException -> L10 CertificateException -> L12 KeyStoreException -> L14 Throwable -> L32
        r102 = (X509Certificate) r103.getCertificate(h.f278196f);     // Catch: RuntimeException -> L6 NoSuchAlgorithmException -> L8 IOException -> L10 CertificateException -> L12 KeyStoreException -> L14 Throwable -> L32
        r100 = r104;
    L30:
        d.a(r100);
        return r102;
    L10:
        e = e;
    L29:
        e.b(f278178a, "loadBksCA: exception : " + e.getMessage());     // Catch: Throwable -> L32
        r100 = r104;
    L6:
        e = e;
    L14:
        e = e;
    L8:
        e = e;
    L12:
        e = e;
    L32:
        th = th;
        r101 = r100;
    L34:
        d.a(r101);
        throw th;
    L22:
        e = e;
    L19:
        r104 = null;
    L18:
        e = e;
    L26:
        e = e;
    L20:
        e = e;
    L24:
        e = e;
    L16:
        th = th;
        goto L34
    }
}
