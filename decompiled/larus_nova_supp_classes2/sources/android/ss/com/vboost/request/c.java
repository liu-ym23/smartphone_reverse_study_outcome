package android.ss.com.vboost.request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final enum c extends Enum<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f155a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f156b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ c[] f157c = null;

    static {
        c r0 = new c("DIRECT", 0, 0);
        f155a = r0;
        c r1 = new c("ASYNC", 1, 1);
        f156b = r1;
        f157c = new c[]{r0, r1};
    }

    private c(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static c valueOf(String r1) {
        return (c) r27.a.a(c.class, r1);
    }

    public static c[] values() {
        return (c[]) f157c.clone();
    }
}
