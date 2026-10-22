package je1;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f498795a;

    /* JADX INFO: renamed from: je1.a$a, reason: collision with other inner class name */
    public static final class C6422a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f498796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f498797c;

        public C6422a() {
            this(null, 3);
        }

        public C6422a(String r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            super(false);
            this.f498796b = r100;
            this.f498797c = null;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f498798b = null;

        public b() {
            super(true);
        }

        static {
            f498798b = new b();
        }
    }

    public a(boolean r100) {
        this.f498795a = r100;
    }
}
