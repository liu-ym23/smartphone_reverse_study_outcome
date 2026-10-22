package com.ss.android.downloadlib.install;

import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes34.dex */
public interface IDownloadInstallFeatureCallback {
    void onAfterIntercept(boolean r100);

    void onBeforeIntercept(DownloadShortInfo r100, IBeforeInterceptCallback r101);
}
