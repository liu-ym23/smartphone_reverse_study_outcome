package kotlinx.datetime.format;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class s0 extends kotlinx.datetime.format.a<fuc.g, e0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f505233b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.datetime.internal.format.f<d1> f505234a;

    public static final class a implements kotlinx.datetime.format.b<d1, a>, d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kotlinx.datetime.internal.format.d<d1> f505235a;

        @Override // kotlinx.datetime.format.b
        public final kotlinx.datetime.format.b k() {
            return new a(new kotlinx.datetime.internal.format.d());
        }

        @Override // kotlinx.datetime.format.b
        public final kotlinx.datetime.internal.format.d<d1> c() {
            return this.f505235a;
        }

        @Override // kotlinx.datetime.format.w.d
        public final void e() {
            d.a.d(this);
        }

        public a(kotlinx.datetime.internal.format.d<d1> r100) {
            Intrinsics.checkNotNullParameter(r100, "actualBuilder");
            this.f505235a = r100;
        }

        @Override // kotlinx.datetime.format.d
        public final void b(kotlinx.datetime.internal.format.n<? super d1> r100) {
            Intrinsics.checkNotNullParameter(r100, "structure");
            this.f505235a.a(r100);
        }

        @Override // kotlinx.datetime.format.w.d
        public final void g(Padding r100) {
            d.a.b(this, r100);
        }

        @Override // kotlinx.datetime.format.w.d
        public final void i(Padding r100) {
            d.a.a(this, r100);
        }

        @Override // kotlinx.datetime.format.w
        public final void o(String r100) {
            kotlinx.datetime.format.b.a.d(this, r100);
        }

        @Override // kotlinx.datetime.format.w.d
        public final void s(Padding r100) {
            d.a.c(this, r100);
        }

        @Override // kotlinx.datetime.format.b
        public final void f(Function1<? super a, Unit>[] r100, Function1<? super a, Unit> r101) {
            kotlinx.datetime.format.b.a.a(this, r100, r101);
        }

        @Override // kotlinx.datetime.format.b
        public final void p(String r100, Function1<? super a, Unit> r101) {
            kotlinx.datetime.format.b.a.b(this, r100, r101);
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // kotlinx.datetime.format.a
    public final kotlinx.datetime.internal.format.f<d1> b() {
        return this.f505234a;
    }

    @Override // kotlinx.datetime.format.a
    public final kotlinx.datetime.internal.format.parser.c c() {
        return y0.f505250b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s0(kotlinx.datetime.internal.format.f<? super d1> r100) {
        Intrinsics.checkNotNullParameter(r100, "actualFormat");
        this.f505234a = r100;
    }

    @Override // kotlinx.datetime.format.a
    public final fuc.g d(kotlinx.datetime.internal.format.parser.c r100) {
        e0 r101 = (e0) r100;
        Intrinsics.checkNotNullParameter(r101, "intermediate");
        return r101.b();
    }
}
