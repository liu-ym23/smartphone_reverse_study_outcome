package k10;

import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.live.datacontext.m;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f501345a = 0;

    static {
    }

    public static void a(String r100, String r110, String r111, String r112, long r113) {
        String r101 = null;
        long r102 = 0;
        int r103 = 3;
        RoomContext r104 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r104 == null) goto L7;
        m<Room> r105 = r104.getRoom();
        if (r105 == null) goto L7;
        Room r106 = r105.getValue();
    L8:
        if (r106 == null) goto L11;
        r102 = r106.getRoomId();
    L11:
        if (r106 == null) goto L14;
        String r107 = r106.getAnchorId();
        if (r107 == null) goto L14;
    L15:
        IUserService r108 = (IUserService) k.f(IUserService.class);
        if (r108 == null) goto L21;
        f r109 = r108.user();
        if (r109 == null) goto L21;
        r101 = r109.n();
    L21:
        if ((!StringsKt.isBlank(r107)) == true) goto L23;
    L25:
        boolean r114 = false;
    L26:
        boolean r115 = ((ILiveRoomService) k.n(ILiveRoomService.class)).inLivingRoom();
        if (r114 == false) goto L31;
        if (r115 == false) goto L30;
        r103 = 1;
        goto L31
    L30:
        r103 = 2;
    L31:
        LinkedHashMap r116 = new LinkedHashMap();
        r116.put("from_source", String.valueOf(r103));
        r116.put("anchor_id", r107);
        r116.put("room_id", String.valueOf(r102));
        if (r100 != null) goto L34;
        r100 = "";
    L34:
        r116.put("path", r100);
        r116.put("err_no", r110);
        if (r111 != null) goto L37;
        r111 = "";
    L37:
        r116.put(LocationMonitorConst.ERR_MSG, r111);
        if (r112 != null) goto L40;
        r112 = "";
    L40:
        r116.put("app_id", r112);
        r116.put("duration", String.valueOf(r113));
        g r117 = u.l();
        LinkedHashMap r118 = new LinkedHashMap();
        r118.putAll(r116);
        Unit r119 = Unit.INSTANCE;
        r117.e("mp_live_req_result", r118, new Object[0]);
        return;
    L23:
        if (Intrinsics.areEqual(r107, r101) == false) goto L25;
        r114 = true;
    L14:
        r107 = "";
    L7:
        r106 = null;
        goto L8
    }
}
