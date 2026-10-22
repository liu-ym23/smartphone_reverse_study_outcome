package com.larus.utils;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f375430a = 0;

    static {
    }

    public static void b(Function0 r100) {
        Intrinsics.checkNotNullParameter(r100, "onInvoke");
        r100.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(th, "SafeExt");
        FLogger.f375446a.e("SafeExt", "safeUse: " + th);
    }

    public static Object a(Object r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "onInvoke");
        return r101.invoke();
    L5:
        th = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(th, "SafeExt");
        FLogger.f375446a.e("SafeExt", "safeReturn: " + th + ", defaultValue: " + r100);
        return r100;
    }
}
