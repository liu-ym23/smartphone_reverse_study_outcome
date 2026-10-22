package com.huawei.secure.android.common.ssl.hostname;

import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.e;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes23.dex */
public class StrictHostnameVerifier implements HostnameVerifier {
    public StrictHostnameVerifier() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String r100, SSLSession r101) {
        X509Certificate r102 = (X509Certificate) r101.getPeerCertificates()[0];     // Catch: SSLException -> L5
        e.c("", "verify: certificate is : " + r102.getSubjectDN().getName());     // Catch: SSLException -> L5
        b.a(r100, r102, true);     // Catch: SSLException -> L5
        c.a();     // Catch: SSLException -> L5
        return true;
    L5:
        e = move-exception;
        e.b("", "SSLException : " + e.getMessage());
        return false;
    }
}
