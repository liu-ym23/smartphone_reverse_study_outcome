package xg6;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.model.m;
import com.bytedance.android.live.liveinteract.plantform.model.n;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import com.bytedance.android.livesdk.chatroom.model.interact.e1;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.interact.data.LinkConstantKt;
import com.bytedance.android.livesdkapi.interact.data.LinkConstantKt_live_model_apiKt;
import com.bytedance.live.kmp.util.KmpToastUtil;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import je0.d;
import kotlin.jvm.internal.Intrinsics;
import ph6.c;
import ph6.l;
import qg6.f;
import ti6.j;
import vm2.e;
import yz0.g;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends tg6.a implements yf6.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public j f563793p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f563794q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final g f563795r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final cg6.a f563796s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final f f563797t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final tc0.b f563798u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final bn0.b f563799v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f563800w;

    /* JADX INFO: renamed from: xg6.a$a, reason: collision with other inner class name */
    public static final class C8235a {
    }

    public static final class b implements xb6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f563801a;

        public b(a r100) {
            this.f563801a = r100;
        }

        @Override // xb6.a
        public final void a(Map r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
        }

        @Override // xb6.a
        public final String b(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            ((l) this.f563801a.q()).getClass();
            if (d.f() != 9) goto L5;
            int r101 = 64;
        L6:
            r100.put("layout", String.valueOf(r101));
            return "inject finish api layout";
        L5:
            r101 = 8;
            goto L6
        }

        @Override // xb6.a
        public final void c(fi6.a r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            Intrinsics.checkNotNullParameter(r100, "config");
        }

        @Override // xb6.a
        public final String d(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            return "";
        }

        @Override // xb6.a
        public final String e(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            return "";
        }

        @Override // xb6.a
        public final String f(yb6.g r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            Intrinsics.checkNotNullParameter(r100, "params");
            return "";
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.k
    public final void ci() {
        ((c) k()).getClass();
        if (d.U() == false) goto L10;
        hg6.g r100 = this.f563796s.getRtcManager();
        if (r100 == null) goto L11;
        pf6.a r101 = r100.f0();
        if (r101 == null) goto L12;
        r101.O(true);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // tg6.a, sf6.a
    public void init() {
        super.init();
        hg6.g r100 = this.f563796s.getRtcManager();
        if (r100 == null) goto L7;
        fi6.a r101 = r100.getInteractConfig();
        if (r101 == null) goto L7;
        r101.f477395l0 = false;
    L7:
        vb6.g r102 = this.f563796s.O5();
        if (r102 == null) goto L11;
        r102.b1(this.f563794q, true);
        return;
    }

    @Override // tg6.a, hg6.k
    public final void H1() {
        super.H1();
    }

    @Override // tg6.a, com.bytedance.android.live.liveinteract.plantform.core.v
    public void M1() {
        super.M1();
    }

    @Override // tg6.a, sf6.a
    public void release() {
        super.release();
    }

    @Override // tg6.a, hg6.k
    public final void M4(cc6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        super.M4(r100);
        KmpToastUtil.a("连线失败，请稍后重试", 0);
    }

    @Override // hg6.l
    public final void bd(IBaseUser r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        gd0.j r101 = m();
        String r102 = "";
        if (r101 == null) goto L21;
        List<ILinkPlayerInfoBridge> r103 = r101.getOnlineUserList();
        if (r103 == null) goto L21;
        Iterator<T> r104 = r103.iterator();
    L7:
        Object r105 = null;
        if (r104.hasNext() == false) goto L15;
        Object r106 = r104.next();
        IBaseUser r107 = n.d((ILinkPlayerInfoBridge) r106);
        if (r107 == null) goto L13;
        r105 = r107.getIdString();
    L13:
        if (Intrinsics.areEqual(r105, r100.getIdString()) == false) goto L7;
        r105 = r106;
    L15:
        ILinkPlayerInfoBridge r108 = (ILinkPlayerInfoBridge) r105;
        if (r108 == null) goto L21;
        Intrinsics.checkNotNullParameter(r108, "$this$userKt");
        IBaseUser r109 = r108.getUser();
        if (r109 == null) goto L21;
        String r110 = r109.getNickName();
        if (r110 == null) goto L21;
    L22:
        qg6.g r111 = this.f545895m.y();
        com.bytedance.live.bizlink.impl.platform.manager.a r112 = this.f563796s.A0();
        if (r112 == null) goto L29;
        String r113 = r112.f254956f;
        if (r113 == null) goto L29;
        r102 = r113;
    L29:
        if (r111.l(r102) == false) goto L31;
        KmpToastUtil.a("当前匿名连线已结束，用户将恢复正常显示", 0);
        return;
    L31:
        int r114 = KmpToastUtil.f255165a;
        StringBuilder r115 = new StringBuilder("已断开与");
        m.f77236q0.getClass();
        r115.append(m.a.a(r110));
        r115.append("的连线");
        KmpToastUtil.a(r115.toString(), 0);
        return;
    L21:
        r110 = "";
        goto L22
    }

    @Override // tg6.a, gg6.b
    public final void be(ExtraResponse<? extends IJoinChannelResult, Extra> r100) {
        Intrinsics.checkNotNullParameter(r100, "response");
        super.be(r100);
        hg6.g r101 = n();
        if (r101 == null) goto L5;
        r101.t();
    L5:
        hg6.g r102 = n();
        if (r102 == null) goto L8;
        String r103 = r102.u();
    L9:
        hg6.g r104 = n();
        if (r104 == null) goto L13;
        r104.J(r103);
        return;
    L13:
        return;
    L8:
        r103 = null;
        goto L9
    }

    @Override // tg6.a, gg6.b
    public final void m0(Throwable r100) {
        if ((r100 instanceof ApiServerException) == false) goto L13;
        ApiServerException r101 = (ApiServerException) r100;
        String r102 = r101.getPrompt();
        if (r102 != null) goto L7;
        return;
    L7:
        if (r102.length() <= 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 != true) goto L15;
        int r104 = KmpToastUtil.f255165a;
        KmpToastUtil.a(r101.getPrompt(), 0);
        return;
    L15:
        return;
    L9:
        r103 = false;
        goto L10
    }

    @Override // hg6.o
    public final void onPermitSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r100, "userId");
        uf0.d r101 = this.f545886d;
        if (r101 == null) goto L6;
        r101.onPermitSuccess(r100);
        return;
    }

    @Override // tg6.a, com.bytedance.android.live.liveinteract.plantform.core.t
    public void p2(fi6.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r101 = null;
        if (((Boolean) e.f556056m.getValue(null, e.f556037a[11])).booleanValue() == false) goto L7;
        int r102 = mh6.a.f513966a;
        InteractMode r103 = mh6.a.C6815a.a(0);
    L8:
        j r104 = this.f545895m.j0().a(r100, j());
        this.f563793p = r104;
        hg6.g r105 = n();
        if (r105 == null) goto L12;
        String r106 = r105.t();
        if (r106 == null) goto L12;
    L13:
        r100.f477382f = r104;
        r100.f(LinkConstantKt.Companion.getSTREAM_BACKGROUND());
        r100.h(this.f563800w);
        Intrinsics.checkNotNullParameter(r106, "info");
        r100.f477406v = r106;
        r100.S = 5;
        r100.o(qi6.g.f533174h);
        Intrinsics.checkNotNullParameter("douyin_live", "key");
        r100.f477407w = "douyin_live";
        r100.i(r103);
        r100.N = LinkConstantKt_live_model_apiKt.getVOLUME_CALLBACK_INTERVAL();
        r100.g(Character.ANCHOR);
        r100.f477378d = 3;
        r100.R = e.q();
        r100.Q = (int) e.l();
        IRoomBase r107 = this.f545893k.getRoom();
        if ((r107 instanceof IRoom) == true) goto L16;
        r107 = null;
    L16:
        IRoom r108 = (IRoom) r107;
        if (r108 == null) goto L21;
        IBaseStreamUrl r109 = IRoomKt_androidKt.getStreamUrlKt(r108);
        if (r109 == null) goto L21;
        r101 = r109.getRtmpPushUrl();
    L21:
        r100.f477380e = r101;
        MixStreamType r110 = MixStreamType.SERVER_MIX;
        r100.j(r110);
        r100.n(StreamType.VIDEO);
        if (e.e() == false) goto L27;
        boolean r111 = e.c();
        r100.W = false;
        if (r111 == false) goto L26;
        r110 = MixStreamType.CLIENT_MIX;
    L26:
        r100.j(r110);
    L27:
        ((c) k()).getClass();
        if (com.bytedance.android.live.liveinteract.plantform.widgt.voicelink.c.a() == false) goto L30;
        r100.Z = true;
        this.f545883a.I3(true);
    L32:
        if (e.n() == false) goto L35;
        r100.f477390j = 1;
        return;
    L35:
        return;
    L30:
        this.f545883a.I3(false);
    L12:
        r106 = "";
        goto L13
    L7:
        r103 = InteractMode.FM;
        goto L8
    }

    @Override // tg6.a, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void wk(String r100) {
        jy0.b.f("VoiceAnchorBizLinkService", "onWarn: ".concat(r100), null, 4);
    }

    @Override // tg6.a, uf6.a
    public final void G4(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(LiveCommonConstants.REASON_SILENCE_MESSAGE, "reason");
        hg6.g r102 = this.f563796s.getRtcManager();
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f0() == null) goto L16;
        jg6.a r103 = this.f563796s.e5();
        if (r103 == null) goto L14;
        kg6.e r104 = r103.b();
        if (r104 == null) goto L15;
        r104.s(r100);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // tg6.a, com.bytedance.android.live.liveinteract.plantform.core.v
    public final void G9(long r100, Exception r101) {
        super.G9(r100, r101);
    }

    @Override // hg6.l
    public final void Il(IBaseUser r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        if (r101 == null) goto L6;
        com.bytedance.live.kmp.util.a.c(r101, "断开连线失败，请稍后重试");
        return;
    }

    @Override // sf6.b
    public void a(com.bytedance.android.live.liveinteract.videolink.a r100, uf0.c r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        if (this.f545895m.y().isTeamFightShowing() == true) goto L5;
    L12:
        this.f545887e = r101;
        ((l) q()).getClass();
        if (d.f() != 9) goto L15;
        int r102 = 64;
    L16:
        r100.f78848a = r102;
        com.bytedance.live.bizlink.impl.platform.manager.a r103 = this.f563796s.A0();
        Intrinsics.checkNotNull(r103);
        r103.e(r100);
        return;
    L15:
        r102 = 8;
        goto L16
    L5:
        if (r100.f78856i > 0) goto L12;
        if (r100.f78849b != 0) goto L12;
        ph6.b r104 = this.f545895m.b0();
        if (r104 == null) goto L18;
        r104.l(r100, j());
        return;
    }

    @Override // sf6.b
    public final void b(IBaseUser r100, uf0.d r101) {
        this.f545886d = r101;
        com.bytedance.live.bizlink.impl.platform.manager.a r102 = this.f545894l.A0();
        if (r102 == null) goto L6;
        r102.j(r100);
        return;
    }

    @Override // sf6.b
    public final void d(IBaseUser r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "targetUser");
        Intrinsics.checkNotNullParameter(r101, "requestFrom");
        Intrinsics.checkNotNullParameter(r100, "targetUser");
        Intrinsics.checkNotNullParameter(r101, "requestFrom");
        com.bytedance.live.bizlink.impl.platform.manager.a r102 = this.f545894l.A0();
        if (r102 == null) goto L6;
        r102.h(r100, r101);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.core.v
    public final void f0(long r100, Exception r101) {
        KmpToastUtil.a("连线失败，请稍后重试", 0);
        com.bytedance.live.bizlink.impl.platform.manager.a r102 = this.f563796s.A0();
        if (r102 == null) goto L6;
        r102.d("stop_on_rtc_error");
        return;
    }

    @Override // hg6.o
    public final void l(String r100, Throwable r101) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r100, "userId");
        if (r101 == null) goto L5;
        com.bytedance.live.kmp.util.a.c(r101, "连线失败，请稍后重试");
    L5:
        uf0.d r102 = this.f545886d;
        if (r102 == null) goto L9;
        r102.a();
        return;
    }

    @Override // hg6.j
    public final void v5(IBaseUser r100, List<? extends e1> r101) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        uf0.c r102 = this.f545887e;
        if (r102 == null) goto L6;
        r102.v5(r100, r101);
        return;
    }

    public a(g r100, cg6.a r101, f r102, tc0.b r103, bn0.b r104, Context r105) {
        Intrinsics.checkNotNullParameter(r100, "roomDataService");
        Intrinsics.checkNotNullParameter(r101, "multiLinkComponentService");
        Intrinsics.checkNotNullParameter(r102, "hostService");
        Intrinsics.checkNotNullParameter(r103, "linkInRoomDataHolderKt");
        Intrinsics.checkNotNullParameter(r104, "multiLinkRoomScope");
        Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, r103, r104, r105);
        this.f563795r = r100;
        this.f563796s = r101;
        this.f563797t = r102;
        this.f563798u = r103;
        this.f563799v = r104;
        this.f563800w = r105;
        this.f563794q = new b(this);
    }
}
