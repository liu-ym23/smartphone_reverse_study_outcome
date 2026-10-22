package kk;

import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {
    public static final void c(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        r100.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
    }

    public static final <T> T a(T r100, Function0<? extends T> r101) {
        Intrinsics.checkNotNullParameter(r101, "block");
        return r101.invoke();
    L5:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        return r100;
    }

    public static final <T> T b(Function0<? extends T> r100, Function1<? super Throwable, ? extends T> r101) {
        Intrinsics.checkNotNullParameter(r100, "block");
        Intrinsics.checkNotNullParameter(r101, "fallbackBlock");
        return r100.invoke();
    L5:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        return r101.invoke(th);
    }
}
