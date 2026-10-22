package com.larus.doc.impl.video;

import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import kotlin.Result;

/* JADX INFO: loaded from: classes27.dex */
public final class n extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.i<String> f331497a;

    public n(kotlinx.coroutines.j r100) {
        this.f331497a = r100;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        kotlinx.coroutines.i<String> r101 = this.f331497a;
        Result.Companion r102 = Result.Companion;
        if (r100 == null) goto L5;
        String r103 = r100.getTargetFilePath();
    L6:
        r101.resumeWith(Result.m9449constructorimpl(r103));
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("Download video failed: ");
        if (r101 == null) goto L5;
        String r104 = r101.getMessage();
    L6:
        r103.append(r104);
        r102.e("VideoDetailFragment", r103.toString());
        this.f331497a.resumeWith(Result.m9449constructorimpl(null));
        return;
    L5:
        r104 = null;
        goto L6
    }
}
