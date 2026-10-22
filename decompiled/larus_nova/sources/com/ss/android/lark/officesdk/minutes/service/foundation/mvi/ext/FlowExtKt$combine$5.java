package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.i;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0011\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0004\b\u0003\u0010\u0004\"\u0004\b\u0004\u0010\u0005\"\u0004\b\u0005\u0010\u0006\"\u0004\b\u0006\u0010\u0007\"\u0004\b\u0007\u0010\b\"\u0004\b\b\u0010\t\"\u0004\b\t\u0010\n\"\u0004\b\n\u0010\u000b2\u0006\u0010\f\u001a\u0002H\u00022\u0006\u0010\r\u001a\u0002H\u00032\u0006\u0010\u000e\u001a\u0002H\u00042\u0006\u0010\u000f\u001a\u0002H\u00052*\u0010\u0010\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\u0011H\n"}, d2 = {"<anonymous>", "R", "T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "t1", "t2", "t3", "t4", "combine", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/Tuple6;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.ext.FlowExtKt$combine$5", f = "FlowExt.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
final class FlowExtKt$combine$5 extends SuspendLambda implements Function6<Object, Object, Object, Object, i<Object, Object, Object, Object, Object, Object>, Continuation<Object>, Object> {
    final /* synthetic */ Function11<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Continuation<Object>, Object> $transform;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    /* synthetic */ Object L$4;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FlowExtKt$combine$5(Function11<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, ? super Continuation<Object>, ? extends Object> r100, Continuation<? super FlowExtKt$combine$5> r101) {
        this.$transform = r100;
        super(6, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Object r101, Object r102, Object r103, i<Object, Object, Object, Object, Object, Object> r104, Continuation<Object> r105) {
        FlowExtKt$combine$5 r106 = new FlowExtKt$combine$5(this.$transform, r105);
        r106.L$0 = r100;
        r106.L$1 = r101;
        r106.L$2 = r102;
        r106.L$3 = r103;
        r106.L$4 = r104;
        return r106.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Object r101, Object r102, Object r103, i<Object, Object, Object, Object, Object, Object> r104, Continuation<Object> r105) {
        return invoke2(r100, r101, r102, r103, r104, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L11:
        return r110;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        Object r111 = this.L$0;
        Object r102 = this.L$1;
        Object r103 = this.L$2;
        Object r104 = this.L$3;
        i r105 = (i) this.L$4;
        Function11<Object, Object, Object, Object, Object, Object, Object, Object, Object, Object, Continuation<Object>, Object> r106 = this.$transform;
        Object r107 = r105.f433884a;
        Object r108 = r105.f433885b;
        Object r109 = r105.f433886c;
        Object r112 = r105.f433887d;
        Object r113 = r105.f433888e;
        Object r114 = r105.f433889f;
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 1;
        r110 = r106.invoke(r111, r102, r103, r104, r107, r108, r109, r112, r113, r114, this);
        if (r110 != r100) goto L11;
        return r100;
    }
}
