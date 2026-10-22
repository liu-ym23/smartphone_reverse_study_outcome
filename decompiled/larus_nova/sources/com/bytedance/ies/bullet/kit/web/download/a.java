package com.bytedance.ies.bullet.kit.web.download;

import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebResourceDownloader f246958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f246959b;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        ExecutorService r101 = BulletLogger.f247763a;
        BulletLogger.k("WebResourceDownloader: download success " + r100.getUrl(), null, "XPreload", 2);
        Downloader.getInstance(this.f246958a.f246956a).removeMainThreadListener(r100.getId(), this);
    }

    public a(WebResourceDownloader r100, String r101) {
        this.f246958a = r100;
        this.f246959b = r101;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        Intrinsics.checkNotNullParameter(r101, "e");
        ExecutorService r102 = BulletLogger.f247763a;
        BulletLogger.k("WebResourceDownloader: download failed url=" + this.f246959b + ",errorCode=" + r101.getErrorCode() + ",errorMsg=" + r101.getErrorMessage(), null, "XPreload", 2);
        Downloader.getInstance(this.f246958a.f246956a).removeMainThreadListener(r100.getId(), this);
    }
}
