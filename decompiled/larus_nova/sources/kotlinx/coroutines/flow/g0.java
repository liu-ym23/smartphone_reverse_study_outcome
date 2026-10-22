package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: loaded from: classes42.dex */
public final class g0 implements FlowCollector<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f504853a;

    public g0(Ref.ObjectRef r100) {
        this.f504853a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, kotlinx.coroutines.internal.b0] */
    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation<? super Unit> r101) {
        Ref.ObjectRef r102 = this.f504853a;
        T r103 = r102.element;
        ?? r104 = kotlinx.coroutines.flow.internal.o.f504892a;
        if (r103 != r104) goto L5;
        r102.element = r100;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L10;
        return Unit.INSTANCE;
    L10:
        throw new AbortFlowException(this);
    L5:
        r102.element = r104;
        r105 = false;
        goto L6
    }
}
