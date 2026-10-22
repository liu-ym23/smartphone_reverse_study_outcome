package com.ss.videoarch.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.huawei.hms.framework.common.ContainerUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.vcbkit.VCBaseKitLoader;
import com.ss.videoarch.strategy.base.ABRStrategyExecutor;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.config.PlatformDataFetcher;
import com.ss.videoarch.strategy.dataCenter.strategyData.DataWarehouse;
import com.ss.videoarch.strategy.dataCenter.strategyData.HistoryTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLiteWrapper;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.SessionCacheInfos;
import com.ss.videoarch.strategy.featureCenter.FeatureFactory;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePlayFeaturesCollector;
import com.ss.videoarch.strategy.featureCenter.featureType.TypePushFeaturesCollector;
import com.ss.videoarch.strategy.log.StrategyCenterLogger;
import com.ss.videoarch.strategy.log.VeLSCommonMonitorLogger;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseLogInfo;
import com.ss.videoarch.strategy.network.LSNetworkManager;
import com.ss.videoarch.strategy.network.LSSDKConfig;
import com.ss.videoarch.strategy.network.LSSettingsApi;
import com.ss.videoarch.strategy.network.NetworkMonitorLoader;
import com.ss.videoarch.strategy.strategy.liveio.LiveIOEngine;
import com.ss.videoarch.strategy.strategy.liveio.SocketAccStrategyBridge;
import com.ss.videoarch.strategy.strategy.mpdPreload.MpdPreloadManager;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnDataHandle;
import com.ss.videoarch.strategy.strategy.networkStrategy.LSPreconnManager;
import com.ss.videoarch.strategy.strategy.networkStrategy.MultiPath;
import com.ss.videoarch.strategy.strategy.networkStrategy.NetworkProber;
import com.ss.videoarch.strategy.strategy.networkStrategy.SettingsManager;
import com.ss.videoarch.strategy.strategy.nodeOptimizer.DnsOptimizer;
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
import com.ss.videoarch.strategy.strategy.smartStrategy.SuperResolution;
import com.ss.videoarch.strategy.strategy.smartStrategy.SuperResolutionStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import com.ss.videoarch.strategy.strategy.smartStrategy.TransportParamRecommend;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.JniTask;
import com.ss.videoarch.strategy.utils.LibraryLoader;
import com.ss.videoarch.strategy.utils.TTClassLoad;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class LiveStrategyManager extends NativeObject implements ILiveStrategyCenter {
    private static final int MSG_WHAT_CHAR_FETCH_CLOCK = 1029;
    private static final int MSG_WHAT_PTY_INIT = 1028;
    private static final int MSG_WHAT_RECEIVE_PTY_CALLBACK = 1026;
    public static final int MSG_WHAT_REFRESH = 1024;
    private static final int MSG_WHAT_RT_FEATURES_CLOCK = 1027;
    private static final int MSG_WHAT_SR_PREDICT = 1025;
    static final String TAG = "VeLs";
    private static final long TTL_MIN_THRES = 300000;
    private static boolean mIsSetAppInfoBundle = false;
    private static List<String> mLibraryList = null;
    public static LiveIOEngine mLiveIOEngine = null;
    public static long mLoadLibraryTime = -1;
    private static boolean mLoadSoSuccess = false;
    public static SuperResolution mSRPredictEngine = null;
    private static long mStartStrategyTime = -1;
    private static volatile LiveStrategyManager sInstance;
    private ABRStrategyExecutor mABRExprExecutor;
    public Intent mBatteryIntent;
    private Handler mChildHandler;
    public Context mContext;
    public String mDeviceId;
    private boolean mDidLocalDNS;
    private IFunctionCalledByStrategyEngine mEngine;
    public boolean mFirstStart;
    private boolean mFirstUpdate;
    private IFunctionStartPTYInit mFunctionStartPTYInit;
    public Handler mHandler;
    public Map<Integer, IAppInfoBundle> mHashCodeToBundleMap;
    public JSONObject mInitInfo;
    public boolean mIsRunning;
    private final LSPreconnManager.OnPreconnMessageListener mLSPreconnListener;
    public long mLastEndTS;
    private String mLatestSessionId;
    public Map<String, IAppInfoBundle> mListenerMap;
    private boolean mLiveioStarted;
    private int mNetworkStatus;
    private DnsOptimizer.OnDoPreconnectListener mOnDoPreconnectListener;
    private DnsOptimizer.OnParseDnsCompletionListener mOnParseDnsCompletionListener;
    private Boolean mPTYSetUpAlready;
    public int mReceiveMessage;
    private Boolean mRetryFlag;
    private LSSettingsApi.Listener mSettingsListener;
    private ThreadPoolExecutor mStartupStrategyExecutor;
    public long mTTLMs;
    private ThreadPoolExecutor mThreadPool;
    private final Set<Integer> mVoidCommandSet;
    private final BroadcastReceiver networkReceiver;

    public static class StrategyThreadFactory implements ThreadFactory {
        private final String mPrefix;
        private final ThreadGroup mThreadGroup;
        private final AtomicInteger mThreadNumber;

        private StrategyThreadFactory() {
            this.mThreadNumber = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.mThreadGroup = r101;
            this.mPrefix = "live-stream-strategy-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        private StrategyThreadFactory(String r100) {
            this.mThreadNumber = new AtomicInteger(1);
            SecurityManager r101 = System.getSecurityManager();
            if (r101 == null) goto L5;
            ThreadGroup r102 = r101.getThreadGroup();
        L6:
            this.mThreadGroup = r102;
            this.mPrefix = r100;
            return;
        L5:
            r102 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r100) {
            PthreadThreadV2 r101 = new PthreadThreadV2(this.mThreadGroup, r100, this.mPrefix + this.mThreadNumber.getAndIncrement(), 0);
            if (r101.isDaemon() == false) goto L6;
            r101.setDaemon(false);
        L6:
            if (r101.getPriority() == 1) goto L8;
            ThreadMethodProxy.setPriority(r101, 1);
        L8:
            return r101;
        }

        public /* synthetic */ StrategyThreadFactory(AnonymousClass1 r100) {
            this();
        }

        public /* synthetic */ StrategyThreadFactory(String r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static /* synthetic */ JSONObject a(LiveStrategyManager r100, JSONObject r101) {
        return r100.lambda$executeCommandPerfOpt$1(r101);
    }

    public static /* synthetic */ void b(LiveStrategyManager r100, int r101, int r102, int r103, JSONObject r104) {
        r100.lambda$executeCommand$0(r101, r102, r103, r104);
    }

    public static /* synthetic */ JSONObject c(LiveStrategyManager r100, int r101, JSONObject r102, int r103, int r104) {
        return r100.lambda$executeCommandPerfOpt$2(r101, r102, r103, r104);
    }

    private native void nativeAddPlayFeatureBundle(String r100, FeatureBundleBridge r101);

    private native void nativeCreate();

    private native String nativeExecuteCommand(int r100, int r101, int r102, String r103);

    private native JSONObject nativeExecuteCommandOpt(int r100, int r101, int r102, JSONObject r103);

    private native void nativeRemovePlayFeatureBundle(String r100);

    private native void nativeSetAppInfoBundle(FeatureBundleBridge r100);

    private native void nativeSetNextRoomInfo(String r100, int r101, long r102);

    private native void nativeSetSocketAccBridge(SocketAccStrategyBridge r100);

    private native void nativeSetStreamInfo(String r100);

    private native void nativeStart();

    private native void nativeStartPreProcessor(String r100, String r101, String r102);

    private native void nativeStartStrategy(JSONObject r100);

    private native void nativeStop();

    private native void nativeStopSession(JSONObject r100);

    private void onLiveIOStarted() {
        this.mLiveioStarted = true;
        if (this.mIsRunning == true) goto L10;
        return;
    L10:
        JSONObject r100 = new JSONObject();     // Catch: Exception -> L7
        r100.put("liveio_started", 1);     // Catch: Exception -> L7
        MultiPath.getInstance().notifyMultiPathChange(r100);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public <T> T getInfo(String r100, T r101) {
        return null;
    }

    public static LiveStrategyManager inst() {
        if (sInstance != null) goto L15;
        monitor-enter(LiveStrategyManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LiveStrategyManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LiveStrategyManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void loadNativeLib() {
        if (mLoadSoSuccess == false) goto L5;
        return;
    L5:
        VCBaseKitLoader.loadLibrary();
        List r100 = Arrays.asList(new String[]{"livestrategy"});
        ArrayList r101 = new ArrayList();
        mLibraryList = r101;
        r101.addAll(r100);
        Iterator<String> r102 = mLibraryList.iterator();
    L7:
        if (r102.hasNext() == false) goto L10;
        mLoadSoSuccess = loadLibrary(r102.next(), this.mContext);
        goto L7
    L10:
        if (mLoadLibraryTime != (-1)) goto L12;
        mLoadLibraryTime = System.currentTimeMillis();
    L12:
        VeLSUtils.setLoadSoSuccess(mLoadSoSuccess);
    }

    private void updateNetStateToNative() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        int r100 = NetworkMonitorLoader.getNativeNetworkType(this.mContext);
        JSONObject r101 = new JSONObject();
        r101.put("net_type", r100);     // Catch: JSONException -> L8
    L10:
        if (LSSettings.inst().mEnableNewNativeArch != 1) goto L15;
        r101.toString();
        nativeExecuteCommandOpt(1001, 30002, 0, r101);
        return;
    }

    public void createHandleForChildThread() {
        final Looper r100 = Looper.myLooper();
        this.mHandler = new AnonymousClass9(this, r100);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public String getStrategyCenterABTraceInfo() {
        if (this.mIsRunning == true) goto L7;
        return "";
    L7:
        return LSSettings.inst().getStrategyABInfo();
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public String getStrategyCenterCommonTraceInfo() {
        if (this.mIsRunning == true) goto L7;
        return "";
    L7:
        return LSSettings.inst().getStrategyCommonInfo();
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void start() {
        if (this.mIsRunning == false) goto L5;
        return;
    L5:
        this.mIsRunning = true;
        INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.networkReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        AnonymousClass1 r100 = null;
        this.mBatteryIntent = INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (LSSettings.inst().mEnableNewNativeArch != 1) goto L13;
        if (mIsSetAppInfoBundle == true) goto L13;
        if (LSSettings.inst().getAppInfoBundle() == null) goto L13;
        newNativeStrategyStart(LSSettings.inst().getAppInfoBundle());
    L13:
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L22;
        if (LSSettings.inst().mPersistenceConfigInfo.mHisTableEnable != 1) goto L22;
        HistoryTableOperate.setContext(this.mContext);
        List<SessionCacheInfos> r101 = HistoryTableOperate.getSPData();
        if (r101 == null) goto L22;
        if (r101.size() <= 0) goto L22;
        HistoryTableOperate.replaceAllRecord(r101);
        HistoryTableOperate.clearCacheData();
    L22:
        if (LSSettings.inst().mEnableStartupGearThreadPool != 1) goto L24;
        this.mStartupStrategyExecutor = new PThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new StrategyThreadFactory("live-startupgear-strategy", r100));
    L24:
        BaseLogInfo.inst().mSDKStartCostTime = System.currentTimeMillis() - mLoadLibraryTime;
        if (LSSettings.inst().mEnableReduceReport == 1) goto L28;
        VeLSCommonMonitorLogger.onSDKStart();
    L28:
        if (LSSettings.inst().mEnableOpenPreconnect != 1) goto L46;
        DnsOptimizer.inst().setDoPreconnListener(this.mOnDoPreconnectListener);
        if (LSSettings.inst().mEnableLiveIO != 1) goto L35;
        if (LSSettings.inst().mEnableLiveIOEngine != 1) goto L35;
        LiveIOEngine r102 = new LiveIOEngine(this.mEngine);
        mLiveIOEngine = r102;
        r102.setLiveIOPreconnConfig(this.mContext.getFilesDir().getAbsolutePath() + "/pullstream.scfg");
    L35:
        if (LSSettings.inst().mEnableLSHotDomainPrecon != 1) goto L37;
    L38:
        LSPreconnManager.inst().setListener(this.mLSPreconnListener);
        LSPreconnManager.inst().setAppInfoBundle(this.mContext);
        loadQuicLibrary();
        if (mLoadSoSuccess == false) goto L46;
        LSPreconnDataHandle.PreconnToggles r103 = new LSPreconnDataHandle.PreconnToggles();
        if (LSSettings.inst().mEnableLSH2QPrecon != 1) goto L43;
        boolean r104 = true;
    L44:
        r103.enableTTQuicH2Q = r104;
        r103.socketIdleTimeoutMs = LSSettings.inst().mSocketIdleTimeout;
        r103.getPreconnIpTimeout = LSSettings.inst().mGetIpFromPreconTimeOut;
        r103.enablePrecreate = LSSettings.inst().mEnableLSPrecreate;
        LSPreconnManager.inst().setLSConnectToggles(r103);
        goto L46
    L43:
        r104 = false;
        goto L44
    L37:
        if (LSSettings.inst().mEnableLSRoomPrecon == 1) goto L38;
    L46:
        if (LSSettings.inst().mEnableSR != 1) goto L49;
        SuperResolution r105 = new SuperResolution();
        mSRPredictEngine = r105;
        r105.init();
    L49:
        if (LSSettings.inst().mEnablePerformanceOptimization != 1) goto L51;
        this.mThreadPool.execute(new AnonymousClass8(this));
    L53:
        if (mLoadSoSuccess == false) goto L60;
        nativeStart();
        JniTask.getInstance().Start();
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L61;
        SettingsManager.getInstance().loadDB();
        if (this.mDidLocalDNS == true) goto L62;
        DnsOptimizer.inst().doPreDnsOperate(TopNHostStrategy.inst().runStrategy());
        return;
    L62:
        return;
    L61:
        return;
    L60:
        return;
    L51:
        LSNetworkManager.inst().settingsApi().postHttpRequest(null, false);
        goto L53
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void stop() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        this.mIsRunning = false;
        this.mHandler.removeMessages(1024);
        this.mHandler.removeMessages(1025);
        this.mHandler.removeMessages(1026);
        INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(this.mContext, this.networkReceiver);
        this.mHandler.post(new AnonymousClass10(this));
        if (this.mSettingsListener == null) goto L9;
        LSNetworkManager.inst().settingsApi().removeListener(this.mSettingsListener);
        this.mSettingsListener = null;
    L9:
        if (mLoadSoSuccess == false) goto L11;
        nativeStop();
    L11:
        ABRStrategyExecutor r100 = this.mABRExprExecutor;
        if (r100 != null) goto L14;
    L16:
        ThreadPoolExecutor r101 = this.mStartupStrategyExecutor;
        if (r101 != null) goto L19;
        return;
    L19:
        if (r101.isShutdown() == true) goto L23;
        this.mStartupStrategyExecutor.shutdown();
        return;
    L23:
        return;
    L14:
        if (r100.isShutdown() == true) goto L16;
        this.mABRExprExecutor.shutdown();
        goto L16
    }

    public LiveStrategyManager() {
        this.mTTLMs = 300000;
        this.mReceiveMessage = 0;
        this.mLastEndTS = 0;
        this.mIsRunning = false;
        this.mSettingsListener = null;
        Boolean r100 = Boolean.FALSE;
        this.mRetryFlag = r100;
        this.mEngine = null;
        this.mPTYSetUpAlready = r100;
        this.mABRExprExecutor = null;
        this.mListenerMap = new ConcurrentHashMap();
        this.mHashCodeToBundleMap = new ConcurrentHashMap();
        this.mFirstStart = true;
        this.mFirstUpdate = true;
        this.mChildHandler = null;
        this.mDeviceId = "";
        this.mDidLocalDNS = false;
        this.mLatestSessionId = "";
        this.mNetworkStatus = 0;
        this.mLiveioStarted = false;
        this.mStartupStrategyExecutor = null;
        this.mVoidCommandSet = new HashSet();
        this.mOnParseDnsCompletionListener = new AnonymousClass2(this);
        this.mOnDoPreconnectListener = new AnonymousClass3(this);
        this.mLSPreconnListener = new AnonymousClass4(this);
        final Looper r101 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass5(this, r101);
        this.networkReceiver = new AnonymousClass6(this);
        TTClassLoad.init();
    }

    private int getSuggestSendingRate() {
        int r100 = 0;
        JSONObject r101 = (JSONObject) inst().getConfigAndStrategyByKeyInt(0, 20, null, new JSONObject());
        if (r101 == null) goto L17;
        Iterator<String> r102 = r101.keys();
        String r103 = "";
    L6:
        if (r102.hasNext() == false) goto L17;
        String r104 = String.valueOf(r102.next());
        String r105 = r101.optString(r104);
        if (TextUtils.equals(r104, "BandwidthDecision") == true) goto L6;
        if (TextUtils.equals(r104, "Bandwidth") == false) goto L14;
        r100 = CastIntegerProtector.valueOf(r105).intValue();
    L14:
        if (r103.equals("") == true) goto L16;
        r103 = r103.concat("&");
    L16:
        r103 = r103 + r104 + ContainerUtils.KEY_VALUE_DELIMITER + r105;
    L17:
        return r100;
    }

    private void loadQuicLibrary() {
        if (loadLibrary("vcbasekit") == true) goto L5;
        return;
    L5:
        loadLibrary("ttquic");
    }

    private void updateGlobalSettings() {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptAsync == 1) goto L17;
        if (this.mFirstUpdate == false) goto L13;
        this.mFirstUpdate = false;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDnsOptimizer != 1) goto L9;
        DnsOptimizer.inst().setOnParseDnsCompletionListener(this.mOnParseDnsCompletionListener);
    L9:
        StartPlayBufferStrategy.inst().computeBufferOffset();
        Handler r100 = this.mChildHandler;
        if (r100 == null) goto L12;
        initPitaya(r100);
        goto L13
    L12:
        initPitaya(this.mHandler);
    L13:
        SuperResolution r101 = mSRPredictEngine;
        if (r101 == null) goto L20;
        r101.updateSettings();
    L20:
        long r102 = 300000;
        if ((LSSettings.inst().mBasePostRequestInterval * 1000) < 300000) goto L24;
        r102 = LSSettings.inst().mBasePostRequestInterval * 1000;
    L24:
        this.mTTLMs = r102;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDnsOptimizer != 1) goto L27;
        DnsOptimizer.inst().updateDnsResult(null);
    L27:
        this.mHandler.removeMessages(1024);
        this.mHandler.sendEmptyMessageDelayed(1024, this.mTTLMs);
        return;
    L17:
        if (this.mFirstUpdate == false) goto L19;
        this.mFirstUpdate = false;
        this.mThreadPool.execute(new AnonymousClass12(this));
    L19:
        this.mThreadPool.execute(new AnonymousClass13(this));
        goto L20
    }

    public boolean isLiveIOStarted() {
        return this.mLiveioStarted;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static /* synthetic */ DnsOptimizer.OnParseDnsCompletionListener access$000(LiveStrategyManager r100) {
        return r100.mOnParseDnsCompletionListener;
    }

    public static /* synthetic */ IFunctionStartPTYInit access$100(LiveStrategyManager r100) {
        return r100.mFunctionStartPTYInit;
    }

    public static /* synthetic */ ThreadPoolExecutor access$200(LiveStrategyManager r100) {
        return r100.mThreadPool;
    }

    public static /* synthetic */ void access$300(LiveStrategyManager r100) {
        r100.updateNetStateToNative();
    }

    public static /* synthetic */ boolean access$400(Context r100) {
        return isNetworkAvailable(r100);
    }

    public static /* synthetic */ void access$500(LiveStrategyManager r100) {
        r100.updateGlobalSettings();
    }

    public static /* synthetic */ Handler access$800(LiveStrategyManager r100) {
        return r100.mChildHandler;
    }

    private String getStrategyConfigByName(String r100) {
        if (LSSettings.inst().mStrategyConfigJSON != null) goto L7;
        return "";
    L7:
        return SettingsManager.getInstance().getStrategyConfigByName(LSSettings.inst().mStrategyConfigJSON.toString(), r100);
    }

    private static boolean isNetworkAvailable(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L12
        if (r101 != null) goto L6;
        return false;
    L6:
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L12
        if (r102 == null) goto L17;
        if (r102.isConnected() == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L12:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private /* synthetic */ JSONObject lambda$executeCommandPerfOpt$1(JSONObject r100) throws Exception {
        return processStartupGearStrategy(r100);
    }

    private static boolean loadLibrary(String r100) {
        LibraryLoader.loadLibrary(r100);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        th.getMessage();
        return false;
    }

    private void newNativeStrategyStart(IAppInfoBundle r100) {
        if (this.mIsRunning == true) goto L6;
        return;
    L6:
        if (mLoadSoSuccess == true) goto L8;
        return;
    L8:
        if (r100 != null) goto L10;
        return;
    L10:
        LSSDKConfig r101 = LSNetworkManager.inst().getSDKConfig();
        int r102 = NetworkMonitorLoader.getNativeNetworkType(this.mContext);
        JSONObject r103 = new JSONObject();     // Catch: JSONException -> L21
        Iterator<String> r104 = this.mInitInfo.keys();     // Catch: JSONException -> L21
    L13:
        if (r104.hasNext() == false) goto L15;
        String r105 = r104.next();     // Catch: JSONException -> L21
        r103.put(r105, this.mInitInfo.get(r105));     // Catch: JSONException -> L21
        goto L13
    L15:
        if (r101 != null) goto L17;
    L19:
        r103.put("net_type", r102);     // Catch: JSONException -> L21
        mIsSetAppInfoBundle = true;     // Catch: JSONException -> L21
        nativeSetAppInfoBundle(new FeatureBundleBridge(r100, FeatureBundleBridge.kSourceAppType));     // Catch: JSONException -> L21
        nativeStartStrategy(r103);     // Catch: JSONException -> L21
        return;
    L17:
        if (TextUtils.isEmpty(r101.getApiHost()) == true) goto L19;
        r103.put("neptune_host", r101.getApiHost());     // Catch: JSONException -> L21
    L21:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private JSONObject processStartupGearStrategy(JSONObject r110) {
        long r100 = System.nanoTime() / 1000;
        JSONObject r101 = null;
        if (r110 != null) goto L17;
    L10:
        r101 = nativeExecuteCommandOpt(4, 2, -1, r110);     // Catch: JSONException -> L14
        long r102 = (System.nanoTime() / 1000) - r100;     // Catch: JSONException -> L14
        if (r101 == null) goto L16;
        r101.put("execute_cost", r102);     // Catch: JSONException -> L14
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        return r101;
    L17:
        if (this.mContext == null) goto L10;
        JSONObject r103 = r110.optJSONObject("extra_info");     // Catch: JSONException -> L14
        if (r103 != null) goto L9;
        r103 = new JSONObject();     // Catch: JSONException -> L14
    L9:
        DisplayMetrics r104 = INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources());     // Catch: JSONException -> L14
        r103.put("screen_size", r104.widthPixels + "x" + r104.heightPixels);     // Catch: JSONException -> L14
        r110.put("extra_info", r103);     // Catch: JSONException -> L14
        goto L10
    }

    private void releaseHashCodeToBundleMap(String r100) {
        if (LSSettings.inst().mEnableSetConfigToLiveIO == 1) goto L5;
        return;
    L5:
        IAppInfoBundle r101 = this.mListenerMap.get(r100);
        if (r101 == null) goto L9;
        Integer r102 = (Integer) r101.getAppInfoForKey("HashCode", 0);
        this.mHashCodeToBundleMap.remove(r102);
        return;
    }

    private void removeFeatureBundleToNative(String r100) {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        nativeRemovePlayFeatureBundle(r100);
    }

    private void sendEmptyMsg(final int r100) {
        if (LSSettings.inst().mEnablePerformanceOptimization != 1) goto L7;
        ThreadPoolExecutor r101 = this.mThreadPool;
        if (r101 == null) goto L7;
        r101.execute(new AnonymousClass1(this, r100));
        return;
    L7:
        this.mHandler.removeMessages(r100);
        this.mHandler.sendEmptyMessage(r100);
    }

    private void setDeviceFeature(JSONObject r100) {
        nativeExecuteCommandOpt(0, 408, 0, r100);
    }

    private void setHashCodeToBundleMap(IAppInfoBundle r100) {
        if (LSSettings.inst().mEnableSetConfigToLiveIO == 1) goto L5;
        return;
    L5:
        if (r100 == null) goto L8;
        Integer r101 = (Integer) r100.getAppInfoForKey("HashCode", 0);
        this.mHashCodeToBundleMap.put(r101, r100);
        return;
    }

    private void setNetworkStatus(JSONObject r100) {
        if (r100 != null) goto L20;
        return;
    L20:
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        int r101 = this.mNetworkStatus;
        if (r101 != 0) goto L15;
    L18:
        fireNotifyToPlayer("NetworkStatusChange", Integer.valueOf(r101), "");
        return;
    L15:
        if (r101 == 1) goto L18;
        if (r101 == 2) goto L18;
        return;
    L5:
        if (r100.has("multipath_network_status") == false) goto L22;
        this.mNetworkStatus = r100.optInt("multipath_network_status");     // Catch: Exception -> L10
        goto L12
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void doLocalDnsOperator(Context r100) {
        this.mDidLocalDNS = true;
        StrategySQLiteWrapper.inst(r100);
        DataWarehouse.init(r100);
        SettingsManager.getInstance().loadDB();
        JSONObject r101 = TopNHostStrategy.inst().runStrategy();
        DnsOptimizer.inst().doPreDnsOperate(r101);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public String getPreconnResult(String r100) {
        if (mLoadSoSuccess == true) goto L6;
        return "";
    L6:
        if (LSSettings.inst().mEnableLSRoomPrecon == 1) goto L8;
        return "";
    L8:
        if (LSSettings.inst().mEnableLSGetPreconIp == 1) goto L10;
        return "";
    L10:
        return LSPreconnManager.inst().getPreconnIp(r100);
    }

    public void initPitaya(Handler r100) {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUsePTY != 1) goto L8;
        PitayaWrapper.inst().setHandler(this.mHandler);
        PitayaWrapper r101 = PitayaWrapper.inst();
        r101.mEnableInitByStrategy = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableInitPtyByStrategy;
        PitayaWrapper r102 = PitayaWrapper.inst();
        Context r103 = this.mContext;
        JSONObject r104 = this.mInitInfo;
        BaseLogInfo.inst();
        r102.init(r103, r104, BaseLogInfo.REAL_SDK_APP_ID);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRegisterPtyFeatureCenter != 1) goto L9;
        PitayaWrapper.inst().registerPTYFeatureProducer();
        return;
    L9:
        return;
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void releaseFeatureDataBundle(String r100) {
        releaseHashCodeToBundleMap(r100);
        this.mListenerMap.remove(r100);
        removeFeatureBundleToNative(r100);
        this.mListenerMap.size();
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setAppInfoBundle(IAppInfoBundle r100) {
        LSSettings.inst().initWithAppInfoBundle(r100);
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L6;
        StrategySQLiteWrapper.inst(this.mContext);
    L6:
        if (LSSettings.inst().mEnableSocketAcc == 1) goto L8;
    L10:
        StrategyCenterLogger.init(this.mContext, this.mInitInfo);
        PlatformDataFetcher.init(r100);
        if (r100 != null) goto L13;
        return;
    L13:
        if (((Integer) r100.getAppInfoForKey("live_sdk_enable_mpd_prelaod", 0)).intValue() != 1) goto L16;
        MpdPreloadManager.getInstance().init(this.mContext);
    L16:
        if (((Integer) r100.getAppInfoForKey("live_sdk_enable_data_warehouse", 0)).intValue() != 1) goto L19;
        DataWarehouse.init(this.mContext);
    L19:
        if (LSSettings.inst().mEnableNewNativeArch != 1) goto L23;
        newNativeStrategyStart(r100);
        return;
    L23:
        return;
    L8:
        if (mLoadSoSuccess == false) goto L10;
        nativeSetSocketAccBridge(new SocketAccStrategyBridge());
        goto L10
    }

    public String setConfigToLiveIO(String r100) {
        if (mLoadSoSuccess == true) goto L7;
        return "";
    L7:
        return nativeExecuteCommand(0, 54, 0, r100);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setFunctionStartPTYInit(IFunctionStartPTYInit r100) {
        this.mFunctionStartPTYInit = r100;
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setIFunctionCalledByStrategyEngine(IFunctionCalledByStrategyEngine r100) {
        Objects.toString(r100);
        this.mEngine = r100;
        LiveIOEngine r101 = mLiveIOEngine;
        if (r101 == null) goto L6;
        r101.setIFunctionCalledByStrategyEngine(r100);
        return;
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setSupportSRScene(boolean r100) {
        if (mSRPredictEngine != null) goto L5;
    L7:
        SuperResolutionStrategy.inst().setSupportSRScene(r100);
        return;
    L5:
        if (SuperResolutionStrategy.inst().getEnableDynamicSR() == true) goto L7;
        mSRPredictEngine.setSupportSRScene(r100);
        goto L7
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void stopSession(JSONObject r100) {
        if (mLoadSoSuccess == false) goto L6;
        nativeStopSession(r100);
    L6:
        if (mSRPredictEngine != null) goto L8;
    L11:
        SuperResolution.inst().stopSession(r100);
        return;
    L8:
        if (SuperResolutionStrategy.inst().getEnableDynamicSR() == true) goto L11;
        mSRPredictEngine.stopSession(r100);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void triggerSRPredict(JSONObject r100) {
        if (mSRPredictEngine != null) goto L5;
    L8:
        SuperResolutionStrategy.inst().triggerSRPredict(r100);
        return;
    L5:
        if (SuperResolutionStrategy.inst().getEnableDynamicSR() == true) goto L8;
        mSRPredictEngine.triggerSRPredict(r100);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ void access$1100(LiveStrategyManager r100, JSONObject r101) {
        r100.setDeviceFeature(r101);
    }

    public static /* synthetic */ Handler access$802(LiveStrategyManager r100, Handler r101) {
        r100.mChildHandler = r101;
        return r101;
    }

    public static /* synthetic */ void access$900(LiveStrategyManager r100, JSONObject r101) {
        r100.setNetworkStatus(r101);
    }

    private static boolean loadLibrary(String r100, Context r101) {
        LibraryLoader.loadLibrary(r100, r101);     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        th.getMessage();
        return false;
    }

    private void setFeatureBundleToNative(String r100, IAppInfoBundle r101) {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        nativeAddPlayFeatureBundle(r100, new FeatureBundleBridge(r101, FeatureBundleBridge.kSourceFeatureType));
    }

    public <T> T getAppInfoForKey(String r100, T r101) {
        if (r100 != null) goto L4;
        return r101;
    L4:
        return (T) LSSettings.inst().getAppInfoForKey(r100, r101);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public String getConfigAndStrategyBundle(int r100, JSONObject r101) {
        if (this.mIsRunning == true) goto L5;
        return null;
    L5:
        if (r100 != 0) goto L7;
    L12:
        TypePlayFeaturesCollector.inst().setCurCallerInfo(r101);
        String r102 = "2";
    L13:
        if (r102 == null) goto L18;
        JSONObject r103 = LSSettings.inst().getGlobalStaticSettingsBundleByProjectKey(r102, r100);
        if (r103 == null) goto L18;
        return r103.toString();
    L18:
        return null;
    L7:
        if (r100 != 1) goto L9;
        TypePushFeaturesCollector.inst().setCurCallerInfo(r101);
        r102 = "1";
        goto L13
    L9:
        if (r100 == 3) goto L12;
        r102 = null;
        goto L13
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public JSONObject getConfigAndStrategyJson(int r100, JSONObject r101) {
        if (this.mIsRunning == true) goto L5;
        return null;
    L5:
        if (r100 != 0) goto L7;
    L12:
        TypePlayFeaturesCollector.inst().setCurCallerInfo(r101);
        String r102 = "2";
    L13:
        if (r102 != null) goto L15;
        return null;
    L15:
        return LSSettings.inst().getGlobalStaticSettingsBundleByProjectKey(r102, r100);
    L7:
        if (r100 != 1) goto L9;
        TypePushFeaturesCollector.inst().setCurCallerInfo(r101);
        r102 = "1";
        goto L13
    L9:
        if (r100 == 3) goto L12;
        r102 = null;
        goto L13
    }

    public float getFloatValue(int r100, float r101) {
        if (r100 == 12) goto L5;
        String r102 = null;
    L9:
        return ((Float) getAppInfoForKey(r102, Float.valueOf(r101))).floatValue();
    L11:
        return r101;
    L5:
        r102 = "attenuation_coefficient";
        goto L9
    }

    public long getInt64Value(String r100, long r101) {
        return ((Long) getAppInfoForKey(r100, Long.valueOf(r101))).longValue();
    }

    public int getIntValue(int r100, int r101) {
        switch(r100) {
            case 9: goto L6;
            case 10: goto L5;
            case 11: goto L4;
            default: goto L3;
        };
    L3:
        String r102 = null;
    L8:
        return ((Integer) getAppInfoForKey(r102, Integer.valueOf(r101))).intValue();
    L4:
        r102 = "attenuation_time_offset";
        goto L8
    L5:
        r102 = "max_start_play_buffer";
        goto L8
    L6:
        r102 = "min_start_play_buffer";
        goto L8
    }

    public void init(Context r210, JSONObject r211) throws Exception {
        this.mContext = r210;
        if (LSSettings.inst().mEnableNativeNodeOptimize != 1) goto L5;
    L6:
        this.mVoidCommandSet.add(409);
        this.mVoidCommandSet.add(401);
        this.mVoidCommandSet.add(403);
        this.mVoidCommandSet.add(406);
        this.mVoidCommandSet.add(408);
        this.mVoidCommandSet.add(411);
    L7:
        loadNativeLib();
        if (mLoadSoSuccess == false) goto L10;
        nativeCreate();
    L10:
        if (r211 == null) goto L22;
        this.mInitInfo = r211;
        if (r211.has("host_aid") == false) goto L19;
        if (r211.optString("host_aid").equals("1233") == false) goto L16;
    L17:
        BaseLogInfo.inst();
        BaseLogInfo.REAL_SDK_APP_ID = ILiveStrategyCenter.SDK_APP_ID_OVERSEA;
        goto L19
    L16:
        if (r211.optString("host_aid").equals("1180") == true) goto L17;
    L19:
        if (r211.has("device_id") == false) goto L22;
        this.mDeviceId = r211.optString("device_id");
    L22:
        if (this.mSettingsListener != null) goto L24;
        this.mSettingsListener = new AnonymousClass7(this);
        LSNetworkManager.inst().settingsApi().addListener(this.mSettingsListener);
    L24:
        ThreadPoolExecutor r100 = LSNetworkManager.inst().customThreadPool();
        if (r100 != null) goto L27;
        PThreadPoolExecutor r101 = new PThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new StrategyThreadFactory(null));
        this.mThreadPool = r101;
        r101.allowCoreThreadTimeOut(true);
    L28:
        ABRStrategyExecutor r102 = new ABRStrategyExecutor(1, 3, 60, TimeUnit.SECONDS, new LinkedBlockingDeque());
        this.mABRExprExecutor = r102;
        r102.setQueueThreshold(LSSettings.inst().mABRStrategyQueueMaxThreshold);
        return;
    L27:
        this.mThreadPool = r100;
        goto L28
    L5:
        if (LSSettings.inst().mEnableNewNativeArch != 1) goto L7;
        goto L6
    }

    public void registerStrategyConfigUpdate(String r100, SettingsManager.StrategyConfigUpdateCallBack r101) {
        SettingsManager.getInstance().registerStrategyConfigUpdate(r100, r101);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setEventInfo(int r100, JSONObject r101) {
        FeatureFactory.inst().setFeature(r100, r101);
        if (r100 != 61) goto L24;
        if (this.mFirstStart == false) goto L22;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L8:
        if (this.mFirstStart == false) goto L17;
        this.mFirstStart = false;     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
        long r102 = System.currentTimeMillis() - mLoadLibraryTime;
        PredictFirstPlayTime.inst().saveDataToDB(r102);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableCollectTime == (-1)) goto L15;
        sendEmptyMsg(1027);
    L15:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mUpdateCharToLiveIOTimer == (-1)) goto L22;
        int r103 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mUpdateCharToLiveIOTimer;
        sendEmptyMsg(1029);
        goto L22
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L22:
        PredictShortTimeLeave.inst().runStrategy();
    L24:
        if (r100 == 63) goto L26;
        return;
    L26:
        if (mLoadSoSuccess == false) goto L28;
        inst().nativeStopSession(r101);
    L28:
        SuperResolution r104 = mSRPredictEngine;
        if (r104 == null) goto L31;
        r104.stopSession(r101);
    L31:
        SuperResolutionStrategy.inst().stopSession(r101);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setFeatureDataBundle(String r100, IAppInfoBundle r101) {
        if (this.mListenerMap.size() <= LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDataBundleCount) goto L5;
        this.mListenerMap.clear();
        this.mHashCodeToBundleMap.clear();
    L5:
        this.mLatestSessionId = r100;
        this.mListenerMap.put(r100, r101);
        setHashCodeToBundleMap(r101);
        setFeatureBundleToNative(r100, r101);
        this.mListenerMap.size();
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_ss_videoarch_strategy_LiveStrategyManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }

    private void uploadNodeOptimizeService(JSONObject r100, JSONObject r101, int r102) {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDnsOptimizer != 1) goto L16;
        DnsOptimizer.inst().mServiceMonitor.mCallIndex++;
        if (r101.has("hostList") == false) goto L8;
        DnsOptimizer.inst().mServiceMonitor.mCallerID = -1;
    L14:
        DnsOptimizer.inst().mServiceMonitor.uploadMonitorLog();
        return;
    L8:
        if (r101.has("host") == false) goto L14;
        DnsOptimizer.inst().mServiceMonitor.mCallerID = r102;
        DnsOptimizer.inst().mServiceMonitor.mLookUpDomain = r101.optString("host");
        DnsOptimizer.inst().mServiceMonitor.mStreamSessionVVId = r101.optString("stream_session_vv_id", "none");
        if (r100 == null) goto L14;
        String r103 = r100.optString("Ip", "none");
        DnsOptimizer.inst().mServiceMonitor.mIsHit = !r103.equals("none") ? 1 : 0;
        DnsOptimizer.inst().mServiceMonitor.mReturnIP = r103;
        DnsOptimizer.inst().mServiceMonitor.mHitType = r100.optString("EvaluatorSymbol", "none");
        DnsOptimizer.inst().mServiceMonitor.mSDKStartCost = BaseLogInfo.inst().mSDKStartCostTime;
        if (DnsOptimizer.inst().mServiceMonitor.mIsHit != 0) goto L14;
        DnsOptimizer.inst().mServiceMonitor.mHasGetDomainInfos = r100.optBoolean("HasGetDomainInfos", false) ? 1 : 0;
        DnsOptimizer.inst().mServiceMonitor.mHostContained = r100.optBoolean("IsHostContained", false) ? 1 : 0;
        DnsOptimizer.inst().mServiceMonitor.mHasLocalDnsResult = r100.optBoolean("HasLocalDNSResult", false) ? 1 : 0;
        DnsOptimizer.inst().mServiceMonitor.mHasResetDns = r100.optBoolean("HasResetDNSResults", false) ? 1 : 0;
        DnsOptimizer.inst().mServiceMonitor.mIsRetryFailStopSchedule = r100.optBoolean("RetryFailStopSchedule", false) ? 1 : 0;
        goto L14
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public JSONObject PreProcessor(String r100, String r101, JSONObject r102) {
        JSONObject r103 = new JSONObject();
        if (mLoadSoSuccess == true) goto L5;
        return r103;
    L5:
        if (r102 == null) goto L7;
        String r104 = r102.toString();
    L8:
        nativeStartPreProcessor(r100, r101, r104);
        return r103;
    L7:
        r104 = "";
        goto L8
    }

    public <T> T fireNotifyToPlayer(String r100, T r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r101;
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L15;
        if (this.mListenerMap.containsKey(this.mLatestSessionId) == false) goto L11;
        IAppInfoBundle r103 = this.mListenerMap.get(this.mLatestSessionId);
    L18:
        if (r103 == null) goto L21;
        return (T) r103.getAppInfoForKey(r100, r101);
    L21:
        return r101;
    L11:
        if (this.mListenerMap.isEmpty() == true) goto L17;
        Iterator<Map.Entry<String, IAppInfoBundle>> r104 = this.mListenerMap.entrySet().iterator();
        IAppInfoBundle r105 = r104.next().getValue();
        String r106 = r104.next().getKey();
        r103 = r105;
    L17:
        r103 = null;
        goto L18
    L15:
        if (this.mListenerMap.containsKey(r102) == false) goto L17;
        r103 = this.mListenerMap.get(r102);
        goto L18
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void notifyInfo(int r100, int r101, String r102) {
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L13;
        if (r100 != 2) goto L20;
        if (r101 != 0) goto L16;
        LiveIOEngine r103 = mLiveIOEngine;
        if (r103 == null) goto L17;
        r103.savePreconnResult(r102);
        return;
    L17:
        return;
    L16:
        return;
    L20:
        return;
    L13:
        if (r101 != 500) goto L19;
        DnsOptimizer.inst().updateBlackIP(r102);
        return;
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setRoomInfo(String r100, int r101, long r102) {
        if (mLoadSoSuccess == true) goto L5;
        return;
    L5:
        SettingsManager.getInstance().SetSDKParams(r100);
        r100.length();
        if (r101 == 50) goto L8;
        return;
    L8:
        if (LSSettings.inst().mEnableLSRoomPrecon != 1) goto L10;
        LSPreconnManager.inst().setliveStartingTogglesFromStreamInfo(r100, getSuggestSendingRate(), NetworkMonitorLoader.inst().getStringNetworkType());
        LSPreconnManager.inst().preconnect(r100);
    L10:
        nativeSetNextRoomInfo(r100, r101, r102);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void setStreamInfo(String r100, String r101, String r102) {
        if (mLoadSoSuccess == false) goto L6;
        nativeSetStreamInfo(r102);
        return;
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public void notifyInfo(int r100, int r101, JSONObject r102) {
        if (r100 == 0) goto L4;
    L9:
        notifyInfo(r100, r101, r102.toString());
        return;
    L4:
        if (r101 != 500) goto L9;
        if (LSSettings.inst().mEnableNativeNodeOptimize != 1) goto L9;
        nativeExecuteCommandOpt(0, 10003, 0, r102);
    }

    private /* synthetic */ void lambda$executeCommand$0(int r100, int r101, int r102, JSONObject r103) {
        nativeExecuteCommandOpt(r100, r101, r102, r103);
    }

    private /* synthetic */ JSONObject lambda$executeCommandPerfOpt$2(int r100, JSONObject r101, int r102, int r103) throws Exception {
        if (r100 != 2) goto L5;
        JSONObject r104 = processStartupGearStrategy(r101);
        if (r104 == null) goto L14;
        r104.toString();
    L14:
        return r104;
    L5:
        if (r100 == 3) goto L9;
        return null;
    L9:
        return nativeExecuteCommandOpt(r102, r100, r103, r101);
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public JSONObject executeCommand(final int r110, final int r111, final int r112, final JSONObject r113) {
        JSONObject r100 = null;
        if (r111 != 405) goto L7;
        onLiveIOStarted();
        return null;
    L7:
        if (mLoadSoSuccess == true) goto L10;
        return null;
    L10:
        if (this.mThreadPool != null) goto L13;
        return null;
    L13:
        if (r111 != 10004) goto L17;
        return nativeExecuteCommandOpt(r110, r111, r112, r113);
    L17:
        if (this.mVoidCommandSet.isEmpty() == false) goto L24;
        if (LSSettings.inst().mEnableNativeNodeOptimize != 1) goto L21;
    L22:
        this.mVoidCommandSet.add(409);
        this.mVoidCommandSet.add(401);
        this.mVoidCommandSet.add(403);
        this.mVoidCommandSet.add(406);
        this.mVoidCommandSet.add(408);
        goto L24
    L21:
        if (LSSettings.inst().mEnableNewNativeArch == 1) goto L22;
    L24:
        if (r111 != 10006) goto L30;
        ABRStrategyExecutor r101 = this.mABRExprExecutor;
        if (r101 == null) goto L30;
        r101.execute(new c(this, r110, r111, r112, r113));
        return null;
    L30:
        if (LSSettings.inst().mEnableExecuteCommandOpt != 1) goto L36;
        if (2 == r111) goto L35;
        if (3 != r111) goto L36;
    L35:
        return executeCommandPerfOpt(r110, r111, r112, r113);
    L36:
        Future r114 = this.mThreadPool.submit(new AnonymousClass11(this, r111, r112, r113, r110));
        if (this.mVoidCommandSet.contains(Integer.valueOf(r111)) == true) goto L39;
        if (r111 != 2) goto L42;
        String r115 = (String) r114.get(LSSettings.inst().mExecuteCommandTimeout, TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L50 Throwable -> L52 InterruptedException -> L54
    L44:
        if (TextUtils.isEmpty(r115) == false) goto L58;
    L56:
        Objects.toString(r100);
        return r100;
    L58:
        r100 = new JSONObject(r115);     // Catch: JSONException -> L47 TimeoutException -> L50 Throwable -> L52 InterruptedException -> L54
    L47:
        e = move-exception;
        e.printStackTrace();     // Catch: TimeoutException -> L50 Throwable -> L52 InterruptedException -> L54
        goto L56
    L42:
        r115 = (String) r114.get();     // Catch: TimeoutException -> L50 Throwable -> L52 InterruptedException -> L54
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L56
    L39:
        return null;
    }

    public JSONObject executeCommandPerfOpt(final int r110, final int r111, final int r112, final JSONObject r113) {
        if (2 == r111) goto L7;
        if (3 == r111) goto L7;
        return null;
    L7:
        if (LSSettings.inst().mEnableExecuteCommandInExternalThread != 1) goto L12;
        if (r111 != 3) goto L12;
        return nativeExecuteCommandOpt(r110, r111, r112, r113);
    L12:
        if (LSSettings.inst().mEnableExecuteStartupGearCommandInExternalThread != 1) goto L29;
        if (r111 != 2) goto L29;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L28;
        ThreadPoolExecutor r114 = this.mStartupStrategyExecutor;
        if (r114 == null) goto L28;
        return (JSONObject) r114.submit(new a(this, r113)).get(LSSettings.inst().mExecuteCommandTimeout, TimeUnit.MILLISECONDS);
    L23:
        e = move-exception;
        e.printStackTrace();
        return null;
    L28:
        return processStartupGearStrategy(r113);
    L29:
        Future r115 = this.mThreadPool.submit(new b(this, r111, r113, r110, r112));
        if (r111 != 2) goto L32;
        JSONObject r116 = (JSONObject) r115.get(LSSettings.inst().mExecuteCommandTimeout, TimeUnit.MILLISECONDS);     // Catch: TimeoutException -> L34 ExecutionException -> L36 Throwable -> L38
    L41:
        return r116;
    L32:
        r116 = (JSONObject) r115.get();     // Catch: TimeoutException -> L34 ExecutionException -> L36 Throwable -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v65, types: [T, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v12, types: [T, org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r14v0, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v29, types: [T, java.lang.Object, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r14v49 */
    /* JADX WARN: Type inference failed for: r14v5, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v64 */
    /* JADX WARN: Type inference failed for: r14v65 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r5v7 */
    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public <T> T getConfigAndStrategyByKeyInt(int r110, int r111, T r112, JSONObject r113) {
        if (this.mIsRunning == true) goto L14;
        if (r111 != 13) goto L12;
        ?? r114 = (T) new JSONObject();
        r114.put("StartStrategySDKCost", -1);     // Catch: Exception -> L9
    L11:
        return r114;
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    L12:
        return r112;
    L14:
        if (r110 == 0) goto L22;
        if (r110 == 1) goto L17;
        String r100 = null;
    L27:
        if (r100 == null) goto L29;
        Objects.toString(LSSettings.inst().getGlobalStaticSettingsBundleByProjectKey(r100, -1));
    L29:
        String r101 = (String) LSSettings.inst().getAppInfoForKey("TTNet_NQE_INFO", "");
        Objects.toString(r113);
        if (r111 != 51) goto L32;
        if (r113 != null) goto L173;
        return r112;
    L173:
        if (r113.has("strategyName") == true) goto L175;
        return r112;
    L175:
        return (T) getStrategyConfigByName(r113.optString("strategyName"));
    L32:
        if (r111 == 52) goto L165;
        int r102 = 0;
        ?? r103 = r101;
        switch(r111) {
            case 12: goto L160;
            case 13: goto L90;
            case 14: goto L89;
            case 15: goto L83;
            case 16: goto L215;
            case 17: goto L74;
            case 18: goto L209;
            case 19: goto L68;
            case 20: goto L66;
            case 21: goto L65;
            case 22: goto L64;
            case 23: goto L63;
            case 24: goto L42;
            case 25: goto L41;
            case 26: goto L39;
            case 27: goto L37;
            case 28: goto L189;
            default: goto L229;
        };
    L37:
        T r115 = (T) GetRetryBufferStrategy.inst().runStrategy();
        Objects.toString(r115);
        return r115;
    L41:
        T r116 = (T) SocketBufferStrategy.inst().runStrategy();
        Objects.toString(r116);
        return r116;
    L42:
        if (r113 != null) goto L44;
        return r112;
    L44:
        if (r113.has("host") == true) goto L46;
        return r112;
    L46:
        if (r113.has("protocolType") == true) goto L48;
        return r112;
    L48:
        if (LSSettings.inst().mEnableNativeNodeOptimize != 1) goto L62;
        JSONObject r117 = nativeExecuteCommandOpt(0, 10002, 0, r113);
        if (r117 != null) goto L52;
        return r112;
    L52:
        if (r117.has("lss_ip_list") == false) goto L198;
        JSONArray r118 = r117.optJSONArray("lss_ip_list");
        if (r118 != null) goto L56;
        return r112;
    L56:
        if (r118.length() <= 0) goto L200;
        ?? r119 = (T) new ArrayList();
    L59:
        if (r102 >= r118.length()) goto L61;
        r119.add(r118.optString(r102));
        r102 = r102 + 1;
        goto L59
    L61:
        r119.toString();
        return r119;
    L200:
        return r112;
    L198:
        return r112;
    L62:
        String r120 = r113.optString("host");
        int r121 = r113.optInt("protocolType");
        T r122 = (T) DnsOptimizer.inst().getNodeListWithHostByKey(r121, r120);
        Objects.toString(r122);
        return r122;
    L63:
        T r123 = (T) ABRSwitchStrategy.inst().runStrategy(r113);
        Objects.toString(r123);
        return r123;
    L64:
        T r124 = (T) SmoothSwitchStrategy.inst().runStrategy();
        Objects.toString(r124);
        return r124;
    L65:
        T r125 = (T) ProbeStartupBitrate.inst().runStrategy();
        Objects.toString(r125);
        return r125;
    L66:
        Objects.toString(r112);
        T r126 = (T) TransportParamRecommend.inst().runStrategy();
        Objects.toString(r126);
        return r126;
    L74:
        if (r113 != null) goto L76;
        return r112;
    L76:
        if (r113.has("domain") == true) goto L78;
        return r112;
    L78:
        if (r113.has("ipCount") == true) goto L80;
        return r112;
    L80:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRtmProbe != 1) goto L213;
        String r127 = r113.optString("domain");
        int r128 = r113.optInt("ipCount");
        return (T) NetworkProber.inst().getUdpProbeResultInfo(r127, r128);
    L213:
        return r112;
    L83:
        LiveIOEngine r129 = mLiveIOEngine;
        if (r129 == null) goto L216;
        if (r113 == null) goto L217;
        T r130 = (T) r129.getPreconnResults(r113.optString(DNSParser.DNS_RESULT_IP));
        if (LSSettings.inst().mStartLiveIOPreconnect == true) goto L218;
        LSSettings.inst().mStartLiveIOPreconnect = true;
        return r130;
    L218:
        return r130;
    L217:
        return r112;
    L216:
        return r112;
    L89:
        T r131 = (T) NetConnectionTypeStrategy.inst().runStrategy();
        Objects.toString(r131);
        return r131;
    L90:
        if (r113 == null) goto L221;
        Boolean r132 = Boolean.FALSE;
        if (LSSettings.inst().mEnableNativeNodeOptimize != 1) goto L102;
        ?? r133 = (T) nativeExecuteCommandOpt(0, 10001, 0, r113);
        if (r113.has("UseRedirected") == false) goto L96;
        r113.optInt("UseRedirected");
    L96:
        if (r133 != 0) goto L98;
    L100:
        r132 = Boolean.TRUE;
        goto L102
    L98:
        if (r133.has("Ip") == false) goto L100;
        r133.optString("Ip");
        return r133;
    L102:
        if (r113.has("hostList") == false) goto L104;
        JSONArray r134 = r113.optJSONArray("hostList");
        JSONObject r135 = DnsOptimizer.inst().getNodeOptimizerInfoByHostList(r134);
        Objects.toString(r135);
        Object r136 = (T) r135;
    L159:
        uploadNodeOptimizeService((JSONObject) r136, r113, r110);
        return (T) r136;
    L104:
        String r104 = nativeExecuteCommand(0, 101, 0, r113.toString());
        if (TextUtils.isEmpty(r104) == false) goto L178;
    L115:
        ?? r105 = r112;
    L117:
        if (r113.has("UseRedirected") == true) goto L119;
    L132:
        int r106 = -1;
    L133:
        JSONObject r137 = (T) DnsOptimizer.inst().getNodeOptimizerInfos(r113, (INodeListener) r112);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptNotExeFunc != 1) goto L136;
    L144:
        if (r106 == (-1)) goto L150;
        r137.put("UseRedirectedIp", r106);     // Catch: Exception -> L147
    L147:
        e = move-exception;
        e.printStackTrace();
    L150:
        if (LSSettings.inst().mEnableNativeNodeOptimize == 1) goto L152;
    L158:
        Objects.toString(r137);
        r136 = r137;
        goto L159
    L152:
        if (r132.booleanValue() == false) goto L158;
        r137.put("NativeOptimizeFail", 1);     // Catch: JSONException -> L155
    L155:
        e = move-exception;
        throw new RuntimeException(e);
    L136:
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L144;
        if (LSSettings.inst().mPersistenceConfigInfo.mHisTableEnable != 1) goto L144;
        if (r113.has("host") == false) goto L144;
        if (r113.has("stream_session_vv_id") == false) goto L144;
        String r107 = r113.optString("host");
        String r108 = r113.optString("stream_session_vv_id");
        SessionCacheInfos r109 = new SessionCacheInfos();
        r109.mDomain = r107;
        r109.mSessionId = r108;
        HistoryTableOperate.mSessionCacheInfosMap.put(r108, r109);
        goto L144
    L119:
        if (r113.optInt("UseRedirected") != 1) goto L132;
        String r138 = nativeExecuteCommand(0, 100, 0, r113.toString());
        if (TextUtils.isEmpty(r138) == true) goto L132;
        JSONObject r139 = new JSONObject(r138);     // Catch: Exception -> L127
        JSONObject r140 = DnsOptimizer.inst().addBasicMetrics(r139);     // Catch: Exception -> L127
        r140.put("EvaluatorSymbol", "Pre-Redirect");     // Catch: Exception -> L127
        String r141 = r140.optString("RedirectedIp");     // Catch: Exception -> L127
        if (TextUtils.isEmpty(r141) == true) goto L125;
        r140.put("Ip", r141);     // Catch: Exception -> L127
    L125:
        r106 = r140.optInt("UseRedirectedIp");     // Catch: Exception -> L127
        ?? r142 = r140;
    L129:
        Objects.toString(r142);
        boolean r143 = ((JSONObject) r142).has("Ip");
        r103 = r142;
        if (r143 == false) goto L133;
    L127:
        e = move-exception;
        e.printStackTrace();
        r106 = -1;
        r142 = r105;
        goto L129
    L178:
        JSONObject r144 = new JSONObject(r104);     // Catch: Exception -> L112
        ?? r145 = DnsOptimizer.inst().addBasicMetrics(r144);     // Catch: Exception -> L112
        r145.put("EvaluatorSymbol", "Pre-Connect");     // Catch: Exception -> L112
        if (r145.has("Ip") == false) goto L115;
        r103 = r145;
    L110:
        e = e;
    L114:
        e.printStackTrace();
        r105 = r145;
    L112:
        e = e;
        r145 = r112;
        goto L114
    L221:
        return r112;
    L160:
        JSONObject r146 = StartPlayBufferStrategy.inst().runStrategy();
        ?? r147 = r112;
        if (r146 == null) goto L163;
        r147 = (T) Long.valueOf(r146.optLong("result"));
    L163:
        Objects.toString((Object) r147);
        return (T) r147;
    L229:
        return r112;
    L189:
        return (T) LSSettings.inst().mRequestId;
    L39:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableSuggestQuic == 1) goto L192;
        return r112;
    L192:
        return (T) 1;
    L68:
        if (mSRPredictEngine == null) goto L208;
        if (SuperResolutionStrategy.inst().getEnableDynamicSR() == true) goto L208;
        return (T) mSRPredictEngine.getSRPredictResult();
    L208:
        return (T) SuperResolutionStrategy.inst().getSRPredictResult();
    L209:
        return (T) r103;
    L215:
        return (T) Integer.valueOf(DnsOptimizer.inst().getIntValue(0, ((Integer) r112).intValue()));
    L165:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUpdateCharToLiveIO != 1) goto L225;
        JSONObject r148 = CharacterFetchStrategy.inst().runStrategy();
        if (r148 != null) goto L169;
        T r149 = (T) "";
    L226:
        return r149;
    L169:
        r149 = (T) r148.toString();
        goto L226
    L225:
        return r112;
    L17:
        if (r113 == null) goto L19;
    L20:
        TypePushFeaturesCollector.inst().setCurCallerInfo(r113);
    L21:
        r100 = "1";
        goto L27
    L19:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDisableResetSDKInfo != 0) goto L21;
    L22:
        if (r113 == null) goto L24;
    L25:
        TypePlayFeaturesCollector.inst().setCurCallerInfo(r113);
    L26:
        r100 = "2";
        goto L27
    L24:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDisableResetSDKInfo != 0) goto L26;
        goto L25
    }

    @Override // com.ss.videoarch.strategy.ILiveStrategyCenter
    public <T> T getConfigAndStrategyByKeyStr(int r100, String r101, T r102, JSONObject r103) {
        String r104 = null;
        if (r100 != 0) goto L5;
        TypePlayFeaturesCollector.inst().setCurCallerInfo(r103);
        String r105 = "2";
    L9:
        if (r103 != null) goto L11;
    L15:
        if (r105 == null) goto L35;
        Map<String, IAppInfoBundle> r106 = this.mListenerMap;
        if (r106 != null) goto L19;
    L28:
        T r107 = (T) LSSettings.inst().getCommonConfigByKey(r101);
        if (r107 != null) goto L32;
        return r102;
    L32:
        if (JSONObject.class.equals(r107.getClass()) == true) goto L34;
        return r107;
    L34:
        return (T) r107.toString();
    L19:
        if (r106.containsKey(r104) == false) goto L28;
        if (LSSettings.inst().mSupportHotUpdateFunctionNameList.contains(r101) == false) goto L28;
        List<String> r108 = new ArrayList();
        if (LSSettings.inst().mSessionRequestHotUpdateParamsMap != null) goto L25;
    L27:
        r108.add(r101);
        LSSettings.inst().mSessionRequestHotUpdateParamsMap.put(r104, r108);
        goto L28
    L25:
        if (LSSettings.inst().mSessionRequestHotUpdateParamsMap.containsKey(r104) == false) goto L27;
        r108 = LSSettings.inst().mSessionRequestHotUpdateParamsMap.get(r104);
        goto L27
    L35:
        return r102;
    L11:
        if (r103.has("host") == false) goto L15;
        if (r103.has("stream_session_vv_id") == false) goto L15;
        r103.optString("host");
        r104 = r103.optString("stream_session_vv_id");
        goto L15
    L5:
        if (r100 == 1) goto L7;
        r105 = null;
        goto L9
    L7:
        TypePushFeaturesCollector.inst().setCurCallerInfo(r103);
        r105 = "1";
        goto L9
    }

    public static /* synthetic */ JSONObject access$1000(LiveStrategyManager r100, int r101, int r102, int r103, JSONObject r104) {
        return r100.nativeExecuteCommandOpt(r101, r102, r103, r104);
    }

    public static /* synthetic */ String access$1200(LiveStrategyManager r100, int r101, int r102, int r103, String r104) {
        return r100.nativeExecuteCommand(r101, r102, r103, r104);
    }
}
