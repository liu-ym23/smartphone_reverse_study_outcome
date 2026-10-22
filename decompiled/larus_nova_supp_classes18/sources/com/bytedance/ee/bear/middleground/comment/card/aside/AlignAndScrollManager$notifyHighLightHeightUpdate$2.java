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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AlignAndScrollManager$notifyHighLightHeightUpdate$2", f = "AlignAndScrollManager.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
public final class AlignAndScrollManager$notifyHighLightHeightUpdate$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $position;
    final /* synthetic */ Ref.BooleanRef $success;
    Object L$0;
    int label;
    final /* synthetic */ AlignAndScrollManager this$0;

    public AlignAndScrollManager$notifyHighLightHeightUpdate$2(Ref.BooleanRef r1, AlignAndScrollManager r2, int r3, Continuation<? super AlignAndScrollManager$notifyHighLightHeightUpdate$2> r4) {
        this.$success = r1;
        this.this$0 = r2;
        this.$position = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AlignAndScrollManager$notifyHighLightHeightUpdate$2(this.$success, this.this$0, this.$position, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Ref.BooleanRef r2 = (Ref.BooleanRef) this.L$0;
        ResultKt.throwOnFailure(r5);
    L12:
        r2.element = ((Boolean) r5).booleanValue();
        tt5.a.h("Comment#AlignAndScrollManager", "notifyHighLightHeightUpdate retry, result is " + this.$success.element);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        Ref.BooleanRef r6 = this.$success;
        AlignAndScrollManager r3 = this.this$0;
        int r4 = this.$position;
        this.L$0 = r6;
        this.label = 1;
        int r7 = AlignAndScrollManager.e;
        Object r8 = r3.g(r4, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r6;
        r5 = r8;
        goto L12
    }
}
