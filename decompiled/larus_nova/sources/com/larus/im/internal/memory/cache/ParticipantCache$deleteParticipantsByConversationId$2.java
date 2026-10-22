package com.larus.im.internal.memory.cache;

import com.larus.im.internal.database.delegate.ParticipantDaoSource;
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
@DebugMetadata(c = "com.larus.im.internal.memory.cache.ParticipantCache$deleteParticipantsByConversationId$2", f = "ParticipantCache.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class ParticipantCache$deleteParticipantsByConversationId$2 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    final /* synthetic */ String $cvsId;
    int label;
    final /* synthetic */ ParticipantCache this$0;

    /* JADX INFO: renamed from: com.larus.im.internal.memory.cache.ParticipantCache$deleteParticipantsByConversationId$2$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.memory.cache.ParticipantCache$deleteParticipantsByConversationId$2$2", f = "ParticipantCache.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $cvsId;
        int label;
        final /* synthetic */ ParticipantCache this$0;

        public AnonymousClass2(ParticipantCache r100, String r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$cvsId = r101;
            super(1, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass2(this.this$0, this.$cvsId, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Unit> r100) {
            return ((AnonymousClass2) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ParticipantDaoSource r103 = this.this$0.f348959j;
            String r104 = this.$cvsId;
            this.label = 1;
            if (r103.y(r104, this) != r101) goto L12;
            return r101;
        }
    }

    public ParticipantCache$deleteParticipantsByConversationId$2(ParticipantCache r100, String r101, Continuation<? super ParticipantCache$deleteParticipantsByConversationId$2> r102) {
        this.this$0 = r100;
        this.$cvsId = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new ParticipantCache$deleteParticipantsByConversationId$2(this.this$0, this.$cvsId, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Integer> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Integer> r100) {
        return ((ParticipantCache$deleteParticipantsByConversationId$2) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Boxing.boxInt(1);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ParticipantCache r103 = this.this$0;
        final String r104 = this.$cvsId;
        r103.R(new r0(r104));
        ParticipantCache r105 = this.this$0;
        AnonymousClass2 r106 = new AnonymousClass2(r105, this.$cvsId, null);
        this.label = 1;
        if (r105.U(r106, this) != r101) goto L12;
        return r101;
    }
}
