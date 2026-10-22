package com.larus.share.impl.sdk.special;

import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShareImageSpecialHandler f368758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f368759b;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        FLogger.f375446a.i("ShareImageSpecialHandler", "Download video success");
        ShareImageSpecialHandler r101 = this.f368758a;
        int r102 = this.f368759b.element;
        if (r100 == null) goto L5;
        String r103 = r100.getTargetFilePath();
    L6:
        ShareImageSpecialHandler.d(r101, r102, r103);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public d(ShareImageSpecialHandler r100, Ref.IntRef r101) {
        this.f368758a = r100;
        this.f368759b = r101;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("Download video failed: ");
        if (r101 == null) goto L5;
        String r104 = r101.getMessage();
    L6:
        r103.append(r104);
        r102.e("ShareImageSpecialHandler", r103.toString());
        ShareImageSpecialHandler.d(this.f368758a, this.f368759b.element, null);
        return;
    L5:
        r104 = null;
        goto L6
    }
}
