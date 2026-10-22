package com.bytedance.gamecenter.base;

import com.ss.android.download.api.config.DownloadNetworkFactory;
import com.ss.android.download.api.config.IHttpCallback;
import com.ss.android.downloadlib.addownload.GlobalInfo;

/* JADX INFO: loaded from: classes19.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f245005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IHttpCallback f245006b;

    @Override // java.lang.Runnable
    public final void run() {
        DownloadNetworkFactory r100 = GlobalInfo.getDownloadNetworkFactory();     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.execute("GET", this.f245005a, null, this.f245006b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public m(String r100, IHttpCallback r101) {
        this.f245005a = r100;
        this.f245006b = r101;
    }
}
