package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ThreadContextKt {
    public static final b0 a = null;
    public static final Function2<Object, CoroutineContext.Element, Object> b = null;
    public static final Function2<u1<?>, CoroutineContext.Element, u1<?>> c = null;
    public static final Function2<i0, CoroutineContext.Element, i0> d = null;

    static {
        a = new b0("NO_THREAD_ELEMENTS");
        b = ThreadContextKt$countAll$1.INSTANCE;
        c = ThreadContextKt$findOne$1.INSTANCE;
        d = ThreadContextKt$updateState$1.INSTANCE;
    }

    public static final Object b(CoroutineContext r2) {
        Object r3 = r2.fold(0, b);
        Intrinsics.checkNotNull(r3);
        return r3;
    }

    public static final void a(CoroutineContext r4, Object r5) {
        if (r5 != a) goto L6;
        return;
    L6:
        if ((r5 instanceof i0) == false) goto L13;
        i0 r6 = (i0) r5;
        int r0 = r6.c.length - 1;
        if (r0 < 0) goto L16;
    L9:
        int r1 = r0 - 1;
        u1 r2 = r6.c[r0];
        Intrinsics.checkNotNull(r2);
        r2.restoreThreadContext(r4, r6.b[r0]);
        if (r1 < 0) goto L17;
        r0 = r1;
        goto L9
    L17:
        return;
    L16:
        return;
    L13:
        Object r3 = r4.fold(null, c);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((u1) r3).restoreThreadContext(r4, r5);
    }

    public static final Object c(CoroutineContext r1, Object r2) {
        if (r2 != null) goto L5;
        r2 = b(r1);
    L5:
        if (r2 != 0) goto L8;
        return a;
    L8:
        if ((r2 instanceof Integer) == true) goto L13;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((u1) r2).updateThreadContext(r1);
    L13:
        return r1.fold(new i0(r1, ((Number) r2).intValue()), d);
    }
}
