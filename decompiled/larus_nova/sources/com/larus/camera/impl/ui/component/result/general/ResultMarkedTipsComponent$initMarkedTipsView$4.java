package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.api.vlm.VLMIntent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/camera/api/vlm/VLMIntentDetectResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultMarkedTipsComponent$initMarkedTipsView$4", f = "ResultMarkedTipsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultMarkedTipsComponent$initMarkedTipsView$4 extends SuspendLambda implements Function2<ix8.d, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ p this$0;

    public ResultMarkedTipsComponent$initMarkedTipsView$4(p r100, Continuation<? super ResultMarkedTipsComponent$initMarkedTipsView$4> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ResultMarkedTipsComponent$initMarkedTipsView$4 r102 = new ResultMarkedTipsComponent$initMarkedTipsView$4(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ix8.d r100, Continuation<? super Unit> r101) {
        return ((ResultMarkedTipsComponent$initMarkedTipsView$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ix8.d r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (((ix8.d) this.L$0).f496391a != VLMIntent.COMMON) goto L8;
        p r101 = this.this$0;
        int r102 = p.f322327o;
        r101.r();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
