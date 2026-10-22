package jk1;

import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPageFragment;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static aj1.i a(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (aj1.i) r100.b("RoomDataConst_live_end_room_page_context");
    }

    public static com.bytedance.android.livesdk.chatroom.newcontainer.business.common.logger.room.b b(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (com.bytedance.android.livesdk.chatroom.newcontainer.business.common.logger.room.b) r100.b("RoomDataConst_live_room_logger_context");
    }

    public static ik1.c c(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (ik1.c) r100.b("RoomDataConst_live_room_common_context");
    }

    public static RoomContext d(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return ((xh1.a) r100.a(xh1.a.class)).Ua();
    }

    public static wh1.a e(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (wh1.a) r100.b("RoomDataConst_live_room_interaction_context");
    }

    public static yj1.a f(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (yj1.a) r100.b("RoomDataConst_live_room_player_context");
    }

    public static hk1.a g(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return (hk1.a) r100.b("RoomDataConst_live_room_widget_context");
    }

    public static ILiveRoomPageFragment h(com.bytedance.android.livesdk.room.b r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return ((com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b) r100.a(com.bytedance.android.livesdk.chatroom.newcontainer.business.boot.room.engin.room.b.class)).parentPage();
    }
}
