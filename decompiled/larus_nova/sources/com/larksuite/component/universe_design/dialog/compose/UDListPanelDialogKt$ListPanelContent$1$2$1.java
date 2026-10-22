package com.larksuite.component.universe_design.dialog.compose;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.component.universe_design.dialog.compose.UDListPanelDialogKt$ListPanelContent$1$2$1", f = "UDListPanelDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UDListPanelDialogKt$ListPanelContent$1$2$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Float> $accumulatedDrag$delegate;
    final /* synthetic */ float $hideThresholdPx;
    final /* synthetic */ Function0<Unit> $onDismissRequest;
    int label;

    public UDListPanelDialogKt$ListPanelContent$1$2$1(float r100, Function0<Unit> r101, MutableState<Float> r102, Continuation<? super UDListPanelDialogKt$ListPanelContent$1$2$1> r103) {
        this.$hideThresholdPx = r100;
        this.$onDismissRequest = r101;
        this.$accumulatedDrag$delegate = r102;
        super(3, r103);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Float r101, Continuation<? super Unit> r102) {
        return invoke(r100, r101.floatValue(), r102);
    }

    public final Object invoke(CoroutineScope r100, float r101, Continuation<? super Unit> r102) {
        return new UDListPanelDialogKt$ListPanelContent$1$2$1(this.$hideThresholdPx, this.$onDismissRequest, this.$accumulatedDrag$delegate, r102).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (this.$accumulatedDrag$delegate.getValue().floatValue() < this.$hideThresholdPx) goto L7;
        this.$onDismissRequest.invoke();
    L7:
        this.$accumulatedDrag$delegate.setValue(Float.valueOf(0.0f));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
