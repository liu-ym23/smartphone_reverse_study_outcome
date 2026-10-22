package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public final enum m extends Enum<m> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f464124a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ m[] f963a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f464125b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f464126c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f464127d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f464128e = null;

    static {
        m r100 = new m("China", 0);
        f464124a = r100;
        m r101 = new m("Global", 1);
        f464125b = r101;
        m r102 = new m("Europe", 2);
        f464126c = r102;
        m r103 = new m("Russia", 3);
        f464127d = r103;
        m r104 = new m("India", 4);
        f464128e = r104;
        f963a = new m[]{r100, r101, r102, r103, r104};
    }

    public static m[] values() {
        return (m[]) f963a.clone();
    }

    public static m valueOf(String r100) {
        return (m) r27.a.a(m.class, r100);
    }

    private m(String r100, int r101) {
        super(r100, r101);
    }
}
