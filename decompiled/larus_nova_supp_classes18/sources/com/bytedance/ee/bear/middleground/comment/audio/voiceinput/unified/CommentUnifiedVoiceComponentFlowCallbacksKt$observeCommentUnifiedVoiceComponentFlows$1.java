package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified;

import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.audio.voiceinput.unified.CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$1", f = "CommentUnifiedVoiceComponentFlowCallbacks.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
final class CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $callbacks;
    final /* synthetic */ Function1<Map<String, Integer>, Map<String, Boolean>> $consumerResult;
    final /* synthetic */ i1<Map<String, zac.a>> $results;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function1<Map<String, Integer>, Map<String, Boolean>> a;
        public final /* synthetic */ h b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super Map<String, Integer>, ? extends Map<String, Boolean>> r1, h r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object emit(Object r9, Continuation r10) {
            Map r11 = (Map) r9;
            Function1<Map<String, Integer>, Map<String, Boolean>> r12 = this.a;
            LinkedHashMap r0 = new LinkedHashMap(MapsKt.mapCapacity(r11.size()));
            Iterator<T> r1 = r11.entrySet().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            Map.Entry r2 = (Map.Entry) r1.next();
            r0.put(r2.getKey(), Boxing.boxInt(((zac.a) r2.getValue()).c));
            goto L4
        L6:
            Map r13 = (Map) r12.invoke(r0);
            Collection r14 = r11.values();
            h r3 = this.b;
            Iterator<T> r15 = r14.iterator();
        L8:
            if (r15.hasNext() == false) goto L17;
            zac.a r4 = (zac.a) r15.next();
            boolean r5 = true;
            boolean r6 = Intrinsics.areEqual(r13.get(r4.a), Boxing.boxBoolean(true));
            StringBuilder r7 = new StringBuilder("[flowObserver] result consumed=");
            r7.append(r6);
            r7.append(", ");
            CommentVoiceLog r8 = CommentVoiceLog.a;
            String r16 = r4.a;
            r8.getClass();
            r7.append(CommentVoiceLog.d("taskId", r16));
            r7.append(", sequenceId=");
            r7.append(r4.c);
            r7.append(", isFinish=");
            r7.append(r4.d);
            r7.append(", hasRichText=");
            if (r4.b.b != null) goto L13;
            r5 = false;
        L13:
            r7.append(r5);
            r7.append(", ");
            r7.append(CommentVoiceLog.i("content", r4.b.a));
            tt5.a.h("CommentVoice", r7.toString());
            if (r6 == false) goto L8;
            r3.a.invoke(r4);
            goto L8
        L17:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$1(i1<? extends Map<String, zac.a>> r1, Function1<? super Map<String, Integer>, ? extends Map<String, Boolean>> r2, h r3, Continuation<? super CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$1> r4) {
        this.$results = r1;
        this.$consumerResult = r2;
        this.$callbacks = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CommentUnifiedVoiceComponentFlowCallbacksKt$observeCommentUnifiedVoiceComponentFlows$1(this.$results, this.$consumerResult, this.$callbacks, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        i1<Map<String, zac.a>> r7 = this.$results;
        a r2 = new a(this.$consumerResult, this.$callbacks);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
