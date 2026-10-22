package com.ss.videoarch.strategy.featureCenter.featureType;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.ConfigTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.DataWarehouse;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.ConfigCacheInfo;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TypeUserProfileCollector extends BaseTypeFeaturesCollector {
    private static volatile TypeUserProfileCollector sInstance;
    private final String TAG;
    private JSONObject mOfflineFeatures;
    private JSONObject mUserProfileFeature;

    public static TypeUserProfileCollector inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TypeUserProfileCollector.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TypeUserProfileCollector();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TypeUserProfileCollector.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TypeUserProfileCollector() {
        this.TAG = "UserProfileCollector";
        this.mTypeKey = "TypeUserProfileFeature";
        FeatureConfigInfo r100 = this.mFeatureConfigInfo;
        if (r100 == null) goto L6;
        r100.mFeatureTypeName = "TypeUserProfileFeature";
        return;
    }

    public void updateOfflineFeatures() {
        String r100 = DataWarehouse.getOfflineFeatures();
        if (r100.isEmpty() == true) goto L11;
        this.mOfflineFeatures = new JSONObject(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.getMessage();
        return;
    }

    private Number convertStringToNumber(String r100) {
    L8:
        e = move-exception;
        e.printStackTrace();
        return -1;
    L4:
        if (r100.contains(".") == false) goto L6;
        Number r101 = Double.valueOf(CastDoubleProtector.parseDouble(r100));     // Catch: NumberFormatException -> L8
    L12:
        return r101;
    L6:
        r101 = Integer.valueOf(CastIntegerProtector.parseInt(r100));     // Catch: NumberFormatException -> L8
        goto L12
    }

    public void updateUserProfile(JSONObject r100) {
        this.mUserProfileFeature = r100;
        if (r100 != null) goto L5;
        return;
    L5:
        if (LSSettings.inst().mPersistenceConfigInfo.mConfigTableEnable != 1) goto L9;
        ArrayList r101 = new ArrayList();
        ConfigCacheInfo r102 = new ConfigCacheInfo();
        r102.mSettingsName = "UserProfile";
        r102.mSettingsValue = this.mUserProfileFeature.toString();
        r101.add(r102);
        ConfigTableOperate.addSettingsConfigToDB(r101);
        return;
    }

    @Override // com.ss.videoarch.strategy.featureCenter.featureType.BaseTypeFeaturesCollector
    public JSONObject fillInputFeatures(JSONObject r210, JSONArray r211, String r212, String r310, JSONObject r311) {
        TypeUserProfileCollector r100 = this;
        String r101 = "push_day_7d";
        String r110 = "user_activeness";
        String r111 = "play_cnt";
        String r213 = "high_value_anchor";
        JSONObject r102 = r100.mUserProfileFeature;
        if (r102 != null) goto L5;
        return r210;
    L5:
        String r312 = "high_value_user";
        if (r102.has("PlayerFeatureParam") == false) goto L209;
        String r112 = "definition_preference";
        if (r100.mUserProfileFeature.has("AnchorFeatureParam") == false) goto L209;
        String r113 = "watch_activeness_l1";
        Map<String, Object> r114 = LSSettings.inst().mUserParams;
        Map<String, Object> r115 = r114;
        Map<String, Object> r116 = LSSettings.inst().mAnchorParams;
        JSONObject r117 = r100.mUserProfileFeature.optJSONObject("PlayerFeatureParam");
        JSONObject r118 = r100.mUserProfileFeature.optJSONObject("AnchorFeatureParam");
        Map<String, Object> r214 = r116;
        int r119 = 0;
    L12:
        if (r119 >= r211.length()) goto L209;
        String r215 = r111;
        String r103 = r211.optString(r119);
        int r216 = r119;
        String r217 = r110;
        switch(r103.hashCode()) {
            case -1874363628: goto L64;
            case -1586779251: goto L61;
            case -304104001: goto L58;
            case -272178482: goto L55;
            case -11100574: goto L52;
            case 4193615: goto L49;
            case 22974109: goto L46;
            case 237476505: goto L43;
            case 253129591: goto L40;
            case 676395323: goto L37;
            case 1030322897: goto L34;
            case 1554438000: goto L31;
            case 1618464440: goto L28;
            case 1630417628: goto L25;
            case 1825336871: goto L22;
            case 2097480599: goto L218;
            default: goto L68;
        };
    L68:
        byte r120 = -1;
    L69:
        switch(r120) {
            case 0: goto L162;
            case 1: goto L150;
            case 2: goto L138;
            case 3: goto L129;
            case 4: goto L120;
            case 5: goto L112;
            case 6: goto L108;
            case 7: goto L104;
            case 8: goto L100;
            case 9: goto L96;
            case 10: goto L92;
            case 11: goto L88;
            case 12: goto L84;
            case 13: goto L78;
            case 14: goto L74;
            case 15: goto L73;
            default: goto L70;
        };
    L70:
        String r104 = r312;
        r113 = r113;
        r111 = r215;
        r110 = r217;
        r112 = r112;
        String r121 = r101;
        String[] r105 = r103.split("-", 2);     // Catch: JSONException -> L199
        r312 = r104;
        if (r105.length == 2) goto L232;
    L167:
        r214 = r214;
    L208:
        r214 = r214;
        r101 = r121;
        r112 = r112;
        r100 = this;
        r113 = r113;
        r119 = r216 + 1;
        goto L12
    L232:
        String r106 = r105[0];     // Catch: JSONException -> L197
        String r107 = r105[1].toLowerCase();     // Catch: JSONException -> L197
        if (r106.equals(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID) == false) goto L187;
        Map<String, Object> r108 = r115;
    L185:
        e = e;
        r115 = r108;
    L201:
        r214 = r214;
    L207:
        e.printStackTrace();
        goto L208
    L180:
        if (r108.containsKey(r107) == false) goto L183;
        r210.put(r103, r108.get(r107));     // Catch: JSONException -> L185
        r115 = r108;
        goto L167
    L183:
        r115 = r108;
    L184:
        r214 = r214;
    L226:
        r210.put(r103, "none");     // Catch: JSONException -> L195
    L195:
        e = e;
        goto L207
    L187:
        if (r106.equals(FeatureConfigInfo.ANCHOR_PROFILE_FEATURE_TYPE_ID) == false) goto L184;
        r214 = r214;
        if (r214.containsKey(r107) == false) goto L226;
        r210.put(r103, r214.get(r107));     // Catch: JSONException -> L195
    L197:
        e = e;
    L199:
        e = e;
    L200:
        r312 = r104;
        goto L201
    L73:
        r210.put(r103, LSSettings.inst().getAppInfoForKey("USER-LandScapeSwitch", -1));     // Catch: JSONException -> L66
    L109:
        r111 = r215;
        r110 = r217;
    L133:
        r121 = r101;
        goto L208
    L74:
        int r122 = -1;
        if (r311 == 0) goto L77;
        r122 = r311.optInt("USER-HumanActivityRecognition", -1);     // Catch: JSONException -> L66
    L77:
        r210.put(r103, r122);     // Catch: JSONException -> L66
        goto L109
    L78:
        JSONObject r123 = r100.mOfflineFeatures;     // Catch: JSONException -> L66
        if (r123 == null) goto L81;
        int r124 = r123.optInt(r103, -1);     // Catch: JSONException -> L66
    L82:
        r210.put(r103, r124);     // Catch: JSONException -> L66
        goto L109
    L81:
        r124 = -1;
        goto L82
    L112:
        r110 = r217;
    L118:
        e = e;
    L204:
        r111 = r215;
    L206:
        r121 = r101;
        goto L207
    L114:
        if (r117.has(r110) == true) goto L116;
    L115:
        r111 = r215;
        goto L133
    L116:
        r210.put(r103, r100.convertStringToNumber(r117.optString(r110)).intValue());     // Catch: JSONException -> L118
        goto L115
    L120:
        r110 = r217;
        r111 = r215;
    L127:
        e = e;
        goto L206
    L122:
        if (r117.has(r111) == false) goto L133;
        r210.put(r103, r100.convertStringToNumber(r117.optString(r111)).intValue());     // Catch: JSONException -> L127
        goto L133
    L129:
        r111 = r215;
        r110 = r217;
        r113 = r113;
    L136:
        e = e;
        r214 = r214;
        goto L206
    L131:
        if (r117.has(r113) == true) goto L134;
    L132:
        r214 = r214;
        goto L133
    L134:
        r210.put(r103, r100.convertStringToNumber(r117.optString(r113)).intValue());     // Catch: JSONException -> L136
        goto L132
    L138:
        r113 = r113;
        r111 = r215;
        r110 = r217;
        String r109 = r112;
        if (r117.has(r109) == true) goto L142;
        r112 = r109;
        r121 = r101;
        goto L167
    L142:
        r121 = r101;
        r210.put(r103, r100.convertStringToNumber(r117.optString(r109)).intValue());     // Catch: JSONException -> L145
        r112 = r109;
    L145:
        e = e;
    L149:
        r112 = r109;
    L147:
        e = e;
        r121 = r101;
        goto L149
    L150:
        String r125 = r112;
        r113 = r113;
        r111 = r215;
        r110 = r217;
        r121 = r101;
        String r126 = r213;
        if (r117.has(r126) == true) goto L154;
        r112 = r125;
    L166:
        r213 = r126;
        goto L167
    L154:
        r112 = r125;
        r210.put(r103, r100.convertStringToNumber(r117.optString(r126)).intValue());     // Catch: JSONException -> L157
    L157:
        e = e;
    L161:
        r213 = r126;
    L159:
        e = e;
        r112 = r125;
        goto L161
    L162:
        r113 = r113;
        r111 = r215;
        r110 = r217;
        r112 = r112;
        r121 = r101;
        r126 = r213;
        r104 = r312;
        if (r117.has(r104) == true) goto L168;
        r312 = r104;
        goto L166
    L168:
        r213 = r126;
        r210.put(r103, r100.convertStringToNumber(r117.optString(r104)).intValue());     // Catch: JSONException -> L199
        r312 = r104;
    L170:
        e = e;
        r213 = r126;
        goto L200
    L84:
        if (r118.has(r101) == false) goto L109;
        r210.put(r103, r100.convertStringToNumber(r118.optString(r101)).intValue());     // Catch: JSONException -> L66
        goto L109
    L88:
        if (r117.has("stream_cnt") == false) goto L109;
        r210.put(r103, r100.convertStringToNumber(r117.optString("stream_cnt")).intValue());     // Catch: JSONException -> L66
        goto L109
    L92:
        if (r117.has("play_time_30days_sum") == false) goto L109;
        r210.put(r103, r100.convertStringToNumber(r117.optString("play_time_30days_sum")).intValue());     // Catch: JSONException -> L66
        goto L109
    L96:
        if (r117.has("first_frame_tolerance") == false) goto L109;
        r210.put(r103, r100.convertStringToNumber(r117.optString("first_frame_tolerance")).intValue());     // Catch: JSONException -> L66
        goto L109
    L100:
        if (r117.has("low_resolution_avoid") == false) goto L109;
        r210.put(r103, r100.convertStringToNumber(r117.optString("low_resolution_avoid")).doubleValue());     // Catch: JSONException -> L66
        goto L109
    L104:
        if (r117.has("lagging_sensitivity") == false) goto L109;
        r210.put(r103, r100.convertStringToNumber(r117.optString("lagging_sensitivity")).doubleValue());     // Catch: JSONException -> L66
        goto L109
    L108:
        if (r117.has("valid_days") == false) goto L109;
        r210.put(r103, r100.convertStringToNumber(r117.optString("valid_days")).intValue());     // Catch: JSONException -> L66
        goto L109
    L218:
        if (r103.equals("USER-LowResolutionAvoid") == false) goto L68;
        r120 = 8;
    L66:
        e = e;
        r111 = r215;
        r110 = r217;
        goto L206
    L22:
        if (r103.equals("USER-StreamCnt") == false) goto L68;
        r120 = 11;
        goto L69
    L25:
        if (r103.equals("USER-PlayTimeIn30Days") == false) goto L68;
        r120 = 10;
        goto L69
    L28:
        if (r103.equals("USER-HighValueUser") == false) goto L68;
        r120 = 0;
        goto L69
    L31:
        if (r103.equals("USER-DefinitionPreference") == false) goto L68;
        r120 = 2;
        goto L69
    L34:
        if (r103.equals("USER-ValidDays") == false) goto L68;
        r120 = 6;
        goto L69
    L37:
        if (r103.equals("ANCHOR-pushIn7Days_offline") == false) goto L68;
        r120 = HTTP.CR;
        goto L69
    L40:
        if (r103.equals("ANCHOR-PushIn7Days") == false) goto L68;
        r120 = 12;
        goto L69
    L43:
        if (r103.equals("USER-PlayCount") == false) goto L68;
        r120 = 4;
        goto L69
    L46:
        if (r103.equals("USER-HumanActivityRecognition") == false) goto L68;
        r120 = 14;
        goto L69
    L49:
        if (r103.equals("USER-WatchActivenessL1") == false) goto L68;
        r120 = 3;
        goto L69
    L52:
        if (r103.equals("USER-HighValueAnchor") == false) goto L68;
        r120 = 1;
        goto L69
    L55:
        if (r103.equals("USER-FirstFrameTolerance") == false) goto L68;
        r120 = 9;
        goto L69
    L58:
        if (r103.equals("USER-Activeness") == false) goto L68;
        r120 = 5;
        goto L69
    L61:
        if (r103.equals("USER-LandScapeSwitch") == false) goto L68;
        r120 = 15;
        goto L69
    L64:
        if (r103.equals("USER-LaggingSensitivity") == false) goto L68;
        r120 = 7;
    L202:
        e = e;
        r216 = r119;
    L209:
        return r210;
    }
}
