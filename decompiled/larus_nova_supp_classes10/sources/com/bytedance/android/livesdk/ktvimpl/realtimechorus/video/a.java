package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.foundation.IMiddlewareHostApp;
import com.bytedance.android.livesdk.config.m71;
import com.bytedance.android.livesdk.config.s91;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.model.CloseOrderSongDialogSource;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.util.KSongOrderSongUtilKt;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.KtvEarMonitor;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.o;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RTChorusOperateType;
import com.bytedance.android.livesdk.utils.u6;
import com.bytedance.android.livesdkapi.TTLiveServiceMiddleware;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends com.bytedance.android.livesdk.ktvimpl.realtimechorus.a {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.a$a, reason: collision with other inner class name */
    public static final class C0051a {
    }

    static {
    }

    public a(com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r2) {
        Intrinsics.checkNotNullParameter(r2, "chorusEventHandler");
        super(r2);
    }

    public static String d(Boolean r1) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L5;
        return "1";
    L5:
        return BDLocationException.ERROR_TIMEOUT;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.realtimechorus.a
    public final void a(int r9, RTChorusOperateType r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "actionType");
        Intrinsics.checkNotNullParameter(r11, "musicId");
        Intrinsics.checkNotNullParameter(r12, "orderUserId");
        KtvComponentOrderSongDataContext.Companion.getClass();
        KtvComponentOrderSongDataContext r0 = KtvComponentOrderSongDataContext.Companion.d();
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r1 = r0.m58getBusinessOrderSongViewModel();
        if (r1 == null) goto L11;
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d) r1.getValue();
        if (r2 == null) goto L12;
        r2.checkRTChorusPermissionInfoIfNeed(null, r9, r10, null, r11, r12);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void b(String r17, int r18, boolean r19, Context r20) {
        Intrinsics.checkNotNullParameter(r17, "source");
        IMiddlewareUserService r0 = jc1.k.f(IMiddlewareUserService.class);
        if (r0 == null) goto L77;
        com.bytedance.android.livesdk.user.e r1 = r0.user();
        if (r1 == null) goto L78;
        IBaseUser r2 = r1.b();
        if (r2 == null) goto L82;
        IInteractService r3 = jc1.k.f(IInteractService.class);
        Activity r4 = null;
        if (r3 == null) goto L12;
        Boolean r5 = Boolean.valueOf(r3.isLinkerUser(r2));
    L13:
        KtvComponentOrderedSongDataContext r6 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r6 == null) goto L79;
        MusicPanel r7 = r6.getKtvPublicFirstOrderedSong();
        if (r7 != null) goto L19;
        return;
    L19:
        if (Intrinsics.areEqual(gh0.a.c(), je0.d.a()) == true) goto L21;
    L24:
        KSongOrderSongUtilKt.b(r20, CloseOrderSongDialogSource.AUTO);
        if (KtvUtilsKt.j() == false) goto L27;
    L30:
        String r8 = LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL;
    L31:
        String r9 = r8;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r10 = VideoChorusDataContext.Companion.a();
        if (r10 == null) goto L34;
        KtvEarMonitor r11 = r10.g();
    L35:
        KtvMusic.a r12 = KtvMusic.Companion;
        KtvMusic r13 = r7.a;
        r12.getClass();
        String r14 = String.valueOf(KtvMusic.a.a(r13));
        if (r10 == null) goto L40;
        jd2.c r15 = r10.f();
        if (r15 == null) goto L40;
        Number r16 = Float.valueOf(r15.b / 1000.0f);
    L41:
        String r21 = r16.toString();
        if (r10 == null) goto L46;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b r22 = r10.k();
        if (r22 == null) goto L46;
        Boolean r23 = Boolean.valueOf(r22.m());
    L47:
        String r24 = d(r23);
        if (r11 != null) goto L50;
    L52:
        String r25 = BDLocationException.ERROR_TIMEOUT;
    L53:
        String r110 = r25;
        if (r11 == null) goto L56;
        r11.m();
        Boolean r26 = Boolean.FALSE;
    L57:
        String r111 = d(r26);
        if (r11 == null) goto L60;
        Boolean r27 = Boolean.valueOf(r11.l());
    L61:
        String r112 = d(r27);
        if (r11 == null) goto L64;
        Boolean r28 = Boolean.valueOf(r11.k());
    L65:
        String r113 = d(r28);
        if (r11 == null) goto L68;
        Boolean r29 = Boolean.valueOf(r11.j());
    L69:
        o r30 = new o(r9, r14, r21, r24, r110, r111, r112, r113, d(r29), "1");
        int r31 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.a.a;
        Intrinsics.checkNotNullParameter(r30, "params");
        s91 r32 = ((m71) vm2.h.r4.getValue(null, vm2.h.a[276(0x114, float:3.87E-43)])).c();
        String r33 = r32.a();
        String r34 = r32.b();
        u6 r35 = new u6(r33);
        r35.b("url", r34);
        u6 r36 = r35.d("url");
        r36.b("tab_name", r30.a);
        r36.b("total_time", r30.b);
        r36.b("current_time", r30.c);
        r36.b("original_song_checked", r30.d);
        r36.b("headphone_monitor_checked", r30.e);
        r36.b("is_support_ear_monitor", r30.f);
        r36.b("show_network_improvement", r30.g);
        r36.b("show_oppo_headphone_guide", r30.h);
        r36.b("network_improvement_checked", r30.i);
        r36.b("show_playback_controls", r30.j);
        IMiddlewareHostApp r37 = jc1.k.f(IMiddlewareHostApp.class);
        if (r37 == null) goto L72;
        r4 = r37.getTopActivity();
    L72:
        if (r4 == null) goto L80;
        IMiddlewareLiveService r38 = TTLiveServiceMiddleware.getLiveService();
        if (r38 == null) goto L81;
        r38.handleSchema(r4, r35.c());
        return;
    L81:
        return;
    L80:
        return;
    L68:
        r29 = null;
        goto L69
    L64:
        r28 = null;
        goto L65
    L60:
        r27 = null;
        goto L61
    L56:
        r26 = null;
        goto L57
    L50:
        if (r11.h() != true) goto L52;
        r25 = d(Boolean.FALSE);
    L46:
        r23 = null;
    L40:
        r16 = 0L;
        goto L41
    L34:
        r11 = null;
        goto L35
    L27:
        if (gh0.a.d() == true) goto L30;
        r8 = "personal";
        goto L31
    L21:
        if ((!Intrinsics.areEqual(r5, Boolean.TRUE)) == false) goto L24;
        f2.b(2131918276, 0);
        return;
    L79:
        return;
    L12:
        r5 = null;
        goto L13
    L82:
        return;
    L78:
        return;
    }
}
