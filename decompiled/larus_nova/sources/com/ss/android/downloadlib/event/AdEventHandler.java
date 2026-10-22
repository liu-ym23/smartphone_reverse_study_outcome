package com.ss.android.downloadlib.event;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DownloadEventModel;
import com.ss.android.download.api.runtime.IAdEventProvider;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.AdDownloadCompletedEventHandlerImpl;
import com.ss.android.downloadlib.DownloadAdRuntimeInitializer;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.DownloadInsideHelper;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.addownload.model.SharedPrefsManager;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.downloader.NotificationPermissionHelperKt;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.EventAppendUtils;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AdEventHandler {
    private static final String TAG = null;

    /* JADX INFO: renamed from: com.ss.android.downloadlib.event.AdEventHandler$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public @interface EventType {
        public static final int CLICK_CONTINUE = 4;
        public static final int CLICK_INSTALL = 5;
        public static final int CLICK_PAUSE = 3;
        public static final int CLICK_START = 2;
        public static final int STORAGE_DENY = 1;
    }

    public static class SingleTonHolder {
        private static AdEventHandler INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new AdEventHandler(null);
        }

        public static /* synthetic */ AdEventHandler access$100() {
            return INSTANCE;
        }
    }

    static {
        TAG = "AdEventHandler";
    }

    public static AdEventHandler getInstance() {
        return SingleTonHolder.access$100();
    }

    private AdEventHandler() {
    }

    public /* synthetic */ AdEventHandler(AnonymousClass1 r100) {
        this();
    }

    public void sendDownloadResumeEvent(DownloadInfo r100) {
        NativeDownloadModel r101 = ModelManager.getInstance().getNativeModelByInfo(r100);
        if (r101 != null) goto L10;
        return;
    L10:
        JSONObject r102 = new JSONObject();     // Catch: Throwable -> L7
        EventAppendUtils.appendInfoJson(r100, r102);     // Catch: Throwable -> L7
        r101.setRecentDownloadResumeTime(System.currentTimeMillis());     // Catch: Throwable -> L7
        sendEvent(r101.getEventTag(), EventConstants.Label.DOWNLOAD_RESUME, r102, r101);     // Catch: Throwable -> L7
        SharedPrefsManager.getInstance().saveNativeDownloadModel(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
    }

    private void onEvent(DownloadEventModel r100, int r101) {
        IAdEventProvider r102 = (IAdEventProvider) DownloadAdRuntimeProvider.getInnerService(IAdEventProvider.class);
        if (r102 != null) goto L6;
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "onEvent", "未获取到发送埋点能力的实例");
        return;
    L6:
        if (r101 <= 0) goto L11;
        if (GlobalInfo.getDownloadEventInterceptFactory() == null) goto L11;
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "onEvent", "对原有发埋点操作进行拦截,交给业务方进行个性化处理,但是不影响原有埋点的发送");
        GlobalInfo.getDownloadEventInterceptFactory().interceptDownloadEvent(r100, r101, null);
    L11:
        if (r100.isV3() == false) goto L13;
        r102.onAdV3Event(r100);
        return;
    L13:
        r102.onAdEvent(r100);
    }

    public void sendAppLinkFailedUserEvent(int r100, String r101) {
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L4
        r102.putOpt(EventConstants.ExtraJson.EXTRA_INNER_APPLINK_FAILED_REASON, Integer.valueOf(r100));     // Catch: Exception -> L4
        r102.putOpt(EventConstants.ExtraJson.EXTRA_INNER_APPLINK_FAILED_MESSAGE, r101);     // Catch: Exception -> L4
        sendUserEvent(EventConstants.UserEventLabel.BDAL_INNER_APPLINK_FAILED, r102, null);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(e, "sendApplinkFailedUserEvent");
    }

    public void sendCleanEvent(String r100, long r101) {
        sendCleanEvent(r100, r101, null);
    }

    public void sendClickEvent(long r100, int r110) {
        NativeDownloadModel r101 = ModelManager.getInstance().getNativeDownloadModel(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getEvent().isEnableClickEvent() == false) goto L35;
        int r102 = 1;
        AdDownloadEventConfig r103 = r101.getEvent();
        if (r110 != 1) goto L10;
        String r104 = r103.getClickItemTag();
    L11:
        String r105 = ToolUtils.getNotEmptyStr(new String[]{r101.getEvent().getClickLabel(), "click"});
        JSONObject r106 = new JSONObject();
        r106.putOpt("download_click_type", Integer.valueOf(r110));     // Catch: JSONException -> L22
        if (NotificationPermissionHelperKt.isNotificationEnabled() == false) goto L15;
        int r107 = 1;
    L16:
        r106.putOpt("permission_notification", Integer.valueOf(r107));     // Catch: JSONException -> L22
        if (DownloadUtils.isNetworkConnected(GlobalInfo.getContext()) == true) goto L20;
        r102 = 2;
    L20:
        r106.putOpt("network_available", Integer.valueOf(r102));     // Catch: JSONException -> L22
    L24:
        sendEvent(r104, r105, r106, r101);
        SlardarEventHandler.getInstance().sendSlardarClickEvent(r106, r101);
        if ("click".equals(r105) == true) goto L27;
        return;
    L27:
        if (r101.getModel() == null) goto L34;
        ClickEventHelper.getInstance().recordClick(r100, r101.getModel().getLogExtra());
        return;
    L34:
        return;
    L15:
        r107 = 2;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    L10:
        r104 = r103.getClickButtonTag();
        goto L11
    }

    public void sendContentProviderClickIdClearEvent(JSONObject r100, NativeDownloadModel r101) {
        sendUserEvent(EventConstants.UserEventLabel.BDAL_CLICK_ID_CONTENT_PROVIDER_CLEAR_RESULT, r100, r101);
    }

    public void sendContentProviderClickIdEvent(JSONObject r100, NativeDownloadModel r101) {
        sendUserEvent(EventConstants.UserEventLabel.BDAL_CLICK_ID_CONTENT_PROVIDER_OPT_RESULT, r100, r101);
    }

    public void sendDownloadCancelEvent(JSONObject r100, NativeDownloadModel r101) {
        sendEvent(r101.getEventTag(), "download_cancel", r100, r101);
        DownloadInfo r102 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r101.getDownloadId());
        SlardarEventHandler.getInstance().sendSlardarDownloadCancelEvent(r100, r101, r102);
    }

    public void sendDownloadExceptionEvent(long r100, BaseException r101) {
        sendDownloadExceptionEvent(r100, r101, null);
    }

    public void sendDownloadFailedEvent(DownloadInfo r100, BaseException r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        NativeDownloadModel r101 = ModelManager.getInstance().getNativeModelByInfo(r100);
        if (r101 != null) goto L9;
        TTDownloaderMonitor.inst().monitorDataError("sendDownloadFailedEvent nativeModel null");
        return;
    L9:
        if (r101.hasSendInstallFinish.get() == false) goto L11;
        return;
    L11:
        JSONObject r102 = new JSONObject();
        EventAppendUtils.appendInfoJson(r100, r102);     // Catch: JSONException -> L27
        AdDownloadCompletedEventHandlerImpl.monitorDownloadInfo(r102, r100);     // Catch: JSONException -> L27
        if (r110 == null) goto L15;
        r102.putOpt("fail_status", Integer.valueOf(r110.getErrorCode()));     // Catch: JSONException -> L27
        r102.putOpt("fail_msg", r110.getErrorMessage());     // Catch: JSONException -> L27
        r101.setLastFailedErrCode(r110.getErrorCode());     // Catch: JSONException -> L27
        r101.setLastFailedErrMsg(r110.getErrorMessage());     // Catch: JSONException -> L27
    L15:
        r101.increaseDownloadFailedTimes();     // Catch: JSONException -> L27
        r102.put("download_failed_times", r101.getDownloadFailedTimes());     // Catch: JSONException -> L27
        if (r100.getTotalBytes() <= 0) goto L18;
        r102.put("download_percent", r100.getCurBytes() / r100.getTotalBytes());     // Catch: JSONException -> L27
    L18:
        int r103 = 2;
        if (r101.hasSendDownloadFailedFinally.get() == false) goto L21;
        int r104 = 1;
    L22:
        r102.put("has_send_download_failed_finally", r104);     // Catch: JSONException -> L27
        EventAppendUtils.appendPatchApplyArgJson(r101, r102);     // Catch: JSONException -> L27
        if (r101.isUpdateDownload() == false) goto L25;
        r103 = 1;
    L25:
        r102.put("is_update_download", r103);     // Catch: JSONException -> L27
        r101.setDownloadFailedSendCount(r101.getDownloadFailedSendCount() + 1);     // Catch: JSONException -> L27
        r102.putOpt("download_failed_send_count", Integer.valueOf(r101.getDownloadFailedSendCount()));     // Catch: JSONException -> L27
    L30:
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r101) == false) goto L33;
        EventAppendUtils.appendDownloadTaskManagerInfo(r102);
    L33:
        if (r101.isFromGameUnionLive() == true) goto L35;
    L42:
        sendEvent(r101.getEventTag(), "download_failed", r102, r101);
    L43:
        SlardarEventHandler.getInstance().sendSlardarDownloadFailedEvent(r102, r101, r100);
        SharedPrefsManager.getInstance().saveNativeDownloadModel(r101);
        return;
    L35:
        if (r101.hasRealStartDownload.get() == true) goto L42;
        if (r101.isEnableClickStartOptForGameUnion() == false) goto L42;
        if (r110 == null) goto L42;
        if (r110.getErrorCode() != 1013) goto L42;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "sendDownloadFailedEvent", "命中游戏联运的埋点优化逻辑,后续埋点操作由业务方处理");
        sendEvent(r101.getEventTag(), "download_failed", r102, r101, 1);
        goto L43
    L21:
        r104 = 2;
    L27:
        e = move-exception;
        e.printStackTrace();
        goto L30
    }

    public void sendDownloadFailedFinallyEvent(JSONObject r100, NativeDownloadModel r101) {
        sendEvent(r101.getEventTag(), "download_failed_finally", r100, r101);
        DownloadInfo r102 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r101.getDownloadId());
        SlardarEventHandler.getInstance().sendSlardarDownloadFailedFinallyEvent(r100, r101, r102);
    }

    public void sendEvent(String r100, long r101) {
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeDownloadModel(r101);
        if (r102 == null) goto L6;
        sendEvent(r100, r102);
        return;
    }

    public void sendInstallCorrectEvent(JSONObject r100, NativeDownloadModel r101) {
        sendEvent(r101.getEventTag(), EventConstants.Label.INSTALL_CORRECT, r100, r101);
    }

    public void sendInstallFinishEvent(JSONObject r100, NativeDownloadModel r101) {
        EventAppendUtils.appendRollbackPackageDownloadInfo(r100, r101);
        sendEvent(r101.getEventTag(), "install_finish", r100, r101);
        DownloadInfo r102 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r101.getDownloadId());
        SlardarEventHandler.getInstance().sendSlardarInstallFinishEvent(r100, r101, r102);
    }

    public void sendOpenWebEvent(String r100, long r101) {
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeDownloadModel(r101);
        if (r102 != null) goto L6;
        TTDownloaderMonitor.inst().monitorDataError("sendOpenWebEvent NativeDownloadModel notValid");
        return;
    L6:
        JSONObject r103 = new JSONObject();
        r103.putOpt("web_url", r102.getWebUrl());     // Catch: JSONException -> L9
        r103.putOpt("download_mode", Integer.valueOf(r102.getController().getDownloadMode()));     // Catch: JSONException -> L9
    L11:
        getInstance().sendUnityEvent(EventConstants.UnityLabel.OPEN_WEB, r103, r102);
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    public void sendUnityEvent(String r100, long r101) {
        sendUnityEvent(r100, null, r101);
    }

    public void sendDownloadFailedEvent(long r100, BaseException r101) {
        NativeDownloadModel r102 = ModelManager.getInstance().getNativeDownloadModel(r100);
        if (r102 != null) goto L5;
    L20:
        TTDownloaderMonitor.inst().monitorDataError("sendDownloadFailedEvent NativeDownloadModel notValid");
        return;
    L5:
        if (r102.notValid() == true) goto L20;
        JSONObject r103 = new JSONObject();
        r103.putOpt("download_time", 0);     // Catch: JSONException -> L13
        if (r101 == null) goto L11;
        r103.putOpt("fail_status", Integer.valueOf(r101.getErrorCode()));     // Catch: JSONException -> L13
        r103.putOpt("fail_msg", r101.getErrorMessage());     // Catch: JSONException -> L13
    L11:
        r102.setDownloadFailedSendCount(r102.getDownloadFailedSendCount() + 1);     // Catch: JSONException -> L13
        r103.putOpt("download_failed_send_count", Integer.valueOf(r102.getDownloadFailedSendCount()));     // Catch: JSONException -> L13
    L16:
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r102) == false) goto L18;
        EventAppendUtils.appendDownloadTaskManagerInfo(r103);
    L18:
        sendEvent("download_failed", r103, r102);
        DownloadInfo r104 = Downloader.getInstance(GlobalInfo.getContext()).getDownloadInfo(r102.getDownloadId());
        SlardarEventHandler.getInstance().sendSlardarDownloadFailedEvent(r103, r102, r104);
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    public void sendEvent(long r100, int r101) {
        sendEvent(r100, r101, null);
    }

    public void sendUnityEvent(String r100, NativeDownloadModel r101) {
        sendUnityEvent(r100, null, r101);
    }

    public void sendEvent(String r100, NativeDownloadModel r101) {
        sendEvent(null, r100, r101);
    }

    public void sendCleanEvent(String r100, long r101, JSONObject r102) {
        NativeDownloadModel r103 = ModelManager.getInstance().getNativeDownloadModel(r101);
        if (r101 <= 0) goto L5;
        if (r103 == null) goto L5;
    L11:
        if (r103 == null) goto L17;
        sendUnityEvent(r100, r102, r103);
        return;
    L17:
        return;
    L5:
        Iterator<NativeDownloadModel> r104 = ModelManager.getInstance().getAllNativeModels().values().iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        NativeDownloadModel r105 = r104.next();
        if (r105 == null) goto L7;
        r103 = r105;
        goto L11
    }

    public void sendDownloadCancelEvent(DownloadInfo r110, JSONObject r111, boolean r112) {
        if (r110 != null) goto L4;
        return;
    L4:
        NativeDownloadModel r100 = ModelManager.getInstance().getNativeModelByInfo(r110);
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.hasSendInstallFinish.get() == false) goto L10;
        return;
    L10:
        if (r111 != null) goto L47;
        r111 = new JSONObject();
    L47:
        AdDownloadCompletedEventHandlerImpl.monitorDownloadInfo(r111, r110);     // Catch: JSONException -> L43
        r111.putOpt("fail_status", Integer.valueOf(r100.getLastFailedErrCode()));     // Catch: JSONException -> L43
        r111.putOpt("fail_msg", r100.getLastFailedErrMsg());     // Catch: JSONException -> L43
        r111.put("download_failed_times", r100.getDownloadFailedTimes());     // Catch: JSONException -> L43
        if (r110.getTotalBytes() <= 0) goto L15;
        r111.put("download_percent", r110.getCurBytes() / r110.getTotalBytes());     // Catch: JSONException -> L43
    L15:
        r111.put("download_status", r110.getRealStatus());     // Catch: JSONException -> L43
        long r101 = System.currentTimeMillis();     // Catch: JSONException -> L43
        if (r100.getTimeStamp() <= 0) goto L19;
        r111.put("time_from_start_download", r101 - r100.getTimeStamp());     // Catch: JSONException -> L43
    L19:
        if (r100.getRecentDownloadResumeTime() <= 0) goto L21;
        r111.put("time_from_download_resume", r101 - r100.getRecentDownloadResumeTime());     // Catch: JSONException -> L43
    L21:
        int r102 = 1;
        if (r100.isUpdateDownload() == false) goto L24;
        int r103 = 1;
    L25:
        r111.put("is_update_download", r103);     // Catch: JSONException -> L43
        if (NotificationPermissionHelperKt.isNotificationEnabled() == false) goto L28;
        int r104 = 1;
    L29:
        r111.put("can_show_notification", r104);     // Catch: JSONException -> L43
        if (r100.hasSendDownloadFailedFinally.get() == false) goto L32;
        int r105 = 1;
    L33:
        r111.put("has_send_download_failed_finally", r105);     // Catch: JSONException -> L43
        if (r100.getDownloadFinishDate() != 0) goto L36;
        int r106 = 1;
    L37:
        r111.put(EventConstants.ExtraJson.EXTRA_WHETHER_CANCEL_IN_DOWNLOADING, r106);     // Catch: JSONException -> L43
        if (r112 == true) goto L41;
        r102 = 2;
    L41:
        r111.putOpt(EventConstants.ExtraJson.KEY_IS_CANCEL_FROM_DIALOG, Integer.valueOf(r102));     // Catch: JSONException -> L43
    L45:
        sendDownloadCancelEvent(r111, r100);
        return;
    L36:
        r106 = 2;
        goto L37
    L32:
        r105 = 2;
        goto L33
    L28:
        r104 = 2;
        goto L29
    L24:
        r103 = 2;
    L43:
        e = move-exception;
        e.printStackTrace();
        goto L45
    }

    public void sendDownloadExceptionEvent(long r100, BaseException r101, JSONObject r102) {
        if (r102 != null) goto L4;
        r102 = new JSONObject();
    L4:
        if (r101 != null) goto L11;
    L9:
        sendUnityEvent(EventConstants.UnityLabel.DOWNLOAD_SDK_ERROR, r102, r100);
        return;
    L11:
        r102.putOpt("error_code", Integer.valueOf(r101.getErrorCode()));     // Catch: JSONException -> L7
        r102.putOpt(EventConstants.ExtraJson.KEY_MESSAGE, r101.getErrorMessage());     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public void sendEvent(long r100, int r101, DownloadInfo r110) {
        sendEvent(r100, r101, r110, false);
    }

    public void sendQuickAppEvent(long r100, boolean r101, int r102) {
        NativeDownloadModel r103 = ModelManager.getInstance().getNativeDownloadModel(r100);
        if (r103 != null) goto L7;
        TTDownloaderMonitor.inst().monitorDataError("sendQuickAppEvent NativeDownloadModel notValid");
        return;
    L7:
        if (r103.getModel().getQuickAppModel() != null) goto L10;
        return;
    L10:
        if (r103.getModel() == null) goto L12;
        r103.getModel().setFunnelType(3);
    L12:
        JSONObject r104 = new JSONObject();
        r104.putOpt("download_click_type", Integer.valueOf(r102));     // Catch: JSONException -> L15
    L17:
        if (r101 == false) goto L19;
        String r105 = EventConstants.Label.DEEPLINK_QUICKAPP_SUCCESS;
    L20:
        sendEvent(r105, r104, r103);
        return;
    L19:
        r105 = EventConstants.Label.DEEPLINK_QUICKAPP_FAILED;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public void sendRecommendEvent(String r110, int r111, NativeDownloadModel r112) {
        onEvent(null, r110, null, r111, 0, r112, 0);
    }

    public void sendUnityEvent(String r100, JSONObject r101, long r102) {
        NativeDownloadModel r103 = ModelManager.getInstance().getNativeDownloadModel(r102);
        if (r103 == null) goto L6;
        sendUnityEvent(r100, r101, r103);
        return;
    }

    public void sendUserEvent(String r100, JSONObject r101, NativeDownloadModel r110) {
        if (r101 != null) goto L5;
        r101 = new JSONObject();
    L5:
        if (r110 != null) goto L8;
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "sendUserEvent", "sendUserEvent data is null");
    L11:
        IAdEventProvider r102 = (IAdEventProvider) DownloadAdRuntimeProvider.getInnerService(IAdEventProvider.class);
        if (r102 != null) goto L28;
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "sendUserEvent", "未获取到用户侧埋点发送能力的实例");
        return;
    L28:
        if (r110 == null) goto L22;
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L24
        EventAppendUtils.appendAppInfoForUserEvents(r103);     // Catch: Exception -> L24
        if (DownloadAdRuntimeInitializer.INSTANCE.getEnableRuntimeForUserEvent().get() == false) goto L20;
        int r104 = 1;
    L21:
        r103.putOpt(EventConstants.ExtraJson.EXTRA_ENABLE_NORMAL_RUNTIME_EVENT, Integer.valueOf(r104));     // Catch: Exception -> L24
        r102.sendUserEvent(r100, ToolUtils.mergeJson(new JSONObject[]{ToolUtils.getBaseJson(r110), ToolUtils.copyJson(r101, r103)}));     // Catch: Exception -> L24
    L27:
        return;
    L20:
        r104 = 2;
        goto L21
    L22:
        r101.putOpt(EventConstants.ExtraJson.EXTRA_NO_BASIC_INFO, 1);     // Catch: Exception -> L24
        r102.sendUserEvent(r100, r101);     // Catch: Exception -> L24
    L24:
        e = move-exception;
        TTDownloaderMonitor.inst().monitorException(false, false, e, "sendUserEvent error");
        return;
    L8:
        if (r110.notValid() == false) goto L11;
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "sendUserEvent", "sendUserEvent NativeDownloadModel notValid");
    }

    public void sendEvent(String r100, String r101, NativeDownloadModel r102) {
        sendEvent(r100, r101, null, r102);
    }

    public void sendUnityEvent(String r100, JSONObject r101, NativeDownloadModel r102) {
        sendUnityEvent(r100, r101, r102, 0);
    }

    public void sendEvent(String r100, JSONObject r101, NativeDownloadModel r102) {
        sendEvent(null, r100, r101, r102);
    }

    public void sendEvent(long r110, int r111, DownloadInfo r112, boolean r113) {
        NativeDownloadModel r100 = ModelManager.getInstance().getNativeDownloadModel(r110);
        if (r100 != null) goto L5;
    L54:
        TTDownloaderMonitor.inst().monitorDataError("sendEvent ModelBox notValid");
        return;
    L5:
        if (r100.notValid() == true) goto L54;
        JSONObject r101 = new JSONObject();
        NativeDownloadModel r114 = ModelManager.getInstance().getNativeModelByInfo(r112);
        EventAppendUtils.appendRollbackPackageDownloadInfo(r101, r114);
        if (r111 == 1) goto L47;
        if (r111 != 2) goto L11;
        String r115 = ToolUtils.getNotEmptyStr(new String[]{r100.getEvent().getClickStartLabel(), "click_start"});
        if (r114 == null) goto L40;
        EventAppendUtils.appendDownloadWebUrl(r114.getWebUrl(), r101);
    L40:
        EventAppendUtils.appendClickStartInfo(r112, r101, r113);
        if (r114 != null) goto L43;
    L45:
        SlardarEventHandler.getInstance().sendSlardarClickStartEvent(r101, r100, r112);
    L46:
        String r102 = r115;
    L49:
        if (r113 == false) goto L51;
        int r103 = 2;
    L52:
        onEvent(null, r102, r101, 0, 1, r100, r103);
        return;
    L51:
        r103 = 0;
        goto L52
    L43:
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r114) == false) goto L45;
        EventAppendUtils.appendDownloadTaskManagerInfo(r101);
        goto L45
    L11:
        if (r111 != 3) goto L13;
        r115 = ToolUtils.getNotEmptyStr(new String[]{r100.getEvent().getClickPauseLabel(), "click_pause"});
        if (r114 == null) goto L31;
        EventAppendUtils.appendDownloadWebUrl(r114.getWebUrl(), r101);
    L31:
        EventAppendUtils.appendClickPauseInfo(r112, r101);
        if (r114 != null) goto L34;
    L36:
        SlardarEventHandler.getInstance().sendSlardarClickPauseEvent(r101, r100, r112);
        goto L46
    L34:
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r114) == false) goto L36;
        EventAppendUtils.appendDownloadTaskManagerInfo(r101);
        goto L36
    L13:
        if (r111 != 4) goto L15;
        r115 = ToolUtils.getNotEmptyStr(new String[]{r100.getEvent().getClickContinueLabel(), "click_continue"});
        if (r114 == null) goto L22;
        EventAppendUtils.appendDownloadWebUrl(r114.getWebUrl(), r101);
        EventAppendUtils.appendClickContinueInfo(r112, r101, r114);
    L22:
        EventAppendUtils.appendInfoJson(r112, r101);
        if (r114 != null) goto L25;
    L27:
        SlardarEventHandler.getInstance().sendSlardarClickContinueEvent(r100, r112);
        goto L46
    L25:
        if (DownloadInsideHelper.checkTaskQueueOptOpen(r114) == false) goto L27;
        EventAppendUtils.appendDownloadTaskManagerInfo(r101);
        goto L27
    L15:
        if (r111 == 5) goto L18;
        String r116 = null;
    L17:
        r102 = r116;
        goto L49
    L18:
        EventAppendUtils.appendClickInstallInfo(r112, r101, r114);
        r116 = ToolUtils.getNotEmptyStr(new String[]{r100.getEvent().getClickInstallLabel(), "click_install"});
        SlardarEventHandler.getInstance().sendSlardarClickInstallEvent(r101, r100);
        goto L17
    L47:
        r116 = ToolUtils.getNotEmptyStr(new String[]{r100.getEvent().getStorageDenyLabel(), "storage_deny"});
        SlardarEventHandler.getInstance().sendSlardarStorageDenyEvent(r100);
        goto L17
    }

    public void sendUnityEvent(String r100, JSONObject r110, NativeDownloadModel r111, int r112) {
        JSONObject r101 = new JSONObject();
        ToolUtils.safePut(r101, EventConstants.ExtraJson.UNITY_LABEL, r100);
        sendEvent(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.UNITY, ToolUtils.copyJson(r110, r101), r111, r112);
    }

    public void sendEvent(String r100, String r101, JSONObject r102, NativeDownloadModel r110) {
        sendEvent(r100, r101, r102, r110, 0);
    }

    public void sendEvent(String r100, DownloadModel r101, DownloadEventConfig r102, DownloadController r103) {
        sendEvent(r100, new NativeDownloadModel(r101, r102, r103));
    }

    public void sendEvent(String r110, String r111, JSONObject r112, NativeDownloadModel r113, int r114) {
        onEvent(r110, r111, r112, 0, 0, r113, r114);
    }

    public void sendEvent(String r100, String r101, JSONObject r102, DownloadModel r103, DownloadEventConfig r104, DownloadController r105) {
        sendEvent(r100, r101, r102, new NativeDownloadModel(r103, r104, r105));
    }

    private void onEvent(String r110, String r111, JSONObject r112, long r113, int r114, NativeDownloadModel r115, int r116) {
        if (r115 != null) goto L7;
        TTDownloaderMonitor.inst().monitorDataError("onEvent data null");
        return;
    L7:
        if (r115.notValid() == false) goto L37;
        TTDownloaderMonitor.inst().monitorDataError(false, false, "onEvent NativeDownloadModel notValid");
        return;
    L37:
    L33:
        e = e;
    L35:
        TTDownloaderMonitor.inst().monitorException(e, "onEvent");
        return;
    L11:
        int r100 = 2;
        if (r115.getExtra() != null) goto L14;
        String r101 = ToolUtils.getNotEmptyStr(new String[]{r110, r115.getEventTag(), EventConstants.Tag.EMBEDED_AD});     // Catch: Exception -> L33
    L16:
        JSONObject r102 = ToolUtils.getBaseJson(r115);     // Catch: Exception -> L33
        r102.putOpt(EventConstants.ExtraJson.KEY_ORIGINAL_TAG, r101);     // Catch: Exception -> L33
        DownloadEventModel.Builder r103 = new DownloadEventModel.Builder().setTag(ToolUtils.getTagValue(r110, r111, r115)).setLabel(r111).setIsAd(r115.isAd()).setAdId(r115.getId()).setLogExtra(r115.getLogExtra());     // Catch: Exception -> L33
        if (r113 <= 0) goto L19;
        long r104 = r113;
    L20:
        DownloadEventModel.Builder r105 = r103.setExtValue(r104);     // Catch: Exception -> L33
        if (r115.getExtra() == null) goto L23;
        String r106 = ToolUtils.getNotEmptyStr(new String[]{r115.getEventRefer(), r115.getExtra().optString("refer")});     // Catch: Exception -> L33
    L24:
        DownloadEventModel.Builder r107 = r105.setRefer(r106).setClickTrackUrl(r115.getClickTrackUrl()).setExtJson(ToolUtils.mergeJson(new JSONObject[]{r102, r112})).setParamsJson(r115.getParamsJson()).setExtraObject(r115.getExtraEventObject()).setAdExtraDataObject(r115.getEvent().getAdExtraDataObject());     // Catch: Exception -> L33
        if (r114 <= 0) goto L27;
        r100 = r114;
    L27:
        onEvent(r107.setEventSource(r100).setIsV3(r115.isV3Event()).build(), r116);     // Catch: Exception -> L31
        return;
    L31:
        e = e;
        goto L35
    L23:
        r106 = r115.getEventRefer();     // Catch: Exception -> L33
        goto L24
    L19:
        r104 = r115.getExtValue();     // Catch: Exception -> L33
        goto L20
    L14:
        r101 = ToolUtils.getNotEmptyStr(new String[]{r110, r115.getEventTag(), r115.getExtra().optString("tag"), EventConstants.Tag.EMBEDED_AD});     // Catch: Exception -> L33
        goto L16
    }
}
