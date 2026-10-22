package com.ss.android.downloadlib.addownload.pause;

import android.content.Context;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes34.dex */
public interface IPauseInterceptor {
    boolean interceptor(NativeDownloadModel r100, int r101, IPauseCallback r102, boolean r103, Context r104, DownloadInfo r105);
}
