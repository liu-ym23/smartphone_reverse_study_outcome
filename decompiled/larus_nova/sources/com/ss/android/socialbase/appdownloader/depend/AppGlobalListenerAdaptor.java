package com.ss.android.socialbase.appdownloader.depend;

import com.ss.android.socialbase.appdownloader.AhUtils;
import com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler;
import com.ss.android.socialbase.downloader.depend.GlobalListenerAdaptor;
import com.ss.android.socialbase.downloader.logger.Logger;

/* JADX INFO: loaded from: classes38.dex */
public class AppGlobalListenerAdaptor extends GlobalListenerAdaptor {
    private static final String TAG = "AppGlobalListenerAdaptor";

    public AppGlobalListenerAdaptor() {
    }

    public static AhUtils.OnAhAttemptListener addListener(AhUtils.OnAhAttemptListener r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "AhUtils_OnAhAttemptListener sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return OnAhAttemptListenerAdaptor.getInstance().addListener(r100);
    }

    public static IAppDownloadDepend addListener(IAppDownloadDepend r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "AppDownloadDepend sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return AppDownloadDependAdaptor.getInstance().addListener(r100);
    }

    public static IAppDownloadEventHandler addListener(IAppDownloadEventHandler r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "AppDownloadEventHandler sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return AppDownloadEventHandlerAdaptor.getInstance().addListener(r100);
    }

    public static IAppDownloadInterceptor addListener(IAppDownloadInterceptor r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "AppDownloadInterceptor sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return AppDownloadInterceptorAdaptor.getInstance().addListener(r100);
    }

    public static IAppDownloadLaunchResumeListener addListener(IAppDownloadLaunchResumeListener r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "AppDownloadLaunchResumeListener sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return AppDownloadLaunchResumeListenerAdaptor.getInstance().addListener(r100);
    }

    public static IAppDownloadMonitorListener addListener(IAppDownloadMonitorListener r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "AppDownloadMonitorListener sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return AppDownloadMonitorListenerAdaptor.getInstance().addListener(r100);
    }

    public static IBeforeAppInstallInterceptor addListener(IBeforeAppInstallInterceptor r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "BeforeAppInstallInterceptor sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return BeforeAppInstallInterceptorAdaptor.getInstance().addListener(r100);
    }

    public static IMockNotificationProgressHandler addListener(IMockNotificationProgressHandler r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "MockNotificationProgressHandler sEnabled:" + GlobalListenerAdaptor.sEnabled);
    L6:
        if (GlobalListenerAdaptor.isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return MockNotificationProgressHandlerAdaptor.getInstance().addListener(r100);
    }
}
