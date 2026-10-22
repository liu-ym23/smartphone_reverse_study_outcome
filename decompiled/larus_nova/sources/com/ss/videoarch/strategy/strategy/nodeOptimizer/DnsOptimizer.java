package com.ss.videoarch.strategy.strategy.nodeOptimizer;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.ttvideoengine.FeatureManager;
import com.ss.ttvideoengine.net.DNSParser;
import com.ss.videoarch.strategy.INodeListener;
import com.ss.videoarch.strategy.LiveStrategyManager;
import com.ss.videoarch.strategy.dataCenter.config.LSSettings;
import com.ss.videoarch.strategy.dataCenter.strategyData.BaseTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.NodeTableOperate;
import com.ss.videoarch.strategy.dataCenter.strategyData.StrategySQLMonitorLog;
import com.ss.videoarch.strategy.dataCenter.strategyData.model.NodeCacheInfos;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseLogInfo;
import com.ss.videoarch.strategy.log.strategyMonitor.BaseStrategyMonitor;
import com.ss.videoarch.strategy.network.LSNetworkManager;
import com.ss.videoarch.strategy.network.NetworkMonitorLoader;
import com.ss.videoarch.strategy.network.VeLSNetworkManagerImpl;
import com.ss.videoarch.strategy.strategy.networkStrategy.NetworkProber;
import com.ss.videoarch.strategy.strategy.smartStrategy.PredictFirstPlayTime;
import com.ss.videoarch.strategy.strategy.smartStrategy.TopNHostStrategy;
import com.ss.videoarch.strategy.utils.JNINamespace;
import com.ss.videoarch.strategy.utils.VeLSUtils;
import com.ss.videoarch.strategy.utils.smartStrategy.PitayaWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@JNINamespace("jni")
public class DnsOptimizer {
    static final boolean DEBUG = false;
    private static final int NETTYPE_1xRTT = 7;
    private static final int NETTYPE_CDMA = 4;
    private static final int NETTYPE_EDGE = 2;
    private static final int NETTYPE_EHRPD = 14;
    private static final int NETTYPE_EVDO_0 = 5;
    private static final int NETTYPE_EVDO_A = 6;
    private static final int NETTYPE_EVDO_B = 12;
    private static final int NETTYPE_GPRS = 1;
    private static final int NETTYPE_GSM = 16;
    private static final int NETTYPE_HSDPA = 8;
    private static final int NETTYPE_HSPA = 10;
    private static final int NETTYPE_HSPAP = 15;
    private static final int NETTYPE_HSUPA = 9;
    private static final int NETTYPE_IDEN = 11;
    private static final int NETTYPE_IWLAN = 18;
    private static final int NETTYPE_LITE = 13;
    private static final int NETTYPE_LTE_CA = 19;
    private static final int NETTYPE_TD_SCDMA = 17;
    private static final int NETTYPE_UMTS = 3;
    private static final int NETTYPE_UNKNOWN = 0;
    private static final int NETWORK_CLASS_2_G = 2;
    private static final int NETWORK_CLASS_3_G = 3;
    private static final int NETWORK_CLASS_4_G = 1;
    private static final int NETWORK_CLASS_UNKNOWN = -1;
    private static final long NETWORK_DEBOUNCE_TIME = 2000;
    private static final int NETWORK_WIFI = 0;
    private static final int PING_COUNT = 10;
    static final String TAG = "AndroidDnsOptimizer";
    private static List<String> mHttpDnsDomainList;
    public static HashMap<String, JSONObject> mNodeCacheInfos;
    private static final Map<String, OptRecord> mOptResults = null;
    private static volatile DnsOptimizer sInstance;
    private final int IPV6_PROBE_SUCCESS;
    public boolean mCompleteFirstLocalDns;
    private volatile OnParseDnsCompletionListener mCompletionListener;
    private long mCurLoopStartDnsTS;
    public int mCurrentNetworkType;
    public long mDelayUpdateTime;
    private DnsErrorMonitorLog mDnsErrorMonitor;
    public Set<String> mDoLocalDnsHosts;
    private long mDoPreDnsStartTime;
    private Map<String, Integer> mDomainParseType;
    public int mEnablePersistenceSave;
    private boolean mEnableTfoPreconnect;
    public int mFirstResponseCost;
    public Handler mHandler;
    private Handler mHandlerOfListener;
    private boolean mHasLocalDNSTimeout;
    public boolean mHasParseIpv6Address;
    public boolean mHasResetDNSResults;
    private int mHasResolvedCount;
    public boolean mHasSendFirstRequest;
    private int mHasSendToResolveCount;
    public boolean mHasUdpProbe;
    public Set<String> mHosts;
    public int mIPV6ProbeResult;
    private final List<ResolveTask> mInFlightTasks;
    private boolean mIsAlreadyDidOnMessage;
    private boolean mIsGetHotDomainsSuccess;
    private final ThreadPoolExecutor mListenThreadPool;
    private ReentrantLock mLock;
    private NodeOptimizeLoopMonitorLog mLoopMonitor;
    private INodeListener mNodeListener;
    private int mPreDnsHasResolvedCount;
    private int mPreDnsHostCount;
    public NodeOptimizePreDnsMonitorLog mPreDnsMonitor;
    public Set<String> mPreHosts;
    private volatile OnDoPreconnectListener mPreconnListener;
    private final List<String> mPreconnResults;
    private int mPreconnectFlag;
    private String mRequestDomain;
    private long mRequestTimeOut;
    public int mResponseCost;
    public int mResponseStatusCode;
    public boolean mRetryFailStopSchedule;
    private boolean mRunning;
    public NodeOptimizeServiceMonitorLog mServiceMonitor;
    private boolean mTheFirstIntoUpdate;
    private final ThreadPoolExecutor mThreadPool;
    public int mUDPProbeResult;
    public boolean updateNodeCacheInfos;

    public static class DnsListenThreadFactory implements ThreadFactory {
        private final String mPrefix;
        private final ThreadGroup mThreadGroup;
        private final AtomicInteger mThreadNumber;

        private DnsListenThreadFactory() {
            this.mThreadNumber = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.mThreadGroup = r101;
            this.mPrefix = "dns-optimizer-listen-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        public /* synthetic */ DnsListenThreadFactory(AnonymousClass1 r100) {
            this();
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
    }

    public static class DnsOptThreadFactory implements ThreadFactory {
        private final String mPrefix;
        private final ThreadGroup mThreadGroup;
        private final AtomicInteger mThreadNumber;

        private DnsOptThreadFactory() {
            this.mThreadNumber = new AtomicInteger(1);
            SecurityManager r100 = System.getSecurityManager();
            if (r100 == null) goto L5;
            ThreadGroup r101 = r100.getThreadGroup();
        L6:
            this.mThreadGroup = r101;
            this.mPrefix = "dns-optimizer-";
            return;
        L5:
            r101 = ThreadMethodProxy.currentThread().getThreadGroup();
            goto L6
        }

        public /* synthetic */ DnsOptThreadFactory(AnonymousClass1 r100) {
            this();
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
    }

    public interface OnDoPreconnectListener {
        void onReadyDoPreConnect(String r100, String r101);
    }

    public interface OnParseDnsCompletionListener {
        void onParseDnsComplete(String r100);
    }

    public interface OnParseIPV6AddressListener {
        int onParseIPV6Address(String r100);
    }

    private String addGetDomainInfosRequest() {
        return "\n    \"GetDomainInfosRequest\":{\n        \"Enabled\":true\n     }\n";
    }

