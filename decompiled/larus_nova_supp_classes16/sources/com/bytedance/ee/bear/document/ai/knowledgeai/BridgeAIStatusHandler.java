package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.google.gson.Gson;
import com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIStatusBean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
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
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BridgeAIStatusHandler implements tb5.i<Object> {
    public final com.ss.android.lark.inline.ai.api.knowledgeai.d a;
    public final i1<Boolean> b;
    public Job c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1", f = "JSBHandlers.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ tb5.m $callback;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BridgeAIStatusHandler this$0;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1$1", f = "JSBHandlers.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ tb5.m $callback;
            int label;
            final /* synthetic */ BridgeAIStatusHandler this$0;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1$1$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ BridgeAIStatusHandler a;
                public final /* synthetic */ tb5.m b;

                public a(BridgeAIStatusHandler r1, tb5.m r2) {
                    this.a = r1;
                    this.b = r2;
                }

                public final Object emit(Object r3, Continuation r4) {
                    KnowledgeAIStatusBean r5 = (KnowledgeAIStatusBean) r3;
                    if (r5 == null) goto L22;
                    BridgeAIStatusHandler r6 = this.a;
                    tb5.m r0 = this.b;
                    if (r5.isWriting() == true) goto L7;
                L9:
                    if (r0 == null) goto L22;
                    Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L12
                    Object r8 = Result.constructor-impl(new Gson().toJson(r5));     // Catch: Throwable -> L12
                L15:
                    if (Result.isFailure-impl(r8) == false) goto L17;
                    r8 = null;
                L17:
                    String r9 = (String) r8;
                    if (r9 != null) goto L20;
                    r9 = "";
                L20:
                    r0.onCallBack(r9);
                L12:
                    th = move-exception;
                    Result.Companion r10 = Result.Companion;
                    r8 = Result.constructor-impl(ResultKt.createFailure(th));
                    goto L15
                L7:
                    if (((Boolean) r6.b.getValue()).booleanValue() == false) goto L9;
                    tt5.a.h("BridgeAIStatusHandler", "isWriting is true, skip");
                    return Unit.INSTANCE;
                L22:
                    return Unit.INSTANCE;
                }
            }

            public C00511(BridgeAIStatusHandler r1, tb5.m r2, Continuation<? super C00511> r3) {
                this.this$0 = r1;
                this.$callback = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00511(this.this$0, this.$callback, r4);
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
                StateFlowImpl r7 = this.this$0.a.f();
                a r2 = new a(this.this$0, this.$callback);
                this.label = 1;
                if (r7.collect(r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1$2, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1$2", f = "JSBHandlers.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ tb5.m $callback;
            int label;
            final /* synthetic */ BridgeAIStatusHandler this$0;

            /* JADX INFO: renamed from: com.bytedance.ee.bear.document.ai.knowledgeai.BridgeAIStatusHandler$handle$1$2$a */
            public static final class a<T> implements FlowCollector {
                public final /* synthetic */ BridgeAIStatusHandler a;
                public final /* synthetic */ tb5.m b;

                public a(BridgeAIStatusHandler r1, tb5.m r2) {
                    this.a = r1;
                    this.b = r2;
                }

                public final Object emit(Object r8, Continuation r9) {
                    boolean r10 = ((Boolean) r8).booleanValue();
                    KnowledgeAIStatusBean r0 = (KnowledgeAIStatusBean) this.a.a.f().getValue();
                    if (r0 == null) goto L45;
                    String r11 = "";
                    Object r6 = null;
                    if (r10 == false) goto L23;
                    KnowledgeAIStatusBean r12 = KnowledgeAIStatusBean.copy$default(r0, 0, false, false, 3, null);
                    tb5.m r1 = this.b;
                    if (r1 == null) goto L40;
                    Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
                    Object r13 = Result.constructor-impl(new Gson().toJson(r12));     // Catch: Throwable -> L11
                L14:
                    if (Result.isFailure-impl(r13) == true) goto L17;
                    r6 = r13;
                L17:
                    String r7 = (String) r6;
                    if (r7 == null) goto L21;
                    r11 = r7;
                L21:
                    r1.onCallBack(r11);
                L11:
                    th = move-exception;
                    Result.Companion r3 = Result.Companion;
                    r13 = Result.constructor-impl(ResultKt.createFailure(th));
                L40:
                    return Unit.INSTANCE;
                L23:
                    if (r0.isWriting() == false) goto L40;
                    tt5.a.h("BridgeAIStatusHandler", "send writing while close panel");
                    tb5.m r14 = this.b;
                    if (r14 == null) goto L40;
                    Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L28
                    Object r5 = Result.constructor-impl(new Gson().toJson(r0));     // Catch: Throwable -> L28
                L31:
                    if (Result.isFailure-impl(r5) == true) goto L34;
                    r6 = r5;
                L34:
                    String r16 = (String) r6;
                    if (r16 == null) goto L38;
                    r11 = r16;
                L38:
                    r14.onCallBack(r11);
                L28:
                    th = move-exception;
                    Result.Companion r17 = Result.Companion;
                    r5 = Result.constructor-impl(ResultKt.createFailure(th));
                    goto L31
                L45:
                    return Unit.INSTANCE;
                }
            }

            public AnonymousClass2(BridgeAIStatusHandler r1, tb5.m r2, Continuation<? super AnonymousClass2> r3) {
                this.this$0 = r1;
                this.$callback = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new AnonymousClass2(this.this$0, this.$callback, r4);
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
                BridgeAIStatusHandler r7 = this.this$0;
                i1<Boolean> r2 = r7.b;
                a r3 = new a(r7, this.$callback);
                this.label = 1;
                if (r2.collect(r3, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(BridgeAIStatusHandler r1, tb5.m r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$callback = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$callback, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r8);
            CoroutineScope r9 = (CoroutineScope) this.L$0;
            BuildersKt.launch$default(r9, null, null, new C00511(this.this$0, this.$callback, null), 3, null);
            BuildersKt.launch$default(r9, null, null, new AnonymousClass2(this.this$0, this.$callback, null), 3, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public BridgeAIStatusHandler(com.ss.android.lark.inline.ai.api.knowledgeai.d r2, z0 r3) {
        Intrinsics.checkNotNullParameter(r2, "knowledgeAIViewModel");
        Intrinsics.checkNotNullParameter(r3, "isVisibleFlow");
        this.a = r2;
        this.b = r3;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r8, tb5.m r9) {
        Job r10 = this.c;
        if (r10 == null) goto L5;
        Job.DefaultImpls.cancel$default(r10, null, 1, null);
    L5:
        this.c = BuildersKt.launch$default(this.a.c(), null, null, new AnonymousClass1(this, r9, null), 3, null);
    }
}
