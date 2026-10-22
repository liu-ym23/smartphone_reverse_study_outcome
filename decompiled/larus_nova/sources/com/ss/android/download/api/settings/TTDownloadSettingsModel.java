package com.ss.android.download.api.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.downloadlib.constants.DownloadSettingKeys;
import com.ss.android.downloadlib.constants.EventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b,\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0016\u0010\u0013\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0016\u0010\u0015\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0016\u0010\u0017\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0016\u0010\u001b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0016\u0010\u001d\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0016\u0010!\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0016\u0010#\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0016\u0010%\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0016\u0010'\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0016\u0010)\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0016\u0010+\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0016\u0010-\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006¨\u00060"}, d2 = {"Lcom/ss/android/download/api/settings/TTDownloadSettingsModel;", "", "()V", "disableDelayMarketJump", "", "getDisableDelayMarketJump", "()I", "enableBusinessDownloadFile", "getEnableBusinessDownloadFile", "enableCheckMarketSign", "getEnableCheckMarketSign", "enableDefaultTag", "getEnableDefaultTag", "enableDeleteDownloadAndModel", "getEnableDeleteDownloadAndModel", "enableDownloadChainProcessOpt", "getEnableDownloadChainProcessOpt", "enableDownloadSchemeOpt", "getEnableDownloadSchemeOpt", "enableFixDownloadPause", "getEnableFixDownloadPause", "enableGetInstallAppsPermission", "getEnableGetInstallAppsPermission", "enableMiuiMarketDownloadListenerOpt", "getEnableMiuiMarketDownloadListenerOpt", "enableReadDownloadInfoOpt", "getEnableReadDownloadInfoOpt", "enableSchemeCheckerOpt", "getEnableSchemeCheckerOpt", "enableSendInstallFinishByMiuiMarketBroadcast", "getEnableSendInstallFinishByMiuiMarketBroadcast", "enableUpdateDeleteForGame", "getEnableUpdateDeleteForGame", "fixSamsungMarketPackage", "getFixSamsungMarketPackage", "fixSoftListener", "getFixSoftListener", "fixUpdateDelete", "getFixUpdateDelete", "fixWebTrackPoint", "getFixWebTrackPoint", "marketIntentJumpProhibitToast", "getMarketIntentJumpProhibitToast", "mimarketDetailStyle", "getMimarketDetailStyle", "toastBackup", "getToastBackup", "Companion", "download-api_release"}, k = 1, mv = {1, 1, 16})
public final class TTDownloadSettingsModel {
    public static final Companion Companion = null;
    public static final int DETAIL_STYLE_FULL = 1;
    public static final int DETAIL_STYLE_HALF = 2;
    public static final int DETAIL_STYLE_UNKNOWN = -1;

    @SerializedName("disable_delay_market_jump")
    private final int disableDelayMarketJump;

    @SerializedName("enable_business_download_file")
    private final int enableBusinessDownloadFile;

    @SerializedName("enable_check_market_sign")
    private final int enableCheckMarketSign;

    @SerializedName("enable_default_tag")
    private final int enableDefaultTag;

    @SerializedName("enable_delete_download_and_model")
    private final int enableDeleteDownloadAndModel;

    @SerializedName(EventConstants.ExtraJson.EXTRA_ENABLE_DOWNLOAD_CHAIN_PROCESS_OPT)
    private final int enableDownloadChainProcessOpt;

    @SerializedName("enable_download_scheme_opt")
    private final int enableDownloadSchemeOpt;

    @SerializedName("enable_fix_download_pause")
    private final int enableFixDownloadPause;

    @SerializedName("enable_get_install_apps_permission")
    private final int enableGetInstallAppsPermission;

    @SerializedName(DownloadSettingKeys.KEY_ENABLE_MIUI_MARKET_DOWNLOAD_LISTENER_OPT)
    private final int enableMiuiMarketDownloadListenerOpt;

