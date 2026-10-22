package com.ss.android.downloadad.api.download;

import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.downloadlib.addownload.GlobalInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class AdDownloadEventConfig implements DownloadEventConfig {
    protected JSONObject mAdExtraDataObject;
    protected JSONObject mAppPkgInfo;
    protected String mClickButtonTag;
    protected String mClickContinueLabel;
    protected String mClickInstallLabel;
    protected String mClickItemTag;
    protected String mClickLabel;
    protected String mClickPauseLabel;
    protected String mClickStartLabel;
    protected boolean mDefaultEventConfigSign;
    protected int mDownloadScene;
    protected transient Object mExtraEventObject;
    protected JSONObject mExtraJson;
    protected boolean mHasShowPkgInfo;
    protected boolean mIsEnableClickEvent;
    protected boolean mIsEnableV3Event;
    protected JSONObject mParamsJson;
    protected String mRefer;
    protected String mStorageDenyLabel;

    public static final class Builder {
        AdDownloadEventConfig eventConfig;

        public Builder setClickContinueTag(String r100) {
            return this;
        }

        public Builder setClickInstallTag(String r100) {
            return this;
        }

        public Builder setClickOpenLabel(String r100) {
            return this;
        }

        public Builder setClickOpenTag(String r100) {
            return this;
        }

        public Builder setClickPauseTag(String r100) {
            return this;
        }

        public Builder setClickStartTag(String r100) {
            return this;
        }

        public Builder setClickTag(String r100) {
            return this;
        }

        public Builder setCompletedEventTag(String r100) {
            return this;
        }

        public Builder setDownloadFailedLabel(String r100) {
            return this;
        }

        public Builder setIsEnableCompletedEvent(boolean r100) {
            return this;
        }

        public Builder setIsEnableNoChargeClickEvent(boolean r100) {
            return this;
        }

        public Builder setOpenLabel(String r100) {
            return this;
        }

        public Builder setOpenTag(String r100) {
            return this;
        }

        public Builder setQuickAppEventTag(String r100) {
            return this;
        }

        public Builder setStorageDenyTag(String r100) {
            return this;
        }

        public Builder() {
            this.eventConfig = new AdDownloadEventConfig();
        }

        public AdDownloadEventConfig build() {
            return this.eventConfig;
        }

        public Builder hasShowPkgInfo(boolean r100) {
            this.eventConfig.mHasShowPkgInfo = r100;
            return this;
        }

        public Builder setAdExtraDataObject(JSONObject r100) {
            this.eventConfig.mAdExtraDataObject = r100;
            return this;
        }

        public Builder setAppPkgInfo(JSONObject r100) {
            this.eventConfig.mAppPkgInfo = r100;
            return this;
        }

        public Builder setClickButtonTag(String r100) {
            this.eventConfig.mClickButtonTag = r100;
            return this;
        }

        public Builder setClickContinueLabel(String r100) {
            this.eventConfig.mClickContinueLabel = r100;
            return this;
        }

        public Builder setClickInstallLabel(String r100) {
            this.eventConfig.mClickInstallLabel = r100;
            return this;
        }

        public Builder setClickItemTag(String r100) {
            this.eventConfig.mClickItemTag = r100;
            return this;
        }

        public Builder setClickLabel(String r100) {
            this.eventConfig.mClickLabel = r100;
            return this;
        }

        public Builder setClickPauseLabel(String r100) {
            this.eventConfig.mClickPauseLabel = r100;
            return this;
        }

        public Builder setClickStartLabel(String r100) {
            this.eventConfig.mClickStartLabel = r100;
            return this;
        }

        public Builder setDefaultEventConfigSign(boolean r100) {
            this.eventConfig.mDefaultEventConfigSign = r100;
            return this;
        }

        public Builder setDownloadScene(int r100) {
            this.eventConfig.mDownloadScene = r100;
            return this;
        }

        public Builder setExtraEventObject(Object r100) {
            this.eventConfig.mExtraEventObject = r100;
            return this;
        }

        public Builder setExtraJson(JSONObject r100) {
            this.eventConfig.mExtraJson = r100;
            return this;
        }

        public Builder setIsEnableClickEvent(boolean r100) {
            this.eventConfig.mIsEnableClickEvent = r100;
            return this;
        }

        public Builder setIsEnableV3Event(boolean r100) {
            this.eventConfig.mIsEnableV3Event = r100;
            return this;
        }

        public Builder setParamsJson(JSONObject r100) {
            this.eventConfig.mParamsJson = r100;
            return this;
        }

        public Builder setRefer(String r100) {
            this.eventConfig.mRefer = r100;
            return this;
        }

        public Builder setStorageDenyLabel(String r100) {
            this.eventConfig.mStorageDenyLabel = r100;
            return this;
        }
    }

    public interface JsonKey {
        public static final String AD_EXTRA_DATA_OBJECT = "ad_extra_data_object";
        public static final String APP_PKG_INFO = "app_pkg_info";
        public static final String CLICK_BTN_TAG = "click_button_tag";
        public static final String CLICK_CONTINUE_LABEL = "click_continue_label";
        public static final String CLICK_INSTALL_LABEL = "click_install_label";
        public static final String CLICK_ITEM_TAG = "click_item_tag";
        public static final String CLICK_LABEL = "click_label";
        public static final String CLICK_PAUSE_LABEL = "click_pause_label";
        public static final String CLICK_START_LABEL = "click_start_label";
        public static final String DEFAULT_EVENT_CONFIG_SIGN = "default_event_config_sign";
        public static final String DOWNLOAD_SCENE = "download_scene";
        public static final String ENABLE_CLICK_EVENT = "enable_click_event";
        public static final String ENABLE_V3_EVENT = "enable_v3_event";
        public static final String EXTRA = "extra";
        public static final String EXTRA_EVENT_OBJECT = "extra_event_object";
        public static final String HAS_SHOWN_PKG_INFO = "has_shown_pkg_info";
        public static final String PARAMS_JSON = "params_json";
        public static final String REFER = "refer";
        public static final String STORAGE_DENY_LABEL = "storage_deny_label";
    }

    public void setQuickAppEventTag(String r100) {
    }

    public JSONObject toJson() {
        JSONObject r100 = new JSONObject();
        r100.putOpt(JsonKey.CLICK_BTN_TAG, this.mClickButtonTag);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.CLICK_ITEM_TAG, this.mClickItemTag);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.CLICK_LABEL, this.mClickLabel);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.CLICK_START_LABEL, this.mClickStartLabel);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.CLICK_CONTINUE_LABEL, this.mClickContinueLabel);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.CLICK_PAUSE_LABEL, this.mClickPauseLabel);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.CLICK_INSTALL_LABEL, this.mClickInstallLabel);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.STORAGE_DENY_LABEL, this.mStorageDenyLabel);     // Catch: Exception -> L21
        r100.putOpt("refer", this.mRefer);     // Catch: Exception -> L21
        r100.putOpt("download_scene", Integer.valueOf(this.mDownloadScene));     // Catch: Exception -> L21
        int r101 = 1;
        if (this.mIsEnableClickEvent == false) goto L6;
        int r102 = 1;
    L7:
        r100.putOpt(JsonKey.ENABLE_CLICK_EVENT, Integer.valueOf(r102));     // Catch: Exception -> L21
        if (this.mIsEnableV3Event == false) goto L10;
        int r103 = 1;
    L11:
        r100.putOpt(JsonKey.ENABLE_V3_EVENT, Integer.valueOf(r103));     // Catch: Exception -> L21
        r100.putOpt("extra", this.mExtraJson);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.PARAMS_JSON, this.mParamsJson);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.EXTRA_EVENT_OBJECT, this.mExtraEventObject);     // Catch: Exception -> L21
        r100.putOpt(JsonKey.AD_EXTRA_DATA_OBJECT, this.mAdExtraDataObject);     // Catch: Exception -> L21
        if (this.mHasShowPkgInfo == false) goto L14;
        int r104 = 1;
    L15:
        r100.putOpt("has_shown_pkg_info", Integer.valueOf(r104));     // Catch: Exception -> L21
        r100.putOpt("app_pkg_info", this.mAppPkgInfo);     // Catch: Exception -> L21
        if (this.mDefaultEventConfigSign == true) goto L19;
        r101 = 0;
    L19:
        r100.putOpt(JsonKey.DEFAULT_EVENT_CONFIG_SIGN, Integer.valueOf(r101));     // Catch: Exception -> L21
    L23:
        return r100;
    L14:
        r104 = 0;
        goto L15
    L10:
        r103 = 0;
        goto L11
    L6:
        r102 = 0;
    L21:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "AdDownloadEventConfig toJson");
        goto L23
    }

    public AdDownloadEventConfig() {
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
        this.mDefaultEventConfigSign = false;
    }

    public boolean defaultEventConfigSign() {
        return this.mDefaultEventConfigSign;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getAdExtraDataObject() {
        return this.mAdExtraDataObject;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getAppPkgInfo() {
        return this.mAppPkgInfo;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.mClickButtonTag;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.mClickContinueLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.mClickInstallLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return this.mClickItemTag;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.mClickLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.mClickPauseLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.mClickStartLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return this.mDownloadScene;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.mExtraEventObject;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return this.mParamsJson;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.mRefer;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.mStorageDenyLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean hasShowPkgInfo() {
        return this.mHasShowPkgInfo;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.mIsEnableClickEvent;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.mIsEnableV3Event;
    }

    public AdDownloadEventConfig(AdDownloadEventConfig r100) {
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
        this.mDefaultEventConfigSign = false;
        if (r100 != null) goto L5;
        return;
    L5:
        this.mClickButtonTag = r100.mClickButtonTag;
        this.mClickItemTag = r100.mClickItemTag;
        this.mClickLabel = r100.mClickLabel;
        this.mClickStartLabel = r100.mClickStartLabel;
        this.mClickPauseLabel = r100.mClickPauseLabel;
        this.mClickContinueLabel = r100.mClickContinueLabel;
        this.mClickInstallLabel = r100.mClickInstallLabel;
        this.mStorageDenyLabel = r100.mStorageDenyLabel;
        this.mDownloadScene = r100.mDownloadScene;
        this.mIsEnableClickEvent = r100.mIsEnableClickEvent;
        this.mIsEnableV3Event = r100.mIsEnableV3Event;
        this.mRefer = r100.mRefer;
        this.mExtraJson = r100.mExtraJson;
        this.mParamsJson = r100.mParamsJson;
        this.mHasShowPkgInfo = r100.mHasShowPkgInfo;
        this.mAppPkgInfo = r100.mAppPkgInfo;
    }

    public static AdDownloadEventConfig fromJson(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Builder r101 = new Builder();
        r101.setClickButtonTag(r100.optString(JsonKey.CLICK_BTN_TAG));     // Catch: Exception -> L23
        r101.setClickItemTag(r100.optString(JsonKey.CLICK_ITEM_TAG));     // Catch: Exception -> L23
        r101.setClickLabel(r100.optString(JsonKey.CLICK_LABEL));     // Catch: Exception -> L23
        r101.setClickStartLabel(r100.optString(JsonKey.CLICK_START_LABEL));     // Catch: Exception -> L23
        r101.setClickContinueLabel(r100.optString(JsonKey.CLICK_CONTINUE_LABEL));     // Catch: Exception -> L23
        r101.setClickPauseLabel(r100.optString(JsonKey.CLICK_PAUSE_LABEL));     // Catch: Exception -> L23
        r101.setClickInstallLabel(r100.optString(JsonKey.CLICK_INSTALL_LABEL));     // Catch: Exception -> L23
        r101.setStorageDenyLabel(r100.optString(JsonKey.STORAGE_DENY_LABEL));     // Catch: Exception -> L23
        r101.setRefer(r100.optString("refer"));     // Catch: Exception -> L23
        r101.setDownloadScene(r100.optInt("download_scene"));     // Catch: Exception -> L23
        boolean r102 = false;
        if (r100.optInt(JsonKey.ENABLE_CLICK_EVENT) != 1) goto L9;
        boolean r103 = true;
    L10:
        r101.setIsEnableClickEvent(r103);     // Catch: Exception -> L23
        if (r100.optInt(JsonKey.ENABLE_V3_EVENT) != 1) goto L13;
        boolean r104 = true;
    L14:
        r101.setIsEnableV3Event(r104);     // Catch: Exception -> L23
        r101.setExtraJson(r100.optJSONObject("extra"));     // Catch: Exception -> L23
        r101.setParamsJson(r100.optJSONObject(JsonKey.PARAMS_JSON));     // Catch: Exception -> L23
        r101.setExtraEventObject(r100.opt(JsonKey.EXTRA_EVENT_OBJECT));     // Catch: Exception -> L23
        if (r100.optInt("has_shown_pkg_info") != 1) goto L17;
        boolean r105 = true;
    L18:
        r101.hasShowPkgInfo(r105);     // Catch: Exception -> L23
        r101.setAppPkgInfo(r100.optJSONObject("app_pkg_info"));     // Catch: Exception -> L23
        if (r100.optInt(JsonKey.DEFAULT_EVENT_CONFIG_SIGN) != 1) goto L21;
        r102 = true;
    L21:
        r101.setDefaultEventConfigSign(r102);     // Catch: Exception -> L23
    L26:
        return r101.build();
    L17:
        r105 = false;
        goto L18
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
    L23:
        e = move-exception;
        GlobalInfo.getTTMonitor().monitorException(e, "AdDownloadEventConfig fromJson");
        goto L26
    }

    public void setClickButtonTag(String r100) {
        this.mClickButtonTag = r100;
    }

    public void setClickItemTag(String r100) {
        this.mClickItemTag = r100;
    }

    public void setDefaultEventConfigSign(boolean r100) {
        this.mDefaultEventConfigSign = r100;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int r100) {
        this.mDownloadScene = r100;
    }

    public void setExtraEventObject(Object r100) {
        this.mExtraEventObject = r100;
    }

    public void setExtraJson(JSONObject r100) {
        this.mExtraJson = r100;
    }

    public void setParamsJson(JSONObject r100) {
        this.mParamsJson = r100;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String r100) {
        this.mRefer = r100;
    }

    public void setExtraEventObject(JSONObject r100) {
        this.mAdExtraDataObject = r100;
    }
}
