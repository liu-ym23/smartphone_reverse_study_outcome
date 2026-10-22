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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/widget/title/ResultTitleRightIconState;", "params", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleComponent$TitleRightIconParams;", "inMarkSelectMode", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$resultTitleRightIconStateFlow$5", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$resultTitleRightIconStateFlow$5 extends SuspendLambda implements Function3<ResultTitleComponent.b, Boolean, Continuation<? super ay8.a>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ ResultTitleComponent this$0;

    public ResultTitleComponent$resultTitleRightIconStateFlow$5(ResultTitleComponent r100, Continuation<? super ResultTitleComponent$resultTitleRightIconStateFlow$5> r101) {
        this.this$0 = r100;
        super(3, r101);
    }

    public final Object invoke(ResultTitleComponent.b r100, boolean r101, Continuation<? super ay8.a> r102) {
        ResultTitleComponent$resultTitleRightIconStateFlow$5 r103 = new ResultTitleComponent$resultTitleRightIconStateFlow$5(this.this$0, r102);
        r103.L$0 = r100;
        r103.Z$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(ResultTitleComponent.b r100, Boolean r101, Continuation<? super ay8.a> r102) {
        return invoke(r100, r101.booleanValue(), r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ResultTitleComponent.b r101 = (ResultTitleComponent.b) this.L$0;
        boolean r102 = this.Z$0;
        ResultTitleComponent r103 = this.this$0;
        Boolean r104 = r101.f322217a;
        boolean r105 = r101.f322218b;
        boolean r106 = r101.f322219c;
        n r107 = r101.f322220d;
        boolean r108 = r101.f322221e;
        int r109 = ResultTitleComponent.f322210s;
        return r103.y(r104, r105, r106, r107, r108, r102);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
