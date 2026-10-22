package com.larus.dispatcher.askhuman.handler;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor$CompletionDelegate", f = "RequestActionBrowserOperationInterceptor.kt", i = {0, 1, 2}, l = {186, 187, 190}, m = BitableAnalytic.SelectSceneClickType.COMPLETE, n = {"request", "request", "success"}, s = {"L$0", "L$0", "Z$0"})
public final class RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RequestActionBrowserOperationInterceptor.CompletionDelegate this$0;

    public RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1(RequestActionBrowserOperationInterceptor.CompletionDelegate r100, Continuation<? super RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
