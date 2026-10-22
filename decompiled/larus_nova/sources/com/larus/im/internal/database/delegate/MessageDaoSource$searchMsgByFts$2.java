package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/internal/database/entity/MessageEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.MessageDaoSource$searchMsgByFts$2", f = "MessageDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageDaoSource$searchMsgByFts$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends MessageEntity>>, Object> {
    final /* synthetic */ List<Integer> $availableContentType;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ List<String> $conversationIdList;
    final /* synthetic */ long $cursor;
    final /* synthetic */ int $limit;
    final /* synthetic */ String $query;
    final /* synthetic */ String $senderId;
    int label;

    public MessageDaoSource$searchMsgByFts$2(String r100, int r101, long r102, List<Integer> r103, String r104, List<String> r105, String r106, Continuation<? super MessageDaoSource$searchMsgByFts$2> r107) {
        this.$query = r100;
        this.$limit = r101;
        this.$cursor = r102;
        this.$availableContentType = r103;
        this.$conversationId = r104;
        this.$conversationIdList = r105;
        this.$senderId = r106;
        super(1, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r110) {
        return new MessageDaoSource$searchMsgByFts$2(this.$query, this.$limit, this.$cursor, this.$availableContentType, this.$conversationId, this.$conversationIdList, this.$senderId, r110);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends MessageEntity>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<MessageEntity>> r100) {
        return ((MessageDaoSource$searchMsgByFts$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r110);
        final String r100 = this.$query;
        final int r101 = this.$limit;
        final long r102 = this.$cursor;
        final List<Integer> r103 = this.$availableContentType;
        final String r104 = this.$conversationId;
        final List<String> r105 = this.$conversationIdList;
        final String r106 = this.$senderId;
        return OmniDatabaseExtKt.d("MessageDaoSource", new g2(r100, r101, r102, r103, r104, r105, r106));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
