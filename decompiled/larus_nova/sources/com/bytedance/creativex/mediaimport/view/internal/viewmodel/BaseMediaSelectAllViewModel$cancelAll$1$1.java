package com.bytedance.creativex.mediaimport.view.internal.viewmodel;

import ki4.a0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import ti4.e0;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.creativex.mediaimport.view.internal.viewmodel.BaseMediaSelectAllViewModel$cancelAll$1$1", f = "MediaSelectAllViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseMediaSelectAllViewModel$cancelAll$1$1 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ a0 $category;
    int label;
    final /* synthetic */ d<Object, Object> this$0;

    public BaseMediaSelectAllViewModel$cancelAll$1$1(d<Object, Object> r100, a0 r101, Continuation<? super BaseMediaSelectAllViewModel$cancelAll$1$1> r102) {
        this.this$0 = r100;
        this.$category = r101;
        super(3, r102);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Integer> r100, Throwable r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super Integer> r100, Throwable r101, Continuation<? super Unit> r102) {
        return new BaseMediaSelectAllViewModel$cancelAll$1$1(this.this$0, this.$category, r102).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.this$0.f204126g.onNext(new e0.a(this.$category));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
