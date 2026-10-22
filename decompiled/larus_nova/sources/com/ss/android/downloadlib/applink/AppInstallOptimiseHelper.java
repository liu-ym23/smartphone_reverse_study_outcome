package com.ss.android.downloadlib.applink;

import android.os.Build;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.guide.install.IAppInstallCallback;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* JADX INFO: loaded from: classes34.dex */
public class AppInstallOptimiseHelper {
    private static final String TAG = "AppInstallOptimiseHelper";

    public AppInstallOptimiseHelper() {
    }

    public static void invoke(final NativeDownloadModel r100, final IAppInstallCallback r101) {
        boolean r102 = AppStatusManager.getInstance().isAppForeground();
        if (r102 == false) goto L5;
    L7:
        boolean r103 = AppStatusManager.getInstance().isAppForeground();
        if (r102 == true) goto L12;
        if (r103 == false) goto L12;
        if (r100 == null) goto L12;
        r100.setDeeplinkAfterBackApp(true);
    L12:
        r101.onInstallApp();
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, AbsMethodDelegate.TAG_INVOKE, "AppInstallOptimiseHelper-->isAppForegroundSecond:::" + r103);
        if (r103 == true) goto L16;
        AppStatusManager.getInstance().registerAppSwitchListener(new AnonymousClass1(r100, r101));
        return;
    L16:
        return;
    L5:
        if (Build.VERSION.SDK_INT < 29) goto L7;
        ToolUtils.tryMoveAppToFront();
        goto L7
    }
}
