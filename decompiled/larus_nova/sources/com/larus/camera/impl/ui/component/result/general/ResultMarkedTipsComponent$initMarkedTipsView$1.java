package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "inMarkSelectMode", "inCropMode"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultMarkedTipsComponent$initMarkedTipsView$1", f = "ResultMarkedTipsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultMarkedTipsComponent$initMarkedTipsView$1 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Pair<? extends Boolean, ? extends Boolean>>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    public ResultMarkedTipsComponent$initMarkedTipsView$1(Continuation<? super ResultMarkedTipsComponent$initMarkedTipsView$1> r100) {
        super(3, r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Boolean r101, Continuation<? super Pair<? extends Boolean, ? extends Boolean>> r102) {
        return invoke(r100.booleanValue(), r101.booleanValue(), r102);
    }

    public final Object invoke(boolean r100, boolean r101, Continuation<? super Pair<Boolean, Boolean>> r102) {
        ResultMarkedTipsComponent$initMarkedTipsView$1 r103 = new ResultMarkedTipsComponent$initMarkedTipsView$1(r102);
        r103.Z$0 = r100;
        r103.Z$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        boolean r102 = this.Z$1;
        return TuplesKt.to(Boxing.boxBoolean(r101), Boxing.boxBoolean(r102));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
