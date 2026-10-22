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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2", f = "CommentUnifiedVoiceComponentFlowCallbacks.kt", i = {}, l = {57}, m = "invokeSuspend", n = {}, s = {})
final class CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $callbacks;
    final /* synthetic */ d1<yac.a> $events;
    int label;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f230587a;

        public a(h r100) {
            this.f230587a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            yac.a r102 = (yac.a) r100;
            tt5.a.h("CommentVoice", "[flowObserver] event=" + r102);
            this.f230587a.f230648b.invoke(r102);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2(d1<? extends yac.a> r100, h r101, Continuation<? super CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2> r102) {
        this.$events = r100;
        this.$callbacks = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2(this.$events, this.$callbacks, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        d1<yac.a> r103 = this.$events;
        a r104 = new a(this.$callbacks);
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
