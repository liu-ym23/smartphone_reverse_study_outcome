package com.larus.common.account.platform.larkauth.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.account.platform.larkauth.model.AuthorizationModel", f = "AuthorizationModel.kt", i = {}, l = {28}, m = "getDomainsAll", n = {}, s = {})
public final class AuthorizationModel$getDomainsAll$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AuthorizationModel this$0;

    public AuthorizationModel$getDomainsAll$1(AuthorizationModel r100, Continuation<? super AuthorizationModel$getDomainsAll$1> r101) {
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
