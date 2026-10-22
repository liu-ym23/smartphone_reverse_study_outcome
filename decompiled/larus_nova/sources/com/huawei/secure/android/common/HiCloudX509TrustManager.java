package com.huawei.secure.android.common;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes23.dex */
public class HiCloudX509TrustManager extends com.huawei.secure.android.common.ssl.SecureX509TrustManager {
    public HiCloudX509TrustManager(InputStream r100, String r101) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        super(r100, r101);
    }
}
