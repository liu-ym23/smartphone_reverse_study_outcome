package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import android.view.View;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.ss.android.lark.foundation.widget.FlowSwitch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "saveArtifactType", "", "saveArtifactReady", "saveArtifactSyncing"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation.MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6", f = "MmStandaloneAIInterpretationToolBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6 extends SuspendLambda implements Function4<Boolean, Boolean, Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    int label;
    final /* synthetic */ MmStandaloneAIInterpretationToolBarView this$0;

    public MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6(MmStandaloneAIInterpretationToolBarView r100, Continuation<? super MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6> r101) {
        this.this$0 = r100;
        super(4, r101);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Boolean r101, Boolean r102, Continuation<? super Unit> r103) {
        return invoke(r100.booleanValue(), r101.booleanValue(), r102.booleanValue(), r103);
    }

    public final Object invoke(boolean r100, boolean r101, boolean r102, Continuation<? super Unit> r103) {
        MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6 r104 = new MmStandaloneAIInterpretationToolBarView$bindSaveSwitch$6(this.this$0, r103);
        r104.Z$0 = r100;
        r104.Z$1 = r101;
        r104.Z$2 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        boolean r102 = this.Z$1;
        boolean r103 = this.Z$2;
        View r104 = this.this$0.f436733b;
        if ((r104 instanceof FlowSwitch) == false) goto L8;
        ((FlowSwitch) r104).setChecked(r101);
    L10:
        View r105 = this.this$0.f436733b;
        if (r102 == false) goto L14;
        if (r103 == true) goto L14;
        boolean r106 = true;
    L15:
        r105.setEnabled(r106);
        MmStandaloneAIInterpretationToolBarView r107 = this.this$0;
        r107.f436734c.setEnabled(r107.f436733b.isEnabled());
        return Unit.INSTANCE;
    L14:
        r106 = false;
        goto L15
    L8:
        if ((r104 instanceof UDSwitch) == false) goto L10;
        ((UDSwitch) r104).setCheckedIgnoreEvent(r101);
        goto L10
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
