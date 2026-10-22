package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.mime.FormUrlEncodedTypedOutput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SsCronetHttpClient extends lx5.a implements ICronetClient.ICronetBootFailureCheckerProvider, ICronetClient.ICronetThreadStackOptFailureCheckerProvider {
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

    /* JADX INFO: loaded from: classes3.dex */
    public interface ICronetBootFailureChecker {
        boolean isCronetBootFailureExpected();
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface ICronetHttpDnsConfig {
        boolean isCronetHttpDnsOpen();
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface ICronetThreadStackOptFailureChecker {
        String getThreadStackInitReason();

        boolean isCronetThreadStackOptFailureExpected();
    }

    /* JADX INFO: loaded from: classes3.dex */
    public interface ITncInfoGet {
        JSONObject getABTest();
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean isCronetInputStreamSizeValid(int r100) {
        if (r100 >= 8192) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 20971520) goto L7;
        return true;
    }

    public static boolean isCustomCronetInputStreamSizeValid(int r100) {
        if (r100 > 0) goto L4;
    L6:
        return false;
    L4:
        if (r100 > 20971520) goto L6;
        return true;
    }

    public static boolean isValidCronetOutputstreamBufferSize(int r100) {
        if (r100 >= 16384) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 10485760) goto L7;
        return true;
    }

    public void setHttpDnsForTesting(boolean r100, boolean r101, boolean r102) throws Exception {
    }

    static {
        sCronetOutputStreamBufferMap = new ConcurrentHashMap();
        sPathCronetInputStreamBufferSizeMap = new ConcurrentHashMap();
    }

    private static void checkCronetClientCreated() {
        if (sCronetClient == null) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    private static void tryResolveImpl() {
        if (sCronetClient == null) goto L5;
        return;
    L5:
        if (StringUtils.isEmpty(sCustomCronetClientClass) == true) goto L7;
        String r100 = sCustomCronetClientClass;
    L8:
        Logger.w(TAG, "tryResolveImpl:" + r100);
        Object r101 = INVOKESTATIC_com_bytedance_frameworks_baselib_network_http_cronet_impl_SsCronetHttpClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).newInstance();     // Catch: Throwable -> L13
        if ((r101 instanceof ICronetClient) == false) goto L19;
        sCronetClient = (ICronetClient) r101;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w(TAG, "load CronetClient exception: " + th);
        return;
    L7:
        r100 = CRONET_CLIENT_CLASS;
        goto L8
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public String getThreadStackInitReason() {
        ICronetThreadStackOptFailureChecker r100 = sCronetThreadOptFailureChecker;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getThreadStackInitReason();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureCheckerProvider
    public boolean isCronetBootFailureExpected() {
        ICronetBootFailureChecker r100 = sCronetBootFailureChecker;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.isCronetBootFailureExpected();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetThreadStackOptFailureCheckerProvider
    public boolean isCronetThreadStackOptFailureExpected() {
        ICronetThreadStackOptFailureChecker r100 = sCronetThreadOptFailureChecker;
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.isCronetThreadStackOptFailureExpected();
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

    private SsCronetHttpClient(Context r100) {
        sContext = r100.getApplicationContext();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_frameworks_baselib_network_http_cronet_impl_SsCronetHttpClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static void bindBigCore(TTNetThreadConfig.ThreadType r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindBigCore(r100);
    }

    public static void bindLittleCore(TTNetThreadConfig.ThreadType r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.bindLittleCore(r100);
    }

    public static int getCronetInternalErrorCode(HttpURLConnection r100) {
        return sCronetClient.getCronetInternalErrorCode(r100);
    }

    public static SsCronetHttpClient inst(Context r100) {
        if (sInstance != null) goto L15;
        monitor-enter(SsCronetHttpClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SsCronetHttpClient(r100);     // Catch: Throwable -> L11
        tryResolveImpl();     // Catch: Throwable -> L11
    L9:
        monitor-exit(SsCronetHttpClient.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static void onSaveConfigToSP(SharedPreferences.Editor r100) {
        r100.putInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, sCronetInputstreamBuffSize);
        if (sPostBodyBufferConfig == null) goto L6;
        r100.putString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, sPostBodyBufferConfig);
    L6:
        if (sInputStreamBufferConfig == null) goto L9;
        r100.putString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, sInputStreamBufferConfig);
        return;
    }

    public static void resetCoreBind(TTNetThreadConfig.ThreadType r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.resetCoreBind(r100);
    }

    public static void setBypassOfflineCheck(boolean r100) {
        sBypassOfflineCheckEnabled = r100;
    }

    public static void setCronetAppInfoProvider(ICronetAppProvider r100) {
        sCronetAppProvider = r100;
    }

    public static void setCronetBootFailureChecker(ICronetBootFailureChecker r100) {
        sCronetBootFailureChecker = r100;
    }

    public static void setCronetHttpDnsConfig(ICronetHttpDnsConfig r100) {
        sCronetHttpDnsConfig = r100;
    }

    public static void setCronetThreadOptFailureChecker(ICronetThreadStackOptFailureChecker r100) {
        sCronetThreadOptFailureChecker = r100;
    }

    public static void setCronetTncInfoGet(ITncInfoGet r100) {
        sCronetTncInfoGet = r100;
    }

    public static void setCustomCronetClientClass(String r100) {
        sCustomCronetClientClass = r100;
    }

    private static void updateInputStreamBufferConfig(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sPathCronetInputStreamBufferSizeMap.clear();
        Iterator<String> r101 = r100.keys();
    L6:
        if (r101.hasNext() == false) goto L13;
        String r102 = r101.next();
        if (TextUtils.isEmpty(r102) == true) goto L6;
        int r103 = r100.optInt(r102);
        if (isCustomCronetInputStreamSizeValid(r103) == false) goto L6;
        sPathCronetInputStreamBufferSizeMap.put(r102, Integer.valueOf(r103));
        goto L6
    }

    private static void updatePostBodyBufferConfig(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        sCronetOutputStreamBufferMap.clear();
        Iterator<String> r101 = r100.keys();
    L6:
        if (r101.hasNext() == false) goto L12;
        String r102 = r101.next();
        int r103 = r100.optInt(r102);
        if (TextUtils.isEmpty(r102) == true) goto L6;
        if (isValidCronetOutputstreamBufferSize(r103) == false) goto L6;
        sCronetOutputStreamBufferMap.put(r102, Integer.valueOf(r103));
        goto L6
    }

    public void clearClientOpaqueData(boolean r100) {
        if (sCronetClient != null) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
    L9:
        sCronetClient.clearClientOpaqueData();
        return;
    L7:
        if (i.d(sContext) == true) goto L9;
    }

    public void getMappingRequestState(String r100) {
        checkCronetClientCreated();
        sCronetClient.getMappingRequestState(r100);
    }

    public PacketLossMetrics getPacketLossRateMetrics(int r100) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.getPacketLossRateMetrics(r100);
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r100) throws IOException {
        Request r101 = tryUseFormBodyModifyHook(r100);
        Request r102 = QueryFilterEngine.inst().filterQuery(r101);
        if (r102 == null) goto L6;
        r101 = r102;
    L6:
        if (CronetSsCallConfig.inst().isConcurrentRequestEnabled() == false) goto L18;
        if (r101.getUrl().contains(CONCURRENT_NO_RETRY_SWITCH) == true) goto L18;
        CronetSsCallConfig.UrlMatchRule r103 = CronetSsCallConfig.inst().getUrlMatchRuleFromRequest(r101);
        if (r103 == null) goto L18;
        if (r103.getDomainList() == null) goto L18;
        if (r103.getDomainList().size() < 2) goto L18;
        r101.getMetrics().networklib.misc.isConcurrentRequest = true;
        return new ConcurrentCronetSsCall(r101, r103);
    L18:
        return new CronetSsCall(r101);
    }

    public void reportNetDiagnosisUserLog(String r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.reportNetDiagnosisUserLog(r100);
    }

    public void runInBackGround(boolean r100) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (i.d(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.runInBackGround(r100);
    }

    public void setAlogFuncAddr(long r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setAlogFuncAddr(r100);
    }

    public void setHostResolverRules(String r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setHostResolverRules(r100);
    }

    public void setProxy(String r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setProxy(r100);
    }

    public void setSlaSamplingSetting(JSONObject r100) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setSlaSamplingSetting(r100);
    }

    public void triggerGetDomain(boolean r100) {
        if (sCronetClient != null) goto L6;
        return;
    L6:
        if (i.d(sContext) == true) goto L8;
        return;
    L8:
        sCronetClient.triggerGetDomain(r100);
    }

    public Request tryUseFormBodyModifyHook(Request r100) {
        TypedOutput r101 = r100.getBody();
        if ((r101 instanceof FormUrlEncodedTypedOutput) == true) goto L5;
        return r100;
    L5:
        FormUrlEncodedTypedOutput r102 = (FormUrlEncodedTypedOutput) r101;
        r102.useFormBodyModifyHookAndConstructStream(r100);
        return r100.newBuilder().post(r102).build();
    }

    public static int getCronetInputstreamBuffSize(String r100, BaseHttpRequestInfo r101) {
        if (isCronetInputStreamSizeValid(sCronetInputstreamBuffSize) == false) goto L7;
        return sCronetInputstreamBuffSize;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L9;
    L18:
        if (r101 == null) goto L29;
        T r102 = r101.reqContext;
        if (r102 != 0) goto L22;
        return 0;
    L22:
        if (isCronetInputStreamSizeValid(r102.input_stream_buffer_size) == true) goto L28;
        T r103 = r101.reqContext;
        if (r103.ignoreCheckMinInputStreamBufferSize == true) goto L26;
        return 0;
    L26:
        if (isCustomCronetInputStreamSizeValid(r103.input_stream_buffer_size) == true) goto L28;
        return 0;
    L28:
        return r101.reqContext.input_stream_buffer_size;
    L29:
        return 0;
    L9:
        if (sPathCronetInputStreamBufferSizeMap.isEmpty() == true) goto L18;
        if (sPathCronetInputStreamBufferSizeMap.containsKey(r100) == false) goto L18;
        Integer r104 = sPathCronetInputStreamBufferSizeMap.get(r100);
        if (r104 == null) goto L18;
        if (isCronetInputStreamSizeValid(r104.intValue()) == false) goto L18;
        return r104.intValue();
    }

    public static int getCronetOutputStreamBufferSize(String r100, int r101) {
        if (isValidCronetOutputstreamBufferSize(r101) == true) goto L7;
        r101 = 0;
    L7:
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return r101;
    L10:
        if (sCronetOutputStreamBufferMap.containsKey(r100) == false) goto L16;
        Integer r102 = sCronetOutputStreamBufferMap.get(r100);
        if (r102 != null) goto L14;
        r101 = 0;
        goto L16
    L14:
        r101 = r102.intValue();
    L16:
        if (isValidCronetOutputstreamBufferSize(r101) == true) goto L18;
        return 0;
    L18:
        return r101;
    }

    public static HttpURLConnection openConnection(String r100, BaseHttpRequestInfo r110) throws IOException {
        tryResolveImpl();
        ICronetClient r101 = sCronetClient;
        if (r101 == null) goto L11;
        r101.setCronetBootFailureCheckerProvider(sInstance);
        sCronetClient.setCronetThreadStackOptFailureCheckerProvider(sInstance);
        ICronetClient r102 = sCronetClient;
        Context r103 = sContext;
        ICronetHttpDnsConfig r104 = sCronetHttpDnsConfig;
        if (r104 != null) goto L7;
        boolean r105 = false;
    L9:
        return r102.openConnection(r103, r100, r105, NetworkParams.getUserAgent(), r110, sCronetAppProvider);
    L7:
        r105 = r104.isCronetHttpDnsOpen();
        goto L9
    L11:
        throw new IllegalArgumentException("CronetClient is null");
    }

    public static void setBestHostWithRouteSelectionName(String r100, String r101) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setBestHostWithRouteSelectionName(r100, r101);
    }

    public static void tryUpdateBodyBufferSizeConfig(JSONObject r100, SharedPreferences r101) {
        if (r100 == null) goto L20;
        sCronetInputstreamBuffSize = r100.optInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        JSONObject r102 = r100.optJSONObject(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE);     // Catch: Throwable -> L19
        if (r102 == null) goto L8;
        updatePostBodyBufferConfig(r102);     // Catch: Throwable -> L19
        sPostBodyBufferConfig = r102.toString();     // Catch: Throwable -> L19
    L9:
        JSONObject r103 = r100.optJSONObject(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE);     // Catch: Throwable -> L19
        if (r103 == null) goto L17;
        String r104 = r103.toString();     // Catch: Throwable -> L19
        if (sInputStreamBufferConfig != null) goto L14;
    L16:
        updateInputStreamBufferConfig(r103);     // Catch: Throwable -> L19
        sInputStreamBufferConfig = r104;     // Catch: Throwable -> L19
        goto L20
    L14:
        if (r104.equals(sInputStreamBufferConfig) == false) goto L16;
        return;
    L17:
        sPathCronetInputStreamBufferSizeMap.clear();     // Catch: Throwable -> L19
        sInputStreamBufferConfig = "";     // Catch: Throwable -> L19
        goto L20
    L8:
        sCronetOutputStreamBufferMap.clear();     // Catch: Throwable -> L19
        sPostBodyBufferConfig = "";     // Catch: Throwable -> L19
    L20:
        if (r101 == null) goto L36;
        sCronetInputstreamBuffSize = r101.getInt(KEY_CRONET_INPUTSTREAM_BUFF_SIZE, 0);
        String r105 = r101.getString(KEY_CRONET_OUTPUTSTREAM_BUFF_SIZE, "");
        if (TextUtils.isEmpty(r105) == false) goto L31;
    L26:
        String r106 = r101.getString(KEY_PATH_CRONET_INPUTSTREAM_BUFF_SIZE, "");
        if (TextUtils.isEmpty(r106) == true) goto L37;
        updateInputStreamBufferConfig(new JSONObject(r106));     // Catch: Throwable -> L30
        return;
    L38:
        return;
    L37:
        return;
    L31:
        updatePostBodyBufferConfig(new JSONObject(r105));     // Catch: Throwable -> L25
        goto L26
    }

    public void preconnectUrl(String r100, Map<String, String> r101) throws Exception {
        checkCronetClientCreated();
        sCronetClient.preconnectUrl(r100, r101);
    }

    public void removeClientOpaqueData(String r100, boolean r101) {
        if (sCronetClient != null) goto L5;
        return;
    L5:
        if (r101 == false) goto L7;
    L9:
        sCronetClient.removeClientOpaqueData(r100);
        return;
    L7:
        if (i.d(sContext) == true) goto L9;
    }

    public void stopThrottle(String[] r100, int r101) {
        checkCronetClientCreated();
        sCronetClient.stopThrottle(r100, r101);
    }

    public static TTDispatchResult ttUrlDispatch(String r100, int r101, boolean r102) throws Exception {
        checkCronetClientCreated();
        return sCronetClient.ttUrlDispatch(r100, r101, r102);
    }

    public void startThrottle(String[] r100, int r101, long r102) {
        checkCronetClientCreated();
        sCronetClient.startThrottle(r100, r101, r102);
    }

    public void tryStartNetDetect(String[] r100, int r101, int r102) throws Exception {
        checkCronetClientCreated();
        sCronetClient.tryStartNetDetect(r100, r101, r102);
    }

    public void ttDnsResolve(String r100, int r101, String r102, Map<String, String> r103) throws Exception {
        checkCronetClientCreated();
        sCronetClient.ttDnsResolve(r100, r101, r102, r103);
    }

    public void addClientOpaqueData(String[] r110, byte[] r111, byte[] r112, long r113, long r114, boolean r115) {
        if (sCronetClient != null) goto L5;
        return;
    L5:
        if (r115 == false) goto L7;
    L9:
        sCronetClient.addClientOpaqueData(r110, r111, r112, r113, r114);
        return;
    L7:
        if (i.d(sContext) == true) goto L9;
    }

    public void enableTTBizHttpDns(boolean r100, String r101, String r110, String r111, boolean r112, String r113) throws Exception {
        checkCronetClientCreated();
        sCronetClient.enableTTBizHttpDns(r100, r101, r110, r111, r112, r113);
    }

    public void notifyTNCConfigUpdated(String r100, String r101, String r110, String r111, String r112, String r113) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyTNCConfigUpdated(r100, r101, r110, r111, r112, r113);
    }

    public void tryCreateCronetEngine(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, ICronetAppProvider r115) {
        tryResolveImpl();
        ICronetClient r100 = sCronetClient;
        if (r100 == null) goto L6;
        r100.setCronetBootFailureCheckerProvider(this);
        sCronetClient.setCronetThreadStackOptFailureCheckerProvider(this);
        sCronetClient.tryCreateCronetEngine(sContext, r110, r111, r112, r113, NetworkParams.getUserAgent(), r114, r115);
        return;
    }

    public void setZstdFuncAddr(long r110, long r210, long r211, long r212, long r213, long r214, long r310, long r311) throws Exception {
        checkCronetClientCreated();
        sCronetClient.setZstdFuncAddr(r110, r210, r211, r212, r213, r214, r310, r311);
    }

    public static void notifyStoreRegionUpdated(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, String r212) throws Exception {
        checkCronetClientCreated();
        sCronetClient.notifyStoreRegionUpdated(r110, r111, r112, r113, r114, r115, r116, r117, r210, r211, r212);
    }
}
