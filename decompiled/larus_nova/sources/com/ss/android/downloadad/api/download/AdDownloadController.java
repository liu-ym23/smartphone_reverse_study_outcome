package com.ss.android.downloadad.api.download;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AdDownloadController implements DownloadController {
    protected String bizParamsJson;
    protected String certId;
    protected boolean mDefaultControllerSign;
    protected int mDownloadMode;
    protected boolean mEnableAH;
    protected boolean mEnableAM;
    protected boolean mEnableClickStartOptForGameUnion;
    protected boolean mEnableDownloadHandlerTaskKey;
    protected boolean mEnableNewActivity;
    protected boolean mEnableOppoAutoDownload;
    protected boolean mEnableShowComplianceDialog;
    protected boolean mEnableShowComplianceDialogInFeed;
    protected boolean mEnableSpecialShowComplianceDialog;
    protected Object mExtraClickOperation;
    protected JSONObject mExtraJson;
    protected Object mExtraObject;
    protected int mInterceptFlag;
    protected boolean mIsAddToDownloadManage;
    protected boolean mIsAutoDownloadOnCardShow;
    protected boolean mIsEnableBackDialog;
    protected boolean mIsOrderDownload;
    protected int mLinkMode;
    protected boolean mShouldUseNewWebView;

    public static final class Builder {
        AdDownloadController controller;

        public Builder setDowloadChunkCount(int r100) {
            return this;
        }

        public Builder setIsEnableMultipleDownload(boolean r100) {
            return this;
        }

        public Builder() {
            this.controller = new AdDownloadController();
        }

        public AdDownloadController build() {
            return this.controller;
        }

        public Builder setBizParamsJson(String r100) {
            this.controller.bizParamsJson = r100;
            return this;
        }

        public Builder setCertId(String r100) {
            this.controller.certId = r100;
            return this;
        }

        public Builder setDefaultControllerSign(boolean r100) {
            this.controller.mDefaultControllerSign = r100;
            return this;
        }

        public Builder setDownloadMode(int r100) {
            this.controller.mDownloadMode = r100;
            return this;
        }

        public Builder setEnableAH(boolean r100) {
            this.controller.mEnableAH = r100;
            return this;
        }

        public Builder setEnableAM(boolean r100) {
            this.controller.mEnableAM = r100;
            return this;
        }

        public Builder setEnableBackDialog(boolean r100) {
            this.controller.mIsEnableBackDialog = r100;
            return this;
        }

        public Builder setEnableClickStartOptForGameUnion(boolean r100) {
            this.controller.mEnableClickStartOptForGameUnion = r100;
            return this;
        }

        public Builder setEnableDownloadHandlerTaskKey(boolean r100) {
            this.controller.mEnableDownloadHandlerTaskKey = r100;
            return this;
        }

        public Builder setEnableNewActivity(boolean r100) {
            this.controller.mEnableNewActivity = r100;
            return this;
        }

        public Builder setEnableOppoAutoDownload(boolean r100) {
            this.controller.mEnableOppoAutoDownload = r100;
            return this;
        }

        public Builder setEnableShowComplianceDialog(boolean r100) {
            this.controller.mEnableShowComplianceDialog = r100;
            return this;
        }

        public Builder setEnableShowComplianceDialogInFeed(boolean r100) {
            this.controller.mEnableShowComplianceDialogInFeed = r100;
            return this;
        }

        public Builder setEnableSpecialShowComplianceDialog(boolean r100) {
            this.controller.mEnableSpecialShowComplianceDialog = r100;
            return this;
        }

        public Builder setExtraJson(JSONObject r100) {
            this.controller.mExtraJson = r100;
            return this;
        }

        public Builder setExtraObject(Object r100) {
            this.controller.mExtraObject = r100;
            return this;
        }

        public Builder setExtraOperation(Object r100) {
            this.controller.mExtraClickOperation = r100;
            return this;
        }

        public Builder setInterceptFlag(int r100) {
            this.controller.mInterceptFlag = r100;
            return this;
        }

        public Builder setIsAddToDownloadManage(boolean r100) {
            this.controller.mIsAddToDownloadManage = r100;
            return this;
        }

        public Builder setIsAutoDownloadOnCardShow(boolean r100) {
            this.controller.mIsAutoDownloadOnCardShow = r100;
            return this;
        }

        public Builder setIsEnableBackDialog(boolean r100) {
            this.controller.mIsEnableBackDialog = r100;
            return this;
        }

        public Builder setIsOrderDownload(boolean r100) {
            this.controller.mIsOrderDownload = r100;
            return this;
        }

        public Builder setLinkMode(int r100) {
            this.controller.mLinkMode = r100;
            return this;
        }

        public Builder setShouldUseNewWebView(boolean r100) {
            this.controller.mShouldUseNewWebView = r100;
            return this;
        }
    }

    public interface JsonKey {
        public static final String ADD_TO_MANAGE = "add_to_manage";
        public static final String AUTO_DOWNLOAD_ON_CARD_SHOW = "is_auto_download_on_card_show";
        public static final String DEFAULT_CONTROLLER_SIGN = "default_controller_sign";
        public static final String DOWNLOAD_MODE = "download_mode";
        public static final String ENABLE_AH = "enable_ah";
        public static final String ENABLE_AM = "enable_am";
        public static final String ENABLE_BACK_DIALOG = "enable_back_dialog";
        public static final String ENABLE_CLICK_START_OPT_FOR_GAME_UNION = "enable_click_start_opt_for_game_union";
        public static final String ENABLE_COMPLIANCE_DIALOG_IN_FEED = "enable_compliance_dialog_in_feed";
        public static final String ENABLE_DOWNLOAD_HANDLER_TASKKEY = "enable_download_handler_taskkey";
        public static final String ENABLE_NEW_ACTIVITY = "enable_new_activity";
        public static final String ENABLE_OPPO_AUTO_DOWNLOAD = "enable_oppo_auto_download";
        public static final String ENABLE_SHOW_COMPLIANCE_DIALOG = "enable_show_compliance_dialog";
        public static final String ENABLE_SPECIAL_SHOW_COMPLIANCE_DIALOG = "enable_special_show_compliance_dialog";
        public static final String EXTRA = "extra";
        public static final String INTERCEPT_FLAG = "intercept_flag";
        public static final String IS_ORDER_DOWNLOAD = "is_order_download";
        public static final String LINK_MODE = "link_mode";
        public static final String USE_NEW_WEBVIEW = "use_new_webview";
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 1;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.putOpt("link_mode", Integer.valueOf(this.mLinkMode));     // Catch: Exception -> L65
        r100.putOpt("download_mode", Integer.valueOf(this.mDownloadMode));     // Catch: Exception -> L65
        int r101 = 1;
        if (this.mIsEnableBackDialog == false) goto L6;
        int r102 = 1;
    L7:
        r100.putOpt(JsonKey.ENABLE_BACK_DIALOG, Integer.valueOf(r102));     // Catch: Exception -> L65
        if (this.mIsAddToDownloadManage == false) goto L10;
        int r103 = 1;
    L11:
        r100.putOpt(JsonKey.ADD_TO_MANAGE, Integer.valueOf(r103));     // Catch: Exception -> L65
        if (this.mShouldUseNewWebView == false) goto L14;
        int r104 = 1;
    L15:
        r100.putOpt(JsonKey.USE_NEW_WEBVIEW, Integer.valueOf(r104));     // Catch: Exception -> L65
        r100.putOpt(JsonKey.INTERCEPT_FLAG, Integer.valueOf(this.mInterceptFlag));     // Catch: Exception -> L65
        if (this.mEnableShowComplianceDialog == false) goto L18;
        int r105 = 1;
    L19:
        r100.putOpt(JsonKey.ENABLE_SHOW_COMPLIANCE_DIALOG, Integer.valueOf(r105));     // Catch: Exception -> L65
        if (this.mIsAutoDownloadOnCardShow == false) goto L22;
        int r106 = 1;
    L23:
        r100.putOpt(JsonKey.AUTO_DOWNLOAD_ON_CARD_SHOW, Integer.valueOf(r106));     // Catch: Exception -> L65
        r100.putOpt("extra", this.mExtraJson);     // Catch: Exception -> L65
        if (this.mEnableNewActivity == false) goto L26;
        int r107 = 1;
    L27:
        r100.putOpt("enable_new_activity", Integer.valueOf(r107));     // Catch: Exception -> L65
        if (this.mEnableAH == false) goto L30;
        int r108 = 1;
    L31:
        r100.putOpt("enable_ah", Integer.valueOf(r108));     // Catch: Exception -> L65
        if (this.mEnableAM == false) goto L34;
        int r109 = 1;
    L35:
        r100.putOpt("enable_am", Integer.valueOf(r109));     // Catch: Exception -> L65
        if (this.mEnableShowComplianceDialogInFeed == false) goto L38;
        int r110 = 1;
    L39:
        r100.putOpt(JsonKey.ENABLE_COMPLIANCE_DIALOG_IN_FEED, Integer.valueOf(r110));     // Catch: Exception -> L65
        if (this.mEnableDownloadHandlerTaskKey == false) goto L42;
        int r111 = 1;
    L43:
        r100.putOpt("enable_download_handler_taskkey", Integer.valueOf(r111));     // Catch: Exception -> L65
        if (this.mEnableOppoAutoDownload == false) goto L46;
        int r112 = 1;
    L47:
        r100.putOpt(JsonKey.ENABLE_OPPO_AUTO_DOWNLOAD, Integer.valueOf(r112));     // Catch: Exception -> L65
        if (this.mEnableClickStartOptForGameUnion == false) goto L50;
        int r113 = 1;
    L51:
        r100.putOpt("enable_click_start_opt_for_game_union", Integer.valueOf(r113));     // Catch: Exception -> L65
        if (this.mEnableSpecialShowComplianceDialog == false) goto L54;
        int r114 = 1;
    L55:
        r100.putOpt(JsonKey.ENABLE_SPECIAL_SHOW_COMPLIANCE_DIALOG, Integer.valueOf(r114));     // Catch: Exception -> L65
        if (this.mDefaultControllerSign == false) goto L58;
        int r115 = 1;
    L59:
        r100.putOpt(JsonKey.DEFAULT_CONTROLLER_SIGN, Integer.valueOf(r115));     // Catch: Exception -> L65
        if (this.mIsOrderDownload == true) goto L63;
        r101 = 0;
    L63:
        r100.putOpt("is_order_download", Integer.valueOf(r101));     // Catch: Exception -> L65
    L67:
        return r100;
    L58:
        r115 = 0;
        goto L59
    L54:
        r114 = 0;
        goto L55
    L50:
        r113 = 0;
        goto L51
    L46:
        r112 = 0;
        goto L47
    L42:
        r111 = 0;
        goto L43
    L38:
        r110 = 0;
        goto L39
    L34:
        r109 = 0;
        goto L35
    L30:
        r108 = 0;
        goto L31
    L26:
        r107 = 0;
        goto L27
    L22:
        r106 = 0;
        goto L23
    L18:
        r105 = 0;
        goto L19
    L14:
        r104 = 0;
        goto L15
    L10:
        r103 = 0;
        goto L11
    L6:
        r102 = 0;
    L65:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "AdDownloadController toJson");
        goto L67
    }

    public AdDownloadController() {
        this.mEnableShowComplianceDialog = true;
        this.mEnableNewActivity = true;
        this.mEnableAH = true;
        this.mEnableAM = true;
        this.mEnableShowComplianceDialogInFeed = false;
        this.mEnableDownloadHandlerTaskKey = false;
        this.mEnableOppoAutoDownload = true;
        this.mEnableClickStartOptForGameUnion = false;
        this.mEnableSpecialShowComplianceDialog = false;
        this.mDefaultControllerSign = false;
        this.mIsOrderDownload = false;
        this.certId = "";
        this.bizParamsJson = "";
    }

    public boolean defaultControllerSign() {
        return this.mDefaultControllerSign;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return this.mEnableAH;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return this.mEnableAM;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return this.mEnableNewActivity;
    }

    public boolean enableOppoAutoDownload() {
        return this.mEnableOppoAutoDownload;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return this.mEnableShowComplianceDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public String getBizParamsJson() {
        return this.bizParamsJson;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public String getCertId() {
        return this.certId;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return this.mDownloadMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraClickOperation() {
        return this.mExtraClickOperation;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public Object getExtraObject() {
        return this.mExtraObject;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return this.mInterceptFlag;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return this.mLinkMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return this.mIsAddToDownloadManage;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return this.mIsAutoDownloadOnCardShow;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return this.mIsEnableBackDialog;
    }

    public boolean isEnableClickStartOptForGameUnion() {
        return this.mEnableClickStartOptForGameUnion;
    }

    public boolean isEnableDownloadHandlerTaskKey() {
        return this.mEnableDownloadHandlerTaskKey;
    }

    public boolean isEnableShowComplianceDialogInFeed() {
        return this.mEnableShowComplianceDialogInFeed;
    }

    public boolean isEnableSpecialShowComplianceDialog() {
        return this.mEnableSpecialShowComplianceDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isOrderDownload() {
        return this.mIsOrderDownload;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return this.mShouldUseNewWebView;
    }

    public static AdDownloadController fromJson(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Builder r101 = new Builder();
        r101.setLinkMode(r100.optInt("link_mode"));     // Catch: Exception -> L67
        r101.setDownloadMode(r100.optInt("download_mode"));     // Catch: Exception -> L67
        boolean r102 = false;
        if (r100.optInt(JsonKey.ENABLE_BACK_DIALOG) != 1) goto L9;
        boolean r103 = true;
    L10:
        r101.setIsEnableBackDialog(r103);     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.ADD_TO_MANAGE) != 1) goto L13;
        boolean r104 = true;
    L14:
        r101.setIsAddToDownloadManage(r104);     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.USE_NEW_WEBVIEW) != 1) goto L17;
        boolean r105 = true;
    L18:
        r101.setShouldUseNewWebView(r105);     // Catch: Exception -> L67
        r101.setInterceptFlag(r100.optInt(JsonKey.INTERCEPT_FLAG));     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.ENABLE_SHOW_COMPLIANCE_DIALOG, 1) != 1) goto L21;
        boolean r106 = true;
    L22:
        r101.setEnableShowComplianceDialog(r106);     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.AUTO_DOWNLOAD_ON_CARD_SHOW) != 1) goto L25;
        boolean r107 = true;
    L26:
        r101.setIsAutoDownloadOnCardShow(r107);     // Catch: Exception -> L67
        if (r100.optInt("enable_new_activity", 1) != 1) goto L29;
        boolean r108 = true;
    L30:
        r101.setEnableNewActivity(r108);     // Catch: Exception -> L67
        if (r100.optInt("enable_ah", 1) != 1) goto L33;
        boolean r109 = true;
    L34:
        r101.setEnableAH(r109);     // Catch: Exception -> L67
        if (r100.optInt("enable_am", 1) != 1) goto L37;
        boolean r110 = true;
    L38:
        r101.setEnableAM(r110);     // Catch: Exception -> L67
        r101.setExtraJson(r100.optJSONObject("extra"));     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.ENABLE_COMPLIANCE_DIALOG_IN_FEED, 1) != 1) goto L41;
        boolean r111 = true;
    L42:
        r101.setEnableShowComplianceDialogInFeed(r111);     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.ENABLE_OPPO_AUTO_DOWNLOAD, 1) != 1) goto L45;
        boolean r112 = true;
    L46:
        r101.setEnableOppoAutoDownload(r112);     // Catch: Exception -> L67
        if (r100.optInt("enable_download_handler_taskkey", 1) != 1) goto L49;
        boolean r113 = true;
    L50:
        r101.setEnableDownloadHandlerTaskKey(r113);     // Catch: Exception -> L67
        if (r100.optInt("enable_click_start_opt_for_game_union", 0) != 1) goto L53;
        boolean r114 = true;
    L54:
        r101.setEnableClickStartOptForGameUnion(r114);     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.ENABLE_SPECIAL_SHOW_COMPLIANCE_DIALOG, 0) != 1) goto L57;
        boolean r115 = true;
    L58:
        r101.setEnableSpecialShowComplianceDialog(r115);     // Catch: Exception -> L67
        if (r100.optInt(JsonKey.DEFAULT_CONTROLLER_SIGN, 0) != 1) goto L61;
        boolean r116 = true;
    L62:
        r101.setDefaultControllerSign(r116);     // Catch: Exception -> L67
        if (r100.optInt("is_order_download", 0) != 1) goto L65;
        r102 = true;
    L65:
        r101.setIsOrderDownload(r102);     // Catch: Exception -> L67
    L70:
        return r101.build();
    L61:
        r116 = false;
        goto L62
    L57:
        r115 = false;
        goto L58
    L53:
        r114 = false;
        goto L54
    L49:
        r113 = false;
        goto L50
    L45:
        r112 = false;
        goto L46
    L41:
        r111 = false;
        goto L42
    L37:
        r110 = false;
        goto L38
    L33:
        r109 = false;
        goto L34
    L29:
        r108 = false;
        goto L30
    L25:
        r107 = false;
        goto L26
    L21:
        r106 = false;
        goto L22
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
    L67:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "AdDownloadController fromJson");
        goto L70
    }

    public void setBizParamsJson(String r100) {
        this.bizParamsJson = r100;
    }

    public void setCertId(String r100) {
        this.certId = r100;
    }

    public void setDefaultControllerSign(boolean r100) {
        this.mDefaultControllerSign = r100;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setDownloadMode(int r100) {
        this.mDownloadMode = r100;
    }

    public void setEnableBackDialog(boolean r100) {
        this.mIsEnableBackDialog = r100;
    }

    public void setEnableClickStartOptForGameUnion(boolean r100) {
        this.mEnableClickStartOptForGameUnion = r100;
    }

    public void setEnableDownloadHandlerTaskKey(boolean r100) {
        this.mEnableDownloadHandlerTaskKey = r100;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean r100) {
        this.mEnableNewActivity = r100;
    }

    public void setEnableOppoAutoDownload(boolean r100) {
        this.mEnableOppoAutoDownload = r100;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean r100) {
        this.mEnableShowComplianceDialog = r100;
    }

    public void setEnableShowComplianceDialogInFeed(boolean r100) {
        this.mEnableShowComplianceDialogInFeed = r100;
    }

    public void setEnableSpecialShowComplianceDialog(boolean r100) {
        this.mEnableSpecialShowComplianceDialog = r100;
    }

    public void setExtraJson(JSONObject r100) {
        this.mExtraJson = r100;
    }

    public void setExtraObject(Object r100) {
        this.mExtraObject = r100;
    }

    public void setIsAutoDownloadOnCardShow(boolean r100) {
        this.mIsAutoDownloadOnCardShow = r100;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setLinkMode(int r100) {
        this.mLinkMode = r100;
    }
}
