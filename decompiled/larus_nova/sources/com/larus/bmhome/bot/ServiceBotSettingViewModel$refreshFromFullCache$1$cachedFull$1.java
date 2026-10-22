package com.larus.bmhome.bot;

import com.larus.bmhome.chat.model.repo.FullPermissionSettings;
import com.larus.bmhome.chat.model.repo.ServiceBotNoticeRepo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/model/repo/FullPermissionSettings;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.bot.ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1", f = "ServiceBotSettingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FullPermissionSettings>, Object> {
    final /* synthetic */ String $currentBotId;
    int label;

    public ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1(String r100, Continuation<? super ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1> r101) {
        this.$currentBotId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1(this.$currentBotId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super FullPermissionSettings> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super FullPermissionSettings> r101) {
        return ((ServiceBotSettingViewModel$refreshFromFullCache$1$cachedFull$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ServiceBotNoticeRepo r101 = ServiceBotNoticeRepo.f307747a;
        String r102 = this.$currentBotId;
        r101.getClass();
        return ServiceBotNoticeRepo.f(r102);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
