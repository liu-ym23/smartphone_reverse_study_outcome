package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public final enum gs extends Enum<gs> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gs f463874a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ gs[] f695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gs f463875b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gs f463876c = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f696a;

    static {
        gs r100 = new gs("RegIdExpired", 0, 0);
        f463874a = r100;
        gs r101 = new gs("PackageUnregistered", 1, 1);
        f463875b = r101;
        gs r102 = new gs("Init", 2, 2);
        f463876c = r102;
        f695a = new gs[]{r100, r101, r102};
    }

    public static gs[] values() {
        return (gs[]) f695a.clone();
    }

    public int a() {
        return this.f696a;
    }

    public static gs a(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return f463876c;
    L12:
        return f463875b;
    L14:
        return f463874a;
    }

    public static gs valueOf(String r100) {
        return (gs) r27.a.a(gs.class, r100);
    }

    private gs(String r100, int r101, int r102) {
        super(r100, r101);
        this.f696a = r102;
    }
}
