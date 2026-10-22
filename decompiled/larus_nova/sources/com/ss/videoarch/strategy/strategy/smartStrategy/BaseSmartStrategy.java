package com.ss.videoarch.strategy.strategy.smartStrategy;

import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.roomplayer.VrBgLogData;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.ConfigTableOperate;
import com.ss.videoarch.strategy.featureCenter.FeatureFactory;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePushFeaturesCollector;
import com.ss.videoarch.strategy.log.StrategyCenterLogger;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import java.util.Iterator;
import java.util.Objects;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class BaseSmartStrategy extends BaseStrategyMonitor {
    protected static String TAG = "BaseSmartStrategy";
    protected int mCode;
    protected double mCpuInc;
    protected int mEnableCloudPackage;
    protected String mExtraLog;
    protected boolean mFallbackLocal;
    protected int mIndex;
    protected JSONObject mInputFeatures;
    protected long mLoadPackageCost;
    protected double mMemoryInc;
    protected String mProjectKey;
    protected float mRandomFloat;
    protected String mResult;
    protected long mRunCost;
    protected int mRunIndex;
    protected StrategyConfigInfo mStrategyConfigInfo;
    public String mStrategyName;
    protected JSONObject mStrategyResult;
    protected long mTotalCost;

    private native String nativeRunCloudStrategy(String r100, String r101);

    private native void nativeSetObject();

    public JSONObject runLocalStrategy(JSONObject r100) {
        return null;
    }

    public JSONObject runStrategy() {
        return runStrategy(null);
    }

    private JSONObject createCommonLog() {
        JSONObject r100 = new JSONObject();
        r100.put("stream_type", TypePlayFeaturesCollector.inst().getCallerInfo("neptuneName", "none")).put("enter_from", TypePlayFeaturesCollector.inst().getCallerInfo("enter_from", "none")).put("run_index", this.mRunIndex).put(VrBgLogData.KEY_IS_PREVIEW, TypePlayFeaturesCollector.inst().getCallerInfo(VrBgLogData.KEY_IS_PREVIEW, -1)).put("strategy_name", this.mStrategyName).put("strategy_id", this.mStrategyConfigInfo.mStrategyID).put("strategy_ABInfo", LSSettings.inst().getStrategyABInfo()).put("strategy_common_trace", LSSettings.inst().getStrategyCommonInfo()).put("pitaya_ab_package_name", this.mStrategyConfigInfo.mPitayaABPackageName);     // Catch: JSONException -> L5
    L7:
        return r100;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createMetric() {
        return new JSONObject().put("load_cost", this.mLoadPackageCost).put("run_cost", this.mRunCost).put("duration", this.mTotalCost).put("cpu_inc", this.mCpuInc).put("memory_inc", this.mMemoryInc);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public JSONObject fetchData() {
        if (this.mStrategyConfigInfo != null) goto L5;
        return null;
    L5:
        return FeatureFactory.inst().featureFetch(this.mStrategyConfigInfo.mFeaturesBundle, this.mProjectKey, this.mStrategyName);
    }

    public void initStrategyConfig() {
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.initSettingsConfig();
        return;
    }

    public BaseSmartStrategy() {
        this.mStrategyName = "lsstrategy_base_strategy_model";
        this.mStrategyConfigInfo = new StrategyConfigInfo();
        this.mStrategyResult = null;
        this.mInputFeatures = null;
        this.mIndex = 0;
        this.mRandomFloat = new Random().nextFloat();
        this.mProjectKey = "none";
        this.mResult = "none";
        this.mExtraLog = "none";
        this.mCode = -1;
        this.mRunIndex = 0;
        this.mEnableCloudPackage = -1;
        this.mFallbackLocal = false;
        this.mTotalCost = -1;
        this.mLoadPackageCost = -1;
        this.mRunCost = -1;
        this.mCpuInc = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.mMemoryInc = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableNativeStrategyCenter == 1) goto L5;
        return;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L9;
        nativeSetObject();
        return;
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public JSONObject createCategory() {
        JSONObject r100 = createCommonLog();
        JSONObject r101 = r100.put("caller", this.mProjectKey);     // Catch: JSONException -> L14
        if (this.mProjectKey != "2") goto L7;
        Object r102 = TypePlayFeaturesCollector.inst().getCallerInfo("stream_session_vv_id", "none");     // Catch: JSONException -> L14
    L8:
        JSONObject r103 = r101.put("caller_session_id", r102).put("result", this.mResult);     // Catch: JSONException -> L14
        if (this.mFallbackLocal == false) goto L11;
        int r104 = 1;
    L12:
        r103.put("fallback_local", r104).put("enable_cloud_package", this.mEnableCloudPackage).put("code", strategyCode()).put("extra_info", this.mExtraLog);     // Catch: JSONException -> L14
        return r100;
    L11:
        r104 = 0;
        goto L12
    L7:
        r102 = TypePushFeaturesCollector.inst().getCallerInfo("stream_session_vv_id", "none");     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getInputFeatures() {
        JSONObject r100 = fetchData();
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L6:
        Objects.toString(r100);
        return r101;
    L5:
        r101 = "";
        goto L6
    }

    @Override // com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor
    public int strategyCode() {
        if (LiveStrategyManager.inst().mIsRunning == true) goto L6;
        this.mCode = 1;
    L16:
        return this.mCode;
    L6:
        if (this.mStrategyConfigInfo != null) goto L8;
        this.mCode = 2;
        goto L16
    L8:
        String r100 = this.mResult;
        if (r100 == null) goto L16;
        if (TextUtils.isEmpty(r100) == true) goto L16;
        if (this.mResult.equals("none") == true) goto L16;
        this.mCode = 0;
        goto L16
    }

    public JSONObject runCloudStrategy(JSONObject r100) {
        JSONObject r101 = this.mStrategyConfigInfo.mInputSettingsParam.optJSONObject("cloudStrategyParam");
        JSONObject r102 = null;
        if (r101 != null) goto L5;
    L7:
        String r103 = null;
    L9:
        if (TextUtils.isEmpty(r103) == false) goto L17;
    L13:
        if (r102 == null) goto L16;
        return r102;
    L16:
        return runLocalStrategy(r100);
    L17:
        r102 = new JSONObject(r103);     // Catch: JSONException -> L12
        goto L13
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L7;
        r103 = nativeRunCloudStrategy(r101.toString(), r100.toString());
        goto L9
    }

    public JSONObject runSmartStrategy(JSONObject r100) {
        final JSONObject[] r101 = {null};
        Objects.toString(r100);
        if (PitayaWrapper.inst().runPtyPacket(this.mStrategyName, r100, new AnonymousClass1(this, r101)) == false) goto L8;
        JSONObject r102 = r101[0];
        if (r102 == null) goto L8;
        Objects.toString(r102);
        this.mFallbackLocal = false;
        return r101[0];
    L8:
        this.mFallbackLocal = true;
        return runLocalStrategy(r100);
    }

    public JSONObject runStrategy(JSONObject r110) {
        if (this.mServiceName != null) goto L5;
        this.mServiceName = "live_stream_strategy_common_monitor";
    L5:
        JSONObject r100 = null;
        if (getEnableStrategy(this.mStrategyName, 0) != 1) goto L8;
        long r101 = System.currentTimeMillis();
        JSONObject r102 = fetchData();
        this.mInputFeatures = r102;
        if (r110 == null) goto L19;
        if (r102 == null) goto L19;
        Iterator<String> r103 = r110.keys();     // Catch: JSONException -> L17
    L14:
        if (r103.hasNext() == false) goto L19;
        String r104 = r103.next();     // Catch: JSONException -> L17
        r102.put(r104, r110.get(r104));     // Catch: JSONException -> L17
    L17:
        e = move-exception;
        e.printStackTrace();
    L19:
        if (r102 == null) goto L26;
        JSONObject r111 = this.mStrategyConfigInfo.mInputSettingsParam;
        if (r111 == null) goto L26;
        r102.put("InputSettingsParams", r111);     // Catch: JSONException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L26:
        Objects.toString(r102);
        StrategyConfigInfo r112 = this.mStrategyConfigInfo;
        if (r112 == null) goto L39;
        int r105 = r112.mEnableSmartStrategy;
        if (r105 != 1) goto L31;
    L33:
        this.mEnableCloudPackage = 1;
        if (r105 != 1) goto L37;
        r100 = runSmartStrategy(r102);
    L40:
        this.mRunIndex++;
        Objects.toString(r100);
        if (r100 == null) goto L43;
        this.mResult = r100.toString();
    L44:
        this.mTotalCost = System.currentTimeMillis() - r101;
        uploadMonitorLog();
        this.mStrategyResult = r100;
        return r100;
    L43:
        this.mResult = "none";
        goto L44
    L37:
        if (r112.mEnableCloudStrategy != 1) goto L40;
        r100 = runCloudStrategy(r102);
        goto L40
    L31:
        if (r112.mEnableCloudStrategy == 1) goto L33;
    L39:
        this.mEnableCloudPackage = 0;
        r100 = runLocalStrategy(r102);
        goto L40
    L8:
        return null;
    }

    public void uploadGroundTruth(JSONObject r100) {
        StrategyConfigInfo r101 = this.mStrategyConfigInfo;
        if (r101 == null) goto L28;
        JSONObject r102 = r101.mFeatureSampleConfig;
        if (r102 == null) goto L28;
        if (r102.has("GroundTruthSample") == false) goto L28;
        JSONObject r103 = this.mStrategyConfigInfo.mFeatureSampleConfig.optJSONObject("GroundTruthSample");
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.has("Enable") == true) goto L13;
        return;
    L13:
        if (r103.optInt("Enable") != (-1)) goto L16;
        return;
    L16:
        if (r103.has("ReportRate") == false) goto L18;
        float r104 = (float) r103.optDouble("ReportRate");
    L20:
        if (this.mRandomFloat >= r104) goto L28;
        JSONObject r105 = createCommonLog();
        r105.put("input_features", this.mInputFeatures).put("ground_truth", r100).put("unique_symbol", LiveStrategyManager.mLoadLibraryTime + "." + LiveStrategyManager.inst().mDeviceId + "." + this.mIndex);     // Catch: JSONException -> L24
    L26:
        Objects.toString(r105);
        StrategyCenterLogger.reportFeatureData(r105);
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L18:
        r104 = 0.1f;
    L28:
        this.mIndex++;
        this.mRandomFloat = new Random().nextFloat();
    }

    public void uploadPredictValue(JSONObject r100) {
        StrategyConfigInfo r101 = this.mStrategyConfigInfo;
        if (r101 == null) goto L30;
        JSONObject r102 = r101.mFeatureSampleConfig;
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.has("PredictResultSample") == false) goto L32;
        JSONObject r103 = this.mStrategyConfigInfo.mFeatureSampleConfig.optJSONObject("PredictResultSample");
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.has("Enable") == true) goto L13;
        return;
    L13:
        if (r103.optInt("Enable") != (-1)) goto L16;
        return;
    L16:
        if (r103.has("ReportRate") == false) goto L18;
        float r104 = (float) r103.optDouble("ReportRate");
    L20:
        if (this.mRandomFloat >= r104) goto L35;
        JSONObject r105 = createCommonLog();
        r105.put("input_features", this.mInputFeatures).put("predict", r100).put("unique_symbol", LiveStrategyManager.mLoadLibraryTime + "." + LiveStrategyManager.inst().mDeviceId + "." + this.mIndex);     // Catch: JSONException -> L24
    L26:
        Objects.toString(r105);
        StrategyCenterLogger.reportFeatureData(r105);
        return;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    L35:
        return;
    L18:
        r104 = 0.1f;
        goto L20
    L32:
        return;
    }

    public int getEnableStrategy(String r100, int r101) {
        if (LiveStrategyManager.inst().mIsRunning == false) goto L7;
        StrategyConfigInfo r102 = this.mStrategyConfigInfo;
        if (r102 == null) goto L13;
        r101 = r102.mEnable;
    L13:
        return r101;
    L7:
        JSONObject r103 = ConfigTableOperate.getConfigResultFromSettingsValue(ConfigTableOperate.STRATEGY_CONFIG, r100);
        if (r103 == null) goto L13;
        r101 = r103.optInt("Enable");
        StrategyConfigInfo r104 = this.mStrategyConfigInfo;
        if (r104 == null) goto L13;
        r104.mInputSettingsParam = r103.optJSONObject("InputSettingsParam");
        goto L13
    }
}
