package com.bytedance.sdk.account.identitytoken;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0082@"}, d2 = {"", "needForceGetTag", "", "enterFrom", "triggerScene", "Lkotlin/Function1;", "Lcom/bytedance/sdk/account/identitytoken/d;", "", "onTokenResult", "Lkotlin/coroutines/Continuation;", "continuation", "", "requestIdentityToken"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "com.bytedance.sdk.account.identitytoken.IdentityTokenManager", f = "IdentityTokenManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {483}, m = "requestIdentityToken", n = {"this", "needForceGetTag", "enterFrom", "triggerScene", "onTokenResult", "abTestGroup"}, s = {"L$0", "Z$0", "L$1", "L$2", "L$3", "L$4"})
public final class IdentityTokenManager$requestIdentityToken$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IdentityTokenManager this$0;

    public IdentityTokenManager$requestIdentityToken$1(IdentityTokenManager r100, Continuation r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(false, null, null, null, this);
    }
}
