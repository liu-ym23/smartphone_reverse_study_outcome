package com.larus.common.account.platform.larkauth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.LarkAuthTokenFetcher", f = "LarkAuthTokenFetcher.kt", i = {}, l = {68}, m = "fetchBizAuthToken", n = {}, s = {})
public final class LarkAuthTokenFetcher$fetchBizAuthToken$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LarkAuthTokenFetcher this$0;

    public LarkAuthTokenFetcher$fetchBizAuthToken$1(LarkAuthTokenFetcher r100, Continuation<? super LarkAuthTokenFetcher$fetchBizAuthToken$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        LarkAuthTokenFetcher r101 = this.this$0;
        LarkAuthTokenFetcher r102 = LarkAuthTokenFetcher.f326121a;
        return r101.b(null, null, this);
    }
}
