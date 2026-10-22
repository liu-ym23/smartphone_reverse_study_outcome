package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public final enum gk extends Enum<gk> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gk f463788a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ gk[] f635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gk f463789b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f636a;

    static {
        gk r100 = new gk("MISC_CONFIG", 0, 1);
        f463788a = r100;
        gk r101 = new gk("PLUGIN_CONFIG", 1, 2);
        f463789b = r101;
        f635a = new gk[]{r100, r101};
    }

    public static gk[] values() {
        return (gk[]) f635a.clone();
    }

    public int a() {
        return this.f636a;
    }

    public static gk a(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return null;
    L9:
        return f463789b;
    L11:
        return f463788a;
    }

    public static gk valueOf(String r100) {
        return (gk) r27.a.a(gk.class, r100);
    }

    private gk(String r100, int r101, int r102) {
        super(r100, r101);
        this.f636a = r102;
    }
}
