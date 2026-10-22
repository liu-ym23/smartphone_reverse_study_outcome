package com.cmic.ida.sdk;

/* JADX INFO: loaded from: classes22.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final u f273244a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f273245b;

    static {
        f273244a = new u();
        f273245b = false;
    }

    public u() {
    }

    public static void a(boolean r100) {
        f273245b = r100;
    }

    public static void a(String r100, String r101) {
        if (f273245b == true) goto L5;
        return;
    }

    public static void b(String r100, String r101) {
        if (f273245b == true) goto L5;
        return;
    }
}
