package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.entity.MessageEntity;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/im/internal/database/entity/MessageEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.MessageDaoSource$getMessageListByQuestionId$2", f = "MessageDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageDaoSource$getMessageListByQuestionId$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends MessageEntity>>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ String $questionId;
    int label;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            Long r102 = ((MessageEntity) r100).getServerIndex();
            long r103 = Long.MAX_VALUE;
            if (r102 == null) goto L5;
            long r104 = r102.longValue();
        L6:
            Long r105 = Long.valueOf(r104);
            Long r106 = ((MessageEntity) r101).getServerIndex();
            if (r106 == null) goto L10;
            r103 = r106.longValue();
        L10:
            return ComparisonsKt.compareValues(r105, Long.valueOf(r103));
        L5:
            r104 = Long.MAX_VALUE;
            goto L6
        }
    }

    public MessageDaoSource$getMessageListByQuestionId$2(String r100, String r101, Continuation<? super MessageDaoSource$getMessageListByQuestionId$2> r102) {
        this.$questionId = r100;
        this.$cvsId = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new MessageDaoSource$getMessageListByQuestionId$2(this.$questionId, this.$cvsId, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super List<? extends MessageEntity>> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super List<MessageEntity>> r100) {
        return ((MessageDaoSource$getMessageListByQuestionId$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        List r101 = CollectionsKt.emptyList();
        final String r102 = this.$questionId;
        final String r103 = this.$cvsId;
        return com.larus.im.internal.database.utils.n.a("MessageDaoSource", r101, new q1(r102, r103));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
