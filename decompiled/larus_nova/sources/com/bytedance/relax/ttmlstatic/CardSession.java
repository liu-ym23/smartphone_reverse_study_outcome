package com.bytedance.relax.ttmlstatic;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.rts.kmp.foundation.i;
import com.bytedance.rts.kmp.foundation.p;
import com.bytedance.rts.kmp.foundation.r;
import com.lynx.rts.gen.BridgeCallback;
import com.lynx.rts.gen.RendererFunctionNG;
import com.lynx.tasm.StaticPageHost;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import s87.j;

/* JADX INFO: loaded from: classes21.dex */
public final class CardSession {
    public Function2<? super Map<String, ? extends Object>, Object, Boolean> A;
    public Function0<Unit> B;
    public Function0<Unit> C;
    public Function0<Unit> D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f267193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f267194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f267195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<Object, Unit> f267196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function1<Object, Unit> f267197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<Object, Unit> f267198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function1<Object, Unit> f267199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f267200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f267201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f267202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f267203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ArrayList<Function0<Unit>> f267204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f267205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f267206n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f267207o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f267208p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f267209q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f267210r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f267211s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f267212t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f267213u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f267214v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f267215w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ArrayList<Function0<Unit>> f267216x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f267217y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Function1<? super Map<String, ? extends Object>, Unit> f267218z;

    public final void c() {
        this.f267215w = false;
        int r100 = 0;
    L3:
        IntCompanionObject r101 = IntCompanionObject.INSTANCE;
        int r102 = i.a(this.f267216x);
        Intrinsics.checkNotNullParameter(r101, "<this>");
        if (r100 >= r102) goto L6;
        Function0 r103 = (Function0) ListProtector.get(this.f267216x, r100);
        r100 = r100 + 1;
        r103.invoke();
        goto L3
    L6:
        this.f267216x = i.b(new Function0[0]);
        this.f267215w = false;
    }

    public final void b() {
        if (this.f267209q == false) goto L5;
        return;
    L5:
        if (this.f267210r == false) goto L7;
        return;
    L7:
        if (this.f267212t == false) goto L9;
        return;
    L9:
        if (this.f267217y == false) goto L11;
        return;
    L11:
        if (this.f267215w == false) goto L42;
        this.f267217y = true;
    L32:
    L28:
        th = move-exception;
        this.f267217y = false;
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        throw th;
    L16:
        if (this.f267209q == true) goto L24;
        if (this.f267215w == false) goto L24;
        c();     // Catch: Throwable -> L28
        if (this.f267209q == true) goto L24;
        h r100 = this.f267193a;     // Catch: Throwable -> L28
        Map<String, Object> r101 = d.f267227a;     // Catch: Throwable -> L28
        Map r102 = TypeIntrinsics.asMutableMap(new LinkedHashMap());     // Catch: Throwable -> L28
        int r103 = com.bytedance.rts.kmp.foundation.g.f267611a;     // Catch: Throwable -> L28
        com.bytedance.rts.kmp.foundation.g.a.b(r102, "triggerDataUpdated", Boolean.TRUE);     // Catch: Throwable -> L28
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Any");     // Catch: Throwable -> L28
        Map r104 = r102;     // Catch: Throwable -> L28
        r100.h(r102);     // Catch: Throwable -> L28
        k();     // Catch: Throwable -> L28
    L24:
        this.f267217y = false;
        if (this.f267209q == false) goto L38;
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        return;
    L38:
        return;
    }

