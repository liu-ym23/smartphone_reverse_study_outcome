package com.larus.contextwindow.impl.data;

import com.larus.contextwindow.api.ContextWindowSnapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/contextwindow/api/ContextWindowSnapshot;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.data.ContextWindowSnapshotStore$observe$2", f = "ContextWindowSnapshotStore.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
public final class ContextWindowSnapshotStore$observe$2 extends SuspendLambda implements Function2<FlowCollector<? super ContextWindowSnapshot>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ContextWindowSnapshot $initialSnapshot;
    private /* synthetic */ Object L$0;
    int label;

    public ContextWindowSnapshotStore$observe$2(ContextWindowSnapshot r100, Continuation<? super ContextWindowSnapshotStore$observe$2> r101) {
        this.$initialSnapshot = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ContextWindowSnapshotStore$observe$2 r102 = new ContextWindowSnapshotStore$observe$2(this.$initialSnapshot, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super ContextWindowSnapshot> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super ContextWindowSnapshot> r100, Continuation<? super Unit> r101) {
        return ((ContextWindowSnapshotStore$observe$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FlowCollector r103 = (FlowCollector) this.L$0;
        ContextWindowSnapshot r104 = this.$initialSnapshot;
        this.label = 1;
        if (r103.emit(r104, this) != r101) goto L12;
        return r101;
    }
}
