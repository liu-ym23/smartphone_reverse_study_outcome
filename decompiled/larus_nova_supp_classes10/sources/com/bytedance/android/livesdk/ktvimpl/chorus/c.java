package com.bytedance.android.livesdk.ktvimpl.chorus;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.model.ChorusInfo;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c {
    public static final b a = null;

    static {
        a = new b();
    }

    public static void d() {
        a.a = System.currentTimeMillis();
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = ke2.b.a;
        ke2.b.j(r0);
        Long r2 = KtvLoggerHelper.a;
        KtvLoggerHelper.o0(r0);
        KtvLoggerHelper.k0(r0);
        o r3 = m.i();
        if (r3 == null) goto L10;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L10;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L10;
        String r6 = r5.getOwnerUserIdString();
        if (r6 == null) goto L10;
    L11:
        ChorusContext r7 = ChorusContext.Companion.getContext();
        if (r7 == null) goto L20;
        j<ChorusViewModel> r8 = r7.getChorusViewModel();
        if (r8 == null) goto L20;
        ChorusViewModel r9 = (ChorusViewModel) r8.getValue();
        if (r9 == null) goto L20;
        MutableLiveData<ChorusInfo> r10 = r9.getChorusInfo();
        if (r10 == null) goto L20;
        ChorusInfo r11 = (ChorusInfo) r10.getValue();
    L21:
        if (r11 != null) goto L23;
    L27:
        r0.put("play_mode", "pk_chorus");
        i0 r12 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.c1(r0);
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch", r0, new Object[]{IRoom.class});
        return;
    L23:
        if (Intrinsics.areEqual(r6, r11.getLeadSingerIdString().toString()) == false) goto L25;
        r0.put("role_type", "leader");
    L26:
        r0.put("chorus_id", String.valueOf(r11.getChorusId()));
        goto L27
    L25:
        r0.put("role_type", "follower");
    L20:
        r11 = null;
    L10:
        r6 = "";
        goto L11
    }

    public static void e() {
        LinkedHashMap r0 = new LinkedHashMap();
        int r1 = ke2.b.a;
        ke2.b.j(r0);
        b r2 = a;
        r0.put("duration", String.valueOf(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - r2.a)));
        o r3 = m.i();
        if (r3 == null) goto L10;
        com.bytedance.live.datacontext.m r4 = r3.getRoom();
        if (r4 == null) goto L10;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L10;
        String r6 = r5.getOwnerUserIdString();
        if (r6 == null) goto L10;
    L11:
        ChorusInfo r7 = r2.b;
        if (r7 != null) goto L14;
    L18:
        r0.put("play_mode", "pk_chorus");
        zi0.d.b(r0, false);
        j0.l().sendLog("livesdk_audience_playmode_room_watch_duration", r0, new Object[]{IRoom.class});
        return;
    L14:
        if (Intrinsics.areEqual(r6, r7.getLeadSingerIdString().toString()) == false) goto L16;
        r0.put("role_type", "leader");
    L17:
        r0.put("chorus_id", String.valueOf(r7.getChorusId()));
        goto L18
    L16:
        r0.put("role_type", "follower");
    L10:
        r6 = "";
        goto L11
    }

    public static void a(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        o r0 = m.i();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L10;
        String r4 = r2.getOwnerUserIdString();
        if (r4 == null) goto L10;
    L11:
        ChorusContext r5 = ChorusContext.Companion.getContext();
        if (r5 == null) goto L20;
        j<ChorusViewModel> r6 = r5.getChorusViewModel();
        if (r6 == null) goto L20;
        ChorusViewModel r7 = (ChorusViewModel) r6.getValue();
        if (r7 == null) goto L20;
        MutableLiveData<ChorusInfo> r8 = r7.getChorusInfo();
        if (r8 == null) goto L20;
        ChorusInfo r9 = (ChorusInfo) r8.getValue();
    L21:
        if (r9 != null) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(r4, r9.getLeadSingerIdString().toString()) == false) goto L25;
        r3.put("role_type", "leader");
    L26:
        r3.put("chorus_id", String.valueOf(r9.getChorusId()));
        return;
    L25:
        r3.put("role_type", "follower");
    L20:
        r9 = null;
    L10:
        r4 = "";
        goto L11
    }

    public static void b(Map r3) {
        Intrinsics.checkNotNullParameter(r3, "logMap");
        o r0 = m.i();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.m r1 = r0.getRoom();
        if (r1 == null) goto L10;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L10;
        String r4 = r2.getOwnerUserIdString();
        if (r4 == null) goto L10;
    L11:
        ChorusContext.a r5 = ChorusContext.Companion;
        if (r5.c() == false) goto L29;
        ChorusContext r6 = r5.getContext();
        if (r6 == null) goto L22;
        j<ChorusViewModel> r7 = r6.getChorusViewModel();
        if (r7 == null) goto L22;
        ChorusViewModel r8 = (ChorusViewModel) r7.getValue();
        if (r8 == null) goto L22;
        MutableLiveData<ChorusInfo> r9 = r8.getChorusInfo();
        if (r9 == null) goto L22;
        ChorusInfo r10 = (ChorusInfo) r9.getValue();
    L23:
        if (r10 != null) goto L25;
        return;
    L25:
        if (Intrinsics.areEqual(r4, r10.getLeadSingerIdString().toString()) == false) goto L27;
        r3.put("role_type", "leader");
        return;
    L27:
        r3.put("role_type", "follower");
        return;
    L22:
        r10 = null;
        goto L23
    L29:
        return;
    L10:
        r4 = "";
        goto L11
    }

    public static void c(Map r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "logMap");
        Intrinsics.checkNotNullParameter(r2, "orderUserId");
        ChorusContext r0 = ChorusContext.Companion.getContext();
        if (r0 == null) goto L11;
        j<ChorusViewModel> r3 = r0.getChorusViewModel();
        if (r3 == null) goto L11;
        ChorusViewModel r4 = (ChorusViewModel) r3.getValue();
        if (r4 == null) goto L11;
        MutableLiveData<ChorusInfo> r5 = r4.getChorusInfo();
        if (r5 == null) goto L11;
        ChorusInfo r6 = (ChorusInfo) r5.getValue();
    L12:
        if (r6 != null) goto L14;
        return;
    L14:
        if (Intrinsics.areEqual(r2, r6.getLeadSingerIdString()) == false) goto L16;
        r1.put("song_type", "leader");
        return;
    L16:
        r1.put("song_type", "follower");
        return;
    L11:
        r6 = null;
        goto L12
    }
}