    @SerializedName("enable_read_download_info_opt")
    private final int enableReadDownloadInfoOpt;

    @SerializedName("enable_scheme_checker_opt")
    private final int enableSchemeCheckerOpt;

    @SerializedName(DownloadSettingKeys.KEY_ENABLE_SEND_INSTALL_FINISH_BY_MIUI_MARKET_BROADCAST)
    private final int enableSendInstallFinishByMiuiMarketBroadcast;

    @SerializedName("enable_update_delete_for_game")
    private final int enableUpdateDeleteForGame;

    @SerializedName("fix_samsung_market_package")
    private final int fixSamsungMarketPackage;

    @SerializedName("fix_soft_listener")
    private final int fixSoftListener;

    @SerializedName("fix_update_delete")
    private final int fixUpdateDelete;

    @SerializedName("fix_web_track_point")
    private final int fixWebTrackPoint;

    @SerializedName("market_intent_jump_prohibit_toast")
    private final int marketIntentJumpProhibitToast;

    @SerializedName("mimarket_detail_style")
    private final int mimarketDetailStyle;

    @SerializedName("toast_backup")
    private final int toastBackup;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/ss/android/download/api/settings/TTDownloadSettingsModel$Companion;", "", "()V", "DETAIL_STYLE_FULL", "", "DETAIL_STYLE_HALF", "DETAIL_STYLE_UNKNOWN", "download-api_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TTDownloadSettingsModel() {
        this.mimarketDetailStyle = 1;
        this.marketIntentJumpProhibitToast = 1;
        this.enableCheckMarketSign = 1;
        this.enableUpdateDeleteForGame = 1;
        this.enableDeleteDownloadAndModel = 1;
        this.enableMiuiMarketDownloadListenerOpt = 1;
    }

    public final int getDisableDelayMarketJump() {
        return this.disableDelayMarketJump;
    }

    public final int getEnableBusinessDownloadFile() {
        return this.enableBusinessDownloadFile;
    }

    public final int getEnableCheckMarketSign() {
        return this.enableCheckMarketSign;
    }

    public final int getEnableDefaultTag() {
        return this.enableDefaultTag;
    }

    public final int getEnableDeleteDownloadAndModel() {
        return this.enableDeleteDownloadAndModel;
    }

    public final int getEnableDownloadChainProcessOpt() {
        return this.enableDownloadChainProcessOpt;
    }

    public final int getEnableDownloadSchemeOpt() {
        return this.enableDownloadSchemeOpt;
    }

    public final int getEnableFixDownloadPause() {
        return this.enableFixDownloadPause;
    }

    public final int getEnableGetInstallAppsPermission() {
        return this.enableGetInstallAppsPermission;
    }

    public final int getEnableMiuiMarketDownloadListenerOpt() {
        return this.enableMiuiMarketDownloadListenerOpt;
    }

    public final int getEnableReadDownloadInfoOpt() {
        return this.enableReadDownloadInfoOpt;
    }

    public final int getEnableSchemeCheckerOpt() {
        return this.enableSchemeCheckerOpt;
    }

    public final int getEnableSendInstallFinishByMiuiMarketBroadcast() {
        return this.enableSendInstallFinishByMiuiMarketBroadcast;
    }

    public final int getEnableUpdateDeleteForGame() {
        return this.enableUpdateDeleteForGame;
    }

    public final int getFixSamsungMarketPackage() {
        return this.fixSamsungMarketPackage;
    }

    public final int getFixSoftListener() {
        return this.fixSoftListener;
    }

    public final int getFixUpdateDelete() {
        return this.fixUpdateDelete;
    }

    public final int getFixWebTrackPoint() {
        return this.fixWebTrackPoint;
    }

    public final int getMarketIntentJumpProhibitToast() {
        return this.marketIntentJumpProhibitToast;
    }

    public final int getMimarketDetailStyle() {
        return this.mimarketDetailStyle;
    }

    public final int getToastBackup() {
        return this.toastBackup;
    }
}
