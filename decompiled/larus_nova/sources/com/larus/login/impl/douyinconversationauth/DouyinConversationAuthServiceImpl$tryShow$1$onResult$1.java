package com.larus.login.impl.douyinconversationauth;

import androidx.fragment.app.FragmentActivity;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.login.impl.douyinconversationauth.DouyinConversationAuthServiceImpl$tryShow$1$onResult$1", f = "DouyinConversationAuthServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DouyinConversationAuthServiceImpl$tryShow$1$onResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FragmentActivity $currentHost;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ boolean $requestSuccess;
    final /* synthetic */ boolean $shouldShow;
    int label;
    final /* synthetic */ DouyinConversationAuthServiceImpl this$0;

    public DouyinConversationAuthServiceImpl$tryShow$1$onResult$1(DouyinConversationAuthServiceImpl r100, FragmentActivity r101, boolean r102, boolean r103, String r104, Continuation<? super DouyinConversationAuthServiceImpl$tryShow$1$onResult$1> r105) {
        this.this$0 = r100;
        this.$currentHost = r101;
        this.$requestSuccess = r102;
        this.$shouldShow = r103;
        this.$currentPage = r104;
        super(2, r105);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DouyinConversationAuthServiceImpl$tryShow$1$onResult$1(this.this$0, this.$currentHost, this.$requestSuccess, this.$shouldShow, this.$currentPage, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DouyinConversationAuthServiceImpl$tryShow$1$onResult$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        DouyinConversationAuthServiceImpl.c(this.this$0, this.$currentHost, this.$requestSuccess, this.$shouldShow, this.$currentPage);     // Catch: Throwable -> L8
        this.this$0.f357645a.set(false);
        return Unit.INSTANCE;
    L8:
        th = move-exception;
        this.this$0.f357645a.set(false);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
