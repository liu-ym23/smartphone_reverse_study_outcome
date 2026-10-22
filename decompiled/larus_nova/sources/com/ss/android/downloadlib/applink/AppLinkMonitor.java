package com.ss.android.downloadlib.applink;

import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.downloadlib.DownloadComponentManager;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.common.AppStatusManager;

/* JADX INFO: loaded from: classes34.dex */
public class AppLinkMonitor implements AppStatusManager.AppStatusChangeListener {
    public static final long DELAY_TIME = 5000;
    private long lastForegroundStamp;

    public static class SingleTonHolder {
        private static AppLinkMonitor INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new AppLinkMonitor(null);
        }

        public static /* synthetic */ AppLinkMonitor access$100() {
            return INSTANCE;
        }
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    private AppLinkMonitor() {
        this.lastForegroundStamp = 0;
        AppStatusManager.getInstance().registerAppSwitchListener(this);
    }

    public static AppLinkMonitor getInstance() {
        return SingleTonHolder.access$100();
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        this.lastForegroundStamp = System.currentTimeMillis();
    }

    public /* synthetic */ AppLinkMonitor(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ long access$200(AppLinkMonitor r100) {
        return r100.lastForegroundStamp;
    }

    public void checkAppLinkResult(AppLinkEventCallback r100) {
        checkAppLinkResult(r100, 5000);
    }

    public void checkMarketOrInstaller(AppLinkEventCallback r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return;
    L5:
        int r102 = 1200;
        if (r101 == null) goto L8;
        int r103 = r101.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.CHECK_AN_RESULT_DELAY, 1200);
    L9:
        if (r103 <= 0) goto L11;
        r102 = r103;
    L11:
        checkAppLinkResult(r100, r102);
        return;
    L8:
        r103 = 1200;
        goto L9
    }

    public void checkAppLinkResult(final AppLinkEventCallback r100, final long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        DownloadComponentManager.getInstance().submitScheduledTask(new AnonymousClass1(this, r100, r101), r101);
    }
}
