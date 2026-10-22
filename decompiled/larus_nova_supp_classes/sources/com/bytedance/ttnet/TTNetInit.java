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
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.JavaInterceptorCallbackRegistry;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.impl.a;
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
import org.xmlpull.v1.XmlPullParser;
import ux5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
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

    public TTNetInit() {
    }

    public static void doCommand(Context r0, String r1) {
    }

    public static void enableCookieLogReport(boolean r0) {
    }

    public static void preInitCronetKernel() throws Exception {
        int r0 = -1;
    L7:
        th = move-exception;
        if ((th instanceof IllegalArgumentException) == false) goto L11;
        r0 = 3;
    L11:
        String r2 = TtnetUtil.outputThrowableStackTrace(th);
        if (r2.length() <= 1024) goto L14;
        r2 = r2.substring(0, 1024);
    L14:
        feedBackCronetInitFailedLog(r0, r2);
        TNCManager.getInstance().handleCronetInitFailed();
        throw th;
    L4:
        if (getCronetHttpClient(TTNetInitMetrics.CronetInitMode.PRE_INIT) != null) goto L18;
        r0 = SsOkHttp3Client.getFallbackReason();     // Catch: Throwable -> L7
        feedBackCronetInitFailedLog(r0, XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L7
        return;
    }

    public static void setALogFuncAddr(long r0) throws Exception {
    }

    public static void setCookieHandler(Context r0) {
    }

    public static void setDelayTime(int r0) {
    }

    public static void setEnableURLDispatcher(boolean r0) throws Exception {
    }

    public static void setFirstRequestWaitTime(long r0) {
    }

    public static void setHttpDnsForTesting(boolean r0, boolean r1, boolean r2) throws Exception {
    }

    public static void setMainThreadInitCookieEnabled(boolean r0) {
    }

    private static void tryInitCookieManager(Context r0, boolean r1, boolean r2) {
    }

    public static boolean urlDispatchEnabled() {
        return true;
    }

    static {
        TAG = "TTNetInit";
        sTelemetryOptionFlags = 0;
        sDelayTime = 10;
        sLatchInitCompleted = new CountDownLatch(1);
        sApiHttpInterceptEnabled = $assertionsDisabled;
        sListenAppStateIndependently = $assertionsDisabled;
        sStateDelayNewStrategyEnabled = $assertionsDisabled;
        sMaxHttpDiskCacheSize = 67108864;
        sAppSecurityLevel = 0;
        sLifeCycleMonitor = new b();
        TTALog.init();
        env = ENV.RELEASE;
        sNotifiedColdStartFinsish = $assertionsDisabled;
        sClientIPString = XmlPullParser.NO_NAMESPACE;
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
        ITTNetDepend r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("sITTNetDepend is null");
    }

    public static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        TTNetThreadConfigInfoManager r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getThreadConfigCallbackImpl();
    }

    public static List<TTNetThreadConfig> getThreadConfigInfoList() {
        TTNetThreadConfigInfoManager r0 = sTTNetThreadConfigInfoManager;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getThreadConfigInfoList();
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
        SsCronetHttpClient r0 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.COOKIE_INIT_COMPLETE_API);     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setCookieInitCompleted();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void forceInitCronetKernel() throws Exception {
        if (TTNetInitMetrics.g().a != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r0 = TTNetInitMetrics.g();
        r0.a = TTNetInitMetrics.CronetInitMode.FORCE_INIT;
    L5:
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryCreateCronetEngine($assertionsDisabled, $assertionsDisabled, $assertionsDisabled, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), true, sCronetProvider);
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
        h.f = "ttnetCookieStore";
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

    public static void clearClientOpaqueData(Context r1) {
        SsCronetHttpClient.inst(r1).clearClientOpaqueData($assertionsDisabled);
    }

    public static void clearClientOpaqueDataV1(Context r1) {
        SsCronetHttpClient.inst(r1).clearClientOpaqueData(true);
    }

    public static void clearTNCFileBeforeStart(Context r3) {
        if (r3 == null) goto L12;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3.getFilesDir(), "server.json");     // Catch: Throwable -> L13
        if (r0.exists() == false) goto L6;
        r0.delete();     // Catch: Throwable -> L13
    L6:
        PolarisFileWrapper r1 = new PolarisFileWrapper(r3.getFilesDir(), "tt_net_config.config");     // Catch: Throwable -> L13
        if (r1.exists() == false) goto L9;
        r1.delete();     // Catch: Throwable -> L13
    L9:
        clearSharedPreferencesFile(r3, AppConfig.getSsAppConfigFileName());
        clearSharedPreferencesFile(r3, "ttnet_tnc_config");
        sx5.b r2 = sx5.b.n;
        clearSharedPreferencesFile(r3, "ttnet_store_region");
        return;
    L12:
        throw new IllegalArgumentException("context is null");
    }

    public static List<InetAddress> dnsLookup(String r3) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L24;
        TTDnsResult r0 = TTDnsResolve(r3, 0);
        if (r0.ret != 0) goto L22;
        List r1 = r0.iplist;
        if (r1 == null) goto L22;
        if (r1.isEmpty() == true) goto L22;
        ArrayList r2 = new ArrayList();
        Iterator r4 = r0.iplist.iterator();
    L12:
        if (r4.hasNext() == false) goto L17;
        byte[] r5 = InetAddress.getByName((String) r4.next()).getAddress();
        if (r5 == null) goto L12;
        r2.add(InetAddress.getByAddress(r3, r5));
        goto L12
    L17:
        if (r2.isEmpty() == true) goto L20;
        return r2;
    L20:
        throw new UnknownHostException(r3);
    L22:
        throw new UnknownHostException(r3);
    L24:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void enableApiHttpIntercept(boolean r0) {
        sApiHttpInterceptEnabled = r0;
    }

    public static void enableProceedWithoutHook(boolean r0) {
        RealInterceptorChain.setProceedWithoutHookEnabled(r0);
    }

    public static void enableSsCallUseOkioReadForNoneStream(boolean r0) {
        a.setUseOkioRead(r0);
    }

    private static SsCronetHttpClient getCronetHttpClient(TTNetInitMetrics.CronetInitMode r8) throws Exception {
        if (TTNetInitMetrics.g().a != TTNetInitMetrics.CronetInitMode.NONE) goto L6;
        TTNetInitMetrics.g().a = r8;
    L6:
        if (HttpClient.isCronetClientEnable() == false) goto L9;
        SsCronetHttpClient r9 = SsCronetHttpClient.inst(getTTNetDepend().getContext());
        r9.tryCreateCronetEngine($assertionsDisabled, true, $assertionsDisabled, AppConfig.getInstance(getTTNetDepend().getContext()).isCronetHttpDnsOpen(), $assertionsDisabled, sCronetProvider);
        sSlaSamplingSettingObject = null;
        return r9;
    L9:
        return null;
    }

    public static String getGetDomainConfigByRegion(String r1) {
        Map<String, String> r0 = sGetDomainRegionMap;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return null;
    L7:
        if (sCronetProvider != null) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L12;
        return null;
    L12:
        return sGetDomainRegionMap.get(r1.toLowerCase());
    }

    public static void getMappingRequestState(String r1) {
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).getMappingRequestState(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    public static PacketLossMetrics getPacketLossRateMetrics(int r1) throws Exception {
        return SsCronetHttpClient.inst(getTTNetDepend().getContext()).getPacketLossRateMetrics(r1);
    }

    public static void onClientIPChanged(String r0) {
        if (r0 == null) goto L5;
        sClientIPString = r0;
        return;
    }

    public static void preconnectUrl(String r1) throws Exception {
        preconnectUrl(r1, null);
    }

    public static void setAppSecurityLevel(int r0) {
        sAppSecurityLevel = r0;
    }

    public static void setBypassOfflineCheck(boolean r0) {
        SsCronetHttpClient.setBypassOfflineCheck(r0);
    }

    public static void setCronetDepend(ICronetAppProvider r1) {
        if (r1 == null) goto L6;
        sCronetProvider = r1;
        TNCManager.initStoreRegionModule(r1);
        OkHttpAppInfoProvider.inst().setCronetProvider(r1);
        SsCronetHttpClient.setCronetAppInfoProvider(r1);
        SsOkHttp3Client.injectAppInfoProvider(OkHttpAppInfoProvider.inst());
        return;
    L6:
        throw new IllegalArgumentException("cronetDepend is null");
    }

    public static void setEnv(ENV r0) {
        env = r0;
    }

    public static void setGetDomainRegionMap(Map<String, String> r1) {
        if (r1 == null) goto L6;
        sGetDomainRegionMap = r1;
        return;
    L6:
        throw new IllegalArgumentException("getDomainRegionMap is null");
    }

    public static void setHostResolverRulesForTesting(String r1) throws Exception {
        SsCronetHttpClient r0 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.DEPRECATED_API);
        if (r0 == null) goto L6;
        r0.setHostResolverRules(r1);
        return;
    }

    public static void setListenAppStateIndependently(boolean r0) {
        sListenAppStateIndependently = r0;
    }

    public static void setMaxHttpDiskCacheSize(long r3) {
        if (r3 <= 0) goto L6;
        sMaxHttpDiskCacheSize = r3;
        return;
    }

    public static void setMonitorProcessHookV2(NetworkParams.k<HttpRequestInfo> r0) {
        NetworkParams.setMonitorProcessHookV2(r0);
    }

    public static void setProcessFlag(int r1) {
        i.a.set(r1);
    }

    public static void setProxy(String r1) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L5;
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).setProxy(r1);
        return;
    L5:
        SsOkHttp3Client.inst(getTTNetDepend().getContext());
        SsOkHttp3Client.setProxy(r1);
    }

    public static void setRetryEncryptedRequestEnabled(final RetryEncryptRequestCallback r1) {
        NetworkParams.addRetryRequestByHeaderCallback(ENCRYPT_RETRY_VERIFY_HEADER, new AnonymousClass5(r1));
    }

    public static void setStateDelayNewStrategyEnabled(boolean r0) {
        sStateDelayNewStrategyEnabled = r0;
    }

    public static void setSystemApiSandbox(ITTSystemApiSandbox r0) {
        sSystemApiSandbox = r0;
    }

    public static void setTTNetDepend(ITTNetDepend r7) {
        sITTNetDepend = r7;
        Map r0 = getTTNetDepend().getTTNetServiceDomainMap();
        if (TextUtils.isEmpty((CharSequence) r0.get(DOMAIN_HTTPDNS_KEY)) == false) goto L5;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == true) goto L28;
        AbsOptionalTTNetDepend r2 = sITTNetDepend;
        if ((r2 instanceof AbsOptionalTTNetDepend) == true) goto L15;
    L17:
        AppLaunchTimeStampProvider r3 = sITTNetDepend;
        if ((r3 instanceof AppLaunchTimeStampProvider) == false) goto L20;
        RetrofitMetrics.sAppStartTimeProvider = r3;
    L20:
        HttpRequestInfo.injectCreate();
        String r4 = (String) r0.get(DOMAIN_BOE_KEY);
        c.a = r4;
        if (TextUtils.isEmpty(r4) == true) goto L23;
        c.d = true;
    L23:
        String r5 = (String) r0.get(DOMAIN_BOE_HTTPS_KEY);
        c.b = r5;
        if (TextUtils.isEmpty(r5) == true) goto L26;
        c.d = $assertionsDisabled;
    L26:
        OkHttpAppInfoProvider.inst().setTTNetDepend(r7);
        return;
    L15:
        if (r2.isPrivacyAccessEnabled() == true) goto L17;
        setAppSecurityLevel(sAppSecurityLevel | 1);
        goto L17
    L28:
        sITTNetDepend = null;
        throw new IllegalArgumentException("You must set HttpDns, NetLog and BOE service domain, please refer to TTNet access documents.");
    L5:
        if (TextUtils.isEmpty((CharSequence) r0.get(DOMAIN_BOE_KEY)) == true) goto L7;
    L9:
        r1 = $assertionsDisabled;
        goto L11
    L7:
        if (TextUtils.isEmpty((CharSequence) r0.get(DOMAIN_BOE_HTTPS_KEY)) == false) goto L9;
        goto L9
    }

    public static void setTTNetThreadConfigInfoManager(TTNetThreadConfigInfoManager r0) {
        sTTNetThreadConfigInfoManager = r0;
    }

    public static void setTelemetryOptionFlags(int r1) {
        sTelemetryOptionFlags = r1;
        boolean r0 = true;
        if ((sTelemetryOptionFlags & 1) == 0) goto L6;
        r0 = $assertionsDisabled;
    L6:
        NetworkParams.setTelemetryReportingEnabled(r0);
    }

    public static void trigerGetDomain(Context r1) {
        triggerGetDomain(r1, $assertionsDisabled);
    }

    public static void trySetDefaultUserAgent(String r0) {
        NetworkParams.setDefaultUserAgent(r0);
    }

    public static TTDispatchResult ttUrlDispatch(String r2) throws Exception {
        return ttUrlDispatchInternal(r2, -1, true);
    }

    public static TTDnsResult TTDnsResolve(String r1, int r2) throws Exception {
        return TTDnsResolve(r1, r2, null);
    }

    private static void clearSharedPreferencesFile(Context r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r1.getSharedPreferences(r2, 0).edit().clear().apply();
        return;
    }

    public static void enableSsCallUseZeroCopyReadForNoneStream(boolean r5, int r6) {
        BaseCronetSsCall.setUseZeroCopyRead(r5);
        if (r5 == false) goto L8;
        if (r6 <= 0) goto L9;
        long r1 = ((long) r6) * 1000;
        hx5.b.a(NetworkAsyncTaskType.NETWORK).b(new 7(r1, r1));
        return;
    L9:
        return;
    }

    private static void feedBackCronetInitFailedLog(int r2, String r3) {
        JSONObject r0 = new JSONObject();
        r0.put("fallback", r2);     // Catch: JSONException -> L10
        r0.put("exception", r3);     // Catch: JSONException -> L10
        r0.put("model", Build.MODEL);     // Catch: JSONException -> L10
        String r4 = XmlPullParser.NO_NAMESPACE;
        String[] r5 = Build.SUPPORTED_ABIS;     // Catch: JSONException -> L10
        if (r5 != null) goto L6;
    L8:
        r0.put("abis", r4);     // Catch: JSONException -> L10
        getTTNetDepend().monitorLogSend("cronet_failed", r0);     // Catch: JSONException -> L10
        return;
    L6:
        if (r5.length <= 0) goto L8;
        r4 = Arrays.asList(r5).toString();     // Catch: JSONException -> L10
    }

    public static void monitorLogSend(String r1, JSONObject r2) {
        ITTNetDepend r0 = sITTNetDepend;
        if (r0 == null) goto L6;
        r0.monitorLogSend(r1, r2);
        return;
    }

    public static void onPublicIPsChanged(List<String> r0, List<String> r1) {
        sPublicIPv4List = r0;
        sPublicIPv6List = r1;
    }

    public static void preconnectUrl(String r1, Map<String, String> r2) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L9;
        new URL(r1).toURI();     // Catch: Exception -> L6
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).preconnectUrl(r1, r2);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        throw e;
    L9:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static void removeClientOpaqueData(Context r1, String r2) {
        SsCronetHttpClient.inst(r1).removeClientOpaqueData(r2, $assertionsDisabled);
    }

    public static void removeClientOpaqueDataV1(Context r1, String r2) {
        SsCronetHttpClient.inst(r1).removeClientOpaqueData(r2, true);
    }

    public static void runInBackGround(Context r0, boolean r1) {
        SsCronetHttpClient.inst(r0).runInBackGround(r1);
    }

    public static void setSlaSamplingSetting(Context r2, JSONObject r3) {
    L7:
        e = move-exception;
        e.printStackTrace();
        sSlaSamplingSettingObject = r3;
        return;
    L3:
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "setSlaSamplingSetting");     // Catch: Exception -> L7
    L5:
        SsCronetHttpClient.inst(r2).setSlaSamplingSetting(r3);     // Catch: Exception -> L7
    }

    public static void triggerGetDomain(Context r0, boolean r1) {
        SsCronetHttpClient.inst(r0).triggerGetDomain(r1);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r1, int r2) {
        return ttUrlDispatchV2(r1, r2, true);
    }

    public static TTDnsResult TTDnsResolve(String r1, int r2, Map<String, String> r3) throws Exception {
        if (TTNetInitMetrics.h() == false) goto L7;
        return TTDnsOuterService.getInstance().TTDnsResolve(r1, r2, r3);
    L7:
        throw new IllegalStateException("Cronet engine has not been initialized and completed.");
    }

    public static /* synthetic */ void access$200(Context r0, boolean r1, boolean r2) {
        initCookie(r0, r1, r2);
    }

    private static void initCookie(final Context r5, boolean r6, boolean r7) {
        com.bytedance.frameworks.baselib.network.http.cookie.b.b r0 = new AnonymousClass6(r5);
        boolean r1 = $assertionsDisabled;
        if (r6 == false) goto L24;
        Object r8 = com.bytedance.frameworks.baselib.network.http.cookie.b.a;
        if (ix5.b.k == true) goto L7;
    L9:
        if (r1 == true) goto L11;
        com.bytedance.frameworks.baselib.network.http.cookie.b.e(r5, true, r0);
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d("CookieInitializer", "cookieInitV2 start isMain:true");
    L13:
        TTNetInitMetrics r9 = TTNetInitMetrics.g();
        r9.i = System.nanoTime();
    L20:
        th = move-exception;
        Logger.d("CookieInitializer", "cookieInitV2 failed", th);
        com.bytedance.frameworks.baselib.network.http.cookie.b.a(th.getMessage(), r0);
    L22:
        TTNetInitMetrics r10 = TTNetInitMetrics.g();
        r10.j = System.nanoTime();
        com.bytedance.frameworks.baselib.network.http.cookie.b.c.countDown();
        r0.onSetCookieInitCompleted();
        r0.onInitClientKeyAndSessionInfo(true);
        return;
    L15:
        if (com.bytedance.frameworks.baselib.network.http.cookie.b.d.get() == false) goto L17;
        SSCookieHandler.CookieInitType r11 = SSCookieHandler.CookieInitType.INIT_V2_DISABLE_COOKIE_MGR;     // Catch: Throwable -> L20
    L18:
        com.bytedance.frameworks.baselib.network.http.cookie.b.c(new SSCookieHandler(r5, null, r11, new com.bytedance.frameworks.baselib.network.http.cookie.c(r0)));     // Catch: Throwable -> L20
        goto L22
    L17:
        r11 = SSCookieHandler.CookieInitType.INIT_V2_PREFER_DELAY_COOKIE_MGR;     // Catch: Throwable -> L20
        goto L18
    L7:
        if (ix5.b.n == true) goto L9;
        r1 = true;
        goto L9
    L24:
        if (r7 == false) goto L26;
        com.bytedance.frameworks.baselib.network.http.cookie.b.e(r5, $assertionsDisabled, r0);
        return;
    L26:
        com.bytedance.frameworks.baselib.network.http.cookie.b.c.countDown();
        r0.onSetCookieInitCompleted();
    }

    public static boolean tryStartTTNetDetect(String[] r2, int r3, int r4) {
        if (r2 != null) goto L5;
    L16:
        return $assertionsDisabled;
    L5:
        if (r2.length <= 0) goto L16;
        if (r3 <= 0) goto L16;
        if (r3 > 180) goto L16;
        if (r4 < 0) goto L16;
        SsCronetHttpClient.inst(getTTNetDepend().getContext()).tryStartNetDetect(r2, r3, r4);     // Catch: Throwable -> L14
        return true;
    L14:
        th = move-exception;
        th.printStackTrace();
        goto L16
    }

    private static TTDispatchResult ttUrlDispatchInternal(String r7, int r8, boolean r9) throws Exception {
        if (AppConfig.getInstance(getTTNetDepend().getContext()).isChromiumOpen() == true) goto L11;
        DispatchResult r10 = URLDispatcher.inst().getDispatchResultForUrl(new URLRequest(r7, null, null));
        if (r10 == null) goto L9;
        return new TTDispatchResult(r7, r10.mDispatchedURL, String.valueOf(URLDispatcher.inst().getEpoch()), URLDispatcher.inst().getTncEtag(), TTDispatchResult.DispatchState.SUCCESS, XmlPullParser.NO_NAMESPACE);
    L9:
        throw new IllegalArgumentException(OKHTTP_DISPATCH_FAILED);
    L11:
        if (TTNetInitMetrics.h() == false) goto L17;
        new URL(r7).toURI();     // Catch: Exception -> L14
        return SsCronetHttpClient.ttUrlDispatch(r7, r8, r9);
    L14:
        e = move-exception;
        throw e;
    L17:
        throw new IllegalStateException(TTNET_CRONET_NOT_INITIALIZED);
    }

    public static TTDispatchResult ttUrlDispatchV2(String r2, int r3, boolean r4) {
        new URL(r2).toURI();     // Catch: Exception -> L50
        return ttUrlDispatchInternal(r2, r3, r4);
    L5:
        e = move-exception;
        String r5 = e.getMessage();
        if ((e instanceof IllegalArgumentException) == true) goto L9;
    L12:
        boolean r0 = e instanceof IllegalStateException;
        if (r0 == false) goto L19;
        if (TTNET_CRONET_NOT_INITIALIZED.equals(r5) == false) goto L19;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L19:
        if ((e instanceof UnsupportedOperationException) == true) goto L21;
    L24:
        if (r0 == false) goto L30;
        if ("Engine is shut down.".equals(r5) == false) goto L30;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L30:
        if ((e instanceof UnknownFormatConversionException) == false) goto L36;
        if (RETURN_WRONG_FORMAT.equals(r5) == false) goto L36;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.WRONG_FORMAT, e);
    L36:
        if ((e instanceof URISyntaxException) == true) goto L49;
        if ((e instanceof MalformedURLException) == true) goto L49;
        if ((e instanceof SocketTimeoutException) == false) goto L47;
        if ("ttnet".equals(r5) == false) goto L47;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.TIMEOUT, e);
    L47:
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.NOT_REACHED, e);
    L49:
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.INVALID_FINAL_URL, e);
    L21:
        if ("CronetEngine has not been initialized.".equals(r5) == false) goto L24;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.CRONET_NOT_INIT, e);
    L9:
        if (OKHTTP_DISPATCH_FAILED.equals(r5) == false) goto L12;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.OKHTTP_DISPATCH_FAILED, e);
    L50:
        e = move-exception;
        return new TTDispatchResult(r2, TTDispatchResult.DispatchState.INVALID_ORIGIN_URL, e);
    }

    public static void addClientOpaqueData(Context r9, String[] r10, byte[] r11, byte[] r12) {
        SsCronetHttpClient.inst(r9).addClientOpaqueData(r10, r11, r12, 0, 0, $assertionsDisabled);
    }

    public static void addClientOpaqueDataV1(Context r9, String[] r10, byte[] r11, byte[] r12) {
        SsCronetHttpClient.inst(r9).addClientOpaqueData(r10, r11, r12, 0, 0, true);
    }

    public static void addClientOpaqueData(Context r9, String[] r10, byte[] r11, byte[] r12, long r13, long r15) {
        SsCronetHttpClient.inst(r9).addClientOpaqueData(r10, r11, r12, r13, r15, $assertionsDisabled);
    }

    public static void addClientOpaqueDataV1(Context r9, String[] r10, byte[] r11, byte[] r12, long r13, long r15) {
        SsCronetHttpClient.inst(r9).addClientOpaqueData(r10, r11, r12, r13, r15, true);
    }

    public static void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) {
        if (r8 == true) goto L4;
    L17:
        SsCronetHttpClient r1 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.BIZ_HTTPDNS_API);     // Catch: Throwable -> L14
        if (r1 == null) goto L21;
        r1.enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);     // Catch: Throwable -> L14
        return;
    L21:
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (TextUtils.isEmpty(r9) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r11) == false) goto L17;
    }

    public static void tryInitTTNet(Context r2, Application r3, NetworkParams.ApiProcessHook<HttpRequestInfo> r4, NetworkParams.j<HttpRequestInfo> r5, NetworkParams.f r6, boolean r7, boolean... r8) {
        TTNetInitMetrics r9 = TTNetInitMetrics.g();
        r9.d = System.currentTimeMillis();
        TTNetInitMetrics r10 = TTNetInitMetrics.g();
        r10.e = System.nanoTime();
        if (r2 == null) goto L48;
        SDKConfig.registerSdk();
        DebugMode.openIfDebug(r2);
        RetrofitLogger.setLogLevel(Logger.getLogLevel());
        NetworkParams.setApiProcessHook(r4);
        HttpRequestInfo.injectCreate();
        JavaInterceptorCallbackRegistry.register(new AnonymousClass1());     // Catch: Throwable -> L7
    L9:
        KevaBuilder.getInstance().setContext(r2);
        if (r8 != null) goto L12;
    L14:
        boolean r11 = $assertionsDisabled;
    L15:
        boolean r12 = i.d(r2);
        if (r12 == false) goto L18;
        new 2("NetWork-AsyncInit", r2).start();
    L32:
        TNCRequestFlagHandler.getInstance();
        TNCManager.getInstance().initTnc(r2, r12);
        URLDispatcher.inst().setContext(r2);
        AppConfig.getInstance(r2);
        TTNetInitMetrics r13 = TTNetInitMetrics.g();
        r13.getClass();
        r13.f = System.nanoTime();
        TTNetInitMetrics.i(r2, null);
        r13.g = System.nanoTime();
        NetworkParams.setMonitorProcessHook(r5);
        countDownInitCompletedLatch();
        if (r12 == true) goto L36;
        TTNetInitMetrics.g().b = $assertionsDisabled;
        TTNetInitMetrics r14 = TTNetInitMetrics.g();
        r14.h = System.nanoTime();
        return;
    L36:
        NetworkParams.setCommandListener(r6);
        if (RequestTicketUtil.getRequestTicketProcessor() != null) goto L39;
        RequestTicketUtil.setRequestTicketProcessor(new 4(r2));
    L39:
        b r15 = sLifeCycleMonitor;
        d r16 = d.c();
        ((CopyOnWriteArrayList) r15.a).add(r16);
        if (r3 == null) goto L43;
        r3.registerActivityLifecycleCallbacks(sLifeCycleMonitor);
    L43:
        if (HttpClient.isCronetClientEnable() == true) goto L45;
        notifyColdStartFinish();
    L45:
        TTNetInitMetrics r17 = TTNetInitMetrics.g();
        r17.h = System.nanoTime();
        return;
    L18:
        boolean r0 = true;
        if (r11 == true) goto L31;
        String r18 = i.b(r2);
        if (r18 != null) goto L23;
    L27:
        boolean r19 = $assertionsDisabled;
    L28:
        if (r19 == true) goto L31;
        r0 = $assertionsDisabled;
        goto L31
    L23:
        if (r18.endsWith(":push") == false) goto L25;
    L26:
        r19 = true;
        goto L28
    L25:
        if (r18.endsWith(":pushservice") == false) goto L27;
    L31:
        new 3("NetWork-AsyncInit-other", r2, r0).start();
        goto L32
    L12:
        if (r8.length <= 0) goto L14;
        r11 = r8[0];
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    L48:
        throw new IllegalArgumentException("tryInitTTNet context is null");
    }

    public static void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) throws Exception {
        SsCronetHttpClient r1 = getCronetHttpClient(TTNetInitMetrics.CronetInitMode.ZSTD_API);
        if (r1 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("TTNet_ZSTD", " createDCtxAddr:" + r18 + " decompressStreamAddr:" + r20 + " freeDctxAddr:" + r22 + " isErrorAddr:" + r24 + " createDDictAddr:" + r26 + " dctxRefDDictAddr:" + r28 + " freeDDictAddr:" + r30 + " dctxResetAddr:" + r32);
    L8:
        r1.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }
}
