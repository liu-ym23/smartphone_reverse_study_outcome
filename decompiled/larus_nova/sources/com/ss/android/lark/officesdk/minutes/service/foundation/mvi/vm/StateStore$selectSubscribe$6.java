package com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u00040\u0006H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "<destruct>", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/mvi/vm/Tuple3;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.StateStore$selectSubscribe$6", f = "StateStore.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
final class StateStore$selectSubscribe$6 extends SuspendLambda implements Function2<f<Object, Object, Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function4<Object, Object, Object, Continuation<? super Unit>, Object> $action;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public StateStore$selectSubscribe$6(Function4<Object, Object, Object, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super StateStore$selectSubscribe$6> r101) {
        this.$action = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        StateStore$selectSubscribe$6 r102 = new StateStore$selectSubscribe$6(this.$action, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(f<Object, Object, Object> r100, Continuation<? super Unit> r101) {
        return ((StateStore$selectSubscribe$6) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(f<Object, Object, Object> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        f r103 = (f) this.L$0;
        Object r104 = r103.f433872a;
        Object r105 = r103.f433873b;
        Object r106 = r103.f433874c;
        Function4<Object, Object, Object, Continuation<? super Unit>, Object> r107 = this.$action;
        this.label = 1;
        if (r107.invoke(r104, r105, r106, this) != r101) goto L12;
        return r101;
    }
}
