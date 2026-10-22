package com.larus.dora.impl.device;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1", f = "DoraBaseFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ DoraBaseFragment this$0;

    public DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1(DoraBaseFragment r100, int r101, Continuation<? super DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1> r102) {
        this.this$0 = r100;
        this.$state = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1(this.this$0, this.$state, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoraBaseFragment$doraLinkCallback$1$onDoraLinkStateChanged$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        DoraBaseFragment r101 = this.this$0;
        if (this.$state != 2) goto L7;
        boolean r102 = true;
    L8:
        r101.V90(r102);
        return Unit.INSTANCE;
    L7:
        r102 = false;
        goto L8
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
