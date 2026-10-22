package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f464370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1159a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1160a;

    static {
        if (z.f464371a == false) goto L5;
        String r100 = "ONEBOX";
    L6:
        f1159a = r100;
        f1160a = false;
        f464370a = 1;
        if (r100.equalsIgnoreCase("SANDBOX") == false) goto L10;
        f464370a = 2;
        return;
    L10:
        if (r100.equalsIgnoreCase("ONEBOX") == false) goto L12;
        f464370a = 3;
        return;
    L12:
        f464370a = 1;
        return;
    L5:
        r100 = "@SHIP.TO.2A2FE0D7@";
        goto L6
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9434a() {
        if (f464370a != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean b() {
        if (f464370a != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public static int a() {
        return f464370a;
    }

    public static void a(int r100) {
        f464370a = r100;
    }
}
