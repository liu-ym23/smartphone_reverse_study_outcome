package com.ss.android.downloadlib.utils;

import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.ss.android.download.api.config.IDownloadSlardarMonitor;
import com.ss.android.download.api.config.IDownloaderMonitor;
import com.ss.android.download.api.model.AppInfo;
import com.ss.android.download.api.runtime.IAdUserInfoProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.BuildConfig;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class TTSlardarMonitor implements IDownloadSlardarMonitor, IDownloaderMonitor {
    private static final String TAG = null;
    private static final String TTDOWNLOADERID = "6103";
    private static volatile TTSlardarMonitor instance;
    private static volatile boolean ttInitialized;

    static {
        TAG = "TTSlardarMonitor";
        instance = null;
        ttInitialized = false;
    }

    private JSONObject generateSlardarHeader() {
        JSONObject r100 = new JSONObject();
        String r101 = GlobalInfo.getContext().getPackageName();
        IAdUserInfoProvider r102 = (IAdUserInfoProvider) DownloadAdRuntimeProvider.getInnerService(IAdUserInfoProvider.class);
        if (r102 == null) goto L7;
        AppInfo r103 = r102.getAppUserInfo();
        if (r103 == null) goto L7;
        String r104 = r103.getDeviceId();
        String r105 = r103.getAppId();
        String r106 = r103.getAppVersion();
        String r107 = r103.getVersionCode();
        String r108 = r103.getChannel();
    L13:
        r100.putOpt("device_id", r104);     // Catch: JSONException -> L10
        r100.putOpt("host_aid", r105);     // Catch: JSONException -> L10
        r100.putOpt("sdk_version", BuildConfig.SDK_VERSION_NAME);     // Catch: JSONException -> L10
        r100.putOpt("app_version", r106);     // Catch: JSONException -> L10
        r100.putOpt("update_version_code", r107);     // Catch: JSONException -> L10
        r100.putOpt("package_name", r101);     // Catch: JSONException -> L10
        r100.putOpt("channel", r108);     // Catch: JSONException -> L10
    L12:
        return r100;
    L10:
        e = move-exception;
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "generateSlardarHeader", e.getMessage());
    L7:
        r104 = "0";
        r108 = "0";
        r105 = r108;
        r106 = r105;
        r107 = r106;
        goto L13
    }

    public static TTSlardarMonitor getInstance() {
        if (instance != null) goto L15;
        monitor-enter(TTSlardarMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new TTSlardarMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTSlardarMonitor.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public void checkInit() {
        if (ttInitialized == false) goto L5;
        return;
    L5:
        monitor-enter(TTSlardarMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (ttInitialized == true) goto L9;
        init();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTSlardarMonitor.class);     // Catch: Throwable -> L11
    }

    private SDKMonitor init() {
        if (GlobalInfo.getContext() != null) goto L5;
        TTDownloaderMonitor.inst().monitorDataError(false, "no context found for init slardar");
    L5:
        IAdUserInfoProvider r100 = (IAdUserInfoProvider) DownloadAdRuntimeProvider.getInnerService(IAdUserInfoProvider.class);
        if (r100 != null) goto L8;
    L11:
        TTDownloaderMonitor.inst().monitorDataError(false, "no host appId or invalid appId");
    L12:
        SDKMonitorUtils.setConfigUrl(TTDOWNLOADERID, AdBaseConstants.SlardarMonitorUrls.SLARDAR_DEFAULT_CONFIG_URLS);
        SDKMonitorUtils.setDefaultReportUrl(TTDOWNLOADERID, AdBaseConstants.SlardarMonitorUrls.SLARDAR_DEFAULT_REPORT_URLS);
        SDKMonitorUtils.initMonitor(GlobalInfo.getContext(), TTDOWNLOADERID, generateSlardarHeader(), new AnonymousClass1(this));
        ttInitialized = true;
        return SDKMonitorUtils.getInstance(TTDOWNLOADERID);
    L8:
        if (r100.getAppUserInfo() == null) goto L11;
        if (TextUtils.isEmpty(r100.getAppUserInfo().getAppId()) == false) goto L12;
        goto L11
    }

    private TTSlardarMonitor() {
    }

    @Override // com.ss.android.download.api.config.IDownloaderMonitor
    public void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        SDKMonitorUtils.getInstance(TTDOWNLOADERID).monitorDuration(r100, r101, r102);
    }

    @Override // com.ss.android.download.api.config.IDownloaderMonitor
    public void monitorStatusRate(String r100, int r101, JSONObject r102) {
        SDKMonitorUtils.getInstance(TTDOWNLOADERID).monitorStatusRate(r100, r101, r102);
    }

    public void monitorDuration(String r100, JSONObject r101, JSONObject r102, boolean r103) {
        if (r103 == false) goto L4;
        checkInit();
    L4:
        monitorDuration(r100, r101, r102);
    }

    @Override // com.ss.android.download.api.config.IDownloaderMonitor
    public void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103) {
        SDKMonitorUtils.getInstance(TTDOWNLOADERID).monitorStatusAndDuration(r100, r101, r102, r103);
    }

    public void monitorStatusRate(String r100, int r101, JSONObject r102, boolean r103) {
        if (r103 == true) goto L9;
    L4:
        monitorStatusRate(r100, r101, r102);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        checkInit();     // Catch: Exception -> L6
        goto L4
    }

    public void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103, boolean r104) {
        if (r104 == true) goto L9;
    L4:
        monitorStatusAndDuration(r100, r101, r102, r103);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        checkInit();     // Catch: Exception -> L6
        goto L4
    }

    @Override // com.ss.android.download.api.config.IDownloadSlardarMonitor
    public void ttMonitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103, boolean r104) {
        if (r104 == true) goto L9;
    L4:
        SDKMonitorUtils.getInstance(TTDOWNLOADERID).monitorEvent(r100, r101, r102, r103);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        checkInit();     // Catch: Exception -> L6
        goto L4
    }
}
