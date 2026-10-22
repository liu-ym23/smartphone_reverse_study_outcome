package com.ss.android.lark.chameleon.container.webcontainer;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.ss.android.lark.chameleon.container.webcontainer.view.ChameleonWebView;
import com.ss.android.lark.chameleon.pluginsystem.WebServiceManager;
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
@DebugMetadata(c = "com.ss.android.lark.chameleon.container.webcontainer.ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1", f = "ChameleonWebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChameleonWebView $webView;
    int label;

    public ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1(ChameleonWebView r100, Continuation<? super ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1> r101) {
        this.$webView = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1(this.$webView, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChameleonWebViewManager$doCreateWebView$1$onWebViewDestroyed$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r100);
        ChameleonWebView r101 = this.$webView;
        ViewGroup r102 = null;
        if (r101 == null) goto L7;
        ViewParent r103 = r101.getParent();
    L9:
        if ((r103 instanceof ViewGroup) == false) goto L11;
        r102 = (ViewGroup) r103;
    L11:
        if (r102 == null) goto L13;
        r102.removeView(this.$webView);
    L13:
        ChameleonWebView r104 = this.$webView;
        if (r104 == null) goto L18;
        WebServiceManager r105 = r104.getWebServiceManager();
        if (r105 == null) goto L18;
        r105.onDestroy();
    L18:
        ChameleonWebView r106 = this.$webView;
        if (r106 == null) goto L21;
        r106.clearHistory();
    L21:
        ChameleonWebView r107 = this.$webView;
        if (r107 == null) goto L25;
        r107.destroy();
    L25:
        return Unit.INSTANCE;
    L7:
        r103 = null;
        goto L9
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
