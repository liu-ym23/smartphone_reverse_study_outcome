package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.base.settings.AnnieXRedirectRules;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.sdk.xbridge.cn.utils.ConvertUtils;
import com.google.gson.Gson;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, ? extends Object> f247892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, ? extends Object> f247893b;

    public static final boolean A() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.y0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean B() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.z0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean C() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.B0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean D() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L9;
        d r102 = r101.a0();
        if (r102 == null) goto L9;
        if (r102.f247828l != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean E() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L9;
        d r102 = r101.a0();
        if (r102 == null) goto L9;
        if (r102.A0 != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean F() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.H0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean G() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return r102.I0();
    L7:
        return true;
    }

    public static final boolean H() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.J0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean I() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.O0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean J() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.P0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return false;
    }

    public static final boolean K() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.R0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean L() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.T0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean M() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.W0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean N() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.i2();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean O() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.Z0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean P() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.a1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean Q() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.f1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final void R() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L6;
        r101.a0();
        return;
    }

    public static final boolean S() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.j2();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final void T() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L6;
        r101.a0();
        return;
    }

    public static final boolean U() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L9;
        d r102 = r101.a0();
        if (r102 == null) goto L9;
        if (r102.f247853x0 != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean V() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.i1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean W() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.n1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean X() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.p1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean Y() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.t1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean Z() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.u1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final int a() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Integer r103 = r102.k();
        if (r103 == null) goto L9;
        return r103.intValue();
    L9:
        return 300;
    }

    public static final boolean a0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return Intrinsics.areEqual(r102.v1(), Boolean.TRUE);
    L7:
        return false;
    }

    public static final int b() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Integer r103 = r102.l();
        if (r103 == null) goto L9;
        return r103.intValue();
    L9:
        return 300;
    }

    public static final boolean b0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return Intrinsics.areEqual(r102.w1(), Boolean.TRUE);
    L7:
        return false;
    }

    public static final int c() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Integer r103 = r102.p();
        if (r103 == null) goto L9;
        return r103.intValue();
    L9:
        return 102400;
    }

    public static final boolean c0() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L7;
        d r102 = r101.a0();
        if (r102 == null) goto L7;
        return r102.f247822i;
    L7:
        return true;
    }

    public static final boolean d() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return r102.q();
    L7:
        return false;
    }

    public static final boolean d0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return Intrinsics.areEqual(r102.x1(), Boolean.TRUE);
    L7:
        return false;
    }

    public static final boolean e() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.r();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean e0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.H1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean f() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.x();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return false;
    }

    public static final boolean f0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.J1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return false;
    }

    public static final boolean g() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.B();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return false;
    }

    public static final boolean h() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L9;
        d r102 = r101.a0();
        if (r102 == null) goto L9;
        if (r102.C0 != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean i() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.F();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean j() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L7;
        d r102 = r101.a0();
        if (r102 == null) goto L7;
        return r102.f247851w0;
    L7:
        return true;
    }

    public static final boolean j0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.N1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean k() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return Intrinsics.areEqual(r102.H(), Boolean.TRUE);
    L7:
        return false;
    }

    public static final void k0() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L6;
        r101.a0();
        return;
    }

    public static final boolean l() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.O();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean l0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return Intrinsics.areEqual(r102.O1(), Boolean.TRUE);
    L7:
        return false;
    }

    public static final boolean m() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.R();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean m0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.P1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean n() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.T();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean n0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.T1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean o() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.V();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean o0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        boolean r103 = Intrinsics.areEqual(r102.V1(), Boolean.FALSE);
    L9:
        return !r103;
    L7:
        r103 = false;
        goto L9
    }

    public static final boolean p() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L7;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L7;
        return Intrinsics.areEqual(r102.X(), Boolean.TRUE);
    L7:
        return false;
    }

    public static final boolean p0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.Y1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean q() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.Z();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean q0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.b2();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean r() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.a0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean r0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.c2();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean s() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.b0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean t() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.f0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean u() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.g0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean u0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.j1();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean v() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.i0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final List<String> v0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L12;
        w26.h r102 = (w26.h) r101.n0(w26.h.class);
        if (r102 == null) goto L12;
        w26.h.b r103 = r102.g();
        if (r103 == null) goto L12;
        List<String> r104 = r103.a();
        if (r104 == null) goto L12;
        return r104;
    L12:
        return CollectionsKt.emptyList();
    }

    public static final void w() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L6;
        r101.a0();
        return;
    }

    public static final List<String> w0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L12;
        w26.h r102 = (w26.h) r101.n0(w26.h.class);
        if (r102 == null) goto L12;
        w26.h.b r103 = r102.g();
        if (r103 == null) goto L12;
        List<String> r104 = r103.b();
        if (r104 == null) goto L12;
        return r104;
    L12:
        return CollectionsKt.emptyList();
    }

    public static final boolean x() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.m0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean x0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.m2();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final void y() {
        s26.d r100 = s26.d.f540305c;
        m0 r101 = (m0) s26.d.f540305c.c(m0.class);
        if (r101 == null) goto L6;
        r101.a0();
        return;
    }

    public static final boolean y0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.n2();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean z() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.s0();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean z0() {
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L9;
        w26.e r102 = (w26.e) r101.n0(w26.e.class);
        if (r102 == null) goto L9;
        Boolean r103 = r102.t2();
        if (r103 == null) goto L9;
        return r103.booleanValue();
    L9:
        return true;
    }

    public static final boolean A0(Integer r100) {
        if (r100 == null) goto L10;
        int r101 = r100.intValue();
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;
        w26.g r103 = (w26.g) x26.a.a(w26.g.class);
        if (r103 == null) goto L10;
        w26.e r104 = (w26.e) r103.n0(w26.e.class);
        if (r104 == null) goto L10;
        List<Integer> r105 = r104.l2();
        if (r105 == null) goto L10;
        return r105.contains(Integer.valueOf(r101));
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean g0(BulletContext r100) {
        Integer r101 = null;
        if (r100 == null) goto L7;
        t36.d r102 = r100.f246437e;
        if (r102 == null) goto L7;
        r101 = (Integer) new y36.d(r102, "web_domain_party", null).f565862b;
    L7:
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.intValue() == 1) goto L11;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean h0(t36.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        Integer r101 = (Integer) new y36.d(r100, "web_domain_party", null).f565862b;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.intValue() == 1) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean i0(BulletContext r100) {
        if (r100 == null) goto L8;
        t36.d r101 = r100.f246437e;
        if (r101 == null) goto L8;
        Boolean r102 = (Boolean) new y36.a(r101, "enable_third_party_web_ui", Boolean.FALSE).f565862b;
        if (r102 == null) goto L8;
        return r102.booleanValue();
    L8:
        return false;
    }

    public static final Object s0(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        if (f247893b != null) goto L10;
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;     // Catch: Throwable -> L18
        w26.g r103 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L18
        if (r103 == null) goto L8;
        AnnieXRedirectRules r104 = (AnnieXRedirectRules) r103.n0(AnnieXRedirectRules.class);     // Catch: Throwable -> L18
    L9:
        f247893b = Collections.synchronizedMap(ConvertUtils.INSTANCE.jsonToMap(new JSONObject(new Gson().toJson(r104))));     // Catch: Throwable -> L18
        goto L10
    L8:
        r104 = null;
    L10:
        if (r100 != null) goto L12;
        Object r105 = f247893b;     // Catch: Throwable -> L18
    L16:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r106) == false) goto L24;
        return null;
    L24:
        return r106;
    L12:
        Map<String, ? extends Object> r107 = f247893b;     // Catch: Throwable -> L18
        if (r107 == null) goto L15;
        r105 = r107.get(r100);     // Catch: Throwable -> L18
        goto L16
    L15:
        r105 = null;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }

    public static final Object t0(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L18
        if (f247892a != null) goto L10;
        Map<String, Map<Class<?>, Object>> r102 = x26.a.f562251a;     // Catch: Throwable -> L18
        w26.g r103 = (w26.g) x26.a.a(w26.g.class);     // Catch: Throwable -> L18
        if (r103 == null) goto L8;
        com.bytedance.ies.bullet.base.settings.e r104 = (com.bytedance.ies.bullet.base.settings.e) r103.n0(com.bytedance.ies.bullet.base.settings.e.class);     // Catch: Throwable -> L18
    L9:
        f247892a = Collections.synchronizedMap(ConvertUtils.INSTANCE.jsonToMap(new JSONObject(new Gson().toJson(r104))));     // Catch: Throwable -> L18
        goto L10
    L8:
        r104 = null;
    L10:
        if (r100 != null) goto L12;
        Object r105 = f247892a;     // Catch: Throwable -> L18
    L16:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L18
    L21:
        if (Result.m9455isFailureimpl(r106) == false) goto L24;
        return null;
    L24:
        return r106;
    L12:
        Map<String, ? extends Object> r107 = f247892a;     // Catch: Throwable -> L18
        if (r107 == null) goto L15;
        r105 = r107.get(r100);     // Catch: Throwable -> L18
        goto L16
    L15:
        r105 = null;
    L18:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L21
    }
}
