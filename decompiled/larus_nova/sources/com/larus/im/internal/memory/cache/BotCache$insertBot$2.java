package com.larus.im.internal.memory.cache;

import com.larus.im.internal.database.delegate.BotDaoSource;
import com.larus.im.internal.database.entity.BotEntity;
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
@DebugMetadata(c = "com.larus.im.internal.memory.cache.BotCache$insertBot$2", f = "BotCache.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
public final class BotCache$insertBot$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ BotEntity $botEntity;
    int label;
    final /* synthetic */ BotCache this$0;

    public BotCache$insertBot$2(BotCache r100, BotEntity r101, Continuation<? super BotCache$insertBot$2> r102) {
        this.this$0 = r100;
        this.$botEntity = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new BotCache$insertBot$2(this.this$0, this.$botEntity, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((BotCache$insertBot$2) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        BotDaoSource r103 = this.this$0.f348948j;
        BotEntity r104 = this.$botEntity;
        this.label = 1;
        if (r103.d(r104, this) != r101) goto L12;
        return r101;
    }
}
