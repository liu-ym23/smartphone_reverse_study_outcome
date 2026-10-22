package com.bytedance.crash.npth_repair.nativeCrash;

import com.bytedance.crash.npth_repair.NpthRepair;
import kh4.a;

/* JADX INFO: loaded from: classes.dex */
public class ArtDumpNativeStackFixer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f203323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f203324b;

    public ArtDumpNativeStackFixer() {
    }

    private static native int nStartFixDumpNativeStack();

    private static native void nStopFixDumpNativeStack();

    public static synchronized int a() {
        monitor-enter(ArtDumpNativeStackFixer.class);
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
        monitor-exit(ArtDumpNativeStackFixer.class);
        return -1;
    L16:
        if (f203323a == true) goto L18;
        f203323a = true;     // Catch: Throwable -> L31
        f203324b = nStartFixDumpNativeStack();     // Catch: Throwable -> L26
    L28:
        int r101 = f203324b;     // Catch: Throwable -> L31
        monitor-exit(ArtDumpNativeStackFixer.class);
        return r101;
    L27:
        f203324b = -4;     // Catch: Throwable -> L31
        goto L28
    L18:
        if (a.f503457a == true) goto L20;
    L20:
        monitor-exit(ArtDumpNativeStackFixer.class);
        return -2;
    L7:
        r100 = false;
        goto L8
    }
}
