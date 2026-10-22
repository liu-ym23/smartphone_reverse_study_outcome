package com.obric.assistant.guide.ui;

import android.widget.TextView;
import com.obric.assistant.impl.databinding.ObricGuideForVoiceEnrollBinding;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.guide.ui.VoiceEnrollFragment$updateViews$1", f = "VoiceEnrollFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollFragment$updateViews$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ VoiceEnrollFragment this$0;

    public VoiceEnrollFragment$updateViews$1(VoiceEnrollFragment r100, Continuation<? super VoiceEnrollFragment$updateViews$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoiceEnrollFragment$updateViews$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoiceEnrollFragment$updateViews$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r100);
        ObricGuideForVoiceEnrollBinding r101 = this.this$0.f389351d;
        if (r101 == null) goto L9;
        OButton r102 = r101.f389585d;
        if (r102 == null) goto L9;
        r102.setVisibility(0);
    L9:
        ObricGuideForVoiceEnrollBinding r103 = this.this$0.f389351d;
        if (r103 == null) goto L14;
        OButton r104 = r103.f389586e;
        if (r104 == null) goto L14;
        r104.setVisibility(8);
    L14:
        ObricGuideForVoiceEnrollBinding r105 = this.this$0.f389351d;
        if (r105 == null) goto L19;
        OButton r106 = r105.f389591j;
        if (r106 == null) goto L19;
        r106.setVisibility(8);
    L19:
        ObricGuideForVoiceEnrollBinding r107 = this.this$0.f389351d;
        if (r107 == null) goto L24;
        TextView r108 = r107.f389588g;
        if (r108 == null) goto L24;
        r108.setVisibility(0);
    L24:
        ObricGuideForVoiceEnrollBinding r109 = this.this$0.f389351d;
        if (r109 == null) goto L29;
        TextView r110 = r109.f389589h;
        if (r110 == null) goto L29;
        r110.setVisibility(8);
    L29:
        ObricGuideForVoiceEnrollBinding r111 = this.this$0.f389351d;
        if (r111 == null) goto L35;
        TextView r112 = r111.f389583b;
        if (r112 == null) goto L35;
        r112.setVisibility(0);
    L35:
        return Unit.INSTANCE;
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
