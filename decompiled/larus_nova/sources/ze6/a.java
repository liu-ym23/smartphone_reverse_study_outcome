package ze6;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f571534a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f571535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Context f571536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f571537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f571538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f571539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f571540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f571541h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f571542i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f571543j;

    static {
        f571534a = new a();
    }

    public a() {
    }

    public static boolean a(ye6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "appInfo");
        if (f571535b == true) goto L7;
        b.a("AppInfoProvider.matches App info is not configured; returning false");
        return false;
    L7:
        if (f571536c == r100.f567390a) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(f571537d, r100.f567391b) == true) goto L11;
        return false;
    L11:
        if (Intrinsics.areEqual(f571538e, r100.f567392c) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(f571539f, r100.f567393d) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(f571540g, r100.f567394e) == true) goto L17;
        return false;
    L17:
        if (Intrinsics.areEqual(f571541h, r100.f567395f) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(f571542i, r100.f567396g) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(f571543j, r100.f567397h) == false) goto L31;
        return true;
    L31:
        return false;
    }

    public final synchronized void b(ye6.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "appInfo");     // Catch: Throwable -> L11
        b.b("AppInfoProvider.setAppInfo");     // Catch: Throwable -> L11
        if (f571535b == false) goto L8;
        b.c("AppInfoProvider.setAppInfo App info is already configured; keeping the existing config");     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L8:
        f571536c = r100.f567390a;     // Catch: Throwable -> L11
        f571537d = r100.f567391b;     // Catch: Throwable -> L11
        f571538e = r100.f567392c;     // Catch: Throwable -> L11
        f571539f = r100.f567393d;     // Catch: Throwable -> L11
        f571540g = r100.f567394e;     // Catch: Throwable -> L11
        f571541h = r100.f567395f;     // Catch: Throwable -> L11
        f571542i = r100.f567396g;     // Catch: Throwable -> L11
        f571543j = r100.f567397h;     // Catch: Throwable -> L11
        f571535b = true;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
