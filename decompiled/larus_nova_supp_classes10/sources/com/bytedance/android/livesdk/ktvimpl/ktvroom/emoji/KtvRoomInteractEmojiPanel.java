package com.bytedance.android.livesdk.ktvimpl.ktvroom.emoji;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ExceptionUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApi;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomOperate;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.videotalk.themecompetition.ThemedCompetitionContext;
import com.bytedance.android.live.liveinteract.voicechat.VoiceChatMuteManager;
import com.bytedance.android.live.liveinteract.voicechat.emoji.InteractEmojiPanel;
import com.bytedance.android.live.liveinteract.voicechat.emoji.icon.IconFilterFactory;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.k0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.l0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.t0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.u0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.v0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.w0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.interact.model.y;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicInteractEntrance;
import com.bytedance.android.livesdk.chatroom.model.interact.ThemedCompetitionRole;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.g;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.model.ChorusGuestStatus;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.message.model.nd;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fd2.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/emoji/KtvRoomInteractEmojiPanel;", "Lcom/bytedance/android/live/liveinteract/voicechat/emoji/InteractEmojiPanel;", "Lcom/bytedance/android/live/liveinteract/voicechat/VoiceChatMuteManager$a;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvRoomInteractEmojiPanel extends InteractEmojiPanel implements VoiceChatMuteManager.a {
    public static final /* synthetic */ int G = 0;
    public final e F;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ KtvRoomInteractEmojiPanel a;

        public b(KtvRoomInteractEmojiPanel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dialog");
            r3.dismiss();
            VoiceChatMuteManager.a r5 = this.a;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r5);
        L17:
            KtvRoomInteractEmojiPanel r7 = this.a;
            int r8 = KtvRoomInteractEmojiPanel.G;
            if (((InteractEmojiPanel) r7).j == false) goto L20;
        L23:
            IBaseUser r9 = ((InteractEmojiPanel) this.a).l;
            if (r9 == null) goto L40;
            RealTimeChorusBusinessContext.Companion.getClass();
            if (RealTimeChorusBusinessContext.a.g() == false) goto L30;
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
            com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r10 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
            if (r10 == null) goto L41;
            r10.kickOut(r9);
            return;
        L41:
            return;
        L30:
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
            com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r11 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
            if (r11 == null) goto L43;
            r11.kickOut(r9);
            return;
        L43:
            return;
        L40:
            return;
        L20:
            if (je0.d.Y() == true) goto L23;
            int r12 = InteractEmojiPanel.E;
            InteractEmojiPanel.a.a(TalkRoomOperate.DISCONNECT);
            return;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r13 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r13 == null) goto L16;
            com.bytedance.crash.d.d(r13, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L5:
            if (Looper.myLooper() == r6.getLooper()) goto L7;
            r6.post(DialogLancet.createDismissRunnable(r5));
            goto L17
        }
    }

    public static final class c implements DialogInterface.OnClickListener {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dialog");
            r1.dismiss();
        }
    }

    public static final class e implements bk0.d.a {
        public final /* synthetic */ KtvRoomInteractEmojiPanel a;

        public final boolean c() {
            return false;
        }

        public final boolean a() {
            KtvRoomInteractEmojiPanel r0 = this.a;
            int r1 = KtvRoomInteractEmojiPanel.G;
            r0.getClass();
            return false;
        }

        public final boolean b() {
            KtvRoomInteractEmojiPanel r0 = this.a;
            int r1 = KtvRoomInteractEmojiPanel.G;
            return r0.n1();
        }

        public final boolean isFollowed() {
            KtvRoomInteractEmojiPanel r0 = this.a;
            int r1 = KtvRoomInteractEmojiPanel.G;
            IBaseUser r2 = ((InteractEmojiPanel) r0).l;
            if (r2 != null) goto L5;
        L7:
            return false;
        L5:
            if (r2.isFollowing() != true) goto L7;
            return true;
        }

        public final boolean isMute() {
            KtvRoomInteractEmojiPanel r0 = this.a;
            int r1 = KtvRoomInteractEmojiPanel.G;
            return r0.X0();
        }

        public e(KtvRoomInteractEmojiPanel r1) {
            this.a = r1;
        }
    }

    public static final class f implements DialogInterface.OnShowListener {
        public final /* synthetic */ KtvRoomInteractEmojiPanel a;

        public f(KtvRoomInteractEmojiPanel r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public final void onShow(DialogInterface r5) {
            KtvRoomInteractEmojiPanel r6 = this.a;
            int r0 = KtvRoomInteractEmojiPanel.G;
            if (r6.l1() == false) goto L28;
            LinkedHashMap r7 = new LinkedHashMap();
            o r1 = o3.f();
            if (r1 == null) goto L9;
            m r2 = r1.getRoom();
            if (r2 == null) goto L9;
            IRoom r3 = (IRoom) r2.getValue();
        L10:
            r7.put("live_type", "voice_live");
            String r4 = "";
            if (r3 == null) goto L14;
            String r8 = r3.getOwnerUserIdString();
            if (r8 == null) goto L14;
        L15:
            r7.put("anchor_id", r8);
            if (r3 == null) goto L19;
            String r9 = String.valueOf(r3.getRoomId());
            if (r9 == null) goto L19;
        L20:
            r7.put("room_id", r9);
            r7.put("function_type", "ktv");
            IBaseUser r10 = ((InteractEmojiPanel) this.a).l;
            if (r10 == null) goto L26;
            String r11 = r10.getIdString();
            if (r11 == null) goto L26;
            r4 = r11;
        L26:
            r7.put("to_user_id", r4);
            j0.l().sendLog("livesdk_ktv_friends_group_join_invite_icon_show", r7, new Object[]{x.class, IRoom.class});
            return;
        L19:
            r9 = "";
        L14:
            r8 = "";
        L9:
            r3 = null;
            goto L10
        }
    }

    static {
    }

    public final int Q0() {
        return 1;
    }

    public final void C0() {
        IBaseUser r0 = ((InteractEmojiPanel) this).l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (n.g(((InteractEmojiPanel) this).C) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        String r1 = r0.getIdString();
        LinkApi.UpdateMcAction r2 = LinkApi.UpdateMcAction.UNSET_KTV_HOST;
        ((InteractEmojiPanel) this).m.d0(r1, r2, new KtvRoomInteractEmojiPanel$setMcStatus$1(this, r1, r2));
        return;
    }

    public final void E() {
        ALogger.i("KtvRoomInteractEmojiPanel", "setRealtimeChorusHost, chorusGuestStatus: " + ((InteractEmojiPanel) this).C.getChorusGuestStatus());
        IBaseUser r0 = ((InteractEmojiPanel) this).l;
        if (r0 != null) goto L5;
        return;
    L5:
        if (((InteractEmojiPanel) this).C.getChorusGuestStatus() != ChorusGuestStatus.STATUS_NORMAL.getValue()) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L17;
        o1("set_host", "guest");
        s r2 = RealTimeChorusBusinessContext.Companion.c();
        if (r2 == null) goto L18;
        r2.Ch(r0.getIdString(), ChorusGuestStatus.STATUS_HOST.getValue(), new KtvRoomInteractEmojiPanel$setRealtimeChorusHost$$inlined$let$lambda$1(this));
        return;
    L18:
        return;
    L17:
        return;
    L7:
        r1 = false;
        goto L8
    }

    public final void M() {
        IBaseUser r0 = ((InteractEmojiPanel) this).l;
        if (r0 == null) goto L22;
        k.n(IKtvService.class).inviteToKtvGroup(((InteractEmojiPanel) this).i.getRoomId(), r0.getIdString());
        LinkedHashMap r1 = new LinkedHashMap();
        o r2 = o3.f();
        if (r2 == null) goto L9;
        m r3 = r2.getRoom();
        if (r3 == null) goto L9;
        IRoom r4 = (IRoom) r3.getValue();
    L10:
        r1.put("live_type", "voice_live");
        String r5 = "";
        if (r4 == null) goto L14;
        String r6 = r4.getOwnerUserIdString();
        if (r6 == null) goto L14;
    L15:
        r1.put("anchor_id", r6);
        if (r4 == null) goto L21;
        String r7 = String.valueOf(r4.getRoomId());
        if (r7 == null) goto L21;
        r5 = r7;
    L21:
        r1.put("room_id", r5);
        r1.put("function_type", "ktv");
        r1.put("to_user_id", r0.getIdString());
        j0.l().sendLog("livesdk_ktv_friends_group_join_invite_icon_click", r1, new Object[]{x.class, IRoom.class});
    L14:
        r6 = "";
    L9:
        r4 = null;
    L22:
        g1(this);
    }

    public final i<ILinkPlayerInfoBridge> R0() {
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L8;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getLinkUserInfoCenter();
    L8:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 != null) goto L11;
        return null;
    L11:
        return r1.getLinkUserInfoCenter();
    }

    public final void b0() {
        ALogger.i("KtvRoomInteractEmojiPanel", "setRealtimeChorusPermanentGuest, chorusGuestStatus: " + ((InteractEmojiPanel) this).C.getChorusGuestStatus());
        IBaseUser r0 = ((InteractEmojiPanel) this).l;
        if (r0 == null) goto L20;
        long r1 = ((InteractEmojiPanel) this).C.getChorusGuestStatus();
        ChorusGuestStatus r3 = ChorusGuestStatus.STATUS_NORMAL;
        if (r1 == r3.getValue()) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r0 = null;
    L11:
        if (r0 != null) goto L13;
        return;
    L13:
        if (((InteractEmojiPanel) this).C.getChorusGuestStatus() != ChorusGuestStatus.STATUS_HOST.getValue()) goto L15;
        String r4 = "host";
    L16:
        o1("set_guest", r4);
        s r5 = RealTimeChorusBusinessContext.Companion.c();
        if (r5 == null) goto L22;
        r5.Ch(r0.getIdString(), r3.getValue(), new KtvRoomInteractEmojiPanel$setRealtimeChorusPermanentGuest$$inlined$let$lambda$1(this));
        return;
    L22:
        return;
    L15:
        r4 = "user";
        goto L16
    L7:
        r2 = false;
        goto L8
    }

    public final void h0() {
        IBaseUser r0 = ((InteractEmojiPanel) this).l;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!n.g(((InteractEmojiPanel) this).C)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L12;
        String r1 = r0.getIdString();
        LinkApi.UpdateMcAction r2 = LinkApi.UpdateMcAction.SET_KTV_HOST;
        ((InteractEmojiPanel) this).m.d0(r1, r2, new KtvRoomInteractEmojiPanel$setMcStatus$1(this, r1, r2));
        return;
    }

    public final boolean n1() {
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.h(((InteractEmojiPanel) this).B, null, 2);
        if (r0 == null) goto L13;
        j r1 = r0.s();
        if (r1 == null) goto L14;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 != null) goto L9;
        return true;
    L9:
        if (g.c(r2) != true) goto L16;
        return false;
    L16:
        return true;
    L14:
        return true;
    L13:
        return true;
    }

    public static com.bytedance.android.live.liveinteract.voicechat.b m1() {
        if (jc0.a.a() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r0 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r0 != null) goto L12;
    L10:
        return null;
    L12:
        return r0.muteManager();
    L7:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r1 == null) goto L10;
        return r1.muteManager();
    }

    public final List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> S0() {
        String r1 = null;
        boolean r2 = true;
        if (vm2.d.L() == true) goto L5;
        ArrayList r0 = new ArrayList();
        if (((InteractEmojiPanel) this).j == false) goto L54;
    L79:
        k1(r0);
        IBaseUser r3 = ((InteractEmojiPanel) this).l;
        if (r3 == null) goto L88;
        if (r3.isMysteryMan() == true) goto L88;
        if (((InteractEmojiPanel) this).C.isAnonymous() == false) goto L86;
        ALogger.i("KtvRoomInteractEmojiPanel", "the anchor clicks the anonymous seat profile emoji panel item need to be hidden.");
        goto L88
    L86:
        r0.add(new r0(this));
    L88:
        if (X0() == false) goto L94;
        if (W0() == false) goto L92;
        b1 r4 = new b1(this);
    L97:
        r0.add(r4);
        if (((InteractEmojiPanel) this).C.isAnonymous() == true) goto L103;
        if (vm2.d.V() == false) goto L103;
        j1(r0);
    L103:
        if (W0() == true) goto L106;
        r0.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n(this));
    L106:
        if (((InteractEmojiPanel) this).C.isAnonymous() == false) goto L109;
        ALogger.i("KtvRoomInteractEmojiPanel", "the anchor clicks the anonymous seat KtvGroup and KtvHostOption panel item  need to be hidden.");
    L112:
        IBaseUser r5 = ((InteractEmojiPanel) this).l;
        if (r5 == null) goto L127;
        if (r5.isMysteryMan() == true) goto L127;
        if (((InteractEmojiPanel) this).C.isAnonymous() == false) goto L119;
        ALogger.i("KtvRoomInteractEmojiPanel", "the anchor clicks the anonymous seat follow panel item need to be hidden.");
        goto L127
    L119:
        IBaseUser r6 = ((InteractEmojiPanel) this).l;
        if (r6 != null) goto L122;
    L124:
        a1 r7 = new q(this);
    L125:
        r0.add(r7);
        goto L127
    L122:
        if (r6.isFollowing() != true) goto L124;
        r7 = new a1(this);
    L127:
        if (W0() == true) goto L132;
        if (n1() == false) goto L132;
        r0.add(new r(this));
    L132:
        if (((InteractEmojiPanel) this).C.isAnonymous() == false) goto L135;
        r0.add(new v0(this));
    L135:
        if (W0() == true) goto L137;
        i1(r0);
        P0(r0);
    L137:
        return r0;
    L109:
        if (l1() == false) goto L111;
        r0.add(new i0(this));
    L111:
        h1(r0);
        goto L112
    L92:
        r4 = new c1(this);
        goto L97
    L94:
        if (W0() == false) goto L96;
        r4 = new n0(this);
        goto L97
    L96:
        r4 = new x0(this);
        goto L97
    L54:
        if (je0.d.Y() == false) goto L62;
        IBaseUser r8 = ((InteractEmojiPanel) this).l;
        if (r8 == null) goto L59;
        r1 = r8.getIdString();
    L59:
        if ((!Intrinsics.areEqual(r1, ((InteractEmojiPanel) this).i.getOwnerUserIdString())) == true) goto L79;
    L62:
        if (((InteractEmojiPanel) this).C.isAnonymous() == false) goto L64;
        ALogger.i("KtvRoomInteractEmojiPanel", "other guest clicks the anonymous seat profile emoji and follow panel item need to be hidden.");
    L72:
        if (W0() == true) goto L77;
        if (n1() == false) goto L77;
        r0.add(new r(this));
    L77:
        if (((InteractEmojiPanel) this).C.isAnonymous() == false) goto L135;
        r0.add(new v0(this));
        goto L135
    L64:
        r0.add(new r0(this));
        IBaseUser r9 = ((InteractEmojiPanel) this).l;
        if (r9 != null) goto L67;
    L69:
        a1 r10 = new q(this);
    L70:
        r0.add(r10);
        goto L72
    L67:
        if (r9.isFollowing() != true) goto L69;
        r10 = new a1(this);
        goto L70
    L5:
        if (((InteractEmojiPanel) this).j == false) goto L8;
        IconFilterFactory.Sender r11 = IconFilterFactory.Sender.ANCHOR;
    L11:
        IBaseUser r12 = ((InteractEmojiPanel) this).l;
        if (r12 == null) goto L17;
        if (r12.isMysteryMan() != true) goto L17;
        IconFilterFactory.Receiver r13 = IconFilterFactory.Receiver.MYSTERY;
    L27:
        u r14 = com.bytedance.android.live.liveinteract.api.utils.m.h(((InteractEmojiPanel) this).B, null, 2);
        if (r14 == null) goto L36;
        j r15 = r14.s();
        if (r15 == null) goto L36;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r16 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r15.getValue();
        if (r16 == null) goto L36;
        if (g.b(r16) != true) goto L36;
    L38:
        if (W0() == false) goto L40;
        IconFilterFactory.Scene r17 = IconFilterFactory.Scene.CROSS_ROOM;
    L43:
        bk0.f r18 = bk0.u.a(r11, r13, r17, new bk0.d(this.F));
        ArrayList r19 = new ArrayList();
        k1(r19);
        r19.add(new r0(this));
        r19.add(new x0(this));
        r19.add(new c1(this));
        r19.add(new n0(this));
        r19.add(new b1(this));
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == true) goto L48;
        r19.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a(this));
        h1(r19);
        if (l1() == false) goto L49;
        r19.add(new i0(this));
    L49:
        r19.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n(this));
        r19.add(new q(this));
        r19.add(new a1(this));
        r19.add(new r(this));
        r19.add(new v0(this));
        i1(r19);
        P0(r19);
        return r18.a(r19);
    L48:
        j1(r19);
        goto L49
    L40:
        if (r2 == false) goto L42;
        r17 = IconFilterFactory.Scene.KTV;
        goto L43
    L42:
        r17 = IconFilterFactory.Scene.ROOM;
    L36:
        r2 = false;
    L17:
        if (((InteractEmojiPanel) this).C.isAnonymous() == false) goto L19;
        r13 = IconFilterFactory.Receiver.ANONYMOUS;
        goto L27
    L19:
        IBaseUser r20 = ((InteractEmojiPanel) this).l;
        if (r20 == null) goto L22;
        String r21 = r20.getIdString();
    L24:
        if (Intrinsics.areEqual(r21, ((InteractEmojiPanel) this).i.getOwnerUserIdString()) == false) goto L26;
        r13 = IconFilterFactory.Receiver.ANCHOR;
        goto L27
    L26:
        r13 = IconFilterFactory.Receiver.NORMAL;
        goto L27
    L22:
        r21 = null;
        goto L24
    L8:
        if (je0.d.Y() == false) goto L10;
        r11 = IconFilterFactory.Sender.ADMIN;
        goto L11
    L10:
        r11 = IconFilterFactory.Sender.GUEST;
        goto L11
    }

    public final boolean Y0() {
        if (W0() == false) goto L49;
        int r0 = com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a;
        if (com.bytedance.android.live.liveinteract.revenue.linkroomfight.ui.a.a.b(((InteractEmojiPanel) this).C) == true) goto L49;
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L21;
        if (((InteractEmojiPanel) this).j == false) goto L15;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.T0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b r1 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.b.a.a();
        if (r1 == null) goto L32;
        i<ILinkPlayerInfoBridge> r2 = r1.getLinkUserInfoCenter();
        if (r2 == null) goto L32;
        List r3 = r2.c();
    L33:
        if (r3 == null) goto L48;
        Iterator r4 = r3.iterator();
    L36:
        if (r4.hasNext() == false) goto L48;
        IBaseUser r5 = ((ILinkPlayerInfoBridge) r4.next()).getUser();
        if (r5 == null) goto L40;
        String r6 = r5.getIdString();
    L41:
        IBaseUser r7 = ((InteractEmojiPanel) this).l;
        if (r7 == null) goto L44;
        String r8 = r7.getIdString();
    L46:
        if (Intrinsics.areEqual(r6, r8) == false) goto L36;
        return true;
    L44:
        r8 = null;
        goto L46
    L40:
        r6 = null;
    L48:
        return false;
    L32:
        r3 = null;
        goto L33
    L15:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r9 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r9 == null) goto L32;
        i<ILinkPlayerInfoBridge> r10 = r9.getLinkUserInfoCenter();
        if (r10 == null) goto L32;
        r3 = r10.c();
        goto L33
    L21:
        if (((InteractEmojiPanel) this).j == false) goto L27;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.W0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c r11 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor.c.a.a();
        if (r11 == null) goto L32;
        i<ILinkPlayerInfoBridge> r12 = r11.getLinkUserInfoCenter();
        if (r12 == null) goto L32;
        r3 = r12.c();
        goto L33
    L27:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r13 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r13 == null) goto L32;
        i<ILinkPlayerInfoBridge> r14 = r13.getLinkUserInfoCenter();
        if (r14 == null) goto L32;
        r3 = r14.c();
    L49:
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L54;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.X0.getClass();
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b r15 = com.bytedance.android.livesdk.ktvimpl.realtimechorus.guest.b.a.a();
        if (r15 == null) goto L57;
        List<ILinkPlayerInfoBridge> r16 = r15.getOnlineUserList();
    L58:
        List<ILinkPlayerInfoBridge> r17 = r16;
        if (r17 != null) goto L61;
    L64:
        boolean r18 = true;
    L65:
        if (r18 == false) goto L67;
        return false;
    L67:
        Iterator<T> r19 = r16.iterator();
    L69:
        if (r19.hasNext() == false) goto L81;
        IBaseUser r20 = ((ILinkPlayerInfoBridge) r19.next()).getUser();
        if (r20 == null) goto L73;
        String r21 = r20.getIdString();
    L74:
        IBaseUser r22 = ((InteractEmojiPanel) this).l;
        if (r22 == null) goto L77;
        String r23 = r22.getIdString();
    L79:
        if (Intrinsics.areEqual(r21, r23) == false) goto L69;
        return true;
    L77:
        r23 = null;
        goto L79
    L73:
        r21 = null;
        goto L74
    L81:
        return false;
    L61:
        if (r17.isEmpty() == true) goto L64;
        r18 = false;
    L57:
        r16 = null;
        goto L58
    L54:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.S0.getClass();
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a r24 = com.bytedance.android.livesdk.ktvimpl.ktvroom.service.a.C0028a.a();
        if (r24 == null) goto L57;
        r16 = r24.getOnlineUserList();
        goto L58
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disconnect() {
        if (Y0() == true) goto L6;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L6:
        String r0 = s1.B(2131919267);
        String r2 = s1.B(2131915442);
        if (((InteractEmojiPanel) this).j == false) goto L9;
    L13:
        Object[] r4 = new Object[1];
        IBaseUser r5 = ((InteractEmojiPanel) this).l;
        String r6 = null;
        if (r5 == null) goto L16;
        String r7 = r5.getNickName();
    L17:
        r4[0] = LinkPlayerInfo.getUserNameWithCut(r7);
        String r8 = s1.C(2131919814, r4);
        b r9 = new b(this);
        if (je0.d.y() == true) goto L20;
        com.bytedance.android.livesdk.widget.j0.a r1 = new com.bytedance.android.livesdk.widget.j0.a(getContext());
        r1.a = r8;
        r1.a(r0, r9);
        r1.b(r2, d.a);
        r1.c();
        return;
    L20:
        if (jc0.a.a() == true) goto L23;
        r6 = s1.B(2131919479);
    L23:
        Context r10 = getContext();
        com.bytedance.android.livesdk.widget.x0.d r11 = new com.bytedance.android.livesdk.widget.x0.d();
        r11.b = r10;
        r11.a = 0;
        r11.a = 5;
        r11.k = false;
        r11.c = r8;
        r11.d = r6;
        com.bytedance.android.livesdk.widget.x0.c[] r12 = r11.g;
        com.bytedance.android.livesdk.widget.x0.c r13 = r12[0];
        if (r13 != null) goto L26;
        r13 = new com.bytedance.android.livesdk.widget.x0.c();
        r12[0] = r13;
    L26:
        r13.a = r0;
        r13.b = r9;
        c r3 = c.a;
        com.bytedance.android.livesdk.widget.x0.c[] r14 = r11.g;
        com.bytedance.android.livesdk.widget.x0.c r15 = r14[1];
        if (r15 != null) goto L29;
        r15 = new com.bytedance.android.livesdk.widget.x0.c();
        r14[1] = r15;
    L29:
        r15.a = r2;
        r15.b = r3;
        com.bytedance.android.livesdk.widget.x0.b.g(new com.bytedance.android.livesdk.widget.x0(r11.b, r11));
        return;
    L16:
        r7 = null;
        goto L17
    L9:
        if (je0.d.Y() == true) goto L13;
        InteractEmojiPanel.a.a(TalkRoomOperate.DISCONNECT);
    }

    public final void e() {
        if (Y0() == true) goto L7;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L7:
        if (((InteractEmojiPanel) this).j == false) goto L9;
    L12:
        e1(2131919826);
        if (W0() == false) goto L28;
        o r0 = o3.f();
        Long r1 = null;
        if (r0 == null) goto L21;
        m r2 = r0.getRoom();
        if (r2 == null) goto L21;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L21;
        Long r4 = Long.valueOf(r3.getRoomId());
    L22:
        LinkRoomFightContext r5 = LinkRoomFightContext.Companion.getContext();
        if (r5 == null) goto L25;
        r1 = r5.getLinkRoomId();
    L25:
        if (r4 == null) goto L34;
        if (r1 == null) goto L35;
        InteractEmojiPanel.Z0(r4.longValue(), r1.longValue(), true, ((InteractEmojiPanel) this).s, new KtvRoomInteractEmojiPanel$silence$$inlined$lets$lambda$1(this));
        return;
    L35:
        return;
    L34:
        return;
    L21:
        r4 = null;
        goto L22
    L28:
        IBaseUser r6 = ((InteractEmojiPanel) this).l;
        if (r6 == null) goto L37;
        com.bytedance.android.live.liveinteract.voicechat.b r7 = m1();
        if (r7 == null) goto L38;
        r7.h(r6.getIdString());
        return;
    L38:
        return;
    L37:
        return;
    L9:
        if (je0.d.Y() == true) goto L12;
        InteractEmojiPanel.a.a(TalkRoomOperate.SILENCE);
    }

    public final void k() {
        if (Y0() == true) goto L7;
        f2.b(2131922751, 0);
        g1(this);
        return;
    L7:
        if (((InteractEmojiPanel) this).j == false) goto L9;
    L12:
        e1(2131919829);
        Long r1 = null;
        if (W0() == false) goto L28;
        o r0 = o3.f();
        if (r0 == null) goto L21;
        m r2 = r0.getRoom();
        if (r2 == null) goto L21;
        IRoom r3 = (IRoom) r2.getValue();
        if (r3 == null) goto L21;
        Long r4 = Long.valueOf(r3.getRoomId());
    L22:
        LinkRoomFightContext r5 = LinkRoomFightContext.Companion.getContext();
        if (r5 == null) goto L25;
        r1 = r5.getLinkRoomId();
    L25:
        if (r4 == null) goto L34;
        if (r1 == null) goto L35;
        InteractEmojiPanel.Z0(r4.longValue(), r1.longValue(), false, ((InteractEmojiPanel) this).s, new KtvRoomInteractEmojiPanel$unSilence$$inlined$lets$lambda$1(this));
        return;
    L35:
        return;
    L34:
        return;
    L21:
        r4 = null;
        goto L22
    L28:
        IBaseUser r6 = ((InteractEmojiPanel) this).l;
        if (r6 == null) goto L37;
        com.bytedance.android.live.liveinteract.voicechat.b r7 = m1();
        if (r7 == null) goto L38;
        r7.f(r6.getIdString(), null);
        return;
    L38:
        return;
    L37:
        return;
    L9:
        if (je0.d.Y() == true) goto L12;
        InteractEmojiPanel.a.a(TalkRoomOperate.UNSILENCE);
    }

    public final boolean l1() {
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r0 != null) goto L5;
        return false;
    L5:
        j r1 = r0.s();
        if (r1 == null) goto L34;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r2 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r1.getValue();
        if (r2 == null) goto L34;
        if (g.b(r2) != true) goto L34;
        if (((InteractEmojiPanel) this).j == false) goto L34;
        List r3 = (List) IInteractService.linkMicSettings.getValue();
        if (r3 == null) goto L32;
        Iterator r4 = r3.iterator();
    L18:
        if (r4.hasNext() == false) goto L25;
        Object r5 = r4.next();
        if (((y) r5).getKey() != 56) goto L22;
        boolean r6 = true;
    L23:
        if (r6 == false) goto L18;
    L26:
        y r7 = (y) r5;
        if (r7 == null) goto L32;
        if (r7.getValue() != 1) goto L32;
        return true;
    L22:
        r6 = false;
        goto L23
    L25:
        r5 = null;
    L32:
        ALogger.i("KtvRoomInteractEmojiPanel", "not in group");
        return false;
    L34:
        ALogger.i("KtvRoomInteractEmojiPanel", "not in ktv room");
        return false;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.android.live.liveinteract.voicechat.b r0 = m1();
        if (r0 == null) goto L5;
        r0.a(this);
    L5:
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L8;
        U0();
        return;
    L8:
        b1();
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.android.live.liveinteract.voicechat.b r0 = m1();
        if (r0 == null) goto L6;
        r0.g(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g1(KtvRoomInteractEmojiPanel r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void C(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUserId");
        f2.c(s1.C(2131923172, new Object[]{T0(r3)}), 0);
        V0();
        g1(this);
    }

    public final void V(String r3) {
        Intrinsics.checkNotNullParameter(r3, "targetUserId");
        f2.c(s1.C(2131923165, new Object[]{T0(r3)}), 0);
        V0();
        g1(this);
    }

    public final void h1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r5) {
        nd r1 = null;
        u r0 = com.bytedance.android.live.liveinteract.api.utils.m.h(((InteractEmojiPanel) this).B, null, 2);
        if (r0 != null) goto L5;
        return;
    L5:
        j r2 = r0.s();
        if (r2 == null) goto L36;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r3 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r2.getValue();
        if (r3 == null) goto L37;
        boolean r4 = true;
        if (g.b(r3) == true) goto L12;
        return;
    L12:
        if (((InteractEmojiPanel) this).j == true) goto L14;
        return;
    L14:
        if (jc0.a.a() == true) goto L44;
        m r6 = r0.q();
        if (r6 == null) goto L19;
        r1 = (nd) r6.getValue();
    L19:
        IBaseUser r7 = ((InteractEmojiPanel) this).l;
        if (r7 == null) goto L26;
        t r8 = r7.getUserAttr();
        if (r8 == null) goto L26;
        if (r8.isAdmin() != true) goto L26;
    L28:
        if (n.g(((InteractEmojiPanel) this).C) == false) goto L30;
        ArrayList r9 = (ArrayList) r5;
        r9.add(new k0(this));
        return;
    L30:
        if (r4 == false) goto L41;
        if (r1 != null) goto L33;
        return;
    L33:
        if (r1.a >= r1.b) goto L43;
        ArrayList r10 = (ArrayList) r5;
        r10.add(new com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j0(this));
        return;
    L43:
        return;
    L41:
        return;
    L26:
        r4 = false;
        goto L28
    L44:
        return;
    L37:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r13) {
        if (vm2.c.c() == false) goto L6;
        return;
    L6:
        if (vm2.d.E() == false) goto L120;
        IInteractService r0 = k.f(IInteractService.class);
        List r1 = null;
        if (r0 == null) goto L10;
        i r2 = r0.getLinkUserInfoCenter();
    L12:
        if ((r2 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L14;
        r2 = null;
    L14:
        com.bytedance.android.live.liveinteract.plantform.core.y r3 = (com.bytedance.android.live.liveinteract.plantform.core.y) r2;
        if (r3 == null) goto L24;
        Map r4 = r3.E;
        if (r4 == null) goto L24;
        IBaseUser r5 = ((InteractEmojiPanel) this).l;
        if (r5 == null) goto L22;
        String r6 = r5.getIdString();
        if (r6 == null) goto L22;
    L23:
        List r7 = (List) ((LinkedHashMap) r4).get(r6);
    L25:
        List r8 = com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.a(r7);
        Context r9 = getContext();
        IBaseUser r10 = ((InteractEmojiPanel) this).l;
        if (r10 == null) goto L29;
        String r11 = r10.getIdString();
        if (r11 == null) goto L29;
    L30:
        List r12 = com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.b(r9, this, r8, r11);
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.d(r12);
        if (r7 == null) goto L68;
        Iterator r14 = r7.iterator();
    L34:
        if (r14.hasNext() == false) goto L68;
        ILinkmicInteractEntrance r15 = (ILinkmicInteractEntrance) r14.next();
        if ((r15 instanceof ILinkmicInteractEntrance) == false) goto L34;
        List r16 = r15.getButtons();
        if (r16 == null) goto L34;
        if ((!r16.isEmpty()) != true) goto L34;
        if (r15.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L34;
        if (r15.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L34;
        if (((InteractEmojiPanel) this).o.contains(Long.valueOf(r15.getEntranceId())) == true) goto L61;
        ((InteractEmojiPanel) this).o.add(Long.valueOf(r15.getEntranceId()));
        int r17 = dk0.a.a;
        String r18 = r15.getSource();
        if (r18 != null) goto L50;
        r18 = "";
    L50:
        List r19 = r15.getButtons();
        Intrinsics.checkNotNull(r19);
        com.bytedance.android.livesdk.chatroom.model.interact.r r110 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r19, 0);
        if (r110 == null) goto L54;
        String r111 = r110.getToast();
        if (r111 == null) goto L54;
    L55:
        IBaseUser r112 = ((InteractEmojiPanel) this).l;
        if (r112 == null) goto L59;
        String r113 = r112.getIdString();
        if (r113 == null) goto L59;
    L60:
        dk0.a.a("others", r18, r111, r113);
    L59:
        r113 = "";
    L54:
        r111 = "";
    L61:
        Context r114 = getContext();
        ((InteractEmojiPanel) this).i.getRoomId();
        IBaseUser r115 = ((InteractEmojiPanel) this).l;
        if (r115 == null) goto L65;
        String r116 = r115.getIdString();
        if (r116 == null) goto L65;
    L66:
        ((ArrayList) r13).add(new l0(this, r114, r116, r15));
    L65:
        r116 = "";
    L68:
        if ((!((ArrayList) r12).isEmpty()) == false) goto L70;
        ((ArrayList) r13).addAll(0, r12);
    L70:
        if (r7 != null) goto L72;
    L73:
        IInteractService r20 = k.f(IInteractService.class);
        if (r20 == null) goto L76;
        i r21 = r20.getLinkUserInfoCenter();
    L78:
        if ((r21 instanceof com.bytedance.android.live.liveinteract.plantform.core.y) == true) goto L80;
        r21 = null;
    L80:
        com.bytedance.android.live.liveinteract.plantform.core.y r22 = (com.bytedance.android.live.liveinteract.plantform.core.y) r21;
        if (r22 == null) goto L83;
        r1 = r22.D;
    L83:
        com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i.a(r1);
        if (r1 == null) goto L148;
        Iterator r23 = r1.iterator();
    L87:
        if (r23.hasNext() == false) goto L149;
        ILinkmicInteractEntrance r24 = (ILinkmicInteractEntrance) r23.next();
        if ((r24 instanceof ILinkmicInteractEntrance) == false) goto L87;
        List r25 = r24.getButtons();
        if (r25 == null) goto L87;
        if ((!r25.isEmpty()) != true) goto L87;
        if (r24.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_UNKONWN.getValue()) goto L87;
        if (r24.getStatus() == ILinkmicInteractEntrance.LinkmicEntranceStatus.ENTRANCE_STATUS_SHUTDOWN.getValue()) goto L87;
        if (((InteractEmojiPanel) this).o.contains(Long.valueOf(r24.getEntranceId())) == true) goto L114;
        ((InteractEmojiPanel) this).o.add(Long.valueOf(r24.getEntranceId()));
        int r26 = dk0.a.a;
        String r27 = r24.getSource();
        if (r27 != null) goto L103;
        r27 = "";
    L103:
        List r28 = r24.getButtons();
        Intrinsics.checkNotNull(r28);
        com.bytedance.android.livesdk.chatroom.model.interact.r r29 = (com.bytedance.android.livesdk.chatroom.model.interact.r) ListProtector.get(r28, 0);
        if (r29 == null) goto L107;
        String r30 = r29.getToast();
        if (r30 == null) goto L107;
    L108:
        IBaseUser r31 = ((InteractEmojiPanel) this).l;
        if (r31 == null) goto L112;
        String r32 = r31.getIdString();
        if (r32 == null) goto L112;
    L113:
        dk0.a.a("others", r27, r30, r32);
    L112:
        r32 = "";
    L107:
        r30 = "";
    L114:
        Context r33 = getContext();
        ((InteractEmojiPanel) this).i.getRoomId();
        IBaseUser r34 = ((InteractEmojiPanel) this).l;
        if (r34 == null) goto L118;
        String r35 = r34.getIdString();
        if (r35 == null) goto L118;
    L119:
        ((ArrayList) r13).add(new l0(this, r33, r35, r24));
    L118:
        r35 = "";
        goto L119
    L149:
        return;
    L148:
        return;
    L76:
        r21 = null;
        goto L78
    L72:
        if (r7.isEmpty() == true) goto L73;
        return;
    L29:
        r11 = "";
    L22:
        r6 = "";
    L24:
        r7 = null;
        goto L25
    L10:
        r2 = null;
        goto L12
    }

    public final void j1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r8) {
        if (((InteractEmojiPanel) this).j == true) goto L7;
        if (k.n(IMiddlewareUserService.class).user().c() == true) goto L7;
        return;
    L7:
        if (jc0.a.a() == false) goto L21;
        boolean r4 = false;
        if (((InteractEmojiPanel) this).C.getChorusGuestStatus() <= ChorusGuestStatus.STATUS_UNKNOWN.getValue()) goto L11;
        boolean r0 = true;
    L12:
        if (r0 == true) goto L14;
        return;
    L14:
        if (((InteractEmojiPanel) this).C.getChorusGuestStatus() != ChorusGuestStatus.STATUS_NORMAL.getValue()) goto L16;
        r4 = true;
    L16:
        if (r4 == false) goto L18;
        ((ArrayList) r8).add(new u0(this));
        return;
    L18:
        ((ArrayList) r8).add(new t0(this));
        return;
    L11:
        r0 = false;
        goto L12
    }

    public final void k1(List<com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g> r3) {
        if (ThemedCompetitionContext.Companion.g() == true) goto L6;
        return;
    L6:
        if (je0.d.f() != 9) goto L9;
        return;
    L9:
        if (((InteractEmojiPanel) this).C.getThemedCompetitionRole() == ThemedCompetitionRole.PERFORMER.getValue()) goto L14;
        if (((InteractEmojiPanel) this).C.getThemedCompetitionRole() == ThemedCompetitionRole.CONTESTANT.getValue()) goto L14;
        return;
    L14:
        if (((InteractEmojiPanel) this).j == false) goto L16;
    L17:
        ListProtector.add(r3, 0, new w0(this, ((InteractEmojiPanel) this).C.getThemedCompetitionRole()));
        if (((InteractEmojiPanel) this).u == true) goto L22;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.a r4 = com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.a;
        com.bytedance.android.live.liveinteract.videotalk.themecompetition.b.b(((InteractEmojiPanel) this).j, ((InteractEmojiPanel) this).C.getThemedCompetitionRole());
        ((InteractEmojiPanel) this).u = true;
        return;
    L22:
        return;
    L16:
        if (ThemedCompetitionContext.a.e() == true) goto L17;
    }

    public final void l(boolean r5) {
        o r0 = o3.f();
        if (r0 == null) goto L18;
        m r1 = r0.getRoom();
        if (r1 == null) goto L19;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L20;
        long r3 = r2.getRoomId();
        IBaseUser r4 = ((InteractEmojiPanel) this).C.getUser();
        if (r4 == null) goto L21;
        String r6 = r4.getIdString();
        if (r6 == null) goto L22;
        pj0.b r7 = ThemedCompetitionContext.Companion.c();
        if (r7 == null) goto L16;
        r7.Z6(r3, r6, r5);
    L16:
        g1(this);
        return;
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setOnShowListener(new f(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "targetUserId");
        V0();
        if ((r3 instanceof ApiServerException) == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == true) goto L11;
        ExceptionUtils.handleException(getContext(), r3, 2131919337);
        return;
    L11:
        return;
    L5:
        if (((ApiServerException) r3).getErrorCode() != 4004468) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i0(String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r2, "targetUserId");
        V0();
        ExceptionUtils.handleException(getContext(), r3, 2131919335);
    }

    public final void o1(String r4, String r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("action_type", r4);
        IBaseUser r6 = ((InteractEmojiPanel) this).l;
        if (r6 == null) goto L6;
        String r7 = r6.getIdString();
        if (r7 == null) goto L6;
    L7:
        r0.put("to_user_id", r7);
        r0.put("user_type", r5);
        if (((InteractEmojiPanel) this).j == false) goto L10;
        String r8 = "1";
    L11:
        r0.put("is_anchor", r8);
        j0.l().sendLog("livesdk_chorus_guestlink_icon_click", r0, new Object[]{IRoom.class});
        return;
    L10:
        r8 = BDLocationException.ERROR_TIMEOUT;
    L6:
        r7 = "";
        goto L7
    }

    public KtvRoomInteractEmojiPanel(Context r1, DataCenter r2, LinkPlayerInfo r3) {
        super(r1, r2, r3);
        this.F = new e(this);
    }
}
