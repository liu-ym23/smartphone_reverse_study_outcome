package com.bytedance.android.livesdk.livecommerce.utils;

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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.CountDownCoroutinesKt$countDownCoroutines$1", f = "countDownCoroutines.kt", i = {0, 0, 1, 1}, l = {30, 31}, m = "invokeSuspend", n = {"$this$flow", "i", "$this$flow", "i"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class CountDownCoroutinesKt$countDownCoroutines$1 extends SuspendLambda implements Function2<FlowCollector<? super Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $delayTime;
    final /* synthetic */ long $timeMillis;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    public CountDownCoroutinesKt$countDownCoroutines$1(int r1, long r2, Continuation r4) {
        this.$delayTime = r1;
        this.$timeMillis = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Intrinsics.checkNotNullParameter(r6, "completion");
        CountDownCoroutinesKt$countDownCoroutines$1 r0 = new CountDownCoroutinesKt$countDownCoroutines$1(this.$delayTime, this.$timeMillis, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0063 -> B:19:0x0066). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$1;
        int r4 = this.I$0;
        FlowCollector r5 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r10);
        FlowCollector r11 = r5;
        CountDownCoroutinesKt$countDownCoroutines$1 r6 = this;
    L19:
        int r7 = r4 - 1;
        int r8 = r2;
        int r3 = r7;
    L11:
        if (r3 < r8) goto L21;
        Integer r9 = Boxing.boxInt(r3);
        r6.L$0 = r11;
        r6.I$0 = r3;
        r6.I$1 = r8;
        r6.label = 1;
        if (r11.emit(r9, r6) != r0) goto L15;
        return r0;
    L15:
        int r12 = r8;
        r4 = r3;
        r2 = r12;
    L16:
        long r13 = r6.$timeMillis;
        r6.L$0 = r11;
        r6.I$0 = r4;
        r6.I$1 = r2;
        r6.label = 2;
        if (DelayKt.delay(r13, r6) != r0) goto L19;
        return r0;
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = this.I$1;
        r4 = this.I$0;
        FlowCollector r14 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r10);
        r11 = r14;
        r6 = this;
        goto L16
    L10:
        ResultKt.throwOnFailure(r10);
        r11 = (FlowCollector) this.L$0;
        r3 = this.$delayTime;
        r8 = 0;
        r6 = this;
        goto L11
    }
}
