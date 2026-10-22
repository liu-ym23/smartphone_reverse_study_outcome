package com.bytedance.kmp.klay.event;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/bytedance/kmp/klay/event/c;", ExifInterface.GPS_DIRECTION_TRUE, "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 0})
@DebugMetadata(c = "com.bytedance.kmp.klay.event.EventDispatcher$subscribeStickyEvent$1", f = "EventDispatcher.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
final class EventDispatcher$subscribeStickyEvent$1 extends SuspendLambda implements Function2<c, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<c, Continuation<? super Unit>, Object> $onEvent;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public EventDispatcher$subscribeStickyEvent$1(Function2<c, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super EventDispatcher$subscribeStickyEvent$1> r101) {
        this.$onEvent = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        EventDispatcher$subscribeStickyEvent$1 r102 = new EventDispatcher$subscribeStickyEvent$1(this.$onEvent, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(c r100, Continuation<? super Unit> r101) {
        return ((EventDispatcher$subscribeStickyEvent$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(c r100, Continuation<? super Unit> r101) {
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
        c r103 = (c) this.L$0;
        Function2<c, Continuation<? super Unit>, Object> r104 = this.$onEvent;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type T of com.bytedance.kmp.klay.event.EventDispatcher.subscribeStickyEvent");
        this.label = 1;
        if (r104.invoke(r103, this) != r101) goto L12;
        return r101;
    }
}
