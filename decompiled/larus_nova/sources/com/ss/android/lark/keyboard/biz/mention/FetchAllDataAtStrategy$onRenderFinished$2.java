package com.ss.android.lark.keyboard.biz.mention;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", "", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.FetchAllDataAtStrategy$onRenderFinished$2", f = "FetchAllDataAtStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FetchAllDataAtStrategy$onRenderFinished$2 extends SuspendLambda implements Function2<Map<String, ? extends ChatChatter>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curChatId;
    final /* synthetic */ AtomicInteger $taskLock;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FetchAllDataAtStrategy this$0;

    public FetchAllDataAtStrategy$onRenderFinished$2(FetchAllDataAtStrategy r100, String r101, AtomicInteger r102, Continuation<? super FetchAllDataAtStrategy$onRenderFinished$2> r103) {
        this.this$0 = r100;
        this.$curChatId = r101;
        this.$taskLock = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        FetchAllDataAtStrategy$onRenderFinished$2 r102 = new FetchAllDataAtStrategy$onRenderFinished$2(this.this$0, this.$curChatId, this.$taskLock, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Map<String, ? extends ChatChatter> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Map<String, ? extends ChatChatter> r100, Continuation<? super Unit> r101) {
        return ((FetchAllDataAtStrategy$onRenderFinished$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Map<String, ? extends ChatChatter> r101 = (Map) this.L$0;
        FetchAllDataAtStrategy r102 = this.this$0;
        r102.f428392g = r101;
        FetchAllDataAtStrategy.e(r102, this.$curChatId, this.$taskLock);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
