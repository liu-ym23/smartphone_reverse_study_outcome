package kotlinx.datetime.format;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class t implements e, d1, e1, kotlinx.datetime.internal.format.parser.c<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f505236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f505237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f505238c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f505239d;

    public t() {
        this(0);
    }

    @Override // kotlinx.datetime.format.d1
    public final void o(guc.a r100) {
        this.f505237b.o(r100);
    }

    @Override // kotlinx.datetime.format.d1
    public final guc.a t() {
        return this.f505237b.t();
    }

    @Override // kotlinx.datetime.format.e
    public final Integer a() {
        return this.f505236a.f505205d;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer c() {
        return this.f505236a.f505202a;
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    public final t copy() {
        c0 r100 = this.f505236a.b();
        e0 r101 = this.f505237b.a();
        f0 r102 = this.f505238c;
        r102.getClass();
        return new t(r100, r101, new f0(r102.f505215a, r102.f505216b, r102.f505217c, r102.f505218d), this.f505239d);
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer g() {
        return this.f505237b.f505210b;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer getHour() {
        return this.f505237b.f505209a;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer getMinute() {
        return this.f505237b.f505212d;
    }

    public final int hashCode() {
        int r100 = (this.f505236a.hashCode() ^ this.f505237b.hashCode()) ^ this.f505238c.hashCode();
        String r101 = this.f505239d;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 ^ r102;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // kotlinx.datetime.format.d1
    public final AmPmMarker i() {
        return this.f505237b.f505211c;
    }

    @Override // kotlinx.datetime.format.e1
    public final Boolean isNegative() {
        return this.f505238c.f505215a;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer k() {
        return this.f505236a.f505203b;
    }

    @Override // kotlinx.datetime.format.e1
    public final Integer l() {
        return this.f505238c.f505216b;
    }

    @Override // kotlinx.datetime.format.e1
    public final Integer m() {
        return this.f505238c.f505217c;
    }

    @Override // kotlinx.datetime.format.e1
    public final Integer q() {
        return this.f505238c.f505218d;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer s() {
        return this.f505237b.f505213e;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer u() {
        return this.f505236a.f505204c;
    }

    public /* synthetic */ t(int r100) {
        this(new c0(null, null, null, null), new e0(0), new f0(null, null, null, null), null);
    }

    @Override // kotlinx.datetime.format.e1
    public final void b(Integer r100) {
        this.f505238c.f505216b = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void d(Integer r100) {
        this.f505236a.f505205d = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void e(Integer r100) {
        this.f505236a.f505203b = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof t) == false) goto L13;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(r101.f505236a, this.f505236a) == false) goto L13;
        if (Intrinsics.areEqual(r101.f505237b, this.f505237b) == false) goto L13;
        if (Intrinsics.areEqual(r101.f505238c, this.f505238c) == false) goto L13;
        if (Intrinsics.areEqual(r101.f505239d, this.f505239d) == false) goto L13;
        return true;
    L13:
        return false;
    }

    @Override // kotlinx.datetime.format.e
    public final void f(Integer r100) {
        this.f505236a.f505202a = r100;
    }

    @Override // kotlinx.datetime.format.e1
    public final void h(Integer r100) {
        this.f505238c.f505217c = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void j(Integer r100) {
        this.f505237b.f505210b = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void n(Integer r100) {
        this.f505237b.f505209a = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void p(Integer r100) {
        this.f505237b.f505213e = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void r(AmPmMarker r100) {
        this.f505237b.f505211c = r100;
    }

    @Override // kotlinx.datetime.format.e1
    public final void v(Boolean r100) {
        this.f505238c.f505215a = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void w(Integer r100) {
        this.f505236a.f505204c = r100;
    }

    @Override // kotlinx.datetime.format.e1
    public final void x(Integer r100) {
        this.f505238c.f505218d = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void y(Integer r100) {
        this.f505237b.f505212d = r100;
    }

    public t(c0 r100, e0 r101, f0 r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Intrinsics.checkNotNullParameter(r101, "time");
        Intrinsics.checkNotNullParameter(r102, "offset");
        this.f505236a = r100;
        this.f505237b = r101;
        this.f505238c = r102;
        this.f505239d = r103;
    }
}
