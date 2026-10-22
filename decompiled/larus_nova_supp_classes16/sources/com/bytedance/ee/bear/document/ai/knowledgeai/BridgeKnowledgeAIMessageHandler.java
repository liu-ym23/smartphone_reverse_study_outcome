package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BridgeKnowledgeAIMessageHandler implements tb5.i<Object> {
    public final com.ss.android.lark.inline.ai.api.knowledgeai.d a;
    public Job b;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.BridgeKnowledgeAIMessageHandler$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.BridgeKnowledgeAIMessageHandler$handle$1", f = "JSBHandlers.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ tb5.m $callback;
        int label;
        final /* synthetic */ BridgeKnowledgeAIMessageHandler this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.BridgeKnowledgeAIMessageHandler$handle$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ tb5.m a;

            public a(tb5.m r1) {
                this.a = r1;
            }

            public final Object emit(Object r1, Continuation r2) {
                KnowledgeAIMessage r3 = (KnowledgeAIMessage) r1;
                tb5.m r4 = this.a;
                if (r4 == null) goto L6;
                r4.onCallBack(JSON.toJSONString(r3));
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(BridgeKnowledgeAIMessageHandler r1, tb5.m r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.this$0, this.$callback, r4);
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
            MutableSharedFlow r6 = this.this$0.a.d();
            a r2 = new a(this.$callback);
            this.label = 1;
            if (r6.collect(r2, this) != r0) goto L12;
            return r0;
        }
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public BridgeKnowledgeAIMessageHandler(com.ss.android.lark.inline.ai.api.knowledgeai.d r2) {
        Intrinsics.checkNotNullParameter(r2, "knowledgeAIViewModel");
        this.a = r2;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r8, tb5.m r9) {
        Job r10 = this.b;
        if (r10 == null) goto L5;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L5:
        this.b = BuildersKt.launch$default(this.a.c(), null, null, new AnonymousClass1(this, r9, null), 3, null);
    }
}
