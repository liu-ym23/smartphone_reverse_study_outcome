package kotlinx.coroutines.selects;

import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(SelectImplementation r100, long r101, Function1 r110) {
        b r102 = new b(r101);
        OnTimeout$selectClause$1 r103 = OnTimeout$selectClause$1.INSTANCE;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        r100.k(new SelectImplementation.a(r100, r102, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(r103, 3), SelectKt.f505099a, SelectKt.f505104f, (SuspendLambda) r110, null), false);
    }
}
