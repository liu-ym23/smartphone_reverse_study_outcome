package com.ss.android.lark.monitor.traffic;

import com.facebook.battery.metrics.network.NetworkMetrics;
import com.facebook.battery.metrics.network.NetworkMetricsCollector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class l extends com.ss.android.lark.monitor.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkMetricsCollector f432523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, b> f432524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f432525c;

    public class a implements os3.g {
        public a() {
        }

        public final void a(long r100, long r101, long r102, long r110, long r111) {
            Log.i("ScenePerfMonitor", "During Scene:" + MonitorModule.e().d() + ",Used totalTraffic:" + (r100 / 1024) + "kb,Mobile Traffic:" + r110 + r111 + ",Wifi Traffic:" + r102 + r101);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public NetworkMetrics f432526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public NetworkMetrics f432527b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f432528c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f432529d;

        public b() {
        }
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r100) {
    }

    public l(com.ss.android.lark.monitor.i r100) {
        super(r100);
        this.f432524b = new ConcurrentHashMap();
        this.f432525c = 0;
        this.f432523a = new NetworkMetricsCollector(r100.f432397a);
        ws3.k.f561009y = new a();
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r100) {
        b r101 = this.f432524b.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        NetworkMetrics r102 = this.f432523a.createMetrics();
        this.f432523a.getSnapshot(r102);
        NetworkMetrics r103 = r102.diff(r101.f432526a);
        if (r101.f432527b != null) goto L8;
        r101.f432527b = new NetworkMetrics();
    L8:
        NetworkMetrics r104 = r101.f432527b;
        r104.sum(r103, r104);
        long r105 = (System.currentTimeMillis() - r101.f432528c) / 1000;
        r101.f432529d += r105;
        long r106 = (r103.mobileBytesRx + r103.mobileBytesTx) / 1024;
        long r107 = (r103.wifiBytesRx + r103.wifiBytesTx) / 10024;
        Log.i("ScenePerfMonitor", "Pause Scene:" + r100.split("#hash")[0] + ",Cost MobileTrafficKB:" + r106 + ", wifiTrafficKB: " + r107 + ", Span(S):" + r105);
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(String r100) {
        if (r100.contains("vc_meeting_onthecall") == false) goto L5;
    L6:
        this.f432525c++;
    L7:
        b r101 = this.f432524b.get(r100);
        NetworkMetrics r102 = this.f432523a.createMetrics();
        if (this.f432523a.getSnapshot(r102) == true) goto L10;
        return;
    L10:
        if (r101 != null) goto L12;
        r101 = new b();
        this.f432524b.put(r100, r101);
    L12:
        r101.f432526a = r102;
        r101.f432528c = System.currentTimeMillis();
        return;
    L5:
        if (r100.contains("ByteRTCMeetingActivityInstance") == false) goto L7;
        goto L6
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(String r210, JSONObject r211) {
        if (this.f432525c == 0) goto L5;
        boolean r100 = true;
    L7:
        if (r210.contains("vc_meeting_onthecall") == false) goto L9;
    L10:
        this.f432525c--;
    L11:
        String r101 = r210.split("#hash")[0];
        b r102 = this.f432524b.remove(r210);
        if (r102 != null) goto L15;
        return;
    L15:
        if (r102.f432527b != null) goto L17;
        NetworkMetrics r103 = this.f432523a.createMetrics();
        this.f432523a.getSnapshot(r103);
        r102.f432527b = r103.diff(r102.f432526a);
        r102.f432529d = (System.currentTimeMillis() - r102.f432528c) / 1000;
    L17:
        NetworkMetrics r104 = r102.f432527b;
        long r105 = r104.mobileBytesRx;
        long r106 = r104.mobileBytesTx;
        long r110 = (r105 + r106) / 1024;
        long r111 = r104.wifiBytesRx;
        long r107 = r104.wifiBytesTx;
        long r108 = (r111 + r107) / 10024;
        long r109 = (r105 + r111) / 1024;
        long r112 = (r106 + r107) / 10024;
        Log.i("ScenePerfMonitor", "End Scene:" + r101 + ",Cost MobileTrafficKB:" + r110 + ", wifiTrafficKB: " + r108 + ", Span(S):" + r102.f432529d);
        long r113 = r110 + r108;
        if (r113 >= 1024) goto L36;
        return;
    L36:
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L22
        r114.put("scene", r101);     // Catch: Exception -> L22
        r114.put("traffic", r113);     // Catch: Exception -> L22
        r114.put("traffic_mobile", r110);     // Catch: Exception -> L22
        r114.put("traffic_wifi", r108);     // Catch: Exception -> L22
        r114.put("traffic_rx", r109);     // Catch: Exception -> L22
        r114.put("traffic_tx", r112);     // Catch: Exception -> L22
        r114.put("span", r102.f432529d);     // Catch: Exception -> L22
        isb.a.a(r114, r211);     // Catch: Exception -> L22
        isb.a.c("scene_traffic_info", r114);     // Catch: Exception -> L22
    L24:
        if (r100 == true) goto L26;
    L27:
        if (r100 == false) goto L29;
        return;
    L29:
        if (r110 <= 204800) goto L39;
    L30:
        StringBuilder r115 = new StringBuilder();
        r115.append(r101);
        r115.append(" cost ");
        r115.append(r110 / 1024);
        r115.append(" M mobile traffic ");
        if (r100 == false) goto L33;
        String r116 = " during vc";
    L34:
        r115.append(r116);
        r115.append(", time interval is(s) ");
        r115.append(r102.f432529d);
        Log.e("Scene TrafficException", new Throwable(r115.toString()), true);
        return;
    L33:
        r116 = "";
        goto L34
    L39:
        return;
    L26:
        if (r110 > 307200) goto L30;
    L22:
        e = move-exception;
        Log.e("ScenePerfMonitor", "stopScene", e);
        goto L24
    L9:
        if (r210.contains("ByteRTCMeetingActivityInstance") == false) goto L11;
    L5:
        r100 = false;
        goto L7
    }
}
