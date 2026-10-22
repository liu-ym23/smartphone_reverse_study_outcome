package com.obric.assistant.settings.experience;

import com.obric.assistant.network.api.IObricNetworkService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1", f = "ObricUserExperiencePlanManager.kt", i = {}, l = {206}, m = "invokeSuspend", n = {}, s = {})
public final class ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $enabled;
    private /* synthetic */ Object L$0;
    int label;

    public ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1(boolean r100, Continuation<? super ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1> r101) {
        this.$enabled = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1 r102 = new ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1(this.$enabled, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        boolean r103 = true;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L24
    L19:
        if (((Boolean) r100).booleanValue() == true) goto L22;
    L21:
        r103 = false;
    L22:
        Object r104 = Result.m9449constructorimpl(Boxing.boxBoolean(r103));     // Catch: Throwable -> L24
    L26:
        Boolean r105 = Boxing.boxBoolean(false);
        if (Result.m9455isFailureimpl(r104) == true) goto L29;
        return r104;
    L29:
        return r105;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        CoroutineScope r106 = (CoroutineScope) this.L$0;
        boolean r107 = this.$enabled;
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L24
        IObricNetworkService r109 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: Throwable -> L24
        if (r109 == null) goto L21;
        if (r107 == false) goto L14;
        boolean r110 = true;
    L15:
        this.label = 1;     // Catch: Throwable -> L24
        r100 = r109.r(r110, this);     // Catch: Throwable -> L24
        if (r100 != r101) goto L19;
        return r101;
    L14:
        r110 = false;
    L24:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }
}
