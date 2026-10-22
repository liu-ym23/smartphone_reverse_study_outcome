package com.larus.init.task;

import com.larus.abtest.api.IGlobalExposureStarter;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.Set;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.init.task.InitAbTestExposureTask$triggerGlobalExposure$1", f = "InitAbTestExposureTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class InitAbTestExposureTask$triggerGlobalExposure$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InitAbTestExposureTask this$0;

    public InitAbTestExposureTask$triggerGlobalExposure$1(InitAbTestExposureTask r100, Continuation<? super InitAbTestExposureTask$triggerGlobalExposure$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new InitAbTestExposureTask$triggerGlobalExposure$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((InitAbTestExposureTask$triggerGlobalExposure$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.i(this.this$0.f351004a, "trigger all global experiment exposure");
        Iterator r101 = ((Set) LazyKt.lazy(new p()).getValue()).iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        ((IGlobalExposureStarter) r101.next()).a();
        goto L6
    L9:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
