package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class SmoothSwitchStrategy extends BaseSmartStrategy {
    private static final String TAG = "SmoothSwitchStrategy";
    private static volatile SmoothSwitchStrategy sInstance;

    public static SmoothSwitchStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(SmoothSwitchStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SmoothSwitchStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SmoothSwitchStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private SmoothSwitchStrategy() {
        this.mStrategyName = "live_stream_strategy_smooth_switch_probe_bitrate";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_smooth_switch_probe_bitrate";
        r100.mDefaultInputFeatureList = new JSONArray().put("NETWORK-NetworkLevel").put("PLAY-BitrateList");
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r110) {
        Objects.toString(r110);
        if (r110 == null) goto L38;
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        if (r100.mInputSettingsParam == null) goto L52;
        JSONObject r101 = new JSONObject();
        JSONObject r102 = r110.optJSONObject("PLAY-BitrateList");
        JSONObject r103 = this.mStrategyConfigInfo.mInputSettingsParam.optJSONObject("NetLevel-Map");
        int r111 = r110.optInt("NETWORK-NetworkLevel", 0);
        boolean r104 = true;
        if (r102 != null) goto L12;
        boolean r105 = true;
    L13:
        if (r103 == null) goto L17;
        r104 = false;
    L17:
        if ((r104 | r105) == false) goto L19;
        return r101;
    L19:
        Iterator<String> r106 = r103.keys();
        int r107 = -1;
    L40:
    L35:
        e = move-exception;
        e.printStackTrace();
    L37:
        return r101;
    L21:
        if (r106.hasNext() == false) goto L33;
        String r108 = r106.next();     // Catch: JSONException -> L35
        JSONArray r109 = r103.optJSONArray(r108);     // Catch: JSONException -> L35
        if (r109 == null) goto L40;
        int r112 = 0;
    L26:
        if (r112 >= r109.length()) goto L40;
        if (r109.get(r112).equals(Integer.valueOf(r111)) == false) goto L32;
        if (r102.has(r108) == false) goto L32;
        r107 = r102.optInt(r108);     // Catch: JSONException -> L35
    L32:
        r112 = r112 + 1;     // Catch: JSONException -> L35
        goto L26
    L33:
        r101.put("smooth_switch_probe_bitrate", r107);     // Catch: JSONException -> L35
        goto L37
    L12:
        r105 = false;
        goto L13
    L52:
        return null;
    L38:
        return null;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject r100) {
        return super.runSmartStrategy(r100);
    }
}
