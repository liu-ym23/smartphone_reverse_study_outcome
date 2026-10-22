package com.ss.videoarch.strategy.dataCenter.config.model;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeDeviceFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeNetworkFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePushFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeUserProfileCollector;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class StrategyConfigInfo {
    public String TAG;
    public JSONObject mDefaultFeatureSampleConfig;
    public JSONObject mDefaultGroundTruthRule;
    public JSONArray mDefaultInputFeatureList;
    public JSONArray mDefaultInputFeatures;
    public JSONObject mDefaultPredictRule;
    public JSONArray mDeviceFeaturesBundle;
    public int mEnable;
    public int mEnableByDolphin;
    public int mEnableCloudStrategy;
    public int mEnableSmartStrategy;
    public JSONObject mFeatureSampleConfig;
    public JSONObject mFeaturesBundle;
    public JSONObject mGroundTruthRule;
    public JSONArray mInputFeatureList;
    public JSONObject mInputSettingsParam;
    public JSONArray mLastInputFeatureList;
    public JSONArray mNetworkFeaturesBundle;
    public String mPitayaABPackageName;
    public JSONArray mPlayFeaturesBundle;
    public JSONArray mPushFeaturesBundle;
    public JSONArray mRTDeviceFeaturesBundle;
    public JSONArray mRTNetworkFeaturesBundle;
    public JSONArray mRTPlayFeaturesBundle;
    public JSONArray mRTPushFeaturesBundle;
    public JSONArray mRTUserFeaturesBundle;
    public long mStrategyID;
    public String mStrategyName;
    public JSONArray mUserFeaturesBundle;

    public StrategyConfigInfo() {
        this.TAG = "StrategyConfigInfo";
        this.mStrategyName = "";
        this.mStrategyID = 0;
        this.mPitayaABPackageName = "none";
        this.mEnable = -1;
        this.mEnableSmartStrategy = -1;
        this.mEnableCloudStrategy = -1;
        this.mInputSettingsParam = null;
        this.mLastInputFeatureList = null;
        this.mInputFeatureList = null;
        this.mFeatureSampleConfig = null;
        this.mGroundTruthRule = null;
        this.mDefaultInputFeatureList = null;
        this.mDefaultInputFeatures = null;
        this.mDefaultPredictRule = null;
        this.mDefaultGroundTruthRule = null;
        this.mDefaultFeatureSampleConfig = null;
        this.mEnableByDolphin = -1;
        this.mFeaturesBundle = new JSONObject();
    }

    public void initSettingsConfig() {
        if (LSSettings.inst().mStrategyConfigJSON == null) goto L22;
        if (LSSettings.inst().mStrategyConfigJSON.has(this.mStrategyName) == false) goto L20;
        JSONObject r100 = LSSettings.inst().mStrategyConfigJSON.optJSONObject(this.mStrategyName);
        if (r100 != null) goto L9;
        this.mInputFeatureList = this.mDefaultInputFeatureList;
        this.mFeatureSampleConfig = this.mDefaultFeatureSampleConfig;
        goto L22
    L9:
        if (r100.has("StrategyID") == false) goto L11;
        this.mStrategyID = r100.optLong("StrategyID");
    L11:
        this.mEnable = r100.optInt("Enable");
        this.mEnableSmartStrategy = r100.optInt("EnableSmartStrategyConfig");
        this.mEnableCloudStrategy = r100.optInt("EnableCloudStrategyModel");
        this.mInputSettingsParam = r100.optJSONObject("InputSettingsParam");
        if (r100.has("FeatureSampleConfig") == false) goto L14;
        this.mFeatureSampleConfig = r100.optJSONObject("FeatureSampleConfig");
    L15:
        this.mGroundTruthRule = r100.optJSONObject("GroundTruthRule");
        if (r100.has("InputFeatureList") == false) goto L18;
        this.mInputFeatureList = r100.optJSONArray("InputFeatureList");
        goto L22
    L18:
        this.mInputFeatureList = this.mDefaultInputFeatureList;
        goto L22
    L14:
        this.mFeatureSampleConfig = this.mDefaultFeatureSampleConfig;
        goto L15
    L20:
        this.mInputFeatureList = this.mDefaultInputFeatureList;
        this.mFeatureSampleConfig = this.mDefaultFeatureSampleConfig;
    L22:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPitayaABSettingsJSON != null) goto L24;
    L30:
        Objects.toString(this.mInputFeatureList);
        JSONArray r101 = this.mInputFeatureList;
        if (r101 != null) goto L34;
        return;
    L34:
        if (this.mLastInputFeatureList != null) goto L36;
    L38:
        this.mLastInputFeatureList = this.mInputFeatureList;
        this.mPlayFeaturesBundle = new JSONArray();
        this.mRTPlayFeaturesBundle = new JSONArray();
        this.mNetworkFeaturesBundle = new JSONArray();
        this.mRTNetworkFeaturesBundle = new JSONArray();
        this.mDeviceFeaturesBundle = new JSONArray();
        this.mRTDeviceFeaturesBundle = new JSONArray();
        this.mUserFeaturesBundle = new JSONArray();
        this.mRTUserFeaturesBundle = new JSONArray();
        this.mPushFeaturesBundle = new JSONArray();
        this.mRTPushFeaturesBundle = new JSONArray();
        int r102 = 0;
    L40:
        if (r102 >= this.mInputFeatureList.length()) goto L121;
        String r103 = JSONArrayProtectorUtils.getString(this.mInputFeatureList, r102);     // Catch: JSONException -> L111
        String r104 = FeatureConfigInfo.getFeatureType(r103);
        r104.getClass();
        byte r105 = -1;
        switch(r104.hashCode()) {
            case -1733499378: goto L66;
            case 2458420: goto L62;
            case 2467610: goto L58;
            case 2614219: goto L54;
            case 1934997173: goto L50;
            case 2013139542: goto L46;
            default: goto L69;
        };
    L69:
        switch(r105) {
            case 0: goto L104;
            case 1: goto L96;
            case 2: goto L88;
            case 3: goto L80;
            case 4: goto L80;
            case 5: goto L72;
            default: goto L113;
        };
    L72:
        if (TypeDeviceFeaturesCollector.inst().mFeatureConfigInfo != null) goto L74;
    L78:
        this.mDeviceFeaturesBundle.put(r103);
        goto L113
    L74:
        if (TypeDeviceFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L78;
        if (TypeDeviceFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r103) == false) goto L78;
        this.mRTDeviceFeaturesBundle.put(r103);
        goto L113
    L80:
        if (TypeUserProfileCollector.inst().mFeatureConfigInfo != null) goto L82;
    L86:
        this.mUserFeaturesBundle.put(r103);
        goto L113
    L82:
        if (TypeUserProfileCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L86;
        if (TypeUserProfileCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r103) == false) goto L86;
        this.mRTUserFeaturesBundle.put(r103);
        goto L113
    L88:
        if (TypePushFeaturesCollector.inst().mFeatureConfigInfo != null) goto L90;
    L94:
        this.mPushFeaturesBundle.put(r103);
        goto L113
    L90:
        if (TypePushFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L94;
        if (TypePushFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r103) == false) goto L94;
        this.mRTPushFeaturesBundle.put(r103);
        goto L113
    L96:
        if (TypePlayFeaturesCollector.inst().mFeatureConfigInfo != null) goto L98;
    L102:
        this.mPlayFeaturesBundle.put(r103);
        goto L113
    L98:
        if (TypePlayFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L102;
        if (TypePlayFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r103) == false) goto L102;
        this.mRTPlayFeaturesBundle.put(r103);
        goto L113
    L104:
        if (TypeNetworkFeaturesCollector.inst().mFeatureConfigInfo != null) goto L106;
    L110:
        this.mNetworkFeaturesBundle.put(r103);
        goto L113
    L106:
        if (TypeNetworkFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L110;
        if (TypeNetworkFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r103) == false) goto L110;
        this.mRTNetworkFeaturesBundle.put(r103);
    L113:
        r102 = r102 + 1;
        goto L40
    L46:
        if (r104.equals(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID) == false) goto L69;
        r105 = 5;
        goto L69
    L50:
        if (r104.equals(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID) == false) goto L69;
        r105 = 4;
        goto L69
    L54:
        if (r104.equals(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID) == false) goto L69;
        r105 = 3;
        goto L69
    L58:
        if (r104.equals(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID) == false) goto L69;
        r105 = 2;
        goto L69
    L62:
        if (r104.equals(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID) == false) goto L69;
        r105 = 1;
        goto L69
    L66:
        if (r104.equals("NETWORK") == false) goto L69;
        r105 = 0;
    L111:
        e = move-exception;
        e.printStackTrace();
        goto L113
    L121:
        this.mFeaturesBundle.put("PlayFeaturesBundle", this.mPlayFeaturesBundle).put("RTPlayFeaturesBundle", this.mRTPlayFeaturesBundle).put("NetworkFeaturesBundle", this.mNetworkFeaturesBundle).put("RTNetworkFeaturesBundle", this.mRTNetworkFeaturesBundle).put("DeviceFeaturesBundle", this.mDeviceFeaturesBundle).put("RTDeviceFeaturesBundle", this.mRTDeviceFeaturesBundle).put("UserFeaturesBundle", this.mUserFeaturesBundle).put("RTUserFeaturesBundle", this.mRTUserFeaturesBundle).put("PushFeaturesBundle", this.mPushFeaturesBundle).put("RTPushFeaturesBundle", this.mRTPushFeaturesBundle);     // Catch: JSONException -> L116
        Objects.toString(this.mFeaturesBundle);     // Catch: JSONException -> L116
        return;
    L116:
        e = move-exception;
        e.printStackTrace();
        return;
    L36:
        if (r101.toString().equals(this.mLastInputFeatureList.toString()) == false) goto L38;
        return;
    L24:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPitayaABSettingsJSON.has(this.mStrategyName) == false) goto L30;
        JSONObject r106 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPitayaABSettingsJSON.optJSONObject(this.mStrategyName);
        if (r106 == null) goto L30;
        if (r106.has("package_name") == false) goto L30;
        this.mPitayaABPackageName = r106.optString("package_name");
        goto L30
    }
}
