package com.ss.android.downloadlib.applink;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.ComplianceDataItem;
import com.ss.android.download.api.runtime.IAdSDKSettingsProvider;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.downloadlib.addownload.CommonDownloadHandler;
import com.ss.android.downloadlib.addownload.DownloadAdRuntimeProvider;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import com.ss.android.downloadlib.addownload.model.ModelManager;
import com.ss.android.downloadlib.addownload.model.OpenAppResult;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.exception.TTDownloaderMonitor;
import com.ss.android.downloadlib.utils.DownloadSettingUtils;
import com.ss.android.downloadlib.utils.TTDownloaderLogger;
import com.ss.android.downloadlib.utils.ToolUtils;
import com.ss.android.socialbase.appdownloader.util.AnUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class AdMarketOpenSubManager {
    private static final String TAG = null;

    public static class SingleTonHolder {
        private static AdMarketOpenSubManager INSTANCE;

        private SingleTonHolder() {
        }

        static {
            INSTANCE = new AdMarketOpenSubManager(null);
        }

        public static /* synthetic */ AdMarketOpenSubManager access$100() {
            return INSTANCE;
        }
    }

    static {
        TAG = "AdMarketOpenProcessor";
    }

    public static AdMarketOpenSubManager getInstance() {
        return SingleTonHolder.access$100();
    }

    private AdMarketOpenSubManager() {
    }

    public static /* synthetic */ String access$200() {
        return TAG;
    }

    public /* synthetic */ AdMarketOpenSubManager(AnonymousClass1 r100) {
        this();
    }

    private void setPackageName(NativeDownloadModel r100, String r101) {
        DownloadModel r102 = ModelManager.getInstance().getDownloadModel(r100.getId());
        if ((r102 instanceof AdDownloadModel) == false) goto L5;
        ((AdDownloadModel) r102).setPackageName(r101);
    L5:
        r100.getModel().setPackageName(r101);
    }

    public int checkMarketOpenScene(NativeDownloadModel r100, int r101) {
        IAdSDKSettingsProvider r102 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        if (r102 == null) goto L5;
        JSONArray r103 = r102.getTTDownloaderAdSettings().optJSONArray(DownloadSettingKeys.KEY_AM_PLANS);
    L7:
        if (RomUtils.isMiui() == false) goto L11;
        return 5;
    L11:
        if (r100.getModel().isAd() == true) goto L13;
    L39:
        return 1;
    L13:
        if (r100.getController().enableAM() == false) goto L39;
        if (r103 == null) goto L39;
        if (RomUtils.isFlyme() == false) goto L23;
        if (AnUtils.enableAmPlan(r103, DownloadSettingKeys.AM_2) == false) goto L23;
        return 2;
    L23:
        if (RomUtils.isVivo() == false) goto L31;
        if (AnUtils.enableAmPlan(r103, DownloadSettingKeys.AM_8) == false) goto L31;
        if (ToolUtils.compareVersion(ToolUtils.getVersionName(GlobalInfo.getContext(), RomUtils.MARKET_PKG_NAME_VIVO), BaseConstants.VIVO_V2_REQUIRED_MARKET_VERSION) < 0) goto L31;
        return 3;
    L31:
        if (RomUtils.isHuaWeiDevice() == false) goto L39;
        if (RomUtils.isHonorDevice() == true) goto L39;
        if (AnUtils.enableAmPlan(r103, DownloadSettingKeys.AM_12) == false) goto L39;
        if (r101 != 1) goto L39;
        return 4;
    L5:
        r103 = null;
        goto L7
    }

    public OpenAppResult tryOpenNormalMarket(Context r110, Uri r111) {
        TTDownloaderLogger r100 = TTDownloaderLogger.INSTANCE;
        String r101 = TAG;
        r100.innerLogD(r101, "tryOpenNormalMarket", "外部传入uri接口尝试调起商店");
        AdMarketOpenProcessor r102 = new AdMarketOpenProcessor();
        JSONObject r103 = new JSONObject();
        ToolUtils.safePut(r103, EventConstants.ExtraJson.TTDOWNLOADER, 1);
        ToolUtils.safePut(r103, EventConstants.ExtraJson.EXTRA_MARKET_OPEN_SCENE, 1);
        OpenAppResult r112 = realTryOpenNormalMarket(r102, r110, r111);
        ToolUtils.safePut(r103, "applink_source", ToolUtils.getNotEmptyStr(new String[]{r112.getSource(), EventConstants.AppLinkSource.OPEN_MARKET_OUTSIDE}));
        int r104 = r112.getType();
        if (r104 == 5) goto L9;
        if (r104 == 6) goto L7;
        TTDownloaderMonitor.inst().monitorDataError(false, "普通商店跳转场景数据错误, 不执行调起商店的逻辑");
        return new OpenAppResult(6);
    L7:
        r100.innerLogD(r101, "tryOpenNormalMarket", "前置检查失败,不执行调起商店的逻辑,调起失败");
        return r112;
    L9:
        r100.innerLogD(r101, "tryOpenNormalMarket", "前置检查成功，尝试执行调起操作");
        if (r102.realDoOpenNormalMarket(r110, r112, null, r103) == false) goto L13;
        r100.innerLogD(r101, "tryOpenNormalMarket", "调起成功");
        return new OpenAppResult(5);
    L13:
        r100.innerLogD(r101, "tryOpenNormalMarket", "调起过程中抛出异常，不拦截点击操作");
        return new OpenAppResult(6, 23);
    }

    public OpenAppResult tryOpenNormalMarket(Context r110, String r111) {
        TTDownloaderLogger r100 = TTDownloaderLogger.INSTANCE;
        String r101 = TAG;
        r100.innerLogD(r101, "tryOpenNormalMarket", "外部传入包名接口尝试调起商店");
        AdMarketOpenProcessor r102 = new AdMarketOpenProcessor();
        JSONObject r103 = new JSONObject();
        ToolUtils.safePut(r103, EventConstants.ExtraJson.TTDOWNLOADER, 1);
        ToolUtils.safePut(r103, EventConstants.ExtraJson.EXTRA_MARKET_OPEN_SCENE, 1);
        OpenAppResult r112 = realTryOpenNormalMarket(r102, r110, r111);
        ToolUtils.safePut(r103, "applink_source", ToolUtils.getNotEmptyStr(new String[]{r112.getSource(), EventConstants.AppLinkSource.OPEN_MARKET_OUTSIDE}));
        int r104 = r112.getType();
        if (r104 == 5) goto L9;
        if (r104 == 6) goto L7;
        TTDownloaderMonitor.inst().monitorDataError(false, "普通商店跳转场景数据错误, 不执行调起商店的逻辑");
        return new OpenAppResult(6);
    L7:
        r100.innerLogD(r101, "tryOpenNormalMarket", "前置检查失败,不执行调起商店的逻辑,调起失败");
        return r112;
    L9:
        r100.innerLogD(r101, "tryOpenNormalMarket", "前置检查成功，尝试执行调起操作");
        if (r102.realDoOpenNormalMarket(r110, r112, null, r103) == false) goto L13;
        r100.innerLogD(r101, "tryOpenNormalMarket", "调起成功");
        return new OpenAppResult(5);
    L13:
        r100.innerLogD(r101, "tryOpenNormalMarket", "调起过程中抛出异常，不拦截点击操作");
        return new OpenAppResult(6, 23);
    }

    private boolean isMarketDownloadAd(DownloadModel r100, DownloadController r101, ComplianceDataItem r102) {
        if (r101 != null) goto L5;
    L6:
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.getAppStorePermit() != 1) goto L12;
    L9:
        return true;
    L12:
        return false;
    L5:
        if (r101.getDownloadMode() == 2) goto L9;
        goto L6
    }

    private OpenAppResult realTryOpenNormalMarket(AdMarketOpenProcessor r100, Context r101, NativeDownloadModel r102) {
        String r103 = r102.getModel().getPackageName();
        if (r101 == null) goto L10;
        if (TextUtils.isEmpty(r103) == true) goto L10;
        return realTryOpenNormalMarket(r100, r101, r103);
    L10:
        return new OpenAppResult(6, 11);
    }

    public boolean canOpenMarket(NativeDownloadModel r100, boolean r101, JSONObject r102) {
        if (isMarketDownloadAd(r100.getModel(), r100.getController(), r100.getComplianceItem()) == true) goto L6;
        return false;
    L6:
        boolean r103 = MarketOnlineStatusChecker.isApkInMarket(r100.getComplianceItem().getMarketOnlineStatus());
        if (r103 == true) goto L13;
        JSONObject r104 = new JSONObject();
        ToolUtils.safePut(r104, "market_online_status", Integer.valueOf(r100.getComplianceItem().getMarketOnlineStatus()));
        if (r101 == true) goto L11;
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_MARKET_DOWNLOAD_OFFLINE_SIGN, r104, r100);
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "canOpenMarket", "发送应用未上架记录的用户侧埋点");
    L11:
        if (r102 == null) goto L13;
        ToolUtils.safePut(r102, AdBaseConstants.DownloadExtraInfoKey.EXTRA_MARKET_OFF_SHELF_SIGH, 1);
    L13:
        return r103;
    }

    public boolean shouldOpenMarket(NativeDownloadModel r100, int r101, JSONObject r102) {
        IAdSDKSettingsProvider r103 = (IAdSDKSettingsProvider) DownloadAdRuntimeProvider.getInnerService(IAdSDKSettingsProvider.class);
        ComplianceDataItem r104 = r100.getComplianceItem();
        if (TextUtils.isEmpty(r100.getModel().getPackageName()) == false) goto L9;
        if (TextUtils.isEmpty(r104.getPackageName()) == true) goto L7;
        setPackageName(r100, r104.getPackageName());
        goto L9
    L7:
        return false;
    L9:
        if (DownloadSettingUtils.shouldOpenMarketBySettings(false) == true) goto L12;
        return false;
    L12:
        if (r101 == 2) goto L14;
    L16:
        if (r101 != 1) goto L23;
        if (r103 == null) goto L23;
        if (r103.getTTDownloaderAdSettings().optInt(DownloadSettingKeys.DISABLE_LP_IF_MARKET, 0) != 1) goto L23;
        if (canOpenMarket(r100, false, r102) == false) goto L23;
        return true;
    L23:
        return false;
    L14:
        if (canOpenMarket(r100, false, r102) == false) goto L16;
        return true;
    }

    private OpenAppResult realTryOpenNormalMarket(AdMarketOpenProcessor r100, Context r101, Uri r102) {
        if (r101 == null) goto L8;
        if (r102 == null) goto L8;
        OpenAppResult r103 = new OpenAppResult();
        r100.generateMarketIntent(r101, r102, r103);
        return r100.checkMarketIntentResult(r101, r103, false);
    L8:
        return new OpenAppResult(6, 12);
    }

    private OpenAppResult realTryOpenNormalMarket(AdMarketOpenProcessor r100, Context r101, String r102) {
        OpenAppResult r103 = new OpenAppResult();
        r100.generateMarketIntent(r101, r102, r103);
        return r100.checkMarketIntentResult(r101, r103, false);
    }

    public boolean rollBackLandingPage(boolean r100, CommonDownloadHandler r101, int r102, NativeDownloadModel r103) {
        JSONObject r104 = new JSONObject();
        if (r100 == false) goto L5;
        int r105 = 2;
    L6:
        ToolUtils.safePut(r104, EventConstants.ExtraJson.EXTRA_IS_FROM_NORMAL_SCENE, Integer.valueOf(r105));
        ToolUtils.safePut(r104, "click_type", Integer.valueOf(r102));
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_ROLL_BACK_LANDING_PAGE_FROM_JUMP_MARKET, r104, r103);
        if (DownloadSettingUtils.shouldRollbackLandingPage(r103.getModel()) == false) goto L12;
        if (r100 == false) goto L14;
        if (r101 == null) goto L15;
        AdEventHandler.getInstance().sendClickEvent(r103.getId(), r102);
        r101.openLandingPage();
        return true;
    L15:
        return false;
    L14:
        return false;
    L12:
        return false;
    L5:
        r105 = 1;
        goto L6
    }

    public void tryOpenNormalMarket(JSONObject r100, final NativeDownloadModel r110, Context r111, boolean r112, boolean r113, int r114, final IDownloadMarketResultCallback r115) {
        if (r100 != null) goto L4;
        r100 = new JSONObject();
    L4:
        final AdMarketOpenProcessor r101 = new AdMarketOpenProcessor();
        ToolUtils.safePut(r100, "applink_source", EventConstants.AppLinkSource.OPEN_MARKET);
        r101.beforeHandleOpenMarket(r100, r110);
        if (r113 == true) goto L7;
        ToolUtils.safePut(r100, EventConstants.ExtraJson.EXTRA_MARKET_OPEN_SCENE, 1);
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_DOWNLOAD_APPLINK_BEFORE_HANDLE_CLICK, r100, r110);
    L7:
        if (r111 != null) goto L9;
        r111 = GlobalInfo.getContext();
    L9:
        OpenAppResult r116 = realTryOpenNormalMarket(r101, r111, r110);
        ToolUtils.safePut(r100, EventConstants.ExtraJson.MARKET_PACKAGE_NAME, r116.getMarketPackageName());
        int r102 = r116.getType();
        if (r102 != 5) goto L12;
        r101.handleMarketBeforeCheckSuccess(r100, r116, r110);
        if (r112 == false) goto L23;
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenNormalMarket", "普通商店调起场景, 发送click埋点");
        AdEventHandler.getInstance().sendClickEvent(r110.getId(), r114);
    L23:
        final JSONObject r103 = r100;
        Context r104 = r111;
        r101.realDoOpenNormalMarket(r104, r116, r110, ToolUtils.mergeJson(new JSONObject[]{ToolUtils.getBaseJson(r110), r100}), new AnonymousClass1(this, r115, r101, r103, r110));     // Catch: Exception -> L21
        return;
    L21:
        TTDownloaderLogger.INSTANCE.innerLogD(TAG, "tryOpenNormalMarket", "调起过程中抛出异常，不拦截点击操作");
        r101.sendRealOpenFailedUserEvent(r100, r110, null);
        r115.onFailed();
        return;
    L12:
        if (r102 == 6) goto L14;
        TTDownloaderMonitor.inst().monitorDataError(false, "普通商店跳转场景数据错误, 不执行调起商店的逻辑");
        r115.onFailed();
        return;
    L14:
        TTDownloaderLogger r117 = TTDownloaderLogger.INSTANCE;
        String r118 = TAG;
        r117.innerLogD(r118, "tryOpenNormalMarket", "前置检查失败,不执行调起商店的逻辑");
        r101.handleMarketBeforeCheckFailed(r100, r116, r110);
        r117.innerLogD(r118, "tryOpenNormalMarket", "不对点击操作进行拦截");
        r115.onFailed();
    }

    public void tryOpenOptMarket(final JSONObject r110, final NativeDownloadModel r111, final int r112, final boolean r113, int r114, int r210, Context r211, final IDownloadMarketResultCallback r212) {
        final AdMarketOpenProcessor r115 = new AdMarketOpenProcessor();
        r115.beforeHandleOpenMarket(r110, r111);
        ToolUtils.safePut(r110, "applink_source", EventConstants.AppLinkSource.OPEN_MARKET_OPT);
        ToolUtils.safePut(r110, EventConstants.ExtraJson.EXTRA_MARKET_OPEN_SCENE, Integer.valueOf(r114));
        AdEventHandler.getInstance().sendUserEvent(EventConstants.UserEventLabel.BDAL_DOWNLOAD_APPLINK_BEFORE_HANDLE_CLICK, r110, r111);
        if (r211 != null) goto L5;
        Context r116 = GlobalInfo.getContext();
    L6:
        final Context r100 = r116;
        Context r101 = r116;
        realTryOpenOptMarket(r115, r110, r101, r111, r114, r210, r112, r113, new AnonymousClass2(this, r115, r111, r110, r100, r113, r112, r212));
        return;
    L5:
        r116 = r211;
        goto L6
    }

    private void realTryOpenOptMarket(final AdMarketOpenProcessor r110, final JSONObject r111, final Context r112, final NativeDownloadModel r113, int r114, int r115, final int r116, final boolean r117, final IDownloadMarketOptCheckCallback r118) {
        String r100 = r113.getModel().getPackageName();
        if (r112 != null) goto L5;
    L8:
        ToolUtils.safePut(r111, "error_code", 11);
        r118.onCheckFinish(false, r111, null);
    L9:
        ToolUtils.safePut(r111, EventConstants.ExtraJson.KEY_OPT_MARKET_SCENE, Integer.valueOf(r114));
        r110.generateOptMarketIntent(r112, r113, r114, r115, new AnonymousClass3(this, r110, r112, r111, r113, r117, r116, r118));
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        goto L8
    }
}
