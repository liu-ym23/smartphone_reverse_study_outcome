package com.larus.bmhome.chat.model.strategy.block;

import com.larus.bmhome.actionbar.model.ReplyOption;
import com.larus.bmhome.chat.thinkmode.BehaviorSource;
import com.larus.bmhome.chat.thinkmode.ConversationSource;
import com.larus.bmhome.chat.thinkmode.IThinkModeMemoryReportService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.block.ChatBlockSendStrategy$reportThinkModeMemory$1", f = "ChatBlockSendStrategy.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
public final class ChatBlockSendStrategy$reportThinkModeMemory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $agentMode;
    final /* synthetic */ ConversationSource $conversationSource;
    final /* synthetic */ ReplyOption $replyOption;
    int label;

    public ChatBlockSendStrategy$reportThinkModeMemory$1(ReplyOption r100, ConversationSource r101, int r102, Continuation<? super ChatBlockSendStrategy$reportThinkModeMemory$1> r103) {
        this.$replyOption = r100;
        this.$conversationSource = r101;
        this.$agentMode = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatBlockSendStrategy$reportThinkModeMemory$1(this.$replyOption, this.$conversationSource, this.$agentMode, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatBlockSendStrategy$reportThinkModeMemory$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        IThinkModeMemoryReportService.Companion r103 = IThinkModeMemoryReportService.f309973a;
        ReplyOption r104 = this.$replyOption;
        BehaviorSource r105 = BehaviorSource.CHAT;
        ConversationSource r106 = this.$conversationSource;
        Integer r107 = Boxing.boxInt(this.$agentMode);
        this.label = 1;
        if (r103.a(r104, r105, r106, r107, this) != r101) goto L12;
        return r101;
    }
}
