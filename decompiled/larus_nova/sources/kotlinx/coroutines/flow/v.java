package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes6.dex */
public final class v implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f504905b;

    public v(Flow r100, int r101) {
        this.f504904a = r100;
        this.f504905b = r101;
    }

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> r100, Continuation<? super Unit> r101) {
        Ref.IntRef r102 = new Ref.IntRef();
        Object r103 = this.f504904a.collect(new FlowKt__LimitKt$drop$2$1(r102, this.f504905b, r100), r101);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }
}
