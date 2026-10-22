package com.larus.utils;

import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class l0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(Function0 r4) {
        Intrinsics.checkNotNullParameter(r4, "onInvoke");
        r4.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        g.a.ensureNotReachHere(th, "SafeExt");
        FLogger.a.e("SafeExt", "safeUse: " + th);
    }

    public static Object a(Object r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r5, "onInvoke");
        return r5.invoke();
    L5:
        th = move-exception;
        g.a.ensureNotReachHere(th, "SafeExt");
        FLogger.a.e("SafeExt", "safeReturn: " + th + ", defaultValue: " + r4);
        return r4;
    }
}
