package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public final enum gl extends Enum<gl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gl f463790a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final /* synthetic */ gl[] f637a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gl f463791b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gl f463792c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gl f463793d = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final int f638a;

    static {
        gl r100 = new gl("INT", 0, 1);
        f463790a = r100;
        gl r101 = new gl("LONG", 1, 2);
        f463791b = r101;
        gl r102 = new gl("STRING", 2, 3);
        f463792c = r102;
        gl r103 = new gl("BOOLEAN", 3, 4);
        f463793d = r103;
        f637a = new gl[]{r100, r101, r102, r103};
    }

    public static gl[] values() {
        return (gl[]) f637a.clone();
    }

    public static gl a(int r100) {
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L17;
        if (r100 == 3) goto L15;
        if (r100 == 4) goto L13;
        return null;
    L13:
        return f463793d;
    L15:
        return f463792c;
    L17:
        return f463791b;
    L19:
        return f463790a;
    }

    public static gl valueOf(String r100) {
        return (gl) r27.a.a(gl.class, r100);
    }

    private gl(String r100, int r101, int r102) {
        super(r100, r101);
        this.f638a = r102;
    }
}
