package kotlinx.datetime.format;

/* JADX INFO: loaded from: classes42.dex */
public interface w {

    public interface a extends w {

        /* JADX INFO: renamed from: kotlinx.datetime.format.w$a$a, reason: collision with other inner class name */
        public static final class C6591a {
            public static /* synthetic */ void a(a r100) {
                r100.l(Padding.ZERO);
            }
        }

        void a(Padding r100);

        void j(MonthNames r100);

        void l(Padding r100);

        void m(Padding r100);

        void q(v<fuc.e> r100);

        void t(DayOfWeekNames r100);
    }

    public interface b extends a, d {
    }

    public interface c extends b, e {
    }

    public interface d extends w {

        public static final class a {
            public static /* synthetic */ void a(d r100) {
                r100.i(Padding.ZERO);
            }

            public static /* synthetic */ void b(d r100) {
                r100.g(Padding.ZERO);
            }

            public static /* synthetic */ void c(d r100) {
                r100.s(Padding.ZERO);
            }
        }

        void e();

        void g(Padding r100);

        void i(Padding r100);

        void r(s0 r100);

        void s(Padding r100);
    }

    public interface e extends w {

        public static final class a {
            public static /* synthetic */ void a(e r100) {
                r100.v(Padding.ZERO);
            }

            public static /* synthetic */ void b(e r100) {
                r100.d(Padding.ZERO);
            }
        }

        void d(Padding r100);

        void h(f1 r100);

        void n(Padding r100);

        void v(Padding r100);
    }

    void o(String r100);
}
