package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/internal/database/entity/MessageEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.MessageDaoSource$getLatestVisibleMessageList$2", f = "MessageDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageDaoSource$getLatestVisibleMessageList$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends MessageEntity>>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ int $limit;
    int label;

    public MessageDaoSource$getLatestVisibleMessageList$2(String r100, int r101, Continuation<? super MessageDaoSource$getLatestVisibleMessageList$2> r102) {
        this.$conversationId = r100;
        this.$limit = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageDaoSource$getLatestVisibleMessageList$2(this.$conversationId, this.$limit, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends MessageEntity>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<MessageEntity>> r100) {
        return ((MessageDaoSource$getLatestVisibleMessageList$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        List r101 = CollectionsKt.emptyList();
        final String r102 = this.$conversationId;
        final int r103 = this.$limit;
        return com.larus.im.internal.database.utils.n.a("MessageDaoSource", r101, new b1(r102, r103));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
