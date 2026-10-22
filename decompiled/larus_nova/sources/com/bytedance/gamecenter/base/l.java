package com.bytedance.gamecenter.base;

import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.download.api.config.IHttpCallback;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f245002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map f245003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IHttpCallback f245004c;

    @Override // java.lang.Runnable
    public final void run() {
        DownloadNetworkFactory r100 = GlobalInfo.getDownloadNetworkFactory();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.execute("POST", this.f245002a, this.f245003b, this.f245004c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public l(String r100, Map r101, IHttpCallback r102) {
        this.f245002a = r100;
        this.f245003b = r101;
        this.f245004c = r102;
    }
}
