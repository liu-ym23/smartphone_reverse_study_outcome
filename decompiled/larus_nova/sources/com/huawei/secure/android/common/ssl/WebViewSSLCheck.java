package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.e;
import com.huawei.secure.android.common.ssl.util.h;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes23.dex */
public class WebViewSSLCheck {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f278126a = "WebViewSSLCheck";

    public WebViewSSLCheck() {
    }

    public static boolean checkServerCertificateNew(X509Certificate r100, SslError r101) {
        return com.huawei.secure.android.common.ssl.util.b.a(r100, com.huawei.secure.android.common.ssl.util.b.a(r101.getCertificate()));
    }

    public static boolean checkServerCertificateNew(String r100, SslError r101) {
        return checkServerCertificateNew(com.huawei.secure.android.common.ssl.util.b.a(r100), r101);
    }

    public static void checkServerCertificateNew(SslErrorHandler r100, SslError r101, Context r102) {
        checkServerCertificateNew(r100, r101, null, r102, null);
    }

    public static void checkServerCertificateNew(SslErrorHandler r100, SslError r101, String r102, Context r103, WebViewSSLCheckThread.Callback r104) {
        String r105 = f278126a;
        e.c(r105, " error type : " + r101.getPrimaryError() + " , cn is : " + r101.getCertificate().getIssuedTo().getCName());
        X509Certificate r106 = com.huawei.secure.android.common.ssl.util.b.a(r101.getCertificate());
        X509Certificate r107 = new h(r103).a();
        e.a(r105, "checkServerCertificateNew: error certificate is : " + r106);
        if (com.huawei.secure.android.common.ssl.util.b.a(r107, r106) == false) goto L9;
        e.c(r105, "checkServerCertificateNew: proceed");
        if (r104 == null) goto L7;
        r104.onProceed(r103, r102);
        return;
    L7:
        r100.proceed();
        return;
    L9:
        e.b(r105, "checkServerCertificateNew: cancel");
        if (r104 == null) goto L12;
        r104.onCancel(r103, r102);
        return;
    L12:
        r100.cancel();
    }
}
