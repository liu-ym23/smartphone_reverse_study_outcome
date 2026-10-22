package f40;

import com.bytedance.android.live.cloudgrouplive.core.d;
import com.bytedance.android.live.cloudgrouplive.utils.AnchorExitGroupLiveType;
import com.bytedance.android.live.cloudgrouplive.utils.CloudGroupLiveTraceEvent;
import com.bytedance.android.live.cloudgrouplive.utils.GroupLiveStatus;
import com.bytedance.android.live.core.monitor.trace.TraceMonitor;
import com.bytedance.android.live.core.monitor.trace.e;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f475503a = 0;

    public a() {
    }

    static {
    }

    public static void c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "record");
        HashMap r101 = new HashMap();
        r101.put("reply_accept_api_result", r100.f64450a);
        r101.put("reply_accept_api_duration", String.valueOf(r100.f64451b));
        r101.put("join_rtc_result", r100.f64452c);
        r101.put("join_rtc_duration", String.valueOf(r100.f64453d));
        r101.put("join_cloud_live_result", r100.f64454e);
        r101.put("join_cloud_live_duration", String.valueOf(r100.f64455f));
        r101.put("join_api_result", r100.f64456g);
        r101.put("join_api_duration", String.valueOf(r100.f64457h));
        m<IRoom> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        String r103 = null;
        if (r102 == null) goto L7;
        IRoom r104 = r102.getValue();
        if (r104 == null) goto L7;
        String r105 = r104.getIdStr();
    L8:
        r101.put("room_id", String.valueOf(r105));
        r101.put("user_id", gh0.a.c());
        IMiddleWareHostContext r106 = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        if (r106 == null) goto L11;
        String r107 = r106.getServerDeviceId();
    L12:
        r101.put("device_id", String.valueOf(r107));
        if (r106 == null) goto L15;
        String r108 = r106.getVersionCode();
    L16:
        r101.put("app_version", String.valueOf(r108));
        if (r106 == null) goto L19;
        r103 = r106.getDevicePlatform();
    L19:
        r101.put("device_platform", String.valueOf(r103));
        j0.l().sendLog("livesdk_cloud_group_live_performance", r101, new Object[0]);
        r100.f64450a = "";
        r100.f64451b = 0;
        r100.f64452c = "";
        r100.f64453d = 0;
        r100.f64454e = "";
        r100.f64455f = 0;
        r100.f64456g = "";
        r100.f64457h = 0;
        return;
    L15:
        r108 = null;
        goto L16
    L11:
        r107 = null;
    L7:
        r105 = null;
        goto L8
    }

    public static void a(String r100, String r101, AnchorExitGroupLiveType r110) {
        Intrinsics.checkNotNullParameter(r100, "hostAnchorId");
        Intrinsics.checkNotNullParameter(r101, "hostRoomId");
        Intrinsics.checkNotNullParameter(r110, "endType");
        HashMap r102 = new HashMap();
        RoomContext.a r103 = RoomContext.Companion;
        Long r104 = null;
        RoomContext r105 = RoomContext.a.c(r103, null, 0, 3);
        if (r105 == null) goto L9;
        m<Room> r106 = r105.getRoom();
        if (r106 == null) goto L9;
        Room r107 = r106.getValue();
        if (r107 == null) goto L9;
        String r108 = r107.getAnchorId();
    L10:
        r102.put("anchor_id", String.valueOf(r108));
        RoomContext r109 = RoomContext.a.c(r103, null, 0, 3);
        if (r109 == null) goto L17;
        m<Room> r111 = r109.getRoom();
        if (r111 == null) goto L17;
        Room r112 = r111.getValue();
        if (r112 == null) goto L17;
        r104 = Long.valueOf(r112.getRoomId());
    L17:
        r102.put("room_id", String.valueOf(r104));
        r102.put("host_anchor_id", r100);
        r102.put("host_room_id", r101);
        r102.put("end_type", r110.getDes());
        j0.l().sendLog("livesdk_group_link_screen_member_close", r102, new Object[]{IRoom.class});
        return;
    L9:
        r108 = null;
        goto L10
    }

    public static void b(String r100, String r101, GroupLiveStatus r110) {
        Intrinsics.checkNotNullParameter(r100, "hostAnchorId");
        Intrinsics.checkNotNullParameter(r101, "hostRoomId");
        Intrinsics.checkNotNullParameter(r110, "changeType");
        HashMap r102 = new HashMap();
        RoomContext.a r103 = RoomContext.Companion;
        Long r104 = null;
        RoomContext r105 = RoomContext.a.c(r103, null, 0, 3);
        if (r105 == null) goto L9;
        m<Room> r106 = r105.getRoom();
        if (r106 == null) goto L9;
        Room r107 = r106.getValue();
        if (r107 == null) goto L9;
        String r108 = r107.getAnchorId();
    L10:
        r102.put("anchor_id", String.valueOf(r108));
        RoomContext r109 = RoomContext.a.c(r103, null, 0, 3);
        if (r109 == null) goto L17;
        m<Room> r111 = r109.getRoom();
        if (r111 == null) goto L17;
        Room r112 = r111.getValue();
        if (r112 == null) goto L17;
        r104 = Long.valueOf(r112.getRoomId());
    L17:
        r102.put("room_id", String.valueOf(r104));
        r102.put("host_anchor_id", r100);
        r102.put("host_room_id", r101);
        r102.put("change_type", r110.getDes());
        j0.l().sendLog("livesdk_group_link_screen_member_change", r102, new Object[]{IRoom.class});
        return;
    L9:
        r108 = null;
        goto L10
    }

    public static void d(CloudGroupLiveTraceEvent r100, String r101, int r102, String r103, int r104) {
        if ((r104 & 4) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = "";
    L8:
        String r105 = null;
        if ((r104 & 16) == 0) goto L11;
        JSONObject r106 = new JSONObject();
    L12:
        Intrinsics.checkNotNullParameter(r100, "traceEvent");
        Intrinsics.checkNotNullParameter(r101, "traceStep");
        Intrinsics.checkNotNullParameter(r106, "extraInfo");
        int r107 = e.f64997m;
        e.a r108 = e.b.a(r100.getEventName(), "cloud_group_live_trace");
        r108.f65012c = "webcast_client_cloud_group_live";
        r108.f65013d = r101;
        r108.f65016g = gh0.a.c();
        m<IRoom> r109 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r109 == null) goto L17;
        IRoom r110 = r109.getValue();
        if (r110 == null) goto L17;
        String r111 = r110.getOwnerUserIdString();
    L18:
        r108.f65015f = r111;
        m<IRoom> r112 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r112 == null) goto L23;
        IRoom r113 = r112.getValue();
        if (r113 == null) goto L23;
        r105 = r113.getIdStr();
    L23:
        r108.f65014e = r105;
        r108.f65017h = Integer.valueOf(r102);
        r108.f65018i = r103;
        TraceMonitor.h(r108.a(), r106);
        return;
    L17:
        r111 = null;
        goto L18
    L11:
        r106 = null;
        goto L12
    }
}
