package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import t39.l;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession$setStateListener$1$onGuideStateChange$1$1$1", f = "DoraGuideServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GuideSession$setStateListener$1$onGuideStateChange$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ l $interactor;
    final /* synthetic */ int $prevState;
    final /* synthetic */ int $state;
    int label;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$setStateListener$1$onGuideStateChange$1$1$1(GuideSession r100, l r101, int r102, int r103, Continuation<? super GuideSession$setStateListener$1$onGuideStateChange$1$1$1> r104) {
        this.this$0 = r100;
        this.$interactor = r101;
        this.$state = r102;
        this.$prevState = r103;
        super(1, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new GuideSession$setStateListener$1$onGuideStateChange$1$1$1(this.this$0, this.$interactor, this.$state, this.$prevState, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((GuideSession$setStateListener$1$onGuideStateChange$1$1$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        GuideSession r101 = this.this$0;
        r101.f335964h.invoke(Boxing.boxInt(r101.f335957a), Boxing.boxInt(this.$interactor.f()), Boxing.boxInt(this.$state), Boxing.boxInt(this.$prevState));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
