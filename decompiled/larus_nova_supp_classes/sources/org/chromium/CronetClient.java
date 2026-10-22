package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
import com.bytedance.frameworks.baselib.network.http.util.i;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.larus.utils.logger.FLogger;
import com.ttnet.org.chromium.base.Logger;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalCronetEngine;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTAppSecurityManager;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import wx5.b;
import wx5.c;
import wx5.d;
import yx5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class CronetClient implements ICronetClient {
    private static final String BORINGSSL_LIBRARY_NAME = "ttboringssl";
    private static final String CRYPTO_LIBRARY_NAME = "ttcrypto";
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String KEY_CRASH_DETECT_INTERVAL_MS = "crash_detect_interval_ms";
    private static final String KEY_CRASH_LIMIT_TIMES = "crash_limit_times";
    private static final String KEY_TTNET_CRASH_TIMES = "ttnet_crash_times";
    private static final int MAX_THREAD_STACK_SIZE = 5242880;
    private static final int MIN_THREAD_STACK_SIZE = 51200;
    private static final String SP_SS_APP_CONFIG = "ss_app_config";
    public static final String TAG = "CronetClient";
    private static final String TTNET_ALOG_CLASS = "com.bytedance.ttnet.TTALog";
    private static final String TTNET_BOE_FLAG = "ttnet_boe.flag";
    private static final String TTNET_CACHE_DIR = "ttnet_storage/";
    private static final String TTNET_CONFIG_FILE = "ttnet_config.json";
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static int sAppID = 0;
    private static ICronetClient.ICronetBootFailureCheckerProvider sCronetBootFailureCheckerProvider = null;
    private static volatile CronetEngine sCronetEngine = null;
    private static ICronetClient.ICronetThreadStackOptFailureCheckerProvider sCronetThreadStackOptFailureCheckerProvider = null;
    private static volatile int sNetworkThreadPriority = 20;
    private int mCrashDetectTimerInterval;
    private int mCrashLimitTimes;
    private int mTTNetCrashTimes;

    public static /* synthetic */ void access$000(String r0) {
        System.loadLibrary(r0);
    }

    public static /* synthetic */ Class access$001(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return "TTNetVersion:c32625e6 2026-09-09 QuicVersion:6a5515bf 2026-09-09";
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHttpDnsForTesting(boolean r1, boolean r2, boolean r3) throws Exception {
    }

    private static long getALogFuncAddr() throws Exception {
        return ((Long) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_ALOG_CLASS).newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private static int getAppSecurityLevel() {
        return ((Integer) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getAppSecurityLevel").get()).intValue();
    L4:
        return 0;
    }

    public static CronetEngine getCronetEngine() {
        if (sCronetEngine == null) goto L7;
        return sCronetEngine;
    L7:
        throw new NullPointerException("Cronet engine is null.");
    }

    private static boolean getListenAppStateIndependently() {
        return ((Boolean) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    private static long getMaxHttpDiskCacheSize() {
        return ((Long) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getMaxHttpDiskCacheSize").get()).longValue();
    L4:
        return 67108864;
    }

    private static JSONObject getSlaSamplingSetting() {
        return (JSONObject) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getSlaSamplingSetting").get();
    L4:
        return null;
    }

    private static int getTelemetryOptionFlags() {
        return ((Integer) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getTelemetryOptionFlags").get()).intValue();
    L4:
        return 0;
    }

    private static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        return (TTNetThreadConfig.Callback) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigCallbackImpl").get();
    L4:
        return null;
    }

    private static ArrayList<TTNetThreadConfig> getThreadConfigInfoList() {
        return (ArrayList) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigInfoList").get();
    L4:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveConnectionType() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return sCronetEngine.getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveHttpRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return sCronetEngine.getEffectiveHttpRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveRxThroughputKbps() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return sCronetEngine.getEffectiveRxThroughput();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveTransportRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return sCronetEngine.getEffectiveTransportRtt();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ExperimentalCronetEngine r0 = sCronetEngine;
        HashMap r1 = new HashMap();
        Iterator r2 = r0.getGroupRttEstimates().entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L12;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (((int[]) r3.getValue()).length != 2) goto L11;
        NetworkQuality r4 = new NetworkQuality();
        r4.transportRttMs = ((int[]) r3.getValue())[0];
        r4.httpRttMs = ((int[]) r3.getValue())[1];
        r4.downstreamThroughputKbps = -1;
        r1.put((String) r3.getKey(), r4);
        goto L6
    L11:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L12:
        return r1;
    L14:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public NetworkQuality getNetworkQuality() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ExperimentalCronetEngine r0 = sCronetEngine;
        NetworkQuality r1 = new NetworkQuality();
        r1.transportRttMs = r0.getTransportRttMs();
        r1.httpRttMs = r0.getHttpRttMs();
        r1.downstreamThroughputKbps = r0.getDownstreamThroughputKbps();
        return r1;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getNetworkQualityLevel() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return sCronetEngine.getNetworkQualityLevel();
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCookieInitCompleted() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.setCookieInitCompleted();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = 5000;
    }

    private static String getDomainConfigByRegion() {
        c r0 = c.h();
        r0.getClass();
        boolean r1 = NetworkParams.getOptReflection();
        String r2 = XmlPullParser.NO_NAMESPACE;
        if (r1 == false) goto L8;
        ICronetAppProvider r3 = r0.b;
        if (r3 != null) goto L7;
        String r4 = XmlPullParser.NO_NAMESPACE;
    L9:
        c r5 = c.h();
        r5.getClass();
        if (NetworkParams.getOptReflection() == false) goto L15;
        ICronetAppProvider r6 = r5.b;
        if (r6 != null) goto L14;
        String r7 = XmlPullParser.NO_NAMESPACE;
    L16:
        c r8 = c.h();
        r8.getClass();
        if (NetworkParams.getOptReflection() == false) goto L22;
        ICronetAppProvider r9 = r8.b;
        if (r9 == null) goto L24;
        r2 = r9.getRegion();
    L24:
        if (TextUtils.isEmpty(r4) == false) goto L31;
        if (TextUtils.isEmpty(r7) == true) goto L29;
        r4 = r7;
        goto L31
    L29:
        r4 = r2;
    L31:
        if (TextUtils.isEmpty(r4) == false) goto L36;
        return null;
    L36:
        return (String) a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r4}).get();
    L35:
        return null;
    L22:
        r2 = r8.e("getRegion");
        goto L24
    L14:
        r7 = r6.getSysRegion();
        goto L16
    L15:
        r7 = r5.e("getSysRegion");
        goto L16
    L7:
        r4 = r3.getCarrierRegion();
        goto L9
    L8:
        r4 = r0.e("getCarrierRegion");
        goto L9
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void clearClientOpaqueData() {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "clearClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        sCronetEngine.clearClientOpaqueData();     // Catch: Throwable -> L9
        return;
    }

    @JvmStatic
    public static void INVOKESTATIC_org_chromium_CronetClient_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$001(r3);     // Catch: Throwable -> L8
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
        Class r4 = access$001(r3);     // Catch: Throwable -> L17
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

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(TTNetAppInfoSubset r3) {
        TTAppInfoProvider.AppInfo r0 = new TTAppInfoProvider.AppInfo();
        r0.setAbSdkVersion(r3.mAbSdkVersion);
        r0.setHostFirst(r3.mHostFirst);
        r0.setHostSecond(r3.mHostSecond);
        r0.setHostThird(r3.mHostThird);
        r0.setDomainHttpDns(r3.mDomainHttpDns);
        r0.setDomainBoe(r3.mDomainBoe);
        r0.setDomainBoeHttps(r3.mDomainBoeHttps);
        r0.setInitRegion(r3.mInitRegion);
        return r0;
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(c r5) {
        if (r5 != null) goto L19;
        return null;
    L19:
        b r1 = r5.c;     // Catch: Exception -> L8
        if (r1 == null) goto L10;
        TTSamplingSettingProvider.TTSlaSamplingRule r2 = new TTSamplingSettingProvider.TTSlaSamplingRule();     // Catch: Exception -> L8
        r2.mEnableBaseApiAll = r1.a;     // Catch: Exception -> L8
        r2.mEnableApiAllUpload = r1.b;     // Catch: Exception -> L8
        r2.mUrlRegexBlackList = r1.c;     // Catch: Exception -> L8
        r2.mPathEqualWhiteList = r1.d;     // Catch: Exception -> L8
        r2.mPathPrefixWhiteList = r1.f;     // Catch: Exception -> L8
        r2.mPathContainWhiteList = r1.e;     // Catch: Exception -> L8
        r2.mPathRegexWhiteList = r1.g;     // Catch: Exception -> L8
        r2.mHostPatternWhiteList = r1.i;     // Catch: Exception -> L8
        r2.mUrlRegexWhiteList = r1.h;     // Catch: Exception -> L8
    L11:
        wx5.a r3 = r5.d;     // Catch: Exception -> L8
        if (r3 == null) goto L14;
        TTSamplingSettingProvider.TTEventLogSamplingRule r4 = new TTSamplingSettingProvider.TTEventLogSamplingRule();     // Catch: Exception -> L8
        r4.mEventLogTypeWhiteList = r3.a;     // Catch: Exception -> L8
    L15:
        TTSamplingSettingProvider.TTSlaSamplingSetting r6 = new TTSamplingSettingProvider.TTSlaSamplingSetting();     // Catch: Exception -> L8
        r6.mHostAid = r5.a;     // Catch: Exception -> L8
        r6.mSdkAid = r5.b;     // Catch: Exception -> L8
        r6.mSlaSamplingRule = r2;     // Catch: Exception -> L8
        r6.mEventLogSamplingRule = r4;     // Catch: Exception -> L8
        return r6;
    L14:
        r4 = null;
        goto L15
    L10:
        r2 = null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private String getProxyConfig(String r6) {
        boolean r0 = TextUtils.isEmpty(r6);
        String r1 = XmlPullParser.NO_NAMESPACE;
        if (r0 == true) goto L34;
        BufferedReader r2 = null;
        PolarisFileWrapper r3 = new PolarisFileWrapper(r6 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L21
        if (r3.exists() == false) goto L16;
        BufferedReader r7 = new BufferedReader(new PolarisFileReaderWrapper(r3));     // Catch: Throwable -> L21
        StringBuilder r4 = new StringBuilder();     // Catch: Throwable -> L14
    L9:
        String r5 = r7.readLine();     // Catch: Throwable -> L14
        if (r5 == null) goto L12;
        r4.append(r5);     // Catch: Throwable -> L14
        goto L9
    L12:
        r1 = new JSONObject(r4.toString()).optString("ttnet_proxy", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L14
        r2 = r7;
    L14:
        Throwable th = th;
    L42:
        th.printStackTrace();     // Catch: Throwable -> L27
        if (r7 == null) goto L34;
        r7.close();     // Catch: IOException -> L19
    L37:
    L27:
        th = move-exception;
        if (r7 != null) goto L40;
    L33:
        throw th;
    L40:
        r7.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r2 == null) goto L34;
        r2.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        th = th;
        r7 = null;
    L34:
        return r1;
    }

    public static void setNetworkThreadPriority(int r0) {
        sNetworkThreadPriority = r0;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindBigCore(TTNetThreadConfig.ThreadType r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.bindBigCore(r2.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindLittleCore(TTNetThreadConfig.ThreadType r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.bindLittleCore(r2.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(TTNetThreadConfig.Callback r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new 2(this, r2);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r3) {
    L8:
        return 0;
    L4:
        if ((r3 instanceof CronetHttpURLConnection) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) r3).getCronetInternalErrorCode();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getMappingRequestState(String r3) {
        CronetUrlRequest r0 = CronetUrlRequestMapping.GetRequest(r3);     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        r0.getStatus(new 5(this, r3));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public PacketLossMetrics getPacketLossRateMetrics(int r5) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        PacketLossMetrics r0 = new PacketLossMetrics();
        ExperimentalCronetEngine r1 = sCronetEngine;
        r0.protocol = r5;
        r0.upstreamLossRate = r1.getUpstreamPacketLossRate(r5);
        r0.upstreamLossRateVariance = r1.getUpstreamPacketLossRateVariance(r5);
        r0.downstreamLossRate = r1.getDownstreamPacketLossRate(r5);
        r0.downstreamLossRateVariance = r1.getDownstreamPacketLossRateVariance(r5);
        return r0;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r1) {
        return r1 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void removeClientOpaqueData(String r4) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        sCronetEngine.removeClientOpaqueData(r4);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void reportNetDiagnosisUserLog(String r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.reportNetDiagnosisUserLog(r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void resetCoreBind(TTNetThreadConfig.ThreadType r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.resetCoreBind(r2.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void runInBackGround(boolean r4) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        sCronetEngine.runInBackGround(r4);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAlogFuncAddr(long r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.setAlogFuncAddr(r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAppStartUpState(int r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.setAppStartUpState(r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider r1) {
        sCronetBootFailureCheckerProvider = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetThreadStackOptFailureCheckerProvider(ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1) {
        sCronetThreadStackOptFailureCheckerProvider = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHostResolverRules(String r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.setHostResolverRules(r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setProxy(String r2) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.setProxy(r2);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setSlaSamplingSetting(JSONObject r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L20;
        if (sAppID > 0) goto L14;
        c r0 = c.h();
        r0.getClass();
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r1 = r0.b;
        if (r1 != null) goto L11;
        String r2 = XmlPullParser.NO_NAMESPACE;
    L13:
        sAppID = CastIntegerProtector.parseInt(r2);
        goto L14
    L11:
        r2 = r1.getAppId();
        goto L13
    L12:
        r2 = r0.e("getAppId");
    L14:
        TTSamplingSettingProvider.TTSlaSamplingSetting r4 = convertToCronetSlaSamplingSetting(d.a(r3, sAppID));
        if (r4 != null) goto L17;
        return;
    L17:
        sCronetEngine.addSamplingSetting(r4);
        return;
    L20:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerGetDomain(boolean r4) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        sCronetEngine.triggerGetDomain(r4);     // Catch: Throwable -> L9
        return;
    }

    private void detectCronetColdStartCrash(Context r12, ExperimentalCronetEngine.Builder r13) {
        SharedPreferences r0 = r12.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int r2 = r0.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = r2;
        if (r2 > 0) goto L8;
        int r3 = r0.getInt(KEY_TTNET_CRASH_TIMES, 0);
        this.mTTNetCrashTimes = r3;
        if (r3 <= 0) goto L28;
        SharedPreferences.Editor r1 = r0.edit();
        r1.putInt(KEY_TTNET_CRASH_TIMES, 0);
        r1.apply();
        return;
    L28:
        return;
    L8:
        this.mTTNetCrashTimes = r0.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int r4 = r0.getInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        this.mCrashDetectTimerInterval = r4;
        if (r4 > 0) goto L12;
        this.mCrashDetectTimerInterval = 5000;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "processname is " + i.b(r12) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "processname is " + i.b(r12) + "set secure mode true");
    L19:
        r13.enableTncSecureMode(true);
    L21:
        if (i.d(r12) == true) goto L23;
        return;
    L23:
        SharedPreferences.Editor r8 = r0.edit();
        int r5 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r5;
        r8.putInt(KEY_TTNET_CRASH_TIMES, r5);
        r8.commit();
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "processname is " + i.b(r12) + " save count " + this.mTTNetCrashTimes);
    L26:
        hx5.b.a(NetworkAsyncTaskType.NETWORK).b(new 1(this, this.mCrashDetectTimerInterval, 0, r12, r8));
    }

    public ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<TTNetThreadConfig> r10, boolean r11) {
        if (r10 != null) goto L40;
    L39:
        return null;
    L40:
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L5:
        if (r10.isEmpty() == true) goto L39;
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r1 = new ArrayList();     // Catch: Exception -> L37
        EnumSet r2 = EnumSet.noneOf(TTNetThreadConfig.ThreadType.class);     // Catch: Exception -> L37
        Iterator<TTNetThreadConfig> r12 = r10.iterator();     // Catch: Exception -> L37
    L8:
        if (r12.hasNext() == false) goto L36;
        TTNetThreadConfig r3 = r12.next();     // Catch: Exception -> L37
        int r4 = r3.mThreadPriority;     // Catch: Exception -> L37
        boolean r6 = true;
        if (r4 >= (-20)) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r11 == false) goto L22;
        int r7 = r3.mThreadStackSize;     // Catch: Exception -> L37
        if (r7 < MIN_THREAD_STACK_SIZE) goto L22;
        if (r7 > MAX_THREAD_STACK_SIZE) goto L22;
    L23:
        if (r5 == true) goto L27;
        if (r6 == false) goto L8;
    L27:
        if (r2.contains(r3.mThreadType) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r8 = new TTThreadConfigInfoProvider.ThreadConfigInfo();     // Catch: Exception -> L37
        r8.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[r3.mThreadType.ordinal()]);     // Catch: Exception -> L37
        if (r5 == false) goto L32;
        r8.setThreadPriority(r3.mThreadPriority);     // Catch: Exception -> L37
    L32:
        if (r6 == false) goto L34;
        r8.setThreadStackSize(r3.mThreadStackSize);     // Catch: Exception -> L37
    L34:
        r1.add(r8);     // Catch: Exception -> L37
        r2.add(r3.mThreadType);     // Catch: Exception -> L37
    L22:
        r6 = false;
        goto L23
    L13:
        if (r4 > 19) goto L15;
        r5 = true;
        goto L16
    L36:
        return r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void preconnectUrl(String r3, Map<String, String> r4) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.preconnectUrl(r3, 1, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setBestHostWithRouteSelectionName(String r2, String r3) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.setRouteSelectionBestHost(r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void stopThrottle(String[] r2, int r3) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.stopThrottle(r2, r3);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void startThrottle(String[] r2, int r3, long r4) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.startThrottle(r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryStartNetDetect(String[] r2, int r3, int r4) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.tryStartNetDetect(r2, r3, r4);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public TTDispatchResult ttUrlDispatch(String r8, int r9, boolean r10) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L11;
        Map r11 = sCronetEngine.ttUrlDispatch(r8, r9, r10);
        String r2 = (String) r11.get("final_url");
        if (TextUtils.isEmpty(r2) == true) goto L9;
        new URL(r2).toURI();
        return new TTDispatchResult(r8, r2, (String) r11.get("epoch"), (String) r11.get("etag"), TTDispatchResult.DispatchState.SUCCESS, (String) r11.get("ttnet_origin_host"));
    L9:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L11:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void ttDnsResolve(String r2, int r3, String r4, Map<String, String> r5) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.ttDnsResolve(r2, r3, r4, r5);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void addClientOpaqueData(String[] r10, byte[] r11, byte[] r12, long r13, long r15) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        sCronetEngine.addClientOpaqueData(r10, r11, r12, r13, r15);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void enableTTBizHttpDns(boolean r9, String r10, String r11, String r12, boolean r13, String r14) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.enableTTBizHttpDns(r9, r10, r11, r12, r13, r14);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyTNCConfigUpdated(String r9, String r10, String r11, String r12, String r13, String r14) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.notifyTNCConfigUpdated(r9, r10, r11, r12, r13, r14);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r10, String r11, boolean r12, String r13, BaseHttpRequestInfo r14, ICronetAppProvider r15) throws IOException {
    L7:
        th = move-exception;
        if ((th instanceof MalformedURLException) == false) goto L11;
        throw th;
    L11:
        if ((th instanceof UnsupportedOperationException) == false) goto L19;
        if (th.getMessage() == null) goto L19;
        if (th.getMessage().contains("Unexpected protocol") == false) goto L19;
        throw new IOException("MalformedURLException", th);
    L19:
        throw new IOException(th);
    L3:
        if (TTNetInitMetrics.g().a != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r0 = TTNetInitMetrics.g();     // Catch: Throwable -> L7
        r0.a = TTNetInitMetrics.CronetInitMode.LAZY_INIT;     // Catch: Throwable -> L7
    L5:
        tryCreateCronetEngine(r10, false, false, false, r12, r13, false, r15);     // Catch: Throwable -> L7
        CronetHttpURLConnection r16 = (CronetHttpURLConnection) sCronetEngine.openConnection(new URL(r11), Proxy.NO_PROXY, r14.useCronetInputStreamWithTTBuffer);     // Catch: Throwable -> L7
        r16.setRequestFinishedListener(new h(r14));     // Catch: Throwable -> L7
        return r16;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setZstdFuncAddr(long r19, long r21, long r23, long r25, long r28, long r29, long r31, long r33) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.setZstdFuncAddr(r19, r21, r23, r25, r28, r29, r31, r33);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0287 -> B:116:0x028a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x037e -> B:161:0x0381). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x03bb -> B:180:0x03be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:198:0x03f8 -> B:199:0x03fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x020f -> B:82:0x0212). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x024b -> B:99:0x024e). Please report as a decompilation issue!!! */
    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryCreateCronetEngine(Context r18, boolean r19, boolean r20, boolean r21, boolean r22, String r23, boolean r24, ICronetAppProvider r25) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L277:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L274;
        TTNetInitMetrics.g().m = System.currentTimeMillis();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().n = System.nanoTime();     // Catch: Throwable -> L277
        if (r24 == true) goto L17;
        ICronetClient.ICronetBootFailureCheckerProvider r0 = sCronetBootFailureCheckerProvider;     // Catch: Throwable -> L277
        if (r0 == null) goto L17;
        if (r0.isCronetBootFailureExpected() == true) goto L17;
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L277
    L17:
        TTNetInitMetrics.g().o = System.nanoTime();     // Catch: Throwable -> L277
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r1 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L277
        if (r1 != null) goto L20;
    L22:
        boolean r7 = false;
    L23:
        TTNetInitMetrics.g().p = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().q = System.nanoTime();     // Catch: Throwable -> L277
        c r2 = c.h();     // Catch: Throwable -> L277
        r2.getClass();     // Catch: Throwable -> L277
    L35:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L37:
        boolean r8 = false;
    L38:
        if (r8 == false) goto L40;
        TTNetAppInfoSubset r10 = r25.getAppInfoSubset();     // Catch: Throwable -> L277
    L41:
        TTNetInitMetrics.g().r = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().s = TTNetInitMetrics.g().r;     // Catch: Throwable -> L277
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r11 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList(), r7);     // Catch: Throwable -> L277
        TTNetInitMetrics.g().t = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().u = TTNetInitMetrics.g().t;     // Catch: Throwable -> L277
        TTThreadConfigInfoProvider.Callback r12 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L277
        TTNetInitMetrics.g().v = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().w = TTNetInitMetrics.g().v;     // Catch: Throwable -> L277
        sAppID = Integer.parseInt(r25.getAppId());     // Catch: Exception -> L281 Throwable -> L277
    L43:
        TTSamplingSettingProvider.TTSlaSamplingSetting r13 = convertToCronetSlaSamplingSetting(d.a(getSlaSamplingSetting(), sAppID));     // Catch: Throwable -> L277
        TTNetInitMetrics.g().x = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().y = TTNetInitMetrics.g().x;     // Catch: Throwable -> L277
        ExperimentalCronetEngine.Builder r14 = new ExperimentalCronetEngine.Builder(r18, r8).enableQuic(r19).enableHttp2(r20).enableSdch(r21).enableHttpDns(r22).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L277
        if (d.a().loggerDebug() == false) goto L46;
        r14.enableVerboseLog();     // Catch: Throwable -> L277
    L46:
        TTNetAppInfoSubset r15 = r10;
        boolean r16 = r7;
        r14.setTTNetInitStart(Math.min(TTNetInitMetrics.g().e, TTNetInitMetrics.g().n));     // Catch: Throwable -> L277
        detectCronetColdStartCrash(r18, r14);     // Catch: Throwable -> L277
        String r6 = XmlPullParser.NO_NAMESPACE;
        String r9 = r18.getCacheDir().getPath() + "/";     // Catch: Throwable -> L58
        r14.setStoragePath(r9 + TTNET_CACHE_DIR);     // Catch: Throwable -> L55
        String r110 = r9;
        r14.enableHttpCache(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L53
        r6 = r110;
    L61:
        if (sNetworkThreadPriority >= (-20)) goto L63;
    L65:
        int r3 = getAppSecurityLevel();     // Catch: Throwable -> L277
        if (r3 <= 0) goto L68;
        r14.setAppSecurityLevel(r3);     // Catch: Throwable -> L277
    L68:
        c r4 = c.h();     // Catch: Throwable -> L277
        r4.getClass();     // Catch: Throwable -> L277
    L80:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L82:
        boolean r5 = false;
    L83:
        if (r5 == false) goto L85;
        r14.enableBrotli(true);     // Catch: Throwable -> L277
    L85:
        c r17 = c.h();     // Catch: Throwable -> L277
        r17.getClass();     // Catch: Throwable -> L277
    L97:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L99:
        boolean r26 = false;
    L100:
        if (r26 == false) goto L102;
        r14.enableQuic(true);     // Catch: Throwable -> L277
    L102:
        c r28 = c.h();     // Catch: Throwable -> L277
        r28.getClass();     // Catch: Throwable -> L277
    L114:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L116:
        boolean r29 = false;
    L117:
        if (r29 == false) goto L119;
        r14.enableHttp2(true);     // Catch: Throwable -> L277
    L119:
        TTAppSecurityManager.getInstance().setSystemApiSandbox(f.a());     // Catch: Throwable -> L277
        r14.setAppInfoProvider(a.b(r18));     // Catch: Throwable -> L277
        r14.setEventListener(e.a());     // Catch: Throwable -> L277
        r14.setIsMainProcess(i.d(r18));     // Catch: Throwable -> L277
        r14.setProcessName(i.b(r18));     // Catch: Throwable -> L277
        if (i.d(r18) == false) goto L122;
        r14.setAppMonitorProvider(b.a());     // Catch: Throwable -> L277
        e.a().a = true;     // Catch: Throwable -> L277
    L122:
        if (r8 == false) goto L124;
        r14.setTTAppInfoColdStartSubset(convertToCronetAppInfo(r15));     // Catch: Throwable -> L277
    L124:
        r14.setOptInit(r8);     // Catch: Throwable -> L277
        r14.setOptNqeInit(r25.getOptNqeDefault(), r25.getOptNqePersist());     // Catch: Throwable -> L277
        r14.setThreadConfigInfoList(r11);     // Catch: Throwable -> L277
        r14.setThreadConfigCallbackImpl(r12);     // Catch: Throwable -> L277
        r14.setLazyInitIPC(r25.getLazyInitCronetIPC());     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r23) == true) goto L127;
        r14.setUserAgent(r23 + " cronet/TTNetVersion:c32625e6 2026-09-09 QuicVersion:6a5515bf 2026-09-09");     // Catch: Throwable -> L277
    L127:
        String r30 = getDomainConfigByRegion();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r30) == false) goto L145;
        c r31 = c.h();     // Catch: Throwable -> L277
        r31.getClass();     // Catch: Throwable -> L277
    L141:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L143:
        r30 = null;
        goto L145
    L131:
        if (NetworkParams.getOptReflection() == false) goto L136;
        ICronetAppProvider r32 = r31.b;     // Catch: Throwable -> L141
        if (r32 == null) goto L143;
        r30 = r32.getGetDomainDefaultJSON();     // Catch: Throwable -> L141
    L282:
    L136:
        Object r33 = r31.a;     // Catch: Throwable -> L141
        if (r33 == null) goto L143;
        r30 = (String) a.b(r33).call("getGetDomainDefaultJSON").get();     // Catch: Throwable -> L141
    L145:
        if (TextUtils.isEmpty(r30) == true) goto L147;
        r14.setGetDomainDefaultJSON(r30);     // Catch: Throwable -> L277
    L147:
        c r34 = c.h();     // Catch: Throwable -> L277
        r34.getClass();     // Catch: Throwable -> L277
    L159:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L161:
        ArrayList<byte[]> r35 = null;
    L162:
        if (r35 != null) goto L164;
    L166:
        c r36 = c.h();     // Catch: Throwable -> L277
        r36.getClass();     // Catch: Throwable -> L277
    L178:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L180:
        Map<String[], Pair<byte[], byte[]>> r37 = null;
    L181:
        if (r37 != null) goto L183;
    L185:
        c r38 = c.h();     // Catch: Throwable -> L277
        r38.getClass();     // Catch: Throwable -> L277
    L197:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L199:
        Map<String, Pair<Integer, Integer>> r39 = null;
    L200:
        if (r39 == null) goto L208;
    L202:
        if (r39.isEmpty() == true) goto L208;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r40 = r39.entrySet().iterator();     // Catch: Throwable -> L277
    L205:
        if (r40.hasNext() == false) goto L208;
        Map.Entry<String, Pair<Integer, Integer>> r41 = r40.next();     // Catch: Throwable -> L277
        r14.addQuicHint(r41.getKey(), ((Integer) r41.getValue().first).intValue(), ((Integer) r41.getValue().second).intValue());     // Catch: Throwable -> L277
    L208:
        if (c.h().j() == false) goto L210;
        r14.setLibraryLoader(new 3(this));     // Catch: Throwable -> L277
    L210:
        String r42 = c.h().c();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r42) == true) goto L215;
        String r43 = File.separator;     // Catch: Throwable -> L277
        String r44 = r42.substring(r42.lastIndexOf(r43) + 1);     // Catch: Throwable -> L277
        String r45 = r18.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L277
        if (FileUtils.copyFile(r42, r45, r44) == false) goto L215;
        r14.setCronetSoPath(r45 + r43 + r44);     // Catch: Throwable -> L277
    L215:
        boolean r46 = c.h().i();     // Catch: Throwable -> L277
        if (r46 == false) goto L218;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L277
    L218:
        if (r46 == true) goto L230;
        String r47 = com.bytedance.frameworks.baselib.network.http.util.c.a(r18);     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r47) == true) goto L230;
        JSONObject r48 = new JSONObject(r47);     // Catch: Throwable -> L228
        String r49 = r48.optString("ttnet_proxy", XmlPullParser.NO_NAMESPACE);     // Catch: Throwable -> L228
        if (TextUtils.isEmpty(r49) == true) goto L224;
        r14.setProxyConfig(r49);     // Catch: Throwable -> L228
    L224:
        r46 = r48.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L228
        if (r46 == false) goto L230;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L228
    L228:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L230:
        if (r46 == true) goto L234;
        r46 = com.bytedance.frameworks.baselib.network.http.util.c.b(r18);     // Catch: Throwable -> L277
        if (r46 == false) goto L234;
        r14.enableBoeProxy(true);     // Catch: Throwable -> L277
    L234:
        if (r46 == false) goto L241;
        String r50 = c.h().b();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r50) == true) goto L238;
        r14.setBypassBOEJSON(r50);     // Catch: Throwable -> L277
    L238:
        String r51 = getProxyConfig(r6);     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r51) == true) goto L241;
        r14.setProxyConfig(r51);     // Catch: Throwable -> L277
    L241:
        String r52 = c.h().d();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r52) == true) goto L297;
        r14.setStoreIdcRuleJSON(r52);     // Catch: Throwable -> L277
    L297:
        long r53 = getALogFuncAddr();     // Catch: Exception -> L248 Throwable -> L277
        if (r53 == 0) goto L250;
        r14.setALogFuncAddr(r53);     // Catch: Exception -> L248 Throwable -> L277
    L250:
        if (r13 == null) goto L252;
        r14.setSlaSamplingSetting(r13);     // Catch: Throwable -> L277
    L252:
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r54 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L277
        if (r54 != null) goto L255;
        String r55 = null;
    L256:
        r14.setStackInfo(r16, r55);     // Catch: Throwable -> L277
        r14.setTelemetryOptionFlags(getTelemetryOptionFlags());     // Catch: Throwable -> L277
        TTNetInitMetrics.g().z = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().A = TTNetInitMetrics.g().z;     // Catch: Throwable -> L277
        sCronetEngine = r14.build();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().B = System.nanoTime();     // Catch: Throwable -> L277
        if (d.a().loggerDebug() == false) goto L259;
        Logger.setLogLevel(2);     // Catch: Throwable -> L277
    L261:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L274;
        ExperimentalCronetEngine r56 = sCronetEngine;     // Catch: Throwable -> L277
        long r57 = getALogFuncAddr();     // Catch: Throwable -> L272
        if (r57 == 0) goto L266;
        r56.setAlogFuncAddr(r57);     // Catch: Throwable -> L272
    L266:
        int r58 = TTAppStateManager.getAppStartUpState();     // Catch: Throwable -> L272
        if (r58 < 0) goto L270;
        if (r58 > 2) goto L270;
        r56.setAppStartUpState(r58);     // Catch: Throwable -> L272
    L270:
        TTNetInitMetrics.g().f(r18, r56.getOpaqueFuncAddress());     // Catch: Throwable -> L272
    L272:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
        goto L274
    L259:
        Logger.setLogLevel(4);     // Catch: Throwable -> L277
        goto L261
    L255:
        r55 = r54.getThreadStackInitReason();     // Catch: Throwable -> L277
    L248:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L277
        goto L250
    L187:
        if (NetworkParams.getOptReflection() == false) goto L192;
        ICronetAppProvider r59 = r38.b;     // Catch: Throwable -> L197
        if (r59 == null) goto L199;
        r39 = r59.getQuicHint();     // Catch: Throwable -> L197
        goto L200
    L192:
        Object r60 = r38.a;     // Catch: Throwable -> L197
        if (r60 == null) goto L199;
        r39 = (Map) a.b(r60).call("getQuicHint").get();     // Catch: Throwable -> L197
        goto L200
    L183:
        if (r37.isEmpty() == true) goto L185;
        r14.setClientOpaqueData(r37);     // Catch: Throwable -> L277
        goto L185
    L168:
        if (NetworkParams.getOptReflection() == false) goto L173;
        ICronetAppProvider r61 = r36.b;     // Catch: Throwable -> L178
        if (r61 == null) goto L180;
        r37 = r61.getClientOpaqueData();     // Catch: Throwable -> L178
        goto L181
    L173:
        Object r62 = r36.a;     // Catch: Throwable -> L178
        if (r62 == null) goto L180;
        r37 = (Map) a.b(r62).call("getClientOpaqueData").get();     // Catch: Throwable -> L178
        goto L181
    L164:
        if (r35.isEmpty() == true) goto L166;
        r14.setOpaqueData(r35);     // Catch: Throwable -> L277
        goto L166
    L149:
        if (NetworkParams.getOptReflection() == false) goto L154;
        ICronetAppProvider r63 = r34.b;     // Catch: Throwable -> L159
        if (r63 == null) goto L161;
        r35 = r63.getOpaqueData();     // Catch: Throwable -> L159
        goto L162
    L154:
        Object r64 = r34.a;     // Catch: Throwable -> L159
        if (r64 == null) goto L161;
        r35 = (ArrayList) a.b(r64).call("getOpaqueData").get();     // Catch: Throwable -> L159
        goto L162
    L104:
        if (NetworkParams.getOptReflection() == false) goto L109;
        ICronetAppProvider r65 = r28.b;     // Catch: Throwable -> L114
        if (r65 == null) goto L116;
        r29 = r65.isEnableHttp2();     // Catch: Throwable -> L114
        goto L117
    L109:
        Object r66 = r28.a;     // Catch: Throwable -> L114
        if (r66 == null) goto L116;
        r29 = ((Boolean) a.b(r66).call("isEnableHttp2").get()).booleanValue();     // Catch: Throwable -> L114
        goto L117
    L87:
        if (NetworkParams.getOptReflection() == false) goto L92;
        ICronetAppProvider r67 = r17.b;     // Catch: Throwable -> L97
        if (r67 == null) goto L99;
        r26 = r67.isEnableQuic();     // Catch: Throwable -> L97
        goto L100
    L92:
        Object r68 = r17.a;     // Catch: Throwable -> L97
        if (r68 == null) goto L99;
        r26 = ((Boolean) a.b(r68).call("isEnableQuic").get()).booleanValue();     // Catch: Throwable -> L97
        goto L100
    L70:
        if (NetworkParams.getOptReflection() == false) goto L75;
        ICronetAppProvider r69 = r4.b;     // Catch: Throwable -> L80
        if (r69 == null) goto L82;
        r5 = r69.isEnableBrotli();     // Catch: Throwable -> L80
        goto L83
    L75:
        Object r70 = r4.a;     // Catch: Throwable -> L80
        if (r70 == null) goto L82;
        r5 = ((Boolean) a.b(r70).call("isEnableBrotli").get()).booleanValue();     // Catch: Throwable -> L80
        goto L83
    L63:
        if (sNetworkThreadPriority > 19) goto L65;
        r14.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L277
    L53:
        th = th;
    L57:
        r6 = r110;
    L59:
        th.printStackTrace();     // Catch: Throwable -> L277
        r14.enableHttpCache(0, 0);     // Catch: Throwable -> L277
    L55:
        th = th;
        r110 = r9;
    L58:
        th = th;
        goto L59
    L40:
        r10 = null;
        goto L41
    L25:
        if (NetworkParams.getOptReflection() == false) goto L30;
        ICronetAppProvider r71 = r2.b;     // Catch: Throwable -> L35
        if (r71 == null) goto L37;
        boolean r72 = r71.getOptInit();     // Catch: Throwable -> L35
    L34:
        r8 = r72;
        goto L38
    L30:
        Object r73 = r2.a;     // Catch: Throwable -> L35
        if (r73 == null) goto L37;
        r72 = ((Boolean) a.b(r73).call("getOptInit").get()).booleanValue();     // Catch: Throwable -> L35
        goto L34
    L20:
        if (r1.isCronetThreadStackOptFailureExpected() == false) goto L22;
        r7 = true;
    L274:
        TTRequestCompressManager.setCompressDataCallback(new AnonymousClass4(this));     // Catch: Throwable -> L277
        TTNetInitMetrics.g().E = System.nanoTime();     // Catch: Throwable -> L277
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L277
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyStoreRegionUpdated(String r14, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        sCronetEngine.updateStoreRegionFromServer(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }
}
