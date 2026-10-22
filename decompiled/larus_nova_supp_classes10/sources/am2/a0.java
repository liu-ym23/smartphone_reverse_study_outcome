package am2;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 {
    public static final /* synthetic */ int L = 0;
    public String A;
    public long B;
    public long C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public Long I;
    public boolean J;
    public HashMap<String, String> K;
    public String a;
    public String b;
    public final String c;
    public String d;
    public String e;
    public int f;
    public String g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public String z;

    public static final class a {
        public static a0 a(Episode r10) {
            Intrinsics.checkNotNullParameter(r10, "episode");
            a0 r0 = new a0();
            String r1 = String.valueOf(r10.roomId);
            Intrinsics.checkNotNullParameter(r1, "<set-?>");
            r0.a = r1;
            String r2 = String.valueOf(r10.getIdExt());
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            r0.b = r2;
            String r3 = EpisodeExtKt.getOwnerIdString(r10);
            Intrinsics.checkNotNullParameter(r3, "<set-?>");
            r0.d = r3;
            String r4 = r10.seasonId;
            String r5 = "";
            if (r4 != null) goto L5;
            r4 = "";
        L5:
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r0.e = r4;
            EpisodeBasicInfo r6 = r10.episodeBasicInfo;
            boolean r7 = false;
            if (r6 == null) goto L8;
            int r8 = r6.getReplayType();
        L9:
            r0.n = r8;
            IMainEpisode r9 = r10.castToOrNull(IMainEpisode.class);
            String r11 = "1";
            PrivilegeInfo r12 = null;
            if (r9 != null) goto L12;
        L19:
            String r13 = "";
        L20:
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            r0.u = r13;
            IMainEpisode r14 = r10.castToOrNull(IMainEpisode.class);
            if (r14 != null) goto L23;
        L25:
            r11 = "";
        L26:
            Intrinsics.checkNotNullParameter(r11, "<set-?>");
            r0.v = r11;
            IMainEpisode r15 = r10.castToOrNull(IMainEpisode.class);
            if (r15 != null) goto L29;
        L41:
            String r16 = "";
        L42:
            Intrinsics.checkNotNullParameter(r16, "<set-?>");
            r0.w = r16;
            IMainEpisode r17 = r10.castToOrNull(IMainEpisode.class);
            if (r17 == null) goto L50;
            ReplayPaidInfo r18 = r17.getReplayPaidInfo();
            if (r18 == null) goto L50;
            if (r18.hasViewRight() == true) goto L50;
            boolean r19 = false;
        L51:
            r0.x = r19;
            IMainEpisode r20 = r10.castToOrNull(IMainEpisode.class);
            if (r20 == null) goto L59;
            ReplayPaidInfo r21 = r20.getReplayPaidInfo();
            if (r21 == null) goto L59;
            if (r21.isDelivery() == true) goto L59;
            boolean r22 = false;
        L60:
            r0.y = r22;
            EpisodeBasicInfo r23 = r10.episodeBasicInfo;
            if (r23 == null) goto L63;
            Long r24 = Long.valueOf(r23.getReplayCameraId());
        L64:
            String r25 = String.valueOf(r24);
            Intrinsics.checkNotNullParameter(r25, "<set-?>");
            r0.q = r25;
            EpisodeBasicInfo r26 = r10.episodeBasicInfo;
            if (r26 == null) goto L67;
            Long r27 = Long.valueOf(r26.getReplayCameraId());
        L68:
            EpisodeBasicInfo r28 = r10.episodeBasicInfo;
            if (r28 == null) goto L71;
            Long r29 = Long.valueOf(r28.getOriginEpisodeId());
        L73:
            if (Intrinsics.areEqual(r27, r29) == false) goto L75;
            String r30 = "major";
        L76:
            Intrinsics.checkNotNullParameter(r30, "<set-?>");
            r0.r = r30;
            String r31 = r10.title;
            if (r31 != null) goto L79;
            r31 = "";
        L79:
            Intrinsics.checkNotNullParameter(r31, "<set-?>");
            r0.s = r31;
            EpisodeVideo r32 = r10.video;
            if (r32 == null) goto L83;
            String r33 = r32.getVid();
            if (r33 == null) goto L83;
        L84:
            Intrinsics.checkNotNullParameter(r33, "<set-?>");
            r0.p = r33;
            if (r0.y == true) goto L87;
        L96:
            String r34 = "try";
        L97:
            Intrinsics.checkNotNullParameter(r34, "<set-?>");
            r0.z = r34;
            IMainEpisode r35 = r10.castToOrNull(IMainEpisode.class);
            if (r35 == null) goto L109;
            Map r36 = r35.getPrivilegeInfo();
            if (r36 == null) goto L109;
            Iterator r37 = r36.values().iterator();
            String r38 = "paid";
        L103:
            if (r37.hasNext() == false) goto L110;
            PrivilegeBaseInfo r39 = ((PrivilegeInfo) r37.next()).paidLiveInfo;
            if (r39 == null) goto L103;
            if (r39.viewRight != 0) goto L103;
            r38 = "not_paid";
        L110:
            Intrinsics.checkNotNullParameter(r38, "<set-?>");
            r0.A = r38;
            IMainEpisode r40 = r10.castToOrNull(IMainEpisode.class);
            if (r40 == null) goto L120;
            ReplayPaidInfo r41 = r40.getReplayPaidInfo();
            if (r41 == null) goto L120;
            TicketData r42 = r41.getTicketData();
            if (r42 == null) goto L120;
            String r43 = r42.getTicketCategoryLogStr();
            if (r43 == null) goto L120;
            r5 = r43;
        L120:
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r0.D = r5;
            IMainEpisode r44 = r10.castToOrNull(IMainEpisode.class);
            long r45 = 0;
            if (r44 == null) goto L127;
            ReplayPaidInfo r46 = r44.getReplayPaidInfo();
            if (r46 == null) goto L127;
            TicketData r47 = r46.getTicketData();
            if (r47 == null) goto L127;
            long r48 = r47.getTicketId();
        L128:
            r0.B = r48;
            EpisodeBasicInfo r49 = r10.episodeBasicInfo;
            if (r49 == null) goto L131;
            Long r50 = Long.valueOf(r49.getContentId());
        L132:
            r0.I = r50;
            IMainEpisode r51 = r10.castToOrNull(IMainEpisode.class);
            if (r51 == null) goto L135;
            r12 = r51.subscribeReplayInfo();
        L135:
            if (r12 == null) goto L137;
            r7 = true;
        L137:
            r0.J = r7;
            IMainEpisode r110 = r10.castToOrNull(IMainEpisode.class);
            if (r110 == null) goto L142;
            ReplayPaidInfo r111 = r110.getReplayPaidInfo();
            if (r111 == null) goto L142;
            r45 = r111.getFreeDuration();
        L142:
            r0.C = r45;
            return r0;
        L131:
            r50 = null;
        L127:
            r48 = 0;
        L109:
            r38 = "none";
            goto L110
        L87:
            if (r0.x == false) goto L96;
            IMainEpisode r52 = r10.castToOrNull(IMainEpisode.class);
            if (r52 == null) goto L95;
            ReplayPaidInfo r53 = r52.getReplayPaidInfo();
            if (r53 == null) goto L95;
            if (r53.getViewRight() != 9) goto L95;
            r34 = "vmember";
        L95:
            r34 = "regular";
        L83:
            r33 = "";
            goto L84
        L75:
            r30 = "others";
            goto L76
        L71:
            r29 = null;
            goto L73
        L67:
            r27 = null;
            goto L68
        L63:
            r24 = null;
        L59:
            r22 = true;
        L50:
            r19 = true;
            goto L51
        L29:
            if (r15.isPaidCameraReplay() != true) goto L41;
            IMainEpisode r54 = r10.castToOrNull(IMainEpisode.class);
            if (r54 == null) goto L39;
            ReplayPaidInfo r55 = r54.getReplayPaidInfo();
            if (r55 == null) goto L39;
            TicketData r56 = r55.getTicketData();
            if (r56 == null) goto L39;
            String r57 = r56.getPrice();
            if (r57 == null) goto L39;
            Long r58 = Long.valueOf((long) (CastFloatProtector.parseFloat(r57) * 100));
        L40:
            r16 = String.valueOf(r58);
        L39:
            r58 = null;
            goto L40
        L23:
            if (r14.isPaidCameraReplay() != true) goto L25;
        L12:
            if (r9.isPaidReplay() != true) goto L19;
            IMainEpisode r59 = r10.castToOrNull(IMainEpisode.class);
            if (r59 == null) goto L16;
            PrivilegeInfo r60 = r59.subscribeReplayInfo();
        L17:
            if (r60 != null) goto L19;
            r13 = "1";
            goto L20
        L16:
            r60 = null;
            goto L17
        L8:
            r8 = 0;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"am2/a0$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    static {
    }

    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(this.t) == true) goto L10;
        String r1 = Uri.decode(this.t);
        r0.put("log_params", r1);
        Map r2 = (Map) new Gson().fromJson(r1, new b().getType());     // Catch: Exception -> L9
        if (r2 == null) goto L10;
        r0.putAll(r2);     // Catch: Exception -> L9
    L10:
        HashMap<String, String> r3 = this.K;
        if (r3 == null) goto L13;
        r0.putAll(r3);
    L13:
        boolean r4 = false;
        if (this.a.length() <= 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == false) goto L20;
        r0.put("room_id", this.a);
    L20:
        if (this.b.length() <= 0) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L26;
        r0.put("vs_episode_id", this.b);
    L26:
        if (this.c.length() <= 0) goto L28;
        boolean r7 = true;
    L29:
        if (r7 == false) goto L32;
        r0.put("vs_episode_stage", this.c);
    L32:
        if (this.e.length() <= 0) goto L34;
        boolean r8 = true;
    L35:
        if (r8 == false) goto L38;
        r0.put("vs_season_id", this.e);
    L38:
        if (this.d.length() <= 0) goto L40;
        boolean r9 = true;
    L41:
        if (r9 == false) goto L44;
        r0.put("anchor_id", this.d);
    L44:
        if (this.g.length() <= 0) goto L46;
        boolean r10 = true;
    L47:
        if (r10 == false) goto L50;
        r0.put("replay_enter_type", this.g);
    L50:
        if (this.j.length() <= 0) goto L52;
        boolean r11 = true;
    L53:
        if (r11 == false) goto L56;
        r0.put("card_order", this.j);
    L56:
        if (this.k.length() <= 0) goto L58;
        boolean r12 = true;
    L59:
        if (r12 == false) goto L62;
        r0.put("content_type", this.k);
    L62:
        if (this.l.length() <= 0) goto L64;
        boolean r13 = true;
    L65:
        if (r13 == false) goto L68;
        r0.put("token_form", this.l);
    L68:
        if (this.m.length() <= 0) goto L70;
        boolean r14 = true;
    L71:
        if (r14 == false) goto L73;
        r0.put("is_rolling_type", this.m);
    L73:
        boolean r15 = this.h;
        if (r15 == false) goto L77;
        r0.put("enter_with_video_model", String.valueOf(r15));
    L77:
        if ("normal".length() <= 0) goto L79;
        boolean r16 = true;
    L80:
        if (r16 == false) goto L83;
        r0.put("vs_episode_sub_type", "normal");
    L83:
        if (this.i.length() <= 0) goto L85;
        boolean r17 = true;
    L86:
        if (r17 == false) goto L88;
        r0.put("replay_bottom_bar_start_type", this.i);
    L88:
        int r18 = this.f;
        if (r18 < 0) goto L97;
        if (r18 != 0) goto L92;
    L95:
        String r19 = "landscape";
    L96:
        r0.put("vs_screen_type", r19);
        goto L97
    L92:
        if (r18 == 6) goto L95;
        r19 = "portrait";
    L97:
        int r20 = this.o;
        String r21 = BDLocationException.ERROR_TIMEOUT;
        if (r20 >= 0) goto L100;
    L104:
        int r22 = this.n;
        if (r22 <= 0) goto L108;
        r0.put("replay_type", String.valueOf(r22));
    L108:
        if (this.x == false) goto L110;
        Object r23 = "1";
    L111:
        r0.put("has_buy_ticket", r23);
        if (this.y == false) goto L114;
        Object r24 = "1";
    L115:
        r0.put("has_full_right", r24);
        if (this.F == false) goto L118;
        Object r25 = "1";
    L119:
        r0.put("is_from_highlight_moment", r25);
        if (this.E == false) goto L122;
        Object r26 = "1";
    L123:
        r0.put("is_click_highlight", r26);
        if (this.G == false) goto L126;
        Object r27 = "1";
    L127:
        r0.put("is_ecom", r27);
        if (this.H == false) goto L130;
        Object r28 = "1";
    L131:
        r0.put("is_live_streaming", r28);
        if (TextUtils.isEmpty(this.u) == true) goto L135;
        r0.put("is_paidlive", this.u);
    L135:
        if (this.v.length() <= 0) goto L137;
        boolean r29 = true;
    L138:
        if (r29 == false) goto L141;
        r0.put("is_paid_machine", this.v);
    L141:
        if (this.w.length() <= 0) goto L143;
        boolean r30 = true;
    L144:
        if (r30 == false) goto L147;
        r0.put("pay_num", this.w);
    L147:
        if (this.q.length() <= 0) goto L149;
        boolean r31 = true;
    L150:
        if (r31 == false) goto L153;
        r0.put("vs_machine_id", this.q);
    L153:
        if (this.r.length() <= 0) goto L155;
        boolean r32 = true;
    L156:
        if (r32 == false) goto L159;
        r0.put("vs_machine_type", this.r);
    L159:
        if (this.s.length() <= 0) goto L161;
        boolean r33 = true;
    L162:
        if (r33 == false) goto L165;
        r0.put("vs_machine_title", this.s);
    L165:
        if (this.z.length() <= 0) goto L167;
        boolean r34 = true;
    L168:
        if (r34 == false) goto L171;
        r0.put("watch_paidlive_status", this.z);
    L171:
        if (this.A.length() <= 0) goto L173;
        boolean r35 = true;
    L174:
        if (r35 == false) goto L177;
        r0.put("privilege_status", this.A);
    L177:
        if (this.p.length() <= 0) goto L179;
        boolean r36 = true;
    L180:
        if (r36 == false) goto L183;
        r0.put("video_id", this.p);
    L183:
        if (this.B == 0) goto L186;
        r0.put("ticket_id", "" + this.B);
    L186:
        if (this.C == 0) goto L189;
        r0.put("try_duration", "" + this.C);
    L189:
        if (this.D.length() <= 0) goto L191;
        r4 = true;
    L191:
        if (r4 == false) goto L193;
        r0.put("ticket_type", "" + this.D);
    L193:
        Long r37 = this.I;
        if (r37 == null) goto L197;
        r0.put("vs_content_id", String.valueOf(r37));
    L197:
        if (this.J == false) goto L199;
        Object r38 = "1";
    L200:
        r0.put("is_vip_replay", r38);
        if (this.f == 1) goto L204;
        r21 = "1";
    L204:
        r0.put("is_hor", r21);
        r0.put("is_vs", "1");
        return r0;
    L199:
        r38 = BDLocationException.ERROR_TIMEOUT;
        goto L200
    L179:
        r36 = false;
        goto L180
    L173:
        r35 = false;
        goto L174
    L167:
        r34 = false;
        goto L168
    L161:
        r33 = false;
        goto L162
    L155:
        r32 = false;
        goto L156
    L149:
        r31 = false;
        goto L150
    L143:
        r30 = false;
        goto L144
    L137:
        r29 = false;
        goto L138
    L130:
        r28 = BDLocationException.ERROR_TIMEOUT;
        goto L131
    L126:
        r27 = BDLocationException.ERROR_TIMEOUT;
        goto L127
    L122:
        r26 = BDLocationException.ERROR_TIMEOUT;
        goto L123
    L118:
        r25 = BDLocationException.ERROR_TIMEOUT;
        goto L119
    L114:
        r24 = BDLocationException.ERROR_TIMEOUT;
        goto L115
    L110:
        r23 = BDLocationException.ERROR_TIMEOUT;
        goto L111
    L100:
        if (r20 != 2) goto L102;
        Object r39 = "1";
    L103:
        r0.put("vs_is_portrait_content", r39);
        goto L104
    L102:
        r39 = BDLocationException.ERROR_TIMEOUT;
        goto L103
    L85:
        r17 = false;
        goto L86
    L79:
        r16 = false;
        goto L80
    L70:
        r14 = false;
        goto L71
    L64:
        r13 = false;
        goto L65
    L58:
        r12 = false;
        goto L59
    L52:
        r11 = false;
        goto L53
    L46:
        r10 = false;
        goto L47
    L40:
        r9 = false;
        goto L41
    L34:
        r8 = false;
        goto L35
    L28:
        r7 = false;
        goto L29
    L22:
        r6 = false;
        goto L23
    L16:
        r5 = false;
        goto L17
    }

    public a0() {
        this.a = "";
        this.b = "";
        this.c = "replay";
        this.d = "";
        this.e = "";
        this.f = 1;
        this.g = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.o = -1;
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.w = "";
        this.y = true;
        this.z = "try";
        this.A = "";
        this.D = "";
    }
}
