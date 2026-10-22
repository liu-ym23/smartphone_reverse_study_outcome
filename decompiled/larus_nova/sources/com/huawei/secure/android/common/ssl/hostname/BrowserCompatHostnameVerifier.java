package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.e;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes23.dex */
public class BrowserCompatHostnameVerifier implements HostnameVerifier {
    public BrowserCompatHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String r100, SSLSession r101) {
        X509Certificate r102 = (X509Certificate) r101.getPeerCertificates()[0];     // Catch: SSLException -> L6
        e.c("", "verify: certificate is : " + r102.getSubjectDN().getName());     // Catch: SSLException -> L6
        b.a(r100, r102, false);     // Catch: SSLException -> L6
        c.a();     // Catch: SSLException -> L6
        return true;
    L6:
        e = move-exception;
        e.b("", "SSLException : " + e.getMessage());
        return false;
    }
}
