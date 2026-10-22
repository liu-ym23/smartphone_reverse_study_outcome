package com.larus.im.internal.database.delegate;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.database.delegate.ParticipantDaoSource$queryParticipantCountByConversationId$2", f = "ParticipantDaoSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ParticipantDaoSource$queryParticipantCountByConversationId$2 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ int $status;
    int label;

    public ParticipantDaoSource$queryParticipantCountByConversationId$2(String r100, int r101, Continuation<? super ParticipantDaoSource$queryParticipantCountByConversationId$2> r102) {
        this.$cvsId = r100;
        this.$status = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ParticipantDaoSource$queryParticipantCountByConversationId$2(this.$cvsId, this.$status, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Integer> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Integer> r100) {
        return ((ParticipantDaoSource$queryParticipantCountByConversationId$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        int r101 = ParticipantDaoSource.f347926e;
        Integer r102 = Boxing.boxInt(0);
        final String r103 = this.$cvsId;
        final int r104 = this.$status;
        return com.larus.im.internal.database.utils.n.a("ParticipantDaoSource", r102, new k3(r103, r104));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
