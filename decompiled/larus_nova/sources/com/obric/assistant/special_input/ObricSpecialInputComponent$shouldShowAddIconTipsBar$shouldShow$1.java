package com.obric.assistant.special_input;

import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1", f = "ObricSpecialInputComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1(Continuation<? super ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1 r102 = new ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((ObricSpecialInputComponent$shouldShowAddIconTipsBar$shouldShow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
        IAgentTaskAppIDL r103 = com.obric.aiagent.assistant.idl.s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class));     // Catch: Throwable -> L11
        if (r103 == null) goto L8;
        boolean r104 = r103.shouldShowAddTaskManagerIconGuide();     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(Boxing.boxBoolean(r104));     // Catch: Throwable -> L11
    L13:
        Boolean r106 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r105) == true) goto L16;
        return r105;
    L16:
        return r106;
    L8:
        r104 = false;
    L11:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
