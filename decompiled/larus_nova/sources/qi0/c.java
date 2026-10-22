package qi0;

import am2.x;
import com.bytedance.android.live.broadcastgame.api.interactgame.IGameDataService;
import com.bytedance.android.live.broadcastgame.api.model.i;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.utils.m;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IAnchorData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomExtra;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import rj0.k;
import rj0.l;
import tf0.o;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f533087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f533088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f533089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f533090d = null;

    public c() {
    }

    static {
        f533090d = new c();
        f533088b = "";
        f533089c = "";
    }

    public static String h() {
        com.bytedance.live.datacontext.m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L10;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L10;
        IAnchorData r102 = r101.getAnchorData();
        if (r102 == null) goto L10;
        String r103 = r102.getConversationId();
        if (r103 == null) goto L10;
        return r103;
    L10:
        return "";
    }

    public static String i() {
        if (je0.d.r() == false) goto L9;
        IGameDataService r100 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r100 == null) goto L14;
        i0 r101 = r100.getOpenPlatformAppInfo();
        if (r101 == null) goto L14;
        String r102 = r101.f59359b;
    L15:
        if (r102 == null) goto L17;
        return r102;
    L17:
        return f533088b;
    L14:
        r102 = null;
        goto L15
    L9:
        IGameDataService r103 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r103 == null) goto L14;
        i r104 = r103.getGameOpenInfo();
        if (r104 == null) goto L14;
        r102 = r104.f59353a;
        goto L15
    }

    public static String j() {
        if (je0.d.r() == false) goto L9;
        IGameDataService r100 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r100 == null) goto L14;
        i0 r101 = r100.getOpenPlatformAppInfo();
        if (r101 == null) goto L14;
        String r102 = r101.f59360c;
    L15:
        if (r102 == null) goto L17;
        return r102;
    L17:
        return f533089c;
    L14:
        r102 = null;
        goto L15
    L9:
        IGameDataService r103 = com.bytedance.android.live.liveinteract.api.utils.m.a();
        if (r103 == null) goto L14;
        i r104 = r103.getGameOpenInfo();
        if (r104 == null) goto L14;
        r102 = r104.f59355c;
        goto L15
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void c() {
        String r100 = com.bytedance.android.live.liveinteract.revenue.game.c.f78318a;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void g() {
        String r100 = com.bytedance.android.live.liveinteract.revenue.game.c.f78318a;
    }

    public static void l(boolean r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put("request_page", "interact_panel");
        r101.put("game_id", i());
        r101.put("danmu_name", j());
        r101.put("user_id", gh0.a.c());
        if (je0.d.r() == false) goto L5;
        String r102 = "anchor";
    L6:
        r101.put("user_type", r102);
        if (je0.d.r() == false) goto L13;
        k.f537953m2.getClass();
        k r103 = k.a.a();
        if (r103 == null) goto L18;
        o r104 = r103.windowManager();
        if (r104 == null) goto L18;
        Integer r105 = Integer.valueOf(r104.getUserCount());
    L20:
        if (r105 == null) goto L22;
        int r106 = r105.intValue();
    L23:
        r101.put("user_num", String.valueOf(r106));
        r101.put(FastStartLiveConfig.PLAY_MODE, w.a());
        j0 r107 = j0.l();
        if (r100 == false) goto L26;
        String r108 = "livesdk_danmu_seatcollapse_click";
    L27:
        r107.sendLog(r108, r101, new Object[]{IRoom.class, x.class});
        return;
    L26:
        r108 = "livesdk_danmu_seatexpand_click";
        goto L27
    L22:
        r106 = 0;
    L18:
        r105 = null;
        goto L20
    L13:
        l.f537955n2.getClass();
        l r109 = l.a.a();
        if (r109 == null) goto L18;
        o r110 = r109.windowManager();
        if (r110 == null) goto L18;
        r105 = Integer.valueOf(r110.getUserCount());
        goto L20
    L5:
        r102 = "guest";
        goto L6
    }

    public static void m(com.bytedance.android.live.liveinteract.revenue.game.e r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r101);
        TalkRoomLogUtils.B0(r101, null, null, 6);
        TalkRoomLogUtils.u0(r101);
        if (f533087a <= 0) goto L11;
        r101.put("duration", String.valueOf((System.currentTimeMillis() - f533087a) / ((long) 1000)));
        f533087a = 0;
        r101.put(FastStartLiveConfig.PLAY_MODE, u0.k(31));
        if (r100 == null) goto L8;
        String r102 = r100.f78323b;
        if (r102 == null) goto L8;
    L9:
        r101.put("game_id", r102);
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r101, new Object[]{IRoom.class});
        return;
    L8:
        r102 = "";
        goto L9
    }

    public static void k(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceName");
        Intrinsics.checkNotNullParameter(r101, "logMap");
        com.bytedance.android.livesdk.chatroom.o r102 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r102 == null) goto L11;
        Room r103 = r102.getCurrentRoom();
        if (r103 == null) goto L11;
        RoomExtra r104 = r103.getExtra();
        if (r104 == null) goto L11;
        if (r104.isGroupLiveGame() != true) goto L11;
        HashMap r105 = (HashMap) r101;
        r105.put(r100, "playtogether");
        r105.put("game_id", i());
        r105.put(EventConstants.ExtraJson.GAME_NAME, j());
    L11:
        com.bytedance.android.livesdk.chatroom.o r106 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r106 == null) goto L21;
        Room r107 = r106.getCurrentRoom();
        if (r107 == null) goto L22;
        RoomExtra r108 = r107.getExtra();
        if (r108 != null) goto L18;
        return;
    L18:
        if (r108.isGroupLiveChorus() != true) goto L24;
        ((HashMap) r101).put(r100, "playtogether_chorus");
        return;
    L24:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        f533088b = r100;
        f533089c = r101;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("request_page", "interact_panel");
        r102.put("game_id", r100);
        r102.put("danmu_name", r101);
        ALogger.i("LinkMicGameLogUtil", "onClickDanmuStartPlay: " + r102);
        j0.l().sendLog("livesdk_danmu_startplay_click", r102, new Object[]{IRoom.class, x.class});
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        f533088b = r100;
        f533089c = r101;
        String r102 = com.bytedance.android.live.liveinteract.revenue.game.c.f78318a;
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        Intrinsics.checkNotNullParameter(r102, "pageType");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("request_page", "interact_panel");
        r103.put("page_type", r102);
        r103.put("game_id", r100);
        r103.put("danmu_name", r101);
        j0.l().sendLog("livesdk_danmu_start_show", r103, new Object[]{IRoom.class, x.class});
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "gameName");
        Intrinsics.checkNotNullParameter(r102, "pageType");
        LinkedHashMap r103 = new LinkedHashMap();
        r103.put("request_page", "interact_panel");
        r103.put("page_type", r102);
        r103.put("game_id", r100);
        r103.put("danmu_name", r101);
        j0.l().sendLog("livesdk_danmu_start_click", r103, new Object[]{IRoom.class, x.class});
    }

    @Override // com.bytedance.android.live.liveinteract.utils.m
    public final void f(boolean r100, String r101, String r102, String r103) {
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("request_page", "interact_panel");
        r104.put("game_id", f533088b);
        r104.put("danmu_name", f533089c);
        if (r100 == false) goto L5;
        r104.put("result", "success");
    L15:
        ALogger.i("LinkMicGameLogUtil", "onDanmuStartPlayRes: " + r104);
        j0.l().sendLog("livesdk_danmu_start_res", r104, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r104.put("result", "failed");
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        r104.put("failed_reason", r101);
        if (r102 != null) goto L11;
        r102 = "";
    L11:
        r104.put("error_code", r102);
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r104.put("error_msg", r103);
        goto L15
    }
}
