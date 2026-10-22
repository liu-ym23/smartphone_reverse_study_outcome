package yh3;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.CheckOrderTriggerOrigin;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.CheckStatus;
import com.bytedance.android.shopping.abscontainer.common_biz.constant.PageStartupStatus;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.jvm.internal.Intrinsics;
import n33.f;
import v43.g;
import v43.h;
import v43.i;
import v43.j;
import v43.k;
import v43.l;
import v43.m;
import v43.n;
import v43.o;
import v43.p;
import v43.q;
import v43.r;
import v43.s;
import v43.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements v43.b, l, o, m, p, r, s, v43.a, n {
    public final v43.b a;
    public final l b;
    public final o c;
    public final m d;
    public final p e;
    public final r f;
    public final s g;
    public final v43.a h;
    public final n i;

    public c() {
        this(0);
    }

    public final t A() {
        return this.g.A();
    }

    public final void B(f r2) {
        this.g.B(r2);
    }

    public final boolean C() {
        return this.b.C();
    }

    public final void D(int r2) {
        this.h.D(r2);
    }

    public final boolean E() {
        return this.b.E();
    }

    public final long F() {
        return this.c.F();
    }

    public final void G(k33.a r2) {
        this.b.G(r2);
    }

    public final Map<String, Object> H() {
        return this.b.H();
    }

    public final void I(boolean r2) {
        this.i.I(r2);
    }

    public final void J(p43.a r2) {
        this.b.J(r2);
    }

    public final String K() {
        return this.c.K();
    }

    public final int L() {
        return this.i.L();
    }

    public final void M(PageStartupStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c.M(r2);
    }

    public final p43.a N() {
        return this.b.N();
    }

    public final String O() {
        return this.e.O();
    }

    public final k33.a P() {
        return this.b.P();
    }

    public final void Q(CheckStatus r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.b.Q(r2);
    }

    public final void R(boolean r2) {
        this.b.R(r2);
    }

    public final void S(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.c.S(r2);
    }

    public final List<String> T() {
        return this.h.T();
    }

    public final w33.f<y43.a> a() {
        return this.a.a();
    }

    public final AtomicLong b() {
        return this.g.b();
    }

    public final PageStartupStatus c() {
        return this.c.c();
    }

    public final Integer d() {
        return this.h.d();
    }

    public final boolean e() {
        return this.i.e();
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L24;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.g, r4.g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.h, r4.h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.i, r4.i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final boolean f() {
        return this.b.f();
    }

    public final w33.f<x43.a> g() {
        return this.a.g();
    }

    public final Map<String, RecyclerView> getPopup() {
        return this.d.getPopup();
    }

    public final int h() {
        return this.h.h();
    }

    public final int hashCode() {
        v43.b r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        l r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        o r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        m r10 = this.d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        p r13 = this.e;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        r r16 = this.f;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        s r19 = this.g;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        v43.a r22 = this.h;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        n r25 = this.i;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        return r24 + r1;
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final void i(int r2) {
        this.i.i(r2);
    }

    public final void j(Map<String, ? extends Object> r2) {
        this.b.j(r2);
    }

    public final void k(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f.k(r2);
    }

    public final void l(t r2) {
        this.g.l(r2);
    }

    public final void m(boolean r2) {
        this.b.m(r2);
    }

    public final void n(List<String> r2) {
        this.h.n(r2);
    }

    public final w33.f<p43.c> o() {
        return this.b.o();
    }

    public final void p(Integer r2) {
        this.h.p(r2);
    }

    public final void q(String r2) {
        this.b.q(r2);
    }

    public final String r() {
        return this.b.r();
    }

    public final void s(boolean r2) {
        this.b.s(r2);
    }

    public final f t() {
        return this.g.t();
    }

    public final String toString() {
        return "SkuBuyState(coreSubState=" + this.a + ", orderSubState=" + this.b + ", quitPageSubState=" + this.c + ", popupSubState=" + this.d + ", secondaryPageSubState=" + this.e + ", skuSecondaryPageSubState=" + this.f + ", uplinkInterceptorSubState=" + this.g + ", cacheSubState=" + this.h + ", queryRetryState=" + this.i + ")";
    }

    public final Map<String, q> u() {
        return this.f.u();
    }

    public final void v(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.f.v(r2);
    }

    public final w33.f<w33.a<p43.b>> w() {
        return this.b.w();
    }

    public final void x(String r2) {
        this.e.x(r2);
    }

    public final CheckStatus y() {
        return this.b.y();
    }

    public final w33.f<w33.a<CheckOrderTriggerOrigin>> z() {
        return this.b.z();
    }

    public c(int r10) {
        v43.d r11 = new v43.d(0);
        v43.e r1 = new v43.e();
        h r2 = new h();
        v43.f r3 = new v43.f(0);
        i r4 = new i();
        j r5 = new j(0);
        k r6 = new k();
        v43.c r7 = new v43.c(0);
        g r0 = new g();
        Intrinsics.checkNotNullParameter(r11, "coreSubState");
        Intrinsics.checkNotNullParameter(r1, "orderSubState");
        Intrinsics.checkNotNullParameter(r2, "quitPageSubState");
        Intrinsics.checkNotNullParameter(r3, "popupSubState");
        Intrinsics.checkNotNullParameter(r4, "secondaryPageSubState");
        Intrinsics.checkNotNullParameter(r5, "skuSecondaryPageSubState");
        Intrinsics.checkNotNullParameter(r6, "uplinkInterceptorSubState");
        Intrinsics.checkNotNullParameter(r7, "cacheSubState");
        Intrinsics.checkNotNullParameter(r0, "queryRetryState");
        this.a = r11;
        this.b = r1;
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.i = r0;
    }
}
