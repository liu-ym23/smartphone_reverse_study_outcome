package com.larus.ui.arch.vm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.ui.arch.vm.internal.ComponentStateOperator$collectLatest$flow$1", f = "ComponentStateOperator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ComponentStateOperator$collectLatest$flow$1 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    final /* synthetic */ w1a.d $deliveryMode;
    final /* synthetic */ ConcurrentHashMap<String, Object> $lastDeliveredStates;
    /* synthetic */ Object L$0;
    int label;

    public ComponentStateOperator$collectLatest$flow$1(ConcurrentHashMap<String, Object> r100, w1a.d r101, Continuation<? super ComponentStateOperator$collectLatest$flow$1> r102) {
        this.$lastDeliveredStates = r100;
        this.$deliveryMode = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ComponentStateOperator$collectLatest$flow$1 r102 = new ComponentStateOperator$collectLatest$flow$1(this.$lastDeliveredStates, this.$deliveryMode, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Object r100, Continuation<? super Boolean> r101) {
        return ((ComponentStateOperator$collectLatest$flow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        Object r101 = this.L$0;
        if (this.$lastDeliveredStates.containsKey(((w1a.h) this.$deliveryMode).f557950a) == true) goto L7;
    L9:
        boolean r102 = false;
    L11:
        return Boxing.boxBoolean(r102);
    L7:
        if (Intrinsics.areEqual(r101, this.$lastDeliveredStates.get(((w1a.h) this.$deliveryMode).f557950a)) == false) goto L9;
        r102 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
