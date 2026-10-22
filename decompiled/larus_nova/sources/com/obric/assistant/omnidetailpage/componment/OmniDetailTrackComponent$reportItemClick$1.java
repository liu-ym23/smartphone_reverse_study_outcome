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
@DebugMetadata(c = "com.obric.assistant.omnidetailpage.componment.OmniDetailTrackComponent$reportItemClick$1", f = "OmniDetailTrackComponent.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
public final class OmniDetailTrackComponent$reportItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $itemName;
    int label;
    final /* synthetic */ OmniDetailTrackComponent this$0;

    public OmniDetailTrackComponent$reportItemClick$1(OmniDetailTrackComponent r100, String r101, Continuation<? super OmniDetailTrackComponent$reportItemClick$1> r102) {
        this.this$0 = r100;
        this.$itemName = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OmniDetailTrackComponent$reportItemClick$1(this.this$0, this.$itemName, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OmniDetailTrackComponent$reportItemClick$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        Bundle r103 = (Bundle) r100;
        r103.putString("item_name", this.$itemName);
        com.larus.platform.service.o.f365780a.b("obric_omni_detail_item_click", r103);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        OmniDetailTrackComponent r104 = this.this$0;
        this.label = 1;
        r100 = OmniDetailTrackComponent.F2(r104, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
