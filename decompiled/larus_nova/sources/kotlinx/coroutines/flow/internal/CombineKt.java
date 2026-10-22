package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes5.dex */
public final class CombineKt {
    public static final <R, T> Object a(FlowCollector<? super R> r100, Flow<? extends T>[] r101, Function0<T[]> r102, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> r110, Continuation<? super Unit> r111) {
        CombineKt$combineInternal$2 r103 = new CombineKt$combineInternal$2(r101, r102, r110, r100, null);
        j r104 = new j(r111.getContext(), r111);
        Object r105 = cuc.b.a(r104, r104, r103);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        DebugProbesKt.probeCoroutineSuspended(r111);
    L6:
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r105;
    L9:
        return Unit.INSTANCE;
    }
}
