package com.larus.doc.impl.video;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class m implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadTask f331495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f331496b;

    public m(DownloadTask r100, Context r101) {
        this.f331495a = r100;
        this.f331496b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        FLogger.f375446a.e("VideoDetailFragment", "Download video cancel, downloadId = " + this.f331495a.getDownloadId());
        Downloader.getInstance(this.f331496b).cancel(this.f331495a.getDownloadId());
        return Unit.INSTANCE;
    }
}
