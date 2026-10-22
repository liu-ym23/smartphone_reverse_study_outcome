package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.download.api.runtime.IAdDownloadActionProvider;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.dialog.IDeleteBtnListener;
import com.ss.android.downloadlib.addownload.dialog.ISelectOperationListener;
import com.ss.android.downloadlib.addownload.pause.CancelPauseInterceptorManager;
import com.ss.android.downloadlib.addownload.pause.IPauseCallback;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class ReverseWifiHelper {
    private static final String TAG = null;
    private static IDeleteBtnListener sDeleteBtnListener;
    private static ISelectOperationListener sReverseWifiListener;

    public ReverseWifiHelper() {
    }

    public static /* synthetic */ void a(Context r100, NativeDownloadModel r101, int r102, int r103, int r104) {
        lambda$tryReverseWifi$0(r100, r101, r102, r103, r104);
    }

    public static boolean willPause(int r100) {
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 != 3) goto L9;
        return true;
    L9:
        if (r100 != 4) goto L11;
        return true;
    L11:
        if (r100 != 5) goto L13;
        return true;
    L13:
        if (r100 != 7) goto L15;
        return true;
    L15:
        if (r100 == 8) goto L25;
        return false;
    L25:
        return true;
    }

    static {
        TAG = "ReverseWifiHelper";
    }

    public static IDeleteBtnListener getDeleteBtnListener() {
        return sDeleteBtnListener;
    }

    public static ISelectOperationListener getReverseWifiListener() {
        return sReverseWifiListener;
    }

    private static String getDeleteBtnText(NativeDownloadModel r100) {
        IAdSDKSettingsProvider r101 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        String r102 = DownloadSettingUtils.getSetting(r100).optString(DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_NEW_BUTTON_TEXT);
        if (TextUtils.isEmpty(r102) == true) goto L6;
        return r102;
    L6:
        if (r101 != null) goto L8;
        return AdBaseConstants.CANCEL_PAUSE_BUTTON_TEXT;
    L8:
        return r101.getTTDownloaderAdSettings().optString(DownloadSettingKeys.CANCEL_PAUSE_OPTIMISE_NEW_BUTTON_TEXT, AdBaseConstants.CANCEL_PAUSE_BUTTON_TEXT);
    }

    public static void setDeleteBtnListener(IDeleteBtnListener r100) {
        sDeleteBtnListener = r100;
    }

    public static void setReverseWifiListener(ISelectOperationListener r100) {
        sReverseWifiListener = r100;
    }

    public static /* synthetic */ void access$000(int r100, int r101, int r102, NativeDownloadModel r103, String r104) {
        sendReserveWifiCancelUserEvent(r100, r101, r102, r103, r104);
    }

    private static /* synthetic */ void lambda$tryReverseWifi$0(Context r100, NativeDownloadModel r101, int r102, int r103, int r104) {
        IDeleteBtnListener r105 = CancelPauseInterceptorManager.getInstance().getDeleteBtnListener();
        if (r105 == null) goto L5;
        r105.delete();
    L8:
        AdEventHandler.getInstance().sendUnityEvent(EventConstants.UnityLabel.CANCEL_PAUSE_RESERVE_WIFI_DELETE, r101);
        sendReserveWifiCancelUserEvent(r102, r103, r104, r101, "delete");
        return;
    L5:
        IAdDownloadActionProvider r106 = (IAdDownloadActionProvider) DownloadAdRuntimeProvider.getInnerService(IAdDownloadActionProvider.class);
        if (r106 == null) goto L8;
        r106.onJumpManagementPage(r100, r101.getModel(), r101.getController(), r101.getEvent());
        goto L8
    }

    private static void sendReserveWifiCancelUserEvent(int r100, int r101, int r102, NativeDownloadModel r103, String r104) {
        JSONObject r105 = new JSONObject();
        r105.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_TYPE, "reserve_wifi");     // Catch: JSONException -> L5
        r105.putOpt(EventConstants.ExtraJson.PAUSE_OPTIMISE_ACTION, r104);     // Catch: JSONException -> L5
        r105.putOpt("download_percent", Integer.valueOf(r100));     // Catch: JSONException -> L5
        r105.putOpt(EventConstants.ExtraJson.DOWNLOAD_CURRENT_BYTES, Integer.valueOf(r101));     // Catch: JSONException -> L5
        r105.putOpt(EventConstants.ExtraJson.DOWNLOAD_TOTAL_BYTES, Integer.valueOf(r102));     // Catch: JSONException -> L5
    L6:
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_CANCEL_PAUSE_RETAIN_OPTIMISE, r105, r103);
        return;
    L5:
        TTDownloaderLogger.INSTANCE.innerLogE(TAG, "sendReserveWifiCancelUserEvent", "在生成JSONObject的过程中发生了异常");
        goto L6
    }

    public static boolean tryReverseWifi(final NativeDownloadModel r110, DownloadInfo r111, int r112, final IPauseCallback r113, final boolean r114, boolean r210, final Context r211) {
        if (r110 != null) goto L6;
        TTDownloaderMonitor.inst().monitorDataError("tryReverseWifi nativeModel null");
        return false;
    L6:
        if (r111 != null) goto L9;
        TTDownloaderMonitor.inst().monitorDataError("tryReverseWifi info null");
        return false;
    L9:
        final int r100 = r111.getId();
        if (r114 == false) goto L12;
        boolean r101 = DownloadSettingUtils.pauseCancelReserveOnWifiIsOpen(r110);
    L13:
        boolean r102 = r101;
        JSONObject r103 = new JSONObject();
        if (r102 == false) goto L17;
        int r104 = 1;
    L45:
        r103.putOpt(EventConstants.ExtraJson.SWITCH_STATUS, Integer.valueOf(r104));     // Catch: Exception -> L20
    L22:
        if (r114 == false) goto L24;
        AdEventHandler.getInstance().sendUnityEvent(EventConstants.UnityLabel.CANCEL_PAUSE_RESERVE_WIFI_SWITCH_STATUS, r103, r110);
    L25:
        if (r102 == true) goto L28;
        return false;
    L28:
        if (willPause(r112) == true) goto L31;
        return false;
    L31:
        if (DownloadUtils.isWifi(GlobalInfo.getContext()) == false) goto L34;
        return false;
    L34:
        if (r111.hasPauseReservedOnWifi() == true) goto L44;
        long r105 = DownloadPercentHelper.getCurrBytes(r111.getId(), r111.getCurBytes(), r111.getTotalBytes());
        long r106 = r111.getTotalBytes();
        if (r106 != 0) goto L38;
        return false;
    L38:
        final int r107 = DownloadPercentHelper.handlePercent(r111.getId(), (int) ((100 * r105) / r106), r106);
        final int r115 = (int) (r105 / 1048576);
        setReverseWifiListener(new AnonymousClass1(r100, r114, r110, r107, r115, r115, r113));
        setDeleteBtnListener(new g(r211, r110, r107, r115, r115));
        if (r114 == false) goto L41;
        TTDelegateActivity.shownReverseWifiDialogWithCancel(r110, getDeleteBtnText(r110), r210, r211);
    L42:
        r110.setHasShowPauseOptimiseDialogCount(r110.getHasShowPauseOptimiseDialogCount() + 1);
        return true;
    L41:
        TTDelegateActivity.showReverseWifiDialog(r110, r210, r211);
        goto L42
    L44:
        return false;
    L24:
        AdEventHandler.getInstance().sendUnityEvent(EventConstants.UnityLabel.PAUSE_RESERVE_WIFI_SWITCH_STATUS, r103, r110);
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    L17:
        r104 = 0;
        goto L45
    L12:
        r101 = DownloadSettingUtils.pauseReserveOnWifiIsOpen(r110);
        goto L13
    }
}
