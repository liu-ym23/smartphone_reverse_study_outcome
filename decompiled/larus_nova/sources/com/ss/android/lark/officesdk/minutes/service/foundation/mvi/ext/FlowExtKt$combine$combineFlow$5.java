package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function7;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0010\u0000\u001a&\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004\"\u0004\b\u0003\u0010\u0005\"\u0004\b\u0004\u0010\u0006\"\u0004\b\u0005\u0010\u00072\u0006\u0010\b\u001a\u0002H\u00022\u0006\u0010\t\u001a\u0002H\u00032\u0006\u0010\n\u001a\u0002H\u00042\u0006\u0010\u000b\u001a\u0002H\u00052\u0006\u0010\f\u001a\u0002H\u00062\u0006\u0010\r\u001a\u0002H\u0007H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/Tuple6;", "T5", "T6", "T7", "T8", "T9", "T10", "t5", "t6", "t7", "t8", "t9", "t10"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.FlowExtKt$combine$combineFlow$5", f = "FlowExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$combine$combineFlow$5 extends SuspendLambda implements Function7<Object, Object, Object, Object, Object, Object, Continuation<? super i<Object, Object, Object, Object, Object, Object>>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    /* synthetic */ Object L$4;
    /* synthetic */ Object L$5;
    int label;

    public FlowExtKt$combine$combineFlow$5(Continuation<? super FlowExtKt$combine$combineFlow$5> r100) {
        super(7, r100);
    }

    @Override // kotlin.jvm.functions.Function7
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Continuation<? super i<Object, Object, Object, Object, Object, Object>> r106) {
        return invoke2(r100, r101, r102, r103, r104, r105, r106);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Object r101, Object r102, Object r103, Object r104, Object r105, Continuation<? super i<Object, Object, Object, Object, Object, Object>> r106) {
        FlowExtKt$combine$combineFlow$5 r107 = new FlowExtKt$combine$combineFlow$5(r106);
        r107.L$0 = r100;
        r107.L$1 = r101;
        r107.L$2 = r102;
        r107.L$3 = r103;
        r107.L$4 = r104;
        r107.L$5 = r105;
        return r107.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return new i(this.L$0, this.L$1, this.L$2, this.L$3, this.L$4, this.L$5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
