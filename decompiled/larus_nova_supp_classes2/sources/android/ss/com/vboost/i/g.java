package android.ss.com.vboost.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f130a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f131b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ g[] f132c = null;

    static {
        g r0 = new g("VENDOR", 0, 1);
        f130a = r0;
        g r1 = new g("PLATFORM", 1, 2);
        f131b = r1;
        f132c = new g[]{r0, r1};
    }

    private g(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static g valueOf(String r1) {
        return (g) r27.a.a(g.class, r1);
    }

    public static g[] values() {
        return (g[]) f132c.clone();
    }
}
