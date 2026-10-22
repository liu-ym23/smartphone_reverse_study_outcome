package com.bytedance.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.applog.isolate.DataIsolateKey;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.f0;
import com.bytedance.bdinstall.g0;
import com.bytedance.bdinstall.t0;
import com.bytedance.bdinstall.y;
import com.larus.network.NetQualityManager;
import g84.d;
import java.net.Proxy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import uw3.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class AppLog {
    private static final g gAppLogInstance = null;
    private static volatile boolean gAppLogInstanceInitialized;

    public AppLog() {
    }

    public static void onEventV3(String r0, Bundle r1) {
        com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(r0, r1);
    }

    public static void onEventV3(String r0, JSONObject r1) {
        com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(r0, r1);
    }

    public static void clearAndSetEnv() {
        gAppLogInstance.B1();
    }

    public static void disableInsertCache() {
        gAppLogInstance.w1();
    }

    public static void flush() {
        gAppLogInstance.flush();
    }

    public static void flushAsync() {
        gAppLogInstance.N();
    }

    public static String getAbSdkVersion() {
        return gAppLogInstance.getAbSdkVersion();
    }

    public static boolean getAdjustTerminate() {
        return gAppLogInstance.q1();
    }

    public static String getAid() {
        return gAppLogInstance.getAid();
    }

    public static String getAppId() {
        return gAppLogInstance.getAppId();
    }

    public static IBDAccountCallback getBDAccountCallback() {
        return gAppLogInstance.v();
    }

    public static y getBDInstallApi() {
        return gAppLogInstance.V();
    }

    public static mw3.b getBatchReportSettings() {
        return gAppLogInstance.R();
    }

    public static String getClientUdid() {
        return gAppLogInstance.e0();
    }

    public static com.bytedance.applog.params.b getCommonParams() {
        return gAppLogInstance.getCommonParams();
    }

    public static Context getContext() {
        return gAppLogInstance.getContext();
    }

    public static String getDid() {
        return gAppLogInstance.getDid();
    }

    public static Integer getDisablePersonalization() {
        return gAppLogInstance.Q0();
    }

    public static boolean getEnableEventUserId() {
        return gAppLogInstance.C0();
    }

    public static boolean getEncryptAndCompress() {
        return gAppLogInstance.getEncryptAndCompress();
    }

    public static uw3.a getEventFilterByClient() {
        return gAppLogInstance.Y();
    }

    public static JSONObject getHeader() {
        return gAppLogInstance.getHeader();
    }

    public static k getHeaderCustomCallback() {
        return gAppLogInstance.u();
    }

    public static int getHttpMonitorPort() {
        return gAppLogInstance.g1();
    }

    public static String getIid() {
        return gAppLogInstance.getIid();
    }

    public static q getInitConfig() {
        return gAppLogInstance.getInitConfig();
    }

    public static m getLogCompressor() {
        return gAppLogInstance.h();
    }

    public static o getLogSettingsCallback() {
        gAppLogInstance.e1();
        return null;
    }

    public static g0 getNetClient() {
        return gAppLogInstance.getNetClient();
    }

    public static String getOpenUdid() {
        return gAppLogInstance.getOpenUdid();
    }

    public static tw3.b getParamsExtractApi() {
        return gAppLogInstance.l0();
    }

    public static Map<String, String> getRequestHeader() {
        return gAppLogInstance.d();
    }

    public static i getSamplingFilter() {
        return gAppLogInstance.C();
    }

    public static String getSessionId() {
        return gAppLogInstance.getSessionId();
    }

    public static String getSsid() {
        return gAppLogInstance.getSsid();
    }

    public static String getUserID() {
        return gAppLogInstance.getUserID();
    }

    public static String getUserUniqueID() {
        return gAppLogInstance.getUserUniqueID();
    }

    public static boolean hasStarted() {
        return gAppLogInstance.i();
    }

    public static void initGroupPriority() {
        gAppLogInstance.Z0();
    }

    public static boolean isEnableBgSessionTask() {
        return gAppLogInstance.c0();
    }

    public static boolean isEnableEventInTouristMode() {
        return gAppLogInstance.Y0();
    }

    public static boolean isEnableEventPriority() {
        return gAppLogInstance.z1();
    }

    public static boolean isEventMapEnabled() {
        return gAppLogInstance.q0();
    }

    public static boolean isEventParamsExtractEnabled() {
        return gAppLogInstance.U0();
    }

    public static boolean isGroupPriorityEnabled() {
        return gAppLogInstance.P0();
    }

    public static boolean isNewUser() {
        return gAppLogInstance.isNewUser();
    }

    public static boolean isNewUserModeAvailable() {
        return gAppLogInstance.J();
    }

    public static boolean isTouristMode() {
        return gAppLogInstance.e();
    }

    public static boolean manualActivate() {
        return gAppLogInstance.k0();
    }

    public static g newInstance() {
        return new b();
    }

    public static void onActivityPause() {
        gAppLogInstance.onActivityPause();
    }

    public static void onBgSessionTaskPause() {
        gAppLogInstance.g();
    }

    public static void onBgSessionTaskResume() {
        gAppLogInstance.l();
    }

    public static void removeAllDataObserver() {
        gAppLogInstance.G0();
    }

    public static void start() {
        gAppLogInstance.start();
    }

    public static void stop() {
        gAppLogInstance.stop();
    }

    static {
        gAppLogInstance = newInstance();
        gAppLogInstanceInitialized = false;
    }

    public static g getInstance() {
        return gAppLogInstance;
    }

    public static void addDataObserver(h r1) {
        gAppLogInstance.E0(r1);
    }

    public static void addEventObserver(i r1) {
        gAppLogInstance.l1(r1);
    }

    public static void addEventObserverV2(j r1) {
        gAppLogInstance.x0(r1);
    }

    public static void addLaunchObserver(l r1) {
        gAppLogInstance.n1(r1);
    }

    public static void addLogReportMonitor(n r1) {
        gAppLogInstance.L(r1);
    }

    public static void addSessionHook(p r1) {
        gAppLogInstance.z0(r1);
    }

    public static void allowHeaderKey(String r1) {
        gAppLogInstance.x1(r1);
    }

    public static void blockHeaderKey(String r1) {
        gAppLogInstance.b0(r1);
    }

    public static void clearWhenSwitchChildMode(boolean r1) {
        gAppLogInstance.k(r1);
    }

    public static void forceTimeoutReportSync(long r1) {
        gAppLogInstance.t(r1);
    }

    public static void getSsidGroup(Map<String, String> r1) {
        gAppLogInstance.getSsidGroup(r1);
    }

    public static boolean isEventHitSamplingDrop(String r1) {
        return gAppLogInstance.s(r1);
    }

    public static boolean isEventHitStickySamplingDrop(String r1) {
        return gAppLogInstance.s(r1);
    }

    public static boolean isNewUserMode(Context r0) {
        return gAppLogInstance.c();
    }

    public static d newUserMode(Context r0) {
        gAppLogInstance.r1();
        return null;
    }

    public static void onEvent(String r1) {
        gAppLogInstance.onEvent(r1);
    }

    public static void onEventV3(String r1) {
        gAppLogInstance.onEventV3(r1);
    }

    public static void onPause(Context r1) {
        gAppLogInstance.onPause(r1);
    }

    public static void onResume(Context r1) {
        gAppLogInstance.onResume(r1);
    }

    public static void registerAbSdkVersionCallback(f r1) {
        gAppLogInstance.U(r1);
    }

    public static void registerBgSessionTaskCallback(lx3.a r0) {
        gAppLogInstance.y();
    }

    public static void registerHeaderCustomCallback(k r1) {
        gAppLogInstance.Z(r1);
    }

    public static void removeDataObserver(h r1) {
        gAppLogInstance.k1(r1);
    }

    public static void removeEventObserver(i r1) {
        gAppLogInstance.y1(r1);
    }

    public static void removeEventObserverV2(j r1) {
        gAppLogInstance.a0(r1);
    }

    public static void removeHeaderInfo(String r1) {
        gAppLogInstance.H1(r1);
    }

    public static void removeLaunchObserver(l r1) {
        gAppLogInstance.P(r1);
    }

    public static void removeSessionHook(p r1) {
        gAppLogInstance.K0(r1);
    }

    public static void setAccount(Account r1) {
        gAppLogInstance.b(r1);
    }

    public static void setAdjustTerminate(boolean r1) {
        gAppLogInstance.N0(r1);
    }

    public static void setAppTrack(JSONObject r1) {
        gAppLogInstance.r(r1);
    }

    public static void setAutoStartGroupPriority(boolean r1) {
        gAppLogInstance.M0(r1);
    }

    public static void setBDAccountCallback(IBDAccountCallback r1) {
        gAppLogInstance.v1(r1);
    }

    public static void setBDInstallEventTrackEnabled(boolean r1) {
        gAppLogInstance.f0(r1);
    }

    public static void setBatchProcessEventCount(int r1) {
        gAppLogInstance.r0(r1);
    }

    public static void setBatchProcessInterval(int r1) {
        gAppLogInstance.h1(r1);
    }

    public static void setBgSessionReportOnPause(boolean r1) {
        gAppLogInstance.u1(r1);
    }

    public static void setBgSessionTaskEnabled(boolean r1) {
        gAppLogInstance.B0(r1);
    }

    public static void setBgSessionTaskNavigatorCallback(ow3.b r1) {
        gAppLogInstance.K(r1);
    }

    public static void setCommonParamsEnabled(boolean r1) {
        gAppLogInstance.I(r1);
    }

    public static void setCustomHeaderControlEnabled(boolean r1) {
        gAppLogInstance.S(r1);
    }

    public static void setDataIsolateCallback(yw3.b r0) {
        gAppLogInstance.D1();
    }

    public static void setDataIsolateEnabled(boolean r1) {
        gAppLogInstance.A1(r1);
    }

    public static void setDataIsolateKey(DataIsolateKey r1) {
        gAppLogInstance.c1(r1);
    }

    public static void setDefaultHttpClientProxy(Proxy r1) {
        gAppLogInstance.q(r1);
    }

    public static void setDevToolsEnable(boolean r0) {
        com.bytedance.applog.log.m.a = Boolean.valueOf(r0);
    }

    public static void setDisablePersonalization(int r1) {
        gAppLogInstance.F0(r1);
    }

    public static void setEnableEventInTouristMode(boolean r1) {
        gAppLogInstance.F(r1);
    }

    public static void setEnableEventPriority(boolean r1) {
        gAppLogInstance.g0(r1);
    }

    public static void setEnableEventUserId(boolean r1) {
        gAppLogInstance.w0(r1);
    }

    public static void setEncryptAndCompress(boolean r1) {
        gAppLogInstance.t1(r1);
    }

    public static void setEventForwardEnabled(boolean r1) {
        gAppLogInstance.m1(r1);
    }

    public static void setEventHandler(ww3.a r0) {
        gAppLogInstance.T();
    }

    public static void setEventMapEnabled(boolean r1) {
        gAppLogInstance.G(r1);
    }

    public static void setEventParamControlEnabled(boolean r1) {
        gAppLogInstance.L0(r1);
    }

    public static void setEventParamsExtractEnabled(boolean r1) {
        gAppLogInstance.p0(r1);
    }

    public static void setEventSamplingEnable(boolean r1) {
        gAppLogInstance.j(r1);
    }

    public static void setExternalAbVersion(String r1) {
        gAppLogInstance.E(r1);
    }

    public static void setExtraParams(d0 r1) {
        gAppLogInstance.H0(r1);
    }

    public static void setFetchConfigFirstDelayMills(long r1) {
        gAppLogInstance.f1(r1);
    }

    public static void setFlushAsyncDefault(boolean r1) {
        gAppLogInstance.I0(r1);
    }

    public static void setFlushThresholdEnable(boolean r1) {
        gAppLogInstance.A0(r1);
    }

    public static void setGroupPriorityEnable(boolean r1) {
        gAppLogInstance.o(r1);
    }

    public static void setHeaderInfo(HashMap<String, Object> r1) {
        gAppLogInstance.setHeaderInfo(r1);
    }

    public static void setHttpMonitorPort(int r1) {
        gAppLogInstance.i1(r1);
    }

    public static void setInsertByTransactionEnabled(boolean r1) {
        gAppLogInstance.B(r1);
    }

    public static void setInsertEventOptEnabled(boolean r1) {
        gAppLogInstance.W(r1);
    }

    public static void setLogCompressor(m r1) {
        gAppLogInstance.T0(r1);
    }

    public static void setLogSettingsCallback(o r0) {
        gAppLogInstance.n0();
    }

    public static void setLogger(f0 r1) {
        gAppLogInstance.J1(r1);
    }

    public static void setMaxCacheEventNum(int r1) {
        gAppLogInstance.M(r1);
    }

    public static void setMaxRequestOnceReport(int r1) {
        gAppLogInstance.F1(r1);
    }

    public static void setMigrateOldAppLogDataEnabled(boolean r1) {
        gAppLogInstance.O0(r1);
    }

    public static void setNavigatorCallback(ow3.b r1) {
        gAppLogInstance.A(r1);
    }

    public static void setNewMonitorEnabled(boolean r1) {
        gAppLogInstance.f(r1);
    }

    public static void setNewMonitorInDebugMode(boolean r1) {
        gAppLogInstance.C1(r1);
    }

    public static void setPackLaunchByDesc(boolean r1) {
        gAppLogInstance.o0(r1);
    }

    public static void setPageId(String r1) {
        gAppLogInstance.D(r1);
    }

    public static void setPageInfoEnabled(boolean r1) {
        gAppLogInstance.J0(r1);
    }

    public static void setPageName(String r1) {
        gAppLogInstance.setPageName(r1);
    }

    public static void setReportDropStrategy(kx3.b r1) {
        gAppLogInstance.M1(r1);
    }

    public static void setServerFilterByNative(boolean r1) {
        gAppLogInstance.j0(r1);
    }

    public static void setServerFilterSaveToKeva(boolean r1) {
        gAppLogInstance.d0(r1);
    }

    public static void setTeaEventSamplingEnable(boolean r1) {
        gAppLogInstance.i0(r1);
    }

    public static void setTerminateImmediately(boolean r1) {
        gAppLogInstance.z(r1);
    }

    public static void setTouchPoint(String r1) {
        gAppLogInstance.n(r1);
    }

    public static void setTouristMode(boolean r1) {
        gAppLogInstance.j1(r1);
    }

    public static void setTrackResumeEvent(boolean r1) {
        gAppLogInstance.b1(r1);
    }

    public static void setUriRuntime(r r1) {
        gAppLogInstance.R0(r1);
    }

    public static void setUserAgent(String r1) {
        gAppLogInstance.h0(r1);
    }

    public static void setUserID(long r1) {
        gAppLogInstance.D0(r1);
    }

    public static void setUserUniqueID(String r1) {
        gAppLogInstance.setUserUniqueID(r1);
    }

    public static void addEventObserver(int r1, i r2) {
        gAppLogInstance.K1(r1, r2);
    }

    public static void addEventObserverV2(int r1, j r2) {
        gAppLogInstance.a1(r1, r2);
    }

    public static void addRegisterCustomHeader(Context r1, JSONObject r2) {
        gAppLogInstance.u0(r1, r2);
    }

    public static void com_bytedance_applog_AppLog__onEventV3$___twin___(String r1, Bundle r2) {
        gAppLogInstance.onEventV3(r1, r2);
    }

    public static void com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(String r2, Bundle r3) {
        if (r3 != null) goto L7;
    L4:
        com_bytedance_applog_AppLog__onEventV3$___twin___(r2, r3);
        return;
    L7:
        NetQualityManager.NetworkStatus r1 = NetQualityManager.a;     // Catch: Exception -> L6
        r3.putInt("network_quality", NetQualityManager.a.getValue());     // Catch: Exception -> L6
        goto L4
    }

    public static void init(Context r3, q r4) {
        monitor-enter(AppLog.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (gAppLogInstanceInitialized == false) goto L8;
        monitor-exit(AppLog.class);     // Catch: Throwable -> L16
        return;
    L8:
        gAppLogInstanceInitialized = true;     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(r4.z) == true) goto L11;
    L13:
        gAppLogInstance.O(r3, r4);     // Catch: Throwable -> L16
        monitor-exit(AppLog.class);     // Catch: Throwable -> L16
        return;
    L11:
        if (TextUtils.isEmpty("applog_stats") == true) goto L13;
        r4.z = "applog_stats";     // Catch: Throwable -> L16
        goto L13
    }

    public static boolean isEventHitSamplingDrop(String r1, JSONObject r2) {
        return gAppLogInstance.X0(r1, r2);
    }

    public static boolean isEventHitStickySamplingDrop(String r1, JSONObject r2) {
        return gAppLogInstance.X0(r1, r2);
    }

    public static void monitorCount(String r1, int r2) {
        gAppLogInstance.t0(r1, r2);
    }

    public static void monitorError(String r1, Throwable r2) {
        gAppLogInstance.d1(r1, r2);
    }

    public static void onActivityResumed(Activity r0, int r1) {
        gAppLogInstance.onActivityResumed(r0);
    }

    public static void onEvent(String r1, String r2) {
        gAppLogInstance.onEvent(r1, r2);
    }

    public static void onMiscEvent(String r1, JSONObject r2) {
        gAppLogInstance.onMiscEvent(r1, r2);
    }

    public static void resetAndReInstall(long r1, t0 r3) {
        gAppLogInstance.E1(r1, r3);
    }

    public static void setAppLanguageAndRegion(String r1, String r2) {
        gAppLogInstance.setAppLanguageAndRegion(r1, r2);
    }

    public static void setEventFilterByClient(List<String> r1, boolean r2) {
        gAppLogInstance.v0(r1, r2);
    }

    public static void setEventForwardHttpHeader(String r1, String r2) {
        gAppLogInstance.o1(r1, r2);
    }

    public static void setEventSenderEnable(boolean r1, String r2) {
        gAppLogInstance.s0(r1, r2);
    }

    public static void setHeaderInfo(String r1, Object r2) {
        gAppLogInstance.a(r1, r2);
    }

    public static void setNewUserMode(Context r0, boolean r1) {
        gAppLogInstance.x(r1);
    }

    public static void com_bytedance_applog_AppLog__onEventV3$___twin___(String r1, JSONObject r2) {
        gAppLogInstance.onEventV3(r1, r2);
    }

    public static void com_bytedance_applog_AppLog_com_larus_home_impl_utils_CommonHook_onEventV3(String r2, JSONObject r3) {
        if (r3 != null) goto L7;
    L4:
        com_bytedance_applog_AppLog__onEventV3$___twin___(r2, r3);
        return;
    L7:
        NetQualityManager.NetworkStatus r1 = NetQualityManager.a;     // Catch: JSONException -> L6
        r3.put("network_quality", NetQualityManager.a.getValue());     // Catch: JSONException -> L6
        goto L4
    }

    public static void onActivityResumed(String r1, int r2) {
        gAppLogInstance.p(r1, r2);
    }

    public static void enableInsertCache(HashSet<String> r1, int r2, int r3) {
        gAppLogInstance.s1(r1, r2, r3);
    }

    public static <T> T getHeaderValue(String r1, T r2, Class<T> r3) {
        return (T) gAppLogInstance.G1(r1, r2, r3);
    }

    public static void setExpectedBatchInterval(String r1, String r2, int r3) {
        gAppLogInstance.S0(r1, r2, r3);
    }

    public static String addNetCommonParams(Context r1, String r2, boolean r3, Level r4) {
        return gAppLogInstance.w(r1, r2, r3, r4);
    }

    public static void onEventV3WithView(View r1, String r2, String r3, JSONObject r4) {
        gAppLogInstance.H(r1, r2, r3, r4);
    }

    public static void putCommonParams(Context r1, Map<String, String> r2, boolean r3, Level r4) {
        gAppLogInstance.m0(r1, r2, r3, r4);
    }

    public static void resetDidWhenSwitchChildMode(Context r0, boolean r1, long r2, t0 r4) {
        gAppLogInstance.p1(r1, r2, r4);
    }

    public static String addNetCommonParams(Context r1, StringBuilder r2, boolean r3, Level r4) {
        return gAppLogInstance.I1(r1, r2, r3, r4);
    }

    public static void onEvent(String r8, String r9, String r10, long r11, long r13) {
        gAppLogInstance.V0(r8, r9, r10, r11, r13);
    }

    public static void onInternalEventV3(String r6, Bundle r7, String r8, String r9, String r10) {
        gAppLogInstance.W0(r6, r7, r8, r9, r10);
    }

    public static void onInternalEventV3(String r6, JSONObject r7, String r8, String r9, String r10) {
        gAppLogInstance.onInternalEventV3(r6, r7, r8, r9, r10);
    }

    public static void onEvent(String r9, String r10, String r11, long r12, long r14, JSONObject r16) {
        gAppLogInstance.Q(r9, r10, r11, r12, r14, r16);
    }
}
