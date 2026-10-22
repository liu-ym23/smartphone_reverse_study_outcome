package com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel;

import android.os.SystemClock;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements com.bytedance.android.live.ui.p {
    public long a;
    public VoiceLiveTheme b;
    public final Map<String, String> c;
    public final boolean d;

    public g(boolean r1) {
        this.d = r1;
        this.c = new LinkedHashMap();
    }

    public final void a(VoiceLiveTheme r14) {
        ((LinkedHashMap) this.c).clear();
        Map<String, String> r0 = this.c;
        String r2 = "dynamic";
        if (this.d == false) goto L13;
        LinkedHashMap r1 = new LinkedHashMap();
        String r11 = r14.imageUri;
        if (r11 != null) goto L7;
        r11 = "";
    L7:
        r1.put("pic_uri", r11);
        r1.put("template_id", String.valueOf(Long.valueOf(r14.id)));
        d(r1, 1);
        int r15 = r14.formatType;
        if (r15 == 1) goto L11;
        if (r15 == 2) goto L12;
        r2 = "";
    L12:
        r1.put("pic_type", r2);
        Long r16 = KtvLoggerHelper.a;
        r1.put("play_mode", KtvLoggerHelper.E());
    L22:
        r0.putAll(r1);
        return;
    L11:
        r2 = "static";
        goto L12
    L13:
        r1 = new LinkedHashMap();
        String r12 = r14.imageUri;
        if (r12 != null) goto L16;
        r12 = "";
    L16:
        r1.put("pic_uri", r12);
        r1.put("template_id", String.valueOf(Long.valueOf(r14.id)));
        d(r1, 1);
        int r17 = r14.formatType;
        if (r17 == 1) goto L20;
        if (r17 == 2) goto L21;
        r2 = "";
    L21:
        r1.put("pic_type", r2);
        Long r18 = KtvLoggerHelper.a;
        r1.put("play_mode", KtvLoggerHelper.E());
        goto L22
    L20:
        r2 = "static";
        goto L21
    }

    public final void onThemeChanged(IVoiceLiveTheme r8) {
        vh7.c r0 = null;
        if (r8 == null) goto L5;
        vh7.c r9 = jm2.a.d((vh7.c) r8);
    L7:
        if ((r9 instanceof VoiceLiveTheme) == false) goto L10;
        r0 = r9;
    L10:
        VoiceLiveTheme r1 = (VoiceLiveTheme) r0;
        boolean r10 = false;
        if (r1 != null) goto L13;
    L33:
        if (r1 == null) goto L36;
        r1.choosing = false;
        return;
    L36:
        return;
    L13:
        if (r1.choosing == true) goto L33;
        if (r1.bgType == 1) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(this.b, r1) == false) goto L22;
        return;
    L22:
        if (this.d == true) goto L25;
        c(r1, r1.bgType, false);
    L28:
        long r5 = 0;
        if (this.a <= 0) goto L31;
        r5 = SystemClock.elapsedRealtime() - this.a;
    L31:
        e(r5, r1, true);
        this.a = SystemClock.elapsedRealtime();
        this.b = r1;
        a(r1);
        return;
    L25:
        if (this.b == null) goto L27;
        r10 = true;
    L27:
        b(r1, r10, r1.bgType);
        goto L28
    L5:
        r9 = null;
        goto L7
    }

    public final void onThemeEnd(IVoiceLiveTheme r8) {
        if (r8 == null) goto L5;
        vh7.c r9 = jm2.a.d((vh7.c) r8);
    L7:
        if ((r9 instanceof VoiceLiveTheme) == true) goto L9;
        r9 = null;
    L9:
        VoiceLiveTheme r10 = (VoiceLiveTheme) r9;
        if (this.a <= 0) goto L12;
        long r1 = SystemClock.elapsedRealtime() - this.a;
    L13:
        e(r1, r10, false);
        this.b = null;
        this.a = 0;
        ((LinkedHashMap) this.c).clear();
        return;
    L12:
        r1 = 0;
        goto L13
    L5:
        r9 = null;
        goto L7
    }

    public final void onThemeStart(IVoiceLiveTheme r4) {
        vh7.c r0 = null;
        if (r4 == null) goto L5;
        vh7.c r5 = jm2.a.d((vh7.c) r4);
    L7:
        if ((r5 instanceof VoiceLiveTheme) == false) goto L10;
        r0 = r5;
    L10:
        VoiceLiveTheme r1 = (VoiceLiveTheme) r0;
        if (r1 != null) goto L13;
        return;
    L13:
        int r6 = r1.bgType;
        boolean r2 = true;
        if (r6 == 1) goto L17;
        return;
    L17:
        if (this.d == true) goto L20;
        c(r1, r6, true);
    L24:
        this.a = SystemClock.elapsedRealtime();
        this.b = r1;
        a(r1);
        return;
    L20:
        if (this.b != null) goto L23;
        r2 = false;
    L23:
        b(r1, r2, r6);
        goto L24
    L5:
        r5 = null;
        goto L7
    }

    public final void d(Map<String, String> r5, int r6) {
        if (r6 != 1) goto L5;
        r5.put("live_type", "voice_live");
        r5.put("function_type", "ktv");
    L20:
        r5.put("function_type2", jc1.k.n(IInteractService.class).getFunctionType2());
        return;
    L5:
        if (r6 != 2) goto L7;
        r5.put("live_type", "voice_live");
        r5.put("function_type", "radio");
        com.bytedance.android.livesdk.chatroom.o r7 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r7 == null) goto L15;
        com.bytedance.live.datacontext.m r8 = r7.getRoom();
        if (r8 == null) goto L15;
        IRoom r9 = (IRoom) r8.getValue();
    L17:
        if (d0.h(r9) == false) goto L20;
        r5.put("function_type", "party");
    L15:
        r9 = null;
        goto L17
    L7:
        if (r6 != 5) goto L20;
        r5.put("live_type", "voice_live");
        r5.put("function_type", "live");
        goto L20
    }

    public final void b(VoiceLiveTheme r7, boolean r8, int r9) {
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L7;
        Room r1 = r0.getCurrentRoom();
        if (r1 == null) goto L7;
        Long r2 = Long.valueOf(r1.getId());
    L8:
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("anchor_id", jc1.k.n(IMiddlewareUserService.class).user().n().toString().toString());
        String r4 = r7.imageUri;
        String r5 = "";
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        r3.put("pic_uri", r4);
        r3.put("template_id", String.valueOf(r7.id));
        if (r8 == false) goto L14;
        String r10 = BDLocationException.ERROR_TIMEOUT;
    L15:
        r3.put("is_default", r10);
        if (r2 != null) goto L18;
        r3.put("event_page", "live_take_page");
    L19:
        r3.put("play_mode", com.bytedance.android.live.liveinteract.utils.w.a());
        int r11 = r7.formatType;
        if (r11 != 1) goto L22;
        r5 = "static";
    L26:
        r3.put("pic_type", r5);
        int r12 = r7.bgType;
        if (r12 != 3) goto L29;
    L31:
        String r13 = "video_live";
    L32:
        r3.put("live_type", r13);
        r3.put("template_id", String.valueOf(r7.id));
        d(r3, r9);
        if (r2 != null) goto L35;
        j0.l().sendLog("livesdk_anchor_theme_select", r3, new Object[0]);
        return;
    L35:
        r3.put("room_id", String.valueOf(r2.longValue()));
        j0.l().sendLog("livesdk_anchor_theme_select", r3, new Object[]{IRoom.class});
        return;
    L29:
        if (r12 == 4) goto L31;
        r13 = "voice_live";
        goto L32
    L22:
        if (r11 != 2) goto L26;
        r5 = "dynamic";
        goto L26
    L18:
        r3.put("event_page", "live_take_detail");
        goto L19
    L14:
        r10 = "1";
    L7:
        r2 = null;
        goto L8
    }

    public final void c(VoiceLiveTheme r17, int r18, boolean r19) {
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("template_id", String.valueOf(r17.id));
        String r2 = r17.imageUri;
        String r4 = "";
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r1.put("pic_uri", r2);
        int r3 = r17.formatType;
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L11;
        r4 = "dynamic";
    L11:
        r1.put("pic_type", r4);
        d(r1, r18);
        r1.put("template_id", String.valueOf(r17.id));
        if (r19 == false) goto L30;
        com.bytedance.android.livesdk.chatroom.o r0 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r0 == null) goto L18;
        com.bytedance.live.datacontext.m r5 = r0.getRoom();
        if (r5 == null) goto L18;
        IRoom r6 = (IRoom) r5.getValue();
    L19:
        if (r6 == null) goto L29;
        z5 r7 = r6.getLinkerDetail();
        if (r7 == null) goto L29;
        List<Long> r8 = r7.getPlayModes();
        if (r8 == null) goto L29;
        if (r8.size() <= 0) goto L29;
        Sequence r9 = SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r8), KtvLiveThemeReporter$getCurrentPlayModesFromRoom$1$filterPlayModes$1.INSTANCE), KtvLiveThemeReporter$getCurrentPlayModesFromRoom$1$filterPlayModes$2.INSTANCE);
        if (SequencesKt.none(r9) == true) goto L29;
        String r10 = SequencesKt.joinToString$default(r9, ",", "[", "]", 0, null, null, 56, null);
    L31:
        r1.put("play_mode", r10);
        j0.l().sendLog("livesdk_live_theme_show", r1, new Object[]{IRoom.class, am2.x.class});
        return;
    L29:
        r10 = "[normal]";
    L18:
        r6 = null;
        goto L19
    L30:
        Long r11 = KtvLoggerHelper.a;
        r10 = KtvLoggerHelper.E();
        goto L31
    L10:
        r4 = "static";
        goto L11
    }

    public final void e(long r9, VoiceLiveTheme r11, boolean r12) {
        if (this.d == false) goto L13;
        if (r9 == 0) goto L27;
        this.c.put("duration", "" + r9);
        Map<String, String> r10 = this.c;
        if (r11 == null) goto L10;
        Long r13 = Long.valueOf(r11.id);
    L11:
        r10.put("template_id", String.valueOf(r13));
        j0.l().sendLog("livesdk_anchor_theme_select_duration", MapsKt.toMap(this.c), new Object[]{IRoom.class, am2.x.class});
        return;
    L10:
        r13 = null;
        goto L11
    L27:
        return;
    L13:
        if (r9 == 0) goto L28;
        Map<String, String> r0 = this.c;
        if (r12 == true) goto L22;
        if (r11 != null) goto L20;
    L23:
        String r14 = "leave";
    L24:
        r0.put("end_type", r14);
        this.c.put("duration", "" + r9);
        j0.l().sendLog("livesdk_live_theme_duration", MapsKt.toMap(this.c), new Object[]{IRoom.class, am2.x.class});
        return;
    L20:
        if (r11.changeByAnchor != true) goto L23;
        r11.changeByAnchor = false;
    L22:
        r14 = "anchor";
        goto L24
    }
}
