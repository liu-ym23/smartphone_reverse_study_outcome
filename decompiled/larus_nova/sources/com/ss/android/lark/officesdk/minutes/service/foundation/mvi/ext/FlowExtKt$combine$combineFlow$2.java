package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u0002H\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "T5", "T6", "T7", "t5", "t6", "t7"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.FlowExtKt$combine$combineFlow$2", f = "FlowExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$combine$combineFlow$2 extends SuspendLambda implements Function4<Object, Object, Object, Continuation<? super Triple<Object, Object, Object>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    public FlowExtKt$combine$combineFlow$2(Continuation<? super FlowExtKt$combine$combineFlow$2> r100) {
        super(4, r100);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102, Continuation<? super Triple<Object, Object, Object>> r103) {
        return invoke2(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Object r101, Object r102, Continuation<? super Triple<Object, Object, Object>> r103) {
        FlowExtKt$combine$combineFlow$2 r104 = new FlowExtKt$combine$combineFlow$2(r103);
        r104.L$0 = r100;
        r104.L$1 = r101;
        r104.L$2 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return new Triple(this.L$0, this.L$1, this.L$2);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
