package xe2;

import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.w;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b extends mb0.b {
    public static final b b = null;

    static {
        b = new b();
    }

    public b() {
    }

    @JvmStatic
    public static final void s(LinkMonitorData r10, JSONObject r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "extra");
        b.getClass();
        pd2.c.a(r11);
        nd0.c.p(nd0.c.a, r10, r11, MultiLinkEventModule.KTV_CHORUS, 0, null, false, null, 88);
        w.a("RTChorusFullLinkMonitor", "businessName:" + r10.getEventTypeValue() + ", extra:" + r11);
    }

    public static void w(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "source");
        JSONObject r2 = new JSONObject();
        r2.put("action", r3);
        r2.put("source", r4);
        s(LinkMonitorData.UpdateRtcStreamPushStatus, r2);
    }

    public static void u(String r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "chorusId");
        JSONObject r0 = new JSONObject();
        r0.put("chorus_id", r3);
        r0.put("cur_chorus_role", String.valueOf(r4));
        r0.put("local_ntp", String.valueOf(0));
        if (r5 == false) goto L5;
        String r6 = "1";
    L6:
        r0.put("is_engine_on", r6);
        s(LinkMonitorData.RtcNtpTimeException, r0);
        return;
    L5:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static void v(String r2, int r3, String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "chorusId");
        Intrinsics.checkNotNullParameter(r4, "leaderSingerId");
        Intrinsics.checkNotNullParameter(r5, "leaderSingerInteractId");
        JSONObject r1 = new JSONObject();
        r1.put("chorusId", r2);
        r1.put("cur_chorus_role", String.valueOf(r3));
        r1.put("lead_singer_uid", r4);
        r1.put("lead_singer_interactId", r5);
        if (r6 == false) goto L5;
        String r7 = "1";
    L6:
        r1.put("is_engine_on", r7);
        s(LinkMonitorData.UpdateMixBaseUid, r1);
        return;
    L5:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static void t(String r2, int r3, int r4, long r5, long r7, long r9) {
        Intrinsics.checkNotNullParameter(r2, "chorusId");
        JSONObject r1 = new JSONObject();
        r1.put("chorusId", r2);
        r1.put("cur_chorus_role", String.valueOf(r3));
        r1.put("audio_device_loop_delay", String.valueOf(r4));
        r1.put("local_ntp", String.valueOf(0));
        r1.put("local_progress", String.valueOf(r5));
        r1.put("progress_diff", String.valueOf(r7));
        r1.put("seek_diff", String.valueOf(r9));
        s(LinkMonitorData.ChorusBgmSeek, r1);
    }
}
