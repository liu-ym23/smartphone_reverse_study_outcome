package com.ss.videoarch.strategy.strategy.smartStrategy;

import androidx.camera.video.AudioStats;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class GetRetryBufferStrategy extends BaseSmartStrategy {
    private static final String TAG = "GetRetryBufferStrategy";
    private static volatile GetRetryBufferStrategy sInstance;
    private int mAdaptiveBufferingEndThresholdStrategy;

    public static GetRetryBufferStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(GetRetryBufferStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new GetRetryBufferStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(GetRetryBufferStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private GetRetryBufferStrategy() {
        this.mAdaptiveBufferingEndThresholdStrategy = -1;
        this.mStrategyName = "live_stream_strategy_retry_buffer";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L5;
        r100.mStrategyName = "live_stream_strategy_retry_buffer";
        r100.mDefaultInputFeatureList = new JSONArray().put("PLAY-DownloadSpeed").put("USER-OverallScore").put("NETWORK-NetworkLevel").put("PLAY-StallTime").put("PLAY-BufferDataSeconds").put("PLAY-DoubleBufferDataSeconds");
    L5:
        this.mProjectKey = "2";
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r110) {
        Objects.toString(r110);
        if (r110 == null) goto L55;
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L59;
        this.mAdaptiveBufferingEndThresholdStrategy = 1;
        JSONObject r101 = r100.mInputSettingsParam;
        if (r101 == null) goto L11;
        this.mAdaptiveBufferingEndThresholdStrategy = r101.optInt("AdaptiveBufferingEndThresholdStrategy", 1);
    L11:
        if (r110.has("PLAY-BufferDataSeconds") == false) goto L13;
        double r102 = r110.optInt("PLAY-BufferDataSeconds");
    L14:
        int r103 = this.mAdaptiveBufferingEndThresholdStrategy;
        long r104 = -1;
        if (r103 != 1) goto L35;
        if (r110.has("NETWORK-NetworkLevel") == false) goto L19;
        int r105 = r110.optInt("NETWORK-NetworkLevel");
    L21:
        if (r110.has("USER-OverallScore") == false) goto L23;
        double r106 = r110.optDouble("USER-OverallScore");
    L25:
        if (r110.has("PLAY-DownloadSpeed") == false) goto L27;
        r104 = r110.optInt("PLAY-DownloadSpeed");
    L27:
        if (r105 <= 0) goto L49;
        if (r104 <= 0) goto L49;
        if (r106 <= AudioStats.AUDIO_AMPLITUDE_NONE) goto L49;
        double r107 = r105;
        double r108 = r104;
        r102 = ((((((Math.log(r107) * 18.06d) + 1148.3d) + (Math.log(0.001d * r108) * 81.67d)) - (Math.log(r106) * 234.83d)) + ((27.7d * r107) / r108)) + ((193.1d * r106) / r108)) - ((r107 * 117.43d) / r106);
    L49:
        double r109 = Math.min(Math.max(r102, 100.0d), 1500.0d);
        JSONObject r111 = new JSONObject();
        r111.put("RetryBufferSize", r109);     // Catch: JSONException -> L52
    L54:
        return r111;
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L23:
        r106 = -1.0d;
        goto L25
    L19:
        r105 = -1;
        goto L21
    L35:
        if (r103 != 2) goto L41;
        if (r110.has("PLAY-DoubleBufferDataSeconds") == false) goto L49;
        r102 = r110.optInt("PLAY-DoubleBufferDataSeconds");
        goto L49
    L41:
        if (r103 != 3) goto L49;
        if (r110.has("PLAY-StallTime") == false) goto L46;
        r104 = r110.optInt("PLAY-StallTime");
    L46:
        if (r104 <= 0) goto L49;
        r102 = (int) r104;
        goto L49
    L13:
        r102 = 200.0d;
        goto L14
    L59:
        return null;
    L55:
        return null;
    }
}
