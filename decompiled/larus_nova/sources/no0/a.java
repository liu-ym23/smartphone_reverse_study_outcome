package no0;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f519883a = 0;

    public a() {
    }

    static {
    }

    public static void a(String r100, Map r101) {
        g r102 = u.l();
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(r101);
        Unit r104 = Unit.INSTANCE;
        r102.e(r100, r103, new Object[0]);
    }

    public static void c(int r100, int r101, int r102) {
        Room r103 = null;
        long r104 = 0;
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r105 == null) goto L7;
        m<Room> r106 = r105.getRoom();
        if (r106 == null) goto L7;
        r103 = r106.getValue();
    L7:
        if (r103 == null) goto L9;
        r104 = r103.getRoomId();
    L9:
        if (r103 == null) goto L12;
        String r107 = r103.getAnchorId();
        if (r107 == null) goto L12;
    L13:
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("anchor_id", r107);
        r108.put("room_id", String.valueOf(r104));
        r108.put("from_source", String.valueOf(r100));
        r108.put(LocationMonitorConst.IDENTIFIER, String.valueOf(r101));
        r108.put("role", String.valueOf(r102));
        a("mp_handle_entrance_msg", r108);
        return;
    L12:
        r107 = "";
        goto L13
    }

    public static void b(String r100, String r101, String r102, JSONObject r110, String r111) {
        Object r103 = "0";
        Intrinsics.checkNotNullParameter(r100, "entranceType");
        Intrinsics.checkNotNullParameter(r101, "stage");
        Intrinsics.checkNotNullParameter(r102, "stageDesc");
        Intrinsics.checkNotNullParameter(r111, "pageType");
        Room r104 = null;
        long r105 = 0;
        RoomContext r106 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r106 == null) goto L7;
        m<Room> r107 = r106.getRoom();
        if (r107 == null) goto L7;
        r104 = r107.getValue();
    L7:
        if (r104 == null) goto L9;
        r105 = r104.getRoomId();
    L9:
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_APP);
        r108.put("room_id", String.valueOf(r105));
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L19
        IUserService r112 = (IUserService) k.f(IUserService.class);     // Catch: Throwable -> L19
        if (r112 == null) goto L16;
        f r113 = r112.user();     // Catch: Throwable -> L19
        if (r113 == null) goto L16;
        String r114 = r113.n();     // Catch: Throwable -> L19
        if (r114 == null) goto L16;
    L17:
        Object r115 = Result.m9449constructorimpl(r114);     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r115) == true) goto L25;
        r103 = r115;
    L25:
        r108.put("anchor_id", ((String) r103).toString());
        r108.put(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, r100);
        r108.put("stage", r101);
        r108.put("stage_desc", r102);
        if (r110 == null) goto L29;
        String r116 = r110.toString();
        if (r116 == null) goto L29;
    L30:
        r108.put("stage_extra", r116);
        r108.put("page_type", r111);
        a("mp_live_choose_page_monitor", r108);
        return;
    L29:
        r116 = "";
    L16:
        r114 = "0";
    L19:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    public static void d(int r100, int r101, int r102, String r103, String r104) {
        Room r105 = null;
        long r106 = 0;
        RoomContext r107 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r107 == null) goto L7;
        m<Room> r108 = r107.getRoom();
        if (r108 == null) goto L7;
        r105 = r108.getValue();
    L7:
        if (r105 == null) goto L9;
        r106 = r105.getRoomId();
    L9:
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put("roomid", String.valueOf(r106));
        r109.put("role", String.valueOf(r100));
        r109.put("live_status", String.valueOf(r101));
        r109.put("page", String.valueOf(r102));
        r109.put("errNo", r103);
        if (r104 != null) goto L12;
        r104 = "";
    L12:
        r109.put("errMsg", r104);
        a("mp_mount_page_show", r109);
    }

    public static void e(String r100, String r101, String r110, String r111, long r112) {
        String r102 = null;
        long r103 = 0;
        int r104 = 3;
        RoomContext r105 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r105 == null) goto L7;
        m<Room> r106 = r105.getRoom();
        if (r106 == null) goto L7;
        Room r107 = r106.getValue();
    L8:
        if (r107 == null) goto L11;
        r103 = r107.getRoomId();
    L11:
        if (r107 == null) goto L14;
        String r108 = r107.getAnchorId();
        if (r108 == null) goto L14;
    L15:
        IUserService r109 = (IUserService) k.f(IUserService.class);
        if (r109 == null) goto L21;
        f r113 = r109.user();
        if (r113 == null) goto L21;
        r102 = r113.n();
    L21:
        if ((!StringsKt.isBlank(r108)) == true) goto L23;
    L25:
        boolean r114 = false;
    L26:
        boolean r115 = ((ILiveRoomService) k.n(ILiveRoomService.class)).inLivingRoom();
        if (r114 == false) goto L31;
        if (r115 == false) goto L30;
        r104 = 1;
        goto L31
    L30:
        r104 = 2;
    L31:
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put("fromSource", String.valueOf(r104));
        r116.put("anchorId", r108);
        r116.put("roomid", String.valueOf(r103));
        if (r100 != null) goto L34;
        r100 = "";
    L34:
        r116.put("path", r100);
        r116.put("errNo", r101);
        if (r110 != null) goto L37;
        r110 = "";
    L37:
        r116.put("errMsg", r110);
        if (r111 != null) goto L40;
        r111 = "";
    L40:
        r116.put("app_id", r111);
        r116.put("duration", String.valueOf(r112));
        a("mp_live_req_result", r116);
        if (r114 == false) goto L44;
        a("mp_live_anchor_req_result", r116);
        return;
    L44:
        return;
    L23:
        if (Intrinsics.areEqual(r108, r102) == false) goto L25;
        r114 = true;
    L14:
        r108 = "";
    L7:
        r107 = null;
        goto L8
    }
}
