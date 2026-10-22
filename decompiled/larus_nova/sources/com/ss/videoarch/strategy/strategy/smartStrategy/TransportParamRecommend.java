package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.text.TextUtils;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TransportParamRecommend extends BaseSmartStrategy {
    private static final long MAX_BANDWIDTH = 80000;
    private static final double MAX_MULTIPLE = 20.0d;
    private static final long MIN_BANDWIDTH = 1500;
    private static final double MIN_MULTIPLE = 1.1d;
    private static final String TAG = "TransportParamRecommend";
    private static volatile TransportParamRecommend sInstance;

    public static TransportParamRecommend inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TransportParamRecommend.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TransportParamRecommend();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TransportParamRecommend.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private TransportParamRecommend() {
        this.mStrategyName = "live_stream_strategy_trans_params";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_trans_params";
        r100.mDefaultInputFeatureList = new JSONArray().put("NETWORK-NetworkLevel").put("NETWORK-RTT").put("NETWORK-VodDownloadSpeed").put("NETWORK-BestMtuLength").put("NETWORK-PacketLossRate").put("PLAY-Bitrate").put("PLAY-NeptuneName").put("PLAY-HistoryBandwidth").put("CLOUD-DefaultRecommendResult").put("CLOUD-MinMultiple").put("CLOUD-MaxMultiple").put("CLOUD-MinBandWidth").put("CLOUD-MaxBandWidth");
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r210) {
        Objects.toString(r210);
        if (r210 == null) goto L55;
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 != null) goto L7;
        return null;
    L7:
        if (r100.mInputSettingsParam == null) goto L60;
        JSONObject r101 = new JSONObject();
        String r102 = r210.optString("PLAY-NeptuneName", "");
        long r103 = r210.optLong("PLAY-HistoryBandwidth", 0);
        int r104 = r210.optInt("NETWORK-NetworkLevel", 0);
        long r110 = r210.optLong("NETWORK-RTT", 0);
        long r111 = r210.optLong("NETWORK-VodDownloadSpeed", 0);
        long r112 = r210.optLong("NETWORK-BestMtuLength", -1);
        long r211 = r210.optLong("NETWORK-PacketLossRate", -1);
        long r105 = this.mStrategyConfigInfo.mInputSettingsParam.optLong("MinBandWidth", 1500);
        long r106 = this.mStrategyConfigInfo.mInputSettingsParam.optLong("MaxBandWidth", MAX_BANDWIDTH);
        JSONObject r107 = this.mStrategyConfigInfo.mInputSettingsParam.optJSONObject("NetWorkTypeDefaultBandWidth");
        if (r103 <= 0) goto L12;
        int r113 = 1;
    L26:
        if (r103 >= r105) goto L28;
    L29:
        if (r103 < r105) goto L32;
        r105 = r106;
    L32:
        r103 = r105;
    L34:
        if (r103 > 0) goto L57;
        r103 = -1;
    L57:
        r101.put("Bandwidth", r103);     // Catch: JSONException -> L51
        if (r110 <= 0) goto L40;
        long r114 = r110;
    L41:
        r101.put("RTT", r114);     // Catch: JSONException -> L51
        if (r112 <= 0) goto L44;
        long r108 = r112;
    L45:
        r101.put("BestMTULength", r108);     // Catch: JSONException -> L51
        if (r211 <= 0) goto L48;
        long r109 = r211;
    L49:
        r101.put("PacketLossRate", r109);     // Catch: JSONException -> L51
        r101.put("BandwidthDecision", r113);     // Catch: JSONException -> L51
    L53:
        r101.toString();
        return r101;
    L48:
        r109 = -1;
        goto L49
    L44:
        r108 = -1;
        goto L45
    L40:
        r114 = -1;
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    L28:
        if (r103 <= r106) goto L34;
    L12:
        if (r111 <= 0) goto L14;
        r103 = r111;
        r113 = 2;
        goto L26
    L14:
        if (r107 != null) goto L16;
    L23:
        r113 = 0;
        goto L26
    L16:
        if (r107.has(String.valueOf(r104)) == false) goto L23;
        JSONObject r115 = r107.optJSONObject(String.valueOf(r104));
        if (TextUtils.isEmpty(r102) == true) goto L23;
        if (r115 == null) goto L23;
        if (r115.has(r102) == false) goto L23;
        r103 = r115.optLong(r102);
        r113 = 3;
        goto L26
    L60:
        return null;
    L55:
        return null;
    }
}
