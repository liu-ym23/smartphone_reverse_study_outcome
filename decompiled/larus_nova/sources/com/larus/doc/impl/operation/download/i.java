package com.larus.doc.impl.operation.download;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;

/* JADX INFO: loaded from: classes27.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f331380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f331381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IDownloadListener f331382c;

    public /* synthetic */ i(Context r100, int r101, IDownloadListener r102) {
        this.f331380a = r100;
        this.f331381b = r101;
        this.f331382c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f331380a;
        int r101 = this.f331381b;
        IDownloadListener r102 = this.f331382c;
        Downloader.getInstance(r100).removeMainThreadListener(r101, r102);
    }
}
