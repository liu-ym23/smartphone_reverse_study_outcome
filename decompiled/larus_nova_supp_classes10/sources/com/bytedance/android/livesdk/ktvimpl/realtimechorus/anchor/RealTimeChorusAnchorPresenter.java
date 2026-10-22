package com.bytedance.android.livesdk.ktvimpl.realtimechorus.anchor;

import android.content.Context;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.message.model.LinkMicGuideMessage;
import com.bytedance.android.livesdk.message.model.in;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.depend.model.live.audio.VoiceLiveTheme;
import io.reactivex.disposables.CompositeDisposable;
import jc1.k;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class RealTimeChorusAnchorPresenter extends n<IView> implements l {
    public boolean e;
    public final u f;
    public final cg6.a g;
    public final CompositeDisposable h;

    public interface IView extends IWidget {
        void e0(int r1, LinkMicGuideMessage.AnchorGuideInfo r2);

        Context getContext();
    }

    public final void detachView() {
        this.h.dispose();
        super.detachView();
    }

    public final /* bridge */ /* synthetic */ void c0(IWidget r1) {
        g0((IView) r1);
    }

    public final void g0(IView r2) {
        super.c0(r2);
        vlc.d r3 = ((n) this).d;
        if (r3 == null) goto L6;
        r3.addMessageListener(MessageType.LINK_MIC.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.LINK_MIC_GUIDE_MESSAGE.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.LINKER.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getIntType(), this);
        ((n) this).d.addMessageListener(MessageType.VOICE_LIVE_THEME_MESSAGE.getIntType(), this);
        return;
    }

    public final void onMessage(tlc.d r7) {
        if (((q46.b) this).a != null) goto L5;
        return;
    L5:
        boolean r1 = true;
        if ((r7 instanceof LinkMicGuideMessage) == false) goto L22;
        LinkMicGuideMessage r8 = (LinkMicGuideMessage) r7;
        if (r8.guidelineType == 0) goto L10;
        return;
    L10:
        if (this.e == true) goto L12;
        jy0.b.c("voice_chat", "intercept guide since message too often", null, 4);
    L18:
        if (r1 == false) goto L20;
        return;
    L20:
        ((q46.b) this).a.e0(r8.audienceLimit, r8.anchorGuideInfo);
        return;
    L12:
        u r0 = this.f;
        if (r0 != null) goto L15;
    L17:
        r1 = false;
        goto L18
    L15:
        if (((Boolean) r0.I1().getValue()).booleanValue() == false) goto L17;
        jy0.b.c("voice_chat", "intercept guide since in ktv mode", null, 4);
        goto L18
    L22:
        if ((r7 instanceof in) == false) goto L40;
        in r9 = (in) r7;
        VoiceLiveTheme r2 = r9.voiceLiveTheme;
        if (r2 == null) goto L31;
        if (r2.isRealTimeChorusTheme() == false) goto L31;
        if (vm2.c.k() == false) goto L31;
        r9.bgType = 100;
        r9.voiceLiveTheme.bgType = 100;
    L31:
        if (r9.voiceLiveTheme != null) goto L33;
        return;
    L33:
        if (r9.bgType != 100) goto L42;
        ALogger.i("RealTimeChorusAnchorPresenter", "IM, type:" + r9.bgType + ",theme:" + r9.voiceLiveTheme);
        x00.a r3 = k.f(IInteractService.class).getThemeManager(true, ((n) this).c);
        if (r3 == null) goto L43;
        r3.c(r9.voiceLiveTheme, r9.bgType);
        return;
    L43:
        return;
    L42:
        return;
    }

    public RealTimeChorusAnchorPresenter(u r2, cg6.a r3) {
        this.e = true;
        this.h = new CompositeDisposable();
        this.f = r2;
        this.g = r3;
        ((f) r2.s().getValue()).a().subscribe(new d(this));
    }
}
