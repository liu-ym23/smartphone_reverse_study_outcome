package com.larus.home.impl.main.side_bar;

import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.MainSideBarFragment$findOrCreateEnterpriseNewConversation$4", f = "MainSideBarFragment.kt", i = {}, l = {460}, m = "invokeSuspend", n = {}, s = {})
final class MainSideBarFragment$findOrCreateEnterpriseNewConversation$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
    final /* synthetic */ String $expectedUserId;
    int label;

    public MainSideBarFragment$findOrCreateEnterpriseNewConversation$4(String r100, Continuation<? super MainSideBarFragment$findOrCreateEnterpriseNewConversation$4> r101) {
        this.$expectedUserId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MainSideBarFragment$findOrCreateEnterpriseNewConversation$4(this.$expectedUserId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super wc9.e> r101) {
        return ((MainSideBarFragment$findOrCreateEnterpriseNewConversation$4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        LocalSubConvHelper r103 = LocalSubConvHelper.f314106a;
        String r104 = this.$expectedUserId;
        this.label = 1;
        r100 = r103.c(r104, null, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
