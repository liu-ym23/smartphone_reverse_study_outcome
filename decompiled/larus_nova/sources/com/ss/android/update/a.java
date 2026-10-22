package com.ss.android.update;

import com.bytedance.common.utility.Logger;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import yhc.i;

/* JADX INFO: loaded from: classes40.dex */
public final class a implements IDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f455240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f455241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f455242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f455243d;

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onCanceled(DownloadInfo r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onCanceled ");
    L5:
        i r101 = this.f455243d.f455247d.get();
        if (r101 == null) goto L8;
        r101.a(false, this.f455240a);
    L8:
        c.d(this.f455241b, this.f455242c, this.f455240a, "cancel", "");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstStart(DownloadInfo r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onFirstStart ");
    L5:
        c.d(this.f455241b, this.f455242c, this.f455240a, "first_start", "");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFirstSuccess(DownloadInfo r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onFirstSuccess ");
    L5:
        c.d(this.f455241b, this.f455242c, this.f455240a, "first_success", "");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPause(DownloadInfo r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onPause ");
    L5:
        i r101 = this.f455243d.f455247d.get();
        if (r101 == null) goto L8;
        r101.a(false, this.f455240a);
    L8:
        c.d(this.f455241b, this.f455242c, this.f455240a, "pause", "");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onPrepare(DownloadInfo r100) {
        i r101 = this.f455243d.f455247d.get();
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        if (Logger.debug() == false) goto L8;
        Logger.d("UpdateDownloadHelper", "onPrepare " + r100.getTotalBytes() + " " + this.f455240a);
    L8:
        r101.e((int) r100.getTotalBytes(), this.f455240a);
        r101.b(this.f455240a);
    L9:
        c.d(this.f455241b, this.f455242c, this.f455240a, "prepare", "");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        i r101 = this.f455243d.f455247d.get();
        if (r100 == null) goto L10;
        if (r101 != null) goto L6;
        return;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("UpdateDownloadHelper", "onProgress " + r100.getCurBytes() + " " + r100.getTotalBytes());
    L8:
        r101.d((int) r100.getCurBytes(), (int) r100.getTotalBytes(), this.f455240a);
        return;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onStart(DownloadInfo r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onStart ");
    L5:
        c.d(this.f455241b, this.f455242c, this.f455240a, "start", "");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onSuccessed ");
    L5:
        i r101 = this.f455243d.f455247d.get();
        if (r101 == null) goto L8;
        r101.d((int) r100.getCurBytes(), (int) r100.getTotalBytes(), this.f455240a);
        r101.a(true, this.f455240a);
    L8:
        c.e("");
        c.d(this.f455241b, this.f455242c, this.f455240a, "success", "");
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onFailed ");
    L5:
        i r102 = this.f455243d.f455247d.get();
        if (r102 == null) goto L8;
        r102.a(false, this.f455240a);
    L8:
        String r103 = "download fail: ";
        if (r101 == null) goto L11;
        r103 = "download fail: " + r101.getErrorMessage();
    L11:
        c.e(r103);
        c.d(this.f455241b, this.f455242c, this.f455240a, "fail", r103);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onRetry(DownloadInfo r100, BaseException r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onRetry ");
    L5:
        String r102 = "download retry: ";
        if (r101 == null) goto L8;
        r102 = "download retry: " + r101.getErrorMessage();
    L8:
        c.d(this.f455241b, this.f455242c, this.f455240a, EventConstant.Value.RETRY, r102);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onRetryDelay(DownloadInfo r100, BaseException r101) {
        if (Logger.debug() == false) goto L5;
        Logger.d("UpdateDownloadHelper", "onRetryDelay ");
    L5:
        String r102 = "download retry delay: ";
        if (r101 == null) goto L8;
        r102 = "download retry delay: " + r101.getErrorMessage();
    L8:
        c.d(this.f455241b, this.f455242c, this.f455240a, "retry_delay", r102);
    }

    public a(b r100, boolean r101, String r102, int r103) {
        this.f455243d = r100;
        this.f455240a = r101;
        this.f455241b = r102;
        this.f455242c = r103;
    }
}
