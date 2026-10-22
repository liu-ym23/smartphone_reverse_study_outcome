package android.ss.com.vboost.request;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final enum i extends Enum<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f175a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f176b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f177c = null;
    public static final i d = null;
    private static final /* synthetic */ i[] e = null;

    static {
        i r0 = new i("FIFO", 0, 0);
        f175a = r0;
        i r1 = new i("LIFO", 1, 1);
        f176b = r1;
        i r3 = new i("SMALL", 2, 2);
        f177c = r3;
        i r5 = new i("LAGER", 3, 3);
        d = r5;
        e = new i[]{r0, r1, r3, r5};
    }

    private i(String r1, int r2, int r3) {
        super(r1, r2);
    }

    public static i valueOf(String r1) {
        return (i) r27.a.a(i.class, r1);
    }

    public static i[] values() {
        return (i[]) e.clone();
    }
}
