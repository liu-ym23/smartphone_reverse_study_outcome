package com.bytedance.ttnet;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.b;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cookie.h;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.JavaInterceptorCallbackRegistry;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchResult;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLDispatcher;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.URLRequest;
import com.bytedance.frameworks.baselib.network.http.util.c;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.retrofit2.AppActivityResumeSuspendRecorder;
import com.bytedance.retrofit2.AppLaunchTimeStampProvider;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ttnet.config.AppConfig;
import com.bytedance.ttnet.config.SDKConfig;
import com.bytedance.ttnet.debug.DebugMode;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.httpdns.TTDnsOuterService;
import com.bytedance.ttnet.httpdns.TTDnsResult;
import com.bytedance.ttnet.okhttp.OkHttpAppInfoProvider;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import com.bytedance.ttnet.utils.TtnetUtil;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import com.ttnet.org.chromium.base.TTProcessUtils;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import ux5.d;

/* JADX INFO: loaded from: classes.dex */
public class TTNetInit {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String DOMAIN_BOE_HTTPS_KEY = "boe_https";
    public static final String DOMAIN_BOE_KEY = "boe";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static final String ENCRYPT_RETRY_HEADER = "x-ttnet-retry-encrypt";
    public static final String ENCRYPT_RETRY_VERIFY_HEADER = "x-tt-e-ignore-status-code-verify";
    private static final int INIT_TIMEOUT_VALUE = 5;
    private static final String OKHTTP_DISPATCH_FAILED = "okhttp dispatch failed.";
    private static final String RETURN_WRONG_FORMAT = "Conversion = 'ttUrlDispatch returns wrong format'";
    private static final String TAG = null;
    public static final int TELEMETRY_DISABLE_DEFAULT_REPORTING = 1;
    public static final int TELEMETRY_DISABLE_NATIVE_REQUEST_API_ALL_ROUTE = 2;
    public static final int TELEMETRY_OPTION_FLAG_NONE = 0;
    private static final String TTNET_CRONET_NOT_INITIALIZED = "cronet not init.";
    private static volatile ENV env;
    private static volatile boolean sApiHttpInterceptEnabled;
    private static volatile int sAppSecurityLevel;
    private static volatile String sClientIPString;
    public static ICronetAppProvider sCronetProvider;
    private static volatile int sDelayTime;
    public static Map<String, String> sGetDomainRegionMap;
    private static ITTNetDepend sITTNetDepend;
    private static volatile CountDownLatch sLatchInitCompleted;
    public static b sLifeCycleMonitor;
    private static volatile boolean sListenAppStateIndependently;
    private static volatile long sMaxHttpDiskCacheSize;
    private static volatile boolean sNotifiedColdStartFinsish;
    private static volatile List<String> sPublicIPv4List;
    private static volatile List<String> sPublicIPv6List;
    public static JSONObject sSlaSamplingSettingObject;
    private static volatile boolean sStateDelayNewStrategyEnabled;
    private static ITTSystemApiSandbox sSystemApiSandbox;
    private static TTNetThreadConfigInfoManager sTTNetThreadConfigInfoManager;
    private static volatile int sTelemetryOptionFlags;

    /* JADX INFO: loaded from: classes3.dex */
    public static final enum ENV extends Enum<ENV> {
        private static final /* synthetic */ ENV[] $VALUES = null;
        public static final ENV DEBUG = null;
        public static final ENV RELEASE = null;

        static {
            ENV r100 = new ENV("DEBUG", 0);
            DEBUG = r100;
            ENV r101 = new ENV("RELEASE", 1);
            RELEASE = r101;
            $VALUES = new ENV[]{r100, r101};
        }

        public static ENV[] values() {
            return (ENV[]) $VALUES.clone();
        }

        public static ENV valueOf(String r100) {
            return (ENV) r27.a.a(ENV.class, r100);
        }

