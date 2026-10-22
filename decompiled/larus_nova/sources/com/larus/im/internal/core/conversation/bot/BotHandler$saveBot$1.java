package com.larus.im.internal.core.conversation.bot;

import com.larus.im.internal.database.entity.BotEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.core.conversation.bot.BotHandler$saveBot$1", f = "BotHandler.kt", i = {}, l = {29, 31, 33}, m = "invokeSuspend", n = {}, s = {})
public final class BotHandler$saveBot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotEntity $botEntity;
    final /* synthetic */ boolean $forceNew;
    int label;

    public BotHandler$saveBot$1(boolean r100, BotEntity r101, Continuation<? super BotHandler$saveBot$1> r102) {
        this.$forceNew = r100;
        this.$botEntity = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new BotHandler$saveBot$1(this.$forceNew, this.$botEntity, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((BotHandler$saveBot$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L12;
        if (r102 == 1) goto L11;
        if (r102 == 2) goto L10;
        if (r102 == 3) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r100);
    L21:
        if (((BotEntity) r100) != null) goto L26;
        be9.a r103 = ae9.a.a();
        BotEntity r104 = this.$botEntity;
        this.label = 3;
        if (r103.d(r104, this) != r101) goto L26;
        return r101;
    L26:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r100);
        goto L26
    L12:
        ResultKt.throwOnFailure(r100);
        if (this.$forceNew == false) goto L17;
        be9.a r105 = ae9.a.a();
        BotEntity r106 = this.$botEntity;
        this.label = 1;
        if (r105.d(r106, this) != r101) goto L26;
        return r101;
    L17:
        be9.a r107 = ae9.a.a();
        String r108 = this.$botEntity.getBotId();
        this.label = 2;
        r100 = r107.j(r108, this);
        if (r100 != r101) goto L21;
        return r101;
    }
}
