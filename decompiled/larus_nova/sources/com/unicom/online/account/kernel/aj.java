package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes5.dex */
public final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f461980a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f461981b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f461982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f461983d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f461984e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static StringBuilder f461985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static StringBuilder f461986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static StringBuilder f461987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static StringBuilder f461988i;

    static {
        f461985f = new StringBuilder();
        f461986g = new StringBuilder();
        f461987h = new StringBuilder();
        f461988i = new StringBuilder();
    }

    public static String a(int r100) {
        if (r100 != 0) goto L4;
        StringBuilder r101 = f461986g;
    L13:
        return r101.toString();
    L4:
        if (r100 != 1) goto L6;
        r101 = f461985f;
        goto L13
    L6:
        if (r100 != 2) goto L8;
        r101 = f461987h;
        goto L13
    L8:
        if (r100 == 3) goto L11;
        return "no info";
    L11:
        r101 = f461988i;
        goto L13
    }

    public static void a() {
        f461983d = 0;
        f461984e = 0;
        f461986g.setLength(0);
        f461986g.append("\n\n■★■★■★■★■★■★■★■★■★■\n\ncom debug info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
        f461985f.setLength(0);
        f461985f.append("\n\n■★■★■★■★■★■★■★■★■★■\n\nall debug info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
        f461987h.setLength(0);
        f461987h.append("\n\n■★■★■★■★■★■★■★■★■★■\n\nresult  info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
        f461988i.setLength(0);
        f461988i.append("\n\n■★■★■★■★■★■★■★■★■★■\n\ncost time  info\n\n■★■★■★■★■★■★■★■★■★■\n\n");
    }

    public static void a(int r100, String r101) {
        if (f461980a == true) goto L6;
        return;
    L6:
        if (r100 != 3) goto L8;
        StringBuilder r102 = new StringBuilder("【");
        int r103 = f461984e;
        f461984e = r103 + 1;
        r102.append(r103);
        r102.append("】:");
        r102.append(r101);
        r102.append("\n");
        b(r100, r102.toString());
        r100 = 1;
    L8:
        StringBuilder r104 = new StringBuilder("【");
        int r105 = f461983d;
        f461983d = r105 + 1;
        r104.append(r105);
        r104.append("】\n时间戳:");
        r104.append(System.currentTimeMillis());
        r104.append("\n时间差:");
        r104.append(System.currentTimeMillis() - f461982c);
        r104.append("\n数据:\n");
        r104.append(r101);
        r104.append("\n\n");
        b(r100, r104.toString());
        f461982c = System.currentTimeMillis();
    }

    public static void a(Exception r100) {
        if (f461980a == false) goto L6;
        r100.printStackTrace();
        return;
    }

    public static void a(String r100) {
        if (f461980a == false) goto L6;
        ac.d();
        a(0, r100);
        return;
    }

    public static void a(boolean r100) {
        f461980a = r100;
    }

    private static void b(int r100, String r101) {
        if (f461980a == true) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
        StringBuilder r102 = f461986g;
    L14:
        r102.append(r101);
    L15:
        f461985f.append(r101);
        return;
    L7:
        if (r100 != 2) goto L9;
        r102 = f461987h;
        goto L14
    L9:
        if (r100 != 3) goto L15;
        r102 = f461988i;
        goto L14
    }

    public static void b(String r100) {
        if (f461980a == false) goto L6;
        ac.d();
        a(0, r100);
        return;
    }

    public static void c(String r100) {
        ac.d();
        a(0, r100);
    }
}
