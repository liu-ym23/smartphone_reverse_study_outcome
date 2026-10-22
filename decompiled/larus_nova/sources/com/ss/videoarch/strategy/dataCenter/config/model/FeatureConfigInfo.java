package com.ss.videoarch.strategy.dataCenter.config.model;

import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class FeatureConfigInfo {
    public static final String ANCHOR_PROFILE_FEATURE_TYPE_ID = "ANCHOR";
    public static final String CLOUD_CONFIG_FEATURE_TYPE_ID = "CLOUD";
    public static final String DEVICE_FEATURE_TYPE_ID = "DEVICE";
    public static final String NETWORK_FEATURE_TYPE_ID = "NETWORK";
    public static final String PLAY_FEATURE_TYPE_ID = "PLAY";
    public static final String PUSH_FEATURE_TYPE_ID = "PUSH";
    private static final String TAG = "FeatureConfigInfo";
    public static final String UNKNOWN_FEATURE_TYPE_ID = "UNKNOWN";
    public static final String USER_PROFILE_FEATURE_TYPE_ID = "USER";
    public JSONObject mDefaultFeaturesCollectRules;
    public JSONArray mDefaultFeaturesList;
    public JSONArray mDefaultRTFeaturesList;
    public String mFeatureTypeName;
    public JSONObject mFeaturesCollectRules;
    public JSONArray mFeaturesList;
    public JSONArray mRTFeaturesList;
    public String mRTFeaturesStr;

    public FeatureConfigInfo() {
        this.mFeatureTypeName = "";
        this.mFeaturesList = null;
        this.mDefaultFeaturesList = null;
        this.mRTFeaturesList = null;
        this.mDefaultRTFeaturesList = null;
        this.mRTFeaturesStr = "";
        this.mFeaturesCollectRules = null;
        this.mDefaultFeaturesCollectRules = null;
    }

    public void _initSettingsConfig() {
        if (LSSettings.inst().mFeatureConfigJSON != null) goto L5;
        return;
    L5:
        if (LSSettings.inst().mFeatureConfigJSON.has(this.mFeatureTypeName) == false) goto L24;
        JSONObject r100 = LSSettings.inst().mFeatureConfigJSON.optJSONObject(this.mFeatureTypeName);
        if (r100 != null) goto L9;
        this.mFeaturesList = this.mDefaultFeaturesList;
        this.mFeaturesCollectRules = this.mDefaultFeaturesCollectRules;
        return;
    L9:
        if (r100.has("FeatureList") == false) goto L11;
        this.mFeaturesList = r100.optJSONArray("FeatureList");
    L13:
        if (r100.has("RTFeatureList") == false) goto L15;
        this.mRTFeaturesList = r100.optJSONArray("RTFeatureList");
    L16:
        JSONArray r101 = this.mRTFeaturesList;
        if (r101 == null) goto L20;
        this.mRTFeaturesStr = r101.toString();
    L20:
        if (r100.has("FeaturesCollectRules") == false) goto L22;
        this.mFeaturesCollectRules = r100.optJSONObject("FeaturesCollectRules");
        return;
    L22:
        this.mFeaturesCollectRules = this.mDefaultFeaturesCollectRules;
        return;
    L15:
        this.mRTFeaturesList = this.mDefaultRTFeaturesList;
        goto L16
    L11:
        this.mFeaturesList = this.mDefaultFeaturesList;
        goto L13
    L24:
        this.mFeaturesList = this.mDefaultFeaturesList;
        this.mFeaturesCollectRules = this.mDefaultFeaturesCollectRules;
    }

    public void initSettingsConfig() {
        if (LSSettings.inst().mEnableSettingsMgrChar == 1) goto L5;
        _initSettingsConfig();
        return;
    L5:
        if (LSSettings.inst().mFeatureConfigJSON != null) goto L7;
        return;
    L7:
        SettingsManager.getInstance().getFeatureConfig(String.valueOf(LSSettings.inst().mFeatureConfigJSON), this);
    }

    public static String getFeatureType(String r100) {
        String r101 = "UNKNOWN";
        if (r100 == null) goto L8;
        int r102 = r100.indexOf("-");
        if (r102 <= 0) goto L8;
        r101 = r100.substring(0, r102);
    L8:
        return r101;
    }
}
