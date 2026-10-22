package com.larus.paging;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lcom/larus/paging/b1;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.paging.CancelableChannelFlowKt$cancelableChannelFlow$1", f = "CancelableChannelFlow.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
final class CancelableChannelFlowKt$cancelableChannelFlow$1 extends SuspendLambda implements Function2<b1<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<b1<Object>, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Job $controller;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public CancelableChannelFlowKt$cancelableChannelFlow$1(Job r100, Function2<? super b1<Object>, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super CancelableChannelFlowKt$cancelableChannelFlow$1> r102) {
        this.$controller = r100;
        this.$block = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CancelableChannelFlowKt$cancelableChannelFlow$1 r102 = new CancelableChannelFlowKt$cancelableChannelFlow$1(this.$controller, this.$block, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(b1<Object> r100, Continuation<? super Unit> r101) {
        return ((CancelableChannelFlowKt$cancelableChannelFlow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(b1<Object> r100, Continuation<? super Unit> r101) {
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
        final b1<Object> r103 = (b1) this.L$0;
        this.$controller.invokeOnCompletion(new AnonymousClass1(r103));
        Function2<b1<Object>, Continuation<? super Unit>, Object> r104 = this.$block;
        this.label = 1;
        if (r104.invoke(r103, this) != r101) goto L12;
        return r101;
    }
}
