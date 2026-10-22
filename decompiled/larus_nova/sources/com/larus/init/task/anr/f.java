package com.larus.init.task.anr;

import android.content.Context;
import android.os.Process;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f351176a = 0;

    static {
    }

    public static void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        ht9.a.f487150a.getClass();
        if ((ht9.a.b(r100) & 2) == 0) goto L11;
        Process.setThreadPriority(Process.myPid(), -20);     // Catch: Throwable -> L6
        Process.getThreadPriority(Process.myPid());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.toString();
        return;
    }
}
