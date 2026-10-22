package iu8;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {
    static {
    }

    public static String a() {
        StackTraceElement[] r100 = ThreadMethodProxy.getLooperThread(Looper.getMainLooper()).getStackTrace();     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r100);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter(r100, "stackTraceElements");     // Catch: Throwable -> L7
        StringBuilder r101 = new StringBuilder();     // Catch: Throwable -> L7
        int r102 = r100.length;     // Catch: Throwable -> L7
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        StackTraceElement r104 = r100[r103];     // Catch: Throwable -> L7
        r101.append("  at ");     // Catch: Throwable -> L7
        r101.append(r104.getClassName());     // Catch: Throwable -> L7
        r101.append(".");     // Catch: Throwable -> L7
        r101.append(r104.getMethodName());     // Catch: Throwable -> L7
        r101.append("(");     // Catch: Throwable -> L7
        r101.append(r104.getFileName());     // Catch: Throwable -> L7
        r101.append(":");     // Catch: Throwable -> L7
        r101.append(r104.getLineNumber());     // Catch: Throwable -> L7
        r101.append(")\n");     // Catch: Throwable -> L7
        r103 = r103 + 1;     // Catch: Throwable -> L7
        goto L3
    L5:
        return r101.toString();
    L7:
        th = move-exception;
        nu8.a.f("StackDumpUtils", th, "dumpMainStack failed:");
        return "INVALID_STACK in app launch period!";
    }
}
