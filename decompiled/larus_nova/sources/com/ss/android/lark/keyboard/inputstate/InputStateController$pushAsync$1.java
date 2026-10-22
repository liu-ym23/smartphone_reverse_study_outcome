package com.ss.android.lark.keyboard.inputstate;

import cya.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.inputstate.InputStateController$pushAsync$1", f = "InputStateController.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class InputStateController$pushAsync$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<Boolean> $result;
    final /* synthetic */ h $state;
    Object L$0;
    int label;
    final /* synthetic */ InputStateController this$0;

    public InputStateController$pushAsync$1(InputStateController r100, CompletableDeferred<Boolean> r101, h r102, Continuation<? super InputStateController$pushAsync$1> r103) {
        this.this$0 = r100;
        this.$result = r101;
        this.$state = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new InputStateController$pushAsync$1(this.this$0, this.$result, this.$state, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((InputStateController$pushAsync$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        CompletableDeferred r103 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r100);
    L16:
        r103.complete(r100);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        InputStateController r104 = this.this$0;
        if (r104.f429424j == true) goto L12;
        this.$result.complete(Boxing.boxBoolean(false));
        return Unit.INSTANCE;
    L12:
        CompletableDeferred<Boolean> r105 = this.$result;
        h r106 = this.$state;
        this.L$0 = r105;
        this.label = 1;
        r100 = r104.k(r106, true);
        if (r100 != r101) goto L15;
        return r101;
    L15:
        r103 = r105;
        goto L16
    }
}
