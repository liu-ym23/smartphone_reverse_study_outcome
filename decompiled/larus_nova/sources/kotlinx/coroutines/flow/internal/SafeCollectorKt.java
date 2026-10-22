package kotlinx.coroutines.flow.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes42.dex */
public final class SafeCollectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> f504873a = null;

    static {
        SafeCollectorKt$emitFun$1 r100 = SafeCollectorKt$emitFun$1.INSTANCE;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f504873a = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r100, 3);
    }
}
