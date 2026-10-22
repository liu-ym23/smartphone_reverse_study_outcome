package android.ss.com.vboost.request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum g extends Enum<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f170b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f171c = null;
    public static final g d = null;
    public static final g e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ g[] f172f = null;

    static {
        g r0 = new g("USE_PROVIDERS", 0, 0);
        f169a = r0;
        g r1 = new g("USE_OURS", 1, 1);
        f170b = r1;
        g r3 = new g("USER_CANCEL", 2, 2);
        f171c = r3;
        g r5 = new g("ONE_TIME", 3, 3);
        d = r5;
        g r7 = new g("ETERNAL", 4, 4);
        e = r7;
        f172f = new g[]{r0, r1, r3, r5, r7};
    }

    private g(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static g valueOf(String r1) {
        return (g) r27.a.a(g.class, r1);
    }

    public static g[] values() {
        return (g[]) f172f.clone();
    }
}
