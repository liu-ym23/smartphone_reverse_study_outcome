package com.tencent.mm.opensdk.diffdev.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f461625b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f461626c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f461627d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f461628e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f461629f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d f461630g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ d[] f461631h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f461632a;

    static {
        d r100 = new d("UUID_EXPIRED", 0, 402);
        f461625b = r100;
        d r101 = new d("UUID_CANCELED", 1, 403);
        f461626c = r101;
        d r102 = new d("UUID_SCANED", 2, 404);
        f461627d = r102;
        d r103 = new d("UUID_CONFIRM", 3, 405);
        f461628e = r103;
        d r104 = new d("UUID_KEEP_CONNECT", 4, 408);
        f461629f = r104;
        d r105 = new d("UUID_ERROR", 5, 500);
        f461630g = r105;
        f461631h = new d[]{r100, r101, r102, r103, r104, r105};
    }

    private d(String r100, int r101, int r102) {
        super(r100, r101);
        this.f461632a = r102;
    }

    public static d valueOf(String r100) {
        return (d) r27.a.a(d.class, r100);
    }

    public static d[] values() {
        return (d[]) f461631h.clone();
    }

    public int a() {
        return this.f461632a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UUIDStatusCode:" + this.f461632a;
    }
}