    public final void d() {
        String r100 = "";
        if (this.f267209q == false) goto L5;
        return;
    L5:
        this.f267209q = true;
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        this.f267217y = false;
        this.f267204l = i.b(new Function0[0]);
        this.f267205m = false;
        this.f267210r = false;
        this.f267212t = false;
        this.f267213u = false;
        this.f267214v = 0;
        if (this.f267201i == true) goto L8;
    L13:
        this.f267202j = false;
        this.f267200h = -1;
        this.f267201i = false;
        this.f267199g = null;
        this.f267194b.a();     // Catch: Throwable -> L16
        th = null;
    L61:
        Function0<Unit> r101 = this.B;     // Catch: Throwable -> L22
        if (r101 == null) goto L59;
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L22
        r101.invoke();     // Catch: Throwable -> L22
    L59:
    L51:
        th = move-exception;
        if (th == null) goto L58;
        int r102 = r.f267614a;
        Object[] r103 = new Object[1];
        Intrinsics.checkNotNullParameter(th, "<this>");
        String r104 = th.getMessage();
        if (r104 == null) goto L57;
        r100 = r104;
    L57:
        r103[0] = r100;
        r.a.a(r103);
    L58:
        throw th;
    L26:
        if (this.f267196d == null) goto L32;
        j r105 = this.f267195c;     // Catch: Throwable -> L51
        if (r105 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");     // Catch: Throwable -> L51
        r105 = null;
    L30:
        String r106 = d.f267230d;     // Catch: Throwable -> L51
        Function1<Object, Unit> r107 = this.f267196d;     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(r107);     // Catch: Throwable -> L51
        r105.e(r106, r107, d.f267229c);     // Catch: Throwable -> L51
    L32:
        if (this.f267197e == null) goto L38;
        j r108 = this.f267195c;     // Catch: Throwable -> L51
        if (r108 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");     // Catch: Throwable -> L51
        r108 = null;
    L36:
        String r109 = d.f267231e;     // Catch: Throwable -> L51
        Function1<Object, Unit> r110 = this.f267197e;     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L51
        r108.e(r109, r110, d.f267229c);     // Catch: Throwable -> L51
    L38:
        if (this.f267198f == null) goto L43;
        j r111 = this.f267195c;     // Catch: Throwable -> L51
        if (r111 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");     // Catch: Throwable -> L51
        r111 = null;
    L42:
        String r112 = d.f267232f;     // Catch: Throwable -> L51
        Function1<Object, Unit> r113 = this.f267198f;     // Catch: Throwable -> L51
        Intrinsics.checkNotNull(r113);     // Catch: Throwable -> L51
        r111.e(r112, r113, d.f267228b);     // Catch: Throwable -> L51
    L43:
        this.f267196d = null;     // Catch: Throwable -> L51
        this.f267197e = null;     // Catch: Throwable -> L51
        this.f267198f = null;     // Catch: Throwable -> L51
        this.f267218z = null;     // Catch: Throwable -> L51
        this.A = null;     // Catch: Throwable -> L51
        this.B = null;     // Catch: Throwable -> L51
        this.C = null;     // Catch: Throwable -> L51
        this.D = null;     // Catch: Throwable -> L51
        this.f267193a.g();     // Catch: Throwable -> L51
        if (th == null) goto L65;
        int r114 = r.f267614a;
        Object[] r115 = new Object[1];
        Intrinsics.checkNotNullParameter(th, "<this>");
        String r116 = th.getMessage();
        if (r116 == null) goto L49;
        r100 = r116;
    L49:
        r115[0] = r100;
        r.a.a(r115);
        return;
    L65:
        return;
    L22:
        th = move-exception;
        if (th != null) goto L59;
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type kotlin.Throwable{ com.bytedance.rts.kmp.foundation.RTSErrorKt.RTSError }");
        th = th;
    L16:
        th = th;
        Intrinsics.checkNotNull(th, "null cannot be cast to non-null type kotlin.Throwable{ com.bytedance.rts.kmp.foundation.RTSErrorKt.RTSError }");
        goto L61
    L8:
        if (this.f267200h < 0) goto L13;
        j r117 = this.f267195c;
        if (r117 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
        r117 = null;
    L12:
        r117.a(this.f267200h);
        goto L13
    }

    public final boolean g() {
        if (this.f267207o == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f267209q == true) goto L7;
        return true;
    }

    public final void k() {
        if (this.f267209q == false) goto L5;
        return;
    L5:
        if (this.f267202j == false) goto L7;
        return;
    L7:
        if (i.a(this.f267204l) == 0) goto L9;
    L11:
        final int r100 = this.f267203k + 1;
        this.f267203k = r100;
        this.f267202j = true;
        this.f267199g = d.d(new CardSession$scheduleReadyFrameCallback$1(this, r100));
        j r101 = this.f267195c;
        if (r101 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
        r101 = null;
    L14:
        Function1<Object, Unit> r102 = this.f267199g;
        Intrinsics.checkNotNull(r102);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = s87.e.f540981a;
        s87.i r104 = r101.f540987a;
        Intrinsics.checkNotNullParameter(r104, "renderer");
        Intrinsics.checkNotNullParameter(r102, "callback");
        long r105 = r104.a().I(s87.h.a(r102));
        if (this.f267202j == true) goto L17;
        return;
    L17:
        if (this.f267203k == r100) goto L19;
        return;
    L19:
        if (r105 < 0) goto L21;
        this.f267200h = r105;
        this.f267201i = false;
        return;
    L21:
        j r106 = this.f267195c;
        if (r106 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
        r106 = null;
    L24:
        Function1<Object, Unit> r107 = this.f267199g;
        Intrinsics.checkNotNull(r107);
        long r108 = r106.c(r107);
        if (this.f267202j == true) goto L27;
        return;
    L27:
        if (this.f267203k == r100) goto L29;
        return;
    L29:
        if (r108 < 0) goto L31;
        this.f267200h = r108;
        this.f267201i = true;
        return;
    L31:
        this.f267202j = false;
        this.f267200h = -1;
        this.f267201i = false;
        this.f267199g = null;
        this.f267204l = i.b(new Function0[0]);
        this.f267205m = false;
        return;
    L9:
        if (this.f267205m == true) goto L11;
    }

    public final h e() {
        return this.f267193a;
    }

    public CardSession(j r100) {
        Intrinsics.checkNotNullParameter(r100, "rendererFunction");
        this.f267200h = -1;
        this.f267204l = i.b(new Function0[0]);
        this.f267216x = i.b(new Function0[0]);
        this.f267195c = r100;
        this.f267193a = new h(r100);
        this.f267194b = new f();
    }

    public final void h(Function0<Unit> r100) {
        if (g() == true) goto L5;
        return;
    L5:
        i.f(this.f267216x, r100);
        this.f267215w = true;
        if (this.f267210r == false) goto L8;
        return;
    L8:
        if (this.f267212t == false) goto L10;
        return;
    L10:
        if (this.f267214v != 0) goto L15;
        b();
        return;
    }

    public final void i(Map<String, ? extends Object> r100) {
        if (this.f267209q == false) goto L5;
        return;
    L5:
        if (this.f267207o == false) goto L7;
        return;
    L7:
        if (this.f267208p == true) goto L42;
        boolean r101 = true;
        this.f267207o = true;
        this.f267210r = true;
        this.f267211s = false;     // Catch: Throwable -> L35
        if (r100 == null) goto L33;
        Function1<? super Map<String, ? extends Object>, Unit> r102 = this.f267218z;     // Catch: Throwable -> L35
        if (r102 == null) goto L33;
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L35
        r102.invoke(r100);     // Catch: Throwable -> L35
        if (this.f267211s == false) goto L18;
    L21:
        boolean r103 = !this.f267211s;
        this.f267210r = false;
        this.f267211s = false;
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        this.f267217y = false;
        if (r103 == true) goto L25;
        this.f267204l = i.b(new Function0[0]);
        this.f267205m = false;
        this.f267207o = false;
        this.f267208p = true;
    L25:
        if (r103 == true) goto L28;
        return;
    L28:
        if (this.C != null) goto L31;
        r101 = false;
    L31:
        this.f267205m = r101;
        k();
        return;
    L18:
        if (this.f267215w == false) goto L21;
        c();     // Catch: Throwable -> L35
    L33:
        this.f267210r = false;
        this.f267211s = false;
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        this.f267217y = false;
        this.f267204l = i.b(new Function0[0]);
        this.f267205m = false;
        this.f267207o = false;
        this.f267208p = true;
        return;
    L35:
        th = move-exception;
        this.f267210r = false;
        this.f267211s = false;
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        this.f267217y = false;
        this.f267204l = i.b(new Function0[0]);
        this.f267205m = false;
        this.f267207o = false;
        this.f267208p = true;
        throw th;
    }

    public final void j(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        if (g() == true) goto L5;
        return;
    L5:
        this.f267214v++;
        r100.invoke();     // Catch: Throwable -> L15
        int r101 = this.f267214v - 1;
        this.f267214v = r101;
        if (r101 == 0) goto L10;
        return;
    L10:
        if (this.f267215w == true) goto L12;
        return;
    L12:
        if (this.f267212t == true) goto L28;
        b();
        return;
    L28:
        return;
    L15:
        th = move-exception;
        this.f267214v--;
        if (this.f267214v == 0) goto L19;
    L23:
        throw th;
    L19:
        if (this.f267215w == false) goto L23;
        if (this.f267212t == true) goto L23;
        b();
        goto L23
    }

    public final void a(Map<String, ? extends Object> r100, Object r101) {
        if (this.f267209q == false) goto L5;
        return;
    L5:
        if (this.f267207o == false) goto L45;
        this.f267212t = true;
        this.f267213u = false;
        Function2<? super Map<String, ? extends Object>, Object, Boolean> r102 = this.A;     // Catch: Throwable -> L35
        if (r102 == null) goto L11;
        Intrinsics.checkNotNull(r102);     // Catch: Throwable -> L35
        boolean r103 = r102.invoke(r100, r101).booleanValue();     // Catch: Throwable -> L35
    L13:
        if (this.f267213u == true) goto L18;
        if (r103 == false) goto L18;
        if (this.f267215w == false) goto L18;
        c();     // Catch: Throwable -> L35
    L18:
        this.f267212t = false;
        if (this.f267213u == true) goto L21;
        if (r103 == false) goto L21;
    L23:
        if (this.f267213u == false) goto L25;
        return;
    L25:
        if (this.f267209q == true) goto L44;
        if (r103 == false) goto L30;
        this.f267193a.h(r101);
        k();
    L30:
        if (this.f267209q == true) goto L42;
        Function0<Unit> r104 = this.D;
        if (r104 == null) goto L43;
        Intrinsics.checkNotNull(r104);
        j(r104);
        return;
    L43:
        return;
    L42:
        return;
    L44:
        return;
    L21:
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        goto L23
    L11:
        r103 = false;
    L35:
        th = move-exception;
        this.f267212t = false;
        this.f267215w = false;
        this.f267216x = i.b(new Function0[0]);
        throw th;
    }

    public final void l(Function1 r100, Function2 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "onRender");
        boolean r103 = false;
        if (this.f267206n == false) goto L6;
        int r104 = r.f267614a;
        r.a.a(new Object[]{"[TTML Static] CardSession.start() may only be called once."});
        return;
    L6:
        this.f267206n = true;
        this.f267218z = r100;
        this.A = r101;
        this.B = r102;
        j r105 = null;
        this.C = null;
        this.D = null;
        int r106 = t87.d.f545057a;
        j r107 = this.f267195c;
        if (r107 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
        r107 = null;
    L9:
        Intrinsics.checkNotNullParameter(this, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r107, "renderer");
        Intrinsics.checkNotNullParameter(this, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r107, "renderer");
        r107.getClass();
        int r108 = s87.e.f540981a;
        s87.i r109 = r107.f540987a;
        Intrinsics.checkNotNullParameter(r109, "renderer");
        int r110 = r109.a().D();
        t87.a r111 = new t87.a(this, r107);
        StaticPageHost r112 = StaticPageHost.c(r110);
        if (r112 == null) goto L28;
        Object r113 = r112.f381759a;
        monitor-enter(r113);
    L25:
        th = move-exception;
        throw th;
    L14:
        if (r112.f381762d == true) goto L16;
    L21:
        monitor-exit(r113);     // Catch: Throwable -> L25
        boolean r114 = false;
    L23:
        if (r114 == false) goto L28;
        boolean r115 = true;
    L29:
        if (r115 == false) goto L32;
        s87.i r116 = r107.f540987a;
        Intrinsics.checkNotNullParameter(r116, "renderer");
        r116.a().f();
        r103 = true;
    L32:
        if (r103 == false) goto L34;
        return;
    L34:
        this.f267196d = d.d(new CardSession$start$1(this));
        this.f267197e = d.d(new CardSession$start$2(this));
        this.f267198f = d.d(new CardSession$start$3(this));
        j r117 = this.f267195c;
        if (r117 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
        r117 = null;
    L37:
        String r118 = d.f267230d;
        Function1<Object, Unit> r119 = this.f267196d;
        Intrinsics.checkNotNull(r119);
        int r120 = d.f267229c;
        r117.d(r118, r119, r120);
        j r121 = this.f267195c;
        if (r121 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
        r121 = null;
    L40:
        String r122 = d.f267231e;
        Function1<Object, Unit> r123 = this.f267197e;
        Intrinsics.checkNotNull(r123);
        r121.d(r122, r123, r120);
        j r124 = this.f267195c;
        if (r124 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
    L44:
        String r125 = d.f267232f;
        Function1<Object, Unit> r126 = this.f267198f;
        Intrinsics.checkNotNull(r126);
        r105.d(r125, r126, d.f267228b);
        return;
    L43:
        r105 = r124;
        goto L44
    L16:
        if (r112.f381766h != null) goto L21;
        r112.f381766h = r111;     // Catch: Throwable -> L25
        monitor-exit(r113);     // Catch: Throwable -> L25
        r114 = true;
    L28:
        r115 = false;
        goto L29
    }

    public static Object f(CardSession r100, String r101, ArrayList r102, final Function1 r103, int r110) {
        if ((r110 & 8) == 0) goto L5;
        r103 = null;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter("ProfileEditHostModule", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        if (r100.g() == false) goto L20;
        if (r103 == null) goto L10;
        final p r104 = new p(r100);
        final Function1<Object, Unit> r105 = new CardSession$wrapNativeModuleCallback$wrapped$1(r104, r103);
    L11:
        j r106 = r100.f267195c;
        if (r106 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("rendererFunction");
        r106 = null;
    L14:
        r106.getClass();
        Intrinsics.checkNotNullParameter("ProfileEditHostModule", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        int r107 = s87.e.f540981a;
        s87.i r108 = r106.f540987a;
        Intrinsics.checkNotNullParameter(r108, "renderer");
        Intrinsics.checkNotNullParameter("ProfileEditHostModule", TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        Intrinsics.checkNotNullParameter(r102, "params");
        RendererFunctionNG r109 = r108.a();
        AtomicLong r111 = s87.h.f540984a;
        if (r105 == null) goto L17;
        BridgeCallback r112 = new s87.f(r105);
    L19:
        return r109.a("ProfileEditHostModule", r101, r102, r112, null);
    L17:
        r112 = null;
        goto L19
    L10:
        r105 = null;
        goto L11
    L20:
        return null;
    }
}
