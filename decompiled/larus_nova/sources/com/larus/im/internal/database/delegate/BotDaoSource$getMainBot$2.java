package com.larus.im.internal.database.delegate;

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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/internal/database/entity/BotEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.BotDaoSource$getMainBot$2", f = "BotDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotDaoSource$getMainBot$2 extends SuspendLambda implements Function1<Continuation<? super BotEntity>, Object> {
    int label;

    public BotDaoSource$getMainBot$2(Continuation<? super BotDaoSource$getMainBot$2> r100) {
        super(1, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new BotDaoSource$getMainBot$2(r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super BotEntity> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super BotEntity> r100) {
        return ((BotDaoSource$getMainBot$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = BotDaoSource.f347922e;
        return BotDaoSource.a.a().getMainBot();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
