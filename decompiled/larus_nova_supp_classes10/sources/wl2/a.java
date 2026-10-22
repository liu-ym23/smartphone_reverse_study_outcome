package wl2;

import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import jc1.k;
import l32.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public static final a a = null;

    public a() {
    }

    static {
        a = new a();
    }

    public static boolean a(DataCenter r7) {
        IRoomService r0 = k.f(IRoomService.class);
        if (r0 != null) goto L5;
        return false;
    L5:
        com.bytedance.android.live.room.utils.a r2 = r0.getLiveMultiTabHandler();
        Room r1 = r0.getCurrentRoom();
        if (r2 == null) goto L15;
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r2.b(RoomContext.a.c(RoomContext.Companion, r7, 0, 2)) == true) goto L12;
        return false;
    L12:
        if (r1.withAggregateColumn == true) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    }
}
