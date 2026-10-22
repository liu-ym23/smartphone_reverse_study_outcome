package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleComponent$TitleRightIconParams;", "params", "detectResult", "Lcom/larus/camera/impl/ui/component/result/general/ResultDetectStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$resultTitleRightIconStateFlow$3", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$resultTitleRightIconStateFlow$3 extends SuspendLambda implements Function3<ResultTitleComponent.b, n, Continuation<? super ResultTitleComponent.b>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public ResultTitleComponent$resultTitleRightIconStateFlow$3(Continuation<? super ResultTitleComponent$resultTitleRightIconStateFlow$3> r100) {
        super(3, r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ResultTitleComponent.b r100, n r101, Continuation<? super ResultTitleComponent.b> r102) {
        ResultTitleComponent$resultTitleRightIconStateFlow$3 r103 = new ResultTitleComponent$resultTitleRightIconStateFlow$3(r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(ResultTitleComponent.b r100, n r101, Continuation<? super ResultTitleComponent.b> r102) {
        return invoke2(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return ResultTitleComponent.b.a((ResultTitleComponent.b) this.L$0, false, (n) this.L$1, false, 23);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
