package com.example.myapplication;

import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes22.dex */
public final class AssetMp3Player$downloadFile$2 extends AbsDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f274040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f274041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f274042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f274043d;

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onProgress(DownloadInfo r100) {
        super.onProgress(r100);
        Function1 r101 = this.f274043d;
        if (r100 == null) goto L5;
        int r102 = r100.getDownloadProcess();
    L6:
        r101.invoke(Integer.valueOf(r102));
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onSuccessed(DownloadInfo r100) {
        super.onSuccessed(r100);
        if (r100 == null) goto L7;
        String r101 = r100.getSavePath();
        if (r101 == null) goto L7;
        this.f274041b.invoke(r101 + File.separator + this.f274040a);
        Unit r102 = Unit.INSTANCE;
        return;
    L7:
        new AssetMp3Player$downloadFile$2$onSuccessed$2(this);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public final void onFailed(DownloadInfo r100, BaseException r101) {
        super.onFailed(r100, r101);
        this.f274042c.invoke();
    }

    public AssetMp3Player$downloadFile$2(String r100, Function1 r101, Function0 r102, Function1 r103) {
        this.f274040a = r100;
        this.f274041b = r101;
        this.f274042c = r102;
        this.f274043d = r103;
    }
}
