package k82;

import am2.a0;
import am2.b0;
import am2.x;
import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.SkinSelection;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.framework.VSInputSectionType;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.provider.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.j;
import j82.e;
import j82.f;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import nm1.h;
import vr1.u;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a implements j82.a, j82.d, j82.c, j82.b, e, f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditText f502082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j82.a f502083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j82.d f502084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ j82.c f502085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j82.b f502086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e f502087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ f f502088g;

    public abstract void A();

    public abstract void B();

    public abstract void C(String r100);

    public abstract void D(String r100);

    @Override // j82.b
    public final void a(EditText r100) {
        this.f502086e.a(r100);
    }

    @Override // j82.b
    public final void b(BaseEmoji r100, String r101, EditText r102) {
        this.f502086e.b(r100, r101, r102);
    }

    @Override // j82.a
    public final void c() {
        this.f502083b.c();
    }

    @Override // j82.c
    public final void d(boolean r100) {
        this.f502085d.d(r100);
    }

    @Override // j82.a
    public final int e() {
        return this.f502083b.e();
    }

    @Override // j82.a
    public final void f(SkinSelection r100) {
        this.f502083b.f(r100);
    }

    @Override // j82.b
    public final void g(boolean r100) {
        this.f502086e.g(r100);
    }

    public abstract Activity getActivity();

    public abstract Context getContext();

    @Override // j82.f
    public final void h(SkinSelection r100) {
        this.f502088g.h(r100);
    }

    @Override // j82.e
    public final void i() {
        this.f502087f.i();
    }

    @Override // j82.e
    public final void j(boolean r100) {
        this.f502087f.j(r100);
    }

    @Override // j82.c
    public final void k() {
        this.f502085d.k();
    }

    @Override // j82.f
    public final void l(VSInputSectionType r100) {
        Intrinsics.checkNotNullParameter(r100, "panelType");
        this.f502088g.l(r100);
    }

    @Override // j82.d
    public final boolean m() {
        return this.f502084c.m();
    }

    @Override // j82.c
    public final void n(SkinSelection r100) {
        this.f502085d.n(r100);
    }

    public abstract void p();

    public abstract VSInputSectionType q();

    public abstract DataCenter r();

    public abstract t9 s();

    @Override // j82.e
    public final void scrollToTop(boolean r100) {
        this.f502087f.scrollToTop(r100);
    }

    public abstract int t();

    public abstract boolean u();

    public abstract void v();

    public abstract void w(boolean r100);

    public abstract void x();

    public abstract void y(o r100);

    public abstract void z();

    public final Map<String, String> o() {
        LinkedHashMap r100 = new LinkedHashMap();
        t9 r101 = s();
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.f114220d;
        if (r103 == null) goto L6;
    L7:
        r100.put("show_type", r103);
        t9 r104 = s();
        if (r104 == null) goto L11;
        String r105 = r104.f114222f;
        if (r105 == null) goto L11;
    L12:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r105);
        nm1.e r106 = pm1.f.c();
        com.bytedance.android.livesdk.log.filter.o r107 = null;
        if (r106 == null) goto L17;
        ReplayDataContext r108 = r106.h(null);
        if (r108 == null) goto L17;
        j<Object> r109 = r108.getVsMsgBoardDataContext();
    L19:
        if ((r109 instanceof j) == true) goto L21;
        r109 = null;
    L21:
        if (r109 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.msgboard.a r110 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r109.getValue();
        if (r110 == null) goto L24;
    L31:
        nm1.e r111 = pm1.f.c();
        if (r111 == null) goto L36;
        ReplayDataContext r112 = r111.h(null);
        if (r112 == null) goto L36;
        j<Object> r113 = r112.getVsMsgBoardDataContext();
    L38:
        if (r113 == null) goto L66;
        DataCenter r114 = r();
        if (r114 == null) goto L57;
        h r115 = pm1.f.f();
        if (r115 == null) goto L49;
        Map<String, String> r116 = r115.d(r114, a0.class);
        if (r116 == null) goto L49;
        Iterator<Map.Entry<String, String>> r117 = r116.entrySet().iterator();
    L47:
        if (r117.hasNext() == false) goto L49;
        Map.Entry<String, String> r118 = r117.next();
        r100.put(r118.getKey(), r118.getValue());
    L49:
        h r119 = pm1.f.f();
        if (r119 == null) goto L57;
        Map<String, String> r120 = r119.d(r114, b0.class);
        if (r120 == null) goto L57;
        Iterator<Map.Entry<String, String>> r121 = r120.entrySet().iterator();
    L55:
        if (r121.hasNext() == false) goto L57;
        Map.Entry<String, String> r122 = r121.next();
        r100.put(r122.getKey(), r122.getValue());
    L57:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "1");
        r100.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, "replay");
        if (r110 == null) goto L65;
        Episode r123 = r110.getEpisode();
        if (r123 == null) goto L65;
        String r124 = r123.idStr;
        if (r124 == null) goto L65;
        r102 = r124;
    L65:
        r100.put("vs_from_episode_id", r102);
    L92:
        return r100;
    L66:
        com.bytedance.android.livesdk.log.filter.o r125 = r.l().j(x.class);
        if ((r125 instanceof com.bytedance.android.livesdk.log.filter.o) == true) goto L69;
        r125 = null;
    L69:
        if (r125 == null) goto L73;
        Map<String, String> r126 = r125.getMap();
        if (r126 == null) goto L73;
        r100.putAll(r126);
    L73:
        com.bytedance.android.livesdk.log.filter.o r127 = r.l().j(IRoom.class);
        if ((r127 instanceof com.bytedance.android.livesdk.log.filter.o) == false) goto L77;
        r107 = r127;
    L77:
        if (r107 == null) goto L81;
        Map<String, String> r128 = r107.getMap();
        if (r128 == null) goto L81;
        r100.putAll(r128);
    L81:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, "0");
        r100.put(PaidReplayConstants.KEY_FROM_CONTENT_TYPE, "live");
        if (r110 == null) goto L91;
        IRoom r129 = r110.getRoom();
        if (r129 == null) goto L91;
        IEpisodeExtraInfo r130 = r129.getEpisodeExtra();
        if (r130 == null) goto L91;
        String r131 = String.valueOf(r130.getId());
        if (r131 == null) goto L91;
        r102 = r131;
    L91:
        r100.put("vs_from_episode_id", r102);
    L36:
        r113 = null;
    L24:
        u r132 = r.u(r(), null, 2);
        if (r132 == null) goto L27;
        r110 = r132.L0();
    L29:
        if ((r110 instanceof com.bytedance.android.livesdk.chatroom.msgboard.a) == true) goto L31;
        r110 = null;
        goto L31
    L27:
        r110 = null;
    L17:
        r109 = null;
    L11:
        r105 = "";
    L6:
        r103 = "";
        goto L7
    }

    public a(j82.a r100, j82.d r101, j82.b r102, j82.c r103, e r104, f r105) {
        Intrinsics.checkNotNullParameter(r100, "contentSectionBridge");
        Intrinsics.checkNotNullParameter(r101, "publishSectionBridge");
        Intrinsics.checkNotNullParameter(r102, "emojiSectionBridge");
        Intrinsics.checkNotNullParameter(r103, "portraitControlSectionBridge");
        Intrinsics.checkNotNullParameter(r104, "skinSectionBridge");
        Intrinsics.checkNotNullParameter(r105, "bottomTipSectionBridge");
        this.f502083b = r100;
        this.f502084c = r101;
        this.f502085d = r103;
        this.f502086e = r102;
        this.f502087f = r104;
        this.f502088g = r105;
    }
}
