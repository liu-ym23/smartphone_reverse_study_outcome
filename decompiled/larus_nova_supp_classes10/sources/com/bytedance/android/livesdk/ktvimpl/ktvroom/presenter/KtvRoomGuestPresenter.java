package com.bytedance.android.livesdk.ktvimpl.ktvroom.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.external.api.core.type.AckFromSource;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.in;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContent;
import com.bytedance.android.livesdkapi.depend.model.live.linker.ILinkerUpdateUserContentKt;
import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerRemoveWaitingUserContent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import ge1.a;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import jc1.k;
import pe2.b;
import vlc.d;
import vlc.l;
import vm2.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class KtvRoomGuestPresenter extends n<IView> implements l {
    public final IRoom e;
    public final u f;
    public boolean g;
    public final DataCenter h;
    public final CompositeDisposable i;
    public final b j;

    public interface IView extends IWidget {
        ag6.b L5();

        void V1();

        void Y(h1 r1);

        void e0(int r1, LinkMicGuideMessage.AnchorGuideInfo r2);

        Context getContext();

        void q(int r1);
    }

    public final void detachView() {
        this.h.removeObserver("cmd_interact_state_change", this.j);
        this.i.dispose();
        super.detachView();
    }

    public final String h0() {
        return k.f(IMiddlewareUserService.class).user().n();
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r3) {
        super.c0(r3);
        d r4 = ((n) this).d;
        if (r4 == null) goto L5;
        r4.addMessageListener(MessageType.LINK_MIC.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.LINKER.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.CONTROL.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.VOICE_LIVE_THEME_MESSAGE.getIntType(), this);
    L5:
        this.h.observeForever("cmd_interact_state_change", this.j);
    }

    public final void onMessage(tlc.d r12) {
        if (((q46.b) this).a != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if ((r12 instanceof LinkMicGuideMessage) == false) goto L40;
        LinkMicGuideMessage r13 = (LinkMicGuideMessage) r12;
        if (r13.guidelineType == 0) goto L10;
        return;
    L10:
        if (c.i() == true) goto L13;
    L35:
        r1 = true;
    L36:
        if (r1 == false) goto L38;
        return;
    L38:
        ((q46.b) this).a.e0(r13.audienceLimit, r13.anchorGuideInfo);
        return;
    L13:
        if (this.g == true) goto L15;
        jy0.b.c("voice_chat", "intercept guide since message too often", null, 4);
        goto L35
    L15:
        u r0 = this.f;
        if (r0 != null) goto L18;
    L20:
        IView r2 = ((q46.b) this).a;
        if (r2 != null) goto L23;
    L25:
        boolean r3 = false;
    L26:
        if (r3 == true) goto L35;
        LinkMicGuideMessage.AnchorGuideInfo r4 = r13.anchorGuideInfo;
        if (r4 == null) goto L34;
        List r5 = r4.infoItems;
        if (r5 == null) goto L34;
        if (r5.size() == 3) goto L36;
    L34:
        jy0.b.c("voice_chat", "intercept guide since message not complete", null, 4);
        goto L35
    L23:
        if (r2.L5() == null) goto L25;
        r3 = ((q46.b) this).a.L5().Ig();
        goto L26
    L18:
        if (((Boolean) r0.I1().getValue()).booleanValue() == false) goto L20;
        jy0.b.c("voice_chat", "intercept guide since in ktv mode", null, 4);
        goto L35
    L40:
        if ((r12 instanceof z0) == false) goto L79;
        z0 r14 = (z0) r12;
        long r7 = r14.getMessageId2();
        int r6 = (int) r14.getType2();
        if (r6 == 10) goto L58;
        if (r6 == 11) goto L58;
        if (r6 != 13) goto L47;
        x.b(r7, r14.getReplyType());
        InteractLinkFullLinkMonitor.K(r14);
        TalkRoomBusinessFullLinkMonitor.a.getClass();
        TalkRoomBusinessFullLinkMonitor.o0(r14);
        if (k.f(IMiddlewareUserService.class).user().c() == true) goto L52;
        return;
    L52:
        if (r14.getReplyType() != 1) goto L54;
        return;
    L54:
        if (TextUtils.isEmpty(r14.getReplyPrompts()) == true) goto L56;
        f2.c(r14.getReplyPrompts(), 0);
        return;
    L56:
        f2.b(2131919242, 0);
        return;
    L47:
        if (r6 == 16) goto L58;
        return;
    L58:
        if (c.f() == true) goto L61;
        return;
    L61:
        if (TextUtils.equals(r14.getToUserId(), h0()) == true) goto L63;
        return;
    L63:
        if (r14.getType2() != 10) goto L73;
        if (TextUtils.equals(r14.getFromUserIdStr(), h0()) == true) goto L71;
        IView r8 = ((q46.b) this).a;
        if (r8 == null) goto L71;
        if (r8.L5() == null) goto L71;
        ((q46.b) this).a.L5().Z(r14.getToUserId(), r14.getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_MESSAGE);
    L71:
        com.bytedance.android.live.liveinteract.linksecurity.c r15 = com.bytedance.android.live.liveinteract.linksecurity.c.g;
        r15.getClass();
        com.bytedance.android.live.liveinteract.linksecurity.c.m(r15);
        ((q46.b) this).a.q(2);
        return;
    L73:
        if (r14.getType2() != 11) goto L76;
        ((q46.b) this).a.q(0);
        return;
    L76:
        if (r14.getType2() != 16) goto L144;
        ((q46.b) this).a.q(3);
        return;
    L144:
        return;
    L79:
        if ((r12 instanceof h1) == false) goto L126;
        h1 r9 = (h1) r12;
        int r10 = (int) r9.getType2();
        if (r10 == 12) goto L102;
        if (r10 != 13) goto L84;
        IView r16 = ((q46.b) this).a;
        if (r16 != null) goto L100;
        return;
    L100:
        r16.Y(r9);
        return;
    L84:
        if (r10 == 56) goto L87;
        return;
    L87:
        if (((Integer) ((a) hd0.c.f()).b).intValue() != 1) goto L146;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.U0.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a() == null) goto L91;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.service.d.a.a().cancelApply(null, true, "leave_from_remove_apply_msg");
    L91:
        if (r12 == null) goto L147;
        LinkerRemoveWaitingUserContent r17 = ((h1) r12).getLinkerRemoveWaitingUserContent();
        if (r17 != null) goto L95;
        return;
    L95:
        if (r17.getWaitingUserToast() == null) goto L149;
        f2.c(r17.getWaitingUserToast(), 0);
        return;
    L149:
        return;
    L147:
        return;
    L146:
        return;
    L102:
        if (c.f() == true) goto L162;
        ILinkerUpdateUserContent r18 = r9.getMUpdateUser();
        if (r18 != null) goto L108;
        return;
    L108:
        if (ILinkerUpdateUserContentKt.isSilenceStatusUpdate(r18) == true) goto L111;
        return;
    L111:
        if (r9.getMUpdateUser() != null) goto L113;
        return;
    L113:
        if (TextUtils.equals(ILinkerUpdateUserContentKt.getToUserIdString(r18), h0()) == true) goto L115;
        return;
    L115:
        if (TextUtils.equals(ILinkerUpdateUserContentKt.getFromUserIdString(r18), ILinkerUpdateUserContentKt.getToUserIdString(r18)) == true) goto L163;
        int r11 = ILinkerUpdateUserContentKt.getSilenceStatus(r18);
        if (r11 != 2) goto L124;
        IView r19 = ((q46.b) this).a;
        if (r19 == null) goto L124;
        if (r19.L5() == null) goto L124;
        ((q46.b) this).a.L5().Z(ILinkerUpdateUserContentKt.getToUserIdString(r18), r18.getAckMessage(), AckFromSource.VOICE_CHAT_SILENCE_MESSAGE);
    L124:
        ((q46.b) this).a.q(r11);
        return;
    L163:
        return;
    L162:
        return;
    L126:
        if ((r12 instanceof in) == false) goto L155;
        in r110 = (in) r12;
        if (r110.voiceLiveTheme != null) goto L130;
        return;
    L130:
        if (r110.bgType != 1) goto L157;
        ALogger.i("KtvRoomGuestPresenter", "IM, type:" + r110.bgType + ",theme:" + r110.voiceLiveTheme);
        x00.a r20 = k.f(IInteractService.class).getThemeManager(false, this.h);
        if (r20 == null) goto L158;
        r20.c(r110.voiceLiveTheme, 1);
        return;
    L158:
        return;
    L157:
        return;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [pe2.b] */
    public KtvRoomGuestPresenter(IRoom r3, DataCenter r4, u r5) {
        this.g = true;
        this.i = new CompositeDisposable();
        com.bytedance.android.livesdk.a.h.getClass();
        com.bytedance.android.livesdk.a r0 = com.bytedance.android.livesdk.a.a.b("ktv_pre_linkmic_warning");
        this.j = new b(this);
        this.e = r3;
        this.h = r4;
        this.f = r5;
        k.f(IInteractService.class).addBusinessDegradeStrategy(r0);
    }
}
