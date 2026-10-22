package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.BksUtil;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes23.dex */
public class SecureX509SingleInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278116a = "SecureX509SingleInstance";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f278117b;

    private SecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context r100) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        long r101 = System.currentTimeMillis();
        if (r100 == null) goto L25;
        ContextUtil.setContext(r100);
        if (f278117b == null) goto L7;
    L22:
        e.a(f278116a, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - r101) + " ms");
        return f278117b;
    L7:
        monitor-enter(SecureX509SingleInstance.class);
    L19:
        th = move-exception;
        throw th;
    L9:
        if (f278117b == null) goto L28;
    L17:
        monitor-exit(SecureX509SingleInstance.class);     // Catch: Throwable -> L19
        goto L22
    L28:
        InputStream r102 = BksUtil.getFilesBksIS(r100);     // Catch: RuntimeException -> L12 Throwable -> L19
    L13:
        if (r102 != null) goto L15;
        e.c(f278116a, "get assets bks");     // Catch: Throwable -> L19
        r102 = r100.getAssets().open("hmsrootcas.bks");     // Catch: Throwable -> L19
    L16:
        f278117b = new SecureX509TrustManager(r102, "");     // Catch: Throwable -> L19
        goto L17
    L15:
        e.c(f278116a, "get files bks");     // Catch: Throwable -> L19
        goto L16
    L12:
        e.b(f278116a, "get files bks error");     // Catch: Throwable -> L19
        r102 = null;
        goto L13
    L25:
        throw new NullPointerException("context is null");
    }

    public static void updateBks(InputStream r100) {
        String r101 = f278116a;
        e.c(r101, "update bks");
        long r102 = System.currentTimeMillis();
        if (r100 != null) goto L5;
    L7:
        e.c(r101, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - r102) + " ms");
        return;
    L5:
        if (f278117b == null) goto L7;
        f278117b = new SecureX509TrustManager(r100, "");
        SecureSSLSocketFactory.a(f278117b);
        SecureApacheSSLSocketFactory.a(f278117b);
        goto L7
    }

    public static void updateBks(InputStream r100, SecureRandom r101) {
        String r102 = f278116a;
        e.c(r102, "update bks");
        long r103 = System.currentTimeMillis();
        if (r100 != null) goto L5;
    L7:
        e.c(r102, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - r103) + " ms");
        return;
    L5:
        if (f278117b == null) goto L7;
        f278117b = new SecureX509TrustManager(r100, "");
        SecureSSLSocketFactory.a(f278117b, r101);
        SecureApacheSSLSocketFactory.a(f278117b, r101);
        goto L7
    }
}
