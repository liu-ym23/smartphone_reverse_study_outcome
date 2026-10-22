package com.larus.im.internal.core.conversation.bot;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.BatchGetBotByConversationId$retrieveBotIdList$2", f = "BatchGetBotByConversationId.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA}, m = "invokeSuspend", n = {}, s = {})
public final class BatchGetBotByConversationId$retrieveBotIdList$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public BatchGetBotByConversationId$retrieveBotIdList$2(Function1<? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super BatchGetBotByConversationId$retrieveBotIdList$2> r101) {
        this.$block = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new BatchGetBotByConversationId$retrieveBotIdList$2(this.$block, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((BatchGetBotByConversationId$retrieveBotIdList$2) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        Function1<Continuation<? super Unit>, Object> r103 = this.$block;
        this.label = 1;
        if (r103.invoke(this) != r101) goto L12;
        return r101;
    }
}
