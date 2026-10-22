package com.bytedance.kmp.ec.yata.common.platform;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 0})
@DebugMetadata(c = "com.bytedance.kmp.ec.yata.common.platform.YataPlatformExpectSubUtils$mainHandlerCreator$1$1$postDelayed$1", f = "YataPlatformExpectUtils.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
final class YataPlatformExpectSubUtils$mainHandlerCreator$1$1$postDelayed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ Function0<Unit> $runnable;
    int label;

    public YataPlatformExpectSubUtils$mainHandlerCreator$1$1$postDelayed$1(long r100, Function0<Unit> r101, Continuation<? super YataPlatformExpectSubUtils$mainHandlerCreator$1$1$postDelayed$1> r102) {
        this.$delayMillis = r100;
        this.$runnable = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new YataPlatformExpectSubUtils$mainHandlerCreator$1$1$postDelayed$1(this.$delayMillis, this.$runnable, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((YataPlatformExpectSubUtils$mainHandlerCreator$1$1$postDelayed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        this.$runnable.invoke();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        long r103 = this.$delayMillis;
        this.label = 1;
        if (DelayKt.delay(r103, this) != r101) goto L11;
        return r101;
    }
}
