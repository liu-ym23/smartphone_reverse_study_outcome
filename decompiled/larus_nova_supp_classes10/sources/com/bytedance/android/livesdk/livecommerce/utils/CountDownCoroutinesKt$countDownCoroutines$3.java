package com.bytedance.android.livesdk.livecommerce.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.CountDownCoroutinesKt$countDownCoroutines$3", f = "countDownCoroutines.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CountDownCoroutinesKt$countDownCoroutines$3 extends SuspendLambda implements Function3<FlowCollector<? super Integer>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $onFinish;
    int label;

    public CountDownCoroutinesKt$countDownCoroutines$3(Function0 r1, Continuation r2) {
        this.$onFinish = r1;
        super(3, r2);
    }

    public final Continuation<Unit> create(FlowCollector<? super Integer> r1, Throwable r2, Continuation<? super Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "$this$create");
        Intrinsics.checkNotNullParameter(r3, "continuation");
        return new CountDownCoroutinesKt$countDownCoroutines$3(this.$onFinish, r3);
    }

    public final Object invoke(Object r1, Object r2, Object r3) {
        return create((FlowCollector) r1, (Throwable) r2, (Continuation) r3).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        Function0 r3 = this.$onFinish;
        if (r3 == null) goto L8;
        Unit r4 = (Unit) r3.invoke();
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
