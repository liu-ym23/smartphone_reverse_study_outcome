package com.larus.bmhome.chat.list.cell.prompt;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.prompt.PromptCell$findConversationByBot$2", f = "PromptCell.kt", i = {}, l = {1315}, m = "invokeSuspend", n = {}, s = {})
final class PromptCell$findConversationByBot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
    final /* synthetic */ String $botId;
    int label;

    public PromptCell$findConversationByBot$2(String r100, Continuation<? super PromptCell$findConversationByBot$2> r101) {
        this.$botId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new PromptCell$findConversationByBot$2(this.$botId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return ((PromptCell$findConversationByBot$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IChatRepoService r103 = zh8.a.f572196a;
        IConversationRepoService r104 = zh8.a.f572197b;
        String r105 = this.$botId;
        this.label = 1;
        r100 = r104.a(r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
