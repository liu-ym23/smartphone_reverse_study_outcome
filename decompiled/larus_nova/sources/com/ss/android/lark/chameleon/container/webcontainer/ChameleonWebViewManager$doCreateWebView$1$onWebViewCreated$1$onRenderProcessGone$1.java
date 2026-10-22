package com.ss.android.lark.chameleon.container.webcontainer;

import com.ss.android.lark.chameleon.container.webcontainer.preload.webviewpool.IWebViewPool;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager$doCreateWebView$1$onWebViewCreated$1$onRenderProcessGone$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonWebViewManager$doCreateWebView$1$onWebViewCreated$1$onRenderProcessGone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IWebViewPool $newWebViewPool;
    final /* synthetic */ ChameleonWebView $webView;
    int label;

    public ChameleonWebViewManager$doCreateWebView$1$onWebViewCreated$1$onRenderProcessGone$1(IWebViewPool r100, ChameleonWebView r101, Continuation<? super ChameleonWebViewManager$doCreateWebView$1$onWebViewCreated$1$onRenderProcessGone$1> r102) {
        this.$newWebViewPool = r100;
        this.$webView = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChameleonWebViewManager$doCreateWebView$1$onWebViewCreated$1$onRenderProcessGone$1(this.$newWebViewPool, this.$webView, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChameleonWebViewManager$doCreateWebView$1$onWebViewCreated$1$onRenderProcessGone$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        this.$newWebViewPool.destroyWebView(this.$webView);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
