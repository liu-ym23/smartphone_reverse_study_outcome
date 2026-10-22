package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;
import kh4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ScudoVmaLeakFixer {
    public static boolean a;
    public static int b;

    public ScudoVmaLeakFixer() {
    }

    private static native int nFixScudoVmaLeak();

    public static synchronized int a() {
        monitor-enter(ScudoVmaLeakFixer.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (NpthRepair.c != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L16;
        if (a.a == true) goto L12;
    L12:
        monitor-exit(ScudoVmaLeakFixer.class);
        return -1;
    L16:
        if (a == true) goto L18;
        a = true;     // Catch: Throwable -> L31
        b = nFixScudoVmaLeak();     // Catch: Throwable -> L26
    L28:
        int r2 = b;     // Catch: Throwable -> L31
        monitor-exit(ScudoVmaLeakFixer.class);
        return r2;
    L27:
        b = -4;     // Catch: Throwable -> L31
        goto L28
    L18:
        if (a.a == true) goto L20;
    L20:
        monitor-exit(ScudoVmaLeakFixer.class);
        return -2;
    L7:
        r1 = false;
        goto L8
    }
}
