package ii0;

import android.os.SystemClock;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.battle.GuestBattleContext;
import com.bytedance.android.live.liveinteract.revenuebase.MultiRevenueDataContext;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.a0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.obric.assistant.WakeupSoundEffectSettings;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f489960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f489961b;

    public static String f(int r100) {
        if (r100 != 1) goto L5;
        return "start";
    L5:
        if (r100 != 2) goto L7;
        return "fight";
    L7:
        if (r100 == 3) goto L9;
        return "none";
    L9:
        return "rush";
    }

    public static void g() {
        if (f489960a != 0) goto L5;
        return;
    L5:
        String r100 = String.valueOf((SystemClock.uptimeMillis() - f489960a) / ((long) 1000));
        f489960a = 0;
        LinkedHashMap r101 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r101);
        TalkRoomLogUtils.B0(r101, null, null, 6);
        TalkRoomLogUtils.V0(r101);
        r101.put(FastStartLiveConfig.PLAY_MODE, "boom");
        r101.put("duration", r100);
        GuestBattleContext.a r102 = GuestBattleContext.Companion;
        if (r102.d() == false) goto L8;
        String r103 = "ongoing";
    L9:
        r101.put("play_stage", r103);
        r101.put("play_period", f(r102.b()));
        d(r101);
        j0.l().sendLog("livesdk_audience_playmode_room_link_duration", r101, new Object[]{IRoom.class});
        return;
    L8:
        r103 = "over";
        goto L9
    }

    public static void h() {
        if (f489960a == 0) goto L5;
        return;
    L5:
        f489960a = SystemClock.uptimeMillis();
        LinkedHashMap r100 = new LinkedHashMap();
        TalkRoomLogUtils.J0(r100);
        TalkRoomLogUtils.B0(r100, null, null, 6);
        TalkRoomLogUtils.V0(r100);
        r100.put(FastStartLiveConfig.PLAY_MODE, "boom");
        GuestBattleContext.a r101 = GuestBattleContext.Companion;
        if (r101.d() == false) goto L8;
        String r102 = "ongoing";
    L9:
        r100.put("play_stage", r102);
        r100.put("play_period", f(r101.b()));
        d(r100);
        j0.l().sendLog("livesdk_audience_playmode_room_link", r100, new Object[]{IRoom.class});
        return;
    L8:
        r102 = "over";
        goto L9
    }

    static {
    }

    public static void a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        HashMap r101 = (HashMap) r100;
        String r102 = (String) r101.get("play_type");
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        String r103 = "bomb";
        boolean r104 = false;
        if (StringsKt.contains$default(r102, "bomb", false, 2, null) == false) goto L9;
        return;
    L9:
        if (r102.length() <= 0) goto L11;
        r104 = true;
    L11:
        if (r104 == false) goto L13;
        r103 = ",bomb";
    L13:
        r101.put("play_type", r102.concat(r103));
    }

    public static void d(Map r100) {
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r101 = MultiRevenueDataContext.a.a();
        if (r101 == null) goto L7;
        a0 r102 = r101.c();
        if (r102 == null) goto L7;
        Long r103 = Long.valueOf(r102.getUiType());
    L8:
        if (r103 != null) goto L11;
    L13:
        if (r103 != null) goto L16;
    L18:
        String r104 = WakeupSoundEffectSettings.CLASSIC;
    L19:
        r100.put("play_layout", r104);
        return;
    L16:
        if (r103.longValue() != 1) goto L18;
        r104 = "flexible";
        goto L19
    L11:
        if (r103.longValue() != 2) goto L13;
    L7:
        r103 = null;
        goto L8
    }

    public static void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        HashMap r101 = new HashMap();
        r101.put("user_id", ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n().toString());
        r101.put("user_cnt", String.valueOf(d.S()));
        r101.put(EventConstants.ExtraJson.GAME_NAME, "bomb");
        r101.put("request_page", r100);
        TalkRoomLogUtils.B0(r101, null, null, 6);
        i0 r102 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.i1(r101);
        j0.l().sendLog("livesdk_connection_game_window_show", r101, new Object[]{IRoom.class});
    }

    public static void c(Map r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Integer r102 = null;
        if (r101 == false) goto L12;
        GuestBattleContext.a r103 = GuestBattleContext.Companion;
        if (r103.e() == false) goto L19;
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r104 = MultiRevenueDataContext.a.a();
        if (r104 == null) goto L11;
        a0 r105 = r104.c();
        if (r105 == null) goto L11;
        r102 = Integer.valueOf(r105.getScoreType());
    L11:
        r100.put("compete_mode", String.valueOf(r102));
        d(r100);
        r100.put("play_period", f(r103.b()));
        return;
    L19:
        return;
    L12:
        MultiRevenueDataContext.Companion.getClass();
        com.bytedance.android.live.liveinteract.revenuebase.a r106 = MultiRevenueDataContext.a.a();
        if (r106 == null) goto L17;
        a0 r107 = r106.c();
        if (r107 == null) goto L17;
        r102 = Integer.valueOf(r107.getScoreType());
    L17:
        r100.put("compete_mode", String.valueOf(r102));
        d(r100);
    }

    public static void b(String r100, int r101, boolean r102, int r103, int r104, String r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r105, "result");
        Intrinsics.checkNotNullParameter(r110, "requestPage");
        HashMap r106 = new HashMap();
        r106.put("user_cnt", String.valueOf(d.S()));
        r106.put(EventConstants.ExtraJson.GAME_NAME, "bomb");
        r106.put("game_time", String.valueOf(r101));
        r106.put("action_type", r100);
        String r107 = "1";
        if (r102 == false) goto L5;
        Object r108 = "1";
    L6:
        r106.put("is_anchor_in", r108);
        if (r104 != ((int) 1)) goto L9;
        String r109 = "flexible";
    L10:
        r106.put("play_layout", r109);
        if (r105.length() <= 0) goto L13;
        boolean r111 = true;
    L14:
        if (r111 == false) goto L16;
        r106.put("result", r105);
    L16:
        i0 r112 = TalkRoomLogUtils.f77433a;
        if (TalkRoomLogUtils.E() == true) goto L20;
        r107 = "0";
    L20:
        r106.put("if_enlarge", r107);
        r106.put("request_page", r110);
        TalkRoomLogUtils.B0(r106, null, null, 6);
        TalkRoomLogUtils.i1(r106);
        Intrinsics.checkNotNullParameter(r106, "params");
        r106.put("compete_mode", String.valueOf(r103));
        j0.l().sendLog("livesdk_connection_game_window_start_result", r106, new Object[]{IRoom.class});
        return;
    L13:
        r111 = false;
        goto L14
    L9:
        r109 = WakeupSoundEffectSettings.CLASSIC;
        goto L10
    L5:
        r108 = "0";
        goto L6
    }
}
