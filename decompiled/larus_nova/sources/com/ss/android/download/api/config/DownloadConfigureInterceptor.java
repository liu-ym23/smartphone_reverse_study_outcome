package com.ss.android.download.api.config;

import com.ss.android.download.api.DownloadConfigure;

/* JADX INFO: loaded from: classes34.dex */
public interface DownloadConfigureInterceptor {
    DownloadConfigure getDownloadConfigure(String r100);

    boolean shouldIntercept(String r100);
}
