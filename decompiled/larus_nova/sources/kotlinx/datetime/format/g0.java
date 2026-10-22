package kotlinx.datetime.format;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class g0 extends kotlinx.datetime.format.a<fuc.e, c0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f505222b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kotlinx.datetime.internal.format.f<e> f505223a;

    public static final class a implements kotlinx.datetime.format.b<e, a>, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kotlinx.datetime.internal.format.d<e> f505224a;

        @Override // kotlinx.datetime.format.b
        public final kotlinx.datetime.format.b k() {
            return new a(new kotlinx.datetime.internal.format.d());
        }

        @Override // kotlinx.datetime.format.b
        public final kotlinx.datetime.internal.format.d<e> c() {
            return this.f505224a;
        }

        public a(kotlinx.datetime.internal.format.d<e> r100) {
            Intrinsics.checkNotNullParameter(r100, "actualBuilder");
            this.f505224a = r100;
        }

        @Override // kotlinx.datetime.format.w.a
        public final void a(Padding r100) {
            c.a.b(this, r100);
        }

        @Override // kotlinx.datetime.format.w.a
        public final void l(Padding r100) {
            c.a.c(this, r100);
        }

        @Override // kotlinx.datetime.format.w.a
        public final void m(Padding r100) {
            c.a.a(this, r100);
        }

        @Override // kotlinx.datetime.format.w
        public final void o(String r100) {
            kotlinx.datetime.format.b.a.d(this, r100);
        }

        @Override // kotlinx.datetime.format.c
        public final void u(kotlinx.datetime.internal.format.n<? super e> r100) {
            Intrinsics.checkNotNullParameter(r100, "structure");
            this.f505224a.a(r100);
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
    public final kotlinx.datetime.internal.format.f<e> b() {
        return this.f505223a;
    }

    @Override // kotlinx.datetime.format.a
    public final kotlinx.datetime.internal.format.parser.c c() {
        return l0.f505227c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g0(kotlinx.datetime.internal.format.f<? super e> r100) {
        Intrinsics.checkNotNullParameter(r100, "actualFormat");
        this.f505223a = r100;
    }

    @Override // kotlinx.datetime.format.a
    public final fuc.e d(kotlinx.datetime.internal.format.parser.c r100) {
        c0 r101 = (c0) r100;
        Intrinsics.checkNotNullParameter(r101, "intermediate");
        return r101.g();
    }
}
