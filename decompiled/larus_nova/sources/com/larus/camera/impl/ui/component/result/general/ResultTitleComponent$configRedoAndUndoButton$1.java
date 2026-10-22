package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/ui/component/result/general/ResultTitleEditState;", "redo", "", "undo", "inMarkSelectMode", "inCropMode"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTitleComponent$configRedoAndUndoButton$1", f = "ResultTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTitleComponent$configRedoAndUndoButton$1 extends SuspendLambda implements Function5<Boolean, Boolean, Boolean, Boolean, Continuation<? super d2>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    /* synthetic */ boolean Z$3;
    int label;

    public ResultTitleComponent$configRedoAndUndoButton$1(Continuation<? super ResultTitleComponent$configRedoAndUndoButton$1> r100) {
        super(5, r100);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Boolean r101, Boolean r102, Boolean r110, Continuation<? super d2> r111) {
        return invoke(r100.booleanValue(), r101.booleanValue(), r102.booleanValue(), r110.booleanValue(), r111);
    }

    public final Object invoke(boolean r100, boolean r101, boolean r102, boolean r103, Continuation<? super d2> r104) {
        ResultTitleComponent$configRedoAndUndoButton$1 r105 = new ResultTitleComponent$configRedoAndUndoButton$1(r104);
        r105.Z$0 = r100;
        r105.Z$1 = r101;
        r105.Z$2 = r102;
        r105.Z$3 = r103;
        return r105.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return new d2(this.Z$0, this.Z$1, this.Z$2, this.Z$3);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
