package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes38.dex */
public class GlobalListenerAdaptor {
    private static final String TAG = "GlobalListenerAdaptor";
    protected static volatile boolean sEnabled;
    private static AtomicBoolean sRunSetter;

    public GlobalListenerAdaptor() {
    }

    static {
        sRunSetter = new AtomicBoolean(false);
        sEnabled = false;
    }

    public static IDownloadInterceptor addListener(IDownloadInterceptor r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "DownloadInterceptor sEnabled:" + sEnabled);
    L6:
        if (isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return DownloadInterceptorAdaptor.getInstance().addListener(r100);
    }

    public static boolean isEnabled(Object r100) {
        sRunSetter.compareAndSet(false, true);
        if (sEnabled == false) goto L7;
        if (r100 == null) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public static void setEnabled(boolean r100) {
        if (sRunSetter.compareAndSet(false, true) == false) goto L10;
        if (Logger.debug() == false) goto L7;
        Logger.globalDebug(TAG, "setEnabled", "First Run:" + r100);
    L7:
        sEnabled = r100;
        return;
    L10:
        if (Logger.debug() == false) goto L13;
        Logger.globalDebug(TAG, "setEnabled", "Run:" + r100);
        return;
    }

    public static INotificationClickCallback addListener(INotificationClickCallback r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "NotificationClickCallback sEnabled:" + sEnabled);
    L6:
        if (isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return NotificationClickCallbackAdaptor.getInstance().addListener(r100);
    }

    public static IOpenInstallerListener addListener(IOpenInstallerListener r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "OpenInstallerListener sEnabled:" + sEnabled);
    L6:
        if (isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return OpenInstallerListenerAdaptor.getInstance().addListener(r100);
    }

    public static IReserveWifiStatusListener addListener(IReserveWifiStatusListener r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "ReserveWifiStatusListener sEnabled:" + sEnabled);
    L6:
        if (isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return ReserveWifiStatusListenerAdaptor.getInstance().addListener(r100);
    }

    public static InnerEventListener addListener(InnerEventListener r100) {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "addListener", "InnerEventListener sEnabled:" + sEnabled);
    L6:
        if (isEnabled(r100) == true) goto L9;
        return r100;
    L9:
        return InnerEventListenerAdaptor.getInstance().addEventListener(r100);
    }
}
