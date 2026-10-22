package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2", f = "CommentUnifiedVoiceComponentFlowCallbacks.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $callbacks;
    final /* synthetic */ d1<yac.a> $events;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            yac.a r4 = (yac.a) r2;
            tt5.a.h("CommentVoice", "[flowObserver] event=" + r4);
            this.a.b.invoke(r4);
            return Unit.INSTANCE;
        }
    }

    public CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2(d1<? extends yac.a> r1, h r2, Continuation<? super CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2> r3) {
        this.$events = r1;
        this.$callbacks = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2(this.$events, this.$callbacks, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1<yac.a> r6 = this.$events;
        a r2 = new a(this.$callbacks);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
