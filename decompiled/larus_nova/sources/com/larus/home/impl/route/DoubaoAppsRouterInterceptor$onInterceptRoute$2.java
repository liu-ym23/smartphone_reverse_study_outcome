package com.larus.home.impl.route;

import android.content.Context;
import com.bytedance.ai.api.AppletService;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.route.DoubaoAppsRouterInterceptor$onInterceptRoute$2", f = "DoubaoAppsRouterInterceptor.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, s = {})
public final class DoubaoAppsRouterInterceptor$onInterceptRoute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ AppletService $appletService;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $mode;
    final /* synthetic */ Ref.ObjectRef<String> $pageUrl;
    int label;
    final /* synthetic */ DoubaoAppsRouterInterceptor this$0;

    public DoubaoAppsRouterInterceptor$onInterceptRoute$2(AppletService r100, DoubaoAppsRouterInterceptor r101, Context r102, String r103, Ref.ObjectRef<String> r104, String r105, String r106, Continuation<? super DoubaoAppsRouterInterceptor$onInterceptRoute$2> r107) {
        this.$appletService = r100;
        this.this$0 = r101;
        this.$context = r102;
        this.$appId = r103;
        this.$pageUrl = r104;
        this.$mode = r105;
        this.$conversationId = r106;
        super(2, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new DoubaoAppsRouterInterceptor$onInterceptRoute$2(this.$appletService, this.this$0, this.$context, this.$appId, this.$pageUrl, this.$mode, this.$conversationId, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DoubaoAppsRouterInterceptor$onInterceptRoute$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L8;
        ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L15
    L13:
        DoubaoAppsRouterInterceptor r103 = this.this$0;     // Catch: Throwable -> L15
        Context r104 = this.$context;     // Catch: Throwable -> L15
        String r105 = this.$appId;     // Catch: Throwable -> L15
        String r106 = this.$pageUrl.element;     // Catch: Throwable -> L15
        String r107 = this.$mode;     // Catch: Throwable -> L15
        String r108 = this.$conversationId;     // Catch: Throwable -> L15
        CoroutineScope r109 = DoubaoAppsRouterInterceptor.f346048a;     // Catch: Throwable -> L15
        r103.getClass();     // Catch: Throwable -> L15
        DoubaoAppsRouterInterceptor.c(r104, r105, r106, r107, r108);     // Catch: Throwable -> L15
    L18:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
        FLogger.f375446a.i("DoubaoAppsRouterInterceptor", "onInterceptRoute: ensureInitialized");     // Catch: Throwable -> L15
        AppletService r110 = this.$appletService;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r110.j(this) != r101) goto L13;
        return r101;
    L15:
        th = move-exception;
        FLogger.f375446a.e("DoubaoAppsRouterInterceptor", "onInterceptRoute: ERROR, AppletService initialization failed", th);
        goto L18
    }
}
