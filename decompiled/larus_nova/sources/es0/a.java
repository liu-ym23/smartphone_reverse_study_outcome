package es0;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f473676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f473677b;

    /* JADX INFO: renamed from: es0.a$a, reason: collision with other inner class name */
    public static final class C5809a extends a {
        public C5809a(long r100, boolean r101) {
            super(r100, r101);
        }
    }

    public static final class b extends a {
        public b(long r100, boolean r101) {
            super(r100, r101);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f473678c = null;

        public c() {
            super(0, false);
        }

        static {
            f473678c = new c();
        }
    }

    public static final class d extends a {
        public d(long r100) {
            super(r100, true);
        }
    }

    public a(long r100, boolean r101) {
        this.f473676a = r100;
        this.f473677b = r101;
    }
}
