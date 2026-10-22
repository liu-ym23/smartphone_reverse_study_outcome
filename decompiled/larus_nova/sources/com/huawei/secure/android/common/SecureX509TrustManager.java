package com.huawei.secure.android.common;

import android.content.Context;
import java.io.IOException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes23.dex */
public class SecureX509TrustManager extends com.huawei.secure.android.common.ssl.SecureX509TrustManager {
    public SecureX509TrustManager(Context r100) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException {
        super(r100);
    }
}
