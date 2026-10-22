package i02;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f487857e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f487858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f487859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f487860c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f487861d;

    public static final class a {
        public a() {
        }

        public static b a(int r100) {
            return new b(false, false, false, r100);
        }
    }

    static {
        new a();
    }

    public final String toString() {
        return "hasTriggerPlay:" + this.f487858a + ", isEffectPaused:" + this.f487859b;
    }

    public /* synthetic */ b(boolean r100) {
        this(r100, false, true, -1);
    }

    public b(boolean r100, boolean r101, boolean r102, int r103) {
        this.f487858a = r100;
        this.f487859b = r101;
        this.f487860c = r102;
        this.f487861d = r103;
    }
}
