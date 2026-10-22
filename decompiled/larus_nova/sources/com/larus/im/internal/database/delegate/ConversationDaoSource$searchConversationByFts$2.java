package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.entity.ConversationEntity;
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

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/internal/database/entity/ConversationEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.ConversationDaoSource$searchConversationByFts$2", f = "ConversationDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationDaoSource$searchConversationByFts$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends ConversationEntity>>, Object> {
    final /* synthetic */ List<String> $conversationIds;
    final /* synthetic */ long $cursor;
    final /* synthetic */ int $limit;
    final /* synthetic */ String $query;
    int label;

    public ConversationDaoSource$searchConversationByFts$2(String r100, int r101, long r102, List<String> r103, Continuation<? super ConversationDaoSource$searchConversationByFts$2> r104) {
        this.$query = r100;
        this.$limit = r101;
        this.$cursor = r102;
        this.$conversationIds = r103;
        super(1, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ConversationDaoSource$searchConversationByFts$2(this.$query, this.$limit, this.$cursor, this.$conversationIds, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends ConversationEntity>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<ConversationEntity>> r100) {
        return ((ConversationDaoSource$searchConversationByFts$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        List r101 = CollectionsKt.emptyList();
        final String r102 = this.$query;
        final int r103 = this.$limit;
        final long r104 = this.$cursor;
        final List<String> r105 = this.$conversationIds;
        return com.larus.im.internal.database.utils.n.a("ConversationDaoSource", r101, new d0(r102, r103, r104, r105));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
