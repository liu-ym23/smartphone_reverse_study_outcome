package com.larus.office.plugins.inputv2.coordinator.runtime.interaction;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.office.plugins.inputv2.coordinator.runtime.interaction.OfficeChatNavigationCoordinator$jumpToBoundOrMainConversation$1$mainConversationId$2", f = "OfficeChatNavigationCoordinator.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class OfficeChatNavigationCoordinator$jumpToBoundOrMainConversation$1$mainConversationId$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public OfficeChatNavigationCoordinator$jumpToBoundOrMainConversation$1$mainConversationId$2(Continuation<? super OfficeChatNavigationCoordinator$jumpToBoundOrMainConversation$1$mainConversationId$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeChatNavigationCoordinator$jumpToBoundOrMainConversation$1$mainConversationId$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((OfficeChatNavigationCoordinator$jumpToBoundOrMainConversation$1$mainConversationId$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        wc9.e r103 = (wc9.e) r100;
        if (r103 != null) goto L16;
        return null;
    L16:
        return r103.f559198a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IChatRepoService r104 = zh8.a.f572196a;
        IConversationRepoService r105 = zh8.a.f572197b;
        this.label = 1;
        r100 = r105.f(this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
