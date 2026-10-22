package com.larus.settings.value;

import au9.i;
import au9.s;
import av9.h;
import com.larus.common.apphost.AppHost;
import com.larus.network.config.BackgroundControlConfig;
import com.larus.platform.model.LuckyDogControlSettings;
import com.larus.platform.model.bot.MultiBotsCapability;
import com.larus.platform.model.bot.MultiBotsOfflineConfig;
import com.larus.platform.model.bot.MultiBotsPointSwitches;
import com.larus.platform.model.mainbot.ECommerceSettingsConfig;
import com.larus.settings.provider.account.LarkAuthConfig;
import com.larus.settings.provider.bootprotector.BootProtectorConfig;
import com.larus.settings.provider.chat.UserPromptHoverConfig;
import com.larus.settings.provider.dora.WakeupComfortConfig;
import com.larus.settings.provider.health.HealthFirstPartyApplicationConfig;
import com.larus.settings.provider.perf.SuperThreadConfig;
import com.larus.utils.l0;
import cv9.e;
import dv9.c;
import ft9.d;
import hq9.d4;
import hq9.e1;
import hq9.e5;
import hq9.k;
import hq9.k1;
import hq9.y0;
import hu9.b;
import hu9.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nu9.o;
import nu9.r;
import org.xmlpull.v1.XmlPullParser;
import ot9.n;
import ot9.p;
import qt9.c0;
import qt9.g;
import qt9.o0;
import qt9.u0;
import qt9.v;
import qt9.x;
import qt9.z3;
import rt9.j;
import uq9.f;
import vt9.v0;
import zv9.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e10 {
    public static final e10 a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;
    public static final Lazy d = null;
    public static volatile long e;
    public static final Lazy f = null;

    public e10() {
    }

    public static List I0() {
        return CollectionsKt.mutableListOf(new Integer[]{21, 2, 5, 27, 1, 30, 34});
    }

    static {
        a = new e10();
        b = LazyKt.lazy(new a());
        c = LazyKt.lazy(new h3());
        d = LazyKt.lazy(new o7());
        e = -1;
        f = LazyKt.lazy(new vb());
    }

    public static BackgroundControlConfig A() {
        int r0 = l0.a;
        return (BackgroundControlConfig) l0.a(new BackgroundControlConfig(null, null, null, null, null, null, 63, null), new a00());
    }

    @Deprecated(message = "tab style not use appSetting to config, use tabbar/config api", replaceWith = @ReplaceWith(expression = "BottomTabConfigManager", imports = {}))
    public static c A0() {
        int r0 = l0.a;
        return (c) l0.a(new c(), new k6());
    }

    public static zt9.a B() {
        return (zt9.a) l0.a(new zt9.a(0), new r7());
    }

    public static boolean B0() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new xq())).booleanValue();
    }

    public static BootProtectorConfig C() {
        int r0 = l0.a;
        return (BootProtectorConfig) l0.a(new BootProtectorConfig(null, null, null, null, null, null, null, 127, null), new jh());
    }

    public static boolean C0() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new c10())).booleanValue();
    }

    public static v D() {
        int r0 = l0.a;
        return (v) l0.a(new v(), new yp());
    }

    public static k D0() {
        return (k) l0.a(new k(0), new r8());
    }

    public static x E() {
        int r0 = l0.a;
        return (x) l0.a(new x(), new h8());
    }

    public static boolean E0() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new sn())).booleanValue();
    }

    public static int F() {
        int r0 = l0.a;
        Integer r1 = ((i) l0.a(new i(0), new e9())).a();
        if (r1 != null) goto L5;
        return 0;
    L5:
        return r1.intValue();
    }

    public static int F0() {
        int r0 = l0.a;
        return ((Number) l0.a(1, new v7())).intValue();
    }

    public static av9.a G() {
        return (av9.a) l0.a(new av9.a(0), new c4());
    }

    public static LuckyDogControlSettings G0() {
        int r0 = l0.a;
        return (LuckyDogControlSettings) l0.a(new LuckyDogControlSettings(false, false, null, false, false, 31, null), new ws());
    }

    public static c0 H() {
        return (c0) l0.a(new c0(0), new om());
    }

    public static MultiBotsCapability H0() {
        MultiBotsCapability.a r0 = MultiBotsCapability.Companion;
        int r1 = l0.a;
        MultiBotsOfflineConfig r2 = (MultiBotsOfflineConfig) l0.a(new MultiBotsOfflineConfig(null, 1, null), new n3());
        r0.getClass();
        if (r2 == null) goto L6;
        MultiBotsPointSwitches r3 = r2.getPointSwitches();
        if (r3 == null) goto L6;
    L7:
        int r4 = r3.getProfileBotTabVisibility();
        if (r4 == 0) goto L13;
        if (r4 == 1) goto L13;
        if (r4 == 2) goto L13;
        int r10 = 2;
    L15:
        return new MultiBotsCapability(r3.getHideSidebarBotAsset(), r3.getHideBottomTabDiscovery(), r3.getDisableBotCreateEntry(), r3.getHideCreatePermissionEntry(), r3.getDisableBotDescPolish(), r3.getHideProfileBotTab(), r10, r3.getDisableBotShare(), r3.getDisableBotLinkLanding(), r3.getDisableBotLikeCommentActionbar());
    L13:
        r10 = r3.getProfileBotTabVisibility();
    L6:
        r3 = new MultiBotsPointSwitches(false, false, false, false, false, false, 0, false, false, false, 1023, null);
        goto L7
    }

    public static uu9.a I() {
        int r0 = l0.a;
        return (uu9.a) l0.a(new uu9.a(0), new oe());
    }

    public static b J() {
        return (b) l0.a(new b(false, false, false), new h0());
    }

    public static mv9.a J0() {
        int r0 = l0.a;
        return (mv9.a) l0.a(new mv9.a(), new op());
    }

    public static int K() {
        int r0 = l0.a;
        return ((Number) l0.a(0, new tj())).intValue();
    }

    public static String K0() {
        return (String) l0.a(XmlPullParser.NO_NAMESPACE, new jr());
    }

    public static du9.c0 L() {
        return (du9.c0) l0.a(new du9.c0(0), new je());
    }

    public static boolean L0() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new bj())).booleanValue();
    }

    public static nu9.i M() {
        int r0 = l0.a;
        return (nu9.i) l0.a(new nu9.i(), new ca());
    }

    public static boolean N() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new o0())).booleanValue();
    }

    public static int O() {
        int r0 = l0.a;
        return ((Number) l0.a(10, new dj())).intValue();
    }

    public static r P() {
        int r0 = l0.a;
        return (r) l0.a(new r(0), new g5());
    }

    public static o Q() {
        int r0 = l0.a;
        return (o) l0.a(new o(), new i4());
    }

    public static f R() {
        return (f) l0.a(new f(0), new in());
    }

    public static ECommerceSettingsConfig S() {
        int r0 = l0.a;
        new e();
        return (ECommerceSettingsConfig) l0.a(e.a(), new nf());
    }

    public static u0 T() {
        return (u0) l0.a(new u0(null), new e6());
    }

    public static qv9.f U() {
        qv9.f r0 = (qv9.f) l0.a(null, new zl());
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new qv9.f(0);
    }

    public static e1 V() {
        int r0 = l0.a;
        return (e1) l0.a(new e1(null), new zv());
    }

    public static k1 W() {
        return (k1) l0.a(new k1(0), new kd());
    }

    public static HealthFirstPartyApplicationConfig X() {
        int r0 = l0.a;
        return (HealthFirstPartyApplicationConfig) l0.a(new HealthFirstPartyApplicationConfig(null, null, null, null, null, null, 63, null), new k());
    }

    public static kt9.b Y() {
        int r0 = l0.a;
        return (kt9.b) l0.a(new kt9.b(0), new tt());
    }

    public static LarkAuthConfig Z() {
        int r0 = l0.a;
        return (LarkAuthConfig) l0.a(new LarkAuthConfig(0, 0, false, null, false, false, null, false, 0.0f, 511, null), new mm());
    }

    public static rt9.a a() {
        int r0 = l0.a;
        return (rt9.a) l0.a(new rt9.a(0), new d8());
    }

    public static Map a0() {
        int r0 = l0.a;
        return (Map) l0.a(d.a, new mv());
    }

    public static boolean b() {
        int r0 = l0.a;
        if (((Boolean) l0.a(Boolean.valueOf(!AppHost.a.isOversea()), new mc())).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (H0().getDisableBotCreateEntry() == true) goto L7;
        return true;
    }

    public static vq9.b b0() {
        int r0 = l0.a;
        return (vq9.b) l0.a(new vq9.b(null), new ep());
    }

    public static boolean c() {
        int r0 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new fj())).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (H0().getDisableBotDescPolish() == true) goto L7;
        return true;
    }

    public static List c0() {
        int r0 = l0.a;
        return (List) l0.a(new ArrayList(), new g4());
    }

    public static boolean d() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new l9())).booleanValue();
    }

    public static n d0() {
        return (n) l0.a(new n(0), new e2());
    }

    public static o0 e() {
        int r0 = l0.a;
        return (o0) l0.a(new o0(), new hw());
    }

    public static ot9.o e0() {
        int r0 = l0.a;
        return (ot9.o) l0.a(new ot9.o(null), new a1());
    }

    public static y0 f() {
        int r0 = l0.a;
        return (y0) l0.a(new y0(), new qb());
    }

    public static p f0() {
        return (p) l0.a(new p(0), new ar());
    }

    public static boolean g() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new rd())).booleanValue();
    }

    public static nu9.x g0() {
        int r0 = l0.a;
        return (nu9.x) l0.a(new nu9.x(0), new yj());
    }

    public static boolean h() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.valueOf(!AppHost.a.isOversea()), new hg())).booleanValue();
    }

    public static j h0() {
        return (j) l0.a(new j(0), new m());
    }

    public static boolean i() {
        int r0 = l0.a;
        if (((Boolean) l0.a(Boolean.FALSE, new v())).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (h() == false) goto L7;
        return true;
    }

    public static lv9.a i0() {
        return (lv9.a) l0.a(new lv9.a(0), new s1());
    }

    public static boolean j() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new lo())).booleanValue();
    }

    public static qv9.r j0() {
        int r0 = l0.a;
        return (qv9.r) l0.a(new qv9.r(0), new qq());
    }

    public static boolean k() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new k2())).booleanValue();
    }

    public static nr9.d k0() {
        return (nr9.d) l0.a(new nr9.d(0), new ff());
    }

    public static boolean l() {
        int r0 = l0.a;
        return Intrinsics.areEqual(((i) l0.a(new i(0), new e9())).b(), Boolean.TRUE);
    }

    public static d4 l0() {
        return (d4) l0.a(new d4(0), new x5());
    }

    public static boolean m() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new ei())).booleanValue();
    }

    public static z3 m0() {
        return (z3) l0.a(new z3(null), new pq());
    }

    public static boolean n() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new yd())).booleanValue();
    }

    public static v0 n0() {
        return (v0) b.getValue();
    }

    public static boolean o() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.FALSE, new gg())).booleanValue();
    }

    public static uu9.d o0() {
        return (uu9.d) l0.a(new uu9.d(0), new sj());
    }

    public static boolean p() {
        int r0 = l0.a;
        return ((Boolean) l0.a(Boolean.TRUE, new md())).booleanValue();
    }

    public static uu9.f p0() {
        return (uu9.f) l0.a(new uu9.f(0), new se());
    }

    public static ir9.c q() {
        return (ir9.c) l0.a(new ir9.c(0), new x3());
    }

    public static SuperThreadConfig q0() {
        int r0 = l0.a;
        return (SuperThreadConfig) l0.a(new SuperThreadConfig(null, null, null, null, null, null, null, null, 255, null), new gz());
    }

    public static ir9.a r() {
        int r0 = l0.a;
        new cu9.a();
        return (ir9.a) l0.a(new ir9.a(0), new cy());
    }

    public static u r0() {
        int r0 = l0.a;
        new zv9.v();
        return (u) l0.a(zv9.v.a(), new xx());
    }

    public static com.larus.platform.model.chat.a s() {
        return (com.larus.platform.model.chat.a) l0.a(new com.larus.platform.model.chat.a(0), new e1());
    }

    public static s s0() {
        int r0 = l0.a;
        return (s) l0.a(new s(null, null, 31), new o9());
    }

    public static hq9.e t() {
        int r0 = l0.a;
        return (hq9.e) l0.a(new hq9.e(null), new su());
    }

    public static hw9.b t0() {
        int r0 = l0.a;
        return (hw9.b) l0.a(new hw9.b(null), new kf());
    }

    public static lu9.a u() {
        int r0 = l0.a;
        return (lu9.a) l0.a(new lu9.a(null), new b5());
    }

    public static z u0() {
        int r0 = l0.a;
        return (z) l0.a(new z(false, false, false, false, 63), new d2());
    }

    public static oq9.a v() {
        return (oq9.a) l0.a(new oq9.a(0), new re());
    }

    public static UserPromptHoverConfig v0() {
        int r0 = l0.a;
        return (UserPromptHoverConfig) l0.a(new UserPromptHoverConfig(false, 0, false, 7, null), new o3());
    }

    public static pt9.a w() {
        int r0 = l0.a;
        return (pt9.a) l0.a(new pt9.a(0), new zk());
    }

    public static WakeupComfortConfig w0() {
        int r0 = l0.a;
        new nu9.c0();
        return (WakeupComfortConfig) l0.a(nu9.c0.a(), new sb());
    }

    public static pt9.e x() {
        return (pt9.e) l0.a(new pt9.e(0), new s4());
    }

    public static e5 x0() {
        return (e5) l0.a(new e5(0), new h7());
    }

    public static g y() {
        int r0 = l0.a;
        return (g) l0.a(new g(null), new eq());
    }

    public static h y0() {
        return (h) l0.a(new h(0), new qu());
    }

    public static vt9.o z() {
        int r0 = l0.a;
        return (vt9.o) l0.a(new vt9.o(null, null, null, 524287), new oh());
    }

    public static dv9.a z0() {
        int r0 = l0.a;
        return (dv9.a) l0.a(new dv9.a(), new n());
    }
}
