package com.obric.miniapp.utils;

import android.content.Context;
import com.bytedance.router.SmartRouter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.utils.MiniAppUtils$routeToApplet$2", f = "MiniAppUtils.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppUtils$routeToApplet$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $pageData;
    final /* synthetic */ String $url;
    int label;

    public MiniAppUtils$routeToApplet$2(Context r100, String r101, String r102, Continuation<? super MiniAppUtils$routeToApplet$2> r103) {
        this.$context = r100;
        this.$url = r101;
        this.$pageData = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new MiniAppUtils$routeToApplet$2(this.$context, this.$url, this.$pageData, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MiniAppUtils$routeToApplet$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        com.bytedance.router.i r103 = SmartRouter.buildRoute(this.$context, this.$url);
        String r104 = this.$pageData;
        if (r104 == null) goto L14;
        r103.j("pageData", r104);
    L14:
        r103.d();
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.label = 1;
        if (DelayKt.delay(200, this) != r101) goto L11;
        return r101;
    }
}
