package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.g;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0010\u0000\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u00052\u0006\u0010\u0006\u001a\u0002H\u00022\u0006\u0010\u0007\u001a\u0002H\u00032\u0006\u0010\b\u001a\u0002H\u00042\u0006\u0010\t\u001a\u0002H\u0005H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/Tuple4;", "T5", "T6", "T7", "T8", "t5", "t6", "t7", "t8"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.FlowExtKt$combine$combineFlow$3", f = "FlowExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$combine$combineFlow$3 extends SuspendLambda implements Function5<Object, Object, Object, Object, Continuation<? super g<Object, Object, Object, Object>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    int label;

    public FlowExtKt$combine$combineFlow$3(Continuation<? super FlowExtKt$combine$combineFlow$3> r100) {
        super(5, r100);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102, Object r103, Continuation<? super g<Object, Object, Object, Object>> r104) {
        return invoke2(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Object r101, Object r102, Object r103, Continuation<? super g<Object, Object, Object, Object>> r104) {
        FlowExtKt$combine$combineFlow$3 r105 = new FlowExtKt$combine$combineFlow$3(r104);
        r105.L$0 = r100;
        r105.L$1 = r101;
        r105.L$2 = r102;
        r105.L$3 = r103;
        return r105.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return new g(this.L$0, this.L$1, this.L$2, this.L$3);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
