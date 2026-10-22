package com.cmic.sso.sdk.e;

/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f273490a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f273491b;

    public c() {
    }

    static {
        f273490a = new c();
        f273491b = false;
    }

    public static void a(boolean r100) {
        f273491b = r100;
    }

    public static void a(String r100, String r101) {
        if (f273491b == true) goto L5;
        return;
    }

    public static void b(String r100, String r101) {
        if (f273491b == true) goto L5;
        return;
    }
}
