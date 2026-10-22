package zk4;

import android.os.SystemClock;
import com.bytedance.dora.wlan.model.DoraWifiEventReason;
import com.bytedance.dora.wlan.model.DoraWifiType;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Map<Integer, Integer>> f572657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f572658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f572659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f572660d;

    public interface a {
    }

    public l(k r100) {
        this.f572660d = r100;
        this.f572658b = 0;
        HashMap r101 = new HashMap();
        HashMap r102 = new HashMap();
        r102.put(0, 1);
        r101.put(0, r102);
        HashMap r103 = new HashMap();
        r103.put(1, 1);
        r103.put(2, 2);
        r103.put(5, 0);
        r103.put(6, 0);
        r103.put(7, 0);
        r103.put(3, 3);
        r101.put(1, r103);
        HashMap r104 = new HashMap();
        r104.put(3, 3);
        r104.put(4, 0);
        r104.put(7, 0);
        r104.put(8, 0);
        r101.put(2, r104);
        HashMap r105 = new HashMap();
        r105.put(4, 0);
        r101.put(3, r105);
        this.f572657a = r101;
        pk4.j.d("DoraWifiSoftApStateMachine", "StateMachine initialized with initial state: " + b(this.f572658b));
    }

    public static String a(int r100) {
        switch(r100) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L13;
            case 5: goto L11;
            case 6: goto L9;
            case 7: goto L7;
            case 8: goto L5;
            default: goto L4;
        };
    L5:
        return "EVENT_NETWORK_LOSS";
    L7:
        return "EVENT_ERROR";
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
        return "EVENT_AP_READY";
    L21:
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

    public final void c(int r100, DoraWifiEventReason r101) {
        pk4.j.d("DoraWifiSoftApStateMachine", "handleEvent: event=" + a(r100) + ", currentState=" + b(this.f572658b) + ", reason=" + r101);
        Map r102 = (Map) ((HashMap) this.f572657a).get(Integer.valueOf(this.f572658b));
        if (r102 != null) goto L6;
        pk4.j.f("DoraWifiSoftApStateMachine", "handleEvent: No transitions defined for current state: " + b(this.f572658b));
        return;
    L6:
        Integer r103 = (Integer) r102.get(Integer.valueOf(r100));
        if (r103 != null) goto L11;
        pk4.j.f("DoraWifiSoftApStateMachine", "handleEvent: No transition found for event=" + a(r100) + " in state=" + b(this.f572658b));
        return;
    L11:
        if (this.f572658b == r103.intValue()) goto L36;
        int r104 = this.f572658b;
        this.f572658b = r103.intValue();
        pk4.j.d("DoraWifiSoftApStateMachine", "handleEvent: State transition: " + b(r104) + " -> " + b(this.f572658b));
        this.f572660d.a("SoftApConnectionState(" + r104 + "->" + this.f572658b + ")");
        int r105 = r103.intValue();
        if (r104 != 1) goto L16;
        if (r105 != 2) goto L16;
        k r106 = this.f572660d;
        r106.f572647h = 1;
        r106.f572646g = "success";
        cl4.c.a(r106);
    L30:
        a r107 = this.f572659c;
        if (r107 == null) goto L37;
        int r108 = this.f572658b;
        vk4.i r109 = ((zk4.a) r107).f572614a.f572632b;
        if (r109 == null) goto L38;
        ((vk4.e) r109).h(DoraWifiType.SOFT_AP, r108, f.f572630f);
        return;
    L38:
        return;
    L37:
        return;
    L16:
        if (r104 != 1) goto L19;
        if (r105 != 0) goto L19;
        k r110 = this.f572660d;
        r110.f572647h = 2;
        cl4.c.a(r110);
    L19:
        if (r104 != 2) goto L26;
        if (r105 != 0) goto L26;
        if (r101 != DoraWifiEventReason.ON_SPP_WIFI_CALLBACK) goto L24;
        String r111 = "SPPDisconnect";
    L25:
        k r112 = this.f572660d;
        r112.f572643d = r111;
        r112.f572656q = SystemClock.elapsedRealtime();
        cl4.c.b(this.f572660d);
        goto L30
    L24:
        r111 = "AbnormalClosed";
    L26:
        if (r104 != 2) goto L30;
        if (r105 != 3) goto L30;
        k r113 = this.f572660d;
        r113.f572643d = "invokeWiFiClose";
        r113.f572656q = SystemClock.elapsedRealtime();
        cl4.c.b(this.f572660d);
        goto L30
    }
}
