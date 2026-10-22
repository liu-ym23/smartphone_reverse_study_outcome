package com.ss.android.downloadlib.install;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallInterceptCallback;
import com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes34.dex */
public class AppInstallParamsInterceptor implements IBeforeAppInstallInterceptor {
    public AppInstallParamsInterceptor() {
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor
    public void intercept(DownloadInfo r100, IAppInstallInterceptCallback r101) {
        if (r100 == null) goto L6;
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeModelByInfo(r100);
        if (r102 == null) goto L6;
        r100.setLinkMode(r102.getLinkMode());
    L6:
        if (r101 == null) goto L9;
        r101.onInterceptFinish();
        return;
    }
}
