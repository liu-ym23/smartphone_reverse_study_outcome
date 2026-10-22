package com.larus.extension.summary_card.impl.component;

import com.larus.extension.account_auth.api.FlowAccountAuthServiceDelegate;
import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.extension.summary_card.impl.component.SummaryCardComponentFeature$saveSummaryCardAsMessage$1", f = "SummaryCardComponentFeature.kt", i = {0, 1}, l = {98, 99, 101}, m = "invokeSuspend", n = {"offlineMessageContext", "offlineMessageContext"}, s = {"L$0", "L$0"})
public final class SummaryCardComponentFeature$saveSummaryCardAsMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ k99.b $offlineMessage;
    final /* synthetic */ long $session;
    Object L$0;
    int label;

    public SummaryCardComponentFeature$saveSummaryCardAsMessage$1(wc9.e r100, String r101, k99.b r102, long r103, Continuation<? super SummaryCardComponentFeature$saveSummaryCardAsMessage$1> r104) {
        this.$conversation = r100;
        this.$botId = r101;
        this.$offlineMessage = r102;
        this.$session = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SummaryCardComponentFeature$saveSummaryCardAsMessage$1(this.$conversation, this.$botId, this.$offlineMessage, this.$session, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SummaryCardComponentFeature$saveSummaryCardAsMessage$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        ResultKt.throwOnFailure(r110);
    L23:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        k99.c r102 = (k99.c) this.L$0;
        ResultKt.throwOnFailure(r110);
    L19:
        OfflineMessageServiceDelegate r103 = OfflineMessageServiceDelegate.f342907b;
        long r104 = this.$session;
        List<? extends k99.b> r105 = CollectionsKt.listOf(this.$offlineMessage);
        this.L$0 = null;
        this.label = 3;
        if (r103.g(r104, r102, r105, this) != r100) goto L23;
        return r100;
    L11:
        r102 = (k99.c) this.L$0;
        ResultKt.throwOnFailure(r110);
    L16:
        OfflineMessageServiceDelegate r111 = OfflineMessageServiceDelegate.f342907b;
        List r106 = CollectionsKt.listOf(this.$offlineMessage);
        FlowAccountAuthServiceDelegate.f342480b.b();
        this.L$0 = r102;
        this.label = 2;
        if (r111.b(r102, r106, this) != r100) goto L19;
        return r100;
    L12:
        ResultKt.throwOnFailure(r110);
        k99.c r112 = new k99.c(this.$conversation.f559198a, this.$botId);
        OfflineMessageServiceDelegate r107 = OfflineMessageServiceDelegate.f342907b;
        List<? extends k99.b> r108 = CollectionsKt.listOf(this.$offlineMessage);
        this.L$0 = r112;
        this.label = 1;
        if (r107.e(r112, r108, this) != r100) goto L15;
        return r100;
    L15:
        r102 = r112;
        goto L16
    }
}
