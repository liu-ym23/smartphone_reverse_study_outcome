package com.ss.android.update;

import android.content.Context;
import android.content.Intent;
import com.bytedance.news.common.service.manager.IService;
import java.io.File;
import yhc.g;
import yhc.h;
import yhc.l;

/* JADX INFO: loaded from: classes5.dex */
public interface UpdateService extends IService {
    public static final String REASON_ALPHA_UPDATE_BG_DOWNLOAD = "reason_alpha_pkg_update_bg_download";
    public static final String REASON_APK_IS_PRE_DOWNLOAD = "apk_is_pre_download";
    public static final String REASON_CHECK_VERSION_CODE_FAIL = "reason_check_version_code_fail";
    public static final String REASON_CONTEXT_IS_NULL = "context_is_null";
    public static final String REASON_DIALOG_IS_ALREADY_SHOWN = "dialog_is_already_shown";
    public static final String REASON_IN_LOGIN_ACTIVITY = "activity_is_newaccountloginactivity";
    public static final String REASON_LACK_INFORMATION_NORMAL = "reason_lack_information_normal";
    public static final String REASON_LOCAL_BLOCK_DIALOG = "reason_local_block_dialog";
    public static final String REASON_LOCAL_LIMIT_BLOCK_DIALOG = "reason_local_limit_block_dialog";
    public static final String REASON_LOCAL_OUT_OF_HOUSE = "reason_local_out_of_house";
    public static final String REASON_NETWORK_IS_NOT_WIFI = "network_is_not_wifi";
    public static final String REASON_NEW_STRATEGY_INTERVAL_VERSION = "new_strategy_interval_version_";
    public static final String REASON_NEW_STRATEGY_NOT_ENABLE = "new_strategy_not_enable";
    public static final String REASON_NEW_STRATEGY_NOT_SHOW_FORMAL_DIALOG = "new_strategy_not_show_formal_dialog";
    public static final String REASON_NEW_STRATEGY_VERSION_IS_SAME = "new_strategy_version_is_same";
    public static final String REASON_NOT_ACTIVE = "activity_is_not_active";
    public static final String REASON_NO_BUTTON_TEXT = "reason_no_button_text";
    public static final String REASON_NO_LOCAL_GUIDE = "reason_no_local_guide";
    public static final String REASON_NO_NORMAL_GUIDE = "reason_no_normal_guide";
    public static final String REASON_NO_ORIENTAL_DIALOG = "reason_no_oriental_dialog";
    public static final String REASON_OLD_STRATEGY_DELAY_DAYS = "old_strategy_delay_days_";
    public static final String REASON_OTHER_DIALOG_SHOWING = "reason_other_update_dialog_showing";
    public static final String REASON_VERSION_IS_NOT_MATCH = "version_is_not_match";
    public static final int UPDATE_DIALOG_ACCEPT = 2;
    public static final int UPDATE_DIALOG_OTHER = 0;
    public static final int UPDATE_DIALOG_REFUSE = 3;
    public static final int UPDATE_DIALOG_SHOW = 1;

    void cancelDownload();

    void cancelNotifyAvai();

    void cancelNotifyReady();

    void checkUpdate(int r100, int r101, OnUpdateStatusChangedListener r102, boolean r103);

    void checkUpdate(int r100, OnUpdateStatusChangedListener r101);

    void checkUpdate(int r100, OnUpdateStatusChangedListener r101, boolean r102);

    void clickCloseAlphaButton(boolean r100);

    void clickCloseButton(boolean r100);

    void clickOpenAlphaButton(boolean r100);

    void clickUpdateButton(boolean r100);

    void exitUpdate();

    boolean formalUpdateEnable();

    String getDownloadingUrl();

    Intent getIntentForLocalApp();

    String getLastVersion();

    int getLatency();

    int getOfficial();

    int getPreDownloadDelayDays();

    long getPreDownloadDelaySecond();

    void getProgress(yhc.a r100);

    int getReleaseRuleId();

    String getUpdateButtonText();

    File getUpdateReadyApk();

    String getUpdateTitle();

    String getVerboseAppName();

    int getVersionCode();

    String getWhatsNew();

    boolean isCanUpdate();

    boolean isCanUpdate(boolean r100);

    boolean isClientStrategyEnable();

    boolean isCurrentVersionOut();

    boolean isForceUpdate();

    boolean isInstallAlphaApp();

    boolean isLocalApp();

    boolean isRealCurrentVersionOut();

    boolean isShowUpdateDialog();

    boolean isShowingUpdateAvailDialog();

    boolean isShowingUpdateCheckDialog();

    boolean isUpdateApkPreDownloaded();

    boolean isUpdating();

    boolean needPreDownload();

    void noShowDialogEvent(String r100);

    String parseWhatsNew(String r100);

    void removeUpdateStatusListener(OnUpdateStatusChangedListener r100);

    void reportDialogInfo(int r100, boolean r101);

    void setAppExtra(String r100);

    void setCheckSignature(boolean r100);

    void setCustomUpdateAlphaDialog(g r100);

    void setCustomUpdateDialog(l r100, h r101);

    void showUpdateAlphaDialogScene(boolean r100);

    void showUpdateDialog(int r100, Context r101, boolean r102);

    void showUpdateDialogScene(boolean r100);

    void startDownload();

    void startPreDownload();
}
