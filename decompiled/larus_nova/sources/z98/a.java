package z98;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571025a;

    /* JADX INFO: renamed from: z98.a$a, reason: collision with other inner class name */
    public static final class C8433a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C8433a f571026b = null;

        static {
            f571026b = new C8433a();
        }

        public C8433a() {
            super("ApDetected");
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f571027b = null;

        static {
            f571027b = new b();
        }

        public b() {
            super("GpsDisabled");
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f571028b = null;

        static {
            f571028b = new c();
        }

        public c() {
            super("Hide");
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f571029b = null;

        static {
            f571029b = new d();
        }

        public d() {
            super("Idle");
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f571030b = null;

        static {
            f571030b = new e();
        }

        public e() {
            super("LowBattery");
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f f571031b = null;

        static {
            f571031b = new f();
        }

        public f() {
            super("NoPermission");
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f571032b = null;

        static {
            f571032b = new g();
        }

        public g() {
            super("Recording");
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f571033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f571034c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f571033b == r101.f571033b) goto L12;
            return false;
        L12:
            if (this.f571034c == r101.f571034c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f571033b * 31) + this.f571034c;
        }

        public final String toString() {
            return "ShowDiff(imageCount=" + this.f571033b + ", videoCount=" + this.f571034c + ')';
        }

        public h(int r100, int r101) {
            super("ShowDiff:(" + r100 + ", " + r101 + ')');
            this.f571033b = r100;
            this.f571034c = r101;
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final i f571035b = null;

        static {
            f571035b = new i();
        }

        public i() {
            super("TransferEnded");
        }
    }

    public static final class j extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final j f571036b = null;

        static {
            f571036b = new j();
        }

        public j() {
            super("TransferStarted");
        }
    }

    public static final class k extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k f571037b = null;

        static {
            f571037b = new k();
        }

        public k() {
            super("VpnDetected");
        }
    }

    public static final class l extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final l f571038b = null;

        static {
            f571038b = new l();
        }

        public l() {
            super("WifiConnecting");
        }
    }

    public static final class m extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final m f571039b = null;

        static {
            f571039b = new m();
        }

        public m() {
            super("WifiDisabled");
        }
    }

    public static final class n extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final n f571040b = null;

        static {
            f571040b = new n();
        }

        public n() {
            super("WifiError");
        }
    }

    public a(String r100) {
        this.f571025a = r100;
    }
}
