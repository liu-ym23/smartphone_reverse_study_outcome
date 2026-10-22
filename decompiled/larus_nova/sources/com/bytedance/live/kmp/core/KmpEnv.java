package com.bytedance.live.kmp.core;

/* JADX INFO: loaded from: classes19.dex */
public final class KmpEnv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KmpEnv f255139a = null;

    public KmpEnv() {
    }

    static {
        f255139a = new KmpEnv();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [T, java.lang.Boolean] */
    public static boolean a() {
        kjc.c r100 = new kjc.c();
        com.bytedance.android.livesdk.paas.a.a(r100, KmpEnv$isDouyin$1$1.INSTANCE);
        if (r100.f503731b == true) goto L6;
        kjc.b<T> r101 = r100.f503730a;
        r101.f503729a = Boolean.TRUE;
    L6:
        return ((Boolean) r100.f503730a.f503729a).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Boolean] */
    public static boolean b() {
        kjc.c r100 = new kjc.c();
        if (2 != kjc.a.a()) goto L6;
        kjc.b<T> r101 = r100.f503730a;
        r101.f503729a = Boolean.TRUE;
        r100.f503731b = true;
    L6:
        if (r100.f503731b == true) goto L9;
        kjc.b<T> r102 = r100.f503730a;
        r102.f503729a = Boolean.FALSE;
    L9:
        return ((Boolean) r100.f503730a.f503729a).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Boolean] */
    public static boolean c() {
        kjc.c r100 = new kjc.c();
        if (3 != kjc.a.a()) goto L6;
        kjc.b<T> r101 = r100.f503730a;
        r101.f503729a = Boolean.TRUE;
        r100.f503731b = true;
    L6:
        if (r100.f503731b == true) goto L9;
        kjc.b<T> r102 = r100.f503730a;
        r102.f503729a = Boolean.FALSE;
    L9:
        return ((Boolean) r100.f503730a.f503729a).booleanValue();
    }
}
