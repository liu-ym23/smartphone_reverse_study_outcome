package com.larus.office.plugins.titlebar;

import com.larus.bmhome.tipoff.TipOffApi;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/tipoff/ReportReasonsData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.titlebar.DocMorePanelConfigKt$reportDoc$1$reportReasonAsync$1", f = "DocMorePanelConfig.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
public final class DocMorePanelConfigKt$reportDoc$1$reportReasonAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.bmhome.tipoff.b>, Object> {
    int label;

    public DocMorePanelConfigKt$reportDoc$1$reportReasonAsync$1(Continuation<? super DocMorePanelConfigKt$reportDoc$1$reportReasonAsync$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DocMorePanelConfigKt$reportDoc$1$reportReasonAsync$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super com.larus.bmhome.tipoff.b> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super com.larus.bmhome.tipoff.b> r101) {
        return ((DocMorePanelConfigKt$reportDoc$1$reportReasonAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return ((com.larus.network.http.a) r100).f360135b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        int r103 = TipOffApi.f314671a;
        this.label = 1;
        r100 = TipOffApi.a("24", this);
        if (r100 != r101) goto L12;
        return r101;
    }
}
