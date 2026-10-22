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

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/internal/database/entity/MessageEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.MessageDaoSource$getMessageLessThanTarCreateTime$2", f = "MessageDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageDaoSource$getMessageLessThanTarCreateTime$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends MessageEntity>>, Object> {
    final /* synthetic */ int $limit;
    final /* synthetic */ int $offset;
    final /* synthetic */ long $tarTime;
    int label;

    public MessageDaoSource$getMessageLessThanTarCreateTime$2(long r100, int r101, int r102, Continuation<? super MessageDaoSource$getMessageLessThanTarCreateTime$2> r103) {
        this.$tarTime = r100;
        this.$limit = r101;
        this.$offset = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageDaoSource$getMessageLessThanTarCreateTime$2(this.$tarTime, this.$limit, this.$offset, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends MessageEntity>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<MessageEntity>> r100) {
        return ((MessageDaoSource$getMessageLessThanTarCreateTime$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        final long r101 = this.$tarTime;
        final int r102 = this.$limit;
        final int r103 = this.$offset;
        return OmniDatabaseExtKt.d("MessageDaoSource", new l1(r101, r102, r103));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
