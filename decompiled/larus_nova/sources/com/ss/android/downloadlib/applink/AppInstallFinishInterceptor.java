package com.ss.android.downloadlib.applink;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.DownloadComponentManager;

/* JADX INFO: loaded from: classes34.dex */
public class AppInstallFinishInterceptor {
    public AppInstallFinishInterceptor() {
    }

    public void invokeApp(final NativeDownloadModel r100, final IAppDeepLinkCallback r101, int r102) {
        DownloadComponentManager.getInstance().submitScheduledTask(new AnonymousClass1(this, r100, r101), r102);
    }
}
