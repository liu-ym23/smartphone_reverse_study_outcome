package com.obric.assistant.omnidetailpage.componment;

import android.os.Bundle;
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
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailTrackComponent$reportShowEvent$1", f = "OmniDetailTrackComponent.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
final class OmniDetailTrackComponent$reportShowEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ OmniDetailTrackComponent this$0;

    public OmniDetailTrackComponent$reportShowEvent$1(OmniDetailTrackComponent r100, Continuation<? super OmniDetailTrackComponent$reportShowEvent$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OmniDetailTrackComponent$reportShowEvent$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OmniDetailTrackComponent$reportShowEvent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        String r103 = (String) this.L$1;
        com.larus.platform.service.o r104 = (com.larus.platform.service.o) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        r104.b(r103, (Bundle) r100);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r104 = com.larus.platform.service.o.f365780a;
        OmniDetailTrackComponent r105 = this.this$0;
        this.L$0 = r104;
        this.L$1 = "obric_omni_detail_show";
        this.label = 1;
        r100 = OmniDetailTrackComponent.F2(r105, this);
        if (r100 != r101) goto L11;
        return r101;
    L11:
        r103 = "obric_omni_detail_show";
        goto L12
    }
}
