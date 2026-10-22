package org.chromium;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.utility.io.FileUtils;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ConstantsDefined;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTAppStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetAppInfoSubset;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.TTDispatchResult;
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
import com.ttnet.org.chromium.net.TTNetVersion;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.impl.CronetUrlRequest;
import com.ttnet.org.chromium.net.impl.CronetUrlRequestMapping;
import com.ttnet.org.chromium.net.impl.URLDispatch;
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

/* JADX INFO: loaded from: classes.dex */
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

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public String getCronetVersion() {
        return TTNetVersion.VERSION;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHttpDnsForTesting(boolean r100, boolean r101, boolean r102) throws Exception {
    }

    private static long getALogFuncAddr() throws Exception {
        return ((Long) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_ALOG_CLASS).newInstance()).call("getALogFuncAddr").get()).longValue();
    }

    private static int getAppSecurityLevel() {
        return ((Integer) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getAppSecurityLevel").get()).intValue();
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
        return ((Boolean) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getListenAppStateIndependently").get()).booleanValue();
    L4:
        return false;
    }

    private static long getMaxHttpDiskCacheSize() {
        return ((Long) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getMaxHttpDiskCacheSize").get()).longValue();
    L4:
        return 67108864;
    }

    private static JSONObject getSlaSamplingSetting() {
        return (JSONObject) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getSlaSamplingSetting").get();
    L4:
        return null;
    }

    private static int getTelemetryOptionFlags() {
        return ((Integer) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getTelemetryOptionFlags").get()).intValue();
    L4:
        return 0;
    }

    private static TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        return (TTNetThreadConfig.Callback) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigCallbackImpl").get();
    L4:
        return null;
    }

    private static ArrayList<TTNetThreadConfig> getThreadConfigInfoList() {
        return (ArrayList) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getThreadConfigInfoList").get();
    L4:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveConnectionType() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveConnectionType();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveHttpRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveHttpRtt();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveRxThroughputKbps() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveRxThroughput();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getEffectiveTransportRttMs() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getEffectiveTransportRtt();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public Map<String, NetworkQuality> getGroupRttEstimates() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ExperimentalCronetEngine r100 = (ExperimentalCronetEngine) sCronetEngine;
        HashMap r101 = new HashMap();
        Iterator<Map.Entry<String, int[]>> r102 = r100.getGroupRttEstimates().entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, int[]> r103 = r102.next();
        if (r103.getValue().length != 2) goto L11;
        NetworkQuality r104 = new NetworkQuality();
        r104.transportRttMs = r103.getValue()[0];
        r104.httpRttMs = r103.getValue()[1];
        r104.downstreamThroughputKbps = -1;
        r101.put(r103.getKey(), r104);
        goto L6
    L11:
        throw new UnknownFormatConversionException("getGroupRttEstimates returns wrong format");
    L12:
        return r101;
    L14:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public NetworkQuality getNetworkQuality() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ExperimentalCronetEngine r100 = (ExperimentalCronetEngine) sCronetEngine;
        NetworkQuality r101 = new NetworkQuality();
        r101.transportRttMs = r100.getTransportRttMs();
        r101.httpRttMs = r100.getHttpRttMs();
        r101.downstreamThroughputKbps = r100.getDownstreamThroughputKbps();
        return r101;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getNetworkQualityLevel() throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        return ((ExperimentalCronetEngine) sCronetEngine).getNetworkQualityLevel();
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCookieInitCompleted() {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setCookieInitCompleted();
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public CronetClient() {
        this.mCrashLimitTimes = 0;
        this.mCrashDetectTimerInterval = 5000;
    }

    private static String getDomainConfigByRegion() {
        c r100 = c.h();
        r100.getClass();
        String r101 = "";
        if (NetworkParams.getOptReflection() == false) goto L8;
        ICronetAppProvider r102 = r100.f525635b;
        if (r102 != null) goto L7;
        String r103 = "";
    L9:
        c r104 = c.h();
        r104.getClass();
        if (NetworkParams.getOptReflection() == false) goto L15;
        ICronetAppProvider r105 = r104.f525635b;
        if (r105 != null) goto L14;
        String r106 = "";
    L16:
        c r107 = c.h();
        r107.getClass();
        if (NetworkParams.getOptReflection() == false) goto L22;
        ICronetAppProvider r108 = r107.f525635b;
        if (r108 == null) goto L24;
        r101 = r108.getRegion();
    L24:
        if (TextUtils.isEmpty(r103) == false) goto L31;
        if (TextUtils.isEmpty(r106) == true) goto L29;
        r103 = r106;
        goto L31
    L29:
        r103 = r101;
    L31:
        if (TextUtils.isEmpty(r103) == false) goto L36;
        return null;
    L36:
        return (String) yx5.a.b(INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("getGetDomainConfigByRegion", new Class[]{String.class}, new Object[]{r103}).get();
    L35:
        return null;
    L22:
        r101 = r107.e("getRegion");
        goto L24
    L14:
        r106 = r105.getSysRegion();
        goto L16
    L15:
        r106 = r104.e("getSysRegion");
        goto L16
    L7:
        r103 = r102.getCarrierRegion();
        goto L9
    L8:
        r103 = r100.e("getCarrierRegion");
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
        ((ExperimentalCronetEngine) sCronetEngine).clearClientOpaqueData();     // Catch: Throwable -> L9
        return;
    }

    @JvmStatic
    public static void INVOKESTATIC_org_chromium_CronetClient_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_org_chromium_CronetClient_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
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

    private TTAppInfoProvider.AppInfo convertToCronetAppInfo(TTNetAppInfoSubset r100) {
        TTAppInfoProvider.AppInfo r101 = new TTAppInfoProvider.AppInfo();
        r101.setAbSdkVersion(r100.mAbSdkVersion);
        r101.setHostFirst(r100.mHostFirst);
        r101.setHostSecond(r100.mHostSecond);
        r101.setHostThird(r100.mHostThird);
        r101.setDomainHttpDns(r100.mDomainHttpDns);
        r101.setDomainBoe(r100.mDomainBoe);
        r101.setDomainBoeHttps(r100.mDomainBoeHttps);
        r101.setInitRegion(r100.mInitRegion);
        return r101;
    }

    private static TTSamplingSettingProvider.TTSlaSamplingSetting convertToCronetSlaSamplingSetting(wx5.c r100) {
        if (r100 != null) goto L19;
        return null;
    L19:
        wx5.b r101 = r100.f561831c;     // Catch: Exception -> L8
        if (r101 == null) goto L10;
        TTSamplingSettingProvider.TTSlaSamplingRule r102 = new TTSamplingSettingProvider.TTSlaSamplingRule();     // Catch: Exception -> L8
        r102.mEnableBaseApiAll = r101.f561820a;     // Catch: Exception -> L8
        r102.mEnableApiAllUpload = r101.f561821b;     // Catch: Exception -> L8
        r102.mUrlRegexBlackList = r101.f561822c;     // Catch: Exception -> L8
        r102.mPathEqualWhiteList = r101.f561823d;     // Catch: Exception -> L8
        r102.mPathPrefixWhiteList = r101.f561825f;     // Catch: Exception -> L8
        r102.mPathContainWhiteList = r101.f561824e;     // Catch: Exception -> L8
        r102.mPathRegexWhiteList = r101.f561826g;     // Catch: Exception -> L8
        r102.mHostPatternWhiteList = r101.f561828i;     // Catch: Exception -> L8
        r102.mUrlRegexWhiteList = r101.f561827h;     // Catch: Exception -> L8
    L11:
        wx5.a r103 = r100.f561832d;     // Catch: Exception -> L8
        if (r103 == null) goto L14;
        TTSamplingSettingProvider.TTEventLogSamplingRule r104 = new TTSamplingSettingProvider.TTEventLogSamplingRule();     // Catch: Exception -> L8
        r104.mEventLogTypeWhiteList = r103.f561819a;     // Catch: Exception -> L8
    L15:
        TTSamplingSettingProvider.TTSlaSamplingSetting r105 = new TTSamplingSettingProvider.TTSlaSamplingSetting();     // Catch: Exception -> L8
        r105.mHostAid = r100.f561829a;     // Catch: Exception -> L8
        r105.mSdkAid = r100.f561830b;     // Catch: Exception -> L8
        r105.mSlaSamplingRule = r102;     // Catch: Exception -> L8
        r105.mEventLogSamplingRule = r104;     // Catch: Exception -> L8
        return r105;
    L14:
        r104 = null;
        goto L15
    L10:
        r102 = null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private String getProxyConfig(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == true) goto L34;
        BufferedReader r102 = null;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100 + TTNET_CONFIG_FILE);     // Catch: Throwable -> L21
        if (r103.exists() == false) goto L16;
        BufferedReader r104 = new BufferedReader(new PolarisFileReaderWrapper(r103));     // Catch: Throwable -> L21
        StringBuilder r105 = new StringBuilder();     // Catch: Throwable -> L14
    L9:
        String r106 = r104.readLine();     // Catch: Throwable -> L14
        if (r106 == null) goto L12;
        r105.append(r106);     // Catch: Throwable -> L14
        goto L9
    L12:
        r101 = new JSONObject(r105.toString()).optString("ttnet_proxy", "");     // Catch: Throwable -> L14
        r102 = r104;
    L14:
        Throwable th10 = th;
    L42:
        th10.printStackTrace();     // Catch: Throwable -> L27
        if (r104 == null) goto L34;
        r104.close();     // Catch: IOException -> L19
    L37:
    L27:
        th = move-exception;
        if (r104 != null) goto L40;
    L33:
        throw th;
    L40:
        r104.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        e.printStackTrace();
    L16:
        if (r102 == null) goto L34;
        r102.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
    L21:
        th = move-exception;
        th10 = th;
        r104 = null;
    L34:
        return r101;
    }

    public static void setNetworkThreadPriority(int r100) {
        sNetworkThreadPriority = r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindBigCore(TTNetThreadConfig.ThreadType r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindBigCore(r100.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void bindLittleCore(TTNetThreadConfig.ThreadType r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).bindLittleCore(r100.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    public TTThreadConfigInfoProvider.Callback convertToCronetThreadConfigCallback(final TTNetThreadConfig.Callback r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return new AnonymousClass2(this, r100);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public int getCronetInternalErrorCode(HttpURLConnection r100) {
    L8:
        return 0;
    L4:
        if ((r100 instanceof CronetHttpURLConnection) == true) goto L6;
        return 0;
    L6:
        return ((CronetHttpURLConnection) r100).getCronetInternalErrorCode();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void getMappingRequestState(final String r100) {
        CronetUrlRequest r101 = CronetUrlRequestMapping.GetRequest(r100);     // Catch: Throwable -> L6
        if (r101 == null) goto L11;
        r101.getStatus(new AnonymousClass5(this, r100));     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public PacketLossMetrics getPacketLossRateMetrics(int r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        PacketLossMetrics r101 = new PacketLossMetrics();
        ExperimentalCronetEngine r102 = (ExperimentalCronetEngine) sCronetEngine;
        r101.protocol = r100;
        r101.upstreamLossRate = r102.getUpstreamPacketLossRate(r100);
        r101.upstreamLossRateVariance = r102.getUpstreamPacketLossRateVariance(r100);
        r101.downstreamLossRate = r102.getDownstreamPacketLossRate(r100);
        r101.downstreamLossRateVariance = r102.getDownstreamPacketLossRateVariance(r100);
        return r101;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public boolean isCronetHttpURLConnection(HttpURLConnection r100) {
        return r100 instanceof CronetHttpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void removeClientOpaqueData(String r100) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "removeClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).removeClientOpaqueData(r100);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void reportNetDiagnosisUserLog(String r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).reportNetDiagnosisUserLog(r100);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void resetCoreBind(TTNetThreadConfig.ThreadType r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).resetCoreBind(r100.ordinal());
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void runInBackGround(boolean r100) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "runInBackGround start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).runInBackGround(r100);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAlogFuncAddr(long r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAlogFuncAddr(r100);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setAppStartUpState(int r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setAppStartUpState(r100);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetBootFailureCheckerProvider(ICronetClient.ICronetBootFailureCheckerProvider r100) {
        sCronetBootFailureCheckerProvider = r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setCronetThreadStackOptFailureCheckerProvider(ICronetClient.ICronetThreadStackOptFailureCheckerProvider r100) {
        sCronetThreadStackOptFailureCheckerProvider = r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setHostResolverRules(String r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setHostResolverRules(r100);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setProxy(String r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setProxy(r100);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setSlaSamplingSetting(JSONObject r100) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L20;
        if (sAppID > 0) goto L14;
        c r101 = c.h();
        r101.getClass();
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r102 = r101.f525635b;
        if (r102 != null) goto L11;
        String r103 = "";
    L13:
        sAppID = CastIntegerProtector.parseInt(r103);
        goto L14
    L11:
        r103 = r102.getAppId();
        goto L13
    L12:
        r103 = r101.e("getAppId");
    L14:
        TTSamplingSettingProvider.TTSlaSamplingSetting r104 = convertToCronetSlaSamplingSetting(wx5.d.a(r100, sAppID));
        if (r104 != null) goto L17;
        return;
    L17:
        ((ExperimentalCronetEngine) sCronetEngine).addSamplingSetting(r104);
        return;
    L20:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void triggerGetDomain(boolean r100) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "triggerGetDomain start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).triggerGetDomain(r100);     // Catch: Throwable -> L9
        return;
    }

    private void detectCronetColdStartCrash(final Context r110, ExperimentalCronetEngine.Builder r111) {
        SharedPreferences r100 = r110.getSharedPreferences(SP_SS_APP_CONFIG, 0);
        int r101 = r100.getInt(KEY_CRASH_LIMIT_TIMES, 0);
        this.mCrashLimitTimes = r101;
        if (r101 > 0) goto L8;
        int r102 = r100.getInt(KEY_TTNET_CRASH_TIMES, 0);
        this.mTTNetCrashTimes = r102;
        if (r102 <= 0) goto L28;
        SharedPreferences.Editor r103 = r100.edit();
        r103.putInt(KEY_TTNET_CRASH_TIMES, 0);
        r103.apply();
        return;
    L28:
        return;
    L8:
        this.mTTNetCrashTimes = r100.getInt(KEY_TTNET_CRASH_TIMES, 0);
        int r104 = r100.getInt(KEY_CRASH_DETECT_INTERVAL_MS, 5000);
        this.mCrashDetectTimerInterval = r104;
        if (r104 > 0) goto L12;
        this.mCrashDetectTimerInterval = 5000;
    L12:
        if (Logger.debug() == false) goto L15;
        Logger.d(TAG, "processname is " + com.bytedance.frameworks.baselib.network.http.util.i.b(r110) + " count is " + this.mTTNetCrashTimes + " limit is " + this.mCrashLimitTimes + " interval is " + this.mCrashDetectTimerInterval);
    L15:
        if (this.mTTNetCrashTimes < this.mCrashLimitTimes) goto L21;
        if (Logger.debug() == false) goto L19;
        Logger.d(TAG, "processname is " + com.bytedance.frameworks.baselib.network.http.util.i.b(r110) + "set secure mode true");
    L19:
        r111.enableTncSecureMode(true);
    L21:
        if (com.bytedance.frameworks.baselib.network.http.util.i.d(r110) == true) goto L23;
        return;
    L23:
        final SharedPreferences.Editor r105 = r100.edit();
        int r106 = this.mTTNetCrashTimes + 1;
        this.mTTNetCrashTimes = r106;
        r105.putInt(KEY_TTNET_CRASH_TIMES, r106);
        r105.commit();
        if (Logger.debug() == false) goto L26;
        Logger.d(TAG, "processname is " + com.bytedance.frameworks.baselib.network.http.util.i.b(r110) + " save count " + this.mTTNetCrashTimes);
    L26:
        hx5.b r107 = hx5.b.a(NetworkAsyncTaskType.NETWORK);
        final long r108 = this.mCrashDetectTimerInterval;
        final long r109 = 0;
        r107.b(new AnonymousClass1(this, r108, r109, r110, r105));
    }

    public ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> convertToCronetThreadConfigInfoList(ArrayList<TTNetThreadConfig> r110, boolean r111) {
        if (r110 != null) goto L40;
    L39:
        return null;
    L40:
    L37:
        e = move-exception;
        e.printStackTrace();
        goto L39
    L5:
        if (r110.isEmpty() == true) goto L39;
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r100 = new ArrayList();     // Catch: Exception -> L37
        EnumSet r101 = EnumSet.noneOf(TTNetThreadConfig.ThreadType.class);     // Catch: Exception -> L37
        Iterator<TTNetThreadConfig> r112 = r110.iterator();     // Catch: Exception -> L37
    L8:
        if (r112.hasNext() == false) goto L36;
        TTNetThreadConfig r102 = r112.next();     // Catch: Exception -> L37
        int r103 = r102.mThreadPriority;     // Catch: Exception -> L37
        boolean r104 = true;
        if (r103 >= (-20)) goto L13;
    L15:
        boolean r105 = false;
    L16:
        if (r111 == false) goto L22;
        int r106 = r102.mThreadStackSize;     // Catch: Exception -> L37
        if (r106 < MIN_THREAD_STACK_SIZE) goto L22;
        if (r106 > 5242880) goto L22;
    L23:
        if (r105 == true) goto L27;
        if (r104 == false) goto L8;
    L27:
        if (r101.contains(r102.mThreadType) == true) goto L8;
        TTThreadConfigInfoProvider.ThreadConfigInfo r107 = new TTThreadConfigInfoProvider.ThreadConfigInfo();     // Catch: Exception -> L37
        r107.setThreadType(TTThreadConfigInfoProvider.ThreadType.values()[r102.mThreadType.ordinal()]);     // Catch: Exception -> L37
        if (r105 == false) goto L32;
        r107.setThreadPriority(r102.mThreadPriority);     // Catch: Exception -> L37
    L32:
        if (r104 == false) goto L34;
        r107.setThreadStackSize(r102.mThreadStackSize);     // Catch: Exception -> L37
    L34:
        r100.add(r107);     // Catch: Exception -> L37
        r101.add(r102.mThreadType);     // Catch: Exception -> L37
    L22:
        r104 = false;
        goto L23
    L13:
        if (r103 > 19) goto L15;
        r105 = true;
        goto L16
    L36:
        return r100;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void preconnectUrl(String r100, Map<String, String> r101) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).preconnectUrl(r100, 1, r101);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setBestHostWithRouteSelectionName(String r100, String r101) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setRouteSelectionBestHost(r100, r101);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void stopThrottle(String[] r100, int r101) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).stopThrottle(r100, r101);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void startThrottle(String[] r100, int r101, long r102) {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).startThrottle(r100, r101, r102);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryStartNetDetect(String[] r100, int r101, int r102) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).tryStartNetDetect(r100, r101, r102);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public TTDispatchResult ttUrlDispatch(String r100, int r101, boolean r110) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L11;
        Map<String, String> r102 = ((ExperimentalCronetEngine) sCronetEngine).ttUrlDispatch(r100, r101, r110);
        String r103 = r102.get(URLDispatch.KEY_FINAL_URL);
        if (TextUtils.isEmpty(r103) == true) goto L9;
        new URL(r103).toURI();
        return new TTDispatchResult(r100, r103, r102.get(URLDispatch.KEY_EPOCH), r102.get(URLDispatch.KEY_ETAG), TTDispatchResult.DispatchState.SUCCESS, r102.get(URLDispatch.KEY_TTNET_ORIGIN_HOST));
    L9:
        throw new UnknownFormatConversionException("ttUrlDispatch returns wrong format");
    L11:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void ttDnsResolve(String r100, int r101, String r102, Map<String, String> r103) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).ttDnsResolve(r100, r101, r102, r103);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void addClientOpaqueData(String[] r110, byte[] r111, byte[] r112, long r113, long r114) {
    L9:
        th = move-exception;
        th.printStackTrace();
        return;
    L3:
        if (d.a().loggerDebug() == false) goto L6;
        d.a().loggerD(TAG, "addClientOpaqueData start");     // Catch: Throwable -> L9
    L6:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L14;
        ((ExperimentalCronetEngine) sCronetEngine).addClientOpaqueData(r110, r111, r112, r113, r114);     // Catch: Throwable -> L9
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void enableTTBizHttpDns(boolean r100, String r110, String r111, String r112, boolean r113, String r114) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).enableTTBizHttpDns(r100, r110, r111, r112, r113, r114);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyTNCConfigUpdated(String r100, String r110, String r111, String r112, String r113, String r114) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).notifyTNCConfigUpdated(r100, r110, r111, r112, r113, r114);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public HttpURLConnection openConnection(Context r110, String r111, boolean r112, String r113, BaseHttpRequestInfo r114, ICronetAppProvider r115) throws IOException {
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
        if (TTNetInitMetrics.g().f244605a != TTNetInitMetrics.CronetInitMode.NONE) goto L5;
        TTNetInitMetrics r100 = TTNetInitMetrics.g();     // Catch: Throwable -> L7
        r100.f244605a = TTNetInitMetrics.CronetInitMode.LAZY_INIT;     // Catch: Throwable -> L7
    L5:
        tryCreateCronetEngine(r110, false, false, false, r112, r113, false, r115);     // Catch: Throwable -> L7
        CronetHttpURLConnection r116 = (CronetHttpURLConnection) sCronetEngine.openConnection(new URL(r111), Proxy.NO_PROXY, r114.useCronetInputStreamWithTTBuffer);     // Catch: Throwable -> L7
        r116.setRequestFinishedListener(new h(r114));     // Catch: Throwable -> L7
        return r116;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void setZstdFuncAddr(long r110, long r210, long r211, long r212, long r213, long r214, long r310, long r311) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).setZstdFuncAddr(r110, r210, r211, r212, r213, r214, r310, r311);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:115:0x0287 -> B:116:0x028a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x037e -> B:161:0x0381). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:179:0x03bb -> B:180:0x03be). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:198:0x03f8 -> B:199:0x03fb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x020f -> B:82:0x0212). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x024b -> B:99:0x024e). Please report as a decompilation issue!!! */
    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void tryCreateCronetEngine(Context r110, boolean r111, boolean r210, boolean r211, boolean r212, String r213, boolean r214, ICronetAppProvider r215) {
        if (sCronetEngine == null) goto L5;
        return;
    L5:
        monitor-enter(CronetClient.class);
    L277:
        th = move-exception;
        throw th;
    L7:
        if (sCronetEngine != null) goto L274;
        TTNetInitMetrics.g().f244619m = System.currentTimeMillis();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244620n = System.nanoTime();     // Catch: Throwable -> L277
        if (r214 == true) goto L17;
        ICronetClient.ICronetBootFailureCheckerProvider r100 = sCronetBootFailureCheckerProvider;     // Catch: Throwable -> L277
        if (r100 == null) goto L17;
        if (r100.isCronetBootFailureExpected() == true) goto L17;
        throw new IllegalArgumentException("isCronetBootFailureExpected return false.");     // Catch: Throwable -> L277
    L17:
        TTNetInitMetrics.g().f244621o = System.nanoTime();     // Catch: Throwable -> L277
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r101 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L277
        if (r101 != null) goto L20;
    L22:
        boolean r102 = false;
    L23:
        TTNetInitMetrics.g().f244622p = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244623q = System.nanoTime();     // Catch: Throwable -> L277
        c r103 = c.h();     // Catch: Throwable -> L277
        r103.getClass();     // Catch: Throwable -> L277
    L35:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L37:
        boolean r104 = false;
    L38:
        if (r104 == false) goto L40;
        TTNetAppInfoSubset r112 = r215.getAppInfoSubset();     // Catch: Throwable -> L277
    L41:
        TTNetInitMetrics.g().f244624r = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244625s = TTNetInitMetrics.g().f244624r;     // Catch: Throwable -> L277
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r113 = convertToCronetThreadConfigInfoList(getThreadConfigInfoList(), r102);     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244626t = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244627u = TTNetInitMetrics.g().f244626t;     // Catch: Throwable -> L277
        TTThreadConfigInfoProvider.Callback r114 = convertToCronetThreadConfigCallback(getThreadConfigCallbackImpl());     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244628v = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244629w = TTNetInitMetrics.g().f244628v;     // Catch: Throwable -> L277
        sAppID = Integer.parseInt(r215.getAppId());     // Catch: Exception -> L281 Throwable -> L277
    L43:
        TTSamplingSettingProvider.TTSlaSamplingSetting r115 = convertToCronetSlaSamplingSetting(wx5.d.a(getSlaSamplingSetting(), sAppID));     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244630x = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244631y = TTNetInitMetrics.g().f244630x;     // Catch: Throwable -> L277
        ExperimentalCronetEngine.Builder r116 = new ExperimentalCronetEngine.Builder(r110, r104).enableQuic(r111).enableHttp2(r210).enableSdch(r211).enableHttpDns(r212).listenAppStateIndependently(getListenAppStateIndependently()).enableNetworkQualityEstimator(true);     // Catch: Throwable -> L277
        if (d.a().loggerDebug() == false) goto L46;
        r116.enableVerboseLog();     // Catch: Throwable -> L277
    L46:
        TTNetAppInfoSubset r117 = r112;
        boolean r118 = r102;
        r116.setTTNetInitStart(Math.min(TTNetInitMetrics.g().f244611e, TTNetInitMetrics.g().f244620n));     // Catch: Throwable -> L277
        detectCronetColdStartCrash(r110, r116);     // Catch: Throwable -> L277
        String r105 = "";
        String r106 = r110.getCacheDir().getPath() + HTTP.URL_DEFAULT;     // Catch: Throwable -> L58
        r116.setStoragePath(r106 + TTNET_CACHE_DIR);     // Catch: Throwable -> L55
        String r119 = r106;
        r116.enableHttpCache(3, getMaxHttpDiskCacheSize());     // Catch: Throwable -> L53
        r105 = r119;
    L61:
        if (sNetworkThreadPriority >= (-20)) goto L63;
    L65:
        int r107 = getAppSecurityLevel();     // Catch: Throwable -> L277
        if (r107 <= 0) goto L68;
        r116.setAppSecurityLevel(r107);     // Catch: Throwable -> L277
    L68:
        c r108 = c.h();     // Catch: Throwable -> L277
        r108.getClass();     // Catch: Throwable -> L277
    L80:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L82:
        boolean r109 = false;
    L83:
        if (r109 == false) goto L85;
        r116.enableBrotli(true);     // Catch: Throwable -> L277
    L85:
        c r120 = c.h();     // Catch: Throwable -> L277
        r120.getClass();     // Catch: Throwable -> L277
    L97:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L99:
        boolean r121 = false;
    L100:
        if (r121 == false) goto L102;
        r116.enableQuic(true);     // Catch: Throwable -> L277
    L102:
        c r122 = c.h();     // Catch: Throwable -> L277
        r122.getClass();     // Catch: Throwable -> L277
    L114:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L116:
        boolean r123 = false;
    L117:
        if (r123 == false) goto L119;
        r116.enableHttp2(true);     // Catch: Throwable -> L277
    L119:
        TTAppSecurityManager.getInstance().setSystemApiSandbox(f.a());     // Catch: Throwable -> L277
        r116.setAppInfoProvider(a.b(r110));     // Catch: Throwable -> L277
        r116.setEventListener(e.a());     // Catch: Throwable -> L277
        r116.setIsMainProcess(com.bytedance.frameworks.baselib.network.http.util.i.d(r110));     // Catch: Throwable -> L277
        r116.setProcessName(com.bytedance.frameworks.baselib.network.http.util.i.b(r110));     // Catch: Throwable -> L277
        if (com.bytedance.frameworks.baselib.network.http.util.i.d(r110) == false) goto L122;
        r116.setAppMonitorProvider(b.a());     // Catch: Throwable -> L277
        e.a().f525641a = true;     // Catch: Throwable -> L277
    L122:
        if (r104 == false) goto L124;
        r116.setTTAppInfoColdStartSubset(convertToCronetAppInfo(r117));     // Catch: Throwable -> L277
    L124:
        r116.setOptInit(r104);     // Catch: Throwable -> L277
        r116.setOptNqeInit(r215.getOptNqeDefault(), r215.getOptNqePersist());     // Catch: Throwable -> L277
        r116.setThreadConfigInfoList(r113);     // Catch: Throwable -> L277
        r116.setThreadConfigCallbackImpl(r114);     // Catch: Throwable -> L277
        r116.setLazyInitIPC(r215.getLazyInitCronetIPC());     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r213) == true) goto L127;
        r116.setUserAgent(r213 + " cronet/TTNetVersion:c32625e6 2026-09-09 QuicVersion:6a5515bf 2026-09-09");     // Catch: Throwable -> L277
    L127:
        String r124 = getDomainConfigByRegion();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r124) == false) goto L145;
        c r125 = c.h();     // Catch: Throwable -> L277
        r125.getClass();     // Catch: Throwable -> L277
    L141:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L143:
        r124 = null;
        goto L145
    L131:
        if (NetworkParams.getOptReflection() == false) goto L136;
        ICronetAppProvider r126 = r125.f525635b;     // Catch: Throwable -> L141
        if (r126 == null) goto L143;
        r124 = r126.getGetDomainDefaultJSON();     // Catch: Throwable -> L141
    L282:
    L136:
        Object r127 = r125.f525634a;     // Catch: Throwable -> L141
        if (r127 == null) goto L143;
        r124 = (String) yx5.a.b(r127).call("getGetDomainDefaultJSON").get();     // Catch: Throwable -> L141
    L145:
        if (TextUtils.isEmpty(r124) == true) goto L147;
        r116.setGetDomainDefaultJSON(r124);     // Catch: Throwable -> L277
    L147:
        c r128 = c.h();     // Catch: Throwable -> L277
        r128.getClass();     // Catch: Throwable -> L277
    L159:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L161:
        ArrayList<byte[]> r129 = null;
    L162:
        if (r129 != null) goto L164;
    L166:
        c r130 = c.h();     // Catch: Throwable -> L277
        r130.getClass();     // Catch: Throwable -> L277
    L178:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L180:
        Map<String[], Pair<byte[], byte[]>> r131 = null;
    L181:
        if (r131 != null) goto L183;
    L185:
        c r132 = c.h();     // Catch: Throwable -> L277
        r132.getClass();     // Catch: Throwable -> L277
    L197:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L199:
        Map<String, Pair<Integer, Integer>> r133 = null;
    L200:
        if (r133 == null) goto L208;
    L202:
        if (r133.isEmpty() == true) goto L208;
        Iterator<Map.Entry<String, Pair<Integer, Integer>>> r134 = r133.entrySet().iterator();     // Catch: Throwable -> L277
    L205:
        if (r134.hasNext() == false) goto L208;
        Map.Entry<String, Pair<Integer, Integer>> r135 = r134.next();     // Catch: Throwable -> L277
        r116.addQuicHint(r135.getKey(), ((Integer) r135.getValue().first).intValue(), ((Integer) r135.getValue().second).intValue());     // Catch: Throwable -> L277
    L208:
        if (c.h().j() == false) goto L210;
        r116.setLibraryLoader(new AnonymousClass3(this));     // Catch: Throwable -> L277
    L210:
        String r136 = c.h().c();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r136) == true) goto L215;
        String r137 = File.separator;     // Catch: Throwable -> L277
        String r138 = r136.substring(r136.lastIndexOf(r137) + 1);     // Catch: Throwable -> L277
        String r139 = r110.getCacheDir().getAbsolutePath();     // Catch: Throwable -> L277
        if (FileUtils.copyFile(r136, r139, r138) == false) goto L215;
        r116.setCronetSoPath(r139 + r137 + r138);     // Catch: Throwable -> L277
    L215:
        boolean r140 = c.h().i();     // Catch: Throwable -> L277
        if (r140 == false) goto L218;
        r116.enableBoeProxy(true);     // Catch: Throwable -> L277
    L218:
        if (r140 == true) goto L230;
        String r141 = com.bytedance.frameworks.baselib.network.http.util.c.a(r110);     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r141) == true) goto L230;
        JSONObject r142 = new JSONObject(r141);     // Catch: Throwable -> L228
        String r143 = r142.optString("ttnet_proxy", "");     // Catch: Throwable -> L228
        if (TextUtils.isEmpty(r143) == true) goto L224;
        r116.setProxyConfig(r143);     // Catch: Throwable -> L228
    L224:
        r140 = r142.optBoolean("boe_proxy_enabled", false);     // Catch: Throwable -> L228
        if (r140 == false) goto L230;
        r116.enableBoeProxy(true);     // Catch: Throwable -> L228
    L228:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
    L230:
        if (r140 == true) goto L234;
        r140 = com.bytedance.frameworks.baselib.network.http.util.c.b(r110);     // Catch: Throwable -> L277
        if (r140 == false) goto L234;
        r116.enableBoeProxy(true);     // Catch: Throwable -> L277
    L234:
        if (r140 == false) goto L241;
        String r144 = c.h().b();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r144) == true) goto L238;
        r116.setBypassBOEJSON(r144);     // Catch: Throwable -> L277
    L238:
        String r145 = getProxyConfig(r105);     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r145) == true) goto L241;
        r116.setProxyConfig(r145);     // Catch: Throwable -> L277
    L241:
        String r146 = c.h().d();     // Catch: Throwable -> L277
        if (TextUtils.isEmpty(r146) == true) goto L297;
        r116.setStoreIdcRuleJSON(r146);     // Catch: Throwable -> L277
    L297:
        long r147 = getALogFuncAddr();     // Catch: Exception -> L248 Throwable -> L277
        if (r147 == 0) goto L250;
        r116.setALogFuncAddr(r147);     // Catch: Exception -> L248 Throwable -> L277
    L250:
        if (r115 == null) goto L252;
        r116.setSlaSamplingSetting(r115);     // Catch: Throwable -> L277
    L252:
        ICronetClient.ICronetThreadStackOptFailureCheckerProvider r148 = sCronetThreadStackOptFailureCheckerProvider;     // Catch: Throwable -> L277
        if (r148 != null) goto L255;
        String r149 = null;
    L256:
        r116.setStackInfo(r118, r149);     // Catch: Throwable -> L277
        r116.setTelemetryOptionFlags(getTelemetryOptionFlags());     // Catch: Throwable -> L277
        TTNetInitMetrics.g().f244632z = System.nanoTime();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().A = TTNetInitMetrics.g().f244632z;     // Catch: Throwable -> L277
        sCronetEngine = r116.build();     // Catch: Throwable -> L277
        TTNetInitMetrics.g().B = System.nanoTime();     // Catch: Throwable -> L277
        if (d.a().loggerDebug() == false) goto L259;
        Logger.setLogLevel(2);     // Catch: Throwable -> L277
    L261:
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L274;
        ExperimentalCronetEngine r150 = (ExperimentalCronetEngine) sCronetEngine;     // Catch: Throwable -> L277
        long r151 = getALogFuncAddr();     // Catch: Throwable -> L272
        if (r151 == 0) goto L266;
        r150.setAlogFuncAddr(r151);     // Catch: Throwable -> L272
    L266:
        int r152 = TTAppStateManager.getAppStartUpState();     // Catch: Throwable -> L272
        if (r152 < 0) goto L270;
        if (r152 > 2) goto L270;
        r150.setAppStartUpState(r152);     // Catch: Throwable -> L272
    L270:
        TTNetInitMetrics.g().f(r110, r150.getOpaqueFuncAddress());     // Catch: Throwable -> L272
    L272:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L277
        goto L274
    L259:
        Logger.setLogLevel(4);     // Catch: Throwable -> L277
        goto L261
    L255:
        r149 = r148.getThreadStackInitReason();     // Catch: Throwable -> L277
    L248:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L277
        goto L250
    L187:
        if (NetworkParams.getOptReflection() == false) goto L192;
        ICronetAppProvider r153 = r132.f525635b;     // Catch: Throwable -> L197
        if (r153 == null) goto L199;
        r133 = r153.getQuicHint();     // Catch: Throwable -> L197
        goto L200
    L192:
        Object r154 = r132.f525634a;     // Catch: Throwable -> L197
        if (r154 == null) goto L199;
        r133 = (Map) yx5.a.b(r154).call("getQuicHint").get();     // Catch: Throwable -> L197
        goto L200
    L183:
        if (r131.isEmpty() == true) goto L185;
        r116.setClientOpaqueData(r131);     // Catch: Throwable -> L277
        goto L185
    L168:
        if (NetworkParams.getOptReflection() == false) goto L173;
        ICronetAppProvider r155 = r130.f525635b;     // Catch: Throwable -> L178
        if (r155 == null) goto L180;
        r131 = r155.getClientOpaqueData();     // Catch: Throwable -> L178
        goto L181
    L173:
        Object r156 = r130.f525634a;     // Catch: Throwable -> L178
        if (r156 == null) goto L180;
        r131 = (Map) yx5.a.b(r156).call("getClientOpaqueData").get();     // Catch: Throwable -> L178
        goto L181
    L164:
        if (r129.isEmpty() == true) goto L166;
        r116.setOpaqueData(r129);     // Catch: Throwable -> L277
        goto L166
    L149:
        if (NetworkParams.getOptReflection() == false) goto L154;
        ICronetAppProvider r157 = r128.f525635b;     // Catch: Throwable -> L159
        if (r157 == null) goto L161;
        r129 = r157.getOpaqueData();     // Catch: Throwable -> L159
        goto L162
    L154:
        Object r158 = r128.f525634a;     // Catch: Throwable -> L159
        if (r158 == null) goto L161;
        r129 = (ArrayList) yx5.a.b(r158).call("getOpaqueData").get();     // Catch: Throwable -> L159
        goto L162
    L104:
        if (NetworkParams.getOptReflection() == false) goto L109;
        ICronetAppProvider r159 = r122.f525635b;     // Catch: Throwable -> L114
        if (r159 == null) goto L116;
        r123 = r159.isEnableHttp2();     // Catch: Throwable -> L114
        goto L117
    L109:
        Object r160 = r122.f525634a;     // Catch: Throwable -> L114
        if (r160 == null) goto L116;
        r123 = ((Boolean) yx5.a.b(r160).call("isEnableHttp2").get()).booleanValue();     // Catch: Throwable -> L114
        goto L117
    L87:
        if (NetworkParams.getOptReflection() == false) goto L92;
        ICronetAppProvider r161 = r120.f525635b;     // Catch: Throwable -> L97
        if (r161 == null) goto L99;
        r121 = r161.isEnableQuic();     // Catch: Throwable -> L97
        goto L100
    L92:
        Object r162 = r120.f525634a;     // Catch: Throwable -> L97
        if (r162 == null) goto L99;
        r121 = ((Boolean) yx5.a.b(r162).call("isEnableQuic").get()).booleanValue();     // Catch: Throwable -> L97
        goto L100
    L70:
        if (NetworkParams.getOptReflection() == false) goto L75;
        ICronetAppProvider r163 = r108.f525635b;     // Catch: Throwable -> L80
        if (r163 == null) goto L82;
        r109 = r163.isEnableBrotli();     // Catch: Throwable -> L80
        goto L83
    L75:
        Object r164 = r108.f525634a;     // Catch: Throwable -> L80
        if (r164 == null) goto L82;
        r109 = ((Boolean) yx5.a.b(r164).call("isEnableBrotli").get()).booleanValue();     // Catch: Throwable -> L80
        goto L83
    L63:
        if (sNetworkThreadPriority > 19) goto L65;
        r116.setThreadPriority(sNetworkThreadPriority);     // Catch: Throwable -> L277
    L53:
        th = th;
    L57:
        r105 = r119;
    L59:
        th.printStackTrace();     // Catch: Throwable -> L277
        r116.enableHttpCache(0, 0);     // Catch: Throwable -> L277
    L55:
        th = th;
        r119 = r106;
    L58:
        th = th;
        goto L59
    L40:
        r112 = null;
        goto L41
    L25:
        if (NetworkParams.getOptReflection() == false) goto L30;
        ICronetAppProvider r165 = r103.f525635b;     // Catch: Throwable -> L35
        if (r165 == null) goto L37;
        boolean r166 = r165.getOptInit();     // Catch: Throwable -> L35
    L34:
        r104 = r166;
        goto L38
    L30:
        Object r167 = r103.f525634a;     // Catch: Throwable -> L35
        if (r167 == null) goto L37;
        r166 = ((Boolean) yx5.a.b(r167).call("getOptInit").get()).booleanValue();     // Catch: Throwable -> L35
        goto L34
    L20:
        if (r101.isCronetThreadStackOptFailureExpected() == false) goto L22;
        r102 = true;
    L274:
        TTRequestCompressManager.setCompressDataCallback(new AnonymousClass4(this));     // Catch: Throwable -> L277
        TTNetInitMetrics.g().E = System.nanoTime();     // Catch: Throwable -> L277
        monitor-exit(CronetClient.class);     // Catch: Throwable -> L277
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient
    public void notifyStoreRegionUpdated(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214) throws Exception {
        if ((sCronetEngine instanceof ExperimentalCronetEngine) == false) goto L7;
        ((ExperimentalCronetEngine) sCronetEngine).updateStoreRegionFromServer(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
        return;
    L7:
        throw new UnsupportedOperationException(ConstantsDefined.CRONET_NOT_INITIALIZED);
    }
}
