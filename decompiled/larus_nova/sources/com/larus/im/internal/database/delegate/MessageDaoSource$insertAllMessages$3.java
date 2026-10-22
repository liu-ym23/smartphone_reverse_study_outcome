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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.MessageDaoSource$insertAllMessages$3", f = "MessageDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageDaoSource$insertAllMessages$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MessageEntity> $messages;
    int label;

    public MessageDaoSource$insertAllMessages$3(List<MessageEntity> r100, Continuation<? super MessageDaoSource$insertAllMessages$3> r101) {
        this.$messages = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageDaoSource$insertAllMessages$3(this.$messages, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((MessageDaoSource$insertAllMessages$3) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        final List<MessageEntity> r101 = this.$messages;
        return OmniDatabaseExtKt.d("MessageDaoSource", new e2(r101));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
