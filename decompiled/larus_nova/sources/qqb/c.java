package qqb;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c {
    public static final b a(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new b(a.d(), r100);
    }

    public static final void c(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "block");
        a.h("");     // Catch: Throwable -> L6
        r100.run();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final <R> R b(String r100, Function0<? extends R> r101) {
        Intrinsics.checkNotNullParameter(r100, "mark");
        Intrinsics.checkNotNullParameter(r101, "block");
        a.h(r100);     // Catch: Throwable -> L6
        R r102 = r101.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        return r102;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final void d(String r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, "mark");
        Intrinsics.checkNotNullParameter(r101, "block");
        a.h(r100);     // Catch: Throwable -> L6
        r101.run();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        a.a();
        InlineMarker.finallyEnd(1);
        throw th;
    }
}
