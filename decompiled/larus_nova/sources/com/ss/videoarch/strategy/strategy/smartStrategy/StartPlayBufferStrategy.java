package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLMonitorLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class StartPlayBufferStrategy extends BaseSmartStrategy {
    public static double ATTENUATION_COEFFICIENT_DEFAULT = 0.1d;
    public static long DEFAULT_MAX_BANDWIDTH = 80000;
    public static double DEFAULT_MAX_MULTIPLE = 15.0d;
    public static long DEFAULT_MIN_BANDWIDTH = 0;
    public static double DEFAULT_MIN_MULTIPLE = 1.05d;
    public static int START_PLAY_BUFERR_THRES_MAX_DEFAULT = 1000;
    public static int START_PLAY_BUFERR_THRES_MIN_DEFAULT = 600;
    private static final String TAG = "StartPlayBufferStrategy";
    public static int WEIGHTED_MEAN_STALL_COUNT_THRES = 20;
    private static volatile StartPlayBufferStrategy sInstance;
    int FIRST_START_PLAY_RETRY_COUNT;
    private int mAttenuationTimeOffset;
    private double mCoefficient;
    public JSONObject mDownloadSpeedInfo;
    public String mLastSessionId;
    private long mMaxBandWidth;
    private int mMaxStartPlayBuffer;
    private double mMaxmultiple;
    private long mMinBandWidth;
    private int mMinStartPlayBuffer;
    private double mMinmultiple;
    private ConcurrentHashMap<Integer, Pair> mNetWorkLevelAndStartPlayBufferMap;
    private int[] mNetworkAllLevel;
    private int[] mNetworkLevel;
    public JSONObject mResult;
    public StrategySQLMonitorLog mStartPlayBufferMonitor;

    public static StartPlayBufferStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(StartPlayBufferStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new StartPlayBufferStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(StartPlayBufferStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void computeBufferOffset() {
        JSONObject r100 = this.mStrategyConfigInfo.mInputSettingsParam;
        if (r100 == null) goto L5;
        this.mMinStartPlayBuffer = r100.optInt("MinStartPlayBuffer", this.mMinStartPlayBuffer);
        this.mMaxStartPlayBuffer = this.mStrategyConfigInfo.mInputSettingsParam.optInt("MaxStartPlayBuffer", this.mMaxStartPlayBuffer);
        this.mCoefficient = this.mStrategyConfigInfo.mInputSettingsParam.optDouble("AttenuationCoefficient", this.mCoefficient);
        this.mAttenuationTimeOffset = this.mStrategyConfigInfo.mInputSettingsParam.optInt("AttenuationTimeOffset", this.mAttenuationTimeOffset);
    L5:
        double r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r102 = 0;
        double r103 = 0.0d;
    L6:
        int[] r104 = this.mNetworkLevel;
        if (r102 >= r104.length) goto L9;
        r103 = r103 + Math.cbrt(8 - r104[r102]);
        r102 = r102 + 1;
        goto L6
    L9:
        int r105 = this.mMaxStartPlayBuffer;
        int r106 = this.mMinStartPlayBuffer;
        int r107 = r105 - r106;
        int r108 = 1;
    L10:
        int[] r109 = this.mNetworkLevel;
        if (r108 >= r109.length) goto L14;
        r101 = r101 + Math.cbrt(8 - r109[r108]);
        int r110 = (int) (((double) this.mMinStartPlayBuffer) + ((r101 / r103) * ((double) r107)));
        this.mNetWorkLevelAndStartPlayBufferMap.put(Integer.valueOf(this.mNetworkLevel[r108 - 1]), new Pair(Integer.valueOf(r106), Integer.valueOf(r110)));
        r108 = r108 + 1;
        r106 = r110;
        goto L10
    L14:
        if (r108 != r109.length) goto L19;
        this.mNetWorkLevelAndStartPlayBufferMap.put(Integer.valueOf(this.mNetworkLevel[r108 - 1]), new Pair(Integer.valueOf(r106), Integer.valueOf(this.mMaxStartPlayBuffer)));
        return;
    }

    private StartPlayBufferStrategy() {
        this.FIRST_START_PLAY_RETRY_COUNT = 0;
        this.mMinStartPlayBuffer = START_PLAY_BUFERR_THRES_MIN_DEFAULT;
        this.mMaxStartPlayBuffer = START_PLAY_BUFERR_THRES_MAX_DEFAULT;
        this.mCoefficient = ATTENUATION_COEFFICIENT_DEFAULT;
        this.mAttenuationTimeOffset = 1000;
        this.mNetworkLevel = new int[]{8, 7, 6, 5, 4, 3, 2};
        this.mNetWorkLevelAndStartPlayBufferMap = new ConcurrentHashMap();
        this.mLastSessionId = null;
        this.mResult = null;
        this.mMinmultiple = DEFAULT_MIN_MULTIPLE;
        this.mMaxmultiple = DEFAULT_MAX_MULTIPLE;
        this.mMinBandWidth = DEFAULT_MIN_BANDWIDTH;
        this.mMaxBandWidth = DEFAULT_MAX_BANDWIDTH;
        this.mNetworkAllLevel = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        this.mDownloadSpeedInfo = new JSONObject();
        this.mStrategyName = "live_stream_strategy_start_play_buffer";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_start_play_buffer";
        r100.mDefaultInputFeatureList = new JSONArray().put("NETWORK-NetworkLevel").put("PLAY-RetryTotalCount").put("PLAY-StallTotalCount").put("PLAY-LastRetryTotalCount").put("PLAY-LastStallTotalCount").put("PLAY-LastEndTS");
        return;
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r110) {
        if (r110 != null) goto L5;
        return null;
    L5:
        int r100 = r110.optInt("NETWORK-NetworkLevel");
        if (r100 != 0) goto L9;
        return null;
    L9:
        if (r100 != 1) goto L11;
        r100 = 7;
    L11:
        Pair r101 = this.mNetWorkLevelAndStartPlayBufferMap.get(Integer.valueOf(r100));
        if (r101 != null) goto L15;
        return null;
    L15:
        if (r110.has("PLAY-RetryTotalCount") == false) goto L17;
        int r102 = r110.optInt("PLAY-RetryTotalCount");
    L19:
        if (r110.has("PLAY-StallTotalCount") == false) goto L21;
        int r103 = r110.optInt("PLAY-StallTotalCount");
    L23:
        if (r102 == this.FIRST_START_PLAY_RETRY_COUNT) goto L25;
    L39:
        double r104 = 1.0d;
    L40:
        int r111 = (int) ((((double) Math.max(r102, 0)) * 0.41935483870967744d) + (((double) Math.max(r103, 0)) * 0.5806451612903226d));
        int r105 = ((Integer) r101.second).intValue() - ((Integer) r101.first).intValue();
        if (r111 >= WEIGHTED_MEAN_STALL_COUNT_THRES) goto L43;
        r105 = (int) ((((1.0d / (Math.exp(-r111) + 1.0d)) - 0.5d) * 2.0d) * ((double) r105));
    L43:
        long r106 = ((Integer) r101.first).intValue() + ((int) (r104 * ((double) r105)));
        JSONObject r112 = new JSONObject();
        r112.put("result", r106);     // Catch: JSONException -> L46
    L48:
        return r112;
    L46:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L25:
        if (r110.has("PLAY-LastRetryTotalCount") == false) goto L30;
        if (r110.optInt("PLAY-LastRetryTotalCount") == (-1)) goto L30;
        r102 = r110.optInt("PLAY-LastRetryTotalCount");
    L30:
        if (r110.has("PLAY-LastStallTotalCount") == false) goto L35;
        if (r110.optInt("PLAY-LastStallTotalCount") == (-1)) goto L35;
        r103 = r110.optInt("PLAY-LastStallTotalCount");
    L35:
        if (r110.has("PLAY-LastEndTs") == false) goto L39;
        if (r110.optLong("PLAY-LastEndTs") <= 0) goto L39;
        r104 = 1.0d / Math.exp((this.mCoefficient * (System.currentTimeMillis() - r110.optLong("PLAY-LastEndTs"))) / ((double) this.mAttenuationTimeOffset));
        goto L40
    L21:
        r103 = 0;
        goto L23
    L17:
        r102 = 0;
        goto L19
    }
}
