package gc7;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Integer f480866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f480867b;

    public static class a extends hc7.a<kc7.c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f480868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Long f480869d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Integer f480870e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f480871f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Long f480872g;

        @Override // hc7.a
        public final kc7.c a() {
            return jc7.b.a.f498144a.d(this.f480868c, this.f480869d, this.f480870e, this.f480871f, this.f480872g);
        }

        @Override // hc7.a
        public final /* bridge */ /* synthetic */ void c(kc7.c r100) {
        }

        public a(int r100, Long r101, Integer r102, String r103, Long r104) {
            this.f480868c = r100;
            this.f480869d = r101;
            this.f480870e = r102;
            this.f480871f = r103;
            this.f480872g = r104;
        }
    }

    public static class b extends hc7.a<c> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f480873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f480874d;

        @Override // hc7.a
        public final c a() {
            if (jc7.b.a.f498144a.delete(this.f480873c, this.f480874d) == false) goto L6;
            return new c(0, null);
        L6:
            return new c(-5, "删除数据失败或者没有数据");
        }

        @Override // hc7.a
        public final /* bridge */ /* synthetic */ void c(c r100) {
        }

        public b(int r100, Object r101) {
            this.f480873c = r100;
            this.f480874d = r101;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f480875a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f480876b;

        public c(int r100, String r101) {
            this.f480875a = r100;
            this.f480876b = r101;
        }
    }

    private static void delete(int r100, Object r101, ic7.a r102) {
        new b(r100, r101).b();
    }

    private static void query(int r100, Long r101, Integer r102, String r103, Long r110, ic7.b r111) {
        new a(r100, r101, r102, r103, r110).b();
    }
}
