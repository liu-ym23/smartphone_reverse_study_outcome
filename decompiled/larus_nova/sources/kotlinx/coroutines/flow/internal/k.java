package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes6.dex */
public final class k implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f504888a;

    public k(Function3 r100) {
        this.f504888a = r100;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> r100, Continuation<? super Unit> r101) {
        FlowCoroutineKt$scopedFlow$1$1 r102 = new FlowCoroutineKt$scopedFlow$1$1(this.f504888a, r100, null);
        j r103 = new j(r101.getContext(), r101);
        Object r104 = cuc.b.a(r103, r103, r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L6:
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r104;
    L9:
        return Unit.INSTANCE;
    }
}
