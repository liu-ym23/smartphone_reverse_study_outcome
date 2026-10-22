package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.ConfigTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLMonitorLog;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.ConfigCacheInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class PredictFirstPlayTime extends BaseSmartStrategy {
    public static final int N = 10;
    private static final String TAG = "PredictFirstPlayTime";
    private static volatile PredictFirstPlayTime sInstance;
    public boolean mIsFirst;
    public StrategySQLMonitorLog mPredictStartMonitor;

    public static PredictFirstPlayTime inst() {
        if (sInstance != null) goto L15;
        monitor-enter(PredictFirstPlayTime.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PredictFirstPlayTime();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PredictFirstPlayTime.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private PredictFirstPlayTime() {
        this.mIsFirst = true;
        this.mStrategyName = "live_stream_strategy_first_play_time_predict";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_first_play_time_predict";
        r100.mDefaultInputFeatureList = new JSONArray().put("PLAY-FirstStartTime").put("PLAY-FirstStartTimeStamp").put("USER-FeaturesBundle").put("NETWORK-NetworkLevel").put("DEVICE-Battery");
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r100) {
        JSONObject r101 = this.mStrategyResult;
        if (r101 == null) goto L5;
        return r101;
    L5:
        JSONObject r102 = new JSONObject();
        ConfigCacheInfo r103 = ConfigTableOperate.getSettingsConfigFromDB(inst().mStrategyName + "_data");
        if (r103 == null) goto L13;
        return new JSONObject(r103.mExpandValue);
    L14:
        return r102;
    L13:
        return r102;
    }

    public void saveDataToDB(long r110) {
        if (getEnableStrategy(this.mStrategyName, 0) == 1) goto L5;
        return;
    L5:
        JSONObject r100 = null;
        if (r110 == (-1)) goto L13;
        JSONObject r101 = new JSONObject().put("result", r110);     // Catch: JSONException -> L9
    L11:
        uploadGroundTruth(r101);
    L9:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
    L13:
        if (LSSettings.inst().mPersistenceConfigInfo.mConfigTableEnable == 1) goto L15;
        return;
    L15:
        ConfigCacheInfo r102 = ConfigTableOperate.getSettingsConfigFromDB(inst().mStrategyName + "_data");
        String r103 = "";
        if (r102 != null) goto L51;
    L22:
        String r104 = "";
    L23:
        if (r110 == (-1)) goto L39;
        if (r100 != null) goto L32;
        r100 = new JSONObject();
        int r105 = 0;
    L27:
        if (r105 >= 10) goto L32;
        r100.put(String.valueOf(r105), -1);     // Catch: JSONException -> L30
        r105 = r105 + 1;
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        int r106 = 9;
    L33:
        if (r106 <= 0) goto L35;
        r100.put(String.valueOf(r106), r100.optLong(String.valueOf(r106 - 1), -1));     // Catch: JSONException -> L37
        r106 = r106 - 1;     // Catch: JSONException -> L37
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L35:
        r100.put(String.valueOf(0), r110);     // Catch: JSONException -> L37
    L39:
        if (r100 == null) goto L41;
        r103 = r100.toString();
    L41:
        JSONObject r111 = this.mStrategyResult;
        if (r111 == null) goto L44;
        r104 = r111.toString();
    L44:
        ConfigCacheInfo r112 = new ConfigCacheInfo();
        r112.mSettingsName = this.mStrategyName + "_data";
        r112.mSettingsValue = r103;
        r112.mExpandValue = r104;
        ArrayList r113 = new ArrayList();
        r113.add(r112);
        ConfigTableOperate.addSettingsConfigToDB(r113);
        ConfigTableOperate.mConfigTableCacheInfoMap.put(this.mStrategyName + "_data", r112);
        return;
    L51:
        r100 = new JSONObject(r102.mSettingsValue);     // Catch: JSONException -> L46
    L49:
        r104 = new JSONObject(r102.mExpandValue).toString();     // Catch: JSONException -> L21
        goto L23
    }
}
