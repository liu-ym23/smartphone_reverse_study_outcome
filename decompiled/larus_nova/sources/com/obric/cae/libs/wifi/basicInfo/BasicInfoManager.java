package com.obric.cae.libs.wifi.basicInfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes33.dex */
public class BasicInfoManager {
    public static final int INT_ERROR = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static BasicInfoManager f395993h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiManager f395994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiState f395995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ScanResultBean f395996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ChannelsEnvironment f395997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArrayList<WifiChangeListener> f395998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f395999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WifiInfoBean f396000g;

    public class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BasicInfoManager f396001a;

        public a(BasicInfoManager r100) {
            this.f396001a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            String r102 = r101.getAction();
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(r102) == false) goto L10;
            this.f396001a.f395995b.handleWifiStateChanged(r101.getIntExtra("wifi_state", 4));
            BasicInfoManager r103 = this.f396001a;
            int r104 = r103.f395995b.getState();
            Iterator<WifiChangeListener> r105 = r103.f395998e.iterator();
        L6:
            if (r105.hasNext() == false) goto L8;
            r105.next().onWifiStateChanged(r104);
            goto L6
        L8:
            this.f396001a.b();
            return;
        L10:
            if ("android.net.wifi.STATE_CHANGE".equals(r102) == false) goto L17;
            NetworkInfo r106 = (NetworkInfo) r101.getParcelableExtra("networkInfo");
            this.f396001a.f395995b.handleConnectStateChanged(r106.getDetailedState());
            BasicInfoManager r107 = this.f396001a;
            int r108 = r107.f395995b.getState();
            Iterator<WifiChangeListener> r109 = r107.f395998e.iterator();
        L13:
            if (r109.hasNext() == false) goto L15;
            r109.next().onWifiStateChanged(r108);
            goto L13
        L15:
            this.f396001a.b();
            return;
        L17:
            if ("android.net.wifi.SCAN_RESULTS".equals(r102) == false) goto L23;
            this.f396001a.f395997d.update();
            this.f396001a.f395996c.update();
            BasicInfoManager r110 = this.f396001a;
            List<ScanResult> r111 = WifiUtils.getWifiScanResults(r110.f395999f, r110.f395994a);
            Iterator<WifiChangeListener> r112 = r110.f395998e.iterator();
        L20:
            if (r112.hasNext() == false) goto L32;
            r112.next().onScanInfoChanged(r111);
            goto L20
        L32:
            return;
        L23:
            if ("android.net.wifi.RSSI_CHANGED".equals(r102) == false) goto L31;
            this.f396001a.b();
            return;
        }
    }

    public final void a() {
        if (this.f395994a.isWifiEnabled() == true) goto L5;
        this.f395995b.handleWifiStateChanged(1);
        return;
    L5:
        this.f395995b.handleWifiStateChanged(3);
        if (WifiUtils.isWifiConnected(this.f395999f) == false) goto L8;
        this.f395995b.handleConnectStateChanged(NetworkInfo.DetailedState.CONNECTED);
        return;
    L8:
        this.f395995b.handleWifiStateChanged(3);
    }

    public final void b() {
        WifiInfoBean r100 = this.f396000g.update();
        if (r100 != null) goto L5;
        return;
    L5:
        LogUtil.d("BasicInfoManager", "Update WifiInfoBean:" + r100.toString());
        if (r100.equals(this.f396000g) == true) goto L14;
        Iterator<WifiChangeListener> r101 = this.f395998e.iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        r101.next().onWifiInfoChanged(true);
        goto L9
    L11:
        this.f396000g = r100;
        return;
    }

    public int getWifiStandard() {
        return this.f396000g.getWifiStandard();
    }

    public int getWifiState() {
        return this.f395995b.getState();
    }

    public int getBand() {
        int r100 = getFrequency();
        if (WifiUtils.is24GHz(r100) == false) goto L7;
        return 1;
    L7:
        if (WifiUtils.is5GHz(r100) == false) goto L11;
        return 2;
    L11:
        if (WifiUtils.is6GHz(r100) == false) goto L14;
        return 8;
    L14:
        return -1;
    }

    public int getBandwidth() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f395996c.getBandwidth();
    }

    public String getBssid() {
        if (getWifiState() == 5) goto L5;
        return null;
    L5:
        return this.f396000g.getBssid();
    }

    public int getChannel() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.f396000g.getChannel();
    }

    public int getCurrentChannelUsedCount() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f395996c.getCurrentChannelUsedCount();
    }

    public int getFrequency() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.f396000g.getFrequency();
    }

    public List<ScanResult> getLastScanResults() {
        if (getWifiState() >= 3) goto L7;
        return null;
    L7:
        return this.f395996c.getLastScanResults();
    }

    public int getRssi() {
        if (getWifiState() == 5) goto L5;
        return -1;
    L5:
        return this.f396000g.getRssi();
    }

    public int getRxLinkSpeedMbps() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f396000g.getRxLinkSpeedMbps();
    }

    public String getSsid() {
        if (getWifiState() == 5) goto L5;
        return null;
    L5:
        return this.f396000g.getSsid();
    }

    public int getTxLinkSpeedMbps() {
        if (getWifiState() == 5) goto L7;
        return -1;
    L7:
        return this.f396000g.getTxLinkSpeedMbps();
    }

    public void refreshData() {
        b();
        startScan();
    }

    public boolean startScan() {
        if (getWifiState() >= 3) goto L6;
        LogUtil.i("BasicInfoManager", "startScan failed");
        return false;
    L6:
        LogUtil.i("BasicInfoManager", "startScan");
        return this.f395996c.startScan();
    }

    public BasicInfoManager(Context r100) {
        this.f395998e = new CopyOnWriteArrayList();
        a r101 = new a(this);
        this.f395999f = r100;
        WifiManager r102 = (WifiManager) r100.getSystemService("wifi");
        this.f395994a = r102;
        this.f395995b = new WifiState();
        this.f396000g = new WifiInfoBean(r102);
        this.f395997d = new ChannelsEnvironment(r100, r102);
        this.f395996c = new ScanResultBean(r100, r102);
        IntentFilter r103 = new IntentFilter("android.net.wifi.WIFI_STATE_CHANGED");
        r103.addAction("android.net.wifi.STATE_CHANGE");
        r103.addAction("android.net.wifi.SCAN_RESULTS");
        r103.addAction("android.net.wifi.RSSI_CHANGED");
        INVOKEVIRTUAL_com_obric_cae_libs_wifi_basicInfo_BasicInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r103);
        a();
        refreshData();
    }

    public static BasicInfoManager getInstance(Context r100) {
        if (r100 == null) goto L15;
        monitor-enter(BasicInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (f395993h != null) goto L8;
        f395993h = new BasicInfoManager(r100);     // Catch: Throwable -> L11
    L8:
        monitor-exit(BasicInfoManager.class);     // Catch: Throwable -> L11
        return f395993h;
    L15:
        throw new IllegalArgumentException("context cannot be null");
    }

    public boolean registerWifiChangeListener(WifiChangeListener r100) {
        return this.f395998e.add(r100);
    }

    public boolean unregisterWifiChangeListener(WifiChangeListener r100) {
        if (this.f395998e.contains(r100) == true) goto L5;
        return false;
    L5:
        return this.f395998e.remove(r100);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_cae_libs_wifi_basicInfo_BasicInfoManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
