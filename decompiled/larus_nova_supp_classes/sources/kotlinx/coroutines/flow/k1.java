package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.flow.internal.a;
import kotlinx.coroutines.flow.internal.b;
import kotlinx.coroutines.flow.internal.c;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class k1 extends c<StateFlowImpl<?>> {
    public final AtomicReference<Object> a;

    public k1() {
        this.a = new AtomicReference(null);
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public final boolean a(a r2) {
        StateFlowImpl r3 = (StateFlowImpl) r2;
        if (this.a.get() == null) goto L5;
        return false;
    L5:
        this.a.set(j1.a);
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.c
    public final Continuation[] b(a r2) {
        StateFlowImpl r3 = (StateFlowImpl) r2;
        this.a.set(null);
        return b.a;
    }

    public final Object c(Continuation<? super Unit> r6) {
        boolean r2 = true;
        j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        AtomicReference<Object> r1 = this.a;
        b0 r3 = j1.a;
    L4:
        if (r1.compareAndSet(r3, r0) == true) goto L9;
        if (r1.get() == r3) goto L4;
        r2 = false;
    L9:
        if (r2 == true) goto L11;
        Result.Companion r4 = Result.Companion;
        r0.resumeWith(Result.m49constructorimpl(Unit.INSTANCE));
    L11:
        Object r5 = r0.B();
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L15:
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        return r5;
    L18:
        return Unit.INSTANCE;
    }
}
