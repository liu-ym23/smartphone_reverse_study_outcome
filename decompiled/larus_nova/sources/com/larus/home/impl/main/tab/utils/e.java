package com.larus.home.impl.main.tab.utils;

import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes29.dex */
public final class e implements IDownloadListener {
    public e() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstStart(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstSuccess(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPause(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPrepare(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onRetry(DownloadInfo r100, BaseException r101) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onRetryDelay(DownloadInfo r100, BaseException r101) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onCanceled(DownloadInfo r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        BaseException r102 = r100.getFailedException();
    L6:
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("download cancels, status=");
        if (r100 == null) goto L9;
        Integer r105 = Integer.valueOf(r100.getStatus());
    L10:
        r104.append(r105);
        r104.append(", code=");
        if (r102 == null) goto L13;
        Integer r106 = Integer.valueOf(r102.getErrorCode());
    L14:
        r104.append(r106);
        r104.append(", msg=");
        if (r102 == null) goto L17;
        r101 = r102.getErrorMessage();
    L17:
        r104.append(r101);
        r103.w("MiddleTabUIHelper", r104.toString());
        return;
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onStart(DownloadInfo r100) {
        FLogger.f375446a.i("MiddleTabUIHelper", "download_starts");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        FLogger.f375446a.i("MiddleTabUIHelper", "download_succeeds");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        String r102 = null;
        if (r100 == null) goto L5;
        BaseException r103 = r100.getFailedException();
    L6:
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("download fails, status=");
        if (r100 == null) goto L9;
        Integer r106 = Integer.valueOf(r100.getStatus());
    L10:
        r105.append(r106);
        r105.append(", code=");
        if (r103 == null) goto L13;
        Integer r107 = Integer.valueOf(r103.getErrorCode());
    L14:
        r105.append(r107);
        r105.append(", msg=");
        if (r103 == null) goto L17;
        r102 = r103.getErrorMessage();
    L17:
        r105.append(r102);
        r104.w("MiddleTabUIHelper", r105.toString());
        return;
    L13:
        r107 = null;
        goto L14
    L9:
        r106 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }
}
