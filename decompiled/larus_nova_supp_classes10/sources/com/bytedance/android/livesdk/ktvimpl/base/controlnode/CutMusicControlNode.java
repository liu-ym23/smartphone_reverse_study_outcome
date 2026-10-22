package com.bytedance.android.livesdk.ktvimpl.base.controlnode;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.ktv.common.karaokestation.model.g;
import com.bytedance.android.live.ktv.common.music.control.IMusicControlNode;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvModeOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.Disposable;
import jc1.k;
import kg6.e;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class CutMusicControlNode extends com.bytedance.android.live.ktv.common.music.control.c {
    public final void h() {
        boolean r1 = true;
        if (KtvUtilsKt.g() == false) goto L5;
        Lazy r0 = KtvSettingHelper.a;
        boolean r2 = true;
    L6:
        qd0.a r3 = k.n(IInteractService.class).getAudioTalkService();
        if (r2 == true) goto L9;
        r1 = r3.L();
    L22:
        if (j.i() == true) goto L37;
        if (r1 == true) goto L25;
        return;
    L25:
        if (((com.bytedance.android.live.ktv.common.music.control.c) this).h == false) goto L39;
        if (r2 == false) goto L34;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r4 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r4 == null) goto L35;
        jg6.a r5 = r4.getAdminStatusCenter();
        if (r5 == null) goto L35;
        e r6 = r5.b();
        if (r6 == null) goto L35;
        r6.u(false, "singer cut music");
    L35:
        ((com.bytedance.android.live.ktv.common.music.control.c) this).h = false;
        return;
    L34:
        r3.muteLocalAudio(false);
        goto L35
    L39:
        return;
    L37:
        return;
    L9:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L19;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r7 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r7 == null) goto L19;
        jg6.a r8 = r7.getAdminStatusCenter();
        if (r8 == null) goto L19;
        e r9 = r8.b();
        if (r9 == null) goto L19;
        if (r9.q() == true) goto L22;
    L19:
        r1 = false;
        goto L22
    L5:
        r2 = false;
        goto L6
    }

    public /* synthetic */ CutMusicControlNode(MusicPanel r3) {
        this(r3, true, ModeType.KTV_MODE);
    }

    public static OrderedSongDataContext j(CutMusicControlNode r1) {
        KtvContext.Companion.getClass();
        boolean r0 = KtvContext.a.g().isKtvMode();
        r1.getClass();
        if (r0 == false) goto L6;
        return KtvModeOrderedSongDataContext.Companion.getContext();
    L6:
        return KtvComponentOrderedSongDataContext.Companion.getContext();
    }

    public static boolean k(KtvMusic r1) {
        String r0 = k.n(IMiddlewareUserService.class).user().n().toString();
        if (r1 == null) goto L10;
        OrderInfo r2 = r1.getOrderInfo();
        if (r2 == null) goto L10;
        InteractiveSongUserInfo r3 = r2.getTopUser();
        if (r3 == null) goto L10;
        String r4 = r3.getIdString();
        if (r4 == null) goto L10;
    L12:
        return Intrinsics.areEqual(r0, r4);
    L10:
        r4 = "";
        goto L12
    }

    public final void e(final MusicPanel r21) {
        Intrinsics.checkNotNullParameter(r21, "musicPanel");
        if (((com.bytedance.android.live.ktv.common.music.control.c) this).g != null) goto L6;
        f(r21);
        return;
    L6:
        boolean r3 = true;
        if (KtvUtilsKt.g() == false) goto L9;
        Lazy r2 = KtvSettingHelper.a;
        boolean r4 = true;
    L10:
        qd0.a r5 = k.n(IInteractService.class).getAudioTalkService();
        if (r4 == true) goto L13;
        boolean r6 = r5.L();
    L26:
        if (j.i() == false) goto L28;
    L42:
        OrderedSongDataContext r7 = j(this);
        if (r7 == null) goto L47;
        MusicPanel r8 = r7.getKtvPublicSecondOrderedSong();
        if (r8 == null) goto L47;
        KtvMusic r9 = r8.a;
    L49:
        if (k(r9) == false) goto L51;
    L65:
        long r10 = System.currentTimeMillis();
        pd2.d.y(r21.a.getMId(), "start_cut");
        int r11 = g.a;
        g r12 = g.b.a;
        o r13 = ((com.bytedance.android.live.ktv.common.music.control.c) this).g;
        if (r13 == null) goto L72;
        m r14 = r13.getRoom();
        if (r14 == null) goto L72;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L72;
        long r16 = r15.getId();
    L73:
        o r17 = ((com.bytedance.android.live.ktv.common.music.control.c) this).g;
        if (r17 == null) goto L80;
        m r18 = r17.getRoom();
        if (r18 == null) goto L80;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L80;
        long r110 = r19.getId();
    L81:
        long r111 = r21.a.getMId();
        OrderInfo r20 = r21.a.getOrderInfo();
        if (r20 == null) goto L87;
        InteractiveSongUserInfo r22 = r20.getTopUser();
        if (r22 == null) goto L87;
        String r23 = r22.getIdString();
        if (r23 == null) goto L87;
    L88:
        Disposable r1 = r12.e(r10, r16, r110, r111, r23, true, r21.a.getSongType(), com.bytedance.android.live.ktv.common.util.KtvUtilsKt.i(r21), new CutMusicControlNode$cutMusic$1(this, r21), new CutMusicControlNode$cutMusic$2(this, r21));
        if (r1 == null) goto L92;
        RxUtilKt.c(r1, ((com.bytedance.android.live.ktv.common.music.control.d) this).a);
        return;
    L92:
        return;
    L87:
        r23 = "";
    L80:
        r110 = 0;
    L72:
        r16 = 0;
        goto L73
    L51:
        if (KtvUtilsKt.g() == false) goto L60;
        Lazy r24 = KtvSettingHelper.a;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L59;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r25 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r25 == null) goto L59;
        if (r25.ktvWillAutoSilenceSelf() != true) goto L59;
    L61:
        if (r3 == true) goto L65;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.v() == true) goto L65;
        f2.b(2131918560, 0);
    L59:
        r3 = false;
        goto L61
    L60:
        r3 = k.n(IInteractService.class).getAudioTalkService().ktvWillAutoSilenceSelf();
    L47:
        r9 = null;
        goto L49
    L28:
        if (k(((com.bytedance.android.live.ktv.common.music.control.d) this).d.a) == false) goto L42;
        if (r6 == true) goto L42;
        if (r4 == true) goto L32;
        r5.muteLocalAudio(true);
    L41:
        ((com.bytedance.android.live.ktv.common.music.control.c) this).h = true;
        goto L42
    L32:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L41;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r26 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r26 == null) goto L41;
        jg6.a r27 = r26.getAdminStatusCenter();
        if (r27 == null) goto L41;
        e r28 = r27.b();
        if (r28 == null) goto L41;
        r28.u(true, "singer cut music");
        goto L41
    L13:
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0 == null) goto L23;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r29 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r29 == null) goto L23;
        jg6.a r30 = r29.getAdminStatusCenter();
        if (r30 == null) goto L23;
        e r31 = r30.b();
        if (r31 == null) goto L23;
        if (r31.q() != true) goto L23;
        r6 = true;
    L23:
        r6 = false;
        goto L26
    L9:
        r4 = false;
        goto L10
    }

    public final void g(final MusicPanel r21) {
        Intrinsics.checkNotNullParameter(r21, "musicPanel");
        if (((com.bytedance.android.live.ktv.common.music.control.c) this).g != null) goto L6;
        f(r21);
        return;
    L6:
        pd2.d.y(r21.a.getMId(), "start_cut");
        long r6 = System.currentTimeMillis();
        OrderedSongDataContext r2 = j(this);
        if (r2 == null) goto L11;
        MusicPanel r3 = r2.getKtvPublicFirstOrderedSong();
        if (r3 == null) goto L11;
        final boolean r4 = com.bytedance.android.live.ktv.common.util.KtvUtilsKt.u(r3, r21);
    L12:
        int r5 = g.a;
        g r7 = g.b.a;
        o r8 = ((com.bytedance.android.live.ktv.common.music.control.c) this).g;
        long r9 = 0;
        if (r8 == null) goto L19;
        m r10 = r8.getRoom();
        if (r10 == null) goto L19;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L19;
        long r12 = r11.getId();
    L20:
        o r13 = ((com.bytedance.android.live.ktv.common.music.control.c) this).g;
        if (r13 == null) goto L27;
        m r14 = r13.getRoom();
        if (r14 == null) goto L27;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L27;
        r9 = r15.getId();
    L27:
        long r16 = r9;
        long r17 = r21.a.getMId();
        OrderInfo r18 = r21.a.getOrderInfo();
        if (r18 == null) goto L33;
        InteractiveSongUserInfo r19 = r18.getTopUser();
        if (r19 == null) goto L33;
        String r20 = r19.getIdString();
        if (r20 == null) goto L33;
    L34:
        Disposable r1 = r7.e(r6, r12, r16, r17, r20, false, r21.a.getSongType(), com.bytedance.android.live.ktv.common.util.KtvUtilsKt.i(r21), new CutMusicControlNode$removeMusic$1(this, r21, r4), new CutMusicControlNode$removeMusic$2(this, r21));
        if (r1 == null) goto L38;
        RxUtilKt.c(r1, ((com.bytedance.android.live.ktv.common.music.control.d) this).a);
        return;
    L38:
        return;
    L33:
        r20 = "";
    L19:
        r12 = 0;
    L11:
        r4 = false;
        goto L12
    }

    public static final void i(CutMusicControlNode r3, MusicPanel r4) {
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "panel");
        Disposable r0 = ((com.bytedance.android.live.ktv.common.music.control.d) r3).b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        com.bytedance.android.live.ktv.common.music.control.g r1 = ((com.bytedance.android.live.ktv.common.music.control.d) r3).c;
        if (r1 == null) goto L8;
        r1.b(new IMusicControlNode.b(r3.getType(), r4), r3);
    L8:
        r3.h();
    }

    public CutMusicControlNode(MusicPanel r2, boolean r3, ModeType r4) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "modeType");
        super(r2, r3, r4);
    }
}
