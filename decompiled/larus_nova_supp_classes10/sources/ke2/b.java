package ke2;

import am2.x;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.SwitchItemType;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.datacontext.n;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b {
    public static int a;

    public b() {
    }

    static {
    }

    public static void a(String r4) {
        Intrinsics.checkNotNullParameter(r4, "clickType");
        LinkedHashMap r0 = new LinkedHashMap();
        j(r0);
        m(r0);
        l(r0);
        k(r0);
        r0.put("click_type", r4);
        j0.l().sendLog("livesdk_anchor_ksong_popup_click", r0, new Object[]{IRoom.class});
    }

    public static void i(String r4) {
        Intrinsics.checkNotNullParameter(r4, "requestPage");
        LinkedHashMap r0 = new LinkedHashMap();
        j(r0);
        p(r0);
        r0.put("request_page", r4);
        j0.l().sendLog("livesdk_guest_connection_pre_apply", r0, new Object[]{IRoom.class});
    }

    public static void j(Map r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$putCommonParams");
        Intrinsics.checkNotNullParameter(r4, "$this$putRoomId");
        o r0 = m.i();
        String r1 = "";
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r2 = r0.getRoom();
        if (r2 == null) goto L10;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L10;
        String r5 = String.valueOf(r3.getRoomId());
        if (r5 == null) goto L10;
    L11:
        r4.put("room_id", r5);
        Intrinsics.checkNotNullParameter(r4, "$this$putAnchorId");
        o r6 = m.i();
        if (r6 == null) goto L21;
        com.bytedance.live.datacontext.m r7 = r6.getRoom();
        if (r7 == null) goto L21;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L21;
        String r9 = r8.getOwnerUserIdString();
        if (r9 == null) goto L21;
        r1 = r9;
    L21:
        r4.put("anchor_id", r1);
        n(r4);
        return;
    L10:
        r5 = "";
        goto L11
    }

    public static void k(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$putEnterFrom");
        KtvContext.Companion.getClass();
        n<oe2.b> r0 = KtvContext.a.g().getKtvRoomProvider();
        if (r0 == null) goto L18;
        oe2.b r1 = (oe2.b) r0.getValue();
        if (r1 == null) goto L19;
        String r3 = r1.getEnterFrom();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L21;
        r2.put("enter_from", r3);
        return;
    L21:
        return;
    L11:
        r4 = false;
        goto L12
    L19:
        return;
    }

    public static void l(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$putKSongElementOpenMethod");
        KtvContext.Companion.getClass();
        n<oe2.b> r0 = KtvContext.a.g().getKtvRoomProvider();
        if (r0 == null) goto L18;
        oe2.b r1 = (oe2.b) r0.getValue();
        if (r1 == null) goto L19;
        String r3 = r1.a();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L21;
        r2.put("element_open_method", r3);
        return;
    L21:
        return;
    L11:
        r4 = false;
        goto L12
    L19:
        return;
    }

    public static void m(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$putKSongElementOpenSource");
        KtvContext.Companion.getClass();
        n<oe2.b> r0 = KtvContext.a.g().getKtvRoomProvider();
        if (r0 == null) goto L18;
        oe2.b r1 = (oe2.b) r0.getValue();
        if (r1 == null) goto L19;
        String r3 = r1.c();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.length() <= 0) goto L11;
        boolean r4 = true;
    L12:
        if (r4 == true) goto L15;
        r3 = null;
    L15:
        if (r3 == null) goto L21;
        r2.put("ksong_element_source", r3);
        return;
    L21:
        return;
    L11:
        r4 = false;
        goto L12
    L19:
        return;
    }

    public static void n(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$putLiveType");
        r2.put("live_type", j.d());
    }

    public static void o(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$putOrderStatus");
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L14;
        n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L15;
        Boolean r3 = (Boolean) r1.getValue();
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.booleanValue() == false) goto L11;
        String r4 = "on";
    L12:
        r2.put("order_status", r4);
        return;
    L11:
        r4 = "off";
        goto L12
    L15:
        return;
    }

    public static void p(Map r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$putUserType");
        if (j.i() == false) goto L6;
        String r0 = "anchor";
    L9:
        r2.put("user_type", r0);
        return;
    L6:
        if (hd0.c.f().h() == false) goto L8;
        r0 = "guest";
        goto L9
    L8:
        r0 = "user";
        goto L9
    }

    public static void b(String r3, SwitchItemType r4) {
        Intrinsics.checkNotNullParameter(r3, "actionType");
        Intrinsics.checkNotNullParameter(r4, "buttonType");
        LinkedHashMap r1 = new LinkedHashMap();
        j(r1);
        m(r1);
        l(r1);
        k(r1);
        Intrinsics.checkNotNullParameter(r1, "logMap");
        Intrinsics.checkNotNullParameter(r4, "buttonType");
        if (r4 != SwitchItemType.AUDIENCE_SING) goto L6;
        String r5 = "order";
    L15:
        r1.put("button_type", r5);
        r1.put("action_result", r3);
        j0.l().sendLog("livesdk_anchor_ksong_allow_button_click", r1, new Object[]{IRoom.class});
        return;
    L6:
        if (r4 != SwitchItemType.MULTI_CHORUS) goto L9;
        r5 = "chorus";
        goto L15
    L9:
        if (r4 != SwitchItemType.KTV_CHALLENGE) goto L12;
        r5 = "sing_challenge";
        goto L15
    L12:
        if (r4 != SwitchItemType.HIDE_LYRICS_FOR_SUBTITLE) goto L14;
        r5 = "hide";
        goto L15
    L14:
        r5 = "";
        goto L15
    }

    public static void e(String r5, boolean r6) {
        Intrinsics.checkNotNullParameter("open", "lrcAction");
        Intrinsics.checkNotNullParameter(r5, "iconType");
        LinkedHashMap r0 = new LinkedHashMap();
        j(r0);
        p(r0);
        o(r0);
        m(r0);
        r0.put("lrc_action", "open");
        KtvContext.Companion.getClass();
        String r3 = "1";
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L21;
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        if (r1 == null) goto L14;
        n<KtvComponentUIContext> r2 = r1.getKtvComponentUIContext();
        if (r2 == null) goto L14;
        KtvComponentUIContext r4 = (KtvComponentUIContext) r2.getValue();
        if (r4 == null) goto L14;
        MutableLiveData<Boolean> r7 = r4.getScoreOpen();
        if (r7 == null) goto L14;
        Boolean r8 = (Boolean) r7.getValue();
        if (r8 == null) goto L14;
    L16:
        if (r8.booleanValue() == false) goto L18;
        Object r9 = "1";
    L19:
        r0.put("is_score", r9);
    L25:
        r0.put("icon_type", r5);
        if (r6 == false) goto L28;
        Object r10 = "1";
    L29:
        r0.put("is_notification", r10);
        r0.put("is_get_order_info", String.valueOf(a));
        if (KtvContext.a.i() == false) goto L32;
        Object r11 = "1";
    L33:
        r0.put("is_resource_info", r11);
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r12 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r12 == null) goto L42;
        KtvRoomLyricsStateMachineConfig.d r13 = r12.getCurState();
        if (r13 == null) goto L42;
        if ((r13 instanceof KtvRoomLyricsStateMachineConfig.d.c) == true) goto L41;
        r3 = BDLocationException.ERROR_TIMEOUT;
    L41:
        r0.put("is_sing", r3);
    L42:
        j0.l().sendLog("livesdk_audience_ksong_icon_show", r0, new Object[]{IRoom.class});
        return;
    L32:
        r11 = BDLocationException.ERROR_TIMEOUT;
        goto L33
    L28:
        r10 = BDLocationException.ERROR_TIMEOUT;
        goto L29
    L18:
        r9 = BDLocationException.ERROR_TIMEOUT;
    L14:
        r8 = Boolean.FALSE;
        goto L16
    L21:
        if (Intrinsics.areEqual(r5, "score") == false) goto L23;
        Object r14 = "1";
    L24:
        r0.put("is_score", r14);
        goto L25
    L23:
        r14 = BDLocationException.ERROR_TIMEOUT;
        goto L24
    }

    public static void g(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter("music", "playMode");
        LinkedHashMap r0 = new LinkedHashMap();
        j(r0);
        m(r0);
        Long r2 = KtvLoggerHelper.a;
        KtvLoggerHelper.o0(r0);
        KtvLoggerHelper.k0(r0);
        r0.put("play_mode", "music");
        if (r3 == null) goto L5;
        r0.put("function_type", r3);
    L5:
        if (r4 == null) goto L7;
        r0.put("function_type2", r4);
    L7:
        if (r5 == null) goto L9;
        r0.put("source", r5);
    L9:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.a(r0);
        i0 r6 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r0);
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r0, new Object[]{IRoom.class, x.class});
    }

    public static void f(String r3, String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "orderStatus");
        LinkedHashMap r0 = new LinkedHashMap();
        j(r0);
        m(r0);
        Long r1 = KtvLoggerHelper.a;
        KtvLoggerHelper.o0(r0);
        KtvLoggerHelper.k0(r0);
        r0.put("play_mode", "music");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("source", r3);
        r0.put("order_status", r4);
        we2.a.a(r0);
        if (r5 == null) goto L8;
        r0.put("function_type", r5);
    L8:
        if (r6 == null) goto L10;
        r0.put("function_type2", r6);
    L10:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.a(r0);
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_anchor_playmode_open_success", r0, new Object[]{IRoom.class});
    }

    public static void d(String r3, boolean r4, Long r5, Integer r6, int r7) {
        if ((r7 & 8) == 0) goto L6;
        r5 = null;
    L6:
        if ((r7 & 16) == 0) goto L8;
        r6 = null;
    L8:
        Intrinsics.checkNotNullParameter("open", "lrcAction");
        Intrinsics.checkNotNullParameter(r3, "iconType");
        LinkedHashMap r8 = new LinkedHashMap();
        j(r8);
        p(r8);
        o(r8);
        m(r8);
        r8.put("lrc_action", "open");
        String r0 = "1";
        if (r4 == false) goto L11;
        Object r9 = "1";
    L12:
        r8.put("is_score", r9);
        r8.put("icon_type", r3);
        if (r6 == null) goto L15;
        r8.put("song_cnt", String.valueOf(r6.intValue()));
    L15:
        if (r5 == null) goto L17;
        r8.put("order_cnt", String.valueOf(r5.longValue()));
    L17:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r10 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r10 == null) goto L27;
        if (r10.getCurState() == null) goto L27;
        if (KtvContext.a.g().isCurrentUserIsSinger() == false) goto L24;
        Object r11 = "1";
    L25:
        r8.put("is_sing", r11);
        goto L27
    L24:
        r11 = BDLocationException.ERROR_TIMEOUT;
    L27:
        if (KtvContext.a.i() == true) goto L30;
        r0 = BDLocationException.ERROR_TIMEOUT;
    L30:
        r8.put("is_resource_info", r0);
        j0.l().sendLog("livesdk_audience_ksong_icon_click", r8, new Object[]{IRoom.class});
        return;
    L11:
        r9 = BDLocationException.ERROR_TIMEOUT;
        goto L12
    }

    public static void h(long r2, String r4, String r5, String r6, int r7) {
        if ((r7 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 8) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 32) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter("music", "playMode");
        LinkedHashMap r8 = new LinkedHashMap();
        j(r8);
        m(r8);
        Long r1 = KtvLoggerHelper.a;
        KtvLoggerHelper.o0(r8);
        KtvLoggerHelper.k0(r8);
        r8.put("play_mode", "music");
        if (r4 == null) goto L14;
        r8.put("function_type", r4);
    L14:
        if (r5 == null) goto L16;
        r8.put("function_type2", r5);
    L16:
        r8.put("duration", String.valueOf(r2));
        if (r6 == null) goto L19;
        r8.put("source", r6);
    L19:
        com.bytedance.android.livesdk.ktvimpl.chorus.c.a(r8);
        zi0.d.b(r8, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r8, new Object[]{IRoom.class, x.class});
    }

    public static void c(String r3, String r4, long r5, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r4, "orderStatus");
        LinkedHashMap r0 = new LinkedHashMap();
        j(r0);
        m(r0);
        Long r1 = KtvLoggerHelper.a;
        KtvLoggerHelper.o0(r0);
        KtvLoggerHelper.k0(r0);
        r0.put("play_mode", "music");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        r0.put("over_type", r3);
        r0.put("order_status", r4);
        we2.a.a(r0);
        if (r7 == null) goto L8;
        r0.put("function_type", r7);
    L8:
        if (r8 == null) goto L10;
        r0.put("function_type2", r8);
    L10:
        if (r9 == null) goto L12;
        r0.put("ksong_element_source", r9);
    L12:
        r0.put("duration", String.valueOf(r5));
        com.bytedance.android.livesdk.ktvimpl.chorus.c.a(r0);
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_anchor_playmode_over", r0, new Object[]{IRoom.class});
    }
}
