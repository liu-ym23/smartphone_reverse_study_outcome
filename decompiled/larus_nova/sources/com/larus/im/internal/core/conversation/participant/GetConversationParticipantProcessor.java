package com.larus.im.internal.core.conversation.participant;

import ae9.h;
import be9.e;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IMError;
import com.larus.im.internal.core.IMActionProcessor;
import com.larus.im.internal.database.delegate.ParticipantDaoSource;
import com.larus.im.internal.database.entity.ConversationEntity;
import com.larus.im.internal.database.entity.ParticipantEntity;
import com.larus.im.internal.database.utils.OmniDatabaseExtKt;
import com.larus.im.internal.protocol.bean.GetConversationParticipantDownlinkBody;
import com.larus.im.internal.protocol.bean.GetConversationParticipantUplinkBody;
import com.larus.im.internal.protocol.bean.Participant;
import com.larus.im.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import wc9.k;

/* JADX INFO: loaded from: classes29.dex */
public final class GetConversationParticipantProcessor extends IMActionProcessor<GetConversationParticipantUplinkBody, k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f347630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f347631b;

    /* JADX INFO: renamed from: com.larus.im.internal.core.conversation.participant.GetConversationParticipantProcessor$process$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.im.internal.core.conversation.participant.GetConversationParticipantProcessor$process$1", f = "GetConversationParticipantProcessor.kt", i = {}, l = {38, 45, 48}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GetConversationParticipantProcessor this$0;

        public AnonymousClass1(GetConversationParticipantProcessor r100, Continuation<? super AnonymousClass1> r101) {
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
            if (r102 == 0) goto L12;
            if (r102 == 1) goto L11;
            if (r102 == 2) goto L10;
            if (r102 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r100);
        L36:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r100);
        L23:
            List r103 = (List) r100;
            if ((!r103.isEmpty()) == false) goto L30;
            GetConversationParticipantProcessor r104 = this.this$0;
            List r105 = r103;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator r107 = r105.iterator();
        L27:
            if (r107.hasNext() == false) goto L29;
            r106.add(com.larus.im.internal.core.conversation.converter.a.b((ParticipantEntity) r107.next()));
            goto L27
        L29:
            r104.onSuccess(new k(0, r106, 28));
            goto L36
        L30:
            GetConversationParticipantProcessor r108 = this.this$0;
            if (r108.f347630a == false) goto L36;
            this.label = 2;
            if (GetConversationParticipantProcessor.c(r108, this) != r101) goto L36;
            return r101;
        L12:
            ResultKt.throwOnFailure(r100);
            String r109 = this.this$0.getRequest().conversationId;
            Intrinsics.checkNotNull(r109);
            com.larus.im.internal.delegate.a.f348188b.i(this.this$0.f347631b, "get participant cvs id = " + this.this$0.getRequest().conversationId + " from local = " + this.this$0.f347630a);
            GetConversationParticipantProcessor r110 = this.this$0;
            if (r110.f347630a == true) goto L20;
            Lazy r111 = j.f350569a;
            if (j.f(r110.getRequest().conversationId) == true) goto L20;
            GetConversationParticipantProcessor r112 = this.this$0;
            this.label = 3;
            if (GetConversationParticipantProcessor.c(r112, this) != r101) goto L36;
            return r101;
        L20:
            e r113 = h.a();
            this.label = 1;
            r100 = ((ParticipantDaoSource) r113).c(r109, this);
            if (r100 != r101) goto L23;
            return r101;
        }
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final void process() {
        BuildersKt.launch$default(getScope(), null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.im.internal.core.IMActionProcessor
    public final String getTAG() {
        return this.f347631b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object c(GetConversationParticipantProcessor r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof GetConversationParticipantProcessor$getParticipantFromNetwork$1) == false) goto L7;
        GetConversationParticipantProcessor$getParticipantFromNetwork$1 r100 = (GetConversationParticipantProcessor$getParticipantFromNetwork$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        ResultKt.throwOnFailure(r112);
    L46:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L25:
        com.larus.im.internal.network.e r113 = (com.larus.im.internal.network.e) r112;
        if ((r113 instanceof com.larus.im.internal.network.e.f) == false) goto L44;
        List<Participant> r114 = ((GetConversationParticipantDownlinkBody) ((com.larus.im.internal.network.e.f) r113).f349185a).participantInfoList;
        com.larus.im.internal.delegate.a r106 = com.larus.im.internal.delegate.a.f348188b;
        String r107 = r110.f347631b;
        StringBuilder r108 = new StringBuilder("get participant success  size = ");
        if (r114 == null) goto L30;
        Integer r115 = Boxing.boxInt(r114.size());
    L31:
        r108.append(r115);
        r106.i(r107, r108.toString());
        List<Participant> r109 = r114;
        if (r109 != null) goto L34;
    L35:
        r104 = true;
    L37:
        if ((!r104) == true) goto L40;
        r114 = null;
    L40:
        if (r114 == null) goto L46;
        GetConversationParticipantProcessor$getParticipantFromNetwork$3$1 r116 = new GetConversationParticipantProcessor$getParticipantFromNetwork$3$1(r105, r114, r110, null);
        r100.L$0 = null;
        r100.label = 3;
        if (OmniDatabaseExtKt.e(r116, r100) != r102) goto L46;
        return r102;
    L34:
        if (r109.isEmpty() == false) goto L37;
    L30:
        r115 = null;
        goto L31
    L44:
        com.larus.im.internal.delegate.a.f348188b.i(r110.f347631b, "get participant failed error = " + r113.a().getCode() + " tips = " + r113.a().getTips());
        r110.onFailure(new IMError(r113.a().getCode(), r113.a().getTips(), r113.a().getException(), null, 8, null));
        goto L46
    L17:
        r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L22:
        GetConversationParticipantProcessor$getParticipantFromNetwork$ret$1 r117 = new GetConversationParticipantProcessor$getParticipantFromNetwork$ret$1(r110, (ConversationEntity) r112, null);
        r100.L$0 = r105;
        r100.label = 2;
        r112 = r110.requestServer(r117, r100);
        if (r112 != r102) goto L25;
        return r102;
    L18:
        ResultKt.throwOnFailure(r112);
        String r118 = r110.getRequest().conversationId;
        Intrinsics.checkNotNull(r118);
        be9.b r119 = ae9.b.a();
        r100.L$0 = r118;
        r100.label = 1;
        Object r120 = be9.b.C0295b.a(r119, r118, 0, r100, 6);
        if (r120 == r102) goto L47;
        r105 = r118;
        r112 = r120;
        goto L22
    L47:
        return r102;
    L7:
        r100 = new GetConversationParticipantProcessor$getParticipantFromNetwork$1(r110, r111);
        goto L8
    }

    public GetConversationParticipantProcessor(boolean r100, GetConversationParticipantUplinkBody r101, IIMCallback<k> r102) {
        Intrinsics.checkNotNullParameter(r101, "requestBody");
        super(r101, r102);
        this.f347630a = r100;
        this.f347631b = "GetParticipantListProcessor";
    }
}
