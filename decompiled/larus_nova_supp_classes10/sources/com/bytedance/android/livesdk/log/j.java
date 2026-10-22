package com.bytedance.android.livesdk.log;

import android.os.SystemClock;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.q2;
import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.x6;
import com.bytedance.android.livesdk.chatroom.utils.VrUtils;
import com.bytedance.android.livesdk.landscapeslide.LiveLandSlideContext;
import com.bytedance.android.livesdk.landscapeslide.PreRoomInfoContext;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.room.RoomBaseSession;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.PreviewLandScapeUtils;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j {
    public long a;
    public long b;
    public boolean c;
    public long d;
    public long e;
    public long f;
    public long g;
    public final DataCenter h;
    public final boolean i;

    public final void d() {
        if (this.a <= 0) goto L8;
        if (this.c == false) goto L8;
        this.b += SystemClock.elapsedRealtime() - this.a;
        this.a = 0;
    L8:
        if (this.e > 0) goto L10;
        return;
    L10:
        if (this.c == false) goto L14;
        this.d += SystemClock.elapsedRealtime() - this.e;
        this.e = 0;
        return;
    }

    public final void f() {
        if (this.a <= 0) goto L6;
        d();
    L6:
        if (this.b > 0) goto L8;
        return;
    L8:
        if (this.i == false) goto L21;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        if (r0 == null) goto L12;
        Room r1 = r0.getVsRoom();
    L14:
        if (q2.b(r1) == true) goto L17;
        this.a = 0;
        this.b = 0;
        return;
    L17:
        g r2 = u.l();
        HashMap r11 = new HashMap();
        r11.put("duration", String.valueOf(this.b));
        r11.put("vr_type", VrUtils.n());
        r11.put("is_vr_machine", VrUtils.o(this.h));
        nm1.m r6 = pm1.f.l();
        if (r6 == null) goto L20;
        r6.x(this.h, r11);
    L20:
        Unit r7 = Unit.INSTANCE;
        r2.sendLog("live_machine_play_time", r11, new Object[]{new am2.x(), Room.class, am2.u.class});
    L30:
        if (this.i == true) goto L32;
        b(null);
    L32:
        this.a = 0;
        this.b = 0;
        return;
    L12:
        r1 = null;
        goto L14
    L21:
        RoomContext r3 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        if (r3 == null) goto L30;
        if (r3.isVSRoom() != true) goto L30;
        g r4 = u.l();
        HashMap r12 = new HashMap();
        r12.put("duration", String.valueOf(this.b));
        r12.put("vr_type", VrUtils.n());
        r12.put("is_vr_machine", VrUtils.o(this.h));
        nm1.m r8 = pm1.f.l();
        if (r8 == null) goto L28;
        r8.x(this.h, r12);
    L28:
        Unit r9 = Unit.INSTANCE;
        r4.sendLog("livesdk_live_duration_all_reject_pause", r12, new Object[]{new am2.x(), Room.class, am2.u.class});
        goto L30
    }

    public final void e() {
        long r0 = SystemClock.elapsedRealtime();
        this.a = r0;
        this.e = r0;
    }

    public final void b(Integer r9) {
        if (this.e <= 0) goto L8;
        if (this.c == false) goto L8;
        long r0 = SystemClock.elapsedRealtime();
        this.d += r0 - this.e;
        this.e = r0;
    L8:
        if (this.d <= 0) goto L23;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        if (r1 != null) goto L12;
    L14:
        if (r9 == null) goto L19;
        if (r9.intValue() != 0) goto L19;
    L20:
        c(x6.b(null), -1);
    L21:
        this.f = 0;
        this.d = 0;
        return;
    L19:
        if (e5.n() == false) goto L21;
    L12:
        if (r1.isVSLive() != true) goto L14;
        g r10 = u.l();
        HashMap r2 = new HashMap();
        r2.put("duration", String.valueOf(this.d));
        Unit r5 = Unit.INSTANCE;
        r10.sendLog("livesdk_live_landscape_and_portrait_play_duration", r2, new Object[]{new am2.x(), Room.class});
        goto L21
    }

    public j(DataCenter r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.h = r2;
        this.i = r3;
    }

    public final void c(String r9, int r10) {
        if (this.e > 0) goto L5;
    L7:
        long r0 = this.d;
        long r4 = this.f;
        long r1 = r0 - r4;
        this.f = r4 + r1;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        Long r3 = null;
        if (r2 == null) goto L14;
        com.bytedance.live.datacontext.m r5 = r2.getRoom();
        if (r5 == null) goto L14;
        Room r6 = (Room) r5.getValue();
        if (r6 == null) goto L14;
        Long r7 = Long.valueOf(r6.getRoomId());
    L15:
        LiveLandSlideContext.Companion.getClass();
        LiveLandSlideContext r8 = LiveLandSlideContext.a.a();
        if (r8 == null) goto L18;
        r3 = Long.valueOf(r8.getInitRoomId());
    L18:
        boolean r11 = !Intrinsics.areEqual(r7, r3);
        if (r10 == (-1)) goto L21;
    L24:
        Pair[] r12 = new Pair[4];
        r12[0] = TuplesKt.to("duration", String.valueOf(r1));
        r12[1] = TuplesKt.to("picture_type", r9);
        if (x6.e == false) goto L27;
        String r13 = "1";
    L28:
        r12[2] = TuplesKt.to("is_hand_big", r13);
        r12[3] = TuplesKt.to("is_sandwich", String.valueOf(r10));
        Map r14 = MapsKt.mapOf(r12);
        PreRoomInfoContext.Companion.getClass();
        a("livesdk_picture_fit_live_duration", r11, MapsKt.plus(r14, PreRoomInfoContext.a.c()));
        return;
    L27:
        r13 = BDLocationException.ERROR_TIMEOUT;
        goto L28
    L21:
        if (x6.f() == false) goto L23;
        r10 = 1;
        goto L24
    L23:
        r10 = 0;
    L14:
        r7 = null;
        goto L15
    L5:
        if (this.c == false) goto L7;
        long r15 = SystemClock.elapsedRealtime();
        this.d += r15 - this.e;
        this.e = r15;
        goto L7
    }

    public final void a(String r19, boolean r20, Map<String, String> r21) {
        String r1 = r21.get("is_support_landscape");
        String r2 = BDLocationException.ERROR_TIMEOUT;
        if (Intrinsics.areEqual(r1, BDLocationException.ERROR_TIMEOUT) == false) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.log.filter.o r3 = u.l().c(am2.x.class);
        RoomContext r4 = RoomContext.a.c(RoomContext.Companion, this.h, 0, 2);
        if (r4 == null) goto L10;
        com.bytedance.live.datacontext.m r5 = r4.getRoom();
        if (r5 == null) goto L10;
        Room r6 = (Room) r5.getValue();
    L11:
        IUserService r9 = jc1.k.f(IUserService.class);
        if (r9 == null) goto L16;
        com.bytedance.android.livesdk.user.f r10 = r9.user();
        if (r10 == null) goto L16;
        String r11 = r10.n();
    L17:
        String r12 = r3.getMap().get("action_type");
        if (r12 != null) goto L20;
    L28:
        r12 = "switch";
    L29:
        ILivePlayerClient r14 = LivePlatformPlayerManager.f();
        if (r14 == null) goto L34;
        ILivePlayerExtraRenderController r15 = r14.extraRenderController();
        if (r15 == null) goto L34;
        Integer r16 = Integer.valueOf(r15.getGameLayoutType());
    L36:
        if (r16 != null) goto L39;
    L41:
        if (r16 != null) goto L44;
    L46:
        if (r16 != null) goto L49;
    L51:
        if (r16 != null) goto L54;
    L56:
        String r7 = "customize";
    L57:
        com.bytedance.android.livesdk.log.filter.o r8 = u.l().c(Room.class);
        Pair[] r17 = new Pair[13];
        r17[0] = TuplesKt.to("user_id", r11);
        if (r6 == null) goto L60;
        String r13 = r6.getIdStr();
    L61:
        r17[1] = TuplesKt.to("room_id", r13);
        if (r6 == null) goto L64;
        String r18 = r6.getOwnerUserIdString();
    L65:
        r17[2] = TuplesKt.to("anchor_id", r18);
        r17[3] = TuplesKt.to("enter_method", r3.getMap().get("enter_method"));
        r17[4] = TuplesKt.to("enter_from_merge", r3.getMap().get("enter_from_merge"));
        if (r6 == null) goto L68;
        LiveMode r22 = r6.getStreamType();
    L69:
        int r23 = h1.a;
        r17[5] = TuplesKt.to("live_type", i1.a(r22));
        r17[6] = TuplesKt.to("action_type", r3.getMap().get("action_type"));
        r17[7] = TuplesKt.to("enter_type", r12);
        if (r20 == false) goto L72;
        r2 = "1";
    L72:
        r17[8] = TuplesKt.to("is_landscape_stream", r2);
        if (r8 == null) goto L78;
        Map<String, String> r24 = r8.getMap();
        if (r24 == null) goto L78;
        String r25 = r24.get("request_id");
        if (r25 == null) goto L78;
    L79:
        r17[9] = TuplesKt.to("request_id", r25);
        if (r6 == null) goto L82;
        int r26 = r6.isGameRoom();
    L83:
        r17[10] = TuplesKt.to("is_game_live", String.valueOf(r26));
        if (r6 == null) goto L86;
        long r110 = r6.getGameTagId();
    L87:
        r17[11] = TuplesKt.to("game_tag_id", String.valueOf(r110));
        r17[12] = TuplesKt.to("model_type", r7);
        Map<String, String> r27 = MapsKt.mutableMapOf(r17);
        if (r6 != null) goto L90;
    L92:
        r27.putAll(r21);
        u.l().sendLog(r19, r27, new Object[0]);
        return;
    L90:
        if (r6.isMergeVSRoom() != true) goto L92;
        r27.put("is_vs", "1");
        int r28 = ju2.f.M;
        r27.putAll(ju2.f.a.a(r6).b());
        goto L92
    L86:
        r110 = 0;
        goto L87
    L82:
        r26 = 0;
    L78:
        r25 = "";
        goto L79
    L68:
        r22 = null;
        goto L69
    L64:
        r18 = null;
        goto L65
    L60:
        r13 = null;
        goto L61
    L54:
        if (r16.intValue() != 4) goto L56;
        r7 = "cam_temp_split";
        goto L57
    L49:
        if (r16.intValue() != 3) goto L51;
        r7 = "cam_temp_floating";
        goto L57
    L44:
        if (r16.intValue() != 2) goto L46;
        r7 = "cam_temp_left_right";
        goto L57
    L39:
        if (r16.intValue() != 1) goto L41;
        r7 = "cam_temp_small";
    L34:
        r16 = null;
        goto L36
    L20:
        if (Intrinsics.areEqual(r12, "draw") == false) goto L23;
        if (r20 == false) goto L23;
        boolean r111 = true;
    L24:
        if (r111 == true) goto L27;
        r12 = null;
    L27:
        if (r12 != null) goto L29;
    L23:
        r111 = false;
    L16:
        r11 = null;
    L10:
        r6 = null;
        goto L11
    }

    public static void g(j r9, Boolean r10, long r11, int r13) {
        IQuality r1 = null;
        Object r2 = null;
        r1 = null;
        r1 = null;
        r1 = null;
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = 0;
    L8:
        r9.getClass();
        boolean r14 = false;
        if ((SystemClock.elapsedRealtime() - r9.g) <= MonitorLevel.FATAL) goto L11;
        boolean r4 = true;
    L12:
        if (r10 == null) goto L14;
        boolean r12 = r10.booleanValue();
    L15:
        if (r4 == true) goto L17;
        return;
    L17:
        if (r9.i == true) goto L95;
        if (r12 == false) goto L20;
    L21:
        r9.g = SystemClock.elapsedRealtime();
        LiveLandSlideContext.Companion.getClass();
        LiveLandSlideContext r15 = LiveLandSlideContext.a.a();
        if (r15 == null) goto L24;
        int r16 = r15.getRelateRoomIndex();
    L26:
        if (r11 == 0) goto L28;
        HashMap r17 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to("room_id", String.valueOf(r11))});
    L29:
        PreviewLandScapeUtils r18 = PreviewLandScapeUtils.INSTANCE;
        if (r18.getLandscapePlayMob() == false) goto L32;
        r17.put("landscape_click_page", "preview");
        r18.setLandscapePlayMob(false);
    L34:
        if (x6.f() == false) goto L36;
        String r19 = "1";
    L37:
        r17.put("is_sandwich", r19);
        ILivePlayerClient r110 = LivePlatformPlayerManager.f();
        if (r110 == null) goto L87;
        PlayerResolution.PickResult r3 = r110.context().getResolutionResult();
        int r5 = r110.getAutoResolutionState();
        if ((r110 instanceof as0.a) == true) goto L42;
        r110 = null;
    L42:
        as0.a r111 = (as0.a) r110;
        if (r111 == null) goto L61;
        RoomBaseSession r112 = r111.d();
        if (r112 == null) goto L61;
        StreamUrl r113 = r112.getStreamUrl();
        if (r113 == null) goto L61;
        List r114 = r113.qualityList;
        if (r114 == null) goto L61;
        Iterator r115 = r114.iterator();
    L52:
        if (r115.hasNext() == false) goto L60;
        Object r6 = r115.next();
        String r7 = ((IQuality) r6).getSdkKey();
        if (r3 == null) goto L56;
        String r8 = r3.getResultSdkKey();
    L58:
        if (Intrinsics.areEqual(r7, r8) == false) goto L52;
        r2 = r6;
        goto L60
    L56:
        r8 = null;
    L60:
        r1 = (IQuality) r2;
    L61:
        String r116 = "";
        if (r3 == null) goto L65;
        String r20 = r3.getPickStrategy();
        if (r20 == null) goto L65;
    L66:
        r17.put("resolution_strategy", r20);
        if (r3 == null) goto L70;
        String r21 = r3.getResultSdkKey();
        if (r21 == null) goto L70;
    L71:
        r17.put("result_sdk_key", r21);
        if (r3 == null) goto L75;
        String r22 = r3.getShotStrategyId();
        if (r22 == null) goto L75;
    L76:
        r17.put("strategy_info", r22);
        r17.put("auto_resolution_state", String.valueOf(r5));
        if (r1 == null) goto L82;
        String r23 = r1.getName();
        if (r23 == null) goto L82;
        r116 = r23;
    L82:
        r17.put("resolution_ui_name", r116);
        if (r1 == null) goto L85;
        int r117 = r1.getFps();
    L86:
        String r118 = (String) r17.put("resolution_fps", String.valueOf(r117));
        goto L87
    L85:
        r117 = -1;
    L75:
        r22 = "";
    L70:
        r21 = "";
    L65:
        r20 = "";
    L87:
        if (r16 == 0) goto L89;
        r14 = true;
    L89:
        r9.a("livesdk_live_landscape_play", r14, r17);
        return;
    L36:
        r19 = BDLocationException.ERROR_TIMEOUT;
        goto L37
    L32:
        r17.put("landscape_click_page", "live");
        goto L34
    L28:
        r17 = new HashMap();
        goto L29
    L24:
        r16 = 0;
        goto L26
    L20:
        if (PreviewLandScapeUtils.INSTANCE.getLandscapePlayMob() == true) goto L21;
        return;
    L95:
        return;
    L14:
        r12 = e5.n();
        goto L15
    L11:
        r4 = false;
        goto L12
    }
}
