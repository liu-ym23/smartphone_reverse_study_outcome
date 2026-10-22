package com.bytedance.bdinstall;

import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j74.a f199651a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f199652b = null;

    static {
        f199651a = new j74.a();
        f199652b = new k();
    }

    public static j b() {
        return f199652b.f199680g;
    }

    public static void c() throws InterruptedException {
        k r100 = f199652b;
        Integer r101 = r100.g();
        n0 r102 = r100.j();
        if (r101 == null) goto L37;
        if (r102 != null) goto L6;
    L9:
        s0 r103 = r100.f199677d;
        if (r103.f199786d.get() != null) goto L33;
        t.a("tryWaitingForInstallFinishWithOldWay");
        Object r104 = r103.f199783a;
        monitor-enter(r104);
        r103.c(r101);     // Catch: Throwable -> L34
        if (r103.f199787e == false) goto L19;
        monitor-exit(r104);     // Catch: Throwable -> L34
        goto L33
    L19:
        if (Looper.myLooper() != v.d(String.valueOf(r101))) goto L22;
        t.e(new RuntimeException("did generate at this thread,you shouldn't block this thread"));     // Catch: Throwable -> L34
    L22:
        if (r103.f199788f == false) goto L24;
        long r105 = 4000;
    L26:
        if (r103.f199784b == false) goto L38;
    L31:
        r103.f199787e = true;     // Catch: Throwable -> L34
        t.a("tryWaitingForInstallFinishWithOldWay finish");     // Catch: Throwable -> L34
        monitor-exit(r104);     // Catch: Throwable -> L34
        goto L33
    L38:
        r103.f199783a.wait(r105);     // Catch: InterruptedException -> L29 Throwable -> L34
    L29:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        goto L31
    L24:
        r105 = 1500;
    L34:
        th = move-exception;
        throw th;
    L33:
        r100.j();
        return;
    L6:
        if (TextUtils.isEmpty(r102.f199720a) == true) goto L9;
        if (TextUtils.isEmpty(r102.f199721b) == true) goto L9;
        return;
    }

    public static void a(String r100, Level r101) {
        k r102 = f199652b;
        if (r102.e() == false) goto L20;
        f r103 = r102.f199682i;
        r103.getClass();
        if (r101 != null) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty("language") == false) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r100) == true) goto L24;
        int r104 = f.a.f199642a[r101.ordinal()];
        if (r104 != 1) goto L15;
        ((ConcurrentHashMap) r103.f199640f).put("language", r100);
        return;
    L15:
        if (r104 != 2) goto L25;
        ((ConcurrentHashMap) r103.f199639e).put("language", r100);
        return;
    L25:
        return;
    L24:
        return;
    }
}
