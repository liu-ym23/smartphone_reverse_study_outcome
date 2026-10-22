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
public class SSFSecureX509SingleInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278076a = "SSFSecureX509SingleInstance";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile SecureX509TrustManager f278077b;

    private SSFSecureX509SingleInstance() {
    }

    public static SecureX509TrustManager getInstance(Context r100) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        if (r100 == null) goto L22;
        ContextUtil.setContext(r100);
        if (f278077b != null) goto L20;
        monitor-enter(SSFSecureX509SingleInstance.class);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (f278077b != null) goto L14;
        InputStream r101 = BksUtil.getFilesBksIS(r100);     // Catch: Throwable -> L16
        if (r101 != null) goto L12;
        e.c(f278076a, "get assets bks");     // Catch: Throwable -> L16
        r101 = r100.getAssets().open("hmsrootcas.bks");     // Catch: Throwable -> L16
    L13:
        f278077b = new SecureX509TrustManager(r101, "", true);     // Catch: Throwable -> L16
        goto L14
    L12:
        e.c(f278076a, "get files bks");     // Catch: Throwable -> L16
    L14:
        monitor-exit(SSFSecureX509SingleInstance.class);     // Catch: Throwable -> L16
    L20:
        return f278077b;
    L22:
        throw new NullPointerException("context is null");
    }

    public static void updateBks(InputStream r100) {
        String r101 = f278076a;
        e.c(r101, "update bks");
        long r102 = System.currentTimeMillis();
        if (r100 != null) goto L5;
    L7:
        e.a(r101, "update bks cost : " + (System.currentTimeMillis() - r102) + " ms");
        return;
    L5:
        if (f278077b == null) goto L7;
        f278077b = new SecureX509TrustManager(r100, "", true);
        e.a(r101, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - r102) + " ms");
        SSFCompatiableSystemCA.a(f278077b);
        SASFCompatiableSystemCA.a(f278077b);
        goto L7
    }

    public static void updateBks(InputStream r100, SecureRandom r101) {
        String r102 = f278076a;
        e.c(r102, "update bks");
        long r103 = System.currentTimeMillis();
        if (r100 != null) goto L5;
    L7:
        e.a(r102, "update bks cost : " + (System.currentTimeMillis() - r103) + " ms");
        return;
    L5:
        if (f278077b == null) goto L7;
        f278077b = new SecureX509TrustManager(r100, "", true);
        e.a(r102, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - r103) + " ms");
        SSFCompatiableSystemCA.a(f278077b, r101);
        SASFCompatiableSystemCA.a(f278077b, r101);
        goto L7
    }
}
