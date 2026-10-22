package zi0;

import com.bytedance.android.live.liveinteract.api.utils.n;
import com.bytedance.android.live.liveinteract.plantform.monitor.MultiLinkEventModule;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.live.datacontext.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f572217a = null;

    public a() {
    }

    static {
        f572217a = new a();
    }

    public static void a(JSONObject r100) {
        LinkRoomFightContext r101 = LinkRoomFightContext.Companion.getContext();
        if (r101 == null) goto L9;
        m<com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b> r102 = r101.getFightState();
        if (r102 == null) goto L9;
        com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.c.b r103 = r102.getValue();
        if (r103 == null) goto L9;
        r100.put("fight_state", r103.f78515b);
    L9:
        n.f71525b.l(r100);
    }

    public final void d(String r100) {
        JSONObject r101 = new JSONObject();
        r101.put("rtc_ext_info", r100);
        a(r101);
        e(this, "stop_forward_stream_to_rooms", r101);
    }

    public static void b(Object r100, Object r101) {
        JSONObject r102 = new JSONObject();
        r102.put("state", r100);
        r102.put("param", r101);
        a(r102);
        MultiLinkEventModule r103 = n.p();
        n.f71525b.getClass();
        n.D(r103, "forward_stream_state", r102);
    }

    public static void e(a r100, String r101, JSONObject r102) {
        MultiLinkEventModule r103 = n.p();
        r100.getClass();
        n.f71525b.getClass();
        n.B(r103, r101, r102);
    }

    public final void c(String r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("to_room_id", r100);
        r103.put("rtc_ext_info", r101);
        r103.put("remote_rtc_ext_info", r102);
        a(r103);
        e(this, "start_forward_stream_to_rooms", r103);
    }
}
