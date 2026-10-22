package com.larus.im;

import gd9.q;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.FlowRuntime$init$1$1", f = "FlowRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FlowRuntime$init$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public FlowRuntime$init$1$1(Continuation<? super FlowRuntime$init$1$1> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new FlowRuntime$init$1$1(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((FlowRuntime$init$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r100);
        q r101 = FlowRuntime.f346398a;
        if (r101 == null) goto L9;
        gd9.h r102 = r101.e();
        if (r102 == null) goto L9;
        q r103 = FlowRuntime.f346398a;
        r102.e("FlowRuntime", "init flow runtime , current pending action size = " + ((ArrayList) FlowRuntime.f346401d).size());
    L9:
        Iterator<T> r104 = FlowRuntime.f346401d.iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        ((Runnable) r104.next()).run();
        goto L11
    L13:
        ((ArrayList) FlowRuntime.f346401d).clear();
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
