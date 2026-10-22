package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/internal/database/entity/MessageEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.MessageDaoSource$getMessageByIdOrLocalId$2", f = "MessageDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageDaoSource$getMessageByIdOrLocalId$2 extends SuspendLambda implements Function1<Continuation<? super MessageEntity>, Object> {
    final /* synthetic */ String $id;
    int label;

    public MessageDaoSource$getMessageByIdOrLocalId$2(String r100, Continuation<? super MessageDaoSource$getMessageByIdOrLocalId$2> r101) {
        this.$id = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageDaoSource$getMessageByIdOrLocalId$2(this.$id, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super MessageEntity> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super MessageEntity> r100) {
        return ((MessageDaoSource$getMessageByIdOrLocalId$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        final String r101 = this.$id;
        return OmniDatabaseExtKt.d("MessageDaoSource", new f1(r101));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
