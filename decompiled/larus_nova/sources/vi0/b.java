package vi0;

import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f555007a = 0;

    public static void b() {
        JSONObject r100 = new JSONObject();
        r100.put(ITTVideoEngineEventSource.KEY_MUTE, true);
        int r101 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerMedia, "guest_link_linkmic_player_mute_change", 0, null, r100, 88);
    }

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        JSONObject r102 = new JSONObject();
        r102.put("channel_id", r100);
        r102.put("error", r101);
        int r103 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_join_rtc_room_finish", 0, null, r102, 88);
    }

    public static void c(String r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r110, "reason");
        Intrinsics.checkNotNullParameter(r111, "toast");
        JSONObject r101 = new JSONObject();
        r101.put("msg_id", r100);
        r101.put("reason", r110);
        r101.put("toast", r111);
        int r102 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.GuestLink, MultiTraceData$TraceEvent.GuestLinkerLink, "guest_link_channel_finish_msg_receive", 0, null, r101, 88);
    }
}
