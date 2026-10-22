package kotlinx.datetime.format;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class d0 implements e, d1, kotlinx.datetime.internal.format.parser.c<d0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f505207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e0 f505208b;

    public d0() {
        this(0);
    }

    @Override // kotlinx.datetime.format.d1
    public final void o(guc.a r100) {
        this.f505208b.o(r100);
    }

    @Override // kotlinx.datetime.format.d1
    public final guc.a t() {
        return this.f505208b.t();
    }

    @Override // kotlinx.datetime.format.e
    public final Integer a() {
        return this.f505207a.f505205d;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer c() {
        return this.f505207a.f505202a;
    }

    @Override // kotlinx.datetime.internal.format.parser.c
    public final d0 copy() {
        return new d0(this.f505207a.b(), this.f505208b.a());
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer g() {
        return this.f505208b.f505210b;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer getHour() {
        return this.f505208b.f505209a;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer getMinute() {
        return this.f505208b.f505212d;
    }

    @Override // kotlinx.datetime.format.d1
    public final AmPmMarker i() {
        return this.f505208b.f505211c;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer k() {
        return this.f505207a.f505203b;
    }

    @Override // kotlinx.datetime.format.d1
    public final Integer s() {
        return this.f505208b.f505213e;
    }

    @Override // kotlinx.datetime.format.e
    public final Integer u() {
        return this.f505207a.f505204c;
    }

    public /* synthetic */ d0(int r100) {
        this(new c0(null, null, null, null), new e0(0));
    }

    @Override // kotlinx.datetime.format.e
    public final void d(Integer r100) {
        this.f505207a.f505205d = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void e(Integer r100) {
        this.f505207a.f505203b = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void f(Integer r100) {
        this.f505207a.f505202a = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void j(Integer r100) {
        this.f505208b.f505210b = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void n(Integer r100) {
        this.f505208b.f505209a = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void p(Integer r100) {
        this.f505208b.f505213e = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void r(AmPmMarker r100) {
        this.f505208b.f505211c = r100;
    }

    @Override // kotlinx.datetime.format.e
    public final void w(Integer r100) {
        this.f505207a.f505204c = r100;
    }

    @Override // kotlinx.datetime.format.d1
    public final void y(Integer r100) {
        this.f505208b.f505212d = r100;
    }

    public d0(c0 r100, e0 r101) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Intrinsics.checkNotNullParameter(r101, "time");
        this.f505207a = r100;
        this.f505208b = r101;
    }
}
