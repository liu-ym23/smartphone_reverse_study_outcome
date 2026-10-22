package ju2;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f {
    public static final /* synthetic */ int M = 0;
    public final String A;
    public final String B;
    public final String C;
    public String D;
    public int E;
    public final String F;
    public int G;
    public int H;
    public int I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f500439J;
    public int K;
    public final String L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f500440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f500442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f500443d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f500444e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f500445f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f500446g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f500447h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f500448i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f500449j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f500450k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f500451l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f500452m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f500453n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f500454o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f500455p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f500456q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f500457r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f500458s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f500459t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f500460u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f500461v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f500462w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f500463x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f500464y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f500465z;

    public static final class a {
        public static f a(IRoom r100) {
            Intrinsics.checkNotNullParameter(r100, "room");
            f r101 = new f();
            IEpisodeExtraInfo r102 = r100.getEpisodeExtra();
            String r103 = "";
            if (r102 == null) goto L6;
            String r104 = r102.getItemId();
            if (r104 == null) goto L6;
        L7:
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r101.f500442c = r104;
            String r105 = String.valueOf(r100.getId());
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r101.f500443d = r105;
            String r106 = r100.getOwnerUserIdString();
            Intrinsics.checkNotNullParameter(r106, "<set-?>");
            r101.f500445f = r106;
            IEpisodeExtraInfo r107 = r100.getEpisodeExtra();
            if (r107 == null) goto L15;
            Long r108 = r107.getSeasonId();
            if (r108 == null) goto L15;
            String r109 = String.valueOf(r108.longValue());
            if (r109 == null) goto L15;
            r103 = r109;
        L15:
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r101.f500446g = r103;
            IEpisodeExtraInfo r110 = r100.getEpisodeExtra();
            if (r110 == null) goto L18;
            long r111 = r110.getId();
        L19:
            String r112 = String.valueOf(r111);
            Intrinsics.checkNotNullParameter(r112, "<set-?>");
            r101.f500444e = r112;
            IEpisodeExtraInfo r113 = r100.getEpisodeExtra();
            int r114 = -1;
            if (r113 == null) goto L24;
            IBaseEpisodeMod r115 = r113.getRealMod();
            if (r115 == null) goto L24;
            int r116 = r115.getEpisodeStage();
        L25:
            r101.E = r116;
            IEpisodeExtraInfo r117 = r100.getEpisodeExtra();
            if (r117 == null) goto L30;
            IBaseEpisodeMod r118 = r117.getRealMod();
            if (r118 == null) goto L30;
            int r119 = r118.getEpisodeType();
        L31:
            r101.G = r119;
            IEpisodeExtraInfo r120 = r100.getEpisodeExtra();
            if (r120 == null) goto L36;
            IBaseEpisodeMod r121 = r120.getRealMod();
            if (r121 == null) goto L36;
            int r122 = r121.getEpisodeSubType();
        L37:
            r101.H = r122;
            IEpisodeExtraInfo r123 = r100.getEpisodeExtra();
            if (r123 == null) goto L42;
            IBaseEpisodeMod r124 = r123.getRealMod();
            if (r124 == null) goto L42;
            r114 = r124.getEpisodeRecordType();
        L42:
            r101.I = r114;
            LiveVSLog.f153393r.getClass();
            r101.K = LiveVSLog.b.b(r100);
            return r101;
        L36:
            r122 = -1;
        L30:
            r119 = -1;
        L24:
            r116 = -1;
            goto L25
        L18:
            r111 = -1;
        L6:
            r104 = "";
            goto L7
        }
    }

    static {
    }

    public final String a() {
        int r100 = this.E;
        if (r100 != EpisodeMod.EpisodeStageType.LIVE) goto L6;
        return "live";
    L6:
        if (r100 != EpisodeMod.EpisodeStageType.RECORD) goto L9;
        return "record";
    L9:
        if (r100 != EpisodeMod.EpisodeStageType.PREMIERE) goto L11;
        return EnterRoomExtra.VS_TYPE_PREMIERE;
    L11:
        return "";
    }

    public final Map<String, String> b() {
        HashMap r100 = new HashMap();
        if (this.f500440a.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100.put("request_id", this.f500440a);
    L9:
        if (this.f500441b.length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L15;
        r100.put("log_pb", this.f500441b);
    L15:
        if (this.f500442c.length() <= 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        r100.put("vs_ep_group_id", this.f500442c);
    L21:
        if (this.f500443d.length() <= 0) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L27;
        r100.put("room_id", this.f500443d);
    L27:
        if (this.f500444e.length() <= 0) goto L29;
        boolean r105 = true;
    L30:
        if (r105 == false) goto L33;
        r100.put("vs_episode_id", this.f500444e);
    L33:
        if (this.f500446g.length() <= 0) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == false) goto L39;
        r100.put("vs_season_id", this.f500446g);
    L39:
        if (this.f500447h.length() <= 0) goto L41;
        boolean r107 = true;
    L42:
        if (r107 == false) goto L45;
        r100.put("video_id", this.f500447h);
    L45:
        if (this.f500445f.length() <= 0) goto L47;
        boolean r108 = true;
    L48:
        if (r108 == false) goto L51;
        r100.put("author_id", this.f500445f);
    L51:
        if (this.f500458s.length() <= 0) goto L53;
        boolean r109 = true;
    L54:
        if (r109 == false) goto L57;
        r100.put("vs_enter_type", this.f500458s);
    L57:
        if (this.f500459t.length() <= 0) goto L59;
        boolean r110 = true;
    L60:
        if (r110 == false) goto L63;
        r100.put("previous_page", this.f500459t);
    L63:
        if (this.f500460u.length() <= 0) goto L65;
        boolean r111 = true;
    L66:
        if (r111 == false) goto L69;
        r100.put("vs_from_others_homepage_uid", this.f500460u);
    L69:
        if (this.f500461v.length() <= 0) goto L71;
        boolean r112 = true;
    L72:
        if (r112 == false) goto L75;
        r100.put("live_reason", this.f500461v);
    L75:
        if (this.f500465z.length() <= 0) goto L77;
        boolean r113 = true;
    L78:
        if (r113 == false) goto L81;
        r100.put("vs_pay_result_status", this.f500465z);
    L81:
        if (this.f500464y.length() <= 0) goto L83;
        boolean r114 = true;
    L84:
        if (r114 == false) goto L87;
        r100.put("is_paidepisode", this.f500464y);
    L87:
        if (this.A.length() <= 0) goto L89;
        boolean r115 = true;
    L90:
        if (r115 == false) goto L93;
        r100.put("vs_sku_id", this.A);
    L93:
        if (this.B.length() <= 0) goto L95;
        boolean r116 = true;
    L96:
        if (r116 == false) goto L99;
        r100.put("vs_ticket_type", this.B);
    L99:
        if (a().length() <= 0) goto L101;
        boolean r117 = true;
    L102:
        if (r117 == false) goto L104;
        r100.put("vs_episode_stage", a());
    L104:
        int r118 = this.G;
        String r119 = "special";
        String r120 = "unknown";
        if (r118 != EpisodeMod.EpisodeType.NORMAL) goto L108;
        String r121 = "formal";
    L115:
        if (r121.length() <= 0) goto L117;
        boolean r122 = true;
    L118:
        if (r122 == false) goto L130;
        int r123 = this.G;
        if (r123 != EpisodeMod.EpisodeType.NORMAL) goto L123;
        r119 = "formal";
    L129:
        r100.put("vs_episode_type", r119);
        goto L130
    L123:
        if (r123 == EpisodeMod.EpisodeType.FEATURE) goto L129;
        if (r123 != EpisodeMod.EpisodeType.UNKNOWN) goto L128;
        r119 = "unknown";
        goto L129
    L128:
        r119 = "";
    L130:
        int r124 = this.H;
        if (r124 != EpisodeMod.EpisodeSubType.GUIDE) goto L134;
        String r125 = "pilot_file";
    L141:
        if (r125.length() <= 0) goto L143;
        boolean r126 = true;
    L144:
        if (r126 == false) goto L157;
        int r127 = this.H;
        if (r127 != EpisodeMod.EpisodeSubType.GUIDE) goto L149;
        r120 = "pilot_file";
    L155:
        r100.put("vs_episode_sub_type", r120);
        goto L157
    L149:
        if (r127 != EpisodeMod.EpisodeSubType.NORMAL) goto L152;
        r120 = "normal";
        goto L155
    L152:
        if (r127 == EpisodeMod.EpisodeSubType.UNKNOWN) goto L155;
        r120 = "";
    L157:
        if (a().length() <= 0) goto L159;
        boolean r128 = true;
    L160:
        if (r128 == false) goto L172;
        int r129 = this.E;
        if (r129 != EpisodeMod.EpisodeStageType.LIVE) goto L165;
        String r130 = "living";
    L171:
        r100.put("vs_play_status", r130);
        goto L172
    L165:
        if (r129 != EpisodeMod.EpisodeStageType.PREMIERE) goto L168;
        r130 = "premiere_ing";
        goto L171
    L168:
        if (this.I != EpisodeMod.EpisodeRecordType.LATEST) goto L170;
        r130 = "last_content";
        goto L171
    L170:
        r130 = "";
    L172:
        long r131 = this.f500452m;
        if (r131 < 0) goto L176;
        r100.put("vs_watch_record", String.valueOf(r131));
    L176:
        if (this.f500451l.length() <= 0) goto L178;
        boolean r132 = true;
    L179:
        if (r132 == false) goto L182;
        r100.put("vs_has_chase_record", this.f500451l);
    L182:
        if (this.f500448i.length() <= 0) goto L184;
        boolean r133 = true;
    L185:
        if (r133 == false) goto L188;
        r100.put("vs_from_episode_id", this.f500448i);
    L188:
        if (this.f500449j.length() <= 0) goto L190;
        boolean r134 = true;
    L191:
        if (r134 == false) goto L194;
        r100.put("vs_from_module_name", this.f500449j);
    L194:
        if (this.f500450k.length() <= 0) goto L196;
        boolean r135 = true;
    L197:
        if (r135 == false) goto L200;
        r100.put("vs_extension_type", this.f500450k);
    L200:
        if (this.C.length() <= 0) goto L202;
        boolean r136 = true;
    L203:
        if (r136 == false) goto L205;
        r100.put("vs_bottom_bar_start_type", this.C);
    L205:
        int r137 = this.f500453n;
        if (r137 < 0) goto L215;
        if (r137 != 0) goto L209;
    L212:
        String r138 = "landscape";
    L213:
        r100.put("vs_screen_type", r138);
        goto L215
    L209:
        if (r137 == 6) goto L212;
        r138 = "portrait";
    L215:
        if (this.f500454o.length() <= 0) goto L217;
        boolean r139 = true;
    L218:
        if (r139 == false) goto L220;
        r100.put("search_params", this.f500454o);
    L220:
        int r140 = this.f500455p;
        if (r140 < 0) goto L224;
        r100.put("vs_is_auto_premiere2record", String.valueOf(r140));
    L224:
        if (this.f500439J.length() <= 0) goto L226;
        boolean r141 = true;
    L227:
        if (r141 == false) goto L229;
        r100.put("enter_from_merge", this.f500439J);
    L229:
        int r142 = this.K;
        String r143 = "1";
        if (r142 < 0) goto L237;
        if (r142 != 2) goto L234;
        Object r144 = "1";
    L235:
        r100.put("vs_is_portraid_content", r144);
        goto L237
    L234:
        r144 = "0";
    L237:
        if (dt2.f.f470000a.getValue().booleanValue() == false) goto L242;
        if ((!Intrinsics.areEqual(this.f500456q, "-1")) == false) goto L245;
        r100.put("order", this.f500456q);
    L245:
        if ((!Intrinsics.areEqual(this.f500457r, "")) == false) goto L248;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, this.f500457r);
    L248:
        if ((!Intrinsics.areEqual(this.F, "")) == false) goto L251;
        r100.put("episode_title", this.F);
    L251:
        if (this.f500462w.length() <= 0) goto L253;
        boolean r145 = true;
    L254:
        if (r145 == false) goto L257;
        r100.put("vs_machine_id", this.f500462w);
    L257:
        if (this.f500463x.length() <= 0) goto L259;
        boolean r146 = true;
    L260:
        if (r146 == false) goto L263;
        r100.put(PaidReplayConstants.KEY_VS_MACHINE_TYPE, this.f500463x);
    L263:
        if (this.D.length() <= 0) goto L265;
        boolean r147 = true;
    L266:
        if (r147 == false) goto L269;
        r100.put("vs_medium_type", this.D);
    L269:
        if (this.L.length() <= 0) goto L271;
        boolean r148 = true;
    L272:
        if (r148 == false) goto L274;
        r100.put("vs_highlight_label", this.L);
    L274:
        r100.put("vs_comment_style", String.valueOf(0));
        r100.put("vs_comment_switcher", String.valueOf(false));
        r100.put("is_official_account", "0");
        if (this.f500453n != 1) goto L277;
        r143 = "0";
    L277:
        r100.put("is_hor", r143);
        return r100;
    L271:
        r148 = false;
        goto L272
    L265:
        r147 = false;
        goto L266
    L259:
        r146 = false;
        goto L260
    L253:
        r145 = false;
        goto L254
    L242:
        if ((!Intrinsics.areEqual(this.f500456q, "")) == false) goto L245;
        r100.put("order", this.f500456q);
        goto L245
    L226:
        r141 = false;
        goto L227
    L217:
        r139 = false;
        goto L218
    L202:
        r136 = false;
        goto L203
    L196:
        r135 = false;
        goto L197
    L190:
        r134 = false;
        goto L191
    L184:
        r133 = false;
        goto L185
    L178:
        r132 = false;
        goto L179
    L159:
        r128 = false;
        goto L160
    L143:
        r126 = false;
        goto L144
    L134:
        if (r124 != EpisodeMod.EpisodeSubType.NORMAL) goto L137;
        r125 = "normal";
        goto L141
    L137:
        if (r124 != EpisodeMod.EpisodeSubType.UNKNOWN) goto L139;
        r125 = "unknown";
        goto L141
    L139:
        r125 = "";
        goto L141
    L117:
        r122 = false;
        goto L118
    L108:
        if (r118 != EpisodeMod.EpisodeType.FEATURE) goto L111;
        r121 = "special";
        goto L115
    L111:
        if (r118 != EpisodeMod.EpisodeType.UNKNOWN) goto L113;
        r121 = "unknown";
        goto L115
    L113:
        r121 = "";
        goto L115
    L101:
        r117 = false;
        goto L102
    L95:
        r116 = false;
        goto L96
    L89:
        r115 = false;
        goto L90
    L83:
        r114 = false;
        goto L84
    L77:
        r113 = false;
        goto L78
    L71:
        r112 = false;
        goto L72
    L65:
        r111 = false;
        goto L66
    L59:
        r110 = false;
        goto L60
    L53:
        r109 = false;
        goto L54
    L47:
        r108 = false;
        goto L48
    L41:
        r107 = false;
        goto L42
    L35:
        r106 = false;
        goto L36
    L29:
        r105 = false;
        goto L30
    L23:
        r104 = false;
        goto L24
    L17:
        r103 = false;
        goto L18
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public f() {
        this.f500440a = "";
        this.f500441b = "";
        this.f500442c = "";
        this.f500443d = "";
        this.f500444e = "";
        this.f500445f = "";
        this.f500446g = "";
        this.f500447h = "";
        this.f500448i = "";
        this.f500449j = "";
        this.f500450k = "";
        this.f500451l = "";
        this.f500452m = -1;
        this.f500453n = 1;
        this.f500454o = "";
        this.f500455p = -1;
        this.f500456q = "-1";
        this.f500457r = UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT;
        this.f500458s = "";
        this.f500459t = "";
        this.f500460u = "";
        this.f500461v = "";
        this.f500462w = "";
        this.f500463x = "";
        this.f500464y = "";
        this.f500465z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = -1;
        this.F = "";
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.f500439J = "";
        this.K = -1;
        this.L = "";
    }
}
