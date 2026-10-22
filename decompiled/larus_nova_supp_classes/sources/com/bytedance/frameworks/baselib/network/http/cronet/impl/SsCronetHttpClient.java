package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lx5.a;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class SsCronetHttpClient extends a implements ICronetClient.ICronetBootFailureCheckerProvider, ICronetClient.ICronetThreadStackOptFailureCheckerProvider {
    private static final String CONCURRENT_NO_RETRY_SWITCH = "no_retry=1";
    private static final String CRONET_CLIENT_CLASS = "org.chromium.CronetClient";
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MAX = 20971520;
    private static final int CRONET_INPUTSTREAM_BUFF_SIZE_MIN = 8192;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MAX = 10485760;
    private static final int CRONET_OUTPUTSTREAM_BUFF_SIZE_MIN = 16384;
    private static final int INVALID_BUFFER_SIZE = 0;
    private static final String KEY_CRONET_INPUTSTREAM_BUFF_SIZE = "cronet_inputstream_buff_size";
    private static final String KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE = "post_body_buffer_size";
    private static final String KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE = "path_cronet_inputstream_buff_size";
    public static final String TAG = "SsCronetHttpClient";
    private static volatile boolean sBypassOfflineCheckEnabled = true;
    private static Context sContext = null;
    private static volatile ICronetAppProvider sCronetAppProvider = null;
    private static ICronetBootFailureChecker sCronetBootFailureChecker = null;
    private static ICronetClient sCronetClient = null;
    private static ICronetHttpDnsConfig sCronetHttpDnsConfig = null;
    private static volatile int sCronetInputstreamBuffSize = 0;
    private static ConcurrentHashMap<String, Integer> sCronetOutputStreamBufferMap = null;
    private static ICronetThreadStackOptFailureChecker sCronetThreadOptFailureChecker = null;
    private static ITncInfoGet sCronetTncInfoGet = null;
    private static String sCustomCronetClientClass = "";
    private static volatile String sInputStreamBufferConfig;
    private static volatile SsCronetHttpClient sInstance;
    private static Map<String, Integer> sPathCronetInputStreamBufferSizeMap;
    private static volatile String sPostBodyBufferConfig;

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public static boolean isCronetInputStreamSizeValid(int r1) {
        if (r1 >= CRONET_INPUTSTREAM_BUFF_SIZE_MIN) goto L5;
    L7:
        return false;
    L5:
        if (r1 > CRONET_INPUTSTREAM_BUFF_SIZE_MAX) goto L7;
        return true;
    }

    public static boolean isCustomCronetInputStreamSizeValid(int r1) {
        if (r1 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r1 > CRONET_INPUTSTREAM_BUFF_SIZE_MAX) goto L6;
        return true;
    }

    public static boolean isValidCronetOutputstreamBufferSize(int r1) {
        if (r1 >= CRONET_OUTPUTSTREAM_BUFF_SIZE_MIN) goto L5;
    L7:
        return false;
    L5:
        if (r1 > CRONET_OUTPUTSTREAM_BUFF_SIZE_MAX) goto L7;
        return true;
    }

    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) throws Exception {
    }

    static {
        sCronetOutputStreamBufferMap = new ConcurrentHashMap();
        sPathCronetInputStreamBufferSizeMap = new ConcurrentHashMap();
    }

    private static void checkCronetClientCreated() {
        if (sCronetClient == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    private static void tryResolveImpl() {
        if (sCronetClient == null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(sCustomCronetClientClass) == true) goto L7;
        String r0 = sCustomCronetClientClass;
    L8:
        Logger.w(TAG, "tryResolveImpl:" + r0);
        Object r1 = INVOKESTATIC_com_bytedance_frameworks_baselib_network_http_cronet_impl_SsCronetHttpClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r0).newInstance();     // Catch: Throwable -> L13
        if ((r1 instanceof ICronetClient) == false) goto L19;
        sCronetClient = (ICronetClient) r1;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w(TAG, "load CronetClient exception: " + th);
        return;
    L7:
        r0 = CRONET_CLIENT_CLASS;
        goto L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public String getThreadStackInitReason() {
        ICronetThreadStackOptFailureChecker r0 = sCronetThreadOptFailureChecker;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getThreadStackInitReason();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
    public boolean isCronetBootFailureExpected() {
        ICronetBootFailureChecker r0 = sCronetBootFailureChecker;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isCronetBootFailureExpected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public boolean isCronetThreadStackOptFailureExpected() {
        ICronetThreadStackOptFailureChecker r0 = sCronetThreadOptFailureChecker;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isCronetThreadStackOptFailureExpected();
    }

    public static String getCronetVersion() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getCronetVersion();
    }

    public int getEffectiveConnectionType() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveConnectionType();
    }

    public int getEffectiveHttpRttMs() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveHttpRttMs();
    }

    public int getEffectiveRxThroughputKbps() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveRxThroughputKbps();
    }

    public int getEffectiveTransportRttMs() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getEffectiveTransportRttMs();
    }

    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getGroupRttEstimates();
    }

    public NetworkQuality getNetworkQuality() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getNetworkQuality();
    }

    public int getNetworkQualityLevel() throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getNetworkQualityLevel();
    }

    public void setCookieInitCompleted() {
        checkCronetClientCreated();
        sCronetClient.setCookieInitCompleted();
    }

    public static Context getContext() {
        return sContext;
    }

    public static ICronetClient getCronetClient() {
        return sCronetClient;
    }

    public static ITncInfoGet getCronetTncInfoGet() {
        return sCronetTncInfoGet;
    }

    public static boolean getGlobalBypassOfflineCheck() {
        return sBypassOfflineCheckEnabled;
    }

    private SsCronetHttpClient(Context r1) {
        sContext = r1.getApplicationContext();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_frameworks_baselib_network_http_cronet_impl_SsCronetHttpClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public static void bindBigCore(TTNetThreadConfig.ThreadType r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindBigCore(r1);
    }

    public static void bindLittleCore(TTNetThreadConfig.ThreadType r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindLittleCore(r1);
    }

    public static int getCronetInternalErrorCode(HttpURLConnection r1) {
        return sCronetClient.getCronetInternalErrorCode(r1);
    }

    public static SsCronetHttpClient inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(SsCronetHttpClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SsCronetHttpClient(r2);     // Catch: Throwable -> L11
        tryResolveImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SsCronetHttpClient.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor r2) {
        r2.putInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, sCronetInputstreamBuffSize);
        if (sPostBodyBufferConfig == null) goto L6;
        r2.putString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, sPostBodyBufferConfig);
    L6:
        if (sInputStreamBufferConfig == null) goto L9;
        r2.putString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, sInputStreamBufferConfig);
        return;
    }

    public static void resetCoreBind(TTNetThreadConfig.ThreadType r1) throws Exception {
        checkCronetClientCreated();
        sCronetClient.resetCoreBind(r1);
    }

    public static void setBypassOfflineCheck(boolean r0) {
        sBypassOfflineCheckEnabled = r0;
    }

    public static void setCronetAppInfoProvider(ICronetAppProvider r0) {
        sCronetAppProvider = r0;
    }

    public static void setCronetBootFailureChecker(ICronetBootFailureChecker r0) {
        sCronetBootFailureChecker = r0;
    }

    public static void setCronetHttpDnsConfig(ICronetHttpDnsConfig r0) {
        sCronetHttpDnsConfig = r0;
    }

    public static void setCronetThreadOptFailureChecker(ICronetThreadStackOptFailureChecker r0) {
        sCronetThreadOptFailureChecker = r0;
    }

    public static void setCronetTncInfoGet(ITncInfoGet r0) {
        sCronetTncInfoGet = r0;
    }

    public static void setCustomCronetClientClass(String r0) {
        sCustomCronetClientClass = r0;
    }

    private static void updateInputStreamBufferConfig(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        sPathCronetInputStreamBufferSizeMap.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L13;
        String r1 = r0.next();
        if (TextUtils.isEmpty(r1) == true) goto L6;
        int r2 = r4.optInt(r1);
        if (isCustomCronetInputStreamSizeValid(r2) == false) goto L6;
        sPathCronetInputStreamBufferSizeMap.put(r1, Integer.valueOf(r2));
        goto L6
    }

    private static void updatePostBodyBufferConfig(JSONObject r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        sCronetOutputStreamBufferMap.clear();
        Iterator<String> r0 = r4.keys();
    L6:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        int r2 = r4.optInt(r1);
        if (TextUtils.isEmpty(r1) == true) goto L6;
        if (isValidCronetOutputstreamBufferSize(r2) == false) goto L6;
        sCronetOutputStreamBufferMap.put(r1, Integer.valueOf(r2));
        goto L6
    }

    public void clearClientOpaqueData(boolean r2) {
        if (sCronetClient != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
    L9:
        sCronetClient.clearClientOpaqueData();
        return;
    L7:
        if (i.d(sContext) == true) goto L9;
    }

    public void getMappingRequestState(String r2) {
        checkCronetClientCreated();
        sCronetClient.getMappingRequestState(r2);
    }

    public PacketLossMetrics getPacketLossRateMetrics(int r2) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getPacketLossRateMetrics(r2);
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r4) throws IOException {
        Request r5 = tryUseFormBodyModifyHook(r4);
        Request r0 = QueryFilterEngine.inst().filterQuery(r5);
        if (r0 == null) goto L6;
        r5 = r0;
    L6:
        if (CronetSsCallConfig.inst().isConcurrentRequestEnabled() == false) goto L18;
        if (r5.getUrl().contains(CONCURRENT_NO_RETRY_SWITCH) == true) goto L18;
        CronetSsCallConfig.UrlMatchRule r1 = CronetSsCallConfig.inst().getUrlMatchRuleFromRequest(r5);
        if (r1 == null) goto L18;
        if (r1.getDomainList() == null) goto L18;
        if (r1.getDomainList().size() < 2) goto L18;
        r5.getMetrics().networklib.misc.isConcurrentRequest = true;
        return new ConcurrentCronetSsCall(r5, r1);
    L18:
        return new CronetSsCall(r5);
    }

    public void reportNetDiagnosisUserLog(String r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.reportNetDiagnosisUserLog(r2);
    }

    public void runInBackGround(boolean r2) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (i.d(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.runInBackGround(r2);
    }

    public void setAlogFuncAddr(long r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setAlogFuncAddr(r2);
    }

    public void setHostResolverRules(String r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setHostResolverRules(r2);
    }

    public void setProxy(String r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setProxy(r2);
    }

    public void setSlaSamplingSetting(JSONObject r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setSlaSamplingSetting(r2);
    }

    public void triggerGetDomain(boolean r2) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (i.d(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.triggerGetDomain(r2);
    }

    public Request tryUseFormBodyModifyHook(Request r3) {
        FormUrlEncodedTypedOutput r0 = r3.getBody();
        if ((r0 instanceof FormUrlEncodedTypedOutput) == true) goto L5;
        return r3;
    L5:
        FormUrlEncodedTypedOutput r1 = r0;
        r1.useFormBodyModifyHookAndConstructStream(r3);
        return r3.newBuilder().post(r1).build();
    }

    public static int getCronetInputstreamBuffSize(String r1, BaseHttpRequestInfo r2) {
        if (isCronetInputStreamSizeValid(sCronetInputstreamBuffSize) == false) goto L7;
        return sCronetInputstreamBuffSize;
    L7:
        if (TextUtils.isEmpty(r1) == false) goto L9;
    L18:
        if (r2 == null) goto L29;
        BaseRequestContext r3 = r2.reqContext;
        if (r3 != null) goto L22;
        return 0;
    L22:
        if (isCronetInputStreamSizeValid(r3.input_stream_buffer_size) == true) goto L28;
        BaseRequestContext r4 = r2.reqContext;
        if (r4.ignoreCheckMinInputStreamBufferSize == true) goto L26;
        return 0;
    L26:
        if (isCustomCronetInputStreamSizeValid(r4.input_stream_buffer_size) == true) goto L28;
        return 0;
    L28:
        return r2.reqContext.input_stream_buffer_size;
    L29:
        return 0;
    L9:
        if (sPathCronetInputStreamBufferSizeMap.isEmpty() == true) goto L18;
        if (sPathCronetInputStreamBufferSizeMap.containsKey(r1) == false) goto L18;
        Integer r5 = sPathCronetInputStreamBufferSizeMap.get(r1);
        if (r5 == null) goto L18;
        if (isCronetInputStreamSizeValid(r5.intValue()) == false) goto L18;
        return r5.intValue();
    }

    public static int getCronetOutputStreamBufferSize(String r2, int r3) {
        if (isValidCronetOutputstreamBufferSize(r3) == true) goto L7;
        r3 = 0;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return r3;
    L10:
        if (sCronetOutputStreamBufferMap.containsKey(r2) == false) goto L16;
        Integer r4 = sCronetOutputStreamBufferMap.get(r2);
        if (r4 != null) goto L14;
        r3 = 0;
        goto L16
    L14:
        r3 = r4.intValue();
    L16:
        if (isValidCronetOutputstreamBufferSize(r3) == true) goto L18;
        return 0;
    L18:
        return r3;
    }

    public static HttpURLConnection openConnection(String r9, BaseHttpRequestInfo r10) throws IOException {
        tryResolveImpl();
        ICronetClient r0 = sCronetClient;
        if (r0 == null) goto L11;
        r0.setCronetBootFailureCheckerProvider(sInstance);
        sCronetClient.setCronetThreadStackOptFailureCheckerProvider(sInstance);
        ICronetClient r2 = sCronetClient;
        Context r3 = sContext;
        ICronetHttpDnsConfig r1 = sCronetHttpDnsConfig;
        if (r1 != null) goto L7;
        boolean r5 = false;
    L9:
        return r2.openConnection(r3, r9, r5, NetworkParams.getUserAgent(), r10, sCronetAppProvider);
    L7:
        r5 = r1.isCronetHttpDnsOpen();
        goto L9
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static void setBestHostWithRouteSelectionName(String r1, String r2) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setBestHostWithRouteSelectionName(r1, r2);
    }

    public static void tryUpdateBodyBufferSizeConfig(JSONObject r7, SharedPreferences r8) {
        if (r7 == null) goto L20;
        sCronetInputstreamBuffSize = r7.optInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        JSONObject r5 = r7.optJSONObject(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE);     // Catch: Throwable -> L19
        if (r5 == null) goto L8;
        updatePostBodyBufferConfig(r5);     // Catch: Throwable -> L19
        sPostBodyBufferConfig = r5.toString();     // Catch: Throwable -> L19
    L9:
        JSONObject r9 = r7.optJSONObject(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE);     // Catch: Throwable -> L19
        if (r9 == null) goto L17;
        String r6 = r9.toString();     // Catch: Throwable -> L19
        if (sInputStreamBufferConfig != null) goto L14;
    L16:
        updateInputStreamBufferConfig(r9);     // Catch: Throwable -> L19
        sInputStreamBufferConfig = r6;     // Catch: Throwable -> L19
        goto L20
    L14:
        if (r6.equals(sInputStreamBufferConfig) == false) goto L16;
        return;
    L17:
        sPathCronetInputStreamBufferSizeMap.clear();     // Catch: Throwable -> L19
        sInputStreamBufferConfig = XmlPullParser.NO_NAMESPACE;     // Catch: Throwable -> L19
        goto L20
    L8:
        sCronetOutputStreamBufferMap.clear();     // Catch: Throwable -> L19
        sPostBodyBufferConfig = XmlPullParser.NO_NAMESPACE;     // Catch: Throwable -> L19
    L20:
        if (r8 == null) goto L36;
        sCronetInputstreamBuffSize = r8.getInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        String r10 = r8.getString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r10) == false) goto L31;
    L26:
        String r11 = r8.getString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, XmlPullParser.NO_NAMESPACE);
        if (TextUtils.isEmpty(r11) == true) goto L37;
        updateInputStreamBufferConfig(new JSONObject(r11));     // Catch: Throwable -> L30
        return;
    L38:
        return;
    L37:
        return;
    L31:
        updatePostBodyBufferConfig(new JSONObject(r10));     // Catch: Throwable -> L25
        goto L26
    }

    public void preconnectUrl(String r2, Map<String, String> r3) throws Exception {
        checkCronetClientCreated();
        sCronetClient.preconnectUrl(r2, r3);
    }

    public void removeClientOpaqueData(String r2, boolean r3) {
        if (sCronetClient != null) goto L5;
        return;
    L5:
        if (r3 == false) goto L7;
    L9:
        sCronetClient.removeClientOpaqueData(r2);
        return;
    L7:
        if (i.d(sContext) == true) goto L9;
    }

    public void stopThrottle(String[] r2, int r3) {
        checkCronetClientCreated();
        sCronetClient.stopThrottle(r2, r3);
    }

    public static TTDispatchResult ttUrlDispatch(String r1, int r2, boolean r3) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.ttUrlDispatch(r1, r2, r3);
    }

    public void startThrottle(String[] r2, int r3, long r4) {
        checkCronetClientCreated();
        sCronetClient.startThrottle(r2, r3, r4);
    }

    public void tryStartNetDetect(String[] r2, int r3, int r4) throws Exception {
        checkCronetClientCreated();
        sCronetClient.tryStartNetDetect(r2, r3, r4);
    }

    public void ttDnsResolve(String r2, int r3, String r4, Map<String, String> r5) throws Exception {
        checkCronetClientCreated();
        sCronetClient.ttDnsResolve(r2, r3, r4, r5);
    }

    public void addClientOpaqueData(String[] r10, byte[] r11, byte[] r12, long r13, long r15, boolean r17) {
        if (sCronetClient != null) goto L5;
        return;
    L5:
        if (r17 == false) goto L7;
    L9:
        sCronetClient.addClientOpaqueData(r10, r11, r12, r13, r15);
        return;
    L7:
        if (i.d(sContext) == true) goto L9;
    }

    public void enableTTBizHttpDns(boolean r8, String r9, String r10, String r11, boolean r12, String r13) throws Exception {
        checkCronetClientCreated();
        sCronetClient.enableTTBizHttpDns(r8, r9, r10, r11, r12, r13);
    }

    public void notifyTNCConfigUpdated(String r8, String r9, String r10, String r11, String r12, String r13) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyTNCConfigUpdated(r8, r9, r10, r11, r12, r13);
    }

    public void tryCreateCronetEngine(boolean r12, boolean r13, boolean r14, boolean r15, boolean r16, ICronetAppProvider r17) {
        tryResolveImpl();
        ICronetClient r1 = sCronetClient;
        if (r1 == null) goto L6;
        r1.setCronetBootFailureCheckerProvider(this);
        sCronetClient.setCronetThreadStackOptFailureCheckerProvider(this);
        sCronetClient.tryCreateCronetEngine(sContext, r12, r13, r14, r15, NetworkParams.getUserAgent(), r16, r17);
        return;
    }

    public void setZstdFuncAddr(long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setZstdFuncAddr(r18, r20, r22, r24, r26, r28, r30, r32);
    }

    public static void notifyStoreRegionUpdated(String r12, String r13, String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyStoreRegionUpdated(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }
}
