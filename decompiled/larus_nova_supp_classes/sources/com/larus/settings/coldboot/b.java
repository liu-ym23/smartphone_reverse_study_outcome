package com.larus.settings.coldboot;

import android.content.Context;
import com.larus.settings.value.e10;
import com.larus.settings.value.me;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import qt9.c2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static final b a = null;
    public static final EarlyFileSettingsStore.Key b = null;
    public static final EarlyFileSettingsStore.Key c = null;
    public static final EarlyFileSettingsStore.Key d = null;
    public static volatile a e;
    public static final Object f = null;

    public b() {
    }

    static {
        a = new b();
        b = EarlyFileSettingsStore.Key.KEVA_INIT_REPO_MAIN_ONLY_OPT;
        c = EarlyFileSettingsStore.Key.KEVA_GET_REPO_LOCK_OPT;
        d = EarlyFileSettingsStore.Key.KEVA_EXECUTOR_OPT;
        f = new Object();
    }

    public static a a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        a r0 = e;
        if (r0 == null) goto L6;
        r0.toString();
        return r0;
    L6:
        Object r1 = f;
        monitor-enter(r1);
        a r3 = e;     // Catch: Throwable -> L14
        if (r3 == null) goto L11;
        r3.toString();     // Catch: Throwable -> L14
    L12:
        monitor-exit(r1);
        return r3;
    L11:
        a.getClass();     // Catch: Throwable -> L14
        r3 = b(r2);     // Catch: Throwable -> L14
        e = r3;     // Catch: Throwable -> L14
        Objects.toString(r3);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public static a b(Context r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        int r1 = EarlyFileSettingsStore.a;     // Catch: Throwable -> L4
        Object r5 = Result.m49constructorimpl(new a(EarlyFileSettingsStore.b(r4, b), EarlyFileSettingsStore.b(r4, c), EarlyFileSettingsStore.b(r4, d)));     // Catch: Throwable -> L4
    L6:
        Result.m52exceptionOrNullimpl(r5);
        a r2 = a.d;
        if (Result.m55isFailureimpl(r5) == false) goto L10;
        r5 = r2;
    L10:
        return (a) r5;
    L4:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r5 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static void d(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        e10 r2 = e10.a;     // Catch: Throwable -> L5
        Object r3 = Result.m49constructorimpl((c2) l0.a(new c2(0), new me()));     // Catch: Throwable -> L5
    L7:
        Throwable r4 = Result.m52exceptionOrNullimpl(r3);
        if (r4 == null) goto L10;
        FLogger.a.e("KevaEarlyPerfOptConfig", "read settings failed, use disabled config", r4);
    L10:
        c2 r5 = new c2(0);
        if (Result.m55isFailureimpl(r3) == false) goto L13;
        r3 = r5;
    L13:
        c2 r7 = (c2) r3;
        c(r6, b, r7.d());
        c(r6, c, r7.b());
        c(r6, d, r7.a());
        e = b(r6);
        FLogger.a.i("KevaEarlyPerfOptConfig", "updateFromSettings config=" + r7 + " cachedConfig=" + e);
        return;
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static void c(Context r2, EarlyFileSettingsStore.Key r3, boolean r4) {
        if (EarlyFileSettingsStore.d(r2, r3, r4) == true) goto L6;
        FLogger.a.e("KevaEarlyPerfOptConfig", "setMarkerEnabled failed, key=" + r3 + " enabled=" + r4);
        return;
    }
}
