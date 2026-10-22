package com.larus.platform.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.platform.service.AccountService", f = "AccountService.kt", i = {}, l = {116}, m = "queryUserInfoWhenCacheEmpty", n = {}, s = {})
public final class AccountService$queryUserInfoWhenCacheEmpty$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AccountService this$0;

    public AccountService$queryUserInfoWhenCacheEmpty$1(AccountService r100, Continuation<? super AccountService$queryUserInfoWhenCacheEmpty$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, this);
    }
}
