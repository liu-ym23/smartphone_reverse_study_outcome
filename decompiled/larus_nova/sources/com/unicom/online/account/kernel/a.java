package com.unicom.online.account.kernel;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f461943a;

    public static void a(Exception r100) {
        if (f461943a == false) goto L6;
        r100.printStackTrace();
        return;
    }

    public static void a(String r100) {
        if (f461943a == false) goto L6;
        "6.3.0 ".concat(String.valueOf(r100));
        return;
    }

    public static void a(boolean r100) {
        f461943a = r100;
    }

    public static void b(String r100) {
        "6.3.0 ".concat(String.valueOf(r100));
    }
}
