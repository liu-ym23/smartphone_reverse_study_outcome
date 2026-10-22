package li0;

import com.bytedance.android.live.base.model.message.o2;
import com.bytedance.android.live.liveinteract.multiscene.f;
import com.bytedance.android.live.liveinteract.multiscene.j;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.util.k;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.lark.search.dto.UserGroupScene;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f509312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f509313b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f509314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f509315b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f509314a == r101.f509314a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f509315b, r101.f509315b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            long r100 = this.f509314a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f509315b;
            if (r102 == null) goto L5;
            int r103 = r102.hashCode();
        L7:
            return r101 + r103;
        L5:
            r103 = 0;
            goto L7
        }

        public final String toString() {
            return "WatchInfo(duration=" + this.f509314a + ", stage=" + this.f509315b + ")";
        }

        public a(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "stage");
            this.f509314a = r100;
            this.f509315b = r101;
        }
    }

    public b() {
    }

    public static String c(int r100) {
        if (r100 != 1) goto L5;
        return "prepare";
    L5:
        if (r100 != 2) goto L7;
        return "processing";
    L7:
        if (r100 == 3) goto L10;
        return "";
    L10:
        return "punish";
    }

    public static String d(int r100) {
        if (r100 != 1) goto L7;
        return "red";
    L7:
        if (r100 != 2) goto L10;
        return "blue";
    L10:
        return "";
    }

    static {
        f509313b = new b();
    }

    public static String b() {
        TeamFightContext.a r100 = TeamFightContext.Companion;
        if (r100.h() == true) goto L7;
        return null;
    L7:
        if (r100.d() == false) goto L11;
        return "prepare";
    L11:
        if (r100.e() == false) goto L14;
        return "punish";
    L14:
        return "processing";
    }

    public final void f() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("seat_fit_status", "off");
        k(r100);
        j(this, r100, null, true, 2);
        m<IRoom> r101 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r101 == null) goto L18;
        IRoom r102 = r101.getValue();
        if (r102 == null) goto L18;
        if (r102.isLiveTypeAudio() != true) goto L18;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r103 = IVoiceChatGuestService.a.a();
        if (r103 == null) goto L12;
        k r104 = r103.getLogger();
        if (r104 == null) goto L12;
    L16:
        if (r104 == null) goto L19;
        k.t(r104, 7, r100, f509312a, 3);
    L19:
        f509312a = 0;
        return;
    L12:
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r105 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r105 == null) goto L15;
        r104 = r105.getLogger();
        goto L16
    L15:
        r104 = null;
    L18:
        TalkRoomLogUtils.N(null, 7, r100, f509312a, 3);
        goto L19
    }

    public static String a(com.bytedance.android.live.liveinteract.multiscene.a r100) {
        int r101 = r100.getTeamBattleType();
        if (r101 != 1) goto L5;
        return "fixed";
    L5:
        if (r101 == 2) goto L7;
        return "";
    L7:
        return "flexible";
    }

    public static void e(o2 r110) {
        boolean r100 = r110 instanceof o2;
        if (r100 == false) goto L5;
        int r101 = r110.getFinishReason();
    L7:
        if (r100 == false) goto L9;
        Object r111 = r110.getFinishUserIdString();
    L10:
        String r102 = ((IMiddlewareUserService) jc1.k.n(IMiddlewareUserService.class)).user().n();
        if (Intrinsics.areEqual(r111, 0L) == false) goto L14;
        r111 = r102;
    L14:
        if (Intrinsics.areEqual(r111, r102) == false) goto L16;
        String r103 = "anchor";
    L17:
        m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r104 == null) goto L35;
        IRoom r105 = r104.getValue();
        if (r105 == null) goto L35;
        if (r105.isLiveTypeAudio() != true) goto L35;
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r106 = IVoiceChatGuestService.a.a();
        if (r106 == null) goto L29;
        k r107 = r106.getLogger();
        if (r107 == null) goto L29;
    L28:
        k r108 = r107;
        if (r108 == null) goto L37;
        k.m(r108, null, 7, 0, 0, Integer.valueOf(r101), String.valueOf(r111), r103, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME);
        return;
    L37:
        return;
    L29:
        com.bytedance.android.live.liveinteract.voicechat.d.f80030s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r109 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r109 == null) goto L32;
        r107 = r109.getLogger();
        goto L28
    L32:
        r107 = null;
    L35:
        TalkRoomLogUtils.L(7, 0, 0, Integer.valueOf(r101), String.valueOf(r111), r103, null, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME);
        return;
    L16:
        r103 = UserGroupScene.DEFAULT_NAME_SPACE;
        goto L17
    L9:
        r111 = 0L;
        goto L10
    L5:
        r101 = 1;
        goto L7
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
        HashMap r101 = new HashMap();
        r101.put("action_type", r100);
        k(r101);
        TalkRoomLogUtils.B0(r101, null, null, 6);
        j0.l().sendLog("livesdk_grouppk_user_apply_panel", r101, new Object[]{IRoom.class});
    }

    public static void i(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        TeamFightContext.a r101 = TeamFightContext.Companion;
        if (r101.h() == false) goto L5;
    L6:
        com.bytedance.android.live.liveinteract.multiscene.a r102 = r101.b();
        if (r102 == null) goto L18;
        HashMap r103 = (HashMap) r100;
        r103.put("play_layout", a(r102));
        j r104 = d.i(r102);
        j r105 = d.a(r102);
        Long r106 = null;
        if (r104 == null) goto L11;
        Long r107 = r104.getMaxMember();
    L12:
        r103.put("grouppk_redcnt", String.valueOf(r107));
        if (r105 == null) goto L15;
        r106 = r105.getMaxMember();
    L15:
        r103.put("grouppk_bluecnt", String.valueOf(r106));
        return;
    L11:
        r107 = null;
        goto L12
    L18:
        return;
    L5:
        if (r101.g() == true) goto L6;
    }

    public static void k(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "logMap");
        String r101 = b();
        if (r101 == null) goto L6;
        r100.put("grouppk_stage", r101);
        return;
    }

    public static void g(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        Intrinsics.checkNotNullParameter(r101, "source");
        LinkedHashMap r102 = new LinkedHashMap();
        TalkRoomLogUtils.B0(r102, null, null, 6);
        r102.put("request_page", r100);
        i0 r103 = TalkRoomLogUtils.f77433a;
        TalkRoomLogUtils.i1(r102);
        r102.put("source", r101);
        j0.l().sendLog("livesdk_grouppk_icon_click", r102, new Object[]{IRoom.class});
    }

    public static void j(b r100, Map r101, com.bytedance.android.live.liveinteract.multiscene.a r102, boolean r103, int r104) {
        String r105 = null;
        if ((r104 & 2) == 0) goto L5;
        r102 = null;
    L5:
        boolean r106 = false;
        if ((r104 & 4) == 0) goto L8;
        r103 = false;
    L8:
        r100.getClass();
        TeamFightContext.a r107 = TeamFightContext.Companion;
        if (r107.h() == false) goto L11;
    L13:
        if (r102 != null) goto L15;
        r102 = r107.b();
    L15:
        if (r102 == null) goto L61;
        r101.put("play_layout", a(r102));
        j r108 = d.i(r102);
        j r109 = d.a(r102);
        if (r108 == null) goto L19;
        Long r110 = r108.getMaxMember();
    L20:
        r101.put("grouppk_redcnt", String.valueOf(r110));
        if (r109 == null) goto L23;
        Long r111 = r109.getMaxMember();
    L24:
        r101.put("grouppk_bluecnt", String.valueOf(r111));
        r101.put("grouppk_playtime", String.valueOf(r102.getDuration()));
        m<IRoom> r112 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r112 == null) goto L29;
        IRoom r113 = r112.getValue();
        if (r113 == null) goto L29;
        r105 = r113.getOwnerUserIdString();
    L29:
        List<j> r114 = r102.getTeamInfos();
        if (r114 == null) goto L44;
        Iterator<T> r115 = r114.iterator();
    L33:
        if (r115.hasNext() == false) goto L44;
        j r116 = (j) r115.next();
        if (r116 == null) goto L33;
        List<f> r117 = r116.getPlayers();
        if (r117 == null) goto L33;
        Iterator<T> r118 = r117.iterator();
    L40:
        if (r118.hasNext() == false) goto L33;
        if (Intrinsics.areEqual(((f) r118.next()).getUserIdString(), r105) == false) goto L40;
        r106 = true;
    L44:
        if (r106 == false) goto L46;
        String r119 = "1";
    L47:
        r101.put("grouppk_anchorpart", r119);
        return;
    L46:
        r119 = "0";
        goto L47
    L23:
        r111 = null;
        goto L24
    L19:
        r110 = null;
        goto L20
    L61:
        return;
    L11:
        if (r107.g() == true) goto L13;
        if (r103 == true) goto L13;
    }
}
