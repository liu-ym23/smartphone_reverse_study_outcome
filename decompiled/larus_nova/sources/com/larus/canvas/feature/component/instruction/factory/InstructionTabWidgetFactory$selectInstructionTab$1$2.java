package com.larus.canvas.feature.component.instruction.factory;

import com.larus.canvas.feature.component.instruction.InstructionTabEventType;
import com.larus.canvas.service.bean.InstructionTab;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.instruction.factory.InstructionTabWidgetFactory$selectInstructionTab$1$2", f = "InstructionTabWidgetFactory.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class InstructionTabWidgetFactory$selectInstructionTab$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InstructionTab $selectInstructionTab;
    int label;

    public InstructionTabWidgetFactory$selectInstructionTab$1$2(InstructionTab r100, Continuation<? super InstructionTabWidgetFactory$selectInstructionTab$1$2> r101) {
        this.$selectInstructionTab = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new InstructionTabWidgetFactory$selectInstructionTab$1$2(this.$selectInstructionTab, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((InstructionTabWidgetFactory$selectInstructionTab$1$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        MutableSharedFlow<com.larus.canvas.feature.component.instruction.c> r111 = com.larus.canvas.feature.component.instruction.d.f323127a;
        com.larus.canvas.feature.component.instruction.c r112 = new com.larus.canvas.feature.component.instruction.c(InstructionTabEventType.EVENT_INSTRUCTION_TAB_SELECTED, this.$selectInstructionTab, null, true, 4);
        this.label = 1;
        if (com.larus.canvas.feature.component.instruction.d.a(r112, this) != r100) goto L12;
        return r100;
    }
}
