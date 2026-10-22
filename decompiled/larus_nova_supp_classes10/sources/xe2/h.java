package xe2;

import am2.x;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RealTimeChorusStage;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class h {
    public static long a = 0;
    public static long b = 0;
    public static int c = 0;
    public static int d = 0;
    public static Integer e = null;
    public static String f = "";
    public static String g = "";

    public static final String f(int r1) {
        switch(r1) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L12;
        };
    L5:
        return "gift";
    L6:
        return "specify";
    L7:
        return "mutual";
    L8:
        return "vip";
    L9:
        return "fans_club";
    L10:
        return "fans";
    L12:
        return LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL;
    }

    public static final String d() {
        if ((!Intrinsics.areEqual(g, "")) == true) goto L14;
        KtvModeOrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r0 == null) goto L15;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
        if (r1 == null) goto L16;
        String r2 = String.valueOf(r1.c());
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L16:
        return "";
    L15:
        return "";
    L14:
        return g;
    }

    public static final String e() {
        if ((!Intrinsics.areEqual(f, "")) == true) goto L14;
        KtvModeOrderedSongDataContext r0 = KtvModeOrderedSongDataContext.Companion.getContext();
        if (r0 == null) goto L15;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
        if (r1 == null) goto L16;
        String r2 = r1.e();
        if (r2 != null) goto L13;
        return "";
    L13:
        return r2;
    L16:
        return "";
    L15:
        return "";
    L14:
        return f;
    }

    public static final String g() {
        Integer r0 = e;
        int r1 = RealTimeChorusStage.RealTimeChorusStage_Normal.getValue();
        if (r0 != null) goto L6;
    L8:
        int r2 = RealTimeChorusStage.RealTimeChorusStage_Carnival.getValue();
        if (r0 != null) goto L12;
    L15:
        int r3 = RealTimeChorusStage.RealTimeChorusStage_Peak.getValue();
        if (r0 != null) goto L19;
    L22:
        return "level_1";
    L19:
        if (r0.intValue() != r3) goto L22;
        return "level_3";
    L12:
        if (r0.intValue() != r2) goto L15;
        return "level_2";
    L6:
        if (r0.intValue() != r1) goto L8;
        return "level_1";
    }

    public static final void j() {
        if (a != 0) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        a(r0);
        c(r0);
        b(r0);
        if (h() == false) goto L8;
        String r1 = "1";
    L9:
        r0.put("is_fixed_guest", r1);
        r0.put("duration", String.valueOf((b + (System.currentTimeMillis() - a)) / ((long) 1000)));
        r0.put("stage_level", g());
        j0.l().sendLog("livesdk_chorus_exit_success", r0, new Object[]{IRoom.class, x.class});
        a = 0;
        return;
    L8:
        r1 = BDLocationException.ERROR_TIMEOUT;
        goto L9
    }

    public static final boolean h() {
        String r0 = gh0.a.c();
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 == null) goto L7;
        ILinkPlayerInfoBridge r2 = r1.getGuestInfo(r0, null);
        if (r2 == null) goto L7;
        long r3 = r2.getChorusGuestStatus();
    L9:
        if (r3 <= 0) goto L11;
        return true;
    L11:
        return false;
    L7:
        r3 = 0;
        goto L9
    }

    public static final void a(HashMap<String, String> r2) {
        r2.put("function_type", "chorus");
        r2.put("function_type2", "chorus");
        if (j.i() == false) goto L5;
        String r0 = "anchor";
    L12:
        r2.put("user_type", r0);
        return;
    L5:
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 != null) goto L9;
    L11:
        r0 = "user";
        goto L12
    L9:
        if (r1.intValue() != 2) goto L11;
        r0 = "guest";
        goto L12
    }

    public static final void b(HashMap<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        String r1 = "1";
        if (jc0.a.a == false) goto L5;
        String r0 = "1";
    L6:
        r5.put("is_lead_singer", r0);
        RealTimeChorusBusinessContext.a r2 = RealTimeChorusBusinessContext.Companion;
        if (r2.e() == false) goto L9;
        String r3 = "1";
    L10:
        r5.put("is_setting_lead", r3);
        if (r2.j() == true) goto L13;
    L15:
        r1 = BDLocationException.ERROR_TIMEOUT;
    L16:
        r5.put("is_cdn_song_user", r1);
        return;
    L13:
        if (r2.d() != 3) goto L15;
    L9:
        r3 = BDLocationException.ERROR_TIMEOUT;
        goto L10
    L5:
        r0 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static final void c(HashMap<String, String> r2) {
        r2.put("song_name", e());
        r2.put("ksong_id", d());
    }

    public static final void k(String r4) {
        Intrinsics.checkNotNullParameter(r4, "buttonType");
        HashMap r0 = new HashMap();
        a(r0);
        c(r0);
        b(r0);
        r0.put("button_type", r4);
        if (h() == false) goto L5;
        String r5 = "1";
    L6:
        r0.put("is_fixed_guest", r5);
        r0.put("order_limit", f(c));
        r0.put("join_limit", f(d));
        j0.l().sendLog("livesdk_chorus_join_icon_click", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static final void l(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        HashMap r0 = new HashMap();
        a(r0);
        r0.putAll(r4);
        j0.l().sendLog("livesdk_chorus_user_pay_popup_click", r0, new Object[]{IRoom.class, x.class});
    }

    public static final void m(Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r4, "extraParams");
        HashMap r0 = new HashMap();
        a(r0);
        r0.putAll(r4);
        j0.l().sendLog("livesdk_chorus_user_pay_popup_show", r0, new Object[]{IRoom.class, x.class});
    }

    public static final void i(int r2, int r3, int r4, String r5) {
        HashMap r0 = new HashMap();
        r0.put("order_limit", f(r2));
        r0.put("join_limit", f(r3));
        if (r4 == 0) goto L5;
        String r6 = "1";
    L6:
        r0.put("is_leader_type", r6);
        if (r2.a(r5) == false) goto L11;
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r0.put("source", r5);
    L11:
        j0.l().sendLog("livesdk_anchor_chorus_success", r0, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static final void n(Boolean r3, boolean r4, int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        HashMap r1 = new HashMap();
        if (r3 == null) goto L5;
        r1.put("lastVisibleState", String.valueOf(r3.booleanValue()));
    L6:
        r1.put("isAnchor", String.valueOf(r4));
        r1.put("currentLoginUserRoleType", String.valueOf(r5));
        r1.put("action", r6);
        j0.l().sendLog("detection_howling_exception", r1, new Object[]{IRoom.class, x.class});
        return;
    L5:
        r1.put("lastVisibleState", "false");
        goto L6
    }
}
