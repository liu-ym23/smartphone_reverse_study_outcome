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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleComponent$TitleRightIconParams;", "photoEditable", "", "inCropMode"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$resultTitleRightIconStateFlow$1", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$resultTitleRightIconStateFlow$1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super ResultTitleComponent.b>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public ResultTitleComponent$resultTitleRightIconStateFlow$1(Continuation<? super ResultTitleComponent$resultTitleRightIconStateFlow$1> r100) {
        super(3, r100);
    }

    public final Object invoke(Boolean r100, boolean r101, Continuation<? super ResultTitleComponent.b> r102) {
        ResultTitleComponent$resultTitleRightIconStateFlow$1 r103 = new ResultTitleComponent$resultTitleRightIconStateFlow$1(r102);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Boolean r101, Continuation<? super ResultTitleComponent.b> r102) {
        return invoke(r100, r101.booleanValue(), r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return new ResultTitleComponent.b((Boolean) this.L$0, this.Z$0, 28);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
