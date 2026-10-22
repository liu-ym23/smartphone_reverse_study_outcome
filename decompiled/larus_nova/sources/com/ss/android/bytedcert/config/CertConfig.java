package com.ss.android.bytedcert.config;

/* JADX INFO: loaded from: classes34.dex */
public interface CertConfig {
    public static final CertConfig CERT_CONFIG = null;

    boolean isEnableWebBack();

    static {
        CERT_CONFIG = new CertConfigAdapter();
    }
}
