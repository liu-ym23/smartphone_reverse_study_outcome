package kotlinx.coroutines.debug.internal;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.Reference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DebugProbesImpl$startWeakRefCleanerThread$1 extends Lambda implements Function0<Unit> {
    public static final DebugProbesImpl$startWeakRefCleanerThread$1 INSTANCE = null;

    static {
        INSTANCE = new DebugProbesImpl$startWeakRefCleanerThread$1();
    }

    public DebugProbesImpl$startWeakRefCleanerThread$1() {
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ConcurrentWeakMap<CoroutineStackFrame, b> r100 = c.f504732d;
        if (r100.f504709a == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L19;
    L20:
        Reference<? extends CoroutineStackFrame> r102 = r100.f504709a.remove();     // Catch: InterruptedException -> L16
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlinx.coroutines.debug.internal.HashedWeakRef<*>");     // Catch: InterruptedException -> L16
        d r103 = (d) r102;     // Catch: InterruptedException -> L16
        ConcurrentWeakMap.a r104 = (ConcurrentWeakMap.a) ConcurrentWeakMap.f504708c.get(r100);     // Catch: InterruptedException -> L16
        r104.getClass();     // Catch: InterruptedException -> L16
        int r105 = (r103.f504733a * (-1640531527)) >>> r104.f504712b;     // Catch: InterruptedException -> L16
    L8:
        d r106 = (d) r104.f504714d.get(r105);     // Catch: InterruptedException -> L16
        if (r106 == null) goto L20;
        if (r106 == r103) goto L12;
        if (r105 != 0) goto L15;
        r105 = r104.f504711a;     // Catch: InterruptedException -> L16
    L15:
        r105 = r105 - 1;
        goto L8
    L12:
        r104.c(r105);     // Catch: InterruptedException -> L16
    L16:
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L19:
        throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
