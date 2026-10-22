package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;
import kh4.a;

/* JADX INFO: loaded from: classes.dex */
public class ScudoVmaLeakFixer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f203329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f203330b;

    public ScudoVmaLeakFixer() {
    }

    private static native int nFixScudoVmaLeak();

    public static synchronized int a() {
        monitor-enter(ScudoVmaLeakFixer.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.f203320c != 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L16;
        if (a.f503457a == true) goto L12;
    L12:
        monitor-exit(ScudoVmaLeakFixer.class);
        return -1;
    L16:
        if (f203329a == true) goto L18;
        f203329a = true;     // Catch: Throwable -> L31
        f203330b = nFixScudoVmaLeak();     // Catch: Throwable -> L26
    L28:
        int r101 = f203330b;     // Catch: Throwable -> L31
        monitor-exit(ScudoVmaLeakFixer.class);
        return r101;
    L27:
        f203330b = -4;     // Catch: Throwable -> L31
        goto L28
    L18:
        if (a.f503457a == true) goto L20;
    L20:
        monitor-exit(ScudoVmaLeakFixer.class);
        return -2;
    L7:
        r100 = false;
        goto L8
    }
}
