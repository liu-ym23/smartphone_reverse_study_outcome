package com.bytedance.android.shopping.deepfeed.slice.action;

import java.util.List;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.deepfeed.slice.action.DeepFeedSlcIntervalUpdateAction$onHandleAction$job$1", f = "DeepFeedSlcIntervalUpdateAction.kt", i = {0, 0}, l = {108}, m = "invokeSuspend", n = {"$this$launch", "counter"}, s = {"L$0", "I$0"})
public final class DeepFeedSlcIntervalUpdateAction$onHandleAction$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ w $container;
    final /* synthetic */ int $from;
    final /* synthetic */ long $interval;
    final /* synthetic */ List $specs;
    final /* synthetic */ int $step;
    final /* synthetic */ int $to;
    int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DeepFeedSlcIntervalUpdateAction this$0;

    public DeepFeedSlcIntervalUpdateAction$onHandleAction$job$1(DeepFeedSlcIntervalUpdateAction r1, int r2, w r3, List r4, int r5, int r6, long r7, Continuation r9) {
        this.this$0 = r1;
        this.$from = r2;
        this.$container = r3;
        this.$specs = r4;
        this.$to = r5;
        this.$step = r6;
        this.$interval = r7;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Intrinsics.checkNotNullParameter(r13, "completion");
        DeepFeedSlcIntervalUpdateAction$onHandleAction$job$1 r0 = new DeepFeedSlcIntervalUpdateAction$onHandleAction$job$1(this.this$0, this.$from, this.$container, this.$specs, this.$to, this.$step, this.$interval, r13);
        r0.L$0 = r12;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        int r2 = this.I$0;
        CoroutineScope r4 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L23
    L12:
        if (CoroutineScopeKt.isActive(r4) == false) goto L25;
        w r11 = this.$container;     // Catch: Throwable -> L23
        DeepFeedSlcIntervalUpdateAction r6 = this.this$0;     // Catch: Throwable -> L23
        List r7 = this.$specs;     // Catch: Throwable -> L23
        WeakHashMap<w, Job> r8 = DeepFeedSlcIntervalUpdateAction.g;     // Catch: Throwable -> L23
        r6.getClass();     // Catch: Throwable -> L23
        r11.C(MapsKt.mapOf(TuplesKt.to("state", DeepFeedSlcIntervalUpdateAction.e(r7, r2))));     // Catch: Throwable -> L23
        int r12 = this.$to;     // Catch: Throwable -> L23
        if (r2 >= r12) goto L25;
        r2 = r2 + this.$step;     // Catch: Throwable -> L23
        if (r2 <= r12) goto L20;
        r2 = r12;
    L20:
        long r5 = this.$interval;     // Catch: Throwable -> L23
        this.L$0 = r4;     // Catch: Throwable -> L23
        this.I$0 = r2;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        if (DelayKt.delay(r5, this) != r0) goto L12;
        return r0;
    L25:
        DeepFeedSlcIntervalUpdateAction r13 = this.this$0;
        w r3 = this.$container;
        Job r9 = r4.getCoroutineContext().get(Job.Key);
        WeakHashMap<w, Job> r14 = DeepFeedSlcIntervalUpdateAction.g;
        r13.getClass();
        WeakHashMap<w, Job> r15 = DeepFeedSlcIntervalUpdateAction.g;
        if (r15.get(r3) != r9) goto L29;
        r15.remove(r3);
    L29:
        if (r13.e != r9) goto L32;
        r13.e = null;
        r13.f = null;
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        r4 = (CoroutineScope) this.L$0;
        r2 = this.$from;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DeepFeedSlcIntervalUpdateAction r16 = this.this$0;
        w r17 = this.$container;
        Job r18 = r4.getCoroutineContext().get(Job.Key);
        WeakHashMap<w, Job> r19 = DeepFeedSlcIntervalUpdateAction.g;
        r16.getClass();
        WeakHashMap<w, Job> r20 = DeepFeedSlcIntervalUpdateAction.g;
        if (r20.get(r17) != r18) goto L37;
        r20.remove(r17);
    L37:
        if (r16.e != r18) goto L39;
        r16.e = null;
        r16.f = null;
    L39:
        throw th;
    }
}
