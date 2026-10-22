package android.ss.com.vboost.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final enum b extends Enum<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f56a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f57b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ b[] f58c = null;

    static {
        b r0 = new b("USER_SPECIFIED", 0, 1);
        f56a = r0;
        b r1 = new b("BIND_CLUSTER", 1, 2);
        f57b = r1;
        f58c = new b[]{r0, r1};
    }

    private b(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static b valueOf(String r1) {
        return (b) r27.a.a(b.class, r1);
    }

    public static b[] values() {
        return (b[]) f58c.clone();
    }
}
