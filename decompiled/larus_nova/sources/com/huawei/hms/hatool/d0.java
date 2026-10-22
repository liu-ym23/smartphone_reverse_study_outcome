package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes23.dex */
public final enum d0 extends Enum<d0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d0 f277311a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f277312b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d0 f277313c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f277314d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ d0[] f277315e = null;

    static {
        d0 r100 = new d0("IMEI", 0);
        f277311a = r100;
        d0 r101 = new d0("UDID", 1);
        f277312b = r101;
        d0 r102 = new d0("SN", 2);
        f277313c = r102;
        d0 r103 = new d0("EMPTY", 3);
        f277314d = r103;
        f277315e = new d0[]{r100, r101, r102, r103};
    }

    private d0(String r100, int r101) {
        super(r100, r101);
    }

    public static d0 valueOf(String r100) {
        return (d0) r27.a.a(d0.class, r100);
    }

    public static d0[] values() {
        return (d0[]) f277315e.clone();
    }
}