        private ENV(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface RetryEncryptRequestCallback {
        void onCallToRetryEncryptRequestByHeader(String r100, List<Header> r101, Map<String, List<String>> r102);
    }

    public TTNetInit() {
    }

    public static void doCommand(Context r100, String r101) {
    }

    public static void enableCookieLogReport(boolean r100) {
    }

    public static void preInitCronetKernel() throws Exception {
        int r100 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L11;
        r100 = 3;
    L11:
        String r101 = TtnetUtil.outputThrowableStackTrace(th);
        if (r101.length() <= 1024) goto L14;
        r101 = r101.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r100, r101);
        TNCManager.getInstance().handleCronetInitFailed();
        throw th;
    L4:
        if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.PRE_INIT) != null) goto L18;
        r100 = SsOkHttp3Client.getFallbackReason();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r100, "");     // Catch: Throwable -> L7
        return;
    }

    public static void setALogFuncAddr(long r100) throws Exception {
    }

    public static void setCookieHandler(Context r100) {
    }

    public static void setDelayTime(int r100) {
    }

    public static void setEnableURLDispatcher(boolean r100) throws Exception {
    }

    public static void setFirstRequestWaitTime(long r100) {
    }

    public static void setHttpDnsForTesting(boolean r100, boolean r101, boolean r102) throws Exception {
    }

    public static void setMainThreadInitCookieEnabled(boolean r100) {
    }

    private static void tryInitCookieManager(Context r100, boolean r101, boolean r102) {
    }

    public static boolean urlDispatchEnabled() {
        return true;
    }

    static {
        TAG = "TTNetInit";
        sTelemetryOptionFlags = 0;
        sDelayTime = 10;
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = false;
        sListenAppStateIndependently = false;
        sStateDelayNewStrategyEnabled = false;
        sMaxHttpDiskCacheSize = 67108864;
        sAppSecurityLevel = 0;
        sLifeCycleMonitor = new b();
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = false;
        sClientIPString = "";
    }

    private static void countDownInitCompletedLatch() {
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (sLatchInitCompleted.getCount() <= 0) goto L11;
        sLatchInitCompleted.countDown();     // Catch: Exception -> L6
        return;
    }

    public static void getInitCompletedLatch() {
        sLatchInitCompleted.await(5, TimeUnit.SECONDS);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public static ITTNetDepend getTTNetDepend() {
        ITTNetDepend r100 = sITTNetDepend;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        TTNetThreadConfigInfoManager r100 = sTTNetThreadConfigInfoManager;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getThreadConfigCallbackImpl();
    }

    public static List<TTNetThreadConfig> getThreadConfigInfoList() {
        TTNetThreadConfigInfoManager r100 = sTTNetThreadConfigInfoManager;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getThreadConfigInfoList();
    }

    public static void notifyColdStartFinish() {
        if (sITTNetDepend != null) goto L5;
        return;
    L5:
        if (sNotifiedColdStartFinsish == true) goto L9;
        sNotifiedColdStartFinsish = true;
        sITTNetDepend.onColdStartFinish();
        return;
    }

    private static void setCookieInitCompleted() {
        SsCronetHttpClient r100 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.COOKIE_INIT_COMPLETE_API);     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setCookieInitCompleted();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void forceInitCronetKernel() throws Exception {
        if (TTNetInitMetrics.g().f244605a != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r100 = TTNetInitMetrics.g();
        r100.f244605a = TTNetInitMetrics.CronetInitMode.FORCE_INIT;
    L5:
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryCreateCronetEngine(false, false, false, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), true, sCronetProvider);
    }

    public static long getALogFuncAddr() {
        return TTALog.getALogFuncAddr();
    }

    public static int getEffectiveConnectionType() {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getEffectiveConnectionType();
    L4:
        th = move-exception;
        th.printStackTrace();
        return 0;
    }

    public static Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getGroupRttEstimates();
    }

    public static NetworkQuality getNetworkQuality() throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getNetworkQuality();
    }

    public static void useCustomizedCookieStoreName() {
        h.f244715f = "ttnetCookieStore";
    }

    public static void OnAppActivitySuspend() {
        AppActivityResumeSuspendRecorder.OnAppActivitySuspend();
    }

    public static void OnAppActiviyResume() {
        AppActivityResumeSuspendRecorder.OnAppActiviyResume();
    }

    public static /* synthetic */ String access$000() {
        return TAG;
    }

    public static /* synthetic */ boolean access$100() {
        return sStateDelayNewStrategyEnabled;
    }

    public static /* synthetic */ void access$300() {
        setCookieInitCompleted();
    }

    public static boolean apiHttpInterceptEnabled() {
        return sApiHttpInterceptEnabled;
    }

    public static int getAppSecurityLevel() {
        return sAppSecurityLevel;
    }

    public static String getClientIpString() {
        return sClientIPString;
    }

    public static ICronetAppProvider getCronetProvider() {
        return sCronetProvider;
    }

    public static ENV getEnv() {
        return env;
    }

    public static boolean getListenAppStateIndependently() {
        return sListenAppStateIndependently;
    }

    public static long getMaxHttpDiskCacheSize() {
        return sMaxHttpDiskCacheSize;
    }

    public static List<String> getPublicIPv4List() {
        return sPublicIPv4List;
    }

    public static List<String> getPublicIPv6List() {
        return sPublicIPv6List;
    }

    public static JSONObject getSlaSamplingSetting() {
        return sSlaSamplingSettingObject;
    }

    public static boolean getStateDelayNewStrategyEnabled() {
        return sStateDelayNewStrategyEnabled;
    }

    public static ITTSystemApiSandbox getSystemApiSandbox() {
        return sSystemApiSandbox;
    }

    public static int getTelemetryOptionFlags() {
        return sTelemetryOptionFlags;
    }

    public static void clearClientOpaqueData(Context r100) {
        SsCronetHttpClient.inst(r100).clearClientOpaqueData(false);
    }

    public static void clearClientOpaqueDataV1(Context r100) {
        SsCronetHttpClient.inst(r100).clearClientOpaqueData(true);
    }

    public static void clearTNCFileBeforeStart(Context r100) {
        if (r100 == null) goto L12;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getFilesDir(), "server.json");     // Catch: Throwable -> L13
        if (r101.exists() == false) goto L6;
        r101.delete();     // Catch: Throwable -> L13
    L6:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100.getFilesDir(), "tt_net_config.config");     // Catch: Throwable -> L13
        if (r102.exists() == false) goto L9;
        r102.delete();     // Catch: Throwable -> L13
    L9:
        clearSharedPreferencesFile(r100, AppConfig.getSsAppConfigFileName());
        clearSharedPreferencesFile(r100, TNCManager.TNC_SP_NAME);
        sx5.b r103 = sx5.b.f543815n;
        clearSharedPreferencesFile(r100, "ttnet_store_region");
        return;
    L12:
        throw new IllegalArgumentException("context is null");
    }

    public static List<InetAddress> dnsLookup(String r100) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L24;
        TTDnsResult r101 = TTDnsResolve(r100, 0);
        if (r101.ret != 0) goto L22;
        List<String> r102 = r101.iplist;
        if (r102 == null) goto L22;
        if (r102.isEmpty() == true) goto L22;
        ArrayList r103 = new ArrayList();
        Iterator<String> r104 = r101.iplist.iterator();
    L12:
        if (r104.hasNext() == false) goto L17;
        byte[] r105 = InetAddress.getByName(r104.next()).getAddress();
        if (r105 == null) goto L12;
        r103.add(InetAddress.getByAddress(r100, r105));
        goto L12
    L17:
        if (r103.isEmpty() == true) goto L20;
        return r103;
    L20:
        throw new UnknownHostException(r100);
    L22:
        throw new UnknownHostException(r100);
    L24:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void enableApiHttpIntercept(boolean r100) {
        sApiHttpInterceptEnabled = r100;
    }

    public static void enableProceedWithoutHook(boolean r100) {
        RealInterceptorChain.setProceedWithoutHookEnabled(r100);
    }

    public static void enableSsCallUseOkioReadForNoneStream(boolean r100) {
        com.bytedance.frameworks.baselib.network.http.impl.a.setUseOkioRead(r100);
    }

    private static SsCronetHttpClient getCronetHttpClient(TTNetInitMetrics.CronetInitMode r100) throws Exception {
        if (TTNetInitMetrics.g().f244605a != TTNetInitMetrics.CronetInitMode.NONE) goto L6;
        TTNetInitMetrics.g().f244605a = r100;
    L6:
        if (HttpClient.isCronetClientEnable() == false) goto L9;
        SsCronetHttpClient r101 = SsCronetHttpClient.inst(getTTNetDepend().getContext());
        r101.tryCreateCronetEngine(false, true, false, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), false, sCronetProvider);
        sSlaSamplingSettingObject = null;
        return r101;
    L9:
        return null;
    }

    public static String getGetDomainConfigByRegion(String r100) {
        Map<String, String> r101 = sGetDomainRegionMap;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return null;
    L12:
        return sGetDomainRegionMap.get(r100.toLowerCase());
    }

    public static void getMappingRequestState(String r100) {
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).getMappingRequestState(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static PacketLossMetrics getPacketLossRateMetrics(int r100) throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getPacketLossRateMetrics(r100);
    }

    public static void onClientIPChanged(String r100) {
        if (r100 == null) goto L5;
        sClientIPString = r100;
        return;
    }

    public static void preconnectUrl(String r100) throws Exception {
        preconnectUrl(r100, null);
    }

    public static void setAppSecurityLevel(int r100) {
        sAppSecurityLevel = r100;
    }

    public static void setBypassOfflineCheck(boolean r100) {
        SsCronetHttpClient.setBypassOfflineCheck(r100);
    }

    public static void setCronetDepend(ICronetAppProvider r100) {
        if (r100 == null) goto L6;
        sCronetProvider = r100;
        TNCManager.initStoreRegionModule(r100);
        OkHttpAppInfoProvider.inst().setCronetProvider(r100);
        SsCronetHttpClient.setCronetAppInfoProvider(r100);
        SsOkHttp3Client.injectAppInfoProvider(OkHttpAppInfoProvider.inst());
        return;
    L6:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static void setEnv(ENV r100) {
        env = r100;
    }

    public static void setGetDomainRegionMap(Map<String, String> r100) {
        if (r100 == null) goto L6;
        sGetDomainRegionMap = r100;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    public static void setHostResolverRulesForTesting(String r100) throws Exception {
        SsCronetHttpClient r101 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.DEPRECATED_API);
        if (r101 == null) goto L6;
        r101.setHostResolverRules(r100);
        return;
    }

    public static void setListenAppStateIndependently(boolean r100) {
        sListenAppStateIndependently = r100;
    }

    public static void setMaxHttpDiskCacheSize(long r100) {
        if (r100 <= 0) goto L6;
        sMaxHttpDiskCacheSize = r100;
        return;
    }

    public static void setMonitorProcessHookV2(NetworkParams.k<HttpRequestInfo> r100) {
        NetworkParams.setMonitorProcessHookV2(r100);
    }

    public static void setProcessFlag(int r100) {
        i.f244792a.set(r100);
    }

    public static void setProxy(String r100) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L5;
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).setProxy(r100);
        return;
    L5:
        SsOkHttp3Client.inst(getTTNetDepend().getContext());
        SsOkHttp3Client.setProxy(r100);
    }

    public static void setRetryEncryptedRequestEnabled(final RetryEncryptRequestCallback r100) {
        NetworkParams.addRetryRequestByHeaderCallback(ENCRYPT_RETRY_VERIFY_HEADER, new AnonymousClass5(r100));
    }

    public static void setStateDelayNewStrategyEnabled(boolean r100) {
        sStateDelayNewStrategyEnabled = r100;
    }

    public static void setSystemApiSandbox(ITTSystemApiSandbox r100) {
        sSystemApiSandbox = r100;
    }

    public static void setTTNetDepend(ITTNetDepend r100) {
        sITTNetDepend = r100;
        Map<String, String> r101 = getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty(r101.get("httpdns")) == false) goto L5;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == true) goto L28;
        Object r103 = sITTNetDepend;
        if ((r103 instanceof AbsOptionalTTNetDepend) == true) goto L15;
    L17:
        ITTNetDepend r104 = sITTNetDepend;
        if ((r104 instanceof AppLaunchTimeStampProvider) == false) goto L20;
        RetrofitMetrics.sAppStartTimeProvider = (AppLaunchTimeStampProvider) r104;
    L20:
        HttpRequestInfo.injectCreate();
        String r105 = r101.get("boe");
        c.f244772a = r105;
        if (TextUtils.isEmpty(r105) == true) goto L23;
        c.f244775d = true;
    L23:
        String r106 = r101.get(DOMAIN_BOE_HTTPS_KEY);
        c.f244773b = r106;
        if (TextUtils.isEmpty(r106) == true) goto L26;
        c.f244775d = false;
    L26:
        OkHttpAppInfoProvider.inst().setTTNetDepend(r100);
        return;
    L15:
        if (((AbsOptionalTTNetDepend) r103).isPrivacyAccessEnabled() == true) goto L17;
        setAppSecurityLevel(sAppSecurityLevel | 1);
        goto L17
    L28:
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (TextUtils.isEmpty(r101.get("boe")) == true) goto L7;
    L9:
        r102 = false;
        goto L11
    L7:
        if (TextUtils.isEmpty(r101.get(DOMAIN_BOE_HTTPS_KEY)) == false) goto L9;
        goto L9
    }

    public static void setTTNetThreadConfigInfoManager(TTNetThreadConfigInfoManager r100) {
        sTTNetThreadConfigInfoManager = r100;
    }

    public static void setTelemetryOptionFlags(int r100) {
        sTelemetryOptionFlags = r100;
        boolean r101 = true;
        if ((sTelemetryOptionFlags & 1) == 0) goto L6;
        r101 = false;
    L6:
        NetworkParams.setTelemetryReportingEnabled(r101);
    }

    public static void trigerGetDomain(Context r100) {
        triggerGetDomain(r100, false);
    }

    public static void trySetDefaultUserAgent(String r100) {
        NetworkParams.setDefaultUserAgent(r100);
    }

    public static TTDispatchResult ttUrlDispatch(String r100) throws Exception {
        return ttUrlDispatchInternal(r100, -1, true);
    }

    public static TTDnsResult TTDnsResolve(String r100, int r101) throws Exception {
        return TTDnsResolve(r100, r101, null);
    }

    private static void clearSharedPreferencesFile(Context r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r100.getSharedPreferences(r101, 0).edit().clear().apply();
        return;
    }

    public static void enableSsCallUseZeroCopyReadForNoneStream(boolean r100, int r101) {
        BaseCronetSsCall.setUseZeroCopyRead(r100);
        if (r100 == false) goto L8;
        if (r101 <= 0) goto L9;
        final long r102 = ((long) r101) * 1000;
        hx5.b.a(NetworkAsyncTaskType.NETWORK).b(new AnonymousClass7(r102, r102));
        return;
    L9:
        return;
    }

    private static void feedBackCronetInitFailedLog(int r100, String r101) {
        JSONObject r102 = new JSONObject();
        r102.put("fallback", r100);     // Catch: JSONException -> L10
        r102.put(com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r101);     // Catch: JSONException -> L10
        r102.put(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, Build.MODEL);     // Catch: JSONException -> L10
        String r103 = "";
        String[] r104 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r104 != null) goto L6;
    L8:
        r102.put("abis", r103);     // Catch: JSONException -> L10
        getTTNetDepend().monitorLogSend("cronet_failed", r102);     // Catch: JSONException -> L10
        return;
    L6:
        if (r104.length <= 0) goto L8;
        r103 = Arrays.asList(r104).toString();     // Catch: JSONException -> L10
    }

    public static void monitorLogSend(String r100, JSONObject r101) {
        ITTNetDepend r102 = sITTNetDepend;
        if (r102 == null) goto L6;
        r102.monitorLogSend(r100, r101);
        return;
    }

    public static void onPublicIPsChanged(List<String> r100, List<String> r101) {
        sPublicIPv4List = r100;
        sPublicIPv6List = r101;
    }

    public static void preconnectUrl(String r100, Map<String, String> r101) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L9;
        new URL(r100).toURI();     // Catch: Exception -> L6
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).preconnectUrl(r100, r101);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void removeClientOpaqueData(Context r100, String r101) {
        SsCronetHttpClient.inst(r100).removeClientOpaqueData(r101, false);
    }

    public static void removeClientOpaqueDataV1(Context r100, String r101) {
        SsCronetHttpClient.inst(r100).removeClientOpaqueData(r101, true);
    }

    public static void runInBackGround(Context r100, boolean r101) {
        SsCronetHttpClient.inst(r100).runInBackGround(r101);
    }

    public static void setSlaSamplingSetting(Context r100, JSONObject r101) {
    L7:
        e = move-exception;
        e.printStackTrace();
        sSlaSamplingSettingObject = r101;
        return;
    L3:
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "setSlaSamplingSetting");     // Catch: Exception -> L7
    L5:
        SsCronetHttpClient.inst(r100).setSlaSamplingSetting(r101);     // Catch: Exception -> L7
    }

    public static void triggerGetDomain(Context r100, boolean r101) {
        SsCronetHttpClient.inst(r100).triggerGetDomain(r101);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r100, int r101) {
        return ttUrlDispatchV2(r100, r101, true);
    }

    public static TTDnsResult TTDnsResolve(String r100, int r101, Map<String, String> r102) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L7;
        return TTDnsOuterService.getInstance().TTDnsResolve(r100, r101, r102);
    L7:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static /* synthetic */ void access$200(Context r100, boolean r101, boolean r102) {
        initCookie(r100, r101, r102);
    }

    private static void initCookie(final Context r100, boolean r101, boolean r102) {
        com.bytedance.frameworks.baselib.network.http.cookie.b.InterfaceC3502b r103 = new AnonymousClass6(r100);
        boolean r104 = false;
        if (r101 == false) goto L24;
        Object r105 = com.bytedance.frameworks.baselib.network.http.cookie.b.f244692a;
        if (ix5.b.f496372k == true) goto L7;
    L9:
        if (r104 == true) goto L11;
        com.bytedance.frameworks.baselib.network.http.cookie.b.e(r100, true, r103);
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("CookieInitializer", "cookieInitV2 start isMain:true");
    L13:
        TTNetInitMetrics r106 = TTNetInitMetrics.g();
        r106.f244615i = System.nanoTime();
    L20:
        th = move-exception;
        Logger.d("CookieInitializer", "cookieInitV2 failed", th);
        com.bytedance.frameworks.baselib.network.http.cookie.b.a(th.getMessage(), r103);
    L22:
        TTNetInitMetrics r107 = TTNetInitMetrics.g();
        r107.f244616j = System.nanoTime();
        com.bytedance.frameworks.baselib.network.http.cookie.b.f244694c.countDown();
        r103.onSetCookieInitCompleted();
        r103.onInitClientKeyAndSessionInfo(true);
        return;
    L15:
        if (com.bytedance.frameworks.baselib.network.http.cookie.b.f244695d.get() == false) goto L17;
        SSCookieHandler.CookieInitType r108 = SSCookieHandler.CookieInitType.INIT_V2_DISABLE_COOKIE_MGR;     // Catch: Throwable -> L20
    L18:
        com.bytedance.frameworks.baselib.network.http.cookie.b.c(new SSCookieHandler(r100, null, r108, new com.bytedance.frameworks.baselib.network.http.cookie.c(r103)));     // Catch: Throwable -> L20
        goto L22
    L17:
        r108 = SSCookieHandler.CookieInitType.INIT_V2_PREFER_DELAY_COOKIE_MGR;     // Catch: Throwable -> L20
        goto L18
    L7:
        if (ix5.b.f496375n == true) goto L9;
        r104 = true;
        goto L9
    L24:
        if (r102 == false) goto L26;
        com.bytedance.frameworks.baselib.network.http.cookie.b.e(r100, false, r103);
        return;
    L26:
        com.bytedance.frameworks.baselib.network.http.cookie.b.f244694c.countDown();
        r103.onSetCookieInitCompleted();
    }

    public static boolean tryStartTTNetDetect(String[] r100, int r101, int r102) {
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if (r100.length <= 0) goto L16;
        if (r101 <= 0) goto L16;
        if (r101 > 180) goto L16;
        if (r102 < 0) goto L16;
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryStartNetDetect(r100, r101, r102);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    private static TTDispatchResult ttUrlDispatchInternal(String r100, int r101, boolean r102) throws Exception {
        if (AppConfig.getInstance(getTTNetDepend().getContext()).isChromiumOpen() == true) goto L11;
        DispatchResult r103 = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(r100, null, null));
        if (r103 == null) goto L9;
        return new TTDispatchResult(r100, r103.mDispatchedURL, String.valueOf(URLDispatcher.inst().getEpoch()), URLDispatcher.inst().getTncEtag(), TTDispatchResult.DispatchState.SUCCESS, "");
    L9:
        throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
    L11:
        if (TTNetInitMetrics.h() == false) goto L17;
        new URL(r100).toURI();     // Catch: Exception -> L14
        return SsCronetHttpClient.ttUrlDispatch(r100, r101, r102);
    L14:
        e = move-exception;
        throw e;
    L17:
        throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r100, int r101, boolean r102) {
        new URL(r100).toURI();     // Catch: Exception -> L50
        return ttUrlDispatchInternal(r100, r101, r102);
    L5:
        e = move-exception;
        String r103 = e.getMessage();
        if ((e instanceof IllegalArgumentException) == true) goto L9;
    L12:
        boolean r104 = e instanceof IllegalStateException;
        if (r104 == false) goto L19;
        if (TTNET_CRONET_NOT_INITIALIZED.equals(r103) == false) goto L19;
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L19:
        if ((e instanceof UnsupportedOperationException) == true) goto L21;
    L24:
        if (r104 == false) goto L30;
        if ("Engine is shut down.".equals(r103) == false) goto L30;
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L30:
        if ((e instanceof UnknownFormatConversionException) == false) goto L36;
        if (RETURN_WRONG_FORMAT.equals(r103) == false) goto L36;
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.WRONG_FORMAT, e);
    L36:
        if ((e instanceof URISyntaxException) == true) goto L49;
        if ((e instanceof MalformedURLException) == true) goto L49;
        if ((e instanceof SocketTimeoutException) == false) goto L47;
        if (TrafficMetrics.FRPM_TTNET.equals(r103) == false) goto L47;
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.TIMEOUT, e);
    L47:
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.NOT_REACHED, e);
    L49:
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.INVALID_FINAL_URL, e);
    L21:
        if (ConstantsDefined.CRONET_NOT_INITIALIZED.equals(r103) == false) goto L24;
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L9:
        if (OKHTTP_DISPATCH_FAILED.equals(r103) == false) goto L12;
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.OKHTTP_DISPATCH_FAILED, e);
    L50:
        e = move-exception;
        return new TTDispatchResult(r100, TTDispatchResult.DispatchState.INVALID_ORIGIN_URL, e);
    }

    public static void addClientOpaqueData(Context r100, String[] r110, byte[] r111, byte[] r112) {
        SsCronetHttpClient.inst(r100).addClientOpaqueData(r110, r111, r112, 0, 0, false);
    }

    public static void addClientOpaqueDataV1(Context r100, String[] r110, byte[] r111, byte[] r112) {
        SsCronetHttpClient.inst(r100).addClientOpaqueData(r110, r111, r112, 0, 0, true);
    }

    public static void addClientOpaqueData(Context r100, String[] r110, byte[] r111, byte[] r112, long r113, long r114) {
        SsCronetHttpClient.inst(r100).addClientOpaqueData(r110, r111, r112, r113, r114, false);
    }

    public static void addClientOpaqueDataV1(Context r100, String[] r110, byte[] r111, byte[] r112, long r113, long r114) {
        SsCronetHttpClient.inst(r100).addClientOpaqueData(r110, r111, r112, r113, r114, true);
    }

    public static void enableTTBizHttpDns(boolean r100, String r101, String r110, String r111, boolean r112, String r113) {
        if (r100 == true) goto L4;
    L17:
        SsCronetHttpClient r102 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.BIZ_HTTPDNS_API);     // Catch: Throwable -> L14
        if (r102 == null) goto L21;
        r102.enableTTBizHttpDns(r100, r101, r110, r111, r112, r113);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r111) == false) goto L17;
    }

    public static void tryInitTTNet(final Context r100, Application r101, NetworkParams.ApiProcessHook<HttpRequestInfo> r102, NetworkParams.j<HttpRequestInfo> r103, NetworkParams.f r104, boolean r105, boolean... r106) {
        TTNetInitMetrics r107 = TTNetInitMetrics.g();
        r107.f244610d = System.currentTimeMillis();
        TTNetInitMetrics r108 = TTNetInitMetrics.g();
        r108.f244611e = System.nanoTime();
        if (r100 == null) goto L48;
        SDKConfig.registerSdk();
        DebugMode.openIfDebug(r100);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
        NetworkParams.setApiProcessHook(r102);
        HttpRequestInfo.injectCreate();
        JavaInterceptorCallbackRegistry.register(new AnonymousClass1());     // Catch: Throwable -> L7
    L9:
        KevaBuilder.getInstance().setContext(r100);
        if (r106 != null) goto L12;
    L14:
        boolean r109 = false;
    L15:
        boolean r110 = i.d(r100);
        if (r110 == false) goto L18;
        final String r111 = "NetWork-AsyncInit";
        new AnonymousClass2(r111, r100).start();
    L32:
        TNCRequestFlagHandler.getInstance();
        TNCManager.getInstance().initTnc(r100, r110);
        URLDispatcher.inst().setContext(r100);
        AppConfig.getInstance(r100);
        TTNetInitMetrics r112 = TTNetInitMetrics.g();
        r112.getClass();
        r112.f244612f = System.nanoTime();
        TTNetInitMetrics.i(r100, null);
        r112.f244613g = System.nanoTime();
        NetworkParams.setMonitorProcessHook(r103);
        countDownInitCompletedLatch();
        if (r110 == true) goto L36;
        TTNetInitMetrics.g().f244607b = false;
        TTNetInitMetrics r113 = TTNetInitMetrics.g();
        r113.f244614h = System.nanoTime();
        return;
    L36:
        NetworkParams.setCommandListener(r104);
        if (RequestTicketUtil.getRequestTicketProcessor() != null) goto L39;
        RequestTicketUtil.setRequestTicketProcessor(new AnonymousClass4(r100));
    L39:
        b r114 = sLifeCycleMonitor;
        d r115 = d.c();
        ((CopyOnWriteArrayList) r114.f244638a).add(r115);
        if (r101 == null) goto L43;
        r101.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
    L43:
        if (HttpClient.isCronetClientEnable() == true) goto L45;
        notifyColdStartFinish();
    L45:
        TTNetInitMetrics r116 = TTNetInitMetrics.g();
        r116.f244614h = System.nanoTime();
        return;
    L18:
        final boolean r117 = true;
        if (r109 == true) goto L31;
        String r118 = i.b(r100);
        if (r118 != null) goto L23;
    L27:
        boolean r119 = false;
    L28:
        if (r119 == true) goto L31;
        r117 = false;
        goto L31
    L23:
        if (r118.endsWith(TTProcessUtils.MESSAGE_PROCESS_SUFFIX) == false) goto L25;
    L26:
        r119 = true;
        goto L28
    L25:
        if (r118.endsWith(TTProcessUtils.MESSAGE_PROCESS_SERVICE_SUFFIX) == false) goto L27;
    L31:
        final String r120 = "NetWork-AsyncInit-other";
        new AnonymousClass3(r120, r100, r117).start();
        goto L32
    L12:
        if (r106.length <= 0) goto L14;
        r109 = r106[0];
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    L48:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void setZstdFuncAddr(long r110, long r210, long r211, long r212, long r213, long r214, long r310, long r311) throws Exception {
        SsCronetHttpClient r100 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ZSTD_API);
        if (r100 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTNet_ZSTD", " createDCtxAddr:" + r110 + " decompressStreamAddr:" + r210 + " freeDctxAddr:" + r211 + " isErrorAddr:" + r212 + " createDDictAddr:" + r213 + " dctxRefDDictAddr:" + r214 + " freeDDictAddr:" + r310 + " dctxResetAddr:" + r311);
    L8:
        r100.setZstdFuncAddr(r110, r210, r211, r212, r213, r214, r310, r311);
    }
}
