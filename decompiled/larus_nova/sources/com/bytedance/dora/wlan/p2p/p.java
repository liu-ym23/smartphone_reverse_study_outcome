package com.bytedance.dora.wlan.p2p;

import android.os.SystemClock;
import com.bytedance.dora.wlan.model.DoraWifiEventReason;
import com.bytedance.dora.wlan.model.DoraWifiScene;
import com.bytedance.dora.wlan.model.DoraWifiType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Map<Integer, Integer>> f204756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f204757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f204758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f204759d;

    public interface a {
    }

    public p(o r100) {
        this.f204759d = r100;
        this.f204757b = 0;
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        r102.put(0, 1);
        r101.put(0, r102);
        HashMap r103 = new HashMap();
        r103.put(1, 2);
        r103.put(4, 0);
        r103.put(5, 0);
        r103.put(2, 3);
        r103.put(6, 0);
        r103.put(3, 0);
        r101.put(1, r103);
        HashMap r104 = new HashMap();
        r104.put(2, 3);
        r104.put(3, 0);
        r104.put(6, 0);
        r104.put(7, 0);
        r101.put(2, r104);
        HashMap r105 = new HashMap();
        r105.put(3, 0);
        r101.put(3, r105);
        this.f204756a = r101;
        pk4.j.d("DoraWifiP2pStateMachine", "StateMachine initialized with initial state: " + b(this.f204757b));
    }

    public static String a(int r100) {
        switch(r100) {
            case 0: goto L19;
            case 1: goto L17;
            case 2: goto L15;
            case 3: goto L13;
            case 4: goto L11;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        return "EVENT_CLIENTS_EMPTY";
    L7:
        return "EVENT_NETWORK_DISCONNECTED";
    L9:
        return "EVENT_TIMEOUT";
    L11:
        return "EVENT_CONNECT_FAILED";
    L13:
        return "EVENT_DISCONNECT";
    L15:
        return "EVENT_DISCONNECT_REQUEST";
    L17:
        return "EVENT_CONNECT_SUCCESS";
    L19:
        return "EVENT_START";
    L4:
        return "UNKNOWN_EVENT(" + r100 + ")";
    }

    public static String b(int r100) {
        if (r100 != 0) goto L4;
        return "STATE_DISCONNECTED";
    L4:
        if (r100 != 1) goto L6;
        return "STATE_CONNECTING";
    L6:
        if (r100 != 2) goto L8;
        return "STATE_CONNECTED";
    L8:
        if (r100 != 3) goto L10;
        return "STATE_DISCONNECTING";
    L10:
        return "UNKNOWN_STATE(" + r100 + ")";
    }

    public final void c(int r100, DoraWifiEventReason r110) {
        pk4.j.d("DoraWifiP2pStateMachine", "handleEvent: event=" + a(r100) + ", currentState=" + b(this.f204757b) + ", reason=" + r110);
        Map r101 = (Map) ((HashMap) this.f204756a).get(Integer.valueOf(this.f204757b));
        if (r101 != null) goto L6;
        pk4.j.f("DoraWifiP2pStateMachine", "handleEvent: No transitions defined for current state: " + b(this.f204757b));
        return;
    L6:
        Integer r102 = (Integer) r101.get(Integer.valueOf(r100));
        if (r102 != null) goto L11;
        pk4.j.f("DoraWifiP2pStateMachine", "handleEvent: No transition found for event=" + a(r100) + " in state=" + b(this.f204757b));
        return;
    L11:
        if (this.f204757b == r102.intValue()) goto L45;
        int r103 = this.f204757b;
        this.f204757b = r102.intValue();
        pk4.j.d("DoraWifiP2pStateMachine", "handleEvent: State transition: " + b(r103) + " -> " + b(this.f204757b));
        this.f204759d.a("P2pConnectionState(" + r103 + "->" + this.f204757b + ")");
        int r104 = r102.intValue();
        if (r103 != 1) goto L16;
        if (r104 != 2) goto L16;
        this.f204759d.f204752u = SystemClock.elapsedRealtime();
        o r105 = this.f204759d;
        r105.f204740i = 1;
        r105.f204739h = "success";
        cl4.b.b(r105);
    L31:
        if (this.f204758c == null) goto L44;
        pk4.j.a("DoraWifiP2pStateMachine", "handleEvent: Notifying StateChangeListener of state change");
        a r106 = this.f204758c;
        int r107 = this.f204757b;
        DoraWifiP2p r108 = ((b) r106).f204698a;
        r108.getClass();
        pk4.j.d("DoraWifiP2p", "notifyP2pConnectStateChanged: " + r103 + " -> " + r107 + ", where=" + r110);
        if (r107 != 0) goto L41;
        if (r103 == 1) goto L36;
        if (r103 != 2) goto L41;
    L36:
        DoraWifiScene r109 = r108.f204687e.f204736e;
        if (r108.f204683a == null) goto L41;
        if (r108.f204685c == null) goto L41;
        r108.f204683a.removeGroup(r108.f204685c, new n(r109, SystemClock.elapsedRealtime()));
    L41:
        vk4.i r111 = r108.f204690h;
        if (r111 == null) goto L47;
        ((vk4.e) r111).h(DoraWifiType.P2P, r107, r108.f204687e);
        return;
    L47:
        return;
    L44:
        pk4.j.f("DoraWifiP2pStateMachine", "handleEvent: StateChangeListener not set, cannot notify state change");
        return;
    L16:
        if (r103 != 1) goto L19;
        if (r104 != 0) goto L19;
        o r112 = this.f204759d;
        r112.f204740i = 2;
        r112.f204752u = SystemClock.elapsedRealtime();
        cl4.b.b(this.f204759d);
    L19:
        if (r103 != 2) goto L26;
        if (r104 != 0) goto L26;
        if (r110 != DoraWifiEventReason.ON_SPP_WIFI_CALLBACK) goto L24;
        String r113 = "SPPDisconnect";
    L25:
        o r114 = this.f204759d;
        r114.f204737f = r113;
        r114.f204755x = SystemClock.elapsedRealtime();
        cl4.b.d(this.f204759d);
        goto L31
    L24:
        r113 = "AbnormalClosed";
    L26:
        if (r103 != 2) goto L31;
        if (r104 != 3) goto L31;
        o r115 = this.f204759d;
        r115.f204737f = "invokeWiFiClose";
        r115.f204755x = SystemClock.elapsedRealtime();
        cl4.b.d(this.f204759d);
        goto L31
    L45:
        pk4.j.d("DoraWifiP2pStateMachine", "handleEvent: No state change needed, staying in: " + b(this.f204757b));
    }
}
