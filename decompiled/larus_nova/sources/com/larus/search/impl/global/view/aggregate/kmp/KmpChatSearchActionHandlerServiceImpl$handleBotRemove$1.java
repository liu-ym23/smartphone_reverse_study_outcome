package com.larus.search.impl.global.view.aggregate.kmp;

import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.search.impl.common.ConversationRepoManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.search.impl.global.view.aggregate.kmp.KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1", f = "KmpChatSearchActionHandlerServiceImpl.kt", i = {0, 1}, l = {312, 314}, m = "invokeSuspend", n = {"botId", "botId"}, s = {"L$0", "L$0"})
final class KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $bot;
    Object L$0;
    int label;

    public KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1(RecommendBot r100, Continuation<? super KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1> r101) {
        this.$bot = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1(this.$bot, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((KmpChatSearchActionHandlerServiceImpl$handleBotRemove$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        String r103 = (String) this.L$0;
        ResultKt.throwOnFailure(r100);
    L32:
        BotStatusCacheDelegate.f296446b.a(r103, false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r104 = (String) this.L$0;
        ResultKt.throwOnFailure(r100);
    L27:
        String r105 = (String) r100;
    L28:
        ConversationRepoManager r106 = ConversationRepoManager.f367620a;
        this.L$0 = r104;
        this.label = 2;
        if (ConversationRepoManager.e(r105, r104, this) != r101) goto L31;
        return r101;
    L31:
        r103 = r104;
        goto L32
    L10:
        ResultKt.throwOnFailure(r100);
        r104 = this.$bot.o();
        if (r104 == null) goto L13;
        r105 = this.$bot.E();
        if (r105 != null) goto L17;
    L20:
        boolean r107 = true;
    L21:
        if (r107 == false) goto L23;
    L24:
        ConversationRepoManager r108 = ConversationRepoManager.f367620a;
        this.L$0 = r104;
        this.label = 1;
        r100 = ConversationRepoManager.d(r104, this);
        if (r100 != r101) goto L27;
        return r101;
    L23:
        if (wf9.a.a(r105) == false) goto L28;
    L17:
        if (r105.length() == 0) goto L20;
        r107 = false;
        goto L21
    L13:
        return Unit.INSTANCE;
    }
}