    private native String nativeGetNodeOptimizerInfoByHostList(List<String> r100);

    private native String nativeGetNodeOptimizerInfos(String r100);

    private native String nativeGetPreferedIP(String r100);

    private native void nativeResolveLocalDns(Set<String> r100);

    private native void nativeStartIPRace(String r100);

    static {
        mOptResults = new ConcurrentHashMap();
        mHttpDnsDomainList = new ArrayList();
        mNodeCacheInfos = new HashMap();
    }

    public static DnsOptimizer inst() {
        if (sInstance != null) goto L15;
        monitor-enter(DnsOptimizer.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new DnsOptimizer();     // Catch: Throwable -> L11
    L9:
        monitor-exit(DnsOptimizer.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void resetResolveResults() {
        Set<String> r100 = this.mHosts;
        if (r100 != null) goto L5;
    L14:
        mOptResults.clear();
        return;
    L5:
        if (r100.size() == 0) goto L14;
        Iterator<String> r101 = this.mHosts.iterator();
    L9:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();
        OptRecord r103 = mOptResults.get(r102);
        if (r103 == null) goto L9;
        r103.setRemoteLocalDnsResult(null);
        r103.setLocalDnsResult(null);
        r103.setHttpDnsResult(null);
        goto L9
    }

    public void stop() {
        if (this.mRunning == true) goto L5;
        return;
    L5:
        this.mNodeListener = null;
        this.mInFlightTasks.clear();
        mOptResults.clear();
        this.mRunning = false;
    }

    public DnsOptimizer() {
        this.mLock = new ReentrantLock();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mInFlightTasks = new LinkedList();
        this.mPreconnResults = new ArrayList();
        this.updateNodeCacheInfos = false;
        this.mRunning = false;
        this.mCompleteFirstLocalDns = false;
        this.mPreDnsHasResolvedCount = 0;
        this.mPreDnsHostCount = 0;
        this.mHasResolvedCount = 0;
        this.mHasSendToResolveCount = 0;
        this.mEnableTfoPreconnect = false;
        this.mPreconnectFlag = -1;
        this.mTheFirstIntoUpdate = false;
        this.mIsGetHotDomainsSuccess = true;
        this.mDelayUpdateTime = 0;
        this.mEnablePersistenceSave = -1;
        this.mHasParseIpv6Address = false;
        this.mIPV6ProbeResult = -1;
        this.IPV6_PROBE_SUCCESS = 0;
        this.mHasUdpProbe = false;
        this.mUDPProbeResult = -1;
        this.mHasLocalDNSTimeout = false;
        this.mHasSendFirstRequest = false;
        this.mFirstResponseCost = -1;
        this.mResponseCost = -1;
        this.mResponseStatusCode = -1;
        this.mHasResetDNSResults = false;
        this.mRetryFailStopSchedule = false;
        this.mCurLoopStartDnsTS = 0;
        this.mDoPreDnsStartTime = 0;
        this.mCurrentNetworkType = NetworkMonitorLoader.inst().getNetworkType();
        this.mIsAlreadyDidOnMessage = true;
        this.mRequestTimeOut = 0;
        this.mRequestDomain = "none";
        ThreadPoolExecutor r100 = LSNetworkManager.inst().customThreadPool();
        AnonymousClass1 r101 = null;
        if (r100 != null) goto L7;
        PThreadPoolExecutor r102 = new PThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DnsOptThreadFactory(r101));
        this.mThreadPool = r102;
        if (LSSettings.inst().mEnableThreadTimeOut != 1) goto L8;
        r102.allowCoreThreadTimeOut(true);
    L8:
        PThreadPoolExecutor r103 = new PThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DnsListenThreadFactory(r101));
        this.mListenThreadPool = r103;
        if (LSSettings.inst().mEnableThreadTimeOut != 1) goto L11;
        r103.allowCoreThreadTimeOut(true);
    L11:
        this.mLoopMonitor = new NodeOptimizeLoopMonitorLog();
        this.mServiceMonitor = new NodeOptimizeServiceMonitorLog();
        this.mDnsErrorMonitor = new DnsErrorMonitorLog();
        this.mPreDnsMonitor = new NodeOptimizePreDnsMonitorLog();
        if (LSSettings.inst().mGetHotDomains != 1) goto L15;
        this.mIsGetHotDomainsSuccess = false;
        return;
    L15:
        return;
    L7:
        this.mThreadPool = r100;
        goto L8
    }

    private boolean shouldResponseIpv6() {
        if (shouldRequestIpv6() == true) goto L5;
        return false;
    L5:
        int r100 = this.mCurrentNetworkType;
        if (r100 != 0) goto L8;
        return false;
    L8:
        if (r100 != (-1)) goto L11;
        return false;
    L11:
        if (r100 != 4) goto L16;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mForbidUseIpv6InWiFi == 1) goto L20;
    L17:
        return true;
    L20:
        return false;
    L16:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mForbidUseIpv6InWWAN != 1) goto L17;
        return false;
    }

