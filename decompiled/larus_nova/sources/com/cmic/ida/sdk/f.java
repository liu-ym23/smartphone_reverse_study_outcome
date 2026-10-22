package com.cmic.ida.sdk;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes22.dex */
public abstract class f extends SSLSocketFactory {
    protected SSLSocketFactory delegate;

    public f() {
        this.delegate = HttpsURLConnection.getDefaultSSLSocketFactory();
    }
}
