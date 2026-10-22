package com.ss.android.downloadlib.exception;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.download.api.inner.ITTDownloaderMonitor;
import com.ss.android.download.api.runtime.IAdHostUIProvider;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.download.api.runtime.IAdUserInfoProvider;
import com.ss.android.downloadlib.DownloadDispatcher;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.appdownloader.util.SecurityUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class TTDownloaderMonitor implements ITTDownloaderMonitor {
    private static final String SERVICE_NAME = "service_ttdownloader";
    private static final String TAG = null;

    public static class SingleTonHolder {
        private static TTDownloaderMonitor INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new TTDownloaderMonitor();
        }

        public static /* synthetic */ TTDownloaderMonitor access$000() {
            return INSTANCE;
        }
    }

    public interface Status {
        public static final int DATA_ERROR = 2;
        public static final int EXCEPTION = 1;
        public static final int PATH_ERROR = 3;
    }

    public TTDownloaderMonitor() {
    }

    static {
        TAG = "TTDownloaderMonitor";
    }

    private boolean disableMonitor() {
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
        return true;
    L5:
        if (r100.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.ENABLE_MONITOR, 1) != 1) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean enableMonitorToast() {
        IAdSDKSettingsProvider r100 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.ENABLE_MONITOR_TOAST, 1) != 1) goto L7;
        return true;
    }

    public static TTDownloaderMonitor inst() {
        return SingleTonHolder.access$000();
    }

    private void debugCrash(Throwable r100) {
        if (SecurityUtils.isDebug(GlobalInfo.getContext()) == true) goto L6;
        return;
    L6:
        throw new MonitorException(r100);
    }

    private void localTestToast(final String r100) {
        final IAdHostUIProvider r101 = (IAdHostUIProvider) DownloadAdRuntimeProvider.getInnerService(IAdHostUIProvider.class);
        IAdUserInfoProvider r102 = (IAdUserInfoProvider) DownloadAdRuntimeProvider.getInnerService(IAdUserInfoProvider.class);
        if (r102 != null) goto L5;
    L7:
        String r103 = "";
    L9:
        if (enableMonitorToast() == true) goto L11;
        return;
    L11:
        if ("local_test".equals(r103) == false) goto L15;
        DownloadDispatcher.getInstance().getMainHandler().post(new AnonymousClass1(this, r101, r100));
        return;
    L15:
        return;
    L5:
        if (r102.getAppUserInfo() == null) goto L7;
        r103 = r102.getAppUserInfo().getChannel();
        goto L9
    }

    public static String printStackTrace(Throwable r100) {
        return Log.getStackTraceString(r100);
    L4:
        return null;
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorDataError(String r100) {
        monitorDataError(true, true, r100);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorPathError(String r100) {
        monitorPathError(true, true, r100);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorDataError(boolean r100, String r101) {
        monitorDataError(r100, true, r101);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorException(Throwable r100, String r101) {
        monitorException(true, true, r100, r101);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorPathError(boolean r100, String r101) {
        monitorPathError(r100, true, r101);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorDataError(boolean r100, boolean r101, String r102) {
        if (disableMonitor() == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        debugCrash(new RuntimeException(r102));
    L7:
        if (r101 == false) goto L9;
        localTestToast(r102);
    L9:
        JSONObject r103 = new JSONObject();
        ToolUtils.safePut(r103, "msg", r102);
        ToolUtils.safePut(r103, "stack", printStackTrace(new Throwable()));
        TTDownloaderLogger.INSTANCE.innerAlogE(TAG, "monitorDataError", "检测到数据异常:" + r103);
        GlobalInfo.getDownloaderMonitor().monitorStatusRate(SERVICE_NAME, 2, r103);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorException(boolean r100, Throwable r101, String r102) {
        monitorException(r100, true, r101, r102);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorPathError(boolean r100, boolean r101, String r102) {
        if (disableMonitor() == false) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
        debugCrash(new RuntimeException(r102));
    L7:
        if (r101 == false) goto L9;
        localTestToast(r102);
    L9:
        JSONObject r103 = new JSONObject();
        ToolUtils.safePut(r103, "msg", r102);
        ToolUtils.safePut(r103, "stack", printStackTrace(new Throwable()));
        TTDownloaderLogger.INSTANCE.innerAlogE(TAG, "monitorPathError", "检测到路径异常:" + r103);
        GlobalInfo.getDownloaderMonitor().monitorStatusRate(SERVICE_NAME, 3, r103);
    }

    @Override // com.ss.android.download.api.inner.ITTDownloaderMonitor
    public void monitorException(boolean r100, boolean r101, Throwable r102, String r103) {
        if (disableMonitor() == false) goto L5;
        return;
    L5:
        if (r102 != null) goto L7;
        r102 = new Throwable();
    L7:
        if (r100 == false) goto L9;
        debugCrash(r102);
    L9:
        if (r101 == false) goto L11;
        localTestToast(r103);
    L11:
        JSONObject r104 = new JSONObject();
        if (TextUtils.isEmpty(r103) == false) goto L15;
        r103 = r102.getMessage();
    L15:
        ToolUtils.safePut(r104, "msg", r103);
        ToolUtils.safePut(r104, "stack", Log.getStackTraceString(r102));
        TTDownloaderLogger.INSTANCE.innerAlogE(TAG, "monitorException", "检测到异常:" + r104);
        GlobalInfo.getDownloaderMonitor().monitorStatusRate(SERVICE_NAME, 1, r104);
    }
}
