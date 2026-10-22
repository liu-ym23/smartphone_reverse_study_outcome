package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class ProbeStartupBitrate extends BaseSmartStrategy {
    private static final String TAG = "ProbeStartupBitrate";
    private static volatile ProbeStartupBitrate sInstance;

    public static ProbeStartupBitrate inst() {
        if (sInstance != null) goto L15;
        monitor-enter(ProbeStartupBitrate.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ProbeStartupBitrate();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ProbeStartupBitrate.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ProbeStartupBitrate() {
        this.mStrategyName = "live_stream_strategy_startup_bitrate_predict";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_startup_bitrate_predict";
        r100.mDefaultInputFeatureList = new JSONArray().put("NETWORK-RecommendBitrate").put("PLAY-BitrateList");
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r210) {
        Objects.toString(r210);
        if (r210 != null) goto L5;
        return null;
    L5:
        if (this.mStrategyConfigInfo == null) goto L130;
        JSONObject r100 = new JSONObject();
        JSONObject r101 = this.mStrategyConfigInfo.mInputSettingsParam;
        if (r101 != null) goto L11;
        r101 = new JSONObject();
    L11:
        if (r101 == null) goto L13;
        double r102 = r101.optDouble("RecommendBitrateDownParameter", 0.75d);
        int r110 = r101.optInt("PreviewDecision", 0);
        int r111 = r101.optInt("KeepPlayerDecision", 0);
        double r103 = r101.optDouble("PreviewRecommendBitrateDownParameter", 0.75d);
        int r112 = r101.optInt("HorizontalDowngrade", 0);
        int r113 = r101.optInt("HarDesicion", 0);
        int r114 = r101.optInt("EnableFlvSpeed", 0);
    L15:
        if (r110 != 1) goto L22;
        int r104 = r210.optInt("PLAY-IsPreview", 0);
        if (r104 == 1) goto L19;
    L21:
        r103 = r102;
    L23:
        JSONObject r105 = r101.optJSONObject("DeviceLevelRecommendBitrateDiscountParam");
        int r115 = r104;
        double r106 = 1.0d;
        if (r105 == null) goto L28;
        String r116 = r210.optString("DEVICE-PhoneLevel", "");
        if (TextUtils.isEmpty(r116) == true) goto L28;
        r106 = r105.optDouble(r116, 1.0d);
    L28:
        int r107 = r210.optInt("NETWORK-RecommendBitrate", 0);
        int r117 = r210.optInt("PLAY-HistoryEstimatedBandwidth", 0);
        if (r107 > 0) goto L33;
        if (r117 <= 0) goto L33;
        r107 = r117;
    L33:
        if (r114 == 1) goto L35;
    L38:
        double r108 = r107;
    L39:
        int r109 = (int) ((r108 * r103) * r106);
        JSONObject r118 = r210.optJSONObject("PLAY-BitrateList");
        if (r118 == null) goto L110;
        if (r109 <= 0) goto L110;
        ArrayList r119 = new ArrayList();
        JSONObject r120 = r101.optJSONObject("NetworkLevelResolutionLimitMap");
        if (r120 == null) goto L50;
        int r121 = r210.optInt("NETWORK-NetworkLevel", -1);
        if (r121 == (-1)) goto L50;
        String r122 = r120.optString(String.valueOf(r121));
        if (TextUtils.isEmpty(r122) == true) goto L50;
        int r123 = r118.optInt(r122);
    L51:
        Iterator<String> r124 = r118.keys();
    L53:
        if (r124.hasNext() == false) goto L61;
        int r125 = r118.optInt(r124.next());
        if (r125 <= 0) goto L53;
        if (r123 > 0) goto L57;
        r119.add(Integer.valueOf(r125));
        goto L53
    L57:
        if (r125 > r123) goto L53;
        r119.add(Integer.valueOf(r125));
        goto L53
    L61:
        if (r112 != 1) goto L76;
        int r126 = r210.optInt("PLAY-IsHorizontalScreen", -1);
        String r127 = r210.optString("PLAY-DefaultResolution", "");
        if (r126 < 0) goto L76;
        if (TextUtils.isEmpty(r127) == true) goto L76;
        int r128 = r118.optInt(r127);
        int r129 = 1;
        int r130 = 0;
    L68:
        if (r129 >= r119.size()) goto L73;
        if (((Integer) ListProtector.get(r119, r129)).intValue() >= r128) goto L72;
        r130 = Math.max(r130, ((Integer) ListProtector.get(r119, r129)).intValue());
    L72:
        r129 = r129 + 1;
        goto L68
    L73:
        if (r130 <= 0) goto L76;
        r109 = Math.min(r109, r130);
    L76:
        if (r113 != 1) goto L86;
        int r131 = r210.optInt("USER-HumanActivityRecognition", -1);
        JSONObject r132 = r101.optJSONObject("HarResolutionLimitMap");
        if (r132 == null) goto L86;
        if (r131 == (-1)) goto L86;
        String r133 = r132.optString(String.valueOf(r131));
        if (TextUtils.isEmpty(r133) == true) goto L83;
        int r134 = r118.optInt(r133);
    L84:
        if (r134 <= 0) goto L86;
        r109 = Math.min(r109, r134);
        goto L86
    L83:
        r134 = 0;
    L86:
        int r135 = 1;
        if (r111 == 1) goto L89;
    L96:
        int r136 = Integer.MAX_VALUE;
        int r137 = -1;
        int r138 = 0;
    L98:
        if (r138 >= r119.size()) goto L113;
        int r139 = r109 - ((Integer) ListProtector.get(r119, r138)).intValue();
        if (r139 > 0) goto L103;
        r139 = -r139;
    L103:
        if (r139 >= r136) goto L105;
        r137 = ((Integer) ListProtector.get(r119, r138)).intValue();
        r136 = r139;
    L105:
        r138 = r138 + 1;
    L113:
        r100.put("startup_probe_bitrate", r137);     // Catch: JSONException -> L108
    L108:
        e = move-exception;
        e.printStackTrace();
        goto L110
    L89:
        if (r119.size() <= 0) goto L96;
        Collections.sort(r119);
        r137 = ((Integer) ListProtector.get(r119, 0)).intValue();
    L92:
        if (r135 >= r119.size()) goto L113;
        if (((Integer) ListProtector.get(r119, r135)).intValue() > r109) goto L113;
        r137 = ((Integer) ListProtector.get(r119, r135)).intValue();
        r135 = r135 + 1;
    L50:
        r123 = -1;
    L110:
        return r100;
    L35:
        if (r115 != 0) goto L38;
        if (r117 <= 0) goto L38;
        r108 = r117;
        goto L39
    L19:
        if (r103 == (-1.0d)) goto L21;
    L22:
        r103 = r102;
        r104 = 0;
        goto L23
    L13:
        r102 = 0.75d;
        r103 = -1.0d;
        r110 = 0;
        r111 = 0;
        r112 = 0;
        r113 = 0;
        r114 = 0;
        goto L15
    L130:
        return null;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject r100) {
        return super.runSmartStrategy(r100);
    }
}
