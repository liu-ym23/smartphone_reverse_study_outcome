package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: classes5.dex */
public final class v0 implements Flow<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Flow f504906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Flow f504907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function3 f504908c;

    @Override // kotlinx.coroutines.flow.Flow
    public final Object collect(FlowCollector<? super Object> r100, Continuation<? super Unit> r101) {
        Object r102 = CombineKt.a(r100, new Flow[]{this.f504906a, this.f504907b}, FlowKt__ZipKt$nullArrayFactory$1.INSTANCE, new FlowKt__ZipKt$combine$1$1(this.f504908c, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r102;
    L6:
        return Unit.INSTANCE;
    }

    public v0(Flow r100, Flow r101, Function3 r102) {
        this.f504906a = r100;
        this.f504907b = r101;
        this.f504908c = r102;
    }
}
