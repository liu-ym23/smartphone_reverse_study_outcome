package com.bytedance.bdlocation.scan.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import com.bytedance.bdlocation.network.model.WifiInfo;
import com.bytedance.bdlocation.permission.PermissionManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.store.LocationCache;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.crash.Npth;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.ArrayList;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class WifiInfoManager {
    public static final String CACHE_CONNECT_WIFI_BSSID_KEY = "cache_connect_wifi_bssid";
    private static final String TAG = "WifiInfoManager";
    private static SparseIntArray sChannelFrequency;
    private AppExecutors mAppExecutors;
    private Object mBpeaCert;
    private volatile boolean mEnableCallbackOnMainThread;
    private Handler mHandler;
    private volatile boolean mIsNotified;
    private volatile boolean mIsRegisterReceiver;
    private LocationTraceLogger mTraceLogger;
    private WifiInfoCallback mWifiInfoCallback;
    private BroadcastReceiver mWifiScanReceiver;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.wifi.WifiInfoManager$1, reason: invalid class name */
    public class AnonymousClass1 extends BroadcastReceiver {
        final /* synthetic */ WifiInfoManager this$0;

        public static /* synthetic */ void a(AnonymousClass1 r0, Intent r1, Context r2) {
            r0.lambda$onReceive$0(r1, r2);
        }

        public AnonymousClass1(WifiInfoManager r1) {
            this.this$0 = r1;
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r11, Context r12) {
            long r0 = System.currentTimeMillis() / 1000;
            boolean r13 = r11.getBooleanExtra("resultsUpdated", false);
            if (r13 == false) goto L5;
            Logger.i("WifiInfoManager scan wifi from broadcast result is success.");
        L6:
            WifiInfoManager r4 = this.this$0;
            monitor-enter(r4);
        L22:
            th = move-exception;
            throw th;
        L9:
            if (WifiInfoManager.access$100(this.this$0) == true) goto L19;
            Logger.i("WifiInfoManager scan wifi from broadcast");     // Catch: Throwable -> L22
            Object r6 = WifiInfoManager.access$200(this.this$0);     // Catch: Throwable -> L22
            boolean r7 = true;
            if (r13 == true) goto L13;
            boolean r8 = true;
        L14:
            WifiInfoModule r9 = WifiInfoManager.getWifiModule(r12, r6, r8, false, WifiInfoManager.access$300(this.this$0));     // Catch: Throwable -> L22
            WifiInfoManager r10 = this.this$0;     // Catch: Throwable -> L22
            if (r13 == false) goto L18;
            r7 = false;
        L18:
            WifiInfoManager.access$400(r10, r9, r7, false);     // Catch: Throwable -> L22
            goto L19
        L13:
            r8 = false;
        L19:
            monitor-exit(r4);     // Catch: Throwable -> L22
            WifiInfoManager.access$500(this.this$0, r12);
            Logger.i("WifiInfoManager Receiver excutTime:" + ((System.currentTimeMillis() / 1000) - r0) + "--success " + r13);
            return;
        L5:
            Logger.i("WifiInfoManager scan wifi from broadcast result is failed.");
            goto L6
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(final Context r3, final Intent r4) {
            Logger.i("WifiInfoManager wifi scan receive broadcast result");
            WifiInfoManager.access$000(this.this$0).diskIO().execute(new i(this, r4, r3));
        }
    }

    public interface WifiInfoCallback {

        /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.wifi.WifiInfoManager$WifiInfoCallback$-CC, reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onFailed(WifiInfoCallback r1, int r2, String r3) {
                Logger.i(WifiInfoManager.TAG, "get wifiInfos failed, code:" + r2 + "--message:" + r3);
            }
        }

        void onFailed(int r1, String r2);

        void onWifiInfo(List<WifiInfo> r1, boolean r2, boolean r3, WifiInfo r4);
    }

    public static /* synthetic */ void a(WifiInfoCallback r0, List r1, boolean r2, boolean r3, WifiInfo r4) {
        lambda$notifyWifiInfos$2(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void b(WifiInfoCallback r0, int r1, String r2) {
        lambda$notifyFailed$5(r0, r1, r2);
    }

    public static /* synthetic */ void c(WifiInfoCallback r0, int r1, String r2) {
        lambda$notifyFailed$4(r0, r1, r2);
    }

    public static /* synthetic */ void d(WifiInfoCallback r0, List r1, boolean r2, boolean r3, WifiInfo r4) {
        lambda$notifyWifiInfos$3(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void e(WifiInfoManager r0, Context r1) {
        r0.lambda$getWifiScanInfos$1(r1);
    }

    public static /* synthetic */ void f(WifiInfoManager r0, Context r1) {
        r0.lambda$null$0(r1);
    }

    static {
        SparseIntArray r0 = new SparseIntArray();
        sChannelFrequency = r0;
        r0.put(1, 2412);
        sChannelFrequency.put(2, 2417);
        sChannelFrequency.put(3, 2422);
        sChannelFrequency.put(4, 2427);
        sChannelFrequency.put(5, 2432);
        sChannelFrequency.put(6, 2437);
        sChannelFrequency.put(7, 2442);
        sChannelFrequency.put(8, 2447);
        sChannelFrequency.put(9, 2452);
        sChannelFrequency.put(10, 2457);
        sChannelFrequency.put(11, 2462);
        sChannelFrequency.put(12, 2467);
        sChannelFrequency.put(13, 2472);
        sChannelFrequency.put(14, 2484);
        sChannelFrequency.put(36, 5180);
        sChannelFrequency.put(40, 5200);
        sChannelFrequency.put(44, 5220);
        sChannelFrequency.put(48, 5240);
        sChannelFrequency.put(52, 5260);
        sChannelFrequency.put(56, 5280);
        sChannelFrequency.put(60, 5300);
        sChannelFrequency.put(64, 5320);
        sChannelFrequency.put(100, 5500);
        sChannelFrequency.put(104, 5520);
        sChannelFrequency.put(108, 5540);
        sChannelFrequency.put(112, 5560);
        sChannelFrequency.put(116, 5580);
        sChannelFrequency.put(120, 5600);
        sChannelFrequency.put(124, 5620);
        sChannelFrequency.put(DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE, 5640);
        sChannelFrequency.put(132, 5660);
        sChannelFrequency.put(136, 5680);
        sChannelFrequency.put(140, 5700);
        sChannelFrequency.put(149, 5745);
        sChannelFrequency.put(153, 5765);
        sChannelFrequency.put(157, 5785);
        sChannelFrequency.put(161, 5805);
    }

    public WifiInfoManager() {
        this.mIsNotified = false;
        this.mAppExecutors = AppExecutors.getInstance();
        this.mIsRegisterReceiver = false;
        this.mBpeaCert = null;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mWifiScanReceiver = new AnonymousClass1(this);
    }

    private static String getCacheConnectWifiBSSID() {
        return LocationCache.getInstance().getStringValue(CACHE_CONNECT_WIFI_BSSID_KEY);
    }

    public static /* synthetic */ AppExecutors access$000(WifiInfoManager r0) {
        return r0.mAppExecutors;
    }

    public static /* synthetic */ boolean access$100(WifiInfoManager r0) {
        return r0.mIsNotified;
    }

    public static /* synthetic */ Object access$200(WifiInfoManager r0) {
        return r0.mBpeaCert;
    }

    public static /* synthetic */ LocationTraceLogger access$300(WifiInfoManager r0) {
        return r0.mTraceLogger;
    }

    private static boolean isValidWifiInfo(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return false;
    L6:
        if (r2.matches("^[0-9|A-Z|a-z]{2}(:[0-9|A-Z|a-z]{2}){5}$") == true) goto L8;
        return false;
    L8:
        if (TextUtils.equals(r2, "02:00:00:00:00:00") == true) goto L12;
        return true;
    L12:
        return false;
    }

    private static boolean isWifi(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L13
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.isAvailable() == false) goto L17;
        if (1 != r3.getType()) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L19:
        return false;
    }

    private /* synthetic */ void lambda$getWifiScanInfos$1(final Context r3) {
        this.mAppExecutors.diskIO().execute(new h(this, r3));
    }

    private /* synthetic */ void lambda$null$0(Context r4) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsNotified == true) goto L6;
        Logger.i("WifiInfoManager start scan timeout.");     // Catch: Throwable -> L8
        notifyWifi(getWifiModule(r4, this.mBpeaCert, false, false, this.mTraceLogger), false, true);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private void registerReceiver(Context r3) {
        if (r3 != null) goto L4;
    L13:
        Logger.i("WifiInfoManager has register receiver.");
        return;
    L4:
        if (this.mWifiScanReceiver == null) goto L13;
        if (this.mIsRegisterReceiver == true) goto L13;
        IntentFilter r0 = new IntentFilter();     // Catch: Throwable -> L10
        r0.addAction("android.net.wifi.SCAN_RESULTS");     // Catch: Throwable -> L10
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_wifi_WifiInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r3, this.mWifiScanReceiver, r0);     // Catch: Throwable -> L10
        this.mIsRegisterReceiver = true;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Logger.i("registerReceiver error:" + th.toString());
    }

    private static void setCacheConnectWifiBSSID(String r2) {
        LocationCache.getInstance().setStringValue(CACHE_CONNECT_WIFI_BSSID_KEY, r2);
    }

    private void unRegisterReceiver(Context r3) {
        if (this.mIsRegisterReceiver == false) goto L15;
        if (r3 == null) goto L16;
        BroadcastReceiver r0 = this.mWifiScanReceiver;
        if (r0 == null) goto L17;
        INVOKEVIRTUAL_com_bytedance_bdlocation_scan_wifi_WifiInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(r3, r0);     // Catch: Throwable -> L9
    L11:
        this.mIsRegisterReceiver = false;
        return;
    L9:
        th = move-exception;
        Logger.i("unRegisterReceiver error:" + th.toString());
        goto L11
    L17:
        return;
    L16:
        return;
    }

    public int getChannel(int r2) {
        int r3 = sChannelFrequency.indexOfValue(r2);
        if (r3 >= 0) goto L5;
        return -1;
    L5:
        return sChannelFrequency.keyAt(r3);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_bytedance_bdlocation_scan_wifi_WifiInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r1, BroadcastReceiver r2) {
        ReceiverRegisterLancet.loge(r2, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r1.unregisterReceiver(r2);
        return;
    L14:
    L8:
        e = move-exception;
        if (r2 == null) goto L11;
        Npth.addTag("unregisterReceiver", r2.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, r1) == false) goto L16;
        r1.unregisterReceiver(r2);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ void access$500(WifiInfoManager r0, Context r1) {
        r0.unRegisterReceiver(r1);
    }

    private void notifyFailed(final int r4, final String r5) {
        final WifiInfoCallback r0 = this.mWifiInfoCallback;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L9;
        this.mAppExecutors.mainThread().execute(new e(r0, r4, r5));
    L12:
        this.mEnableCallbackOnMainThread = false;
        return;
    L9:
        if (this.mAppExecutors.isMainThread() == false) goto L11;
        this.mAppExecutors.diskIO().execute(new f(r0, r4, r5));
        goto L12
    L11:
        r0.onFailed(r4, r5);
        goto L12
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_bytedance_bdlocation_scan_wifi_WifiInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r8, BroadcastReceiver r9, IntentFilter r10) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    private static void addScanWifiInfoMonitor(boolean r1, String r2, boolean r3) {
        if (r3 == false) goto L4;
        return;
    L4:
        if (BDLocationConfig.isOpenWifiListMonitor() == false) goto L8;
        Logger.i(LocationMonitorConst.EVENT_CONNECT_WIFI_INFO, "isCache:" + r1 + "--connectWifi:" + r2);
        LocationMonitor.doConnectWifiInfo(r1, r2);
        return;
    }

    private static void addScanWifiListMonitor(boolean r6, List<ScanResult> r7, boolean r8) {
        if (r8 == false) goto L4;
        return;
    L4:
        if (BDLocationConfig.isOpenWifiListMonitor() == false) goto L29;
        ArrayList r9 = new ArrayList(r7);
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor start");
        if (r9.isEmpty() == true) goto L19;
        JSONArray r10 = new JSONArray();
        int r1 = 0;
    L10:
        if (r1 >= r9.size()) goto L18;
        ScanResult r2 = (ScanResult) ListProtector.get(r9, r1);
        if (r2 == null) goto L17;
        JSONObject r3 = new JSONObject();     // Catch: JSONException -> L15
        r3.put("w_ssid", r2.SSID);     // Catch: JSONException -> L15
        r3.put("w_bssid", r2.BSSID);     // Catch: JSONException -> L15
        r3.put("w_rssi", r2.level);     // Catch: JSONException -> L15
        r10.put(r3);     // Catch: JSONException -> L15
    L15:
        e = move-exception;
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "addScanWifiListMonitor JSONException:" + e.toString() + "--scanResult" + r2.toString());
    L17:
        r1 = r1 + 1;
        goto L10
    L18:
        String r11 = r10.toString();
        Logger.i(LocationMonitorConst.EVENT_SCAN_WIFI_LIST, "isCache:" + r6 + "--scanResults:" + r11 + "--end");
        LocationMonitor.doScanWiFiList(r6, r11);
        return;
    L19:
        LocationMonitor.doScanWiFiList(r6, "");
        return;
    }

    public static List<WifiInfo> getWifiInfos(Context r2, Object r3, boolean r4) {
        WifiInfoModule r5 = getWifiModule(r2, r3, r4, false, null);
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.wifiInfoList;
    }

    private static /* synthetic */ void lambda$notifyFailed$4(WifiInfoCallback r0, int r1, String r2) {
        r0.onFailed(r1, r2);
    }

    private static /* synthetic */ void lambda$notifyFailed$5(WifiInfoCallback r0, int r1, String r2) {
        r0.onFailed(r1, r2);
    }

    private void notifyWifi(WifiInfoModule r10, boolean r11, boolean r12) {
        if (r10 == null) goto L11;
        List<WifiInfo> r1 = r10.wifiInfoList;
        WifiInfo r2 = r10.connectWifi;
        LocationMonitor.locationTracePutCategoryData(this.mTraceLogger, LocationMonitorConst.SCAN_WIFI_TIMEOUT, Boolean.valueOf(r12));
        LocationMonitor.locationTraceLogEnd(this.mTraceLogger, LocationMonitorConst.WIFI_CORE_SCAN_DURATION);
        long r3 = System.currentTimeMillis();
        long r5 = r10.cacheWifiTime;
        long r4 = r3 - r5;
        if (r5 != 0) goto L7;
    L9:
        boolean r13 = true;
    L10:
        Logger.i("notifyWifi isRecommendLocation cacheWifiInterval" + r4);
    L12:
        StringBuilder r6 = new StringBuilder("wifiInfoModule is ");
        if (r10 != null) goto L15;
        String r14 = "null";
    L16:
        r6.append(r14);
        r6.append(", notifyWifi isRecommendWifiResults：");
        r6.append(r13);
        Logger.i(r6.toString());
        notifyWifiInfos(r1, r11, r13, r2);
        this.mIsNotified = true;
        return;
    L15:
        r14 = "not null";
        goto L16
    L7:
        if (r4 <= BDLocationConfig.getTailWifiTimeThreshold()) goto L9;
        r13 = false;
        goto L10
    L11:
        r1 = null;
        r2 = null;
        r13 = true;
        goto L12
    }

    public static /* synthetic */ void access$400(WifiInfoManager r0, WifiInfoModule r1, boolean r2, boolean r3) {
        r0.notifyWifi(r1, r2, r3);
    }

    private static boolean checkWifiPolicy(Context r6, WifiInfoModule r7, Object r8, LocationTraceLogger r9) {
        if (BDLocationConfig.enableScanWifi() == true) goto L7;
        Logger.i("checkWifiPolicy unable scan WiFi");
        return true;
    L7:
        if (r7 != null) goto L10;
        return false;
    L10:
        if (BDLocationConfig.enableCheckConnectWifi() == false) goto L22;
        WifiInfo r0 = r7.connectWifi;
        if (r0 != null) goto L14;
        setCacheConnectWifiBSSID("");
        goto L22
    L14:
        if (r0.wifiMac.equals(getCacheConnectWifiBSSID()) == true) goto L16;
    L19:
        setCacheConnectWifiBSSID(r0.wifiMac);
        goto L22
    L16:
        if (r0.rssi <= BDLocationConfig.checkConnectWifiRssi()) goto L19;
        Logger.i("checkWifiPolicy same_connect_wifi");
        LocationMonitor.locationTracePutCategoryData(r9, LocationMonitorConst.SAME_CONNECT_WIFI, Boolean.TRUE);
        return true;
    L22:
        if (BDLocationConfig.enableCheckRefreshWifiTime() == false) goto L27;
        long r1 = System.currentTimeMillis() - r7.cacheWifiTime;
        Logger.i("checkWifiPolicy wifi_cache_valid cacheWifiInterval:" + r1);
        if (r1 >= BDLocationConfig.checkRefreshWifiTimeInterval()) goto L27;
        Logger.i("checkWifiPolicy wifi_cache_valid");
        LocationMonitor.locationTracePutCategoryData(r9, LocationMonitorConst.WIFI_CACHE_VALID, Boolean.TRUE);
        return true;
    L27:
        return false;
    }

    private static android.net.wifi.WifiInfo getConnectWifiInfo(Context r1, WifiManager r2, Object r3, boolean r4) {
        if (r1 == null) goto L18;
        if (r2 != null) goto L5;
        return null;
    L5:
        if (isWifi(r1) == false) goto L20;
        android.net.wifi.WifiInfo r5 = getConnectionInfo(r1, r2, r3, r4);     // Catch: Throwable -> L12
        if (((ConnectivityManager) r1.getSystemService("connectivity")).getNetworkInfo(1).getState() != NetworkInfo.State.CONNECTED) goto L21;
        if (r5 == null) goto L22;
        if (BDLocationExtrasService.getBPEAManagerWithTag(r4).getSSID(r5, r3) == null) goto L23;
        return r5;
    L23:
        return null;
    L22:
        return null;
    L21:
        return null;
    L12:
        th = move-exception;
        Logger.e("", th);
        return null;
    L20:
        return null;
    L18:
        return null;
    }

    private static android.net.wifi.WifiInfo getConnectionInfo(Context r2, WifiManager r3, Object r4, boolean r5) {
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r5 == true) goto L9;
        if (PermissionManager.hasAnyPermission(r2, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L9;
        return null;
    L9:
        return BDLocationExtrasService.getBPEAManagerWithTag(r5).getConnectionInfo(r3, r4);
    }

    private void notifyWifiInfos(final List<WifiInfo> r9, final boolean r10, final boolean r11, final WifiInfo r12) {
        final WifiInfoCallback r1 = this.mWifiInfoCallback;
        if (r1 != null) goto L5;
        return;
    L5:
        this.mWifiInfoCallback = null;
        if (this.mEnableCallbackOnMainThread == false) goto L9;
        this.mAppExecutors.mainThread().execute(new c(r1, r9, r10, r11, r12));
    L12:
        this.mEnableCallbackOnMainThread = false;
        return;
    L9:
        if (this.mAppExecutors.isMainThread() == false) goto L11;
        this.mAppExecutors.diskIO().execute(new d(r1, r9, r10, r11, r12));
        goto L12
    L11:
        r1.onWifiInfo(r9, r10, r11, r12);
        goto L12
    }

    public void getWifiScanInfos(final Context r9, WifiInfoCallback r10, Object r11, LocationTraceLogger r12) {
        if (r9 != null) goto L5;
        Logger.d("The method getAllWifiInfos of WifiInfoManager is executed and context is null");
        notifyFailed(-1, "context is null.");
        return;
    L5:
        this.mBpeaCert = r11;
        this.mTraceLogger = r12;
        WifiManager r0 = (WifiManager) r9.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);
        registerReceiver(r9);
        this.mWifiInfoCallback = r10;
        this.mIsNotified = false;
        WifiInfoModule r1 = getWifiModule(r9, this.mBpeaCert, true, false, this.mTraceLogger);
        boolean r13 = checkWifiPolicy(r9, r1, r11, r12);
        if (BDLocationConfig.getWifiScanInterval() <= 0) goto L8;
        this.mHandler.postDelayed(new g(this, r9), BDLocationConfig.getWifiScanInterval());
    L8:
        LocationMonitor.locationTracePutCategoryData(this.mTraceLogger, LocationMonitorConst.LIBRA_PARAM_WIFI_SCAN_INTERVAL, Long.valueOf(BDLocationConfig.getWifiScanInterval()));
        LocationMonitor.locationTraceLogBegin(this.mTraceLogger, LocationMonitorConst.WIFI_CORE_SCAN_DURATION);
        if (r13 == false) goto L11;
    L12:
        Logger.i("WifiInfoManager start scan failed.");
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L15:
        if (this.mIsNotified == true) goto L17;
        notifyWifi(r1, true, false);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);     // Catch: Throwable -> L19
        return;
    L11:
        if (BDLocationExtrasService.getBPEAManager().wifiStartScan(r0, r11) == false) goto L12;
    }

    public static WifiInfoModule getWifiModule(Context r25, Object r26, boolean r27, boolean r28, LocationTraceLogger r29) {
        Context r9 = LocationUtil.getContext(r25);
        if (r9 != null) goto L73;
        return null;
    L73:
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_WIFI_CACHE_DURATION);     // Catch: Exception -> L70
        WifiManager r11 = (WifiManager) r9.getSystemService(LocationAnnotation.LightLocationType.LIGHT_LOCATION_WIFI);     // Catch: Exception -> L70
        if (r11 != null) goto L8;
        return null;
    L8:
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L70
        if (r28 == false) goto L11;
    L14:
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_DURATION);     // Catch: Exception -> L70
        List r15 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getScanResults(r11, r26);     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_DURATION);     // Catch: Exception -> L70
        if (r15 != null) goto L17;
    L19:
        boolean r16 = false;
    L20:
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.HAS_WIFI_SCAN_RESULTS, Boolean.valueOf(r16));     // Catch: Exception -> L70
        addScanWifiListMonitor(r27, r15, r28);     // Catch: Exception -> L70
    L21:
        StringBuilder r5 = new StringBuilder("wifi scan result is null: ");     // Catch: Exception -> L70
        if (r15 != null) goto L24;
        boolean r8 = true;
    L25:
        r5.append(r8);     // Catch: Exception -> L70
        Logger.i(r5.toString());     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogBegin(r29, LocationMonitorConst.GET_CONNECT_WIFI_DURATION);     // Catch: Exception -> L70
        android.net.wifi.WifiInfo r6 = getConnectWifiInfo(r9, r11, r26, r28);     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_CONNECT_WIFI_DURATION);     // Catch: Exception -> L70
        if (r6 == null) goto L28;
        boolean r10 = true;
    L29:
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.HAS_CONNECT_WIFI, Boolean.valueOf(r10));     // Catch: Exception -> L70
        if (r6 == null) goto L32;
        addScanWifiInfoMonitor(r27, r6.toString(), r28);     // Catch: Exception -> L70
        String r1 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getBSSID(r6, r26);     // Catch: Exception -> L70
    L34:
        if (isValidWifiInfo(r1) == false) goto L41;
        WifiInfo r4 = new WifiInfo();     // Catch: Exception -> L70
        String r0 = BDLocationExtrasService.getBPEAManagerWithTag(r28).getSSID(r6, r26);     // Catch: Exception -> L70
        if (TextUtils.isEmpty(r0) == false) goto L38;
    L40:
        r4.wifiName = r0;     // Catch: Exception -> L70
        r4.wifiMac = r1;     // Catch: Exception -> L70
        r4.rssi = r6.getRssi();     // Catch: Exception -> L70
        r4.isCurrent = 1;     // Catch: Exception -> L70
        r4.timeStamp = WifiUtil.getCurrentTimeSeconds();     // Catch: Exception -> L70
        r4.frequency = r6.getFrequency();     // Catch: Exception -> L70
        r12.add(r4);     // Catch: Exception -> L70
    L42:
        if (r15 != null) goto L44;
    L67:
        long r2 = 0;
        long r13 = 0;
    L68:
        long r14 = r13 - r2;     // Catch: Exception -> L70
        WifiInfoModule r3 = new WifiInfoModule(r12, r4, r13);     // Catch: Exception -> L70
        long r7 = System.currentTimeMillis() - r3.cacheWifiTime;     // Catch: Exception -> L70
        long r17 = System.currentTimeMillis() - r2;     // Catch: Exception -> L70
        Logger.i("WifiInfoManager currentTimeMillis" + System.currentTimeMillis() + "--minCacheWifiTime:" + r2 + "--minCacheWifiInterval:" + r17);     // Catch: Exception -> L70
        StringBuilder r18 = new StringBuilder();     // Catch: Exception -> L70
        r18.append("WifiInfoManager maxCacheWifiTime:");     // Catch: Exception -> L70
        r18.append(r13);     // Catch: Exception -> L70
        r18.append("--maxCacheWifiInterval:");     // Catch: Exception -> L70
        r18.append(r7);     // Catch: Exception -> L70
        Logger.i(r18.toString());     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.CACHE_WIFI_INTERVAL, r7);     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.MIN_CACHE_WIFI_INTERVAL, r17);     // Catch: Exception -> L70
        LocationMonitor.locationTraceLogEnd(r29, LocationMonitorConst.GET_WIFI_CACHE_DURATION);     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.WIFI_CACHE_TIME_DIFFERENCE, r14);     // Catch: Exception -> L70
        LocationMonitor.locationTracePutMetricData(r29, LocationMonitorConst.WIFI_SCAN_RESULTS_NUM, r12.size());     // Catch: Exception -> L70
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS, Boolean.TRUE);     // Catch: Exception -> L70
        return r3;
    L44:
        if (r15.isEmpty() == true) goto L67;
        int r19 = r15.size();     // Catch: Exception -> L70
        int r20 = 0;
        long r110 = 0;
        long r111 = 0;
    L46:
        if (r20 >= r19) goto L66;
        ScanResult r21 = (ScanResult) ListProtector.get(r15, r20);     // Catch: Exception -> L70
        if (r21 != null) goto L50;
    L64:
        r19 = r19;
        r1 = r1;
        long r22 = r110;
        long r23 = r111;
    L65:
        r110 = r22;
        r20 = r20 + 1;     // Catch: Exception -> L70
        r111 = r23;
        r19 = r19;
        r1 = r1;
        goto L46
    L50:
        if (TextUtils.isEmpty(r21.SSID) == true) goto L64;
        if (TextUtils.isEmpty(r21.BSSID) == true) goto L64;
        if (r21.capabilities.contains("[IBSS]") == true) goto L64;
        if (r21.BSSID.equalsIgnoreCase(r1) == true) goto L64;
        WifiInfo r24 = new WifiInfo();     // Catch: Exception -> L70
        r24.wifiName = r21.SSID;     // Catch: Exception -> L70
        r24.wifiMac = r21.BSSID;     // Catch: Exception -> L70
        r24.rssi = r21.level;     // Catch: Exception -> L70
        r24.frequency = r21.frequency;     // Catch: Exception -> L70
        r24.isCurrent = 0;     // Catch: Exception -> L70
        long r112 = r110;
        long r113 = (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r21.timestamp / 1000);     // Catch: Exception -> L70
        long r30 = r111;
        if (r30 != 0) goto L62;
        r23 = r113;
    L63:
        r22 = Math.max(r112, r113);     // Catch: Exception -> L70
        r24.timeStamp = r113 / 1000;     // Catch: Exception -> L70
        r12.add(r24);     // Catch: Exception -> L70
        goto L65
    L62:
        r23 = Math.min(r30, r113);     // Catch: Exception -> L70
        goto L63
    L66:
        r2 = r111;
        r13 = r110;
        goto L68
    L38:
        if (r0.matches("\".*\"") == false) goto L40;
        r0 = r0.substring(1, r0.length() - 1);     // Catch: Exception -> L70
        goto L40
    L41:
        r4 = null;
        goto L42
    L32:
        addScanWifiInfoMonitor(r27, "", r28);     // Catch: Exception -> L70
        r1 = null;
        goto L34
    L28:
        r10 = false;
        goto L29
    L24:
        r8 = false;
        goto L25
    L17:
        if (r15.isEmpty() == true) goto L19;
        r16 = true;
        goto L20
    L11:
        if (PermissionManager.hasAnyPermission(r9, r29, new String[]{"android.permission.ACCESS_FINE_LOCATION"}) == true) goto L14;
        r15 = null;
    L70:
        e = move-exception;
        LocationMonitor.locationTracePutCategoryData(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_SUCCESS, Boolean.FALSE);
        LocationMonitor.locationTracePutLogExtra(r29, LocationMonitorConst.GET_WIFI_SCAN_RESULTS_ERROR_MESSAGE, e.getMessage());
        Logger.v(TAG, "WifiInfo: scan exception", e);
        return null;
    }

    private static /* synthetic */ void lambda$notifyWifiInfos$2(WifiInfoCallback r0, List r1, boolean r2, boolean r3, WifiInfo r4) {
        r0.onWifiInfo(r1, r2, r3, r4);
    }

    private static /* synthetic */ void lambda$notifyWifiInfos$3(WifiInfoCallback r0, List r1, boolean r2, boolean r3, WifiInfo r4) {
        r0.onWifiInfo(r1, r2, r3, r4);
    }
}
