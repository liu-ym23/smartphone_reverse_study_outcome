package com.ss.videoarch.strategy.dataCenter.config;

import android.os.Handler;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.videoarch.strategy.IAppInfoBundle;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.config.model.CommonConfigInfo;
import com.ss.videoarch.strategy.dataCenter.config.model.PersistenceConfigInfo;
import com.ss.videoarch.strategy.dataCenter.strategyData.ConfigTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.ConfigCacheInfo;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeDeviceFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeNetworkFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePushFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypeUserProfileCollector;
import com.ss.videoarch.strategy.log.VeLSCommonMonitorLogger;
import com.ss.videoarch.strategy.strategy.networkStrategy.NetworkProber;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.strategy.smartStrategy.ABRSwitchStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.CharacterFetchStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.GetRetryBufferStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.NetConnectionTypeStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.PredictFirstPlayTime;
import com.ss.videoarch.strategy.strategy.smartStrategy.PredictShortTimeLeave;
import com.ss.videoarch.strategy.strategy.smartStrategy.ProbeStartupBitrate;
import com.ss.videoarch.strategy.strategy.smartStrategy.SmoothSwitchStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.SocketBufferStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.StartPlayBufferStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.SuperResolutionStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.TransportParamRecommend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class LSSettings {
    static final String PROJECT_KEY = "live_stream_strategy_engine";
    static final String TAG = "LSSettings";
    private static volatile LSSettings sInstance;
    public final long DEFAULT_START_UP_DELAY;
    public final int DEFAULT_TIME_OUT;
    public int mABRStrategyQueueMaxThreshold;
    public Map<String, Object> mAnchorParams;
    private IAppInfoBundle mAppInfoBundle;
    public int mAutoRetrySyncInterval;
    public int mBasePostRequestInterval;
    public JSONObject mClientInfos;
    public CommonConfigInfo mCommonConfigInfo;
    public JSONObject mCommonConfigJSON;
    public int mCount;
    public long mDelayTime;
    private Map<String, Integer> mDomainParseType;
    public JSONArray mDomianInfos;
    public int mEnableDataWarehouse;
    public int mEnableExecuteCommandInExternalThread;
    public int mEnableExecuteCommandOpt;
    public int mEnableExecuteStartupGearCommandInExternalThread;
    public int mEnableGetHttpDnsIpFirstResponse;
    public int mEnableGetIpv6HttpDnsIpFirstResponse;
    public int mEnableJniQueue;
    public int mEnableLSGetPreconIp;
    public int mEnableLSH2QPrecon;
    public int mEnableLSHotDomainPrecon;
    public int mEnableLSPrecreate;
    public int mEnableLSRoomPrecon;
    public int mEnableLiveIO;
    public int mEnableLiveIOEngine;
    public int mEnableMgrTopN;
    public int mEnableNativeDns;
    public int mEnableNativeNodeOptimize;
    public int mEnableNewNativeArch;
    public int mEnableOpenPreconnect;
    public int mEnablePerformanceOptimization;
    public int mEnablePreconnUDPProbe;
    public int mEnableReduceReport;
    public int mEnableSR;
    public boolean mEnableSelectNode;
    public int mEnableSetConfigToLiveIO;
    public int mEnableSetNetworkStatus;
    public int mEnableSettingsMgrChar;
    public int mEnableSocketAcc;
    public int mEnableStartupGearThreadPool;
    public int mEnableThreadTimeOut;
    public int mExecuteCommandTimeout;
    public JSONObject mFeatureConfigJSON;
    public int mGetHotDomains;
    public int mGetIpFromPreconTimeOut;
    private Handler mHandler;
    public int mMaxRetryTimes;
    public JSONObject mNodeInfos;
    public PersistenceConfigInfo mPersistenceConfigInfo;
    public JSONObject mProjectSettings;
    public String mRequestId;
    private JSONObject mResult;
    public Map<String, List<String>> mSessionRequestHotUpdateParamsMap;
    public JSONObject mSettings;
    public int mSocketIdleTimeout;
    public boolean mStartLiveIOPreconnect;
    public long mStartUpDelay;
    public JSONObject mStrategyConfigJSON;
    public List<String> mSupportHotUpdateFunctionNameList;
    public String mSymbol;
    public JSONObject mUidFeatureJSON;
    public int mUpdateCountGlobal;
    public Map<String, Object> mUserParams;

    public static LSSettings inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LSSettings.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LSSettings();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LSSettings.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void checkAndNotifyHotUpdateParams() {
        HashMap r100 = new HashMap();
        if (this.mCommonConfigJSON == null) goto L15;
        List<String> r101 = this.mSupportHotUpdateFunctionNameList;
        if (r101 == null) goto L15;
        Iterator<String> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        String r103 = r102.next();
        JSONObject r104 = this.mCommonConfigJSON.optJSONObject(r103);
        JSONObject r105 = ConfigTableOperate.getConfigResultFromSettingsValue(ConfigTableOperate.COMMON_CONFIG, r103);
        if (r104 == null) goto L8;
        if (r105 == null) goto L8;
        if (r104.toString().equals(r105.toString()) == true) goto L8;
        r100.put(r103, r104);
    L15:
        Map<String, List<String>> r106 = this.mSessionRequestHotUpdateParamsMap;
        if (r106 != null) goto L18;
        return;
    L18:
        if (r106.size() <= 0) goto L60;
        Iterator<String> r107 = this.mSessionRequestHotUpdateParamsMap.keySet().iterator();
    L21:
        if (r107.hasNext() == false) goto L61;
        String r108 = r107.next();
        JSONObject r109 = new JSONObject();
        List<String> r110 = this.mSessionRequestHotUpdateParamsMap.get(r108);
        if (r110 == null) goto L21;
        if (r110.size() <= 0) goto L21;
        Iterator<String> r111 = r110.iterator();
    L28:
        if (r111.hasNext() == false) goto L35;
        String r112 = r111.next();
        if (r100.containsKey(r112) == false) goto L28;
        r109.put(r112, r100.get(r112));     // Catch: JSONException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L35:
        LiveStrategyManager.inst().mListenerMap.get(r108).getAppInfoForKey("hot_update", r109);
        goto L21
    L61:
        return;
    }

    public Set<String> getDomainInfos() {
        HashSet r100 = new HashSet();
        JSONArray r101 = this.mDomianInfos;
        if (r101 != null) goto L5;
    L15:
        return r100;
    L5:
        if (r101.length() <= 0) goto L15;
        int r102 = 0;
    L8:
        if (r102 >= this.mDomianInfos.length()) goto L15;
        JSONObject r103 = this.mDomianInfos.optJSONObject(r102);
        if (r103 == null) goto L14;
        if (r103.has("DomainName") == false) goto L14;
        String r104 = r103.optString("DomainName");
        r100.add(r104);
        this.mDomainParseType.put(r104, Integer.valueOf(r103.optInt("DomainParseType")));
    L14:
        r102 = r102 + 1;
        goto L8
    }

    public Set<String> getNodeInfosDomain() {
        HashSet r100 = new HashSet();
        JSONObject r101 = this.mNodeInfos;
        if (r101 == null) goto L8;
        Iterator<String> r102 = r101.keys();
    L6:
        if (r102.hasNext() == false) goto L8;
        r100.add(r102.next());
    L8:
        return r100;
    }

    public String getStrategyABInfo() {
        JSONObject r100 = this.mSettings;
        if (r100 != null) goto L12;
        return "";
    L12:
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    L6:
        if (r100.has("ABVersionTrace") == false) goto L14;
        return this.mSettings.optString("ABVersionTrace", "");
    L14:
        return "";
    }

    public String getStrategyCommonInfo() {
        JSONObject r100 = this.mSettings;
        if (r100 != null) goto L12;
        return "";
    L12:
    L9:
        e = move-exception;
        e.printStackTrace();
        return "";
    L6:
        if (r100.has("CommonTrace") == false) goto L14;
        return this.mSettings.optString("CommonTrace", "");
    L14:
        return "";
    }

    public LSSettings() {
        this.mResult = null;
        this.mSettings = null;
        this.mClientInfos = null;
        this.mProjectSettings = null;
        this.DEFAULT_TIME_OUT = 5000;
        this.DEFAULT_START_UP_DELAY = 0;
        this.mDomianInfos = null;
        this.mRequestId = null;
        this.mNodeInfos = null;
        this.mSymbol = null;
        this.mDomainParseType = new HashMap();
        this.mUserParams = new HashMap();
        this.mAnchorParams = new HashMap();
        this.mStrategyConfigJSON = null;
        this.mFeatureConfigJSON = null;
        this.mCommonConfigJSON = null;
        this.mUidFeatureJSON = null;
        this.mCommonConfigInfo = new CommonConfigInfo();
        this.mPersistenceConfigInfo = new PersistenceConfigInfo();
        this.mUpdateCountGlobal = 0;
        this.mEnableSelectNode = false;
        this.mEnablePerformanceOptimization = -1;
        this.mEnableOpenPreconnect = -1;
        this.mEnableLiveIO = -1;
        this.mEnableLiveIOEngine = -1;
        this.mStartLiveIOPreconnect = false;
        this.mEnableThreadTimeOut = -1;
        this.mEnableLSHotDomainPrecon = -1;
        this.mEnableSR = -1;
        this.mEnableGetHttpDnsIpFirstResponse = -1;
        this.mEnableGetIpv6HttpDnsIpFirstResponse = -1;
        this.mBasePostRequestInterval = 300;
        this.mEnableExecuteCommandOpt = -1;
        this.mEnableExecuteCommandInExternalThread = -1;
        this.mEnableExecuteStartupGearCommandInExternalThread = -1;
        this.mEnableStartupGearThreadPool = -1;
        this.mStartUpDelay = 0;
        this.mDelayTime = 0;
        this.mCount = 0;
        this.mEnableLSRoomPrecon = -1;
        this.mEnableLSH2QPrecon = -1;
        this.mSocketIdleTimeout = -1;
        this.mEnablePreconnUDPProbe = -1;
        this.mGetIpFromPreconTimeOut = -1;
        this.mEnableLSGetPreconIp = -1;
        this.mEnableLSPrecreate = -1;
        this.mEnableSettingsMgrChar = -1;
        this.mEnableMgrTopN = -1;
        this.mEnableDataWarehouse = -1;
        this.mMaxRetryTimes = 5;
        this.mAutoRetrySyncInterval = 10000;
        this.mEnableJniQueue = -1;
        this.mEnableNativeDns = -1;
        this.mGetHotDomains = -1;
        this.mEnableSetConfigToLiveIO = -1;
        this.mEnableSetNetworkStatus = -1;
        this.mEnableReduceReport = -1;
        this.mEnableSocketAcc = -1;
        this.mEnableNewNativeArch = -1;
        this.mEnableNativeNodeOptimize = -1;
        this.mExecuteCommandTimeout = 100;
        this.mABRStrategyQueueMaxThreshold = 5;
        this.mSupportHotUpdateFunctionNameList = new ArrayList();
        this.mSessionRequestHotUpdateParamsMap = new ConcurrentHashMap();
        this.mAppInfoBundle = null;
        this.mHandler = null;
    }

    public void updateConfigToDB() {
        if (inst().mPersistenceConfigInfo.mConfigTableEnable == 1) goto L5;
        return;
    L5:
        if ((inst().mUpdateCountGlobal % inst().mPersistenceConfigInfo.mConfigTableUpdateLimit) != 0) goto L7;
    L8:
        final ArrayList r100 = new ArrayList();
        if (this.mStrategyConfigJSON == null) goto L12;
        ConfigCacheInfo r101 = new ConfigCacheInfo();
        r101.mSettingsName = ConfigTableOperate.STRATEGY_CONFIG;
        r101.mSettingsValue = this.mStrategyConfigJSON.toString();
        r100.add(r101);
        ConfigTableOperate.mConfigTableCacheInfoMap.put(ConfigTableOperate.STRATEGY_CONFIG, r101);
    L12:
        if (this.mFeatureConfigJSON == null) goto L15;
        ConfigCacheInfo r102 = new ConfigCacheInfo();
        r102.mSettingsName = ConfigTableOperate.FEATURE_CONFIG;
        r102.mSettingsValue = this.mFeatureConfigJSON.toString();
        r100.add(r102);
        ConfigTableOperate.mConfigTableCacheInfoMap.put(ConfigTableOperate.FEATURE_CONFIG, r102);
    L15:
        if (this.mCommonConfigJSON == null) goto L17;
        ConfigCacheInfo r103 = new ConfigCacheInfo();
        r103.mSettingsName = ConfigTableOperate.COMMON_CONFIG;
        r103.mSettingsValue = this.mCommonConfigInfo.toString();
        r100.add(r103);
        ConfigTableOperate.mConfigTableCacheInfoMap.put(ConfigTableOperate.COMMON_CONFIG, r103);
    L17:
        Handler r104 = this.mHandler;
        if (r104 == null) goto L23;
        r104.postDelayed(new AnonymousClass1(this, r100), this.mPersistenceConfigInfo.mConfigTableDelayTime);
        return;
    L23:
        return;
    L7:
        if (inst().mUpdateCountGlobal == 1) goto L8;
    }

    public void updateStrategyAndFeatureConfig() {
        TypeDeviceFeaturesCollector.inst().initFeatureConfig();
        TypeDeviceFeaturesCollector.inst().initGraphicsMonitor();
        TypeNetworkFeaturesCollector.inst().initFeatureConfig();
        TypePlayFeaturesCollector.inst().initFeatureConfig();
        TypePushFeaturesCollector.inst().initFeatureConfig();
        TypeUserProfileCollector.inst().updateOfflineFeatures();
        TransportParamRecommend.inst().initStrategyConfig();
        ProbeStartupBitrate.inst().initStrategyConfig();
        ABRSwitchStrategy.inst().initStrategyConfig();
        SmoothSwitchStrategy.inst().initStrategyConfig();
        SuperResolutionStrategy.inst().initStrategyConfig();
        SuperResolutionStrategy.inst().updateSettings();
        PredictFirstPlayTime.inst().initStrategyConfig();
        PredictShortTimeLeave.inst().initStrategyConfig();
        TopNHostStrategy.inst().initStrategyConfig();
        NetConnectionTypeStrategy.inst().initStrategyConfig();
        StartPlayBufferStrategy.inst().initStrategyConfig();
        NetworkProber.inst().initUdpProbe();
        SocketBufferStrategy.inst().initStrategyConfig();
        CharacterFetchStrategy.inst().initStrategyConfig();
        GetRetryBufferStrategy.inst().initStrategyConfig();
        JSONObject r100 = this.mUidFeatureJSON;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.has("PlayerFeatureParam") == false) goto L11;
        JSONObject r101 = this.mUidFeatureJSON.optJSONObject("PlayerFeatureParam");
        Iterator<String> r102 = r101.keys();
    L8:
        if (r102.hasNext() == false) goto L11;
        String r103 = r102.next();
        String r104 = r103.replaceAll("_", "");
        Object r105 = r101.opt(r103);
        this.mUserParams.put(r104, r105);
    L11:
        if (this.mUidFeatureJSON.has("AnchorFeatureParam") == false) goto L16;
        JSONObject r106 = this.mUidFeatureJSON.optJSONObject("AnchorFeatureParam");
        Iterator<String> r107 = r106.keys();
    L14:
        if (r107.hasNext() == false) goto L16;
        String r108 = r107.next();
        String r109 = r108.replaceAll("_", "");
        Object r110 = r106.opt(r108);
        this.mAnchorParams.put(r109, r110);
    L16:
        TypeUserProfileCollector.inst().updateUserProfile(this.mUidFeatureJSON);
    }

    public IAppInfoBundle getAppInfoBundle() {
        return this.mAppInfoBundle;
    }

    public Map<String, Integer> getmDomainParseType() {
        return this.mDomainParseType;
    }

    public JSONObject getCommonConfigByKey(String r100) {
        JSONObject r101 = this.mCommonConfigJSON;
        if (r101 == null) goto L5;
    L7:
        if (r101 != null) goto L9;
    L11:
        return null;
    L9:
        if (r101.has(r100) == false) goto L11;
        return this.mCommonConfigJSON.optJSONObject(r100);
    L5:
        if (this.mUpdateCountGlobal != 0) goto L7;
        return ConfigTableOperate.getConfigResultFromSettingsValue(ConfigTableOperate.COMMON_CONFIG, r100);
    }

    public JSONArray getNodeInfosByIP(String r100) {
        JSONObject r101 = this.mNodeInfos;
        if (r101 == null) goto L14;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    L5:
        if (r101.has(r100) == false) goto L15;
        return JSONObjectProtectorUtils.getJSONArray(this.mNodeInfos, r100);
    L15:
        return null;
    L14:
        return null;
    }

    public boolean init(SettingsManager.ResponseData r100) {
        if (r100 != null) goto L13;
        return false;
    L13:
        JSONObject r101 = new JSONObject(r100.responseJsonStr);     // Catch: Exception -> L7
    L9:
        if (r101 != null) goto L11;
        return false;
    L11:
        this.mUpdateCountGlobal++;
        SettingsManager.getInstance().initLSSettings(r101.toString(), this);
        this.mCommonConfigInfo.initSettingsConfig();
        updateStrategyAndFeatureConfig();
        checkAndNotifyHotUpdateParams();
        updateConfigToDB();
        VeLSCommonMonitorLogger.onSettingsUpdate(this.mUpdateCountGlobal, r100.statusCode, r100.responseCost, r100.responseJsonStr, this.mRequestId);
        return true;
    L7:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L9
    }

    public void initWithAppInfoBundle(IAppInfoBundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mAppInfoBundle = r100;
        this.mEnableOpenPreconnect = ((Integer) r100.getAppInfoForKey("live_stream_strategy_enable_open_preconnect", 0)).intValue();
        this.mEnablePerformanceOptimization = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_performance_optimization", 0)).intValue();
        this.mStartUpDelay = ((Long) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_start_up_delay", 0L)).longValue();
        this.mEnableLiveIO = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_liveio", 0)).intValue();
        this.mEnableLiveIOEngine = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_liveio_engine", 0)).intValue();
        this.mEnableThreadTimeOut = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_thread_timeout", 1)).intValue();
        this.mEnableLSHotDomainPrecon = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_hot_domain_precnn", 0)).intValue();
        this.mEnableLSRoomPrecon = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_room_info_precnn", 0)).intValue();
        this.mEnableLSH2QPrecon = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_H2Q_precnn", 0)).intValue();
        this.mSocketIdleTimeout = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_socket_idle_timeout", 0)).intValue();
        this.mEnablePreconnUDPProbe = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_precnn_probe", 0)).intValue();
        this.mGetIpFromPreconTimeOut = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_get_precnn_ip_timeout", 0)).intValue();
        this.mEnableLSGetPreconIp = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_get_precnn_ip", 0)).intValue();
        this.mEnableLSPrecreate = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_enable_pre_created_player", 0)).intValue();
        this.mEnableSR = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_super_resolution_enable", 0)).intValue();
        this.mPersistenceConfigInfo.initSettingsConfig((String) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_persistence", ""));
        this.mEnableGetHttpDnsIpFirstResponse = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_stream_strategy_enable_get_httpdns_ip_first", 0)).intValue();
        this.mEnableSettingsMgrChar = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_settingmgr_char", 0)).intValue();
        this.mEnableMgrTopN = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_settingmgr_topn", 0)).intValue();
        this.mEnableDataWarehouse = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_data_warehouse", 0)).intValue();
        this.mEnableGetIpv6HttpDnsIpFirstResponse = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_get_ipv6_httpdns_ip_first", 0)).intValue();
        this.mMaxRetryTimes = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_request_max_retry_times", 5)).intValue();
        this.mAutoRetrySyncInterval = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_request_retry_sync_interval", 10000)).intValue();
        this.mEnableJniQueue = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_new_thread", 0)).intValue();
        this.mEnableNativeDns = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_neptune_player", 0)).intValue();
        this.mGetHotDomains = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_get_hot_domains_first_request", 0)).intValue();
        this.mEnableSetConfigToLiveIO = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_set_config_to_liveio", 0)).intValue();
        this.mEnableSetNetworkStatus = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_set_network_status", 0)).intValue();
        this.mEnableReduceReport = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_reduce_report", 0)).intValue();
        this.mEnableSocketAcc = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_socket_acc", 0)).intValue();
        this.mEnableNewNativeArch = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_native_arch", 0)).intValue();
        this.mEnableNativeNodeOptimize = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_native_node_opt", 0)).intValue();
        this.mExecuteCommandTimeout = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_execute_command_timeout", 100)).intValue();
        this.mABRStrategyQueueMaxThreshold = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_abr_queue_max_threshold", 5)).intValue();
        this.mEnableExecuteCommandOpt = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_execute_cmd_opt", 0)).intValue();
        this.mEnableExecuteCommandInExternalThread = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_execute_cmd_in_external_thread", 0)).intValue();
        this.mEnableExecuteStartupGearCommandInExternalThread = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_execute_startup_cmd_in_external_thread", 0)).intValue();
        this.mEnableStartupGearThreadPool = ((Integer) this.mAppInfoBundle.getAppInfoForKey("live_sdk_enable_startup_gear_threadpool", 0)).intValue();
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    public void updateSettingsFromNative(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.mUpdateCountGlobal++;
        this.mCommonConfigJSON = r100.optJSONObject("CommonConfig");
        this.mSettings = r100.optJSONObject("Settings");
        this.mStrategyConfigJSON = r100.optJSONObject("StrategyConfig");
        this.mCommonConfigInfo.initSettingsConfig();
        updateStrategyAndFeatureConfig();
        checkAndNotifyHotUpdateParams();
        updateConfigToDB();
    }

    public <T> T getAppInfoForKey(String r100, T r101) {
        IAppInfoBundle r102 = this.mAppInfoBundle;
        if (r102 != null) goto L5;
        return r101;
    L5:
        return (T) r102.getAppInfoForKey(r100, r101);
    }

    public JSONObject getGlobalStaticSettingsBundleByProjectKey(String r100, int r101) {
        JSONObject r102 = this.mSettings;
        if (r102 != null) goto L24;
        return null;
    L24:
    L21:
        e = move-exception;
        e.printStackTrace();
    L23:
        return null;
    L6:
        if (r102.has("BatchSettingsParams") == false) goto L23;
        String r103 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(this.mSettings, "BatchSettingsParams"), PROJECT_KEY).optString(r100);     // Catch: JSONException -> L21
        if (r103 != null) goto L10;
    L12:
        JSONObject r104 = new JSONObject(r103);     // Catch: JSONException -> L21
        if (r101 != 0) goto L15;
        JSONObject r105 = new JSONObject();     // Catch: JSONException -> L21
        r105.put("LivePlayerSettings", this.mCommonConfigInfo.mLivePlayerSettingsJSON);     // Catch: JSONException -> L21
        r105.put("LSStrategySDKSettings", this.mCommonConfigInfo.mLSStrategySDKSettingsJSON);     // Catch: JSONException -> L21
        r105.put("StrategyConfig", this.mStrategyConfigJSON);     // Catch: JSONException -> L21
        return r105;
    L15:
        if (r101 == 3) goto L18;
        return r104;
    L18:
        return this.mCommonConfigInfo.mRTMPlayerSettingsJSON;
    L10:
        if (r103.startsWith("\ufeff") == false) goto L12;
        r103 = r103.substring(1);     // Catch: JSONException -> L21
        goto L12
    }

    public Object getGlobalStaticSettingsByKey(String r100, String r101) {
        JSONObject r102 = this.mResult;
        if (r102 != null) goto L5;
        return null;
    L5:
        r102.toString();
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        return null;
    L7:
        if (this.mResult.has("Settings") == false) goto L21;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(this.mResult, "Settings");     // Catch: JSONException -> L19
        if (r103.has("BatchSettingsParams") == false) goto L21;
        String r104 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r103, "BatchSettingsParams"), PROJECT_KEY).optString(r100);     // Catch: JSONException -> L19
        if (r104 != null) goto L13;
    L15:
        JSONObject r105 = new JSONObject(r104);     // Catch: JSONException -> L19
        if (r105.has(r101) == false) goto L21;
        return r105.get(r101);
    L13:
        if (r104.startsWith("\ufeff") == false) goto L15;
        r104 = r104.substring(1);     // Catch: JSONException -> L19
        goto L15
    }

    public String getUidFeatureByKey(String r100, String r101) {
        JSONObject r102 = this.mUidFeatureJSON;
        if (r102 != null) goto L5;
        return null;
    L5:
        r102.toString();
    L12:
        e = move-exception;
        e.printStackTrace();
    L14:
        return null;
    L7:
        if (this.mUidFeatureJSON.has(r101) == false) goto L14;
        JSONObject r103 = JSONObjectProtectorUtils.getJSONObject(this.mUidFeatureJSON, r101);     // Catch: JSONException -> L12
        if (r103.has(r100) == false) goto L14;
        return r103.optString(r100);
    }
}
