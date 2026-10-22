package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.u1;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f504930a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2<Object, CoroutineContext.Element, Object> f504931b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Function2<u1<?>, CoroutineContext.Element, u1<?>> f504932c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Function2<i0, CoroutineContext.Element, i0> f504933d = null;

    static {
        f504930a = new b0("NO_THREAD_ELEMENTS");
        f504931b = ThreadContextKt$countAll$1.INSTANCE;
        f504932c = ThreadContextKt$findOne$1.INSTANCE;
        f504933d = ThreadContextKt$updateState$1.INSTANCE;
    }

    public static final Object b(CoroutineContext r100) {
        Object r101 = r100.fold(0, f504931b);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public static final void a(CoroutineContext r100, Object r101) {
        if (r101 != f504930a) goto L6;
        return;
    L6:
        if ((r101 instanceof i0) == false) goto L13;
        i0 r102 = (i0) r101;
        int r103 = r102.f504958c.length - 1;
        if (r103 < 0) goto L16;
    L9:
        int r104 = r103 - 1;
        u1<Object> r105 = r102.f504958c[r103];
        Intrinsics.checkNotNull(r105);
        r105.restoreThreadContext(r100, r102.f504957b[r103]);
        if (r104 < 0) goto L17;
        r103 = r104;
        goto L9
    L17:
        return;
    L16:
        return;
    L13:
        Object r106 = r100.fold(null, f504932c);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((u1) r106).restoreThreadContext(r100, r101);
    }

    public static final Object c(CoroutineContext r100, Object r101) {
        if (r101 != null) goto L5;
        r101 = b(r100);
    L5:
        if (r101 != 0) goto L8;
        return f504930a;
    L8:
        if ((r101 instanceof Integer) == true) goto L13;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((u1) r101).updateThreadContext(r100);
    L13:
        return r100.fold(new i0(r100, ((Number) r101).intValue()), f504933d);
    }
}
