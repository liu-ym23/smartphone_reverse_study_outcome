package com.ss.videoarch.strategy.strategy.smartStrategy;

import com.bytedance.pitaya.api.bean.PTYError;
import com.bytedance.pitaya.api.bean.PTYPackageInfo;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.ss.videoarch.strategy.dataCenter.config.model.StrategyConfigInfo;
import com.ss.videoarch.strategy.strategy.abr.DecisionMaker;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class ABRSwitchStrategy extends BaseSmartStrategy {
    private static final String TAG = "ABRSwitchStrategy";
    private static volatile ABRSwitchStrategy sInstance;
    private boolean mPitayaReady;

    public static /* synthetic */ void a(JSONObject[] r100, boolean r101, PTYError r102, PTYTaskData r103, PTYPackageInfo r104) {
        lambda$runPitayaStrategy$0(r100, r101, r102, r103, r104);
    }

    public static ABRSwitchStrategy inst() {
        if (sInstance != null) goto L15;
        monitor-enter(ABRSwitchStrategy.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new ABRSwitchStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(ABRSwitchStrategy.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private ABRSwitchStrategy() {
        this.mPitayaReady = false;
        this.mStrategyName = "live_stream_strategy_abr_predict_bitrate";
        this.mProjectKey = "2";
        StrategyConfigInfo r100 = this.mStrategyConfigInfo;
        if (r100 == null) goto L6;
        r100.mStrategyName = "live_stream_strategy_abr_predict_bitrate";
        r100.mDefaultInputFeatureList = new JSONArray().put("PLAY-BitrateList");
        return;
    }

    public JSONObject runABRStrategy(JSONObject r100) {
        this.mPitayaReady = PitayaWrapper.inst().getPtyInitResult();
        return DecisionMaker.getInstance().makeDecision(r100);
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runLocalStrategy(JSONObject r100) {
        return runABRStrategy(r100);
    }

    @Override // com.ss.videoarch.strategy.strategy.smartStrategy.BaseSmartStrategy
    public JSONObject runSmartStrategy(JSONObject r100) {
        return runABRStrategy(r100);
    }

    private String runPitayaStrategy(String r100, String r101) {
        if (this.mPitayaReady == true) goto L18;
        return null;
    L18:
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L15
        if (r100 != null) goto L8;
        r100 = this.mStrategyName;
    L8:
        final JSONObject[] r103 = {null};
        if (PitayaWrapper.inst().runPtyPacket(r100, r102, new a(r103)) == false) goto L14;
        JSONObject r104 = r103[0];
        if (r104 == null) goto L14;
        return r104.toString();
    L14:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static /* synthetic */ void lambda$runPitayaStrategy$0(JSONObject[] r100, boolean r101, PTYError r102, PTYTaskData r103, PTYPackageInfo r104) {
        if (r103 == null) goto L4;
        JSONObject r105 = r103.getParams();
        r100[0] = r105;
        Objects.toString(r105);
        Objects.toString(r102);
        return;
    L4:
        Objects.toString(r102);
    }
}
