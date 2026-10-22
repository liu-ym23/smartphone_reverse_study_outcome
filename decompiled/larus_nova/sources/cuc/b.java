package cuc;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.internal.x;
import kotlinx.coroutines.t;

/* JADX INFO: loaded from: classes5.dex */
public final class b {
    public static final Object a(x r100, x r101, Function2 r102) {
    L7:
        th = move-exception;
        Object r103 = new t(th, false);
    L10:
        if (r103 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        Object r104 = r100.V(r103);
        if (r104 != g1.f504913b) goto L16;
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L16:
        if ((r104 instanceof t) == true) goto L20;
        return g1.a(r104);
    L20:
        throw ((t) r104).f505148a;
    L24:
        return IntrinsicsKt.getCOROUTINE_SUSPENDED();
    L3:
        if ((r102 instanceof BaseContinuationImpl) == true) goto L5;
        r103 = IntrinsicsKt.wrapWithContinuationImpl(r102, r101, r100);     // Catch: Throwable -> L7
    L21:
        goto L10
    L5:
        r103 = ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r102, 2)).invoke(r101, r100);     // Catch: Throwable -> L7
        goto L21
    }
}
