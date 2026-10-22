package com.larus.home.impl.main.side_bar.view.group.datasource.lark;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.main.side_bar.view.group.datasource.lark.OfficeSdkHumanFeedBadgeSource$attachToUserApi$1", f = "OfficeSdkHumanFeedBadgeSource.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
final class OfficeSdkHumanFeedBadgeSource$attachToUserApi$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ aza.d $service;
    int label;

    public OfficeSdkHumanFeedBadgeSource$attachToUserApi$1(aza.d r100, Continuation<? super OfficeSdkHumanFeedBadgeSource$attachToUserApi$1> r101) {
        this.$service = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new OfficeSdkHumanFeedBadgeSource$attachToUserApi$1(this.$service, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((OfficeSdkHumanFeedBadgeSource$attachToUserApi$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L14:
        if (Result.m9455isFailureimpl(r103) == false) goto L16;
        r103 = null;
    L16:
        pza.a r104 = (pza.a) r103;
        if (r104 == null) goto L22;
        o.d(r104);
        return Unit.INSTANCE;
    L22:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        aza.d r105 = this.$service;
        if (r105 == null) goto L22;
        this.label = 1;
        r103 = r105.ma(this);
        if (r103 != r101) goto L14;
        return r101;
    }
}
