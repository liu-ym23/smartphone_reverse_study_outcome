package com.bytedance.bdinstall;

import android.os.Looper;
import android.text.TextUtils;
import j74.a;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i {
    public static final a a = null;
    public static final k b = null;

    static {
        a = new a();
        b = new k();
    }

    public static j b() {
        return b.g;
    }

    public static void c() throws InterruptedException {
        k r0 = b;
        Integer r1 = r0.g();
        n0 r2 = r0.j();
        if (r1 == null) goto L37;
        if (r2 != null) goto L6;
    L9:
        s0 r3 = r0.d;
        if (r3.d.get() != null) goto L33;
        t.a("tryWaitingForInstallFinishWithOldWay");
        Object r4 = r3.a;
        monitor-enter(r4);
        r3.c(r1);     // Catch: Throwable -> L34
        if (r3.e == false) goto L19;
        monitor-exit(r4);     // Catch: Throwable -> L34
        goto L33
    L19:
        if (Looper.myLooper() != v.d(String.valueOf(r1))) goto L22;
        t.e(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L34
    L22:
        if (r3.f == false) goto L24;
        long r5 = 4000;
    L26:
        if (r3.b == false) goto L38;
    L31:
        r3.e = true;     // Catch: Throwable -> L34
        t.a("tryWaitingForInstallFinishWithOldWay finish");     // Catch: Throwable -> L34
        monitor-exit(r4);     // Catch: Throwable -> L34
        goto L33
    L38:
        r3.a.wait(r5);     // Catch: InterruptedException -> L29 Throwable -> L34
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        goto L31
    L24:
        r5 = 1500;
    L34:
        th = move-exception;
        throw th;
    L33:
        r0.j();
        return;
    L6:
        if (TextUtils.isEmpty(r2.a) == true) goto L9;
        if (TextUtils.isEmpty(r2.b) == true) goto L9;
        return;
    }

    public static void a(String r3, Level r4) {
        k r0 = b;
        if (r0.e() == false) goto L20;
        f r1 = r0.i;
        r1.getClass();
        if (r4 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty("language") == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r3) == true) goto L24;
        int r5 = f.a.a[r4.ordinal()];
        if (r5 != 1) goto L15;
        ((ConcurrentHashMap) r1.f).put("language", r3);
        return;
    L15:
        if (r5 != 2) goto L25;
        ((ConcurrentHashMap) r1.e).put("language", r3);
        return;
    L25:
        return;
    L24:
        return;
    }
}
