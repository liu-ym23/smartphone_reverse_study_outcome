package com.larus.im.internal.core.conversation.participant;

import com.larus.im.bean.conversation.ParticipantModel;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.database.entity.ParticipantEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
public final class GetParticipantProcessor extends IMActionProcessor<Unit, ParticipantModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f347632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f347634c;

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.participant.GetParticipantProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.participant.GetParticipantProcessor$process$1", f = "GetParticipantProcessor.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GetParticipantProcessor this$0;

        public AnonymousClass1(GetParticipantProcessor r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            ParticipantEntity r103 = (ParticipantEntity) r100;
            if (r103 != null) goto L14;
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347634c, "db has no participant id = " + this.this$0.f347633b);
            this.this$0.onFailure(new IMError(-1, "db has no participant", null, null, 12, null));
        L16:
            return Unit.INSTANCE;
        L14:
            this.this$0.onSuccess(com.larus.im.internal.core.conversation.converter.a.b(r103));
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            GetParticipantProcessor r104 = this.this$0;
            GetParticipantProcessor$process$1$ret$1 r105 = new GetParticipantProcessor$process$1$ret$1(r104, null);
            this.label = 1;
            r100 = r104.requestServer(r105, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347634c;
    }

    public GetParticipantProcessor(String r100, String r101, IIMCallback<ParticipantModel> r102) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        Intrinsics.checkNotNullParameter(r101, "participantId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        super(Unit.INSTANCE, r102);
        this.f347632a = r100;
        this.f347633b = r101;
        this.f347634c = "GetParticipantProcessor";
    }
}
