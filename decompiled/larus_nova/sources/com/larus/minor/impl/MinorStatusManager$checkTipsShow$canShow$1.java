package com.larus.minor.impl;

import com.larus.bmhome.chat.tips.IGuideTipsService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.minor.impl.MinorStatusManager$checkTipsShow$canShow$1", f = "MinorStatusManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MinorStatusManager$checkTipsShow$canShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function0<Unit> $showDialogAction;
    int label;

    public MinorStatusManager$checkTipsShow$canShow$1(Function0<Unit> r100, Continuation<? super MinorStatusManager$checkTipsShow$canShow$1> r101) {
        this.$showDialogAction = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MinorStatusManager$checkTipsShow$canShow$1(this.$showDialogAction, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Boolean> r101) {
        return ((MinorStatusManager$checkTipsShow$canShow$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        IGuideTipsService r101 = (IGuideTipsService) ServiceManager.get().getService(IGuideTipsService.class);
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.g(new com.larus.bmhome.chat.tips.a(3, "", ""), this.$showDialogAction) != true) goto L9;
    L11:
        return Boxing.boxBoolean(r102);
    L9:
        r102 = false;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
