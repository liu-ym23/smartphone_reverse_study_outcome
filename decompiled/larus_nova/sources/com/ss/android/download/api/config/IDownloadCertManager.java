package com.ss.android.download.api.config;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.appdownloader.AppTaskBuilder;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadInterceptor;

/* JADX INFO: loaded from: classes34.dex */
public interface IDownloadCertManager extends IAppDownloadInterceptor {
    Object getAdDownloadCert(DownloadModel r100, DownloadController r101, DownloadEventConfig r102);

    Object getCommonDownloadCert(DownloadModel r100, DownloadController r101, DownloadEventConfig r102);

    Object getGameDownloadCert(DownloadModel r100, DownloadController r101, DownloadEventConfig r102);

    @Override // com.ss.android.socialbase.appdownloader.depend.IAppDownloadInterceptor
    boolean intercept(AppTaskBuilder r100);
}
