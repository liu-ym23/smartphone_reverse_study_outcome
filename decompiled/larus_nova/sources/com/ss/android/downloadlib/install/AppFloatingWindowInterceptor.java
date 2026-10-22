package com.ss.android.downloadlib.install;

import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallInterceptCallback;
import com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes34.dex */
public class AppFloatingWindowInterceptor implements IBeforeAppInstallInterceptor {
    private static IAppInstallInterceptCallback iAppInstallInterceptCallback;
    private static IDownloadInstallFeatureCallback iDownloadInstallFeatureCallback;
    public static final AtomicBoolean jumpSettingPageSign = null;
    private DownloadShortInfo mDownloadShortInfo;

    public AppFloatingWindowInterceptor() {
    }

    static {
        jumpSettingPageSign = new AtomicBoolean(false);
    }

    public DownloadShortInfo getDownloadShortInfo() {
        DownloadShortInfo r100 = this.mDownloadShortInfo;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new DownloadShortInfo();
    }

    public static IAppInstallInterceptCallback getAppInstallInterceptCallback() {
        return iAppInstallInterceptCallback;
    }

    public static IDownloadInstallFeatureCallback getDownloadInstallFeatureCallback() {
        return iDownloadInstallFeatureCallback;
    }

    public static /* synthetic */ void access$000(IAppInstallInterceptCallback r100) {
        setAppInstallInterceptCallback(r100);
    }

    private static void setAppInstallInterceptCallback(IAppInstallInterceptCallback r100) {
        iAppInstallInterceptCallback = r100;
    }

    public static void setDownloadInstallFeatureCallback(IDownloadInstallFeatureCallback r100) {
        iDownloadInstallFeatureCallback = r100;
    }

    @Override // com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor
    public void intercept(DownloadInfo r100, final IAppInstallInterceptCallback r101) {
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeModelByInfo(r100);
        if (r102 != null) goto L5;
    L9:
        r101.onInterceptFinish();
        return;
    L5:
        if (r102.isFromGameUnionLive() == false) goto L9;
        if (getDownloadInstallFeatureCallback() == null) goto L9;
        DownloadShortInfo r103 = getDownloadShortInfo();
        r103.updateFromNewDownloadInfo(r100);
        r103.updateFromNativeDownloadModel(r102);
        getDownloadInstallFeatureCallback().onBeforeIntercept(r103, new AnonymousClass1(this, r101));
    }
}
