package com.larus.business.multitask_management.impl.component;

import com.larus.multitask_management.api.data.quick_access.NodeType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.multitask_management.impl.component.PinnedServicesFeature$pinListener$1$onUnpinned$1", f = "PinnedServicesFeature.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PinnedServicesFeature$pinListener$1$onUnpinned$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NodeType $nodeType;
    final /* synthetic */ String $referenceId;
    int label;
    final /* synthetic */ PinnedServicesFeature this$0;

    public PinnedServicesFeature$pinListener$1$onUnpinned$1(PinnedServicesFeature r100, NodeType r101, String r102, Continuation<? super PinnedServicesFeature$pinListener$1$onUnpinned$1> r103) {
        this.this$0 = r100;
        this.$nodeType = r101;
        this.$referenceId = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PinnedServicesFeature$pinListener$1$onUnpinned$1(this.this$0, this.$nodeType, this.$referenceId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((PinnedServicesFeature$pinListener$1$onUnpinned$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        PinnedServicesFeature.F2(this.this$0, this.$nodeType, this.$referenceId);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
