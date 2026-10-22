package com.bytedance.android.livesdk.ktvimpl.base.logger;

import am2.x;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.model.api.s;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.multilink.internal.api.core.service.IMultiLinkInternalService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.datacontext.KtvRoomContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvChallengeDataContext;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.filter.v;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.PersonalSongInfo;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.android.livesdk.sharedpref.c;
import com.bytedance.android.livesdk.utils.s2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.n;
import hg6.g;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import xe2.h;
import yr0.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvLoggerHelper implements pb0.a {
    public static Long a;
    public static final Map<String, Boolean> b = null;
    public static final String c = null;
    public static final KtvLoggerHelper d = null;

    public static final class a implements v {
        public static final Set<String> a = null;
        public static final a b = null;

        public a() {
        }

        @Override // com.bytedance.android.livesdk.log.filter.v
        public final void Rd() {
        }

        @Override // com.bytedance.android.livesdk.log.filter.v
        public final void onRemove() {
        }

        static {
            b = new a();
            a = SetsKt.setOf(new String[]{"livesdk_live_music_icon_show", "livesdk_live_music_icon_click", "livesdk_anchor_playmode_open_success", "livesdk_anchor_playmode_over", "livesdk_anchor_ksong_show", "livesdk_anchor_ksong_request_song_show", "livesdk_anchor_ksong_request_button_click", "livesdk_ksong_request_song_success", "livesdk_anchor_ksong_play", "livesdk_anchor_ksong_play_duration", "livesdk_anchor_ksong_button_click", "livesdk_anchor_ksong_allow_button_click", "livesdk_anchor_ksong_allow_button_click_result", "livesdk_anchor_ksong_apply_msg_show", "livesdk_anchor_ksong_accept_button_click", "livesdk_anchor_ksong_popup_show", "livesdk_anchor_ksong_popup_click", "livesdk_anchor_audience_connection_pass", "livesdk_anchor_audience_connection_open_success", "livesdk_anchor_audience_connection_over", "livesdk_audience_playmode_room_watch", "livesdk_audience_playmode_room_watch_duration", "livesdk_audience_ksong_want_listen_button_click", "livesdk_guest_connection_pre_apply", "livesdk_guest_connection_apply", "livesdk_guest_apply_withdraw", "livesdk_guest_connection_success", "livesdk_guest_connection_over", "livesdk_anchor_ksong_collect_icon_click", "livesdk_anchor_ksong_request_search", "livesdk_anchor_ksong_request_search_click", "livesdk_anchor_ksong_request_search_success", "livesdk_audience_ksong_icon_click", "livesdk_audience_ksong_icon_show"});
        }

        @Override // com.bytedance.android.livesdk.log.filter.v
        public final void L9(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "params");
            if (r2.length() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L8;
            return;
        L8:
            if (a.contains(r2) == false) goto L19;
            Long r4 = KtvLoggerHelper.a;
            String r5 = KtvLoggerHelper.c;
            IMultiLinkServiceExternal r1 = k.f(IMultiLinkServiceExternal.class);
            if (r1 == null) goto L15;
            d r6 = r1.getMultiDataHolderExternal();
            if (r6 == null) goto L15;
            String r7 = r6.x();
            if (r7 == null) goto L15;
        L16:
            r3.put(r5, r7);
            return;
        L15:
            r7 = "";
            goto L16
        L19:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class b implements v {
        public static final b a = null;

        public b() {
        }

        @Override // com.bytedance.android.livesdk.log.filter.v
        public final void Rd() {
        }

        @Override // com.bytedance.android.livesdk.log.filter.v
        public final void onRemove() {
        }

        static {
            a = new b();
        }

        @Override // com.bytedance.android.livesdk.log.filter.v
        public final void L9(String r2, Map<String, String> r3) {
            Intrinsics.checkNotNullParameter(r2, "eventName");
            Intrinsics.checkNotNullParameter(r3, "params");
            r3.put("ktv_stage_mode", "video");
        }
    }

    public KtvLoggerHelper() {
    }

    static {
        d = new KtvLoggerHelper();
        b = new LinkedHashMap();
        c = "room_link_status";
    }

    public static String F() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.e() != 8) goto L7;
        return "voice_live";
    L7:
        return j.d();
    }

    public static int x() {
        return k.n(IInteractService.class).getCurrentScene();
    }

    public final void a() {
        HashMap r0 = new HashMap();
        r0.put("live_type", j.d());
        r0.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        j0.l().sendLog("livesdk_ksong_oppo_echo_setting_guide_click", r0, new Object[]{IRoom.class, x.class});
    }

    public static String E() {
        u r0 = m.d();
        if (r0 == null) goto L13;
        com.bytedance.live.datacontext.j r1 = r0.J();
        if (r1 == null) goto L13;
        LivePlayModeLogContext r2 = (LivePlayModeLogContext) r1.getValue();
        if (r2 == null) goto L13;
        if (((Set) r2.getPlayModes().getValue()).size() <= 0) goto L13;
        Sequence r3 = SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) r2.getPlayModes().getValue()), KtvLoggerHelper$getCurrentPlayModes$1$filterPlayModes$1.INSTANCE), KtvLoggerHelper$getCurrentPlayModes$1$filterPlayModes$2.INSTANCE);
        if (SequencesKt.none(r3) == true) goto L13;
        return SequencesKt.joinToString$default(r3, ",", "[", "]", 0, null, null, 56, null);
    L13:
        return "[normal]";
    }

    public static int G() {
        if (jc0.a.a() == false) goto L10;
        Integer r0 = (Integer) c.g.getValue();
        if (r0 != null) goto L8;
    L16:
        return 0;
    L8:
        if (r0.intValue() != 1) goto L16;
        return 1;
    L10:
        Integer r1 = (Integer) c.f.getValue();
        if (r1 == null) goto L16;
        if (r1.intValue() != 1) goto L16;
        return 1;
    }

    public static String I() {
        if (j.i() == false) goto L5;
        return "anchor";
    L5:
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L9;
    L11:
        return "user";
    L9:
        if (r0.intValue() != 2) goto L11;
        return "guest";
    }

    public static void c0() {
        if (j.i() == false) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        r0.put("function_type", "ktv");
        r0.put("function_type2", "ktv");
        r0.put("layout_type", "normal");
        a = Long.valueOf(System.currentTimeMillis());
        j0.l().sendLog("livesdk_audience_ktv_room_watch", r0, new Object[]{IRoom.class, new x()});
    }

    public static void f0() {
        if (j.i() == false) goto L11;
        HashMap r0 = new HashMap();
        KtvContext.Companion.getClass();
        if (Intrinsics.areEqual(KtvContext.a.g().isEnterKtvDirectly(), Boolean.TRUE) == false) goto L8;
        String r1 = "live_take_page";
    L9:
        r0.put("source", r1);
        a = Long.valueOf(System.currentTimeMillis());
        j0.l().sendLog("livesdk_anchor_ktv_mode_open_success", r0, new Object[]{IRoom.class, new x()});
        return;
    L8:
        r1 = "ktv_tab";
        goto L9
    }

    public static Integer y() {
        o r0 = m.i();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L10;
        r2.isLiveTypeAudio();
    L10:
        if (r0 == null) goto L27;
        com.bytedance.live.datacontext.m r3 = r0.getRoom();
        if (r3 == null) goto L27;
        IRoom r4 = (IRoom) r3.getValue();
        if (r4 == null) goto L27;
        if (r4.isLiveTypeAudio() != true) goto L27;
        u r5 = m.d();
        if (r5 == null) goto L36;
        com.bytedance.live.datacontext.j r6 = r5.s();
        if (r6 == null) goto L37;
        f r7 = (f) r6.getValue();
        if (r7 == null) goto L38;
        i r8 = r7.t();
        if (r8 != null) goto L26;
        return null;
    L26:
        return Integer.valueOf(r8.b);
    L38:
        return null;
    L37:
        return null;
    L36:
        return null;
    L27:
        if (r0 == null) goto L40;
        com.bytedance.live.datacontext.j r9 = r0.getVideoTalkRoomSubScene();
        if (r9 == null) goto L41;
        e r10 = (e) r9.getValue();
        if (r10 == null) goto L42;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r11 = r10.t();
        if (r11 != null) goto L35;
        return null;
    L35:
        return Integer.valueOf(r11.c);
    L42:
        return null;
    L41:
        return null;
    L40:
        return null;
    }

    public static void A(Map r2) {
        r2.put("function_type", H(j.c()));
        r2.put("function_type2", H(j.c()));
    }

    public static String C(Integer r2) {
        int r0 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
        if (r2 != null) goto L6;
    L8:
        int r1 = KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue();
        if (r2 != null) goto L12;
    L14:
        int r3 = KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue();
        if (r2 != null) goto L18;
    L20:
        return "";
    L18:
        if (r2.intValue() != r3) goto L20;
        return "like";
    L12:
        if (r2.intValue() != r1) goto L14;
        return "midi_score";
    L6:
        if (r2.intValue() != r0) goto L8;
        return "gift";
    }

    public static String H(String r6) {
        Intrinsics.checkNotNullParameter(r6, "functionType");
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L14;
        Integer r7 = y();
        if (r7 != null) goto L8;
        return "ktv";
    L8:
        if (r7.intValue() != 61) goto L11;
        return "chorus";
    L11:
        return "ktv";
    L14:
        if (x() != 0) goto L17;
        r6 = "live";
    L17:
        if (k.n(IInteractService.class).dynamicFromAudience() == false) goto L19;
        return "new_audience";
    L19:
        boolean r1 = true;
        boolean r2 = false;
        if (x() != 4) goto L22;
        boolean r0 = true;
    L23:
        if (r0 == false) goto L26;
        return "audience";
    L26:
        if (x() != 5) goto L28;
        boolean r3 = true;
    L30:
        if (r3 == true) goto L40;
        int r4 = x();
        if (r4 == 8) goto L37;
        if (r4 == 12) goto L37;
        if (r4 == 4) goto L37;
        boolean r5 = false;
    L38:
        if (r5 == true) goto L40;
        return r6;
    L37:
        r5 = true;
    L40:
        if (x() == 12) goto L43;
        r1 = false;
    L43:
        if (r1 == true) goto L54;
        o r8 = m.i();
        if (r8 == null) goto L51;
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L51;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L51;
        r2 = d0.h(r10);
    L51:
        if (r2 == true) goto L54;
        return "radio";
    L54:
        return "party";
    L28:
        r3 = false;
        goto L30
    L22:
        r0 = false;
        goto L23
    }

    public static void W(String r4) {
        Intrinsics.checkNotNullParameter(r4, "resourceType");
        Intrinsics.checkNotNullParameter("open", "actionType");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("resource_type", r4);
        r0.put("action_type", "open");
        r0.put("user_type", I());
        A(r0);
        j0.l().sendLog("livesdk_audience_ksong_resource_more_icon_click", r0, new Object[]{IRoom.class});
    }

    public static void b0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "show_page");
        HashMap r1 = new HashMap();
        A(r1);
        r1.put("live_type", F());
        r1.put("show_page", r4);
        j0.l().sendLog("livesdk_ktv_sing_challenge_open_entrance_show", r1, new Object[]{IRoom.class, x.class});
    }

    public static void d0(String r8) {
        Intrinsics.checkNotNullParameter(r8, "over_path");
        if (j.i() == true) goto L15;
        Long r0 = a;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.longValue() == 0) goto L17;
        HashMap r1 = new HashMap();
        r1.put("over_type", r8);
        long r4 = System.currentTimeMillis();
        Long r9 = a;
        if (r9 == null) goto L12;
        long r6 = r9.longValue();
    L13:
        r1.put("duration", String.valueOf((int) ((r4 - r6) / 1000.0f)));
        r1.put("function_type", "ktv");
        r1.put("function_type2", "ktv");
        r1.put("layout_type", "normal");
        a = 0L;
        j0.l().sendLog("livesdk_audience_ktv_room_watch_duration", r1, new Object[]{IRoom.class, new x()});
        return;
    L12:
        r6 = System.currentTimeMillis();
        goto L13
    L17:
        return;
    }

    public static void e0(String r6) {
        Intrinsics.checkNotNullParameter(r6, "over_path");
        if (j.i() == true) goto L5;
        return;
    L5:
        HashMap r1 = new HashMap();
        r1.put("over_path", r6);
        long r2 = System.currentTimeMillis();
        Long r7 = a;
        if (r7 == null) goto L8;
        long r4 = r7.longValue();
    L9:
        r1.put("duration", String.valueOf((int) ((r2 - r4) / 1000.0f)));
        r1.put("function_type", "ktv");
        r1.put("function_type2", "ktv");
        a = 0L;
        j0.l().sendLog("livesdk_anchor_ktv_mode_over", r1, new Object[]{IRoom.class, new x()});
        return;
    L8:
        r4 = System.currentTimeMillis();
        goto L9
    }

    public static String j0(Integer r2) {
        List r0 = null;
        if (r2 == null) goto L30;
        r2.intValue();
        Lazy r1 = KtvUtilsKt.a;
        u r3 = m.d();
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.j r4 = r3.getVideoTalkRoomSubScene();
        if (r4 == null) goto L14;
        e r5 = (e) r4.getValue();
        if (r5 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r6 = r5.t();
        if (r6 == null) goto L14;
        r0 = r6.b;
    L14:
        if (d0.e(r0) == false) goto L17;
    L21:
        return "seat_fit";
    L17:
        if (r2.intValue() == 2) goto L21;
        if (r2.intValue() == 7) goto L21;
        if (r2.intValue() != 3) goto L26;
    L27:
        return "seat_enlarge";
    L26:
        if (r2.intValue() == 6) goto L27;
        return "normal";
    L30:
        return null;
    }

    public static void k0(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "logMap");
        String r0 = j0(y());
        if (r0 == null) goto L6;
        r2.put("layout_type", r0);
        return;
    }

    public static void l0(Map r3) {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L14;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L15;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L16;
        Long r4 = r2.getSingApplyUnreadNum();
        if (r4 == null) goto L11;
        long r5 = r4.longValue();
    L12:
        r3.put("applicant_cnt", String.valueOf(r5));
        return;
    L11:
        r5 = 0;
        goto L12
    L16:
        return;
    L15:
        return;
    }

    public static void m0(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "logMap");
        com.bytedance.android.livesdk.log.filter.o r2 = j0.l().c(x.class);     // Catch: Exception -> L17
        if ((r2 instanceof t) == true) goto L6;
        r2 = null;
    L6:
        t r3 = (t) r2;     // Catch: Exception -> L17
        if (r3 == null) goto L22;
        String r5 = r3.i();     // Catch: Exception -> L17
        if (r5 == null) goto L23;
        JSONObject r6 = s2.a(r5);     // Catch: Exception -> L17
        String r7 = r6.optString("video_id");     // Catch: Exception -> L17
        if (r7 == null) goto L13;
        r4.put("video_id", r7);     // Catch: Exception -> L17
    L13:
        String r1 = r6.optString("video_live_label");     // Catch: Exception -> L17
        if (r1 == null) goto L24;
        r4.put("video_live_label", r1);     // Catch: Exception -> L17
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L17:
        e = move-exception;
        ALogger.e("KtvLoggerHelper", "can't parse json for relevant log", e);
    }

    public static void o0(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        u r0 = m.d();
        if (r0 == null) goto L11;
        com.bytedance.live.datacontext.j r1 = r0.getVideoTalkRoomSubScene();
        if (r1 == null) goto L11;
        e r2 = (e) r1.getValue();
        if (r2 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r4 = r2.t();
        if (r4 == null) goto L11;
        List r5 = r4.b;
    L13:
        if (r5 != null) goto L15;
        r3.put("seat_fit_status", "off");
        return;
    L15:
        if (d0.e(r5) == false) goto L17;
        r3.put("seat_fit_status", "on");
        return;
    L17:
        r3.put("seat_fit_status", "off");
        return;
    L11:
        r5 = null;
        goto L13
    }

    public static String p0(int r1) {
        if (r1 != 13) goto L5;
        String r2 = "enlarge";
    L33:
        return r2.concat("");
    L5:
        if (r1 != 19) goto L7;
        r2 = "request_song";
        goto L33
    L7:
        if (r1 != 21) goto L9;
        r2 = "music";
        goto L33
    L9:
        if (r1 != 23) goto L11;
        r2 = "pk_chorus";
        goto L33
    L11:
        if (r1 != Integer.MAX_VALUE) goto L13;
        r2 = "order_by_user";
        goto L33
    L13:
        if (r1 != 16) goto L15;
        r2 = "room_grouppk";
        goto L33
    L15:
        if (r1 == 17) goto L25;
        switch(r1) {
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L22;
            case 8: goto L21;
            case 9: goto L20;
            case 10: goto L19;
            case 11: goto L18;
            default: goto L17;
        };
    L17:
        r2 = "normal";
        goto L33
    L18:
        r2 = "rechargeable_normal";
        goto L33
    L19:
        r2 = "ktv";
        goto L33
    L20:
        r2 = "bgm";
        goto L33
    L21:
        r2 = "ksong";
        goto L33
    L22:
        r2 = "grouppk";
        goto L33
    L23:
        r2 = "sing_challenge";
        goto L33
    L24:
        r2 = "boom";
        goto L33
    L25:
        r2 = "self_discipline";
        goto L33
    }

    public final void u(String r5) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        HashMap r0 = new HashMap();
        r0.put("user_type", I());
        r0.put("function_type", k.n(IInteractService.class).getFunctionType2());
        r0.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        r0.put("request_page", r5);
        r0.put("live_type", F());
        h.b(r0);
        j0.l().sendLog("song_feedback_show", r0, new Object[]{IRoom.class, x.class});
    }

    public final void w(boolean r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("user_type", I());
        r0.put("live_type", F());
        A(r0);
        if (r5 == false) goto L5;
        String r6 = "1";
    L6:
        r0.put("is_ksong", r6);
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L16;
        com.bytedance.android.live.liveinteract.plantform.base.i r7 = k.n(IInteractService.class).getLinkUserInfoCenter();
        if (r7 == null) goto L11;
        int r8 = r7.b();
    L12:
        if (r8 <= 0) goto L14;
        String r9 = "end_ahead";
    L15:
        r0.put("request_page", r9);
        goto L16
    L14:
        r9 = "normal";
        goto L15
    L11:
        r8 = 0;
    L16:
        j0.l().sendLog("livesdk_live_chat_feedback_show", r0, new Object[]{x.class, IRoom.class});
        return;
    L5:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static void B(MusicPanel r3, HashMap r4) {
        KtvMusic r0 = r3.a;
        if (r0 == null) goto L5;
        r4.put("song_id", String.valueOf(r0.getMId()));
        r4.put("song_name", r0.getTitle());
    L5:
        r4.put("from_request_type", r3.d);
    }

    @JvmStatic
    public static final String D(Integer r4, Integer r5) {
        if (r4 == null) goto L53;
        r4.intValue();
        if (r4.intValue() != 5) goto L21;
        if (r5 != null) goto L7;
    L11:
        o r6 = m.i();
        if (r6 == null) goto L56;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L57;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 != null) goto L18;
        return "radio";
    L18:
        if (d0.h(r8) == true) goto L67;
        return "radio";
    L67:
        return "party";
    L57:
        return "radio";
    L56:
        return "radio";
    L7:
        if (r5.intValue() == 0) goto L11;
        if (r5.intValue() == 22) goto L67;
        return "radio";
    L21:
        if (r4.intValue() != 9) goto L29;
        if (r5 != null) goto L25;
    L27:
        return "ktv";
    L25:
        if (r5.intValue() != 61) goto L27;
        return "chorus";
    L29:
        if (r4.intValue() != 8) goto L38;
        if (r5 != null) goto L32;
        return "radio";
    L32:
        if (r5.intValue() == 7) goto L34;
        return "radio";
    L34:
        if (k.n(IInteractService.class).dynamicFromAudience() == false) goto L64;
        return "new_audience";
    L64:
        return "radio";
    L38:
        if (r4.intValue() != 10) goto L41;
        return "watch";
    L41:
        if (r4.intValue() != 4) goto L44;
        return "audience";
    L44:
        if (r4.intValue() == 12) goto L67;
        if (r4.intValue() == 16) goto L67;
        if (r4.intValue() != 0) goto L68;
        return "live";
    L68:
        return "radio";
    L53:
        return null;
    }

    public static void M(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "clickType");
        Intrinsics.checkNotNullParameter(r4, "songId");
        Intrinsics.checkNotNullParameter("music_effect", "enterFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("click_type", r3);
        r0.put("song_id", r4);
        r0.put("enter_from", "music_effect");
        A(r0);
        j0.l().sendLog("livesdk_interact_music_select_trail_click", r0, new Object[]{IRoom.class});
    }

    public static void R(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "liveType");
        Intrinsics.checkNotNullParameter(r4, "roomType");
        HashMap r0 = new HashMap(2);
        r0.put("live_type", r3);
        r0.put("room_type", r4);
        A(r0);
        j0.l().sendLog("anchor_ksong_exit_click", r0, new Object[]{IRoom.class});
    }

    public static void X(String r5, Map r6) {
        Intrinsics.checkNotNullParameter(r5, "key");
        LinkedHashMap r0 = new LinkedHashMap();
        o r1 = m.i();
        if (r1 == null) goto L7;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L7;
        IRoom r3 = (IRoom) r2.getValue();
    L8:
        r0.put("live_type", "voice_live");
        String r4 = "";
        if (r3 == null) goto L12;
        String r7 = r3.getOwnerUserIdString();
        if (r7 == null) goto L12;
    L13:
        r0.put("anchor_id", r7);
        if (r3 == null) goto L19;
        String r8 = String.valueOf(r3.getRoomId());
        if (r8 == null) goto L19;
        r4 = r8;
    L19:
        r0.put("room_id", r4);
        r0.put("function_type", "ktv");
        if (r6 == null) goto L22;
        r0.putAll(r6);
    L22:
        j0.l().sendLog(r5, r0, new Object[]{x.class, IRoom.class});
        return;
    L12:
        r7 = "";
    L7:
        r3 = null;
        goto L8
    }

    public static void n0(HashMap r7, MusicPanel r8) {
        boolean r2 = false;
        if (x() == 9) goto L5;
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L24;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L24;
        KtvComponentUIContext r3 = (KtvComponentUIContext) r1.getValue();
        if (r3 == null) goto L24;
        MutableLiveData<Boolean> r4 = r3.getScoreOpen();
        if (r4 == null) goto L24;
        Boolean r5 = (Boolean) r4.getValue();
    L26:
        if (Intrinsics.areEqual(r5, Boolean.TRUE) == false) goto L28;
    L31:
        boolean r6 = true;
    L33:
        if (r6 == false) goto L35;
        Object r9 = "1";
    L36:
        r7.put("score_status", r9);
        if (r6 == false) goto L39;
        Object r10 = "1";
    L40:
        r7.put("is_score", r10);
        if (r8 == null) goto L51;
        KtvMusic r11 = r8.a;
        if (r11 == null) goto L51;
        String r12 = r11.getMidiUrl();
        if (r12 == null) goto L51;
        if (r12.length() <= 0) goto L49;
        r2 = true;
    L49:
        if (r2 != true) goto L51;
        r7.put("is_midi", "1");
        return;
    L51:
        r7.put("is_midi", BDLocationException.ERROR_TIMEOUT);
        return;
    L39:
        r10 = BDLocationException.ERROR_TIMEOUT;
        goto L40
    L35:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L36
    L28:
        if (((Boolean) c.H.getValue()).booleanValue() == true) goto L31;
    L30:
        r6 = false;
    L24:
        r5 = null;
        goto L26
    L5:
        if (KtvRoomContext.Companion == null) goto L13;
        KtvRoomContext r13 = KtvRoomContext.a.a();
        if (r13 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r14 = r13.isMidiOpened();
        if (r14 == null) goto L13;
        if (((Boolean) r14.getValue()).booleanValue() == true) goto L31;
    L13:
        if (((Boolean) c.M.getValue()).booleanValue() == false) goto L30;
        goto L30
    }

    public static void z(DataCenter r4, HashMap r5) {
        String r6 = j.a(r4);
        String r0 = j.g();
        A(r5);
        boolean r2 = false;
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L9;
        r5.put("user_type", r0);
    L9:
        if (r6.length() <= 0) goto L11;
        r2 = true;
    L11:
        if (r2 == false) goto L13;
        r5.put("room_type", r6);
    L13:
        r5.put("live_type", F());
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final void c(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("user_id", r4);
        r0.put("enter_from", r5);
        A(r0);
        j0.l().sendLog("livesdk_solo_ktv_click", r0, new Object[]{IRoom.class});
    }

    public final void g(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
        Intrinsics.checkNotNullParameter(r3, "throwable");
        ALogger.e(r2, r3);
    }

    public final void k(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "userId");
        Intrinsics.checkNotNullParameter(r5, "enterFrom");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("user_id", r4);
        r0.put("enter_from", r5);
        A(r0);
        j0.l().sendLog("livesdk_solo_ktv_show", r0, new Object[]{IRoom.class});
    }

    public final void m(int r4, s r5) {
        Intrinsics.checkNotNullParameter(r5, "guessWord");
        HashMap r0 = new HashMap();
        r0.put("word_source", "sug");
        r0.put("word_position", String.valueOf(r4));
        r0.put("word_content", r5.b());
        r0.put("group_id", r5.c());
        r0.put("impr_id", r5.a);
        j0.l().e("trending_words_click", r0, new Object[0]);
    }

    public final void n(String r6, String r7) {
        Intrinsics.checkNotNullParameter("search_result", "tabName");
        Intrinsics.checkNotNullParameter(r6, "userType");
        KtvContext.Companion.getClass();
        n<oe2.b> r0 = KtvContext.a.g().getKtvRoomProvider();
        if (r0 == null) goto L5;
        oe2.b r1 = (oe2.b) r0.getValue();
    L6:
        HashMap r2 = new HashMap(2);
        r2.put("tab_name", "search_result");
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r2.put("main_tab", r7);
        r2.put("sub_tab", "搜索");
        if (r1 == null) goto L13;
        String r8 = r1.getEnterFrom();
        if (r8 == null) goto L13;
    L14:
        r2.put("enter_from", r8);
        r2.put("user_type", r6);
        r2.put("live_type", F());
        if (r1 == null) goto L19;
        String r9 = r1.c();
        if (r9 == null) goto L19;
        r2.put("ksong_element_source", r9);
    L19:
        A(r2);
        if (r1 == null) goto L24;
        String r10 = r1.a();
        if (r10 == null) goto L24;
        r2.put("element_open_method", r10);
    L24:
        KtvComponentContext r11 = KtvComponentContext.Companion.getContext();
        if (r11 == null) goto L35;
        n<Boolean> r12 = r11.isAudienceEnableSing();
        if (r12 == null) goto L35;
        Boolean r13 = (Boolean) r12.getValue();
        if (r13 == null) goto L35;
        if (r13.booleanValue() == false) goto L33;
        String r14 = "on";
    L34:
        r2.put("order_status", r14);
        goto L35
    L33:
        r14 = "off";
    L35:
        l0(r2);
        o0(r2);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r2);
        we2.a.a(r2);
        h.b(r2);
        j0.l().sendLog("livesdk_anchor_ksong_show", r2, new Object[]{IRoom.class, x.class});
        return;
    L13:
        r8 = "bottom";
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final void s(int r4, s r5) {
        Intrinsics.checkNotNullParameter(r5, "guessWord");
        HashMap r0 = new HashMap();
        r0.put("word_source", "sug");
        r0.put("word_position", String.valueOf(r4));
        r0.put("word_content", r5.b());
        r0.put("group_id", r5.c());
        r0.put("impr_id", r5.a);
        j0.l().e("trending_words_show", r0, new Object[0]);
    }

    public static void O(MusicPanel r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r5, "musicPanel");
        Intrinsics.checkNotNullParameter(r6, "result");
        HashMap r1 = new HashMap();
        r1.put("from_request_type", r5.d);
        r1.put("song_id", String.valueOf(r5.a.getMId()));
        String r2 = r5.a.getMTitle();
        String r3 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.put("song_name", r2);
        String r8 = r5.a.getMAuthor();
        if (r8 == null) goto L9;
        r3 = r8;
    L9:
        r1.put("singer", r3);
        r1.put("result", r6);
        r1.put("live_type", j.d());
        A(r1);
        if (r7 == (-1)) goto L12;
        r1.put("duration", String.valueOf(r7));
    L12:
        j0.l().sendLog("livesdk_ksong_request_single_song_result", r1, new Object[]{IRoom.class});
    }

    public static void i0(long r3, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "effectName");
        Intrinsics.checkNotNullParameter(r6, "functionType");
        HashMap r0 = new HashMap();
        r0.put("duration", String.valueOf(r3 / ((long) 1000)));
        r0.put("effect_type", r5);
        r0.put("function_type", H(r6));
        r0.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        r0.put("user_type", I());
        if (Intrinsics.areEqual(r5, (String) c.e.getValue()) == false) goto L5;
        r0.put("if_default", BDLocationException.ERROR_TIMEOUT);
    L6:
        r0.put("live_type", F());
        o0(r0);
        j0.l().sendLog("anchor_ksong_audio_effect_effective_duration", r0, new Object[]{IRoom.class, new x()});
        return;
    L5:
        r0.put("if_default", "1");
        goto L6
    }

    public final void h(String r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "content");
        HashMap r0 = new HashMap();
        r0.put("user_type", I());
        r0.put("live_type", F());
        A(r0);
        if (r6 == false) goto L5;
        String r7 = "1";
    L6:
        r0.put("is_ksong", r7);
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        r0.put("first_feedback", r4);
        r0.put("second_feedback", r5);
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L19;
        com.bytedance.android.live.liveinteract.plantform.base.i r8 = k.n(IInteractService.class).getLinkUserInfoCenter();
        if (r8 == null) goto L14;
        int r9 = r8.b();
    L15:
        if (r9 <= 0) goto L17;
        String r10 = "end_ahead";
    L18:
        r0.put("request_page", r10);
        goto L19
    L17:
        r10 = "normal";
        goto L18
    L14:
        r9 = 0;
    L19:
        h.b(r0);
        j0.l().sendLog("livesdk_live_chat_feedback_success", r0, new Object[]{x.class, IRoom.class});
        return;
    L5:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public static void J(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        Intrinsics.checkNotNullParameter(r5, "toUserType");
        Intrinsics.checkNotNullParameter(r6, "liveType");
        HashMap r0 = new HashMap(2);
        r0.put("live_type", r6);
        r0.put("request_page", r3);
        r0.put("to_user_type", r5);
        r0.put("to_user_id", r4);
        r0.put("user_type", I());
        A(r0);
        j0.l().sendLog("livesdk_ksong_mark_label_click", r0, new Object[]{x.class, IRoom.class});
    }

    public static void K(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r3, "requestPage");
        Intrinsics.checkNotNullParameter(r4, "toUserId");
        Intrinsics.checkNotNullParameter(r5, "toUserType");
        Intrinsics.checkNotNullParameter(r6, "liveType");
        HashMap r0 = new HashMap(2);
        r0.put("live_type", r6);
        r0.put("request_page", r3);
        r0.put("to_user_type", r5);
        r0.put("to_user_id", r4);
        r0.put("user_type", I());
        A(r0);
        j0.l().sendLog("livesdk_ksong_mark_label_show", r0, new Object[]{x.class, IRoom.class});
    }

    public static void P(String r3, String r4, String r5, long r6) {
        Intrinsics.checkNotNullParameter(r3, "playMode");
        Intrinsics.checkNotNullParameter(r4, "deviceType");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("live_type", F());
        r0.put("anchor_id", r5.toString());
        r0.put("room_id", String.valueOf(r6));
        A(r0);
        r0.put("play_mode", r3);
        r0.put("device_type", r4);
        j0.l().sendLog("livesdk_live_ksong_device_add_result", r0, new Object[0]);
    }

    public static /* synthetic */ void U(String r7, String r8, String r9, String r10) {
        T(r7, r8, "ksong", r9, BDLocationException.ERROR_TIMEOUT, r10, "");
    }

    public static void g0(int r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "toUserType");
        HashMap r0 = new HashMap(2);
        r0.put("song_score", String.valueOf(r3));
        r0.put("user_type", I());
        r0.put("to_user_type", r5);
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        r0.put("to_user_id", r4);
        if (r6 == null) goto L8;
        r0.put("result_status", r6);
    L8:
        A(r0);
        j0.l().sendLog("livesdk_ksong_score_result_show", r0, new Object[]{x.class, IRoom.class});
    }

    public final void Q(String r21, String r22, DataCenter r23, MusicPanel r24) {
        Intrinsics.checkNotNullParameter(r21, "requestPage");
        Intrinsics.checkNotNullParameter(r22, "buttonType");
        String r2 = j.e(r23);
        String r3 = j.a(r23);
        String r4 = j.c();
        String r9 = j.g();
        if (r24 == null) goto L10;
        KtvMusic r5 = r24.a;
        if (r5 == null) goto L10;
        String r6 = r5.getMTitle();
        if (r6 == null) goto L10;
        String r7 = r6;
    L11:
        if (r24 == null) goto L15;
        KtvMusic r8 = r24.a;
        if (r8 == null) goto L15;
        long r10 = r8.getMId();
    L16:
        if (r24 == null) goto L21;
        String r11 = r24.d;
        if (r11 == null) goto L21;
        String r12 = r11;
    L22:
        if (r24 == null) goto L32;
        KtvMusic r13 = r24.a;
        if (r13 == null) goto L32;
        String r14 = r13.getMidiUrl();
        if (r14 == null) goto L32;
        if (r14.length() <= 0) goto L30;
        boolean r15 = true;
    L31:
        Boolean r16 = Boolean.valueOf(r15);
    L33:
        Boolean r17 = r16;
        if (r24 == null) goto L39;
        String r18 = r24.b();
        if (r18 == null) goto L39;
        String r19 = r18;
    L40:
        if (r24 == null) goto L47;
        KtvMusic r20 = r24.a;
        if (r20 == null) goto L47;
        String r25 = r20.getMAuthor();
        if (r25 == null) goto L47;
        String r110 = r25;
    L48:
        pb0.a.a.a(this, r22, r2, r3, r4, r21, r7, r10, r9, r12, r19, r110, r21, null, null, r17, null, r24, 92160);
        return;
    L47:
        r110 = "";
    L39:
        r19 = "";
        goto L40
    L30:
        r15 = false;
    L32:
        r16 = null;
    L21:
        r12 = "";
    L15:
        r10 = 0;
    L10:
        r7 = "";
        goto L11
    }

    public final void l(String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, "requestPage");
        Intrinsics.checkNotNullParameter(r6, "songName");
        Intrinsics.checkNotNullParameter(r7, "singerName");
        Intrinsics.checkNotNullParameter(r8, "feedback");
        HashMap r1 = new HashMap();
        r1.put("user_type", I());
        A(r1);
        r1.put("request_page", r5);
        r1.put("song_name", r6);
        r1.put("singer_name", r7);
        r1.put("feedback", r8);
        r1.put("live_type", F());
        h.b(r1);
        j0.l().sendLog("song_feedback_success", r1, new Object[]{IRoom.class, x.class});
    }

    public final void p(String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "searchContent");
        KtvContext.Companion.getClass();
        n<oe2.b> r0 = KtvContext.a.g().getKtvRoomProvider();
        if (r0 == null) goto L5;
        oe2.b r1 = (oe2.b) r0.getValue();
    L6:
        HashMap r2 = new HashMap();
        r2.put("search_content", r4);
        if (r5 == null) goto L9;
        r2.put("search_content_type", r5);
    L9:
        r2.put("function_type", H(j.c()));
        r2.put("user_type", I());
        r2.put("live_type", F());
        o0(r2);
        if (r1 == null) goto L14;
        String r8 = r1.getEnterFrom();
        if (r8 == null) goto L14;
        r2.put("enter_from", r8);
    L14:
        if (r7 == null) goto L16;
        r2.put("enter_from", r7);
    L16:
        if (r1 == null) goto L20;
        String r9 = r1.c();
        if (r9 == null) goto L20;
        r2.put("ksong_element_source", r9);
    L20:
        r2.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r2);
        r2.put("sub_tab", r6);
        j0.l().sendLog("livesdk_anchor_ksong_request_search_click", r2, new Object[]{IRoom.class});
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void r(String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r8, "userType");
        Intrinsics.checkNotNullParameter(r9, "source");
        KtvContext.Companion.getClass();
        KtvContext r1 = KtvContext.a.g();
        String r2 = null;
        if (r1 == null) goto L7;
        n<oe2.b> r3 = r1.getKtvRoomProvider();
        if (r3 == null) goto L7;
        oe2.b r4 = (oe2.b) r3.getValue();
    L8:
        if (r4 == null) goto L10;
        String r5 = r4.c();
    L11:
        if (r4 == null) goto L13;
        r2 = r4.a();
    L13:
        HashMap r6 = new HashMap();
        r6.put("function_type", H(j.c()));
        r6.put("user_type", r8);
        r6.put("source", r9);
        r6.put("live_type", F());
        o0(r6);
        if (r4 == null) goto L18;
        String r12 = r4.getEnterFrom();
        if (r12 == null) goto L18;
        r6.put("enter_from", r12);
    L18:
        if (r11 == null) goto L20;
        r6.put("enter_from", r11);
    L20:
        if (r5 == null) goto L22;
        r6.put("ksong_element_source", r5);
    L22:
        if (r2 == null) goto L24;
        r6.put("element_open_method", r2);
    L24:
        if (r10 == null) goto L26;
        r6.put("sub_tab", r10);
    L26:
        r6.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r6);
        h.b(r6);
        j0.l().sendLog("livesdk_anchor_ksong_request_search", r6, new Object[]{IRoom.class});
        return;
    L10:
        r5 = null;
    L7:
        r4 = null;
        goto L8
    }

    public static void L(String r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r3, "connectionType");
        Intrinsics.checkNotNullParameter(r4, "liveType");
        Intrinsics.checkNotNullParameter(r5, "roomType");
        Intrinsics.checkNotNullParameter(r6, "enterFrom");
        Intrinsics.checkNotNullParameter(r7, "function");
        HashMap r1 = new HashMap();
        r1.put("connection_type", r3);
        r1.put("live_type", r4);
        r1.put("room_type", r5);
        r1.put("enter_from", r6);
        r1.put("function", r7);
        A(r1);
        j0.l().sendLog("anchor_ksong_icon_click", r1, new Object[]{IRoom.class});
    }

    public final void i(String r5, String r6, String r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r5, "searchWord");
        Intrinsics.checkNotNullParameter(r6, "liveType");
        Intrinsics.checkNotNullParameter(r7, "roomType");
        Intrinsics.checkNotNullParameter("audience_sing", "function");
        HashMap r2 = new HashMap();
        r2.put("live_type", r6);
        r2.put("room_type", r7);
        r2.put("search_word", r5);
        if (r8 == false) goto L5;
        String r10 = "recent";
    L6:
        r2.put("word_type", r10);
        r2.put("function", "audience_sing");
        if (r9 == false) goto L9;
        String r11 = "1";
    L10:
        r2.put("is_anchor", r11);
        j0.l().sendLog("anchor_ksong_request_frequent_search_click", r2, new Object[]{IRoom.class, x.class});
        return;
    L9:
        r11 = BDLocationException.ERROR_TIMEOUT;
        goto L10
    L5:
        r10 = "frequent";
        goto L6
    }

    public final void j(String r6, String r7, String r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r6, "requestPage");
        Intrinsics.checkNotNullParameter(r7, "eventPage");
        Intrinsics.checkNotNullParameter(r8, "iconType");
        Intrinsics.checkNotNullParameter(r10, "isResourceInfo");
        String r11 = I();
        if (r7.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L10;
        String r1 = "1";
    L11:
        Pair[] r3 = new Pair[6];
        r3[0] = TuplesKt.to("request_page", r6);
        r3[1] = TuplesKt.to("user_type", r11);
        r3[2] = TuplesKt.to("event_page", r7);
        r3[3] = TuplesKt.to("is_show_cnt", r1);
        r3[4] = TuplesKt.to("live_type", F());
        if (r9 != null) goto L14;
        r9 = H(j.c());
    L14:
        r3[5] = TuplesKt.to("function_type", r9);
        HashMap r12 = MapsKt.hashMapOf(r3);
        r12.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        r12.put("is_resource_info", r10);
        m0(r12);
        Intrinsics.checkNotNullParameter(r12, "logMap");
        com.bytedance.android.livesdk.log.filter.o r13 = j0.l().c(x.class);     // Catch: Exception -> L33
        if ((r13 instanceof t) == true) goto L18;
        r13 = null;
    L18:
        t r14 = (t) r13;     // Catch: Exception -> L33
        if (r14 != null) goto L21;
    L35:
        o0(r12);
        h.b(r12);
        j0.l().sendLog("livesdk_ktv_sing_icon_click", r12, new Object[]{IRoom.class, x.class});
        return;
    L21:
        if (Intrinsics.areEqual(r14.getMap().get("enter_from_merge"), "single_song") == false) goto L35;
        if (Intrinsics.areEqual(r14.getMap().get("enter_method"), "song") == false) goto L35;
        String r15 = r14.i();     // Catch: Exception -> L33
        if (r15 == null) goto L35;
        JSONObject r16 = s2.a(r15);     // Catch: Exception -> L33
        String r17 = r16.optString("linkmic_ktv_song_id");     // Catch: Exception -> L33
        if (r17 == null) goto L29;
        r12.put("song_id", r17);     // Catch: Exception -> L33
    L29:
        String r18 = r16.optString("linkmic_ktv_song_name");     // Catch: Exception -> L33
        if (r18 == null) goto L35;
        r12.put("song_name", r18);     // Catch: Exception -> L33
    L33:
        e = move-exception;
        ALogger.e("KtvLoggerHelper", "can't parse json for relevant log", e);
    L10:
        r1 = BDLocationException.ERROR_TIMEOUT;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final void t(MusicPanel r8, String r9, String r10, HashMap<String, String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r9, "fromRequestType");
        Intrinsics.checkNotNullParameter(r10, "enterFrom");
        HashMap r0 = new HashMap();
        if (r12 != null) goto L5;
    L10:
        r0.put("sub_tab", r9);
        r0.put("from_request_type", r9);
        if ((!StringsKt.isBlank(r10)) == false) goto L14;
        r0.put("enter_from", r10);
    L14:
        if (r8 == null) goto L19;
        KtvMusic r13 = r8.a;
        if (r13 == null) goto L19;
        String r14 = r13.getMTitle();
        if (r14 == null) goto L19;
    L20:
        r0.put("song_name", r14);
        r0.put("user_type", I());
        if (r8 == null) goto L25;
        KtvMusic r15 = r8.a;
        if (r15 == null) goto L25;
        Long r16 = Long.valueOf(r15.getMId());
    L26:
        r0.put("song_id", String.valueOf(r16));
        r0.put("live_type", F());
        if (r11 == null) goto L32;
        Iterator<Map.Entry<String, String>> r17 = r11.entrySet().iterator();
    L30:
        if (r17.hasNext() == false) goto L32;
        Map.Entry<String, String> r18 = r17.next();
        r0.put(r18.getKey(), r18.getValue());
    L32:
        r0.put("midi_score", "");
        if (r8 == null) goto L41;
        KtvMusic r19 = r8.a;
        if (r19 == null) goto L41;
        PersonalSongInfo r110 = r19.getPersonalSongInfo();
        if (r110 == null) goto L41;
        double r3 = r110.getMidiScore();
        if (r3 <= 0) goto L41;
        r0.put("midi_score", String.valueOf(r3));
    L41:
        r0.put("is_original", String.valueOf(G()));
        int r111 = ke2.b.a;
        ke2.b.m(r0);
        ke2.b.l(r0);
        ke2.b.o(r0);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r0);
        n0(r0, r8);
        ke2.d.a(r8, r0, false);
        we2.a.d(r0, r8, r9);
        h.b(r0);
        j0.l().sendLog("livesdk_anchor_ksong_request_song_show", r0, new Object[]{IRoom.class, new x()});
        if (Intrinsics.areEqual(r9, "播放列表") == false) goto L49;
        if (r8 == null) goto L49;
        HashMap r112 = r8.B;
        if (r112 == null) goto L49;
        if ((!r112.isEmpty()) != true) goto L49;
        boolean r113 = true;
    L50:
        if (r8 == null) goto L65;
        KtvMusic r20 = r8.a;
        if (r20 == null) goto L66;
        List r21 = r20.getRecommendRealTimeChorusInfos();
        if (r21 == null) goto L67;
        RecommendRealTimeChorusInfo r22 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r21, 0);
        if (r22 == null) goto L68;
        List r23 = r22.getShowUsers();
        if (r23 != null) goto L60;
        return;
    L60:
        if ((!r23.isEmpty()) != true) goto L70;
        if (r113 == true) goto L71;
        LinkedHashMap r24 = new LinkedHashMap();
        r24.put("tab_name", r9);
        r24.put("play_mode", E());
        r24.put("function_type2", H(j.c()));
        j0.l().sendLog("livesdk_live_show", r24, new Object[]{IRoom.class, new x()});
        return;
    L71:
        return;
    L70:
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L49:
        r113 = false;
    L25:
        r16 = null;
    L19:
        r14 = "";
        goto L20
    L5:
        if (r12.length() <= 0) goto L7;
        boolean r4 = true;
    L8:
        if (r4 != true) goto L10;
        r0.put("main_tab", r12);
        goto L10
    L7:
        r4 = false;
        goto L8
    }

    public static void S(String r3, String r4, String r5, String r6, String r7, int r8) {
        if ((r8 & 16) == 0) goto L5;
        r7 = BDLocationException.ERROR_TIMEOUT;
    L5:
        String r0 = "";
        if ((r8 & 32) == 0) goto L8;
        String r9 = "";
    L9:
        Intrinsics.checkNotNullParameter(r5, "resourceType");
        Intrinsics.checkNotNullParameter(r6, "isAvailable");
        Intrinsics.checkNotNullParameter(r7, "isRoomOnly");
        Intrinsics.checkNotNullParameter(r9, "dressId");
        LinkedHashMap r1 = new LinkedHashMap();
        if (r3 == null) goto L12;
        r1.put("tag_type", r3);
    L12:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r1.put("resource_name", r4);
        r1.put("resource_type", r5);
        r1.put("is_available", r6);
        r1.put("is_roomonly", r7);
        r1.put("user_type", I());
        if (Intrinsics.areEqual(r5, "midi") == false) goto L17;
        r0 = r9;
    L17:
        r1.put("midi_id", r0);
        A(r1);
        j0.l().sendLog("livesdk_audience_ksong_resource_detail_click", r1, new Object[]{IRoom.class});
        return;
    L8:
        r9 = null;
        goto L9
    }

    public static void V(String r3, String r4, String r5, String r6, String r7, int r8) {
        if ((r8 & 16) == 0) goto L5;
        r7 = BDLocationException.ERROR_TIMEOUT;
    L5:
        String r0 = "";
        if ((r8 & 32) == 0) goto L8;
        String r9 = "";
    L9:
        Intrinsics.checkNotNullParameter(r5, "resourceType");
        Intrinsics.checkNotNullParameter(r6, "isAvailable");
        Intrinsics.checkNotNullParameter(r7, "isRoomOnly");
        Intrinsics.checkNotNullParameter(r9, "dressId");
        LinkedHashMap r1 = new LinkedHashMap();
        if (r3 == null) goto L12;
        r1.put("tag_type", r3);
    L12:
        if (r4 != null) goto L14;
        r4 = "";
    L14:
        r1.put("resource_name", r4);
        r1.put("resource_type", r5);
        r1.put("is_available", r6);
        r1.put("is_roomonly", r7);
        r1.put("user_type", I());
        if (Intrinsics.areEqual(r5, "midi") == false) goto L17;
        r0 = r9;
    L17:
        r1.put("midi_id", r0);
        A(r1);
        j0.l().sendLog("livesdk_audience_ksong_resource_detail_show", r1, new Object[]{IRoom.class});
        return;
    L8:
        r9 = null;
        goto L9
    }

    public static void N(String r4, String r5, String r6, String r7, String r8, String r9, Long r10) {
        Intrinsics.checkNotNullParameter(r4, "playMode");
        Intrinsics.checkNotNullParameter(r5, "anchorId");
        Intrinsics.checkNotNullParameter(r6, "roomId");
        HashMap r0 = new HashMap();
        r0.put("anchor_id", r5);
        r0.put("room_id", r6);
        r0.put("live_type", j.d());
        if (r7 == null) goto L5;
        r0.put("function_type", r7);
        r0.put("function_type2", r7);
    L6:
        if (r8 == null) goto L8;
        r0.put("layout_type", r8);
    L8:
        o r11 = m.i();
        if (r11 == null) goto L13;
        DataCenter r12 = r11.getDataCenter();
        if (r12 == null) goto L13;
        String r13 = (String) r12.get("cmd_func_type_when_open_ktv_by_schema", "");
    L15:
        if (r13 != null) goto L17;
    L20:
        boolean r3 = true;
    L21:
        if (r3 == true) goto L28;
        o r14 = m.i();
        if (r14 == null) goto L27;
        DataCenter r15 = r14.getDataCenter();
        if (r15 == null) goto L27;
        r15.put("cmd_func_type_when_open_ktv_by_schema", "");
    L27:
        r0.put("function_type", r13);
    L28:
        r0.put("play_mode", r4);
        if (r10 == null) goto L31;
        r0.put("duration", String.valueOf(r10.longValue()));
    L31:
        if (r9 == null) goto L33;
        r0.put("source", r9);
    L33:
        o0(r0);
        j0.l().sendLog("anchor_playmode_over", r0, new Object[]{IRoom.class, x.class});
        return;
    L17:
        if (r13.length() == 0) goto L20;
        r3 = false;
    L13:
        r13 = null;
        goto L15
    L5:
        r0.put("function_type", H(j.c()));
        goto L6
    }

    public static void T(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "resourceType");
        Intrinsics.checkNotNullParameter(r5, "isAvailable");
        Intrinsics.checkNotNullParameter(r6, "isRoomOnly");
        Intrinsics.checkNotNullParameter(r7, "clickResult");
        Intrinsics.checkNotNullParameter(r8, "dressId");
        LinkedHashMap r0 = new LinkedHashMap();
        if (r2 == null) goto L6;
        r0.put("tag_type", r2);
    L6:
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.put("resource_name", r3);
        r0.put("resource_type", r4);
        r0.put("is_available", r5);
        r0.put("is_roomonly", r6);
        r0.put("click_result", r7);
        r0.put("user_type", I());
        if (Intrinsics.areEqual(r4, "midi") == true) goto L12;
        r8 = "";
    L12:
        r0.put("midi_id", r8);
        A(r0);
        j0.l().sendLog("livesdk_audience_ksong_resource_detail_click_result", r0, new Object[]{IRoom.class});
    }

    public final void q(String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r2, "liveType");
        Intrinsics.checkNotNullParameter(r3, "roomType");
        Intrinsics.checkNotNullParameter(r4, "effectName");
        Intrinsics.checkNotNullParameter(r5, "functionType");
        HashMap r9 = new HashMap();
        r9.put("room_type", r3);
        r9.put("effect_type", r4);
        r9.put("function_type", H(r5));
        r9.put("user_type", I());
        if (Intrinsics.areEqual(r4, (String) c.e.getValue()) == false) goto L5;
        r9.put("if_default", BDLocationException.ERROR_TIMEOUT);
    L6:
        r9.put("live_type", F());
        o0(r9);
        r9.put("enter_from", r6);
        r9.put("ksong_element_source", r7);
        r9.put("element_open_method", r8);
        r9.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        h.b(r9);
        j0.l().sendLog("anchor_ksong_audio_effect_effective_user", r9, new Object[]{IRoom.class, new x()});
        return;
    L5:
        r9.put("if_default", "1");
        goto L6
    }

    public final void e(String r13, String r14, Boolean r15, Boolean r16, String r17, String r18, String r19, Boolean r20) {
        Intrinsics.checkNotNullParameter(r13, "liveType");
        Intrinsics.checkNotNullParameter(r14, "roomType");
        HashMap r3 = new HashMap(2);
        if (x() == 9) goto L5;
        KtvComponentContext r4 = KtvComponentContext.Companion.getContext();
        if (r4 == null) goto L24;
        n<KtvComponentUIContext> r5 = r4.getKtvComponentUIContext();
        if (r5 == null) goto L24;
        KtvComponentUIContext r6 = (KtvComponentUIContext) r5.getValue();
        if (r6 == null) goto L24;
        MutableLiveData<Boolean> r7 = r6.getScoreOpen();
        if (r7 == null) goto L24;
        Boolean r8 = (Boolean) r7.getValue();
    L26:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L28;
    L31:
        boolean r9 = true;
    L32:
        String r10 = "1";
        if (r9 == false) goto L35;
        Object r11 = "1";
    L36:
        r3.put("score_status", r11);
        r3.put("live_type", r13);
        r3.put("room_type", r14);
        A(r3);
        r3.put("user_type", I());
        Boolean r0 = Boolean.TRUE;
        String r12 = "open";
        if (Intrinsics.areEqual(r15, r0) == false) goto L39;
        Object r1 = "open";
    L40:
        r3.put("original_vocal_status", r1);
        if (Intrinsics.areEqual(r16, r0) == false) goto L44;
    L47:
        r3.put("earphone_status", r12);
        String r2 = "";
        if (r17 != null) goto L50;
        String r21 = "";
    L51:
        r3.put("singer_volume", r21);
        if (r18 != null) goto L54;
        String r22 = "";
    L55:
        r3.put("song_volume", r22);
        if (Intrinsics.areEqual(r20, r0) == true) goto L59;
        r10 = BDLocationException.ERROR_TIMEOUT;
    L59:
        r3.put("score_status", r10);
        if (Intrinsics.areEqual(r16, r0) == false) goto L65;
        if (r19 == null) goto L64;
        r2 = r19;
    L64:
        r3.put("earphone_volume", r2);
    L65:
        j0.l().sendLog("anchor_ksong_tune_show", r3, new Object[]{IRoom.class});
        return;
    L54:
        r22 = r18;
        goto L55
    L50:
        r21 = r17;
        goto L51
    L44:
        if (Intrinsics.areEqual(r16, Boolean.FALSE) == false) goto L46;
        r12 = "close";
        goto L47
    L46:
        r12 = "unavailable";
        goto L47
    L39:
        r1 = "close";
        goto L40
    L35:
        r11 = BDLocationException.ERROR_TIMEOUT;
        goto L36
    L28:
        if (((Boolean) c.H.getValue()).booleanValue() == true) goto L31;
    L30:
        r9 = false;
    L24:
        r8 = null;
        goto L26
    L5:
        if (KtvRoomContext.Companion == null) goto L13;
        KtvRoomContext r23 = KtvRoomContext.a.a();
        if (r23 == null) goto L13;
        com.bytedance.live.datacontext.m<Boolean> r24 = r23.isMidiOpened();
        if (r24 == null) goto L13;
        if (((Boolean) r24.getValue()).booleanValue() == true) goto L31;
    L13:
        if (((Boolean) c.M.getValue()).booleanValue() == false) goto L30;
        goto L30
    }

    public final void b(String r6, String r7, boolean r8, String r9, String r10, String r11, String r12, String r13, String r14) {
        Intrinsics.checkNotNullParameter(r6, "liveType");
        Intrinsics.checkNotNullParameter(r7, "roomType");
        Intrinsics.checkNotNullParameter("audience_sing", "function");
        Intrinsics.checkNotNullParameter(r9, "source");
        Intrinsics.checkNotNullParameter(r10, "content");
        HashMap r3 = new HashMap();
        r3.put("live_type", r6);
        r3.put("function_type", H(r7));
        r3.put("function", "audience_sing");
        if (r8 == false) goto L5;
        String r15 = "1";
    L6:
        r3.put("is_anchor", r15);
        r3.put("source", r9);
        r3.put("search_content", r10);
        r3.put("user_type", I());
        if (r11 == null) goto L9;
        r3.put("search_content_type", r11);
    L9:
        if (r12 == null) goto L11;
        r3.put("enter_from", r12);
    L11:
        if (r13 == null) goto L13;
        r3.put("ksong_element_source", r13);
    L13:
        if (r14 == null) goto L15;
        r3.put("element_open_method", r14);
    L15:
        r3.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r3);
        h.b(r3);
        j0.l().sendLog("livesdk_anchor_ksong_request_search_success", r3, new Object[]{IRoom.class});
        return;
    L5:
        r15 = BDLocationException.ERROR_TIMEOUT;
        goto L6
    }

    public final void v(String r3, String r4, String r5, long r6, String r8, String r9, Integer r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r3, "liveType");
        Intrinsics.checkNotNullParameter(r4, "roomType");
        Intrinsics.checkNotNullParameter(r5, "buttonActionType");
        Intrinsics.checkNotNullParameter(r8, "userType");
        KtvContext.Companion.getClass();
        n<oe2.b> r7 = KtvContext.a.g().getKtvRoomProvider();
        if (r7 == null) goto L5;
        oe2.b r13 = (oe2.b) r7.getValue();
    L6:
        HashMap r0 = new HashMap();
        r0.put("function_type", H(r4));
        r0.put("button_action_type", r5);
        if (r13 == null) goto L10;
        String r14 = r13.getEnterFrom();
        if (r14 == null) goto L10;
    L11:
        r0.put("enter_from", r14);
        r0.put("ksong_id", String.valueOf(r6));
        r0.put("user_type", r8);
        r0.put("live_type", F());
        o0(r0);
        if (r13 == null) goto L16;
        String r15 = r13.c();
        if (r15 == null) goto L16;
        r0.put("ksong_element_source", r15);
    L16:
        if (r13 == null) goto L20;
        String r16 = r13.a();
        if (r16 == null) goto L20;
        r0.put("element_open_method", r16);
    L20:
        if (r10 == null) goto L22;
        r0.put("song_top_n", String.valueOf(r10.intValue()));
    L22:
        if (r11 == null) goto L24;
        r0.put("search_id", r11);
    L24:
        if (r12 == null) goto L26;
        r0.put("request_id", r12);
    L26:
        if (r9 == null) goto L28;
        r0.put("from_request_type", r9);
    L28:
        r0.put("search_result_id", String.valueOf(r6));
        r0.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r0);
        h.b(r0);
        j0.l().sendLog("anchor_ksong_collect_icon_click", r0, new Object[]{IRoom.class, new x()});
        return;
    L10:
        r14 = "";
        goto L11
    L5:
        r13 = null;
        goto L6
    }

    public static void Y(String r1, String r2, long r3, String r5, String r6, String r7, String r8, String r9, boolean r10, HashMap r11, MusicPanel r12) {
        Intrinsics.checkNotNullParameter(r1, "buttonType");
        Intrinsics.checkNotNullParameter(r2, "songName");
        Intrinsics.checkNotNullParameter(r5, "applicantId");
        Intrinsics.checkNotNullParameter(r6, "userType");
        Intrinsics.checkNotNullParameter(r7, "fromRequestType");
        Intrinsics.checkNotNullParameter(r8, "artistId");
        Intrinsics.checkNotNullParameter(r9, "artistName");
        if (r11 != null) goto L5;
        r11 = new HashMap();
    L5:
        r11.put("button_type", r1);
        r11.put("from_request_type", r7);
        A(r11);
        r11.put("applicant_id", r5);
        r11.put("song_name", r2);
        r11.put("song_id", String.valueOf(r3));
        r11.put("user_type", r6);
        r11.put("from_request_type", r7);
        r11.put("artist_id", r8);
        r11.put("artist_name", r9);
        if (r10 == false) goto L8;
        String r4 = "1";
    L9:
        r11.put("is_play_all", r4);
        r11.put("live_type", F());
        if (r12 == null) goto L14;
        String r13 = r12.g;
        if (r13 == null) goto L14;
        r11.put("order_type", r13);
        r11.put("enter_method", "linkmic_karaoke_lottery");
    L14:
        ke2.d.a(r12, r11, true);
        we2.a.d(r11, r12, r7);
        h.b(r11);
        j0.l().sendLog("anchor_ksong_order_button_click", r11, new Object[]{IRoom.class});
        return;
    L8:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L9
    }

    public final void d(String r9, long r10, String r12, String r13, String r14, long r15, boolean r17, String r18, int r19, int r20, String r21, Boolean r22) {
        Intrinsics.checkNotNullParameter(r9, "anchorId");
        Intrinsics.checkNotNullParameter(r12, "liveType");
        Intrinsics.checkNotNullParameter(r13, "roomType");
        Intrinsics.checkNotNullParameter(r14, "functionType");
        Intrinsics.checkNotNullParameter(r18, "tuneType");
        KtvContext.Companion.getClass();
        KtvContext r4 = KtvContext.a.g();
        if (r4 == null) goto L7;
        n<oe2.b> r5 = r4.getKtvRoomProvider();
        if (r5 == null) goto L7;
        oe2.b r6 = (oe2.b) r5.getValue();
    L8:
        HashMap r7 = new HashMap();
        r7.put("anchor_id", r9);
        r7.put("room_id", String.valueOf(r10));
        r7.put("live_type", r12);
        r7.put("room_type", r13);
        r7.put("ksong_id", String.valueOf(r15));
        String r0 = "1";
        if (r17 == false) goto L11;
        Object r2 = "1";
    L12:
        r7.put("is_default", r2);
        r7.put("tune_type", r18);
        r7.put("user_type", I());
        r7.put("function_type", H(r14));
        r7.put("from_value", String.valueOf(r19));
        r7.put("to_value", String.valueOf(r20));
        o0(r7);
        r7.put("enter_from", r21);
        if (r6 == null) goto L17;
        String r3 = r6.c();
        if (r3 == null) goto L17;
        r7.put("ksong_element_source", r3);
    L17:
        if (r6 == null) goto L21;
        String r8 = r6.a();
        if (r8 == null) goto L21;
        r7.put("element_open_method", r8);
    L21:
        if (r22 != null) goto L23;
    L27:
        r7.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        h.b(r7);
        j0.l().sendLog("livesdk_anchor_ksong_tune_value", r7, new Object[]{IRoom.class, x.class});
        return;
    L23:
        if (r22.booleanValue() == true) goto L26;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L26:
        r7.put("is_midi", r0);
        goto L27
    L11:
        r2 = BDLocationException.ERROR_TIMEOUT;
    L7:
        r6 = null;
        goto L8
    }

    public final void f(MusicPanel r16, String r17, String r18, String r19, long r20, String r22, boolean r23, String r24, String r25, HashMap<String, String> r26, String r27, String r28, Integer r29, String r30, String r31, Boolean r32) {
        Intrinsics.checkNotNullParameter(r17, "enterFrom");
        Intrinsics.checkNotNullParameter(r18, "userType");
        Intrinsics.checkNotNullParameter(r19, "songName");
        Intrinsics.checkNotNullParameter(r22, "fromRequestType");
        Intrinsics.checkNotNullParameter(r24, "artistId");
        Intrinsics.checkNotNullParameter(r25, "artistName");
        if (r26 != null) goto L5;
        HashMap<String, String> r11 = new HashMap();
    L6:
        r11.put("from_request_type", r22);
        if (r20 <= 0) goto L9;
        r11.put("song_id", String.valueOf(r20));
    L9:
        r11.put("song_name", r19);
        r11.put("user_type", r18);
        r11.put("enter_from", r17);
        A(r11);
        String r2 = BDLocationException.ERROR_TIMEOUT;
        r11.put("is_original", BDLocationException.ERROR_TIMEOUT);
        r11.put("is_play_all", BDLocationException.ERROR_TIMEOUT);
        r11.put("artist_id", r24);
        r11.put("artist_name", r25);
        r11.put("live_type", F());
        if (r23 == false) goto L12;
        String r3 = "1";
    L13:
        r11.put("is_priority_sing", r3);
        m0(r11);
        o0(r11);
        if (r27 == null) goto L16;
        r11.put("ksong_element_source", r27);
    L16:
        if (r28 == null) goto L18;
        r11.put("element_open_method", r28);
    L18:
        if (r29 == null) goto L20;
        r11.put("song_top_n", String.valueOf(r29.intValue()));
    L20:
        if (r30 == null) goto L22;
        r11.put("search_id", r30);
    L22:
        if (r31 == null) goto L24;
        r11.put("request_id", r31);
    L24:
        if (r32 != null) goto L26;
    L29:
        r11.put("search_result_id", String.valueOf(r20));
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r11);
        r11.put("midi_score", "");
        if (r16 == null) goto L38;
        KtvMusic r4 = r16.a;
        if (r4 == null) goto L38;
        PersonalSongInfo r5 = r4.getPersonalSongInfo();
        if (r5 == null) goto L38;
        double r6 = r5.getMidiScore();
        if (r6 <= 0) goto L38;
        r11.put("midi_score", String.valueOf(r6));
    L38:
        n0(r11, r16);
        if (Intrinsics.areEqual(r22, "recommend") == false) goto L41;
    L42:
        ke2.d.a(r16, r11, true);
    L43:
        h.b(r11);
        j0.l().sendLog("anchor_ksong_request_button_click", r11, new Object[]{IRoom.class, new x()});
        return;
    L41:
        if (Intrinsics.areEqual(r22, "推荐") == false) goto L43;
    L26:
        if (r32.booleanValue() == false) goto L28;
        r2 = "1";
    L28:
        r11.put("is_midi", r2);
        goto L29
    L12:
        r3 = BDLocationException.ERROR_TIMEOUT;
        goto L13
    L5:
        r11 = r26;
        goto L6
    }

    public final void h0(MusicPanel r17, String r18, String r19, String r20, long r21, String r23, String r24, String r25, long r26, HashMap r28, String r29, String r30, String r31, String r32, Boolean r33, String r34) {
        Intrinsics.checkNotNullParameter(r18, "liveType");
        Intrinsics.checkNotNullParameter(r19, "roomType");
        Intrinsics.checkNotNullParameter(r20, "fromRequestType");
        Intrinsics.checkNotNullParameter("", "enterFrom");
        Intrinsics.checkNotNullParameter(r23, "functionType");
        Intrinsics.checkNotNullParameter(r24, "userType");
        Intrinsics.checkNotNullParameter(r25, "songName");
        Intrinsics.checkNotNullParameter(r34, "songAnchor");
        HashMap r9 = new HashMap();
        r9.put("sub_tab", r20);
        r9.put("room_type", r19);
        r9.put("from_request_type", r20);
        if ((!StringsKt.isBlank("")) == false) goto L5;
        r9.put("enter_from", "");
    L5:
        String r13 = "1";
        r9.put("is_original", "1");
        r9.put("ksong_id", String.valueOf(r21));
        ke2.d.a(r17, r9, false);
        r9.put("song_name", r25);
        r9.put("function_type", H(r23));
        r9.put("user_type", r24);
        r9.put("song_id", String.valueOf(r26));
        r9.put("live_type", F());
        if (r28 == null) goto L11;
        Iterator r3 = r28.entrySet().iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        Map.Entry r4 = (Map.Entry) r3.next();
        r9.put(r4.getKey(), r4.getValue());
    L11:
        if (r29 == null) goto L13;
        r9.put("ksong_element_source", r29);
    L13:
        if (r30 == null) goto L15;
        r9.put("element_open_method", r30);
    L15:
        if (r31 == null) goto L17;
        r9.put("search_id", r31);
    L17:
        if (r32 == null) goto L19;
        r9.put("request_id", r32);
    L19:
        if (r33 != null) goto L21;
    L25:
        r9.put("search_result_id", String.valueOf(r21));
        r9.put("midi_score", "");
        KtvMusic r5 = r17.a;
        if (r5 == null) goto L32;
        PersonalSongInfo r6 = r5.getPersonalSongInfo();
        if (r6 == null) goto L32;
        double r7 = r6.getMidiScore();
        if (r7 <= 0) goto L32;
        r9.put("midi_score", String.valueOf(r7));
    L32:
        r9.put("is_original", String.valueOf(G()));
        n0(r9, r17);
        m0(r9);
        o0(r9);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r9);
        we2.a.d(r9, r17, r20);
        h.b(r9);
        j0.l().sendLog("anchor_ksong_request_song_show", r9, new Object[]{IRoom.class, new x()});
        return;
    L21:
        if (r33.booleanValue() == true) goto L24;
        r13 = BDLocationException.ERROR_TIMEOUT;
    L24:
        r9.put("is_midi", r13);
        goto L25
    }

    public final void o(String r18, String r19, String r20, String r21, String r22, String r23, long r24, String r26, String r27, String r28, String r29, HashMap<String, String> r30, String r31, String r32, String r33, Boolean r34, Boolean r35, MusicPanel r36) {
        Intrinsics.checkNotNullParameter(r18, "buttonType");
        Intrinsics.checkNotNullParameter(r19, "liveType");
        Intrinsics.checkNotNullParameter(r20, "roomType");
        Intrinsics.checkNotNullParameter(r21, "functionType");
        Intrinsics.checkNotNullParameter(r22, "requestPage");
        Intrinsics.checkNotNullParameter(r23, "songName");
        Intrinsics.checkNotNullParameter(r26, "userType");
        Intrinsics.checkNotNullParameter(r27, "fromRequestType");
        Intrinsics.checkNotNullParameter(r28, "artistId");
        Intrinsics.checkNotNullParameter(r29, "artistName");
        if (r30 != null) goto L5;
        HashMap<String, String> r12 = new HashMap();
    L6:
        r12.put("button_type", r18);
        r12.put("room_type", r20);
        r12.put("from_request_type", r27);
        if (r21.length() <= 0) goto L9;
        boolean r14 = true;
    L11:
        if (r14 == false) goto L14;
        r12.put("function_type", H(r21));
    L14:
        if (r22.length() <= 0) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == false) goto L20;
        r12.put("request_page", r22);
    L20:
        if (r23.length() <= 0) goto L22;
        boolean r2 = true;
    L23:
        if (r2 == false) goto L26;
        r12.put("song_name", r23);
    L26:
        if (r24 == 0) goto L29;
        r12.put("song_id", String.valueOf(r24));
    L29:
        if (r26.length() <= 0) goto L31;
        boolean r3 = true;
    L32:
        if (r3 == false) goto L35;
        r12.put("user_type", r26);
    L35:
        if (r27.length() <= 0) goto L37;
        boolean r4 = true;
    L38:
        if (r4 == false) goto L40;
        r12.put("from_request_type", r27);
    L40:
        r12.put("artist_id", r28);
        r12.put("artist_name", r29);
        r12.put("live_type", F());
        if (r31 != null) goto L43;
    L46:
        boolean r1 = true;
    L47:
        if (r1 == true) goto L49;
        r12.put("enter_from", r31);
    L49:
        if (r32 == null) goto L51;
        r12.put("ksong_element_source", r32);
    L51:
        if (r33 == null) goto L53;
        r12.put("element_open_method", r33);
    L53:
        String r5 = "1";
        if (r34 != null) goto L56;
    L60:
        String r6 = k.n(IInteractService.class).getFunctionType2();
        r12.put("function_type2", r6);
        if (Intrinsics.areEqual(r6, "new_audience") == false) goto L63;
        r12.put("function_type", "new_audience");
    L63:
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L66;
        String r7 = "1";
    L67:
        r12.put("is_song_owner", r7);
        if (Intrinsics.areEqual(r35, Boolean.TRUE) == true) goto L71;
        r5 = BDLocationException.ERROR_TIMEOUT;
    L71:
        r12.put("is_play_all", r5);
        o0(r12);
        if (Intrinsics.areEqual(r18, "order") == false) goto L74;
        l0(r12);
    L74:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r12);
        if (r36 == null) goto L80;
        String r0 = r36.g();
        if (r0 != null) goto L79;
        r0 = "";
    L79:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.c(r12, r0);
    L80:
        if (r36 == null) goto L84;
        String r8 = r36.g;
        if (r8 == null) goto L84;
        r12.put("order_type", r8);
        r12.put("enter_method", "linkmic_karaoke_lottery");
    L84:
        n0(r12, r36);
        ke2.d.a(r36, r12, true);
        we2.a.d(r12, r36, r27);
        h.b(r12);
        j0.l().sendLog("livesdk_anchor_ksong_button_click", r12, new Object[]{IRoom.class, x.class});
        return;
    L66:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L67
    L56:
        if (r34.booleanValue() == false) goto L58;
        String r9 = "1";
    L59:
        r12.put("is_midi", r9);
        goto L60
    L58:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L59
    L43:
        if (r31.length() == 0) goto L46;
        r1 = false;
        goto L47
    L37:
        r4 = false;
        goto L38
    L31:
        r3 = false;
        goto L32
    L22:
        r2 = false;
        goto L23
    L16:
        r13 = false;
        goto L17
    L9:
        r14 = false;
        goto L11
    L5:
        r12 = r30;
        goto L6
    }

    public static void Z(String r17, String r18, String r19, long r20, String r22, String r23, HashMap r24, String r25, boolean r26, boolean r27, String r28, String r29, Boolean r30, boolean r31, Boolean r32, boolean r33, String r34, MusicPanel r35, String r36, String r37, String r38) {
        Intrinsics.checkNotNullParameter(r17, "fromRequestType");
        Intrinsics.checkNotNullParameter(r18, "userType");
        Intrinsics.checkNotNullParameter(r19, "songName");
        Intrinsics.checkNotNullParameter(r22, "artistId");
        Intrinsics.checkNotNullParameter(r23, "artistName");
        Intrinsics.checkNotNullParameter(r34, "orderUserId");
        Intrinsics.checkNotNullParameter(r38, "chorusTime");
        Map<String, Boolean> r13 = b;
        if (r13.containsKey("livesdk_anchor_ksong_play") == true) goto L79;
        Boolean r15 = Boolean.TRUE;
        r13.put("livesdk_anchor_ksong_play", r15);
        if (r24 != null) goto L7;
        HashMap r14 = new HashMap();
    L8:
        r14.put("from_request_type", r17);
        r14.put("ksong_id", String.valueOf(r20));
        r14.put("song_id", String.valueOf(r20));
        r14.put("function_type", H(j.c()));
        r14.put("user_type", r18);
        r14.put("song_name", r19);
        String r1 = BDLocationException.ERROR_TIMEOUT;
        r14.put("is_camera_open", BDLocationException.ERROR_TIMEOUT);
        r14.put("artist_id", r22);
        r14.put("artist_name", r23);
        if (r37 == null) goto L11;
        r14.put("mv_id", r37);
    L11:
        if (r36 == null) goto L13;
        r14.put("mv_type", r36);
    L13:
        r14.put("live_type", F());
        r14.put("is_play_all", BDLocationException.ERROR_TIMEOUT);
        m0(r14);
        if (r25 == null) goto L16;
        r14.put("enter_from", r25);
    L16:
        if (r35 == null) goto L21;
        String r2 = r35.g;
        if (r2 == null) goto L21;
        r14.put("order_type", r2);
        r14.put("enter_method", "linkmic_karaoke_lottery");
    L21:
        if (r26 == false) goto L23;
        Object r3 = "1";
    L24:
        r14.put("is_original_flag", r3);
        if (r27 == false) goto L27;
        Object r4 = "1";
    L28:
        r14.put("is_play_all", r4);
        o0(r14);
        r14.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        if (r28 == null) goto L31;
        r14.put("ksong_element_source", r28);
    L31:
        if (r29 == null) goto L33;
        r14.put("element_open_method", r29);
    L33:
        if (r30 == null) goto L40;
        if (r30.booleanValue() == false) goto L37;
        Object r0 = "1";
    L38:
        r14.put("is_midi", r0);
        goto L40
    L37:
        r0 = BDLocationException.ERROR_TIMEOUT;
    L40:
        if (Intrinsics.areEqual(r32, r15) == false) goto L42;
        Object r5 = "1";
    L43:
        r14.put("is_score", r5);
        if (r31 == false) goto L46;
        Object r6 = "1";
    L47:
        r14.put("is_original", r6);
        if (r33 == false) goto L50;
        Object r7 = "1";
    L51:
        r14.put("is_earphone", r7);
        IMultiLinkInternalService r8 = k.f(IMultiLinkInternalService.class);
        if (r8 == null) goto L58;
        cg6.a r9 = r8.getMultiLinkComponentService(null, m.i());
        if (r9 == null) goto L58;
        g r10 = r9.getRtcManager();
        if (r10 == null) goto L58;
        int r11 = r10.b();
    L59:
        r14.put("audioRoute", String.valueOf(r11));
        o r12 = m.i();
        if (r12 == null) goto L65;
        com.bytedance.live.datacontext.m r16 = r12.X1();
        if (r16 == null) goto L65;
        if (((Boolean) r16.getValue()).booleanValue() != true) goto L65;
    L71:
        String r21 = "on";
    L73:
        r14.put("earphone_status", r21);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r14);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.c(r14, r34);
        n0(r14, r35);
        ke2.d.a(r35, r14, true);
        Intrinsics.checkNotNullParameter(r14, "logMap");
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L77;
        r1 = "1";
    L77:
        r14.put("is_chorus", r1);
        we2.a.b(r14);
        we2.a.a(r14);
        r14.put("chorus_time", r38);
        h.b(r14);
        j0.l().sendLog("livesdk_anchor_ksong_play", r14, new Object[]{IRoom.class, x.class});
        return;
    L65:
        o r39 = m.i();
        if (r39 == null) goto L72;
        com.bytedance.live.datacontext.m r40 = r39.n2();
        if (r40 == null) goto L72;
        if (((Boolean) r40.getValue()).booleanValue() == true) goto L71;
    L72:
        r21 = "off";
    L58:
        r11 = -1;
        goto L59
    L50:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L51
    L46:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L47
    L42:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L43
    L27:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L28
    L23:
        r3 = BDLocationException.ERROR_TIMEOUT;
        goto L24
    L7:
        r14 = r24;
        goto L8
    }

    public static void a0(String r16, long r17, long r19, String r21, String r22, boolean r23, String r24, boolean r25, String r26, String r27, HashMap r28, int r29, String r30, boolean r31, String r32, boolean r33, String r34, String r35, Boolean r36, Integer r37, boolean r38, Boolean r39, Boolean r40, MusicPanel r41, Integer r42, Integer r43) {
        Intrinsics.checkNotNullParameter(r16, "fromRequestType");
        Intrinsics.checkNotNullParameter(r21, "userType");
        Intrinsics.checkNotNullParameter(r22, "songName");
        Intrinsics.checkNotNullParameter(r24, "endType");
        Intrinsics.checkNotNullParameter(r26, "artistId");
        Intrinsics.checkNotNullParameter(r27, "artistName");
        Intrinsics.checkNotNullParameter(r30, "echoType");
        Intrinsics.checkNotNullParameter("", "orderUserIdString");
        Map<String, Boolean> r12 = b;
        if (r12.containsKey("livesdk_anchor_ksong_play") == false) goto L100;
        r12.remove("livesdk_anchor_ksong_play");
        if (r28 != null) goto L7;
        HashMap r13 = new HashMap();
    L8:
        r13.put("from_request_type", r16);
        r13.put("ksong_id", String.valueOf(r17));
        r13.put("song_id", String.valueOf(r17));
        if (r43 == null) goto L13;
        String r0 = String.valueOf(r43.intValue());
        if (r0 == null) goto L13;
        r13.put("user_mv_used", r0);
    L13:
        if (r42 == null) goto L17;
        String r1 = String.valueOf(r42.intValue());
        if (r1 == null) goto L17;
        r13.put("recommend_mv_used", r1);
    L17:
        r13.put("duration", String.valueOf(r19));
        r13.put("end_type", r24);
        r13.put("function_type", H(j.c()));
        r13.put("user_type", r21);
        r13.put("song_name", r22);
        String r2 = BDLocationException.ERROR_TIMEOUT;
        if (r23 == false) goto L20;
        Object r3 = "1";
    L21:
        r13.put("is_full", r3);
        if (r40 != null) goto L24;
    L28:
        if (r41 == null) goto L32;
        String r4 = r41.g;
        if (r4 == null) goto L32;
        r13.put("order_type", r4);
        r13.put("enter_method", "linkmic_karaoke_lottery");
    L32:
        if (r25 == false) goto L34;
        Object r5 = "1";
    L35:
        r13.put("original_switch_used", r5);
        r13.put("artist_id", r26);
        r13.put("artist_name", r27);
        r13.put("live_type", F());
        r13.put("earphone_used", String.valueOf(r29));
        r13.put("earphone_type", r30);
        r13.put("is_support_earphone", String.valueOf(r31));
        m0(r13);
        if (r32 == null) goto L38;
        r13.put("enter_from", r32);
    L38:
        if (r33 == false) goto L40;
        Object r6 = "1";
    L41:
        r13.put("is_original_flag", r6);
        o0(r13);
        r13.put("function_type2", k.n(IInteractService.class).getFunctionType2());
        if (r34 == null) goto L44;
        r13.put("ksong_element_source", r34);
    L44:
        if (r35 == null) goto L46;
        r13.put("element_open_method", r35);
    L46:
        if (r36 != null) goto L48;
    L52:
        r13.put("midi_score", "");
        if (r37 == null) goto L55;
        r13.put("midi_score", String.valueOf(r37.intValue()));
    L55:
        if (r38 == false) goto L57;
        Object r7 = "1";
    L58:
        r13.put("is_original_used", r7);
        Boolean r8 = Boolean.TRUE;
        if (Intrinsics.areEqual(r39, r8) == false) goto L61;
        Object r9 = "1";
    L62:
        r13.put("is_score", r9);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.b(r13);
        com.bytedance.android.livesdk.ktvimpl.chorus.c.c(r13, "");
        if (Intrinsics.areEqual(r40, r8) == false) goto L65;
        Object r10 = "1";
    L66:
        r13.put("is_play_all", r10);
        if (ne2.a.a() == false) goto L94;
        KtvChallengeDataContext.a r11 = KtvChallengeDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r14 = r11.a();
        Long r15 = null;
        if (r14 == null) goto L73;
        me2.a r18 = r14.getChallengeConfig();
        if (r18 == null) goto L73;
        Integer r20 = Integer.valueOf(r18.f);
    L74:
        r13.put("goal_type", C(r20));
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r44 = r11.a();
        if (r44 == null) goto L79;
        me2.a r45 = r44.getChallengeConfig();
        if (r45 == null) goto L79;
        Long r46 = Long.valueOf(r45.d);
    L80:
        if (r46 == null) goto L83;
        String r47 = String.valueOf(r46.longValue());
        if (r47 == null) goto L83;
    L84:
        r13.put("play_time", r47);
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.a r48 = r11.a();
        if (r48 == null) goto L89;
        me2.a r49 = r48.getChallengeConfig();
        if (r49 == null) goto L89;
        r15 = Long.valueOf(r49.c);
    L89:
        if (r15 == null) goto L92;
        String r50 = String.valueOf(r15.longValue());
        if (r50 == null) goto L92;
    L93:
        r13.put("goal", r50);
    L92:
        r50 = BDLocationException.ERROR_TIMEOUT;
    L83:
        r47 = BDLocationException.ERROR_TIMEOUT;
    L79:
        r46 = null;
    L73:
        r20 = null;
    L94:
        n0(r13, r41);
        ke2.d.a(r41, r13, true);
        Intrinsics.checkNotNullParameter(r13, "logMap");
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().isCurrentUserIsSinger() == true) goto L98;
        r2 = "1";
    L98:
        r13.put("is_chorus", r2);
        we2.a.b(r13);
        we2.a.a(r13);
        h.b(r13);
        j0.l().sendLog("livesdk_anchor_ksong_play_duration", r13, new Object[]{IRoom.class, x.class});
        return;
    L65:
        r10 = BDLocationException.ERROR_TIMEOUT;
        goto L66
    L61:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L62
    L57:
        r7 = BDLocationException.ERROR_TIMEOUT;
        goto L58
    L48:
        if (r36.booleanValue() == false) goto L50;
        Object r51 = "1";
    L51:
        r13.put("is_midi", r51);
        goto L52
    L50:
        r51 = BDLocationException.ERROR_TIMEOUT;
        goto L51
    L40:
        r6 = BDLocationException.ERROR_TIMEOUT;
        goto L41
    L34:
        r5 = BDLocationException.ERROR_TIMEOUT;
        goto L35
    L24:
        if (r40.booleanValue() == false) goto L26;
        Object r52 = "1";
    L27:
        r13.put("is_play_all", r52);
        goto L28
    L26:
        r52 = BDLocationException.ERROR_TIMEOUT;
        goto L27
    L20:
        r3 = BDLocationException.ERROR_TIMEOUT;
        goto L21
    L7:
        r13 = r28;
        goto L8
    }
}
