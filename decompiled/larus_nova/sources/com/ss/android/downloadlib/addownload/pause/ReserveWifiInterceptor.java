package com.ss.android.downloadlib.addownload.pause;

import android.content.Context;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.ReverseWifiHelper;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes34.dex */
public class ReserveWifiInterceptor implements IPauseInterceptor {
    public ReserveWifiInterceptor() {
    }

    @Override // com.ss.android.downloadlib.addownload.pause.IPauseInterceptor
    public boolean interceptor(NativeDownloadModel r100, int r101, IPauseCallback r110, boolean r111, Context r112, DownloadInfo r113) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return ReverseWifiHelper.tryReverseWifi(r100, r113, r101, r110, false, r111, r112);
    }
}
