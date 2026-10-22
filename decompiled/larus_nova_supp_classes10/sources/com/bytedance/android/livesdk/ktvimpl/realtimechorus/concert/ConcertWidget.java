package com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.VerticalDragFrameLayout;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.api.RealTimeChorusApi;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.ChorusJsbDataContext;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.z0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.kmp.live.livelink.api.multilink.media.StreamType;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.disposables.CompositeDisposable;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import vb6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/realtimechorus/concert/ConcertWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ConcertWidget extends PlatformMultiLinkWidget implements Observer<KVData> {
    public VerticalDragFrameLayout a;
    public c b;
    public fd2.e c;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a d;
    public final CompositeDisposable e;
    public z0 f;
    public d g;
    public boolean h;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b i;
    public com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a j;
    public final b k;

    public static final class a {
    }

    public static final class b implements xb6.b {
        public final /* synthetic */ ConcertWidget a;

        public final Pair<Boolean, String> a() {
            return xb6.b.a.k();
        }

        public final Pair<Boolean, String> b() {
            return xb6.b.a.a();
        }

        public final Pair<Boolean, String> c() {
            return xb6.b.a.b();
        }

        public final Pair<Boolean, String> e() {
            return xb6.b.a.e();
        }

        public final Pair<Boolean, String> g() {
            return xb6.b.a.l();
        }

        public final Pair<Boolean, String> h() {
            return xb6.b.a.g();
        }

        public final Pair<Boolean, String> k() {
            return xb6.b.a.i();
        }

        public final Pair<Boolean, String> m() {
            return xb6.b.a.c();
        }

        public b(ConcertWidget r1) {
            this.a = r1;
        }

        public final Pair<Boolean, String> d(z0 r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            if (r4.getSwitchToSilence() == false) goto L19;
            cg6.a r5 = this.a.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r5 == null) goto L9;
            g r6 = r5.O5();
            if (r6 == null) goto L9;
            yb6.e r7 = r6.j();
        L11:
            if (r7 == null) goto L13;
            r7.d0(StreamType.AUDIO, "handleKickOutMsg switchToSilence");
        L13:
            if (r7 == null) goto L15;
            r7.g0(false, "handleKickOutMsg switchToSilence");
        L15:
            if (r7 == null) goto L18;
            r7.v();
        L18:
            return new Pair(Boolean.TRUE, "chorus concert interceptPermitMsg");
        L9:
            r7 = null;
            goto L11
        L19:
            cg6.a r8 = this.a.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
            if (r8 == null) goto L25;
            g r9 = r8.O5();
            if (r9 == null) goto L25;
            r9.i1("leave chorus", false);
        L25:
            return new Pair(Boolean.TRUE, "concert chorus");
        }

        public final Pair f(com.bytedance.android.live.liveinteract.multianchor.model.b r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.d(r2);
        }

        public final Pair<Boolean, String> j(z0 r4) {
            Intrinsics.checkNotNullParameter(r4, "msg");
            ALogger.i("multi_link_service RealtimeChorusConcertWidget", "interceptPermitMsg  hasInitClient " + this.a.h);
            ConcertWidget r0 = this.a;
            if (r0.h == true) goto L5;
            r0.f = r4;
            return new Pair(Boolean.TRUE, "chorus concert interceptPermitMsg");
        L5:
            r0.h = false;
            return new Pair(Boolean.FALSE, "chorus concert interceptPermitMsg");
        }

        public final Pair<Boolean, String> l(h1 r2) {
            Intrinsics.checkNotNullParameter(r2, "msg");
            return xb6.b.a.m(r2);
        }

        public final Pair<Boolean, String> i(long r1, String r3, String r4, int r5, int r6) {
            Intrinsics.checkNotNullParameter(r3, "secToUserId");
            Intrinsics.checkNotNullParameter(r4, "toUserIdString");
            return xb6.b.a.j(r3, r4);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567254;
    }

    public ConcertWidget() {
        this.e = new CompositeDisposable();
        this.k = new b(this);
    }

    public final int getScene() {
        return je0.d.f();
    }

    public final void onCreate() {
        super.onCreate();
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.put("cmd_multi_enter_room_remove_view_mock", Boolean.TRUE);
    L5:
        View r1 = ((Widget) this).contentView;
        fd2.e r2 = null;
        if (r1 == null) goto L8;
        VerticalDragFrameLayout r3 = (VerticalDragFrameLayout) r1.findViewById(2131367629);
    L9:
        this.a = r3;
        if (r3 == null) goto L12;
        r3.post(new e(this));
    L12:
        Context r4 = ((Widget) this).context;
        this.b = new c();
        c r5 = this.b;
        if (r5 == null) goto L33;
        m r6 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r6 == null) goto L22;
        IRoom r7 = (IRoom) r6.getValue();
        if (r7 == null) goto L22;
        String r8 = r7.getIdStr();
        if (r8 == null) goto L22;
        String r9 = r8;
    L23:
        m r10 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r10 == null) goto L31;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L31;
        String r12 = r11.getOwnerUserIdString();
        if (r12 == null) goto L31;
        String r13 = r12;
    L32:
        r5.a(new fd2.b(r4, r9, r13, false, false, "", null, null, this.a));
    L31:
        r13 = "";
    L22:
        r9 = "";
    L33:
        c r14 = this.b;
        if (r14 == null) goto L48;
        m r15 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r15 == null) goto L40;
        IRoom r16 = (IRoom) r15.getValue();
        if (r16 == null) goto L40;
        String r17 = r16.getIdStr();
    L41:
        m r18 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r18 == null) goto L46;
        IRoom r19 = (IRoom) r18.getValue();
        if (r19 == null) goto L46;
        String r20 = r19.getOwnerUserIdString();
    L47:
        r14.c(r17, r20, false, "");
    L46:
        r20 = null;
    L40:
        r17 = null;
    L48:
        ((Widget) this).dataCenter.observe(ChorusJsbDataContext.CMD_START_RTC_ENGINE, this);
        ((Widget) this).dataCenter.observe(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE, this);
        ((Widget) this).dataCenter.observe("data_dynamic_show_emoji_panel", this);
        DataCenter r21 = ((Widget) this).dataCenter;
        if (r21 == null) goto L51;
        r21.observe("data_hide_screen", this);
    L51:
        cg6.a r22 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r22 == null) goto L56;
        g r23 = r22.O5();
        if (r23 == null) goto L56;
        r23.e1(this.k, true);
    L56:
        this.d = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a(((Widget) this).dataCenter, "chorus_concert", this);
        d r24 = new d(this);
        this.g = r24;
        ConcertTuner r25 = new ConcertTuner(((Widget) this).context, r24);
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r26 = this.d;
        if (r26 == null) goto L59;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a r27 = new com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a(r25, r26);
    L60:
        this.j = r27;
        ChorusJsbDataContext r28 = ChorusJsbDataContext.Companion.getContext();
        if (r28 == null) goto L65;
        j<fd2.e> r29 = r28.getService();
        if (r29 == null) goto L65;
        r2 = (fd2.e) r29.getValue();
    L65:
        this.c = r2;
        if (r2 == null) goto L68;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.concert.a r30 = this.j;
        Intrinsics.checkNotNull(r30);
        r2.n1(r30);
    L68:
        fd2.e r31 = this.c;
        if (r31 == null) goto L71;
        r31.p1(r25);
    L71:
        fd2.e r32 = this.c;
        if (r32 == null) goto L75;
        d r33 = this.g;
        Intrinsics.checkNotNull(r33);
        r32.q1(r33);
        return;
    L75:
        return;
    L59:
        r27 = null;
        goto L60
    L8:
        r3 = null;
        goto L9
    }

    public final void onDestroy() {
        super.onDestroy();
        c r0 = this.b;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        this.e.clear();
        fd2.e r1 = this.c;
        if (r1 == null) goto L8;
        r1.o1();
    L8:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.a r2 = this.d;
        if (r2 == null) goto L11;
        r2.a();
    L11:
        d r3 = this.g;
        if (r3 == null) goto L18;
        ((LinkedHashMap) r3.c).clear();
        cg6.a r4 = r3.k();
        if (r4 == null) goto L18;
        hg6.g r5 = r4.getRtcManager();
        if (r5 == null) goto L18;
        r5.Z(r3.f);
    L18:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b r6 = this.i;
        if (r6 != null) goto L21;
    L38:
        DataCenter r7 = ((Widget) this).dataCenter;
        if (r7 == null) goto L41;
        r7.removeObserver(this);
    L41:
        cg6.a r8 = getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r8 == null) goto L47;
        g r9 = r8.O5();
        if (r9 == null) goto L48;
        r9.f1(this.k);
        return;
    L48:
        return;
    L47:
        return;
    L21:
        if (r6.c != true) goto L38;
        m r10 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r10 == null) goto L27;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L27;
        long r12 = r11.getId();
    L28:
        long r13 = r12;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b r14 = this.i;
        if (r14 == null) goto L32;
        String r15 = r14.a;
        if (r15 == null) goto L32;
    L33:
        String r16 = r15;
        if (r14 == null) goto L36;
        int r17 = r14.b;
    L37:
        ((RealTimeChorusApi) com.bytedance.android.live.network.c.b().e(RealTimeChorusApi.class)).leaveChorus(r13, r16, 1, r17);
        goto L38
    L36:
        r17 = 0;
    L32:
        r15 = BDLocationException.ERROR_TIMEOUT;
    L27:
        r12 = 0;
        goto L28
    }

    public final void onChanged(Object r5) {
        KVData r6 = (KVData) r5;
        Intrinsics.checkNotNullParameter(r6, "value");
        String r0 = r6.getKey();
        switch(r0.hashCode()) {
            case -1238735384: goto L54;
            case -1122045708: goto L43;
            case -374564286: goto L29;
            case 135538046: goto L6;
            default: goto L79;
        };
    L79:
        return;
    L6:
        if (r0.equals("data_dynamic_show_emoji_panel") == false) goto L64;
        String r7 = (String) r6.getData();
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 == null) goto L65;
        i r2 = r1.getLinkUserInfoCenter();
        if (r2 == null) goto L66;
        ILinkPlayerInfoBridge r3 = je0.d.i(r2, r7);
        if (r3 == null) goto L80;
        m r4 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getRoom();
        if (r4 == null) goto L67;
        IRoom r8 = (IRoom) r4.getValue();
        if (r8 != null) goto L23;
        return;
    L23:
        if (Intrinsics.areEqual(r7, r8.getOwnerUserIdString()) == false) goto L25;
        xs2.b.a().post(new UserProfileEvent(r8.getOwner()).setReportType("data_card_linked_anchor"));
        return;
    L25:
        IInteractService r9 = k.f(IInteractService.class);
        if (r9 == null) goto L69;
        r9.openVideoTalkRoomManageDialog(((Widget) this).context, r3, Boolean.FALSE, ((Widget) this).dataCenter);
        return;
    L69:
        return;
    L67:
        return;
    L80:
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L29:
        if (r0.equals(ChorusJsbDataContext.CMD_START_RTC_ENGINE) == false) goto L71;
        this.h = true;
        if (this.f == null) goto L41;
        j r10 = com.bytedance.android.live.liveinteract.api.utils.m.j(this).getMessageManager();
        if (r10 == null) goto L41;
        vlc.d r11 = (vlc.d) r10.getValue();
        if (r11 == null) goto L41;
        tlc.d r12 = this.f;
        if (r12 == null) goto L40;
        r11.j(r12, true);
        goto L41
    L40:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.ugc.live.sdk.message.data.IMessage");
    L41:
        this.f = null;
        return;
    L71:
        return;
    L43:
        if (r0.equals("data_hide_screen") == false) goto L73;
        Boolean r13 = (Boolean) r6.getData();
        if (r13 != null) goto L47;
        r13 = Boolean.FALSE;
    L47:
        boolean r14 = r13.booleanValue();
        View r15 = ((Widget) this).contentView;
        if (r15 == null) goto L74;
        if (r14 == false) goto L51;
        int r16 = 4;
    L52:
        r15.setVisibility(r16);
        return;
    L51:
        r16 = 0;
        goto L52
    L74:
        return;
    L73:
        return;
    L54:
        if (r0.equals(ChorusJsbDataContext.CMD_JOIN_CHORUS_STATE) == false) goto L76;
        Object r17 = r6.getData();
        if ((r17 instanceof com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b) == true) goto L58;
        r17 = null;
    L58:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b r18 = (com.bytedance.android.livesdk.ktvimpl.realtimechorus.jsb.b) r17;
        this.i = r18;
        if (r18 != null) goto L61;
        return;
    L61:
        if (r18.c == true) goto L78;
        this.f = null;
        return;
    L78:
        return;
    }
}
