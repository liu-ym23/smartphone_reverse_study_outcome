package com.bytedance.dora.wlan.p2p;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.collection.SieveCacheKt;
import androidx.core.content.ContextCompat;
import com.bytedance.dora.wlan.model.DoraWifiEventReason;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.dora.api.model.FlowDoraConnectReason;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
public final class DoraWifiP2p implements vk4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WifiP2pManager f204683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WifiManager f204684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WifiP2pManager.Channel f204685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final al4.a f204686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final o f204687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p f204688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.dora.wlan.p2p.a f204689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public vk4.i f204690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f204691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GoState f204692j;

    public static final enum GoState extends Enum<GoState> {
        public static final GoState ACTIVE = null;
        public static final GoState CREATING = null;
        public static final GoState DESTROYED = null;
        public static final GoState IDLE = null;
        public static final GoState READY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GoState[] f204693a = null;

        static {
            GoState r100 = new GoState("IDLE", 0);
            IDLE = r100;
            GoState r101 = new GoState("CREATING", 1);
            CREATING = r101;
            GoState r102 = new GoState("READY", 2);
            READY = r102;
            GoState r103 = new GoState("ACTIVE", 3);
            ACTIVE = r103;
            GoState r104 = new GoState("DESTROYED", 4);
            DESTROYED = r104;
            f204693a = new GoState[]{r100, r101, r102, r103, r104};
        }

        public static GoState[] values() {
            return (GoState[]) f204693a.clone();
        }

        public static GoState valueOf(String r100) {
            return (GoState) r27.a.a(GoState.class, r100);
        }

        public GoState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraWifiP2p f204694a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            int r101 = r100.what;
            if (r101 != 1000) goto L5;
            pk4.j.d("DoraWifiP2p", "handleTimeout: MSG_CREATE_GROUP_TIMEOUT");
            DoraWifiP2p r102 = this.f204694a;
            r102.f204692j = GoState.IDLE;
            r102.f204687e.a("P2pCreateGroupTimeout");
            o r103 = this.f204694a.f204687e;
            r103.f204739h = FlowDoraConnectReason.P2P_CREATE_GROUP_FAILED;
            r103.f204748q = SystemClock.elapsedRealtime();
            this.f204694a.f204688f.c(5, DoraWifiEventReason.MSG_CREATE_GROUP_TIMEOUT);
            return;
        L5:
            if (r101 != 2000) goto L11;
            pk4.j.d("DoraWifiP2p", "handleTimeout: MSG_SEND_CMD_TIMEOUT");
            this.f204694a.f204687e.a("P2pSendCmdTimeout");
            o r104 = this.f204694a.f204687e;
            r104.f204739h = FlowDoraConnectReason.P2P_CONNECTED_CALLBACK_TIMEOUT;
            r104.f204750s = SystemClock.elapsedRealtime();
            this.f204694a.f204688f.c(5, DoraWifiEventReason.MSG_SEND_CMD_TIMEOUT);
            return;
        }

        public a(DoraWifiP2p r100, Looper r101) {
            this.f204694a = r100;
            super(r101);
        }
    }

    public class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoraWifiP2p f204695a;

        public b(DoraWifiP2p r100) {
            this.f204695a = r100;
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r100, Intent r101) {
            if (r101 != null) goto L5;
        L65:
            pk4.j.b("DoraWifiP2p", "onReceive: intent or intent action is null");
            return;
        L5:
            if (r101.getAction() == null) goto L65;
            String r102 = r101.getAction();
            r102.getClass();
            int r103 = 0;
            switch(r102.hashCode()) {
                case -1772632330: goto L23;
                case -1566767901: goto L19;
                case -1394739139: goto L15;
                case 1695662461: goto L11;
                default: goto L9;
            };
        L9:
            byte r104 = -1;
        L26:
            switch(r104) {
                case 0: goto L38;
                case 1: goto L37;
                case 2: goto L29;
                case 3: goto L28;
                default: goto L77;
            };
        L28:
            pk4.j.d("DoraWifiP2p", "onReceive: WIFI_P2P_STATE_CHANGED_ACTION: state=" + r101.getIntExtra("wifi_p2p_state", -1));
            return;
        L29:
            WifiP2pDeviceList r105 = (WifiP2pDeviceList) r101.getParcelableExtra("wifiP2pDeviceList");
            if (r105 == null) goto L36;
            Collection<WifiP2pDevice> r106 = r105.getDeviceList();
            StringBuilder r107 = new StringBuilder("onReceive: WIFI_P2P_PEERS_CHANGED_ACTION: deviceCount=");
            if (r106 == null) goto L35;
            r103 = r106.size();
        L35:
            r107.append(r103);
            pk4.j.d("DoraWifiP2p", r107.toString());
            return;
        L36:
            pk4.j.d("DoraWifiP2p", "onReceive: WIFI_P2P_PEERS_CHANGED_ACTION: p2pDeviceList is null");
            return;
        L37:
            pk4.j.d("DoraWifiP2p", "onReceive: WIFI_P2P_THIS_DEVICE_CHANGED_ACTION: " + u.c((WifiP2pDevice) r101.getParcelableExtra("wifiP2pDevice")));
            return;
        L38:
            NetworkInfo r108 = (NetworkInfo) r101.getParcelableExtra("networkInfo");
            WifiP2pInfo r109 = (WifiP2pInfo) r101.getParcelableExtra("wifiP2pInfo");
            WifiP2pGroup r110 = (WifiP2pGroup) r101.getParcelableExtra("p2pGroupInfo");
            pk4.j.d("DoraWifiP2p", "onReceive: WIFI_P2P_CONNECTION_CHANGED_ACTION: networkInfo=" + u.c(r108) + ", p2pInfo=" + u.c(r109) + ", p2pGroup=" + u.c(r110));
            o r111 = this.f204695a.f204687e;
            StringBuilder r112 = new StringBuilder("P2pConnectionChanged-");
            r112.append(this.f204695a.f204692j);
            r112.append("-");
            if (r108 != null) goto L41;
            Object r113 = "null";
        L42:
            r112.append(r113);
            r111.a(r112.toString());
            if (this.f204695a.f204692j != GoState.CREATING) goto L48;
            if (r108 == null) goto L48;
            if (r108.isConnected() == false) goto L48;
            DoraWifiP2p r114 = this.f204695a;
            r114.f204683a.requestGroupInfo(r114.f204685c, new i(this));
            return;
        L48:
            GoState r115 = this.f204695a.f204692j;
            if (r115 != GoState.ACTIVE) goto L51;
        L52:
            if (r108 != null) goto L54;
        L56:
            if (r110 != null) goto L58;
            return;
        L58:
            if (r110.isGroupOwner() == false) goto L75;
            Collection<WifiP2pDevice> r116 = r110.getClientList();
            if (r116 != null) goto L62;
        L63:
            pk4.j.d("DoraWifiP2p", "Client disconnected: client list is empty");
            this.f204695a.f204688f.c(7, DoraWifiEventReason.P2P_CLIENTS_EMPTY);
            return;
        L62:
            if (r116.isEmpty() == true) goto L63;
            return;
        L75:
            return;
        L54:
            if (r108.getState() != NetworkInfo.State.DISCONNECTED) goto L56;
            pk4.j.d("DoraWifiP2p", "Client disconnected: network disconnected");
            DoraWifiP2p r117 = this.f204695a;
            r117.f204687e.f204739h = "p2pNetworkDisconnected";
            r117.f204688f.c(6, DoraWifiEventReason.P2P_NETWORK_DISCONNECTED);
            return;
        L51:
            if (r115 == GoState.READY) goto L52;
            return;
        L41:
            r113 = Boolean.valueOf(r108.isConnected());
            goto L42
        L77:
            return;
        L11:
            if (r102.equals("android.net.wifi.p2p.STATE_CHANGED") == false) goto L9;
            r104 = 3;
            goto L26
        L15:
            if (r102.equals("android.net.wifi.p2p.PEERS_CHANGED") == false) goto L9;
            r104 = 2;
            goto L26
        L19:
            if (r102.equals("android.net.wifi.p2p.THIS_DEVICE_CHANGED") == false) goto L9;
            r104 = 1;
            goto L26
        L23:
            if (r102.equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE") == false) goto L9;
            r104 = 0;
            goto L26
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DoraWifiP2p f204696a = null;

        static {
            f204696a = new DoraWifiP2p();
        }
    }

    public final String e() {
        WifiManager r100 = this.f204684b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = false;
        WifiManager r102 = (WifiManager) pk4.n.f529659c.getApplicationContext().getSystemService("wifi");     // Catch: Exception -> L11
        r101 = ((Boolean) r102.getClass().getMethod("isWifiApEnabled", new Class[0]).invoke(r102, new Object[0])).booleanValue();     // Catch: Exception -> L11
    L13:
        if (r101 == false) goto L17;
        return FlowDoraConnectReason.P2P_CHECK_HOTSPOT_OPEN;
    L17:
        if (Build.VERSION.SDK_INT < 33) goto L19;
        return "success";
    L19:
        if (pk4.n.h() == true) goto L26;
        return FlowDoraConnectReason.P2P_CHECK_LOCATION_NOT_PASS;
    L26:
        return "success";
    L11:
        e = move-exception;
        pk4.j.c("DoraWifiP2pUtils", "isHotspotEnabled", e);
        goto L13
    L5:
        if (r100.getWifiState() == 3) goto L8;
        return FlowDoraConnectReason.P2P_CHECK_WIFI_NOT_OPEN;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.dora.wlan.p2p.a] */
    public DoraWifiP2p() {
        this.f204683a = (WifiP2pManager) pk4.n.f529659c.getSystemService("wifip2p");
        this.f204684b = (WifiManager) pk4.n.f529659c.getSystemService("wifi");
        this.f204686d = al4.a.C0080a.f4130a;
        o r100 = new o();
        this.f204687e = r100;
        this.f204689g = new com.bytedance.dora.wlan.p2p.a(this);
        this.f204691i = new a(this, dl4.a.f469113a.getLooper());
        this.f204692j = GoState.IDLE;
        p r101 = new p(r100);
        this.f204688f = r101;
        r101.f204758c = new com.bytedance.dora.wlan.p2p.b(this);
        IntentFilter r102 = new IntentFilter();
        r102.addAction("android.net.wifi.p2p.STATE_CHANGED");
        r102.addAction("android.net.wifi.p2p.PEERS_CHANGED");
        r102.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
        r102.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
        b r103 = new b(this);
        Application r104 = pk4.n.f529659c;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r103, r102);
    L33:
        long r105 = SystemClock.elapsedRealtime();
        this.f204685c = this.f204683a.initialize(pk4.n.f529659c, dl4.a.f469113a.getLooper(), null);
        pk4.j.d("DoraWifiP2p", "ensureInit, channel initialized, cost: " + (SystemClock.elapsedRealtime() - r105));
        ((CopyOnWriteArraySet) this.f204686d.f4128a).add(new com.bytedance.dora.wlan.p2p.c(this));
        vj4.b r106 = vj4.b.a.f555417a;
        com.bytedance.dora.wlan.p2p.a r107 = this.f204689g;
        if (r107 == null) goto L36;
        ((CopyOnWriteArraySet) r106.f555414a).add(r107);
        return;
    L36:
        r106.getClass();
        return;
    L38:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r102) == false) goto L20;
        int r108 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r103, r102, 0, null, null, 2, r104).result;     // Catch: Exception -> L29
        if (r108 != 1) goto L13;
        r104.registerReceiver(r103, r102);     // Catch: Exception -> L29
    L39:
        goto L33
    L13:
        if (r108 != 2) goto L15;
        new Intent();     // Catch: Exception -> L29
        goto L39
    L15:
        if (r108 == 3) goto L39;
        r104.registerReceiver(r103, r102);     // Catch: Exception -> L29
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r104.registerReceiver(r103, r102, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        goto L39
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r104.registerReceiver(r103, r102);     // Catch: Exception -> L29
        goto L39
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r102) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r104, r103, r102, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
        goto L39
    }

    @Override // vk4.g
    public final String c() {
        return e();
    }

    public static int f(byte[] r100, int r101) {
        if (r100 == null) goto L32;
        int r102 = 2;
        if (r100.length < 2) goto L32;
        int r103 = g(r100, 0, r100.length, r101);
        if (r103 < 0) goto L10;
        return r103;
    L10:
        int r104 = r100[0] & UByte.MAX_VALUE;
        if (r104 == 4) goto L15;
        if (r104 != 132) goto L32;
    L15:
        if (r100.length <= 2) goto L32;
        int r105 = r100.length;
        if (1 < r105) goto L19;
    L18:
        int r106 = -1;
    L26:
        if ((r100[1] & ByteCompanionObject.MIN_VALUE) != 0) goto L28;
        r102 = 1;
    L28:
        int r107 = r102 + 1;
        int r108 = Math.min(r106, r100.length - r107);
        if (r108 <= 0) goto L32;
        return g(r100, r107, r108 + r107, r101);
    L19:
        r106 = r100[1] & UByte.MAX_VALUE;
        if ((r106 & 128) == 0) goto L26;
        if (2 >= r105) goto L18;
        int r109 = (r106 & 127) * 128;
        r106 = (r100[2] & UByte.MAX_VALUE) + r109;
    L32:
        return -1;
    }

    @Override // vk4.g
    public final void a(final String r100, final DoraWifiScene r101) {
        dl4.a.a(new f(this, r100, r101));
    }

    @Override // vk4.g
    public final void b(final String r100, final DoraWifiScene r101) {
        dl4.a.a(new d(this, r100, r101));
    }

    public static void d(DoraWifiP2p r110, o r111, int r112) {
        r110.getClass();
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 29) goto L5;
        String r101 = pk4.n.n();
        String r102 = "CzxZ2LTx";
        WifiP2pConfig r103 = new WifiP2pConfig.Builder().setNetworkName(r101).setPassphrase("CzxZ2LTx").enablePersistentMode(true).setGroupOperatingFrequency(5745).build();
    L6:
        WifiP2pConfig r104 = r103;
        r104.wps.setup = 0;
        r111.f204738g = 5745;
        r111.f204741j = 5745;
        h(r111, r101, r102, 5745);
        m r105 = new m(r110, r111, r112, SystemClock.elapsedRealtime());
        pk4.j.d("DoraWifiP2p", "fallbackCreateGroup start");
        if (r100 < 29) goto L9;
        r110.f204683a.createGroup(r110.f204685c, r104, r105);
        return;
    L9:
        r110.f204683a.createGroup(r110.f204685c, r105);
        return;
    L5:
        r103 = new WifiP2pConfig();
        r101 = "";
        r102 = "";
        goto L6
    }

    public static int g(byte[] r100, int r101, int r102, int r103) {
    L3:
        if ((r101 + 2) > r102) goto L32;
        int r104 = r101 + 1;
        int r105 = r100[r101] & 127;
        if (r104 < r102) goto L7;
    L6:
        int r106 = -1;
    L15:
        if ((r100[r104] & ByteCompanionObject.MIN_VALUE) != 0) goto L17;
        int r107 = 1;
    L18:
        int r108 = r104 + r107;
        if (r106 < 0) goto L32;
        int r109 = r108 + r106;
        if (r109 > r102) goto L32;
        if (r105 != r103) goto L31;
        if (r106 <= 0) goto L31;
        if (r106 > 4) goto L31;
        int r110 = 0;
        int r111 = 0;
    L28:
        if (r110 >= r106) goto L30;
        r111 = (r111 << 8) | (r100[r108 + r110] & UByte.MAX_VALUE);
        r110 = r110 + 1;
        goto L28
    L30:
        return r111;
    L31:
        r101 = r109;
        goto L3
    L17:
        r107 = 2;
        goto L18
    L7:
        r106 = r100[r104] & 255;
        if ((r106 & 128) == 0) goto L15;
        int r112 = r104 + 1;
        if (r112 >= r102) goto L6;
        r106 = ((r106 & 127) * 128) + (r100[r112] & 255);
    L32:
        return -1;
    }

    public static void h(o r100, String r101, String r102, int r103) {
        if (Build.VERSION.SDK_INT >= 29) goto L6;
        pk4.j.d("DoraWifiP2p", "sendPreConnectIfNeeded: skip for Android 9 and below");
        return;
    L6:
        r100.f204744m = u.a();
        long r104 = SystemClock.elapsedRealtime();
        int r105 = (int) ((r104 ^ (r104 >>> 32)) & SieveCacheKt.NodeLinkMask);
        if (r105 != 0) goto L9;
        r105 = 1;
    L9:
        r100.f204742k = r105;
        r100.f204743l = 0;
        bl4.e r106 = new bl4.e(r101, r102, r103, r100.f204744m);
        long r107 = SystemClock.elapsedRealtime();
        int r108 = vj4.b.a.f555417a.b(r105, r106);
        pk4.j.d("DoraWifiP2p", "sendPreConnectIfNeeded: requestId=" + r105 + ", ret=" + r108 + ", cost=" + (SystemClock.elapsedRealtime() - r107) + ", event=" + r106);
        StringBuilder r109 = new StringBuilder("P2pPreConnectSend-");
        r109.append(r108);
        r109.append("-");
        r109.append(r105);
        r100.a(r109.toString());
    }
}
