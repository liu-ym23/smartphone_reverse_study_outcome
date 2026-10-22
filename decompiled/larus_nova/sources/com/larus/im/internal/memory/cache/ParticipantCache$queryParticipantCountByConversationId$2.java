package com.larus.im.internal.memory.cache;

import com.larus.im.internal.database.delegate.ParticipantDaoSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.memory.cache.ParticipantCache$queryParticipantCountByConversationId$2", f = "ParticipantCache.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class ParticipantCache$queryParticipantCountByConversationId$2 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ int $status;
    int label;
    final /* synthetic */ ParticipantCache this$0;

    public ParticipantCache$queryParticipantCountByConversationId$2(ParticipantCache r100, String r101, int r102, Continuation<? super ParticipantCache$queryParticipantCountByConversationId$2> r103) {
        this.this$0 = r100;
        this.$cvsId = r101;
        this.$status = r102;
        super(1, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ParticipantCache$queryParticipantCountByConversationId$2(this.this$0, this.$cvsId, this.$status, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Integer> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Integer> r100) {
        return ((ParticipantCache$queryParticipantCountByConversationId$2) create(r100)).invokeSuspend(Unit.INSTANCE);
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
        ParticipantDaoSource r103 = this.this$0.f348959j;
        String r104 = this.$cvsId;
        int r105 = this.$status;
        this.label = 1;
        r100 = r103.b(r104, r105, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
