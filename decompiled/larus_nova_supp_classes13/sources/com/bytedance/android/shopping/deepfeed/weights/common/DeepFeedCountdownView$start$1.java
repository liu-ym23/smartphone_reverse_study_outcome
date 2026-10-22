package com.bytedance.android.shopping.deepfeed.weights.common;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedCountdownView$start$1", f = "DeepFeedCountdownView.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class DeepFeedCountdownView$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeepFeedCountdownView this$0;

    public DeepFeedCountdownView$start$1(DeepFeedCountdownView r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        DeepFeedCountdownView$start$1 r0 = new DeepFeedCountdownView$start$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.widget.TextView, com.bytedance.android.shopping.deepfeed.weights.common.DeepFeedCountdownView, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003b -> B:16:0x003e). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
        DeepFeedCountdownView$start$1 r13 = this;
    L16:
        DeepFeedCountdownView r3 = r13.this$0;
        int r4 = DeepFeedCountdownView.h;
        r3.getClass();
        long r5 = System.currentTimeMillis();
        long r6 = r3.a;
        if (r6 <= r5) goto L19;
        long r7 = r6 - r5;
    L20:
        r3.y(r7);
        if (r7 > 0) goto L10;
        DeepFeedCountdownView r8 = r13.this$0;
        r8.b = false;
        Job r9 = r8.d;
        if (r9 == null) goto L25;
        Job.DefaultImpls.cancel$default(r9, null, 1, null);
    L25:
        r8.d = null;
        ?? r10 = r13.this$0;
        r10.getClass();
        r10.setText(r10.e + r10.g);
        Function0<Unit> r14 = r13.this$0.c;
        if (r14 == null) goto L29;
        Unit r15 = (Unit) r14.invoke();
    L29:
        return Unit.INSTANCE;
    L10:
        if (r13.this$0.b == false) goto L29;
        if (CoroutineScopeKt.isActive(r2) == false) goto L29;
        r13.L$0 = r2;
        r13.label = 1;
        if (DelayKt.delay(1000, r13) != r0) goto L16;
        return r0;
    L19:
        r7 = 0;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        r2 = (CoroutineScope) this.L$0;
        r13 = this;
        goto L10
    }
}
