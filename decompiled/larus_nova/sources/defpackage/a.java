package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public final enum a extends Enum<a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f1230c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f1231d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f1232e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f1233f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f1234g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ a[] f1235h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f1237b;

    static {
        a r100 = new a("SUCCESS", 0, 0, "success");
        f1230c = r100;
        a r101 = new a("ERROR_NO_PERMISSION", 1, 8002009, "No permission to call this function.");
        f1231d = r101;
        a r102 = new a("ERROR_EXCEEDED_MAXIMUM", 2, 8002010, "Turning on the notification switch request exceeds the maximum number of times.");
        f1232e = r102;
        a r103 = new a("ERROR_REQUIRES_TOO_MANY", 3, 8002011, "Turning on the notification switch requires too many requests.");
        f1233f = r103;
        a r104 = new a("ERROR_VERSION_NOT_SUPPORT", 4, 8002012, "The current version does not support this function, please upgrade Honor Push.");
        f1234g = r104;
        f1235h = new a[]{r100, r101, r102, r103, r104};
    }

    public a(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.f1236a = r102;
        this.f1237b = r103;
    }

    public static a valueOf(String r100) {
        return (a) r27.a.a(a.class, r100);
    }

    public static a[] values() {
        return (a[]) f1235h.clone();
    }
}
