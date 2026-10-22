package com.larus.dora.impl.ota.g2;

import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class m5 implements IDownloadListener {
    final /* synthetic */ o.a $callback;

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstStart(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstSuccess(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPrepare(DownloadInfo r100) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onRetry(DownloadInfo r100, BaseException r101) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    @Deprecated(message = "")
    public final void onRetryDelay(DownloadInfo r100, BaseException r101) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onStart(DownloadInfo r100) {
    }

    public m5(AndroidG2OtaRuntime$startLocked$1 r100) {
        this.$callback = r100;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onCanceled(DownloadInfo r100) {
        this.$callback.a(false);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPause(DownloadInfo r100) {
        this.$callback.z();
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        if (r100 == null) goto L5;
        this.$callback.b(r100.getCurBytes());
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        this.$callback.c();
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        o.a r102 = this.$callback;
        l5.a().getClass();
        Set r103 = l5.d();
        if (r101 == null) goto L5;
        Integer r104 = Integer.valueOf(r101.getErrorCode());
    L6:
        r102.a(CollectionsKt.contains(r103, r104));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
