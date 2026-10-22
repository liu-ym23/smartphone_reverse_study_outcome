package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.secure.android.common.ssl.util.ContextUtil;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.h;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes23.dex */
public class c implements X509TrustManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f278148c = "WebViewX509TrustManger";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private X509Certificate f278149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<X509TrustManager> f278150b;

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        ArrayList r100 = new ArrayList();     // Catch: Exception -> L8
        Iterator<X509TrustManager> r101 = this.f278150b.iterator();     // Catch: Exception -> L8
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.addAll(Arrays.asList(r101.next().getAcceptedIssuers()));     // Catch: Exception -> L8
        goto L4
    L6:
        return (X509Certificate[]) r100.toArray(new X509Certificate[r100.size()]);
    L8:
        e = move-exception;
        e.b(f278148c, "getAcceptedIssuers exception : " + e.getMessage());
        return new X509Certificate[0];
    }

    public c(Context r100) {
        this.f278150b = new ArrayList();
        if (r100 == null) goto L10;
        ContextUtil.setContext(r100);
        X509Certificate r101 = new h(r100).b();
        this.f278149a = r101;
        if (r101 == null) goto L8;
        return;
    L8:
        throw new NullPointerException("WebViewX509TrustManger cannot get cbg root ca");
    L10:
        throw new NullPointerException("WebViewX509TrustManger context is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] r100, String r101) throws CertificateException {
        e.c(f278148c, "checkClientTrusted");
        if (this.f278150b.isEmpty() == true) goto L7;
        ((X509TrustManager) ListProtector.get(this.f278150b, 0)).checkClientTrusted(r100, r101);
        return;
    L7:
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] r100, String r101) throws CertificateException {
        e.c(f278148c, "checkServerTrusted");
        boolean r102 = false;
        int r103 = 0;
    L4:
        if (r103 >= r100.length) goto L6;
        e.a(f278148c, "checkServerTrusted " + r103 + " : " + r100[r103].getIssuerDN().getName());
        r103 = r103 + 1;
        goto L4
    L6:
        X509Certificate[] r104 = new X509Certificate[r100.length];
        int r105 = 0;
    L8:
        if (r105 >= r100.length) goto L10;
        r104[r105] = r100[(r100.length - 1) - r105];
        r105 = r105 + 1;
        goto L8
    L10:
        CertificateException e100 = new CertificateException("CBG root CA CertificateException");
        r102 = com.huawei.secure.android.common.ssl.util.b.a(this.f278149a, r104);     // Catch: CertificateException -> L13 SignatureException -> L15 InvalidKeyException -> L17 NoSuchAlgorithmException -> L19 NoSuchProviderException -> L21
    L23:
        if (r102 == false) goto L25;
        return;
    L25:
        throw e100;
    L17:
        e = move-exception;
        e.b(f278148c, "checkServerTrusted InvalidKeyException: " + e.getMessage());
    L19:
        e = move-exception;
        e.b(f278148c, "checkServerTrusted NoSuchAlgorithmException: " + e.getMessage());
    L21:
        e = move-exception;
        e.b(f278148c, "checkServerTrusted NoSuchProviderException: " + e.getMessage());
    L15:
        e = move-exception;
        e.b(f278148c, "checkServerTrusted SignatureException: " + e.getMessage());
    L13:
        e100 = e;
        e.b(f278148c, "checkServerTrusted CertificateException: " + e100.getMessage());
        goto L23
    }
}
