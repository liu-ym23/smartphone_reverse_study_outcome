package com.larus.init.task.anr;

import android.content.Context;
import android.os.Process;
import ht9.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "base");
        a.a.getClass();
        if ((a.b(r1) & 2) == 0) goto L11;
        Process.setThreadPriority(Process.myPid(), -20);     // Catch: Throwable -> L6
        Process.getThreadPriority(Process.myPid());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.toString();
        return;
    }
}
