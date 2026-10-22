package com.ss.android.lark.inline.ai.ui.view;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/edittext2/edittors/editinfo/InsertAtInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.ui.view.InlineEditTextFunctionImpl$getAtInfo$2", f = "InlineEditTextFunctionImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InlineEditTextFunctionImpl$getAtInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super hob.c>, Object> {
    final /* synthetic */ hob.c $atInfo;
    int label;

    public InlineEditTextFunctionImpl$getAtInfo$2(hob.c r100, Continuation<? super InlineEditTextFunctionImpl$getAtInfo$2> r101) {
        this.$atInfo = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new InlineEditTextFunctionImpl$getAtInfo$2(this.$atInfo, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super hob.c> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super hob.c> r101) {
        return ((InlineEditTextFunctionImpl$getAtInfo$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return this.$atInfo;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
