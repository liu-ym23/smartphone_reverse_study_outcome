package com.bytedance.frameworks.baselib.network.http;

import android.app.Activity;
import android.os.Looper;
import android.webkit.CookieManager;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.retrofit2.AppActivityResumeSuspendRecorder;
import com.bytedance.retrofit2.RetrofitLayerMetrics;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.io.encoding.Base64;
import ms.bd.c.a4;
import ms.bd.c.f4;
import ms.bd.c.p2;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkParams {
    public static final String BDTURING_VERIFY_HEADER = "bdturing-verify";
    public static final String BYPASS_BDTURING_HEADER_KEY = "x-tt-bypass-bdturing";
    private static final String BYPASS_RETRY_BY_HEADER_KEY_PREFIX = "x-tt-bypass-retry-by-";
    public static final String BYPASS_RETRY_FOR_ACCOUNT_KEY = "x-tt-bypass-retry-for-account";
    private static final int CONNECT_TIMEOUT = 15000;
    private static final int IO_TIMEOUT = 15000;
    public static final int MAX_ROTATION_HOST_PATH_RETRY_COUNT = 3;
    public static final String PNAME_REMOTE_ADDRESS = "x-net-info.remoteaddr";
    public static final String RETRY_FOR_ACCOUNT_REQUEST_KEY = "x-tt-retry-for-account";
    public static final String RETRY_REQUEST_BY_BDTURING_HEADER = "x-tt-bdturing-retry";
    private static final String RETRY_REQUEST_BY_HEADER_KEY_PREFIX = "x-tt-retry-by-";
    private static final String RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD = "verify";
    private static final String RETRY_REQUEST_IGNORE_STATUS_CODE_CHECK = "ignore-status-code";
    private static a sAddOecSecurityFactorProcessCallback = null;
    private static volatile s sAddResponseHeadersCallback = null;
    private static b sAddSecurityFactorProcessCallback = null;
    private static c sAllErrorReportHook = null;
    private static d sApiInterceptor = null;
    private static ApiProcessHook sApiProcessHook = null;
    private static e sAppCookieStore = null;
    private static CdnConnectionQualitySamplerHook sCdnConnectionQualitySamplerHook = null;
    private static f sCommandListener = null;
    private static g sConnectionQualitySamplerHook = null;
    private static h sCookieShareInterceptor = null;
    private static i sCookieUpdateListener = null;
    private static int sDestroyDeltaMillis = 0;
    private static AtomicBoolean sDisableRotationHostRetryByTnc = null;
    private static volatile boolean sDisallowDupReport = false;
    private static boolean sEnableMainThreadCheck = false;
    private static boolean sEnablePPForceUseSharedStream = false;
    private static j sMonitorProcessHook = null;
    private static k sMonitorProcessHookV2 = null;
    private static l sOldMonitorProcessHook = null;
    private static volatile boolean sOptReflection = false;
    private static boolean sPrivateProtocolEnabled = false;
    private static volatile m sRetryForAccountRequestCallback = null;
    private static final Map<String, n> sRetryRequestByHeaderCallbackMap = null;
    private static volatile p sRetryRequestByRotationHostRetryListCallback = null;
    private static volatile q sRetryRequestCallback = null;
    private static r sStreamProcessor = null;
    private static volatile boolean sTelemetryReportingEnabled = true;
    private static volatile int sUseDnsMapping;
    private static volatile boolean sUseMonitorV2;
    private static String sUserAgent;

    public interface ApiProcessHook<T extends BaseHttpRequestInfo> {

        /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.NetworkParams$ApiProcessHook$-CC, reason: invalid class name */
        /* JADX INFO: loaded from: classes19.dex */
        public final /* synthetic */ class CC<T extends BaseHttpRequestInfo> {
            public static Map $default$addCommonParamsByLevel(ApiProcessHook r100, String r101, boolean r102, int r103) {
                return null;
            }
        }

        String addCommonParams(String r100, boolean r101);

        Map<String, String> addCommonParamsByLevel(String r100, boolean r101, int r102);

        String addRequestVertifyParams(String r100, boolean r101, Object... r102);

        Map<String, String> getCommonParamsByLevel(int r100);

        void handleApiError(String r100, Throwable r101, long r102, T r103);

        void handleApiOk(String r100, long r101, T r102);

        void onTryInit();

        void putCommonParams(Map<String, String> r100, boolean r101);
    }

    public interface CdnConnectionQualitySamplerHook {
        boolean cdnShouldSampling(String r100);
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface a {
    }

    public interface b {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface c {
    }

    public interface d<T extends BaseRequestContext> {
        String filterUrl(String r100, T r101);

        void monitorApiHttp(String r100, String r101, boolean r102) throws IOException;
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface e {
    }

    public interface f {
        void a(List<String> r100);

        void b();
    }

    public interface g {
        boolean shouldSampling(String r100);
    }

    public interface h {
        List<String> getShareCookie(CookieManager r100, com.bytedance.frameworks.baselib.network.http.impl.b r101, URI r102);

        List<String> getShareCookieHostList(String r100);
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface i {
    }

    public interface j<T extends BaseHttpRequestInfo> {
        void monitorApiError(long r100, long r101, String r102, String r103, T r104, Throwable r105);

        void monitorApiOk(long r100, long r101, String r102, String r103, T r104);
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface k<T extends BaseHttpRequestInfo> {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface l {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface m {
    }

    public interface n {
        lx5.e onCallToRetryRequestByHeader(Map<String, List<String>> r100);
    }

    public interface o extends n {
        lx5.e onCallToRetryRequestByHeader(String r100, List<Header> r101, Map<String, List<String>> r102);
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface p {
    }

    public interface q {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface r {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface s {
    }

    public NetworkParams() {
    }

    public static e getAppCookieStore() {
        return null;
    }

    public static int getConnectTimeout() {
        return 15000;
    }

    public static i getCookieUpdateListener() {
        return null;
    }

    public static int getIoTimeout() {
        return 15000;
    }

    public static r getStreamProcessor() {
        return null;
    }

    public static boolean isAllErrorReport() {
        return false;
    }

    public static void setAddOecSecurityFactorProcessCallback(a r100) {
    }

    public static void setAllErrorReportHook(c r100) {
    }

    public static void setAppCookieStore(e r100) {
    }

    public static void setCookieMgrInited(boolean r100) {
    }

    public static void setCookieUpdateListener(i r100) {
    }

    public static void setDynamicTimeOutEnable(boolean r100) {
    }

    public static void setNewCookieBlockPositionEnabled(boolean r100) {
    }

    public static void setOldMonitorProcessHook(l r100) {
    }

    public static void setStreamProcessor(r r100) {
    }

    public static Map<String, String> tryAddOecSecurityFactor(String r100, Map<String, List<String>> r101) {
        return null;
    }

    public static CookieManager tryCookieManagerInit() {
        return null;
    }

    static {
        sRetryRequestByHeaderCallbackMap = new ConcurrentHashMap();
        sDisableRotationHostRetryByTnc = new AtomicBoolean(false);
        sDestroyDeltaMillis = 100;
        sPrivateProtocolEnabled = true;
        sEnableMainThreadCheck = false;
        sUseDnsMapping = -1;
    }

    public static boolean getUseDnsMapping() {
        if (sUseDnsMapping == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static CookieManager tryNecessaryInit() {
        return tryNecessaryInit("");
    }

    public static d getApiRequestInterceptor() {
        return sApiInterceptor;
    }

    public static CdnConnectionQualitySamplerHook getCdnConnectionQualitySamplerHook() {
        return sCdnConnectionQualitySamplerHook;
    }

    public static f getCommandListener() {
        return sCommandListener;
    }

    public static g getConnectionQualitySamplerHook() {
        return sConnectionQualitySamplerHook;
    }

    public static h getCookieShareInterceptor() {
        return sCookieShareInterceptor;
    }

    public static int getDestroyDeltaMillis() {
        return sDestroyDeltaMillis;
    }

    public static boolean getEnableMainThreadCheck() {
        return sEnableMainThreadCheck;
    }

    public static boolean getOptReflection() {
        return sOptReflection;
    }

    public static String getUserAgent() {
        return sUserAgent;
    }

    public static boolean isEnablePPForceUseSharedStream() {
        return sEnablePPForceUseSharedStream;
    }

    public static boolean isPrivateProtocolEnabled() {
        return sPrivateProtocolEnabled;
    }

    public static String filterUrl(String r100) {
        return filterUrl(r100, null, null);
    }

    private static synchronized Map.Entry<String, n> getRetryRequestByHeaderCallbackEntry(Set<String> r100) {
        monitor-enter(NetworkParams.class);
        Iterator<Map.Entry<String, n>> r101 = sRetryRequestByHeaderCallbackMap.entrySet().iterator();     // Catch: Throwable -> L19
    L6:
        if (r101.hasNext() == false) goto L16;
        Map.Entry<String, n> r102 = r101.next();     // Catch: Throwable -> L19
        Iterator<String> r103 = r100.iterator();     // Catch: Throwable -> L19
    L9:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();     // Catch: Throwable -> L19
        if (StringUtils.isEmpty(r104) == true) goto L9;
        if (r104.equalsIgnoreCase(r102.getKey()) == false) goto L9;
        monitor-exit(NetworkParams.class);
        return r102;
    L16:
        monitor-exit(NetworkParams.class);
        return null;
    L19:
        th = move-exception;
        throw th;
    }

    private static boolean ignoreStatusCodeCheck(Map<String, List<String>> r100) {
        if (r100 != null) goto L5;
    L16:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L16;
        Iterator<String> r101 = r100.keySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L16;
        String r102 = r101.next();
        if (StringUtils.isEmpty(r102) == true) goto L9;
        if (r102.toLowerCase().contains(RETRY_REQUEST_IGNORE_STATUS_CODE_CHECK) == false) goto L9;
        return true;
    }

    public static boolean interceptCookie(Object r100) {
        Object r101 = com.bytedance.frameworks.baselib.network.http.cookie.b.f244692a;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if ((r100 instanceof BaseRequestContext) == false) goto L9;
        if (((BaseRequestContext) r100).bypassCookie == false) goto L9;
        return true;
    }

    private static lx5.e onCallToResponseCallback(Map<String, List<String>> r110) {
        if (sRetryRequestCallback == null) goto L32;
        ((ec4.f) sRetryRequestCallback).getClass();
        boolean[] r100 = {false};
        HashMap r101 = new HashMap();
        CountDownLatch r102 = new CountDownLatch(1);
        if (r110.containsKey(BDTURING_VERIFY_HEADER) == false) goto L28;
        List<String> r103 = r110.get(BDTURING_VERIFY_HEADER);
        if (r103 != null) goto L9;
    L27:
        lx5.e r104 = new lx5.e(r100[0], r101);
    L29:
        r110.remove(BDTURING_VERIFY_HEADER);
        return r104;
    L9:
        if (r103.size() < 1) goto L27;
        String r105 = (String) ListProtector.get(r103, 0);
        if (r110.containsKey("bdturing-extra") == false) goto L18;
        List<String> r106 = r110.get("bdturing-extra");
        if (r106 == null) goto L18;
        if (r106.size() < 1) goto L18;
        r101.put("bdturing-extra", (String) ListProtector.get(r106, 0));
    L18:
        jc4.m r107 = new jc4.m(r105);
        qb4.b r108 = qb4.b.c.f532315a;
        BdTuringConfig r109 = r108.f532302a;
        if (r109 == null) goto L21;
        Activity r111 = r109.getTopActivity();
    L22:
        r107.f498097h = 0;
        r108.i(r111, r107, new ec4.e(r102, r100, r101, r107));
        r102.await();     // Catch: InterruptedException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L21:
        r111 = null;
    L28:
        r104 = new lx5.e(r100[0], r101);
        goto L29
    L32:
        return new lx5.e();
    }

    public static synchronized boolean removeRetryRequestByHeaderCallback(String r100) {
        monitor-enter(NetworkParams.class);
    L20:
        th = move-exception;
        throw th;
    L6:
        if (StringUtils.isEmpty(r100) == false) goto L9;
        monitor-exit(NetworkParams.class);
        return false;
    L9:
        Iterator<String> r101 = sRetryRequestByHeaderCallbackMap.keySet().iterator();     // Catch: Throwable -> L20
    L11:
        if (r101.hasNext() == false) goto L18;
        String r102 = r101.next();     // Catch: Throwable -> L20
        if (r102.equalsIgnoreCase(r100) == false) goto L11;
        sRetryRequestByHeaderCallbackMap.remove(r102);     // Catch: Throwable -> L20
        monitor-exit(NetworkParams.class);
        return true;
    L18:
        monitor-exit(NetworkParams.class);
        return false;
    }

    public static synchronized void setAddResponseHeadersCallback(s r100) {
        monitor-enter(NetworkParams.class);
        monitor-exit(NetworkParams.class);
    }

    public static void setAddSecurityFactorProcessCallback(b r100) {
        sAddSecurityFactorProcessCallback = r100;
    }

    public static void setApiProcessHook(ApiProcessHook r100) {
        sApiProcessHook = r100;
    }

    public static void setApiRequestInterceptor(d r100) {
        sApiInterceptor = r100;
    }

    public static void setCdnConnectionQualitySamplerHook(CdnConnectionQualitySamplerHook r100) {
        sCdnConnectionQualitySamplerHook = r100;
    }

    public static void setCommandListener(f r100) {
        sCommandListener = r100;
    }

    public static void setConnectionQualitySamplerHook(g r100) {
        sConnectionQualitySamplerHook = r100;
    }

    public static void setCookieShareInterceptor(h r100) {
        sCookieShareInterceptor = r100;
    }

    public static void setDefaultUserAgent(String r100) {
        if (r100 != null) goto L19;
    L16:
        sUserAgent = r100;
        return;
    L19:
        if (r100.length() <= 0) goto L16;
        char[] r101 = r100.toCharArray();     // Catch: Exception -> L18
        int r102 = r101.length;     // Catch: Exception -> L18
        int r103 = 0;
        boolean r104 = false;
    L6:
        if (r103 >= r102) goto L13;
        char r105 = r101[r103];     // Catch: Exception -> L18
        if (r105 >= ' ') goto L10;
    L11:
        r101[r103] = '?';     // Catch: Exception -> L18
        r104 = true;
    L12:
        r103 = r103 + 1;     // Catch: Exception -> L18
        goto L6
    L10:
        if (r105 <= '~') goto L12;
    L13:
        if (r104 == false) goto L16;
        r100 = new String(r101);     // Catch: Exception -> L18
        goto L16
    }

    public static void setDestroyDeltaMillis(int r100) {
        sDestroyDeltaMillis = r100;
    }

    public static void setDisableRotationHostRetryByTnc(boolean r100) {
        sDisableRotationHostRetryByTnc.set(r100);
    }

    public static void setDisallowDupReport(boolean r100) {
        sDisallowDupReport = r100;
    }

    public static void setEnableMainThreadCheck(boolean r100) {
        sEnableMainThreadCheck = r100;
    }

    public static void setEnablePPForceUseSharedStream(boolean r100) {
        sEnablePPForceUseSharedStream = r100;
    }

    public static void setMonitorProcessHook(j r100) {
        sMonitorProcessHook = r100;
        RetrofitMetrics.setRequestLogReporterBridge(lx5.f.f511218a);
    }

    public static void setMonitorProcessHookV2(k r100) {
        RetrofitMetrics.setRequestLogReporterBridge(lx5.f.f511218a);
    }

    public static void setOptReflection(boolean r100) {
        sOptReflection = r100;
    }

    public static void setPrivateProtocolEnabled(boolean r100) {
        sPrivateProtocolEnabled = r100;
    }

    public static synchronized boolean setRetryForAccountRequestCallback(m r100) {
        monitor-enter(NetworkParams.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sRetryForAccountRequestCallback == null) goto L9;
        monitor-exit(NetworkParams.class);
        return false;
    L9:
        sRetryForAccountRequestCallback = r100;     // Catch: Throwable -> L13
        monitor-exit(NetworkParams.class);
        return true;
    }

    public static synchronized boolean setRetryRequestByRotationHostRetryListCallback(p r100) {
        monitor-enter(NetworkParams.class);
        monitor-exit(NetworkParams.class);
        return true;
    }

    public static synchronized void setRetryRequestCallback(q r100) {
        monitor-enter(NetworkParams.class);
        sRetryRequestCallback = r100;     // Catch: Throwable -> L7
        monitor-exit(NetworkParams.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setTelemetryReportingEnabled(boolean r100) {
        sTelemetryReportingEnabled = r100;
    }

    public static void setUseDnsMapping(int r100) {
        sUseDnsMapping = r100;
    }

    public static void setUseMonitorV2ForDeprecatedApi(boolean r100) {
        sUseMonitorV2 = r100;
    }

    public static void tryApiProcessHookInit(RetrofitMetrics r100) {
        ApiProcessHook r101 = sApiProcessHook;
        if (r101 == null) goto L13;
        if (r100 == null) goto L14;
        r100.onTryInitStart();
    L14:
        r101.onTryInit();     // Catch: Throwable -> L9
        if (r100 == null) goto L16;
        r100.onTryInitEnd();
        return;
    L16:
        return;
    L9:
        th = move-exception;
        if (r100 == null) goto L12;
        r100.onTryInitEnd();
    L12:
        throw th;
    }

    public static CookieManager tryNecessaryInit(String r100) {
        tryApiProcessHookInit(null);
        return com.bytedance.frameworks.baselib.network.http.cookie.b.b();
    }

    public static String addCommonParams(String r100, boolean r101) {
        return addCommonParams(r100, r101, null);
    }

    public static synchronized boolean addRetryRequestByHeaderCallback(String r100, n r101) {
        monitor-enter(NetworkParams.class);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (StringUtils.isEmpty(r100) == false) goto L7;
    L21:
        monitor-exit(NetworkParams.class);
        return false;
    L7:
        if (r100.toLowerCase().contains(RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD) == false) goto L21;
        if (r101 == null) goto L21;
        Iterator<String> r102 = sRetryRequestByHeaderCallbackMap.keySet().iterator();     // Catch: Throwable -> L23
    L12:
        if (r102.hasNext() == false) goto L17;
        if (r102.next().equalsIgnoreCase(r100) == false) goto L12;
        monitor-exit(NetworkParams.class);
        return false;
    L17:
        sRetryRequestByHeaderCallbackMap.put(r100, r101);     // Catch: Throwable -> L23
        monitor-exit(NetworkParams.class);
        return true;
    }

    private static boolean checkIfReportLog(String r100, BaseHttpRequestInfo r101) {
        if (sTelemetryReportingEnabled == false) goto L14;
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.bypassApiReport == false) goto L8;
        return false;
    L8:
        if (StringUtils.isEmpty(r101.metrics.networklib.networkKernelRawRequestLog) == false) goto L10;
        return false;
    L10:
        if (r101.metrics.retrofit.getRequestDurationMs() >= 0) goto L13;
        return false;
    L13:
        return !StringUtils.isEmpty(r100);
    L14:
        return false;
    }

    public static String filterUrl(String r100, BaseRequestContext r101) {
        return filterUrl(r100, r101, null);
    }

    public static Map<String, String> getCommonParamsByLevel(int r100, RetrofitMetrics r101) {
        if (sApiProcessHook == null) goto L13;
        if (r101 == null) goto L15;
        r101.addCommonParamStart();
    L15:
        Map<String, String> r102 = sApiProcessHook.getCommonParamsByLevel(r100);     // Catch: Throwable -> L9
        if (r101 == null) goto L17;
        r101.addCommonParamEnd();
        return r102;
    L17:
        return r102;
    L9:
        th = move-exception;
        if (r101 == null) goto L12;
        r101.addCommonParamEnd();
    L12:
        throw th;
    L13:
        return null;
    }

    public static void handleApiOk(String r100, BaseHttpRequestInfo r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.bypassApiReport == true) goto L9;
        RetrofitLayerMetrics.EventTimestamp r102 = r101.metrics.retrofit.eventTs;
        long r103 = r102.requestEndTime;
        long r104 = r102.ssHttpCallApiStartTime;
        StringUtils.isEmpty(r100);
        return;
    }

    public static void monitorApiOk(String r100, BaseHttpRequestInfo r110) {
        if (checkIfReportLog(r100, r110) == true) goto L5;
        return;
    L5:
        if (sMonitorProcessHook == null) goto L10;
        r110.metrics.logReport();
        sMonitorProcessHook.monitorApiOk(r110.metrics.retrofit.getRequestDurationMs(), r110.metrics.retrofit.eventTs.ssHttpCallApiStartTime, r100, r110.traceCode, r110);
        return;
    }

    public static void monitorApiOkV2(String r100, BaseHttpRequestInfo r101) {
        checkIfReportLog(r100, r101);
    }

    public static void putCommonParams(Map<String, String> r100, boolean r101) {
        ApiProcessHook r102 = sApiProcessHook;
        if (r102 == null) goto L6;
        r102.putCommonParams(r100, r101);
        return;
    }

    public static Map<String, String> tryAddSecurityFactor(String r110, Map<String, List<String>> r111) {
        b r100 = sAddSecurityFactorProcessCallback;
        String[] r101 = null;
        if (r100 == null) goto L54;
        f4 r102 = (f4) r100;
        HashMap r103 = new HashMap();
        if (r110 == null) goto L53;
        if (r111 == null) goto L53;
        String r104 = r110.toLowerCase();
        if (r104.contains((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "576259", new byte[]{44, 33, 81, 86})) == false) goto L11;
    L17:
        a4 r105 = a4.a();
        monitor-enter(r105);
        int r106 = 0;
        if (r105.f515103b != null) goto L25;
        int r107 = r105.f515102a;     // Catch: Throwable -> L50
        r105.f515102a = r107 + 1;     // Catch: Throwable -> L50
        if (r107 < 30) goto L25;
        r105.f515102a = 0;     // Catch: Throwable -> L50
        r105.f515103b = new Throwable();     // Catch: Throwable -> L50
    L25:
        monitor-exit(r105);
        ArrayList r108 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r109 = r111.entrySet().iterator();
    L28:
        if (r109.hasNext() == false) goto L39;
        Map.Entry<String, List<String>> r112 = r109.next();
        String r113 = r112.getKey();
        if (r112.getValue() != null) goto L32;
    L34:
        String r114 = null;
    L35:
        if (r113 == null) goto L28;
        if (r114 == null) goto L28;
        r108.add(r113);
        r108.add(r114);
        goto L28
    L32:
        if (r112.getValue().size() <= 0) goto L34;
        r114 = (String) ListProtector.get(r112.getValue(), 0);
        goto L35
    L39:
        if (r104.startsWith((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "27a6e1", new byte[]{43, 33, 6, 82})) == false) goto L42;
        Object r115 = p2.a(50331649, 0, r102.f515140a.f515153a, r110, (String[]) r108.toArray(new String[0]));
    L44:
        r101 = (String[]) r115;
    L45:
        if (r101 == null) goto L53;
        r103 = new HashMap();
    L48:
        if (r106 >= r101.length) goto L53;
        r103.put(r101[r106], r101[r106 + 1]);
        r106 = r106 + 2;
        goto L48
    L42:
        if (r104.startsWith((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "a145af", new byte[]{103, 32})) == false) goto L45;
        r108.add((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "ae5312", new byte[]{69, 85, 106}));
        r108.add(r110);
        r115 = p2.a(100663297, 0, r102.f515140a.f515153a, null, (String[]) r108.toArray(new String[0]));
    L50:
        th = move-exception;
        throw th;
    L11:
        if (r104.contains((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "09dd01", new byte[]{41, 47, 3, 0, 28})) == true) goto L17;
        if (r104.contains((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "8eea0a", new byte[]{62, 116})) == true) goto L17;
        throw new RuntimeException((String) p2.a(MediaPlayer.MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP, 0, 0, "165999", new byte[]{41, 32, 6, 64, 19, Base64.padSymbol, 38, 87, 102, 108, 96, 60, 82, 89, 22, 97, 58, 3, 112, 121, 51, 123, 81, 94, 21}));
    L53:
        return r103;
    L54:
        return null;
    }

    public static String filterUrl(String r100, RetrofitMetrics r101) {
        return filterUrl(r100, null, r101);
    }

    public static String addCommonParams(String r100, boolean r101, RetrofitMetrics r102) {
        if (sApiProcessHook == null) goto L13;
        if (r102 == null) goto L14;
        r102.addCommonParamStart();
    L14:
        r100 = sApiProcessHook.addCommonParams(r100, r101);     // Catch: Throwable -> L9
        if (r102 == null) goto L13;
        r102.addCommonParamEnd();
    L9:
        th = move-exception;
        if (r102 == null) goto L12;
        r102.addCommonParamEnd();
    L12:
        throw th;
    L13:
        return r100;
    }

    public static String filterUrl(String r100, BaseRequestContext r101, RetrofitMetrics r102) {
        if (StringUtils.isEmpty(r100) == false) goto L6;
        return r100;
    L6:
        if (sApiInterceptor == null) goto L16;
        if (r102 == null) goto L17;
        r102.filterUrlStart();
    L17:
        r100 = sApiInterceptor.filterUrl(r100, r101);     // Catch: Throwable -> L12
        if (r102 == null) goto L16;
        r102.filterUrlEnd();
    L12:
        th = move-exception;
        if (r102 == null) goto L15;
        r102.filterUrlEnd();
    L15:
        throw th;
    L16:
        return r100;
    }

    public static void handleApiError(String r100, Throwable r101, BaseHttpRequestInfo r102) {
        StringUtils.isEmpty(r100);
    }

    public static void monitorApiError(String r110, BaseHttpRequestInfo r111, Throwable r112) {
        if (checkIfReportLog(r110, r111) == true) goto L5;
        return;
    L5:
        if (sMonitorProcessHook == null) goto L11;
        if (r112 == null) goto L12;
        r111.metrics.logReport();
        sMonitorProcessHook.monitorApiError(r111.metrics.retrofit.getRequestDurationMs(), r111.metrics.retrofit.eventTs.ssHttpCallApiStartTime, r110, r111.traceCode, r111, r112);
        return;
    L12:
        return;
    }

    public static void monitorApiErrorV2(String r100, BaseHttpRequestInfo r101, Throwable r102) {
        checkIfReportLog(r100, r101);
    }

    private static lx5.e shouldRetryRequestFromTuringHeader(BaseHttpRequestInfo r100, List<Header> r101, Map<String, List<String>> r102) {
        lx5.e r103 = new lx5.e();
        if (r102 != null) goto L5;
    L30:
        return r103;
    L5:
        if (r102.containsKey(BDTURING_VERIFY_HEADER) == false) goto L30;
        if (r101 == null) goto L19;
        Iterator<Header> r104 = r101.iterator();
    L11:
        if (r104.hasNext() == false) goto L19;
        Header r105 = r104.next();
        if (r105 == null) goto L11;
        if (BYPASS_BDTURING_HEADER_KEY.equalsIgnoreCase(r105.getName()) == false) goto L11;
        if ("1".equals(r105.getValue()) == false) goto L11;
        return r103;
    L19:
        TreeMap r106 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r106.putAll(r102);
        r100.metrics.bdTuringStart();
        lx5.e r107 = onCallToResponseCallback(r106);
        r100.metrics.bdTuringEnd();
        if (r106.containsKey(BDTURING_VERIFY_HEADER) == true) goto L22;
        r100.executeTuringCallback = true;
        r100.retryByHeaderFilterKey = BDTURING_VERIFY_HEADER;
    L22:
        if (r107 != null) goto L24;
    L29:
        return r107;
    L24:
        if (r107.f511215a == false) goto L29;
        r100.bdTuringRetry = true;
        HashMap r108 = new HashMap();
        r108.put(RETRY_REQUEST_BY_BDTURING_HEADER, "1");
        Map<String, String> r109 = r107.f511217c;
        if (r109 == null) goto L28;
        r108.putAll(r109);
    L28:
        r107.f511217c = r108;
        goto L29
    }

    public static Map<String, String> addCommonParamsByLevel(String r100, boolean r101, int r102, RetrofitMetrics r103) {
        if (sApiProcessHook == null) goto L13;
        if (r103 == null) goto L15;
        r103.addCommonParamStart();
    L15:
        Map<String, String> r104 = sApiProcessHook.addCommonParamsByLevel(r100, r101, r102);     // Catch: Throwable -> L9
        if (r103 == null) goto L17;
        r103.addCommonParamEnd();
        return r104;
    L17:
        return r104;
    L9:
        th = move-exception;
        if (r103 == null) goto L12;
        r103.addCommonParamEnd();
    L12:
        throw th;
    L13:
        return null;
    }

    public static void monitorApiHttp(String r100, String r101, boolean r102, RetrofitMetrics r103) throws IOException {
        if (StringUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(r101) == false) goto L8;
        return;
    L8:
        if (sApiInterceptor == null) goto L27;
        if (r103 == null) goto L25;
        if (r102 == true) goto L12;
        r103.monitorApiHttpBeforeFilterStart();
        goto L25
    L12:
        r103.monitorApiHttpAfterFilterStart();
    L25:
        sApiInterceptor.monitorApiHttp(r100, r101, r102);     // Catch: Throwable -> L18
        if (r103 == null) goto L28;
        if (r102 == true) goto L17;
        r103.monitorApiHttpBeforeFilterEnd();
        return;
    L17:
        r103.monitorApiHttpAfterFilterEnd();
        return;
    L28:
        return;
    L18:
        th = move-exception;
        if (r103 == null) goto L23;
        if (r102 == true) goto L22;
        r103.monitorApiHttpBeforeFilterEnd();
        goto L23
    L22:
        r103.monitorApiHttpAfterFilterEnd();
    L23:
        throw th;
    }

    private static lx5.e shouldRetryRequestByHeader(Request r100, BaseHttpRequestInfo r101, List<Header> r110, Map<String, List<String>> r111) {
        lx5.e r102 = new lx5.e();
        if (r111 != null) goto L5;
    L55:
        return r102;
    L5:
        if (r111.isEmpty() == true) goto L55;
        if (sRetryRequestByHeaderCallbackMap.isEmpty() == true) goto L55;
        Iterator<String> r103 = r111.keySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        String r104 = r103.next();
        if (StringUtils.isEmpty(r104) == true) goto L11;
        if (r104.toLowerCase().contains(RETRY_REQUEST_BY_HEADER_RESPONSE_KEYWORD) == false) goto L11;
        boolean r105 = true;
    L18:
        if (r105 == true) goto L20;
        return r102;
    L20:
        Map.Entry<String, n> r106 = getRetryRequestByHeaderCallbackEntry(r111.keySet());
        if (r106 != null) goto L24;
        return r102;
    L24:
        if (r110 == null) goto L35;
        String r107 = BYPASS_RETRY_BY_HEADER_KEY_PREFIX + r106.getKey();
        Iterator<Header> r108 = r110.iterator();
    L27:
        if (r108.hasNext() == false) goto L35;
        Header r109 = r108.next();
        if (r109 == null) goto L27;
        if (r107.equalsIgnoreCase(r109.getName()) == false) goto L27;
        if ("1".equals(r109.getValue()) == false) goto L27;
        return r102;
    L35:
        n r112 = r106.getValue();
        if (r112 != null) goto L38;
        return r102;
    L38:
        r101.metrics.bdTuringStart();
    L52:
        th = move-exception;
        r101.metrics.bdTuringEnd();
        throw th;
    L40:
        if ((r112 instanceof o) == false) goto L42;
        lx5.e r113 = ((o) r112).onCallToRetryRequestByHeader(r100.getUrl(), r110, r111);     // Catch: Throwable -> L52
    L43:
        r101.metrics.bdTuringEnd();
        r101.retryByHeaderFilterKey = r106.getKey();
        if (r113 != null) goto L46;
    L51:
        return r113;
    L46:
        if (r113.f511215a == false) goto L51;
        r101.bdTuringRetry = true;
        Map<String, String> r114 = r113.f511217c;
        if (r114 != null) goto L50;
        r114 = new HashMap();
    L50:
        r114.put(RETRY_REQUEST_BY_HEADER_KEY_PREFIX + r106.getKey(), "1");
        r113.f511217c = r114;
        goto L51
    L42:
        r113 = r112.onCallToRetryRequestByHeader(r111);     // Catch: Throwable -> L52
        goto L43
    L17:
        r105 = false;
        goto L18
    }

    public static String tryAddRequestVertifyParams(String r100, boolean r101, RetrofitMetrics r102, Object... r103) {
        if (sApiProcessHook == null) goto L13;
        if (r102 == null) goto L15;
        r102.requestVerifyStart();
    L15:
        String r104 = sApiProcessHook.addRequestVertifyParams(r100, r101, r103);     // Catch: Throwable -> L9
        if (r102 == null) goto L17;
        r102.requestVerifyEnd();
        return r104;
    L17:
        return r104;
    L9:
        th = move-exception;
        if (r102 == null) goto L12;
        r102.requestVerifyEnd();
    L12:
        throw th;
    L13:
        return null;
    }

    public static void monitorApiSample(long r100, long r101, String r102, String r103, BaseHttpRequestInfo r104) {
        if (r104 != null) goto L4;
        return;
    L4:
        RetrofitLayerMetrics.EventTimestamp r105 = r104.metrics.retrofit.eventTs;
        r105.ssHttpCallApiStartTime = r101;
        r104.requestStart = r101;
        long r106 = r101 + r100;
        r105.requestEndTime = r106;
        r104.requestEnd = r106;
        if (r105.requestEnd != (-1)) goto L7;
        r105.requestEnd = System.nanoTime();
    L7:
        r104.metrics.setRequestEndAppResumeState(AppActivityResumeSuspendRecorder.GetAppActivityResumeState());
        r104.traceCode = r103;
        r104.useDeprecatedApi = true;
        if (sDisallowDupReport == false) goto L13;
        if (r104.reported.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("Report with deprecated monitorApiSample, url: " + r102);
    L16:
        if (sUseMonitorV2 == false) goto L18;
        monitorApiOkV2(r102, r104);
        return;
    L18:
        monitorApiOk(r102, r104);
    }

    private static lx5.e shouldRetryForAccountRequest(String r100, BaseHttpRequestInfo r101, boolean r102, List<Header> r103, Map<String, List<String>> r110) {
        lx5.e r104 = null;
        if (sRetryForAccountRequestCallback != null) goto L6;
        return null;
    L6:
        if (r103 == null) goto L17;
        Iterator<Header> r105 = r103.iterator();
    L9:
        if (r105.hasNext() == false) goto L17;
        Header r106 = r105.next();
        if (r106 == null) goto L9;
        if (BYPASS_RETRY_FOR_ACCOUNT_KEY.equalsIgnoreCase(r106.getName()) == false) goto L9;
        if ("1".equals(r106.getValue()) == false) goto L9;
        return null;
    L17:
        r101.metrics.accountRetryStart();
        r104 = ((gra.a) sRetryForAccountRequestCallback).a(r100, r103, r110);     // Catch: Throwable -> L20
    L21:
        r101.metrics.accountRetryEnd();
        if (r102 == true) goto L30;
        if (r104 == null) goto L30;
        if (r104.f511215a == false) goto L30;
        HashMap r107 = new HashMap();
        r107.put(RETRY_FOR_ACCOUNT_REQUEST_KEY, "1");
        Map<String, String> r108 = r104.f511217c;
        if (r108 == null) goto L29;
        r107.putAll(r108);
    L29:
        r104.f511217c = r107;
        r101.accountRetry = true;
    L30:
        return r104;
    }

    public static void monitorApiError(long r100, long r101, String r102, String r103, BaseHttpRequestInfo r104, Throwable r105) {
        if (r104 != null) goto L4;
        return;
    L4:
        RetrofitLayerMetrics.EventTimestamp r106 = r104.metrics.retrofit.eventTs;
        r106.ssHttpCallApiStartTime = r101;
        r104.requestStart = r101;
        long r107 = r101 + r100;
        r106.requestEndTime = r107;
        r104.requestEnd = r107;
        if (r106.requestEnd != (-1)) goto L7;
        r106.requestEnd = System.nanoTime();
    L7:
        r104.metrics.setRequestEndAppResumeState(AppActivityResumeSuspendRecorder.GetAppActivityResumeState());
        r104.traceCode = r103;
        r104.useDeprecatedApi = true;
        if (sDisallowDupReport == false) goto L13;
        if (r104.reported.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        if (Logger.debug() == false) goto L16;
        Logger.d("Report with deprecated monitorApiError, url: " + r102);
    L16:
        if (sUseMonitorV2 == false) goto L18;
        monitorApiErrorV2(r102, r104, r105);
        return;
    L18:
        monitorApiError(r102, r104, r105);
    }

    private static lx5.e shouldRetryRequestByRotationHost(Request r100, BaseHttpRequestInfo r101, int r102, List<Header> r103, Map<String, List<String>> r104, boolean r105) {
        lx5.e r106 = new lx5.e();
        if (r105 == false) goto L5;
    L9:
        return r106;
    L5:
        if (r101.bdTuringRetry == true) goto L9;
        if (r101.accountRetry == true) goto L9;
        sDisableRotationHostRetryByTnc.get();
        goto L9
    }

    public static lx5.e shouldRetryRequestOnceTime(Request r100, int r101, BaseHttpRequestInfo r102, List<Header> r103, Map<String, List<String>> r110, boolean r111, boolean r112) {
        lx5.e r104 = new lx5.e();
        boolean r105 = false;
        r102.rotationHostRetry = false;
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        return r104;
    L6:
        if (r101 != 200) goto L8;
    L9:
        if (r111 == false) goto L11;
        lx5.e r113 = shouldRetryRequestFromTuringHeader(r102, r103, r110);
        if (r102.executeTuringCallback == true) goto L16;
        r113 = shouldRetryRequestByHeader(r100, r102, r103, r110);
    L16:
        if (r113 != null) goto L18;
    L20:
        boolean r106 = false;
    L21:
        lx5.e r107 = shouldRetryForAccountRequest(r100.getUrl(), r102, r106, r103, r110);
        if (r106 == true) goto L27;
        if (r107 == null) goto L27;
        if (r113 == null) goto L26;
        r107.f511216b = r113.f511216b;
    L26:
        r113 = r107;
    L34:
        if (r113 != null) goto L36;
    L38:
        if (r105 == false) goto L40;
        return r113;
    L40:
        lx5.e r108 = shouldRetryRequestByRotationHost(r100, r102, r101, r103, r110, r112);
        if (r113 == null) goto L44;
        if (r108 == null) goto L44;
        r108.f511216b = r113.f511216b;
    L44:
        return r108;
    L36:
        if (r113.f511215a == false) goto L38;
        r105 = true;
    L27:
        if (r107 == null) goto L34;
        if (r107.f511217c == null) goto L34;
        HashMap r109 = new HashMap();
        Map<String, String> r114 = r113.f511217c;
        if (r114 == null) goto L33;
        r109.putAll(r114);
    L33:
        r109.putAll(r107.f511217c);
        r113.f511217c = r109;
        goto L34
    L18:
        if (r113.f511215a == false) goto L20;
        r106 = true;
    L11:
        return shouldRetryRequestByRotationHost(r100, r102, r101, r103, r110, r112);
    L8:
        if (ignoreStatusCodeCheck(r110) == false) goto L11;
        goto L9
    }
}
