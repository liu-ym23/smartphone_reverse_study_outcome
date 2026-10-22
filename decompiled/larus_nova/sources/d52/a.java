package d52;

/* JADX INFO: loaded from: classes9.dex */
public abstract class a extends d52.c {

    /* JADX INFO: renamed from: d52.a$a, reason: collision with other inner class name */
    public static final class C5635a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f466967a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C5635a f466968b = null;

        static {
            f466968b = new C5635a();
            f466967a = 1;
        }

        public C5635a() {
        }

        @Override // d52.c
        public final int a() {
            return f466967a;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f466969a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f466970b = null;

        static {
            f466970b = new b();
            f466969a = 2;
        }

        public b() {
        }

        @Override // d52.c
        public final int a() {
            return f466969a;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f466971a = null;

        @Override // d52.c
        public final int a() {
            return 0;
        }

        static {
            f466971a = new c();
        }

        public c() {
        }
    }

    public a() {
    }
}
