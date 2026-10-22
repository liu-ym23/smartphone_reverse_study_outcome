package com.huawei.secure.android.common.ssl;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* JADX INFO: loaded from: classes23.dex */
public class HiCloudX509TrustManager extends SecureX509TrustManager {
    public HiCloudX509TrustManager(InputStream r100, String r101) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, IllegalArgumentException {
        super(r100, r101);
    }
}
