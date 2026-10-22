package com.larus.im.internal.core.conversation.participant;

import ae9.h;
import be9.e;
import com.larus.im.internal.database.entity.ParticipantEntity;
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
@DebugMetadata(c = "com.larus.im.internal.core.conversation.participant.GetParticipantProcessor$process$1$ret$1", f = "GetParticipantProcessor.kt", i = {}, l = {22}, m = "invokeSuspend", n = {}, s = {})
public final class GetParticipantProcessor$process$1$ret$1 extends SuspendLambda implements Function1<Continuation<? super ParticipantEntity>, Object> {
    int label;
    final /* synthetic */ GetParticipantProcessor this$0;

    public GetParticipantProcessor$process$1$ret$1(GetParticipantProcessor r100, Continuation<? super GetParticipantProcessor$process$1$ret$1> r101) {
        this.this$0 = r100;
        super(1, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new GetParticipantProcessor$process$1$ret$1(this.this$0, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super ParticipantEntity> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super ParticipantEntity> r100) {
        return ((GetParticipantProcessor$process$1$ret$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        e r103 = h.a();
        GetParticipantProcessor r104 = this.this$0;
        String r105 = r104.f347633b;
        String r106 = r104.f347632a;
        this.label = 1;
        r100 = r103.B(r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
