package com.ss.videoarch.strategy.utils.smartStrategy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.pitaya.api.IPitayaCore;
import com.bytedance.pitaya.api.PTYMessageHandler;
import com.bytedance.pitaya.api.PTYPackageCallback;
import com.bytedance.pitaya.api.PTYTaskResultCallback;
import com.bytedance.pitaya.api.PitayaCoreFactory;
import com.bytedance.pitaya.api.bean.PTYRequestConfig;
import com.bytedance.pitaya.api.bean.PTYSetupInfo;
import com.bytedance.pitaya.api.bean.PTYTaskConfig;
import com.bytedance.pitaya.api.bean.PTYTaskData;
import com.bytedance.pitaya.api.feature.store.PTYFeatureProducer;
import com.bytedance.pitaya.api.feature.store.PTYFeatureStoreInstance;
import com.bytedance.pitaya.api.mutilinstance.HostSetupWatcher;
import com.ss.videoarch.strategy.ILiveStrategyCenter;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.featureCenter.FeatureFactory;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseLogInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class PitayaWrapper {
    private static final int MSG_WHAT_PTY_INIT = 1028;
    private static final int MSG_WHAT_RECEIVE_PTY_CALLBACK = 1026;
    private static volatile PitayaWrapper sInstance;
    private final String TAG;
    private String mAppId;
    private String mChannel;
    private String mDeviceId;
    public int mEnableInitByStrategy;
    public Handler mHandler;
    private PitayaBridge mPitayaBridge;
    private JSONObject mStrategyInfo;
    public StreamStrategyFeatureProducer mStreamStrategyFeatureProducer;
    public long mTimeToInit;
    private String mUserId;

    public static class StreamStrategyFeatureProducer extends PTYFeatureProducer {
        private final String FEATURE_GROUP_NAME;

        @Override // com.bytedance.pitaya.api.feature.store.PTYFeatureProducer
        public String getGroupName() {
            return "live_stream_strategy_feature_group";
        }

        @Override // com.bytedance.pitaya.api.feature.store.PTYFeatureProducer
        public float getNumericFeature(String r100, JSONObject r101) {
            return 0.0f;
        }

        @Override // com.bytedance.pitaya.api.feature.store.PTYFeatureProducer
        public JSONArray getSeqFeature(String r100, JSONObject r101) {
            return null;
        }

        @Override // com.bytedance.pitaya.api.feature.store.PTYFeatureProducer
        public String getStringFeature(String r100, JSONObject r101) {
            return null;
        }

        public StreamStrategyFeatureProducer() {
            this.FEATURE_GROUP_NAME = "live_stream_strategy_feature_group";
        }

        @Override // com.bytedance.pitaya.api.feature.store.PTYFeatureProducer
        public JSONObject getDictFeature(String r100, JSONObject r101) {
            return FeatureFactory.inst().featureFetch(r101, "2", "");
        }
    }

    public static PitayaWrapper inst() {
        if (sInstance != null) goto L15;
        monitor-enter(PitayaWrapper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new PitayaWrapper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PitayaWrapper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public boolean getPtyInitResult() {
        return PitayaCoreFactory.getCore(this.mAppId).isReady();
    }

    public void registerPTYFeatureProducer() {
        this.mStreamStrategyFeatureProducer = new StreamStrategyFeatureProducer();
        PTYFeatureStoreInstance.INSTANCE.getFeatureStore().registerFeatureProducer(this.mStreamStrategyFeatureProducer, new AnonymousClass6(this));
    }

    public void updatePtyPacketAll() {
        PitayaCoreFactory.getCore(this.mAppId).requestUpdateAll();
    }

    public PitayaWrapper() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.TAG = "PitayaWrapper";
        this.mAppId = ILiveStrategyCenter.SDK_APP_ID;
        this.mStrategyInfo = null;
        this.mDeviceId = "";
        this.mUserId = "";
        this.mChannel = "";
        this.mTimeToInit = 180000;
        this.mEnableInitByStrategy = -1;
        this.mPitayaBridge = new PitayaBridge();
    }

    public static /* synthetic */ String access$100(PitayaWrapper r100) {
        return r100.mDeviceId;
    }

    public static /* synthetic */ String access$200(PitayaWrapper r100) {
        return r100.mUserId;
    }

    private void setUpPty(Context r210) {
        IPitayaCore r100 = PitayaCoreFactory.getCore(this.mAppId);
        String r101 = this.mAppId;
        BaseLogInfo.inst();
        r100.setup(r210, new PTYSetupInfo(r101, "1.10.258.3", this.mChannel, new AnonymousClass2(this), new AnonymousClass3(this), null, new AnonymousClass4(this), 2, true, null, 2, null, false, false, null), new AnonymousClass5(this));
    }

    public void removeMessageFromPacket(String r100) {
        PitayaCoreFactory.getCore(this.mAppId).removeMessageHandler(r100);
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    public static /* synthetic */ void access$000(PitayaWrapper r100, Context r101) {
        r100.setUpPty(r101);
    }

    public void downloadPtyPacket(String r100, PTYPackageCallback r101) {
        PitayaCoreFactory.getCore(this.mAppId).downloadPackage(r100, r101);
    }

    public void getMessageFromPacket(String r100, PTYMessageHandler r101) {
        PitayaCoreFactory.getCore(this.mAppId).registerMessageHandler(r100, r101);
    }

    public void queryPtyPackage(String r100, PTYPackageCallback r101) {
        PitayaCoreFactory.getCore(this.mAppId).queryPackage(r100, r101);
    }

    public void registerApplogRunEvent(String r100, PTYTaskResultCallback r101) {
        PitayaCoreFactory.getCore(this.mAppId).registerApplogRunEventCallback(r100, r101);
    }

    public void removeApplogRunEvent(String r100, PTYTaskResultCallback r101) {
        PitayaCoreFactory.getCore(this.mAppId).removeApplogRunEventCallback(r100);
    }

    public void init(final Context r100, JSONObject r101, String r102) {
        this.mStrategyInfo = r101;
        this.mAppId = r102;
        if (r101 != null) goto L5;
    L13:
        HostSetupWatcher r103 = HostSetupWatcher.INSTANCE;
        if (r103.isHostSetup() == false) goto L16;
        setUpPty(r100);
        return;
    L16:
        r103.registerHostSetupListener(new AnonymousClass1(this, r100));
        if (this.mEnableInitByStrategy != 1) goto L23;
        Handler r104 = this.mHandler;
        if (r104 == null) goto L24;
        r104.sendEmptyMessageDelayed(1026, this.mTimeToInit);
        return;
    L24:
        return;
    L23:
        return;
    L5:
        if (r101.has("device_id") == false) goto L8;
        this.mDeviceId = this.mStrategyInfo.optString("device_id");
    L8:
        if (this.mStrategyInfo.has("user_id") == false) goto L11;
        this.mUserId = this.mStrategyInfo.optString("user_id");
    L11:
        if (this.mStrategyInfo.has("channel") == false) goto L13;
        this.mChannel = this.mStrategyInfo.optString("channel");
        goto L13
    }

    public boolean runPtyPacket(String r100, JSONObject r101, PTYTaskResultCallback r102) {
        if (getPtyInitResult() == false) goto L6;
        PTYTaskData r103 = new PTYTaskData(r101);
        PitayaCoreFactory.getCore(this.mAppId).runTask(r100, r103, new PTYTaskConfig(true, null, (float) LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mRunPtyPackageWaitTime), r102);
        return true;
    L6:
        return false;
    }

    public void updatePtyPacket(String r100, PTYRequestConfig r101, PTYPackageCallback r102) {
        PitayaCoreFactory.getCore(this.mAppId).requestUpdate(r100, r101, r102);
    }
}
