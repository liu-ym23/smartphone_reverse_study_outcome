package com.bytedance.ee.bear.middleground.comment.card.aside;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager$notifyHighLightHeightUpdate$2", f = "AlignAndScrollManager.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
public final class AlignAndScrollManager$notifyHighLightHeightUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    final /* synthetic */ Ref.BooleanRef $success;
    Object L$0;
    int label;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$notifyHighLightHeightUpdate$2(Ref.BooleanRef r100, AlignAndScrollManager r101, int r102, Continuation<? super AlignAndScrollManager$notifyHighLightHeightUpdate$2> r103) {
        this.$success = r100;
        this.this$0 = r101;
        this.$position = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AlignAndScrollManager$notifyHighLightHeightUpdate$2(this.$success, this.this$0, this.$position, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AlignAndScrollManager$notifyHighLightHeightUpdate$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Ref.BooleanRef r103 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        r103.element = ((Boolean) r100).booleanValue();
        tt5.a.h("Comment#AlignAndScrollManager", "notifyHighLightHeightUpdate retry, result is " + this.$success.element);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Ref.BooleanRef r104 = this.$success;
        AlignAndScrollManager r105 = this.this$0;
        int r106 = this.$position;
        this.L$0 = r104;
        this.label = 1;
        int r107 = AlignAndScrollManager.f230873e;
        Object r108 = r105.g(r106, this);
        if (r108 != r101) goto L11;
        return r101;
    L11:
        r103 = r104;
        r100 = r108;
        goto L12
    }
}
