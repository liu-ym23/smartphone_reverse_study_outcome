package ola;

import android.app.Application;
import wma.b;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f524188a;

    /* JADX INFO: renamed from: ola.a$a, reason: collision with other inner class name */
    public static final class C7067a {
    }

    static {
    }

    public a() {
        if (f524188a != 0) goto L21;
        b.a("SDK_INIT", "BUILD_NO: [20260830-23:06:03|release|2.0.1|69ad8fa2|20260830-23:00:20_bugfix:Fix the UI issue of ChipsTab when material styling is unavailable.]");
        hla.a r100 = hla.a.f485702a;
    L19:
        e = move-exception;
        b.c("OUISdk", "init failed", e);
        goto L21
    L6:
        if (hla.a.f485703b == true) goto L17;
        long r101 = System.currentTimeMillis();     // Catch: Exception -> L19
        Application r102 = null;
        r102 = (Application) hla.a.a().getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);     // Catch: Exception -> L11
    L13:
        if (r102 == null) goto L16;
        r102.registerComponentCallbacks(r100);     // Catch: Exception -> L19
    L16:
        mja.a.f514263a = mja.a.f514264b;     // Catch: Exception -> L19
        hla.a.f485703b = true;     // Catch: Exception -> L19
        b.a("OUISdk", "init success, cost: " + (System.currentTimeMillis() - r101) + " ms");     // Catch: Exception -> L19
        goto L21
    L11:
        e = move-exception;
        b.c("OUISdk", "getApplicationReflect failed", e);     // Catch: Exception -> L19
        goto L13
    L17:
        b.a("OUISdk", "init already");     // Catch: Exception -> L19
    L21:
        f524188a++;
    }
}
