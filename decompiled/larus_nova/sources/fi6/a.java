package fi6;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.livesdk.live.extension.plugin.api.rtc.engine.live.LiveWrappedMixedStreamPushMode;
import com.bytedance.live.livelink.kmp.api.base.config.ChannelProfile;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.bytedance.live.livelink.kmp.api.base.video.ViewType;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import qi6.g;
import ti6.h;
import ti6.j;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final /* synthetic */ int f477370n0 = 0;
    public String A;
    public String B;
    public StreamType C;
    public Character D;
    public ViewType E;
    public g F;
    public InteractMode G;
    public final boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f477371J;
    public boolean K;
    public boolean L;
    public List<Integer> M;
    public int N;
    public boolean O;
    public boolean P;
    public int Q;
    public boolean R;
    public int S;
    public final h T;
    public MixStreamType U;
    public String V;
    public boolean W;
    public final boolean X;
    public Env Y;
    public boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f477372a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f477373a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f477374b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f477375b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f477376c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public String f477377c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f477378d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f477379d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f477380e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f477381e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f477382f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f477383f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f477384g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f477385g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f477386h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f477387h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f477388i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f477389i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f477390j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f477391j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f477392k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public String f477393k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f477394l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f477395l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f477396m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f477397m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f477398n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f477399o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f477400p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public LiveWrappedMixedStreamPushMode f477401q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f477402r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f477403s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f477404t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Object f477405u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f477406v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f477407w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f477408x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f477409y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f477410z;

    /* JADX INFO: renamed from: fi6.a$a, reason: collision with other inner class name */
    public static final class C5913a {
    }

    static {
    }

    public final int a() {
        String r100 = this.f477384g;
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
        return 0;
    L5:
        if (StringsKt.startsWith$default(r100, "#", false, 2, null) == false) goto L14;
        if (r100 == null) goto L9;
        r100 = r100.substring(1);
        goto L14
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L14:
        return CastIntegerProtector.parseInt(r100, CharsKt.checkRadix(16));
    L17:
        return 0;
    }

    public final boolean b() {
        MixStreamType r100 = this.U;
        if (r100 != MixStreamType.CLIENT_MIX) goto L5;
    L8:
        return true;
    L5:
        if (r100 == MixStreamType.RTC_CLIENT_MIX) goto L8;
        return false;
    }

    public a() {
        this.f477376c = true;
        this.f477384g = "";
        this.f477386h = "";
        this.f477398n = 18;
        this.f477399o = "";
        this.f477401q = LiveWrappedMixedStreamPushMode.ON_STREAM;
        this.f477404t = 2000;
        this.f477406v = SliceInitService.DEFAULT_SWITCH;
        this.f477407w = "";
        this.f477408x = "";
        this.f477409y = "";
        this.f477410z = "";
        this.A = "";
        this.B = "";
        this.C = StreamType.VIDEO;
        this.D = Character.GUEST;
        this.E = ViewType.SURFACE_VIEW;
        g r100 = g.f533173g;
        this.F = g.f533174h;
        this.G = InteractMode.NORMAL;
        this.H = true;
        this.I = true;
        this.K = true;
        this.L = true;
        new ArrayList();
        this.O = true;
        this.P = true;
        this.Q = 1000;
        this.S = 5;
        this.T = new h();
        this.U = MixStreamType.NONE;
        ChannelProfile r101 = ChannelProfile.CHANNEL_PROFILE_COMMUNICATION;
        this.W = true;
        this.X = true;
        this.Y = Env.ENV_PRODUCT;
        this.f477373a0 = true;
        zi6.a.d r102 = zi6.a.d.f572255a;
        this.f477381e0 = true;
        this.f477383f0 = true;
        this.f477385g0 = true;
        this.f477387h0 = true;
        this.f477389i0 = true;
        this.f477391j0 = true;
    }

    public final Object getContext() {
        return this.f477405u;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f477410z = r100;
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "version");
        this.B = r100;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "version");
        this.A = r100;
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "color");
        this.f477384g = r100;
    }

    public final void g(Character r100) {
        Intrinsics.checkNotNullParameter(r100, "character");
        this.D = r100;
    }

    public final void h(Object r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f477405u = r100;
    }

    public final void i(InteractMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.G = r100;
    }

    public final void j(MixStreamType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.U = r100;
    }

    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "rtcABTestConfig");
        this.f477386h = r100;
    }

    public final void l(Env r100) {
        Intrinsics.checkNotNullParameter(r100, "env");
        this.Y = r100;
    }

    public final void m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        this.f477406v = r100;
    }

    public final void n(StreamType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.C = r100;
    }

    public final void o(g r100) {
        Intrinsics.checkNotNullParameter(r100, GearStrategyConsts.EV_QUALITY);
        int r101 = r100.f533180c;
        boolean r102 = this.K;
        int r103 = 2;
        if (r102 == false) goto L5;
        int r104 = 16;
    L6:
        int r105 = (((r101 + r104) - 1) / r104) * r104;
        int r106 = r100.f533181d;
        if (r102 == false) goto L9;
        r103 = 16;
    L9:
        this.F = new g(r105, (((r106 + r103) - 1) / r103) * r103, r100.f533182e, r100.f533183f);
        return;
    L5:
        r104 = 2;
        goto L6
    }
}
