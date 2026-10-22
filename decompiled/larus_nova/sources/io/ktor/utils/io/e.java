package io.ktor.utils.io;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static final boolean a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.close(null);
    }

    public static final Object b(d r100, String r101, Continuation<? super Unit> r102) {
        io.ktor.utils.io.core.j r103 = new io.ktor.utils.io.core.j(null);
        io.ktor.utils.io.core.v.d(r103, r101);     // Catch: Throwable -> L9
        Object r104 = r100.l(r103.m(), (ContinuationImpl) r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r104;
    L8:
        return Unit.INSTANCE;
    L9:
        th = move-exception;
        r103.close();
        throw th;
    }
}
