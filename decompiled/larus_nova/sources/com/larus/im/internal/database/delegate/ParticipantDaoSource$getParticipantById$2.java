package com.larus.im.internal.database.delegate;

import com.larus.im.internal.database.entity.ParticipantEntity;
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
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/internal/database/entity/ParticipantEntity;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.ParticipantDaoSource$getParticipantById$2", f = "ParticipantDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ParticipantDaoSource$getParticipantById$2 extends SuspendLambda implements Function1<Continuation<? super ParticipantEntity>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $participantId;
    int label;

    public ParticipantDaoSource$getParticipantById$2(String r100, String r101, Continuation<? super ParticipantDaoSource$getParticipantById$2> r102) {
        this.$participantId = r100;
        this.$conversationId = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ParticipantDaoSource$getParticipantById$2(this.$participantId, this.$conversationId, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super ParticipantEntity> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super ParticipantEntity> r100) {
        return ((ParticipantDaoSource$getParticipantById$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = ParticipantDaoSource.f347926e;
        final String r102 = this.$participantId;
        final String r103 = this.$conversationId;
        return OmniDatabaseExtKt.d("ParticipantDaoSource", new h3(r102, r103));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
