package nx8;

/* JADX INFO: loaded from: classes26.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f521081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f521082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f521083c;

    public static final class a {
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f521084d = null;

        static {
            f521084d = new b();
        }

        public b() {
            super(0, false, 7);
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f521085d = null;

        static {
            f521085d = new c();
        }

        public c() {
            super(0, false, 6);
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f521086d = null;

        static {
            f521086d = new d();
        }

        public d() {
            super(0, false, 7);
        }
    }

    public static final class e extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f521087d = null;

        static {
            f521087d = new e();
        }

        public e() {
            super(2, false, 5);
        }
    }

    public static final class f extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final f f521088d = null;

        static {
            f521088d = new f();
        }

        public f() {
            super(1, true, 1);
        }
    }

    public static final class g extends i {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final g f521089d = null;

        static {
            f521089d = new g();
        }

        public g() {
            super(0, false, 6);
        }
    }

    static {
    }

    public i(int r100, boolean r101, int r102) {
        if ((r102 & 1) == 0) goto L5;
        boolean r103 = true;
    L7:
        if ((r102 & 2) == 0) goto L10;
        r100 = 0;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = false;
    L12:
        this.f521081a = r103;
        this.f521082b = r100;
        this.f521083c = r101;
        return;
    L5:
        r103 = false;
        goto L7
    }
}
