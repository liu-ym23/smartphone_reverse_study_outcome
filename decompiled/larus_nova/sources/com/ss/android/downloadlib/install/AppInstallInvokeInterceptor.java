package com.ss.android.downloadlib.install;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.applink.AppInstallOptimiseHelper;
import com.ss.android.downloadlib.applink.AppLinkOptimiseHelper;
import com.ss.android.downloadlib.applink.KllkOptimiseHelper;
import com.ss.android.downloadlib.guide.install.IAppInstallCallback;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallInterceptCallback;
import com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes34.dex */
public class AppInstallInvokeInterceptor implements IBeforeAppInstallInterceptor {
    public AppInstallInvokeInterceptor() {
    }

    private void installApp(DownloadInfo r100, final IAppInstallCallback r101) {
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeModelByInfo(r100);
        boolean r103 = AppLinkOptimiseHelper.switchIsOpen(r102);
        boolean r104 = AppLinkOptimiseHelper.installSwitchIsOpen(r102);
        if (r103 == false) goto L8;
        if (r104 == false) goto L8;
        AppInstallOptimiseHelper.invoke(r102, new AnonymousClass3(this, r101));
        return;
    L8:
        r101.onInstallApp();
    }

    public void intercept(final DownloadInfo r100, final IAppInstallCallback r101) {
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeModelByInfo(r100);
        if (r102 != null) goto L5;
    L7:
        installApp(r100, r101);
        return;
    L5:
        if (KllkOptimiseHelper.canInvokeAppFormOppoBackground(r102) == false) goto L7;
        TTDelegateActivity.installApk(r102, new AnonymousClass2(this, r100, r101));
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor
    public void intercept(DownloadInfo r100, final IAppInstallInterceptCallback r101) {
        intercept(r100, new AnonymousClass1(this, r101));
    }

    public static /* synthetic */ void access$000(AppInstallInvokeInterceptor r100, DownloadInfo r101, IAppInstallCallback r102) {
        r100.installApp(r101, r102);
    }
}
