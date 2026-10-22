package v0c;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f552359a;

    public class a {
        public a() {
        }
    }

    public class b implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p.a f552360a;

        public b(p.a r100) {
            this.f552360a = r100;
        }

        @Override // v0c.p.a
        public final void a(o r100) {
            this.f552360a.a(r100);
        }
    }

    public g(p r100) {
        this.f552359a = r100;
    }

    public final void a(p.a r100) {
        this.f552359a.b(new a(), new b(r100));
    }
}
