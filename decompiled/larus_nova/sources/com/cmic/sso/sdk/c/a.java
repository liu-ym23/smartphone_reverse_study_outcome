package com.cmic.sso.sdk.c;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends SSLSocketFactory {
    protected SSLSocketFactory delegate;

    public a() {
        this.delegate = HttpsURLConnection.getDefaultSSLSocketFactory();
    }
}
