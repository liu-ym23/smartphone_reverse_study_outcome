package xe2;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    public static MultiTraceData.TraceBusiness c() {
        if (o.d() != 62) goto L6;
        return MultiTraceData.TraceBusiness.CONCERT;
    L6:
        return MultiTraceData.TraceBusiness.RTChorus;
    }

    static {
    }

    public static void b(String r7) {
        JSONObject r5 = new JSONObject();
        if (r7 != null) goto L5;
        r7 = "";
    L5:
        r5.put("link_id", r7);
        int r8 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "firstFrameCallback", 0, null, r5, 88);
    }

    public static void i(String r7) {
        JSONObject r5 = new JSONObject();
        if (r7 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L11;
        r5.put("content", r7);
    L11:
        int r8 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "setRuntimeParameters", 0, null, r5, 88);
        return;
    L5:
        if (r7.length() == 0) goto L8;
        r0 = false;
        goto L9
    }

    public static void a(boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        JSONObject r6 = new JSONObject();
        r6.put(LocationMonitorConst.CHECK_RESULT, r8);
        r6.put("source", r9);
        int r10 = rd0.a.a;
        MultiTraceData.TraceBusiness r1 = c();
        MultiTraceData.TraceEvent r2 = MultiTraceData.TraceEvent.JoinChorus;
        if (r8 == false) goto L5;
        int r4 = 0;
    L6:
        rd0.a.b(r1, r2, "checkPermission", r4, null, r6, 80);
        return;
    L5:
        r4 = -1;
        goto L6
    }

    public static void e(boolean r8, String r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        JSONObject r6 = new JSONObject();
        r6.put("mute", r8);
        r6.put("source", r9);
        int r10 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "publishStreamAudio", 0, null, r6, 88);
    }

    public static void f(float r7, float r8) {
        JSONObject r5 = new JSONObject();
        r5.put("volume", Float.valueOf(r7));
        r5.put("ratio", Float.valueOf(r8));
        int r9 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "setPlayBackVolume", 0, null, r5, 88);
    }

    public static void g(float r7, float r8) {
        JSONObject r5 = new JSONObject();
        r5.put("volume", Float.valueOf(r7));
        r5.put("ratio", Float.valueOf(r8));
        int r9 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "setRemoteUserDefaultPlaybackVolume", 0, null, r5, 88);
    }

    public static void j(float r7, float r8) {
        JSONObject r5 = new JSONObject();
        r5.put("volume", Float.valueOf(r7));
        r5.put("ratio", Float.valueOf(r8));
        int r9 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "setVoiceVolume", 0, null, r5, 88);
    }

    public static void d(String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        JSONObject r6 = new JSONObject();
        r6.put("live_core_ext_info", r8);
        r6.put("rtc_ext_info", r9);
        r6.put("source", r10);
        int r11 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "initRTCAndLiveClient", 0, null, r6, 88);
    }

    public static void k(boolean r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        JSONObject r6 = new JSONObject();
        r6.put("is_auto_publish", r8);
        r6.put("is_user_visible", r9);
        r6.put("source", r10);
        int r11 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "startRtcEngine", 0, null, r6, 88);
    }

    public static void h(String r8, float r9, float r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "userId");
        Intrinsics.checkNotNullParameter(r11, "source");
        JSONObject r6 = new JSONObject();
        r6.put("user_id", r8);
        r6.put("volume", Float.valueOf(r9));
        r6.put("ratio", Float.valueOf(r10));
        r6.put("source", r11);
        int r12 = rd0.a.a;
        rd0.a.b(c(), MultiTraceData.TraceEvent.JoinChorus, "setRemoteUserPlaybackVolume", 0, null, r6, 88);
    }
}
