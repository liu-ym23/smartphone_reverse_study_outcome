package xe2;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class b extends mb0.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f563350b = null;

    static {
        f563350b = new b();
    }

    public b() {
    }

    @JvmStatic
    public static final void s(LinkMonitorData r110, JSONObject r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Intrinsics.checkNotNullParameter(r111, "extra");
        f563350b.getClass();
        pd2.c.a(r111);
        nd0.c.p(nd0.c.f518746a, r110, r111, MultiLinkEventModule.KTV_CHORUS, 0, null, false, null, 88);
        w.a("RTChorusFullLinkMonitor", "businessName:" + r110.getEventTypeValue() + ", extra:" + r111);
    }

    public static void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "source");
        JSONObject r102 = new JSONObject();
        r102.put("action", r100);
        r102.put("source", r101);
        s(LinkMonitorData.UpdateRtcStreamPushStatus, r102);
    }

    public static void u(String r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "chorusId");
        JSONObject r103 = new JSONObject();
        r103.put("chorus_id", r100);
        r103.put("cur_chorus_role", String.valueOf(r101));
        r103.put("local_ntp", String.valueOf(0));
        if (r102 == false) goto L5;
        String r104 = "1";
    L6:
        r103.put("is_engine_on", r104);
        s(LinkMonitorData.RtcNtpTimeException, r103);
        return;
    L5:
        r104 = "0";
        goto L6
    }

    public static void v(String r100, int r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "chorusId");
        Intrinsics.checkNotNullParameter(r102, "leaderSingerId");
        Intrinsics.checkNotNullParameter(r103, "leaderSingerInteractId");
        JSONObject r105 = new JSONObject();
        r105.put("chorusId", r100);
        r105.put("cur_chorus_role", String.valueOf(r101));
        r105.put("lead_singer_uid", r102);
        r105.put("lead_singer_interactId", r103);
        if (r104 == false) goto L5;
        String r106 = "1";
    L6:
        r105.put("is_engine_on", r106);
        s(LinkMonitorData.UpdateMixBaseUid, r105);
        return;
    L5:
        r106 = "0";
        goto L6
    }

    public static void t(String r100, int r101, int r102, long r103, long r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "chorusId");
        JSONObject r106 = new JSONObject();
        r106.put("chorusId", r100);
        r106.put("cur_chorus_role", String.valueOf(r101));
        r106.put("audio_device_loop_delay", String.valueOf(r102));
        r106.put("local_ntp", String.valueOf(0));
        r106.put("local_progress", String.valueOf(r103));
        r106.put("progress_diff", String.valueOf(r104));
        r106.put("seek_diff", String.valueOf(r105));
        s(LinkMonitorData.ChorusBgmSeek, r106);
    }
}
