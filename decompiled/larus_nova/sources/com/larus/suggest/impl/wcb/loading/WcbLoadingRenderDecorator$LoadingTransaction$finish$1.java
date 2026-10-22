package com.larus.suggest.impl.wcb.loading;

import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.loading.WcbLoadingRenderDecorator$LoadingTransaction", f = "WcbLoadingRenderDecorator.kt", i = {}, l = {117, 109, 117, 113, 117, 117}, m = VideoEventOneOutSync.END_TYPE_FINISH, n = {}, s = {})
public final class WcbLoadingRenderDecorator$LoadingTransaction$finish$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbLoadingRenderDecorator.LoadingTransaction this$0;

    public WcbLoadingRenderDecorator$LoadingTransaction$finish$1(WcbLoadingRenderDecorator.LoadingTransaction r100, Continuation<? super WcbLoadingRenderDecorator$LoadingTransaction$finish$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
