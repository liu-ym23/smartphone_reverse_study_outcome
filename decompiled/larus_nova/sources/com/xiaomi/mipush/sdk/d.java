package com.xiaomi.mipush.sdk;

/* JADX INFO: loaded from: classes41.dex */
public final enum d extends Enum<d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f463055a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ d[] f170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f463056b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f463057c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f463058d = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f171a;

    static {
        d r100 = new d("ASSEMBLE_PUSH_HUAWEI", 0, 1);
        f463055a = r100;
        d r101 = new d("ASSEMBLE_PUSH_FCM", 1, 2);
        f463056b = r101;
        d r102 = new d("ASSEMBLE_PUSH_COS", 2, 3);
        f463057c = r102;
        d r103 = new d("ASSEMBLE_PUSH_FTOS", 3, 4);
        f463058d = r103;
        f170a = new d[]{r100, r101, r102, r103};
    }

    public static d[] values() {
        return (d[]) f170a.clone();
    }

    public static d valueOf(String r100) {
        return (d) r27.a.a(d.class, r100);
    }

    private d(String r100, int r101, int r102) {
        super(r100, r101);
        this.f171a = r102;
    }
}