    public boolean shouldRequestIpv6() {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableIPv6ProbeLoop != 1) goto L13;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseIpv6 == 1) goto L7;
        return false;
    L7:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableIPV6Probe == 1) goto L9;
        return false;
    L9:
        if (this.mIPV6ProbeResult != 0) goto L22;
        return true;
    L22:
        return false;
    L13:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseIpv6 == 1) goto L15;
        return false;
    L15:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableIPV6Probe != 0) goto L17;
    L18:
        return true;
    L17:
        if (this.mIPV6ProbeResult == 0) goto L18;
        return false;
    }

    public static /* synthetic */ Map access$500() {
        return mOptResults;
    }

    public int getPreConnectFlag() {
        return this.mPreconnectFlag;
    }

    private void SortHosts(List<String> r100) {
        String r101 = LSSettings.inst().getUidFeatureByKey("push_day_7d", "AnchorFeatureParam");
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPreferParsingPushNodeByPushDaysIn7Days;
        int r103 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPreferParsingPullNodeByPushDaysIn7Days;
        int r104 = CastIntegerProtector.parseInt(r101);     // Catch: NumberFormatException -> L8
    L11:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnablePreferParsingPushNode != 1) goto L22;
        if (r104 < r102) goto L22;
        ArrayList r105 = new ArrayList();
        ArrayList r106 = new ArrayList();
        Iterator<String> r107 = r100.iterator();
    L15:
        if (r107.hasNext() == false) goto L20;
        String r108 = r107.next();
        if (r108.startsWith("push") == true) goto L18;
        r105.add(r108);
        goto L15
    L18:
        r106.add(r108);
        goto L15
    L20:
        r106.addAll(r105);
        r100 = r106;
    L22:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnablePreferParsingPullNode != 1) goto L47;
        if (r104 >= r103) goto L48;
        ArrayList r109 = new ArrayList();
        ArrayList r110 = new ArrayList();
        Iterator<String> r111 = r100.iterator();
    L26:
        if (r111.hasNext() == false) goto L31;
        String r112 = r111.next();
        if (r112.startsWith("push") == true) goto L29;
        r109.add(r112);
        goto L26
    L29:
        r110.add(r112);
        goto L26
    L31:
        r109.addAll(r110);
        return;
    L48:
        return;
    L47:
        return;
    L8:
        e = move-exception;
        System.out.println("Failed to parse integer: " + e.getMessage());
        r104 = -1;
        goto L11
    }

    public static /* synthetic */ String access$1000(DnsOptimizer r100) {
        return r100.mRequestDomain;
    }

    public static /* synthetic */ long access$1200(DnsOptimizer r100) {
        return r100.mRequestTimeOut;
    }

    public static /* synthetic */ List access$1300(DnsOptimizer r100) {
        return r100.mInFlightTasks;
    }

    public static /* synthetic */ int access$1400(DnsOptimizer r100) {
        return r100.mHasSendToResolveCount;
    }

    public static /* synthetic */ int access$1408(DnsOptimizer r100) {
        int r101 = r100.mHasSendToResolveCount;
        r100.mHasSendToResolveCount = r101 + 1;
        return r101;
    }

    public static /* synthetic */ DnsErrorMonitorLog access$1500(DnsOptimizer r100) {
        return r100.mDnsErrorMonitor;
    }

    public static /* synthetic */ NodeOptimizeLoopMonitorLog access$1600(DnsOptimizer r100) {
        return r100.mLoopMonitor;
    }

    public static /* synthetic */ int access$1700(DnsOptimizer r100) {
        return r100.mHasResolvedCount;
    }

    public static /* synthetic */ int access$1708(DnsOptimizer r100) {
        int r101 = r100.mHasResolvedCount;
        r100.mHasResolvedCount = r101 + 1;
        return r101;
    }

    public static /* synthetic */ boolean access$1800(DnsOptimizer r100) {
        return r100.mHasLocalDNSTimeout;
    }

    public static /* synthetic */ long access$1900(DnsOptimizer r100) {
        return r100.mCurLoopStartDnsTS;
    }

    public static /* synthetic */ int access$200(DnsOptimizer r100) {
        return r100.mPreDnsHasResolvedCount;
    }

    public static /* synthetic */ int access$208(DnsOptimizer r100) {
        int r101 = r100.mPreDnsHasResolvedCount;
        r100.mPreDnsHasResolvedCount = r101 + 1;
        return r101;
    }

    public static /* synthetic */ int access$300(DnsOptimizer r100) {
        return r100.mPreDnsHostCount;
    }

    public static /* synthetic */ long access$400(DnsOptimizer r100) {
        return r100.mDoPreDnsStartTime;
    }

    public static /* synthetic */ ThreadPoolExecutor access$600(DnsOptimizer r100) {
        return r100.mThreadPool;
    }

    public static /* synthetic */ OnParseDnsCompletionListener access$700(DnsOptimizer r100) {
        return r100.mCompletionListener;
    }

    public static /* synthetic */ Handler access$800(DnsOptimizer r100) {
        return r100.mHandlerOfListener;
    }

    public static /* synthetic */ INodeListener access$900(DnsOptimizer r100) {
        return r100.mNodeListener;
    }

    private String addHttpDnsRequest(String r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
        if (r100 != null) goto L15;
        r101.append("\"HTTPDNSRequest\":{\"Enabled\":true,\"DomainNames\":[");
        this.mLock.lock();
        ArrayList r103 = new ArrayList(mHttpDnsDomainList);
        this.mLock.unlock();
        Iterator r104 = r103.iterator();
    L6:
        if (r104.hasNext() == false) goto L14;
        String r105 = (String) r104.next();
        if (r102 == 0) goto L11;
        r101.append(",");
    L11:
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r101.append("\"" + r105 + "\"");
    L13:
        r102 = r102 + 1;
        goto L6
    L14:
        r101.append("],\"IsNeedIPV6\":" + shouldRequestIpv6() + i.f25855d);
    L29:
        return r101.toString();
    L15:
        Map<String, OptRecord> r106 = mOptResults;
        if (r106.get(r100) == null) goto L29;
        if (r106.get(r100).parseType != 1) goto L29;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDomainType == 2) goto L27;
        String r107 = r100.substring(0, 4);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDomainType != 1) goto L24;
        String r108 = "pull";
    L26:
        if (TextUtils.equals(r107, r108) == false) goto L29;
    L24:
        r108 = "push";
    L27:
        r101.append("\"HTTPDNSRequest\":{\"Enabled\":true,\"IsNeedIPV6\":" + shouldRequestIpv6() + ",\"DomainNames\":[");
        r101.append("\"" + r100 + "\"");
        r101.append("]}");
        goto L29
    }

    private String addSelectNodeRequest(String r110) {
        StringBuilder r100 = new StringBuilder();
        int r101 = 0;
        if (r110 != null) goto L31;
        Set<String> r111 = this.mDoLocalDnsHosts;
        if (r111 == null) goto L48;
        if (r111.size() == 0) goto L48;
        r100.append("\"SelectNodeRequest\":{\"Enabled\":true,\"IsNeedIPV6\":" + shouldRequestIpv6() + ",\"IPs\":{");
        Iterator<String> r112 = this.mDoLocalDnsHosts.iterator();
        int r102 = 0;
    L10:
        if (r112.hasNext() == false) goto L30;
        String r103 = r112.next();
        Map<String, OptRecord> r104 = mOptResults;
        if (r104 == null) goto L10;
        if (r104.containsKey(r103) == false) goto L10;
        OptRecord r105 = r104.get(r103);
        if (r105 == null) goto L10;
        List<String> r106 = r105.getLocalDnsResult();
        if (r106 == null) goto L10;
        if (r106.size() == 0) goto L10;
        if (r102 == 0) goto L23;
        r100.append(",");
    L23:
        r100.append("\"" + r105.host + "\":[");
        int r107 = 0;
    L25:
        if (r107 >= r106.size()) goto L29;
        if (r107 == 0) goto L28;
        r100.append(",");
    L28:
        r100.append("\"" + ((String) ListProtector.get(r106, r107)) + "\"");
        r107 = r107 + 1;
        goto L25
    L29:
        r100.append("]");
        r102 = r102 + 1;
        goto L10
    L30:
        r100.append("}}");
    L48:
        return r100.toString();
    L31:
        Map<String, OptRecord> r108 = mOptResults;
        if (r108 == null) goto L48;
        if (r108.size() == 0) goto L48;
        r100.append("\"SelectNodeRequest\":{\"Enabled\":true,\"IsNeedIPV6\":" + shouldRequestIpv6() + ",\"IPs\":{");
        r100.append("\"" + r110 + "\":[");
        OptRecord r113 = r108.get(r110);
        List<String> r109 = new ArrayList();
        if (r113 == null) goto L38;
        r109 = r113.getLocalDnsResult();
    L38:
        if (r109 != null) goto L40;
    L46:
        r100.append("]}}");
        goto L48
    L40:
        if (r109.size() == 0) goto L46;
    L42:
        if (r101 >= r109.size()) goto L46;
        if (r101 == 0) goto L45;
        r100.append(",");
    L45:
        r100.append("\"" + ((String) ListProtector.get(r109, r101)) + "\"");
        r101 = r101 + 1;
        goto L42
    }

    private void doForceLocalDnsByHostList(final List<String> r100) {
        this.mHandler.post(new AnonymousClass2(this, r100));
    }

    public void _doPreDnsOperate(JSONObject r100) {
        this.mPreDnsHasResolvedCount = 0;
        this.mDoPreDnsStartTime = System.currentTimeMillis();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.has("host_name") == false) goto L29;
        JSONArray r101 = r100.optJSONArray("host_name");
        if (r101 != null) goto L10;
        return;
    L10:
        if (r101.length() <= 0) goto L28;
        this.mPreDnsHostCount = r101.length();
        this.mPreHosts = new HashSet();
        int r102 = 0;
    L13:
        if (r102 >= r101.length()) goto L18;
        String r103 = r101.optString(r102);
        this.mPreHosts.add(r103);
        Map<String, OptRecord> r104 = mOptResults;
        final OptRecord r105 = r104.get(r103);
        if (r105 != null) goto L17;
        r105 = new OptRecord(r103, 0);
    L17:
        r104.put(r103, r105);
        final ResolveTask r106 = new ResolveTask(r105.host);
        this.mThreadPool.submit(new AnonymousClass1(this, r106, r105));
        r102 = r102 + 1;
        goto L13
    L18:
        Iterator<String> r107 = this.mPreHosts.iterator();
    L20:
        if (r107.hasNext() == false) goto L30;
        startIPRace(r107.next());
        goto L20
    L30:
        return;
    L28:
        return;
    }

    public JSONObject _getNodeOptimizerInfoByHostList(JSONArray r100) {
        String r101 = null;
        if (r100 != null) goto L5;
        return null;
    L5:
        JSONObject r102 = new JSONObject();
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L7:
        if (r104 >= r100.length()) goto L27;
        String r105 = r100.optString(r104);
        OptRecord r106 = mOptResults.get(r105);
        if (r106 != null) goto L11;
        r103.add(r105);
    L17:
        if (r101 != null) goto L21;
        String r107 = "none";
    L31:
        r102.put(r105, r107);     // Catch: JSONException -> L19
    L25:
        startIPRace(r105);
        r104 = r104 + 1;
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L21:
        r107 = r101;
        goto L31
    L11:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseNewOptRecordStruct != 1) goto L13;
        r101 = r106.newLookUp(shouldRequestIpv6(), this.mCurrentNetworkType, -1);
    L14:
        if (r101 != null) goto L17;
        r103.add(r105);
        goto L17
    L13:
        r101 = r106.lookup(shouldRequestIpv6(), -1);
        goto L14
    L27:
        if (r103.size() <= 0) goto L29;
        doForceLocalDnsByHostList(r103);
    L29:
        this.mServiceMonitor.mForceLocalDnsList = r103;
        return r102;
    }

    public JSONObject addBasicMetrics(JSONObject r100) {
        r100.put("StartStrategySDKCost", BaseLogInfo.inst().mSDKStartCostTime);     // Catch: Exception -> L13
        r100.put("LSSResponseCost", this.mResponseCost);     // Catch: Exception -> L13
        r100.put("FirstResponseCost", this.mFirstResponseCost);     // Catch: Exception -> L13
        r100.put("LSSResponseStatusCode", this.mResponseStatusCode);     // Catch: Exception -> L13
        if (this.mRunning == false) goto L5;
    L7:
        r100.put("RequestId", LSSettings.inst().mRequestId);     // Catch: Exception -> L13
        if (LSSettings.inst().mClientInfos != null) goto L10;
        String r101 = "";
    L11:
        r100.put("ClientInfo", r101);     // Catch: Exception -> L13
    L15:
        return r100;
    L10:
        r101 = LSSettings.inst().mClientInfos.toString();     // Catch: Exception -> L13
        goto L11
    L5:
        if (LSSettings.inst().mEnableSelectNode == true) goto L7;
        r100.put("HasSendFirstRequest", this.mHasSendFirstRequest);     // Catch: Exception -> L13
        r100.put("IsRemoteSorted", LSSettings.inst().mEnableSelectNode);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    }

    public void doPreDnsOperate(JSONObject r100) {
        if (LSSettings.inst().mEnableNativeDns == 1) goto L5;
    L25:
        _doPreDnsOperate(r100);
        return;
    L5:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L25;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.has("host_name") == false) goto L29;
        JSONArray r101 = r100.optJSONArray("host_name");
        HashSet r102 = new HashSet();
        if (r101 == null) goto L19;
        if (r101.length() <= 0) goto L19;
        int r103 = 0;
    L16:
        if (r103 >= r101.length()) goto L19;
        r102.add(r101.optString(r103));
        r103 = r103 + 1;
    L19:
        if (r102.isEmpty() == true) goto L30;
        nativeResolveLocalDns(r102);
        Iterator r104 = r102.iterator();
    L22:
        if (r104.hasNext() == false) goto L31;
        startIPRace((String) r104.next());
        goto L22
    L31:
        return;
    L30:
        return;
    }

    public JSONObject getNodeOptimizerInfoByHostList(JSONArray r100) {
        if (LSSettings.inst().mEnableNativeDns != 1) goto L19;
        if (VeLSUtils.isLoadSoSuccess() == false) goto L19;
        ArrayList r101 = new ArrayList();
        int r102 = 0;
    L8:
        if (r102 >= r100.length()) goto L10;
        r101.add(r100.optString(r102));
        r102 = r102 + 1;
        goto L8
    L10:
        String r103 = nativeGetNodeOptimizerInfoByHostList(r101);
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        if (TextUtils.isEmpty(r103) == true) goto L23;
        return new JSONObject(r103);
    L23:
        return null;
    L19:
        return _getNodeOptimizerInfoByHostList(r100);
    }

    public JSONObject sendDnsRequestByHost(String r110) {
        long r100 = System.currentTimeMillis();
        JSONObject r101 = new JSONObject();
        JSONObject r102 = VeLSNetworkManagerImpl.getInstance().sendDnsRequestByHosts(Collections.singletonList(r110));     // Catch: Exception -> L38
        if (r102 != null) goto L7;
        return r101;
    L7:
        if (r102.has("ResponseMetadata") == false) goto L14;
        JSONObject r103 = r102.optJSONObject("ResponseMetadata");     // Catch: Exception -> L38
        if (r103 == null) goto L14;
        if (r103.has("RequestId") == false) goto L14;
        r101.put("RequestId", r103.optString("RequestId"));     // Catch: Exception -> L38
    L14:
        if (r102.has("Result") == true) goto L16;
        return r101;
    L16:
        JSONObject r104 = r102.optJSONObject("Result");     // Catch: Exception -> L38
        if (r104 != null) goto L19;
    L37:
        return r101;
    L19:
        if (r104.has("NodeInfos") == false) goto L37;
        JSONObject r105 = r104.optJSONObject("NodeInfos");     // Catch: Exception -> L38
        if (r105 != null) goto L24;
    L35:
        r101.put("LSSResponseCost", (int) (System.currentTimeMillis() - r100));     // Catch: Exception -> L38
    L40:
        return r101;
    L24:
        if (r105.has(r110) == false) goto L35;
        JSONArray r111 = JSONObjectProtectorUtils.getJSONArray(r105, r110);     // Catch: Exception -> L38
        JSONArray r106 = new JSONArray();     // Catch: Exception -> L38
        int r107 = 0;
    L27:
        if (r107 >= r111.length()) goto L34;
        JSONObject r108 = JSONArrayProtectorUtils.getJSONObject(r111, r107);     // Catch: Exception -> L38
        if (r108 == null) goto L33;
        if (r108.has(HTTP.IP) == false) goto L33;
        r106.put(r108.optString(HTTP.IP));     // Catch: Exception -> L38
    L33:
        r107 = r107 + 1;     // Catch: Exception -> L38
        goto L27
    L34:
        JSONObject r112 = new JSONObject();     // Catch: Exception -> L38
        r112.put(FeatureManager.HTTP_DNS, r106);     // Catch: Exception -> L38
        r101.put("EvaluatorSymbol", r112);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L40
    }

    public void setDoPreconnListener(OnDoPreconnectListener r100) {
        this.mPreconnListener = r100;
    }

    public void setHandler(Handler r100) {
        this.mHandler = r100;
    }

    public void setOnParseDnsCompletionListener(OnParseDnsCompletionListener r100) {
        this.mCompletionListener = r100;
    }

    public void startIPRace(final String r100) {
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableIpRace == 1) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        this.mThreadPool.execute(new AnonymousClass10(this, r100));
    }

    public void updateBlackIP(String r100) {
        JSONObject r101 = new JSONObject(r100);     // Catch: JSONException -> L4
    L6:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.has("host") == true) goto L11;
        return;
    L11:
        if (r101.has(DNSParser.DNS_RESULT_IP) == false) goto L20;
        String r102 = r101.optString("host");
        String r103 = r101.optString(DNSParser.DNS_RESULT_IP);
        OptRecord r104 = mOptResults.get(r102);
        if (r104 == null) goto L21;
        if (r103 == null) goto L22;
        r104.updateBlackIPList(r103);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        r101 = null;
        goto L6
    }

    public void updateDnsResult(String r310) {
        int r100 = LSSettings.inst().mEnableNativeNodeOptimize;
        boolean r101 = false;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptNotExeFunc != 1) goto L5;
        boolean r102 = true;
    L6:
        this.mRunning = true;
        String r103 = String.valueOf(this.mCurrentNetworkType);
        if (this.mHosts != null) goto L9;
    L10:
        this.mHosts = LSSettings.inst().getDomainInfos();
        this.mDomainParseType = LSSettings.inst().getmDomainParseType();
        if (r102 == false) goto L13;
    L26:
        Set<String> r104 = this.mHosts;
        this.mDoLocalDnsHosts = r104;
        r104.size();
    L27:
        Set<String> r105 = this.mHosts;
        if (r105 != null) goto L30;
    L178:
        mOptResults.clear();
        return;
    L30:
        if (r105.size() == 0) goto L178;
        HashSet r106 = new HashSet();
        if (r310 != null) goto L35;
        Set<String> r107 = this.mHosts;
    L37:
        if (LSSettings.inst().mGetHotDomains != 1) goto L39;
        r107.addAll(LSSettings.inst().getNodeInfosDomain());
    L39:
        ArrayList r108 = new ArrayList(r107);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnablePreferParsingPushNode != 1) goto L42;
        SortHosts(r108);
    L42:
        ArrayList r109 = new ArrayList();
        Iterator r110 = r108.iterator();
    L44:
        if (r110.hasNext() == false) goto L140;
        String r111 = (String) r110.next();
        OptRecord r112 = mOptResults.get(r111);
        if (r112 != null) goto L52;
        if (this.mDomainParseType.get(r111) == null) goto L50;
        r112 = new OptRecord(r111, this.mDomainParseType.get(r111).intValue());
    L54:
        OptRecord r113 = r112;
        JSONArray r114 = LSSettings.inst().getNodeInfosByIP(r111);
        ArrayList r115 = new ArrayList();
        ArrayList r116 = new ArrayList();
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mCheckIPValid != 1) goto L57;
        boolean r117 = true;
    L58:
        if (r114 == null) goto L79;
        int r118 = 0;
    L61:
        if (r118 >= r114.length()) goto L79;
        JSONObject r119 = r114.optJSONObject(r118);
        if (r119.has(HTTP.IP) == false) goto L77;
        String r120 = r119.optString(HTTP.IP);
        if (r117 == false) goto L72;
        if (OptRecord.isValidIpv4Addr(r120, r101) == true) goto L72;
        if (OptRecord.isValidIpv6Addr(r120, r101) == false) goto L77;
    L72:
        if (r119.has("DomainParseType") == false) goto L77;
        if (r119.optInt("DomainParseType") != 0) goto L76;
        r116.add(r120);
        goto L77
    L76:
        r115.add(r120);
    L77:
        r118 = r118 + 1;
        r101 = false;
    L79:
        if (r115.size() <= 0) goto L85;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseNewOptRecordStruct != 1) goto L83;
        r113.setDnsResult(r115, 1, this.mCurrentNetworkType);
    L83:
        r113.setHttpDnsResult(r115);
    L85:
        if (r116.size() > 0) goto L87;
    L90:
        r113.setSymbol(LSSettings.inst().mSymbol);
        if (this.mIsAlreadyDidOnMessage == false) goto L93;
    L106:
        Map<String, OptRecord> r121 = mOptResults;
        r121.put(r111, r113);
        r121.size();
        if (LSSettings.inst().mEnableOpenPreconnect == 1) goto L109;
    L117:
        if (r102 == true) goto L139;
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L139;
        if (LSSettings.inst().mPersistenceConfigInfo.mNodeTableEnable != 1) goto L139;
        if (this.updateNodeCacheInfos == true) goto L129;
        long r210 = System.currentTimeMillis();
        mNodeCacheInfos = NodeTableOperate.getAllData(null, null, null, null, null);
        this.updateNodeCacheInfos = true;
        StrategySQLMonitorLog r211 = NodeTableOperate.mNodeStrategySQLMonitor;
        String r212 = NodeTableOperate.TABLE_NAME_NODE;
        String r213 = BaseStrategyMonitor.MONITOR_QUERY_OPERATE;
        if (mNodeCacheInfos.size() <= 0) goto L127;
        long r214 = 1;
    L128:
        r211.updateMonitorLogInfo(r212, r213, TAG, r214, r210, "Query all data");
        NodeTableOperate.mNodeStrategySQLMonitor.uploadMonitorLog();
        goto L129
    L127:
        r214 = 0;
    L129:
        String r122 = r113.getAllResolveResults().toString();
        String r123 = BaseTableOperate.getCurrentTimeFormat();
        JSONObject r124 = new JSONObject();
        NodeCacheInfos r125 = new NodeCacheInfos();
        if (r122.length() <= 2) goto L139;
        r125.mNodeIps = r122.substring(1, r122.length() - 1);
        r125.mNodeDomain = r111;
        r125.mNodeNetworkType = r103;
        r125.mUpdateTime = r123;
        if (mNodeCacheInfos.containsKey(r111) == false) goto L182;
        r124 = mNodeCacheInfos.get(r111);
    L182:
        r124.put(r125.mNodeNetworkType, r125);     // Catch: JSONException -> L136
    L138:
        mNodeCacheInfos.put(r111, r124);
        r109.add(r125);
    L136:
        e = move-exception;
        e.printStackTrace();
    L139:
        r101 = false;
        goto L44
    L109:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseNewOptRecordStruct != 1) goto L111;
        String r126 = r113.newLookUp(shouldRequestIpv6(), CastIntegerProtector.valueOf(r103).intValue(), -1);
    L113:
        if (TextUtils.isEmpty(r126) == true) goto L117;
        if (this.mPreconnListener == null) goto L117;
        this.mPreconnListener.onReadyDoPreConnect(r111, r126);
        goto L117
    L111:
        r126 = r113.lookup(shouldRequestIpv6(), -1);
        goto L113
    L93:
        if (this.mRequestDomain.equals("none") == true) goto L106;
        if (TextUtils.equals(r113.host, this.mRequestDomain) == false) goto L106;
        if (r113.getAllResolveResults().isEmpty() == true) goto L106;
        JSONObject r127 = new JSONObject();
        r127 = new JSONObject().put("host", r111);     // Catch: JSONException -> L101
    L103:
        final JSONObject r128 = getNodeOptimizerInfos(r127, null);
        Handler r129 = this.mHandlerOfListener;
        if (r129 == null) goto L106;
        r129.removeCallbacksAndMessages(null);
        this.mHandlerOfListener.post(new AnonymousClass5(this, r128));
    L101:
        e = move-exception;
        e.printStackTrace();
        goto L103
    L87:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseNewOptRecordStruct != 1) goto L89;
        r113.setDnsResult(r116, 2, this.mCurrentNetworkType);
    L89:
        r113.setRemoteLocalDnsResult(r116);
        goto L90
    L57:
        r117 = false;
        goto L58
    L50:
        r112 = new OptRecord(r111, r101 ? 1 : 0);
        goto L54
    L52:
        if (this.mDomainParseType.get(r111) == null) goto L54;
        r112.setParseType(this.mDomainParseType.get(r111).intValue());
        goto L54
    L140:
        if (r102 == true) goto L153;
        NetworkProber.inst().initUdpProbe();
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L153;
        if (LSSettings.inst().mPersistenceConfigInfo.mNodeTableEnable != 1) goto L153;
        if (r109.size() == 0) goto L153;
        if (LSSettings.inst().mPersistenceConfigInfo.mNodeUpdateLimit == 0) goto L153;
        if ((LiveStrategyManager.inst().mReceiveMessage % LSSettings.inst().mPersistenceConfigInfo.mNodeUpdateLimit) != 0) goto L153;
        long r130 = System.currentTimeMillis();
        NodeTableOperate.mNodeStrategySQLMonitor.updateMonitorLogInfo(NodeTableOperate.TABLE_NAME_NODE, BaseStrategyMonitor.MONITOR_UPDATE_OPERATE, TAG, NodeTableOperate.replaceAllRecord(r109), r130, "Update ip result");
        NodeTableOperate.mNodeStrategySQLMonitor.uploadMonitorLog();
    L153:
        if (this.mTheFirstIntoUpdate == false) goto L155;
        return;
    L155:
        if (this.mIsGetHotDomainsSuccess == false) goto L157;
        this.mTheFirstIntoUpdate = true;
    L157:
        this.mIsGetHotDomainsSuccess = true;
        if (r102 == false) goto L160;
        this.mHandler.postDelayed(new AnonymousClass7(this), LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mFirstDnsDelay * 1000);
        return;
    L160:
        if (PredictFirstPlayTime.inst().mIsFirst == true) goto L162;
    L166:
        boolean r131 = false;
    L167:
        JSONObject r132 = PredictFirstPlayTime.inst().runStrategy();
        PredictFirstPlayTime.inst().uploadPredictValue(r132);
        if (r131 == false) goto L170;
        PredictFirstPlayTime.inst().saveDataToDB(-1);
    L170:
        if (r132 != null) goto L172;
    L174:
        long r133 = 0;
    L175:
        this.mHandler.postDelayed(new AnonymousClass6(this), r133);
        return;
    L172:
        if (r132.optInt("result", -1) == (-1)) goto L174;
        r133 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mDelayTimeForFirstDns;
        goto L175
    L162:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUsePTY != 1) goto L166;
        if (PitayaWrapper.inst().getPtyInitResult() == false) goto L166;
        PredictFirstPlayTime.inst().mIsFirst = false;
        r131 = true;
        goto L167
    L35:
        r106.add(r310);
        r107 = r106;
        goto L37
    L13:
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L26;
        if (LSSettings.inst().mPersistenceConfigInfo.mNodeTableEnable != 1) goto L26;
        Set<String> r134 = this.mHosts;
        if (r134 != null) goto L19;
    L21:
        long r135 = System.currentTimeMillis();
        Set<String> r136 = NodeTableOperate.getAllDomain();
        this.mHosts = r136;
        StrategySQLMonitorLog r137 = NodeTableOperate.mNodeStrategySQLMonitor;
        String r138 = NodeTableOperate.TABLE_NAME_NODE;
        String r139 = BaseStrategyMonitor.MONITOR_QUERY_OPERATE;
        if (r136.size() == 0) goto L24;
        long r140 = 1;
    L25:
        r137.updateMonitorLogInfo(r138, r139, TAG, r140, r135, "Query domain");
        NodeTableOperate.mNodeStrategySQLMonitor.uploadMonitorLog();
        goto L26
    L24:
        r140 = 0;
        goto L25
    L19:
        if (r134.size() == 0) goto L21;
        NodeTableOperate.insertDomain(this.mHosts);
        goto L26
    L9:
        if (this.mTheFirstIntoUpdate == true) goto L27;
    L5:
        r102 = false;
        goto L6
    }

    private JSONObject _getNodeOptimizerInfos(JSONObject r310, INodeListener r311) {
        Objects.toString(r310);
        String r100 = null;
        if (r310 != null) goto L5;
        return null;
    L5:
        final String r101 = r310.optString("host");
        if (r310.has("EnableIPv6") == false) goto L8;
        int r102 = r310.optInt("EnableIPv6");
    L9:
        this.mRequestTimeOut = r310.optInt("timeout");
        JSONObject r103 = addBasicMetrics(new JSONObject());
        Map<String, OptRecord> r104 = mOptResults;
        OptRecord r105 = r104.get(r101);
        if (r105 == null) goto L54;
        if (r102 != 0) goto L14;
    L12:
        int r106 = 0;
    L30:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableSupportIpOnlyMode != 1) goto L37;
        int r110 = r105.mIpMode;
        if (r110 == 2) goto L37;
        if (r110 != 1) goto L35;
        r106 = 1;
        goto L37
    L35:
        r106 = 0;
    L37:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseNewOptRecordStruct != 1) goto L47;
        int r111 = this.mCurrentNetworkType;
        if (r310.has("NetworkType") == false) goto L41;
        r111 = r310.optInt("NetworkType");
    L41:
        if (r102 != 0) goto L43;
    L45:
        boolean r107 = false;
    L46:
        String r108 = r105.newLookUp(r107, r111, r106);
        JSONObject r109 = r105.newGetEvaluatorSymbol(r108, r111);
        Object r112 = r105.newGetRemoteResults(r111);
    L53:
        JSONObject r210 = r109;
        r100 = r108;
        int r113 = r105.mIpMode;
        Object r114 = r112;
        JSONObject r115 = r210;
    L56:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableHttpDns != 1) goto L68;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRefresh != 1) goto L68;
        if (r100 != null) goto L68;
        if (this.mCompleteFirstLocalDns == false) goto L68;
        if (this.mHasResetDNSResults == true) goto L68;
        if (r104.containsKey(r101) == false) goto L68;
        this.mHandler.post(new AnonymousClass3(this, r101));
    L68:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mPerfOptNotExeFunc == 1) goto L111;
        if (r100 != null) goto L111;
        if (LSSettings.inst().mPersistenceConfigInfo.mEnable != 1) goto L111;
        if (LSSettings.inst().mPersistenceConfigInfo.mNodeTableEnable != 1) goto L111;
        String r116 = String.valueOf(this.mCurrentNetworkType);
        if (this.updateNodeCacheInfos == true) goto L77;
    L93:
        int r117 = 0;
        int r118 = -1;
    L94:
        if (r100 != null) goto L104;
        NodeCacheInfos r119 = new NodeCacheInfos();
        long r211 = System.currentTimeMillis();
        JSONObject r120 = r119.queryIp(r101, r116);
        if (r120 != null) goto L98;
        int r121 = r117;
        int r122 = -1;
    L103:
        NodeTableOperate.mNodeStrategySQLMonitor.updateMonitorLogInfo(NodeTableOperate.TABLE_NAME_NODE, BaseStrategyMonitor.MONITOR_QUERY_OPERATE, TAG, r122, r211, "Query ip:" + r100);
        NodeTableOperate.mNodeStrategySQLMonitor.uploadMonitorLog();
        r118 = r118;
        r117 = r121;
        goto L104
    L98:
        if (r120.has("Ip") == false) goto L100;
        r100 = r120.optString("Ip");
        r121 = 2;
    L101:
        r122 = r120.optInt("code");
        r118 = r120.optInt("reason");
        goto L103
    L100:
        r121 = r117;
    L104:
        if (r100 == null) goto L113;
        if (r115 == null) goto L152;
    L107:
        r115.put(r100, "persistence_data");     // Catch: JSONException -> L109
    L109:
        e = move-exception;
        e.printStackTrace();
        goto L113
    L152:
        r115 = new JSONObject();     // Catch: JSONException -> L109
    L113:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableIpRace == 1) goto L115;
    L154:
        r103.put("Ip", r100);     // Catch: JSONException -> L148
        r103.put("EvaluatorSymbol", r115);     // Catch: JSONException -> L148
        r103.put("RemoteResult", r114);     // Catch: JSONException -> L148
        r103.put("Persistence_type", r117);     // Catch: JSONException -> L148
        r103.put("Persistence_timeout", r118);     // Catch: JSONException -> L148
        r103.put("IPMode", r113);     // Catch: JSONException -> L148
        Objects.toString(r115);     // Catch: JSONException -> L148
        if (TextUtils.isEmpty(r100) == false) goto L145;
        Set<String> r123 = this.mHosts;     // Catch: JSONException -> L148
        if (r123 != null) goto L125;
    L135:
        r103.put("HasGetDomainInfos", false);     // Catch: JSONException -> L148
    L136:
        boolean r124 = this.mHasResetDNSResults;     // Catch: JSONException -> L148
        if (r124 == false) goto L139;
        r103.put("HasResetDNSResults", r124);     // Catch: JSONException -> L148
    L139:
        r103.put("RetryFailStopSchedule", this.mRetryFailStopSchedule);     // Catch: JSONException -> L148
        if (r311 != null) goto L142;
    L150:
        startIPRace(r101);
        return r103;
    L142:
        if (this.mIsAlreadyDidOnMessage == true) goto L144;
        r311.onMessage(r103);     // Catch: JSONException -> L148
        goto L150
    L144:
        this.mIsAlreadyDidOnMessage = false;     // Catch: JSONException -> L148
        this.mNodeListener = r311;     // Catch: JSONException -> L148
        this.mRequestDomain = r101;     // Catch: JSONException -> L148
        this.mListenThreadPool.submit(new AnonymousClass4(this, r101));     // Catch: JSONException -> L148
        goto L150
    L125:
        if (r123.size() <= 0) goto L135;
        r103.put("HasGetDomainInfos", true);     // Catch: JSONException -> L148
        if (this.mHosts.contains(r101) == false) goto L130;
        r103.put("IsHostContained", true);     // Catch: JSONException -> L148
    L132:
        if (r105 == null) goto L134;
        r103.put("HasLocalDNSResult", r105.hasLocalDNSResult);     // Catch: JSONException -> L148
        goto L136
    L134:
        r103.put("HasLocalDNSResult", -1);     // Catch: JSONException -> L148
        goto L136
    L130:
        r103.put("IsHostContained", false);     // Catch: JSONException -> L148
        goto L132
    L145:
        if (r311 == null) goto L150;
        r311.onMessage(r103);     // Catch: JSONException -> L148
    L148:
        e = move-exception;
        e.printStackTrace();
        goto L150
    L115:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L154;
        String r125 = nativeGetPreferedIP(r101);
        if (TextUtils.isEmpty(r125) == true) goto L154;
        r100 = r125;
        goto L154
    L77:
        if (mNodeCacheInfos.containsKey(r101) == false) goto L93;
        JSONObject r126 = mNodeCacheInfos.get(r101);
        if (r126 == null) goto L93;
        if (r126.has(r116) == false) goto L93;
        NodeCacheInfos r127 = (NodeCacheInfos) r126.opt(r116);
        if (r127 == null) goto L93;
        if (BaseTableOperate.calDiffOfTime(r127.mUpdateTime, BaseTableOperate.getCurrentTimeFormat()) > LSSettings.inst().mPersistenceConfigInfo.mNodeCacheTime) goto L91;
        r100 = r127.getIpFromIps();
        if (r100 == null) goto L89;
        r117 = 1;
    L90:
        r118 = 0;
        goto L94
    L89:
        r117 = 0;
        goto L90
    L91:
        r117 = 0;
        r118 = 1;
    L111:
        r117 = -1;
        r118 = -1;
        goto L113
    L43:
        if (shouldRequestIpv6() == false) goto L45;
        r107 = true;
        goto L46
    L47:
        if (r102 != 0) goto L49;
    L51:
        boolean r128 = false;
    L52:
        r108 = r105.lookup(r128, r106);
        r109 = r105.getEvaluatorSymbol(r108);
        r112 = r105.getRemoteResults();
        goto L53
    L49:
        if (shouldRequestIpv6() == false) goto L51;
        r128 = true;
        goto L52
    L14:
        if (r310.has("PreferIpType") == false) goto L17;
        r106 = r310.optInt("PreferIpType");
        goto L30
    L17:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDefaultReturnIPv4 == 1) goto L12;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mForbidUseIpv6InWiFi != 1) goto L23;
        if (this.mCurrentNetworkType == 4) goto L12;
    L23:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableIPv6ProbeLoop != 1) goto L28;
        if (r102 == 0) goto L12;
        if (shouldRequestIpv6() == false) goto L12;
    L28:
        r106 = -1;
        goto L30
    L54:
        r115 = null;
        r114 = null;
        r113 = 2;
        goto L56
    L8:
        r102 = -1;
        goto L9
    }

    public static /* synthetic */ String access$1002(DnsOptimizer r100, String r101) {
        r100.mRequestDomain = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1102(DnsOptimizer r100, boolean r101) {
        r100.mIsAlreadyDidOnMessage = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$1802(DnsOptimizer r100, boolean r101) {
        r100.mHasLocalDNSTimeout = r101;
        return r101;
    }

    public static /* synthetic */ void access$2000(DnsOptimizer r100, String r101) {
        r100.nativeStartIPRace(r101);
    }

    public static /* synthetic */ Handler access$802(DnsOptimizer r100, Handler r101) {
        r100.mHandlerOfListener = r101;
        return r101;
    }

    public void _startLocalDns(OnParseDnsCompletionListener r100, String r101) {
        int r102 = LSSettings.inst().mEnableNativeNodeOptimize;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L50;
        Map<String, OptRecord> r103 = mOptResults;
        if (r103 != null) goto L9;
    L49:
        r100.onParseDnsComplete(r101);
        return;
    L9:
        if (r103.size() == 0) goto L49;
        Set<String> r104 = this.mHosts;
        if (r104 == null) goto L49;
        if (r104.size() == 0) goto L49;
        if (this.mDoLocalDnsHosts == null) goto L49;
        this.mHasSendToResolveCount = 0;
        this.mHasResolvedCount = 0;
        this.mCurLoopStartDnsTS = System.currentTimeMillis();
        NodeOptimizeLoopMonitorLog r105 = this.mLoopMonitor;
        r105.mIndex++;
        r105.mEnableLocalDnsTimeout = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mSendHttpDnsByLocalDnsTimeout;
        this.mLoopMonitor.mEnableForceRefresh = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRefresh;
        this.mLoopMonitor.mEnableHttpDNS = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableHttpDns;
        this.mLoopMonitor.mHttpDNSType = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDomainType;
        this.mLoopMonitor.mEnableTopn = TopNHostStrategy.inst().mEnable;
        this.mLoopMonitor.mDoLocalDnsHostSet = this.mDoLocalDnsHosts;
        this.mDnsErrorMonitor.mEnableLocalDnsTimeout = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mSendHttpDnsByLocalDnsTimeout;
        this.mDnsErrorMonitor.mEnableForceRefresh = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableRefresh;
        this.mDnsErrorMonitor.mEnableHttpDNS = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableHttpDns;
        this.mDnsErrorMonitor.mHttpDNSType = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDomainType;
        this.mLock.lock();
        mHttpDnsDomainList.clear();
        this.mLock.unlock();
        Set<String> r106 = this.mHosts;
        if (r106 == null) goto L37;
        Iterator<String> r107 = r106.iterator();
    L20:
        if (r107.hasNext() == false) goto L37;
        String r108 = r107.next();
        OptRecord r109 = mOptResults.get(r108);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableHttpDns != 1) goto L20;
        if (r109 == null) goto L20;
        if (r109.parseType != 1) goto L20;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDomainType == 2) goto L36;
        if (r108.length() < 4) goto L20;
        String r110 = r108.substring(0, 4);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableDomainType != 1) goto L33;
        String r111 = "pull";
    L35:
        if (TextUtils.equals(r110, r111) == false) goto L20;
    L33:
        r111 = "push";
    L36:
        this.mLock.lock();
        mHttpDnsDomainList.add(r109.host);
        this.mLock.unlock();
    L37:
        this.mHasLocalDNSTimeout = false;
        if (this.mDoLocalDnsHosts == null) goto L48;
        ArrayList r112 = new ArrayList(this.mDoLocalDnsHosts);
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnablePreferParsingPushNode != 1) goto L42;
        SortHosts(r112);
    L42:
        Iterator r113 = r112.iterator();
    L44:
        if (r113.hasNext() == false) goto L48;
        OptRecord r114 = mOptResults.get((String) r113.next());
        if (r114 == null) goto L44;
        resolve(r114, r100, r101);
    L48:
        this.mHasResetDNSResults = false;
        return;
    L50:
        resolve(mOptResults.get(r101), r100, r101);
    }

    public int getIntValue(int r100, int r101) {
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L7;
        return r101;
    L7:
        return this.mUDPProbeResult;
    L9:
        return this.mIPV6ProbeResult;
    }

    public List<String> getNodeListWithHostByKey(int r100, String r101) {
        List<String> r102 = new ArrayList();
        int r103 = 0;
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L7;
        int r104 = 0;
    L11:
        if (this.mRunning == true) goto L13;
    L35:
        return r102;
    L13:
        if (LSSettings.inst().mEnableSelectNode == false) goto L35;
        if (r104 <= 0) goto L35;
        OptRecord r105 = mOptResults.get(r101);
        if (r105 == null) goto L34;
        if (r100 != 2) goto L21;
        r102 = r105.getAllIPList();
        goto L34
    L21:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableSupportIpOnlyMode != 1) goto L29;
        if (r100 == 0) goto L24;
    L25:
        if (r100 != 1) goto L29;
        if (r105.mIpMode != 0) goto L29;
    L31:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableUseNewOptRecordStruct != 1) goto L33;
        r102 = r105.getIpListByKeyWithNetworkType(r100, r103, this.mCurrentNetworkType);
        goto L34
    L33:
        r102 = r105.getIpListByKey(r100, r103);
        goto L34
    L24:
        if (r105.mIpMode == 1) goto L31;
    L29:
        r103 = r104;
    L34:
        Objects.toString(r102);
        goto L35
    L7:
        r104 = 10;
        goto L11
    L8:
        r104 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mRequiredIpv6IpCount;
        goto L11
    L9:
        r104 = LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mRequiredIpv4IpCount;
        goto L11
    }

    public JSONObject getNodeOptimizerInfos(JSONObject r100, INodeListener r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        r100.toString();
        if (LSSettings.inst().mEnableNativeDns != 1) goto L16;
        if (VeLSUtils.isLoadSoSuccess() == false) goto L16;
        JSONObject r102 = new JSONObject();     // Catch: Exception -> L14
        String r103 = nativeGetNodeOptimizerInfos(r100.toString());     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r103) == true) goto L12;
        r102 = new JSONObject(r103);     // Catch: Exception -> L14
    L12:
        return addBasicMetrics(r102);
    L14:
        return null;
    L16:
        return _getNodeOptimizerInfos(r100, r101);
    }

    public void startLocalDns(OnParseDnsCompletionListener r100, String r101) {
        if (LSSettings.inst().mEnableNativeDns != 1) goto L11;
        if (r100 != null) goto L7;
        return;
    L7:
        if (this.mHosts != null) goto L9;
        return;
    L9:
        if (VeLSUtils.isLoadSoSuccess() == false) goto L14;
        nativeResolveLocalDns(this.mHosts);
        r100.onParseDnsComplete(r101);
        this.mCompleteFirstLocalDns = true;
        return;
    L14:
        return;
    L11:
        _startLocalDns(r100, r101);
    }

    private void resolve(final OptRecord r110, final OnParseDnsCompletionListener r111, final String r112) {
        String r100 = r110.host;
        if (this.mRunning == true) goto L5;
        return;
    L5:
        final ResolveTask r101 = new ResolveTask(r100);
        List<ResolveTask> r102 = this.mInFlightTasks;
        monitor-enter(r102);
        this.mInFlightTasks.add(r101);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        final Future<?> r103 = this.mThreadPool.submit(new AnonymousClass8(this, r101, r112, r110, r111));
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableHttpDns == 1) goto L12;
        return;
    L12:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableListenerThread != 1) goto L21;
        this.mListenThreadPool.submit(new AnonymousClass9(this, r103, r110, r111, r112));
        return;
    L21:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public String addNodeOptimizerRequestBody(boolean r100, boolean r101, String r102) {
        if (TextUtils.equals(r102, null) == false) goto L26;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableHttpDns != 1) goto L14;
        if (r100 == false) goto L14;
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mSendHttpDnsByLocalDnsTimeout == 1) goto L10;
    L13:
        String r103 = addHttpDnsRequest(null);
    L16:
        if (LSSettings.inst().mEnableSelectNode == false) goto L19;
        if (r101 == false) goto L19;
        String r104 = addSelectNodeRequest(null);
    L21:
        if (r104.equals("") == false) goto L23;
        return r103;
    L23:
        if (r103.equals("") == true) goto L39;
        return r104 + "," + r103;
    L39:
        return r104;
    L19:
        r104 = "";
        goto L21
    L10:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mSendHttpDnsByLocalDnsTimeout != 1) goto L14;
        if (this.mHasLocalDNSTimeout == true) goto L13;
    L14:
        r103 = "";
        goto L16
    L26:
        if (LSSettings.inst().mCommonConfigInfo.mLSStrategySDKSettings.mEnableHttpDns != 1) goto L28;
        String r105 = addHttpDnsRequest(r102);
    L30:
        if (LSSettings.inst().mEnableSelectNode == false) goto L32;
        r104 = addSelectNodeRequest(r102);
    L34:
        if (r104.equals("") == false) goto L36;
        return r105;
    L36:
        if (r105.equals("") == true) goto L39;
        return r104 + "," + r105;
    L32:
        r104 = "";
        goto L34
    L28:
        r105 = "";
        goto L30
    }
}
