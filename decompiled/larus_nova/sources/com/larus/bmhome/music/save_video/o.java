package com.larus.bmhome.music.save_video;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
public final class o implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DownloadTask f313119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f313120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f313121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Job> f313122d;

    public o(DownloadTask r100, String r101, Context r102, Ref.ObjectRef<Job> r103) {
        this.f313119a = r100;
        this.f313120b = r101;
        this.f313121c = r102;
        this.f313122d = r103;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        FLogger.f375446a.i("save_music_video", "Download audio cancel, downloadId = " + this.f313119a.getDownloadId() + ", downloadTaskKey is " + this.f313120b);
        Downloader.getInstance(this.f313121c).cancel(this.f313119a.getDownloadId());
        Job r101 = this.f313122d.element;
        if (r101 == null) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L6:
        return Unit.INSTANCE;
    }
}
