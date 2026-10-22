package dt;

import android.os.Bundle;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.base.gamedetail.ShowType;
import com.bytedance.android.gamecp.business.gamedetail.base.model.k;
import com.bytedance.android.gamecp.business.gamedetail.o;
import com.bytedance.android.gamecp.common.model.GameStageType;
import com.bytedance.android.gamecp.common.track.GamecpTracker;
import com.bytedance.android.gamecp.common.track.filter.GameInfoFilter;
import com.bytedance.android.gamecp.host_api.model.Room;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements com.bytedance.ies.sve_core.e {

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static Bundle f469936u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static b f469937v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final a f469938w0 = null;
    public String A;
    public boolean B;
    public String C;
    public k D;
    public String E;
    public final String F;
    public final String G;
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f469939J;
    public final String K;
    public final String L;
    public final long M;
    public final String N;
    public final String O;
    public final int P;
    public final String Q;
    public final String R;
    public final String S;
    public final String T;
    public final String U;
    public final String V;
    public final Map<String, Object> W;
    public final GameStageType X;
    public final String Y;
    public final String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f469940a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final int f469941a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f469942b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final String f469943b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f469944c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final String f469945c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f469946d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final String f469947d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f469948e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final String f469949e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f469950f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Integer f469951f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f469952g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final String f469953g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f469954h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final String f469955h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f469956i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final String f469957i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f469958j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final String f469959j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f469960k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final String f469961k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f469962l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final String f469963l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f469964m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final boolean f469965m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f469966n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final String f469967n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f469968o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final boolean f469969o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f469970p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final boolean f469971p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f469972q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final String f469973q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f469974r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final String f469975r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f469976s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final ShowType f469977s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f469978t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final String f469979t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f469980u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f469981v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f469982w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f469983x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f469984y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f469985z;

    public static final class a {
        public a() {
        }

        public static b a(Bundle r510, boolean r511) {
            if (b.f469937v0 == null) goto L10;
            if (Intrinsics.areEqual(r510, b.f469936u0) == false) goto L10;
            if (r511 == false) goto L10;
            b r100 = b.f469937v0;
            Intrinsics.checkNotNull(r100);
            return r100;
        L10:
            if (r510 == null) goto L15;
            String r101 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "game_id");
            if (r101 == null) goto L15;
            String r102 = r101;
        L16:
            if (r510 == null) goto L21;
            String r103 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "enter_from");
            if (r103 == null) goto L21;
            String r104 = r103;
        L23:
            if (r510 == null) goto L41;
            String r105 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE);
            if (r105 == null) goto L41;
            switch(r105.hashCode()) {
                case 48: goto L38;
                case 49: goto L36;
                case 50: goto L33;
                case 51: goto L30;
                default: goto L39;
            };
        L38:
            r105.equals("0");
        L39:
            int r106 = 0;
        L40:
            int r110 = r106;
        L42:
            if (r110 != 0) goto L48;
            Room r107 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
            if (r107 == null) goto L48;
            String r108 = r107.getOwnerUserId();
            if (r108 == null) goto L48;
        L50:
            if (r510 == null) goto L62;
            String r109 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID);
            if (r109 == null) goto L62;
            if (r109.length() <= 0) goto L56;
            boolean r111 = true;
        L57:
            if (r111 == true) goto L60;
            r109 = null;
        L60:
            if (r109 == null) goto L62;
            Unit r112 = Unit.INSTANCE;
            String r113 = r109;
        L63:
            if (r110 != 0) goto L69;
            Room r114 = com.bytedance.android.gamecp.host_api.a.b().getLiveService().getRoomData();
            if (r114 == null) goto L69;
            String r115 = String.valueOf(r114.getId());
            if (r115 == null) goto L69;
        L70:
            if (r510 == null) goto L73;
            String r116 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "room_id");
            if (r116 == null) goto L73;
        L74:
            if (r510 == null) goto L79;
            String r117 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "game_ad_type");
            if (r117 == null) goto L79;
            String r118 = r117;
        L80:
            if (r510 == null) goto L85;
            String r119 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "video_id");
            if (r119 == null) goto L85;
            String r120 = r119;
        L86:
            if (r510 == null) goto L91;
            String r121 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE);
            if (r121 == null) goto L91;
            String r122 = r121;
        L93:
            if (r510 == null) goto L98;
            String r123 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_DEFAULT_TAB_ID);
            if (r123 == null) goto L98;
            String r124 = r123;
        L99:
            if (r510 == null) goto L104;
            String r125 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "start_page");
            if (r125 == null) goto L104;
            String r126 = r125;
        L105:
            if (r510 == null) goto L108;
            String r127 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_DEFAULT_TAB_ID);
            if (r127 == null) goto L108;
        L109:
            String r128 = r127;
            if (r510 == null) goto L115;
            String r129 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_TAB_CONTROL_MSG);
            if (r129 == null) goto L115;
            String r210 = r129;
        L116:
            if (r510 == null) goto L118;
            Serializable r130 = r510.getSerializable("track_previous_route");
        L120:
            if ((r130 instanceof Map) == true) goto L122;
            r130 = null;
        L122:
            Map r131 = (Map) r130;
            if (r131 != null) goto L125;
            r131 = MapsKt.emptyMap();
        L125:
            Map r211 = r131;
            if (r510 == null) goto L131;
            String r132 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "report_params");
            if (r132 == null) goto L131;
            String r212 = r132;
        L132:
            if (r510 == null) goto L136;
            Integer r133 = com.bytedance.android.gamecp.business.gamedetail.f.a(r510, AudienceGamePromoteDetailActionHandler.PARA_GAME_STAGE, null);
            if (r133 == null) goto L136;
            int r134 = r133.intValue();
        L137:
            int r213 = r134;
            if (r510 == null) goto L143;
            String r135 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "game_ad_show_type");
            if (r135 == null) goto L143;
            String r214 = r135;
        L144:
            if (r510 == null) goto L149;
            String r136 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "attribution_id");
            if (r136 == null) goto L149;
            String r215 = r136;
        L151:
            if (r510 == null) goto L155;
            int r216 = com.bytedance.android.gamecp.business.gamedetail.f.f55299a;
            Integer r137 = com.bytedance.android.gamecp.business.gamedetail.f.a(r510, AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE, -1);
            if (r137 == null) goto L155;
            int r138 = r137.intValue();
        L156:
            if (r138 != (-1)) goto L173;
            HashMap<String, String> r139 = GamecpTracker.f56755a;
            com.bytedance.android.gamecp.common.track.filter.d r140 = GamecpTracker.h(zu.d.class);
            if ((r140 instanceof GameInfoFilter) == true) goto L160;
            r140 = null;
        L160:
            GameInfoFilter r141 = (GameInfoFilter) r140;
            if (r141 == null) goto L170;
            JSONObject r142 = r141.c(r102, null);
            if (r142 == null) goto L167;
            String r143 = r142.optString(AudienceGamePromoteDetailActionHandler.PARA_BIZ_MODE);
            if (r143 == null) goto L167;
            Integer r144 = StringsKt.toIntOrNull(r143);
        L168:
            if (r144 == null) goto L170;
            int r145 = r144.intValue();
        L171:
            r138 = r145;
        L167:
            r144 = null;
        L170:
            r145 = -1;
        L173:
            Map<String, String> r146 = o.f55311a;
            if (r510 == null) goto L177;
            String r147 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "third_log_param");
            if (r147 == null) goto L177;
        L179:
            if (r147.length() <= 0) goto L181;
            boolean r148 = true;
        L183:
            if (r148 == true) goto L366;
        L198:
            if (r510 == null) goto L201;
            Integer r149 = com.bytedance.android.gamecp.business.gamedetail.f.a(r510, "biz_type", null);
            if (r149 == null) goto L201;
        L208:
            if (r149 == null) goto L210;
            int r150 = r149.intValue();
        L212:
            if (r510 == null) goto L217;
            String r151 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID);
            if (r151 == null) goto L217;
            String r217 = "";
        L228:
            if (r151 != null) goto L230;
            String r152 = r217;
        L231:
            if (r510 == null) goto L236;
            String r153 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "is_fullscreen");
            if (r153 == null) goto L236;
            String r310 = r153;
        L237:
            if (r510 == null) goto L242;
            String r154 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_CAN_HALFSCREEN);
            if (r154 == null) goto L242;
            String r311 = r154;
        L243:
            if (r510 == null) goto L248;
            String r155 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_USE_BACK_ICON);
            if (r155 == null) goto L248;
            String r312 = r155;
        L249:
            if (r510 == null) goto L254;
            String r156 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_TWO_PART_RESERVE);
            if (r156 == null) goto L254;
            String r313 = r156;
        L255:
            if (r510 == null) goto L260;
            String r157 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_IS_RSVP);
            if (r157 == null) goto L260;
            String r314 = r157;
        L261:
            if (r510 == null) goto L264;
            String r158 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_RESERVE_ID);
            if (r158 == null) goto L264;
        L266:
            if (Intrinsics.areEqual(r158, "0") == false) goto L268;
            String r315 = r217;
        L269:
            if (r510 == null) goto L274;
            String r159 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PROMOTE_INSTANCE_ID);
            if (r159 == null) goto L274;
            String r316 = r159;
        L275:
            if (r510 == null) goto L280;
            String r160 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "report_params");
            if (r160 == null) goto L280;
            String r317 = r160;
        L281:
            if (r510 == null) goto L286;
            String r161 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "fmp_track_id");
            if (r161 == null) goto L286;
            String r318 = r161;
        L287:
            if (r510 == null) goto L292;
            String r162 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, "extra");
            if (r162 == null) goto L292;
            String r163 = r162;
        L293:
            if (r510 == null) goto L298;
            String r164 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PRELOAD_LYNX_CARD_IDS);
            if (r164 == null) goto L298;
            String r410 = r164;
        L299:
            if (r510 == null) goto L301;
            String r165 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_SUPPORT_TRANSFER);
        L302:
            boolean r411 = Intrinsics.areEqual(r165, "1");
            if (r510 == null) goto L305;
            int r166 = com.bytedance.android.gamecp.business.gamedetail.f.f55299a;
            Integer r167 = com.bytedance.android.gamecp.business.gamedetail.f.a(r510, AudienceGamePromoteDetailActionHandler.PARA_IS_LIVE_CELL_REPORT, 0);
        L306:
            if (r167 != null) goto L308;
            int r168 = 1;
        L311:
            boolean r412 = false;
        L312:
            if (r510 == null) goto L314;
            String r169 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.DISABLE_CACHE_DATA);
        L315:
            boolean r170 = Intrinsics.areEqual(r169, "1");
            if (r110 == r168) goto L318;
            r170 = true;
        L318:
            if (r510 == null) goto L323;
            Integer r171 = com.bytedance.android.gamecp.business.gamedetail.f.a(r510, "show_type", null);
            if (r171 == null) goto L323;
            int r172 = r171.intValue();
        L324:
            if (r510 == null) goto L326;
            String r413 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PARA_GAME_AIR_COMPRESS_EXTRA);
        L327:
            if (r510 == null) goto L329;
            String r414 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, PhotoEnterModel.SOURCE_BTM_TOKEN);
        L330:
            if (r510 == null) goto L335;
            String r173 = com.bytedance.android.gamecp.business.gamedetail.f.b(r510, AudienceGamePromoteDetailActionHandler.PREFIX_CACHE_KEY);
            if (r173 == null) goto L335;
            String r415 = r173;
        L336:
            long r218 = System.currentTimeMillis();
            GameStageType.a r416 = GameStageType.Companion;
            Integer r219 = Integer.valueOf(r213);
            r416.getClass();
            GameStageType r220 = GameStageType.a.a(r219);
            Integer r417 = Integer.valueOf(r138);
            boolean r418 = !r170;
            ShowType.Companion.getClass();
            ShowType[] r174 = ShowType.values();
            int r175 = r174.length;
            String r419 = r163;
            int r176 = 0;
        L337:
            if (r176 >= r175) goto L345;
            ShowType r420 = r174[r176];
            ShowType[] r512 = r174;
            if (r420.getType() != r172) goto L341;
            boolean r177 = true;
        L342:
            if (r177 == true) goto L343;
            r176 = r176 + 1;
            r174 = r512;
            goto L337
        L343:
            ShowType r178 = r420;
        L346:
            if (r178 != null) goto L348;
            ShowType r421 = ShowType.NORMAL;
        L349:
            b r179 = new b(r102, r104, r118, r113, r116, r212, r218, r122, r126, r110, r113, r120, r128, r210, r124, r211, r220, r214, r215, r150, r152, r310, r311, r312, r417, r313, r314, r315, r316, r317, r318, r412, r410, r411, r418, r415, r413, r421, r414);
            Integer r180 = Integer.valueOf(Intrinsics.areEqual(r179.f469980u, "1") ? 1 : 0);
            String r181 = r419;
            JSONObject r182 = new JSONObject(r181);     // Catch: Exception -> L361
            r182.putOpt("is_ad", r180);     // Catch: Exception -> L361
            String r183 = r182.toString();     // Catch: Exception -> L361
        L357:
            Intrinsics.checkNotNullParameter(r183, "<set-?>");
            r179.f469940a = r183;
            if (r511 == false) goto L360;
            b.f469937v0 = r179;
            b.f469936u0 = r510;
        L360:
            return r179;
        L356:
            r183 = r181;
        L355:
            r181 = r419;
            goto L356
        L348:
            r421 = r178;
            goto L349
        L341:
            r177 = false;
            goto L342
        L345:
            r178 = null;
        L335:
            r415 = r217;
            goto L336
        L329:
            r414 = null;
            goto L330
        L326:
            r413 = null;
        L323:
            r172 = ShowType.NORMAL.getType();
            goto L324
        L314:
            r169 = null;
            goto L315
        L308:
            r168 = 1;
            if (r167.intValue() != 1) goto L311;
            r412 = true;
            goto L312
        L305:
            r167 = null;
            goto L306
        L301:
            r165 = null;
        L298:
            r410 = r217;
        L292:
            r163 = SliceInitService.DEFAULT_SWITCH;
        L286:
            r318 = r217;
        L280:
            r317 = r11;
        L274:
            r316 = r217;
            goto L275
        L268:
            r315 = r158;
        L264:
            r158 = r217;
        L260:
            r314 = "0";
        L254:
            r313 = "0";
        L248:
            r312 = "0";
        L242:
            r311 = "0";
        L236:
            r310 = "0";
            goto L237
        L230:
            r152 = r151;
        L217:
            HashMap<String, String> r184 = GamecpTracker.f56755a;
            com.bytedance.android.gamecp.common.track.filter.d r185 = GamecpTracker.h(zu.d.class);
            r217 = "";
            if ((r185 instanceof GameInfoFilter) == true) goto L220;
            r185 = null;
        L220:
            GameInfoFilter r186 = (GameInfoFilter) r185;
            if (r186 == null) goto L227;
            JSONObject r187 = r186.c(r102, null);
            if (r187 == null) goto L226;
            r151 = r187.optString(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID);
            if (r151 != null) goto L228;
        L226:
            r151 = r217;
            goto L228
        L227:
            r151 = null;
            goto L228
        L210:
            r150 = 0;
        L201:
            HashMap<String, String> r188 = GamecpTracker.f56755a;
            com.bytedance.android.gamecp.common.track.filter.d r189 = GamecpTracker.h(zu.d.class);
            if ((r189 instanceof GameInfoFilter) == true) goto L204;
            r189 = null;
        L204:
            GameInfoFilter r190 = (GameInfoFilter) r189;
            if (r190 == null) goto L207;
            r149 = Integer.valueOf(r190.d(r102, null));
            goto L208
        L207:
            r149 = null;
            goto L208
        L366:
            JSONObject r191 = new JSONObject(r147);     // Catch: Exception -> L196
            JSONObject r192 = r191.optJSONObject("detail_page");     // Catch: Exception -> L196
            JSONObject r193 = r191.optJSONObject("download_btn");     // Catch: Exception -> L196
            if (r192 == null) goto L188;
            String r194 = r192.toString();     // Catch: Exception -> L196
            if (r194 == null) goto L188;
        L189:
            o.f55311a = o.b(r194);     // Catch: Exception -> L196
            if (r193 == null) goto L193;
            String r195 = r193.toString();     // Catch: Exception -> L196
            if (r195 == null) goto L193;
        L194:
            o.f55312b = o.b(r195);     // Catch: Exception -> L196
        L193:
            r195 = "";
        L188:
            r194 = "";
        L196:
            e = move-exception;
            yr.c.b("", String.valueOf(e.getMessage()));
            goto L198
        L181:
            r148 = false;
        L177:
            r147 = "";
        L155:
            r138 = -1;
        L149:
            r215 = "";
        L143:
            r214 = "";
        L136:
            r134 = com.bytedance.android.gamecp.business.gamedetail.page.root.b.f55466j;
        L131:
            r212 = "";
            goto L132
        L118:
            r130 = null;
        L115:
            r210 = SliceInitService.DEFAULT_SWITCH;
        L108:
            r127 = "tab_game_detail";
        L104:
            r126 = "";
        L98:
            r124 = "";
        L91:
            r122 = "";
        L85:
            r120 = "";
        L79:
            r118 = "";
        L73:
            r116 = r115;
        L69:
            r115 = "";
            goto L70
        L56:
            r111 = false;
        L62:
            r113 = r108;
        L48:
            r108 = "";
            goto L50
        L30:
            if (r105.equals("3") == false) goto L39;
            r106 = 3;
            goto L40
        L33:
            if (r105.equals("2") == false) goto L39;
            r106 = 2;
            goto L40
        L36:
            if (r105.equals("1") == false) goto L39;
            r106 = 1;
        L41:
            r110 = 0;
        L21:
            r104 = "";
        L15:
            r102 = "";
            goto L16
        }
    }

    public b() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L88;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f469939J, r101.f469939J) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.L, r101.L) == true) goto L20;
        return false;
    L20:
        if (this.M == r101.M) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.N, r101.N) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.O, r101.O) == true) goto L26;
        return false;
    L26:
        if (this.P == r101.P) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.Q, r101.Q) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.R, r101.R) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.S, r101.S) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.T, r101.T) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.U, r101.U) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.V, r101.V) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.W, r101.W) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.X, r101.X) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.Y, r101.Y) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.Z, r101.Z) == true) goto L48;
        return false;
    L48:
        if (this.f469941a0 == r101.f469941a0) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f469943b0, r101.f469943b0) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f469945c0, r101.f469945c0) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f469947d0, r101.f469947d0) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f469949e0, r101.f469949e0) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.f469951f0, r101.f469951f0) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f469953g0, r101.f469953g0) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.f469955h0, r101.f469955h0) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.f469957i0, r101.f469957i0) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f469959j0, r101.f469959j0) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.f469961k0, r101.f469961k0) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.f469963l0, r101.f469963l0) == true) goto L72;
        return false;
    L72:
        if (this.f469965m0 == r101.f469965m0) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.f469967n0, r101.f469967n0) == true) goto L76;
        return false;
    L76:
        if (this.f469969o0 == r101.f469969o0) goto L78;
        return false;
    L78:
        if (this.f469971p0 == r101.f469971p0) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.f469973q0, r101.f469973q0) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.f469975r0, r101.f469975r0) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f469977s0, r101.f469977s0) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.f469979t0, r101.f469979t0) == true) goto L133;
        return false;
    L133:
        return true;
    L88:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v68, types: [int] */
    /* JADX WARN: Type inference failed for: r2v112 */
    /* JADX WARN: Type inference failed for: r2v114 */
    /* JADX WARN: Type inference failed for: r2v144 */
    /* JADX WARN: Type inference failed for: r2v145 */
    /* JADX WARN: Type inference failed for: r2v92, types: [int] */
    /* JADX WARN: Type inference failed for: r2v97, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    public final int hashCode() {
        String r100 = this.F;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.G;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.H;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.I;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f469939J;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.K;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.L;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        long r122 = this.M;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        String r124 = this.N;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        String r127 = this.O;
        if (r127 == null) goto L37;
        int r128 = r127.hashCode();
    L38:
        int r129 = (((r126 + r128) * 31) + this.P) * 31;
        String r130 = this.Q;
        if (r130 == null) goto L41;
        int r131 = r130.hashCode();
    L42:
        int r132 = (r129 + r131) * 31;
        String r133 = this.R;
        if (r133 == null) goto L45;
        int r134 = r133.hashCode();
    L46:
        int r135 = (r132 + r134) * 31;
        String r136 = this.S;
        if (r136 == null) goto L49;
        int r137 = r136.hashCode();
    L50:
        int r138 = (r135 + r137) * 31;
        String r139 = this.T;
        if (r139 == null) goto L53;
        int r140 = r139.hashCode();
    L54:
        int r141 = (r138 + r140) * 31;
        String r142 = this.U;
        if (r142 == null) goto L57;
        int r143 = r142.hashCode();
    L58:
        int r144 = (r141 + r143) * 31;
        String r145 = this.V;
        if (r145 == null) goto L61;
        int r146 = r145.hashCode();
    L62:
        int r147 = (r144 + r146) * 31;
        Map<String, Object> r148 = this.W;
        if (r148 == null) goto L65;
        int r149 = r148.hashCode();
    L66:
        int r150 = (r147 + r149) * 31;
        GameStageType r151 = this.X;
        if (r151 == null) goto L69;
        int r152 = r151.hashCode();
    L70:
        int r153 = (r150 + r152) * 31;
        String r154 = this.Y;
        if (r154 == null) goto L73;
        int r155 = r154.hashCode();
    L74:
        int r156 = (r153 + r155) * 31;
        String r157 = this.Z;
        if (r157 == null) goto L77;
        int r158 = r157.hashCode();
    L78:
        int r159 = (((r156 + r158) * 31) + this.f469941a0) * 31;
        String r160 = this.f469943b0;
        if (r160 == null) goto L81;
        int r161 = r160.hashCode();
    L82:
        int r162 = (r159 + r161) * 31;
        String r163 = this.f469945c0;
        if (r163 == null) goto L85;
        int r164 = r163.hashCode();
    L86:
        int r165 = (r162 + r164) * 31;
        String r166 = this.f469947d0;
        if (r166 == null) goto L89;
        int r167 = r166.hashCode();
    L90:
        int r168 = (r165 + r167) * 31;
        String r169 = this.f469949e0;
        if (r169 == null) goto L93;
        int r170 = r169.hashCode();
    L94:
        int r171 = (r168 + r170) * 31;
        Integer r172 = this.f469951f0;
        if (r172 == null) goto L97;
        int r173 = r172.hashCode();
    L98:
        int r174 = (r171 + r173) * 31;
        String r175 = this.f469953g0;
        if (r175 == null) goto L101;
        int r176 = r175.hashCode();
    L102:
        int r177 = (r174 + r176) * 31;
        String r178 = this.f469955h0;
        if (r178 == null) goto L105;
        int r179 = r178.hashCode();
    L106:
        int r180 = (r177 + r179) * 31;
        String r181 = this.f469957i0;
        if (r181 == null) goto L109;
        int r182 = r181.hashCode();
    L110:
        int r183 = (r180 + r182) * 31;
        String r184 = this.f469959j0;
        if (r184 == null) goto L113;
        int r185 = r184.hashCode();
    L114:
        int r186 = (r183 + r185) * 31;
        String r187 = this.f469961k0;
        if (r187 == null) goto L117;
        int r188 = r187.hashCode();
    L118:
        int r189 = (r186 + r188) * 31;
        String r190 = this.f469963l0;
        if (r190 == null) goto L121;
        int r191 = r190.hashCode();
    L122:
        int r192 = (r189 + r191) * 31;
        boolean r193 = this.f469965m0;
        ?? r194 = 1;
        ?? r195 = r193;
        if (r193 == false) goto L125;
        r195 = 1;
    L125:
        int r196 = (r192 + r195) * 31;
        String r197 = this.f469967n0;
        if (r197 == null) goto L128;
        int r198 = r197.hashCode();
    L129:
        int r199 = (r196 + r198) * 31;
        boolean r200 = this.f469969o0;
        ?? r201 = r200;
        if (r200 == false) goto L132;
        r201 = 1;
    L132:
        int r202 = (r199 + r201) * 31;
        boolean r203 = this.f469971p0;
        if (r203 == true) goto L136;
        r194 = r203;
    L136:
        int r204 = (r202 + r194) * 31;
        String r205 = this.f469973q0;
        if (r205 == null) goto L139;
        int r206 = r205.hashCode();
    L140:
        int r207 = (r204 + r206) * 31;
        String r208 = this.f469975r0;
        if (r208 == null) goto L143;
        int r209 = r208.hashCode();
    L144:
        int r210 = (r207 + r209) * 31;
        ShowType r211 = this.f469977s0;
        if (r211 == null) goto L147;
        int r212 = r211.hashCode();
    L148:
        int r213 = (r210 + r212) * 31;
        String r214 = this.f469979t0;
        if (r214 == null) goto L152;
        r101 = r214.hashCode();
    L152:
        return r213 + r101;
    L147:
        r212 = 0;
        goto L148
    L143:
        r209 = 0;
        goto L144
    L139:
        r206 = 0;
        goto L140
    L128:
        r198 = 0;
        goto L129
    L121:
        r191 = 0;
        goto L122
    L117:
        r188 = 0;
        goto L118
    L113:
        r185 = 0;
        goto L114
    L109:
        r182 = 0;
        goto L110
    L105:
        r179 = 0;
        goto L106
    L101:
        r176 = 0;
        goto L102
    L97:
        r173 = 0;
        goto L98
    L93:
        r170 = 0;
        goto L94
    L89:
        r167 = 0;
        goto L90
    L85:
        r164 = 0;
        goto L86
    L81:
        r161 = 0;
        goto L82
    L77:
        r158 = 0;
        goto L78
    L73:
        r155 = 0;
        goto L74
    L69:
        r152 = 0;
        goto L70
    L65:
        r149 = 0;
        goto L66
    L61:
        r146 = 0;
        goto L62
    L57:
        r143 = 0;
        goto L58
    L53:
        r140 = 0;
        goto L54
    L49:
        r137 = 0;
        goto L50
    L45:
        r134 = 0;
        goto L46
    L41:
        r131 = 0;
        goto L42
    L37:
        r128 = 0;
        goto L38
    L33:
        r125 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GameDetailLaunchParams(gameId=" + this.F + ", enterFrom=" + this.G + ", gameAdType=" + this.H + ", anchorId=" + this.I + ", roomId=" + this.f469939J + ", categoryId=" + this.K + ", h5ReportParams=" + this.L + ", startTime=" + this.M + ", couponType=" + this.N + ", startPage=" + this.O + ", promoteScene=" + this.P + ", promoteId=" + this.Q + ", videoId=" + this.R + ", defaultTabId=" + this.S + ", tabControlMsg=" + this.T + ", lynxTabIndex=" + this.U + ", h5OpenParams=" + this.V + ", trackRoute=" + this.W + ", gameStage=" + this.X + ", gameAdShowType=" + this.Y + ", attributionId=" + this.Z + ", bizType=" + this.f469941a0 + ", bizId=" + this.f469943b0 + ", isFullscreen=" + this.f469945c0 + ", canHalfscreen=" + this.f469947d0 + ", useBackIcon=" + this.f469949e0 + ", bizMode=" + this.f469951f0 + ", isTwoPartReserve=" + this.f469953g0 + ", isRsvp=" + this.f469955h0 + ", reserveId=" + this.f469957i0 + ", promoteInstanceId=" + this.f469959j0 + ", reportParams=" + this.f469961k0 + ", fmpTrackId=" + this.f469963l0 + ", isPreview=" + this.f469965m0 + ", preloadLynxCardIds=" + this.f469967n0 + ", supportUserTransfer=" + this.f469969o0 + ", isEnableCacheData=" + this.f469971p0 + ", cacheDataPrefixCacheKey=" + this.f469973q0 + ", gameAirCompressExtra=" + this.f469975r0 + ", showType=" + this.f469977s0 + ", sourceBtmToken=" + this.f469979t0 + ")";
    }

    static {
        f469938w0 = new a();
    }

    public final boolean c() {
        return Intrinsics.areEqual(this.f469945c0, "1");
    }

    public final boolean d() {
        if (Intrinsics.areEqual(this.f469945c0, "1") == true) goto L5;
    L7:
        return false;
    L5:
        if ((!Intrinsics.areEqual(this.f469947d0, "1")) == false) goto L7;
        return true;
    }

    public final void e(String r100, String r101) {
        switch(r100.hashCode()) {
            case -1833239986: goto L75;
            case -1776744766: goto L72;
            case -1544229244: goto L69;
            case -1492741816: goto L66;
            case -1358292395: goto L63;
            case -1337282371: goto L60;
            case -1191777496: goto L57;
            case -1179774949: goto L54;
            case -1097344819: goto L51;
            case -685906904: goto L48;
            case -374437419: goto L45;
            case -284506937: goto L42;
            case -230488906: goto L39;
            case -41830683: goto L36;
            case 92655287: goto L33;
            case 109254796: goto L30;
            case 506361563: goto L27;
            case 666062531: goto L24;
            case 905980611: goto L21;
            case 939008127: goto L18;
            case 972855941: goto L15;
            case 1122864697: goto L12;
            case 1475600463: goto L9;
            case 1901043637: goto L6;
            default: goto L125;
        };
    L125:
        return;
    L6:
        if (r100.equals("location") == false) goto L78;
        this.f469956i = r101;
        return;
    L78:
        return;
    L9:
        if (r100.equals("author_id") == false) goto L80;
        this.f469968o = r101;
        return;
    L80:
        return;
    L12:
        if (r100.equals(PdpOpenThirdParam.KEY_AD_LOG_EXTRA) == false) goto L82;
        this.f469964m = r101;
        return;
    L82:
        return;
    L15:
        if (r100.equals("official_enter_from") == false) goto L84;
        this.f469952g = r101;
        return;
    L84:
        return;
    L18:
        if (r100.equals("is_other_channel") == false) goto L86;
        this.f469962l = r101;
        return;
    L86:
        return;
    L21:
        if (r100.equals("is_from_ad") == false) goto L88;
        this.f469978t = r101;
        return;
    L88:
        return;
    L24:
        if (r100.equals("stock_type") == false) goto L90;
        this.f469984y = r101;
        return;
    L90:
        return;
    L27:
        if (r100.equals("group_id") == false) goto L92;
        this.f469966n = r101;
        return;
    L92:
        return;
    L30:
        if (r100.equals("scene") == false) goto L94;
        this.f469960k = r101;
        return;
    L94:
        return;
    L33:
        if (r100.equals("ad_id") == false) goto L96;
        this.f469982w = r101;
        return;
    L96:
        return;
    L36:
        if (r100.equals("anchor_id") == false) goto L98;
        this.f469970p = r101;
        return;
    L98:
        return;
    L39:
        if (r100.equals("launch_from") == false) goto L100;
        this.f469954h = r101;
        return;
    L100:
        return;
    L42:
        if (r100.equals("game_promote_entrance_from") == false) goto L102;
        this.f469950f = r101;
        return;
    L102:
        return;
    L45:
        if (r100.equals("ad_plan_id") == false) goto L104;
        this.f469976s = r101;
        return;
    L104:
        return;
    L48:
        if (r100.equals("enter_method") == false) goto L106;
        this.f469948e = r101;
        return;
    L106:
        return;
    L51:
        if (r100.equals("log_pb") == false) goto L108;
        this.f469946d = r101;
        return;
    L108:
        return;
    L54:
        if (r100.equals("is_ads") == false) goto L110;
        this.f469980u = r101;
        return;
    L110:
        return;
    L57:
        if (r100.equals("if_dou") == false) goto L112;
        this.A = r101;
        return;
    L112:
        return;
    L60:
        if (r100.equals("enter_directly") == false) goto L114;
        this.f469958j = r101;
        return;
    L114:
        return;
    L63:
        if (r100.equals("ad_value") == false) goto L116;
        this.f469974r = r101;
        return;
    L116:
        return;
    L66:
        if (r100.equals("original_system_origin") == false) goto L118;
        this.f469985z = r101;
        return;
    L118:
        return;
    L69:
        if (r100.equals("anchor_type") == false) goto L120;
        this.f469972q = r101;
        return;
    L120:
        return;
    L72:
        if (r100.equals("ad_source_type") == false) goto L122;
        this.f469983x = r101;
        return;
    L122:
        return;
    L75:
        if (r100.equals("promote_scene_sub") == false) goto L124;
        this.f469981v = r101;
        return;
    }

    public b(String r110, String r111, String r112, String r210, String r211, String r212, long r213, String r214, String r215, int r216, String r217, String r218, String r310, String r311, String r312, Map r313, GameStageType r314, String r315, String r316, int r317, String r318, String r319, String r410, String r411, Integer r412, String r413, String r414, String r415, String r416, String r417, String r418, boolean r419, String r510, boolean r511, boolean r512, String r513, String r514, ShowType r515, String r516) {
        Intrinsics.checkNotNullParameter(r217, "promoteId");
        Intrinsics.checkNotNullParameter(r310, "defaultTabId");
        Intrinsics.checkNotNullParameter(r312, "lynxTabIndex");
        Intrinsics.checkNotNullParameter(r314, "gameStage");
        Intrinsics.checkNotNullParameter(r316, "attributionId");
        Intrinsics.checkNotNullParameter(r318, "bizId");
        Intrinsics.checkNotNullParameter(r319, "isFullscreen");
        Intrinsics.checkNotNullParameter(r410, "canHalfscreen");
        Intrinsics.checkNotNullParameter(r411, "useBackIcon");
        Intrinsics.checkNotNullParameter(r413, "isTwoPartReserve");
        Intrinsics.checkNotNullParameter(r414, "isRsvp");
        Intrinsics.checkNotNullParameter(r415, "reserveId");
        Intrinsics.checkNotNullParameter(r515, "showType");
        this.F = r110;
        this.G = r111;
        this.H = r112;
        this.I = r210;
        this.f469939J = r211;
        this.K = null;
        this.L = r212;
        this.M = r213;
        this.N = r214;
        this.O = r215;
        this.P = r216;
        this.Q = r217;
        this.R = r218;
        this.S = r310;
        this.T = r311;
        this.U = r312;
        this.V = SliceInitService.DEFAULT_SWITCH;
        this.W = r313;
        this.X = r314;
        this.Y = r315;
        this.Z = r316;
        this.f469941a0 = r317;
        this.f469943b0 = r318;
        this.f469945c0 = r319;
        this.f469947d0 = r410;
        this.f469949e0 = r411;
        this.f469951f0 = r412;
        this.f469953g0 = r413;
        this.f469955h0 = r414;
        this.f469957i0 = r415;
        this.f469959j0 = r416;
        this.f469961k0 = r417;
        this.f469963l0 = r418;
        this.f469965m0 = r419;
        this.f469967n0 = r510;
        this.f469969o0 = r511;
        this.f469971p0 = r512;
        this.f469973q0 = r513;
        this.f469975r0 = r514;
        this.f469977s0 = r515;
        this.f469979t0 = r516;
        this.f469940a = SliceInitService.DEFAULT_SWITCH;
        this.f469942b = "";
        this.f469944c = "";
        this.f469946d = "";
        this.f469948e = AdDownloadEventConfig.JsonKey.CLICK_LABEL;
        this.f469950f = "video_anchor";
        this.f469952g = "";
        this.f469954h = "";
        this.f469956i = "";
        this.f469958j = "";
        this.f469960k = "";
        this.f469962l = "";
        this.f469964m = "";
        this.f469966n = "";
        this.f469968o = "";
        this.f469970p = "";
        this.f469972q = "";
        this.f469974r = "";
        this.f469976s = "";
        this.f469978t = "";
        this.f469980u = "";
        this.f469981v = "";
        this.f469982w = "";
        this.f469983x = "0";
        this.f469984y = "0";
        this.f469985z = "0";
        this.A = "0";
        this.C = "";
        this.E = "";
        if (r212.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        String r101 = r212;
    L9:
        if (r101 == null) goto L45;
        JsonElement r102 = GsonHelper.a.f57436d.parse(r101);     // Catch: Throwable -> L31
        if (r102 == null) goto L46;
        JsonObject r103 = r102.getAsJsonObject();     // Catch: Throwable -> L31
        if (r103 != null) goto L15;
        return;
    L15:
        if ((true ^ r103.isJsonNull()) == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L48;
        Iterator<String> r104 = r103.keySet().iterator();     // Catch: Throwable -> L31
    L21:
        if (r104.hasNext() == false) goto L29;
        String r105 = r104.next();     // Catch: Throwable -> L31
        JsonElement r106 = r103.get(r105);     // Catch: Throwable -> L31
        if (r106 == null) goto L21;
        if (r106.isJsonPrimitive() == true) goto L27;
        e(r105, r106.toString());     // Catch: Throwable -> L31
        goto L21
    L27:
        e(r105, r106.getAsString());     // Catch: Throwable -> L31
        goto L21
    L29:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L31
        return;
    L48:
        return;
    L46:
        return;
    L31:
        th = move-exception;
        yr.b.d("Error parsing json", null, th);
        Unit r108 = Unit.INSTANCE;
        return;
    L45:
        return;
    L8:
        r101 = null;
        goto L9
    L5:
        r100 = false;
        goto L6
    }
}
