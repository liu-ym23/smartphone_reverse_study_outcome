package com.ss.android.lark.chat.chatwindow.biz.plugin.tools;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.biz.plugin.tools.ChatMemoryLeakDetectPlugin$onCreate$1", f = "ChatMemoryLeakDetectPlugin.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMemoryLeakDetectPlugin$onCreate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatMemoryLeakDetectPlugin.DetectViewModel $viewModel;
    int label;
    final /* synthetic */ ChatMemoryLeakDetectPlugin this$0;

    public static final class a<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ChatMemoryLeakDetectPlugin f412335a;

        public a(ChatMemoryLeakDetectPlugin r100) {
            this.f412335a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            ((Number) r100).intValue();
            ChatMemoryLeakDetectPlugin r102 = this.f412335a;
            int r103 = ChatMemoryLeakDetectPlugin.f412330h;
            r102.getClass();
            throw null;
        }
    }

    public ChatMemoryLeakDetectPlugin$onCreate$1(ChatMemoryLeakDetectPlugin.DetectViewModel r100, ChatMemoryLeakDetectPlugin r101, Continuation<? super ChatMemoryLeakDetectPlugin$onCreate$1> r102) {
        this.$viewModel = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatMemoryLeakDetectPlugin$onCreate$1(this.$viewModel, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatMemoryLeakDetectPlugin$onCreate$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Flow<Integer> r103 = this.$viewModel.getObserverCountFlow();
        a r104 = new a(this.this$0);
        this.label = 1;
        if (r103.collect(r104, this) != r101) goto L12;
        return r101;
    }
}
