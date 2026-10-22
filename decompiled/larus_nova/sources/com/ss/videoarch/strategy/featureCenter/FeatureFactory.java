package com.ss.videoarch.strategy.featureCenter;

import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
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
public class FeatureFactory {
    private static final String TAG = "FeatureFactory";
    private static volatile FeatureFactory sInstance;

    public FeatureFactory() {
    }

    public static FeatureFactory inst() {
        if (sInstance != null) goto L15;
        monitor-enter(FeatureFactory.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new FeatureFactory();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FeatureFactory.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static JSONObject FeatureList2FeatureBundle(JSONArray r110) {
        JSONObject r100 = new JSONObject();
        JSONArray r101 = new JSONArray();
        JSONArray r102 = new JSONArray();
        JSONArray r103 = new JSONArray();
        JSONArray r104 = new JSONArray();
        JSONArray r105 = new JSONArray();
        JSONArray r106 = new JSONArray();
        JSONArray r107 = new JSONArray();
        JSONArray r108 = new JSONArray();
        JSONArray r111 = new JSONArray();
        JSONArray r112 = new JSONArray();
        int r113 = 0;
    L4:
        if (r113 < r110.length()) goto L86;
        r100.put("PlayFeaturesBundle", r101).put("RTPlayFeaturesBundle", r102).put("NetworkFeaturesBundle", r103).put("RTNetworkFeaturesBundle", r104).put("DeviceFeaturesBundle", r105).put("RTDeviceFeaturesBundle", r106).put("UserFeaturesBundle", r107).put("RTUserFeaturesBundle", r108).put("PushFeaturesBundle", r111).put("RTPushFeaturesBundle", r112);     // Catch: JSONException -> L81
        r100.toString();     // Catch: JSONException -> L81
    L83:
        return r100;
    L81:
        e = move-exception;
        e.printStackTrace();
        goto L83
    L86:
        String r109 = JSONArrayProtectorUtils.getString(r110, r113);     // Catch: JSONException -> L76
        String r114 = FeatureConfigInfo.getFeatureType(r109);
        r114.getClass();
        byte r115 = -1;
        switch(r114.hashCode()) {
            case -1733499378: goto L31;
            case 2458420: goto L27;
            case 2467610: goto L23;
            case 2614219: goto L19;
            case 1934997173: goto L15;
            case 2013139542: goto L11;
            default: goto L34;
        };
    L34:
        switch(r115) {
            case 0: goto L69;
            case 1: goto L61;
            case 2: goto L53;
            case 3: goto L45;
            case 4: goto L45;
            case 5: goto L37;
            default: goto L78;
        };
    L37:
        if (TypeDeviceFeaturesCollector.inst().mFeatureConfigInfo != null) goto L39;
    L43:
        r105.put(r109);
        goto L78
    L39:
        if (TypeDeviceFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L43;
        if (TypeDeviceFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r109) == false) goto L43;
        r106.put(r109);
        goto L78
    L45:
        if (TypeUserProfileCollector.inst().mFeatureConfigInfo != null) goto L47;
    L51:
        r107.put(r109);
        goto L78
    L47:
        if (TypeUserProfileCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L51;
        if (TypeUserProfileCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r109) == false) goto L51;
        r108.put(r109);
        goto L78
    L53:
        if (TypePushFeaturesCollector.inst().mFeatureConfigInfo != null) goto L55;
    L59:
        r111.put(r109);
        goto L78
    L55:
        if (TypePushFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L59;
        if (TypePushFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r109) == false) goto L59;
        r112.put(r109);
        goto L78
    L61:
        if (TypePlayFeaturesCollector.inst().mFeatureConfigInfo != null) goto L63;
    L67:
        r101.put(r109);
        goto L78
    L63:
        if (TypePlayFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L67;
        if (TypePlayFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r109) == false) goto L67;
        r102.put(r109);
        goto L78
    L69:
        if (TypeNetworkFeaturesCollector.inst().mFeatureConfigInfo != null) goto L71;
    L75:
        r103.put(r109);
        goto L78
    L71:
        if (TypeNetworkFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr == null) goto L75;
        if (TypeNetworkFeaturesCollector.inst().mFeatureConfigInfo.mRTFeaturesStr.contains(r109) == false) goto L75;
        r104.put(r109);
    L78:
        r113 = r113 + 1;
        goto L4
    L11:
        if (r114.equals(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID) == false) goto L34;
        r115 = 5;
        goto L34
    L15:
        if (r114.equals(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID) == false) goto L34;
        r115 = 4;
        goto L34
    L19:
        if (r114.equals(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID) == false) goto L34;
        r115 = 3;
        goto L34
    L23:
        if (r114.equals(FeatureConfigInfo.PUSH_FEATURE_TYPE_ID) == false) goto L34;
        r115 = 2;
        goto L34
    L27:
        if (r114.equals(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID) == false) goto L34;
        r115 = 1;
        goto L34
    L31:
        if (r114.equals("NETWORK") == false) goto L34;
        r115 = 0;
    L76:
        e = move-exception;
        e.printStackTrace();
        goto L78
    }

    private JSONObject getIntExtraInfo(String r100) {
        int r101 = ((Integer) LSSettings.inst().getAppInfoForKey(r100, -1)).intValue();
        JSONObject r102 = new JSONObject();
        r102.put(r100, r101);     // Catch: JSONException -> L5
    L7:
        return r102;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    private JSONObject getStringExtraInfo(String r100) {
        String r101 = (String) LSSettings.inst().getAppInfoForKey(r100, "");
        if (r101.length() != 0) goto L10;
    L8:
        return null;
    L10:
        return new JSONObject(r101);
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void setFeature(int r100, JSONObject r101) {
        switch(r100) {
            case 60: goto L10;
            case 61: goto L8;
            case 62: goto L8;
            case 63: goto L5;
            default: goto L17;
        };
    L5:
        TypePlayFeaturesCollector.inst().setEventCallBackInfo(r100, r101);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDeviceFeatureData != 1) goto L14;
        TypeDeviceFeaturesCollector.inst().stopFpsCollect(r101);
        return;
    L14:
        return;
    L8:
        TypePlayFeaturesCollector.inst().setEventCallBackInfo(r100, r101);
        return;
    L17:
        return;
    L10:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDeviceFeatureData != 1) goto L12;
        TypeDeviceFeaturesCollector.inst().startFpsCollect(r101);
    L12:
        TypePlayFeaturesCollector.inst().setEventCallBackInfo(r100, r101);
    }

    public static String getFeatures(String r100, String r101, String r102) {
        String r103 = "";
        JSONArray r104 = new JSONArray(r100);     // Catch: Exception -> L8
        JSONObject r105 = inst().featureFetch(r104, r101, r102);     // Catch: Exception -> L8
        if (r105 == null) goto L6;
        r103 = r105.toString();     // Catch: Exception -> L8
    L6:
        Objects.toString(r105);     // Catch: Exception -> L8
    L10:
        return r103;
    L8:
        e = move-exception;
        e.getMessage();
        goto L10
    }

    public JSONObject featureFetch(JSONObject r110, String r111, String r112) {
        if (r110 != null) goto L5;
        return null;
    L5:
        JSONObject r100 = new JSONObject();
        JSONObject r101 = getStringExtraInfo("TTNet_NQE_INFO");
        JSONObject r102 = getIntExtraInfo("USER-HumanActivityRecognition");
        if (r110.has("PlayFeaturesBundle") == false) goto L13;
        JSONArray r103 = r110.optJSONArray("PlayFeaturesBundle");
        if (r103 == null) goto L13;
        if (r103.length() == 0) goto L13;
        TypePlayFeaturesCollector.inst().fillInputFeatures(r100, r103, r111, r112, r101);
    L13:
        if (r110.has("RTPlayFeaturesBundle") == false) goto L20;
        JSONArray r104 = r110.optJSONArray("RTPlayFeaturesBundle");
        if (r104 == null) goto L20;
        if (r104.length() == 0) goto L20;
        TypePlayFeaturesCollector.inst().fillInputRTFeatures(r100, r104, r111, r112, r101);
    L20:
        if (r110.has("NetworkFeaturesBundle") == false) goto L27;
        JSONArray r105 = r110.optJSONArray("NetworkFeaturesBundle");
        if (r105 == null) goto L27;
        if (r105.length() == 0) goto L27;
        TypeNetworkFeaturesCollector.inst().fillInputFeatures(r100, r105, r111, r112, r101);
    L27:
        if (r110.has("DeviceFeaturesBundle") == false) goto L34;
        JSONArray r106 = r110.optJSONArray("DeviceFeaturesBundle");
        if (r106 == null) goto L34;
        if (r106.length() == 0) goto L34;
        TypeDeviceFeaturesCollector.inst().fillInputFeatures(r100, r106, r111, r112, r101);
    L34:
        if (r110.has("UserFeaturesBundle") == false) goto L41;
        JSONArray r107 = r110.optJSONArray("UserFeaturesBundle");
        if (r107 == null) goto L41;
        if (r107.length() == 0) goto L41;
        TypeUserProfileCollector.inst().fillInputFeatures(r100, r107, r111, r112, r102);
    L41:
        if (r110.has("PushFeaturesBundle") == false) goto L47;
        JSONArray r108 = r110.optJSONArray("PushFeaturesBundle");
        if (r108 == null) goto L47;
        if (r108.length() == 0) goto L47;
        TypePushFeaturesCollector.inst().fillInputFeatures(r100, r108, r111, r112, r101);
    L47:
        r100.toString();
        return r100;
    }

    public JSONObject featureFetch(JSONArray r100, String r101, String r102) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        return featureFetch(FeatureList2FeatureBundle(r100), r101, r102);
    }
}
