package com.bytedance.dora.wlan.direct;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.byted.cast.common.bean.State;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.bytedance.dora.protocol.LinkWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import me.ele.lancet.base.annotations.Skip;
import pk4.i;
import pk4.j;
import pk4.n;
import sk4.d;
import vk4.f;
import wk4.b;
import wk4.g;
import wk4.h;
import wk4.k;
import wk4.l;

/* JADX INFO: loaded from: classes15.dex */
public class WifiDirectOwnerProxy extends BroadcastReceiver implements com.bytedance.dora.wlan.direct.a, IDoraLinkCallback, d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f204669k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiP2pManager f204670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiManager f204671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WifiP2pManager.Channel f204672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Set<Integer> f204673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f204674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f204675f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f204676g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f204677h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile int f204678i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f204679j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final WifiDirectOwnerProxy f204680a = null;

        static {
            f204680a = new WifiDirectOwnerProxy(0);
        }
    }

    public static boolean o() {
        WifiManager r100 = (WifiManager) n.f529659c.getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L5
        return ((Boolean) r100.getClass().getMethod("isWifiApEnabled", new Class[0]).invoke(r100, new Object[0])).booleanValue();
    L5:
        e = move-exception;
        j.c("WifiDirectOwnerProxy@8321b42", "isHotspotEnabled", e);
        return false;
    }

    @Override // sk4.d
    public final void A(int r100, int r101, byte[] r102, byte[] r103) {
    }

    @Override // sk4.d
    public final /* synthetic */ void b() {
    }

    @Override // sk4.d
    public final /* synthetic */ void c(int r100, int r101, int r102) {
    }

    @Override // sk4.d
    public final /* synthetic */ void d(int r100) {
    }

    @Override // sk4.d
    public final /* synthetic */ void f(String r100) {
    }

    @Override // sk4.d
    public final /* synthetic */ void g(int r100, long r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void h(int r100) {
    }

    @Override // sk4.d
    public final /* synthetic */ void j(int r100) {
    }

    @Override // sk4.d
    public final /* synthetic */ void l(int r100) {
    }

    @Override // sk4.d
    public final /* synthetic */ void n() {
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onBtConnectStateChanged(DoraDevice r100, int r101, int r102) {
        IDoraLinkCallback.CC.$default$onBtConnectStateChanged(this, r100, r101, r102);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onBtStateChanged(int r100, int r101) {
        IDoraLinkCallback.CC.$default$onBtStateChanged(this, r100, r101);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onDeviceFound(DoraDevice r100) {
        IDoraLinkCallback.CC.$default$onDeviceFound(this, r100);
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final /* synthetic */ void onScanFailed(int r100) {
        IDoraLinkCallback.CC.$default$onScanFailed(this, r100);
    }

    @Override // sk4.d
    public final void q(int r100, byte[] r101) {
    }

    @Override // sk4.d
    public final /* synthetic */ void r(int r100, int r101, int r102) {
    }

    @Override // sk4.d
    public final /* synthetic */ void w(int r100, int r101) {
    }

    public final int t() {
        if (this.f204678i == 1) goto L5;
        WifiManager r100 = this.f204671b;
        if (r100 == null) goto L13;
        if (r100.getWifiState() == 3) goto L13;
        return 2;
    L13:
        if (o() == false) goto L16;
        return 3;
    L16:
        if (n.h() == true) goto L19;
        return 4;
    L19:
        return 0;
    L5:
        return this.f204678i;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [wk4.b] */
    private WifiDirectOwnerProxy() {
        this.f204670a = (WifiP2pManager) n.f529659c.getSystemService("wifip2p");
        this.f204671b = (WifiManager) n.f529659c.getSystemService("wifi");
        this.f204673d = new CopyOnWriteArraySet();
        this.f204674e = 0;
        this.f204675f = 0;
        this.f204676g = 0;
        this.f204677h = new b(this);
        this.f204678i = 0;
        this.f204679j = false;
        kj4.a.g().registerDoraLinkCallback(this);
        kj4.a.g().registerDoraVoiceCallback(this);
    }

    public /* synthetic */ WifiDirectOwnerProxy(int r100) {
        this();
    }

    public final void m(int r100) {
        ((CopyOnWriteArraySet) this.f204673d).remove(Integer.valueOf(r100));
        j.d("WifiDirectOwnerProxy@8321b42", "disconnect, type: " + r100 + ", arc: " + Arrays.toString(((CopyOnWriteArraySet) this.f204673d).toArray()));
        if (((CopyOnWriteArraySet) this.f204673d).isEmpty() == true) goto L5;
        return;
    L5:
        if (this.f204670a != null) goto L7;
        return;
    L7:
        if (this.f204672c == null) goto L12;
        this.f204670a.removeGroup(this.f204672c, new l(r100, SystemClock.elapsedRealtime()));
        return;
    }

    public final void p(String r100) {
        j.d("WifiDirectOwnerProxy@8321b42", "onStopLiveMode: from=" + r100);
        this.f204679j = false;
        HashMap r101 = new HashMap();
        r101.put("result", Integer.valueOf(t()));
        pk4.l.c("d_wlan_live", r101);
        m(1);
    }

    public final int s(int r110) {
        int r100 = i.a.f529628a.f529627a.getInt("wlan_switch_state", 0);
        j.d("WifiDirectOwnerProxy@8321b42", "start, type: " + r110 + ", p2pState: " + this.f204678i + ", enable: " + r100);
        if (r110 != 1) goto L7;
        if (r100 != 0) goto L7;
        j.d("WifiDirectOwnerProxy@8321b42", "p2p disabled in vui");
        return 1;
    L7:
        HashMap r101 = new HashMap();
        WifiManager r102 = this.f204671b;
        if (r102 == null) goto L14;
        if (r102.getWifiState() == 3) goto L14;
        this.f204678i = 2;
        r101.put("result", Integer.valueOf(this.f204678i));
        r101.put("scene", Integer.valueOf(r110));
        r101.put("t0", 0L);
        r101.put("t1", 0L);
        r101.put("t", 0L);
        pk4.l.c("d_wlan_start", r101);
        return 2;
    L14:
        if (o() == false) goto L18;
        this.f204678i = 3;
        r101.put("result", Integer.valueOf(this.f204678i));
        r101.put("scene", Integer.valueOf(r110));
        r101.put("t0", 0L);
        r101.put("t1", 0L);
        r101.put("t", 0L);
        pk4.l.c("d_wlan_start", r101);
        return 3;
    L18:
        if (n.h() == true) goto L22;
        this.f204678i = 4;
        r101.put("result", Integer.valueOf(this.f204678i));
        r101.put("scene", Integer.valueOf(r110));
        r101.put("t0", 0L);
        r101.put("t1", 0L);
        r101.put("t", 0L);
        pk4.l.c("d_wlan_start", r101);
        return 4;
    L22:
        if (this.f204678i != 2) goto L24;
    L27:
        j.d("WifiDirectOwnerProxy@8321b42", "start: reset state from " + this.f204678i + " to 0");
        this.f204678i = 0;
    L28:
        this.f204674e = System.currentTimeMillis();
        j.d("WifiDirectOwnerProxy@8321b42", "initGO start");
        monitor-enter(this);
    L47:
        th = move-exception;
        throw th;
    L31:
        if (this.f204670a != null) goto L36;
        j.d("WifiDirectOwnerProxy@8321b42", "ensureChannelInit, manager is null");     // Catch: Throwable -> L47
        monitor-exit(this);
    L42:
        this.f204670a.requestGroupInfo(this.f204672c, new g(this, r110));
        if (Build.VERSION.SDK_INT < 29) goto L45;
        this.f204670a.requestP2pState(this.f204672c, new h());
        this.f204670a.requestNetworkInfo(this.f204672c, new wk4.i());
        this.f204670a.requestDeviceInfo(this.f204672c, new wk4.j());
    L45:
        this.f204670a.requestConnectionInfo(this.f204672c, new k());
        ((CopyOnWriteArraySet) this.f204673d).add(Integer.valueOf(r110));
        this.f204676g = r110;
        j.d("WifiDirectOwnerProxy@8321b42", "start, type: " + r110 + ", p2pState: " + this.f204678i + ", enable: " + r100 + ", arc: " + Arrays.toString(((CopyOnWriteArraySet) this.f204673d).toArray()));
        return 1;
    L36:
        if (this.f204672c == null) goto L40;
        j.d("WifiDirectOwnerProxy@8321b42", "ensureChannelInit, channel already initialized");     // Catch: Throwable -> L47
        monitor-exit(this);
        goto L42
    L40:
        long r103 = System.currentTimeMillis();     // Catch: Throwable -> L47
        this.f204672c = this.f204670a.initialize(n.f529659c, Looper.getMainLooper(), null);     // Catch: Throwable -> L47
        IntentFilter r104 = new IntentFilter();     // Catch: Throwable -> L47
        r104.addAction("android.net.wifi.p2p.STATE_CHANGED");     // Catch: Throwable -> L47
        r104.addAction("android.net.wifi.p2p.PEERS_CHANGED");     // Catch: Throwable -> L47
        r104.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");     // Catch: Throwable -> L47
        r104.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");     // Catch: Throwable -> L47
        a(n.f529659c, this, r104);     // Catch: Throwable -> L47
        j.d("WifiDirectOwnerProxy@8321b42", "ensureChannelInit, channel initialized, cost: " + (System.currentTimeMillis() - r103));     // Catch: Throwable -> L47
        monitor-exit(this);
        goto L42
    L24:
        if (this.f204678i == 3) goto L27;
        if (this.f204678i != 4) goto L28;
        goto L27
    }

    public static void k(WifiDirectOwnerProxy r100, WifiP2pGroup r110) {
        r100.getClass();
        j.d("WifiDirectOwnerProxy@8321b42", "groupReady: " + r110);
        if (r110 == null) goto L6;
        r100.f204675f = System.currentTimeMillis();
        n.f529660d.postDelayed(r100.f204677h, 20000);
        ak4.a r101 = f.f555491c;
        f r102 = f.a.f555494a;
        String r103 = r110.getNetworkName();
        String r111 = r110.getPassphrase();
        r102.getClass();
        j.d("DoraWlanManager@8321b42", "configWlanGO, ssid: " + r103 + ", pass: " + r111);
        int r104 = f.f555491c.i(1, 12, LinkWrapper.wlanConfigCommand((byte) 5, n.u(r103.getBytes(), new byte[]{0}), n.u(r111.getBytes(), new byte[]{0}), (byte) 1, (byte) 1, 0, null));
        HashMap r112 = new HashMap();
        r112.put("result", Integer.valueOf(r104));
        pk4.l.c("d_wifi_p2p_config_wlan", r112);
        return;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        j.d("WifiDirectOwnerProxy@8321b42", "onReceive: " + r101.getAction());
        String r102 = r101.getAction();
        r102.getClass();
        switch(r102.hashCode()) {
            case -1772632330: goto L14;
            case -1566767901: goto L10;
            case 1695662461: goto L6;
            default: goto L4;
        };
    L4:
        byte r103 = -1;
    L17:
        switch(r103) {
            case 0: goto L27;
            case 1: goto L20;
            case 2: goto L19;
            default: goto L49;
        };
    L19:
        j.d("WifiDirectOwnerProxy@8321b42", "WIFI_P2P_STATE_CHANGED_ACTION: " + r101.getIntExtra("wifi_p2p_state", -1));
        return;
    L20:
        WifiP2pDevice r104 = (WifiP2pDevice) r101.getParcelableExtra("wifiP2pDevice");
        j.d("WifiDirectOwnerProxy@8321b42", "WIFI_P2P_THIS_DEVICE_CHANGED_ACTION: " + r104);
        if (r104 != null) goto L23;
        return;
    L23:
        if (r104.status != 3) goto L25;
        return;
    L25:
        if (((CopyOnWriteArraySet) this.f204673d).isEmpty() == true) goto L47;
        Object[] r105 = ((CopyOnWriteArraySet) this.f204673d).toArray();
        j.d("WifiDirectOwnerProxy@8321b42", "reconnect, arc: " + Arrays.toString(r105));
        s(((Integer) r105[0]).intValue());
        return;
    L47:
        return;
    L27:
        NetworkInfo r106 = (NetworkInfo) r101.getParcelableExtra("networkInfo");
        WifiP2pInfo r107 = (WifiP2pInfo) r101.getParcelableExtra("wifiP2pInfo");
        WifiP2pGroup r108 = (WifiP2pGroup) r101.getParcelableExtra("p2pGroupInfo");
        j.d("WifiDirectOwnerProxy@8321b42", "WIFI_P2P_CONNECTION_CHANGED_ACTION, networkInfo: " + r106 + ", p2pInfo: " + r107 + ", p2pGroup: " + r108);
        int r109 = this.f204678i;
        if (r106 != null) goto L30;
    L32:
        if (r108 != null) goto L34;
    L42:
        u(r109, this.f204678i);
        return;
    L34:
        if (r108.isGroupOwner() == false) goto L42;
        Collection<WifiP2pDevice> r110 = r108.getClientList();
        if (r110 != null) goto L38;
    L41:
        j.d("WifiDirectOwnerProxy@8321b42", "clientList is null");
        this.f204678i = 0;
        goto L42
    L38:
        if (r110.isEmpty() == true) goto L41;
        this.f204678i = 1;
        goto L42
    L30:
        if (r106.getState() != NetworkInfo.State.DISCONNECTED) goto L32;
        j.d("WifiDirectOwnerProxy@8321b42", "networkInfo is disconnected");
        this.f204678i = 0;
        goto L32
    L49:
        return;
    L6:
        if (r102.equals("android.net.wifi.p2p.STATE_CHANGED") == false) goto L4;
        r103 = 2;
        goto L17
    L10:
        if (r102.equals("android.net.wifi.p2p.THIS_DEVICE_CHANGED") == false) goto L4;
        r103 = 1;
        goto L17
    L14:
        if (r102.equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE") == false) goto L4;
        r103 = 0;
        goto L17
    }

    public final void u(int r100, int r101) {
        if (r100 == r101) goto L15;
        ak4.a r102 = f.f555491c;
        vk4.k r103 = f.a.f555494a.f555492a;
        if (r101 == 1) goto L6;
    L7:
        n.f529660d.removeCallbacks(this.f204677h);
        int r104 = t();
        j.d("WifiDirectOwnerProxy@8321b42", "updateState: " + r100 + " -> " + r101 + ", newState: " + r104);
        if (r101 != 1) goto L10;
        HashMap r105 = new HashMap();
        r105.put("result", Integer.valueOf(r101));
        r105.put("scene", Integer.valueOf(this.f204676g));
        r105.put("t0", Long.valueOf(this.f204675f - this.f204674e));
        r105.put("t1", Long.valueOf(System.currentTimeMillis() - this.f204675f));
        r105.put("t", Long.valueOf(System.currentTimeMillis() - this.f204674e));
        pk4.l.c("d_wlan_start", r105);
    L11:
        Iterator r106 = ((CopyOnWriteArraySet) com.bytedance.dora.wlan.direct.a.f204681q1).iterator();
    L13:
        if (r106.hasNext() == false) goto L18;
        ((com.bytedance.dora.wlan.direct.a.InterfaceC2962a) r106.next()).Xb();
        goto L13
    L18:
        return;
    L10:
        HashMap r107 = new HashMap();
        r107.put("result", Integer.valueOf(r104));
        r107.put("scene", Integer.valueOf(this.f204676g));
        pk4.l.c("d_wlan_end", r107);
        this.f204676g = 0;
        goto L11
    L6:
        if (TextUtils.isEmpty(r103.f555497c) == false) goto L7;
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }

    @Override // com.bytedance.dora.link.IDoraLinkCallback
    public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
        if (r102 == 0) goto L4;
        return;
    L4:
        if (this.f204679j == false) goto L8;
        p(State.DISCONNECTED);
        return;
    }

    @Override // sk4.d
    public final void e(int r100, int r101, int r102, int r103, int r104, String r105, String r106) {
        j.d("WifiDirectOwnerProxy@8321b42", "onVoiceWakeUp, state: " + r100 + ", mode: " + r101 + ", query: " + r102 + ", vuiId: " + r104 + ", kw: " + r105);
        int r107 = i.a.f529628a.f529627a.getInt("wlan_switch_state", 0);
        StringBuilder r108 = new StringBuilder("onVoiceWakeUp, enable: ");
        r108.append(r107);
        j.d("WifiDirectOwnerProxy@8321b42", r108.toString());
        if (r101 == 6) goto L5;
    L10:
        if (r102 == 2) goto L12;
        return;
    L12:
        if (this.f204679j == false) goto L19;
        p("MODE-" + r101 + "-WakeQuery-START");
        return;
    L19:
        return;
    L5:
        if (r107 != 1) goto L10;
        if (r102 != 2) goto L8;
        j.d("WifiDirectOwnerProxy@8321b42", "onStartLiveMode");
        this.f204679j = true;
        s(1);
        return;
    L8:
        if (r102 != 1) goto L16;
        p("LiveVoice-WakeQuery-STOP");
        return;
    }

    @Override // sk4.d
    public final void i(int r100, String r101, int r102, float r103, float r104, float r105, int r106, int r107, float r110, float r111) {
        j.d("WifiDirectOwnerProxy@8321b42", "onPreWakeUp: " + r100 + " - " + r101 + " - " + r102 + " - " + r103 + " - " + r104 + " - " + r105 + " - " + r106 + " - " + r107 + " - " + r110);
    }
}
